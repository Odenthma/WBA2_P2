//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.12 at 04:28:08 PM MESZ 
//


package de.odenthma.geocache.CacheClasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;



/**
 * <p>Java class for LogsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Log">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{}logType">
 *                 &lt;attribute name="l_id" use="required" type="{}lIdRestriction" />
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
@XmlType(name = "LogsType", propOrder = {
    "log"
})
public class LogsType {

    @XmlElement(name = "Log", required = true)
    protected Log log;

    /**
     * Gets the value of the log property.
     * 
     * @return
     *     possible object is
     *     {@link Log }
     *     
     */
    public Log getLog() {
        return log;
    }

    /**
     * Sets the value of the log property.
     * 
     * @param value
     *     allowed object is
     *     {@link Log }
     *     
     */
    public void setLog(Log value) {
        this.log = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{}logType">
     *       &lt;attribute name="l_id" use="required" type="{}lIdRestriction" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Log
        extends LogType
    {

        @XmlAttribute(name = "l_id", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String lId;

        /**
         * Gets the value of the lId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLId() {
            return lId;
        }

        /**
         * Sets the value of the lId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLId(String value) {
            this.lId = value;
        }

    }

}
