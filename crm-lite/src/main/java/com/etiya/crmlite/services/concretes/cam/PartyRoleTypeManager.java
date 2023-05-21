package com.etiya.crmlite.services.concretes.cam;


import com.etiya.crmlite.entities.concretes.cam.PartyRoleTp;
import com.etiya.crmlite.repositories.cam.IPartyRoleTypeRepository;
import com.etiya.crmlite.services.abstracts.cam.IPartyRoleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyRoleTypeManager implements IPartyRoleTypeService {
    private IPartyRoleTypeRepository partyRoleTypeRepository;
    @Autowired
    public PartyRoleTypeManager(IPartyRoleTypeRepository partyRoleTypeRepository) {
        this.partyRoleTypeRepository = partyRoleTypeRepository;
    }

    @Override
    public PartyRoleTp getByPartyRoleTpId(Long partyRoleTpId) {
        return partyRoleTypeRepository.findByPartyRoleTpId(partyRoleTpId);
    }
}
