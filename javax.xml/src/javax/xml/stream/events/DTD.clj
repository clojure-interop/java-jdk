(ns javax.xml.stream.events.DTD
  "This is the top level interface for events dealing with DTDs"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream.events DTD]))

(defn get-document-type-declaration
  "Returns the entire Document Type Declaration as a string, including
   the internal DTD subset.
   This may be null if there is not an internal subset.
   If it is not null it must return the entire
   Document Type Declaration which matches the doctypedecl
   production in the XML 1.0 specification

  returns: `java.lang.String`"
  ([^javax.xml.stream.events.DTD this]
    (-> this (.getDocumentTypeDeclaration))))

(defn get-processed-dtd
  "Returns an implementation defined representation of the DTD.
   This method may return null if no representation is available.

  returns: `java.lang.Object`"
  ([^javax.xml.stream.events.DTD this]
    (-> this (.getProcessedDTD))))

(defn get-notations
  "Return a List containing the notations declared in the DTD.
   This list must contain NotationDeclaration events.

  returns: an unordered list of NotationDeclaration events - `java.util.List`"
  ([^javax.xml.stream.events.DTD this]
    (-> this (.getNotations))))

(defn get-entities
  "Return a List containing the general entities,
   both external and internal, declared in the DTD.
   This list must contain EntityDeclaration events.

  returns: an unordered list of EntityDeclaration events - `java.util.List`"
  ([^javax.xml.stream.events.DTD this]
    (-> this (.getEntities))))

