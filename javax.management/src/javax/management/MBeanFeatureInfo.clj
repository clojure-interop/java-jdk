(ns javax.management.MBeanFeatureInfo
  "Provides general information for an MBean descriptor object.
  The feature described can be an attribute, an operation, a
  parameter, or a notification.  Instances of this class are
  immutable.  Subclasses may be mutable but this is not
  recommended."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management MBeanFeatureInfo]))

(defn ->m-bean-feature-info
  "Constructor.

  Constructs an MBeanFeatureInfo object.

  name - The name of the feature. - `java.lang.String`
  description - A human readable description of the feature. - `java.lang.String`
  descriptor - The descriptor for the feature. This may be null which is equivalent to an empty descriptor. - `javax.management.Descriptor`"
  ([name description descriptor]
    (new MBeanFeatureInfo name description descriptor))
  ([name description]
    (new MBeanFeatureInfo name description)))

(defn get-name
  "Returns the name of the feature.

  returns: the name of the feature. - `java.lang.String`"
  ([this]
    (-> this (.getName))))

(defn get-description
  "Returns the human-readable description of the feature.

  returns: the human-readable description of the feature. - `java.lang.String`"
  ([this]
    (-> this (.getDescription))))

(defn get-descriptor
  "Returns the descriptor for the feature.  Changing the returned value
   will have no affect on the original descriptor.

  returns: a descriptor that is either immutable or a copy of the original. - `javax.management.Descriptor`"
  ([this]
    (-> this (.getDescriptor))))

(defn equals
  "Compare this MBeanFeatureInfo to another.

  o - the object to compare to. - `java.lang.Object`

  returns: true if and only if o is an MBeanFeatureInfo such
   that its getName(), getDescription(), and
   getDescriptor()
   values are equal (not necessarily identical) to those of this
   MBeanFeatureInfo. - `boolean`"
  ([this o]
    (-> this (.equals o))))

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

