(ns javax.management.MBeanParameterInfo
  "Describes an argument of an operation exposed by an MBean.
  Instances of this class are immutable.  Subclasses may be mutable
  but this is not recommended."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management MBeanParameterInfo]))

(defn ->m-bean-parameter-info
  "Constructor.

  Constructs an MBeanParameterInfo object.

  name - The name of the data - `java.lang.String`
  type - The type or class name of the data - `java.lang.String`
  description - A human readable description of the data. Optional. - `java.lang.String`
  descriptor - The descriptor for the operation. This may be null which is equivalent to an empty descriptor. - `javax.management.Descriptor`"
  ([^java.lang.String name ^java.lang.String type ^java.lang.String description ^javax.management.Descriptor descriptor]
    (new MBeanParameterInfo name type description descriptor))
  ([^java.lang.String name ^java.lang.String type ^java.lang.String description]
    (new MBeanParameterInfo name type description)))

(defn clone
  "Returns a shallow clone of this instance.
   The clone is obtained by simply calling super.clone(),
   thus calling the default native shallow cloning mechanism
   implemented by Object.clone().
   No deeper cloning of any internal field is made.

   Since this class is immutable, cloning is chiefly of
   interest to subclasses.

  returns: a clone of this instance. - `java.lang.Object`"
  ([^javax.management.MBeanParameterInfo this]
    (-> this (.clone))))

(defn get-type
  "Returns the type or class name of the data.

  returns: the type string. - `java.lang.String`"
  ([^javax.management.MBeanParameterInfo this]
    (-> this (.getType))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  ([^javax.management.MBeanParameterInfo this]
    (-> this (.toString))))

(defn equals
  "Compare this MBeanParameterInfo to another.

  o - the object to compare to. - `java.lang.Object`

  returns: true if and only if o is an MBeanParameterInfo such
   that its MBeanFeatureInfo.getName(), getType(),
   MBeanFeatureInfo.getDescriptor(), and MBeanFeatureInfo.getDescription() values are equal (not necessarily identical)
   to those of this MBeanParameterInfo. - `boolean`"
  ([^javax.management.MBeanParameterInfo this ^java.lang.Object o]
    (-> this (.equals o))))

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  ([^javax.management.MBeanParameterInfo this]
    (-> this (.hashCode))))

