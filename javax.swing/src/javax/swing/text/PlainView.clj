(ns javax.swing.text.PlainView
  "Implements View interface for a simple multi-line text view
  that has text in one font and color.  The view represents each
  child element as a line of text."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text PlainView]))

(defn ->plain-view
  "Constructor.

  Constructs a new PlainView wrapped on an element.

  elem - the element - `javax.swing.text.Element`"
  ([^javax.swing.text.Element elem]
    (new PlainView elem)))

(defn changed-update
  "Gives notification from the document that attributes were changed
   in a location that this view is responsible for.

  changes - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.PlainView this ^javax.swing.event.DocumentEvent changes ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.changedUpdate changes a f))))

(defn get-preferred-span
  "Determines the preferred span for this view along an
   axis.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the span the view would like to be rendered into >= 0.
             Typically the view is told to render into the span
             that is returned, although there is no guarantee.
             The parent may choose to resize or break the view. - `float`

  throws: java.lang.IllegalArgumentException - for an invalid axis"
  (^Float [^javax.swing.text.PlainView this ^Integer axis]
    (-> this (.getPreferredSpan axis))))

(defn remove-update
  "Gives notification that something was removed from the document
   in a location that this view is responsible for.

  changes - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.PlainView this ^javax.swing.event.DocumentEvent changes ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.removeUpdate changes a f))))

(defn insert-update
  "Gives notification that something was inserted into the document
   in a location that this view is responsible for.

  changes - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.PlainView this ^javax.swing.event.DocumentEvent changes ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.insertUpdate changes a f))))

(defn paint
  "Renders using the given rendering surface and area on that surface.
   The view may need to do layout and create child views to enable
   itself to render into the given allocation.

  g - the rendering surface to use - `java.awt.Graphics`
  a - the allocated region to render into - `java.awt.Shape`"
  ([^javax.swing.text.PlainView this ^java.awt.Graphics g ^java.awt.Shape a]
    (-> this (.paint g a))))

(defn next-tab-stop
  "Returns the next tab stop position after a given reference position.
   This implementation does not support things like centering so it
   ignores the tabOffset argument.

  x - the current position >= 0 - `float`
  tab-offset - the position within the text stream that the tab occurred at >= 0. - `int`

  returns: the tab stop, measured in points >= 0 - `float`"
  (^Float [^javax.swing.text.PlainView this ^Float x ^Integer tab-offset]
    (-> this (.nextTabStop x tab-offset))))

(defn set-size
  "Sets the size of the view.  This should cause
   layout of the view along the given axis, if it
   has any layout duties.

  width - the width >= 0 - `float`
  height - the height >= 0 - `float`"
  ([^javax.swing.text.PlainView this ^Float width ^Float height]
    (-> this (.setSize width height))))

(defn view-to-model
  "Provides a mapping from the view coordinate space to the logical
   coordinate space of the model.

  fx - the X coordinate >= 0 - `float`
  fy - the Y coordinate >= 0 - `float`
  a - the allocated region to render into - `java.awt.Shape`
  bias - `javax.swing.text.Position.Bias[]`

  returns: the location within the model that best represents the
    given point in the view >= 0 - `int`"
  (^Integer [^javax.swing.text.PlainView this ^Float fx ^Float fy ^java.awt.Shape a bias]
    (-> this (.viewToModel fx fy a bias))))

(defn model-to-view
  "Provides a mapping from the document model coordinate space
   to the coordinate space of the view mapped to it.

  pos - the position to convert >= 0 - `int`
  a - the allocated region to render into - `java.awt.Shape`
  b - the bias toward the previous character or the next character represented by the offset, in case the position is a boundary of two views; b will have one of these values: Position.Bias.Forward Position.Bias.Backward - `javax.swing.text.Position.Bias`

  returns: the bounding box of the given position - `java.awt.Shape`

  throws: javax.swing.text.BadLocationException - if the given position does not represent a valid location in the associated document"
  (^java.awt.Shape [^javax.swing.text.PlainView this ^Integer pos ^java.awt.Shape a ^javax.swing.text.Position.Bias b]
    (-> this (.modelToView pos a b))))

