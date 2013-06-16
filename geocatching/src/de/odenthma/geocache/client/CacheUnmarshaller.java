package de.odenthma.geocache.client;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import de.odenthma.geocache.CacheClasses.CacheListType;

public class CacheUnmarshaller {
	private CacheListType clt;
	private static String ORIGINALPATH = "C:/Users/Mel_T/git/WBA2_P2/geocatching/src/de/odenthma/geocache/xml/testList.xml";
	private static String NEWPATH = "C:/Users/Mel_T/git/WBA2_P2/geocatching/src/de/odenthma/geocache/xml/CacheListNew.xml";
	public CacheListType getCaches() throws JAXBException, FileNotFoundException{
		
		JAXBContext context = JAXBContext.newInstance(CacheListType.class.getPackage().getName());
		Unmarshaller um = context.createUnmarshaller();
		clt = (CacheListType)((JAXBElement<?>)um.unmarshal(new FileReader(NEWPATH))).getValue();
		return clt;
	}
}
