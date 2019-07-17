(ns jdk.nio.file.DirectoryIteratorException
  "Runtime exception thrown if an I/O error is encountered when iterating over
  the entries in a directory. The I/O error is retrieved as an IOException using the getCause() method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file DirectoryIteratorException]))

(defn ->directory-iterator-exception
  "Constructor.

  Constructs an instance of this class.

  cause - the IOException that caused the directory iteration to fail - `java.io.IOException`

  throws: java.lang.NullPointerException - if the cause is null"
  ([cause]
    (new DirectoryIteratorException cause)))

(defn get-cause
  "Returns the cause of this exception.

  returns: the cause - `java.io.IOException`"
  ([this]
    (-> this (.getCause))))

