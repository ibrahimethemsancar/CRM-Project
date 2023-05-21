package com.etiya.crmlite.services.abstracts.cam;

import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.entities.concretes.cam.Party;
import com.etiya.crmlite.services.requests.addresses.DeleteAddressRequest;
import com.etiya.crmlite.services.requests.addresses.SubCreateAddressRequest;
import com.etiya.crmlite.services.requests.addresses.UpdateAddressRequest;
import com.etiya.crmlite.services.responses.addresses.SubCreateAddressResponse;
import com.etiya.crmlite.services.responses.addresses.UpdateAddressResponse;

public interface IAddressService {
    DataResult<SubCreateAddressResponse> addAddressForCustomer(SubCreateAddressRequest subCreateAddressRequest, Party party);
    DataResult<UpdateAddressResponse> updateAddress(UpdateAddressRequest updateAddressRequest);
    Result deleteAddress(DeleteAddressRequest deleteAddressRequest);

}
