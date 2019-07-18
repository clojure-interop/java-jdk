(ns jdk.awt.geom.IllegalPathStateException
  "The IllegalPathStateException represents an
  exception that is thrown if an operation is performed on a path
  that is in an illegal state with respect to the particular
  operation being performed, such as appending a path segment
  to a GeneralPath without an initial moveto."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom IllegalPathStateException]))

(defn ->illegal-path-state-exception
  "Constructor.

  Constructs an IllegalPathStateException with the
   specified detail message.

  s - the detail message - `java.lang.String`"
  (^IllegalPathStateException [^java.lang.String s]
    (new IllegalPathStateException s))
  (^IllegalPathStateException []
    (new IllegalPathStateException )))

