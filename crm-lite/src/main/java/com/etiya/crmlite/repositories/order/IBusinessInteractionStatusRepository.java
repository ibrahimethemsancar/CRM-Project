package com.etiya.crmlite.repositories.order;

import com.etiya.crmlite.entities.concretes.order.BsnInterSt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBusinessInteractionStatusRepository extends JpaRepository<BsnInterSt, Long> {
}
