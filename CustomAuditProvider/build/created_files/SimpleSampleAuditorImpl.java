package sample.examples.audit.providers;


import javax.management.MBeanException;

import weblogic.management.commo.CommoMBeanInstance;
import weblogic.management.security.audit.ContextHandlerImpl;


public  class SimpleSampleAuditorImpl extends ContextHandlerImpl
  implements java.io.Serializable
{
   static final long serialVersionUID = 1L;

   
   /**
    * @deprecated Replaced by SimpleSampleAuditorImpl (ModelMBean base).
    */
   public SimpleSampleAuditorImpl (CommoMBeanInstance base)
        throws MBeanException
   { super(base); }




   //****************************************************************************************************
   //***************************************** GENERATED METHODS ****************************************
   //****************************************************************************************************


   //****************************************************************************************************
   //******************************************* METHODS STUBS ******************************************
   //****************************************************************************************************
//@constructorMethods


}

