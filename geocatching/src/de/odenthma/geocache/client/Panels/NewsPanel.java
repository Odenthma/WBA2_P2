package de.odenthma.geocache.client.Panels;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class NewsPanel extends JPanel{
	public static String MENU = "Menu";
	public static String NEWS = "Feeds anzeigen";

	CardLayout cl;
	JPanel mainPanel;
	JFrame frame;
	public void setTitle(){
		frame.setTitle(NEWS);
	}
	public NewsPanel(CardLayout cl, JPanel mainPanel, JFrame frame) {
		this.cl = cl;
		this.mainPanel = mainPanel;
		this.frame = frame;
			
	}

}
