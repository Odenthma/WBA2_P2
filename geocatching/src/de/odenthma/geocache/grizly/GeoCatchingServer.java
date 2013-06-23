package de.odenthma.geocache.grizly;
import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyServerFactory;

import de.odenthma.geocache.client.Globals;
import de.odenthma.geocache.xmppstuff.ConnectionHandler;
import de.odenthma.geocache.xmppstuff.PubSub;

public class GeoCatchingServer {
	public static void main( String[] args ) throws Exception
	   {
	      String server =  "localhost";
	      int restPort = 4434;
	      int xmppPort = 5222;
	      SelectorThread srv = GrizzlyServerFactory.create("http://"+server+":"+restPort );
//	      PubSub pb = new PubSub();
	      ConnectionHandler pubsub_man = new ConnectionHandler();
	      pubsub_man.connect(server, xmppPort);
	      
	      try{
	    	  if(!pubsub_man.register("publisher", "publisher"))
	    			  System.out.println("User schon vorhanden");
	    	  else 
	    		  System.out.println("User \"publisher\n registriert");
	      }
	      finally{
	    	  pubsub_man.disconnect();
	      }
	      
	      System.out.println( "URL: " + "http://"+server+":"+restPort );
	      Thread.sleep( 1000 * 60 * 10 );
	      srv.stopEndpoint();
	   }
}
