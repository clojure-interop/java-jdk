(ns javax.swing.text.Highlighter$HighlightPainter
  "Highlight renderer."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text Highlighter$HighlightPainter]))

(defn paint
  "Renders the highlight.

  g - the graphics context - `java.awt.Graphics`
  p-0 - the starting offset in the model >= 0 - `int`
  p-1 - the ending offset in the model >= p0 - `int`
  bounds - the bounding box for the highlight - `java.awt.Shape`
  c - the editor - `javax.swing.text.JTextComponent`"
  ([^. this ^java.awt.Graphics g ^Integer p-0 ^Integer p-1 ^java.awt.Shape bounds ^javax.swing.text.JTextComponent c]
    (-> this (.paint g p-0 p-1 bounds c))))

