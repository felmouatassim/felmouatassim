package ma.farouk.jms;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.InitialContext;

public class SendToSSLSecureQueue {

	public static void main(String[] args) {
		Properties prop = new Properties();
		InputStream input;
		try {
			input = new FileInputStream("JMSConfig.properties");
			prop.load(input);
			String JNDI_FACTORY = prop.getProperty("JNDI_FACTORY");
			String JMS_QUEUE_FACTORY = prop.getProperty("JMS_QUEUE_FACTORY");
			String QUEUE = prop.getProperty("QUEUE");
			String URL = prop.getProperty("URL");
			String login = prop.getProperty("LOGIN");
			String password = prop.getProperty("PASSWORD");
			String SSL_Truststore = prop.getProperty("JMS_SSL_TrustStore");
			String SSL_Identity = prop.getProperty("JMS_SSL_Identity");
			String SSL_Password = prop.getProperty("JMS_SSL_Password");
			InitialContext ic = JMSUtils.getInitialContext(URL, JNDI_FACTORY, login,
					password, SSL_Truststore, SSL_Identity, SSL_Password);
			QueueProducer qm = new QueueProducer(ic, QUEUE, JMS_QUEUE_FACTORY,
					login, password, SSL_Truststore);
			qm.init();
			qm.readAndSend();
			qm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}