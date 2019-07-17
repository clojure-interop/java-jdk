(ns javax.management.openmbean.OpenMBeanInfoSupport
  "The OpenMBeanInfoSupport class describes the management
  information of an open MBean: it is a subclass of MBeanInfo, and it implements the OpenMBeanInfo interface.  Note that an open MBean is
  recognized as such if its getMBeanInfo() method returns an
  instance of a class which implements the OpenMBeanInfo interface,
  typically OpenMBeanInfoSupport."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean OpenMBeanInfoSupport]))

(defn ->open-m-bean-info-support
  "Constructor.

  Constructs an OpenMBeanInfoSupport instance, which
   describes a class of open MBeans with the specified className, description, openAttributes, openConstructors , openOperations, notifications, and descriptor.

   The openAttributes, openConstructors, openOperations and notifications array parameters are
   internally copied, so that subsequent changes to the arrays
   referenced by these parameters have no effect on this
   instance.

  class-name - The fully qualified Java class name of the open MBean described by this OpenMBeanInfoSupport instance. - `java.lang.String`
  description - A human readable description of the open MBean described by this OpenMBeanInfoSupport instance. - `java.lang.String`
  open-attributes - The list of exposed attributes of the described open MBean; Must be an array of instances of a subclass of MBeanAttributeInfo, typically OpenMBeanAttributeInfoSupport. - `javax.management.openmbean.OpenMBeanAttributeInfo[]`
  open-constructors - The list of exposed public constructors of the described open MBean; Must be an array of instances of a subclass of MBeanConstructorInfo, typically OpenMBeanConstructorInfoSupport. - `javax.management.openmbean.OpenMBeanConstructorInfo[]`
  open-operations - The list of exposed operations of the described open MBean. Must be an array of instances of a subclass of MBeanOperationInfo, typically OpenMBeanOperationInfoSupport. - `javax.management.openmbean.OpenMBeanOperationInfo[]`
  notifications - The list of notifications emitted by the described open MBean. - `javax.management.MBeanNotificationInfo[]`
  descriptor - The descriptor for the MBean. This may be null which is equivalent to an empty descriptor. - `javax.management.Descriptor`

  throws: java.lang.ArrayStoreException - If openAttributes, openConstructors or openOperations is not an array of instances of a subclass of MBeanAttributeInfo, MBeanConstructorInfo or MBeanOperationInfo respectively."
  ([class-name description open-attributes open-constructors open-operations notifications descriptor]
    (new OpenMBeanInfoSupport class-name description open-attributes open-constructors open-operations notifications descriptor))
  ([class-name description open-attributes open-constructors open-operations notifications]
    (new OpenMBeanInfoSupport class-name description open-attributes open-constructors open-operations notifications)))

(defn equals
  "Compares the specified obj parameter with this
   OpenMBeanInfoSupport instance for equality.

   Returns true if and only if all of the following
   statements are true:


   obj is non null,
   obj also implements the OpenMBeanInfo
   interface,
   their class names are equal
   their infos on attributes, constructors, operations and
   notifications are equal


   This ensures that this equals method works properly for
   obj parameters which are different implementations of
   the OpenMBeanInfo interface.

  obj - the object to be compared for equality with this OpenMBeanInfoSupport instance; - `java.lang.Object`

  returns: true if the specified object is equal to this
   OpenMBeanInfoSupport instance. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code value for this OpenMBeanInfoSupport instance.

   The hash code of an OpenMBeanInfoSupport instance is
   the sum of the hash codes of all elements of information used
   in equals comparisons (ie: its class name, and its
   infos on attributes, constructors, operations and
   notifications, where the hashCode of each of these arrays is
   calculated by a call to new
   java.util.HashSet(java.util.Arrays.asList(this.getSignature)).hashCode()).

   This ensures that t1.equals(t2) implies that t1.hashCode()==t2.hashCode() for any two OpenMBeanInfoSupport instances t1 and t2, as
   required by the general contract of the method Object.hashCode().

   However, note that another instance of a class implementing
   the OpenMBeanInfo interface may be equal to this OpenMBeanInfoSupport instance as defined by equals(java.lang.Object), but may have a different hash code
   if it is calculated differently.

   As OpenMBeanInfoSupport instances are immutable, the
   hash code for this instance is calculated once, on the first
   call to hashCode, and then the same value is returned
   for subsequent calls.

  returns: the hash code value for this OpenMBeanInfoSupport instance - `int`"
  ([this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string representation of this OpenMBeanInfoSupport instance.

   The string representation consists of the name of this class
   (ie javax.management.openmbean.OpenMBeanInfoSupport),
   the MBean class name, the string representation of infos on
   attributes, constructors, operations and notifications of the
   described MBean and the string representation of the descriptor.

   As OpenMBeanInfoSupport instances are immutable, the
   string representation for this instance is calculated once, on
   the first call to toString, and then the same value is
   returned for subsequent calls.

  returns: a string representation of this OpenMBeanInfoSupport instance - `java.lang.String`"
  ([this]
    (-> this (.toString))))

