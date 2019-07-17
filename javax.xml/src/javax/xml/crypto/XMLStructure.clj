(ns javax.xml.crypto.XMLStructure
  "A representation of an XML structure from any namespace. The purpose of
  this interface is to group (and provide type safety for) all
  representations of XML structures."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto XMLStructure]))

(defn feature-supported?
  "Indicates whether a specified feature is supported.

  feature - the feature name (as an absolute URI) - `java.lang.String`

  returns: true if the specified feature is supported,
      false otherwise - `boolean`

  throws: java.lang.NullPointerException - if feature is null"
  ([^. this ^java.lang.String feature]
    (-> this (.isFeatureSupported feature))))

