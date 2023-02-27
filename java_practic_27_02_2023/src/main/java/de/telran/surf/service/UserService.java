package de.telran.surf.service;

import de.telran.surf.entity.Role;
import de.telran.surf.entity.User;
import de.telran.surf.repository.RoleRepository;
import de.telran.surf.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(User user) {
        Role role = roleRepository.findByName("ROLE_USER");
        if (role == null) {
            role = roleRepository.save(new Role("ROLE_USER"));
        }
        user.setRoles(List.of(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        System.out.println("admin: " + passwordEncoder.encode("admin"));
//        System.out.println("user: " + passwordEncoder.encode("user"));

        User user = userRepository.findByLogin(username);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    username,
                    user.getPassword(),
                    user.getRoles().stream()
                            .map(role -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList()));
        }
        throw new UsernameNotFoundException("Invalid login or password");
    }
}
