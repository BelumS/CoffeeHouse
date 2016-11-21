package com.quadcore.chat.dao;

import com.quadcore.chat.model.UserInfo;

public interface UserInfoDAO {
	
	boolean authenticate(String username, String password); //login authentication functionality
	//void addUser(UserInfo userInfo);// *reserved for ADMIN role
	//void changeUsername(UserInfo userInfo, String username); *cannot be done? || *reserved for ADMIN
	void changePassword(UserInfo userInfo, String password);
	void changeEmail(UserInfo userInfo, String email);
	//void deleteUser(UserInfo userInfo); *reserved for ADMIN role
}
