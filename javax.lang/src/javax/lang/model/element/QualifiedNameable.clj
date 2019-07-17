(ns javax.lang.model.element.QualifiedNameable
  "A mixin interface for an element that has a qualified name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.element QualifiedNameable]))

(defn get-qualified-name
  "Returns the fully qualified name of an element.

  returns: the fully qualified name of an element - `javax.lang.model.element.Name`"
  ([this]
    (-> this (.getQualifiedName))))

