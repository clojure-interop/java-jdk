(ns jdk.awt.JobAttributes$SidesType
  "A type-safe enumeration of possible multi-page impositions. These
  impositions are in compliance with IPP 1.1."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt JobAttributes$SidesType]))

(def *-one-sided
  "Static Constant.

  The SidesType instance to use for specifying that
   consecutive job pages should be printed upon the same side of
   consecutive media sheets.

  type: java.awt.JobAttributes$SidesType"
  JobAttributes$SidesType/ONE_SIDED)

(def *-two-sided-long-edge
  "Static Constant.

  The SidesType instance to use for specifying that
   consecutive job pages should be printed upon front and back sides
   of consecutive media sheets, such that the orientation of each pair
   of pages on the medium would be correct for the reader as if for
   binding on the long edge.

  type: java.awt.JobAttributes$SidesType"
  JobAttributes$SidesType/TWO_SIDED_LONG_EDGE)

(def *-two-sided-short-edge
  "Static Constant.

  The SidesType instance to use for specifying that
   consecutive job pages should be printed upon front and back sides
   of consecutive media sheets, such that the orientation of each pair
   of pages on the medium would be correct for the reader as if for
   binding on the short edge.

  type: java.awt.JobAttributes$SidesType"
  JobAttributes$SidesType/TWO_SIDED_SHORT_EDGE)

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  (^Integer [^JobAttributes$SidesType this]
    (-> this (.hashCode))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^JobAttributes$SidesType this]
    (-> this (.toString))))

