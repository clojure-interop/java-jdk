(ns jdk.io.FileWriter
  "Convenience class for writing character files.  The constructors of this
  class assume that the default character encoding and the default byte-buffer
  size are acceptable.  To specify these values yourself, construct an
  OutputStreamWriter on a FileOutputStream.

  Whether or not a file is available or may be created depends upon the
  underlying platform.  Some platforms, in particular, allow a file to be
  opened for writing by only one FileWriter (or other file-writing
  object) at a time.  In such situations the constructors in this class
  will fail if the file involved is already open.

  FileWriter is meant for writing streams of characters.
  For writing streams of raw bytes, consider using a
  FileOutputStream."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io FileWriter]))

(defn ->file-writer
  "Constructor.

  Constructs a FileWriter object given a file name with a boolean
   indicating whether or not to append the data written.

  file-name - String The system-dependent filename. - `java.lang.String`
  append - boolean if true, then data will be written to the end of the file rather than the beginning. - `boolean`

  throws: java.io.IOException - if the named file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason"
  ([^java.lang.String file-name ^Boolean append]
    (new FileWriter file-name append))
  ([^java.lang.String file-name]
    (new FileWriter file-name)))

