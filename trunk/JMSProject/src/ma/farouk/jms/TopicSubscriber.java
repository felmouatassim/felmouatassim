package ma.farouk.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.NamingException;

import com.tibco.tibjms.TibjmsXATopicConnectionFactory;

public class TopicSubscriber implements MessageListener {
	private TopicConnectionFactory tconFactory;
	private TibjmsXATopicConnectionFactory tibTConFactory;
	private TopicConnection tcon;
	private TopicSession tsession;
	private javax.jms.TopicSubscriber tsubscriber;
	private Topic topic;
	private boolean quit = false;

	public void onMessage(Message msg) {
		try {
			String msgText;
			if (msg instanceof TextMessage) {
				msgText = ((TextMessage) msg).getText();
			} else {
				msgText = msg.toString();
			}
			System.out.println("Message Received: " + msgText);

			if (msgText.equalsIgnoreCase("quit")) {
				synchronized (this) {
					quit = true;
					this.notifyAll(); // Notify main thread to quit
				}
			}
		} catch (JMSException jmse) {
			System.err.println("An exception occurred: " + jmse.getMessage());
		}
	}

	public boolean isQuit() {
		return quit;
	}

	public void setQuit(boolean quit) {
		this.quit = quit;
	}

	public TopicSubscriber(Context ctx, String topicName,
			String JMS_TOPIC_FACTORY, String login, String password)
			throws NamingException, JMSException {
		tconFactory = (TopicConnectionFactory) ctx.lookup(JMS_TOPIC_FACTORY);
		tcon = tconFactory.createTopicConnection(login, password);
		tsession = tcon.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = (Topic) ctx.lookup(topicName);
		tsubscriber = tsession.createSubscriber(topic);
		tsubscriber.setMessageListener(this);
	}
	
	public TopicSubscriber(Context ctx, String topicName,
			String JMS_TOPIC_FACTORY, String login, String password, String SSLCertif)
			throws NamingException, JMSException {
		tibTConFactory = (TibjmsXATopicConnectionFactory) ctx.lookup(JMS_TOPIC_FACTORY);
		tibTConFactory.setSSLTrustedCertificate(SSLCertif);
		tibTConFactory.setSSLEnableVerifyHost(new Boolean("false"));
		tcon = tibTConFactory.createTopicConnection(login, password);
		tsession = tcon.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = (Topic) ctx.lookup(topicName);
		tsubscriber = tsession.createSubscriber(topic);
		tsubscriber.setMessageListener(this);
	}
	public void init() throws JMSException{
		tcon.start();
	}
	public TopicSubscriber(Context ctx, String queueName,
			String JMS_TOPIC_FACTORY) throws NamingException, JMSException {
		tconFactory = (TopicConnectionFactory) ctx.lookup(JMS_TOPIC_FACTORY);
		tcon = tconFactory.createTopicConnection();
		tsession = tcon.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = (Topic) ctx.lookup(queueName);
		tsubscriber = tsession.createSubscriber(topic);
		tsubscriber.setMessageListener(this);
		tcon.start();
	}

	public void close() throws JMSException {
		tsubscriber.close();
		tsession.close();
		tcon.close();
	}

}