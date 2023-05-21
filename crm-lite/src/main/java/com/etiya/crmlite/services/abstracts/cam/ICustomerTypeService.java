package com.etiya.crmlite.services.abstracts.cam;

import com.etiya.crmlite.entities.concretes.cam.CustTp;

public interface ICustomerTypeService {
    CustTp getByCustTpId(Long custTpId);
}
