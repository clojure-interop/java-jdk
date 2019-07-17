(ns jdk.awt.PageAttributes$PrintQualityType
  "A type-safe enumeration of possible print qualities. These print
  qualities are in compliance with IPP 1.1."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt PageAttributes$PrintQualityType]))

(def *-high
  "Static Constant.

  The PrintQualityType instance to use for specifying a high print
   quality.

  type: java.awt.PageAttributes.PrintQualityType"
  PageAttributes$PrintQualityType/HIGH)

(def *-normal
  "Static Constant.

  The PrintQualityType instance to use for specifying a normal print
   quality.

  type: java.awt.PageAttributes.PrintQualityType"
  PageAttributes$PrintQualityType/NORMAL)

(def *-draft
  "Static Constant.

  The PrintQualityType instance to use for specifying a draft print
   quality.

  type: java.awt.PageAttributes.PrintQualityType"
  PageAttributes$PrintQualityType/DRAFT)

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  ([^java.awt.PageAttributes$PrintQualityType this]
    (-> this (.hashCode))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  ([^java.awt.PageAttributes$PrintQualityType this]
    (-> this (.toString))))

