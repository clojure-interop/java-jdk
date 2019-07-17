(ns javax.activation.MimetypesFileTypeMap
  "This class extends FileTypeMap and provides data typing of files
  via their file extension. It uses the .mime.types format.

  MIME types file search order:
  The MimetypesFileTypeMap looks in various places in the user's
  system for MIME types file entries. When requests are made
  to search for MIME types in the MimetypesFileTypeMap, it searches
  MIME types files in the following order:


   Programmatically added entries to the MimetypesFileTypeMap instance.
   The file .mime.types in the user's home directory.
   The file <java.home>/lib/mime.types.
   The file or resources named META-INF/mime.types.
   The file or resource named META-INF/mimetypes.default
  (usually found only in the activation.jar file).


  MIME types file format:


  # comments begin with a '#'
  # the format is <mime type> <space separated file extensions>
  # for example:
  text/plain    txt text TXT
  # this would map file.txt, file.text, and file.TXT to
  # the mime type `text/plain`"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.activation MimetypesFileTypeMap]))

(defn ->mimetypes-file-type-map
  "Constructor.

  Construct a MimetypesFileTypeMap with programmatic entries
   added from the named file.

  mime-type-file-name - the file name - `java.lang.String`

  throws: java.io.IOException"
  ([^java.lang.String mime-type-file-name]
    (new MimetypesFileTypeMap mime-type-file-name))
  ([]
    (new MimetypesFileTypeMap )))

(defn add-mime-types
  "Prepend the MIME type values to the registry.

  mime-types - A .mime.types formatted string of entries. - `java.lang.String`"
  ([^javax.activation.MimetypesFileTypeMap this ^java.lang.String mime-types]
    (-> this (.addMimeTypes mime-types))))

(defn get-content-type
  "Return the MIME type of the file object.
   The implementation in this class calls
   getContentType(f.getName()).

  f - the file - `java.io.File`

  returns: the file's MIME type - `java.lang.String`"
  (^java.lang.String [^javax.activation.MimetypesFileTypeMap this ^java.io.File f]
    (-> this (.getContentType f))))

