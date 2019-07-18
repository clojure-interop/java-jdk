(ns javax.management.MBeanRegistration
  "Can be implemented by an MBean in order to
  carry out operations before and after being registered or unregistered from
  the MBean Server.  An MBean can also implement this interface in order
  to get a reference to the MBean Server and/or its name within that
  MBean Server."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management MBeanRegistration]))

(defn pre-register
  "Allows the MBean to perform any operations it needs before
   being registered in the MBean Server.  If the name of the MBean
   is not specified, the MBean can provide a name for its
   registration.  If any exception is raised, the MBean will not be
   registered in the MBean Server.

  server - The MBean Server in which the MBean will be registered. - `javax.management.MBeanServer`
  name - The object name of the MBean. This name is null if the name parameter to one of the createMBean or registerMBean methods in the MBeanServer interface is null. In that case, this method must return a non-null ObjectName for the new MBean. - `javax.management.ObjectName`

  returns: The name under which the MBean is to be registered.
   This value must not be null.  If the name
   parameter is not null, it will usually but not necessarily be
   the returned value. - `javax.management.ObjectName`

  throws: java.lang.Exception - This exception will be caught by the MBean Server and re-thrown as an MBeanRegistrationException."
  (^javax.management.ObjectName [^MBeanRegistration this ^javax.management.MBeanServer server ^javax.management.ObjectName name]
    (-> this (.preRegister server name))))

(defn post-register
  "Allows the MBean to perform any operations needed after having been
   registered in the MBean server or after the registration has failed.
   If the implementation of this method throws a RuntimeException
   or an Error, the MBean Server will rethrow those inside
   a RuntimeMBeanException or RuntimeErrorException,
   respectively. However, throwing an exception in postRegister
   will not change the state of the MBean:
   if the MBean was already registered (registrationDone is
   true), the MBean will remain registered.
   This might be confusing for the code calling createMBean()
   or registerMBean(), as such code might assume that MBean
   registration has failed when such an exception is raised.
   Therefore it is recommended that implementations of
   postRegister do not throw Runtime Exceptions or Errors if it
   can be avoided.

  registration-done - Indicates whether or not the MBean has been successfully registered in the MBean server. The value false means that the registration phase has failed. - `java.lang.Boolean`"
  ([^MBeanRegistration this ^java.lang.Boolean registration-done]
    (-> this (.postRegister registration-done))))

(defn pre-deregister
  "Allows the MBean to perform any operations it needs before
   being unregistered by the MBean server.

  throws: java.lang.Exception - This exception will be caught by the MBean server and re-thrown as an MBeanRegistrationException."
  ([^MBeanRegistration this]
    (-> this (.preDeregister))))

(defn post-deregister
  "Allows the MBean to perform any operations needed after having been
   unregistered in the MBean server.
   If the implementation of this method throws a RuntimeException
   or an Error, the MBean Server will rethrow those inside
   a RuntimeMBeanException or RuntimeErrorException,
   respectively. However, throwing an exception in postDeregister
   will not change the state of the MBean:
   the MBean was already successfully deregistered and will remain so.
   This might be confusing for the code calling
   unregisterMBean(), as it might assume that MBean deregistration
   has failed. Therefore it is recommended that implementations of
   postDeregister do not throw Runtime Exceptions or Errors if it
   can be avoided."
  ([^MBeanRegistration this]
    (-> this (.postDeregister))))

