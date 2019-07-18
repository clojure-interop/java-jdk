(ns jdk.lang.IndexOutOfBoundsException
  "Thrown to indicate that an index of some sort (such as to an array, to a
  string, or to a vector) is out of range.

  Applications can subclass this class to indicate similar exceptions."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang IndexOutOfBoundsException]))

(defn ->index-out-of-bounds-exception
  "Constructor.

  Constructs an IndexOutOfBoundsException with the
   specified detail message.

  s - the detail message. - `java.lang.String`"
  (^IndexOutOfBoundsException [^java.lang.String s]
    (new IndexOutOfBoundsException s))
  (^IndexOutOfBoundsException []
    (new IndexOutOfBoundsException )))

