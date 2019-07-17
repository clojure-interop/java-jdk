(ns jdk.lang.Number
  "The abstract class Number is the superclass of platform
  classes representing numeric values that are convertible to the
  primitive types byte, double, float, int, long, and short.

  The specific semantics of the conversion from the numeric value of
  a particular Number implementation to a given primitive
  type is defined by the Number implementation in question.

  For platform classes, the conversion is often analogous to a
  narrowing primitive conversion or a widening primitive conversion
  as defining in The Java™ Language Specification
  for converting between primitive types.  Therefore, conversions may
  lose information about the overall magnitude of a numeric value, may
  lose precision, and may even return a result of a different sign
  than the input.

  See the documentation of a given Number implementation for
  conversion details."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Number]))

(defn ->number
  "Constructor."
  ([]
    (new Number )))

(defn int-value
  "Returns the value of the specified number as an int,
   which may involve rounding or truncation.

  returns: the numeric value represented by this object after conversion
            to type int. - `int`"
  ([this]
    (-> this (.intValue))))

(defn long-value
  "Returns the value of the specified number as a long,
   which may involve rounding or truncation.

  returns: the numeric value represented by this object after conversion
            to type long. - `long`"
  ([this]
    (-> this (.longValue))))

(defn float-value
  "Returns the value of the specified number as a float,
   which may involve rounding.

  returns: the numeric value represented by this object after conversion
            to type float. - `float`"
  ([this]
    (-> this (.floatValue))))

(defn double-value
  "Returns the value of the specified number as a double,
   which may involve rounding.

  returns: the numeric value represented by this object after conversion
            to type double. - `double`"
  ([this]
    (-> this (.doubleValue))))

(defn byte-value
  "Returns the value of the specified number as a byte,
   which may involve rounding or truncation.

   This implementation returns the result of intValue() cast
   to a byte.

  returns: the numeric value represented by this object after conversion
            to type byte. - `byte`"
  ([this]
    (-> this (.byteValue))))

(defn short-value
  "Returns the value of the specified number as a short,
   which may involve rounding or truncation.

   This implementation returns the result of intValue() cast
   to a short.

  returns: the numeric value represented by this object after conversion
            to type short. - `short`"
  ([this]
    (-> this (.shortValue))))

