//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.12 at 04:28:08 PM MESZ 
//


package de.odenthma.geocache.generatedclasses.cache;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for yesNoEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="yesNoEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ja"/>
 *     &lt;enumeration value="nein"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum YesNoEnum {

    @XmlEnumValue("ja")
    JA("ja"),
    @XmlEnumValue("nein")
    NEIN("nein");
    private final String value;
    private static ArrayList<String> values = new ArrayList<String> ();
    YesNoEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static YesNoEnum fromValue(String v) {
        for (YesNoEnum c: YesNoEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }
    public static ArrayList<String> getAll(){
    	values.add(JA.value());
    	values.add(NEIN.value());
    	
    	return values;
    	
    }
}
