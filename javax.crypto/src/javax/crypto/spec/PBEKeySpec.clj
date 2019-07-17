(ns javax.crypto.spec.PBEKeySpec
  "A user-chosen password that can be used with password-based encryption
  (PBE).

  The password can be viewed as some kind of raw key material, from which
  the encryption mechanism that uses it derives a cryptographic key.

  Different PBE mechanisms may consume different bits of each password
  character. For example, the PBE mechanism defined in

  PKCS #5 looks at only the low order 8 bits of each character, whereas
  PKCS #12 looks at all 16 bits of each character.

  You convert the password characters to a PBE key by creating an
  instance of the appropriate secret-key factory. For example, a secret-key
  factory for PKCS #5 will construct a PBE key from only the low order 8 bits
  of each password character, whereas a secret-key factory for PKCS #12 will
  take all 16 bits of each character.

  Also note that this class stores passwords as char arrays instead of
  String objects (which would seem more logical), because the
  String class is immutable and there is no way to overwrite its
  internal value when the password stored in it is no longer needed. Hence,
  this class requests the password as a char array, so it can be overwritten
  when done."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto.spec PBEKeySpec]))

(defn ->pbe-key-spec
  "Constructor.

  Constructor that takes a password, salt, iteration count, and
   to-be-derived key length for generating PBEKey of variable-key-size
   PBE ciphers.  An empty char[] is used if null is specified for
   password.

    Note: the password and salt
   are cloned before they are stored in
   the new PBEKeySpec object.

  password - the password. - `char[]`
  salt - the salt. - `byte[]`
  iteration-count - the iteration count. - `int`
  key-length - the to-be-derived key length. - `int`

  throws: java.lang.NullPointerException - if salt is null."
  ([password salt ^Integer iteration-count ^Integer key-length]
    (new PBEKeySpec password salt iteration-count key-length))
  ([password salt ^Integer iteration-count]
    (new PBEKeySpec password salt iteration-count))
  ([password]
    (new PBEKeySpec password)))

(defn clear-password
  "Clears the internal copy of the password."
  ([^javax.crypto.spec.PBEKeySpec this]
    (-> this (.clearPassword))))

(defn get-password
  "Returns a copy of the password.

    Note: this method returns a copy of the password. It is
   the caller's responsibility to zero out the password information after
   it is no longer needed.

  returns: the password. - `char[]`

  throws: java.lang.IllegalStateException - if password has been cleared by calling clearPassword method."
  ([^javax.crypto.spec.PBEKeySpec this]
    (-> this (.getPassword))))

(defn get-salt
  "Returns a copy of the salt or null if not specified.

    Note: this method should return a copy of the salt. It is
   the caller's responsibility to zero out the salt information after
   it is no longer needed.

  returns: the salt. - `byte[]`"
  ([^javax.crypto.spec.PBEKeySpec this]
    (-> this (.getSalt))))

(defn get-iteration-count
  "Returns the iteration count or 0 if not specified.

  returns: the iteration count. - `int`"
  ([^javax.crypto.spec.PBEKeySpec this]
    (-> this (.getIterationCount))))

(defn get-key-length
  "Returns the to-be-derived key length or 0 if not specified.

    Note: this is used to indicate the preference on key length
   for variable-key-size ciphers. The actual key size depends on
   each provider's implementation.

  returns: the to-be-derived key length. - `int`"
  ([^javax.crypto.spec.PBEKeySpec this]
    (-> this (.getKeyLength))))

