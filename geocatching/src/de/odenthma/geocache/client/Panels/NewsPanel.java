package de.odenthma.geocache.client.Panels;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jivesoftware.smack.XMPPException;

import de.odenthma.geocache.xmppstuff.ConnectionHandler;



@SuppressWarnings("serial")
public class NewsPanel extends JPanel implements ActionListener{
	public static String MENU = "Menu";
	public static String NEWS = "Feeds anzeigen";
	JLabel lblFeeds = new JLabel("");
	JButton btnMenu = new JButton(MENU);
	JButton btnShow = new JButton(NEWS);
	CardLayout cl;
	JPanel mainPanel;
	JFrame frame;
	ActionListener listener;
	ConnectionHandler pubsub_man;
	
	public void setTitle(){
		frame.setTitle(NEWS);
	}
	
	public NewsPanel(ActionListener listener, ConnectionHandler pubsub_man) {
		this.listener = listener;
		this.pubsub_man = pubsub_man;
		btnMenu.addActionListener(listener);
		btnShow.addActionListener(this);
		this.add(lblFeeds);
		this.add(btnMenu);
		this.add(btnShow);
			
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {

		ArrayList<String> nodes = (ArrayList<String>) pubsub_man.getAllNodes();
		for(String s: nodes)
			System.out.println(s);	
	}
}
