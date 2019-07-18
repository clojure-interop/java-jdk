(ns javax.management.MBeanConstructorInfo
  "Describes a constructor exposed by an MBean.  Instances of this
  class are immutable.  Subclasses may be mutable but this is not
  recommended."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management MBeanConstructorInfo]))

(defn ->m-bean-constructor-info
  "Constructor.

  Constructs an MBeanConstructorInfo object.

  name - The name of the constructor. - `java.lang.String`
  description - A human readable description of the constructor. - `java.lang.String`
  signature - MBeanParameterInfo objects describing the parameters(arguments) of the constructor. This may be null with the same effect as a zero-length array. - `javax.management.MBeanParameterInfo[]`
  descriptor - The descriptor for the constructor. This may be null which is equivalent to an empty descriptor. - `javax.management.Descriptor`"
  (^MBeanConstructorInfo [^java.lang.String name ^java.lang.String description signature ^javax.management.Descriptor descriptor]
    (new MBeanConstructorInfo name description signature descriptor))
  (^MBeanConstructorInfo [^java.lang.String name ^java.lang.String description signature]
    (new MBeanConstructorInfo name description signature))
  (^MBeanConstructorInfo [^java.lang.String description ^java.lang.reflect.Constructor constructor]
    (new MBeanConstructorInfo description constructor)))

(defn clone
  "Returns a shallow clone of this instance.  The clone is
   obtained by simply calling super.clone(), thus calling
   the default native shallow cloning mechanism implemented by
   Object.clone().  No deeper cloning of any internal
   field is made.

   Since this class is immutable, cloning is chiefly of
   interest to subclasses.

  returns: a clone of this instance. - `java.lang.Object`"
  (^java.lang.Object [^MBeanConstructorInfo this]
    (-> this (.clone))))

(defn get-signature
  "Returns the list of parameters for this constructor.  Each
   parameter is described by an MBeanParameterInfo
   object.

   The returned array is a shallow copy of the internal array,
   which means that it is a copy of the internal array of
   references to the MBeanParameterInfo objects but
   that each referenced MBeanParameterInfo object is
   not copied.

  returns: An array of MBeanParameterInfo objects. - `javax.management.MBeanParameterInfo[]`"
  ([^MBeanConstructorInfo this]
    (-> this (.getSignature))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^MBeanConstructorInfo this]
    (-> this (.toString))))

(defn equals
  "Compare this MBeanConstructorInfo to another.

  o - the object to compare to. - `java.lang.Object`

  returns: true if and only if o is an MBeanConstructorInfo such
   that its MBeanFeatureInfo.getName(), MBeanFeatureInfo.getDescription(),
   getSignature(), and MBeanFeatureInfo.getDescriptor()
   values are equal (not necessarily
   identical) to those of this MBeanConstructorInfo.  Two
   signature arrays are equal if their elements are pairwise
   equal. - `boolean`"
  (^Boolean [^MBeanConstructorInfo this ^java.lang.Object o]
    (-> this (.equals o))))

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  (^Integer [^MBeanConstructorInfo this]
    (-> this (.hashCode))))

