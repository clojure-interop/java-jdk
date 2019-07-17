(ns javax.swing.text.LayeredHighlighter$LayerPainter
  "Layered highlight renderer."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text LayeredHighlighter$LayerPainter]))

(defn ->layer-painter
  "Constructor."
  ([]
    (new LayeredHighlighter$LayerPainter )))

(defn paint-layer
  "g - `java.awt.Graphics`
  p-0 - `int`
  p-1 - `int`
  view-bounds - `java.awt.Shape`
  editor - `javax.swing.text.JTextComponent`
  view - `javax.swing.text.View`

  returns: `java.awt.Shape`"
  (^java.awt.Shape [^javax.swing.text.LayeredHighlighter$LayerPainter this ^java.awt.Graphics g ^Integer p-0 ^Integer p-1 ^java.awt.Shape view-bounds ^javax.swing.text.JTextComponent editor ^javax.swing.text.View view]
    (-> this (.paintLayer g p-0 p-1 view-bounds editor view))))

