(ns javax.xml.crypto.KeySelectorResult
  "The result returned by the KeySelector.select
  method.

  At a minimum, a KeySelectorResult contains the Key
  selected by the KeySelector. Implementations of this interface
  may add methods to return implementation or algorithm specific information,
  such as a chain of certificates or debugging information."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto KeySelectorResult]))

(defn get-key
  "Returns the selected key.

  returns: the selected key, or null if none can be found - `java.security.Key`"
  (^java.security.Key [^KeySelectorResult this]
    (-> this (.getKey))))

