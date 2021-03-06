//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.12 at 04:28:08 PM MESZ 
//


package de.odenthma.geocache.generatedclasses.cache;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;



/**
 * <p>Java class for CacheType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CacheType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="location">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="lat" use="required" type="{}latRestriction" />
 *                 &lt;attribute name="lon" use="required" type="{}lonRestriction" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Typ" type="{}cacheTypeEnum"/>
 *         &lt;element name="Owner">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="b_id" use="required" type="{}bIdRestriction" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Parkplatz">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="lat" use="required" type="{}latRestriction" />
 *                 &lt;attribute name="lon" use="required" type="{}lonRestriction" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Informationen" type="{}InformationenType"/>
 *         &lt;element name="Logs" type="{}LogsType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Kommentare" type="{}KommentareType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="c_id" use="required" type="{}cIdRestriction" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CacheType", propOrder = {
    "location",
    "name",
    "datum",
    "typ",
    "owner",
    "parkplatz",
    "informationen",
    "logs",
    "kommentare"
})
public class CacheType {

    @XmlElement(required = true)
    protected Location location;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Datum", required = true)
    protected GregorianCalendar datum;
    @XmlElement(name = "Typ", required = true)
    protected CacheTypeEnum typ;
    @XmlElement(name = "Owner", required = true)
    protected Owner owner;
    @XmlElement(name = "Parkplatz", required = true)
    protected Parkplatz parkplatz;
    @XmlElement(name = "Informationen", required = true)
    protected InformationenType informationen;
    @XmlElement(name = "Logs", required = true)
    protected List<LogsType> logs;
    @XmlElement(name = "Kommentare", required = true)
    protected List<KommentareType> kommentare;
    @XmlAttribute(name = "c_id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cId;

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link Location }
     *     
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link Location }
     *     
     */
    public void setLocation(Location value) {
        this.location = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public GregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(GregorianCalendar value) {
        this.datum = value;
    }

    /**
     * Gets the value of the typ property.
     * 
     * @return
     *     possible object is
     *     {@link CacheTypeEnum }
     *     
     */
    public CacheTypeEnum getTyp() {
        return typ;
    }

    /**
     * Sets the value of the typ property.
     * 
     * @param value
     *     allowed object is
     *     {@link CacheTypeEnum }
     *     
     */
    public void setTyp(CacheTypeEnum value) {
        this.typ = value;
    }

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link Owner }
     *     
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link Owner }
     *     
     */
    public void setOwner(Owner value) {
        this.owner = value;
    }

    /**
     * Gets the value of the parkplatz property.
     * 
     * @return
     *     possible object is
     *     {@link Parkplatz }
     *     
     */
    public Parkplatz getParkplatz() {
        return parkplatz;
    }

    /**
     * Sets the value of the parkplatz property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parkplatz }
     *     
     */
    public void setParkplatz(Parkplatz value) {
        this.parkplatz = value;
    }

    /**
     * Gets the value of the informationen property.
     * 
     * @return
     *     possible object is
     *     {@link InformationenType }
     *     
     */
    public InformationenType getInformationen() {
        return informationen;
    }

    /**
     * Sets the value of the informationen property.
     * 
     * @param value
     *     allowed object is
     *     {@link InformationenType }
     *     
     */
    public void setInformationen(InformationenType value) {
        this.informationen = value;
    }

    /**
     * Gets the value of the logs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogsType }
     * 
     * 
     */
    public List<LogsType> getLogs() {
        if (logs == null) {
            logs = new ArrayList<LogsType>();
        }
        return this.logs;
    }

    /**
     * Gets the value of the kommentare property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the kommentare property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKommentare().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KommentareType }
     * 
     * 
     */
    public List<KommentareType> getKommentare() {
        if (kommentare == null) {
            kommentare = new ArrayList<KommentareType>();
        }
        return this.kommentare;
    }

    /**
     * Gets the value of the cId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCId() {
        return cId;
    }

    /**
     * Sets the value of the cId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCId(String value) {
        this.cId = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="lat" use="required" type="{}latRestriction" />
     *       &lt;attribute name="lon" use="required" type="{}lonRestriction" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Location {

        @XmlAttribute(required = true)
        protected double lat;
        @XmlAttribute(required = true)
        protected double lon;

        /**
         * Gets the value of the lat property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public double getLat() {
            return lat;
        }

        /**
         * Sets the value of the lat property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setLat(double value) {
            this.lat = value;
        }

        /**
         * Gets the value of the lon property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public double getLon() {
            return lon;
        }

        /**
         * Sets the value of the lon property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setLon(double value) {
            this.lon = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="b_id" use="required" type="{}bIdRestriction" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Owner {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "b_id", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String bId;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the bId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBId() {
            return bId;
        }

        /**
         * Sets the value of the bId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBId(String value) {
            this.bId = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="lat" use="required" type="{}latRestriction" />
     *       &lt;attribute name="lon" use="required" type="{}lonRestriction" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Parkplatz {

        @XmlValue
        protected String value;
        @XmlAttribute(required = true)
        protected double lat;
        @XmlAttribute(required = true)
        protected double lon;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the lat property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public double getLat() {
            return lat;
        }

        /**
         * Sets the value of the lat property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setLat(double value) {
            this.lat = value;
        }

        /**
         * Gets the value of the lon property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public double getLon() {
            return lon;
        }

        /**
         * Sets the value of the lon property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setLon(double value) {
            this.lon = value;
        }

    }

}
