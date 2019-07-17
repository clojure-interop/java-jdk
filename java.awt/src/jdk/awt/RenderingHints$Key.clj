(ns jdk.awt.RenderingHints$Key
  "Defines the base type of all keys used along with the
  RenderingHints class to control various
  algorithm choices in the rendering and imaging pipelines.
  Instances of this class are immutable and unique which
  means that tests for matches can be made using the
  == operator instead of the more expensive
  equals() method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt RenderingHints$Key]))

(defn compatible-value?
  "Returns true if the specified object is a valid value
   for this Key.

  val - the Object to test for validity - `java.lang.Object`

  returns: true if val is valid;
           false otherwise. - `boolean`"
  ([^java.awt.RenderingHints$Key this ^java.lang.Object val]
    (-> this (.isCompatibleValue val))))

(defn hash-code
  "The hash code for all Key objects will be the same as the
   system identity code of the object as defined by the
   System.identityHashCode() method.

  returns: a hash code value for this object. - `int`"
  ([^java.awt.RenderingHints$Key this]
    (-> this (.hashCode))))

(defn equals
  "The equals method for all Key objects will return the same
   result as the equality operator '=='.

  o - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  ([^java.awt.RenderingHints$Key this ^java.lang.Object o]
    (-> this (.equals o))))

