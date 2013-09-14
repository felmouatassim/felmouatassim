package ma.farouk.client;
import javax.ejb.Local;
 
@Local
public interface CalculLocal {

	
	public  int add (int a, int b);
	
	public int product (int a, int b);
}
