(ns jdk.security.interfaces.DSAParams
  "Interface to a DSA-specific set of key parameters, which defines a
  DSA key family. DSA (Digital Signature Algorithm) is defined
  in NIST's FIPS-186."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.interfaces DSAParams]))

(defn get-p
  "Returns the prime, p.

  returns: the prime, p. - `java.math.BigInteger`"
  (^java.math.BigInteger [^DSAParams this]
    (-> this (.getP))))

(defn get-q
  "Returns the subprime, q.

  returns: the subprime, q. - `java.math.BigInteger`"
  (^java.math.BigInteger [^DSAParams this]
    (-> this (.getQ))))

(defn get-g
  "Returns the base, g.

  returns: the base, g. - `java.math.BigInteger`"
  (^java.math.BigInteger [^DSAParams this]
    (-> this (.getG))))

