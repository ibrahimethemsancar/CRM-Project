package com.etiya.crmlite.repositories.cam;

import com.etiya.crmlite.entities.concretes.cam.Ind;
import com.etiya.crmlite.services.responses.individuals.GetAllIndividualResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IIndividualRepository extends JpaRepository<Ind, Long> {
    boolean existsByNatId(Long natId);

    @Query("select new com.etiya.crmlite.services.responses.individuals.GetAllIndividualResponse (p.partyId, i.frstName," +
            "i.mName, i.lstName, prt.name, i.natId) from Ind " +
            "i inner join i.party p inner join p.partyRoles pr inner join pr.partyRoleTp prt" )
    Page<List<GetAllIndividualResponse>> getAll(Pageable pageable);
}
