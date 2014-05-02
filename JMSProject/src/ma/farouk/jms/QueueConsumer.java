package ma.farouk.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.NamingException;

import com.tibco.tibjms.TibjmsXAQueueConnectionFactory;

public class QueueConsumer implements MessageListener {
	private QueueConnectionFactory qconFactory;
	private TibjmsXAQueueConnectionFactory tibQConFactory;
	private QueueConnection qcon;
	private QueueSession qsession;
	private QueueReceiver qreceiver;
	private Queue queue;
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

	public QueueConsumer(Context ctx, String queueName,
			String JMS_QUEUE_FACTORY, String login, String password)
			throws NamingException, JMSException {
		qconFactory = (QueueConnectionFactory) ctx.lookup(JMS_QUEUE_FACTORY);
		qcon = qconFactory.createQueueConnection(login, password);
		qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		queue = (Queue) ctx.lookup(queueName);
		qreceiver = qsession.createReceiver(queue);
		qreceiver.setMessageListener(this);
	}
	
	public QueueConsumer(Context ctx, String queueName,
			String JMS_QUEUE_FACTORY, String login, String password, String SSL_Truststore)
			throws NamingException, JMSException {
		tibQConFactory = (TibjmsXAQueueConnectionFactory) ctx.lookup(JMS_QUEUE_FACTORY);
		tibQConFactory.setSSLTrustedCertificate(SSL_Truststore);
		tibQConFactory.setSSLEnableVerifyHostName(new Boolean("false"));
		qcon = tibQConFactory.createQueueConnection(login, password);
		qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		queue = (Queue) ctx.lookup(queueName);
		qreceiver = qsession.createReceiver(queue);
		qreceiver.setMessageListener(this);
	}

	public QueueConsumer(Context ctx, String queueName,
			String JMS_QUEUE_FACTORY)
			throws NamingException, JMSException {
		qconFactory = (QueueConnectionFactory) ctx.lookup(JMS_QUEUE_FACTORY);
		qcon = qconFactory.createQueueConnection();
		qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		queue = (Queue) ctx.lookup(queueName);
		qreceiver = qsession.createReceiver(queue);
		qreceiver.setMessageListener(this);
	}

	public void init() throws JMSException {
		qcon.start();
	}

	public void close() throws JMSException {
		qreceiver.close();
		qsession.close();
		qcon.close();
	}

	public boolean isQuit() {
		return quit;
	}

	public void setQuit(boolean quit) {
		this.quit = quit;
	}

}