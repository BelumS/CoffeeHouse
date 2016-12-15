package com.quadcore.chat.dto;

import com.quadcore.chat.model.User;

/**
 * Models an incoming chatroom Message
 * <p>
 *@author Quadcore
 *@since 12/13/16
 *@version 1.0
 *@category Data Transfer Object
 *@see com.quadcore.chat.dto.OutputMessage
 */
public class Message {
	
	//Private Fields
	private User user;
	private int id;
	private String message;
	
	public Message(){}
	
	//Public fields
	public Message(int id, String message)
	{
		this.id = id;
		this.message = message;
	}
	
	public Message(User user, int id, String message)
	{
		this.user = user;
		this.id = id;
		this.message = message;
	}
	
	//Getters and Setters
	public User getUser()
	{
		return user;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
