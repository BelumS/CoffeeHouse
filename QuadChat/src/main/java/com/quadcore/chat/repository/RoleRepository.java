package com.quadcore.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quadcore.chat.model.Role;

/**
 * Controls the database CRUD operations for the "Roles" table
 * <p>
 * @author Quadcore
 * @since 12/6/16
 * @version 2.0
 * @category Repository
 * @see JpaRepository
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRoleName(String roleName);
}
