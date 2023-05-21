package com.etiya.crmlite.repositories.cam;

import com.etiya.crmlite.entities.concretes.cam.CustAcct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerAccountRepository extends JpaRepository<CustAcct, Long> {
}
