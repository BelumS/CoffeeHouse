/**
 * 
 */
package com.quadcore.chat.dao;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.quadcore.chat.model.UserInfo;

/**
 * @author BelumEx
 *
 */
@Service
public class UserInfoDAOImpl implements UserInfoDAO {

	/* (non-Javadoc)
	 * @see com.quadcore.chat.dao.UserInfoDAO#authenticate(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean authenticate(String username, String password) 
	{
		//Provide a sample password check
		return Objects.equals(username, password);
	}

	/* (non-Javadoc)
	 * @see com.quadcore.chat.dao.UserInfoDAO#changePassword(com.quadcore.chat.model.UserInfo, java.lang.String)
	 */
	@Override
	public void changePassword(UserInfo userInfo, String password) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.quadcore.chat.dao.UserInfoDAO#changeEmail(com.quadcore.chat.model.UserInfo, java.lang.String)
	 */
	@Override
	public void changeEmail(UserInfo userInfo, String email) {
		// TODO Auto-generated method stub

	}

}
