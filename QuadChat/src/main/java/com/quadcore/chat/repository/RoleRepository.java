package com.quadcore.chat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quadcore.chat.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
