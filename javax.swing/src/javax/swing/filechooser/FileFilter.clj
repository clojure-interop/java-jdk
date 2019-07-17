(ns javax.swing.filechooser.FileFilter
  "FileFilter is an abstract class used by JFileChooser
  for filtering the set of files shown to the user. See
  FileNameExtensionFilter for an implementation that filters using
  the file name extension.

  A FileFilter
  can be set on a JFileChooser to
  keep unwanted files from appearing in the directory listing.
  For an example implementation of a simple file filter, see
  yourJDK/demo/jfc/FileChooserDemo/ExampleFileFilter.java.
  For more information and examples see
  How to Use File Choosers,
  a section in The Java Tutorial."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.filechooser FileFilter]))

(defn ->file-filter
  "Constructor."
  ([]
    (new FileFilter )))

(defn accept
  "Whether the given file is accepted by this filter.

  f - `java.io.File`

  returns: `boolean`"
  ([^javax.swing.filechooser.FileFilter this ^java.io.File f]
    (-> this (.accept f))))

(defn get-description
  "The description of this filter. For example: `JPG and GIF Images`

  returns: `java.lang.String`"
  ([^javax.swing.filechooser.FileFilter this]
    (-> this (.getDescription))))

