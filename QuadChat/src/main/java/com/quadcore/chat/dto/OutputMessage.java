package com.quadcore.chat.dto;

import java.util.Date;

import com.quadcore.chat.dto.Message;

/**
 *@author Quadcore
 *@version 1.0
 *@category Models an outgoing chatroom Message
 *@see com.quadcore.chat.dto.Message
 */
public class OutputMessage extends Message {
	
	private Date time;
	
	public OutputMessage(Message original, Date time)
	{
		super(original.getId(), original.getMessage());
		this.time = time;
	}
	
	public Date getTime()
	{
		return time;
	}
	public void setTime(Date time)
	{
		this.time = time;
	}

}
