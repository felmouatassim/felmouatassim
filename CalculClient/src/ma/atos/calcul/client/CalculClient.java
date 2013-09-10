package ma.atos.calcul.client;

import javax.xml.ws.WebServiceRef;

import ma.atos.calcul.generated.Ajout;
import ma.atos.calcul.generated.AjoutResponse;
import ma.atos.calcul.generated.Calcul;
import ma.atos.calcul.generated.CalculService;
import ma.atos.calcul.generated.ProductResponse;

public class CalculClient {

	@WebServiceRef(wsdlLocation="http://localhost:8001/Calcul/CalculService?WSDL")
	static int A = 6;
	static int B = 8;
	static CalculService service = new CalculService();
	
	public int getB() {
		return B;
	}

	public void setB(int b) {
		B = b;
	}

	public int getA() {
		return A;
	}

	public void setA(int a) {
		A = a;
	}

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
		
		Ajout arguments = new Ajout();
		arguments.setA(A);
		arguments.setB(B);
	
		//CalculClient client = new CalculClient();
		Calcul port = service.getCalculPort();
		AjoutResponse somme = new AjoutResponse();
		ProductResponse produit = new ProductResponse();
		somme = port.ajout(arguments, "123456789");
		produit.setReturn(port.product(arguments.getA(), arguments.getB()));
		System.out.println("somme = "+somme.getSomme());
		System.out.println("produit = "+produit.getReturn());
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e.getMessage());
		}
	}

}
