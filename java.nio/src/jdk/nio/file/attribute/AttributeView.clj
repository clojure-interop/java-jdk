(ns jdk.nio.file.attribute.AttributeView
  "An object that provides a read-only or updatable view of non-opaque
  values associated with an object in a filesystem. This interface is extended
  or implemented by specific attribute views that define the attributes
  supported by the view. A specific attribute view will typically define
  type-safe methods to read or update the attributes that it supports."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.attribute AttributeView]))

(defn name
  "Returns the name of the attribute view.

  returns: the name of the attribute view - `java.lang.String`"
  (^java.lang.String [^java.nio.file.attribute.AttributeView this]
    (-> this (.name))))

