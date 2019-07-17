(ns javax.management.MBeanServerConnection
  "This interface represents a way to talk to an MBean server, whether
  local or remote.  The MBeanServer interface, representing a
  local MBean server, extends this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management MBeanServerConnection]))

(defn invoke
  "Invokes an operation on an MBean.

   Because of the need for a signature to differentiate
   possibly-overloaded operations, it is much simpler to invoke operations
   through an MBean proxy where possible.  For example, suppose you have a
   Standard MBean interface like this:



   public interface FooMBean {
       public int countMatches(String[] patterns, boolean ignoreCase);
   }

   The countMatches operation can be invoked as follows:



   String[] myPatterns = ...;
   int count = (Integer) mbeanServerConnection.invoke(
           objectName,
           `countMatches`,
           new Object[] {myPatterns, true},
           new String[] {String[].class.getName(), boolean.class.getName()});

   Alternatively, it can be invoked through a proxy as follows:



   String[] myPatterns = ...;
   FooMBean fooProxy = JMX.newMBeanProxy(
           mbeanServerConnection, objectName, FooMBean.class);
   int count = fooProxy.countMatches(myPatterns, true);

  name - The object name of the MBean on which the method is to be invoked. - `javax.management.ObjectName`
  operation-name - The name of the operation to be invoked. - `java.lang.String`
  params - An array containing the parameters to be set when the operation is invoked - `java.lang.Object[]`
  signature - An array containing the signature of the operation, an array of class names in the format returned by Class.getName(). The class objects will be loaded using the same class loader as the one used for loading the MBean on which the operation was invoked. - `java.lang.String[]`

  returns: The object returned by the operation, which represents
   the result of invoking the operation on the MBean specified. - `java.lang.Object`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  ([^. this ^javax.management.ObjectName name ^java.lang.String operation-name ^java.lang.Object[] params ^java.lang.String[] signature]
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

  throws: java.io.IOException - A communication problem occurred when talking to the MBean server."
  ([^. this ^javax.management.ObjectName name ^javax.management.QueryExp query]
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

  throws: java.io.IOException - A communication problem occurred when talking to the MBean server."
  ([^. this ^javax.management.ObjectName name ^javax.management.QueryExp query]
    (-> this (.queryNames name query))))

(defn remove-notification-listener
  "Removes a listener from a registered MBean.

   The MBean must have a listener that exactly matches the
   given listener, filter, and
   handback parameters.  If there is more than one
   such listener, only one is removed.

   The filter and handback parameters
   may be null if and only if they are null in a listener to be
   removed.

  name - The name of the MBean on which the listener should be removed. - `javax.management.ObjectName`
  listener - The object name of the listener to be removed. - `javax.management.ObjectName`
  filter - The filter that was specified when the listener was added. - `javax.management.NotificationFilter`
  handback - The handback that was specified when the listener was added. - `java.lang.Object`

  throws: javax.management.InstanceNotFoundException - The MBean name provided does not match any of the registered MBeans."
  ([^. this ^javax.management.ObjectName name ^javax.management.ObjectName listener ^javax.management.NotificationFilter filter ^java.lang.Object handback]
    (-> this (.removeNotificationListener name listener filter handback)))
  ([^. this ^javax.management.ObjectName name ^javax.management.ObjectName listener]
    (-> this (.removeNotificationListener name listener))))

(defn get-attribute
  "Gets the value of a specific attribute of a named MBean. The MBean
   is identified by its object name.

  name - The object name of the MBean from which the attribute is to be retrieved. - `javax.management.ObjectName`
  attribute - A String specifying the name of the attribute to be retrieved. - `java.lang.String`

  returns: The value of the retrieved attribute. - `java.lang.Object`

  throws: javax.management.AttributeNotFoundException - The attribute specified is not accessible in the MBean."
  ([^. this ^javax.management.ObjectName name ^java.lang.String attribute]
    (-> this (.getAttribute name attribute))))

(defn get-m-bean-info
  "This method discovers the attributes and operations that an
   MBean exposes for management.

  name - The name of the MBean to analyze - `javax.management.ObjectName`

  returns: An instance of MBeanInfo allowing the
   retrieval of all attributes and operations of this MBean. - `javax.management.MBeanInfo`

  throws: javax.management.IntrospectionException - An exception occurred during introspection."
  ([^. this ^javax.management.ObjectName name]
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
  ([^. this ^java.lang.String class-name ^javax.management.ObjectName name ^javax.management.ObjectName loader-name ^java.lang.Object[] params ^java.lang.String[] signature]
    (-> this (.createMBean class-name name loader-name params signature)))
  ([^. this ^java.lang.String class-name ^javax.management.ObjectName name ^java.lang.Object[] params ^java.lang.String[] signature]
    (-> this (.createMBean class-name name params signature)))
  ([^. this ^java.lang.String class-name ^javax.management.ObjectName name ^javax.management.ObjectName loader-name]
    (-> this (.createMBean class-name name loader-name)))
  ([^. this ^java.lang.String class-name ^javax.management.ObjectName name]
    (-> this (.createMBean class-name name))))

(defn get-m-bean-count
  "Returns the number of MBeans registered in the MBean server.

  returns: the number of MBeans registered. - `java.lang.Integer`

  throws: java.io.IOException - A communication problem occurred when talking to the MBean server."
  ([^. this]
    (-> this (.getMBeanCount))))

(defn registered?
  "Checks whether an MBean, identified by its object name, is
   already registered with the MBean server.

  name - The object name of the MBean to be checked. - `javax.management.ObjectName`

  returns: True if the MBean is already registered in the MBean
   server, false otherwise. - `boolean`

  throws: javax.management.RuntimeOperationsException - Wraps a java.lang.IllegalArgumentException: The object name in parameter is null."
  ([^. this ^javax.management.ObjectName name]
    (-> this (.isRegistered name))))

(defn unregister-m-bean
  "Unregisters an MBean from the MBean server. The MBean is
   identified by its object name. Once the method has been
   invoked, the MBean may no longer be accessed by its object
   name.

  name - The object name of the MBean to be unregistered. - `javax.management.ObjectName`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  ([^. this ^javax.management.ObjectName name]
    (-> this (.unregisterMBean name))))

(defn get-default-domain
  "Returns the default domain used for naming the MBean.
   The default domain name is used as the domain part in the ObjectName
   of MBeans if no domain is specified by the user.

  returns: the default domain. - `java.lang.String`

  throws: java.io.IOException - A communication problem occurred when talking to the MBean server."
  ([^. this]
    (-> this (.getDefaultDomain))))

(defn set-attribute
  "Sets the value of a specific attribute of a named MBean. The MBean
   is identified by its object name.

  name - The name of the MBean within which the attribute is to be set. - `javax.management.ObjectName`
  attribute - The identification of the attribute to be set and the value it is to be set to. - `javax.management.Attribute`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  ([^. this ^javax.management.ObjectName name ^javax.management.Attribute attribute]
    (-> this (.setAttribute name attribute))))

(defn get-object-instance
  "Gets the ObjectInstance for a given MBean
   registered with the MBean server.

  name - The object name of the MBean. - `javax.management.ObjectName`

  returns: The ObjectInstance associated with the MBean
   specified by name.  The contained ObjectName
   is name and the contained class name is
   getMBeanInfo(name).getClassName(). - `javax.management.ObjectInstance`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  ([^. this ^javax.management.ObjectName name]
    (-> this (.getObjectInstance name))))

(defn get-domains
  "Returns the list of domains in which any MBean is currently
   registered.  A string is in the returned array if and only if
   there is at least one MBean registered with an ObjectName whose
   getDomain() is equal to that
   string.  The order of strings within the returned array is
   not defined.

  returns: the list of domains. - `java.lang.String[]`

  throws: java.io.IOException - A communication problem occurred when talking to the MBean server."
  ([^. this]
    (-> this (.getDomains))))

(defn set-attributes
  "Sets the values of several attributes of a named MBean. The MBean is
   identified by its object name.

   If one or more attributes cannot be set for some reason, they will be
   omitted from the returned AttributeList.  The caller should check
   that the input AttributeList is the same size as the output one.
   To discover what problem prevented a given attribute from being retrieved,
   it will usually be possible to call setAttribute
   for that attribute, although this is not guaranteed to work.  (For
   example, the values of two attributes may have been rejected because
   they were inconsistent with each other.  Setting one of them alone might
   be allowed.)

   Here is an example of calling this method and checking that it
   succeeded in setting all the requested attributes:



   AttributeList inputAttrs = ...;
   AttributeList outputAttrs = mbeanServerConnection.setAttributes(
   objectName, inputAttrs);
   if (inputAttrs.size() == outputAttrs.size())
       System.out.println(`All attributes were set successfully`);
   else {
        List<String> missing = new  ArrayList<String>();
       for (Attribute a : inputAttrs.asList())
           missing.add(a.getName());
       for (Attribute a : outputAttrs.asList())
           missing.remove(a.getName());
       System.out.println(`Did not set: `  missing);
   }

  name - The object name of the MBean within which the attributes are to be set. - `javax.management.ObjectName`
  attributes - A list of attributes: The identification of the attributes to be set and the values they are to be set to. - `javax.management.AttributeList`

  returns: The list of attributes that were set, with their new
   values. - `javax.management.AttributeList`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  ([^. this ^javax.management.ObjectName name ^javax.management.AttributeList attributes]
    (-> this (.setAttributes name attributes))))

(defn add-notification-listener
  "Adds a listener to a registered MBean.
   Notifications emitted by the MBean will be forwarded to the listener.

  name - The name of the MBean on which the listener should be added. - `javax.management.ObjectName`
  listener - The listener object which will handle the notifications emitted by the registered MBean. - `javax.management.NotificationListener`
  filter - The filter object. If filter is null, no filtering will be performed before handling notifications. - `javax.management.NotificationFilter`
  handback - The context to be sent to the listener when a notification is emitted. - `java.lang.Object`

  throws: javax.management.InstanceNotFoundException - The MBean name provided does not match any of the registered MBeans."
  ([^. this ^javax.management.ObjectName name ^javax.management.NotificationListener listener ^javax.management.NotificationFilter filter ^java.lang.Object handback]
    (-> this (.addNotificationListener name listener filter handback))))

(defn get-attributes
  "Retrieves the values of several attributes of a named MBean. The MBean
   is identified by its object name.

   If one or more attributes cannot be retrieved for some reason, they
   will be omitted from the returned AttributeList.  The caller
   should check that the list is the same size as the attributes
   array.  To discover what problem prevented a given attribute from being
   retrieved, call getAttribute for that attribute.

   Here is an example of calling this method and checking that it
   succeeded in retrieving all the requested attributes:



   String[] attrNames = ...;
   AttributeList list = mbeanServerConnection.getAttributes(objectName, attrNames);
   if (list.size() == attrNames.length)
       System.out.println(`All attributes were retrieved successfully`);
   else {
        List<String> missing = new  ArrayList<String>(
   Arrays.asList(attrNames));
       for (Attribute a : list.asList())
           missing.remove(a.getName());
       System.out.println(`Did not retrieve: `  missing);
   }

  name - The object name of the MBean from which the attributes are retrieved. - `javax.management.ObjectName`
  attributes - A list of the attributes to be retrieved. - `java.lang.String[]`

  returns: The list of the retrieved attributes. - `javax.management.AttributeList`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  ([^. this ^javax.management.ObjectName name ^java.lang.String[] attributes]
    (-> this (.getAttributes name attributes))))

(defn instance-of?
  "Returns true if the MBean specified is an instance of the
   specified class, false otherwise.

   If name does not name an MBean, this method
   throws InstanceNotFoundException.

   Otherwise, let
   X be the MBean named by name,
   L be the ClassLoader of X,
   N be the class name in X's MBeanInfo.

   If N equals className, the result is true.

   Otherwise, if L successfully loads className
   and X is an instance of this class, the result is true.

   Otherwise, if L successfully loads both N and
   className, and the second class is assignable from
   the first, the result is true.

   Otherwise, the result is false.

  name - The ObjectName of the MBean. - `javax.management.ObjectName`
  class-name - The name of the class. - `java.lang.String`

  returns: true if the MBean specified is an instance of the
   specified class according to the rules above, false otherwise. - `boolean`

  throws: javax.management.InstanceNotFoundException - The MBean specified is not registered in the MBean server."
  ([^. this ^javax.management.ObjectName name ^java.lang.String class-name]
    (-> this (.isInstanceOf name class-name))))

