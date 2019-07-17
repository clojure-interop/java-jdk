(ns javax.swing.text.IconView
  "Icon decorator that implements the view interface.  The
  entire element is used to represent the icon.  This acts
  as a gateway from the display-only View implementations to
  interactive lightweight icons (that is, it allows icons
  to be embedded into the View hierarchy.  The parent of the icon
  is the container that is handed out by the associated view
  factory."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text IconView]))

(defn ->icon-view
  "Constructor.

  Creates a new icon view that represents an element.

  elem - the element to create a view for - `javax.swing.text.Element`"
  ([^javax.swing.text.Element elem]
    (new IconView elem)))

(defn paint
  "Paints the icon.
   The real paint behavior occurs naturally from the association
   that the icon has with its parent container (the same
   container hosting this view), so this simply allows us to
   position the icon properly relative to the view.  Since
   the coordinate system for the view is simply the parent
   containers, positioning the child icon is easy.

  g - the rendering surface to use - `java.awt.Graphics`
  a - the allocated region to render into - `java.awt.Shape`"
  ([^javax.swing.text.IconView this ^java.awt.Graphics g ^java.awt.Shape a]
    (-> this (.paint g a))))

(defn get-preferred-span
  "Determines the preferred span for this view along an
   axis.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the span the view would like to be rendered into
             Typically the view is told to render into the span
             that is returned, although there is no guarantee.
             The parent may choose to resize or break the view. - `float`

  throws: java.lang.IllegalArgumentException - for an invalid axis"
  (^Float [^javax.swing.text.IconView this ^Integer axis]
    (-> this (.getPreferredSpan axis))))

(defn get-alignment
  "Determines the desired alignment for this view along an
   axis.  This is implemented to give the alignment to the
   bottom of the icon along the y axis, and the default
   along the x axis.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the desired alignment >= 0.0f && <= 1.0f.  This should be
     a value between 0.0 and 1.0 where 0 indicates alignment at the
     origin and 1.0 indicates alignment to the full span
     away from the origin.  An alignment of 0.5 would be the
     center of the view. - `float`"
  (^Float [^javax.swing.text.IconView this ^Integer axis]
    (-> this (.getAlignment axis))))

(defn model-to-view
  "Provides a mapping from the document model coordinate space
   to the coordinate space of the view mapped to it.

  pos - the position to convert >= 0 - `int`
  a - the allocated region to render into - `java.awt.Shape`
  b - the bias toward the previous character or the next character represented by the offset, in case the position is a boundary of two views; b will have one of these values: Position.Bias.Forward Position.Bias.Backward - `javax.swing.text.Position.Bias`

  returns: the bounding box of the given position - `java.awt.Shape`

  throws: javax.swing.text.BadLocationException - if the given position does not represent a valid location in the associated document"
  (^java.awt.Shape [^javax.swing.text.IconView this ^Integer pos ^java.awt.Shape a ^javax.swing.text.Position.Bias b]
    (-> this (.modelToView pos a b))))

(defn view-to-model
  "Provides a mapping from the view coordinate space to the logical
   coordinate space of the model.

  x - the X coordinate >= 0 - `float`
  y - the Y coordinate >= 0 - `float`
  a - the allocated region to render into - `java.awt.Shape`
  bias - `javax.swing.text.Position.Bias[]`

  returns: the location within the model that best represents the
    given point of view >= 0 - `int`"
  (^Integer [^javax.swing.text.IconView this ^Float x ^Float y ^java.awt.Shape a bias]
    (-> this (.viewToModel x y a bias))))

