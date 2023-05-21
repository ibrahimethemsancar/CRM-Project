package com.etiya.crmlite.repositories.cam;

import com.etiya.crmlite.entities.concretes.cam.PartyRoleTp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPartyRoleTypeRepository extends JpaRepository<PartyRoleTp, Long> {
    PartyRoleTp findByPartyRoleTpId(Long partyRoleTpId);
}
