package de.odenthma.geocache.client.Panels;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.bind.JAXBException;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import de.odenthma.geocache.client.Connector;
import de.odenthma.geocache.client.Globals;
import de.odenthma.geocache.xmppstuff.ConnectionHandler;
import de.odenthma.geocache.xmppstuff.PubSub;

public class LoginPanel extends JPanel implements ActionListener{
	public static String LOGIN = "Login";
	public static String ULOGIN = "User Login";
	public static String ABORT = "Abbrechen";
	private static String LUSER = "Login";
	private JButton btnPseudoLogin = new JButton(ULOGIN);
	private JButton btnPseudoAbort = new JButton(LUSER);
	JButton btnLogin;
	JButton btnAbort;
	JTextField txtName = new JTextField();
	JTextField txtPass = new JTextField();
	Globals globals;
	 String server =  "localhost";
     int restPort = 4434;
     int xmppPort = 5222;
	public LoginPanel( ActionListener parentListener, ActionListener mainListener, Globals globals){
		this.globals = globals;
		DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout(""));
		
		builder.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		builder.appendColumn("right:pref");
		builder.appendColumn("3dlu");
		builder.appendColumn("fill:max(pref; 100px)");
		builder.appendColumn("3dlu");
		builder.appendColumn("right:pref");
		builder.appendColumn("3dlu");
		builder.appendColumn("fill:max(pref; 100px)");
		builder.append("Username", txtName);
		builder.append("Passwort", txtPass);
		builder.nextLine();
		
		btnLogin = new JButton(LOGIN);
		btnAbort = new JButton(ABORT);
		btnLogin.addActionListener(this);
		btnAbort.addActionListener(this);
		
		JTextField bla = new JTextField(); // damit die unteren Buttons in der Mitte sind. Dient als Platzhalter
		bla.setVisible(false);
		builder.append(bla);
		
		builder.append(btnAbort);
    
		builder.append(btnLogin);
		btnPseudoLogin.addActionListener(mainListener);
		btnPseudoAbort.addActionListener(parentListener);
		add(builder.getPanel());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean account = false;
		JButton o = (JButton)e.getSource();
		String name = o.getText();
		
		if(name == LOGIN){
			try {
				try{
//					PubSub pb = new PubSub();
					ConnectionHandler pubsub_man = new ConnectionHandler();
					pubsub_man.connect(server, xmppPort);
					pubsub_man.login(txtName.getText(), txtPass.getText());
				}
				finally{}
			    
				globals.setActiveUser(new Connector().getUser(txtName.getText(),txtPass.getText()));
				account = true;
			} 
			catch (IOException ex) {
				System.out.println("Login fehlgeschlafen");
			} 
			catch (JAXBException ex) {
				ex.printStackTrace();
			}
	
			if(account){
				btnPseudoLogin.doClick();
			}
		}
		if(name == ABORT){
			btnPseudoAbort.doClick();
		}
	}
}
