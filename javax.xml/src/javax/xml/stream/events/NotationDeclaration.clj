(ns javax.xml.stream.events.NotationDeclaration
  "An interface for handling Notation Declarations

  Receive notification of a notation declaration event.
  It is up to the application to record the notation for later reference,
  At least one of publicId and systemId must be non-null.
  There is no guarantee that the notation declaration
  will be reported before any unparsed entities that use it."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream.events NotationDeclaration]))

(defn get-name
  "The notation name.

  returns: `java.lang.String`"
  ([^javax.xml.stream.events.NotationDeclaration this]
    (-> this (.getName))))

(defn get-public-id
  "The notation's public identifier, or null if none was given.

  returns: `java.lang.String`"
  ([^javax.xml.stream.events.NotationDeclaration this]
    (-> this (.getPublicId))))

(defn get-system-id
  "The notation's system identifier, or null if none was given.

  returns: `java.lang.String`"
  ([^javax.xml.stream.events.NotationDeclaration this]
    (-> this (.getSystemId))))

