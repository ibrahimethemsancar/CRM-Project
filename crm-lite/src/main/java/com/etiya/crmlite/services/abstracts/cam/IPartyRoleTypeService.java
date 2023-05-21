package com.etiya.crmlite.services.abstracts.cam;

import com.etiya.crmlite.entities.concretes.cam.PartyRoleTp;

public interface IPartyRoleTypeService {
    PartyRoleTp getByPartyRoleTpId(Long partyRoleTpId);
}
