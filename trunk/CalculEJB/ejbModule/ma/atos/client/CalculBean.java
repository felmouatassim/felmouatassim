package ma.atos.client;

import javax.ejb.Stateless;

@Stateless(mappedName="calculEJB")
public class CalculBean implements CalculLocal, CalculRemote{

	public  int add (int a, int b){	
		return a+b;
	}

	public int product (int a, int b){
		return a*b;
	}
}
