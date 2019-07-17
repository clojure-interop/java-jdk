(ns jdk.awt.color.ProfileDataException
  "This exception is thrown when an error occurs in accessing or
  processing an ICC_Profile object."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.color ProfileDataException]))

(defn ->profile-data-exception
  "Constructor.

  Constructs a ProfileDataException with the specified detail message.

  s - the specified detail message - `java.lang.String`"
  ([s]
    (new ProfileDataException s)))

