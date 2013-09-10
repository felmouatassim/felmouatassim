package ma.atos.calcul;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class CalculWS {
	@WebMethod(operationName="ajout")
	
	public @WebResult(name="somme") int add (@WebParam(header=true,name="Id") String id, @WebParam(name="A") int a, @WebParam(name="B") int b){
		
		return a+b;
	}
	@WebMethod
	public int product (int a, int b){
		return a*b;
	}
}
