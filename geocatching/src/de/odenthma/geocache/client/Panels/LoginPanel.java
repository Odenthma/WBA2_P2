package de.odenthma.geocache.client.Panels;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class LoginPanel extends JPanel{
	ActionListener listener;
	
	public LoginPanel(ActionListener listener){
		this.listener = listener;
	}

}
