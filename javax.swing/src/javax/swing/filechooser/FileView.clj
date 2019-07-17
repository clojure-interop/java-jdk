(ns javax.swing.filechooser.FileView
  "FileView defines an abstract class that can be implemented
  to provide the filechooser with UI information for a File.
  Each L&F JFileChooserUI object implements this
  class to pass back the correct icons and type descriptions specific to
  that L&F. For example, the Microsoft Windows L&F returns the
  generic Windows icons for directories and generic files.
  Additionally, you may want to provide your own FileView to
  JFileChooser to return different icons or additional
  information using JFileChooser.setFileView(javax.swing.filechooser.FileView).



  JFileChooser first looks to see if there is a user defined
  FileView, if there is, it gets type information from
  there first. If FileView returns null for
  any method, JFileChooser then uses the L&F specific
  view to get the information.
  So, for example, if you provide a FileView class that
  returns an Icon for JPG files, and returns null
  icons for all other files, the UI's FileView will provide
  default icons for all other files.



  For an example implementation of a simple file view, see
  yourJDK/demo/jfc/FileChooserDemo/ExampleFileView.java.
  For more information and examples see
  How to Use File Choosers,
  a section in The Java Tutorial."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.filechooser FileView]))

(defn ->file-view
  "Constructor."
  ([]
    (new FileView )))

(defn get-name
  "The name of the file. Normally this would be simply
   f.getName().

  f - `java.io.File`

  returns: `java.lang.String`"
  ([this f]
    (-> this (.getName f))))

(defn get-description
  "A human readable description of the file. For example,
   a file named jag.jpg might have a description that read:
   `A JPEG image file of James Gosling's face`.

  f - `java.io.File`

  returns: `java.lang.String`"
  ([this f]
    (-> this (.getDescription f))))

(defn get-type-description
  "A human readable description of the type of the file. For
   example, a jpg file might have a type description of:
   `A JPEG Compressed Image File`

  f - `java.io.File`

  returns: `java.lang.String`"
  ([this f]
    (-> this (.getTypeDescription f))))

(defn get-icon
  "The icon that represents this file in the JFileChooser.

  f - `java.io.File`

  returns: `javax.swing.Icon`"
  ([this f]
    (-> this (.getIcon f))))

(defn traversable?
  "Whether the directory is traversable or not. This might be
   useful, for example, if you want a directory to represent
   a compound document and don't want the user to descend into it.

  f - `java.io.File`

  returns: `java.lang.Boolean`"
  ([this f]
    (-> this (.isTraversable f))))

