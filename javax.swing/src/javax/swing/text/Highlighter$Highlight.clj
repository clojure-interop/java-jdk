(ns javax.swing.text.Highlighter$Highlight
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text Highlighter$Highlight]))

(defn get-start-offset
  "Gets the starting model offset for the highlight.

  returns: the starting offset >= 0 - `int`"
  ([^javax.swing.text.Highlighter$Highlight this]
    (-> this (.getStartOffset))))

(defn get-end-offset
  "Gets the ending model offset for the highlight.

  returns: the ending offset >= 0 - `int`"
  ([^javax.swing.text.Highlighter$Highlight this]
    (-> this (.getEndOffset))))

(defn get-painter
  "Gets the painter for the highlighter.

  returns: the painter - `javax.swing.text.Highlighter.HighlightPainter`"
  ([^javax.swing.text.Highlighter$Highlight this]
    (-> this (.getPainter))))

