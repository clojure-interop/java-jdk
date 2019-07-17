(ns javax.swing.text.FieldView
  "Extends the multi-line plain text view to be suitable
  for a single-line editor view.  If the view is
  allocated extra space, the field must adjust for it.
  If the hosting component is a JTextField, this view
  will manage the ranges of the associated BoundedRangeModel
  and will adjust the horizontal allocation to match the
  current visibility settings of the JTextField."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text FieldView]))

(defn ->field-view
  "Constructor.

  Constructs a new FieldView wrapped on an element.

  elem - the element - `javax.swing.text.Element`"
  ([^javax.swing.text.Element elem]
    (new FieldView elem)))

(defn paint
  "Renders using the given rendering surface and area on that surface.
   The view may need to do layout and create child views to enable
   itself to render into the given allocation.

  g - the rendering surface to use - `java.awt.Graphics`
  a - the allocated region to render into - `java.awt.Shape`"
  ([^javax.swing.text.FieldView this ^java.awt.Graphics g ^java.awt.Shape a]
    (-> this (.paint g a))))

(defn get-preferred-span
  "Determines the preferred span for this view along an
   axis.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the span the view would like to be rendered into >= 0.
             Typically the view is told to render into the span
             that is returned, although there is no guarantee.
             The parent may choose to resize or break the view. - `float`"
  (^Float [^javax.swing.text.FieldView this ^Integer axis]
    (-> this (.getPreferredSpan axis))))

(defn get-resize-weight
  "Determines the resizability of the view along the
   given axis.  A value of 0 or less is not resizable.

  axis - View.X_AXIS or View.Y_AXIS - `int`

  returns: the weight -> 1 for View.X_AXIS, else 0 - `int`"
  (^Integer [^javax.swing.text.FieldView this ^Integer axis]
    (-> this (.getResizeWeight axis))))

(defn model-to-view
  "Provides a mapping from the document model coordinate space
   to the coordinate space of the view mapped to it.

  pos - the position to convert >= 0 - `int`
  a - the allocated region to render into - `java.awt.Shape`
  b - the bias toward the previous character or the next character represented by the offset, in case the position is a boundary of two views; b will have one of these values: Position.Bias.Forward Position.Bias.Backward - `javax.swing.text.Position.Bias`

  returns: the bounding box of the given position - `java.awt.Shape`

  throws: javax.swing.text.BadLocationException - if the given position does not represent a valid location in the associated document"
  (^java.awt.Shape [^javax.swing.text.FieldView this ^Integer pos ^java.awt.Shape a ^javax.swing.text.Position.Bias b]
    (-> this (.modelToView pos a b))))

(defn view-to-model
  "Provides a mapping from the view coordinate space to the logical
   coordinate space of the model.

  fx - the X coordinate >= 0.0f - `float`
  fy - the Y coordinate >= 0.0f - `float`
  a - the allocated region to render into - `java.awt.Shape`
  bias - `javax.swing.text.Position.Bias[]`

  returns: the location within the model that best represents the
    given point in the view - `int`"
  (^Integer [^javax.swing.text.FieldView this ^Float fx ^Float fy ^java.awt.Shape a bias]
    (-> this (.viewToModel fx fy a bias))))

(defn insert-update
  "Gives notification that something was inserted into the document
   in a location that this view is responsible for.

  changes - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.FieldView this ^javax.swing.event.DocumentEvent changes ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.insertUpdate changes a f))))

(defn remove-update
  "Gives notification that something was removed from the document
   in a location that this view is responsible for.

  changes - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.FieldView this ^javax.swing.event.DocumentEvent changes ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.removeUpdate changes a f))))

