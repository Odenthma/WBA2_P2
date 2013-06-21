package de.odenthma.geocache.client.Panels;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.server.UID;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.XMLGregorianCalendar;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import de.odenthma.geocache.CacheClasses.CacheType;
import de.odenthma.geocache.CacheClasses.CacheType.Location;
import de.odenthma.geocache.CacheClasses.CacheType.Owner;
import de.odenthma.geocache.CacheClasses.CacheType.Parkplatz;
import de.odenthma.geocache.CacheClasses.CacheListType;
import de.odenthma.geocache.CacheClasses.CacheTypeEnum;
import de.odenthma.geocache.CacheClasses.InformationenType;
import de.odenthma.geocache.CacheClasses.PointEnum;
import de.odenthma.geocache.CacheClasses.YesNoEnum;
import de.odenthma.geocache.UserInformation.Classes.AccountType;
import de.odenthma.geocache.UserInformation.Classes.AdressType;
import de.odenthma.geocache.UserInformation.Classes.NameType;
import de.odenthma.geocache.UserInformation.Classes.OptionalType;
import de.odenthma.geocache.UserInformation.Classes.OrtsListeType;
import de.odenthma.geocache.UserInformation.Classes.UserInformationType;
import de.odenthma.geocache.UserInformation.Classes.UserType;
//import info.clearthought.layout.*;
import de.odenthma.geocache.client.Connector;
import de.odenthma.geocache.client.MarshallUnmarshall;
import de.odenthma.geocache.utils.SpringUtilities;


@SuppressWarnings("serial")
public class CreateUserPanel extends JPanel implements ActionListener{
	public static String SCACHE = "Show Caches";
	public static String NUSER = "Create User";
	public static String NEWS = "Feeds anzeigen";
	public static String CCACHE = "Create Cache";
	
	private JTextField txtLastName;
	private JTextField txtFirstName;
	
	private JTextField txtStreet;
	private JTextField txtZip;
	private JTextField txtOrt;
	
	private JTextField txtLoginName;
	private JTextField txtLoginPw;
	private JTextField txtEmail;

	UserType newUser;
	public CreateUserPanel(ActionListener listener) {
		initComponents();
		DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout(""));
		builder.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		builder.appendColumn("right:pref");
		builder.appendColumn("3dlu");
		builder.appendColumn("fill:max(pref; 100px)");
		builder.appendColumn("3dlu");
		builder.appendColumn("right:pref");
		builder.appendColumn("3dlu");
		builder.appendColumn("fill:max(pref; 100px)");

		//Adresse
		builder.appendSeparator("Informationen");
    
		builder.append("Vorname:",txtFirstName);

		builder.append("Nachname:", txtLastName);
		builder.nextLine();

		//Adresse
		builder.appendSeparator("Adresse");
    
		builder.append("Straße", txtStreet);
		builder.nextLine();

		builder.append("PLZ:", txtZip);
//    	builder.nextLine();

		builder.append("Ort:", txtOrt);
		builder.nextLine();

    
		builder.appendSeparator("Account");

		builder.append("LoginName:", txtLoginName);
		builder.nextLine();

		builder.append("Passwort:",txtLoginPw);
		builder.nextLine();

		builder.append("Email:", txtEmail);
		builder.nextLine();

		builder.appendSeparator("Menü");
    
		JButton btnSave = new JButton("Erstellen");
		btnSave.addActionListener(this);
		JButton btnAddOptionals = new JButton("Abonieren");
		JTextField bla = new JTextField(); // damit die unteren Buttons in der Mitte sind. Dient als Platzhalter
		bla.setVisible(false);
		builder.append(bla);
		builder.append(btnAddOptionals);
    
		builder.append(btnSave);
		add(builder.getPanel());
	}

	private void send() throws IOException{
		try {
			new Connector().createUser(new MarshallUnmarshall().writeUser(newUser));
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void buildUserType(){
		newUser = new UserType();
		UserInformationType ui = new UserInformationType();
		NameType nt = new NameType();
		AdressType at = new AdressType();
		AccountType act = new AccountType();
		OptionalType ot = new OptionalType();
		UID userId = new UID();
		OrtsListeType olt = new OrtsListeType();
		
		nt.setFirstName(txtFirstName.getText());
		nt.setLastName(txtLastName.getText());
		
		at.setOrt(txtOrt.getText());
		at.setState("");
		at.setStreet(txtStreet.getText());
		at.setZipCode(txtZip.getText());
		
		ui.setAdress(at);
		ui.setName(nt);
		
		act.setLogInName(txtLoginName.getText());
		act.setLogInPW(txtLoginPw.getText());
		act.setEmail(txtEmail.getText());
		
		ot.setOrtsListe(olt);
		newUser.setUserInformation(ui);
		newUser.setAccount(act);
		
		newUser.setOptional(ot);
		
		newUser.setBId(userId.toString());
	}
	
	private void initComponents() {
//		this.add(new CreateUserPanel());
		
		//UserInformation
		txtLastName = new JTextField();
		txtFirstName = new JTextField();
		
		//Adress
		txtStreet = new JTextField();
		txtZip = new JTextField();
		txtOrt = new JTextField();
		
		//Account
		txtLoginName = new JTextField();
		txtLoginPw = new JTextField();
		txtEmail = new JTextField();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			buildUserType();
			send();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
