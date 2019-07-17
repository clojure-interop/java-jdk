(ns javax.accessibility.AccessibleStreamable
  "The AccessibleStreamable interface should be implemented
  by the AccessibleContext of any component that presents the
  raw stream behind a component on the display screen.  Examples of such
  components are HTML, bitmap images and MathML.  An object that implements
  AccessibleStreamable provides two things: a list of MIME
  types supported by the object and a streaming interface for each MIME type to
  get the data."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleStreamable]))

(defn get-mime-types
  "Returns an array of DataFlavor objects for the MIME types
   this object supports.

  returns: an array of DataFlavor objects for the MIME types
   this object supports. - `java.awt.datatransfer.DataFlavor[]`"
  ([^javax.accessibility.AccessibleStreamable this]
    (-> this (.getMimeTypes))))

(defn get-stream
  "Returns an InputStream for a DataFlavor

  flavor - the DataFlavor - `java.awt.datatransfer.DataFlavor`

  returns: an ImputStream if an ImputStream for this DataFlavor exists.
   Otherwise, null is returned. - `java.io.InputStream`"
  ([^javax.accessibility.AccessibleStreamable this ^java.awt.datatransfer.DataFlavor flavor]
    (-> this (.getStream flavor))))

