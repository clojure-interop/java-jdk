(ns javax.xml.stream.events.EntityDeclaration
  "An interface for handling Entity Declarations

  This interface is used to record and report unparsed entity declarations."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream.events EntityDeclaration]))

(defn get-public-id
  "The entity's public identifier, or null if none was given

  returns: the public ID for this declaration or null - `java.lang.String`"
  (^java.lang.String [^EntityDeclaration this]
    (-> this (.getPublicId))))

(defn get-system-id
  "The entity's system identifier.

  returns: the system ID for this declaration or null - `java.lang.String`"
  (^java.lang.String [^EntityDeclaration this]
    (-> this (.getSystemId))))

(defn get-name
  "The entity's name

  returns: the name, may not be null - `java.lang.String`"
  (^java.lang.String [^EntityDeclaration this]
    (-> this (.getName))))

(defn get-notation-name
  "The name of the associated notation.

  returns: the notation name - `java.lang.String`"
  (^java.lang.String [^EntityDeclaration this]
    (-> this (.getNotationName))))

(defn get-replacement-text
  "The replacement text of the entity.
   This method will only return non-null
   if this is an internal entity.

  returns: null or the replacment text - `java.lang.String`"
  (^java.lang.String [^EntityDeclaration this]
    (-> this (.getReplacementText))))

(defn get-base-uri
  "Get the base URI for this reference
   or null if this information is not available

  returns: the base URI or null - `java.lang.String`"
  (^java.lang.String [^EntityDeclaration this]
    (-> this (.getBaseURI))))

