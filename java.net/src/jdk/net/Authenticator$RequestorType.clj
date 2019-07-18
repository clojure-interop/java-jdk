(ns jdk.net.Authenticator$RequestorType
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net Authenticator$RequestorType]))

(def PROXY
  "Enum Constant.

  Entity requesting authentication is a HTTP proxy server.

  type: java.net.Authenticator$RequestorType"
  Authenticator$RequestorType/PROXY)

(def SERVER
  "Enum Constant.

  Entity requesting authentication is a HTTP origin server.

  type: java.net.Authenticator$RequestorType"
  Authenticator$RequestorType/SERVER)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (Authenticator.RequestorType c : Authenticator.RequestorType.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.net.Authenticator$RequestorType[]`"
  ([]
    (Authenticator$RequestorType/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.net.Authenticator$RequestorType`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.net.Authenticator$RequestorType [^java.lang.String name]
    (Authenticator$RequestorType/valueOf name)))

