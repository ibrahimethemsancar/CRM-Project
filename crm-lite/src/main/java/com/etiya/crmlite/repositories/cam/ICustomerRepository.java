package com.etiya.crmlite.repositories.cam;

import com.etiya.crmlite.entities.concretes.cam.Cust;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Cust, Long> {

}
