package com.cursoapi.gestion.eventos.api.repository;

import com.cursoapi.gestion.eventos.api.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
