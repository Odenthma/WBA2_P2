package de.odenthma.geocache.client;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class CreateCachePanel extends JPanel{
	public static String MENU = "Menu";
	public static String SCACHE = "Show Caches";
	public static String NUSER = "Create User";
	public static String NEWS = "Feeds anzeigen";
	public static String CCACHE = "Create Cache";
	CardLayout cl;
	JPanel mainPanel;
	JFrame frame;
	public void setTitle(){
		frame.setTitle(CCACHE);
	}
	public CreateCachePanel(CardLayout cl, JPanel mainPanel, JFrame frame) {
		this.cl = cl;
		this.mainPanel = mainPanel;
		this.frame = frame;
			
	}

}
