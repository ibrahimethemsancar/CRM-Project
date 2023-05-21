package com.etiya.crmlite.services.concretes.cam;

import com.etiya.crmlite.entities.concretes.cam.CustTp;
import com.etiya.crmlite.repositories.cam.ICustomerTypeRepository;
import com.etiya.crmlite.services.abstracts.cam.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerTypeManager implements ICustomerTypeService {
    private ICustomerTypeRepository customerTypeRepository;

    @Autowired
    public CustomerTypeManager(ICustomerTypeRepository customerTypeRepository) {
        this.customerTypeRepository = customerTypeRepository;
    }
    @Override
    public CustTp getByCustTpId(Long custTpId) {
        return customerTypeRepository.findByCustTpId(custTpId);
    }
}
