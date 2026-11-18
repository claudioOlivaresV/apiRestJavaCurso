package com.cursoapi.gestion.eventos.api.data;

import com.cursoapi.gestion.eventos.api.domain.Role;
import com.cursoapi.gestion.eventos.api.repository.RoleRepository;
import com.cursoapi.gestion.eventos.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Aquí puedes cargar datos iniciales en la base de datos si es necesario

        Role adminRole = roleRepository.findByName("ROLE_ADMIN").orElseGet(() -> {
            Role role = new Role();
            role.setName("ROLE_ADMIN");
            return roleRepository.save(role);
        });


    }
}
