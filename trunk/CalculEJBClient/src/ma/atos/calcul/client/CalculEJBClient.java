package ma.atos.calcul.client;

import javax.naming.InitialContext;

import ma.atos.client.CalculRemote;

public class CalculEJBClient {
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// Utilisation du InitialContext puisque l'EJB n'est pas dans la même JVM du client.
			InitialContext ic = ClientUtility.getInitialContext();
			CalculRemote obj = (CalculRemote) ic.lookup("calculEJB#ma.atos.client.CalculRemote");
			System.out.println("somme = "+obj.add(2, 8));
			System.out.println("produit = "+obj.product(3, 9));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	
	
		
	}

}
