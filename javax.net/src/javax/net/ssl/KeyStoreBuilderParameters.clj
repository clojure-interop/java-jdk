(ns javax.net.ssl.KeyStoreBuilderParameters
  "A parameters object for X509KeyManagers that encapsulates a List
  of KeyStore.Builders."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl KeyStoreBuilderParameters]))

(defn ->key-store-builder-parameters
  "Constructor.

  Construct new KeyStoreBuilderParameters from the specified
   java.security.KeyStore.Builder.

  builder - the Builder object - `java.security.KeyStore.Builder`

  throws: java.lang.NullPointerException - if builder is null"
  ([^java.security.KeyStore.Builder builder]
    (new KeyStoreBuilderParameters builder)))

(defn get-parameters
  "Return the unmodifiable List of the
   java.security.KeyStore.Builders
   encapsulated by this object.

  returns: the unmodifiable List of the
   java.security.KeyStore.Builders
   encapsulated by this object. - `java.util.List<java.security.KeyStore.Builder>`"
  (^java.util.List [^javax.net.ssl.KeyStoreBuilderParameters this]
    (-> this (.getParameters))))

