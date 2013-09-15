/*
 ** This is a sample Simple Custom Audit Provider Class that implements :
 **AuditProvider class and  AuditChannel class available in 
 **weblogic.security.spi package.
 *It logs Authentications, Authorizations and Configuration changes.
 */

package sample.examples.audit.providers;

import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import weblogic.management.security.ProviderMBean;
import weblogic.security.spi.AuditAtnEvent;
import weblogic.security.spi.AuditChannel;
import weblogic.security.spi.AuditEvent;
import weblogic.security.spi.AuditProvider;
import weblogic.security.spi.SecurityServices;

public final class SimpleSampleAuditProviderImpl implements AuditProvider,
		AuditChannel {

	private String description; // a description of this provider
	private String displayName;
	private PrintStream log; // the log file that events are written to
	private boolean enabled;
	private String logFileName;
	private FileHandler fileHandler;
	private Logger logger;
	private Integer logSizeLimit;
	private Integer maxNumberLogFiles;

	SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy KK:mm:ss a z");

	private final String LOG_PREFIX = "####";
	private final String LOG_O = "<";
	private final String LOG_C = ">";
	private final String LOG_E = " ";

	/*
	 * Those are the available WLS contexts, in case you want to implement the
	 * Auditing based on them
	 */

	@SuppressWarnings("unused")
	private final static String[] CONTEXTS = {
			"com.bea.contextelement.channel.Address",
			"com.bea.contextelement.channel.ChannelName",
			"com.bea.contextelement.channel.Port",
			"com.bea.contextelement.channel.Protocol",
			"com.bea.contextelement.channel.PublicAddress",
			"com.bea.contextelement.channel.PublicPort",
			"com.bea.contextelement.channel.RemoteAddress",
			"com.bea.contextelement.channel.RemotePort",
			"com.bea.contextelement.channel.Secure",
			"com.bea.contextelement.ejb20.Parameter",
			"com.bea.contextelement.entitlement.EAuxiliaryID",
			"com.bea.contextelement.jmx.AuditProtectedArgInfo",
			"com.bea.contextelement.jmx.ObjectName",
			"com.bea.contextelement.jmx.OldAttributeValue",
			"com.bea.contextelement.jmx.Parameters",
			"com.bea.contextelement.jmx.ShortName",
			"com.bea.contextelement.jmx.Signature",
			"com.bea.contextelement.saml.MessageSignerCertificate",
			"com.bea.contextelement.saml.SSLClientCertificateChain",
			"com.bea.contextelement.saml.subject.ConfirmationMethod",
			"com.bea.contextelement.saml.subject.dom.KeyInfo",
			"com.bea.contextelement.security.ChainPrevailidatedBySSL",
			"com.bea.contextelement.servlet.HttpServletRequest",
			"com.bea.contextelement.servlet.HttpServletResponse",
			"com.bea.contextelement.webservice.Integrity",
			"com.bea.contextelement.wli.Message",
			"com.bea.contextelement.wsee.SOAPMessage",
			"com.bea.contextelement.xml.SecurityToken",
			"com.bea.contextelement.xml.SecurityTokenAssertion" };

	private void logMessage(String msg) {
		logger.log(Level.INFO,
				LOG_PREFIX + LOG_O + sdf.format(System.currentTimeMillis())
						+ LOG_C + LOG_E + LOG_O + msg + LOG_C);
	}

	public void initialize(ProviderMBean mbean, SecurityServices services) {

		SimpleSampleAuditorMBean myMBean = (SimpleSampleAuditorMBean) mbean;

		description = myMBean.getDescription() + "\n" + myMBean.getVersion();
		displayName = myMBean.getName();
		enabled = myMBean.getEnabled().booleanValue();
		logFileName = myMBean.getLogFileName();

		logSizeLimit = myMBean.getLogSizeLimit().intValue();
		maxNumberLogFiles = myMBean.getMaxNumberLogFiles().intValue();

		System.out.println("#### Logging " + displayName + " info to "
				+ logFileName);

		try {
			setupLogger();
			logMessage("SimpleSampleAuditProviderImpl.initialize()");
		} catch (IOException e) {
			System.out
					.println("#### Error on SimpleSampleAuditProviderImpl.initialize(): "
							+ e.getMessage());
			throw new RuntimeException(e.toString());
		}
	}

	private void setupLogger() throws IOException {

		logger = Logger.getLogger(this.getClass().getCanonicalName());
		logger.setLevel(Level.INFO);
		logger.setUseParentHandlers(false);
		fileHandler = new FileHandler(logFileName, logSizeLimit,
				maxNumberLogFiles);

		SimpleFormatter formatterTxt = new SimpleFormatter();
		fileHandler.setFormatter(formatterTxt);
		logger.addHandler(fileHandler);
	}

	public String getDescription() {
		return description;
	}

	public void shutdown() {
		logMessage("SimpleSampleAuditProviderImpl.shutdown()");
		log.close();
	}

	public AuditChannel getAuditChannel() {
		return this;
	}

	public void writeEvent(AuditEvent event) {

		if (enabled) {
			// Tracer les authentifications
			if (event.getEventType().contains("Authentication Audit Event")) {
				try{
				AuditAtnEvent createEvent = (AuditAtnEvent) event;
				if (createEvent.getAtnEventType().toString()
						.equals("AUTHENTICATE")) {
					String user = createEvent.getUsername().toString();
					String severity = createEvent.getSeverity()
							.getSeverityString();

					logMessage("Authentication: User: " + user + ", severity: "
							+ severity);
				}
				} catch (Exception e){
					System.out.println(e.getMessage()+e.getStackTrace().toString());
				}
			}
			// Tracer les authorisations
//			else if (event.getEventType().contains(
//					"Authorization Audit Event V2")) {
//
//				logMessage("Authorisation : " + event.getClass());
//				AuditAtzEvent createEvent = (AuditAtzEvent) event;
//				String user = createEvent.getSubject().toString();
//				String severity = createEvent.getSeverity().getSeverityString();
//
//				logMessage("Authorization: User: " + user + ", Resource :"
//						+ createEvent.getResource() + ", severity: " + severity);
//			}
//			// Tracer les Creations de ressources
//			else if (event instanceof AuditCreateConfigurationEvent) {
//
//				AuditCreateConfigurationEvent createEvent = (AuditCreateConfigurationEvent) event;
//
//				String user = createEvent.getSubject().toString();
//				String obj = createEvent.getObjectName();
//
//				logMessage("AuditCreateConfigurationEvent: User: " + user
//						+ ", Object: " + obj);
//
//			}
//			// Tracer les suppressions de ressources
//			else if (event instanceof AuditDeleteConfigurationEvent) {
//				AuditDeleteConfigurationEvent deleteEvent = (AuditDeleteConfigurationEvent) event;
//
//				String user = deleteEvent.getSubject().toString();
//				String obj = deleteEvent.getObjectName();
//
//				logMessage("AuditDeleteConfigurationEvent: User: " + user
//						+ ", Object: " + obj);
//
//			}
//			// Tracer les modifications de ressources
//			else if (event instanceof AuditSetAttributeConfigurationEvent) {
//				AuditSetAttributeConfigurationEvent setEvent = (AuditSetAttributeConfigurationEvent) event;
//
//				String oldValue = setEvent.getOldValue().toString();
//				String newValue = setEvent.getNewValue().toString();
//				String user = setEvent.getSubject().toString();
//				String obj = setEvent.getObjectName();
//
//				String attName = setEvent.getAttributeName();
//
//				if (oldValue != null && newValue != null
//						&& !oldValue.equalsIgnoreCase(newValue)) {
//					logMessage("AuditSetAttributeConfigurationEvent: User: "
//							+ user + ", Object: " + obj + ", Attribute: "
//							+ attName + ", Old Value: " + oldValue
//							+ ", New Value: " + newValue);
//				}
//			}
		}
		return;
	}
}
