
package crearalumno;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Input complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Input">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Telephone" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Delegation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passw" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Direction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Input", propOrder = {
    "fLastName",
    "sLastName",
    "name",
    "telephone",
    "email",
    "delegation",
    "passw",
    "direction"
})
public class Input {

    @XmlElementRef(name = "FLastName", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fLastName;
    @XmlElementRef(name = "SLastName", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sLastName;
    @XmlElementRef(name = "Name", type = JAXBElement.class, required = false)
    protected JAXBElement<String> name;
    @XmlElement(name = "Telephone")
    protected int telephone;
    @XmlElementRef(name = "Email", type = JAXBElement.class, required = false)
    protected JAXBElement<String> email;
    @XmlElementRef(name = "Delegation", type = JAXBElement.class, required = false)
    protected JAXBElement<String> delegation;
    @XmlElementRef(name = "passw", type = JAXBElement.class, required = false)
    protected JAXBElement<String> passw;
    @XmlElementRef(name = "Direction", type = JAXBElement.class, required = false)
    protected JAXBElement<String> direction;

    /**
     * Obtiene el valor de la propiedad fLastName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFLastName() {
        return fLastName;
    }

    /**
     * Define el valor de la propiedad fLastName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFLastName(JAXBElement<String> value) {
        this.fLastName = value;
    }

    /**
     * Obtiene el valor de la propiedad sLastName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSLastName() {
        return sLastName;
    }

    /**
     * Define el valor de la propiedad sLastName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSLastName(JAXBElement<String> value) {
        this.sLastName = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setName(JAXBElement<String> value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad telephone.
     * 
     */
    public int getTelephone() {
        return telephone;
    }

    /**
     * Define el valor de la propiedad telephone.
     * 
     */
    public void setTelephone(int value) {
        this.telephone = value;
    }

    /**
     * Obtiene el valor de la propiedad email.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEmail() {
        return email;
    }

    /**
     * Define el valor de la propiedad email.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEmail(JAXBElement<String> value) {
        this.email = value;
    }

    /**
     * Obtiene el valor de la propiedad delegation.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDelegation() {
        return delegation;
    }

    /**
     * Define el valor de la propiedad delegation.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDelegation(JAXBElement<String> value) {
        this.delegation = value;
    }

    /**
     * Obtiene el valor de la propiedad passw.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPassw() {
        return passw;
    }

    /**
     * Define el valor de la propiedad passw.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPassw(JAXBElement<String> value) {
        this.passw = value;
    }

    /**
     * Obtiene el valor de la propiedad direction.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDirection() {
        return direction;
    }

    /**
     * Define el valor de la propiedad direction.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDirection(JAXBElement<String> value) {
        this.direction = value;
    }

}
