(ns javax.swing.filechooser.FileNameExtensionFilter
  "An implementation of FileFilter that filters using a
  specified set of extensions. The extension for a file is the
  portion of the file name after the last \".\". Files whose name does
  not contain a \".\" have no file name extension. File name extension
  comparisons are case insensitive.

  The following example creates a
  FileNameExtensionFilter that will show jpg files:


  FileFilter filter = new FileNameExtensionFilter(\"JPEG file\", \"jpg\", \"jpeg\");
  JFileChooser fileChooser = ...;
  fileChooser.addChoosableFileFilter(filter);"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.filechooser FileNameExtensionFilter]))

(defn ->file-name-extension-filter
  "Constructor.

  Creates a FileNameExtensionFilter with the specified
   description and file name extensions. The returned FileNameExtensionFilter will accept all directories and any
   file with a file name extension contained in extensions.

  description - textual description for the filter, may be null - `java.lang.String`
  extensions - the accepted file name extensions - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if extensions is null, empty, contains null, or contains an empty string"
  (^FileNameExtensionFilter [^java.lang.String description ^java.lang.String extensions]
    (new FileNameExtensionFilter description extensions)))

(defn accept
  "Tests the specified file, returning true if the file is
   accepted, false otherwise. True is returned if the extension
   matches one of the file name extensions of this FileFilter, or the file is a directory.

  f - the File to test - `java.io.File`

  returns: true if the file is to be accepted, false otherwise - `boolean`"
  (^Boolean [^FileNameExtensionFilter this ^java.io.File f]
    (-> this (.accept f))))

(defn get-description
  "The description of this filter. For example: \"JPG and GIF Images.\"

  returns: the description of this filter - `java.lang.String`"
  (^java.lang.String [^FileNameExtensionFilter this]
    (-> this (.getDescription))))

(defn get-extensions
  "Returns the set of file name extensions files are tested against.

  returns: the set of file name extensions files are tested against - `java.lang.String[]`"
  ([^FileNameExtensionFilter this]
    (-> this (.getExtensions))))

(defn to-string
  "Returns a string representation of the FileNameExtensionFilter.
   This method is intended to be used for debugging purposes,
   and the content and format of the returned string may vary
   between implementations.

  returns: a string representation of this FileNameExtensionFilter - `java.lang.String`"
  (^java.lang.String [^FileNameExtensionFilter this]
    (-> this (.toString))))

