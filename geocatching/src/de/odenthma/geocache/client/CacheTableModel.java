package de.odenthma.geocache.client;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import de.odenthma.geocache.CacheClasses.CacheType;

@SuppressWarnings("serial")
public class CacheTableModel extends AbstractTableModel {
    private String[] columnNames = { "Cachename", "ID", "Owner",
              "Datum"};
    private ArrayList<CacheType> list = null;

    public CacheTableModel(ArrayList<CacheType> list) {
         this.list = list;
    }
    
    public void setData(ArrayList<CacheType> list){
    	list.clear();
    	list.addAll(list);
    	fireTableDataChanged();
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

    public Class<? extends Object> getColumnClass(int c) {
         return getValueAt(0, c).getClass();
    }
}