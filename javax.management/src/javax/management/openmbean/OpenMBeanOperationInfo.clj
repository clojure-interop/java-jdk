(ns javax.management.openmbean.OpenMBeanOperationInfo
  "Describes an operation of an Open MBean.

  This interface declares the same methods as the class MBeanOperationInfo.  A class implementing this
  interface (typically OpenMBeanOperationInfoSupport) should
  extend MBeanOperationInfo.

  The getSignature() method should return at runtime an
  array of instances of a subclass of MBeanParameterInfo
  which implements the OpenMBeanParameterInfo interface
  (typically OpenMBeanParameterInfoSupport)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean OpenMBeanOperationInfo]))

(defn get-signature
  "Returns an array of OpenMBeanParameterInfo instances
   describing each parameter in the signature of the operation
   described by this OpenMBeanOperationInfo instance.
   Each instance in the returned array should actually be a
   subclass of MBeanParameterInfo which implements the
   OpenMBeanParameterInfo interface (typically OpenMBeanParameterInfoSupport).

  returns: the signature. - `javax.management.MBeanParameterInfo[]`"
  ([^javax.management.openmbean.OpenMBeanOperationInfo this]
    (-> this (.getSignature))))

(defn get-impact
  "Returns an int constant qualifying the impact of the
   operation described by this OpenMBeanOperationInfo
   instance.

   The returned constant is one of MBeanOperationInfo.INFO, MBeanOperationInfo.ACTION, MBeanOperationInfo.ACTION_INFO, or MBeanOperationInfo.UNKNOWN.

  returns: the impact code. - `int`"
  ([^javax.management.openmbean.OpenMBeanOperationInfo this]
    (-> this (.getImpact))))

(defn to-string
  "Returns a string representation of this OpenMBeanOperationInfo instance.

   The string representation consists of the name of this class (ie javax.management.openmbean.OpenMBeanOperationInfo),
   and the name, signature, return open type and impact of the described operation.

  returns: a string representation of this OpenMBeanOperationInfo instance - `java.lang.String`"
  ([^javax.management.openmbean.OpenMBeanOperationInfo this]
    (-> this (.toString))))

(defn get-name
  "Returns the name of the operation
   described by this OpenMBeanOperationInfo instance.

  returns: the name. - `java.lang.String`"
  ([^javax.management.openmbean.OpenMBeanOperationInfo this]
    (-> this (.getName))))

(defn get-description
  "Returns a human readable description of the operation
   described by this OpenMBeanOperationInfo instance.

  returns: the description. - `java.lang.String`"
  ([^javax.management.openmbean.OpenMBeanOperationInfo this]
    (-> this (.getDescription))))

(defn get-return-type
  "Returns the fully qualified Java class name of the values
   returned by the operation described by this
   OpenMBeanOperationInfo instance.  This method should
   return the same value as a call to
   getReturnOpenType().getClassName().

  returns: the return type. - `java.lang.String`"
  ([^javax.management.openmbean.OpenMBeanOperationInfo this]
    (-> this (.getReturnType))))

(defn hash-code
  "Returns the hash code value for this OpenMBeanOperationInfo instance.

   The hash code of an OpenMBeanOperationInfo instance is the sum of the hash codes
   of all elements of information used in equals comparisons
   (ie: its name, return open type, impact and signature, where the signature hashCode is calculated by a call to
    java.util.Arrays.asList(this.getSignature).hashCode()).

   This ensures that  t1.equals(t2)  implies that  t1.hashCode()==t2.hashCode()
   for any two OpenMBeanOperationInfo instances t1 and t2,
   as required by the general contract of the method
   Object.hashCode().

  returns: the hash code value for this OpenMBeanOperationInfo instance - `int`"
  ([^javax.management.openmbean.OpenMBeanOperationInfo this]
    (-> this (.hashCode))))

(defn get-return-open-type
  "Returns the open type of the values returned by the
   operation described by this OpenMBeanOperationInfo
   instance.

  returns: the return type. - `javax.management.openmbean.OpenType<?>`"
  ([^javax.management.openmbean.OpenMBeanOperationInfo this]
    (-> this (.getReturnOpenType))))

(defn equals
  "Compares the specified obj parameter with this OpenMBeanOperationInfo instance for equality.

   Returns true if and only if all of the following statements are true:

   obj is non null,
   obj also implements the OpenMBeanOperationInfo interface,
   their names are equal
   their signatures are equal
   their return open types are equal
   their impacts are equal

   This ensures that this equals method works properly for obj parameters which are
   different implementations of the OpenMBeanOperationInfo interface.

  obj - the object to be compared for equality with this OpenMBeanOperationInfo instance; - `java.lang.Object`

  returns: true if the specified object is equal to this OpenMBeanOperationInfo instance. - `boolean`"
  ([^javax.management.openmbean.OpenMBeanOperationInfo this ^java.lang.Object obj]
    (-> this (.equals obj))))

