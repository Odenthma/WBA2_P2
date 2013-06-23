package de.odenthma.geocache.client;

import de.odenthma.geocache.generatedclasses.cache.CacheType;

public class CacheTableData {
	private String cache[][] ;
	private String type;
	private String spaltenDetail[] = { "Attribut", "Inhalt"};
	private String spaltenPreview[] = { "Cachename", "ID", "Owner", "Datum"};
	private boolean firstElement = true;
	
	/*
     * erzeugt leere Arrays, welche dann mit Cachedaten befüllt werden
     * 
     * String type -> gibt an welcher Datentyp für diese Instanz verwendet wird
     * preview = Vorschautabelle
     * detail = Volle Cachetabelle
     */
	public CacheTableData(String type){
		this.type = type;
		if(type.equals("preview")){
			cache = new String[1][4];
		}
		else if(type.equals("detail"))
		{
			cache = new String[20][2];
		}
	}
	
	/*
     * gibt den spzifischen Header der Tabelle zurück
     * 
     */
	public String[] getHeader(){
		if(type.equals("preview")){
			return spaltenPreview;
		}
		else if(type.equals("detail"))
		{
			return spaltenDetail;
		}
		return null;
	}
	
	/*
     * Array wird mit Cachedaten befüllt
     * 
     */
	public String[][] fillData(CacheType ct){
		if(type.equals("preview")){
			if(firstElement){
				firstElement = false;
				cache[0][0] = ct.getName();
				cache[0][1] = ct.getCId();
				cache[0][2] = ct.getOwner().getValue();
				cache[0][3] = ct.getTyp().value();
			}
			else{
				String temp[][] = cache;
				cache = new String[temp.length+1][4];
				for(int i = 0; i < temp.length; i++){
					cache[i][0] = temp[i][0];
					cache[i][1] = temp[i][1];
					cache[i][2] = temp[i][2];
					cache[i][3] = temp[i][3];
				}
				cache[cache.length-1][0] = ct.getName();
				cache[cache.length-1][1] = ct.getCId();
				cache[cache.length-1][2] = ct.getOwner().getValue();
				cache[cache.length-1][3] = ct.getTyp().value();
			}
		}
		else if(type.equals("detail"))
		{
			
			cache[0][0] ="Cache ID: ";					cache[0][1] =ct.getCId();
			cache[1][0] ="Location lat: ";				cache[1][1] =ct.getLocation().getLat()+"";
			cache[2][0] ="Location lon: ";				cache[2][1] = ct.getLocation().getLon()+"";
			cache[3][0] ="Name: ";						cache[3][1] = ct.getName();
			cache[4][0] ="Datum: ";						cache[4][1] = ct.getDatum()+"";
			cache[5][0] ="Typ: ";						cache[5][1] = ct.getTyp()+"";
			cache[6][0] ="Owner: ";						cache[6][1] =ct.getOwner().getValue();
			cache[7][0] ="Parkplatz lat: ";				cache[7][1] =ct.getParkplatz().getLat()+"";
			cache[8][0] ="Parkplatz lon: ";				cache[8][1] =ct.getParkplatz().getLon()+"";
			cache[9][0] ="";							cache[9][1] ="";
	    	cache[10][0] ="Schwierigkeit: ";			cache[10][1] =ct.getInformationen().getSchwierigkeit()+"";
	    	cache[11][0] ="Terrain: ";					cache[11][1] =ct.getInformationen().getTerrain()+"";
	    	cache[12][0] ="Land: ";						cache[12][1] =ct.getInformationen().getLand();
	    	cache[13][0] ="Bundesland: ";				cache[13][1] =ct.getInformationen().getBundesland();
	    	cache[14][0] ="Provinz: ";					cache[14][1] =ct.getInformationen().getProvinz();
	    	cache[15][0] ="Beschreibung klein: ";		cache[15][1] =ct.getInformationen().getBeschreibungKlein();
	    	cache[16][0] ="Beschreibung gross: ";		cache[16][1] =ct.getInformationen().getBeschreibungGross();
	    	cache[17][0] ="Hinweise: ";					cache[17][1] =ct.getInformationen().getHinweise();
	    	cache[18][0] ="Travelbug: ";				cache[18][1] =ct.getInformationen().getTravelBug()+"";	
		}	
		return cache;
	}
}
