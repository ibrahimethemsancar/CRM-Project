package com.etiya.crmlite.api.controllers.cam;

import com.etiya.crmlite.core.utilities.constants.Paths;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.services.abstracts.cam.IIndividualService;
import com.etiya.crmlite.services.requests.individuals.CreateIndividualRequest;
import com.etiya.crmlite.services.requests.individuals.UpdateIndividualRequest;
import com.etiya.crmlite.services.responses.individuals.CreateIndividualResponse;
import com.etiya.crmlite.services.responses.individuals.GetAllIndividualResponse;
import com.etiya.crmlite.services.responses.individuals.UpdateIndividualResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "individuals")
public class IndividualsController {
    private IIndividualService individualService;

    @Autowired
    public IndividualsController(IIndividualService individualService) {
        this.individualService = individualService;
    }

    @GetMapping
    public ResponseEntity<DataResult<Page<List<GetAllIndividualResponse>>>> getAll(@RequestParam int page, @RequestParam int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return new ResponseEntity<>(individualService.getAll(pageable), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<DataResult<CreateIndividualResponse>> add(@RequestBody @Valid CreateIndividualRequest createIndividualRequest) {
        return new ResponseEntity<>(individualService.add(createIndividualRequest), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<DataResult<UpdateIndividualResponse>> add(@RequestBody @Valid UpdateIndividualRequest updateIndividualRequest) {
        return new ResponseEntity<>(individualService.updateIndividual(updateIndividualRequest), HttpStatus.OK);
    }
}
