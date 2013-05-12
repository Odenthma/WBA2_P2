package de.odenthma.geocache.grizly;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.ws.rs.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import de.odenthma.geocache.CacheClasses.*;

@Path( "/cachelist" )
public class GeoCatchingCacheService {

	private static String ORIGINALPATH = "C:/Users/Mel_T/git/WBA2_P2/geocatching/src/de/odenthma/geocache/xml/testList.xml";
	private static String NEWPATH = "C:/Users/Mel_T/git/WBA2_P2/geocatching/src/de/odenthma/geocache/xml/CacheListNew.xml";
	ObjectFactory ob;
	CacheListType  clt;
	
	//alle original Caches
	@GET
	@Produces( "application/xml" )
	public CacheListType getAll() throws JAXBException, IOException{
		ob = new ObjectFactory();
		clt = ob.createCacheListType();
		JAXBContext context = JAXBContext.newInstance(CacheListType.class.getPackage().getName());
		Unmarshaller um = context.createUnmarshaller();
		clt = (CacheListType)((JAXBElement<?>)um.unmarshal(new FileReader(ORIGINALPATH))).getValue();
		
		
		Marshaller m = context.createMarshaller();
		m.marshal(clt, new FileWriter(NEWPATH));  
		
		return clt;
	}
	//alle Originalcaches anhand ID gefiltert
	   @GET
	   @Path("/filter")
	   @Produces("application/xml")
	   public CacheListType filter( @QueryParam("id") int id) throws JAXBException, IOException {   
		   CacheListType caches = getAll();
		   CacheListType ergebnisse = new CacheListType();
		   ergebnisse.getCache().add(caches.getCache().get(id));
		return ergebnisse;
	   }
	   
	 //alle Testcaches
	@GET
	@Path("/new")
	@Produces( "application/xml" )
	public CacheListType getAllNew() throws JAXBException, FileNotFoundException{
		JAXBContext context = JAXBContext.newInstance(CacheListType.class.getPackage().getName());
		Unmarshaller um = context.createUnmarshaller();
		clt = (CacheListType)((JAXBElement<?>)um.unmarshal(new FileReader(NEWPATH))).getValue();
		Marshaller m = context.createMarshaller();
		m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
		m.marshal( clt, System.out );
		
		return clt;
	}
	
	//neuen Cache zu Testcaches
		@POST
	   @Path("/new")
	   @Produces("application/xml")
	   public CacheListType postNew( @QueryParam("id") int id) throws JAXBException, IOException {   
		   CacheListType caches = getAllNew();
		   
		   caches.getCache().add(caches.getCache().get(id));
		   
		   JAXBContext context= JAXBContext.newInstance(CacheListType.class);
		   Marshaller m = context.createMarshaller();
		   m.marshal(caches, new FileWriter(NEWPATH));        
		   
		return caches;
	   }
	
		//Cache in Testcaches anhand ID löschen
	   @DELETE
	   @Path("/delete")
	   @Produces("application/xml")
	   public CacheListType delete( @QueryParam("id") int id) throws JAXBException, IOException {   
		   CacheListType caches = getAllNew();
		   caches.getCache().remove(id);

		   JAXBContext context= JAXBContext.newInstance(CacheListType.class);
		   Marshaller m = context.createMarshaller();
		   m.marshal(caches, new FileWriter(NEWPATH));        

		return caches;
	   }
	   
	   @DELETE
	   @Path("{id}:{name}")
	   @Produces("application/xml")
	   public CacheListType deletePath( @PathParam("id") int id, @PathParam("name") String name) throws JAXBException, IOException {   
		  System.out.println("ID: "+id+" Name: "+name);
		   
		   CacheListType caches = getAllNew();
		   caches.getCache().remove(id);

		   JAXBContext context= JAXBContext.newInstance(CacheListType.class);
		   Marshaller m = context.createMarshaller();
		   m.marshal(caches, new FileWriter(NEWPATH));        

		return caches;
	   }

}