(ns jdk.awt.PageAttributes$OriginType
  "A type-safe enumeration of possible origins."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt PageAttributes$OriginType]))

(def *-physical
  "Static Constant.

  The OriginType instance to use for specifying a physical origin.

  type: java.awt.PageAttributes$OriginType"
  PageAttributes$OriginType/PHYSICAL)

(def *-printable
  "Static Constant.

  The OriginType instance to use for specifying a printable origin.

  type: java.awt.PageAttributes$OriginType"
  PageAttributes$OriginType/PRINTABLE)

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  (^Integer [^PageAttributes$OriginType this]
    (-> this (.hashCode))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^PageAttributes$OriginType this]
    (-> this (.toString))))

