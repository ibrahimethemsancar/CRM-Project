package com.etiya.crmlite.repositories.common;

import com.etiya.crmlite.entities.concretes.common.SrvcSpec;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceSpecificationRepository extends JpaRepository<SrvcSpec, Long> {
}
