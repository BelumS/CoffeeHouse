package com.quadcore.chat.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quadcore.chat.model.Role;

@Repository
@Transactional
public interface RoleRepository extends CrudRepository<Role, Long> {

}
