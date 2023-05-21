package com.etiya.crmlite.services.abstracts.cam;

import com.etiya.crmlite.entities.concretes.cam.PartyRole;

public interface IPartyRoleService {
    PartyRole getByPartyRoleId(Long partyRoleId);
}
