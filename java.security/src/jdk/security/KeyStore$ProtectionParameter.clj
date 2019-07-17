(ns jdk.security.KeyStore$ProtectionParameter
  "A marker interface for keystore protection parameters.

   The information stored in a ProtectionParameter
  object protects the contents of a keystore.
  For example, protection parameters may be used to check
  the integrity of keystore data, or to protect the
  confidentiality of sensitive keystore data
  (such as a PrivateKey)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security KeyStore$ProtectionParameter]))

