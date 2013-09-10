
package ma.atos.calcul.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ajout complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ajout">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="A" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="B" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ajout", propOrder = {
    "a",
    "b"
})
public class Ajout {

    @XmlElement(name = "A")
    protected int a;
    @XmlElement(name = "B")
    protected int b;

    /**
     * Gets the value of the a property.
     * 
     */
    public int getA() {
        return a;
    }

    /**
     * Sets the value of the a property.
     * 
     */
    public void setA(int value) {
        this.a = value;
    }

    /**
     * Gets the value of the b property.
     * 
     */
    public int getB() {
        return b;
    }

    /**
     * Sets the value of the b property.
     * 
     */
    public void setB(int value) {
        this.b = value;
    }

}
