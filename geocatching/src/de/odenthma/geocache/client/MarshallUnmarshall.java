package de.odenthma.geocache.client;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import de.odenthma.geocache.CacheClasses.CacheListType;
import de.odenthma.geocache.CacheClasses.CacheType;
import de.odenthma.geocache.UserInformation.Classes.UserListType;
import de.odenthma.geocache.UserInformation.Classes.UserType;

public class MarshallUnmarshall {
	private StringWriter sw = new StringWriter();
	private CacheListType clt;
	private UserListType ult;
	private JAXBContext context;
	private Marshaller marshaller;
	private Unmarshaller um;
	private UserType ut;
	
	public boolean writeCacheList(String path, CacheListType clt){
		return true;
	}
	
	public StringWriter writeCache(CacheType ct){
		try {
			context = JAXBContext.newInstance(CacheListType.class.getPackage().getName());
			marshaller = context.createMarshaller();
		    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
		    marshaller.marshal(ct, sw);
		   
		    return sw;
		} 
		catch (JAXBException e) {
			return null;
		}
	}

	public StringWriter writeUser(UserType ut){
		try {
			context = JAXBContext.newInstance(UserType.class.getPackage().getName());
			marshaller = context.createMarshaller();
		    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
		    marshaller.marshal(ut, sw);
		    System.out.println(sw.toString());
		    return sw;
		} 
		catch (JAXBException e) {
			return null;
		}
	}
	
	public ArrayList<CacheType> getCaches(String path) throws JAXBException, FileNotFoundException{
		context = JAXBContext.newInstance(CacheListType.class.getPackage().getName());
		um = context.createUnmarshaller();
		clt = (CacheListType)((JAXBElement<?>)um.unmarshal(new FileReader(path))).getValue();
		return clt.getCache();
	}
	
	public ArrayList<UserType> getUsers(String path) throws JAXBException, FileNotFoundException{
		context = JAXBContext.newInstance(UserListType.class.getPackage().getName());
		um = context.createUnmarshaller();
		ult = (UserListType)(um.unmarshal(new FileReader(path)));
		return ult.getUser();
	}
	
	public UserType getUser(String path) throws JAXBException, FileNotFoundException{
		context = JAXBContext.newInstance(UserType.class.getPackage().getName());
		um = context.createUnmarshaller();
		ut = (UserType)(um.unmarshal(new FileReader(path)));
		return ut;
	}
}
