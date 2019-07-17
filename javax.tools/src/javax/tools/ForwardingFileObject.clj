(ns javax.tools.ForwardingFileObject
  "Forwards calls to a given file object.  Subclasses of this class
  might override some of these methods and might also provide
  additional fields and methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools ForwardingFileObject]))

(defn open-writer
  "Description copied from interface: FileObject

  returns: a Writer - `java.io.Writer`

  throws: java.lang.IllegalStateException - if this file object was opened for reading and does not support writing"
  ([this]
    (-> this (.openWriter))))

(defn delete
  "Description copied from interface: FileObject

  returns: true if and only if this file object is successfully
   deleted; false otherwise - `boolean`"
  ([this]
    (-> this (.delete))))

(defn open-input-stream
  "Description copied from interface: FileObject

  returns: an InputStream - `java.io.InputStream`

  throws: java.lang.IllegalStateException - if this file object was opened for writing and does not support reading"
  ([this]
    (-> this (.openInputStream))))

(defn open-output-stream
  "Description copied from interface: FileObject

  returns: an OutputStream - `java.io.OutputStream`

  throws: java.lang.IllegalStateException - if this file object was opened for reading and does not support writing"
  ([this]
    (-> this (.openOutputStream))))

(defn get-last-modified
  "Description copied from interface: FileObject

  returns: the time this file object was last modified; or 0 if
   the file object does not exist, if an I/O error occurred, or if
   the operation is not supported - `long`"
  ([this]
    (-> this (.getLastModified))))

(defn to-uri
  "Description copied from interface: FileObject

  returns: a URI - `java.net.URI`"
  ([this]
    (-> this (.toUri))))

(defn get-name
  "Description copied from interface: FileObject

  returns: a user-friendly name - `java.lang.String`"
  ([this]
    (-> this (.getName))))

(defn open-reader
  "Description copied from interface: FileObject

  ignore-encoding-errors - ignore encoding errors if true - `boolean`

  returns: a Reader - `java.io.Reader`

  throws: java.lang.IllegalStateException - if this file object was opened for writing and does not support reading"
  ([this ignore-encoding-errors]
    (-> this (.openReader ignore-encoding-errors))))

(defn get-char-content
  "Description copied from interface: FileObject

  ignore-encoding-errors - ignore encoding errors if true - `boolean`

  returns: a CharSequence if available; null otherwise - `java.lang.CharSequence`

  throws: java.lang.IllegalStateException - if this file object was opened for writing and does not support reading"
  ([this ignore-encoding-errors]
    (-> this (.getCharContent ignore-encoding-errors))))

