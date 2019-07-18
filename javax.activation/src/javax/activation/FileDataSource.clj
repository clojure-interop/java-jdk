(ns javax.activation.FileDataSource
  "The FileDataSource class implements a simple DataSource object
  that encapsulates a file. It provides data typing services via
  a FileTypeMap object.

  FileDataSource Typing Semantics

  The FileDataSource class delegates data typing of files
  to an object subclassed from the FileTypeMap class.
  The setFileTypeMap method can be used to explicitly
  set the FileTypeMap for an instance of FileDataSource. If no
  FileTypeMap is set, the FileDataSource will call the FileTypeMap's
  getDefaultFileTypeMap method to get the System's default FileTypeMap."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.activation FileDataSource]))

(defn ->file-data-source
  "Constructor.

  Creates a FileDataSource from a File object. Note:
   The file will not actually be opened until a method is
   called that requires the file to be opened.

  file - the file - `java.io.File`"
  (^FileDataSource [^java.io.File file]
    (new FileDataSource file)))

(defn get-input-stream
  "This method will return an InputStream representing the
   the data and will throw an IOException if it can
   not do so. This method will return a new
   instance of InputStream with each invocation.

  returns: an InputStream - `java.io.InputStream`

  throws: java.io.IOException"
  (^java.io.InputStream [^FileDataSource this]
    (-> this (.getInputStream))))

(defn get-output-stream
  "This method will return an OutputStream representing the
   the data and will throw an IOException if it can
   not do so. This method will return a new instance of
   OutputStream with each invocation.

  returns: an OutputStream - `java.io.OutputStream`

  throws: java.io.IOException"
  (^java.io.OutputStream [^FileDataSource this]
    (-> this (.getOutputStream))))

(defn get-content-type
  "This method returns the MIME type of the data in the form of a
   string. This method uses the currently installed FileTypeMap. If
   there is no FileTypeMap explictly set, the FileDataSource will
   call the getDefaultFileTypeMap method on
   FileTypeMap to acquire a default FileTypeMap. Note: By
   default, the FileTypeMap used will be a MimetypesFileTypeMap.

  returns: the MIME Type - `java.lang.String`"
  (^java.lang.String [^FileDataSource this]
    (-> this (.getContentType))))

(defn get-name
  "Return the name of this object. The FileDataSource
   will return the file name of the object.

  returns: the name of the object. - `java.lang.String`"
  (^java.lang.String [^FileDataSource this]
    (-> this (.getName))))

(defn get-file
  "Return the File object that corresponds to this FileDataSource.

  returns: the File object for the file represented by this object. - `java.io.File`"
  (^java.io.File [^FileDataSource this]
    (-> this (.getFile))))

(defn set-file-type-map
  "Set the FileTypeMap to use with this FileDataSource

  map - The FileTypeMap for this object. - `javax.activation.FileTypeMap`"
  ([^FileDataSource this ^javax.activation.FileTypeMap map]
    (-> this (.setFileTypeMap map))))

