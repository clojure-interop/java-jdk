(ns javax.jws.soap.SOAPBinding$ParameterStyle
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.jws.soap SOAPBinding$ParameterStyle]))

(def BARE
  "Enum Constant.

  type: javax.jws.soap.SOAPBinding.ParameterStyle"
  SOAPBinding$ParameterStyle/BARE)

(def WRAPPED
  "Enum Constant.

  type: javax.jws.soap.SOAPBinding.ParameterStyle"
  SOAPBinding$ParameterStyle/WRAPPED)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (SOAPBinding.ParameterStyle c : SOAPBinding.ParameterStyle.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.jws.soap.SOAPBinding.ParameterStyle[]`"
  ([]
    (SOAPBinding$ParameterStyle/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.jws.soap.SOAPBinding.ParameterStyle`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^javax.jws.soap.SOAPBinding.ParameterStyle [^java.lang.String name]
    (SOAPBinding$ParameterStyle/valueOf name)))

