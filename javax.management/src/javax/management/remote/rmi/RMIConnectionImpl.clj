(ns javax.management.remote.rmi.RMIConnectionImpl
  "Implementation of the RMIConnection interface.  User
  code will not usually reference this class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote.rmi RMIConnectionImpl]))

(defn ->rmi-connection-impl
  "Constructor.

  Constructs a new RMIConnection. This connection can be
   used with either the JRMP or IIOP transport. This object does
   not export itself: it is the responsibility of the caller to
   export it appropriately (see RMIJRMPServerImpl.makeClient(String,Subject) and RMIIIOPServerImpl.makeClient(String,Subject).

  rmi-server - The RMIServerImpl object for which this connection is created. The behavior is unspecified if this parameter is null. - `javax.management.remote.rmi.RMIServerImpl`
  connection-id - The ID for this connection. The behavior is unspecified if this parameter is null. - `java.lang.String`
  default-class-loader - The default ClassLoader to be used when deserializing marshalled objects. Can be null, to signify the bootstrap class loader. - `java.lang.ClassLoader`
  subject - the authenticated subject to be used for authorization. Can be null, to signify that no subject has been authenticated. - `javax.security.auth.Subject`
  env - the environment containing attributes for the new RMIServerImpl. Can be null, equivalent to an empty map. - `java.util.Map<java.lang.String,?>`"
  ([^javax.management.remote.rmi.RMIServerImpl rmi-server ^java.lang.String connection-id ^java.lang.ClassLoader default-class-loader ^javax.security.auth.Subject subject ^java.util.Map env]
    (new RMIConnectionImpl rmi-server connection-id default-class-loader subject env)))

(defn invoke
  "Description copied from interface: RMIConnection

  name - The object name of the MBean on which the method is to be invoked. - `javax.management.ObjectName`
  operation-name - The name of the operation to be invoked. - `java.lang.String`
  params - An array containing the parameters to be set when the operation is invoked, encapsulated into a MarshalledObject. The encapsulated array can be null, equivalent to an empty array. - `java.rmi.MarshalledObject`
  signature - An array containing the signature of the operation. The class objects will be loaded using the same class loader as the one used for loading the MBean on which the operation was invoked. Can be null, equivalent to an empty array. - `java.lang.String[]`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: The object returned by the operation, which represents
   the result of invoking the operation on the MBean specified. - `java.lang.Object`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  (^java.lang.Object [^javax.management.remote.rmi.RMIConnectionImpl this ^javax.management.ObjectName name ^java.lang.String operation-name ^java.rmi.MarshalledObject params signature ^javax.security.auth.Subject delegation-subject]
    (-> this (.invoke name operation-name params signature delegation-subject))))

(defn unreferenced
  "Description copied from interface: Unreferenced"
  ([^javax.management.remote.rmi.RMIConnectionImpl this]
    (-> this (.unreferenced))))

(defn query-m-beans
  "Description copied from interface: RMIConnection

  name - The object name pattern identifying the MBeans to be retrieved. If null or no domain and key properties are specified, all the MBeans registered will be retrieved. - `javax.management.ObjectName`
  query - The query expression to be applied for selecting MBeans, encapsulated into a MarshalledObject. If the MarshalledObject encapsulates a null value no query expression will be applied for selecting MBeans. - `java.rmi.MarshalledObject`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: A set containing the ObjectInstance
   objects for the selected MBeans.  If no MBean satisfies the
   query an empty list is returned. - `java.util.Set<javax.management.ObjectInstance>`

  throws: java.io.IOException - if a general communication exception occurred."
  (^java.util.Set [^javax.management.remote.rmi.RMIConnectionImpl this ^javax.management.ObjectName name ^java.rmi.MarshalledObject query ^javax.security.auth.Subject delegation-subject]
    (-> this (.queryMBeans name query delegation-subject))))

(defn query-names
  "Description copied from interface: RMIConnection

  name - The object name pattern identifying the MBean names to be retrieved. If null or no domain and key properties are specified, the name of all registered MBeans will be retrieved. - `javax.management.ObjectName`
  query - The query expression to be applied for selecting MBeans, encapsulated into a MarshalledObject. If the MarshalledObject encapsulates a null value no query expression will be applied for selecting MBeans. - `java.rmi.MarshalledObject`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: A set containing the ObjectNames for the MBeans
   selected.  If no MBean satisfies the query, an empty list is
   returned. - `java.util.Set<javax.management.ObjectName>`

  throws: java.io.IOException - if a general communication exception occurred."
  (^java.util.Set [^javax.management.remote.rmi.RMIConnectionImpl this ^javax.management.ObjectName name ^java.rmi.MarshalledObject query ^javax.security.auth.Subject delegation-subject]
    (-> this (.queryNames name query delegation-subject))))

(defn remove-notification-listeners
  "Description copied from interface: RMIConnection

  name - the ObjectName identifying the MBean emitting the Notifications. - `javax.management.ObjectName`
  listener-i-ds - the list of the IDs corresponding to the listeners to remove. - `java.lang.Integer[]`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  throws: javax.management.InstanceNotFoundException - if the given name does not correspond to any registered MBean."
  ([^javax.management.remote.rmi.RMIConnectionImpl this ^javax.management.ObjectName name listener-i-ds ^javax.security.auth.Subject delegation-subject]
    (-> this (.removeNotificationListeners name listener-i-ds delegation-subject))))

(defn to-string
  "Returns a string representation of this object.  In general,
   the toString method returns a string that
   `textually represents` this object. The result should be a
   concise but informative representation that is easy for a
   person to read.

  returns: a String representation of this object. - `java.lang.String`"
  (^java.lang.String [^javax.management.remote.rmi.RMIConnectionImpl this]
    (-> this (.toString))))

(defn remove-notification-listener
  "Description copied from interface: RMIConnection

  name - The name of the MBean on which the listener should be removed. - `javax.management.ObjectName`
  listener - A listener that was previously added to this MBean. - `javax.management.ObjectName`
  filter - The filter that was specified when the listener was added, encapsulated into a MarshalledObject. - `java.rmi.MarshalledObject`
  handback - The handback that was specified when the listener was added, encapsulated into a MarshalledObject. - `java.rmi.MarshalledObject`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  throws: javax.management.InstanceNotFoundException - The MBean name provided does not match any of the registered MBeans."
  ([^javax.management.remote.rmi.RMIConnectionImpl this ^javax.management.ObjectName name ^javax.management.ObjectName listener ^java.rmi.MarshalledObject filter ^java.rmi.MarshalledObject handback ^javax.security.auth.Subject delegation-subject]
    (-> this (.removeNotificationListener name listener filter handback delegation-subject)))
  ([^javax.management.remote.rmi.RMIConnectionImpl this ^javax.management.ObjectName name ^javax.management.ObjectName listener ^javax.security.auth.Subject delegation-subject]
    (-> this (.removeNotificationListener name listener delegation-subject))))

(defn get-attribute
  "Description copied from interface: RMIConnection

  name - The object name of the MBean from which the attribute is to be retrieved. - `javax.management.ObjectName`
  attribute - A String specifying the name of the attribute to be retrieved. - `java.lang.String`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: The value of the retrieved attribute. - `java.lang.Object`

  throws: javax.management.MBeanException - Wraps an exception thrown by the MBean's getter."
  (^java.lang.Object [^javax.management.remote.rmi.RMIConnectionImpl this ^javax.management.ObjectName name ^java.lang.String attribute ^javax.security.auth.Subject delegation-subject]
    (-> this (.getAttribute name attribute delegation-subject))))

(defn get-m-bean-info
  "Description copied from interface: RMIConnection

  name - The name of the MBean to analyze - `javax.management.ObjectName`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: An instance of MBeanInfo allowing the
   retrieval of all attributes and operations of this MBean. - `javax.management.MBeanInfo`

  throws: javax.management.InstanceNotFoundException - The MBean specified was not found."
  (^javax.management.MBeanInfo [^javax.management.remote.rmi.RMIConnectionImpl this ^javax.management.ObjectName name ^javax.security.auth.Subject delegation-subject]
    (-> this (.getMBeanInfo name delegation-subject))))

(defn create-m-bean
  "Description copied from interface: RMIConnection

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

  throws: javax.management.ReflectionException - Wraps a java.lang.ClassNotFoundException or a java.lang.Exception that occurred when trying to invoke the MBean's constructor."
  (^javax.management.ObjectInstance [^javax.management.remote.rmi.RMIConnectionImpl this ^java.lang.String class-name ^javax.management.ObjectName name ^javax.management.ObjectName loader-name ^java.rmi.MarshalledObject params signature ^javax.security.auth.Subject delegation-subject]
    (-> this (.createMBean class-name name loader-name params signature delegation-subject)))
  (^javax.management.ObjectInstance [^javax.management.remote.rmi.RMIConnectionImpl this ^java.lang.String class-name ^javax.management.ObjectName name ^java.rmi.MarshalledObject params signature ^javax.security.auth.Subject delegation-subject]
    (-> this (.createMBean class-name name params signature delegation-subject)))
  (^javax.management.ObjectInstance [^javax.management.remote.rmi.RMIConnectionImpl this ^java.lang.String class-name ^javax.management.ObjectName name ^javax.management.ObjectName loader-name ^javax.security.auth.Subject delegation-subject]
    (-> this (.createMBean class-name name loader-name delegation-subject)))
  (^javax.management.ObjectInstance [^javax.management.remote.rmi.RMIConnectionImpl this ^java.lang.String class-name ^javax.management.ObjectName name ^javax.security.auth.Subject delegation-subject]
    (-> this (.createMBean class-name name delegation-subject))))

(defn get-m-bean-count
  "Description copied from interface: RMIConnection

  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: the number of MBeans registered. - `java.lang.Integer`

  throws: java.io.IOException - if a general communication exception occurred."
  (^java.lang.Integer [^javax.management.remote.rmi.RMIConnectionImpl this ^javax.security.auth.Subject delegation-subject]
    (-> this (.getMBeanCount delegation-subject))))

(defn registered?
  "Description copied from interface: RMIConnection

  name - The object name of the MBean to be checked. - `javax.management.ObjectName`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: True if the MBean is already registered in the MBean
   server, false otherwise. - `boolean`

  throws: java.io.IOException - if a general communication exception occurred."
  (^Boolean [^javax.management.remote.rmi.RMIConnectionImpl this ^javax.management.ObjectName name ^javax.security.auth.Subject delegation-subject]
    (-> this (.isRegistered name delegation-subject))))

(defn add-notification-listeners
  "Description copied from interface: RMIConnection

  names - the ObjectNames identifying the MBeans emitting the Notifications. - `javax.management.ObjectName[]`
  filters - an array of marshalled representations of the NotificationFilters. Elements of this array can be null. - `java.rmi.MarshalledObject[]`
  delegation-subjects - the Subjects on behalf of which the listeners are being added. Elements of this array can be null. Also, the delegationSubjects parameter itself can be null, which is equivalent to an array of null values with the same size as the names and filters arrays. - `javax.security.auth.Subject[]`

  returns: an array of listenerIDs identifying the
   local listeners.  This array has the same number of elements as
   the parameters. - `java.lang.Integer[]`

  throws: javax.management.InstanceNotFoundException - if one of the names does not correspond to any registered MBean."
  ([^javax.management.remote.rmi.RMIConnectionImpl this names filters delegation-subjects]
    (-> this (.addNotificationListeners names filters delegation-subjects))))

(defn unregister-m-bean
  "Description copied from interface: RMIConnection

  name - The object name of the MBean to be unregistered. - `javax.management.ObjectName`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  ([^javax.management.remote.rmi.RMIConnectionImpl this ^javax.management.ObjectName name ^javax.security.auth.Subject delegation-subject]
    (-> this (.unregisterMBean name delegation-subject))))

(defn get-default-domain
  "Description copied from interface: RMIConnection

  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: the default domain. - `java.lang.String`

  throws: java.io.IOException - if a general communication exception occurred."
  (^java.lang.String [^javax.management.remote.rmi.RMIConnectionImpl this ^javax.security.auth.Subject delegation-subject]
    (-> this (.getDefaultDomain delegation-subject))))

(defn set-attribute
  "Description copied from interface: RMIConnection

  name - The name of the MBean within which the attribute is to be set. - `javax.management.ObjectName`
  attribute - The identification of the attribute to be set and the value it is to be set to, encapsulated into a MarshalledObject. - `java.rmi.MarshalledObject`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  ([^javax.management.remote.rmi.RMIConnectionImpl this ^javax.management.ObjectName name ^java.rmi.MarshalledObject attribute ^javax.security.auth.Subject delegation-subject]
    (-> this (.setAttribute name attribute delegation-subject))))

(defn get-object-instance
  "Description copied from interface: RMIConnection

  name - The object name of the MBean. - `javax.management.ObjectName`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: The ObjectInstance associated with the MBean
   specified by name.  The contained ObjectName
   is name and the contained class name is
   getMBeanInfo(name).getClassName(). - `javax.management.ObjectInstance`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  (^javax.management.ObjectInstance [^javax.management.remote.rmi.RMIConnectionImpl this ^javax.management.ObjectName name ^javax.security.auth.Subject delegation-subject]
    (-> this (.getObjectInstance name delegation-subject))))

(defn get-domains
  "Description copied from interface: RMIConnection

  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: the list of domains. - `java.lang.String[]`

  throws: java.io.IOException - if a general communication exception occurred."
  ([^javax.management.remote.rmi.RMIConnectionImpl this ^javax.security.auth.Subject delegation-subject]
    (-> this (.getDomains delegation-subject))))

(defn close
  "Description copied from interface: RMIConnection

  throws: java.io.IOException - if the connection could not be closed, or the Remote object could not be unexported, or there was a communication failure when transmitting the remote close request."
  ([^javax.management.remote.rmi.RMIConnectionImpl this]
    (-> this (.close))))

(defn get-connection-id
  "Description copied from interface: RMIConnection

  returns: the connection ID - `java.lang.String`

  throws: java.io.IOException - if a general communication exception occurred."
  (^java.lang.String [^javax.management.remote.rmi.RMIConnectionImpl this]
    (-> this (.getConnectionId))))

(defn set-attributes
  "Description copied from interface: RMIConnection

  name - The object name of the MBean within which the attributes are to be set. - `javax.management.ObjectName`
  attributes - A list of attributes: The identification of the attributes to be set and the values they are to be set to, encapsulated into a MarshalledObject. - `java.rmi.MarshalledObject`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: The list of attributes that were set, with their new
   values. - `javax.management.AttributeList`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  (^javax.management.AttributeList [^javax.management.remote.rmi.RMIConnectionImpl this ^javax.management.ObjectName name ^java.rmi.MarshalledObject attributes ^javax.security.auth.Subject delegation-subject]
    (-> this (.setAttributes name attributes delegation-subject))))

(defn fetch-notifications
  "Description copied from interface: RMIConnection

  client-sequence-number - the first sequence number that the client is interested in. If negative, it is interpreted as meaning the sequence number that the next notification will have. - `long`
  max-notifications - the maximum number of different notifications to return. The TargetedNotification array in the returned NotificationResult can have more elements than this if the same notification appears more than once. The behavior is unspecified if this parameter is negative. - `int`
  timeout - the maximum time in milliseconds to wait for a notification to arrive. This can be 0 to indicate that the method should not wait if there are no notifications, but should return at once. It can be Long.MAX_VALUE to indicate that there is no timeout. The behavior is unspecified if this parameter is negative. - `long`

  returns: A NotificationResult. - `javax.management.remote.NotificationResult`

  throws: java.io.IOException - if a general communication exception occurred."
  (^javax.management.remote.NotificationResult [^javax.management.remote.rmi.RMIConnectionImpl this ^Long client-sequence-number ^Integer max-notifications ^Long timeout]
    (-> this (.fetchNotifications client-sequence-number max-notifications timeout))))

(defn add-notification-listener
  "Description copied from interface: RMIConnection

  name - The name of the MBean on which the listener should be added. - `javax.management.ObjectName`
  listener - The object name of the listener which will handle the notifications emitted by the registered MBean. - `javax.management.ObjectName`
  filter - The filter object, encapsulated into a MarshalledObject. If filter encapsulated in the MarshalledObject has a null value, no filtering will be performed before handling notifications. - `java.rmi.MarshalledObject`
  handback - The context to be sent to the listener when a notification is emitted, encapsulated into a MarshalledObject. - `java.rmi.MarshalledObject`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  throws: javax.management.InstanceNotFoundException - The MBean name of the notification listener or of the notification broadcaster does not match any of the registered MBeans."
  ([^javax.management.remote.rmi.RMIConnectionImpl this ^javax.management.ObjectName name ^javax.management.ObjectName listener ^java.rmi.MarshalledObject filter ^java.rmi.MarshalledObject handback ^javax.security.auth.Subject delegation-subject]
    (-> this (.addNotificationListener name listener filter handback delegation-subject))))

(defn get-attributes
  "Description copied from interface: RMIConnection

  name - The object name of the MBean from which the attributes are retrieved. - `javax.management.ObjectName`
  attributes - A list of the attributes to be retrieved. - `java.lang.String[]`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: The list of the retrieved attributes. - `javax.management.AttributeList`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  (^javax.management.AttributeList [^javax.management.remote.rmi.RMIConnectionImpl this ^javax.management.ObjectName name attributes ^javax.security.auth.Subject delegation-subject]
    (-> this (.getAttributes name attributes delegation-subject))))

(defn instance-of?
  "Description copied from interface: RMIConnection

  name - The ObjectName of the MBean. - `javax.management.ObjectName`
  class-name - The name of the class. - `java.lang.String`
  delegation-subject - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: true if the MBean specified is an instance of the
   specified class according to the rules above, false otherwise. - `boolean`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  (^Boolean [^javax.management.remote.rmi.RMIConnectionImpl this ^javax.management.ObjectName name ^java.lang.String class-name ^javax.security.auth.Subject delegation-subject]
    (-> this (.isInstanceOf name class-name delegation-subject))))

