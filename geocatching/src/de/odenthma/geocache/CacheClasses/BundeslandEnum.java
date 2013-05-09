//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.09 at 09:00:25 PM MESZ 
//


package de.odenthma.geocache.CacheClasses;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for bundeslandEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="bundeslandEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Baden-Württemberg"/>
 *     &lt;enumeration value="Bayern"/>
 *     &lt;enumeration value="Berlin"/>
 *     &lt;enumeration value="Brandenburg"/>
 *     &lt;enumeration value="Bremen"/>
 *     &lt;enumeration value="Hamburg"/>
 *     &lt;enumeration value="Hessen"/>
 *     &lt;enumeration value="Mecklenburg-Vorpommern"/>
 *     &lt;enumeration value="Niedersachsen"/>
 *     &lt;enumeration value="Nordrhein-Westfalen"/>
 *     &lt;enumeration value="Rheinland-Pfalz"/>
 *     &lt;enumeration value="Saarland"/>
 *     &lt;enumeration value="Sachsen"/>
 *     &lt;enumeration value="Schleswig-Holstein"/>
 *     &lt;enumeration value="Thüringen"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum BundeslandEnum {

    @XmlEnumValue("Baden-W\u00fcrttemberg")
    BADEN_WÜRTTEMBERG("Baden-W\u00fcrttemberg"),
    @XmlEnumValue("Bayern")
    BAYERN("Bayern"),
    @XmlEnumValue("Berlin")
    BERLIN("Berlin"),
    @XmlEnumValue("Brandenburg")
    BRANDENBURG("Brandenburg"),
    @XmlEnumValue("Bremen")
    BREMEN("Bremen"),
    @XmlEnumValue("Hamburg")
    HAMBURG("Hamburg"),
    @XmlEnumValue("Hessen")
    HESSEN("Hessen"),
    @XmlEnumValue("Mecklenburg-Vorpommern")
    MECKLENBURG_VORPOMMERN("Mecklenburg-Vorpommern"),
    @XmlEnumValue("Niedersachsen")
    NIEDERSACHSEN("Niedersachsen"),
    @XmlEnumValue("Nordrhein-Westfalen")
    NORDRHEIN_WESTFALEN("Nordrhein-Westfalen"),
    @XmlEnumValue("Rheinland-Pfalz")
    RHEINLAND_PFALZ("Rheinland-Pfalz"),
    @XmlEnumValue("Saarland")
    SAARLAND("Saarland"),
    @XmlEnumValue("Sachsen")
    SACHSEN("Sachsen"),
    @XmlEnumValue("Schleswig-Holstein")
    SCHLESWIG_HOLSTEIN("Schleswig-Holstein"),
    @XmlEnumValue("Th\u00fcringen")
    THÜRINGEN("Th\u00fcringen");
    private final String value;

    BundeslandEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BundeslandEnum fromValue(String v) {
        for (BundeslandEnum c: BundeslandEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
