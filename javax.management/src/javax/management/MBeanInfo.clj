(ns javax.management.MBeanInfo
  "Describes the management interface exposed by an MBean; that is,
  the set of attributes and operations which are available for
  management operations.  Instances of this class are immutable.
  Subclasses may be mutable but this is not recommended.

  Usually the MBeanInfo for any given MBean does
  not change over the lifetime of that MBean.  Dynamic MBeans can change their
  MBeanInfo and in that case it is recommended that they emit a Notification with a type of `jmx.mbean.info.changed` and a userData that is the new MBeanInfo.  This is not required, but
  provides a conventional way for clients of the MBean to discover the change.
  See also the immutableInfo and
  infoTimeout fields in the MBeanInfo Descriptor.

  The contents of the MBeanInfo for a Dynamic MBean
  are determined by its getMBeanInfo() method.  This includes Open MBeans and Model
  MBeans, which are kinds of Dynamic MBeans.

  The contents of the MBeanInfo for a Standard MBean
  are determined by the MBean server as follows:



  getClassName() returns the Java class name of the MBean
  object;

  getConstructors() returns the list of all public
  constructors in that object;

  getAttributes() returns the list of all attributes
  whose existence is deduced from the presence in the MBean interface
  of a getName, isName, or
  setName method that conforms to the conventions
  for Standard MBeans;

  getOperations() returns the list of all methods in
  the MBean interface that do not represent attributes;

  getNotifications() returns an empty array if the MBean
  does not implement the NotificationBroadcaster interface,
  otherwise the result of calling NotificationBroadcaster.getNotificationInfo() on it;

  getDescriptor() returns a descriptor containing the contents
  of any descriptor annotations in the MBean interface (see
  @DescriptorKey).



  The description returned by getDescription() and the
  descriptions of the contained attributes and operations are not specified.

  The remaining details of the MBeanInfo for a
  Standard MBean are not specified.  This includes the description of
  any contained constructors, and notifications; the names
  of parameters to constructors and operations; and the descriptions of
  constructor parameters."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management MBeanInfo]))

(defn ->m-bean-info
  "Constructor.

  Constructs an MBeanInfo.

  class-name - The name of the Java class of the MBean described by this MBeanInfo. This value may be any syntactically legal Java class name. It does not have to be a Java class known to the MBean server or to the MBean's ClassLoader. If it is a Java class known to the MBean's ClassLoader, it is recommended but not required that the class's public methods include those that would appear in a Standard MBean implementing the attributes and operations in this MBeanInfo. - `java.lang.String`
  description - A human readable description of the MBean (optional). - `java.lang.String`
  attributes - The list of exposed attributes of the MBean. This may be null with the same effect as a zero-length array. - `javax.management.MBeanAttributeInfo[]`
  constructors - The list of public constructors of the MBean. This may be null with the same effect as a zero-length array. - `javax.management.MBeanConstructorInfo[]`
  operations - The list of operations of the MBean. This may be null with the same effect as a zero-length array. - `javax.management.MBeanOperationInfo[]`
  notifications - The list of notifications emitted. This may be null with the same effect as a zero-length array. - `javax.management.MBeanNotificationInfo[]`
  descriptor - The descriptor for the MBean. This may be null which is equivalent to an empty descriptor. - `javax.management.Descriptor`

  throws: java.lang.IllegalArgumentException"
  (^MBeanInfo [^java.lang.String class-name ^java.lang.String description attributes constructors operations notifications ^javax.management.Descriptor descriptor]
    (new MBeanInfo class-name description attributes constructors operations notifications descriptor))
  (^MBeanInfo [^java.lang.String class-name ^java.lang.String description attributes constructors operations notifications]
    (new MBeanInfo class-name description attributes constructors operations notifications)))

(defn get-operations
  "Returns the list of operations  of the MBean.
   Each operation is described by an MBeanOperationInfo object.

   The returned array is a shallow copy of the internal array,
   which means that it is a copy of the internal array of
   references to the MBeanOperationInfo objects
   but that each referenced MBeanOperationInfo object is not copied.

  returns: An array of MBeanOperationInfo objects. - `javax.management.MBeanOperationInfo[]`"
  ([^MBeanInfo this]
    (-> this (.getOperations))))

(defn get-class-name
  "Returns the name of the Java class of the MBean described by
   this MBeanInfo.

  returns: the class name. - `java.lang.String`"
  (^java.lang.String [^MBeanInfo this]
    (-> this (.getClassName))))

(defn get-descriptor
  "Get the descriptor of this MBeanInfo.  Changing the returned value
   will have no affect on the original descriptor.

  returns: a descriptor that is either immutable or a copy of the original. - `javax.management.Descriptor`"
  (^javax.management.Descriptor [^MBeanInfo this]
    (-> this (.getDescriptor))))

(defn get-notifications
  "Returns the list of the notifications emitted by the MBean.
   Each notification is described by an MBeanNotificationInfo object.

   The returned array is a shallow copy of the internal array,
   which means that it is a copy of the internal array of
   references to the MBeanNotificationInfo objects
   but that each referenced MBeanNotificationInfo object is not copied.

  returns: An array of MBeanNotificationInfo objects. - `javax.management.MBeanNotificationInfo[]`"
  ([^MBeanInfo this]
    (-> this (.getNotifications))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^MBeanInfo this]
    (-> this (.toString))))

(defn get-description
  "Returns a human readable description of the MBean.

  returns: the description. - `java.lang.String`"
  (^java.lang.String [^MBeanInfo this]
    (-> this (.getDescription))))

(defn clone
  "Returns a shallow clone of this instance.
   The clone is obtained by simply calling super.clone(),
   thus calling the default native shallow cloning mechanism
   implemented by Object.clone().
   No deeper cloning of any internal field is made.

   Since this class is immutable, the clone method is chiefly of
   interest to subclasses.

  returns: a clone of this instance. - `java.lang.Object`"
  (^java.lang.Object [^MBeanInfo this]
    (-> this (.clone))))

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  (^Integer [^MBeanInfo this]
    (-> this (.hashCode))))

(defn equals
  "Compare this MBeanInfo to another.  Two MBeanInfo objects
   are equal if and only if they return equal values for getClassName(), for getDescription(), and for
   getDescriptor(), and the
   arrays returned by the two objects for getAttributes(), getOperations(), getConstructors(), and getNotifications() are
   pairwise equal.  Here `equal` means Object.equals(Object), not identity.

   If two MBeanInfo objects return the same values in one of
   their arrays but in a different order then they are not equal.

  o - the object to compare to. - `java.lang.Object`

  returns: true if and only if o is an MBeanInfo that is equal
   to this one according to the rules above. - `boolean`"
  (^Boolean [^MBeanInfo this ^java.lang.Object o]
    (-> this (.equals o))))

(defn get-constructors
  "Returns the list of the public constructors of the MBean.
   Each constructor is described by an
   MBeanConstructorInfo object.

   The returned array is a shallow copy of the internal array,
   which means that it is a copy of the internal array of
   references to the MBeanConstructorInfo objects but
   that each referenced MBeanConstructorInfo object
   is not copied.

   The returned list is not necessarily exhaustive.  That is,
   the MBean may have a public constructor that is not in the
   list.  In this case, the MBean server can construct another
   instance of this MBean's class using that constructor, even
   though it is not listed here.

  returns: An array of MBeanConstructorInfo objects. - `javax.management.MBeanConstructorInfo[]`"
  ([^MBeanInfo this]
    (-> this (.getConstructors))))

(defn get-attributes
  "Returns the list of attributes exposed for management.
   Each attribute is described by an MBeanAttributeInfo object.

   The returned array is a shallow copy of the internal array,
   which means that it is a copy of the internal array of
   references to the MBeanAttributeInfo objects
   but that each referenced MBeanAttributeInfo object is not copied.

  returns: An array of MBeanAttributeInfo objects. - `javax.management.MBeanAttributeInfo[]`"
  ([^MBeanInfo this]
    (-> this (.getAttributes))))

