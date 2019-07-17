(ns jdk.awt.JobAttributes$DestinationType
  "A type-safe enumeration of possible job destinations."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt JobAttributes$DestinationType]))

(def *-file
  "Static Constant.

  The DestinationType instance to use for
   specifying print to file.

  type: java.awt.JobAttributes.DestinationType"
  JobAttributes$DestinationType/FILE)

(def *-printer
  "Static Constant.

  The DestinationType instance to use for
   specifying print to printer.

  type: java.awt.JobAttributes.DestinationType"
  JobAttributes$DestinationType/PRINTER)

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

