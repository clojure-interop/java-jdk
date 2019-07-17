(ns javax.activation.FileTypeMap
  "The FileTypeMap is an abstract class that provides a data typing
  interface for files. Implementations of this class will
  implement the getContentType methods which will derive a content
  type from a file name or a File object. FileTypeMaps could use any
  scheme to determine the data type, from examining the file extension
  of a file (like the MimetypesFileTypeMap) to opening the file and
  trying to derive its type from the contents of the file. The
  FileDataSource class uses the default FileTypeMap (a MimetypesFileTypeMap
  unless changed) to determine the content type of files."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.activation FileTypeMap]))

(defn ->file-type-map
  "Constructor.

  The default constructor."
  ([]
    (new FileTypeMap )))

(defn *set-default-file-type-map
  "Sets the default FileTypeMap for the system. This instance
   will be returned to callers of getDefaultFileTypeMap.

  file-type-map - The FileTypeMap. - `javax.activation.FileTypeMap`

  throws: java.lang.SecurityException - if the caller doesn't have permission to change the default"
  ([^javax.activation.FileTypeMap file-type-map]
    (FileTypeMap/setDefaultFileTypeMap file-type-map)))

(defn *get-default-file-type-map
  "Return the default FileTypeMap for the system.
   If setDefaultFileTypeMap was called, return
   that instance, otherwise return an instance of
   MimetypesFileTypeMap.

  returns: The default FileTypeMap - `javax.activation.FileTypeMap`"
  ([]
    (FileTypeMap/getDefaultFileTypeMap )))

(defn get-content-type
  "Return the type of the file object. This method should
   always return a valid MIME type.

  file - A file to be typed. - `java.io.File`

  returns: The content type. - `java.lang.String`"
  ([^javax.activation.FileTypeMap this ^java.io.File file]
    (-> this (.getContentType file))))

