(ns jdk.beans.AppletInitializer
  " This interface is designed to work in collusion with java.beans.Beans.instantiate.
  The interface is intended to provide mechanism to allow the proper
  initialization of JavaBeans that are also Applets, during their
  instantiation by java.beans.Beans.instantiate()."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans AppletInitializer]))

(defn initialize
  "If passed to the appropriate variant of java.beans.Beans.instantiate
   this method will be called in order to associate the newly instantiated
   Applet (JavaBean) with its AppletContext, AppletStub, and Container.


   Conformant implementations shall:

    Associate the newly instantiated Applet with the appropriate
   AppletContext.

    Instantiate an AppletStub() and associate that AppletStub with
   the Applet via an invocation of setStub().

    If BeanContext parameter is null, then it shall associate the
   Applet with its appropriate Container by adding that Applet to its
   Container via an invocation of add(). If the BeanContext parameter is
   non-null, then it is the responsibility of the BeanContext to associate
   the Applet with its Container during the subsequent invocation of its
   addChildren() method.

  new-applet-bean - The newly instantiated JavaBean - `java.applet.Applet`
  b-ctxt - The BeanContext intended for this Applet, or null. - `java.beans.beancontext.BeanContext`"
  ([^. this ^java.applet.Applet new-applet-bean ^java.beans.beancontext.BeanContext b-ctxt]
    (-> this (.initialize new-applet-bean b-ctxt))))

(defn activate
  "Activate, and/or mark Applet active. Implementors of this interface
   shall mark this Applet as active, and optionally invoke its start()
   method.

  new-applet - The newly instantiated JavaBean - `java.applet.Applet`"
  ([^. this ^java.applet.Applet new-applet]
    (-> this (.activate new-applet))))

