(ns javax.crypto.spec.PBEParameterSpec
  "This class specifies the set of parameters used with password-based
  encryption (PBE), as defined in the
  PKCS #5
  standard."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto.spec PBEParameterSpec]))

(defn ->pbe-parameter-spec
  "Constructor.

  Constructs a parameter set for password-based encryption as defined in
   the PKCS #5 standard.

  salt - the salt. The contents of salt are copied to protect against subsequent modification. - `byte[]`
  iteration-count - the iteration count. - `int`
  param-spec - the cipher algorithm parameter specification, which may be null. - `java.security.spec.AlgorithmParameterSpec`

  throws: java.lang.NullPointerException - if salt is null."
  (^PBEParameterSpec [salt ^Integer iteration-count ^java.security.spec.AlgorithmParameterSpec param-spec]
    (new PBEParameterSpec salt iteration-count param-spec))
  (^PBEParameterSpec [salt ^Integer iteration-count]
    (new PBEParameterSpec salt iteration-count)))

(defn get-salt
  "Returns the salt.

  returns: the salt. Returns a new array
   each time this method is called. - `byte[]`"
  ([^PBEParameterSpec this]
    (-> this (.getSalt))))

(defn get-iteration-count
  "Returns the iteration count.

  returns: the iteration count - `int`"
  (^Integer [^PBEParameterSpec this]
    (-> this (.getIterationCount))))

(defn get-parameter-spec
  "Returns the cipher algorithm parameter specification.

  returns: the parameter specification, or null if none was set. - `java.security.spec.AlgorithmParameterSpec`"
  (^java.security.spec.AlgorithmParameterSpec [^PBEParameterSpec this]
    (-> this (.getParameterSpec))))

