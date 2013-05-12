package de.odenthma.geocache.CacheClasses;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CacheListType", propOrder = {
    "cache"
})
@XmlRootElement(name = "CacheList")
public class CacheListType {

    @XmlElement(name = "Cache", required = true)
    protected List<CacheType> cache;

    public List<CacheType> getCache() {
        if (cache == null) {
            cache = new ArrayList<CacheType>();
        }
        return this.cache;
    }
}
