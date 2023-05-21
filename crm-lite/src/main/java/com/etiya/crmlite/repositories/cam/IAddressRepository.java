package com.etiya.crmlite.repositories.cam;

import com.etiya.crmlite.entities.concretes.cam.Addr;
import com.etiya.crmlite.services.responses.addresses.GetAllAddressResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAddressRepository extends JpaRepository<Addr, Long> {

    @Query(value = "SELECT a.ROW_ID, a.CITY_NAME, a.STRT_NAME, a.BLDG_NAME, a.ADDR_DESC, a.CNTRY_NAME FROM ADDR a " +
            "INNER JOIN PARTY p ON a.ROW_ID = p.PARTY_ID WHERE a.DATA_TP_ID = :dataTpId", nativeQuery = true)
    Page<List<GetAllAddressResponse>> getAll(Pageable pageable, @Param("dataTpId") Long dataTpId);
    //TODO: SQL SORGU Düzeltilecek
}
