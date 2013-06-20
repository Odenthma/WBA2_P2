package de.odenthma.geocache.client;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.xml.bind.JAXBException;

import de.odenthma.geocache.client.Panels.CreateCachePanel;
import de.odenthma.geocache.client.Panels.CreateUserPanel;
import de.odenthma.geocache.client.Panels.LoginPanel;
import de.odenthma.geocache.client.Panels.MenuPanel;
import de.odenthma.geocache.client.Panels.NewsPanel;
import de.odenthma.geocache.client.Panels.ShowCachePanel;

public class GeoCatchingClient implements ActionListener{
	private static String MENU = "Menu";
	private static String SCACHE = "Show Caches";
	private static String NUSER = "Create User";
	private static String NEWS = "Feeds anzeigen";
	private static String CCACHE = "Create Cache";
	private static String LUSER = "Login";
	
	JFrame frame = new JFrame("CardLayout");
	JPanel panels  = new JPanel();
	
	MenuPanel jpMenu;
	ShowCachePanel jpShowCache;
	CreateUserPanel jpNewUser;
	CreateCachePanel jpCreateCache;
	NewsPanel jpNews;
	LoginPanel jpLogin;
	CardLayout cl = new CardLayout();
	
	public GeoCatchingClient() throws FileNotFoundException, JAXBException{
		jpMenu = new MenuPanel(this);
		jpShowCache = new ShowCachePanel(this);
		jpNewUser = new CreateUserPanel(cl,panels,frame);
		jpCreateCache = new CreateCachePanel(this);
		jpNews = new NewsPanel(cl, panels,frame);
		jpLogin = new LoginPanel(this);
		panels.setLayout(cl);
		panels.add(jpMenu,MENU);
		panels.add(jpShowCache,SCACHE);
		panels.add(jpNewUser, NUSER);
		panels.add(jpNews, NEWS);
		panels.add(jpCreateCache, CCACHE);
		panels.add(jpLogin,LUSER);
		
//		cl.show(panels, LUSER);
		cl.show(panels, MENU);
		
		frame.add(panels);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void  main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				try {
					new GeoCatchingClient();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (JAXBException e) {
					e.printStackTrace();
				}	
			}	
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton o = (JButton)e.getSource();
		String name = o.getText();
		System.out.println(name);
		frame.setTitle(name);
		
		cl.show(panels, name);
	}
}

