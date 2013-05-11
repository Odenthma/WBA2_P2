package selfMade;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


public class Cache {

	
	private String id;
	private String name;
	private Location location;
	private Date datum;
	private String typ;
	
	@XmlAttribute
	public String getId(){ return id; }
	public void setId(String id){ this.id = id; }
	
	public String getName(){ return name; }
	public void setName(String name){ this.name = name; }
	
	public Location getLocation() {return location;}
    public void setLocation(Location value) {this.location = value;}
    
    public Date getDatum(){ return datum; }
    public void setDatum(Date datum){ this.datum = datum; }
    
    public String getTyp(){ return typ; }
    public void setTyp(String typ){ this.typ = typ; }
	
	
}
