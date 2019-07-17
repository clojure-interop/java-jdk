(ns javax.management.modelmbean.RequiredModelMBean
  "This class is the implementation of a ModelMBean. An appropriate
  implementation of a ModelMBean must be shipped with every JMX Agent
  and the class must be named RequiredModelMBean.

  Java resources wishing to be manageable instantiate the
  RequiredModelMBean using the MBeanServer's createMBean method.
  The resource then sets the MBeanInfo and Descriptors for the
  RequiredModelMBean instance. The attributes and operations exposed
  via the ModelMBeanInfo for the ModelMBean are accessible
  from MBeans, connectors/adaptors like other MBeans. Through the
  Descriptors, values and methods in the managed application can be
  defined and mapped to attributes and operations of the ModelMBean.
  This mapping can be defined in an XML formatted file or dynamically and
  programmatically at runtime.

  Every RequiredModelMBean which is instantiated in the MBeanServer
  becomes manageable:
  its attributes and operations become remotely accessible through the
  connectors/adaptors connected to that MBeanServer.

  A Java object cannot be registered in the MBeanServer unless it is a
  JMX compliant MBean. By instantiating a RequiredModelMBean, resources
  are guaranteed that the MBean is valid.

  MBeanException and RuntimeOperationsException must be thrown on every
  public method.  This allows for wrapping exceptions from distributed
  communications (RMI, EJB, etc.)"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.modelmbean RequiredModelMBean]))

(defn ->required-model-m-bean
  "Constructor.

  Constructs a RequiredModelMBean object using ModelMBeanInfo passed in.
   As long as the RequiredModelMBean is not registered
   with the MBeanServer yet, the RequiredModelMBean's MBeanInfo and
   Descriptors can be customized using the setModelMBeanInfo(javax.management.modelmbean.ModelMBeanInfo)
   method.
   After the RequiredModelMBean's MBeanInfo and Descriptors are
   customized, the RequiredModelMBean can be registered with the
   MBeanServer.

  mbi - The ModelMBeanInfo object to be used by the RequiredModelMBean. The given ModelMBeanInfo is cloned and modified as specified by setModelMBeanInfo(javax.management.modelmbean.ModelMBeanInfo) - `javax.management.modelmbean.ModelMBeanInfo`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([mbi]
    (new RequiredModelMBean mbi))
  ([]
    (new RequiredModelMBean )))

(defn invoke
  "Invokes a method on or through a RequiredModelMBean and returns
   the result of the method execution.

   If the given method to be invoked, together with the provided
   signature, matches one of RequiredModelMbean
   accessible methods, this one will be call. Otherwise the call to
   the given method will be tried on the managed resource.

   The last value returned by an operation may be cached in
   the operation's descriptor which
   is in the ModelMBeanOperationInfo's descriptor.
   The valid value will be in the 'value' field if there is one.
   If the 'currencyTimeLimit' field in the descriptor is:

   <0 Then the value is not cached and is never valid.
        The operation method is invoked.
        The 'value' and 'lastUpdatedTimeStamp' fields are cleared.
   =0 Then the value is always cached and always valid.
        The 'value' field is returned. If there is no 'value' field
        then the operation method is invoked for the attribute.
        The 'lastUpdatedTimeStamp' field and `value' fields are set to
        the operation's return value and the current time stamp.
   >0 Represents the number of seconds that the 'value'
        field is valid.
        The 'value' field is no longer valid when
        'lastUpdatedTimeStamp'  'currencyTimeLimit' > Now.

           When 'value' is valid, 'value' is returned.
           When 'value' is no longer valid then the operation
               method is invoked. The 'lastUpdatedTimeStamp' field
               and `value' fields are updated.




   Note: because of inconsistencies in previous versions of
   this specification, it is recommended not to use negative or zero
   values for currencyTimeLimit.  To indicate that a
   cached value is never valid, omit the
   currencyTimeLimit field.  To indicate that it is
   always valid, use a very large number for this field.

  op-name - The name of the method to be invoked. The name can be the fully qualified method name including the classname, or just the method name if the classname is defined in the 'class' field of the operation descriptor. - `java.lang.String`
  op-args - An array containing the parameters to be set when the operation is invoked - `java.lang.Object[]`
  sig - An array containing the signature of the operation. The class objects will be loaded using the same class loader as the one used for loading the MBean on which the operation was invoked. - `java.lang.String[]`

  returns: The object returned by the method, which represents the
       result of invoking the method on the specified managed resource. - `java.lang.Object`

  throws: javax.management.MBeanException - Wraps one of the following Exceptions: An Exception thrown by the managed object's invoked method. ServiceNotFoundException: No ModelMBeanOperationInfo or no descriptor defined for the specified operation or the managed resource is null. InvalidTargetObjectTypeException: The 'targetType' field value is not 'objectReference'."
  ([this op-name op-args sig]
    (-> this (.invoke op-name op-args sig))))

(defn load
  "Instantiates this MBean instance with the data found for
   the MBean in the persistent store.  The data loaded could include
   attribute and operation values.

   This method should be called during construction or
   initialization of this instance, and before the MBean is
   registered with the MBeanServer.

   If the implementation of this class does not support
   persistence, an MBeanException wrapping a ServiceNotFoundException is thrown.

  throws: javax.management.MBeanException - Wraps another exception, or persistence is not supported"
  ([this]
    (-> this (.load))))

(defn get-notification-info
  "Returns the array of Notifications always generated by the
   RequiredModelMBean.


   RequiredModelMBean may always send also two additional notifications:

      One with descriptor `name=GENERIC,descriptorType=notification,log=T,severity=6,displayName=jmx.modelmbean.generic`
      Second is a standard attribute change notification
          with descriptor `name=ATTRIBUTE_CHANGE,descriptorType=notification,log=T,severity=6,displayName=jmx.attribute.change`

   Thus these two notifications are always added to those specified
   by the application.

  returns: MBeanNotificationInfo[] - `javax.management.MBeanNotificationInfo[]`"
  ([this]
    (-> this (.getNotificationInfo))))

(defn post-deregister
  "Allows the MBean to perform any operations needed after having been
   unregistered in the MBean server.

   In order to ensure proper run-time semantics of RequireModelMBean,
   Any subclass of RequiredModelMBean overloading or overriding this
   method should call super.postDeregister() in its own
   postDeregister implementation."
  ([this]
    (-> this (.postDeregister))))

(defn set-managed-resource
  "Sets the instance handle of the object against which to
   execute all methods in this ModelMBean management interface
   (MBeanInfo and Descriptors).

  mr - Object that is the managed resource - `java.lang.Object`
  mr-type - The type of reference for the managed resource. Can be: `ObjectReference`, `Handle`, `IOR`, `EJBHandle`, or `RMIReference`. In this implementation only `ObjectReference` is supported. - `java.lang.String`

  throws: javax.management.MBeanException - The initializer of the object has thrown an exception."
  ([this mr mr-type]
    (-> this (.setManagedResource mr mr-type))))

(defn remove-notification-listener
  "Description copied from interface: NotificationEmitter

  listener - A listener that was previously added to this MBean. - `javax.management.NotificationListener`
  filter - The filter that was specified when the listener was added. - `javax.management.NotificationFilter`
  handback - The handback that was specified when the listener was added. - `java.lang.Object`

  throws: javax.management.ListenerNotFoundException - The listener is not registered with the MBean, or it is not registered with the given filter and handback."
  ([this listener filter handback]
    (-> this (.removeNotificationListener listener filter handback)))
  ([this listener]
    (-> this (.removeNotificationListener listener))))

(defn pre-deregister
  "Allows the MBean to perform any operations it needs before
   being unregistered by the MBean server.

   In order to ensure proper run-time semantics of RequireModelMBean,
   Any subclass of RequiredModelMBean overloading or overriding this
   method should call super.preDeregister() in its own
   preDeregister implementation.

  throws: java.lang.Exception - This exception will be caught by the MBean server and re-thrown as an MBeanRegistrationException."
  ([this]
    (-> this (.preDeregister))))

(defn get-attribute
  "Returns the value of a specific attribute defined for this
   ModelMBean.
   The last value returned by an attribute may be cached in the
   attribute's descriptor.
   The valid value will be in the 'value' field if there is one.
   If the 'currencyTimeLimit' field in the descriptor is:

     <0 Then the value is not cached and is never valid.
         The getter method is invoked for the attribute.
         The 'value' and 'lastUpdatedTimeStamp' fields are cleared.
     =0 Then the value is always cached and always valid.
         The 'value' field is returned. If there is no'value' field
         then the getter method is invoked for the attribute.
         The 'lastUpdatedTimeStamp' field and `value' fields are set
         to the attribute's value and the current time stamp.
     >0 Represents the number of seconds that the 'value'
         field is valid.
         The 'value' field is no longer valid when
         'lastUpdatedTimeStamp'  'currencyTimeLimit' > Now.

          When 'value' is valid, 'value' is returned.
          When 'value' is no longer valid then the getter
              method is invoked for the attribute.
              The 'lastUpdatedTimeStamp' field and `value' fields
              are updated.



   Note: because of inconsistencies in previous versions of
   this specification, it is recommended not to use negative or zero
   values for currencyTimeLimit.  To indicate that a
   cached value is never valid, omit the
   currencyTimeLimit field.  To indicate that it is
   always valid, use a very large number for this field.

   If the 'getMethod' field contains the name of a valid
   operation descriptor, then the method described by the
   operation descriptor is executed.  The response from the
   method is returned as the value of the attribute.  If the
   operation fails or the returned value is not compatible with
   the declared type of the attribute, an exception will be thrown.

   If no 'getMethod' field is defined then the default value of the
   attribute is returned. If the returned value is not compatible with
   the declared type of the attribute, an exception will be thrown.

   The declared type of the attribute is the String returned by
   MBeanAttributeInfo.getType().  A value is compatible
   with this type if one of the following is true:

   the value is null;
   the declared name is a primitive type name (such as `int`)
       and the value is an instance of the corresponding wrapper
       type (such as java.lang.Integer);
   the name of the value's class is identical to the declared name;
   the declared name can be loaded by the value's class loader and
       produces a class to which the value can be assigned.


   In this implementation, in every case where the getMethod needs to
   be called, because the method is invoked through the standard `invoke`
   method and thus needs operationInfo, an operation must be specified
   for that getMethod so that the invocation works correctly.

  attr-name - A String specifying the name of the attribute to be retrieved. It must match the name of a ModelMBeanAttributeInfo. - `java.lang.String`

  returns: The value of the retrieved attribute from the
   descriptor 'value' field or from the invocation of the
   operation in the 'getMethod' field of the descriptor. - `java.lang.Object`

  throws: javax.management.AttributeNotFoundException - The specified attribute is not accessible in the MBean. The following cases may result in an AttributeNotFoundException: No ModelMBeanInfo was found for the Model MBean. No ModelMBeanAttributeInfo was found for the specified attribute name. The ModelMBeanAttributeInfo isReadable method returns 'false'."
  ([this attr-name]
    (-> this (.getAttribute attr-name))))

(defn get-m-bean-info
  "Returns the attributes, operations, constructors and notifications
   that this RequiredModelMBean exposes for management.

  returns: An instance of ModelMBeanInfo allowing retrieval all
            attributes, operations, and Notifications of this MBean. - `javax.management.MBeanInfo`"
  ([this]
    (-> this (.getMBeanInfo))))

(defn add-attribute-change-notification-listener
  "Description copied from interface: ModelMBeanNotificationBroadcaster

  inlistener - The listener object which will handles notifications emitted by the registered MBean. - `javax.management.NotificationListener`
  in-attribute-name - The name of the ModelMBean attribute for which to receive change notifications. If null, then all attribute changes will cause an attributeChangeNotification to be issued. - `java.lang.String`
  inhandback - The context to be sent to the listener with the notification when a notification is emitted. - `java.lang.Object`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([this inlistener in-attribute-name inhandback]
    (-> this (.addAttributeChangeNotificationListener inlistener in-attribute-name inhandback))))

(defn remove-attribute-change-notification-listener
  "Description copied from interface: ModelMBeanNotificationBroadcaster

  inlistener - The listener name which was handling notifications emitted by the registered MBean. This method will remove all information related to this listener. - `javax.management.NotificationListener`
  in-attribute-name - The attribute for which the listener no longer wants to receive attributeChangeNotifications. If null the listener will be removed for all attributeChangeNotifications. - `java.lang.String`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([this inlistener in-attribute-name]
    (-> this (.removeAttributeChangeNotificationListener inlistener in-attribute-name))))

(defn post-register
  "Allows the MBean to perform any operations needed after having been
   registered in the MBean server or after the registration has failed.

   In order to ensure proper run-time semantics of RequireModelMBean,
   Any subclass of RequiredModelMBean overloading or overriding this
   method should call super.postRegister(registrationDone)
   in its own postRegister implementation.

  registration-done - Indicates whether or not the MBean has been successfully registered in the MBean server. The value false means that the registration phase has failed. - `java.lang.Boolean`"
  ([this registration-done]
    (-> this (.postRegister registration-done))))

(defn set-attribute
  "Sets the value of a specific attribute of a named ModelMBean.

   If the 'setMethod' field of the attribute's descriptor
   contains the name of a valid operation descriptor, then the
   method described by the operation descriptor is executed.
   In this implementation, the operation descriptor must be specified
   correctly and assigned to the modelMBeanInfo so that the 'setMethod'
   works correctly.
   The response from the method is set as the value of the attribute
   in the descriptor.

   If currencyTimeLimit is > 0, then the new value for the
   attribute is cached in the attribute descriptor's
   'value' field and the 'lastUpdatedTimeStamp' field is set to
   the current time stamp.

   If the persist field of the attribute's descriptor is not null
   then Persistence policy from the attribute descriptor is used to
   guide storing the attribute in a persistent store.
   Store the MBean if 'persistPolicy' field is:

    != `never`
    = `always`
    = `onUpdate`
    = `onTimer` and now > 'lastPersistTime'  'persistPeriod'
    = `NoMoreOftenThan` and now > 'lastPersistTime'
           'persistPeriod'

   Do not store the MBean if 'persistPolicy' field is:

    = `never`
    = = `onTimer` && now < 'lastPersistTime'  'persistPeriod'
    = `onUnregister`
    = = `NoMoreOftenThan` and now < 'lastPersistTime'
          'persistPeriod'


   The ModelMBeanInfo of the Model MBean is stored in a file.

  attribute - The Attribute instance containing the name of the attribute to be set and the value it is to be set to. - `javax.management.Attribute`

  throws: javax.management.AttributeNotFoundException - The specified attribute is not accessible in the MBean. The following cases may result in an AttributeNotFoundException: No ModelMBeanAttributeInfo is found for the specified attribute. The ModelMBeanAttributeInfo's isWritable method returns 'false'."
  ([this attribute]
    (-> this (.setAttribute attribute))))

(defn set-attributes
  "Sets the values of an array of attributes of this ModelMBean.
   Executes the setAttribute() method for each attribute in the list.

  attributes - A list of attributes: The identification of the attributes to be set and the values they are to be set to. - `javax.management.AttributeList`

  returns: The array of attributes that were set, with their new
      values in Attribute instances. - `javax.management.AttributeList`

  throws: javax.management.RuntimeOperationsException - Wraps an IllegalArgumentException: The object name in parameter is null or attributes in parameter is null."
  ([this attributes]
    (-> this (.setAttributes attributes))))

(defn set-model-m-bean-info
  "Initializes a ModelMBean object using ModelMBeanInfo passed in.
   This method makes it possible to set a customized ModelMBeanInfo on
   the ModelMBean as long as it is not registered with the MBeanServer.

   Once the ModelMBean's ModelMBeanInfo (with Descriptors) are
   customized and set on the ModelMBean, the  ModelMBean be
   registered with the MBeanServer.

   If the ModelMBean is currently registered, this method throws
   a RuntimeOperationsException wrapping an
   IllegalStateException

   If the given inModelMBeanInfo does not contain any
   ModelMBeanNotificationInfo for the GENERIC
   or ATTRIBUTE_CHANGE notifications, then the
   RequiredModelMBean will supply its own default
   ModelMBeanNotificationInfos for
   those missing notifications.

  mbi - The ModelMBeanInfo object to be used by the ModelMBean. - `javax.management.modelmbean.ModelMBeanInfo`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([this mbi]
    (-> this (.setModelMBeanInfo mbi))))

(defn add-notification-listener
  "Registers an object which implements the NotificationListener
   interface as a listener.  This
   object's 'handleNotification()' method will be invoked when any
   notification is issued through or by the ModelMBean.  This does
   not include attributeChangeNotifications.  They must be registered
   for independently.

  listener - The listener object which will handles notifications emitted by the registered MBean. - `javax.management.NotificationListener`
  filter - The filter object. If null, no filtering will be performed before handling notifications. - `javax.management.NotificationFilter`
  handback - The context to be sent to the listener with the notification when a notification is emitted. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - The listener cannot be null."
  ([this listener filter handback]
    (-> this (.addNotificationListener listener filter handback))))

(defn send-notification
  "Description copied from interface: ModelMBeanNotificationBroadcaster

  ntfy-obj - The notification which is to be passed to the 'handleNotification' method of the listener object. - `javax.management.Notification`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([this ntfy-obj]
    (-> this (.sendNotification ntfy-obj))))

(defn pre-register
  "Allows the MBean to perform any operations it needs before
   being registered in the MBean server.  If the name of the MBean
   is not specified, the MBean can provide a name for its
   registration.  If any exception is raised, the MBean will not be
   registered in the MBean server.

   In order to ensure proper run-time semantics of RequireModelMBean,
   Any subclass of RequiredModelMBean overloading or overriding this
   method should call super.preRegister(server, name)
   in its own preRegister implementation.

  server - The MBean server in which the MBean will be registered. - `javax.management.MBeanServer`
  name - The object name of the MBean. This name is null if the name parameter to one of the createMBean or registerMBean methods in the MBeanServer interface is null. In that case, this method must return a non-null ObjectName for the new MBean. - `javax.management.ObjectName`

  returns: The name under which the MBean is to be registered.
   This value must not be null.  If the name
   parameter is not null, it will usually but not necessarily be
   the returned value. - `javax.management.ObjectName`

  throws: java.lang.Exception - This exception will be caught by the MBean server and re-thrown as an MBeanRegistrationException."
  ([this server name]
    (-> this (.preRegister server name))))

(defn send-attribute-change-notification
  "Description copied from interface: ModelMBeanNotificationBroadcaster

  in-old-val - The original value for the Attribute - `javax.management.Attribute`
  in-new-val - The current value for the Attribute The constructed attributeChangeNotification will be: type `jmx.attribute.change` source this ModelMBean instance sequence 1 attributeName oldValue.getName() attributeType oldValue's class attributeOldValue oldValue.getValue() attributeNewValue newValue.getValue() - `javax.management.Attribute`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([this in-old-val in-new-val]
    (-> this (.sendAttributeChangeNotification in-old-val in-new-val)))
  ([this ntfy-obj]
    (-> this (.sendAttributeChangeNotification ntfy-obj))))

(defn store
  "Captures the current state of this MBean instance and writes
   it out to the persistent store.  The state stored could include
   attribute and operation values.

   If the implementation of this class does not support
   persistence, an MBeanException wrapping a ServiceNotFoundException is thrown.

   Persistence policy from the MBean and attribute descriptor
   is used to guide execution of this method. The MBean should be
   stored if 'persistPolicy' field is:



    != `never`
     = `always`
     = `onTimer` and now > 'lastPersistTime'  'persistPeriod'
     = `NoMoreOftenThan` and now > 'lastPersistTime'  'persistPeriod'
     = `onUnregister`

   Do not store the MBean if 'persistPolicy' field is:


      = `never`
      = `onUpdate`
      = `onTimer` && now < 'lastPersistTime'  'persistPeriod'

  throws: javax.management.MBeanException - Wraps another exception, or persistence is not supported"
  ([this]
    (-> this (.store))))

(defn get-attributes
  "Returns the values of several attributes in the ModelMBean.
   Executes a getAttribute for each attribute name in the
   attrNames array passed in.

  attr-names - A String array of names of the attributes to be retrieved. - `java.lang.String[]`

  returns: The array of the retrieved attributes. - `javax.management.AttributeList`

  throws: javax.management.RuntimeOperationsException - Wraps an IllegalArgumentException: The object name in parameter is null or attributes in parameter is null."
  ([this attr-names]
    (-> this (.getAttributes attr-names))))

