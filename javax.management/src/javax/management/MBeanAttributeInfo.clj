(ns javax.management.MBeanAttributeInfo
  "Describes an MBean attribute exposed for management.  Instances of
  this class are immutable.  Subclasses may be mutable but this is
  not recommended."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management MBeanAttributeInfo]))

(defn ->m-bean-attribute-info
  "Constructor.

  Constructs an MBeanAttributeInfo object.

  name - The name of the attribute. - `java.lang.String`
  type - The type or class name of the attribute. - `java.lang.String`
  description - A human readable description of the attribute. - `java.lang.String`
  is-readable - True if the attribute has a getter method, false otherwise. - `boolean`
  is-writable - True if the attribute has a setter method, false otherwise. - `boolean`
  is-is - True if this attribute has an `is` getter, false otherwise. - `boolean`
  descriptor - The descriptor for the attribute. This may be null which is equivalent to an empty descriptor. - `javax.management.Descriptor`

  throws: java.lang.IllegalArgumentException - if isIs is true but isReadable is not, or if isIs is true and type is not boolean or java.lang.Boolean. (New code should always use boolean rather than java.lang.Boolean.)"
  ([name type description is-readable is-writable is-is descriptor]
    (new MBeanAttributeInfo name type description is-readable is-writable is-is descriptor))
  ([name type description is-readable is-writable is-is]
    (new MBeanAttributeInfo name type description is-readable is-writable is-is))
  ([name description getter setter]
    (new MBeanAttributeInfo name description getter setter)))

(defn clone
  "Returns a shallow clone of this instance.
   The clone is obtained by simply calling super.clone(),
   thus calling the default native shallow cloning mechanism
   implemented by Object.clone().
   No deeper cloning of any internal field is made.

   Since this class is immutable, cloning is chiefly of
   interest to subclasses.

  returns: a clone of this instance. - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

(defn get-type
  "Returns the class name of the attribute.

  returns: the class name. - `java.lang.String`"
  ([this]
    (-> this (.getType))))

(defn readable?
  "Whether the value of the attribute can be read.

  returns: True if the attribute can be read, false otherwise. - `boolean`"
  ([this]
    (-> this (.isReadable))))

(defn writable?
  "Whether new values can be written to the attribute.

  returns: True if the attribute can be written to, false otherwise. - `boolean`"
  ([this]
    (-> this (.isWritable))))

(defn is?
  "Indicates if this attribute has an `is` getter.

  returns: true if this attribute has an `is` getter. - `boolean`"
  ([this]
    (-> this (.isIs))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn equals
  "Compare this MBeanAttributeInfo to another.

  o - the object to compare to. - `java.lang.Object`

  returns: true if and only if o is an MBeanAttributeInfo such
   that its MBeanFeatureInfo.getName(), getType(), MBeanFeatureInfo.getDescription(), isReadable(), isWritable(), and isIs() values are equal (not
   necessarily identical) to those of this MBeanAttributeInfo. - `boolean`"
  ([this o]
    (-> this (.equals o))))

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

