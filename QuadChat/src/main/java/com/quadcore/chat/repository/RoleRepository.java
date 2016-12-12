package com.quadcore.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quadcore.chat.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRoleName(String roleName);
}
