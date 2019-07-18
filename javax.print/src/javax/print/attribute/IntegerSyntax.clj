(ns javax.print.attribute.IntegerSyntax
  "Class IntegerSyntax is an abstract base class providing the common
  implementation of all attributes with integer values.

  Under the hood, an integer attribute is just an integer. You can get an
  integer attribute's integer value by calling getValue(). An integer attribute's integer value is
  established when it is constructed (see IntegerSyntax(int)). Once constructed, an integer attribute's
  value is immutable."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute IntegerSyntax]))

(defn get-value
  "Returns this integer attribute's integer value.

  returns: the integer value - `int`"
  (^Integer [^IntegerSyntax this]
    (-> this (.getValue))))

(defn equals
  "Returns whether this integer attribute is equivalent to the passed in
   object. To be equivalent, all of the following conditions must be true:


   object is not null.

   object is an instance of class IntegerSyntax.

   This integer attribute's value and object's value are
   equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this integer
            attribute, false otherwise. - `boolean`"
  (^Boolean [^IntegerSyntax this ^java.lang.Object object]
    (-> this (.equals object))))

(defn hash-code
  "Returns a hash code value for this integer attribute. The hash code is
   just this integer attribute's integer value.

  returns: a hash code value for this object. - `int`"
  (^Integer [^IntegerSyntax this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string value corresponding to this integer attribute. The
   string value is just this integer attribute's integer value converted to
   a string.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^IntegerSyntax this]
    (-> this (.toString))))

