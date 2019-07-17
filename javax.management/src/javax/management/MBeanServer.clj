(ns javax.management.MBeanServer
  "This is the interface for MBean manipulation on the agent
  side. It contains the methods necessary for the creation,
  registration, and deletion of MBeans as well as the access methods
  for registered MBeans.  This is the core component of the JMX
  infrastructure.

  User code does not usually implement this interface.  Instead,
  an object that implements this interface is obtained with one of
  the methods in the MBeanServerFactory class.

  Every MBean which is added to the MBean server becomes
  manageable: its attributes and operations become remotely
  accessible through the connectors/adaptors connected to that MBean
  server.  A Java object cannot be registered in the MBean server
  unless it is a JMX compliant MBean.

  When an MBean is registered or unregistered in the
  MBean server a MBeanServerNotification Notification is emitted. To register an
  object as listener to MBeanServerNotifications you should call the
  MBean server method addNotificationListener with ObjectName the
  ObjectName of the MBeanServerDelegate.  This
  ObjectName is:
  JMImplementation:type=MBeanServerDelegate.

  An object obtained from the createMBeanServer or
  newMBeanServer
  methods of the MBeanServerFactory class applies security
  checks to its methods, as follows.

  First, if there is no security manager (System.getSecurityManager() is null), then an implementation of
  this interface is free not to make any checks.

  Assuming that there is a security manager, or that the
  implementation chooses to make checks anyway, the checks are made
  as detailed below.  In what follows, and unless otherwise specified,
  className is the
  string returned by MBeanInfo.getClassName() for the target
  MBean.

  If a security check fails, the method throws SecurityException.

  For methods that can throw InstanceNotFoundException,
  this exception is thrown for a non-existent MBean, regardless of
  permissions.  This is because a non-existent MBean has no
  className.



  For the invoke method, the caller's
  permissions must imply MBeanPermission(className, operationName, name, `invoke`).

  For the getAttribute method, the
  caller's permissions must imply MBeanPermission(className, attribute, name, `getAttribute`).

  For the getAttributes method, the
  caller's permissions must imply MBeanPermission(className, null, name, `getAttribute`).
  Additionally, for each attribute a in the AttributeList, if the caller's permissions do not imply MBeanPermission(className, a, name, `getAttribute`), the
  MBean server will behave as if that attribute had not been in the
  supplied list.

  For the setAttribute method, the
  caller's permissions must imply MBeanPermission(className, attrName, name, `setAttribute`), where
  attrName is attribute.getName().

  For the setAttributes method, the
  caller's permissions must imply MBeanPermission(className, null, name, `setAttribute`).
  Additionally, for each attribute a in the AttributeList, if the caller's permissions do not imply MBeanPermission(className, a, name, `setAttribute`), the
  MBean server will behave as if that attribute had not been in the
  supplied list.

  For the addNotificationListener methods,
  the caller's permissions must imply MBeanPermission(className, null, name,
  `addNotificationListener`).

  For the removeNotificationListener methods,
  the caller's permissions must imply MBeanPermission(className, null, name,
  `removeNotificationListener`).

  For the getMBeanInfo method, the
  caller's permissions must imply MBeanPermission(className, null, name, `getMBeanInfo`).

  For the getObjectInstance method,
  the caller's permissions must imply MBeanPermission(className, null, name, `getObjectInstance`).

  For the isInstanceOf method, the
  caller's permissions must imply MBeanPermission(className, null, name, `isInstanceOf`).

  For the queryMBeans method, the
  caller's permissions must imply MBeanPermission(null, null, null, `queryMBeans`).
  Additionally, for each MBean n that matches name,
  if the caller's permissions do not imply MBeanPermission(className, null, n, `queryMBeans`), the
  MBean server will behave as if that MBean did not exist.

  Certain query elements perform operations on the MBean server.
  If the caller does not have the required permissions for a given
  MBean, that MBean will not be included in the result of the query.
  The standard query elements that are affected are Query.attr(String), Query.attr(String,String), and Query.classattr().

  For the queryNames method, the checks
  are the same as for queryMBeans except that
  `queryNames` is used instead of
  `queryMBeans` in the MBeanPermission
  objects.  Note that a `queryMBeans` permission implies
  the corresponding `queryNames` permission.

  For the getDomains method, the caller's
  permissions must imply MBeanPermission(null, null, null, `getDomains`).  Additionally,
  for each domain d in the returned array, if the caller's
  permissions do not imply MBeanPermission(null, null, new ObjectName(`d:x=x`),
  `getDomains`), the domain is eliminated from the array.  Here,
  x=x is any key=value pair, needed to
  satisfy ObjectName's constructor but not otherwise relevant.

  For the getClassLoader method, the
  caller's permissions must imply MBeanPermission(className, null, loaderName,
  `getClassLoader`).

  For the getClassLoaderFor method,
  the caller's permissions must imply MBeanPermission(className, null, mbeanName,
  `getClassLoaderFor`).

  For the getClassLoaderRepository method, the caller's permissions must
  imply MBeanPermission(null, null, null, `getClassLoaderRepository`).

  For the deprecated deserialize methods, the
  required permissions are the same as for the methods that replace
  them.

  For the instantiate methods, the caller's
  permissions must imply MBeanPermission(className, null, null, `instantiate`),
  where className is the name of the class which is to
  be instantiated.

  For the registerMBean method, the
  caller's permissions must imply MBeanPermission(className, null, name, `registerMBean`).

  If the MBeanPermission check succeeds, the MBean's
  class is validated by checking that its ProtectionDomain implies MBeanTrustPermission(`register`).

  Finally, if the name argument is null, another
  MBeanPermission check is made using the
  ObjectName returned by MBeanRegistration.preRegister.

  For the createMBean methods, the caller's
  permissions must imply the permissions needed by the equivalent
  instantiate followed by
  registerMBean.

  For the unregisterMBean method,
  the caller's permissions must imply MBeanPermission(className, null, name, `unregisterMBean`)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management MBeanServer]))

(defn get-class-loader-repository
  "Return the ClassLoaderRepository for this MBeanServer.

  returns: The ClassLoaderRepository for this MBeanServer. - `javax.management.loading.ClassLoaderRepository`"
  (^javax.management.loading.ClassLoaderRepository [^javax.management.MBeanServer this]
    (-> this (.getClassLoaderRepository))))

(defn invoke
  "Description copied from interface: MBeanServerConnection

  name - The object name of the MBean on which the method is to be invoked. - `javax.management.ObjectName`
  operation-name - The name of the operation to be invoked. - `java.lang.String`
  params - An array containing the parameters to be set when the operation is invoked - `java.lang.Object[]`
  signature - An array containing the signature of the operation, an array of class names in the format returned by Class.getName(). The class objects will be loaded using the same class loader as the one used for loading the MBean on which the operation was invoked. - `java.lang.String[]`

  returns: The object returned by the operation, which represents
   the result of invoking the operation on the MBean specified. - `java.lang.Object`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  (^java.lang.Object [^javax.management.MBeanServer this ^javax.management.ObjectName name ^java.lang.String operation-name params signature]
    (-> this (.invoke name operation-name params signature))))

(defn query-m-beans
  "Gets MBeans controlled by the MBean server. This method allows
   any of the following to be obtained: All MBeans, a set of
   MBeans specified by pattern matching on the
   ObjectName and/or a Query expression, a specific
   MBean. When the object name is null or no domain and key
   properties are specified, all objects are to be selected (and
   filtered if a query is specified). It returns the set of
   ObjectInstance objects (containing the
   ObjectName and the Java Class name) for the
   selected MBeans.

  name - The object name pattern identifying the MBeans to be retrieved. If null or no domain and key properties are specified, all the MBeans registered will be retrieved. - `javax.management.ObjectName`
  query - The query expression to be applied for selecting MBeans. If null no query expression will be applied for selecting MBeans. - `javax.management.QueryExp`

  returns: A set containing the ObjectInstance
   objects for the selected MBeans.  If no MBean satisfies the
   query an empty list is returned. - `java.util.Set<javax.management.ObjectInstance>`

  throws: javax.management.RuntimeOperationsException"
  (^java.util.Set [^javax.management.MBeanServer this ^javax.management.ObjectName name ^javax.management.QueryExp query]
    (-> this (.queryMBeans name query))))

(defn query-names
  "Gets the names of MBeans controlled by the MBean server. This
   method enables any of the following to be obtained: The names
   of all MBeans, the names of a set of MBeans specified by
   pattern matching on the ObjectName and/or a Query
   expression, a specific MBean name (equivalent to testing
   whether an MBean is registered). When the object name is null
   or no domain and key properties are specified, all objects are
   selected (and filtered if a query is specified). It returns the
   set of ObjectNames for the MBeans selected.

  name - The object name pattern identifying the MBean names to be retrieved. If null or no domain and key properties are specified, the name of all registered MBeans will be retrieved. - `javax.management.ObjectName`
  query - The query expression to be applied for selecting MBeans. If null no query expression will be applied for selecting MBeans. - `javax.management.QueryExp`

  returns: A set containing the ObjectNames for the MBeans
   selected.  If no MBean satisfies the query, an empty list is
   returned. - `java.util.Set<javax.management.ObjectName>`

  throws: javax.management.RuntimeOperationsException"
  (^java.util.Set [^javax.management.MBeanServer this ^javax.management.ObjectName name ^javax.management.QueryExp query]
    (-> this (.queryNames name query))))

(defn remove-notification-listener
  "Description copied from interface: MBeanServerConnection

  name - The name of the MBean on which the listener should be removed. - `javax.management.ObjectName`
  listener - The object name of the listener to be removed. - `javax.management.ObjectName`
  filter - The filter that was specified when the listener was added. - `javax.management.NotificationFilter`
  handback - The handback that was specified when the listener was added. - `java.lang.Object`

  throws: javax.management.InstanceNotFoundException - The MBean name provided does not match any of the registered MBeans."
  ([^javax.management.MBeanServer this ^javax.management.ObjectName name ^javax.management.ObjectName listener ^javax.management.NotificationFilter filter ^java.lang.Object handback]
    (-> this (.removeNotificationListener name listener filter handback)))
  ([^javax.management.MBeanServer this ^javax.management.ObjectName name ^javax.management.ObjectName listener]
    (-> this (.removeNotificationListener name listener))))

(defn get-attribute
  "Description copied from interface: MBeanServerConnection

  name - The object name of the MBean from which the attribute is to be retrieved. - `javax.management.ObjectName`
  attribute - A String specifying the name of the attribute to be retrieved. - `java.lang.String`

  returns: The value of the retrieved attribute. - `java.lang.Object`

  throws: javax.management.RuntimeOperationsException - Wraps a java.lang.IllegalArgumentException: The object name in parameter is null or the attribute in parameter is null."
  (^java.lang.Object [^javax.management.MBeanServer this ^javax.management.ObjectName name ^java.lang.String attribute]
    (-> this (.getAttribute name attribute))))

(defn get-m-bean-info
  "Description copied from interface: MBeanServerConnection

  name - The name of the MBean to analyze - `javax.management.ObjectName`

  returns: An instance of MBeanInfo allowing the
   retrieval of all attributes and operations of this MBean. - `javax.management.MBeanInfo`

  throws: javax.management.InstanceNotFoundException - The MBean specified was not found."
  (^javax.management.MBeanInfo [^javax.management.MBeanServer this ^javax.management.ObjectName name]
    (-> this (.getMBeanInfo name))))

(defn create-m-bean
  "Instantiates and registers an MBean in the MBean server.  The
   class loader to be used is identified by its object name. An
   object name is associated with the MBean. If the object name of
   the loader is not specified, the ClassLoader that loaded the
   MBean server will be used.  If the MBean object name given is
   null, the MBean must provide its own name by implementing the
   MBeanRegistration
   interface and returning the name from the preRegister method.
   If this method successfully creates an MBean, a notification
   is sent as described above.

  class-name - The class name of the MBean to be instantiated. - `java.lang.String`
  name - The object name of the MBean. May be null. - `javax.management.ObjectName`
  loader-name - The object name of the class loader to be used. - `javax.management.ObjectName`
  params - An array containing the parameters of the constructor to be invoked. - `java.lang.Object[]`
  signature - An array containing the signature of the constructor to be invoked. - `java.lang.String[]`

  returns: An ObjectInstance, containing the
   ObjectName and the Java class name of the newly
   instantiated MBean.  If the contained ObjectName
   is n, the contained Java class name is
   getMBeanInfo(n).getClassName(). - `javax.management.ObjectInstance`

  throws: javax.management.MBeanException - The constructor of the MBean has thrown an exception"
  (^javax.management.ObjectInstance [^javax.management.MBeanServer this ^java.lang.String class-name ^javax.management.ObjectName name ^javax.management.ObjectName loader-name params signature]
    (-> this (.createMBean class-name name loader-name params signature)))
  (^javax.management.ObjectInstance [^javax.management.MBeanServer this ^java.lang.String class-name ^javax.management.ObjectName name params signature]
    (-> this (.createMBean class-name name params signature)))
  (^javax.management.ObjectInstance [^javax.management.MBeanServer this ^java.lang.String class-name ^javax.management.ObjectName name ^javax.management.ObjectName loader-name]
    (-> this (.createMBean class-name name loader-name)))
  (^javax.management.ObjectInstance [^javax.management.MBeanServer this ^java.lang.String class-name ^javax.management.ObjectName name]
    (-> this (.createMBean class-name name))))

(defn get-m-bean-count
  "Returns the number of MBeans registered in the MBean server.

  returns: the number of registered MBeans, wrapped in an Integer.
   If the caller's permissions are restricted, this number may
   be greater than the number of MBeans the caller can access. - `java.lang.Integer`"
  (^java.lang.Integer [^javax.management.MBeanServer this]
    (-> this (.getMBeanCount))))

(defn registered?
  "Description copied from interface: MBeanServerConnection

  name - The object name of the MBean to be checked. - `javax.management.ObjectName`

  returns: True if the MBean is already registered in the MBean
   server, false otherwise. - `boolean`

  throws: javax.management.RuntimeOperationsException - Wraps a java.lang.IllegalArgumentException: The object name in parameter is null."
  (^Boolean [^javax.management.MBeanServer this ^javax.management.ObjectName name]
    (-> this (.isRegistered name))))

(defn get-class-loader
  "Return the named ClassLoader.

  loader-name - The ObjectName of the ClassLoader. May be null, in which case the MBean server's own ClassLoader is returned. - `javax.management.ObjectName`

  returns: The named ClassLoader.  If l is the actual
   ClassLoader with that name, and r is the returned
   value, then either:


   r is identical to l; or
   the result of r.loadClass(s) is the
   same as l.loadClass(s) for any string s.


   What this means is that the ClassLoader may be wrapped in
   another ClassLoader for security or other reasons. - `java.lang.ClassLoader`

  throws: javax.management.InstanceNotFoundException - if the named ClassLoader is not found."
  (^java.lang.ClassLoader [^javax.management.MBeanServer this ^javax.management.ObjectName loader-name]
    (-> this (.getClassLoader loader-name))))

(defn unregister-m-bean
  "Unregisters an MBean from the MBean server. The MBean is
   identified by its object name. Once the method has been
   invoked, the MBean may no longer be accessed by its object
   name.

   If this method successfully unregisters an MBean, a notification
   is sent as described above.

  name - The object name of the MBean to be unregistered. - `javax.management.ObjectName`

  throws: javax.management.RuntimeOperationsException - Wraps a java.lang.IllegalArgumentException: The object name in parameter is null or the MBean you are when trying to unregister is the MBeanServerDelegate MBean."
  ([^javax.management.MBeanServer this ^javax.management.ObjectName name]
    (-> this (.unregisterMBean name))))

(defn get-default-domain
  "Description copied from interface: MBeanServerConnection

  returns: the default domain. - `java.lang.String`"
  (^java.lang.String [^javax.management.MBeanServer this]
    (-> this (.getDefaultDomain))))

(defn set-attribute
  "Description copied from interface: MBeanServerConnection

  name - The name of the MBean within which the attribute is to be set. - `javax.management.ObjectName`
  attribute - The identification of the attribute to be set and the value it is to be set to. - `javax.management.Attribute`

  throws: javax.management.RuntimeOperationsException - Wraps a java.lang.IllegalArgumentException: The object name in parameter is null or the attribute in parameter is null."
  ([^javax.management.MBeanServer this ^javax.management.ObjectName name ^javax.management.Attribute attribute]
    (-> this (.setAttribute name attribute))))

(defn get-object-instance
  "Description copied from interface: MBeanServerConnection

  name - The object name of the MBean. - `javax.management.ObjectName`

  returns: The ObjectInstance associated with the MBean
   specified by name.  The contained ObjectName
   is name and the contained class name is
   getMBeanInfo(name).getClassName(). - `javax.management.ObjectInstance`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  (^javax.management.ObjectInstance [^javax.management.MBeanServer this ^javax.management.ObjectName name]
    (-> this (.getObjectInstance name))))

(defn get-domains
  "Description copied from interface: MBeanServerConnection

  returns: the list of domains. - `java.lang.String[]`"
  ([^javax.management.MBeanServer this]
    (-> this (.getDomains))))

(defn instantiate
  "Instantiates an object. The class loader to be used is
   identified by its object name. If the object name of the loader
   is null, the ClassLoader that loaded the MBean server will be
   used.  The object's class should have a public constructor.
   The call returns a reference to the newly created object.  The
   newly created object is not registered in the MBean server.

  class-name - The class name of the object to be instantiated. - `java.lang.String`
  loader-name - The object name of the class loader to be used. - `javax.management.ObjectName`
  params - An array containing the parameters of the constructor to be invoked. - `java.lang.Object[]`
  signature - An array containing the signature of the constructor to be invoked. - `java.lang.String[]`

  returns: The newly instantiated object. - `java.lang.Object`

  throws: javax.management.ReflectionException - Wraps a java.lang.ClassNotFoundException or the java.lang.Exception that occurred when trying to invoke the object's constructor."
  (^java.lang.Object [^javax.management.MBeanServer this ^java.lang.String class-name ^javax.management.ObjectName loader-name params signature]
    (-> this (.instantiate class-name loader-name params signature)))
  (^java.lang.Object [^javax.management.MBeanServer this ^java.lang.String class-name params signature]
    (-> this (.instantiate class-name params signature)))
  (^java.lang.Object [^javax.management.MBeanServer this ^java.lang.String class-name ^javax.management.ObjectName loader-name]
    (-> this (.instantiate class-name loader-name)))
  (^java.lang.Object [^javax.management.MBeanServer this ^java.lang.String class-name]
    (-> this (.instantiate class-name))))

(defn set-attributes
  "Description copied from interface: MBeanServerConnection

  name - The object name of the MBean within which the attributes are to be set. - `javax.management.ObjectName`
  attributes - A list of attributes: The identification of the attributes to be set and the values they are to be set to. - `javax.management.AttributeList`

  returns: The list of attributes that were set, with their new
   values. - `javax.management.AttributeList`

  throws: javax.management.RuntimeOperationsException - Wraps a java.lang.IllegalArgumentException: The object name in parameter is null or attributes in parameter is null."
  (^javax.management.AttributeList [^javax.management.MBeanServer this ^javax.management.ObjectName name ^javax.management.AttributeList attributes]
    (-> this (.setAttributes name attributes))))

(defn get-class-loader-for
  "Return the ClassLoader that was used for
   loading the class of the named MBean.

  mbean-name - The ObjectName of the MBean. - `javax.management.ObjectName`

  returns: The ClassLoader used for that MBean.  If l
   is the MBean's actual ClassLoader, and r is the
   returned value, then either:


   r is identical to l; or
   the result of r.loadClass(s) is the
   same as l.loadClass(s) for any string s.


   What this means is that the ClassLoader may be wrapped in
   another ClassLoader for security or other reasons. - `java.lang.ClassLoader`

  throws: javax.management.InstanceNotFoundException - if the named MBean is not found."
  (^java.lang.ClassLoader [^javax.management.MBeanServer this ^javax.management.ObjectName mbean-name]
    (-> this (.getClassLoaderFor mbean-name))))

(defn add-notification-listener
  "Adds a listener to a registered MBean.
   Notifications emitted by the MBean will be forwarded to the listener.
   If the source of the notification
   is a reference to an MBean object, the MBean server will replace it
   by that MBean's ObjectName.  Otherwise the source is unchanged.

  name - The name of the MBean on which the listener should be added. - `javax.management.ObjectName`
  listener - The listener object which will handle the notifications emitted by the registered MBean. - `javax.management.NotificationListener`
  filter - The filter object. If filter is null, no filtering will be performed before handling notifications. - `javax.management.NotificationFilter`
  handback - The context to be sent to the listener when a notification is emitted. - `java.lang.Object`

  throws: javax.management.InstanceNotFoundException - The MBean name provided does not match any of the registered MBeans."
  ([^javax.management.MBeanServer this ^javax.management.ObjectName name ^javax.management.NotificationListener listener ^javax.management.NotificationFilter filter ^java.lang.Object handback]
    (-> this (.addNotificationListener name listener filter handback))))

(defn get-attributes
  "Description copied from interface: MBeanServerConnection

  name - The object name of the MBean from which the attributes are retrieved. - `javax.management.ObjectName`
  attributes - A list of the attributes to be retrieved. - `java.lang.String[]`

  returns: The list of the retrieved attributes. - `javax.management.AttributeList`

  throws: javax.management.RuntimeOperationsException - Wrap a java.lang.IllegalArgumentException: The object name in parameter is null or attributes in parameter is null."
  (^javax.management.AttributeList [^javax.management.MBeanServer this ^javax.management.ObjectName name attributes]
    (-> this (.getAttributes name attributes))))

(defn deserialize
  "Deprecated. Use getClassLoader to obtain
   the class loader for deserialization.

  class-name - The name of the class whose class loader should be used for the de-serialization. - `java.lang.String`
  loader-name - The name of the class loader to be used for loading the specified class. If null, the MBean Server's class loader will be used. - `javax.management.ObjectName`
  data - The byte array to be de-sererialized. - `byte[]`

  returns: The de-serialized object stream. - `java.lang..io.ObjectInputStream`

  throws: javax.management.InstanceNotFoundException - The specified class loader MBean is not found."
  (^java.lang..io.ObjectInputStream [^javax.management.MBeanServer this ^java.lang.String class-name ^javax.management.ObjectName loader-name data]
    (-> this (.deserialize class-name loader-name data)))
  (^java.lang..io.ObjectInputStream [^javax.management.MBeanServer this ^javax.management.ObjectName name data]
    (-> this (.deserialize name data))))

(defn register-m-bean
  "Registers a pre-existing object as an MBean with the MBean
   server. If the object name given is null, the MBean must
   provide its own name by implementing the MBeanRegistration interface
   and returning the name from the preRegister method.

   If this method successfully registers an MBean, a notification
   is sent as described above.

  object - The MBean to be registered as an MBean. - `java.lang.Object`
  name - The object name of the MBean. May be null. - `javax.management.ObjectName`

  returns: An ObjectInstance, containing the
   ObjectName and the Java class name of the newly
   registered MBean.  If the contained ObjectName
   is n, the contained Java class name is
   getMBeanInfo(n).getClassName(). - `javax.management.ObjectInstance`

  throws: javax.management.InstanceAlreadyExistsException - The MBean is already under the control of the MBean server."
  (^javax.management.ObjectInstance [^javax.management.MBeanServer this ^java.lang.Object object ^javax.management.ObjectName name]
    (-> this (.registerMBean object name))))

(defn instance-of?
  "Description copied from interface: MBeanServerConnection

  name - The ObjectName of the MBean. - `javax.management.ObjectName`
  class-name - The name of the class. - `java.lang.String`

  returns: true if the MBean specified is an instance of the
   specified class according to the rules above, false otherwise. - `boolean`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  (^Boolean [^javax.management.MBeanServer this ^javax.management.ObjectName name ^java.lang.String class-name]
    (-> this (.isInstanceOf name class-name))))

