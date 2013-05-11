package selfMade;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


	@XmlRootElement( )
	public class CacheList
	{
	  private List<Cache> caches = new ArrayList<Cache>();

	  @XmlElement( name = "cache" )
	  public List<Cache> getCachess()
	  {
	    return caches;
	  }

	  public void setCachess( List<Cache> caches )
	  {
	    this.caches = caches;
	  }
	}