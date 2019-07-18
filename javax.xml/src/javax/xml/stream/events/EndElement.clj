(ns javax.xml.stream.events.EndElement
  "An interface for the end element event.  An EndElement is reported
  for each End Tag in the document."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream.events EndElement]))

(defn get-name
  "Get the name of this event

  returns: the qualified name of this event - `javax.xml.namespace.QName`"
  (^javax.xml.namespace.QName [^EndElement this]
    (-> this (.getName))))

(defn get-namespaces
  "Returns an Iterator of namespaces that have gone out
   of scope.  Returns an empty iterator if no namespaces have gone
   out of scope.

  returns: an Iterator over Namespace interfaces, or an
   empty iterator - `java.util.Iterator`"
  (^java.util.Iterator [^EndElement this]
    (-> this (.getNamespaces))))

