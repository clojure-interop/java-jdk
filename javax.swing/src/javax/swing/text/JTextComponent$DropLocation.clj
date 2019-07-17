(ns javax.swing.text.JTextComponent$DropLocation
  "Represents a drop location for JTextComponents."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text JTextComponent$DropLocation]))

(defn get-index
  "Returns the index where dropped data should be inserted into the
   associated component. This index represents a position between
   characters, as would be interpreted by a caret.

  returns: the drop index - `int`"
  (^Integer [^javax.swing.text.JTextComponent$DropLocation this]
    (-> this (.getIndex))))

(defn get-bias
  "Returns the bias for the drop index.

  returns: the drop bias - `javax.swing.text.Position.Bias`"
  (^javax.swing.text.Position.Bias [^javax.swing.text.JTextComponent$DropLocation this]
    (-> this (.getBias))))

(defn to-string
  "Returns a string representation of this drop location.
   This method is intended to be used for debugging purposes,
   and the content and format of the returned string may vary
   between implementations.

  returns: a string representation of this drop location - `java.lang.String`"
  (^java.lang.String [^javax.swing.text.JTextComponent$DropLocation this]
    (-> this (.toString))))

