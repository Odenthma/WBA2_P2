//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.09 at 09:00:25 PM MESZ 
//


package de.odenthma.geocache.CacheClasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.odenthma.geocache.CacheClasses.KommentareType.Kommentar;


/**
 * <p>Java class for KommentareType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KommentareType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Kommentar">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.w3schools.com}KommentarType">
 *                 &lt;attribute name="k_id" use="required" type="{http://www.w3schools.com}kIdRestriction" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KommentareType", propOrder = {
    "kommentar"
})
public class KommentareType {

    @XmlElement(name = "Kommentar", namespace = "http://www.w3schools.com", required = true)
    protected Kommentar kommentar;

    /**
     * Gets the value of the kommentar property.
     * 
     * @return
     *     possible object is
     *     {@link Kommentar }
     *     
     */
    public Kommentar getKommentar() {
        return kommentar;
    }

    /**
     * Sets the value of the kommentar property.
     * 
     * @param value
     *     allowed object is
     *     {@link Kommentar }
     *     
     */
    public void setKommentar(Kommentar value) {
        this.kommentar = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.w3schools.com}KommentarType">
     *       &lt;attribute name="k_id" use="required" type="{http://www.w3schools.com}kIdRestriction" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Kommentar
        extends KommentarType
    {

        @XmlAttribute(name = "k_id", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String kId;

        /**
         * Gets the value of the kId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKId() {
            return kId;
        }

        /**
         * Sets the value of the kId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKId(String value) {
            this.kId = value;
        }

    }

}