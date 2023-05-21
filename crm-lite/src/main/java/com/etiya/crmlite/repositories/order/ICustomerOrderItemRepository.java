package com.etiya.crmlite.repositories.order;

import com.etiya.crmlite.entities.concretes.order.CustOrdItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerOrderItemRepository extends JpaRepository<CustOrdItem, Long> {
}
