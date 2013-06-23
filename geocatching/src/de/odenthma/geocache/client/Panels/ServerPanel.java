package de.odenthma.geocache.client.Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import de.odenthma.geocache.utils.ServerAdress;

public class ServerPanel extends JPanel implements ActionListener{

	public static String LOGIN = "Login";
	public static String ULOGIN = "User Login";
	public static String ABORT = "Abbrechen";
	private static String LUSER = "Login";
	private static String SERVEROK ="Server OK";
	private JButton btnPseudoServerOkay = new JButton(SERVEROK);
	private boolean fastLogin = false;
	JButton btnConnect;
	JTextField txtServer = new JTextField();
	JTextField txtPort = new JTextField();
	JLabel lblStatus = new JLabel();

	public ServerPanel(ActionListener mainListener){

		DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout(""));
		
		builder.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		builder.appendColumn("right:pref");
		builder.appendColumn("3dlu");
		builder.appendColumn("fill:max(pref; 100px)");
		builder.appendColumn("3dlu");
		builder.appendColumn("right:pref");
		builder.appendColumn("3dlu");
		builder.appendColumn("fill:max(pref; 100px)");
		builder.append("Serveradresse", txtServer);
		builder.append("Serverport", txtPort);

		btnConnect = new JButton(LOGIN);
		btnConnect.addActionListener(this);
    
		builder.append(btnConnect);
		builder.append(lblStatus);
		btnPseudoServerOkay.addActionListener(mainListener);
		
		
		add(builder.getPanel());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String strUrl;
		if(fastLogin){
			strUrl = "http://"+ServerAdress.HOST+":"+ServerAdress.restPort;
		}
		else
			strUrl = "http://"+txtServer.getText()+":"+txtPort.getText();
	    try {
	        URL url = new URL(strUrl);
	        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
	        urlConn.connect();
	        lblStatus.setText("Server is up: "+ txtServer.getText()+":"+txtPort.getText());
	        btnPseudoServerOkay.doClick();
	        
	    } 
	    catch (IOException ex) {
	    	lblStatus.setText("Server is down: "+ txtServer.getText()+":"+txtPort.getText());
	    }
	}
}
