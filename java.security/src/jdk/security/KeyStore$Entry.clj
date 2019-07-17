(ns jdk.security.KeyStore$Entry
  "A marker interface for KeyStore entry types."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security KeyStore$Entry]))

(defn get-attributes
  "Retrieves the attributes associated with an entry.

   The default implementation returns an empty Set.

  returns: an unmodifiable Set of attributes, possibly empty - `default java.util.Set<java.security.KeyStore.Entry.Attribute>`"
  ([^. this]
    (-> this (.getAttributes))))

