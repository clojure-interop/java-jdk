(ns javax.management.remote.JMXConnector
  "The client end of a JMX API connector.  An object of this type can
  be used to establish a connection to a connector server.

  A newly-created object of this type is unconnected.  Its connect method must be called before it can be used.
  However, objects created by JMXConnectorFactory.connect are already connected."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote JMXConnector]))

(defn connect
  "Establishes the connection to the connector server.

   If connect has already been called successfully
   on this object, calling it again has no effect.  If, however,
   close() was called after connect, the new
   connect will throw an IOException.

   Otherwise, either connect has never been called
   on this object, or it has been called but produced an
   exception.  Then calling connect will attempt to
   establish a connection to the connector server.

  env - the properties of the connection. Properties in this map override properties in the map specified when the JMXConnector was created, if any. This parameter can be null, which is equivalent to an empty map. - `java.util.Map`

  throws: java.io.IOException - if the connection could not be made because of a communication problem."
  ([^JMXConnector this ^java.util.Map env]
    (-> this (.connect env)))
  ([^JMXConnector this]
    (-> this (.connect))))

(defn get-m-bean-server-connection
  "Returns an MBeanServerConnection object representing
   a remote MBean server on which operations are performed on behalf of
   the supplied delegation subject. For a given JMXConnector
   and Subject, two successful calls to this method will
   usually return the same MBeanServerConnection object,
   though this is not required.

   For each method in the returned
   MBeanServerConnection, calling the method causes
   the corresponding method to be called in the remote MBean
   server on behalf of the given delegation subject instead of the
   authenticated subject. The value returned by the MBean server
   method is the value returned to the client. If the MBean server
   method produces an Exception, the same
   Exception is seen by the client. If the MBean
   server method, or the attempt to call it, produces an
   Error, the Error is wrapped in a
   JMXServerErrorException, which is seen by the
   client.

  delegation-subject - the Subject on behalf of which requests will be performed. Can be null, in which case requests will be performed on behalf of the authenticated Subject, if any. - `javax.security.auth.Subject`

  returns: an object that implements the MBeanServerConnection
   interface by forwarding its methods to the remote MBean server on behalf
   of a given delegation subject. - `javax.management.MBeanServerConnection`

  throws: java.io.IOException - if a valid MBeanServerConnection cannot be created, for instance because the connection to the remote MBean server has not yet been established (with the connect method), or it has been closed, or it has broken."
  (^javax.management.MBeanServerConnection [^JMXConnector this ^javax.security.auth.Subject delegation-subject]
    (-> this (.getMBeanServerConnection delegation-subject)))
  (^javax.management.MBeanServerConnection [^JMXConnector this]
    (-> this (.getMBeanServerConnection))))

(defn close
  "Closes the client connection to its server.  Any ongoing or new
   request using the MBeanServerConnection returned by getMBeanServerConnection() will get an
   IOException.

   If close has already been called successfully
   on this object, calling it again has no effect.  If
   close has never been called, or if it was called
   but produced an exception, an attempt will be made to close the
   connection.  This attempt can succeed, in which case
   close will return normally, or it can generate an
   exception.

   Closing a connection is a potentially slow operation.  For
   example, if the server has crashed, the close operation might
   have to wait for a network protocol timeout.  Callers that do
   not want to block in a close operation should do it in a
   separate thread.

  throws: java.io.IOException - if the connection cannot be closed cleanly. If this exception is thrown, it is not known whether the server end of the connection has been cleanly closed."
  ([^JMXConnector this]
    (-> this (.close))))

(defn add-connection-notification-listener
  "Adds a listener to be informed of changes in connection
   status.  The listener will receive notifications of type JMXConnectionNotification.  An implementation can send other
   types of notifications too.

   Any number of listeners can be added with this method.  The
   same listener can be added more than once with the same or
   different values for the filter and handback.  There is no
   special treatment of a duplicate entry.  For example, if a
   listener is registered twice with no filter, then its
   handleNotification method will be called twice for
   each notification.

  listener - a listener to receive connection status notifications. - `javax.management.NotificationListener`
  filter - a filter to select which notifications are to be delivered to the listener, or null if all notifications are to be delivered. - `javax.management.NotificationFilter`
  handback - an object to be given to the listener along with each notification. Can be null. - `java.lang.Object`

  throws: java.lang.NullPointerException - if listener is null."
  ([^JMXConnector this ^javax.management.NotificationListener listener ^javax.management.NotificationFilter filter ^java.lang.Object handback]
    (-> this (.addConnectionNotificationListener listener filter handback))))

(defn remove-connection-notification-listener
  "Removes a listener from the list to be informed of changes
   in status.  The listener must previously have been added with
   the same three parameters.  If there is more than one matching
   listener, only one is removed.

  l - a listener to receive connection status notifications. - `javax.management.NotificationListener`
  f - a filter to select which notifications are to be delivered to the listener. Can be null. - `javax.management.NotificationFilter`
  handback - an object to be given to the listener along with each notification. Can be null. - `java.lang.Object`

  throws: javax.management.ListenerNotFoundException - if the listener is not registered with this JMXConnector, or is not registered with the given filter and handback."
  ([^JMXConnector this ^javax.management.NotificationListener l ^javax.management.NotificationFilter f ^java.lang.Object handback]
    (-> this (.removeConnectionNotificationListener l f handback)))
  ([^JMXConnector this ^javax.management.NotificationListener listener]
    (-> this (.removeConnectionNotificationListener listener))))

(defn get-connection-id
  "Gets this connection's ID from the connector server.  For a
   given connector server, every connection will have a unique id
   which does not change during the lifetime of the
   connection.

  returns: the unique ID of this connection.  This is the same as
   the ID that the connector server includes in its JMXConnectionNotifications.  The package description describes the
   conventions for connection IDs. - `java.lang.String`

  throws: java.io.IOException - if the connection ID cannot be obtained, for instance because the connection is closed or broken."
  (^java.lang.String [^JMXConnector this]
    (-> this (.getConnectionId))))

