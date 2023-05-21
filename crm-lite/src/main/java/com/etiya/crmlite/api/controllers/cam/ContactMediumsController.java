package com.etiya.crmlite.api.controllers.cam;

import com.etiya.crmlite.core.utilities.constants.Paths;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.services.abstracts.cam.IContactMediumService;
import com.etiya.crmlite.services.requests.contactMediums.UpdateContactMediumRequest;
import com.etiya.crmlite.services.responses.contactMediums.UpdateContactMediumResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(Paths.apiPrefix + "contact-mediums")
public class ContactMediumsController {
    private IContactMediumService contactMediumService;

    @Autowired
    public ContactMediumsController(IContactMediumService contactMediumService) {
        this.contactMediumService = contactMediumService;
    }

    @PutMapping("/update")
    public ResponseEntity<DataResult<UpdateContactMediumResponse>> updateContactMediumInformation
            (@RequestBody @Valid UpdateContactMediumRequest updateContactMediumRequest) {
        return new ResponseEntity<>(contactMediumService.updateContactMediumInformation(updateContactMediumRequest), HttpStatus.OK);
    }
}
