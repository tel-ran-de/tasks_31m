package de.telran.surf.repository;

import de.telran.surf.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, String> {

    Role findByName(String name);

}
