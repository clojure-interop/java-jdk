(ns jdk.security.PrivateKey
  "A private key.
  The purpose of this interface is to group (and provide type safety
  for) all private key interfaces.

  Note: The specialized private key interfaces extend this interface.
  See, for example, the DSAPrivateKey interface in
  java.security.interfaces.

  Implementations should override the default destroy and
  isDestroyed methods from the
  Destroyable interface to enable
  sensitive key information to be destroyed, cleared, or in the case
  where such information is immutable, unreferenced.
  Finally, since PrivateKey is Serializable, implementations
  should also override
  ObjectOutputStream.writeObject(java.lang.Object)
  to prevent keys that have been destroyed from being serialized."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security PrivateKey]))

