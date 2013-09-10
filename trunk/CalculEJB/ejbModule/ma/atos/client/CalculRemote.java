package ma.atos.client;
import javax.ejb.Remote; 
 
@Remote
public interface CalculRemote {

	
	public  int add (int a, int b);
	
	public int product (int a, int b);
}
