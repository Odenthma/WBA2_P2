package de.odenthma.geocache.client;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GeoCatchingClient implements ActionListener{
	public static String MENU = "Menu";
	public static String SCACHE = "Show Caches";
	public static String NUSER = "Create User";
	public static String NEWS = "Feeds anzeigen";
	public static String CCACHE = "Create Cache";

	JFrame frame = new JFrame("CardLayout");
	JPanel panels  = new JPanel();
	
	MenuPanel jpMenu;
	ShowCachePanel jpShowCache;
	CreateUserPanel jpNewUser;
	CreateCachePanel jpCreateCache;
	NewsPanel jpNews;
	
	CardLayout cl = new CardLayout();
	
	
	public GeoCatchingClient(){
		jpMenu = new MenuPanel(this);
		jpShowCache = new ShowCachePanel(this);
		jpNewUser = new CreateUserPanel(cl,panels,frame);
		jpCreateCache = new CreateCachePanel(cl,panels,frame);
		jpNews = new NewsPanel(cl, panels,frame);
		
		panels.setLayout(cl);
		panels.add(jpMenu,MENU);
		panels.add(jpShowCache,SCACHE);
		panels.add(jpNewUser, NUSER);
		panels.add(jpNews, NEWS);
		panels.add(jpCreateCache, CCACHE);
		
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
				new GeoCatchingClient();	
			}	
		});
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton o = (JButton)e.getSource();
		String name = o.getName();
		frame.setTitle(name);
		cl.show(panels, name);
	}
}

