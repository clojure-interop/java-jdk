(ns javax.management.openmbean.OpenMBeanParameterInfoSupport
  "Describes a parameter used in one or more operations or
  constructors of an open MBean."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean OpenMBeanParameterInfoSupport]))

(defn ->open-m-bean-parameter-info-support
  "Constructor.

  Constructs an OpenMBeanParameterInfoSupport instance,
   which describes the parameter used in one or more operations or
   constructors of a class of open MBeans, with the specified
   name, openType, description, defaultValue, minValue and maxValue.

   It is possible to specify minimal and maximal values only for
   an open type whose values are Comparable.

  name - cannot be a null or empty string. - `java.lang.String`
  description - cannot be a null or empty string. - `java.lang.String`
  open-type - cannot be null. - `javax.management.openmbean.OpenType`
  default-value - must be a valid value for the openType specified for this parameter; default value not supported for ArrayType and TabularType; can be null, in which case it means that no default value is set. - `T`
  min-value - must be valid for the openType specified for this parameter; can be null, in which case it means that no minimal value is set. - `java.lang.Comparable`
  max-value - must be valid for the openType specified for this parameter; can be null, in which case it means that no maximal value is set. - `java.lang.Comparable`

  throws: java.lang.IllegalArgumentException - if name or description are null or empty string, or openType is null."
  (^OpenMBeanParameterInfoSupport [^java.lang.String name ^java.lang.String description ^javax.management.openmbean.OpenType open-type default-value ^java.lang.Comparable min-value ^java.lang.Comparable max-value]
    (new OpenMBeanParameterInfoSupport name description open-type default-value min-value max-value))
  (^OpenMBeanParameterInfoSupport [^java.lang.String name ^java.lang.String description ^javax.management.openmbean.OpenType open-type default-value legal-values]
    (new OpenMBeanParameterInfoSupport name description open-type default-value legal-values))
  (^OpenMBeanParameterInfoSupport [^java.lang.String name ^java.lang.String description ^javax.management.openmbean.OpenType open-type ^javax.management.Descriptor descriptor]
    (new OpenMBeanParameterInfoSupport name description open-type descriptor))
  (^OpenMBeanParameterInfoSupport [^java.lang.String name ^java.lang.String description ^javax.management.openmbean.OpenType open-type]
    (new OpenMBeanParameterInfoSupport name description open-type)))

(defn get-legal-values
  "Returns an unmodifiable Set of legal values for the parameter
   described by this OpenMBeanParameterInfoSupport
   instance, if specified, or null otherwise.

  returns: the set of legal values. - `java.util.Set<?>`"
  (^java.util.Set [^OpenMBeanParameterInfoSupport this]
    (-> this (.getLegalValues))))

(defn has-legal-values?
  "Returns true if this OpenMBeanParameterInfoSupport instance specifies a non-null
   set of legal values for the described parameter, false
   otherwise.

  returns: true if there is a set of legal values. - `boolean`"
  (^Boolean [^OpenMBeanParameterInfoSupport this]
    (-> this (.hasLegalValues))))

(defn get-open-type
  "Returns the open type for the values of the parameter described
   by this OpenMBeanParameterInfoSupport instance.

  returns: the open type. - `javax.management.openmbean.OpenType<?>`"
  (^javax.management.openmbean.OpenType [^OpenMBeanParameterInfoSupport this]
    (-> this (.getOpenType))))

(defn get-min-value
  "Returns the minimal value for the parameter described by this
   OpenMBeanParameterInfoSupport instance, if specified,
   or null otherwise.

  returns: the minimum value. - `java.lang.Comparable<?>`"
  (^java.lang.Comparable [^OpenMBeanParameterInfoSupport this]
    (-> this (.getMinValue))))

(defn to-string
  "Returns a string representation of this
   OpenMBeanParameterInfoSupport instance.

   The string representation consists of the name of this class (i.e.
   javax.management.openmbean.OpenMBeanParameterInfoSupport),
   the string representation of the name and open type of the described
   parameter, the string representation of its default, min, max and legal
   values and the string representation of its descriptor.

   As OpenMBeanParameterInfoSupport instances are immutable,
   the string representation for this instance is calculated once,
   on the first call to toString, and then the same value
   is returned for subsequent calls.

  returns: a string representation of this
   OpenMBeanParameterInfoSupport instance. - `java.lang.String`"
  (^java.lang.String [^OpenMBeanParameterInfoSupport this]
    (-> this (.toString))))

(defn get-default-value
  "Returns the default value for the parameter described by this
   OpenMBeanParameterInfoSupport instance, if specified,
   or null otherwise.

  returns: the default value. - `java.lang.Object`"
  (^java.lang.Object [^OpenMBeanParameterInfoSupport this]
    (-> this (.getDefaultValue))))

(defn get-max-value
  "Returns the maximal value for the parameter described by this
   OpenMBeanParameterInfoSupport instance, if specified,
   or null otherwise.

  returns: the maximum value. - `java.lang.Comparable<?>`"
  (^java.lang.Comparable [^OpenMBeanParameterInfoSupport this]
    (-> this (.getMaxValue))))

(defn has-max-value?
  "Returns true if this OpenMBeanParameterInfoSupport instance specifies a non-null
   maximal value for the described parameter, false
   otherwise.

  returns: true if there is a maximum value. - `boolean`"
  (^Boolean [^OpenMBeanParameterInfoSupport this]
    (-> this (.hasMaxValue))))

(defn value?
  "Tests whether obj is a valid value for the parameter
   described by this OpenMBeanParameterInfo instance.

  obj - the object to be tested. - `java.lang.Object`

  returns: true if obj is a valid value
   for the parameter described by this
   OpenMBeanParameterInfo instance,
   false otherwise. - `boolean`"
  (^Boolean [^OpenMBeanParameterInfoSupport this ^java.lang.Object obj]
    (-> this (.isValue obj))))

(defn has-default-value?
  "Returns true if this OpenMBeanParameterInfoSupport instance specifies a non-null
   default value for the described parameter, false
   otherwise.

  returns: true if there is a default value. - `boolean`"
  (^Boolean [^OpenMBeanParameterInfoSupport this]
    (-> this (.hasDefaultValue))))

(defn hash-code
  "Returns the hash code value for this OpenMBeanParameterInfoSupport instance.

   The hash code of an OpenMBeanParameterInfoSupport
   instance is the sum of the hash codes of all elements of
   information used in equals comparisons (ie: its name,
   its open type, its default, min, max and legal
   values, and its Descriptor).

   This ensures that t1.equals(t2) implies that t1.hashCode()==t2.hashCode() for any two OpenMBeanParameterInfoSupport instances t1 and t2, as required by the general contract of the method Object.hashCode().

   However, note that another instance of a class implementing
   the OpenMBeanParameterInfo interface may be equal to
   this OpenMBeanParameterInfoSupport instance as defined
   by equals(java.lang.Object), but may have a different
   hash code if it is calculated differently.

   As OpenMBeanParameterInfoSupport instances are
   immutable, the hash code for this instance is calculated once,
   on the first call to hashCode, and then the same value
   is returned for subsequent calls.

  returns: the hash code value for this OpenMBeanParameterInfoSupport instance - `int`"
  (^Integer [^OpenMBeanParameterInfoSupport this]
    (-> this (.hashCode))))

(defn has-min-value?
  "Returns true if this OpenMBeanParameterInfoSupport instance specifies a non-null
   minimal value for the described parameter, false
   otherwise.

  returns: true if there is a minimum value. - `boolean`"
  (^Boolean [^OpenMBeanParameterInfoSupport this]
    (-> this (.hasMinValue))))

(defn equals
  "Compares the specified obj parameter with this OpenMBeanParameterInfoSupport instance for equality.

   Returns true if and only if all of the following
   statements are true:


   obj is non null,
   obj also implements the OpenMBeanParameterInfo
   interface,
   their names are equal
   their open types are equal
   their default, min, max and legal values are equal.

   This ensures that this equals method works properly for
   obj parameters which are different implementations of
   the OpenMBeanParameterInfo interface.

   If obj also implements DescriptorRead, then its
   getDescriptor() method must
   also return the same value as for this object.

  obj - the object to be compared for equality with this OpenMBeanParameterInfoSupport instance. - `java.lang.Object`

  returns: true if the specified object is equal to this
   OpenMBeanParameterInfoSupport instance. - `boolean`"
  (^Boolean [^OpenMBeanParameterInfoSupport this ^java.lang.Object obj]
    (-> this (.equals obj))))

