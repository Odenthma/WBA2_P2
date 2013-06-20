package de.odenthma.geocache.client;

import java.io.File;

public class PathHandler {
	public static String ORIGINALPATH = "../geocatching/src/de/odenthma/geocache/xml/";
	public static String NEWPATH = "../geocatching/src/de/odenthma/geocache/xml/";
	
	File relativeNew = new File(NEWPATH);
	File relativeOld = new File(ORIGINALPATH);
	String file;
	
	public String getPath (String file){
		
		return relativeOld.getPath()+file;
	}
}
