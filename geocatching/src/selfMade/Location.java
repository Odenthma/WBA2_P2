package selfMade;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Location {
	public Location(){
	 } 
	
	public Location(int lat, int lon){
		 this.lat = lat;
		 this.lon = lon;
	 }
	@XmlAttribute
	 int lat, lon;
	 
	
	 String location;
	 
	 public String getLocation(){ return location; }
	 public void setLocation(String location){ this.location = location; }
	 
}