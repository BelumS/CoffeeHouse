package com.quadcore.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.quadcore.chat.model.UserRole;
import com.quadcore.chat.model.UserRoleId;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId>{

}
