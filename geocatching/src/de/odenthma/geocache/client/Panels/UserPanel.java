package de.odenthma.geocache.client.Panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.xml.bind.JAXBException;



import de.odenthma.geocache.client.Globals;
import de.odenthma.geocache.client.MarshallUnmarshall;
import de.odenthma.geocache.client.PathHandler;
import de.odenthma.geocache.xmppstuff.ConnectionHandler;

@SuppressWarnings("serial")
public class UserPanel extends JPanel implements ActionListener{
	public static String ULOGIN = "User Login";
	public static String LOGIN = "Login";
	private static String SERVEROK ="Server OK";
	ActionListener listener;
	private JPanel s_panel;
	private JPanel c_panel;
	private Border emptyBorder = BorderFactory.createEmptyBorder();
	private static String MENU = "Menu";
	private static String SERVER ="Connect";
	JButton btnCreateUser = new JButton("User erstellen");
	JButton btnLogin = new JButton(ULOGIN);
	JButton btnOk = new JButton(MENU);
	private ServerPanel jpServer;
	Globals globals;
	ConnectionHandler pubsub_man;
	
	public UserPanel(ActionListener listener, Globals globals, ConnectionHandler pubsub_man) throws FileNotFoundException, JAXBException{
		this.listener = listener;
		this.globals = globals;
		this.pubsub_man = pubsub_man;
		initComponents();
	}
	
	public void initComponents(){
    	s_panel = new JPanel(new FlowLayout());
    	c_panel = new JPanel(new FlowLayout());
    	jpServer = new ServerPanel(this,globals);
    	c_panel.add(jpServer);
	    s_panel.setBorder(BorderFactory.createTitledBorder("Menü")); 
	    c_panel.setBorder(BorderFactory.createTitledBorder("User Login"));

	    btnCreateUser.addActionListener(this);
	    btnCreateUser.setEnabled(false);
	    btnLogin.setEnabled(false);
	    s_panel.add(btnCreateUser);
	    s_panel.add(btnLogin);
	    btnLogin.addActionListener(this);
	    this.setBorder(emptyBorder);
		this.setLayout(new BorderLayout());
		
		this.add(c_panel,BorderLayout.CENTER);
		this.add(s_panel,BorderLayout.SOUTH);
		
		this.setPreferredSize(new Dimension(200, 120));
	}
	
//	public ArrayList<UserType> getUsers() throws FileNotFoundException, JAXBException{
////		return new MarshallUnmarshall().getUsers(new PathHandler().getPath("/UserListNew.xml"));
//	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton o = (JButton)e.getSource();
		String name = o.getText();
		c_panel.removeAll();
		if(name.equals(SERVEROK)){
			  btnCreateUser.setEnabled(true);
			    btnLogin.setEnabled(true);
		}
		if(name.equals("User erstellen")){
			c_panel.add(new CreateUserPanel(listener));
		}
		if(name.equals(ULOGIN)){
			c_panel.add(new LoginPanel(this, listener,globals, pubsub_man));
		}
		this.updateUI();
	}
}
