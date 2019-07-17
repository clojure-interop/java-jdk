(ns jdk.io.EOFException
  "Signals that an end of file or end of stream has been reached
  unexpectedly during input.

  This exception is mainly used by data input streams to signal end of
  stream. Note that many other input operations return a special value on
  end of stream rather than throwing an exception."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io EOFException]))

(defn ->eof-exception
  "Constructor.

  Constructs an EOFException with the specified detail
   message. The string s may later be retrieved by the
   Throwable.getMessage() method of class
   java.lang.Throwable.

  s - the detail message. - `java.lang.String`"
  ([^java.lang.String s]
    (new EOFException s))
  ([]
    (new EOFException )))

