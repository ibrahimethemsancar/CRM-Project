package com.etiya.crmlite.services.concretes.cam;

import com.etiya.crmlite.core.utilities.constants.Messages;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.generalCodes.StatusCodes;
import com.etiya.crmlite.core.utilities.generalCodes.TypeCodes;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.cam.*;
import com.etiya.crmlite.repositories.cam.IIndividualRepository;
import com.etiya.crmlite.services.abstracts.cam.IAddressService;
import com.etiya.crmlite.services.abstracts.cam.IContactMediumService;
import com.etiya.crmlite.services.abstracts.cam.IIndividualService;
import com.etiya.crmlite.services.requests.individuals.CreateIndividualRequest;
import com.etiya.crmlite.services.requests.individuals.UpdateIndividualRequest;
import com.etiya.crmlite.services.responses.individuals.CreateIndividualResponse;
import com.etiya.crmlite.services.responses.individuals.GetAllIndividualResponse;
import com.etiya.crmlite.services.responses.individuals.UpdateIndividualResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class IndividualManager implements IIndividualService {
    private IIndividualRepository individualRepository;
    private IAddressService addressService;
    private IContactMediumService contactMediumService;
    private IMessageSourceService messageSourceService;

    @Autowired
    public IndividualManager(IIndividualRepository individualRepository, IAddressService addressService,
                             IContactMediumService contactMediumService, IMessageSourceService messageSourceService) {
        this.individualRepository = individualRepository;
        this.addressService = addressService;
        this.contactMediumService = contactMediumService;
        this.messageSourceService = messageSourceService;
    }

    @Transactional
    @Override
    public DataResult<CreateIndividualResponse> add(CreateIndividualRequest createIndividualRequest) {

        checkIfIndividualExists(createIndividualRequest.getNationalId());

        Ind savedIndividual = createIndividual(createIndividualRequest);

        CustTp customerType = custTpBuilder();
        Cust customer = customerBuilder(customerType);

        PartyRoleTp partyRoleTp = partyRoleTpBuilder();
        PartyRole partyRole = partyRoleBuilder(customer, partyRoleTp);
        customer.setPartyRole(partyRole);

        Party party = partyBuilder(savedIndividual, partyRole);
        partyRole.setParty(party);
        savedIndividual.setParty(party);

        individualRepository.save(savedIndividual);

        addressService.addAddressForCustomer(createIndividualRequest.getSubCreateAddressRequest(), party);
        contactMediumService.addContactMediumInformation(createIndividualRequest.getSubCreateContactMediumRequest(), party);

        CreateIndividualResponse response = createIndividualResponseBuilder(savedIndividual);

        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.Individual.individualAdded));
    }

    @Override
    public DataResult<UpdateIndividualResponse> updateIndividual(UpdateIndividualRequest updateIndividualRequest) {

        Ind individual = getIndividual(updateIndividualRequest.getIndividualId());

        updateIndividual(updateIndividualRequest, individual);

        Ind updatedIndividual = individualRepository.save(individual);

        UpdateIndividualResponse response = updateIndividualResponseBuilder(updatedIndividual);

        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.Individual.individualUpdated));
    }

    private void updateIndividual(UpdateIndividualRequest updateIndividualRequest, Ind individual) {
        individual.setFrstName(updateIndividualRequest.getFirstName());
        individual.setMName(updateIndividualRequest.getMiddleName());
        individual.setLstName(updateIndividualRequest.getLastName());
        individual.setBrthDate(updateIndividualRequest.getBirthDate());
        individual.setGendrId(updateIndividualRequest.getGenderId());
        individual.setMthrName(updateIndividualRequest.getMotherName());
        individual.setFthrName(updateIndividualRequest.getFatherName());
        individual.setNatId(updateIndividualRequest.getNationalId());
    }

    private Ind getIndividual(Long indId) {
        return individualRepository.findById(indId)
                .orElseThrow(() -> new BusinessException(messageSourceService.getMessage(Messages.Individual.individualNotFound)));
    }

    private UpdateIndividualResponse updateIndividualResponseBuilder(Ind updatedIndividual) {
        return UpdateIndividualResponse.builder()
                .individualId(updatedIndividual.getIndId())
                .firstName(updatedIndividual.getFrstName())
                .middleName(updatedIndividual.getMName())
                .lastName(updatedIndividual.getLstName())
                .birthDate(updatedIndividual.getBrthDate())
                .genderId(updatedIndividual.getGendrId())
                .motherName(updatedIndividual.getMthrName())
                .fatherName(updatedIndividual.getFthrName())
                .nationalId(updatedIndividual.getNatId())
                .build();
    }

    @Override
    public DataResult<Page<List<GetAllIndividualResponse>>> getAll(Pageable pageable) {
        return new SuccessDataResult<>(individualRepository.getAll(pageable), messageSourceService.getMessage(Messages.Individual.individualsListed));
    }

    private CreateIndividualResponse createIndividualResponseBuilder(Ind savedIndividual) {
        CreateIndividualResponse response = CreateIndividualResponse.builder()
                .individualId(savedIndividual.getIndId())
                .firstName(savedIndividual.getFrstName())
                .middleName(savedIndividual.getMName())
                .lastName(savedIndividual.getLstName())
                .birthDate(savedIndividual.getBrthDate())
                .genderId(savedIndividual.getGendrId())
                .motherName(savedIndividual.getMthrName())
                .fatherName(savedIndividual.getFthrName())
                .nationalId(savedIndividual.getNatId())
                .build();
        return response;
    }

    private Party partyBuilder(Ind savedIndividual, PartyRole partyRole) {
        Party party = Party.builder()
                .ind(savedIndividual)
                .partyTpId(TypeCodes.CAM_PARTY_TYPE_INDV)
                .stId(StatusCodes.PARTY_ACTV)
                .partyRoles(List.of(partyRole))
                .build();
        return party;
    }

    private PartyRole partyRoleBuilder(Cust customer, PartyRoleTp partyRoleTp) {
        PartyRole partyRole = PartyRole.builder()
                .cust(customer)
                .partyRoleTp(partyRoleTp)
                .stId(StatusCodes.PARTY_ROLE_ACTV)
                .build();
        return partyRole;
    }

    private PartyRoleTp partyRoleTpBuilder() {
        PartyRoleTp partyRoleTp = PartyRoleTp.builder()
                .partyRoleTpId(TypeCodes.PARTY_ROLE_TYPE_CUST)
                .build();
        return partyRoleTp;
    }

    private Cust customerBuilder(CustTp customerType) {
        Cust customer = Cust.builder()
                .custTp(customerType)
                .stId(StatusCodes.CUST_ACTV)
                .build();
        return customer;
    }

    private CustTp custTpBuilder() {
        CustTp customerType = CustTp.builder()
                .custTpId(TypeCodes.CUST_TYPE)
                .build();
        return customerType;
    }

    private Ind createIndividual(CreateIndividualRequest createIndividualRequest) {
        Ind individual = Ind.builder()
                .frstName(createIndividualRequest.getFirstName())
                .mName(createIndividualRequest.getMiddleName())
                .lstName(createIndividualRequest.getLastName())
                .brthDate(createIndividualRequest.getBirthDate())
                .gendrId(createIndividualRequest.getGenderId())
                .mthrName(createIndividualRequest.getMotherName())
                .fthrName(createIndividualRequest.getFatherName())
                .natId(createIndividualRequest.getNationalId())
                .stId(StatusCodes.IND_ACTV)
                .build();
        return individual;
    }

    private void checkIfIndividualExists(Long natId) {
        boolean individualCustomer = individualRepository.existsByNatId(natId);
        if (individualCustomer)
            throw new BusinessException(messageSourceService.getMessage(Messages.Individual.individualExists));
    }

}
