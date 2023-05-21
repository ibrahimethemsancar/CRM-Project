package com.etiya.crmlite.services.abstracts.cam;

import com.etiya.crmlite.entities.concretes.cam.Party;

public interface IPartyService {
    Party getByPartyId(Long partyId);
}
