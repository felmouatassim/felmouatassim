Tibemsd.conf : all the certificates should have the extension .pem

ssl_server_identity     = C:\Farouk\certs\ems.crt.pem
ssl_server_key          = C:\Farouk\certs\ems.key.pem
ssl_password            = emskey

ssl_server_trusted      = C:\Farouk\certs\client.pem

the client.pem was exported from the identity jks, then converted to pem format

Launch of the java programs :

	java -cp JMS-Properties-Outside.jar;C:\tibco_ems\ems\6.3\lib\tibjms.jar;C:\tibco_ems\ems\6.3\lib\jms.jar;C:\tibco_ems\ems\6.3\lib\tibcrypt.jar;C:\tibco_ems\ems\6.3\lib\TIBCrypt.jar;C:\tibco_ems\ems\6.3\lib\slf4j-api-1.4.2.jar;C:\tibco_ems\ems\6.3\lib\slf4j-simple-1.4.2.jar;C:\Farouk\commons-io-2.4.jar  ma.farouk.jms.SendToSSLSecureQueue
   
   java -cp JMS-Properties-Outside.jar;C:\tibco_ems\ems\6.3\lib\tibjms.jar;C:\tibco_ems\ems\6.3\lib\jms.jar;C:\tibco_ems\ems\6.3\lib\tibcrypt.jar;C:\tibco_ems\ems\6.3\lib\TIBCrypt.jar;C:\tibco_ems\ems\6.3\lib\slf4j-api-1.4.2.jar;C:\tibco_ems\ems\6.3\lib\slf4j-simple-1.4.2.jar;C:\Farouk\commons-io-2.4.jar  ma.farouk.jms.ConsumeFromSSLSecureQueue
   
   java -cp JMS-Properties-Outside.jar;C:\tibco_ems\ems\6.3\lib\tibjms.jar;C:\tibco_ems\ems\6.3\lib\jms.jar;C:\tibco_ems\ems\6.3\lib\tibcrypt.jar;C:\tibco_ems\ems\6.3\lib\TIBCrypt.jar;C:\tibco_ems\ems\6.3\lib\slf4j-api-1.4.2.jar;C:\tibco_ems\ems\6.3\lib\slf4j-simple-1.4.2.jar;C:\Farouk\commons-io-2.4.jar  ma.farouk.jms.PublishToSSLSecureTopic
   
   java -cp JMS-Properties-Outside.jar;C:\tibco_ems\ems\6.3\lib\tibjms.jar;C:\tibco_ems\ems\6.3\lib\jms.jar;C:\tibco_ems\ems\6.3\lib\tibcrypt.jar;C:\tibco_ems\ems\6.3\lib\TIBCrypt.jar;C:\tibco_ems\ems\6.3\lib\slf4j-api-1.4.2.jar;C:\tibco_ems\ems\6.3\lib\slf4j-simple-1.4.2.jar;C:\Farouk\commons-io-2.4.jar  ma.farouk.jms.SubscribeToSSLSecureTopic
   

   
For SSL calls, the ConnectionFactory has an ssl URL.