(ns jdk.sql.ClientInfoStatus
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql ClientInfoStatus]))

(def REASON_UNKNOWN
  "Enum Constant.

  The client info property could not be set for some unknown reason

  type: java.sql.ClientInfoStatus"
  ClientInfoStatus/REASON_UNKNOWN)

(def REASON_UNKNOWN_PROPERTY
  "Enum Constant.

  The client info property name specified was not a recognized property
   name.

  type: java.sql.ClientInfoStatus"
  ClientInfoStatus/REASON_UNKNOWN_PROPERTY)

(def REASON_VALUE_INVALID
  "Enum Constant.

  The value specified for the client info property was not valid.

  type: java.sql.ClientInfoStatus"
  ClientInfoStatus/REASON_VALUE_INVALID)

(def REASON_VALUE_TRUNCATED
  "Enum Constant.

  The value specified for the client info property was too large.

  type: java.sql.ClientInfoStatus"
  ClientInfoStatus/REASON_VALUE_TRUNCATED)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (ClientInfoStatus c : ClientInfoStatus.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.sql.ClientInfoStatus[]`"
  ([]
    (ClientInfoStatus/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.sql.ClientInfoStatus`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([name]
    (ClientInfoStatus/valueOf name)))

