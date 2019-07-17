(ns javax.management.openmbean.OpenType
  "The OpenType class is the parent abstract class of all classes which describe the actual open type
  of open data values.

  An open type is defined by:

   the fully qualified Java class name of the open data values this type describes;
       note that only a limited set of Java classes is allowed for open data values
       (see ALLOWED_CLASSNAMES_LIST),
   its name,
   its description."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean OpenType]))

(def *-allowed-classnames-list
  "Static Constant.

  List of the fully qualified names of the Java classes allowed for open
   data values. A multidimensional array of any one of these classes or
   their corresponding primitive types is also an allowed class for open
   data values.



  ALLOWED_CLASSNAMES_LIST = {
          `java.lang.Void`,
          `java.lang.Boolean`,
          `java.lang.Character`,
          `java.lang.Byte`,
          `java.lang.Short`,
          `java.lang.Integer`,
          `java.lang.Long`,
          `java.lang.Float`,
          `java.lang.Double`,
          `java.lang.String`,
          `java.math.BigDecimal`,
          `java.math.BigInteger`,
          `java.util.Date`,
          `javax.management.ObjectName`,
          CompositeData.class.getName(),
          TabularData.class.getName() } ;

  type: java.util.List<java.lang.String>"
  OpenType/ALLOWED_CLASSNAMES_LIST)

(def *-allowed-classnames
  "Static Constant.

  Deprecated. Use ALLOWED_CLASSNAMES_LIST instead.

  type: java.lang.    java.lang.String[]"
  OpenType/ALLOWED_CLASSNAMES)

(defn get-class-name
  "Returns the fully qualified Java class name of the open data values
   this open type describes.
   The only possible Java class names for open data values are listed in
   ALLOWED_CLASSNAMES_LIST.
   A multidimensional array of any one of these classes or their
   corresponding primitive types is also an allowed class,
   in which case the class name follows the rules defined by the method
   getName() of java.lang.Class.
   For example, a 3-dimensional array of Strings has for class name
   `[[[Ljava.lang.String;` (without the quotes),
   a 3-dimensional array of Integers has for class name
   `[[[Ljava.lang.Integer;` (without the quotes),
   and a 3-dimensional array of int has for class name
   `[[[I` (without the quotes)

  returns: the class name. - `java.lang.String`"
  (^java.lang.String [^javax.management.openmbean.OpenType this]
    (-> this (.getClassName))))

(defn get-type-name
  "Returns the name of this OpenType instance.

  returns: the type name. - `java.lang.String`"
  (^java.lang.String [^javax.management.openmbean.OpenType this]
    (-> this (.getTypeName))))

(defn get-description
  "Returns the text description of this OpenType instance.

  returns: the description. - `java.lang.String`"
  (^java.lang.String [^javax.management.openmbean.OpenType this]
    (-> this (.getDescription))))

(defn array?
  "Returns true if the open data values this open
   type describes are arrays, false otherwise.

  returns: true if this is an array type. - `boolean`"
  (^Boolean [^javax.management.openmbean.OpenType this]
    (-> this (.isArray))))

(defn value?
  "Tests whether obj is a value for this open type.

  obj - the object to be tested for validity. - `java.lang.Object`

  returns: true if obj is a value for this
   open type, false otherwise. - `boolean`"
  (^Boolean [^javax.management.openmbean.OpenType this ^java.lang.Object obj]
    (-> this (.isValue obj))))

(defn equals
  "Compares the specified obj parameter with this
   open type instance for equality.

  obj - the object to compare to. - `java.lang.Object`

  returns: true if this object and obj are equal. - `boolean`"
  (^Boolean [^javax.management.openmbean.OpenType this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  (^Integer [^javax.management.openmbean.OpenType this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string representation of this open type instance.

  returns: the string representation. - `java.lang.String`"
  (^java.lang.String [^javax.management.openmbean.OpenType this]
    (-> this (.toString))))

