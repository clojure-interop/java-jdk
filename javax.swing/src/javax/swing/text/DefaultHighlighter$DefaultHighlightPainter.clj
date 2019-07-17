(ns javax.swing.text.DefaultHighlighter$DefaultHighlightPainter
  "Simple highlight painter that fills a highlighted area with
  a solid color."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text DefaultHighlighter$DefaultHighlightPainter]))

(defn ->default-highlight-painter
  "Constructor.

  Constructs a new highlight painter. If c is null,
   the JTextComponent will be queried for its selection color.

  c - the color for the highlight - `java.awt.Color`"
  ([^java.awt.Color c]
    (new DefaultHighlighter$DefaultHighlightPainter c)))

(defn get-color
  "Returns the color of the highlight.

  returns: the color - `java.awt.Color`"
  ([^javax.swing.text.DefaultHighlighter$DefaultHighlightPainter this]
    (-> this (.getColor))))

(defn paint
  "Paints a highlight.

  g - the graphics context - `java.awt.Graphics`
  offs-0 - the starting model offset >= 0 - `int`
  offs-1 - the ending model offset >= offs1 - `int`
  bounds - the bounding box for the highlight - `java.awt.Shape`
  c - the editor - `javax.swing.text.JTextComponent`"
  ([^javax.swing.text.DefaultHighlighter$DefaultHighlightPainter this ^java.awt.Graphics g ^Integer offs-0 ^Integer offs-1 ^java.awt.Shape bounds ^javax.swing.text.JTextComponent c]
    (-> this (.paint g offs-0 offs-1 bounds c))))

(defn paint-layer
  "Paints a portion of a highlight.

  g - the graphics context - `java.awt.Graphics`
  offs-0 - the starting model offset >= 0 - `int`
  offs-1 - the ending model offset >= offs1 - `int`
  bounds - the bounding box of the view, which is not necessarily the region to paint. - `java.awt.Shape`
  c - the editor - `javax.swing.text.JTextComponent`
  view - View painting for - `javax.swing.text.View`

  returns: region drawing occurred in - `java.awt.Shape`"
  ([^javax.swing.text.DefaultHighlighter$DefaultHighlightPainter this ^java.awt.Graphics g ^Integer offs-0 ^Integer offs-1 ^java.awt.Shape bounds ^javax.swing.text.JTextComponent c ^javax.swing.text.View view]
    (-> this (.paintLayer g offs-0 offs-1 bounds c view))))

