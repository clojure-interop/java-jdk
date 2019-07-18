(ns javax.management.MBeanOperationInfo
  "Describes a management operation exposed by an MBean.  Instances of
  this class are immutable.  Subclasses may be mutable but this is
  not recommended."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management MBeanOperationInfo]))

(defn ->m-bean-operation-info
  "Constructor.

  Constructs an MBeanOperationInfo object.

  name - The name of the method. - `java.lang.String`
  description - A human readable description of the operation. - `java.lang.String`
  signature - MBeanParameterInfo objects describing the parameters(arguments) of the method. This may be null with the same effect as a zero-length array. - `javax.management.MBeanParameterInfo[]`
  type - The type of the method's return value. - `java.lang.String`
  impact - The impact of the method, one of INFO, ACTION, ACTION_INFO, UNKNOWN. - `int`
  descriptor - The descriptor for the operation. This may be null which is equivalent to an empty descriptor. - `javax.management.Descriptor`"
  (^MBeanOperationInfo [^java.lang.String name ^java.lang.String description signature ^java.lang.String type ^Integer impact ^javax.management.Descriptor descriptor]
    (new MBeanOperationInfo name description signature type impact descriptor))
  (^MBeanOperationInfo [^java.lang.String name ^java.lang.String description signature ^java.lang.String type ^Integer impact]
    (new MBeanOperationInfo name description signature type impact))
  (^MBeanOperationInfo [^java.lang.String description ^java.lang.reflect.Method method]
    (new MBeanOperationInfo description method)))

(def *-info
  "Static Constant.

  Indicates that the operation is read-like:
   it returns information but does not change any state.

  type: int"
  MBeanOperationInfo/INFO)

(def *-action
  "Static Constant.

  Indicates that the operation is write-like: it has an effect but does
   not return any information from the MBean.

  type: int"
  MBeanOperationInfo/ACTION)

(def *-action-info
  "Static Constant.

  Indicates that the operation is both read-like and write-like:
   it has an effect, and it also returns information from the MBean.

  type: int"
  MBeanOperationInfo/ACTION_INFO)

(def *-unknown
  "Static Constant.

  Indicates that the impact of the operation is unknown or cannot be
   expressed using one of the other values.

  type: int"
  MBeanOperationInfo/UNKNOWN)

(defn clone
  "Returns a shallow clone of this instance.
   The clone is obtained by simply calling super.clone(),
   thus calling the default native shallow cloning mechanism
   implemented by Object.clone().
   No deeper cloning of any internal field is made.

   Since this class is immutable, cloning is chiefly of interest
   to subclasses.

  returns: a clone of this instance. - `java.lang.Object`"
  (^java.lang.Object [^MBeanOperationInfo this]
    (-> this (.clone))))

(defn get-return-type
  "Returns the type of the method's return value.

  returns: the return type. - `java.lang.String`"
  (^java.lang.String [^MBeanOperationInfo this]
    (-> this (.getReturnType))))

(defn get-signature
  "Returns the list of parameters for this operation.  Each
   parameter is described by an MBeanParameterInfo
   object.

   The returned array is a shallow copy of the internal array,
   which means that it is a copy of the internal array of
   references to the MBeanParameterInfo objects but
   that each referenced MBeanParameterInfo object is
   not copied.

  returns: An array of MBeanParameterInfo objects. - `javax.management.MBeanParameterInfo[]`"
  ([^MBeanOperationInfo this]
    (-> this (.getSignature))))

(defn get-impact
  "Returns the impact of the method, one of
   INFO, ACTION, ACTION_INFO, UNKNOWN.

  returns: the impact code. - `int`"
  (^Integer [^MBeanOperationInfo this]
    (-> this (.getImpact))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^MBeanOperationInfo this]
    (-> this (.toString))))

(defn equals
  "Compare this MBeanOperationInfo to another.

  o - the object to compare to. - `java.lang.Object`

  returns: true if and only if o is an MBeanOperationInfo such
   that its MBeanFeatureInfo.getName(), getReturnType(), MBeanFeatureInfo.getDescription(), getImpact(), MBeanFeatureInfo.getDescriptor()
   and getSignature() values are equal (not necessarily identical)
   to those of this MBeanConstructorInfo.  Two signature arrays
   are equal if their elements are pairwise equal. - `boolean`"
  (^Boolean [^MBeanOperationInfo this ^java.lang.Object o]
    (-> this (.equals o))))

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  (^Integer [^MBeanOperationInfo this]
    (-> this (.hashCode))))

