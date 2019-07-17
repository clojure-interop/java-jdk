(ns javax.management.modelmbean.ModelMBeanInfoSupport
  "This class represents the meta data for ModelMBeans.  Descriptors have been
  added on the meta data objects.

  Java resources wishing to be manageable instantiate the ModelMBean using the
  MBeanServer's createMBean method.  The resource then sets the ModelMBeanInfo
  and Descriptors for the ModelMBean instance. The attributes and operations
  exposed via the ModelMBeanInfo for the ModelMBean are accessible
  from MBeans, connectors/adaptors like other MBeans. Through the Descriptors,
  values and methods in the managed application can be defined and mapped to
  attributes and operations of the ModelMBean.
  This mapping can be defined during development in a file or dynamically and
  programmatically at runtime.

  Every ModelMBean which is instantiated in the MBeanServer becomes manageable:
  its attributes and operations
  become remotely accessible through the connectors/adaptors connected to that
  MBeanServer.
  A Java object cannot be registered in the MBeanServer unless it is a JMX
  compliant MBean.
  By instantiating a ModelMBean, resources are guaranteed that the MBean is
  valid.

  MBeanException and RuntimeOperationsException must be thrown on every public
  method.  This allows for wrapping exceptions from distributed
  communications (RMI, EJB, etc.)

  The serialVersionUID of this class is
  -1935722590756516193L."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.modelmbean ModelMBeanInfoSupport]))

(defn ->model-m-bean-info-support
  "Constructor.

  Creates a ModelMBeanInfoSupport with the provided information
   and the descriptor given in parameter.

  class-name - classname of the MBean - `java.lang.String`
  description - human readable description of the ModelMBean - `java.lang.String`
  attributes - array of ModelMBeanAttributeInfo objects which have descriptors - `javax.management.modelmbean.ModelMBeanAttributeInfo[]`
  constructors - array of ModelMBeanConstructorInfo objects which have descriptor - `javax.management.modelmbean.ModelMBeanConstructorInfo[]`
  operations - array of ModelMBeanOperationInfo objects which have descriptor - `javax.management.modelmbean.ModelMBeanOperationInfo[]`
  notifications - array of ModelMBeanNotificationInfo objects which have descriptor - `javax.management.modelmbean.ModelMBeanNotificationInfo[]`
  mbeandescriptor - descriptor to be used as the MBeanDescriptor containing MBean wide policy. If the descriptor is null, a default descriptor will be constructed. The default descriptor is: name=className, descriptorType=`mbean`, displayName=className, persistPolicy=`never`, log=`F`, visibility=`1`. If the descriptor does not contain all of these fields, the missing ones are added with these default values. - `javax.management.Descriptor`

  throws: javax.management.RuntimeOperationsException - Wraps an IllegalArgumentException for invalid descriptor passed in parameter. (see getMBeanDescriptor for the definition of a valid MBean descriptor.)"
  ([^java.lang.String class-name ^java.lang.String description ^javax.management.modelmbean.ModelMBeanAttributeInfo[] attributes ^javax.management.modelmbean.ModelMBeanConstructorInfo[] constructors ^javax.management.modelmbean.ModelMBeanOperationInfo[] operations ^javax.management.modelmbean.ModelMBeanNotificationInfo[] notifications ^javax.management.Descriptor mbeandescriptor]
    (new ModelMBeanInfoSupport class-name description attributes constructors operations notifications mbeandescriptor))
  ([^java.lang.String class-name ^java.lang.String description ^javax.management.modelmbean.ModelMBeanAttributeInfo[] attributes ^javax.management.modelmbean.ModelMBeanConstructorInfo[] constructors ^javax.management.modelmbean.ModelMBeanOperationInfo[] operations ^javax.management.modelmbean.ModelMBeanNotificationInfo[] notifications]
    (new ModelMBeanInfoSupport class-name description attributes constructors operations notifications))
  ([^javax.management.modelmbean.ModelMBeanInfo mbi]
    (new ModelMBeanInfoSupport mbi)))

(defn get-m-bean-descriptor
  "Description copied from interface: ModelMBeanInfo

  returns: the MBean descriptor. - `javax.management.Descriptor`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([^javax.management.modelmbean.ModelMBeanInfoSupport this]
    (-> this (.getMBeanDescriptor))))

(defn set-m-bean-descriptor
  "Description copied from interface: ModelMBeanInfo

  in-m-bean-descriptor - the descriptor to set. - `javax.management.Descriptor`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([^javax.management.modelmbean.ModelMBeanInfoSupport this ^javax.management.Descriptor in-m-bean-descriptor]
    (-> this (.setMBeanDescriptor in-m-bean-descriptor))))

(defn get-descriptor
  "Description copied from interface: ModelMBeanInfo

  in-descriptor-name - The name of the descriptor. - `java.lang.String`
  in-descriptor-type - The type of the descriptor being requested. If this is null or empty then all types are searched. Valid types are 'mbean', 'attribute', 'constructor' 'operation', and 'notification'. This value will be equal to the 'descriptorType' field in the descriptor that is returned. - `java.lang.String`

  returns: Descriptor containing the descriptor for the ModelMBean
   with the same name and descriptorType.  If no descriptor is
   found, null is returned. - `javax.management.Descriptor`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([^javax.management.modelmbean.ModelMBeanInfoSupport this ^java.lang.String in-descriptor-name ^java.lang.String in-descriptor-type]
    (-> this (.getDescriptor in-descriptor-name in-descriptor-type)))
  ([^javax.management.modelmbean.ModelMBeanInfoSupport this ^java.lang.String in-descriptor-name]
    (-> this (.getDescriptor in-descriptor-name)))
  ([^javax.management.modelmbean.ModelMBeanInfoSupport this]
    (-> this (.getDescriptor))))

(defn set-descriptors
  "Description copied from interface: ModelMBeanInfo

  in-descriptors - The descriptors to be set in the ModelMBeanInfo. Null elements of the list will be ignored. All descriptors must have name and descriptorType fields. - `javax.management.Descriptor[]`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([^javax.management.modelmbean.ModelMBeanInfoSupport this ^javax.management.Descriptor[] in-descriptors]
    (-> this (.setDescriptors in-descriptors))))

(defn get-descriptors
  "Description copied from interface: ModelMBeanInfo

  in-descriptor-type - value of descriptorType field that must be set for the descriptor to be returned. Must be `mbean`, `attribute`, `operation`, `constructor` or `notification`. If it is null or empty then all types will be returned. - `java.lang.String`

  returns: Descriptor array containing all descriptors for the ModelMBean if type inDescriptorType. - `javax.management.Descriptor[]`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([^javax.management.modelmbean.ModelMBeanInfoSupport this ^java.lang.String in-descriptor-type]
    (-> this (.getDescriptors in-descriptor-type))))

(defn get-attribute
  "Description copied from interface: ModelMBeanInfo

  in-name - The name of the ModelMBeanAttributeInfo to get. If no ModelMBeanAttributeInfo exists for this name null is returned. - `java.lang.String`

  returns: the attribute info for the named attribute, or null
   if there is none. - `javax.management.modelmbean.ModelMBeanAttributeInfo`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([^javax.management.modelmbean.ModelMBeanInfoSupport this ^java.lang.String in-name]
    (-> this (.getAttribute in-name))))

(defn get-constructor
  "Returns the ModelMBeanConstructorInfo requested by name.
   If no ModelMBeanConstructorInfo exists for this name null is returned.

  in-name - the name of the constructor. - `java.lang.String`

  returns: the constructor info for the named constructor, or null
   if there is none. - `javax.management.modelmbean.ModelMBeanConstructorInfo`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([^javax.management.modelmbean.ModelMBeanInfoSupport this ^java.lang.String in-name]
    (-> this (.getConstructor in-name))))

(defn set-descriptor
  "Description copied from interface: ModelMBeanInfo

  in-descriptor - The descriptor to be set in the ModelMBean. It must NOT be null. All descriptors must have name and descriptorType fields. - `javax.management.Descriptor`
  in-descriptor-type - The type of the descriptor being set. If this is null then the descriptorType field in the descriptor is used. If specified this value must be set in the descriptorType field in the descriptor. Must be `mbean`,`attribute`, `constructor`, `operation`, or `notification`. - `java.lang.String`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([^javax.management.modelmbean.ModelMBeanInfoSupport this ^javax.management.Descriptor in-descriptor ^java.lang.String in-descriptor-type]
    (-> this (.setDescriptor in-descriptor in-descriptor-type))))

(defn clone
  "Returns a shallow clone of this instance.  Neither the Descriptor nor
   the contained arrays (ModelMBeanAttributeInfo[] etc) are
   cloned.  This method is chiefly of interest to modify the Descriptor
   of the clone via setDescriptor without affecting
   the Descriptor of the original object.

  returns: a shallow clone of this instance. - `java.lang.Object`"
  ([^javax.management.modelmbean.ModelMBeanInfoSupport this]
    (-> this (.clone))))

(defn get-notification
  "Description copied from interface: ModelMBeanInfo

  in-name - The name of the ModelMBeanNotificationInfo to get. If no ModelMBeanNotificationInfo exists for this name null is returned. - `java.lang.String`

  returns: the info for the named notification, or null if there
   is none. - `javax.management.modelmbean.ModelMBeanNotificationInfo`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([^javax.management.modelmbean.ModelMBeanInfoSupport this ^java.lang.String in-name]
    (-> this (.getNotification in-name))))

(defn get-operation
  "Description copied from interface: ModelMBeanInfo

  in-name - The name of the ModelMBeanOperationInfo to get. If no ModelMBeanOperationInfo exists for this name null is returned. - `java.lang.String`

  returns: the operation info for the named operation, or null
   if there is none. - `javax.management.modelmbean.ModelMBeanOperationInfo`

  throws: javax.management.MBeanException - Wraps a distributed communication Exception."
  ([^javax.management.modelmbean.ModelMBeanInfoSupport this ^java.lang.String in-name]
    (-> this (.getOperation in-name))))

