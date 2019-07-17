(ns javax.swing.text.html.StyleSheet$BoxPainter
  "Class to carry out some of the duties of
  CSS formatting.  Implementations of this
  class enable views to present the CSS formatting
  while not knowing anything about how the CSS values
  are being cached.

  As a delegate of Views, this object is responsible for
  the insets of a View and making sure the background
  is maintained according to the CSS attributes."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html StyleSheet$BoxPainter]))

(defn get-inset
  "Fetches the inset needed on a given side to
   account for the margin, border, and padding.

  side - The size of the box to fetch the inset for. This can be View.TOP, View.LEFT, View.BOTTOM, or View.RIGHT. - `int`
  v - the view making the request. This is used to get the AttributeSet, and may be used to resolve percentage arguments. - `javax.swing.text.View`

  returns: `float`

  throws: java.lang.IllegalArgumentException - for an invalid direction"
  ([^javax.swing.text.html.StyleSheet$BoxPainter this ^Integer side ^javax.swing.text.View v]
    (-> this (.getInset side v))))

(defn paint
  "Paints the CSS box according to the attributes
   given.  This should paint the border, padding,
   and background.

  g - the rendering surface. - `java.awt.Graphics`
  x - the x coordinate of the allocated area to render into. - `float`
  y - the y coordinate of the allocated area to render into. - `float`
  w - the width of the allocated area to render into. - `float`
  h - the height of the allocated area to render into. - `float`
  v - the view making the request. This is used to get the AttributeSet, and may be used to resolve percentage arguments. - `javax.swing.text.View`"
  ([^javax.swing.text.html.StyleSheet$BoxPainter this ^java.awt.Graphics g ^Float x ^Float y ^Float w ^Float h ^javax.swing.text.View v]
    (-> this (.paint g x y w h v))))

