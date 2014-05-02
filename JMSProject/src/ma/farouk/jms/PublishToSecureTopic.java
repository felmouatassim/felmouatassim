package ma.farouk.jms;

import java.io.FileInputStream;
import java.util.Properties;

import javax.naming.InitialContext;

public class PublishToSecureTopic {
	
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
			InitialContext ic = JMSUtils.getInitialContext(URL, JNDI_FACTORY, login, password);
			TopicPublisher tp = new TopicPublisher(ic, JMS_TOPIC_FACTORY, TOPIC, login, password);
			tp.init();
			tp.readAndSend();
			tp.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
