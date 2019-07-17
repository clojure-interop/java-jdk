(ns jdk.security.KeyStore$PasswordProtection
  "A password-based implementation of ProtectionParameter."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security KeyStore$PasswordProtection]))

(defn ->password-protection
  "Constructor.

  Creates a password parameter and specifies the protection algorithm
   and associated parameters to use when encrypting a keystore entry.

   The specified password is cloned before it is stored in the
   new PasswordProtection object.

  password - the password, which may be null - `char[]`
  protection-algorithm - the encryption algorithm name, for example, PBEWithHmacSHA256AndAES_256. See the Cipher section in the Java Cryptography Architecture Standard Algorithm Name Documentation for information about standard encryption algorithm names. - `java.lang.String`
  protection-parameters - the encryption algorithm parameter specification, which may be null - `java.security.spec.AlgorithmParameterSpec`

  throws: java.lang.NullPointerException - if protectionAlgorithm is null"
  ([password ^java.lang.String protection-algorithm ^java.security.spec.AlgorithmParameterSpec protection-parameters]
    (new KeyStore$PasswordProtection password protection-algorithm protection-parameters))
  ([password]
    (new KeyStore$PasswordProtection password)))

(defn get-protection-algorithm
  "Gets the name of the protection algorithm.
   If none was set then the keystore provider will use its default
   protection algorithm. The name of the default protection algorithm
   for a given keystore type is set using the
   'keystore.<type>.keyProtectionAlgorithm' security property.
   For example, the
   keystore.PKCS12.keyProtectionAlgorithm property stores the
   name of the default key protection algorithm used for PKCS12
   keystores. If the security property is not set, an
   implementation-specific algorithm will be used.

  returns: the algorithm name, or null if none was set - `java.lang.String`"
  ([^java.security.KeyStore$PasswordProtection this]
    (-> this (.getProtectionAlgorithm))))

(defn get-protection-parameters
  "Gets the parameters supplied for the protection algorithm.

  returns: the algorithm parameter specification, or null,
       if none was set - `java.security.spec.AlgorithmParameterSpec`"
  ([^java.security.KeyStore$PasswordProtection this]
    (-> this (.getProtectionParameters))))

(defn get-password
  "Gets the password.

   Note that this method returns a reference to the password.
   If a clone of the array is created it is the caller's
   responsibility to zero out the password information
   after it is no longer needed.

  returns: the password, which may be null - `char[]`

  throws: java.lang.IllegalStateException - if the password has been cleared (destroyed)"
  ([^java.security.KeyStore$PasswordProtection this]
    (-> this (.getPassword))))

(defn destroy
  "Clears the password.

  throws: javax.security.auth.DestroyFailedException - if this method was unable to clear the password"
  ([^java.security.KeyStore$PasswordProtection this]
    (-> this (.destroy))))

(defn destroyed?
  "Determines if password has been cleared.

  returns: true if the password has been cleared, false otherwise - `boolean`"
  ([^java.security.KeyStore$PasswordProtection this]
    (-> this (.isDestroyed))))

