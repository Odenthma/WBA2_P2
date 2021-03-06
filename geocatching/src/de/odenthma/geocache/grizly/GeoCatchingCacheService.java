package de.odenthma.geocache.grizly;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.ws.rs.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.jivesoftware.smack.XMPPException;

import de.odenthma.geocache.generatedclasses.cache.*;
import de.odenthma.geocache.xmppstuff.ConnectionHandler;

@Path( "/cachelist" )
public class GeoCatchingCacheService {

	private static String ORIGINALPATH = "../geocatching/src/de/odenthma/geocache/xml/testList.xml";
	private static String NEWPATH = "../geocatching/src/de/odenthma/geocache/xml/CacheListNew.xml";
	File relativeNew = new File(NEWPATH);
	File relativeOld = new File(ORIGINALPATH);
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
		clt = (CacheListType)((JAXBElement<?>)um.unmarshal(new FileReader(relativeOld.getPath()))).getValue();

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
		clt = (CacheListType)((JAXBElement<?>)um.unmarshal(new FileReader(relativeNew.getPath()))).getValue();
		Marshaller m = context.createMarshaller();
		m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
		m.marshal( clt, System.out );
		
		return clt;
	}
	
	public void handleNodes(CacheType ct) {
		ConnectionHandler pubsub_man = new ConnectionHandler();
		ArrayList<String> allNodes = new ArrayList<String>();
		pubsub_man.connect("localhost", 5222);
		pubsub_man.login("publisher", "publisher");			

		allNodes = (ArrayList<String>) pubsub_man.getAllNodes();

		for(String node : allNodes){
			String[] temp;
			String delimiter = ":";
			temp = node.split(delimiter);
//			System.out.println("Connected: "+pubsub_man.getHost()+" "+pubsub_man.getUsername());
			if(temp.length==4){
				System.out.println(""+temp.length+"nodename: "+"CACHE:"+temp[1]+":"+temp[2]+":"+temp[3]+" realnode; "+node);
				if(node.equals("CACHE:"+temp[1]+":"+temp[2]+":"+temp[3])){
					System.out.println("asdasdaw"+node);
				System.out.println("lat: "+temp[1]+" lon:"+temp[2]+" range: "+temp[3]);
				String payload = "<location><item><push kategorie=\"" + node + "\" titel=\"" + ct.getCId() + "\" datum=\"" + ct.getDatum() + "\" lat=\"" + ct.getLocation().getLat() + "\" lon=\"" + ct.getLocation().getLon()  +"\"></push></item></location>";
				pubsub_man.publishWithPayload(node, payload);
				}
			}	  	
			System.out.println("node:"+node);
		}
		pubsub_man.disconnect();
	}

	@POST
	@Path("/new")
	@Produces("application/xml")
	public CacheType postNew(String incomingXML) throws JAXBException, IOException {   
		CacheListType caches = getAllNew();
		CacheType ct = (CacheType)unmarshall(incomingXML, CacheType.class);
		caches.addCache(ct);
		
//		handleNodes(ct);
		
		JAXBContext contexts= JAXBContext.newInstance(CacheListType.class);
		Marshaller m = contexts.createMarshaller();
		m.marshal(caches, new FileWriter(relativeNew.getPath()));   
		return ct;
	}
		//Cache in Testcaches anhand ID l�schen
	   
	@DELETE
	   @Path("/new/delete/{id}")
	   @Produces("application/xml")
	   public CacheListType delete( @PathParam("id") String id) throws JAXBException, IOException {   
		   System.out.println("DELETE: ID: "+id);
		   CacheType delete = new CacheType();
		   CacheListType caches = getAllNew();
		   for(CacheType ct : caches.getCache()){
			   if(id.equals(ct.getCId()))
				   delete = ct;   
		   }
		   
		   caches.getCache().remove(delete);

		   JAXBContext context= JAXBContext.newInstance(CacheListType.class);
		   Marshaller m = context.createMarshaller();
		   m.marshal(caches, new FileWriter(relativeNew.getPath()));        

		   return caches;
	   }
	
	@GET
	@Path("/new/filter/{filter}")
	   @Produces("application/xml")
	   public CacheListType filterCache( @PathParam("filter") String filter) throws JAXBException, IOException {   
		   CacheListType caches = new FilterCaches().filter(getAllNew(), filter);     
		   return caches;
	   }
	
	   private Object unmarshall(String str, Class<?> c) {
			Object element = null;
			try {
				JAXBContext context = JAXBContext.newInstance(c);
				Unmarshaller um = context.createUnmarshaller();
				element = um.unmarshal(new StreamSource(new StringReader(str)), c).getValue();
			} catch (JAXBException e) {
				e.printStackTrace();
			}

			return element;
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
		   m.marshal(caches, new FileWriter(relativeNew.getPath()));        

		return caches;
	   }

}