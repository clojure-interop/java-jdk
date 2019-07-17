(ns javax.swing.text.html.StyleSheet$ListPainter
  "Class to carry out some of the duties of CSS list
  formatting.  Implementations of this
  class enable views to present the CSS formatting
  while not knowing anything about how the CSS values
  are being cached."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html StyleSheet$ListPainter]))

(defn paint
  "Paints the CSS list decoration according to the
   attributes given.

  g - the rendering surface. - `java.awt.Graphics`
  x - the x coordinate of the list item allocation - `float`
  y - the y coordinate of the list item allocation - `float`
  w - the width of the list item allocation - `float`
  h - the height of the list item allocation - `float`
  v - the allocated area to paint into. - `javax.swing.text.View`
  item - which list item is being painted. This is a number greater than or equal to 0. - `int`"
  ([^javax.swing.text.html.StyleSheet$ListPainter this ^java.awt.Graphics g ^Float x ^Float y ^Float w ^Float h ^javax.swing.text.View v ^Integer item]
    (-> this (.paint g x y w h v item))))

