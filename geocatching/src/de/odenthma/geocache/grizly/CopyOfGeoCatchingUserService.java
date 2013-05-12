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

import de.odenthma.geocache.UserInformation.Classes.*;

@Path( "/userlist" )
public class CopyOfGeoCatchingUserService {

	private static String ORIGINALPATH = "C:/Users/Mel_T/git/WBA2_P2/geocatching/src/de/odenthma/geocache/xml/UserList.xml";
	private static String NEWPATH = "C:/Users/Mel_T/git/WBA2_P2/geocatching/src/de/odenthma/geocache/xml/UserListNew.xml";
	ObjectFactory ob;
	UserListType  ult;
	
	//alle original user
	@GET
	@Produces( "application/xml" )
	public UserListType getAll() throws JAXBException, IOException{
		ob = new ObjectFactory();
		ult = ob.createUserListType();
		JAXBContext context = JAXBContext.newInstance(UserListType.class.getPackage().getName());
		Unmarshaller um = context.createUnmarshaller();
		ult = (UserListType)((JAXBElement<?>)um.unmarshal(new FileReader(ORIGINALPATH))).getValue();

		Marshaller m = context.createMarshaller();
		m.marshal(ult, new FileWriter(NEWPATH));  
		
		return ult;
	}
	//alle Originaluser anhand ID gefiltert
	   @GET
	   @Path("/filter")
	   @Produces("application/xml")
	   public UserListType filter( @QueryParam("id") String id) throws JAXBException, IOException {   
		   UserListType users = getAll();
		   UserListType ergebnisse = new UserListType();
		   for(UserType ut : users.getUser()){
			   if(ut.getBId().equals(id))
				   ergebnisse.getUser().add(ut);
		   }
		  
		return ergebnisse;
	   }
	   
	 //alle testuser
	@GET
	@Path("/new")
	@Produces( "application/xml" )
	public UserListType getAllNew() throws JAXBException, FileNotFoundException{
		JAXBContext context = JAXBContext.newInstance(UserListType.class.getPackage().getName());
		Unmarshaller um = context.createUnmarshaller();
		ult = (UserListType)um.unmarshal(new FileReader(NEWPATH));
		Marshaller m = context.createMarshaller();
		m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
		m.marshal( ult, System.out );
		
		return ult;
	}
	
	//neuen User zu testlist
		@POST
	   @Path("/new")
	   @Produces("application/xml")
	   public UserListType postNew( @QueryParam("id") String id) throws JAXBException, IOException {   
			UserListType users = getAllNew();
			
			for(UserType ut : users.getUser()){
				   if(ut.getBId().equals(id))
					   users.getUser().add(ut);
			}
		   
		   
		   JAXBContext context= JAXBContext.newInstance(UserListType.class);
		   Marshaller m = context.createMarshaller();
		   m.marshal(users, new FileWriter(NEWPATH));        
		   
		return users;
	   }
	
		//User in testlist anhand ID löschen
	   @DELETE
	   @Path("/delete")
	   @Produces("application/xml")
	   public UserListType delete( @QueryParam("id") String id) throws JAXBException, IOException {   
		   UserListType users = getAllNew();

		   for(UserType ut : users.getUser()){
			   if(ut.getBId().equals(id))
				   users.getUser().remove(users.getUser().indexOf(ut));
			   
		}

		   JAXBContext context= JAXBContext.newInstance(UserListType.class);
		   Marshaller m = context.createMarshaller();
		   m.marshal(users, new FileWriter(NEWPATH));        

		return users;
	   }
	   
	   @DELETE
	   @Path("{id}:{name}")
	   @Produces("application/xml")
	   public UserListType deletePath( @PathParam("id") int id, @PathParam("name") String name) throws JAXBException, IOException {   
		  System.out.println("ID: "+id+" Name: "+name);
		   
		  UserListType users = getAllNew();
		  users.getUser().remove(id);

		   JAXBContext context= JAXBContext.newInstance(UserListType.class);
		   Marshaller m = context.createMarshaller();
		   m.marshal(users, new FileWriter(NEWPATH));        

		return users;
	   }

}