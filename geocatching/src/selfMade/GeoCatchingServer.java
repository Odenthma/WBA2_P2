package selfMade;
import java.sql.Date;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;




public class GeoCatchingServer {
	public static void main( String[] args ) throws Exception
	   {
			Location location = new Location(20,30);
			location.setLocation("hömel");
	    	Cache c = new Cache();
	    	c.setId("eins");
	    	c.setName("keine ahnung");
	    	c.setLocation(location);
	    	c.setDatum(new Date(20, 10, 1920));
	    	c.setTyp("traditional");
	    	
	    	
	    	
	    	CacheList cl = new CacheList();
	    	cl.setCachess(Arrays.asList( c ));
	    	
	    	JAXBContext context = JAXBContext.newInstance( CacheList.class );
	    	Marshaller m = context.createMarshaller();
	    	m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
	    	m.marshal( cl, System.out );
	   }
}
