package de.odenthma.geocache.client;

import de.odenthma.geocache.generatedclasses.userinformation.UserType;



public class Globals {
	private UserType activeUser;
	private String server;
	
	public UserType getActiveUser(){
		return activeUser;
	}
	public void setActiveUser(UserType activeUser){
		this.activeUser = activeUser;
	}
	
	public String getServer(){
		return server;
	}
	public void setServer(String server){
		this.server = server;
	}
	
}
