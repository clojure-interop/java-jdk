(ns jdk.security.spec.KeySpec
  "A (transparent) specification of the key material
  that constitutes a cryptographic key.

  If the key is stored on a hardware device, its
  specification may contain information that helps identify the key on the
  device.

   A key may be specified in an algorithm-specific way, or in an
  algorithm-independent encoding format (such as ASN.1).
  For example, a DSA private key may be specified by its components
  x, p, q, and g
  (see DSAPrivateKeySpec), or it may be
  specified using its DER encoding
  (see PKCS8EncodedKeySpec).

   This interface contains no methods or constants. Its only purpose
  is to group (and provide type safety for) all key specifications.
  All key specifications must implement this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec KeySpec]))

