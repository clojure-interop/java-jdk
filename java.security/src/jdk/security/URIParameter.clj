(ns jdk.security.URIParameter
  "A parameter that contains a URI pointing to data intended for a
  PolicySpi or ConfigurationSpi implementation."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security URIParameter]))

(defn ->uri-parameter
  "Constructor.

  Constructs a URIParameter with the URI pointing to
   data intended for an SPI implementation.

  uri - the URI pointing to the data. - `java.net.URI`

  throws: java.lang.NullPointerException - if the specified URI is null."
  ([^java.net.URI uri]
    (new URIParameter uri)))

(defn get-uri
  "Returns the URI.

  returns: uri the URI. - `java.net.URI`"
  ([^java.security.URIParameter this]
    (-> this (.getURI))))

