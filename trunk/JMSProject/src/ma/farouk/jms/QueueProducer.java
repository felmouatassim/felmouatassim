package ma.farouk.jms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.NamingException;

import com.tibco.tibjms.TibjmsXAQueueConnectionFactory;

public class QueueProducer {
	private QueueConnectionFactory qconFactory;
	private TibjmsXAQueueConnectionFactory tibQConFactory;
	private QueueConnection qcon;
	private QueueSession qsession;
	private QueueSender qsender;
	private Queue queue;
	private TextMessage msg;

	public QueueProducer(Context ctx, String queueName, String JMS_QUEUE_FACTORY, String login, String password)
			throws NamingException, JMSException, IOException {
		this.qconFactory = (QueueConnectionFactory) ctx.lookup(JMS_QUEUE_FACTORY);
		this.qcon = this.qconFactory.createQueueConnection(login, password);
		this.qsession = this.qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		this.queue = (Queue) ctx.lookup(queueName);
		this.qsender = this.qsession.createSender(this.queue);
		this.msg = this.qsession.createTextMessage();
	}
	
	public QueueProducer(Context ctx, String queueName, String JMS_QUEUE_FACTORY, String login, String password, String SSLCertif)
			throws NamingException, JMSException, IOException {
		this.tibQConFactory = (TibjmsXAQueueConnectionFactory) ctx.lookup(JMS_QUEUE_FACTORY);
		tibQConFactory.setSSLTrustedCertificate(SSLCertif);
		tibQConFactory.setSSLEnableVerifyHost(new Boolean("false"));
		this.qcon = this.tibQConFactory.createQueueConnection(login, password);
		this.qsession = this.qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		this.queue = (Queue) ctx.lookup(queueName);
		this.qsender = this.qsession.createSender(this.queue);
		this.msg = this.qsession.createTextMessage();
	}
	
	public QueueProducer(Context ctx, String queueName, String JMS_QUEUE_FACTORY)
			throws NamingException, JMSException, IOException {
		this.qconFactory = (QueueConnectionFactory) ctx.lookup(JMS_QUEUE_FACTORY);
		this.qcon = this.qconFactory.createQueueConnection();
		this.qsession = this.qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		this.queue = (Queue) ctx.lookup(queueName);
		this.qsender = this.qsession.createSender(this.queue);
		this.msg = this.qsession.createTextMessage();
	}

	public void send(String message) throws JMSException {
		msg.setText(message);
		qsender.send(msg);
	}

	public void close() throws JMSException {
		qsender.close();
		qsession.close();
		qcon.close();
	}
	
	public void init() throws JMSException{
		this.qcon.start();
	}

	public void readAndSend() throws IOException,
			JMSException {
		BufferedReader msgStream = new BufferedReader(new InputStreamReader(
				System.in));
		String line = null;
		boolean quitNow = false;
		do {
			System.out.print("Enter message (\"quit\" to quit): \n");
			line = msgStream.readLine();
			if (line != null && line.trim().length() != 0) {
				this.send(line);
				System.out.println("JMS Message Sent: " + line + "\n");
				quitNow = line.equalsIgnoreCase("quit");
			}
		} while (!quitNow);
	}
}