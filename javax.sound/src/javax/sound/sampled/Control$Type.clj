(ns javax.sound.sampled.Control$Type
  "An instance of the Type class represents the type of
  the control.  Static instances are provided for the
  common types."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled Control$Type]))

(defn equals
  "Finalizes the equals method

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  (^Boolean [^javax.sound.sampled.Control$Type this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Finalizes the hashCode method

  returns: a hash code value for this object. - `int`"
  (^Integer [^javax.sound.sampled.Control$Type this]
    (-> this (.hashCode))))

(defn to-string
  "Provides the String representation of the control type.  This String is
   the same name that was passed to the constructor.

  returns: the control type name - `java.lang.String`"
  (^java.lang.String [^javax.sound.sampled.Control$Type this]
    (-> this (.toString))))

