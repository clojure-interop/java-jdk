(ns jdk.lang.StringIndexOutOfBoundsException
  "Thrown by String methods to indicate that an index
  is either negative or greater than the size of the string.  For
  some methods such as the charAt method, this exception also is
  thrown when the index is equal to the size of the string."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang StringIndexOutOfBoundsException]))

(defn ->string-index-out-of-bounds-exception
  "Constructor.

  Constructs a StringIndexOutOfBoundsException with
   the specified detail message.

  s - the detail message. - `java.lang.String`"
  ([s]
    (new StringIndexOutOfBoundsException s))
  ([]
    (new StringIndexOutOfBoundsException )))

