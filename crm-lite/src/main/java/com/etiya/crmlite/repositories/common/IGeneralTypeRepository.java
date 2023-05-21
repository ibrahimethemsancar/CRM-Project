package com.etiya.crmlite.repositories.common;

import com.etiya.crmlite.entities.concretes.common.GnlTp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGeneralTypeRepository extends JpaRepository<GnlTp, Long> {
}
