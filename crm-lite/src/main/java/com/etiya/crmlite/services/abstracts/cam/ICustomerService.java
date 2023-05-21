package com.etiya.crmlite.services.abstracts.cam;

import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.services.requests.customers.CreateCustomerRequest;

public interface ICustomerService {
   Result add(CreateCustomerRequest createCustomerRequest);
}
