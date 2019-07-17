(ns javax.management.relation.RelationException
  "This class is the superclass of any exception which can be raised during
  relation management."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation RelationException]))

(defn ->relation-exception
  "Constructor.

  Constructor with given message put in exception.

  message - the detail message. - `java.lang.String`"
  ([^java.lang.String message]
    (new RelationException message))
  ([]
    (new RelationException )))

