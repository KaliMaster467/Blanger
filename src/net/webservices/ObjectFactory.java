
package net.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the crearalumno package. 
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

    private final static QName _GetInfoResponse_QNAME = new QName("urn:CrearAlumno", "getInfoResponse");
    private final static QName _GetInfoInsert_QNAME = new QName("", "insert");
    private final static QName _InputEmail_QNAME = new QName("", "Email");
    private final static QName _InputFLastName_QNAME = new QName("", "FLastName");
    private final static QName _InputDirection_QNAME = new QName("", "Direction");
    private final static QName _InputSLastName_QNAME = new QName("", "SLastName");
    private final static QName _InputDelegation_QNAME = new QName("", "Delegation");
    private final static QName _InputPassw_QNAME = new QName("", "passw");
    private final static QName _InputName_QNAME = new QName("", "Name");
    private final static QName _GetInfoResponseRecepcion_QNAME = new QName("", "recepcion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: crearalumno
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetInfoResponse }
     * 
     */
    public GetInfoResponse createGetInfoResponse() {
        return new GetInfoResponse();
    }

    /**
     * Create an instance of {@link GetInfo }
     * 
     */
    public GetInfo createGetInfo() {
        return new GetInfo();
    }

    /**
     * Create an instance of {@link Input }
     * 
     */
    public Input createInput() {
        return new Input();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:CrearAlumno", name = "getInfoResponse")
    public JAXBElement<GetInfoResponse> createGetInfoResponse(GetInfoResponse value) {
        return new JAXBElement<GetInfoResponse>(_GetInfoResponse_QNAME, GetInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "insert", scope = GetInfo.class)
    public JAXBElement<Input> createGetInfoInsert(Input value) {
        return new JAXBElement<Input>(_GetInfoInsert_QNAME, Input.class, GetInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Email", scope = Input.class)
    public JAXBElement<String> createInputEmail(String value) {
        return new JAXBElement<String>(_InputEmail_QNAME, String.class, Input.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FLastName", scope = Input.class)
    public JAXBElement<String> createInputFLastName(String value) {
        return new JAXBElement<String>(_InputFLastName_QNAME, String.class, Input.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Direction", scope = Input.class)
    public JAXBElement<String> createInputDirection(String value) {
        return new JAXBElement<String>(_InputDirection_QNAME, String.class, Input.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SLastName", scope = Input.class)
    public JAXBElement<String> createInputSLastName(String value) {
        return new JAXBElement<String>(_InputSLastName_QNAME, String.class, Input.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Delegation", scope = Input.class)
    public JAXBElement<String> createInputDelegation(String value) {
        return new JAXBElement<String>(_InputDelegation_QNAME, String.class, Input.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "passw", scope = Input.class)
    public JAXBElement<String> createInputPassw(String value) {
        return new JAXBElement<String>(_InputPassw_QNAME, String.class, Input.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Name", scope = Input.class)
    public JAXBElement<String> createInputName(String value) {
        return new JAXBElement<String>(_InputName_QNAME, String.class, Input.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "recepcion", scope = GetInfoResponse.class)
    public JAXBElement<String> createGetInfoResponseRecepcion(String value) {
        return new JAXBElement<String>(_GetInfoResponseRecepcion_QNAME, String.class, GetInfoResponse.class, value);
    }

}
