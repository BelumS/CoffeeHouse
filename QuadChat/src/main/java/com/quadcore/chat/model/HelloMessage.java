package com.quadcore.chat.model;

//Model the message carrying the name
public class HelloMessage {
	
	private String name;
	
	public HelloMessage(){}
	
	public HelloMessage(String name){ this.name = name; }
	
	public String getName(){ return name; }
	
	public void setName(String name){ this.name = name; }
}
