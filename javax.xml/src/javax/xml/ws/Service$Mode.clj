(ns javax.xml.ws.Service$Mode
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws Service$Mode]))

(def MESSAGE
  "Enum Constant.

  type: javax.xml.ws.Service.Mode"
  Service$Mode/MESSAGE)

(def PAYLOAD
  "Enum Constant.

  type: javax.xml.ws.Service.Mode"
  Service$Mode/PAYLOAD)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (Service.Mode c : Service.Mode.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.xml.ws.Service.Mode[]`"
  ([]
    (Service$Mode/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.xml.ws.Service.Mode`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (Service$Mode/valueOf name)))

