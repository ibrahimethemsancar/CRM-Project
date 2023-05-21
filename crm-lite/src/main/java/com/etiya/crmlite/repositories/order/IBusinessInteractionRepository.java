package com.etiya.crmlite.repositories.order;

import com.etiya.crmlite.entities.concretes.order.BsnInter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBusinessInteractionRepository extends JpaRepository<BsnInter, Long> {
}
