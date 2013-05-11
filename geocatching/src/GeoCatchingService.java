import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.ws.rs.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import de.odenthma.geocache.CacheClasses.*;
@Path( "/test" )
public class GeoCatchingService {
	
//	@GET @Produces( "text/plain" )
//	public String halloText( @QueryParam("name") String name )
//	{
//		return "Hallo " + name;
//	}
//
//	@GET @Produces( "text/html" )
//	public String halloHtml( @QueryParam("name") String name )
//	{
//	    return "<html><title>HelloWorld</title><body><h2>Html: Hallo asdasdasdasd" + name + "</h2></body></html>";
//	}
//	
	@GET
	@Produces( "application/xml" )
	public CacheListType getAll() throws JAXBException, FileNotFoundException{
		ObjectFactory ob = new ObjectFactory();
		CacheListType clt = ob.createCacheListType();
//		JAXBContext context = JAXBContext.newInstance(CacheListType.class.getPackage().getName());
		JAXBContext context = JAXBContext.newInstance(CacheListType.class.getPackage().getName());
		Unmarshaller um = context.createUnmarshaller();
		clt = (CacheListType)((JAXBElement)um.unmarshal(new FileReader("C:/Users/Mel_T/git/WBA2_P2/geocatching/src/de/odenthma/geocache/xml/CacheList1.xml"))).getValue();
		//user.jaxb.Type myType = (user.jaxb.Type)((javax.xml.bind.JAXBElement) unmarshaller.unmarshal(new File("myXML.xml"))).getValue();
//		clt = (CacheListType)um.unmarshal(new FileReader("C:/Users/Mel_T/git/WBA2_P2/geocatching/src/de/odenthma/geocache/xml/CacheList1.xml"));

		return clt;
	}
}