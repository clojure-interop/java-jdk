(ns jdk.io.FileReader
  "Convenience class for reading character files.  The constructors of this
  class assume that the default character encoding and the default byte-buffer
  size are appropriate.  To specify these values yourself, construct an
  InputStreamReader on a FileInputStream.

  FileReader is meant for reading streams of characters.
  For reading streams of raw bytes, consider using a
  FileInputStream."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io FileReader]))

(defn ->file-reader
  "Constructor.

  Creates a new FileReader, given the name of the
   file to read from.

  file-name - the name of the file to read from - `java.lang.String`

  throws: java.io.FileNotFoundException - if the named file does not exist, is a directory rather than a regular file, or for some other reason cannot be opened for reading."
  ([^java.lang.String file-name]
    (new FileReader file-name)))

