package ma.farouk.jms;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.InitialContext;

public class ConsumeFromSecureQueue {
	
	public static void main(String[] args) throws Exception {

		Properties prop = new Properties();
		InputStream input = new FileInputStream("JMSConfig.properties");
		prop.load(input);
		String JNDI_FACTORY = prop.getProperty("JNDI_FACTORY");
		String JMS_QUEUE_FACTORY = prop.getProperty("JMS_QUEUE_FACTORY");
		String QUEUE = prop.getProperty("QUEUE");
		String URL = prop.getProperty("URL");
		String login = prop.getProperty("LOGIN");
		String password = prop.getProperty("PASSWORD");
		InitialContext ic = JMSUtils.getInitialContext(URL, JNDI_FACTORY, login, password);
		QueueConsumer qr = new QueueConsumer(ic, QUEUE, JMS_QUEUE_FACTORY, login, password);
		qr.init();
		System.out
				.println("JMS Ready To Receive Messages (To quit, send a \"quit\" message).");
		synchronized (qr) {
			while (!qr.isQuit()) {
				try {
					qr.wait();
				} catch (InterruptedException ie) {
				}
			}
		}
		qr.close();
	}
}