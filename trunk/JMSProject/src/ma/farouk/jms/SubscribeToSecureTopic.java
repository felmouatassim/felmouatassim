package ma.farouk.jms;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.InitialContext;

public class SubscribeToSecureTopic {

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
		InitialContext ic = JMSUtils.getInitialContext(URL, JNDI_FACTORY, login,
				password);
		TopicSubscriber tr = new TopicSubscriber(ic, TOPIC, JMS_TOPIC_FACTORY, login, password);
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
