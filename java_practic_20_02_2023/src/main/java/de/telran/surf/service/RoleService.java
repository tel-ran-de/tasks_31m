package de.telran.surf.service;

import de.telran.surf.entity.Role;
import de.telran.surf.repository.RoleRepository;
import de.telran.surf.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

}
