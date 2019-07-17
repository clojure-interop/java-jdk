(ns javax.management.remote.rmi.RMIConnectionImpl_Stub
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote.rmi RMIConnectionImpl_Stub]))

(defn ->rmi-connection-impl-stub
  "Constructor.

  ref - `java.rmi.server.RemoteRef`"
  ([ref]
    (new RMIConnectionImpl_Stub ref)))

(defn invoke
  "Description copied from interface: RMIConnection

  $param-object-name-1 - The object name of the MBean on which the method is to be invoked. - `javax.management.ObjectName`
  $param-string-2 - The name of the operation to be invoked. - `java.lang.String`
  $param-marshalled-object-3 - An array containing the parameters to be set when the operation is invoked, encapsulated into a MarshalledObject. The encapsulated array can be null, equivalent to an empty array. - `java.rmi.MarshalledObject`
  $param-array-of-string-4 - An array containing the signature of the operation. The class objects will be loaded using the same class loader as the one used for loading the MBean on which the operation was invoked. Can be null, equivalent to an empty array. - `java.lang.String[]`
  $param-subject-5 - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: The object returned by the operation, which represents
   the result of invoking the operation on the MBean specified. - `java.lang.Object`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-object-name-1 $param-string-2 $param-marshalled-object-3 $param-array-of-string-4 $param-subject-5]
    (-> this (.invoke $param-object-name-1 $param-string-2 $param-marshalled-object-3 $param-array-of-string-4 $param-subject-5))))

(defn query-m-beans
  "Description copied from interface: RMIConnection

  $param-object-name-1 - The object name pattern identifying the MBeans to be retrieved. If null or no domain and key properties are specified, all the MBeans registered will be retrieved. - `javax.management.ObjectName`
  $param-marshalled-object-2 - The query expression to be applied for selecting MBeans, encapsulated into a MarshalledObject. If the MarshalledObject encapsulates a null value no query expression will be applied for selecting MBeans. - `java.rmi.MarshalledObject`
  $param-subject-3 - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: A set containing the ObjectInstance
   objects for the selected MBeans.  If no MBean satisfies the
   query an empty list is returned. - `java.util.Set`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-object-name-1 $param-marshalled-object-2 $param-subject-3]
    (-> this (.queryMBeans $param-object-name-1 $param-marshalled-object-2 $param-subject-3))))

(defn query-names
  "Description copied from interface: RMIConnection

  $param-object-name-1 - The object name pattern identifying the MBean names to be retrieved. If null or no domain and key properties are specified, the name of all registered MBeans will be retrieved. - `javax.management.ObjectName`
  $param-marshalled-object-2 - The query expression to be applied for selecting MBeans, encapsulated into a MarshalledObject. If the MarshalledObject encapsulates a null value no query expression will be applied for selecting MBeans. - `java.rmi.MarshalledObject`
  $param-subject-3 - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: A set containing the ObjectNames for the MBeans
   selected.  If no MBean satisfies the query, an empty list is
   returned. - `java.util.Set`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-object-name-1 $param-marshalled-object-2 $param-subject-3]
    (-> this (.queryNames $param-object-name-1 $param-marshalled-object-2 $param-subject-3))))

(defn remove-notification-listeners
  "Description copied from interface: RMIConnection

  $param-object-name-1 - the ObjectName identifying the MBean emitting the Notifications. - `javax.management.ObjectName`
  $param-array-of-integer-2 - the list of the IDs corresponding to the listeners to remove. - `java.lang.Integer[]`
  $param-subject-3 - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-object-name-1 $param-array-of-integer-2 $param-subject-3]
    (-> this (.removeNotificationListeners $param-object-name-1 $param-array-of-integer-2 $param-subject-3))))

(defn remove-notification-listener
  "Description copied from interface: RMIConnection

  $param-object-name-1 - The name of the MBean on which the listener should be removed. - `javax.management.ObjectName`
  $param-object-name-2 - A listener that was previously added to this MBean. - `javax.management.ObjectName`
  $param-marshalled-object-3 - The filter that was specified when the listener was added, encapsulated into a MarshalledObject. - `java.rmi.MarshalledObject`
  $param-marshalled-object-4 - The handback that was specified when the listener was added, encapsulated into a MarshalledObject. - `java.rmi.MarshalledObject`
  $param-subject-5 - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-object-name-1 $param-object-name-2 $param-marshalled-object-3 $param-marshalled-object-4 $param-subject-5]
    (-> this (.removeNotificationListener $param-object-name-1 $param-object-name-2 $param-marshalled-object-3 $param-marshalled-object-4 $param-subject-5)))
  ([this $param-object-name-1 $param-object-name-2 $param-subject-3]
    (-> this (.removeNotificationListener $param-object-name-1 $param-object-name-2 $param-subject-3))))

(defn get-attribute
  "Description copied from interface: RMIConnection

  $param-object-name-1 - The object name of the MBean from which the attribute is to be retrieved. - `javax.management.ObjectName`
  $param-string-2 - A String specifying the name of the attribute to be retrieved. - `java.lang.String`
  $param-subject-3 - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: The value of the retrieved attribute. - `java.lang.Object`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-object-name-1 $param-string-2 $param-subject-3]
    (-> this (.getAttribute $param-object-name-1 $param-string-2 $param-subject-3))))

(defn get-m-bean-info
  "Description copied from interface: RMIConnection

  $param-object-name-1 - The name of the MBean to analyze - `javax.management.ObjectName`
  $param-subject-2 - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: An instance of MBeanInfo allowing the
   retrieval of all attributes and operations of this MBean. - `javax.management.MBeanInfo`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-object-name-1 $param-subject-2]
    (-> this (.getMBeanInfo $param-object-name-1 $param-subject-2))))

(defn create-m-bean
  "Description copied from interface: RMIConnection

  $param-string-1 - The class name of the MBean to be instantiated. - `java.lang.String`
  $param-object-name-2 - The object name of the MBean. May be null. - `javax.management.ObjectName`
  $param-object-name-3 - The object name of the class loader to be used. - `javax.management.ObjectName`
  $param-marshalled-object-4 - An array containing the parameters of the constructor to be invoked, encapsulated into a MarshalledObject. The encapsulated array can be null, equivalent to an empty array. - `java.rmi.MarshalledObject`
  $param-array-of-string-5 - An array containing the signature of the constructor to be invoked. Can be null, equivalent to an empty array. - `java.lang.String[]`
  $param-subject-6 - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: An ObjectInstance, containing the
   ObjectName and the Java class name of the newly
   instantiated MBean.  If the contained ObjectName
   is n, the contained Java class name is
   getMBeanInfo(n).getClassName(). - `javax.management.ObjectInstance`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-string-1 $param-object-name-2 $param-object-name-3 $param-marshalled-object-4 $param-array-of-string-5 $param-subject-6]
    (-> this (.createMBean $param-string-1 $param-object-name-2 $param-object-name-3 $param-marshalled-object-4 $param-array-of-string-5 $param-subject-6)))
  ([this $param-string-1 $param-object-name-2 $param-marshalled-object-3 $param-array-of-string-4 $param-subject-5]
    (-> this (.createMBean $param-string-1 $param-object-name-2 $param-marshalled-object-3 $param-array-of-string-4 $param-subject-5)))
  ([this $param-string-1 $param-object-name-2 $param-object-name-3 $param-subject-4]
    (-> this (.createMBean $param-string-1 $param-object-name-2 $param-object-name-3 $param-subject-4)))
  ([this $param-string-1 $param-object-name-2 $param-subject-3]
    (-> this (.createMBean $param-string-1 $param-object-name-2 $param-subject-3))))

(defn get-m-bean-count
  "Description copied from interface: RMIConnection

  $param-subject-1 - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: the number of MBeans registered. - `java.lang.Integer`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-subject-1]
    (-> this (.getMBeanCount $param-subject-1))))

(defn registered?
  "Description copied from interface: RMIConnection

  $param-object-name-1 - The object name of the MBean to be checked. - `javax.management.ObjectName`
  $param-subject-2 - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: True if the MBean is already registered in the MBean
   server, false otherwise. - `boolean`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-object-name-1 $param-subject-2]
    (-> this (.isRegistered $param-object-name-1 $param-subject-2))))

(defn add-notification-listeners
  "Description copied from interface: RMIConnection

  $param-array-of-object-name-1 - the ObjectNames identifying the MBeans emitting the Notifications. - `javax.management.ObjectName[]`
  $param-array-of-marshalled-object-2 - an array of marshalled representations of the NotificationFilters. Elements of this array can be null. - `java.rmi.MarshalledObject[]`
  $param-array-of-subject-3 - the Subjects on behalf of which the listeners are being added. Elements of this array can be null. Also, the delegationSubjects parameter itself can be null, which is equivalent to an array of null values with the same size as the names and filters arrays. - `javax.security.auth.Subject[]`

  returns: an array of listenerIDs identifying the
   local listeners.  This array has the same number of elements as
   the parameters. - `java.lang.Integer[]`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-array-of-object-name-1 $param-array-of-marshalled-object-2 $param-array-of-subject-3]
    (-> this (.addNotificationListeners $param-array-of-object-name-1 $param-array-of-marshalled-object-2 $param-array-of-subject-3))))

(defn unregister-m-bean
  "Description copied from interface: RMIConnection

  $param-object-name-1 - The object name of the MBean to be unregistered. - `javax.management.ObjectName`
  $param-subject-2 - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-object-name-1 $param-subject-2]
    (-> this (.unregisterMBean $param-object-name-1 $param-subject-2))))

(defn get-default-domain
  "Description copied from interface: RMIConnection

  $param-subject-1 - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: the default domain. - `java.lang.String`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-subject-1]
    (-> this (.getDefaultDomain $param-subject-1))))

(defn set-attribute
  "Description copied from interface: RMIConnection

  $param-object-name-1 - The name of the MBean within which the attribute is to be set. - `javax.management.ObjectName`
  $param-marshalled-object-2 - The identification of the attribute to be set and the value it is to be set to, encapsulated into a MarshalledObject. - `java.rmi.MarshalledObject`
  $param-subject-3 - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-object-name-1 $param-marshalled-object-2 $param-subject-3]
    (-> this (.setAttribute $param-object-name-1 $param-marshalled-object-2 $param-subject-3))))

(defn get-object-instance
  "Description copied from interface: RMIConnection

  $param-object-name-1 - The object name of the MBean. - `javax.management.ObjectName`
  $param-subject-2 - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: The ObjectInstance associated with the MBean
   specified by name.  The contained ObjectName
   is name and the contained class name is
   getMBeanInfo(name).getClassName(). - `javax.management.ObjectInstance`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-object-name-1 $param-subject-2]
    (-> this (.getObjectInstance $param-object-name-1 $param-subject-2))))

(defn get-domains
  "Description copied from interface: RMIConnection

  $param-subject-1 - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: the list of domains. - `java.lang.String[]`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-subject-1]
    (-> this (.getDomains $param-subject-1))))

(defn close
  "Description copied from interface: RMIConnection

  throws: java.io.IOException - if the connection could not be closed, or the Remote object could not be unexported, or there was a communication failure when transmitting the remote close request."
  ([this]
    (-> this (.close))))

(defn get-connection-id
  "Description copied from interface: RMIConnection

  returns: the connection ID - `java.lang.String`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this]
    (-> this (.getConnectionId))))

(defn set-attributes
  "Description copied from interface: RMIConnection

  $param-object-name-1 - The object name of the MBean within which the attributes are to be set. - `javax.management.ObjectName`
  $param-marshalled-object-2 - A list of attributes: The identification of the attributes to be set and the values they are to be set to, encapsulated into a MarshalledObject. - `java.rmi.MarshalledObject`
  $param-subject-3 - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: The list of attributes that were set, with their new
   values. - `javax.management.AttributeList`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-object-name-1 $param-marshalled-object-2 $param-subject-3]
    (-> this (.setAttributes $param-object-name-1 $param-marshalled-object-2 $param-subject-3))))

(defn fetch-notifications
  "Description copied from interface: RMIConnection

  $param-long-1 - the first sequence number that the client is interested in. If negative, it is interpreted as meaning the sequence number that the next notification will have. - `long`
  $param-int-2 - the maximum number of different notifications to return. The TargetedNotification array in the returned NotificationResult can have more elements than this if the same notification appears more than once. The behavior is unspecified if this parameter is negative. - `int`
  $param-long-3 - the maximum time in milliseconds to wait for a notification to arrive. This can be 0 to indicate that the method should not wait if there are no notifications, but should return at once. It can be Long.MAX_VALUE to indicate that there is no timeout. The behavior is unspecified if this parameter is negative. - `long`

  returns: A NotificationResult. - `javax.management.remote.NotificationResult`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-long-1 $param-int-2 $param-long-3]
    (-> this (.fetchNotifications $param-long-1 $param-int-2 $param-long-3))))

(defn add-notification-listener
  "Description copied from interface: RMIConnection

  $param-object-name-1 - The name of the MBean on which the listener should be added. - `javax.management.ObjectName`
  $param-object-name-2 - The object name of the listener which will handle the notifications emitted by the registered MBean. - `javax.management.ObjectName`
  $param-marshalled-object-3 - The filter object, encapsulated into a MarshalledObject. If filter encapsulated in the MarshalledObject has a null value, no filtering will be performed before handling notifications. - `java.rmi.MarshalledObject`
  $param-marshalled-object-4 - The context to be sent to the listener when a notification is emitted, encapsulated into a MarshalledObject. - `java.rmi.MarshalledObject`
  $param-subject-5 - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-object-name-1 $param-object-name-2 $param-marshalled-object-3 $param-marshalled-object-4 $param-subject-5]
    (-> this (.addNotificationListener $param-object-name-1 $param-object-name-2 $param-marshalled-object-3 $param-marshalled-object-4 $param-subject-5))))

(defn get-attributes
  "Description copied from interface: RMIConnection

  $param-object-name-1 - The object name of the MBean from which the attributes are retrieved. - `javax.management.ObjectName`
  $param-array-of-string-2 - A list of the attributes to be retrieved. - `java.lang.String[]`
  $param-subject-3 - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: The list of the retrieved attributes. - `javax.management.AttributeList`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-object-name-1 $param-array-of-string-2 $param-subject-3]
    (-> this (.getAttributes $param-object-name-1 $param-array-of-string-2 $param-subject-3))))

(defn instance-of?
  "Description copied from interface: RMIConnection

  $param-object-name-1 - The ObjectName of the MBean. - `javax.management.ObjectName`
  $param-string-2 - The name of the class. - `java.lang.String`
  $param-subject-3 - The Subject containing the delegation principals or null if the authentication principal is used instead. - `javax.security.auth.Subject`

  returns: true if the MBean specified is an instance of the
   specified class according to the rules above, false otherwise. - `boolean`

  throws: java.io.IOException - if a general communication exception occurred."
  ([this $param-object-name-1 $param-string-2 $param-subject-3]
    (-> this (.isInstanceOf $param-object-name-1 $param-string-2 $param-subject-3))))

