package com.quadcore.chat.repo;

import com.quadcore.chat.model.UserInfo;

public interface UserInfoRepository {
	
	//void addUser(UserInfo userInfo);// *reserved for ADMIN role
	//void changeUsername(UserInfo userInfo, String username); *cannot be done? || *reserved for ADMIN
	void changePassword(UserInfo userInfo, String password);
	void changeEmail(UserInfo userInfo, String email);
	//void deleteUser(UserInfo userInfo); *reserved for ADMIN role
}
