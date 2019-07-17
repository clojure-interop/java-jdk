(ns jdk.security.spec.ECField
  "This interface represents an elliptic curve (EC) finite field.
  All specialized EC fields must implements this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec ECField]))

(defn get-field-size
  "Returns the field size in bits. Note: For prime finite
   field ECFieldFp, size of prime p in bits is returned.
   For characteristic 2 finite field ECFieldF2m, m is returned.

  returns: the field size in bits. - `int`"
  ([^. this]
    (-> this (.getFieldSize))))

