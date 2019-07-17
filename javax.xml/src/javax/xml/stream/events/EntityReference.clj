(ns javax.xml.stream.events.EntityReference
  "An interface for handling Entity events.

  This event reports entities that have not been resolved
  and reports their replacement text unprocessed (if
  available).  This event will be reported if javax.xml.stream.isReplacingEntityReferences
  is set to false.  If javax.xml.stream.isReplacingEntityReferences is set to true
  entity references will be resolved transparently.

  Entities are handled in two possible ways:

  (1) If javax.xml.stream.isReplacingEntityReferences is set to true
  all entity references are resolved and reported as markup transparently.
  (2) If javax.xml.stream.isReplacingEntityReferences is set to false
  Entity references are reported as an EntityReference Event."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream.events EntityReference]))

(defn get-declaration
  "Return the declaration of this entity.

  returns: `javax.xml.stream.events.EntityDeclaration`"
  ([^javax.xml.stream.events.EntityReference this]
    (-> this (.getDeclaration))))

(defn get-name
  "The name of the entity

  returns: the entity's name, may not be null - `java.lang.String`"
  ([^javax.xml.stream.events.EntityReference this]
    (-> this (.getName))))

