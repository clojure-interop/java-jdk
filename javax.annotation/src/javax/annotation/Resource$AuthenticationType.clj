(ns javax.annotation.Resource$AuthenticationType
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.annotation Resource$AuthenticationType]))

(def CONTAINER
  "Enum Constant.

  type: javax.annotation.Resource$AuthenticationType"
  Resource$AuthenticationType/CONTAINER)

(def APPLICATION
  "Enum Constant.

  type: javax.annotation.Resource$AuthenticationType"
  Resource$AuthenticationType/APPLICATION)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (Resource.AuthenticationType c : Resource.AuthenticationType.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.annotation.Resource$AuthenticationType[]`"
  ([]
    (Resource$AuthenticationType/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.annotation.Resource$AuthenticationType`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^javax.annotation.Resource$AuthenticationType [^java.lang.String name]
    (Resource$AuthenticationType/valueOf name)))

