package ma.farouk.jms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.tibco.tibjms.TibjmsXATopicConnectionFactory;

public class TopicPublisher {

	private static TopicConnectionFactory cf;
	private TibjmsXATopicConnectionFactory tibTConFactory;
	private static Topic topic;
	private static TopicSession session;
	private static TextMessage message;
	private static javax.jms.TopicPublisher pub;
	private static TopicConnection conn;

	public void readAndSend() throws IOException, JMSException {

		BufferedReader msgStream = new BufferedReader(new InputStreamReader(
				System.in));
		String line = null;
		boolean quitNow = false;
		do {
			System.out.print("Enter message (\"quit\" to quit): \n");
			line = msgStream.readLine();
			if (line != null && line.trim().length() != 0) {
				message.setText(line);
				pub.publish(message);
				System.out.println("JMS Message Sent: " + line + "\n");
				quitNow = line.equalsIgnoreCase("quit");
			}
		} while (!quitNow);

	}

	public TopicPublisher(InitialContext ic, String JMS_TOPIC_FACTORY,
			String TOPIC, String login, String password)
			throws NamingException, JMSException {

		cf = (TopicConnectionFactory) ic.lookup(JMS_TOPIC_FACTORY);
		conn = cf.createTopicConnection(login, password);
		session = conn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = (Topic) ic.lookup(TOPIC);
		pub = session.createPublisher(topic);
		message = session.createTextMessage();

	}

	public TopicPublisher(InitialContext ic, String JMS_TOPIC_FACTORY,
			String TOPIC, String login, String password, String SSLCertif)
			throws NamingException, JMSException {

		tibTConFactory = (TibjmsXATopicConnectionFactory) ic
				.lookup(JMS_TOPIC_FACTORY);
		tibTConFactory.setSSLTrustedCertificate(SSLCertif);
		tibTConFactory.setSSLEnableVerifyHost(new Boolean("false"));
		conn = tibTConFactory.createTopicConnection(login, password);
		session = conn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = (Topic) ic.lookup(TOPIC);
		pub = session.createPublisher(topic);
		message = session.createTextMessage();

	}

	public TopicPublisher(InitialContext ic, String JMS_TOPIC_FACTORY,
			String TOPIC) throws NamingException, JMSException {

		cf = (TopicConnectionFactory) ic.lookup(JMS_TOPIC_FACTORY);
		conn = cf.createTopicConnection();
		session = conn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = (Topic) ic.lookup(TOPIC);
		pub = session.createPublisher(topic);
		message = session.createTextMessage();

	}

	public void init() throws JMSException {
		conn.start();
	}

	public void close() throws JMSException {
		conn.close();
		session.close();
		pub.close();
	}
}
