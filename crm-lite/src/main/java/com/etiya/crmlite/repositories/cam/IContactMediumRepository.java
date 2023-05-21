package com.etiya.crmlite.repositories.cam;


import com.etiya.crmlite.entities.concretes.cam.CntcMedium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContactMediumRepository extends JpaRepository<CntcMedium, Long> {
    @Query(value = "Select * from CNTC_MEDIUM where ROW_ID =:rowId And CNTC_MEDIUM_TP_ID =:cntcMediumTpId", nativeQuery = true)
    CntcMedium findByRowIdAndCntcMediumTpId(Long rowId, Long cntcMediumTpId);
}
