package com.quadcore.chat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.quadcore.chat.model.UserRole;
import com.quadcore.chat.model.UserRoleId;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, UserRoleId>{

}
