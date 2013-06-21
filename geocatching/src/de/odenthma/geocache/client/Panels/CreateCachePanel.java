package de.odenthma.geocache.client.Panels;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

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


@SuppressWarnings("serial")
public class CreateCachePanel extends JPanel implements ActionListener{
	private static String MENU = "Menu";
	public static String SCACHE = "Show Caches";
	public static String NUSER = "Create User";
	public static String NEWS = "Feeds anzeigen";
	public static String CCACHE = "Create Cache";
	private ActionListener listener;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblDate;
	private JTextField txtDate;
	private JLabel lblLocLat;
	private JTextField txtLocLat;
	private JLabel lblLocLon;
	private JTextField txtLocLon;
	private JLabel lblParkLat;
	private JTextField txtParkLat;
	private JLabel lblParkLon ;
	private JTextField txtParkLon;
	private JLabel lblCacheType;
	private JComboBox cbCacheType;
	private JComponent separator1;
	private JLabel lblDiff;
	private JComboBox cbDiff;
	private JLabel lblTerrain;
	private JComboBox cbTerrain;
	private JLabel lblCountry;
	private JTextField txtCountry;
	private JLabel lblBundesland;
	private JTextField txtBundesland;
	private JLabel lblProvince;
	private JTextField txtProvince;
	private JLabel lblDescSmall;
	private JTextField txtDescSmall;
	private JLabel lblDescLarge;
	private JScrollPane scrollPane1;
	private JTextArea txtDescLarge;
	private JLabel lblHints;
	private JScrollPane scrollPane2;
	private JTextArea txtHints;
	private JLabel lblTime;
	private JComboBox cbTime;
	private JLabel lblTravelBug;
	private JComboBox cbTravelBug;
	private JButton btnSave;
	JButton btnMenu;
	
	
	public CreateCachePanel(ActionListener listener) {
		this.listener = listener;
		initComponents();
	}
	CacheType ct;
	private void createCache() throws Exception{
		InformationenType inf = new InformationenType();
		inf.setSchwierigkeit((double)cbDiff.getSelectedItem());
		inf.setTerrain((double)cbTerrain.getSelectedItem());
		inf.setLand(txtCountry.getText());
		inf.setBundesland(txtBundesland.getText());
		inf.setProvinz(txtProvince.getText());
		inf.setBeschreibungKlein(txtDescSmall.getText());
		inf.setBeschreibungGross(txtDescLarge.getText());
		inf.setHinweise(txtHints.getText());
		inf.setGeschaetzteZeit((double)cbTime.getSelectedItem());
		inf.setTravelBug(YesNoEnum.JA);
		ct = new CacheType();
		
		Location loc = new Location();
		loc.setLat(Double.parseDouble(txtLocLat.getText()));
		loc.setLon(Double.parseDouble(txtLocLon.getText()));
		
		UID cacheId = new UID();
		ct.setCId(cacheId.toString());
		ct.setLocation(loc);
		ct.setName(txtName.getText());
		ct.setDatum(new GregorianCalendar());
		ct.setTyp(CacheTypeEnum.valueOf(cbCacheType.getSelectedItem().toString()));
		
		Owner owner = new Owner();
		owner.setBId("b000?");
		owner.setValue(txtUser.getText());
		ct.setOwner(owner);
		
		Parkplatz locPark = new Parkplatz();
		locPark.setLat(Double.parseDouble(txtParkLat.getText()));
		locPark.setLon(Double.parseDouble(txtParkLon.getText()));
		locPark.setValue("unknown");
		ct.setParkplatz(locPark);
		
		ct.setInformationen(inf);
		
		//Daten marshallen und an Service senden
	    send();
	}
	private void send() throws IOException{
		try {
			new Connector().sendRequestAndData(new MarshallUnmarshall().writeCache(ct));
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initComponents() {
		
		lblName = new JLabel();
		txtName = new JTextField();
		lblUser = new JLabel();
		txtUser = new JTextField();
		lblDate = new JLabel();
		txtDate = new JTextField();
		lblLocLat = new JLabel();
		txtLocLat = new JTextField();
		lblLocLon = new JLabel();
		txtLocLon = new JTextField();
		lblParkLat = new JLabel();
		txtParkLat = new JTextField();
		lblParkLon = new JLabel();
		txtParkLon = new JTextField();
		lblCacheType = new JLabel();
		cbCacheType = new JComboBox(CacheTypeEnum.class.getEnumConstants());
		lblDiff = new JLabel();
		cbDiff = new JComboBox(PointEnum.getAll().toArray());
		lblTerrain = new JLabel();
		cbTerrain = new JComboBox(PointEnum.getAll().toArray());
		lblCountry = new JLabel();
		txtCountry = new JTextField();
		lblBundesland = new JLabel();
		txtBundesland = new JTextField();
		lblProvince = new JLabel();
		txtProvince = new JTextField();
		lblDescSmall = new JLabel();
		txtDescSmall = new JTextField();
		lblDescLarge = new JLabel();
		scrollPane1 = new JScrollPane();
		txtDescLarge = new JTextArea();
		lblHints = new JLabel();
		scrollPane2 = new JScrollPane();
		txtHints = new JTextArea();
		lblTime = new JLabel();
		cbTime = new JComboBox(PointEnum.getAll().toArray());
		lblTravelBug = new JLabel();
		cbTravelBug = new JComboBox();
		btnSave = new JButton();
		
		btnMenu = new JButton(MENU);
		
		

		setBorder(new CompoundBorder(
			new TitledBorder(new EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				Color.red), getBorder())); addPropertyChangeListener(new PropertyChangeListener(){public void propertyChange(PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

		setLayout(new TableLayout(new double[][] {
			{TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
			{TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));
		((TableLayout)getLayout()).setHGap(5);
		((TableLayout)getLayout()).setVGap(5);

		//---- label1 ----
		lblName.setText("Name");
		add(lblName, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
		add(txtName, new TableLayoutConstraints(3, 1, 12, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label2 ----
		lblUser.setText("Benutzer");
		add(lblUser, new TableLayoutConstraints(1, 2, 1, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
		add(txtUser, new TableLayoutConstraints(3, 2, 12, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label3 ----
		lblDate.setText("Datum");
		add(lblDate, new TableLayoutConstraints(1, 3, 1, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
		add(txtDate, new TableLayoutConstraints(3, 3, 12, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label4 ----
		lblLocLat.setText("Location lat");
		add(lblLocLat, new TableLayoutConstraints(1, 4, 1, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
		add(txtLocLat, new TableLayoutConstraints(3, 4, 5, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label5 ----
		lblLocLon.setText("location lon");
		add(lblLocLon, new TableLayoutConstraints(8, 4, 8, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
		add(txtLocLon, new TableLayoutConstraints(10, 4, 12, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label6 ----
		lblParkLat.setText("Park lat");
		add(lblParkLat, new TableLayoutConstraints(1, 5, 1, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
		add(txtParkLat, new TableLayoutConstraints(3, 5, 5, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label7 ----
		lblParkLon.setText("Park lon");
		add(lblParkLon, new TableLayoutConstraints(8, 5, 8, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
		add(txtParkLon, new TableLayoutConstraints(10, 5, 12, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label8 ----
		lblCacheType.setText("Cachetyp");
		add(lblCacheType, new TableLayoutConstraints(1, 6, 1, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
		add(cbCacheType, new TableLayoutConstraints(3, 6, 5, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
		

		//---- label9 ----
		lblDiff.setText("Schwierigkeit");
		add(lblDiff, new TableLayoutConstraints(1, 9, 1, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
		add(cbDiff, new TableLayoutConstraints(3, 9, 5, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label10 ----
		lblTerrain.setText("Terrain");
		add(lblTerrain, new TableLayoutConstraints(8, 9, 8, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
		add(cbTerrain, new TableLayoutConstraints(10, 9, 12, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label11 ----
		lblCountry.setText("Land");
		add(lblCountry, new TableLayoutConstraints(1, 10, 1, 10, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
		add(txtCountry, new TableLayoutConstraints(3, 10, 12, 10, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label12 ----
		lblBundesland.setText("Bundesland");
		add(lblBundesland, new TableLayoutConstraints(1, 11, 1, 11, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
		add(txtBundesland, new TableLayoutConstraints(3, 11, 12, 11, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label13 ----
		lblProvince.setText("Provinz");
		add(lblProvince, new TableLayoutConstraints(1, 12, 1, 12, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
		add(txtProvince, new TableLayoutConstraints(3, 12, 12, 12, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label14 ----
		lblDescSmall.setText("Beschreibung klein");
		add(lblDescSmall, new TableLayoutConstraints(1, 13, 1, 13, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
		add(txtDescSmall, new TableLayoutConstraints(3, 13, 12, 13, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label15 ----
		lblDescLarge.setText("Beschreibung lang");
		add(lblDescLarge, new TableLayoutConstraints(1, 14, 1, 14, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//======== scrollPane1 ========
		{
			scrollPane1.setViewportView(txtDescLarge);
		}
		add(scrollPane1, new TableLayoutConstraints(3, 14, 12, 16, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label16 ----
		lblHints.setText("Hinweise");
		add(lblHints, new TableLayoutConstraints(1, 17, 1, 17, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//======== scrollPane2 ========
		{
			scrollPane2.setViewportView(txtHints);
		}
		add(scrollPane2, new TableLayoutConstraints(3, 17, 12, 19, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label17 ----
		lblTime.setText("Gesch\u00e4tzte Zeit");
		add(lblTime, new TableLayoutConstraints(1, 20, 1, 20, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
		add(cbTime, new TableLayoutConstraints(3, 20, 5, 20, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label18 ----
		lblTravelBug.setText("Travelbug");
		add(lblTravelBug, new TableLayoutConstraints(8, 20, 8, 20, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
		add(cbTravelBug, new TableLayoutConstraints(10, 20, 12, 20, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- button1 ----
		btnSave.setText("Speichern");
		add(btnSave, new TableLayoutConstraints(1, 22, 1, 22, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
		btnSave.addActionListener(this);
		//---- button2 ----
		btnMenu.setText(MENU);
		btnMenu.addActionListener(listener);
//		System.out.println(btnMenu.getText());
		add(btnMenu, new TableLayoutConstraints(9, 22, 12, 22, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			createCache();
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
