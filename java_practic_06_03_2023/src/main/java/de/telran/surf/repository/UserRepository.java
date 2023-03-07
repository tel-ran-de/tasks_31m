package de.telran.surf.repository;

import de.telran.surf.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    User findByLogin(String login);

}
