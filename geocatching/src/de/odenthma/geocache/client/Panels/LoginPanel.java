package de.odenthma.geocache.client.Panels;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.xml.bind.JAXBException;

import de.odenthma.geocache.CacheClasses.CacheType;
import de.odenthma.geocache.UserInformation.Classes.UserType;
import de.odenthma.geocache.client.MarshallUnmarshall;
import de.odenthma.geocache.client.PathHandler;

public class LoginPanel extends JPanel{
	ActionListener listener;
	
	public LoginPanel(ActionListener listener) throws FileNotFoundException, JAXBException{
		this.listener = listener;
		ArrayList<UserType> users = new ArrayList<UserType>();
		users = getUser();
		System.out.println("User: "+users.get(1).getAccount().getLogInName());
	}
	public ArrayList<UserType> getUser() throws FileNotFoundException, JAXBException{
		return new MarshallUnmarshall().getUser(new PathHandler().getPath("/UserListNew.xml"));
	}
}
