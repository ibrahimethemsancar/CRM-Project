package com.etiya.crmlite.repositories.cam;

import com.etiya.crmlite.entities.concretes.cam.CustAcctProdInvl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerAccountProductInvolvementRepository extends JpaRepository<CustAcctProdInvl, Long> {
}
