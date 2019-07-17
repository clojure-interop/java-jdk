(ns javax.swing.text.Highlighter$Highlight
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text Highlighter$Highlight]))

(defn get-start-offset
  "Gets the starting model offset for the highlight.

  returns: the starting offset >= 0 - `int`"
  ([^. this]
    (-> this (.getStartOffset))))

(defn get-end-offset
  "Gets the ending model offset for the highlight.

  returns: the ending offset >= 0 - `int`"
  ([^. this]
    (-> this (.getEndOffset))))

(defn get-painter
  "Gets the painter for the highlighter.

  returns: the painter - `javax.swing.text.Highlighter.HighlightPainter`"
  ([^. this]
    (-> this (.getPainter))))

