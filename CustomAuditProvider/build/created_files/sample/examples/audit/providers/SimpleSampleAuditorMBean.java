package sample.examples.audit.providers;


import javax.management.*;
import weblogic.management.commo.RequiredModelMBeanWrapper;



/**
 * No description provided.
 * @root SimpleSampleAuditor
 * @customizer sample.examples.audit.providers.SimpleSampleAuditorImpl(new RequiredModelMBeanWrapper(this))
 * @dynamic false

 */
public interface SimpleSampleAuditorMBean extends weblogic.management.commo.StandardInterface,weblogic.descriptor.DescriptorBean, weblogic.management.security.audit.AuditorMBean, weblogic.management.security.audit.ContextHandlerMBean {
                
        


        /**
         * No description provided.

         * @default "sample.examples.audit.providers.SimpleSampleAuditProviderImpl"
         * @dynamic false
         * @non-configurable
         * @validatePropertyDeclaration false

         * @preserveWhiteSpace
         */
        public java.lang.String getProviderClassName ();


        
        


        /**
         * No description provided.

         * @default "WebLogic Simple Sample Audit Provider"
         * @dynamic false
         * @non-configurable
         * @validatePropertyDeclaration false

         * @preserveWhiteSpace
         */
        public java.lang.String getDescription ();


        
        


        /**
         * No description provided.

         * @default "1.0"
         * @dynamic false
         * @non-configurable
         * @validatePropertyDeclaration false

         * @preserveWhiteSpace
         */
        public java.lang.String getVersion ();


        
        


        /**
         * No description provided.

         * @default "com.bea.contextelement.channel.Address","com.bea.contextelement.channel.ChannelName","com.bea.contextelement.channel.Port","com.bea.contextelement.channel.Protocol","com.bea.contextelement.channel.PublicAddress","com.bea.contextelement.channel.PublicPort","com.bea.contextelement.channel.RemoteAddress","com.bea.contextelement.channel.RemotePort","com.bea.contextelement.channel.Secure","com.bea.contextelement.ejb20.Parameter","com.bea.contextelement.entitlement.EAuxiliaryID","com.bea.contextelement.jmx.AuditProtectedArgInfo","com.bea.contextelement.jmx.ObjectName","com.bea.contextelement.jmx.OldAttributeValue","com.bea.contextelement.jmx.Parameters","com.bea.contextelement.jmx.ShortName","com.bea.contextelement.jmx.Signature","com.bea.contextelement.saml.MessageSignerCertificate","com.bea.contextelement.saml.SSLClientCertificateChain","com.bea.contextelement.saml.subject.ConfirmationMethod","com.bea.contextelement.saml.subject.dom.KeyInfo","com.bea.contextelement.security.ChainPrevailidatedBySSL","com.bea.contextelement.servlet.HttpServletRequest","com.bea.contextelement.servlet.HttpServletResponse","com.bea.contextelement.webservice.Integrity","com.bea.contextelement.wli.Message","com.bea.contextelement.wsee.SOAPMessage","com.bea.contextelement.xml.SecurityToken","com.bea.contextelement.xml.SecurityTokenAssertion"
         * @dynamic false
         * @non-configurable
         * @validatePropertyDeclaration false

         * @preserveWhiteSpace
         */
        public java.lang.String[] getSupportedContextHandlerEntries ();


        
        


        /**
         * No description provided.

         * @default "SimpleSampleAuditor.log"
         * @dynamic false

         * @preserveWhiteSpace
         */
        public java.lang.String getLogFileName ();


        /**
         * No description provided.

         * @default "SimpleSampleAuditor.log"
         * @dynamic false

         * @param newValue - new value for attribute LogFileName
         * @exception InvalidAttributeValueException
         * @preserveWhiteSpace
         */
        public void setLogFileName (java.lang.String newValue)
                throws InvalidAttributeValueException;


        
        


        /**
         * No description provided.

         * @default false
         * @dynamic false

         * @preserveWhiteSpace
         */
        public java.lang.Boolean getEnabled ();


        /**
         * No description provided.

         * @default false
         * @dynamic false

         * @param newValue - new value for attribute Enabled
         * @exception InvalidAttributeValueException
         * @preserveWhiteSpace
         */
        public void setEnabled (java.lang.Boolean newValue)
                throws InvalidAttributeValueException;


        
        


        /**
         * No description provided.

         * @default 1024000
         * @dynamic false

         * @preserveWhiteSpace
         */
        public java.lang.Integer getLogSizeLimit ();


        /**
         * No description provided.

         * @default 1024000
         * @dynamic false

         * @param newValue - new value for attribute LogSizeLimit
         * @exception InvalidAttributeValueException
         * @preserveWhiteSpace
         */
        public void setLogSizeLimit (java.lang.Integer newValue)
                throws InvalidAttributeValueException;


        
        


        /**
         * No description provided.

         * @default 10
         * @dynamic false

         * @preserveWhiteSpace
         */
        public java.lang.Integer getMaxNumberLogFiles ();


        /**
         * No description provided.

         * @default 10
         * @dynamic false

         * @param newValue - new value for attribute MaxNumberLogFiles
         * @exception InvalidAttributeValueException
         * @preserveWhiteSpace
         */
        public void setMaxNumberLogFiles (java.lang.Integer newValue)
                throws InvalidAttributeValueException;



        
        /**
         * @default "SimpleSampleAuditor"
         * @dynamic false
         */
         public java.lang.String getName();

          

}
