package selfMade;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAttribute;


public class Cache {

	private String id;
	private String name;
	Location location;
	
	public String getId(){ return id; }
	public void setId(String id){ this.id = id; }
	
	public String getName(){ return name; }
	public void setName(String name){ this.name = name; }
	s
	public Location getLocation() {return location;}
    public void setLocation(Location value) {this.location = value;}
	
	 public static class Location {
	        @XmlAttribute(required = true)
	        int lat;
	        @XmlAttribute(required = true)
	        int lon;

	        public int getLat() { return lat;}
	        public void setLat(int i) {this.lat = i;}

	        public int getLon() {return lon;}
	        public void setLon(int i) {this.lon = i;}

	    }
}
