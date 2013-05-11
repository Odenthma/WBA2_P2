//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.09 at 09:00:25 PM MESZ 
//


package de.odenthma.geocache.CacheClasses;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import de.odenthma.geocache.CacheClasses.CacheType.Location;
import de.odenthma.geocache.CacheClasses.CacheType.Owner;
import de.odenthma.geocache.CacheClasses.CacheType.Parkplatz;
import de.odenthma.geocache.CacheClasses.KommentarType.Autor;
import de.odenthma.geocache.CacheClasses.KommentareType.Kommentar;
import de.odenthma.geocache.CacheClasses.LogType.GefundenVon;
import de.odenthma.geocache.CacheClasses.LogsType.Log;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.odenthma.geocache package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CacheList_QNAME = new QName("", "CacheList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.odenthma.geocache
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CacheType }
     * 
     */
    public CacheType createCacheType() {
        return new CacheType();
    }

    /**
     * Create an instance of {@link KommentarType }
     * 
     */
    public KommentarType createKommentarType() {
        return new KommentarType();
    }

    /**
     * Create an instance of {@link CacheListType }
     * 
     */
    public CacheListType createCacheListType() {
        return new CacheListType();
    }

    /**
     * Create an instance of {@link InformationenType }
     * 
     */
    public InformationenType createInformationenType() {
        return new InformationenType();
    }

    /**
     * Create an instance of {@link Autor }
     * 
     */
    public Autor createKommentarTypeAutor() {
        return new Autor();
    }

    /**
     * Create an instance of {@link GefundenVon }
     * 
     */
    public GefundenVon createLogTypeGefundenVon() {
        return new GefundenVon();
    }

    /**
     * Create an instance of {@link LogType }
     * 
     */
    public LogType createLogType() {
        return new LogType();
    }

    /**
     * Create an instance of {@link Location }
     * 
     */
    public Location createCacheTypeLocation() {
        return new Location();
    }

    /**
     * Create an instance of {@link Kommentar }
     * 
     */
    public Kommentar createKommentareTypeKommentar() {
        return new Kommentar();
    }

    /**
     * Create an instance of {@link Owner }
     * 
     */
    public Owner createCacheTypeOwner() {
        return new Owner();
    }

    /**
     * Create an instance of {@link LogsType }
     * 
     */
    public LogsType createLogsType() {
        return new LogsType();
    }

    /**
     * Create an instance of {@link KommentareType }
     * 
     */
    public KommentareType createKommentareType() {
        return new KommentareType();
    }

    /**
     * Create an instance of {@link Log }
     * 
     */
    public Log createLogsTypeLog() {
        return new Log();
    }

    /**
     * Create an instance of {@link Parkplatz }
     * 
     */
    public Parkplatz createCacheTypeParkplatz() {
        return new Parkplatz();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CacheListType }{@code >}}
     * 
     */
    @XmlElementDecl( name = "CacheList")
    public JAXBElement<CacheListType> createCacheList(CacheListType value) {
        return new JAXBElement<CacheListType>(_CacheList_QNAME, CacheListType.class, null, value);
    }

}
