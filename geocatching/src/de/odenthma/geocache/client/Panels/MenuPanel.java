package de.odenthma.geocache.client.Panels;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import de.odenthma.geocache.client.Globals;


@SuppressWarnings("serial")
public class MenuPanel extends JPanel {
	public static String MENU = "Menu";
	public static String SCACHE = "Show Caches";
	public static String NUSER = "Create User";
	public static String NEWS = "Feeds anzeigen";
	public static String CCACHE = "Create Cache";
	
	JButton btnShowCache = new JButton(SCACHE);
	JButton btnNewUser = new JButton(NUSER);
	JButton btnNews = new JButton(NEWS);
	JButton btnCreateCache = new JButton(CCACHE);
	

	ActionListener listener;

	public MenuPanel(ActionListener listener){
		this.listener = listener;
		initMenu();
		Globals gl = new Globals();
		
	}
	
	public void initMenu(){
		btnShowCache.setName(SCACHE);
		btnNewUser.setName(NUSER);
		btnNews.setName(NEWS);
		btnCreateCache.setName(CCACHE);
		
		btnShowCache.addActionListener(listener);	
		btnNewUser.addActionListener(listener);
		btnNews.addActionListener(listener);
		btnCreateCache.addActionListener(listener);
		
		this.add(btnShowCache);
		this.add(btnNewUser);
		this.add(btnNews);
		this.add(btnCreateCache);
	}

}
