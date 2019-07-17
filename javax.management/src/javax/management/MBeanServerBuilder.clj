(ns javax.management.MBeanServerBuilder
  "This class represents a builder that creates a default
  MBeanServer implementation.
  The JMX MBeanServerFactory allows
  applications to provide their custom MBeanServer
  implementation by providing a subclass of this class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management MBeanServerBuilder]))

(defn ->m-bean-server-builder
  "Constructor.

  Public default constructor."
  ([]
    (new MBeanServerBuilder )))

(defn new-m-bean-server-delegate
  "This method creates a new MBeanServerDelegate for a new MBeanServer.
   When creating a new MBeanServer the
   MBeanServerFactory first calls this method
   in order to create a new MBeanServerDelegate.
   Then it calls
   newMBeanServer(defaultDomain,outer,delegate)
   passing the delegate that should be used by the MBeanServer
   implementation.
   Note that the passed delegate might not be directly the
   MBeanServerDelegate that was returned by this method. It could
   be, for instance, a new object wrapping the previously
   returned object.

  returns: A new MBeanServerDelegate. - `javax.management.MBeanServerDelegate`"
  (^javax.management.MBeanServerDelegate [^javax.management.MBeanServerBuilder this]
    (-> this (.newMBeanServerDelegate))))

(defn new-m-bean-server
  "This method creates a new MBeanServer implementation object.
   When creating a new MBeanServer the
   MBeanServerFactory first calls
   newMBeanServerDelegate() in order to obtain a new
   MBeanServerDelegate for the new
   MBeanServer. Then it calls
   newMBeanServer(defaultDomain,outer,delegate)
   passing the delegate that should be used by the MBeanServer
   implementation.
   Note that the passed delegate might not be directly the
   MBeanServerDelegate that was returned by this implementation. It could
   be, for instance, a new object wrapping the previously
   returned delegate.
   The outer parameter is a pointer to the MBeanServer that
   should be passed to the MBeanRegistration
   interface when registering MBeans inside the MBeanServer.
   If outer is null, then the MBeanServer
   implementation must use its own this reference when
   invoking the MBeanRegistration interface.
   This makes it possible for a MBeanServer implementation to wrap
   another MBeanServer implementation, in order to implement, e.g,
   security checks, or to prevent access to the actual MBeanServer
   implementation by returning a pointer to a wrapping object.

  default-domain - Default domain of the new MBeanServer. - `java.lang.String`
  outer - A pointer to the MBeanServer object that must be passed to the MBeans when invoking their MBeanRegistration interface. - `javax.management.MBeanServer`
  delegate - A pointer to the MBeanServerDelegate associated with the new MBeanServer. The new MBeanServer must register this MBean in its MBean repository. - `javax.management.MBeanServerDelegate`

  returns: A new private implementation of an MBeanServer. - `javax.management.MBeanServer`"
  (^javax.management.MBeanServer [^javax.management.MBeanServerBuilder this ^java.lang.String default-domain ^javax.management.MBeanServer outer ^javax.management.MBeanServerDelegate delegate]
    (-> this (.newMBeanServer default-domain outer delegate))))

