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
//import info.clearthought.layout.*;
import de.odenthma.geocache.client.Connector;
import de.odenthma.geocache.client.MarshallUnmarshall;
import de.odenthma.geocache.utils.SpringUtilities;


@SuppressWarnings("serial")
public class CreateUserPanel extends JPanel implements ActionListener{
	private static String MENU = "Menu";
	public static String SCACHE = "Show Caches";
	public static String NUSER = "Create User";
	public static String NEWS = "Feeds anzeigen";
	public static String CCACHE = "Create Cache";
	private ActionListener listener;
	
	//UserInformation
	private JLabel lblLastName;
	private JTextField txtLastName;
	private JLabel lblFirstName;
	private JTextField txtFirstName;
	
	//Adress
	private JLabel lblState;
	private JTextField txtState;
	private JLabel lblStreet;
	private JTextField txtStreet;
	private JLabel lblZip;
	private JTextField txtZip;
	private JLabel lblOrt;
	private JTextField txtOrt;
	
	//Account
	private JLabel lblLoginName;
	private JTextField txtLoginName;
	private JLabel lblLoginPw;
	private JTextField txtLoginPw;
	private JLabel lblEmail;
	private JTextField txtEmail;

	
	public CreateUserPanel(ActionListener listener) {
		this.listener = listener;
		initComponents();
	}

	private void createCache() throws Exception{
		
	    send();
	}
	private void send() throws IOException{
		try {
//			new Connector().sendRequestAndData(new MarshallUnmarshall().writeCache("",ct));
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initComponents() {
		this.add(new CreateUserPanel());
	}
	public CreateUserPanel(){
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
    
		builder.append("Vorname:", new JTextField());

		builder.append("Nachname:", new JTextField());
		builder.nextLine();

		//Adresse
		builder.appendSeparator("Adresse");
    
		builder.append("Straße", new JTextField());
		builder.nextLine();

		builder.append("ZIP:", new JTextField());
//    	builder.nextLine();

		builder.append("Ort:", new JTextField());
		builder.nextLine();

    
		builder.appendSeparator("Account");

		builder.append("LoginName:", new JTextField());
		builder.nextLine();

		builder.append("Passwort:", new JTextField());
		builder.nextLine();

		builder.append("Email:", new JTextField());
		builder.nextLine();

		builder.appendSeparator("Menü");
    
		JButton btnSave = new JButton("Erstellen");
		JButton btnAddOptionals = new JButton("Abonieren");

		builder.append(btnAddOptionals);
    
		builder.append(btnSave);
		add(builder.getPanel());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
