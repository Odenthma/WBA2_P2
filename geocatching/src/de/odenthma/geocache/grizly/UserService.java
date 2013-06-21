package de.odenthma.geocache.grizly;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import de.odenthma.geocache.CacheClasses.CacheListType;
import de.odenthma.geocache.CacheClasses.CacheType;
import de.odenthma.geocache.UserInformation.Classes.ObjectFactory;
import de.odenthma.geocache.UserInformation.Classes.UserListType;
import de.odenthma.geocache.UserInformation.Classes.UserType;

//TODO: Marshalling in eigene Klasse, damit Code übersichtlicher wird

@Path( "/user" )
public class UserService {
	private static String ORIGINALPATH = "../geocatching/src/de/odenthma/geocache/xml/UserList.xml";
	private static String NEWPATH = "../geocatching/src/de/odenthma/geocache/xml/UserListNew.xml";
	
	File relativeNew = new File(NEWPATH);
	File relativeOld = new File(ORIGINALPATH);
	ObjectFactory ob;
	UserListType  ult;
	
	//alle original Caches
		@GET
		@Produces( "application/xml" )
		public UserListType getAll() throws JAXBException, IOException{
			ob = new ObjectFactory();
			ult = ob.createUserListType();
			JAXBContext context = JAXBContext.newInstance(UserListType.class.getPackage().getName());
			Unmarshaller um = context.createUnmarshaller();

			ult = (UserListType)((JAXBElement<?>)um.unmarshal(new FileReader(relativeOld.getPath()))).getValue();
			
			Marshaller m = context.createMarshaller();
			m.marshal(ult, new FileWriter(NEWPATH));  
			
			return ult;
		}
		
		@GET
		@Path("/new")
		@Produces( "application/xml" )
		public UserListType getAllNew() throws JAXBException, FileNotFoundException{
			JAXBContext context = JAXBContext.newInstance(UserListType.class.getPackage().getName());
			Unmarshaller um = context.createUnmarshaller();
			ult = (UserListType)(um.unmarshal(new FileReader(relativeNew.getPath())));
			Marshaller m = context.createMarshaller();
			m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
			m.marshal( ult, System.out );
			
			return ult;
			
//			JAXBContext context = JAXBContext.newInstance(CacheListType.class.getPackage().getName());
//			Unmarshaller um = context.createUnmarshaller();
//			clt = (CacheListType)((JAXBElement<?>)um.unmarshal(new FileReader(relativeNew.getPath()))).getValue();
//			Marshaller m = context.createMarshaller();
//			m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
//			m.marshal( clt, System.out );
//			
//			return clt;
		}
		
		
		/*
		 * Username and password check
		 * UserXML wird zurück gesendet, da diese vom eingeloggten User bearbeitet werden kann
		 */
		@GET
		@Path("/{user}/{password}")
		@Produces( "application/xml" )
		public UserType checkUser(@PathParam("user") String user, @PathParam("password") String password) throws JAXBException, FileNotFoundException{
			JAXBContext context = JAXBContext.newInstance(UserListType.class.getPackage().getName());
			Unmarshaller um = context.createUnmarshaller();
			ult = (UserListType)(um.unmarshal(new FileReader(relativeNew.getPath())));
			UserType ut = null;
			
			for(UserType userThis: ult.getUser()){
				if(user.equals(userThis.getAccount().getLogInName()) && password.equals(userThis.getAccount().getLogInPW()))
					ut = userThis;
			}

			return ut;
		}
		
		@POST
		   @Path("/new")
		   @Produces("application/xml")
		   public UserType postNew(String incomingXML) throws JAXBException, IOException {   
			   UserListType user = getAllNew();
			   UserType ut = (UserType)unmarshall(incomingXML, UserType.class);
			   user.addUser(ut);
				
				   JAXBContext contexts= JAXBContext.newInstance(UserListType.class);
				   Marshaller m = contexts.createMarshaller();
				   m.marshal(user, new FileWriter(relativeNew.getPath()));   
			return ut;
//			return null;
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
}
