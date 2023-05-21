package com.etiya.crmlite.services.concretes.cam;

import com.etiya.crmlite.core.utilities.constants.Messages;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.core.utilities.results.SuccessResult;
import com.etiya.crmlite.entities.concretes.cam.Cust;
import com.etiya.crmlite.entities.concretes.cam.CustTp;
import com.etiya.crmlite.entities.concretes.cam.PartyRole;
import com.etiya.crmlite.repositories.cam.ICustomerRepository;
import com.etiya.crmlite.services.abstracts.cam.ICustomerService;
import com.etiya.crmlite.services.abstracts.cam.ICustomerTypeService;
import com.etiya.crmlite.services.abstracts.cam.IPartyRoleService;
import com.etiya.crmlite.services.requests.customers.CreateCustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements ICustomerService {
    private ICustomerRepository customerRepository;
    private IPartyRoleService partyRoleService;
    private ICustomerTypeService customerTypeService;
    private IMessageSourceService messageSourceService;

    @Autowired
    public CustomerManager(ICustomerRepository customerRepository, IPartyRoleService partyRoleService, ICustomerTypeService customerTypeService, IMessageSourceService messageSourceService) {
        this.customerRepository = customerRepository;
        this.partyRoleService = partyRoleService;
        this.customerTypeService = customerTypeService;
        this.messageSourceService = messageSourceService;
    }

    @Override
    public Result add(CreateCustomerRequest createCustomerRequest) {
        CustTp customerType = customerTypeService.getByCustTpId(createCustomerRequest.getCustomerTypeId());
        PartyRole partyRole = partyRoleService.getByPartyRoleId(createCustomerRequest.getPartyRoleId());
        Cust customer = new Cust().builder()
                .stId(createCustomerRequest.getStatusId())
                .custTp(customerType)
                .partyRole(partyRole)
                .build();
        customerRepository.save(customer);
        return new SuccessResult(messageSourceService.getMessage(Messages.Customer.customerAdded));
    }
}
