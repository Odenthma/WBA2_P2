package de.odenthma.geocache.grizly;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.JAXBException;

import de.odenthma.geocache.client.MarshallUnmarshall;
import de.odenthma.geocache.generatedclasses.cache.CacheListType;
import de.odenthma.geocache.generatedclasses.cache.CacheType;
import de.odenthma.geocache.generatedclasses.cache.CacheTypeEnum;
import de.odenthma.geocache.utils.CalculatorLatLon;
import de.odenthma.geocache.utils.Filter;

public class FilterCaches {
	private static String NEWPATH = "../geocatching/src/de/odenthma/geocache/xml/CacheListNew.xml";
	
	public CacheListType filter(CacheListType caches, String s)
	{
		
		ArrayList<CacheType> filtered = new ArrayList<CacheType>();
		String[] komplett;
		String[] kriterien;
		String[] values;
		
		String delimiter1="!";
		String delimiter2="§";
		komplett=s.split(delimiter1);
		System.out.println(komplett[0]);
		System.out.println(komplett[1]);
		kriterien=komplett[0].split(delimiter2);
		System.out.println(kriterien.toString());
		values=komplett[1].split(delimiter2);
		System.out.println(values.toString());
		
		HashMap<String,String> filtermap = new HashMap<String,String>(); 
		
		for(int i=0; i<kriterien.length; i++)
			filtermap.put(kriterien[i], values[i]);
		int counter;

		CacheListType bla = caches;
		ArrayList<CacheType> cl = bla.getCache();
		
		for(CacheType cache : cl){
			counter = 0;
			if(filtermap.get(Filter.DISTANCE) != null)
				if(new CalculatorLatLon().distance(
						Double.parseDouble(filtermap.get(Filter.LAT)),
						Double.parseDouble(filtermap.get(Filter.LON)), 
						cache.getLocation().getLat(), 
						cache.getLocation().getLon(),
						'K')<Double.parseDouble(filtermap.get(Filter.DISTANCE))){ counter++; System.out.println("map: "+filtermap.get(Filter.CACHETYPE)+" cache: "+cache.getTyp());}
			
			if(filtermap.get(Filter.CACHETYPE) != null){
				if(filtermap.get(Filter.CACHETYPE).equals(cache.getTyp().toString())){ 
					System.out.println("map: "+filtermap.get(Filter.CACHETYPE)+"cache: "+cache.getTyp().toString());
					counter++; 
				}
			}
			if(filtermap.get(Filter.SCHWIERIGKEIT)!= null)
				if(Double.parseDouble(filtermap.get(Filter.SCHWIERIGKEIT)) >= 
					cache.getInformationen().getSchwierigkeit()){ counter++; System.out.println("map: "+filtermap.get(Filter.CACHETYPE)+" cache: "+cache.getTyp());}
			
			if(filtermap.get(Filter.TERRAIN) != null)
				if(Double.parseDouble(filtermap.get(Filter.TERRAIN)) >=
					cache.getInformationen().getTerrain()){ counter++; System.out.println("map: "+filtermap.get(Filter.CACHETYPE)+" cache: "+cache.getTyp());}
			
			if(filtermap.get(Filter.DAUER) != null)
				if(Double.parseDouble(filtermap.get(Filter.DAUER)) >=
					cache.getInformationen().getGeschaetzteZeit()){ counter++; System.out.println("map: "+filtermap.get(Filter.CACHETYPE)+" cache: "+cache.getTyp());}
			
			if(filtermap.get(Filter.TRAVELBUG) != null)
				if(filtermap.get(Filter.TRAVELBUG).toLowerCase().equals(cache.getInformationen().getTravelBug())){ counter++; System.out.println("map: "+filtermap.get(Filter.CACHETYPE)+" cache: "+cache.getTyp());}
			
			
			if(counter == filtermap.size()) 
				filtered.add(cache);
		}	
		CacheListType clt = new CacheListType();
		clt.setCacheList(filtered);
		return clt;
		
	}
		
	public ArrayList<CacheType> getCachesWithinRange(CacheType ct, double range) throws FileNotFoundException, JAXBException{
		
		ArrayList<CacheType> caches= new MarshallUnmarshall().getCaches(NEWPATH);
		ArrayList<CacheType> newCaches = new ArrayList<CacheType>();
		for(CacheType cache: caches){
			
			if(new CalculatorLatLon().distance(ct.getLocation().getLat(),ct.getLocation().getLon(),
					cache.getLocation().getLat(),cache.getLocation().getLon(), 'K')	< range){
				System.out.println(" cache; "+cache.getCId());
				System.out.println(""+new CalculatorLatLon().distance(ct.getLocation().getLat(),ct.getLocation().getLon(),
						cache.getLocation().getLat(),cache.getLocation().getLon(), 'K'));
				newCaches.add(cache);
			}
		}
		return newCaches;
	}
}
