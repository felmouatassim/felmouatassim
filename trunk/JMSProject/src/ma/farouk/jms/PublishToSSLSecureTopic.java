package ma.farouk.jms;

import java.io.FileInputStream;
import java.util.Properties;

import javax.naming.InitialContext;

public class PublishToSSLSecureTopic {
	
	public static void main(String[] args){
		
		Properties prop = new Properties();
		try {
			FileInputStream is = new FileInputStream("JMSConfig.properties");
			prop.load(is);
			String JNDI_FACTORY = prop.getProperty("JNDI_FACTORY");
			String JMS_TOPIC_FACTORY = prop.getProperty("JMS_TOPIC_FACTORY");
			String TOPIC = prop.getProperty("TOPIC");
			String URL = prop.getProperty("URL");
			String login = prop.getProperty("LOGIN");
			String password = prop.getProperty("PASSWORD");		
			String SSL_Truststore = prop.getProperty("JMS_SSL_TrustStore");
			String SSL_Identity = prop.getProperty("JMS_SSL_Identity");
			String SSL_Password = prop.getProperty("JMS_SSL_Password");
			InitialContext ic = JMSUtils.getInitialContext(URL, JNDI_FACTORY, login, password, SSL_Truststore, SSL_Identity, SSL_Password);
			TopicPublisher tp = new TopicPublisher(ic, JMS_TOPIC_FACTORY, TOPIC, login, password, SSL_Truststore);
			tp.init();
			tp.readAndSend();
			tp.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
