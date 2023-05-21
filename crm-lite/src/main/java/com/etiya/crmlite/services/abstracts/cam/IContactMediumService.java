package com.etiya.crmlite.services.abstracts.cam;

import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.entities.concretes.cam.Party;
import com.etiya.crmlite.services.requests.contactMediums.SubCreateContactMediumRequest;
import com.etiya.crmlite.services.requests.contactMediums.UpdateContactMediumRequest;
import com.etiya.crmlite.services.responses.contactMediums.SubCreateContactMediumResponse;
import com.etiya.crmlite.services.responses.contactMediums.UpdateContactMediumResponse;

public interface IContactMediumService {
    DataResult<SubCreateContactMediumResponse> addContactMediumInformation(SubCreateContactMediumRequest subCreateContactMediumRequest, Party party);
    DataResult<UpdateContactMediumResponse> updateContactMediumInformation(UpdateContactMediumRequest updateContactMediumRequest);
}
