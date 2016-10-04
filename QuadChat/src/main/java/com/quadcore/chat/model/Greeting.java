package com.quadcore.chat.model;

//Model the greeting representation w/ a POJO
public class Greeting {
	
	private String content;
	
	public Greeting(){}
	
	public Greeting(String content){ this.content = content; }
	
	public String getContent() { return content; }
}
