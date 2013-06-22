package de.odenthma.geocache.client;

import de.odenthma.geocache.generatedclasses.userinformation.UserType;
import de.odenthma.geocache.xmppstuff.PubSub;



public class Globals{
	public static PubSub test;
	private UserType activeUser;
	private String server;
	private PubSub ps;
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
	public PubSub getPubSub(){
		return ps;
	}
	public void setPubSub(PubSub ps){
		this.ps = ps;
	}
	
}
