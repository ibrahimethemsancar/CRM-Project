package com.etiya.crmlite.repositories.cam;


import com.etiya.crmlite.entities.concretes.cam.CustTp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustTp, Long> {
    CustTp findByCustTpId(Long custTpId);
}
