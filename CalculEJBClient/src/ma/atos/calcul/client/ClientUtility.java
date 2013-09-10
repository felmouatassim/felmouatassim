package ma.atos.calcul.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClientUtility {

	private static InitialContext initialContext;

 
    public static InitialContext getInitialContext() throws NamingException {
        if (initialContext == null) {
        	Properties prop = new Properties();
			prop.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");  
	        prop.put(Context.PROVIDER_URL, "t3://localhost:9001");  
 
            initialContext = new InitialContext(prop);
        }
        return initialContext;
    }
}
