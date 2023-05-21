package com.etiya.crmlite.repositories.order;

import com.etiya.crmlite.entities.concretes.order.BsnInterSpec;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBusinessInteractionSpecificationRepository extends JpaRepository<BsnInterSpec, Long> {
}
