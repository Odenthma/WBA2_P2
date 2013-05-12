//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.12 at 05:06:50 PM MESZ 
//


package de.odenthma.geocache.UserInformation.Classes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import de.odenthma.geocache.UserInformation.Classes.OptionalType.Benachrichtigung;
import de.odenthma.geocache.UserInformation.Classes.OptionalType.News;
import de.odenthma.geocache.UserInformation.Classes.UserInformationType.User;



/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
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

    private final static QName _UserInformation_QNAME = new QName("", "userInformation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OptionalType }
     * 
     */
    public OptionalType createOptionalType() {
        return new OptionalType();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUserInformationTypeUser() {
        return new User();
    }

    /**
     * Create an instance of {@link CachesType }
     * 
     */
    public CachesType createCachesType() {
        return new CachesType();
    }

    /**
     * Create an instance of {@link UserInformationType }
     * 
     */
    public UserInformationType createUserInformationType() {
        return new UserInformationType();
    }

    /**
     * Create an instance of {@link OrtsListeType }
     * 
     */
    public OrtsListeType createOrtsListeType() {
        return new OrtsListeType();
    }

    /**
     * Create an instance of {@link CachesErstelltType }
     * 
     */
    public CachesErstelltType createCachesErstelltType() {
        return new CachesErstelltType();
    }

    /**
     * Create an instance of {@link CachesGefundenType }
     * 
     */
    public CachesGefundenType createCachesGefundenType() {
        return new CachesGefundenType();
    }

    /**
     * Create an instance of {@link Benachrichtigung }
     * 
     */
    public Benachrichtigung createOptionalTypeBenachrichtigung() {
        return new Benachrichtigung();
    }

    /**
     * Create an instance of {@link News }
     * 
     */
    public News createOptionalTypeNews() {
        return new News();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserInformationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "userInformation")
    public JAXBElement<UserInformationType> createUserInformation(UserInformationType value) {
        return new JAXBElement<UserInformationType>(_UserInformation_QNAME, UserInformationType.class, null, value);
    }

}
