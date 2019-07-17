(ns javax.management.openmbean.OpenMBeanInfo
  "Describes an Open MBean: an Open MBean is recognized as such if
  its getMBeanInfo() method returns an instance of a class which
  implements the OpenMBeanInfo interface, typically OpenMBeanInfoSupport.

  This interface declares the same methods as the class MBeanInfo.  A class implementing this interface
  (typically OpenMBeanInfoSupport) should extend MBeanInfo.

  The getAttributes(), getOperations() and
  getConstructors() methods of the implementing class should
  return at runtime an array of instances of a subclass of MBeanAttributeInfo, MBeanOperationInfo or MBeanConstructorInfo respectively which implement the OpenMBeanAttributeInfo, OpenMBeanOperationInfo or OpenMBeanConstructorInfo interface respectively."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean OpenMBeanInfo]))

(defn get-operations
  "Returns an array of OpenMBeanOperationInfo instances
   describing each operation in the open MBean described by this
   OpenMBeanInfo instance.  Each instance in the returned
   array should actually be a subclass of
   MBeanOperationInfo which implements the
   OpenMBeanOperationInfo interface (typically OpenMBeanOperationInfoSupport).

  returns: the operation array. - `javax.management.MBeanOperationInfo[]`"
  ([this]
    (-> this (.getOperations))))

(defn get-class-name
  "Returns the fully qualified Java class name of the open MBean
   instances this OpenMBeanInfo describes.

  returns: the class name. - `java.lang.String`"
  ([this]
    (-> this (.getClassName))))

(defn get-notifications
  "Returns an array of MBeanNotificationInfo instances
   describing each notification emitted by the open MBean
   described by this OpenMBeanInfo instance.

  returns: the notification array. - `javax.management.MBeanNotificationInfo[]`"
  ([this]
    (-> this (.getNotifications))))

(defn to-string
  "Returns a string representation of this OpenMBeanInfo instance.

   The string representation consists of the name of this class (ie javax.management.openmbean.OpenMBeanInfo),
   the MBean class name,
   and the string representation of infos on attributes, constructors, operations and notifications of the described MBean.

  returns: a string representation of this OpenMBeanInfo instance - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn get-description
  "Returns a human readable description of the type of open MBean
   instances this OpenMBeanInfo describes.

  returns: the description. - `java.lang.String`"
  ([this]
    (-> this (.getDescription))))

(defn hash-code
  "Returns the hash code value for this OpenMBeanInfo instance.

   The hash code of an OpenMBeanInfo instance is the sum of the hash codes
   of all elements of information used in equals comparisons
   (ie: its class name, and its infos on attributes, constructors, operations and notifications,
   where the hashCode of each of these arrays is calculated by a call to
    new java.util.HashSet(java.util.Arrays.asList(this.getSignature)).hashCode()).

   This ensures that  t1.equals(t2)  implies that  t1.hashCode()==t2.hashCode()
   for any two OpenMBeanInfo instances t1 and t2,
   as required by the general contract of the method
   Object.hashCode().

  returns: the hash code value for this OpenMBeanInfo instance - `int`"
  ([this]
    (-> this (.hashCode))))

(defn equals
  "Compares the specified obj parameter with this OpenMBeanInfo instance for equality.

   Returns true if and only if all of the following statements are true:

   obj is non null,
   obj also implements the OpenMBeanInfo interface,
   their class names are equal
   their infos on attributes, constructors, operations and notifications are equal

   This ensures that this equals method works properly for obj parameters which are
   different implementations of the OpenMBeanInfo interface.

  obj - the object to be compared for equality with this OpenMBeanInfo instance; - `java.lang.Object`

  returns: true if the specified object is equal to this OpenMBeanInfo instance. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn get-constructors
  "Returns an array of OpenMBeanConstructorInfo instances
   describing each constructor in the open MBean described by this
   OpenMBeanInfo instance.  Each instance in the returned
   array should actually be a subclass of
   MBeanConstructorInfo which implements the
   OpenMBeanConstructorInfo interface (typically OpenMBeanConstructorInfoSupport).

  returns: the constructor array. - `javax.management.MBeanConstructorInfo[]`"
  ([this]
    (-> this (.getConstructors))))

(defn get-attributes
  "Returns an array of OpenMBeanAttributeInfo instances
   describing each attribute in the open MBean described by this
   OpenMBeanInfo instance.  Each instance in the returned
   array should actually be a subclass of
   MBeanAttributeInfo which implements the
   OpenMBeanAttributeInfo interface (typically OpenMBeanAttributeInfoSupport).

  returns: the attribute array. - `javax.management.MBeanAttributeInfo[]`"
  ([this]
    (-> this (.getAttributes))))

