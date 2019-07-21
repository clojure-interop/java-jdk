(ns javax.lang.model.element.Name
  "An immutable sequence of characters.  When created by the same
  implementation, objects implementing this interface must obey the
  general equals contract when compared
  with each other.  Therefore, Name objects from the same
  implementation are usable in collections while Names from
  different implementations may not work properly in collections.

  An empty Name has a length of zero.

  In the context of javax.annotation.processing.annotation
  processing, the guarantees for \"the same\" implementation must
  include contexts where the API mediated side effects of javax.annotation.processing.processors could be visible
  to each other, including successive annotation processing
  javax.annotation.processing.rounds."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.element Name]))

(defn equals
  "Returns true if the argument represents the same
   name as this, and false otherwise.

   Note that the identity of a Name is a function both
   of its content in terms of a sequence of characters as well as
   the implementation which created it.

  obj - the object to be compared with this element - `java.lang.Object`

  returns: true if the specified object represents the same
            name as this - `boolean`"
  (^Boolean [^Name this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Obeys the general contract of Object.hashCode.

  returns: a hash code value for this object. - `int`"
  (^Integer [^Name this]
    (-> this (.hashCode))))

(defn content-equals
  "Compares this name to the specified CharSequence. The result
   is true if and only if this name represents the same sequence
   of char values as the specified sequence.

  cs - The sequence to compare this name against - `java.lang.CharSequence`

  returns: true if this name represents the same sequence
   of char values as the specified sequence, false
   otherwise - `boolean`"
  (^Boolean [^Name this ^java.lang.CharSequence cs]
    (-> this (.contentEquals cs))))

