package de.odenthma.geocache.client.Panels;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBException;

import de.odenthma.geocache.client.CacheTableData;
import de.odenthma.geocache.client.Connector;
import de.odenthma.geocache.generatedclasses.cache.CacheType;
import de.odenthma.geocache.generatedclasses.cache.CacheTypeEnum;
import de.odenthma.geocache.generatedclasses.cache.PointEnum;
import de.odenthma.geocache.utils.Filter;

//TODO: Tabelle mit einem Cache implementieren

@SuppressWarnings("serial")
public class ShowCachePanel extends JPanel implements ComponentListener, ActionListener, MouseListener{
	private static String MENU = "Menu";
	private static String FILTER = "Filter";
	private Border emptyBorder = BorderFactory.createEmptyBorder();
	private JButton btnMenu;
	private JButton btnDelete;
	private JButton btnFilter;
	private ActionListener listener;
	private JTable cacheTable;
	private JTable singleTable;
	private JPanel n_panel;
	private JPanel s_panel;
	private JPanel e_panel;
	private JPanel c_panel;
	DefaultTableModel preview;
	DefaultTableModel detail;
	CacheTableData dataPreview = new CacheTableData("preview");
	CacheTableData dataDetail = new CacheTableData("detail");
	ArrayList<CacheType> caches = new ArrayList<CacheType>();
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
		    
			btnFilter = new JButton(FILTER);
			btnFilter.setName(FILTER);
			btnFilter.addActionListener(this);
			
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(this);
			
			this.setBorder(emptyBorder);
			this.setLayout(new BorderLayout());
			
			this.add(c_panel,BorderLayout.CENTER);
			this.add(e_panel,BorderLayout.EAST);
			this.add(s_panel,BorderLayout.SOUTH);
			this.addComponentListener(this);
			
			preview = new DefaultTableModel(null,dataPreview.getHeader());
			detail = new DefaultTableModel(null,dataDetail.getHeader());
//		    DefaultTableModel detail;
			cacheTable = new JTable(preview);	
			singleTable = new JTable(detail);
			cacheTable.addMouseListener(this);
			c_panel.add(new JScrollPane(cacheTable));
			e_panel.add(new JScrollPane(singleTable));
		    s_panel.add(btnMenu);
		    s_panel.add(btnDelete);
		    s_panel.add(btnFilter);
	}
	
	private void createTable() throws JAXBException, IOException{
		dataPreview = new CacheTableData("preview");
		caches = getCaches();
		for(CacheType ct: caches){
			preview = new DefaultTableModel(dataPreview.fillData(ct),dataPreview.getHeader());
		}
		cacheTable.setModel(preview);
		singleTable.setModel(new DefaultTableModel(null,dataDetail.getHeader()));

	}
	
	public ArrayList<CacheType> getCaches() throws JAXBException, IOException{
			try{
				return new Connector().getCaches();
			}
			finally{}
	}
	public ArrayList<CacheType> filterCaches(String filter) throws JAXBException, IOException{
		try{
			return new Connector().filterCaches(filter);
		}
		finally{}
}
	public ShowCachePanel(ActionListener listener) throws JAXBException, IOException{
		this.listener = listener;  
		initPanelsAndComponents();
	}

	private void updateTable() throws JAXBException, IOException{
		dataDetail = new CacheTableData("detail");
			detail = new DefaultTableModel(dataDetail.fillData(caches.get(cacheTable.getSelectedRow())),dataDetail.getHeader());
		singleTable.setModel(detail);
	}

	private void filterTable(String filter) throws JAXBException, IOException{
//		cacheData = new CacheTableModel(new Connector().filterCaches(filter));
//		cacheTable.setModel(cacheData);
		caches = filterCaches(filter);
		dataPreview = new CacheTableData("preview");
		for(CacheType ct: caches){
			preview = new DefaultTableModel(dataPreview.fillData(ct),dataPreview.getHeader());
		}
		cacheTable.setModel(preview);
		singleTable.setModel(new DefaultTableModel(null,dataDetail.getHeader()));
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
				createTable();
			} catch (JAXBException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	}

	private String stringBuilder(String a, String b,  String pattern){
			if(a == "")
				return a + b;
			else 
				return a + pattern + b;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton o = (JButton)e.getSource();
		String name = o.getText();
		if(name == "Delete"){
			try {
				new Connector().sendRequestAndDeleteCache(caches.get(cacheTable.getSelectedRow()).getCId());
				createTable();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (JAXBException e1) {
				e1.printStackTrace();
			}			
		}
		if(name == FILTER){
			ArrayList<String> items = new ArrayList<String>();
			items.add("");
	        ArrayList<String> itemsTB = new ArrayList<String>();
			itemsTB.add("");
			itemsTB.add("ja");
			itemsTB.add("nein");
			ArrayList<String> itemsType = new ArrayList<String>();
	        itemsType.add("");
			for(Double d: PointEnum.getAll())
				items.add(d.toString());
			for(CacheTypeEnum  s: CacheTypeEnum.class.getEnumConstants())
				 itemsType.add(""+s);
	        
			JTextField txtDist = new JTextField("");
	        JTextField txtLat = new JTextField("");
	        JTextField txtLon = new JTextField("");
	        JComboBox<?> cbCacheType = new JComboBox<Object>(itemsType.toArray());
	        JComboBox<?> cbDiff = new JComboBox<Object>(items.toArray());
	        JComboBox<?> cbTerrain = new JComboBox<Object>(items.toArray());
	        JComboBox<?> cbTime = new JComboBox<Object>(items.toArray());
	        JComboBox<?> cbTravelbug = new JComboBox<Object>(itemsTB.toArray());
	       
	        JPanel panel = new JPanel(new GridLayout(0, 1));
	        panel.add(new JLabel("Distance:"));
	        panel.add(txtDist);
	        panel.add(new JLabel("Latitute:"));
	        panel.add(txtLat);
	        panel.add(new JLabel("Longitute:"));
	        panel.add(txtLon);
	        panel.add(new JLabel("Cachetype:"));
	        panel.add(cbCacheType);
	        
	        panel.add(new JLabel("Schwierigkeit:"));
	        panel.add(cbDiff);
	        panel.add(new JLabel("Terrain:"));
	        panel.add(cbTerrain);
	        panel.add(new JLabel("Dauer:"));
	        panel.add(cbTime);
	        panel.add(new JLabel("Travelbug:"));
	        panel.add(cbTravelbug);
	        
	        int result = JOptionPane.showConfirmDialog(null, panel, "Filter Caches",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	        if (result == JOptionPane.OK_OPTION) {
	        	String filterKriterien = "";
	        	String filterValues = "";
	        	
	        	if(!txtDist.getText().trim().isEmpty()){
	        		filterKriterien = stringBuilder(filterKriterien, Filter.DISTANCE, "§");
	        		filterValues = stringBuilder(filterValues, txtDist.getText().trim(), "§");
	        	}
	        	if(!txtLat.getText().trim().isEmpty()){
	        		filterKriterien = stringBuilder(filterKriterien, Filter.LAT, "§");
	        		filterValues = stringBuilder(filterValues, txtLat.getText().trim(), "§");
	        	}
	        	if(!txtLon.getText().trim().isEmpty()){
	        		filterKriterien = stringBuilder(filterKriterien, Filter.LON, "§");
	        		filterValues = stringBuilder(filterValues, txtLon.getText().trim(), "§");
	        	}     
	        	if(cbCacheType.getSelectedItem().toString().trim() != ""){
	        		filterKriterien = stringBuilder(filterKriterien, Filter.CACHETYPE, "§");
	        		filterValues = stringBuilder(filterValues, cbCacheType.getSelectedItem().toString().trim(), "§");
	        	}	        	
	        	if(cbDiff.getSelectedItem().toString().trim() != ""){
	        		filterKriterien = stringBuilder(filterKriterien, Filter.SCHWIERIGKEIT, "§");
	        		filterValues = stringBuilder(filterValues, cbDiff.getSelectedItem().toString().trim(), "§");
	        	}
	        	if(cbTerrain.getSelectedItem().toString().trim() != ""){
	        		filterKriterien = stringBuilder(filterKriterien, Filter.TERRAIN, "§");
	        		filterValues = stringBuilder(filterValues, cbTerrain.getSelectedItem().toString().trim(), "§");
	        	}
	        	if(cbTime.getSelectedItem().toString().trim() != ""){
	        		filterKriterien = stringBuilder(filterKriterien, Filter.DAUER, "§");
	        		filterValues = stringBuilder(filterValues, cbTime.getSelectedItem().toString().trim(), "§");
	        	}
	        	if(cbTravelbug.getSelectedItem().toString().trim() != ""){
	        		filterKriterien = stringBuilder(filterKriterien, Filter.TRAVELBUG, "§");
	        		filterValues = stringBuilder(filterValues, cbTravelbug.getSelectedItem().toString().trim(), "§");
	        	}

	        	try {
					filterTable(stringBuilder(filterKriterien, filterValues,"!"));
				} catch (JAXBException e1) {
					e1.printStackTrace();
				} 
	        	catch (IOException e1) {
					try {
						createTable();
					} 
					catch (JAXBException e2) {
						e2.printStackTrace();
					} 
					catch (IOException e2) {
						e2.printStackTrace();
					}
				}
	        } 
	        else {
	            System.out.println("Cancelled");
	        }
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		try {
			updateTable();
		} 
		catch (JAXBException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
}
