package com.quadcore.chat.dto;

import java.util.Date;

import com.quadcore.chat.dto.Message;

/**
 * Models an outgoing chatroom Message
 * <p>
 *@author Quadcore
 *@since 12/13/16
 *@version 1.0
 *@category Data Transfer Object
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
