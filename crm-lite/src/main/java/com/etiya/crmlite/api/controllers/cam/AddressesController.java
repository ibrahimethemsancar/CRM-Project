package com.etiya.crmlite.api.controllers.cam;

import com.etiya.crmlite.core.utilities.constants.Paths;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.services.abstracts.cam.IAddressService;
import com.etiya.crmlite.services.requests.addresses.DeleteAddressRequest;
import com.etiya.crmlite.services.requests.addresses.UpdateAddressRequest;
import com.etiya.crmlite.services.responses.addresses.UpdateAddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(Paths.apiPrefix + "addresses")
public class AddressesController {

    private IAddressService addressService;

    @Autowired
    public AddressesController(IAddressService addressService) {
        this.addressService = addressService;
    }

    @PutMapping("/update")
    public ResponseEntity<DataResult<UpdateAddressResponse>> updateAddress(@RequestBody @Valid
                                                                           UpdateAddressRequest updateAddressRequest) {
        return new ResponseEntity<>(addressService.updateAddress(updateAddressRequest), HttpStatus.OK);
    }

    @PutMapping("/delete")
    public ResponseEntity<Result> deleteAddress(@RequestBody @Valid
                                                 DeleteAddressRequest deleteAddressRequest) {
        return new ResponseEntity<>(addressService.deleteAddress(deleteAddressRequest), HttpStatus.NO_CONTENT);
    }
}
