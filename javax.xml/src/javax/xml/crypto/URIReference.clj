(ns javax.xml.crypto.URIReference
  "Identifies a data object via a URI-Reference, as specified by
  RFC 2396.

  Note that some subclasses may not have a type attribute
  and for objects of those types, the getType() method always returns
  null."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto URIReference]))

(defn get-uri
  "Returns the URI of the referenced data object.

  returns: the URI of the data object in RFC 2396 format (may be
      null if not specified) - `java.lang.String`"
  (^java.lang.String [^URIReference this]
    (-> this (.getURI))))

(defn get-type
  "Returns the type of data referenced by this URI.

  returns: the type (a URI) of the data object (may be null
      if not specified) - `java.lang.String`"
  (^java.lang.String [^URIReference this]
    (-> this (.getType))))

