(ns javax.management.openmbean.OpenMBeanConstructorInfo
  "Describes a constructor of an Open MBean.

  This interface declares the same methods as the class MBeanConstructorInfo.  A class implementing this
  interface (typically OpenMBeanConstructorInfoSupport)
  should extend MBeanConstructorInfo.

  The getSignature() method should return at runtime an
  array of instances of a subclass of MBeanParameterInfo
  which implements the OpenMBeanParameterInfo interface
  (typically OpenMBeanParameterInfoSupport)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean OpenMBeanConstructorInfo]))

(defn get-description
  "Returns a human readable description of the constructor
   described by this OpenMBeanConstructorInfo instance.

  returns: the description. - `java.lang.String`"
  ([this]
    (-> this (.getDescription))))

(defn get-name
  "Returns the name of the constructor
   described by this OpenMBeanConstructorInfo instance.

  returns: the name. - `java.lang.String`"
  ([this]
    (-> this (.getName))))

(defn get-signature
  "Returns an array of OpenMBeanParameterInfo instances
   describing each parameter in the signature of the constructor
   described by this OpenMBeanConstructorInfo instance.

  returns: the signature. - `javax.management.MBeanParameterInfo[]`"
  ([this]
    (-> this (.getSignature))))

(defn equals
  "Compares the specified obj parameter with this OpenMBeanConstructorInfo instance for equality.

   Returns true if and only if all of the following statements are true:

   obj is non null,
   obj also implements the OpenMBeanConstructorInfo interface,
   their names are equal
   their signatures are equal.

   This ensures that this equals method works properly for obj parameters which are
   different implementations of the OpenMBeanConstructorInfo interface.

  obj - the object to be compared for equality with this OpenMBeanConstructorInfo instance; - `java.lang.Object`

  returns: true if the specified object is equal to this OpenMBeanConstructorInfo instance. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code value for this OpenMBeanConstructorInfo instance.

   The hash code of an OpenMBeanConstructorInfo instance is the sum of the hash codes
   of all elements of information used in equals comparisons
   (ie: its name and signature, where the signature hashCode is calculated by a call to
    java.util.Arrays.asList(this.getSignature).hashCode()).

   This ensures that  t1.equals(t2)  implies that  t1.hashCode()==t2.hashCode()
   for any two OpenMBeanConstructorInfo instances t1 and t2,
   as required by the general contract of the method
   Object.hashCode().

  returns: the hash code value for this OpenMBeanConstructorInfo instance - `int`"
  ([this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string representation of this OpenMBeanConstructorInfo instance.

   The string representation consists of the name of this class (ie javax.management.openmbean.OpenMBeanConstructorInfo),
   and the name and signature of the described constructor.

  returns: a string representation of this OpenMBeanConstructorInfo instance - `java.lang.String`"
  ([this]
    (-> this (.toString))))

