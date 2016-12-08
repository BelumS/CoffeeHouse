package com.quadcore.chat.repository;

import org.springframework.data.repository.CrudRepository;

import com.quadcore.chat.model.UserRole;

public interface RoleRepository extends CrudRepository<UserRole, Long> {

}
