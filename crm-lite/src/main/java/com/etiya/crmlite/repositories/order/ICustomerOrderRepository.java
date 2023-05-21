package com.etiya.crmlite.repositories.order;

import com.etiya.crmlite.entities.concretes.order.CustOrd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerOrderRepository extends JpaRepository<CustOrd, Long> {
}
