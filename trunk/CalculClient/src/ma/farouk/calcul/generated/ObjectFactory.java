
package ma.farouk.calcul.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ma.atos.calcul.generated package. 
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

    private final static QName _Id_QNAME = new QName("http://calcul.atos.ma/", "Id");
    private final static QName _Ajout_QNAME = new QName("http://calcul.atos.ma/", "ajout");
    private final static QName _AjoutResponse_QNAME = new QName("http://calcul.atos.ma/", "ajoutResponse");
    private final static QName _ProductResponse_QNAME = new QName("http://calcul.atos.ma/", "productResponse");
    private final static QName _Product_QNAME = new QName("http://calcul.atos.ma/", "product");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ma.atos.calcul.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Ajout }
     * 
     */
    public Ajout createAjout() {
        return new Ajout();
    }

    /**
     * Create an instance of {@link AjoutResponse }
     * 
     */
    public AjoutResponse createAjoutResponse() {
        return new AjoutResponse();
    }

    /**
     * Create an instance of {@link ProductResponse }
     * 
     */
    public ProductResponse createProductResponse() {
        return new ProductResponse();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calcul.atos.ma/", name = "Id")
    public JAXBElement<String> createId(String value) {
        return new JAXBElement<String>(_Id_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ajout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calcul.atos.ma/", name = "ajout")
    public JAXBElement<Ajout> createAjout(Ajout value) {
        return new JAXBElement<Ajout>(_Ajout_QNAME, Ajout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calcul.atos.ma/", name = "ajoutResponse")
    public JAXBElement<AjoutResponse> createAjoutResponse(AjoutResponse value) {
        return new JAXBElement<AjoutResponse>(_AjoutResponse_QNAME, AjoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calcul.atos.ma/", name = "productResponse")
    public JAXBElement<ProductResponse> createProductResponse(ProductResponse value) {
        return new JAXBElement<ProductResponse>(_ProductResponse_QNAME, ProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Product }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calcul.atos.ma/", name = "product")
    public JAXBElement<Product> createProduct(Product value) {
        return new JAXBElement<Product>(_Product_QNAME, Product.class, null, value);
    }

}
