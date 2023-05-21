package com.etiya.crmlite.services.concretes.cam;

import com.etiya.crmlite.entities.concretes.cam.PartyRole;
import com.etiya.crmlite.repositories.cam.IPartyRoleRepository;
import com.etiya.crmlite.services.abstracts.cam.IPartyRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyRoleManager implements IPartyRoleService {
    private IPartyRoleRepository partyRoleRepository;
    @Autowired
    public PartyRoleManager(IPartyRoleRepository partyRoleRepository) {
        this.partyRoleRepository = partyRoleRepository;
    }
    @Override
    public PartyRole getByPartyRoleId(Long partyRoleId) {
        return partyRoleRepository.findByPartyRoleId(partyRoleId);
    }
}
