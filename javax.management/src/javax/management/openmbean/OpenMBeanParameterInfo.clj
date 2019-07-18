(ns javax.management.openmbean.OpenMBeanParameterInfo
  "Describes a parameter used in one or more operations or
  constructors of an open MBean.

  This interface declares the same methods as the class MBeanParameterInfo.  A class implementing this
  interface (typically OpenMBeanParameterInfoSupport) should
  extend MBeanParameterInfo."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean OpenMBeanParameterInfo]))

(defn get-legal-values
  "Returns the set of legal values for this parameter, if it has
   one, or null otherwise.

  returns: the set of legal values. - `java.util.Set<?>`"
  (^java.util.Set [^OpenMBeanParameterInfo this]
    (-> this (.getLegalValues))))

(defn has-legal-values?
  "Returns true if this parameter has a specified set of
   legal values, or false otherwise.

  returns: true if there is a set of legal values. - `boolean`"
  (^Boolean [^OpenMBeanParameterInfo this]
    (-> this (.hasLegalValues))))

(defn get-open-type
  "Returns the open type of the values of the parameter
   described by this OpenMBeanParameterInfo instance.

  returns: the open type. - `javax.management.openmbean.OpenType<?>`"
  (^javax.management.openmbean.OpenType [^OpenMBeanParameterInfo this]
    (-> this (.getOpenType))))

(defn get-min-value
  "Returns the minimal value for this parameter, if it has one, or
   null otherwise.

  returns: the minimum value. - `java.lang.Comparable<?>`"
  (^java.lang.Comparable [^OpenMBeanParameterInfo this]
    (-> this (.getMinValue))))

(defn to-string
  "Returns a string representation of this OpenMBeanParameterInfo instance.

   The string representation consists of the name of this class (ie javax.management.openmbean.OpenMBeanParameterInfo),
   the string representation of the name and open type of the described parameter,
   and the string representation of its default, min, max and legal values.

  returns: a string representation of this OpenMBeanParameterInfo instance - `java.lang.String`"
  (^java.lang.String [^OpenMBeanParameterInfo this]
    (-> this (.toString))))

(defn get-default-value
  "Returns the default value for this parameter, if it has one, or
   null otherwise.

  returns: the default value. - `java.lang.Object`"
  (^java.lang.Object [^OpenMBeanParameterInfo this]
    (-> this (.getDefaultValue))))

(defn get-max-value
  "Returns the maximal value for this parameter, if it has one, or
   null otherwise.

  returns: the maximum value. - `java.lang.Comparable<?>`"
  (^java.lang.Comparable [^OpenMBeanParameterInfo this]
    (-> this (.getMaxValue))))

(defn get-name
  "Returns the name of the parameter
   described by this OpenMBeanParameterInfo instance.

  returns: the name. - `java.lang.String`"
  (^java.lang.String [^OpenMBeanParameterInfo this]
    (-> this (.getName))))

(defn has-max-value?
  "Returns true if this parameter has a specified maximal
   value, or false otherwise.

  returns: true if there is a maximum value. - `boolean`"
  (^Boolean [^OpenMBeanParameterInfo this]
    (-> this (.hasMaxValue))))

(defn get-description
  "Returns a human readable description of the parameter
   described by this OpenMBeanParameterInfo instance.

  returns: the description. - `java.lang.String`"
  (^java.lang.String [^OpenMBeanParameterInfo this]
    (-> this (.getDescription))))

(defn value?
  "Tests whether obj is a valid value for the parameter
   described by this OpenMBeanParameterInfo instance.

  obj - the object to be tested. - `java.lang.Object`

  returns: true if obj is a valid value
   for the parameter described by this
   OpenMBeanParameterInfo instance,
   false otherwise. - `boolean`"
  (^Boolean [^OpenMBeanParameterInfo this ^java.lang.Object obj]
    (-> this (.isValue obj))))

(defn has-default-value?
  "Returns true if this parameter has a specified default
   value, or false otherwise.

  returns: true if there is a default value. - `boolean`"
  (^Boolean [^OpenMBeanParameterInfo this]
    (-> this (.hasDefaultValue))))

(defn hash-code
  "Returns the hash code value for this OpenMBeanParameterInfo instance.

   The hash code of an OpenMBeanParameterInfo instance is the sum of the hash codes
   of all elements of information used in equals comparisons
   (ie: its name, its open type, and its default, min, max and legal values).

   This ensures that  t1.equals(t2)  implies that  t1.hashCode()==t2.hashCode()
   for any two OpenMBeanParameterInfo instances t1 and t2,
   as required by the general contract of the method
   Object.hashCode().

  returns: the hash code value for this OpenMBeanParameterInfo instance - `int`"
  (^Integer [^OpenMBeanParameterInfo this]
    (-> this (.hashCode))))

(defn has-min-value?
  "Returns true if this parameter has a specified minimal
   value, or false otherwise.

  returns: true if there is a minimum value. - `boolean`"
  (^Boolean [^OpenMBeanParameterInfo this]
    (-> this (.hasMinValue))))

(defn equals
  "Compares the specified obj parameter with this OpenMBeanParameterInfo instance for equality.

   Returns true if and only if all of the following statements are true:

   obj is non null,
   obj also implements the OpenMBeanParameterInfo interface,
   their names are equal
   their open types are equal
   their default, min, max and legal values are equal.

   This ensures that this equals method works properly for obj parameters which are
   different implementations of the OpenMBeanParameterInfo interface.

  obj - the object to be compared for equality with this OpenMBeanParameterInfo instance; - `java.lang.Object`

  returns: true if the specified object is equal to this OpenMBeanParameterInfo instance. - `boolean`"
  (^Boolean [^OpenMBeanParameterInfo this ^java.lang.Object obj]
    (-> this (.equals obj))))

