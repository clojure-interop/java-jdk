(ns jdk.util.MissingResourceException
  "Signals that a resource is missing."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util MissingResourceException]))

(defn ->missing-resource-exception
  "Constructor.

  Constructs a MissingResourceException with the specified information.
   A detail message is a String that describes this particular exception.

  s - the detail message - `java.lang.String`
  class-name - the name of the resource class - `java.lang.String`
  key - the key for the missing resource. - `java.lang.String`"
  (^MissingResourceException [^java.lang.String s ^java.lang.String class-name ^java.lang.String key]
    (new MissingResourceException s class-name key)))

(defn get-class-name
  "Gets parameter passed by constructor.

  returns: the name of the resource class - `java.lang.String`"
  (^java.lang.String [^MissingResourceException this]
    (-> this (.getClassName))))

(defn get-key
  "Gets parameter passed by constructor.

  returns: the key for the missing resource - `java.lang.String`"
  (^java.lang.String [^MissingResourceException this]
    (-> this (.getKey))))

