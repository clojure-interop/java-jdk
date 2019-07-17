(ns javax.management.remote.rmi.RMIConnection
  "RMI object used to forward an MBeanServer request from a client
  to its MBeanServer implementation on the server side.  There is one
  Remote object implementing this interface for each remote client
  connected to an RMI connector.

  User code does not usually refer to this interface.  It is
  specified as part of the public API so that different
  implementations of that API will interoperate.

  To ensure that client parameters will be deserialized at the
  server side with the correct classloader, client parameters such as
  parameters used to invoke a method are wrapped in a MarshalledObject.  An implementation of this interface must first
  get the appropriate class loader for the operation and its target,
  then deserialize the marshalled parameters with this classloader.
  Except as noted, a parameter that is a
  MarshalledObject or MarshalledObject[]
  must not be null; the behavior is unspecified if it is.

  Class loading aspects are detailed in the

  JMX Specification, version 1.4 PDF document.

  Most methods in this interface parallel methods in the MBeanServerConnection interface.  Where an aspect of the behavior
  of a method is not specified here, it is the same as in the
  corresponding MBeanServerConnection method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote.rmi RMIConnection]))

(defn invoke
  "Handles the method MBeanServerConnection.invoke(ObjectName,
   String, Object[], String[]).  The Object[]
   parameter is wrapped in a MarshalledObject.

  name - The object name of the MBean on which the method is to be invoked. - `javax.management.ObjectName`
  operation-name - The name of the operation to be invoked. - `java.lang.String`
  params - An array containing the parameters to be set when the operation is invoked, encapsulated into a MarshalledObject. The encapsulated array can be null, equivalent to an empty array. - `java.rmi.MarshalledObject`
  signature - An array containing the signature of the operation. The class objects will be loaded using the same class loader as the one used for loading the MBean on which the operation was invoked. Can be null, equivalent to an empty array. - `java.lang.String[]`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: The object returned by the operation, which represents
   the result of invoking the operation on the MBean specified. - `java.lang.Object`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  ([this name operation-name params signature delegation-subject]
    (-> this (.invoke name operation-name params signature delegation-subject))))

(defn query-m-beans
  "Handles the method MBeanServerConnection.queryMBeans(ObjectName,
   QueryExp).  The QueryExp is wrapped in a
   MarshalledObject.

  name - The object name pattern identifying the MBeans to be retrieved. If null or no domain and key properties are specified, all the MBeans registered will be retrieved. - `javax.management.ObjectName`
  query - The query expression to be applied for selecting MBeans, encapsulated into a MarshalledObject. If the MarshalledObject encapsulates a null value no query expression will be applied for selecting MBeans. - `java.rmi.MarshalledObject`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: A set containing the ObjectInstance
   objects for the selected MBeans.  If no MBean satisfies the
   query an empty list is returned. - `java.util.Set<javax.management.ObjectInstance>`

  throws: java.lang.SecurityException - if the client, or the delegated Subject if any, does not have permission to perform this operation."
  ([this name query delegation-subject]
    (-> this (.queryMBeans name query delegation-subject))))

(defn query-names
  "Handles the method MBeanServerConnection.queryNames(ObjectName,
   QueryExp).  The QueryExp is wrapped in a
   MarshalledObject.

  name - The object name pattern identifying the MBean names to be retrieved. If null or no domain and key properties are specified, the name of all registered MBeans will be retrieved. - `javax.management.ObjectName`
  query - The query expression to be applied for selecting MBeans, encapsulated into a MarshalledObject. If the MarshalledObject encapsulates a null value no query expression will be applied for selecting MBeans. - `java.rmi.MarshalledObject`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: A set containing the ObjectNames for the MBeans
   selected.  If no MBean satisfies the query, an empty list is
   returned. - `java.util.Set<javax.management.ObjectName>`

  throws: java.lang.SecurityException - if the client, or the delegated Subject if any, does not have permission to perform this operation."
  ([this name query delegation-subject]
    (-> this (.queryNames name query delegation-subject))))

(defn remove-notification-listeners
  "Handles the
   removeNotificationListener(ObjectName, NotificationListener) and
   removeNotificationListener(ObjectName, NotificationListener, NotificationFilter, Object) methods.

   This method removes one or more
   NotificationListeners from a given MBean in the
   MBean server.

   The NotificationListeners are identified by the
   IDs which were returned by the addNotificationListeners(ObjectName[], MarshalledObject[],
   Subject[]) method.

  name - the ObjectName identifying the MBean emitting the Notifications. - `javax.management.ObjectName`
  listener-i-ds - the list of the IDs corresponding to the listeners to remove. - `java.lang.Integer[]`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  throws: javax.management.InstanceNotFoundException - if the given name does not correspond to any registered MBean."
  ([this name listener-i-ds delegation-subject]
    (-> this (.removeNotificationListeners name listener-i-ds delegation-subject))))

(defn remove-notification-listener
  "Handles the method MBeanServerConnection.removeNotificationListener(ObjectName,
   ObjectName, NotificationFilter, Object).  The
   NotificationFilter parameter is wrapped in a
   MarshalledObject.  The Object
   parameter is also wrapped in a MarshalledObject.

  name - The name of the MBean on which the listener should be removed. - `javax.management.ObjectName`
  listener - A listener that was previously added to this MBean. - `javax.management.ObjectName`
  filter - The filter that was specified when the listener was added, encapsulated into a MarshalledObject. - `java.rmi.MarshalledObject`
  handback - The handback that was specified when the listener was added, encapsulated into a MarshalledObject. - `java.rmi.MarshalledObject`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  throws: javax.management.InstanceNotFoundException - The MBean name provided does not match any of the registered MBeans."
  ([this name listener filter handback delegation-subject]
    (-> this (.removeNotificationListener name listener filter handback delegation-subject)))
  ([this name listener delegation-subject]
    (-> this (.removeNotificationListener name listener delegation-subject))))

(defn get-attribute
  "Handles the method MBeanServerConnection.getAttribute(ObjectName,
   String).

  name - The object name of the MBean from which the attribute is to be retrieved. - `javax.management.ObjectName`
  attribute - A String specifying the name of the attribute to be retrieved. - `java.lang.String`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: The value of the retrieved attribute. - `java.lang.Object`

  throws: javax.management.AttributeNotFoundException - The attribute specified is not accessible in the MBean."
  ([this name attribute delegation-subject]
    (-> this (.getAttribute name attribute delegation-subject))))

(defn get-m-bean-info
  "Handles the method
   MBeanServerConnection.getMBeanInfo(ObjectName).

  name - The name of the MBean to analyze - `javax.management.ObjectName`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: An instance of MBeanInfo allowing the
   retrieval of all attributes and operations of this MBean. - `javax.management.MBeanInfo`

  throws: javax.management.IntrospectionException - An exception occurred during introspection."
  ([this name delegation-subject]
    (-> this (.getMBeanInfo name delegation-subject))))

(defn create-m-bean
  "Handles the method MBeanServerConnection.createMBean(String,
   ObjectName, ObjectName, Object[], String[]).  The
   Object[] parameter is wrapped in a
   MarshalledObject.

  class-name - The class name of the MBean to be instantiated. - `java.lang.String`
  name - The object name of the MBean. May be null. - `javax.management.ObjectName`
  loader-name - The object name of the class loader to be used. - `javax.management.ObjectName`
  params - An array containing the parameters of the constructor to be invoked, encapsulated into a MarshalledObject. The encapsulated array can be null, equivalent to an empty array. - `java.rmi.MarshalledObject`
  signature - An array containing the signature of the constructor to be invoked. Can be null, equivalent to an empty array. - `java.lang.String[]`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: An ObjectInstance, containing the
   ObjectName and the Java class name of the newly
   instantiated MBean.  If the contained ObjectName
   is n, the contained Java class name is
   getMBeanInfo(n).getClassName(). - `javax.management.ObjectInstance`

  throws: javax.management.MBeanException - The constructor of the MBean has thrown an exception."
  ([this class-name name loader-name params signature delegation-subject]
    (-> this (.createMBean class-name name loader-name params signature delegation-subject)))
  ([this class-name name params signature delegation-subject]
    (-> this (.createMBean class-name name params signature delegation-subject)))
  ([this class-name name loader-name delegation-subject]
    (-> this (.createMBean class-name name loader-name delegation-subject)))
  ([this class-name name delegation-subject]
    (-> this (.createMBean class-name name delegation-subject))))

(defn get-m-bean-count
  "Handles the method
   MBeanServerConnection.getMBeanCount().

  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: the number of MBeans registered. - `java.lang.Integer`

  throws: java.lang.SecurityException - if the client, or the delegated Subject if any, does not have permission to perform this operation."
  ([this delegation-subject]
    (-> this (.getMBeanCount delegation-subject))))

(defn registered?
  "Handles the method
   MBeanServerConnection.isRegistered(ObjectName).

  name - The object name of the MBean to be checked. - `javax.management.ObjectName`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: True if the MBean is already registered in the MBean
   server, false otherwise. - `boolean`

  throws: javax.management.RuntimeOperationsException - Wraps a java.lang.IllegalArgumentException: The object name in parameter is null."
  ([this name delegation-subject]
    (-> this (.isRegistered name delegation-subject))))

(defn add-notification-listeners
  "Handles the method MBeanServerConnection.addNotificationListener(ObjectName,
   NotificationListener, NotificationFilter, Object).

   Register for notifications from the given MBeans that match
   the given filters.  The remote client can subsequently retrieve
   the notifications using the fetchNotifications method.

   For each listener, the original
   NotificationListener and handback are
   kept on the client side; in order for the client to be able to
   identify them, the server generates and returns a unique
   listenerID.  This listenerID is
   forwarded with the Notifications to the remote
   client.

   If any one of the given (name, filter) pairs cannot be
   registered, then the operation fails with an exception, and no
   names or filters are registered.

  names - the ObjectNames identifying the MBeans emitting the Notifications. - `javax.management.ObjectName[]`
  filters - an array of marshalled representations of the NotificationFilters. Elements of this array can be null. - `java.rmi.MarshalledObject[]`
  delegation-subjects - the Subjects on behalf of which the listeners are being added. Elements of this array can be null. Also, the delegationSubjects parameter itself can be null, which is equivalent to an array of null values with the same size as the names and filters arrays. - `javax.security.auth.Subject[]`

  returns: an array of listenerIDs identifying the
   local listeners.  This array has the same number of elements as
   the parameters. - `java.lang.Integer[]`

  throws: java.lang.IllegalArgumentException - if names or filters is null, or if names contains a null element, or if the three arrays do not all have the same size."
  ([this names filters delegation-subjects]
    (-> this (.addNotificationListeners names filters delegation-subjects))))

(defn unregister-m-bean
  "Handles the method
   MBeanServerConnection.unregisterMBean(ObjectName).

  name - The object name of the MBean to be unregistered. - `javax.management.ObjectName`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  ([this name delegation-subject]
    (-> this (.unregisterMBean name delegation-subject))))

(defn get-default-domain
  "Handles the method
   MBeanServerConnection.getDefaultDomain().

  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: the default domain. - `java.lang.String`

  throws: java.lang.SecurityException - if the client, or the delegated Subject if any, does not have permission to perform this operation."
  ([this delegation-subject]
    (-> this (.getDefaultDomain delegation-subject))))

(defn set-attribute
  "Handles the method MBeanServerConnection.setAttribute(ObjectName,
   Attribute).  The Attribute parameter is wrapped
   in a MarshalledObject.

  name - The name of the MBean within which the attribute is to be set. - `javax.management.ObjectName`
  attribute - The identification of the attribute to be set and the value it is to be set to, encapsulated into a MarshalledObject. - `java.rmi.MarshalledObject`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  ([this name attribute delegation-subject]
    (-> this (.setAttribute name attribute delegation-subject))))

(defn get-object-instance
  "Handles the method
   MBeanServerConnection.getObjectInstance(ObjectName).

  name - The object name of the MBean. - `javax.management.ObjectName`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: The ObjectInstance associated with the MBean
   specified by name.  The contained ObjectName
   is name and the contained class name is
   getMBeanInfo(name).getClassName(). - `javax.management.ObjectInstance`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  ([this name delegation-subject]
    (-> this (.getObjectInstance name delegation-subject))))

(defn get-domains
  "Handles the method
   MBeanServerConnection.getDomains().

  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: the list of domains. - `java.lang.String[]`

  throws: java.lang.SecurityException - if the client, or the delegated Subject if any, does not have permission to perform this operation."
  ([this delegation-subject]
    (-> this (.getDomains delegation-subject))))

(defn close
  "Closes this connection.  On return from this method, the RMI
   object implementing this interface is unexported, so further
   remote calls to it will fail.

  throws: java.io.IOException - if the connection could not be closed, or the Remote object could not be unexported, or there was a communication failure when transmitting the remote close request."
  ([this]
    (-> this (.close))))

(defn get-connection-id
  "Returns the connection ID.  This string is different for
   every open connection to a given RMI connector server.

  returns: the connection ID - `java.lang.String`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this]
    (-> this (.getConnectionId))))

(defn set-attributes
  "Handles the method MBeanServerConnection.setAttributes(ObjectName,
   AttributeList).  The AttributeList parameter is
   wrapped in a MarshalledObject.

  name - The object name of the MBean within which the attributes are to be set. - `javax.management.ObjectName`
  attributes - A list of attributes: The identification of the attributes to be set and the values they are to be set to, encapsulated into a MarshalledObject. - `java.rmi.MarshalledObject`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: The list of attributes that were set, with their new
   values. - `javax.management.AttributeList`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  ([this name attributes delegation-subject]
    (-> this (.setAttributes name attributes delegation-subject))))

(defn fetch-notifications
  "Retrieves notifications from the connector server.  This
   method can block until there is at least one notification or
   until the specified timeout is reached.  The method can also
   return at any time with zero notifications.

   A notification can be included in the result if its sequence
   number is no less than clientSequenceNumber and
   this client has registered at least one listener for the MBean
   generating the notification, with a filter that accepts the
   notification.  Each listener that is interested in the
   notification is identified by an Integer ID that was returned
   by addNotificationListeners(ObjectName[],
   MarshalledObject[], Subject[]).

  client-sequence-number - the first sequence number that the client is interested in. If negative, it is interpreted as meaning the sequence number that the next notification will have. - `long`
  max-notifications - the maximum number of different notifications to return. The TargetedNotification array in the returned NotificationResult can have more elements than this if the same notification appears more than once. The behavior is unspecified if this parameter is negative. - `int`
  timeout - the maximum time in milliseconds to wait for a notification to arrive. This can be 0 to indicate that the method should not wait if there are no notifications, but should return at once. It can be Long.MAX_VALUE to indicate that there is no timeout. The behavior is unspecified if this parameter is negative. - `long`

  returns: A NotificationResult. - `javax.management.remote.NotificationResult`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this client-sequence-number max-notifications timeout]
    (-> this (.fetchNotifications client-sequence-number max-notifications timeout))))

(defn add-notification-listener
  "Handles the method MBeanServerConnection.addNotificationListener(ObjectName,
   ObjectName, NotificationFilter, Object).  The
   NotificationFilter parameter is wrapped in a
   MarshalledObject.  The Object
   (handback) parameter is also wrapped in a
   MarshalledObject.

  name - The name of the MBean on which the listener should be added. - `javax.management.ObjectName`
  listener - The object name of the listener which will handle the notifications emitted by the registered MBean. - `javax.management.ObjectName`
  filter - The filter object, encapsulated into a MarshalledObject. If filter encapsulated in the MarshalledObject has a null value, no filtering will be performed before handling notifications. - `java.rmi.MarshalledObject`
  handback - The context to be sent to the listener when a notification is emitted, encapsulated into a MarshalledObject. - `java.rmi.MarshalledObject`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  throws: javax.management.InstanceNotFoundException - The MBean name of the notification listener or of the notification broadcaster does not match any of the registered MBeans."
  ([this name listener filter handback delegation-subject]
    (-> this (.addNotificationListener name listener filter handback delegation-subject))))

(defn get-attributes
  "Handles the method MBeanServerConnection.getAttributes(ObjectName,
   String[]).

  name - The object name of the MBean from which the attributes are retrieved. - `javax.management.ObjectName`
  attributes - A list of the attributes to be retrieved. - `java.lang.String[]`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: The list of the retrieved attributes. - `javax.management.AttributeList`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  ([this name attributes delegation-subject]
    (-> this (.getAttributes name attributes delegation-subject))))

(defn instance-of?
  "Handles the method MBeanServerConnection.isInstanceOf(ObjectName,
   String).

  name - The ObjectName of the MBean. - `javax.management.ObjectName`
  class-name - The name of the class. - `java.lang.String`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: true if the MBean specified is an instance of the
   specified class according to the rules above, false otherwise. - `boolean`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  ([this name class-name delegation-subject]
    (-> this (.isInstanceOf name class-name delegation-subject))))

