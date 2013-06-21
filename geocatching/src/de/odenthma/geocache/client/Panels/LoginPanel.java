package de.odenthma.geocache.client.Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.bind.JAXBException;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import de.odenthma.geocache.UserInformation.Classes.UserType;
import de.odenthma.geocache.client.Connector;

public class LoginPanel extends JPanel implements ActionListener{
	public static String LOGIN = "Login";
	public static String ULOGIN = "User Login";
	private ActionListener listener;
	private JButton pseudoButton = new JButton(ULOGIN);
	JButton btnLogin;
	JTextField txtName = new JTextField();
	JTextField txtPass = new JTextField();
	private void initComponents() {
		this.add(new LoginPanel(null));
	}
	
	public LoginPanel( ActionListener listener){
		this.listener = listener;
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
		btnLogin.addActionListener(this);
		JButton btnAbort = new JButton("Abbrechen");
		btnLogin.addActionListener(this);
		builder.append(btnAbort);
    
		builder.append(btnLogin);
		pseudoButton.addActionListener(listener);
		add(builder.getPanel());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		UserType ut = null;
		boolean account = false;
			try {
				ut= new Connector().getUser(txtName.getText(),txtPass.getText());
				account = true;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
	
		if(account){
			pseudoButton.doClick();
		}
	}
}
