(ns javax.management.remote.JMXConnectorServer
  "Superclass of every connector server.  A connector server is
  attached to an MBean server.  It listens for client connection
  requests and creates a connection for each one.

  A connector server is associated with an MBean server either by
  registering it in that MBean server, or by passing the MBean server
  to its constructor.

  A connector server is inactive when created.  It only starts
  listening for client connections when the start
  method is called.  A connector server stops listening for client
  connections when the stop method is called or when
  the connector server is unregistered from its MBean server.

  Stopping a connector server does not unregister it from its
  MBean server.  A connector server once stopped cannot be
  restarted.

  Each time a client connection is made or broken, a notification
  of class JMXConnectionNotification is emitted."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote JMXConnectorServer]))

(defn ->jmx-connector-server
  "Constructor.

  Constructs a connector server that is attached to the given
   MBean server.  A connector server that is created in this way
   can be registered in a different MBean server, or not registered
   in any MBean server.

  mbean-server - the MBean server that this connector server is attached to. Null if this connector server will be attached to an MBean server by being registered in it. - `javax.management.MBeanServer`"
  ([mbean-server]
    (new JMXConnectorServer mbean-server))
  ([]
    (new JMXConnectorServer )))

(def *-authenticator
  "Static Constant.

  Name of the attribute that specifies the authenticator for a
   connector server.  The value associated with this attribute, if
   any, must be an object that implements the interface JMXAuthenticator.

  type: java.lang.String"
  JMXConnectorServer/AUTHENTICATOR)

(defn get-m-bean-server
  "Returns the MBean server that this connector server is
   attached to.

  returns: the MBean server that this connector server is attached
   to, or null if it is not yet attached to an MBean server. - `javax.management.MBeanServer`"
  ([this]
    (-> this (.getMBeanServer))))

(defn set-m-bean-server-forwarder
  "Description copied from interface: JMXConnectorServerMBean

  mbsf - the new MBeanServerForwarder. - `javax.management.remote.MBeanServerForwarder`"
  ([this mbsf]
    (-> this (.setMBeanServerForwarder mbsf))))

(defn get-notification-info
  "Returns an array indicating the notifications that this MBean
   sends. The implementation in JMXConnectorServer
   returns an array with one element, indicating that it can emit
   notifications of class JMXConnectionNotification with
   the types defined in that class.  A subclass that can emit other
   notifications should return an array that contains this element
   plus descriptions of the other notifications.

  returns: the array of possible notifications. - `javax.management.MBeanNotificationInfo[]`"
  ([this]
    (-> this (.getNotificationInfo))))

(defn post-deregister
  "Description copied from interface: MBeanRegistration"
  ([this]
    (-> this (.postDeregister))))

(defn pre-deregister
  "Called by an MBean server when this connector server is
   unregistered from that MBean server.  If this connector server
   was attached to that MBean server by being registered in it,
   and if the connector server is still active,
   then unregistering it will call the stop method.
   If the stop method throws an exception, the
   unregistration attempt will fail.  It is recommended to call
   the stop method explicitly before unregistering
   the MBean.

  throws: java.io.IOException - if thrown by the stop method."
  ([this]
    (-> this (.preDeregister))))

(defn get-connection-ids
  "Description copied from interface: JMXConnectorServerMBean

  returns: a new string array containing the list of IDs.  If
   there are no currently-open connections, this array will be
   empty. - `java.lang.String[]`"
  ([this]
    (-> this (.getConnectionIds))))

(defn to-jmx-connector
  "Returns a client stub for this connector server.  A client
   stub is a serializable object whose connect method can be used to make
   one new connection to this connector server.

   A given connector need not support the generation of client
   stubs.  However, the connectors specified by the JMX Remote API do
   (JMXMP Connector and RMI Connector).

   The default implementation of this method uses JMXConnectorServerMBean.getAddress() and JMXConnectorFactory to generate the
   stub, with code equivalent to the following:



   JMXServiceURL addr = getAddress();
   return JMXConnectorFactory.newJMXConnector(addr, env);

   A connector server for which this is inappropriate must
   override this method so that it either implements the
   appropriate logic or throws UnsupportedOperationException.

  env - client connection parameters of the same sort that could be provided to JMXConnector.connect(Map). Can be null, which is equivalent to an empty map. - `java.util.Map<java.lang.String,?>`

  returns: a client stub that can be used to make a new connection
   to this connector server. - `javax.management.remote.JMXConnector`

  throws: java.lang.UnsupportedOperationException - if this connector server does not support the generation of client stubs."
  ([this env]
    (-> this (.toJMXConnector env))))

(defn post-register
  "Description copied from interface: MBeanRegistration

  registration-done - Indicates whether or not the MBean has been successfully registered in the MBean server. The value false means that the registration phase has failed. - `java.lang.Boolean`"
  ([this registration-done]
    (-> this (.postRegister registration-done))))

(defn pre-register
  "Called by an MBean server when this connector server is
   registered in that MBean server.  This connector server becomes
   attached to the MBean server and its getMBeanServer()
   method will return mbs.

   If this connector server is already attached to an MBean
   server, this method has no effect.  The MBean server it is
   attached to is not necessarily the one it is being registered
   in.

  mbs - the MBean server in which this connection server is being registered. - `javax.management.MBeanServer`
  name - The object name of the MBean. - `javax.management.ObjectName`

  returns: The name under which the MBean is to be registered. - `javax.management.ObjectName`

  throws: java.lang.NullPointerException - if mbs or name is null."
  ([this mbs name]
    (-> this (.preRegister mbs name))))

