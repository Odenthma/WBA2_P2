package selfMade;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;


public class GeoCatchingServer {
	public static void main( String[] args ) throws Exception
	   {
	    	Cache c = new Cache();
	    	c.setId("eins");
	    	c.setName("keine ahnung");
	    	CacheList cl = new CacheList();
	    	cl.setCachess(Arrays.asList( c ));
	    	
	    	JAXBContext context = JAXBContext.newInstance( CacheList.class );

	    	Marshaller m = context.createMarshaller();

	    	m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );

	    	m.marshal( cl, System.out );
	   }
}
