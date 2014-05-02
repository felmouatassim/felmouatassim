package ma.farouk.jms;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMSUtils {

	public static InitialContext getInitialContext(String url,
			String JNDI_FACTORY, String LOGIN, String PASSWORD) throws NamingException {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
		env.put(Context.PROVIDER_URL, url);
		env.put(Context.SECURITY_PRINCIPAL, LOGIN);
		env.put(Context.SECURITY_CREDENTIALS, PASSWORD);
		return new InitialContext(env);
	}
	
	public static InitialContext getInitialContext(String url,
			String JNDI_FACTORY, String LOGIN, String PASSWORD, String SSL_Truststore, String SSL_Identity, String SSL_Password) throws NamingException {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
		env.put(Context.PROVIDER_URL, url);
		env.put(Context.SECURITY_PRINCIPAL, LOGIN);
		env.put(Context.SECURITY_CREDENTIALS, PASSWORD);
		env.put("com.tibco.tibjms.naming.security_protocol", "ssl");
		env.put("com.tibco.tibjms.naming.ssl_trusted_certs", SSL_Truststore);
		env.put("com.tibco.tibjms.custom.CustomObjectFactory.setSSLTrustedCertificate", SSL_Truststore);
		env.put("com.tibco.tibjms.naming.ssl_identity", SSL_Identity);
		env.put("com.tibco.tibjms.naming.ssl_password", SSL_Password);
		env.put("java.naming.factory.url.pkgs", "com.tibco.tibjms.naming");
		env.put("com.tibco.tibjms.naming.ssl_enable_verify_hostname", "false");
		return new InitialContext(env);
	}
	
	public static InitialContext getInitialContext(String url,
			String JNDI_FACTORY) throws NamingException {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
		env.put(Context.PROVIDER_URL, url);
		return new InitialContext(env);
	}
	
	
}
