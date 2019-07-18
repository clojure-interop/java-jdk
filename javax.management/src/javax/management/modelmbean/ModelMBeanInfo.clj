(ns javax.management.modelmbean.ModelMBeanInfo
  "This interface is implemented by the ModelMBeanInfo for every ModelMBean. An implementation of this interface
  must be shipped with every JMX Agent.

  Java resources wishing to be manageable instantiate the ModelMBean using the MBeanServer's
  createMBean method.  The resource then sets the ModelMBeanInfo and Descriptors for the ModelMBean
  instance. The attributes, operations, and notifications exposed via the ModelMBeanInfo for the
  ModelMBean comprise the management interface and are accessible
  from MBeans, connectors/adaptors like other MBeans. Through the Descriptors, values and methods in
  the managed application can be defined and mapped to attributes and operations of the ModelMBean.
  This mapping can be defined during development in a file or dynamically and
  programmatically at runtime.

  Every ModelMBean which is instantiated in the MBeanServer becomes manageable:
  its attributes, operations, and notifications
  become remotely accessible through the connectors/adaptors connected to that MBeanServer.
  A Java object cannot be registered in the MBeanServer unless it is a JMX compliant MBean.
  By instantiating a ModelMBean, resources are guaranteed that the MBean is valid.

  MBeanException and RuntimeOperationsException must be thrown on every public method.  This allows
   for wrapping exceptions from distributed communications (RMI, EJB, etc.)"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.modelmbean ModelMBeanInfo]))

(defn get-operations
  "Returns the list of operations  of the MBean.
   Each operation is described by an MBeanOperationInfo object.

  returns: An array of MBeanOperationInfo objects. - `javax.management.MBeanOperationInfo[]`"
  ([^ModelMBeanInfo this]
    (-> this (.getOperations))))

(defn get-m-bean-descriptor
  "Returns the ModelMBean's descriptor which contains MBean wide
   policies.  This descriptor contains metadata about the MBean and default
   policies for persistence and caching.


   The fields in the descriptor are defined, but not limited to, the
   following.  Note that when the Type in this table is Number, a String
   that is the decimal representation of a Long can also be used.


   NameTypeMeaning
   nameString
       MBean name.
   descriptorTypeString
       Must be `mbean`.
   displayNameString
       Name of MBean to be used in displays.
   persistPolicyString
       One of: OnUpdate|OnTimer|NoMoreOftenThan|OnUnregister|Always|Never.
           See the section `MBean Descriptor Fields` in the JMX specification
           document.
   persistLocationString
       The fully qualified directory name where the MBean should be
           persisted (if appropriate).
   persistFileString
       File name into which the MBean should be persisted.
   persistPeriodNumber
       Frequency of persist cycle in seconds, for OnTime and
           NoMoreOftenThan PersistPolicy
   currencyTimeLimitNumber
       How long cached value is valid: <0 never, =0 always,
           >0 seconds.
   logString
       t: log all notifications, f: log no notifications.
   logfileString
       Fully qualified filename to log events to.
   visibilityNumber
       1-4 where 1: always visible 4: rarely visible.
   exportString
       Name to be used to export/expose this MBean so that it is
           findable by other JMX Agents.
   presentationStringString
       XML formatted string to allow presentation of data to be
           associated with the MBean.



   The default descriptor is: name=className,descriptorType=`mbean`, displayName=className,
    persistPolicy=`never`,log=`F`,visibility=`1`
   If the descriptor does not contain all these fields, they will be added with these default values.

   Note: because of inconsistencies in previous versions of
   this specification, it is recommended not to use negative or zero
   values for currencyTimeLimit.  To indicate that a
   cached value is never valid, omit the
   currencyTimeLimit field.  To indicate that it is
   always valid, use a very large number for this field.

  returns: the MBean descriptor. - `javax.management.Descriptor`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  (^javax.management.Descriptor [^ModelMBeanInfo this]
    (-> this (.getMBeanDescriptor))))

(defn set-m-bean-descriptor
  "Sets the ModelMBean's descriptor.  This descriptor contains default, MBean wide
   metadata about the MBean and default policies for persistence and caching. This operation
   does a complete replacement of the descriptor, no merging is done. If the descriptor to
   set to is null then the default descriptor will be created.
   The default descriptor is: name=className,descriptorType=`mbean`, displayName=className,
    persistPolicy=`never`,log=`F`,visibility=`1`
   If the descriptor does not contain all these fields, they will be added with these default values.

   See getMBeanDescriptor method javadoc for description of valid field names.

  in-descriptor - the descriptor to set. - `javax.management.Descriptor`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([^ModelMBeanInfo this ^javax.management.Descriptor in-descriptor]
    (-> this (.setMBeanDescriptor in-descriptor))))

(defn get-class-name
  "Returns the name of the Java class of the MBean described by
   this MBeanInfo.

  returns: the Java class name. - `java.lang.String`"
  (^java.lang.String [^ModelMBeanInfo this]
    (-> this (.getClassName))))

(defn get-descriptor
  "Returns a Descriptor requested by name and descriptorType.

  in-descriptor-name - The name of the descriptor. - `java.lang.String`
  in-descriptor-type - The type of the descriptor being requested. If this is null or empty then all types are searched. Valid types are 'mbean', 'attribute', 'constructor' 'operation', and 'notification'. This value will be equal to the 'descriptorType' field in the descriptor that is returned. - `java.lang.String`

  returns: Descriptor containing the descriptor for the ModelMBean
   with the same name and descriptorType.  If no descriptor is
   found, null is returned. - `javax.management.Descriptor`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  (^javax.management.Descriptor [^ModelMBeanInfo this ^java.lang.String in-descriptor-name ^java.lang.String in-descriptor-type]
    (-> this (.getDescriptor in-descriptor-name in-descriptor-type))))

(defn set-descriptors
  "Adds or replaces descriptors in the ModelMBeanInfo.

  in-descriptors - The descriptors to be set in the ModelMBeanInfo. Null elements of the list will be ignored. All descriptors must have name and descriptorType fields. - `javax.management.Descriptor[]`

  throws: javax.management.RuntimeOperationsException - Wraps an IllegalArgumentException for a null or invalid descriptor."
  ([^ModelMBeanInfo this in-descriptors]
    (-> this (.setDescriptors in-descriptors))))

(defn get-descriptors
  "Returns a Descriptor array consisting of all
   Descriptors for the ModelMBeanInfo of type inDescriptorType.

  in-descriptor-type - value of descriptorType field that must be set for the descriptor to be returned. Must be `mbean`, `attribute`, `operation`, `constructor` or `notification`. If it is null or empty then all types will be returned. - `java.lang.String`

  returns: Descriptor array containing all descriptors for the ModelMBean if type inDescriptorType. - `javax.management.Descriptor[]`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([^ModelMBeanInfo this ^java.lang.String in-descriptor-type]
    (-> this (.getDescriptors in-descriptor-type))))

(defn get-notifications
  "Returns the list of the notifications emitted by the MBean.
   Each notification is described by an MBeanNotificationInfo object.

   In addition to any notification specified by the application,
   a ModelMBean may always send also two additional notifications:

    One with descriptor name `GENERIC` and displayName `jmx.modelmbean.generic`
    Second is a standard attribute change notification
        with descriptor name `ATTRIBUTE_CHANGE` and displayName `jmx.attribute.change`

   Thus any implementation of ModelMBeanInfo should always add those two notifications
   in addition to those specified by the application.

  returns: An array of MBeanNotificationInfo objects. - `javax.management.MBeanNotificationInfo[]`"
  ([^ModelMBeanInfo this]
    (-> this (.getNotifications))))

(defn get-attribute
  "Returns a ModelMBeanAttributeInfo requested by name.

  in-name - The name of the ModelMBeanAttributeInfo to get. If no ModelMBeanAttributeInfo exists for this name null is returned. - `java.lang.String`

  returns: the attribute info for the named attribute, or null
   if there is none. - `javax.management.modelmbean.ModelMBeanAttributeInfo`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  (^javax.management.modelmbean.ModelMBeanAttributeInfo [^ModelMBeanInfo this ^java.lang.String in-name]
    (-> this (.getAttribute in-name))))

(defn get-description
  "Returns a human readable description of the MBean.

  returns: the description. - `java.lang.String`"
  (^java.lang.String [^ModelMBeanInfo this]
    (-> this (.getDescription))))

(defn set-descriptor
  "Sets descriptors in the info array of type inDescriptorType
   for the ModelMBean.  The setDescriptor method of the
   corresponding ModelMBean*Info will be called to set the
   specified descriptor.

  in-descriptor - The descriptor to be set in the ModelMBean. It must NOT be null. All descriptors must have name and descriptorType fields. - `javax.management.Descriptor`
  in-descriptor-type - The type of the descriptor being set. If this is null then the descriptorType field in the descriptor is used. If specified this value must be set in the descriptorType field in the descriptor. Must be `mbean`,`attribute`, `constructor`, `operation`, or `notification`. - `java.lang.String`

  throws: javax.management.RuntimeOperationsException - Wraps an IllegalArgumentException for illegal or null arguments or if the name field of the descriptor is not found in the corresponding MBeanAttributeInfo or MBeanConstructorInfo or MBeanNotificationInfo or MBeanOperationInfo."
  ([^ModelMBeanInfo this ^javax.management.Descriptor in-descriptor ^java.lang.String in-descriptor-type]
    (-> this (.setDescriptor in-descriptor in-descriptor-type))))

(defn clone
  "Creates and returns a copy of this object.

  returns: `java.lang.Object`"
  (^java.lang.Object [^ModelMBeanInfo this]
    (-> this (.clone))))

(defn get-notification
  "Returns a ModelMBeanNotificationInfo requested by name.

  in-name - The name of the ModelMBeanNotificationInfo to get. If no ModelMBeanNotificationInfo exists for this name null is returned. - `java.lang.String`

  returns: the info for the named notification, or null if there
   is none. - `javax.management.modelmbean.ModelMBeanNotificationInfo`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  (^javax.management.modelmbean.ModelMBeanNotificationInfo [^ModelMBeanInfo this ^java.lang.String in-name]
    (-> this (.getNotification in-name))))

(defn get-operation
  "Returns a ModelMBeanOperationInfo requested by name.

  in-name - The name of the ModelMBeanOperationInfo to get. If no ModelMBeanOperationInfo exists for this name null is returned. - `java.lang.String`

  returns: the operation info for the named operation, or null
   if there is none. - `javax.management.modelmbean.ModelMBeanOperationInfo`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  (^javax.management.modelmbean.ModelMBeanOperationInfo [^ModelMBeanInfo this ^java.lang.String in-name]
    (-> this (.getOperation in-name))))

(defn get-constructors
  "Returns the list of the public constructors  of the MBean.
   Each constructor is described by an MBeanConstructorInfo object.

  returns: An array of MBeanConstructorInfo objects. - `javax.management.MBeanConstructorInfo[]`"
  ([^ModelMBeanInfo this]
    (-> this (.getConstructors))))

(defn get-attributes
  "Returns the list of attributes exposed for management.
   Each attribute is described by an MBeanAttributeInfo object.

  returns: An array of MBeanAttributeInfo objects. - `javax.management.MBeanAttributeInfo[]`"
  ([^ModelMBeanInfo this]
    (-> this (.getAttributes))))

