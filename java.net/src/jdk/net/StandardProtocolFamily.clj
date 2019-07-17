(ns jdk.net.StandardProtocolFamily
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net StandardProtocolFamily]))

(def INET
  "Enum Constant.

  Internet Protocol Version 4 (IPv4)

  type: java.net.StandardProtocolFamily"
  StandardProtocolFamily/INET)

(def INET6
  "Enum Constant.

  Internet Protocol Version 6 (IPv6)

  type: java.net.StandardProtocolFamily"
  StandardProtocolFamily/INET6)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (StandardProtocolFamily c : StandardProtocolFamily.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.net.StandardProtocolFamily[]`"
  ([]
    (StandardProtocolFamily/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.net.StandardProtocolFamily`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (StandardProtocolFamily/valueOf name)))

