(ns javax.jws.WebParam$Mode
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.jws WebParam$Mode]))

(def IN
  "Enum Constant.

  type: javax.jws.WebParam.Mode"
  WebParam$Mode/IN)

(def OUT
  "Enum Constant.

  type: javax.jws.WebParam.Mode"
  WebParam$Mode/OUT)

(def INOUT
  "Enum Constant.

  type: javax.jws.WebParam.Mode"
  WebParam$Mode/INOUT)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (WebParam.Mode c : WebParam.Mode.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.jws.WebParam.Mode[]`"
  ([]
    (WebParam$Mode/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.jws.WebParam.Mode`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (WebParam$Mode/valueOf name)))

