package de.odenthma.geocache.client;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Connector {
	URL url;
	HttpURLConnection rc;
	String reqStr;
	  int len;
	  OutputStreamWriter out;
	  InputStreamReader read;
	  StringBuilder sb = new StringBuilder();
	  int ch;
	  String response;
	
	  public void sendRequestAndData(StringWriter sw) throws IOException{
		 System.out.println("Start sending  request");  
		 url = new URL( "http://localhost:4434/cachelist/new" ); 
		 rc = (HttpURLConnection)url.openConnection();
		   
		 rc.setRequestMethod("POST");  
		 rc.setDoOutput( true );  
		 rc.setDoInput( true );   
		 rc.setRequestProperty( "Content-Type", "text/xml; charset=utf-8" );  
		 reqStr = sw.toString();  // the entire payload in a single String  
		 len = reqStr.length();  
		 rc.setRequestProperty( "Content-Length", Integer.toString( len ) );  
		 rc.connect();      
		 out = new OutputStreamWriter( rc.getOutputStream() );   
		 out.write( reqStr, 0, len );  
		 out.flush();  
		 System.out.println("Request sent, reading response ");  
		 read = new InputStreamReader( rc.getInputStream() );  
		     
		 ch = read.read();
		 
		 while( ch != -1 ){  
			 sb.append((char)ch);  
			 ch = read.read();  
		 }  
		 
		 response = sb.toString(); // entire response ends up in String  
		 read.close();  
		 rc.disconnect();  
		 System.out.println("response: "+response);
	}
	  
	  public void sendRequestAndDeleteCache(String id) throws IOException{
		  System.out.println("Start sending  request");  
			 url = new URL( "http://localhost:4434/cachelist/new/delete/"+id ); 
			 rc = (HttpURLConnection)url.openConnection();
			   
			  
			 rc.setDoOutput( true );    
			 rc.setRequestProperty( "Content-Type", "text/xml; charset=utf-8" );  
			 rc.setRequestMethod("DELETE"); 
  
			     int responseCode = rc.getResponseCode();
			     System.out.println("CODE: "+responseCode);

			 rc.disconnect();  
	  }

}
