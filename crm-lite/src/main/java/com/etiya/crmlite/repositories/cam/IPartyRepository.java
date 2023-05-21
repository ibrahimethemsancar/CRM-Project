package com.etiya.crmlite.repositories.cam;

import com.etiya.crmlite.entities.concretes.cam.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPartyRepository extends JpaRepository<Party, Long> {
    Party findByPartyId(Long partyId);
}
