(ns jdk.awt.PageAttributes$ColorType
  "A type-safe enumeration of possible color states."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt PageAttributes$ColorType]))

(def *-color
  "Static Constant.

  The ColorType instance to use for specifying color printing.

  type: java.awt.PageAttributes.ColorType"
  PageAttributes$ColorType/COLOR)

(def *-monochrome
  "Static Constant.

  The ColorType instance to use for specifying monochrome printing.

  type: java.awt.PageAttributes.ColorType"
  PageAttributes$ColorType/MONOCHROME)

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

