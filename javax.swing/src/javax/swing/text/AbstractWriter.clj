(ns javax.swing.text.AbstractWriter
  "AbstractWriter is an abstract class that actually
  does the work of writing out the element tree
  including the attributes.  In terms of how much is
  written out per line, the writer defaults to 100.
  But this value can be set by subclasses."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text AbstractWriter]))

(defn get-start-offset
  "Returns the first offset to be output.

  returns: `int`"
  ([this]
    (-> this (.getStartOffset))))

(defn get-end-offset
  "Returns the last offset to be output.

  returns: `int`"
  ([this]
    (-> this (.getEndOffset))))

(defn set-line-separator
  "Sets the String used to represent newlines. This is initialized
   in the constructor from either the Document, or the System property
   line.separator.

  value - `java.lang.String`"
  ([this value]
    (-> this (.setLineSeparator value))))

(defn get-line-separator
  "Returns the string used to represent newlines.

  returns: `java.lang.String`"
  ([this]
    (-> this (.getLineSeparator))))

