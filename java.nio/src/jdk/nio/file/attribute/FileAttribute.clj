(ns jdk.nio.file.attribute.FileAttribute
  "An object that encapsulates the value of a file attribute that can be set
  atomically when creating a new file or directory by invoking the createFile or createDirectory methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.attribute FileAttribute]))

(defn name
  "Returns the attribute name.

  returns: The attribute name - `java.lang.String`"
  ([this]
    (-> this (.name))))

(defn value
  "Returns the attribute value.

  returns: The attribute value - `FileAttribute.T`"
  ([this]
    (-> this (.value))))

