(ns javax.tools.SimpleJavaFileObject
  "Provides simple implementations for most methods in JavaFileObject.
  This class is designed to be subclassed and used as a basis for
  JavaFileObject implementations.  Subclasses can override the
  implementation and specification of any method of this class as
  long as the general contract of JavaFileObject is obeyed."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools SimpleJavaFileObject]))

(defn name-compatible?
  "This implementation compares the path of its URI to the given
   simple name.  This method returns true if the given kind is
   equal to the kind of this object, and if the path is equal to
   simpleName  kind.extension or if it ends with \"/\"  simpleName  kind.extension.

   This method calls getKind() and toUri() and
   does not access the fields uri and kind
   directly.

   Subclasses can change this behavior as long as the contract
   of JavaFileObject is obeyed.

  simple-name - a simple name of a class - `java.lang.String`
  kind - a kind - `javax.tools.JavaFileObject$Kind`

  returns: true if this file object is compatible; false
   otherwise - `boolean`"
  (^Boolean [^SimpleJavaFileObject this ^java.lang.String simple-name ^javax.tools.JavaFileObject$Kind kind]
    (-> this (.isNameCompatible simple-name kind))))

(defn open-writer
  "Wraps the result of openOutputStream in a Writer.  Subclasses
   can change this behavior as long as the contract of FileObject is obeyed.

  returns: a Writer wrapping the result of openOutputStream - `java.io.Writer`

  throws: java.lang.IllegalStateException - if this file object was opened for reading and does not support writing"
  (^java.io.Writer [^SimpleJavaFileObject this]
    (-> this (.openWriter))))

(defn get-kind
  "Description copied from interface: JavaFileObject

  returns: this.kind - `javax.tools.JavaFileObject$Kind`"
  (^javax.tools.JavaFileObject$Kind [^SimpleJavaFileObject this]
    (-> this (.getKind))))

(defn delete
  "This implementation does nothing.  Subclasses can change this
   behavior as long as the contract of FileObject is
   obeyed.

  returns: false - `boolean`"
  (^Boolean [^SimpleJavaFileObject this]
    (-> this (.delete))))

(defn get-access-level
  "This implementation returns null.  Subclasses can
   change this behavior as long as the contract of
   JavaFileObject is obeyed.

  returns: the access level - `javax.lang.model.element.Modifier`"
  (^javax.lang.model.element.Modifier [^SimpleJavaFileObject this]
    (-> this (.getAccessLevel))))

(defn open-input-stream
  "This implementation always throws java.lang.UnsupportedOperationException.  Subclasses can change this
   behavior as long as the contract of FileObject is
   obeyed.

  returns: an InputStream - `java.io.InputStream`

  throws: java.io.IOException - if an I/O error occurred"
  (^java.io.InputStream [^SimpleJavaFileObject this]
    (-> this (.openInputStream))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^SimpleJavaFileObject this]
    (-> this (.toString))))

(defn open-output-stream
  "This implementation always throws java.lang.UnsupportedOperationException.  Subclasses can change this
   behavior as long as the contract of FileObject is
   obeyed.

  returns: an OutputStream - `java.io.OutputStream`

  throws: java.io.IOException - if an I/O error occurred"
  (^java.io.OutputStream [^SimpleJavaFileObject this]
    (-> this (.openOutputStream))))

(defn get-last-modified
  "This implementation returns 0L.  Subclasses can change
   this behavior as long as the contract of FileObject is
   obeyed.

  returns: 0L - `long`"
  (^Long [^SimpleJavaFileObject this]
    (-> this (.getLastModified))))

(defn to-uri
  "Description copied from interface: FileObject

  returns: a URI - `java.net.URI`"
  (^java.net.URI [^SimpleJavaFileObject this]
    (-> this (.toUri))))

(defn get-name
  "Description copied from interface: FileObject

  returns: a user-friendly name - `java.lang.String`"
  (^java.lang.String [^SimpleJavaFileObject this]
    (-> this (.getName))))

(defn open-reader
  "Wraps the result of getCharContent(boolean) in a Reader.
   Subclasses can change this behavior as long as the contract of
   FileObject is obeyed.

  ignore-encoding-errors - ignore encoding errors if true - `boolean`

  returns: a Reader wrapping the result of getCharContent - `java.io.Reader`

  throws: java.lang.IllegalStateException - if this file object was opened for writing and does not support reading"
  (^java.io.Reader [^SimpleJavaFileObject this ^Boolean ignore-encoding-errors]
    (-> this (.openReader ignore-encoding-errors))))

(defn get-char-content
  "This implementation always throws java.lang.UnsupportedOperationException.  Subclasses can change this
   behavior as long as the contract of FileObject is
   obeyed.

  ignore-encoding-errors - ignore encoding errors if true - `boolean`

  returns: a CharSequence if available; null otherwise - `java.lang.CharSequence`

  throws: java.io.IOException - if an I/O error occurred"
  (^java.lang.CharSequence [^SimpleJavaFileObject this ^Boolean ignore-encoding-errors]
    (-> this (.getCharContent ignore-encoding-errors))))

(defn get-nesting-kind
  "This implementation returns null.  Subclasses can
   change this behavior as long as the contract of
   JavaFileObject is obeyed.

  returns: the nesting kind, or null if the nesting kind
   is not known - `javax.lang.model.element.NestingKind`"
  (^javax.lang.model.element.NestingKind [^SimpleJavaFileObject this]
    (-> this (.getNestingKind))))

