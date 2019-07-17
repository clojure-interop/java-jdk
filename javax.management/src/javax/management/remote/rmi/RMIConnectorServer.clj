(ns javax.management.remote.rmi.RMIConnectorServer
  "A JMX API connector server that creates RMI-based connections
  from remote clients.  Usually, such connector servers are made
  using JMXConnectorServerFactory.  However, specialized applications can
  use this class directly, for example with an RMIServerImpl
  object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote.rmi RMIConnectorServer]))

(defn ->rmi-connector-server
  "Constructor.

  Makes an RMIConnectorServer for the given MBean
   server.

  url - the URL defining how to create the connector server. Cannot be null. - `javax.management.remote.JMXServiceURL`
  environment - attributes governing the creation and storing of the RMI object. Can be null, which is equivalent to an empty Map. - `java.util.Map<java.lang.String,?>`
  rmi-server-impl - An implementation of the RMIServer interface, consistent with the protocol type specified in url. If this parameter is non null, the protocol type specified by url is not constrained, and is assumed to be valid. Otherwise, only `rmi` and `iiop` will be recognized. - `javax.management.remote.rmi.RMIServerImpl`
  mbean-server - the MBean server to which the new connector server is attached, or null if it will be attached by being registered as an MBean in the MBean server. - `javax.management.MBeanServer`

  throws: java.lang.IllegalArgumentException - if url is null."
  ([^javax.management.remote.JMXServiceURL url ^java.util.Map environment ^javax.management.remote.rmi.RMIServerImpl rmi-server-impl ^javax.management.MBeanServer mbean-server]
    (new RMIConnectorServer url environment rmi-server-impl mbean-server))
  ([^javax.management.remote.JMXServiceURL url ^java.util.Map environment ^javax.management.MBeanServer mbean-server]
    (new RMIConnectorServer url environment mbean-server))
  ([^javax.management.remote.JMXServiceURL url ^java.util.Map environment]
    (new RMIConnectorServer url environment)))

(def *-jndi-rebind-attribute
  "Static Constant.

  Name of the attribute that specifies whether the RMIServer stub that represents an RMI connector server should
   override an existing stub at the same address.  The value
   associated with this attribute, if any, should be a string that
   is equal, ignoring case, to `true` or
   `false`.  The default value is false.

  type: java.lang.String"
  RMIConnectorServer/JNDI_REBIND_ATTRIBUTE)

(def *-rmi-client-socket-factory-attribute
  "Static Constant.

  Name of the attribute that specifies the RMIClientSocketFactory for the RMI objects created in
   conjunction with this connector. The value associated with this
   attribute must be of type RMIClientSocketFactory and can
   only be specified in the Map argument supplied when
   creating a connector server.

  type: java.lang.String"
  RMIConnectorServer/RMI_CLIENT_SOCKET_FACTORY_ATTRIBUTE)

(def *-rmi-server-socket-factory-attribute
  "Static Constant.

  Name of the attribute that specifies the RMIServerSocketFactory for the RMI objects created in
   conjunction with this connector. The value associated with this
   attribute must be of type RMIServerSocketFactory and can
   only be specified in the Map argument supplied when
   creating a connector server.

  type: java.lang.String"
  RMIConnectorServer/RMI_SERVER_SOCKET_FACTORY_ATTRIBUTE)

(defn to-jmx-connector
  "Returns a client stub for this connector server.  A client
   stub is a serializable object whose connect method can be used to make
   one new connection to this connector server.

  env - client connection parameters of the same sort that could be provided to JMXConnector.connect(Map). Can be null, which is equivalent to an empty map. - `java.util.Map<java.lang.String,?>`

  returns: a client stub that can be used to make a new connection
   to this connector server. - `javax.management.remote.JMXConnector`

  throws: java.lang.UnsupportedOperationException - if this connector server does not support the generation of client stubs."
  ([^javax.management.remote.rmi.RMIConnectorServer this ^java.util.Map env]
    (-> this (.toJMXConnector env))))

(defn start
  "Activates the connector server, that is starts listening for
   client connections.  Calling this method when the connector
   server is already active has no effect.  Calling this method
   when the connector server has been stopped will generate an
   IOException.

   The behavior of this method when called for the first time
   depends on the parameters that were supplied at construction,
   as described below.

   First, an object of a subclass of RMIServerImpl is
   required, to export the connector server through RMI:



   If an RMIServerImpl was supplied to the
   constructor, it is used.

   Otherwise, if the protocol part of the
   JMXServiceURL supplied to the constructor was
   iiop, an object of type RMIIIOPServerImpl
   is created.

   Otherwise, if the JMXServiceURL
   was null, or its protocol part was rmi, an object
   of type RMIJRMPServerImpl is created.

   Otherwise, the implementation can create an
   implementation-specific RMIServerImpl or it can throw
   MalformedURLException.



   If the given address includes a JNDI directory URL as
   specified in the package documentation for javax.management.remote.rmi, then this
   RMIConnectorServer will bootstrap by binding the
   RMIServerImpl to the given address.

   If the URL path part of the JMXServiceURL was
   empty or a single slash (/), then the RMI object
   will not be bound to a directory.  Instead, a reference to it
   will be encoded in the URL path of the RMIConnectorServer
   address (returned by getAddress()).  The encodings for
   rmi and iiop are described in the
   package documentation for javax.management.remote.rmi.

   The behavior when the URL path is neither empty nor a JNDI
   directory URL, or when the protocol is neither rmi
   nor iiop, is implementation defined, and may
   include throwing MalformedURLException when the
   connector server is created or when it is started.

  throws: java.lang.IllegalStateException - if the connector server has not been attached to an MBean server."
  ([^javax.management.remote.rmi.RMIConnectorServer this]
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
   exception is not thrown from this method.  A JMXConnectionNotification is emitted from this MBean with the
   connection ID of the connection that could not be closed.

   Closing a connector server is a potentially slow operation.
   For example, if a client machine with an open connection has
   crashed, the close operation might have to wait for a network
   protocol timeout.  Callers that do not want to block in a close
   operation should do it in a separate thread.

   This method calls the method close on the connector server's RMIServerImpl
   object.

   If the RMIServerImpl was bound to a JNDI
   directory by the start method, it is unbound
   from the directory by this method.

  throws: java.io.IOException - if the server cannot be closed cleanly, or if the RMIServerImpl cannot be unbound from the directory. When this exception is thrown, the server has already attempted to close all client connections, if appropriate; to call RMIServerImpl.close(); and to unbind the RMIServerImpl from its directory, if appropriate. All client connections are closed except possibly those that generated exceptions when the server attempted to close them."
  ([^javax.management.remote.rmi.RMIConnectorServer this]
    (-> this (.stop))))

(defn active?
  "Description copied from interface: JMXConnectorServerMBean

  returns: true if the connector server is active. - `boolean`"
  ([^javax.management.remote.rmi.RMIConnectorServer this]
    (-> this (.isActive))))

(defn get-address
  "Description copied from interface: JMXConnectorServerMBean

  returns: the address of this connector server, or null if it
   does not have one. - `javax.management.remote.JMXServiceURL`"
  ([^javax.management.remote.rmi.RMIConnectorServer this]
    (-> this (.getAddress))))

(defn get-attributes
  "Description copied from interface: JMXConnectorServerMBean

  returns: a read-only map containing the attributes for this
   connector server.  Attributes whose values are not serializable
   are omitted from this map.  If there are no serializable
   attributes, the returned map is empty. - `java.util.Map<java.lang.String,?>`"
  ([^javax.management.remote.rmi.RMIConnectorServer this]
    (-> this (.getAttributes))))

(defn set-m-bean-server-forwarder
  "Description copied from interface: JMXConnectorServerMBean

  mbsf - the new MBeanServerForwarder. - `javax.management.remote.MBeanServerForwarder`"
  ([^javax.management.remote.rmi.RMIConnectorServer this ^javax.management.remote.MBeanServerForwarder mbsf]
    (-> this (.setMBeanServerForwarder mbsf))))

