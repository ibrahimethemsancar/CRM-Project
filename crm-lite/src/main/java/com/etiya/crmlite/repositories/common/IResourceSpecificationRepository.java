package com.etiya.crmlite.repositories.common;

import com.etiya.crmlite.entities.concretes.common.RsrcSpec;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResourceSpecificationRepository extends JpaRepository<RsrcSpec, Long> {
}
