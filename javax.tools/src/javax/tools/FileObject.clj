(ns javax.tools.FileObject
  "File abstraction for tools.  In this context, file means
  an abstraction of regular files and other sources of data.  For
  example, a file object can be used to represent regular files,
  memory cache, or data in databases.

  All methods in this interface might throw a SecurityException if
  a security exception occurs.

  Unless explicitly allowed, all methods in this interface might
  throw a NullPointerException if given a null argument."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools FileObject]))

(defn open-writer
  "Gets a Writer for this file object.

  returns: a Writer - `java.io.Writer`

  throws: java.lang.IllegalStateException - if this file object was opened for reading and does not support writing"
  ([^javax.tools.FileObject this]
    (-> this (.openWriter))))

(defn delete
  "Deletes this file object.  In case of errors, returns false.

  returns: true if and only if this file object is successfully
   deleted; false otherwise - `boolean`"
  ([^javax.tools.FileObject this]
    (-> this (.delete))))

(defn open-input-stream
  "Gets an InputStream for this file object.

  returns: an InputStream - `java.io.InputStream`

  throws: java.lang.IllegalStateException - if this file object was opened for writing and does not support reading"
  ([^javax.tools.FileObject this]
    (-> this (.openInputStream))))

(defn open-output-stream
  "Gets an OutputStream for this file object.

  returns: an OutputStream - `java.io.OutputStream`

  throws: java.lang.IllegalStateException - if this file object was opened for reading and does not support writing"
  ([^javax.tools.FileObject this]
    (-> this (.openOutputStream))))

(defn get-last-modified
  "Gets the time this file object was last modified.  The time is
   measured in milliseconds since the epoch (00:00:00 GMT, January
   1, 1970).

  returns: the time this file object was last modified; or 0 if
   the file object does not exist, if an I/O error occurred, or if
   the operation is not supported - `long`"
  ([^javax.tools.FileObject this]
    (-> this (.getLastModified))))

(defn to-uri
  "Returns a URI identifying this file object.

  returns: a URI - `java.net.URI`"
  ([^javax.tools.FileObject this]
    (-> this (.toUri))))

(defn get-name
  "Gets a user-friendly name for this file object.  The exact
   value returned is not specified but implementations should take
   care to preserve names as given by the user.  For example, if
   the user writes the filename `BobsApp\Test.java` on
   the command line, this method should return `BobsApp\Test.java` whereas the toUri
   method might return file:///C:/Documents%20and%20Settings/UncleBob/BobsApp/Test.java.

  returns: a user-friendly name - `java.lang.String`"
  ([^javax.tools.FileObject this]
    (-> this (.getName))))

(defn open-reader
  "Gets a reader for this object.  The returned reader will
   replace bytes that cannot be decoded with the default
   translation character.  In addition, the reader may report a
   diagnostic unless ignoreEncodingErrors is true.

  ignore-encoding-errors - ignore encoding errors if true - `boolean`

  returns: a Reader - `java.io.Reader`

  throws: java.lang.IllegalStateException - if this file object was opened for writing and does not support reading"
  ([^javax.tools.FileObject this ^Boolean ignore-encoding-errors]
    (-> this (.openReader ignore-encoding-errors))))

(defn get-char-content
  "Gets the character content of this file object, if available.
   Any byte that cannot be decoded will be replaced by the default
   translation character.  In addition, a diagnostic may be
   reported unless ignoreEncodingErrors is true.

  ignore-encoding-errors - ignore encoding errors if true - `boolean`

  returns: a CharSequence if available; null otherwise - `java.lang.CharSequence`

  throws: java.lang.IllegalStateException - if this file object was opened for writing and does not support reading"
  ([^javax.tools.FileObject this ^Boolean ignore-encoding-errors]
    (-> this (.getCharContent ignore-encoding-errors))))

