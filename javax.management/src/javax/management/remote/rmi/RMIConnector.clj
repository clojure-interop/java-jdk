(ns javax.management.remote.rmi.RMIConnector
  "A connection to a remote RMI connector.  Usually, such
  connections are made using JMXConnectorFactory.
  However, specialized applications can use this class directly, for
  example with an RMIServer stub obtained without going
  through JNDI."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote.rmi RMIConnector]))

(defn ->rmi-connector
  "Constructor.

  Constructs an RMIConnector that will connect
   the RMI connector server with the given address.

   The address can refer directly to the connector server,
   using one of the following syntaxes:



   service:jmx:rmi://[host[:port]]/stub/encoded-stub
   service:jmx:iiop://[host[:port]]/ior/encoded-IOR

   (Here, the square brackets [] are not part of the
   address but indicate that the host and port are optional.)

   The address can instead indicate where to find an RMI stub
   through JNDI, using one of the following syntaxes:



   service:jmx:rmi://[host[:port]]/jndi/jndi-name
   service:jmx:iiop://[host[:port]]/jndi/jndi-name

   An implementation may also recognize additional address
   syntaxes, for example:



   service:jmx:iiop://[host[:port]]/stub/encoded-stub

  url - the address of the RMI connector server. - `javax.management.remote.JMXServiceURL`
  environment - additional attributes specifying how to make the connection. For JNDI-based addresses, these attributes can usefully include JNDI attributes recognized by InitialContext. This parameter can be null, which is equivalent to an empty Map. - `java.util.Map<java.lang.String,?>`

  throws: java.lang.IllegalArgumentException - if url is null."
  ([^javax.management.remote.JMXServiceURL url ^java.util.Map environment]
    (new RMIConnector url environment)))

(defn to-string
  "Returns a string representation of this object.  In general,
   the toString method returns a string that
   `textually represents` this object. The result should be a
   concise but informative representation that is easy for a
   person to read.

  returns: a String representation of this object. - `java.lang.String`"
  ([^javax.management.remote.rmi.RMIConnector this]
    (-> this (.toString))))

(defn get-address
  "The address of this connector.

  returns: the address of this connector, or null if it
   does not have one. - `javax.management.remote.JMXServiceURL`"
  ([^javax.management.remote.rmi.RMIConnector this]
    (-> this (.getAddress))))

(defn connect
  "Description copied from interface: JMXConnector

  environment - the properties of the connection. Properties in this map override properties in the map specified when the JMXConnector was created, if any. This parameter can be null, which is equivalent to an empty map. - `java.util.Map<java.lang.String,?>`

  throws: java.io.IOException - if the connection could not be made because of a communication problem, or in the case of the iiop protocol, that RMI/IIOP is not supported"
  ([^javax.management.remote.rmi.RMIConnector this ^java.util.Map environment]
    (-> this (.connect environment)))
  ([^javax.management.remote.rmi.RMIConnector this]
    (-> this (.connect))))

(defn get-connection-id
  "Description copied from interface: JMXConnector

  returns: the unique ID of this connection.  This is the same as
   the ID that the connector server includes in its JMXConnectionNotifications.  The package description describes the
   conventions for connection IDs. - `java.lang.String`

  throws: java.io.IOException - if the connection ID cannot be obtained, for instance because the connection is closed or broken."
  ([^javax.management.remote.rmi.RMIConnector this]
    (-> this (.getConnectionId))))

(defn get-m-bean-server-connection
  "Description copied from interface: JMXConnector

  delegation-subject - the Subject on behalf of which requests will be performed. Can be null, in which case requests will be performed on behalf of the authenticated Subject, if any. - `javax.security.auth.Subject`

  returns: an object that implements the MBeanServerConnection
   interface by forwarding its methods to the remote MBean server on behalf
   of a given delegation subject. - `javax.management.MBeanServerConnection`

  throws: java.io.IOException - if a valid MBeanServerConnection cannot be created, for instance because the connection to the remote MBean server has not yet been established (with the connect method), or it has been closed, or it has broken."
  ([^javax.management.remote.rmi.RMIConnector this ^javax.security.auth.Subject delegation-subject]
    (-> this (.getMBeanServerConnection delegation-subject)))
  ([^javax.management.remote.rmi.RMIConnector this]
    (-> this (.getMBeanServerConnection))))

(defn add-connection-notification-listener
  "Description copied from interface: JMXConnector

  listener - a listener to receive connection status notifications. - `javax.management.NotificationListener`
  filter - a filter to select which notifications are to be delivered to the listener, or null if all notifications are to be delivered. - `javax.management.NotificationFilter`
  handback - an object to be given to the listener along with each notification. Can be null. - `java.lang.Object`"
  ([^javax.management.remote.rmi.RMIConnector this ^javax.management.NotificationListener listener ^javax.management.NotificationFilter filter ^java.lang.Object handback]
    (-> this (.addConnectionNotificationListener listener filter handback))))

(defn remove-connection-notification-listener
  "Description copied from interface: JMXConnector

  listener - a listener to receive connection status notifications. - `javax.management.NotificationListener`
  filter - a filter to select which notifications are to be delivered to the listener. Can be null. - `javax.management.NotificationFilter`
  handback - an object to be given to the listener along with each notification. Can be null. - `java.lang.Object`

  throws: javax.management.ListenerNotFoundException - if the listener is not registered with this JMXConnector, or is not registered with the given filter and handback."
  ([^javax.management.remote.rmi.RMIConnector this ^javax.management.NotificationListener listener ^javax.management.NotificationFilter filter ^java.lang.Object handback]
    (-> this (.removeConnectionNotificationListener listener filter handback)))
  ([^javax.management.remote.rmi.RMIConnector this ^javax.management.NotificationListener listener]
    (-> this (.removeConnectionNotificationListener listener))))

(defn close
  "Description copied from interface: JMXConnector

  throws: java.io.IOException - if the connection cannot be closed cleanly. If this exception is thrown, it is not known whether the server end of the connection has been cleanly closed."
  ([^javax.management.remote.rmi.RMIConnector this]
    (-> this (.close))))

