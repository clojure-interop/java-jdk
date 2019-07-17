(ns jdk.lang.Boolean
  "The Boolean class wraps a value of the primitive type
  boolean in an object. An object of type
  Boolean contains a single field whose type is
  boolean.

  In addition, this class provides many methods for
  converting a boolean to a String and a
  String to a boolean, as well as other
  constants and methods useful when dealing with a
  boolean."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Boolean]))

(defn ->boolean
  "Constructor.

  Allocates a Boolean object representing the
   value argument.

   Note: It is rarely appropriate to use this constructor.
   Unless a new instance is required, the static factory
   valueOf(boolean) is generally a better choice. It is
   likely to yield significantly better space and time performance.

  value - the value of the Boolean. - `boolean`"
  ([^Boolean value]
    (new Boolean value)))

(def *-true
  "Static Constant.

  The Boolean object corresponding to the primitive
   value true.

  type: java.lang.Boolean"
  Boolean/TRUE)

(def *-false
  "Static Constant.

  The Boolean object corresponding to the primitive
   value false.

  type: java.lang.Boolean"
  Boolean/FALSE)

(def *-type
  "Static Constant.

  The Class object representing the primitive type boolean.

  type: java.lang.Class<java.lang.Boolean>"
  Boolean/TYPE)

(defn *compare
  "Compares two boolean values.
   The value returned is identical to what would be returned by:


      Boolean.valueOf(x).compareTo(Boolean.valueOf(y))

  x - the first boolean to compare - `boolean`
  y - the second boolean to compare - `boolean`

  returns: the value 0 if x == y;
           a value less than 0 if !x && y; and
           a value greater than 0 if x && !y - `int`"
  (^Integer [^Boolean x ^Boolean y]
    (Boolean/compare x y)))

(defn *value-of
  "Returns a Boolean instance representing the specified
   boolean value.  If the specified boolean value
   is true, this method returns Boolean.TRUE;
   if it is false, this method returns Boolean.FALSE.
   If a new Boolean instance is not required, this method
   should generally be used in preference to the constructor
   Boolean(boolean), as this method is likely to yield
   significantly better space and time performance.

  b - a boolean value. - `boolean`

  returns: a Boolean instance representing b. - `java.lang.Boolean`"
  (^java.lang.Boolean [^Boolean b]
    (Boolean/valueOf b)))

(defn *to-string
  "Returns a String object representing the specified
   boolean.  If the specified boolean is true, then
   the string `true` will be returned, otherwise the
   string `false` will be returned.

  b - the boolean to be converted - `boolean`

  returns: the string representation of the specified boolean - `java.lang.String`"
  (^java.lang.String [^Boolean b]
    (Boolean/toString b)))

(defn *logical-and
  "Returns the result of applying the logical AND operator to the
   specified boolean operands.

  a - the first operand - `boolean`
  b - the second operand - `boolean`

  returns: the logical AND of a and b - `boolean`"
  (^Boolean [^Boolean a ^Boolean b]
    (Boolean/logicalAnd a b)))

(defn *parse-boolean
  "Parses the string argument as a boolean.  The boolean
   returned represents the value true if the string argument
   is not null and is equal, ignoring case, to the string
   `true`.
   Example: Boolean.parseBoolean(`True`) returns true.
   Example: Boolean.parseBoolean(`yes`) returns false.

  s - the String containing the boolean representation to be parsed - `java.lang.String`

  returns: the boolean represented by the string argument - `boolean`"
  (^Boolean [^java.lang.String s]
    (Boolean/parseBoolean s)))

(defn *logical-xor
  "Returns the result of applying the logical XOR operator to the
   specified boolean operands.

  a - the first operand - `boolean`
  b - the second operand - `boolean`

  returns: the logical XOR of a and b - `boolean`"
  (^Boolean [^Boolean a ^Boolean b]
    (Boolean/logicalXor a b)))

(defn *hash-code
  "Returns a hash code for a boolean value; compatible with
   Boolean.hashCode().

  value - the value to hash - `boolean`

  returns: a hash code value for a boolean value. - `int`"
  (^Integer [^Boolean value]
    (Boolean/hashCode value)))

(defn *get-boolean?
  "Returns true if and only if the system property
   named by the argument exists and is equal to the string
   `true`. (Beginning with version 1.0.2 of the
   JavaTM platform, the test of
   this string is case insensitive.) A system property is accessible
   through getProperty, a method defined by the
   System class.

   If there is no property with the specified name, or if the specified
   name is empty or null, then false is returned.

  name - the system property name. - `java.lang.String`

  returns: the boolean value of the system property. - `boolean`

  throws: java.lang.SecurityException - for the same reasons as System.getProperty"
  (^Boolean [^java.lang.String name]
    (Boolean/getBoolean name)))

(defn *logical-or
  "Returns the result of applying the logical OR operator to the
   specified boolean operands.

  a - the first operand - `boolean`
  b - the second operand - `boolean`

  returns: the logical OR of a and b - `boolean`"
  (^Boolean [^Boolean a ^Boolean b]
    (Boolean/logicalOr a b)))

(defn boolean-value
  "Returns the value of this Boolean object as a boolean
   primitive.

  returns: the primitive boolean value of this object. - `boolean`"
  (^Boolean [^java.lang.Boolean this]
    (-> this (.booleanValue))))

(defn to-string
  "Returns a String object representing this Boolean's
   value.  If this object represents the value true,
   a string equal to `true` is returned. Otherwise, a
   string equal to `false` is returned.

  returns: a string representation of this object. - `java.lang.String`"
  (^java.lang.String [^java.lang.Boolean this]
    (-> this (.toString))))

(defn hash-code
  "Returns a hash code for this Boolean object.

  returns: the integer 1231 if this object represents
   true; returns the integer 1237 if this
   object represents false. - `int`"
  (^Integer [^java.lang.Boolean this]
    (-> this (.hashCode))))

(defn equals
  "Returns true if and only if the argument is not
   null and is a Boolean object that
   represents the same boolean value as this object.

  obj - the object to compare with. - `java.lang.Object`

  returns: true if the Boolean objects represent the
            same value; false otherwise. - `boolean`"
  (^Boolean [^java.lang.Boolean this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn compare-to
  "Compares this Boolean instance with another.

  b - the Boolean instance to be compared - `java.lang.Boolean`

  returns: zero if this object represents the same boolean value as the
            argument; a positive value if this object represents true
            and the argument represents false; and a negative value if
            this object represents false and the argument represents true - `int`

  throws: java.lang.NullPointerException - if the argument is null"
  (^Integer [^java.lang.Boolean this ^java.lang.Boolean b]
    (-> this (.compareTo b))))

