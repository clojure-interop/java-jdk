(ns javax.swing.text.html.BlockView
  "A view implementation to display a block (as a box)
  with CSS specifications."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html BlockView]))

(defn ->block-view
  "Constructor.

  Creates a new view that represents an
   html box.  This can be used for a number
   of elements.

  elem - the element to create a view for - `javax.swing.text.Element`
  axis - either View.X_AXIS or View.Y_AXIS - `int`"
  ([elem axis]
    (new BlockView elem axis)))

(defn changed-update
  "Description copied from class: View

  changes - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([this changes a f]
    (-> this (.changedUpdate changes a f))))

(defn set-parent
  "Establishes the parent view for this view.  This is
   guaranteed to be called before any other methods if the
   parent view is functioning properly.

   This is implemented
   to forward to the superclass as well as call the
   setPropertiesFromAttributes()
   method to set the paragraph properties from the css
   attributes.  The call is made at this time to ensure
   the ability to resolve upward through the parents
   view attributes.

  parent - the new parent, or null if the view is being removed from a parent it was previously added to - `javax.swing.text.View`"
  ([this parent]
    (-> this (.setParent parent))))

(defn get-preferred-span
  "Determines the preferred span for this view along an
   axis.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the span the view would like to be rendered into >= 0;
             typically the view is told to render into the span
             that is returned, although there is no guarantee;
             the parent may choose to resize or break the view - `float`

  throws: java.lang.IllegalArgumentException - for an invalid axis type"
  ([this axis]
    (-> this (.getPreferredSpan axis))))

(defn get-minimum-span
  "Determines the minimum span for this view along an
   axis.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the span the view would like to be rendered into >= 0;
             typically the view is told to render into the span
             that is returned, although there is no guarantee;
             the parent may choose to resize or break the view - `float`

  throws: java.lang.IllegalArgumentException - for an invalid axis type"
  ([this axis]
    (-> this (.getMinimumSpan axis))))

(defn get-maximum-span
  "Determines the maximum span for this view along an
   axis.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the span the view would like to be rendered into >= 0;
             typically the view is told to render into the span
             that is returned, although there is no guarantee;
             the parent may choose to resize or break the view - `float`

  throws: java.lang.IllegalArgumentException - for an invalid axis type"
  ([this axis]
    (-> this (.getMaximumSpan axis))))

(defn paint
  "Renders using the given rendering surface and area on that
   surface.  This is implemented to delegate to the css box
   painter to paint the border and background prior to the
   interior.

  g - the rendering surface to use - `java.awt.Graphics`
  allocation - the allocated region to render into - `java.awt.Shape`"
  ([this g allocation]
    (-> this (.paint g allocation))))

(defn get-alignment
  "Gets the alignment.

  axis - may be either X_AXIS or Y_AXIS - `int`

  returns: the alignment - `float`"
  ([this axis]
    (-> this (.getAlignment axis))))

(defn get-resize-weight
  "Gets the resize weight.

  axis - may be either X_AXIS or Y_AXIS - `int`

  returns: the weight - `int`

  throws: java.lang.IllegalArgumentException - for an invalid axis"
  ([this axis]
    (-> this (.getResizeWeight axis))))

(defn get-attributes
  "Fetches the attributes to use when rendering.  This is
   implemented to multiplex the attributes specified in the
   model with a StyleSheet.

  returns: `javax.swing.text.AttributeSet`"
  ([this]
    (-> this (.getAttributes))))

