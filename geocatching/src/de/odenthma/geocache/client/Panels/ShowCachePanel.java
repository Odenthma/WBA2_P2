package de.odenthma.geocache.client.Panels;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.server.UID;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import de.odenthma.geocache.CacheClasses.CacheListType;
import de.odenthma.geocache.CacheClasses.CacheType;
import de.odenthma.geocache.client.CacheTableModel;
import de.odenthma.geocache.client.Connector;
import de.odenthma.geocache.client.MarshallUnmarshall;
import de.odenthma.geocache.utils.FilterCaches;

//TODO: Tabelle mit einem Cache implementieren

@SuppressWarnings("serial")
public class ShowCachePanel extends JPanel implements ComponentListener, ActionListener{
	private static String MENU = "Menu";
	private Border emptyBorder = BorderFactory.createEmptyBorder();
	private static String NEWPATH = "C:/Users/Mel_T/git/WBA2_P2/geocatching/src/de/odenthma/geocache/xml/CacheListNew.xml";
	private JButton btnMenu;
	private JButton btnDelete;
	private ActionListener listener;
	private JTable cacheTable;
	private CacheTableModel cacheData;
	private JPanel n_panel;
	private JPanel s_panel;
	private JPanel e_panel;
	private JPanel c_panel;
	    
	private void initPanelsAndComponents(){
	    	n_panel = new JPanel(new FlowLayout());
	    	s_panel = new JPanel(new FlowLayout());
	    	e_panel = new JPanel(new FlowLayout());
	    	c_panel = new JPanel(new FlowLayout());
	    	
	    	n_panel.setBorder(BorderFactory.createTitledBorder("North Panel"));	  
		    s_panel.setBorder(BorderFactory.createTitledBorder("Menü"));
		    e_panel.setBorder(BorderFactory.createTitledBorder("Ausgewählter Cache"));  
		    c_panel.setBorder(BorderFactory.createTitledBorder("Cacheliste"));
		    
		    btnMenu = new JButton(MENU);
		    btnMenu.setName(MENU);
			btnMenu.addActionListener(listener);
		    
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(this);
			
			this.setBorder(emptyBorder);
			this.setLayout(new BorderLayout());
			
			this.add(c_panel,BorderLayout.CENTER);
			this.add(e_panel,BorderLayout.EAST);
			this.add(s_panel,BorderLayout.SOUTH);
			this.addComponentListener(this);
			
			c_panel.add(new JScrollPane(cacheTable));
		    s_panel.add(btnMenu);
		    s_panel.add(btnDelete);
	}
	
	private void createTable() throws FileNotFoundException, JAXBException{
	    	cacheData = new CacheTableModel(getCaches());
			cacheTable = new JTable(cacheData);
			new FilterCaches().getCachesWithinRange(getCaches().get(3), 1004);
			
	}
	
	public ArrayList<CacheType> getCaches() throws FileNotFoundException, JAXBException{
			return new MarshallUnmarshall().getCaches(NEWPATH);
	}
	
	public ShowCachePanel(ActionListener listener) throws FileNotFoundException, JAXBException{
		this.listener = listener;  
		createTable();
		initPanelsAndComponents();
	}
	
	private void updateTable() throws FileNotFoundException, JAXBException{
		cacheData = new CacheTableModel(getCaches());
		cacheTable.setModel(cacheData);
	}
	
	@Override
	public void componentHidden(ComponentEvent e) {
	}
	
	@Override
	public void componentMoved(ComponentEvent e) {
	}
	
	@Override
	public void componentResized(ComponentEvent e) {	
	}
	
	@Override
	public void componentShown(ComponentEvent e) {
		try {
			updateTable();
		} 
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton o = (JButton)e.getSource();
		String name = o.getText();
		if(name == "Delete"){
			try {
				new Connector().sendRequestAndDeleteCache(getCaches().get(cacheTable.getSelectedRow()).getCId());
				updateTable();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (JAXBException e1) {
				e1.printStackTrace();
			}			
		}
		if(name == "Show"){
			
		}
	}	
}
