package de.odenthma.geocache.grizly;
import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyServerFactory;

import de.odenthma.geocache.utils.ServerAdress;
import de.odenthma.geocache.xmppstuff.ConnectionHandler;

public class GeoCatchingServer {
	public static void main( String[] args ) throws Exception
	   {

	      SelectorThread srv = GrizzlyServerFactory.create("http://"+ServerAdress.HOST+":"+ServerAdress.restPort );
	      ConnectionHandler pubsub_man = new ConnectionHandler();
	      pubsub_man.connect(ServerAdress.HOST, ServerAdress.xmppPort);
	      
	      try{
	    	  if(!pubsub_man.register("publisher", "publisher"))
	    			  System.out.println("User schon vorhanden");
	    	  else 
	    		  System.out.println("User \"publisher\n registriert");
	      }
	      finally{
	    	  pubsub_man.disconnect();
	      }
	      
	      System.out.println( "URL: " + "http://"+ServerAdress.HOST+":"+ServerAdress.restPort );
	      Thread.sleep( 1000 * 60 * 10 );
	      srv.stopEndpoint();
	   }
}
