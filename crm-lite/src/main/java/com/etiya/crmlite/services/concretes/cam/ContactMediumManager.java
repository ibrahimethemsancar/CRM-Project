package com.etiya.crmlite.services.concretes.cam;

import com.etiya.crmlite.core.utilities.constants.Messages;
import com.etiya.crmlite.core.utilities.generalCodes.StatusCodes;
import com.etiya.crmlite.core.utilities.generalCodes.TypeCodes;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.cam.CntcMedium;
import com.etiya.crmlite.entities.concretes.cam.Party;
import com.etiya.crmlite.repositories.cam.IContactMediumRepository;
import com.etiya.crmlite.services.abstracts.cam.IContactMediumService;
import com.etiya.crmlite.services.requests.contactMediums.SubCreateContactMediumRequest;
import com.etiya.crmlite.services.requests.contactMediums.UpdateContactMediumRequest;
import com.etiya.crmlite.services.responses.contactMediums.SubCreateContactMediumResponse;
import com.etiya.crmlite.services.responses.contactMediums.UpdateContactMediumResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactMediumManager implements IContactMediumService {
    private IContactMediumRepository contactMediumRepository;
    private IMessageSourceService messageSourceService;

    @Autowired
    public ContactMediumManager(IContactMediumRepository contactMediumRepository, IMessageSourceService messageSourceService) {
        this.contactMediumRepository = contactMediumRepository;
        this.messageSourceService = messageSourceService;
    }

    @Transactional
    @Override
    public DataResult<SubCreateContactMediumResponse> addContactMediumInformation(SubCreateContactMediumRequest subCreateContactMediumRequest,
                                                                                  Party party) {
        CntcMedium pstn = pstnBuilder(subCreateContactMediumRequest, party);
        CntcMedium fax = faxBuilder(subCreateContactMediumRequest, party);
        CntcMedium gsmNumber = gsmNumberBuilder(subCreateContactMediumRequest, party);
        CntcMedium email = emailBuilder(subCreateContactMediumRequest, party);

        List<CntcMedium> contactMediumList = new ArrayList<>();
        contactMediumList.add(pstn);
        contactMediumList.add(fax);
        contactMediumList.add(gsmNumber);
        contactMediumList.add(email);

        contactMediumRepository.saveAll(contactMediumList);
        SubCreateContactMediumResponse response = subCreateContactMediumResponseBuilder(pstn, fax, gsmNumber, email);

        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.ContactMedium.contactInfoAdded));
    }

    @Override
    public DataResult<UpdateContactMediumResponse> updateContactMediumInformation(UpdateContactMediumRequest updateContactMediumRequest) {
        CntcMedium updatedPstn = getByRowIdAndContactMediumTpId(updateContactMediumRequest, TypeCodes.CNTC_MEDIUM_PSTN);
        updatedPstn.setCntcData(updateContactMediumRequest.getPstn());

        CntcMedium updatedFax = getByRowIdAndContactMediumTpId(updateContactMediumRequest, TypeCodes.CNTC_MEDIUM_FAX);
        updatedFax.setCntcData(updateContactMediumRequest.getFax());

        CntcMedium updatedGsmNumber = getByRowIdAndContactMediumTpId(updateContactMediumRequest, TypeCodes.CNTC_MEDIUM_GSM);
        updatedGsmNumber.setCntcData(updateContactMediumRequest.getGsmNumber());

        CntcMedium updatedEmail = getByRowIdAndContactMediumTpId(updateContactMediumRequest, TypeCodes.CNTC_MEDIUM_EML);
        updatedEmail.setCntcData(updateContactMediumRequest.getEmail());

        List<CntcMedium> updatedContactMediumList = new ArrayList<>();
        updatedContactMediumList.add(updatedPstn);
        updatedContactMediumList.add(updatedFax);
        updatedContactMediumList.add(updatedGsmNumber);
        updatedContactMediumList.add(updatedEmail);

        contactMediumRepository.saveAll(updatedContactMediumList);

        UpdateContactMediumResponse response = updateContactMediumResponseBuilder(updateContactMediumRequest, updatedPstn, updatedFax, updatedGsmNumber, updatedEmail);
        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.ContactMedium.contactInfoUpdated));

    }

    private UpdateContactMediumResponse updateContactMediumResponseBuilder(UpdateContactMediumRequest updateContactMediumRequest,
                                                                           CntcMedium updatedPstn, CntcMedium updatedFax,
                                                                           CntcMedium updatedGsmNumber, CntcMedium updatedEmail) {
        return UpdateContactMediumResponse.builder()
                .partyId(updateContactMediumRequest.getPartyId())
                .pstn(updatedPstn.getCntcData())
                .fax(updatedFax.getCntcData())
                .gsmNumber(updatedGsmNumber.getCntcData())
                .email(updatedEmail.getCntcData())
                .build();
    }

    private CntcMedium getByRowIdAndContactMediumTpId(UpdateContactMediumRequest updateContactMediumRequest, Long contactMediumType) {
        return contactMediumRepository.findByRowIdAndCntcMediumTpId(updateContactMediumRequest.getPartyId(),
                contactMediumType);
    }

    private SubCreateContactMediumResponse subCreateContactMediumResponseBuilder(CntcMedium pstn, CntcMedium fax,
                                                                                 CntcMedium gsmNumber, CntcMedium email) {
        SubCreateContactMediumResponse response = SubCreateContactMediumResponse.builder()
                .pstn(pstn.getCntcData())
                .fax(fax.getCntcData())
                .gsmNumber(gsmNumber.getCntcData())
                .email(email.getCntcData())
                .build();
        return response;
    }

    private CntcMedium pstnBuilder(SubCreateContactMediumRequest subCreateContactMediumRequest, Party party) {
        CntcMedium pstn = CntcMedium.builder()
                .cntcMediumTpId(TypeCodes.CNTC_MEDIUM_PSTN)
                .cntcData(subCreateContactMediumRequest.getPstn())
                .rowId(party.getPartyId())
                .dataTpId(TypeCodes.ETIYA_TYPE_VALUE_PARTY)
                .stId(StatusCodes.CNTC_MEDIUM_ACTV)
                .build();
        return pstn;
    }

    private CntcMedium faxBuilder(SubCreateContactMediumRequest subCreateContactMediumRequest, Party party) {
        CntcMedium fax = CntcMedium.builder()
                .cntcMediumTpId(TypeCodes.CNTC_MEDIUM_FAX)
                .cntcData(subCreateContactMediumRequest.getFax())
                .rowId(party.getPartyId())
                .dataTpId(TypeCodes.ETIYA_TYPE_VALUE_PARTY)
                .stId(StatusCodes.CNTC_MEDIUM_ACTV)
                .build();
        return fax;
    }

    private CntcMedium gsmNumberBuilder(SubCreateContactMediumRequest subCreateContactMediumRequest, Party party) {
        CntcMedium gsmNumber = CntcMedium.builder()
                .cntcMediumTpId(TypeCodes.CNTC_MEDIUM_GSM)
                .cntcData(subCreateContactMediumRequest.getGsmNumber())
                .rowId(party.getPartyId())
                .dataTpId(TypeCodes.ETIYA_TYPE_VALUE_PARTY)
                .stId(StatusCodes.CNTC_MEDIUM_ACTV)
                .build();
        return gsmNumber;
    }

    private CntcMedium emailBuilder(SubCreateContactMediumRequest subCreateContactMediumRequest, Party party) {
        CntcMedium email = CntcMedium.builder()
                .cntcMediumTpId(TypeCodes.CNTC_MEDIUM_EML)
                .cntcData(subCreateContactMediumRequest.getEmail())
                .rowId(party.getPartyId())
                .dataTpId(TypeCodes.ETIYA_TYPE_VALUE_PARTY)
                .stId(StatusCodes.CNTC_MEDIUM_ACTV)
                .build();
        return email;
    }
}
