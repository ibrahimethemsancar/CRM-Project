package com.etiya.crmlite.repositories.common;

import com.etiya.crmlite.entities.concretes.common.GnlSt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGeneralStatusRepository extends JpaRepository<GnlSt, Long> {
}
