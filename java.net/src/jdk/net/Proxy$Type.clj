(ns jdk.net.Proxy$Type
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net Proxy$Type]))

(def DIRECT
  "Enum Constant.

  Represents a direct connection, or the absence of a proxy.

  type: java.net.Proxy.Type"
  Proxy$Type/DIRECT)

(def HTTP
  "Enum Constant.

  Represents proxy for high level protocols such as HTTP or FTP.

  type: java.net.Proxy.Type"
  Proxy$Type/HTTP)

(def SOCKS
  "Enum Constant.

  Represents a SOCKS (V4 or V5) proxy.

  type: java.net.Proxy.Type"
  Proxy$Type/SOCKS)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (Proxy.Type c : Proxy.Type.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.net.Proxy.Type[]`"
  ([]
    (Proxy$Type/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.net.Proxy.Type`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (Proxy$Type/valueOf name)))

