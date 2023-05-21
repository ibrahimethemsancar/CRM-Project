package com.etiya.crmlite.services.concretes.cam;

import com.etiya.crmlite.core.utilities.generalCodes.StatusCodes;
import com.etiya.crmlite.core.utilities.generalCodes.TypeCodes;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.messages.MessageSourceManager;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.entities.concretes.cam.*;
import com.etiya.crmlite.repositories.cam.IIndividualRepository;
import com.etiya.crmlite.services.abstracts.cam.IAddressService;
import com.etiya.crmlite.services.abstracts.cam.IContactMediumService;
import com.etiya.crmlite.services.requests.addresses.SubCreateAddressRequest;
import com.etiya.crmlite.services.requests.contactMediums.SubCreateContactMediumRequest;
import com.etiya.crmlite.services.requests.individuals.CreateIndividualRequest;
import com.etiya.crmlite.services.responses.addresses.SubCreateAddressResponse;
import com.etiya.crmlite.services.responses.contactMediums.SubCreateContactMediumResponse;
import com.etiya.crmlite.services.responses.individuals.CreateIndividualResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IndividualManagerTest {

    IndividualManager individualManager;
    IAddressService addressService;
    IContactMediumService contactMediumService;
    IIndividualRepository individualRepository;
    IMessageSourceService messageSourceService;

    @BeforeEach
    void setUp() {
        individualRepository = mock(IIndividualRepository.class);
        messageSourceService = new MessageSourceManager(getResourceBundle());
        addressService = mock(IAddressService.class);
        contactMediumService = mock(IContactMediumService.class);
        individualManager = new IndividualManager(individualRepository, addressService, contactMediumService, messageSourceService);

    }

    ResourceBundleMessageSource getResourceBundle() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        return source;
    }

    @Test
    void add() {
        when(individualRepository.existsByNatId(any())).thenReturn(false);
        SubCreateAddressRequest subCreateAddressRequest = new SubCreateAddressRequest("istanbul", "esenler", "yıldız", "ev", "Türkiye");
        SubCreateContactMediumRequest subCreateContactMediumRequest = new SubCreateContactMediumRequest("2122222", "123456", "5555555555", "asd@gmail.com");
        CreateIndividualRequest createIndividualRequest = new CreateIndividualRequest(
                "furkan", "emre", "cakir", LocalDate.of(2000, 01, 01), 1,
                "asd", "asd", 12345678910L, subCreateAddressRequest, subCreateContactMediumRequest);
        Ind indToAdd = Ind.builder().frstName("furkan").mName("emre").lstName("cakir").brthDate(LocalDate.of(2000, 01, 01))
                .gendrId(1).mthrName("asd").fthrName("asd").natId(12345678910L).build();

        CustTp customerType = CustTp.builder()
                .custTpId(TypeCodes.CUST_TYPE)
                .build();

        Cust customer = Cust.builder()
                .custTp(customerType)
                .stId(StatusCodes.CUST_ACTV)
                .build();

        PartyRoleTp partyRoleTp = PartyRoleTp.builder()
                .partyRoleTpId(TypeCodes.PARTY_ROLE_TYPE_CUST)
                .build();

        PartyRole partyRole = PartyRole.builder()
                .cust(customer)
                .partyRoleTp(partyRoleTp)
                .stId(StatusCodes.PARTY_ROLE_ACTV)
                .build();

        Party party = Party.builder()
                .ind(indToAdd)
                .partyTpId(TypeCodes.CAM_PARTY_TYPE_INDV)
                .stId(StatusCodes.PARTY_ACTV)
                .partyRoles(List.of(partyRole))
                .build();

        indToAdd.setParty(party);

        DataResult<SubCreateAddressResponse> subCreateAddressResponse = new DataResult<>
                (new SubCreateAddressResponse("istanbul", "esenler", "yıldız", "ev", "Türkiye"), true);
        DataResult<SubCreateContactMediumResponse> subCreateContactMediumResponse = new DataResult<>
                (new SubCreateContactMediumResponse("2122222", "123456", "5555555555", "asd@gmail.com"), true);


        when(individualRepository.save(any())).thenReturn(indToAdd);
        when(addressService.addAddressForCustomer(subCreateAddressRequest, indToAdd.getParty())).thenReturn(subCreateAddressResponse);
        when(contactMediumService.addContactMediumInformation(subCreateContactMediumRequest, indToAdd.getParty())).thenReturn(subCreateContactMediumResponse);

        DataResult<CreateIndividualResponse> response = individualManager.add(createIndividualRequest);

        assert response.getData().getNationalId().equals(indToAdd.getNatId());
    }

    @Test
    void getAll() {

        PageRequest pageRequest = PageRequest.of(0, 10);

        Ind ind = Ind.builder().frstName("furkan").mName("emre").lstName("cakir").brthDate(LocalDate.of(2000, 01, 01))
                .gendrId(1).mthrName("asd").fthrName("asd").natId(12345678910L).build();

        List<Ind> individualsToReturn = Arrays.asList(ind);

        //Page<List<GetAllIndividualResponse>> indPage = new PageImpl<>(individualsToReturn, pageRequest, individualsToReturn.size());

        //given(individualRepository.getAll(any())).willReturn(indPage);
    }
}