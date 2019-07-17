(ns javax.swing.text.GlyphView$GlyphPainter
  "A class to perform rendering of the glyphs.
  This can be implemented to be stateless, or
  to hold some information as a cache to
  facilitate faster rendering and model/view
  translation.  At a minimum, the GlyphPainter
  allows a View implementation to perform its
  duties independant of a particular version
  of JVM and selection of capabilities (i.e.
  shaping for i18n, etc)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text GlyphView$GlyphPainter]))

(defn ->glyph-painter
  "Constructor."
  ([]
    (new GlyphView$GlyphPainter )))

(defn get-painter
  "Create a painter to use for the given GlyphView.  If
   the painter carries state it can create another painter
   to represent a new GlyphView that is being created.  If
   the painter doesn't hold any significant state, it can
   return itself.  The default behavior is to return itself.

  v - the GlyphView to provide a painter for - `javax.swing.text.GlyphView`
  p-0 - the starting document offset >= 0 - `int`
  p-1 - the ending document offset >= p0 - `int`

  returns: `javax.swing.text.GlyphView.GlyphPainter`"
  (^javax.swing.text.GlyphView.GlyphPainter [^javax.swing.text.GlyphView$GlyphPainter this ^javax.swing.text.GlyphView v ^Integer p-0 ^Integer p-1]
    (-> this (.getPainter v p-0 p-1))))

(defn get-ascent
  "v - `javax.swing.text.GlyphView`

  returns: `float`"
  (^Float [^javax.swing.text.GlyphView$GlyphPainter this ^javax.swing.text.GlyphView v]
    (-> this (.getAscent v))))

(defn get-descent
  "v - `javax.swing.text.GlyphView`

  returns: `float`"
  (^Float [^javax.swing.text.GlyphView$GlyphPainter this ^javax.swing.text.GlyphView v]
    (-> this (.getDescent v))))

(defn get-height
  "v - `javax.swing.text.GlyphView`

  returns: `float`"
  (^Float [^javax.swing.text.GlyphView$GlyphPainter this ^javax.swing.text.GlyphView v]
    (-> this (.getHeight v))))

(defn paint
  "Paint the glyphs representing the given range.

  v - `javax.swing.text.GlyphView`
  g - `java.awt.Graphics`
  a - `java.awt.Shape`
  p-0 - `int`
  p-1 - `int`"
  ([^javax.swing.text.GlyphView$GlyphPainter this ^javax.swing.text.GlyphView v ^java.awt.Graphics g ^java.awt.Shape a ^Integer p-0 ^Integer p-1]
    (-> this (.paint v g a p-0 p-1))))

(defn get-bounded-position
  "Determines the model location that represents the
   maximum advance that fits within the given span.
   This could be used to break the given view.  The result
   should be a location just shy of the given advance.  This
   differs from viewToModel which returns the closest
   position which might be proud of the maximum advance.

  v - the view to find the model location to break at. - `javax.swing.text.GlyphView`
  p-0 - the location in the model where the fragment should start it's representation >= 0. - `int`
  x - the graphic location along the axis that the broken view would occupy >= 0. This may be useful for things like tab calculations. - `float`
  len - specifies the distance into the view where a potential break is desired >= 0. - `float`

  returns: the maximum model location possible for a break. - `int`"
  (^Integer [^javax.swing.text.GlyphView$GlyphPainter this ^javax.swing.text.GlyphView v ^Integer p-0 ^Float x ^Float len]
    (-> this (.getBoundedPosition v p-0 x len))))

(defn view-to-model
  "Provides a mapping from the view coordinate space to the logical
   coordinate space of the model.

  v - the GlyphView to provide a mapping for - `javax.swing.text.GlyphView`
  x - the X coordinate - `float`
  y - the Y coordinate - `float`
  a - the allocated region to render into - `java.awt.Shape`
  bias-return - either Position.Bias.Forward or Position.Bias.Backward is returned as the zero-th element of this array - `javax.swing.text.Position.Bias[]`

  returns: the location within the model that best represents the
           given point of view - `int`"
  (^Integer [^javax.swing.text.GlyphView$GlyphPainter this ^javax.swing.text.GlyphView v ^Float x ^Float y ^java.awt.Shape a bias-return]
    (-> this (.viewToModel v x y a bias-return))))

(defn get-span
  "Determine the span the glyphs given a start location
   (for tab expansion).

  v - `javax.swing.text.GlyphView`
  p-0 - `int`
  p-1 - `int`
  e - `javax.swing.text.TabExpander`
  x - `float`

  returns: `float`"
  (^Float [^javax.swing.text.GlyphView$GlyphPainter this ^javax.swing.text.GlyphView v ^Integer p-0 ^Integer p-1 ^javax.swing.text.TabExpander e ^Float x]
    (-> this (.getSpan v p-0 p-1 e x))))

(defn model-to-view
  "Provides a mapping from the document model coordinate space
   to the coordinate space of the view mapped to it.
   This is shared by the broken views.

  v - the GlyphView containing the destination coordinate space - `javax.swing.text.GlyphView`
  pos - the position to convert - `int`
  bias - either Position.Bias.Forward or Position.Bias.Backward - `javax.swing.text.Position.Bias`
  a - Bounds of the View - `java.awt.Shape`

  returns: the bounding box of the given position - `java.awt.Shape`

  throws: javax.swing.text.BadLocationException - if the given position does not represent a valid location in the associated document"
  (^java.awt.Shape [^javax.swing.text.GlyphView$GlyphPainter this ^javax.swing.text.GlyphView v ^Integer pos ^javax.swing.text.Position.Bias bias ^java.awt.Shape a]
    (-> this (.modelToView v pos bias a))))

(defn get-next-visual-position-from
  "Provides a way to determine the next visually represented model
   location that one might place a caret.  Some views may not be
   visible, they might not be in the same order found in the model, or
   they just might not allow access to some of the locations in the
   model.

  v - the view to use - `javax.swing.text.GlyphView`
  pos - the position to convert >= 0 - `int`
  b - either Position.Bias.Forward or Position.Bias.Backward - `javax.swing.text.Position.Bias`
  a - the allocated region to render into - `java.awt.Shape`
  direction - the direction from the current position that can be thought of as the arrow keys typically found on a keyboard. This may be SwingConstants.WEST, SwingConstants.EAST, SwingConstants.NORTH, or SwingConstants.SOUTH. - `int`
  bias-ret - either Position.Bias.Forward or Position.Bias.Backward is returned as the zero-th element of this array - `javax.swing.text.Position.Bias[]`

  returns: the location within the model that best represents the next
    location visual position. - `int`

  throws: javax.swing.text.BadLocationException"
  (^Integer [^javax.swing.text.GlyphView$GlyphPainter this ^javax.swing.text.GlyphView v ^Integer pos ^javax.swing.text.Position.Bias b ^java.awt.Shape a ^Integer direction bias-ret]
    (-> this (.getNextVisualPositionFrom v pos b a direction bias-ret))))

