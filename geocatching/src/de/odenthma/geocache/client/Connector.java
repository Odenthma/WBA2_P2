package de.odenthma.geocache.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import de.odenthma.geocache.UserInformation.Classes.UserType;

public class Connector {
	private URL url;
	private HttpURLConnection rc;
	private String reqStr;
	private int len;
	private OutputStreamWriter out;
	private InputStreamReader read;
	private StringBuilder sb = new StringBuilder();
	private int ch;
	private String response;
	
	public void sendRequestAndData(StringWriter sw) throws IOException{
		System.out.println("Start sending  request");  
		url = new URL( "http://localhost:4434/cachelist/new" ); 
		rc = (HttpURLConnection)url.openConnection();
		   
		rc.setRequestMethod("POST");  
		rc.setDoOutput( true );  
		rc.setDoInput( true );   
		rc.setRequestProperty( "Content-Type", "text/xml; charset=utf-8" );  
		reqStr = sw.toString();
		len = reqStr.length();  
		rc.setRequestProperty( "Content-Length", Integer.toString( len ) );  
		rc.connect();      
		out = new OutputStreamWriter( rc.getOutputStream() );   
		out.write( reqStr, 0, len );  
		out.flush();  
		System.out.println("Request sent, reading response ");  
		read = new InputStreamReader( rc.getInputStream() );  
		System.out.println("response:/n/n/n/n/n/n ");
		ch = read.read();
		 
		while( ch != -1 ){  
			sb.append((char)ch);  
			ch = read.read();  
		}  
		 
		response = sb.toString(); 
		read.close();  
		rc.disconnect();  
		System.out.println("response: "+response);
	}
	public void createUser(StringWriter sw) throws IOException{
		System.out.println("Start sending  request");  
		url = new URL( "http://localhost:4434/user/new" ); 
		rc = (HttpURLConnection)url.openConnection();
		   
		rc.setRequestMethod("POST");  
		rc.setDoOutput( true );  
		rc.setDoInput( true );   
		rc.setRequestProperty( "Content-Type", "text/xml; charset=utf-8" );  
		reqStr = sw.toString();
		len = reqStr.length();  
		rc.setRequestProperty( "Content-Length", Integer.toString( len ) );  
		rc.connect();      
		out = new OutputStreamWriter( rc.getOutputStream() );   
		out.write( reqStr, 0, len );  
		out.flush();  
		System.out.println("Request sent, reading response ");  
		read = new InputStreamReader( rc.getInputStream() );  
		System.out.println("response:/n/n/n/n/n/n ");
		ch = read.read();
		 
		while( ch != -1 ){  
			sb.append((char)ch);  
			ch = read.read();  
		}  
		 
		response = sb.toString(); 
		read.close();  
		rc.disconnect();  
		System.out.println("response: "+response);
	}
	  public UserType getUser(String user, String password) throws IOException, JAXBException{
		  String uri =
				    "http://localhost:4434/user/"+user+"/"+password;
		  URL url = new URL(uri);
		  HttpURLConnection connection =
				    (HttpURLConnection) url.openConnection();
		  connection.setRequestMethod("GET");
		  connection.setRequestProperty("Accept", "application/xml");

		  JAXBContext jc = JAXBContext.newInstance(UserType.class);
		  InputStream xml = connection.getInputStream();
		  UserType ut =
				  (UserType) jc.createUnmarshaller().unmarshal(xml);
		
		  connection.disconnect();
		  
		  return ut;
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
