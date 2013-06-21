package de.odenthma.geocache.utils;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import de.odenthma.geocache.client.MarshallUnmarshall;
import de.odenthma.geocache.generatedclasses.cache.CacheType;

public class FilterCaches {
	private static String NEWPATH = "C:/Users/Mel_T/git/WBA2_P2/geocatching/src/de/odenthma/geocache/xml/CacheListNew.xml";
	
	
	public ArrayList<CacheType> getCachesWithinRange(CacheType ct, double range) throws FileNotFoundException, JAXBException{
		
		ArrayList<CacheType> caches= new MarshallUnmarshall().getCaches(NEWPATH);
		ArrayList<CacheType> newCaches = new ArrayList<CacheType>();
		for(CacheType cache: caches){
			
			if(new CalculatorLatLon().distance(ct.getLocation().getLat(),ct.getLocation().getLon(),
					cache.getLocation().getLat(),cache.getLocation().getLon(), 'K')	< range){
				System.out.println(" cache; "+cache.getCId());
				System.out.println(""+new CalculatorLatLon().distance(ct.getLocation().getLat(),ct.getLocation().getLon(),
						cache.getLocation().getLat(),cache.getLocation().getLon(), 'K'));
			}
		}
		return new ArrayList<CacheType>();
	}
}
