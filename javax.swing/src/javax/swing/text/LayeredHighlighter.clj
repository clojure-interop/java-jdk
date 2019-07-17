(ns javax.swing.text.LayeredHighlighter
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text LayeredHighlighter]))

(defn ->layered-highlighter
  "Constructor."
  ([]
    (new LayeredHighlighter )))

(defn paint-layered-highlights
  "When leaf Views (such as LabelView) are rendering they should
   call into this method. If a highlight is in the given region it will
   be drawn immediately.

  g - Graphics used to draw - `java.awt.Graphics`
  p-0 - starting offset of view - `int`
  p-1 - ending offset of view - `int`
  view-bounds - Bounds of View - `java.awt.Shape`
  editor - JTextComponent - `javax.swing.text.JTextComponent`
  view - View instance being rendered - `javax.swing.text.View`"
  ([^javax.swing.text.LayeredHighlighter this ^java.awt.Graphics g ^Integer p-0 ^Integer p-1 ^java.awt.Shape view-bounds ^javax.swing.text.JTextComponent editor ^javax.swing.text.View view]
    (-> this (.paintLayeredHighlights g p-0 p-1 view-bounds editor view))))

