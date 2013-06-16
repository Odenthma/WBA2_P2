package de.odenthma.geocache.client;
import java.awt.List;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.xml.bind.JAXBException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import de.odenthma.geocache.CacheClasses.CacheListType;
import de.odenthma.geocache.CacheClasses.CacheType;


@SuppressWarnings("serial")
public class ShowCachePanel extends JPanel{
	public static String MENU = "Menu";
	public static String SCACHE = "Show Caches";
	public static String NUSER = "Create User";
	public static String NEWS = "Feeds anzeigen";
	public static String CCACHE = "Create Cache";
	CacheUnmarshaller cu = new CacheUnmarshaller();
	Border emptyBorder = BorderFactory.createEmptyBorder();
	JButton btnMenu = new JButton(MENU);
	ActionListener listener;
	JTable cacheTable;
	CacheListType clt;
	ArrayList caches = new ArrayList();
	String columnName = "Cache";
	public ShowCachePanel(ActionListener listener) throws FileNotFoundException, JAXBException{
		this.listener = listener;
		clt = cu.getCaches();
		String url = "http://localhost:4434";
	      url = url + "/cachelist";
	      for (CacheType s : cu.getCaches().getCache()){
	    	  System.out.println( s.getOwner().getValue() + " " + s.getCId() + " " + s.getLocation().getLat());
	    	  caches.add(s.getName());
	      }

	      WebResource wrs = Client.create().resource( url );
	      
		btnMenu.setName(MENU);
		btnMenu.addActionListener(listener);
		this.add(btnMenu);
		this.setBorder(emptyBorder);
		cacheTable = new JTable(new CacheTableModel(clt.getCache()));
		JScrollPane scrollPane = new JScrollPane(cacheTable);
		this.add(scrollPane);
//		cacheTable.add(caches);
		
	}
	class CacheTableModel extends AbstractTableModel {
        private String[] columnNames = { "Cachename", "ID", "Owner",
                  "Datum"};
        ArrayList<CacheType> list = null;

        CacheTableModel(ArrayList<CacheType> list) {
             this.list = list;
        }

        public int getColumnCount() {
             return columnNames.length;
        }

        public int getRowCount() {
             return list.size();
        }

        public String getColumnName(int col) {
             return columnNames[col];
        }

        public Object getValueAt(int row, int col) {


        	CacheType object = list.get(row);
//             return object;
             switch (col) {
             case 0:
                  return object.getName();
             case 1:
                  return object.getCId();
             case 2:
                  return object.getOwner().getValue();
             case 3:
                  return object.getDatum();
             default:
                  return "unknown";
             }
        }

        public Class getColumnClass(int c) {
             return getValueAt(0, c).getClass();
        }
   }


}
