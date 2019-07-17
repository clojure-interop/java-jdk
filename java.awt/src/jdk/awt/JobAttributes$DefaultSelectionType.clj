(ns jdk.awt.JobAttributes$DefaultSelectionType
  "A type-safe enumeration of possible default selection states."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt JobAttributes$DefaultSelectionType]))

(def *-all
  "Static Constant.

  The DefaultSelectionType instance to use for
   specifying that all pages of the job should be printed.

  type: java.awt.JobAttributes.DefaultSelectionType"
  JobAttributes$DefaultSelectionType/ALL)

(def *-range
  "Static Constant.

  The DefaultSelectionType instance to use for
   specifying that a range of pages of the job should be printed.

  type: java.awt.JobAttributes.DefaultSelectionType"
  JobAttributes$DefaultSelectionType/RANGE)

(def *-selection
  "Static Constant.

  The DefaultSelectionType instance to use for
   specifying that the current selection should be printed.

  type: java.awt.JobAttributes.DefaultSelectionType"
  JobAttributes$DefaultSelectionType/SELECTION)

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  ([^java.awt.JobAttributes$DefaultSelectionType this]
    (-> this (.hashCode))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  ([^java.awt.JobAttributes$DefaultSelectionType this]
    (-> this (.toString))))

