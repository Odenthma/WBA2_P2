//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.12 at 07:53:57 PM MESZ 
//


package de.odenthma.geocache.UserInformation.Classes;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for ortsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ortsType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="lat" use="required" type="{}latRestriction" />
 *       &lt;attribute name="lon" use="required" type="{}lonRestriction" />
 *       &lt;attribute name="postal" use="required" type="{}postalRestriction" />
 *       &lt;attribute name="umkreis" use="required" type="{}rangeRestriction" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ortsType", propOrder = {
    "value"
})
public class OrtsType {

    @XmlValue
    protected String value;
    @XmlAttribute(required = true)
    protected BigDecimal lat;
    @XmlAttribute(required = true)
    protected BigDecimal lon;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String postal;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String umkreis;

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
    public BigDecimal getLat() {
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
    public void setLat(BigDecimal value) {
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
    public BigDecimal getLon() {
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
    public void setLon(BigDecimal value) {
        this.lon = value;
    }

    /**
     * Gets the value of the postal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostal() {
        return postal;
    }

    /**
     * Sets the value of the postal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostal(String value) {
        this.postal = value;
    }

    /**
     * Gets the value of the umkreis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUmkreis() {
        return umkreis;
    }

    /**
     * Sets the value of the umkreis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUmkreis(String value) {
        this.umkreis = value;
    }

}