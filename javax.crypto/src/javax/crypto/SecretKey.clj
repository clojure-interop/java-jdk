(ns javax.crypto.SecretKey
  "A secret (symmetric) key.
  The purpose of this interface is to group (and provide type safety
  for) all secret key interfaces.

  Provider implementations of this interface must overwrite the
  equals and hashCode methods inherited from
  Object, so that secret keys are compared based on
  their underlying key material and not based on reference.
  Implementations should override the default destroy and
  isDestroyed methods from the
  Destroyable interface to enable
  sensitive key information to be destroyed, cleared, or in the case
  where such information is immutable, unreferenced.
  Finally, since SecretKey is Serializable, implementations
  should also override
  ObjectOutputStream.writeObject(java.lang.Object)
  to prevent keys that have been destroyed from being serialized.

  Keys that implement this interface return the string RAW
  as their encoding format (see getFormat), and return the
  raw key bytes as the result of a getEncoded method call. (The
  getFormat and getEncoded methods are inherited
  from the Key parent interface.)"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto SecretKey]))

