(ns javax.jws.soap.SOAPBinding$Style
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.jws.soap SOAPBinding$Style]))

(def DOCUMENT
  "Enum Constant.

  type: javax.jws.soap.SOAPBinding.Style"
  SOAPBinding$Style/DOCUMENT)

(def RPC
  "Enum Constant.

  type: javax.jws.soap.SOAPBinding.Style"
  SOAPBinding$Style/RPC)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (SOAPBinding.Style c : SOAPBinding.Style.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.jws.soap.SOAPBinding.Style[]`"
  ([]
    (SOAPBinding$Style/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.jws.soap.SOAPBinding.Style`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^javax.jws.soap.SOAPBinding.Style [^java.lang.String name]
    (SOAPBinding$Style/valueOf name)))

