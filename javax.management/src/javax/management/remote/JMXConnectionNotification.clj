(ns javax.management.remote.JMXConnectionNotification
  "Notification emitted when a client connection is opened or
  closed or when notifications are lost.  These notifications are
  sent by connector servers (instances of JMXConnectorServer)
  and by connector clients (instances of JMXConnector).  For
  certain connectors, a session can consist of a sequence of
  connections.  Connection-opened and connection-closed notifications
  will be sent for each one.

  The notification type is one of the following:




  Type
  Meaning



  jmx.remote.connection.opened
  A new client connection has been opened.



  jmx.remote.connection.closed
  A client connection has been closed.



  jmx.remote.connection.failed
  A client connection has failed unexpectedly.



  jmx.remote.connection.notifs.lost
  A client connection has potentially lost notifications.  This
  notification only appears on the client side.



  The timeStamp of the notification is a time value
  (consistent with System.currentTimeMillis()) indicating
  when the notification was constructed."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote JMXConnectionNotification]))

(defn ->jmx-connection-notification
  "Constructor.

  Constructs a new connection notification.  The source of the notification depends on whether it
   is being sent by a connector server or a connector client:



   For a connector server, if it is registered in an MBean
   server, the source is the ObjectName under which it is
   registered.  Otherwise, it is a reference to the connector
   server object itself, an instance of a subclass of JMXConnectorServer.

   For a connector client, the source is a reference to the
   connector client object, an instance of a class implementing
   JMXConnector.

  type - the type of the notification. This is usually one of the constants OPENED, CLOSED, FAILED, NOTIFS_LOST. It is not an error for it to be a different string. - `java.lang.String`
  source - the connector server or client emitting the notification. - `java.lang.Object`
  connection-id - the ID of the connection within its connector server. - `java.lang.String`
  sequence-number - a non-negative integer. It is expected but not required that this number will be greater than any previous sequenceNumber in a notification from this source. - `long`
  message - an unspecified text message, typically containing a human-readable description of the event. Can be null. - `java.lang.String`
  user-data - an object whose type and meaning is defined by the connector server. Can be null. - `java.lang.Object`

  throws: java.lang.NullPointerException - if type, source, or connectionId is null."
  ([^java.lang.String type ^java.lang.Object source ^java.lang.String connection-id ^Long sequence-number ^java.lang.String message ^java.lang.Object user-data]
    (new JMXConnectionNotification type source connection-id sequence-number message user-data)))

(def *-opened
  "Static Constant.

  Notification type string for a connection-opened notification.

  type: java.lang.String"
  JMXConnectionNotification/OPENED)

(def *-closed
  "Static Constant.

  Notification type string for a connection-closed notification.

  type: java.lang.String"
  JMXConnectionNotification/CLOSED)

(def *-failed
  "Static Constant.

  Notification type string for a connection-failed notification.

  type: java.lang.String"
  JMXConnectionNotification/FAILED)

(def *-notifs-lost
  "Static Constant.

  Notification type string for a connection that has possibly
   lost notifications.

  type: java.lang.String"
  JMXConnectionNotification/NOTIFS_LOST)

(defn get-connection-id
  "The connection ID to which this notification pertains.

  returns: the connection ID. - `java.lang.String`"
  ([^javax.management.remote.JMXConnectionNotification this]
    (-> this (.getConnectionId))))

