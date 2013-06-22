package de.odenthma.geocache.client;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.xml.bind.JAXBException;

import de.odenthma.geocache.client.Panels.CreateCachePanel;
import de.odenthma.geocache.client.Panels.CreateUserPanel;
import de.odenthma.geocache.client.Panels.ServerPanel;
import de.odenthma.geocache.client.Panels.UserPanel;
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
	public static String ULOGIN = "User Login";
	private static String SERVER ="Connect";
	private JFrame frame = new JFrame("CardLayout");
	private JPanel panels  = new JPanel();
	
	private MenuPanel jpMenu;
	private ShowCachePanel jpShowCache;
	private CreateUserPanel jpNewUser;
	private CreateCachePanel jpCreateCache;
	private NewsPanel jpNews;
	private UserPanel jpLogin;
	private ServerPanel jpServer;
	private CardLayout cl = new CardLayout();
	
	private Globals globals = new Globals();
	
	public GeoCatchingClient() throws JAXBException, IOException{
		jpMenu = new MenuPanel(this);
		jpShowCache = new ShowCachePanel(this);
		jpNewUser = new CreateUserPanel(this);
		jpCreateCache = new CreateCachePanel(this);
		jpNews = new NewsPanel(cl, panels,frame);
		jpLogin = new UserPanel(this,globals);
		
		panels.setLayout(cl);
		panels.add(jpMenu,MENU);
		panels.add(jpShowCache,SCACHE);
		panels.add(jpNewUser, NUSER);
		panels.add(jpNews, NEWS);
		panels.add(jpCreateCache, CCACHE);
		panels.add(jpLogin, LUSER);
		cl.show(panels, LUSER);
//		cl.show(panels, MENU);
		
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
				} 
				catch (JAXBException e) {
					e.printStackTrace();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}	
			}	
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton o = (JButton)e.getSource();
		String name = o.getText();
//		System.out.println(name);
		System.out.println(name);
		if(name ==  ULOGIN){ name = MENU;}
		
		frame.setTitle(name);
		cl.show(panels, name);
	}
}

