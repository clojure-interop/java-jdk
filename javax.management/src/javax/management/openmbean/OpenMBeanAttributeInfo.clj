(ns javax.management.openmbean.OpenMBeanAttributeInfo
  "Describes an attribute of an open MBean.

  This interface declares the same methods as the class MBeanAttributeInfo.  A class implementing this
  interface (typically OpenMBeanAttributeInfoSupport) should
  extend MBeanAttributeInfo."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean OpenMBeanAttributeInfo]))

(defn readable?
  "Returns true if the attribute described by this OpenMBeanAttributeInfo instance is readable,
   false otherwise.

  returns: true if the attribute is readable. - `boolean`"
  (^Boolean [^OpenMBeanAttributeInfo this]
    (-> this (.isReadable))))

(defn writable?
  "Returns true if the attribute described by this OpenMBeanAttributeInfo instance is writable,
   false otherwise.

  returns: true if the attribute is writable. - `boolean`"
  (^Boolean [^OpenMBeanAttributeInfo this]
    (-> this (.isWritable))))

(defn is?
  "Returns true if the attribute described by this OpenMBeanAttributeInfo instance
   is accessed through a isXXX getter (applies only to boolean and Boolean values),
   false otherwise.

  returns: true if the attribute is accessed through isXXX. - `boolean`"
  (^Boolean [^OpenMBeanAttributeInfo this]
    (-> this (.isIs))))

(defn equals
  "Compares the specified obj parameter with this OpenMBeanAttributeInfo instance for equality.

   Returns true if and only if all of the following statements are true:

   obj is non null,
   obj also implements the OpenMBeanAttributeInfo interface,
   their names are equal
   their open types are equal
   their access properties (isReadable, isWritable and isIs) are equal
   their default, min, max and legal values are equal.

   This ensures that this equals method works properly for obj parameters which are
   different implementations of the OpenMBeanAttributeInfo interface.

  obj - the object to be compared for equality with this OpenMBeanAttributeInfo instance; - `java.lang.Object`

  returns: true if the specified object is equal to this OpenMBeanAttributeInfo instance. - `boolean`"
  (^Boolean [^OpenMBeanAttributeInfo this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code value for this OpenMBeanAttributeInfo instance.

   The hash code of an OpenMBeanAttributeInfo instance is the sum of the hash codes
   of all elements of information used in equals comparisons
   (ie: its name, its open type, and its default, min, max and legal values).

   This ensures that  t1.equals(t2)  implies that  t1.hashCode()==t2.hashCode()
   for any two OpenMBeanAttributeInfo instances t1 and t2,
   as required by the general contract of the method
   Object.hashCode().

  returns: the hash code value for this OpenMBeanAttributeInfo instance - `int`"
  (^Integer [^OpenMBeanAttributeInfo this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string representation of this OpenMBeanAttributeInfo instance.

   The string representation consists of the name of this class (ie javax.management.openmbean.OpenMBeanAttributeInfo),
   the string representation of the name and open type of the described attribute,
   and the string representation of its default, min, max and legal values.

  returns: a string representation of this OpenMBeanAttributeInfo instance - `java.lang.String`"
  (^java.lang.String [^OpenMBeanAttributeInfo this]
    (-> this (.toString))))

