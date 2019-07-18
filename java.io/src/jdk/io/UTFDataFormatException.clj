(ns jdk.io.UTFDataFormatException
  "Signals that a malformed string in
  modified UTF-8
  format has been read in a data
  input stream or by any class that implements the data input
  interface.
  See the
  DataInput
  class description for the format in
  which modified UTF-8 strings are read and written."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io UTFDataFormatException]))

(defn ->utf-data-format-exception
  "Constructor.

  Constructs a UTFDataFormatException with the
   specified detail message. The string s can be
   retrieved later by the
   Throwable.getMessage()
   method of class java.lang.Throwable.

  s - the detail message. - `java.lang.String`"
  (^UTFDataFormatException [^java.lang.String s]
    (new UTFDataFormatException s))
  (^UTFDataFormatException []
    (new UTFDataFormatException )))

