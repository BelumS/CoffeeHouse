package com.quadcore.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.quadcore.chat.model.UserRole;
import com.quadcore.chat.model.UserRoleId;

/**
 * Controls the database CRUD operations for the "User_Roles" table
 * <p>
 * @author Quadcore
 * @since 12/6/16
 * @version 2.0
 * @category Repository
 * @see JpaRepository
 *
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId>{

}
