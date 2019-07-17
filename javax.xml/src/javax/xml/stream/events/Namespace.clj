(ns javax.xml.stream.events.Namespace
  "An interface that contains information about a namespace.
  Namespaces are accessed from a StartElement."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream.events Namespace]))

(defn get-prefix
  "Gets the prefix, returns `` if this is a default
   namespace declaration.

  returns: `java.lang.String`"
  ([^javax.xml.stream.events.Namespace this]
    (-> this (.getPrefix))))

(defn get-namespace-uri
  "Gets the uri bound to the prefix of this namespace

  returns: `java.lang.String`"
  ([^javax.xml.stream.events.Namespace this]
    (-> this (.getNamespaceURI))))

(defn default-namespace-declaration?
  "returns true if this attribute declares the default namespace

  returns: `boolean`"
  ([^javax.xml.stream.events.Namespace this]
    (-> this (.isDefaultNamespaceDeclaration))))

