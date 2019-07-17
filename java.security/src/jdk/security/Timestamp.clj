(ns jdk.security.Timestamp
  "This class encapsulates information about a signed timestamp.
  It is immutable.
  It includes the timestamp's date and time as well as information about the
  Timestamping Authority (TSA) which generated and signed the timestamp."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security Timestamp]))

(defn ->timestamp
  "Constructor.

  Constructs a Timestamp.

  timestamp - is the timestamp's date and time. It must not be null. - `java.util.Date`
  signer-cert-path - is the TSA's certificate path. It must not be null. - `java.security.cert.CertPath`

  throws: java.lang.NullPointerException - if timestamp or signerCertPath is null."
  ([^java.util.Date timestamp ^java.security.cert.CertPath signer-cert-path]
    (new Timestamp timestamp signer-cert-path)))

(defn get-timestamp
  "Returns the date and time when the timestamp was generated.

  returns: The timestamp's date and time. - `java.util.Date`"
  ([^java.security.Timestamp this]
    (-> this (.getTimestamp))))

(defn get-signer-cert-path
  "Returns the certificate path for the Timestamping Authority.

  returns: The TSA's certificate path. - `java.security.cert.CertPath`"
  ([^java.security.Timestamp this]
    (-> this (.getSignerCertPath))))

(defn hash-code
  "Returns the hash code value for this timestamp.
   The hash code is generated using the date and time of the timestamp
   and the TSA's certificate path.

  returns: a hash code value for this timestamp. - `int`"
  ([^java.security.Timestamp this]
    (-> this (.hashCode))))

(defn equals
  "Tests for equality between the specified object and this
   timestamp. Two timestamps are considered equal if the date and time of
   their timestamp's and their signer's certificate paths are equal.

  obj - the object to test for equality with this timestamp. - `java.lang.Object`

  returns: true if the timestamp are considered equal, false otherwise. - `boolean`"
  ([^java.security.Timestamp this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn to-string
  "Returns a string describing this timestamp.

  returns: A string comprising the date and time of the timestamp and
           its signer's certificate. - `java.lang.String`"
  ([^java.security.Timestamp this]
    (-> this (.toString))))

