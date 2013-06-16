package de.odenthma.geocache.client;
import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


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
	
	JLabel labelName = new JLabel("Cache Name: ");
	JTextField textName = new JTextField("");
	JLabel labelUser= new JLabel("Benutzer: ");
	JTextField textUser= new JTextField("");
	JLabel labelDate = new JLabel("Datum: ");
	JTextField textDate = new JTextField("");
	JLabel labelType = new JLabel("Cachetyp: ");
	JTextField textType = new JTextField("");
	JLabel labelLat = new JLabel("Latitute: ");
	JTextField textLat = new JTextField("");
	JLabel labelLon = new JLabel("Lagitute: ");
	JTextField textLon = new JTextField("");
	public void setTitle(){
		frame.setTitle(CCACHE);
	}
	public CreateCachePanel(CardLayout cl, JPanel mainPanel, JFrame frame) {
		
		this.cl = cl;
		this.mainPanel = mainPanel;
		this.frame = frame;
		
		
		this.setLayout(new SpringLayout());
		addComponents();
		SpringUtilities.makeGrid(this,
                6, 2, //rows, cols
                10, 10, //initialX, initialY
                10, 10);//xPad, yPad
	}
	public void addComponents(){
		this.add(labelName);
		this.add(textName);
		this.add(labelUser);
		this.add(textUser);
		this.add(labelDate);
		this.add(textDate);
		this.add(labelType);
		this.add(textType);
		this.add(labelLat);
		this.add(textLat);
		this.add(labelLon);
		this.add(textLon);

      
	}

}
