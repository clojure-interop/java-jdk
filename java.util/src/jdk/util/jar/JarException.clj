(ns jdk.util.jar.JarException
  "Signals that an error of some sort has occurred while reading from
  or writing to a JAR file."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.jar JarException]))

(defn ->jar-exception
  "Constructor.

  Constructs a JarException with the specified detail message.

  s - the detail message - `java.lang.String`"
  ([s]
    (new JarException s))
  ([]
    (new JarException )))

