package ma.farouk.jms;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.InitialContext;

public class SendToSecureQueue {

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
			InitialContext ic = JMSUtils.getInitialContext(URL, JNDI_FACTORY, login,
					password);
			QueueProducer qm = new QueueProducer(ic, QUEUE, JMS_QUEUE_FACTORY,
					login, password);
			qm.init();
			qm.readAndSend();
			qm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
