(ns jdk.awt.PageAttributes$OrientationRequestedType
  "A type-safe enumeration of possible orientations. These orientations
  are in partial compliance with IPP 1.1."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt PageAttributes$OrientationRequestedType]))

(def *-portrait
  "Static Constant.

  The OrientationRequestedType instance to use for specifying a
   portrait orientation.

  type: java.awt.PageAttributes$OrientationRequestedType"
  PageAttributes$OrientationRequestedType/PORTRAIT)

(def *-landscape
  "Static Constant.

  The OrientationRequestedType instance to use for specifying a
   landscape orientation.

  type: java.awt.PageAttributes$OrientationRequestedType"
  PageAttributes$OrientationRequestedType/LANDSCAPE)

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  (^Integer [^PageAttributes$OrientationRequestedType this]
    (-> this (.hashCode))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^PageAttributes$OrientationRequestedType this]
    (-> this (.toString))))

