(ns jdk.security.KeyStore$Entry$Attribute
  "An attribute associated with a keystore entry.
  It comprises a name and one or more values."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security KeyStore$Entry$Attribute]))

(defn get-name
  "Returns the attribute's name.

  returns: the attribute name - `java.lang.String`"
  (^java.lang.String [^KeyStore$Entry$Attribute this]
    (-> this (.getName))))

(defn get-value
  "Returns the attribute's value.
   Multi-valued attributes encode their values as a single string.

  returns: the attribute value - `java.lang.String`"
  (^java.lang.String [^KeyStore$Entry$Attribute this]
    (-> this (.getValue))))

