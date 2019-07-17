(ns jdk.security.PublicKey
  "A public key. This interface contains no methods or constants.
  It merely serves to group (and provide type safety for) all public key
  interfaces.

  Note: The specialized public key interfaces extend this interface.
  See, for example, the DSAPublicKey interface in
  java.security.interfaces."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security PublicKey]))

