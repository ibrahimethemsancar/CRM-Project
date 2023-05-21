package com.etiya.crmlite.services.concretes.cam;

import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.entities.concretes.cam.Party;
import com.etiya.crmlite.repositories.cam.IPartyRepository;
import com.etiya.crmlite.services.abstracts.cam.IPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyManager implements IPartyService {
    private IPartyRepository partyRepository;

    @Autowired
    public PartyManager(IPartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    @Override
    public Party getByPartyId(Long partyId) {
        return partyRepository.findByPartyId(partyId);
    }

}
