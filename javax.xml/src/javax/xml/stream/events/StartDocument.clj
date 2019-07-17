(ns javax.xml.stream.events.StartDocument
  "An interface for the start document event"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream.events StartDocument]))

(defn get-system-id
  "Returns the system ID of the XML data

  returns: the system ID, defaults to `` - `java.lang.String`"
  ([^. this]
    (-> this (.getSystemId))))

(defn get-character-encoding-scheme
  "Returns the encoding style of the XML data

  returns: the character encoding, defaults to `UTF-8` - `java.lang.String`"
  ([^. this]
    (-> this (.getCharacterEncodingScheme))))

(defn encoding-set
  "Returns true if CharacterEncodingScheme was set in
   the encoding declaration of the document

  returns: `boolean`"
  ([^. this]
    (-> this (.encodingSet))))

(defn standalone?
  "Returns if this XML is standalone

  returns: the standalone state of XML, defaults to `no` - `boolean`"
  ([^. this]
    (-> this (.isStandalone))))

(defn standalone-set
  "Returns true if the standalone attribute was set in
   the encoding declaration of the document.

  returns: `boolean`"
  ([^. this]
    (-> this (.standaloneSet))))

(defn get-version
  "Returns the version of XML of this XML stream

  returns: the version of XML, defaults to `1.0` - `java.lang.String`"
  ([^. this]
    (-> this (.getVersion))))

