package com.etiya.crmlite.services.abstracts.cam;

import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.services.requests.individuals.CreateIndividualRequest;
import com.etiya.crmlite.services.requests.individuals.UpdateIndividualRequest;
import com.etiya.crmlite.services.responses.individuals.CreateIndividualResponse;
import com.etiya.crmlite.services.responses.individuals.GetAllIndividualResponse;
import com.etiya.crmlite.services.responses.individuals.UpdateIndividualResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IIndividualService {
    DataResult<CreateIndividualResponse> add(CreateIndividualRequest createIndividualRequest);
    DataResult<UpdateIndividualResponse> updateIndividual(UpdateIndividualRequest updateIndividualRequest);
    DataResult<Page<List<GetAllIndividualResponse>>> getAll(Pageable pageable);
}
