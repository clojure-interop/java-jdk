(ns javax.jws.soap.SOAPBinding$Use
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.jws.soap SOAPBinding$Use]))

(def LITERAL
  "Enum Constant.

  type: javax.jws.soap.SOAPBinding.Use"
  SOAPBinding$Use/LITERAL)

(def ENCODED
  "Enum Constant.

  type: javax.jws.soap.SOAPBinding.Use"
  SOAPBinding$Use/ENCODED)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (SOAPBinding.Use c : SOAPBinding.Use.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.jws.soap.SOAPBinding.Use[]`"
  ([]
    (SOAPBinding$Use/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.jws.soap.SOAPBinding.Use`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (SOAPBinding$Use/valueOf name)))

