package com.etiya.crmlite.repositories.cam;


import com.etiya.crmlite.entities.concretes.cam.PartyRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPartyRoleRepository extends JpaRepository<PartyRole, Long> {
    PartyRole findByPartyRoleId(Long partyRoleId);
}
