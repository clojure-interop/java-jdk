(ns javax.management.remote.JMXConnectorServerMBean
  "MBean interface for connector servers.  A JMX API connector server
  is attached to an MBean server, and establishes connections to that
  MBean server for remote clients.

  A newly-created connector server is inactive, and does
  not yet listen for connections.  Only when its start
  method has been called does it start listening for connections."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote JMXConnectorServerMBean]))

(defn start
  "Activates the connector server, that is, starts listening for
   client connections.  Calling this method when the connector
   server is already active has no effect.  Calling this method
   when the connector server has been stopped will generate an
   IOException.

  throws: java.io.IOException - if it is not possible to start listening or if the connector server has been stopped."
  ([this]
    (-> this (.start))))

(defn stop
  "Deactivates the connector server, that is, stops listening for
   client connections.  Calling this method will also close all
   client connections that were made by this server.  After this
   method returns, whether normally or with an exception, the
   connector server will not create any new client
   connections.

   Once a connector server has been stopped, it cannot be started
   again.

   Calling this method when the connector server has already
   been stopped has no effect.  Calling this method when the
   connector server has not yet been started will disable the
   connector server object permanently.

   If closing a client connection produces an exception, that
   exception is not thrown from this method.  A JMXConnectionNotification with type JMXConnectionNotification.FAILED is emitted from this MBean
   with the connection ID of the connection that could not be
   closed.

   Closing a connector server is a potentially slow operation.
   For example, if a client machine with an open connection has
   crashed, the close operation might have to wait for a network
   protocol timeout.  Callers that do not want to block in a close
   operation should do it in a separate thread.

  throws: java.io.IOException - if the server cannot be closed cleanly. When this exception is thrown, the server has already attempted to close all client connections. All client connections are closed except possibly those that generated exceptions when the server attempted to close them."
  ([this]
    (-> this (.stop))))

(defn active?
  "Determines whether the connector server is active.  A connector
   server starts being active when its start method
   returns successfully and remains active until either its
   stop method is called or the connector server
   fails.

  returns: true if the connector server is active. - `boolean`"
  ([this]
    (-> this (.isActive))))

(defn set-m-bean-server-forwarder
  "Inserts an object that intercepts requests for the MBean server
   that arrive through this connector server.  This object will be
   supplied as the MBeanServer for any new connection
   created by this connector server.  Existing connections are
   unaffected.

   This method can be called more than once with different
   MBeanServerForwarder objects.  The result is a chain
   of forwarders.  The last forwarder added is the first in the chain.
   In more detail:


   If this connector server is already associated with an
   MBeanServer object, then that object is given to
   mbsf.setMBeanServer.  If doing so produces an exception, this
   method throws the same exception without any other effect.

   If this connector is not already associated with an
   MBeanServer object, or if the
   mbsf.setMBeanServer call just mentioned succeeds,
   then mbsf becomes this connector server's
   MBeanServer.

  mbsf - the new MBeanServerForwarder. - `javax.management.remote.MBeanServerForwarder`

  throws: java.lang.IllegalArgumentException - if the call to mbsf.setMBeanServer fails with IllegalArgumentException. This includes the case where mbsf is null."
  ([this mbsf]
    (-> this (.setMBeanServerForwarder mbsf))))

(defn get-connection-ids
  "The list of IDs for currently-open connections to this
   connector server.

  returns: a new string array containing the list of IDs.  If
   there are no currently-open connections, this array will be
   empty. - `java.lang.String[]`"
  ([this]
    (-> this (.getConnectionIds))))

(defn get-address
  "The address of this connector server.

   The address returned may not be the exact original JMXServiceURL
   that was supplied when creating the connector server, since the original
   address may not always be complete. For example the port number may be
   dynamically allocated when starting the connector server. Instead the
   address returned is the actual JMXServiceURL of the
   JMXConnectorServer. This is the address that clients supply
   to JMXConnectorFactory.connect(JMXServiceURL).

   Note that the address returned may be null if
      the JMXConnectorServer is not yet active.

  returns: the address of this connector server, or null if it
   does not have one. - `javax.management.remote.JMXServiceURL`"
  ([this]
    (-> this (.getAddress))))

(defn get-attributes
  "The attributes for this connector server.

  returns: a read-only map containing the attributes for this
   connector server.  Attributes whose values are not serializable
   are omitted from this map.  If there are no serializable
   attributes, the returned map is empty. - `java.util.Map<java.lang.String,?>`"
  ([this]
    (-> this (.getAttributes))))

(defn to-jmx-connector
  "Returns a client stub for this connector server.  A client
   stub is a serializable object whose connect method can be used to make
   one new connection to this connector server.

   A given connector need not support the generation of client
   stubs.  However, the connectors specified by the JMX Remote API do
   (JMXMP Connector and RMI Connector).

  env - client connection parameters of the same sort that can be provided to JMXConnector.connect(Map). Can be null, which is equivalent to an empty map. - `java.util.Map<java.lang.String,?>`

  returns: a client stub that can be used to make a new connection
   to this connector server. - `javax.management.remote.JMXConnector`

  throws: java.lang.UnsupportedOperationException - if this connector server does not support the generation of client stubs."
  ([this env]
    (-> this (.toJMXConnector env))))

