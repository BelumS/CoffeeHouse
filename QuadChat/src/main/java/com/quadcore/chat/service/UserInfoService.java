package com.quadcore.chat.service;

import com.quadcore.chat.model.UserInfo;

public interface UserInfoService {
	
	//void addUser(UserInfo userInfo); *reserved for ADMIN role
	//void changeUsername(UserInfo userInfo, String username); *cannot be done? || *reserved for ADMIN
	void changePassword(UserInfo userInfo, String password);
	void changeEmail(UserInfo userInfo, String email);
	//void deleteUser(UserInfo userInfo); *reserved for ADMIN role
}
