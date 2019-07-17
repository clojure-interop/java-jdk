(ns javax.swing.text.html.HTMLWriter
  "This is a writer for HTMLDocuments."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html HTMLWriter]))

(defn ->html-writer
  "Constructor.

  Creates a new HTMLWriter.

  w - a Writer - `java.io.Writer`
  doc - an HTMLDocument - `javax.swing.text.html.HTMLDocument`
  pos - the document location from which to fetch the content - `int`
  len - the amount to write out - `int`"
  ([w doc pos len]
    (new HTMLWriter w doc pos len))
  ([w doc]
    (new HTMLWriter w doc)))

(defn write
  "Iterates over the
   Element tree and controls the writing out of
   all the tags and its attributes.

  throws: java.io.IOException - on any I/O error"
  ([this]
    (-> this (.write))))

