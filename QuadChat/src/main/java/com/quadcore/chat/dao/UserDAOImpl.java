/**
 * 
 */
package com.quadcore.chat.dao;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.quadcore.chat.model.User;

/**
 * @author BelumEx
 *
 */
@Service
public class UserDAOImpl implements UserDAO {

	/* (non-Javadoc)
	 * @see com.quadcore.chat.dao.UserDAO#authenticate(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean authenticate(String username, String password) 
	{
		//Provide a sample password check
		return Objects.equals(username, password);
	}

	/* (non-Javadoc)
	 * @see com.quadcore.chat.dao.UserDAO#changePassword(com.quadcore.chat.model.User, java.lang.String)
	 */
	@Override
	public void changePassword(User user, String password) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.quadcore.chat.dao.UserDAO#changeEmail(com.quadcore.chat.model.User, java.lang.String)
	 */
	@Override
	public void changeEmail(User user, String email) {
		// TODO Auto-generated method stub

	}

}
