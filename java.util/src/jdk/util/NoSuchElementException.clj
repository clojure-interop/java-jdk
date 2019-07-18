(ns jdk.util.NoSuchElementException
  "Thrown by various accessor methods to indicate that the element being requested
  does not exist."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util NoSuchElementException]))

(defn ->no-such-element-exception
  "Constructor.

  Constructs a NoSuchElementException, saving a reference
   to the error message string s for later retrieval by the
   getMessage method.

  s - the detail message. - `java.lang.String`"
  (^NoSuchElementException [^java.lang.String s]
    (new NoSuchElementException s))
  (^NoSuchElementException []
    (new NoSuchElementException )))

