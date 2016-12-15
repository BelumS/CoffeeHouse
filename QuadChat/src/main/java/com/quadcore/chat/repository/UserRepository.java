package com.quadcore.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quadcore.chat.model.User;

/**
 * Controls the database CRUD operations for the "Users" table
 * <p>
 * @author Quadcore
 * @since 12/6/16
 * @version 2.0
 * @category Repository
 * @see JpaRepository
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
	User findByEmail(String email);
}
