package de.odenthma.geocache.client.Panels;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.server.UID;
import java.util.ArrayList;
import javax.swing.*;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
//import info.clearthought.layout.*;
import de.odenthma.geocache.client.Connector;
import de.odenthma.geocache.client.MarshallUnmarshall;
import de.odenthma.geocache.generatedclasses.userinformation.*;


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
		btnAddOptionals.addActionListener(this);
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
		
		if(optionals){
			OptionalType.News news = new OptionalType.News();
			news.setWanted(YesNoEnum.JA);
			OptionalType.Benachrichtigung benachrichtigung = new OptionalType.Benachrichtigung();
			benachrichtigung.setWanted(YesNoEnum.JA);
			
			ot.setNews(news);
			ot.setBenachrichtigung(benachrichtigung);
//			olt.addOrt(ort);
		}
//		olt.addOrte(orte);
		//bearbeiten
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
	
	public void buildOptionalType(String plz, String lat, String lon, String radius){

		OrtsType ort = new OrtsType();
		ort.setPostal(plz);
		ort.setLat(Double.parseDouble(lat));
		ort.setLon(Double.parseDouble(lon));
		ort.setUmkreis(radius);
		
		olt.addOrt(ort);
	}
	OrtsListeType olt = new OrtsListeType();
	ArrayList<OrtsType> orte = new ArrayList<OrtsType>();
	boolean optionals = false;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton o = (JButton)e.getSource();
		String name = o.getText();
		if(name.equals("Erstellen")){
			if(		txtLastName.getText().trim().equals("")||
					txtFirstName.getText().trim().equals("")||
					txtStreet.getText().trim().equals("")||
					txtZip.getText().trim().equals("")||
					txtOrt.getText().trim().equals("")||
					txtLoginName.getText().trim().equals("")||
					txtLoginPw.getText().trim().equals("")||
					txtEmail.getText().trim().equals("")){
				JOptionPane.showMessageDialog(this, "Alle Felder müssen ausgefüllt sein!");
			}
			else{
				try {
					buildUserType();
					send();
					JOptionPane.showMessageDialog(this, "Benutzer wurde angelegt!");
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		if(name.equals("Abonieren")){
			String[] items = {"One", "Two", "Three", "Four", "Five"};
//	        JComboBox combo = new JComboBox(items);
			JTextField txtPLZ = new JTextField("");
	        JTextField txtLat = new JTextField("");
	        JTextField txtLon = new JTextField("");
	        JTextField txtRadius = new JTextField("");
	        JPanel panel = new JPanel(new GridLayout(0, 1));
//	        panel.add(combo);
	        panel.add(new JLabel("PLZ:"));
	        panel.add(txtPLZ);
	        panel.add(new JLabel("Latitute:"));
	        panel.add(txtLat);
	        panel.add(new JLabel("Longitute:"));
	        panel.add(txtLon);
	        panel.add(new JLabel("Umkreis:"));
	        panel.add(txtRadius);
	        int result = JOptionPane.showConfirmDialog(null, panel, "Test",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	        if (result == JOptionPane.OK_OPTION) {
	        	optionals = true;
	        	buildOptionalType(txtPLZ.getText(), txtLat.getText(), txtLon.getText(), txtRadius.getText());
	        } else {
	            System.out.println("Cancelled");
	        }
		}
	}
}
