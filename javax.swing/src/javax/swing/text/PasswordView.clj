(ns javax.swing.text.PasswordView
  "Implements a View suitable for use in JPasswordField
  UI implementations.  This is basically a field ui that
  renders its contents as the echo character specified
  in the associated component (if it can narrow the
  component to a JPasswordField)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text PasswordView]))

(defn ->password-view
  "Constructor.

  Constructs a new view wrapped on an element.

  elem - the element - `javax.swing.text.Element`"
  ([elem]
    (new PasswordView elem)))

(defn model-to-view
  "Provides a mapping from the document model coordinate space
   to the coordinate space of the view mapped to it.

  pos - the position to convert >= 0 - `int`
  a - the allocated region to render into - `java.awt.Shape`
  b - the bias toward the previous character or the next character represented by the offset, in case the position is a boundary of two views; b will have one of these values: Position.Bias.Forward Position.Bias.Backward - `javax.swing.text.Position.Bias`

  returns: the bounding box of the given position - `java.awt.Shape`

  throws: javax.swing.text.BadLocationException - if the given position does not represent a valid location in the associated document"
  ([this pos a b]
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
  ([this fx fy a bias]
    (-> this (.viewToModel fx fy a bias))))

(defn get-preferred-span
  "Determines the preferred span for this view along an
   axis.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the span the view would like to be rendered into >= 0.
             Typically the view is told to render into the span
             that is returned, although there is no guarantee.
             The parent may choose to resize or break the view. - `float`"
  ([this axis]
    (-> this (.getPreferredSpan axis))))

