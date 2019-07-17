(ns jdk.security.KeyRep
  "Standardized representation for serialized Key objects.



  Note that a serialized Key may contain sensitive information
  which should not be exposed in untrusted environments.  See the

  Security Appendix
  of the Serialization Specification for more information."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security KeyRep]))

(defn ->key-rep
  "Constructor.

  Construct the alternate Key class.

  type - either one of Type.SECRET, Type.PUBLIC, or Type.PRIVATE - `java.security.KeyRep.Type`
  algorithm - the algorithm returned from Key.getAlgorithm() - `java.lang.String`
  format - the encoding format returned from Key.getFormat() - `java.lang.String`
  encoded - the encoded bytes returned from Key.getEncoded() - `byte[]`

  throws: java.lang.NullPointerException - if type is null, if algorithm is null, if format is null, or if encoded is null"
  ([^java.security.KeyRep.Type type ^java.lang.String algorithm ^java.lang.String format encoded]
    (new KeyRep type algorithm format encoded)))

