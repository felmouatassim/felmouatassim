package ma.farouk.jms;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.InitialContext;

public class SubscribeToSSLSecureTopic {

	public static void main(String[] args) throws Exception {

		Properties prop = new Properties();
		InputStream input = new FileInputStream("JMSConfig.properties");
		prop.load(input);
		String JNDI_FACTORY = prop.getProperty("JNDI_FACTORY");
		String JMS_TOPIC_FACTORY = prop.getProperty("JMS_TOPIC_FACTORY");
		String TOPIC = prop.getProperty("TOPIC");
		String URL = prop.getProperty("URL");
		String login = prop.getProperty("LOGIN");
		String password = prop.getProperty("PASSWORD");
		String SSL_Truststore = prop.getProperty("JMS_SSL_TrustStore");
		String SSL_Identity = prop.getProperty("JMS_SSL_Identity");
		String SSL_Password = prop.getProperty("JMS_SSL_Password");
		InitialContext ic = JMSUtils.getInitialContext(URL, JNDI_FACTORY, login,
				password, SSL_Truststore, SSL_Identity, SSL_Password);
		TopicSubscriber tr = new TopicSubscriber(ic, TOPIC, JMS_TOPIC_FACTORY, login, password, SSL_Truststore);
		tr.init();
		System.out
				.println("JMS Ready To Receive Messages (To quit, send a \"quit\" message).");
		synchronized (tr) {
			while (!tr.isQuit()) {
				try {
					tr.wait();
				} catch (InterruptedException ie) {
				}
			}
		}
		tr.close();
	}
}
