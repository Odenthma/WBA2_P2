package de.odenthma.geocache.grizly;
import com.sun.jersey.api.client.*;


public class GeoCatchingClient {
	public static void main( String[] args )
	   {
	      String url = "http://localhost:4434";
	      url = url + "/cachelist";
	      System.out.println( "URL: " + url );

	      WebResource wrs = Client.create().resource( url );

	      System.out.println( "\nTextausgabe:" );
	      System.out.println( wrs.accept( "application/xml" ).get( String.class ) );
	      System.out.println( "\nHTML-Ausgabe:" );
	      System.out.println( wrs.accept( "text/html"  ).get( String.class ) );
	   }
}
