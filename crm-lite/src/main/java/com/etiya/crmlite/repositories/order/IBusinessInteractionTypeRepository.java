package com.etiya.crmlite.repositories.order;

import com.etiya.crmlite.entities.concretes.order.BsnInterTp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBusinessInteractionTypeRepository extends JpaRepository<BsnInterTp, Long> {
}
