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
import de.odenthma.geocache.utils.ServerAdress;
import de.odenthma.geocache.xmppstuff.ConnectionHandler;


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

     ConnectionHandler pubsub_man;
	public LoginPanel( ActionListener parentListener, ActionListener mainListener,ConnectionHandler pubsub_man){

		this.pubsub_man = pubsub_man;
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
			try{
//					PubSub pb = new PubSub();
//					ConnectionHandler pubsub_man = new ConnectionHandler();
				pubsub_man.connect(ServerAdress.HOST, ServerAdress.xmppPort);
				pubsub_man.login(txtName.getText(), txtPass.getText());
			}
			finally{}
			
			account = true;
	
			if(account){
				btnPseudoLogin.doClick();
			}
		}
		if(name == ABORT){
			btnPseudoAbort.doClick();
		}
	}
}
