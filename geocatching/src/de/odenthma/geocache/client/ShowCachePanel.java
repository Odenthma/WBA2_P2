package de.odenthma.geocache.client;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class ShowCachePanel extends JPanel{
	public static String MENU = "Menu";
	public static String SCACHE = "Show Caches";
	public static String NUSER = "Create User";
	public static String NEWS = "Feeds anzeigen";
	public static String CCACHE = "Create Cache";
	
	JButton btnMenu = new JButton(MENU);
	ActionListener listener;

	public ShowCachePanel(ActionListener listener){
		this.listener = listener;
		btnMenu.setName(MENU);
		btnMenu.addActionListener(listener);
		this.add(btnMenu);
	}

}
