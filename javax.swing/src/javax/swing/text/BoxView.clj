(ns javax.swing.text.BoxView
  "A view that arranges its children into a box shape by tiling
  its children along an axis.  The box is somewhat like that
  found in TeX where there is alignment of the
  children, flexibility of the children is considered, etc.
  This is a building block that might be useful to represent
  things like a collection of lines, paragraphs,
  lists, columns, pages, etc.  The axis along which the children are tiled is
  considered the major axis.  The orthogonal axis is the minor axis.

  Layout for each axis is handled separately by the methods
  layoutMajorAxis and layoutMinorAxis.
  Subclasses can change the layout algorithm by
  reimplementing these methods.    These methods will be called
  as necessary depending upon whether or not there is cached
  layout information and the cache is considered
  valid.  These methods are typically called if the given size
  along the axis changes, or if layoutChanged is
  called to force an updated layout.  The layoutChanged
  method invalidates cached layout information, if there is any.
  The requirements published to the parent view are calculated by
  the methods calculateMajorAxisRequirements
  and  calculateMinorAxisRequirements.
  If the layout algorithm is changed, these methods will
  likely need to be reimplemented."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text BoxView]))

(defn ->box-view
  "Constructor.

  Constructs a BoxView.

  elem - the element this view is responsible for - `javax.swing.text.Element`
  axis - either View.X_AXIS or View.Y_AXIS - `int`"
  ([elem axis]
    (new BoxView elem axis)))

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

(defn get-width
  "Returns the current width of the box.  This is the width that
   it was last allocated.

  returns: the current width of the box - `int`"
  ([this]
    (-> this (.getWidth))))

(defn get-axis
  "Fetches the tile axis property.  This is the axis along which
   the child views are tiled.

  returns: the major axis of the box, either
    View.X_AXIS or View.Y_AXIS - `int`"
  ([this]
    (-> this (.getAxis))))

(defn get-child-allocation
  "Fetches the allocation for the given child view.
   This enables finding out where various views
   are located.  This is implemented to return
   null if the layout is invalid,
   otherwise the superclass behavior is executed.

  index - the index of the child, >= 0 && > getViewCount() - `int`
  a - the allocation to this view - `java.awt.Shape`

  returns: the allocation to the child; or null
            if a is null;
            or null if the layout is invalid - `java.awt.Shape`"
  ([this index a]
    (-> this (.getChildAllocation index a))))

(defn set-axis
  "Sets the tile axis property.  This is the axis along which
   the child views are tiled.

  axis - either View.X_AXIS or View.Y_AXIS - `int`"
  ([this axis]
    (-> this (.setAxis axis))))

(defn replace
  "Invalidates the layout and resizes the cache of
   requests/allocations.  The child allocations can still
   be accessed for the old layout, but the new children
   will have an offset and span of 0.

  index - the starting index into the child views to insert the new views; this should be a value >= 0 and <= getViewCount - `int`
  length - the number of existing child views to remove; This should be a value >= 0 and <= (getViewCount() - offset) - `int`
  elems - the child views to add; this value can be nullto indicate no children are being added (useful to remove) - `javax.swing.text.View[]`"
  ([this index length elems]
    (-> this (.replace index length elems))))

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

(defn get-height
  "Returns the current height of the box.  This is the height that
   it was last allocated.

  returns: the current height of the box - `int`"
  ([this]
    (-> this (.getHeight))))

(defn paint
  "Renders the BoxView using the given
   rendering surface and area
   on that surface.  Only the children that intersect
   the clip bounds of the given Graphics
   will be rendered.

  g - the rendering surface to use - `java.awt.Graphics`
  allocation - the allocated region to render into - `java.awt.Shape`"
  ([this g allocation]
    (-> this (.paint g allocation))))

(defn layout-changed
  "Invalidates the layout along an axis.  This happens
   automatically if the preferences have changed for
   any of the child views.  In some cases the layout
   may need to be recalculated when the preferences
   have not changed.  The layout can be marked as
   invalid by calling this method.  The layout will
   be updated the next time the setSize method
   is called on this view (typically in paint).

  axis - either View.X_AXIS or View.Y_AXIS - `int`"
  ([this axis]
    (-> this (.layoutChanged axis))))

(defn get-alignment
  "Determines the desired alignment for this view along an
   axis.  This is implemented to give the total alignment
   needed to position the children with the alignment points
   lined up along the axis orthogonal to the axis that is
   being tiled.  The axis being tiled will request to be
   centered (i.e. 0.5f).

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the desired alignment >= 0.0f && <= 1.0f; this should
     be a value between 0.0 and 1.0 where 0 indicates alignment at the
     origin and 1.0 indicates alignment to the full span
     away from the origin; an alignment of 0.5 would be the
     center of the view - `float`

  throws: java.lang.IllegalArgumentException - for an invalid axis"
  ([this axis]
    (-> this (.getAlignment axis))))

(defn get-resize-weight
  "Gets the resize weight.  A value of 0 or less is not resizable.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the weight - `int`

  throws: java.lang.IllegalArgumentException - for an invalid axis"
  ([this axis]
    (-> this (.getResizeWeight axis))))

(defn set-size
  "Sets the size of the view.  This should cause
   layout of the view if the view caches any layout
   information.  This is implemented to call the
   layout method with the sizes inside of the insets.

  width - the width >= 0 - `float`
  height - the height >= 0 - `float`"
  ([this width height]
    (-> this (.setSize width height))))

(defn preference-changed
  "This is called by a child to indicate its
   preferred span has changed.  This is implemented to
   throw away cached layout information so that new
   calculations will be done the next time the children
   need an allocation.

  child - the child view - `javax.swing.text.View`
  width - true if the width preference should change - `boolean`
  height - true if the height preference should change - `boolean`"
  ([this child width height]
    (-> this (.preferenceChanged child width height))))

(defn view-to-model
  "Provides a mapping from the view coordinate space to the logical
   coordinate space of the model.

  x - x coordinate of the view location to convert >= 0 - `float`
  y - y coordinate of the view location to convert >= 0 - `float`
  a - the allocated region to render into - `java.awt.Shape`
  bias - either Position.Bias.Forward or Position.Bias.Backward - `javax.swing.text.Position.Bias[]`

  returns: the location within the model that best represents the
    given point in the view >= 0 - `int`"
  ([this x y a bias]
    (-> this (.viewToModel x y a bias))))

(defn model-to-view
  "Provides a mapping from the document model coordinate space
   to the coordinate space of the view mapped to it.  This makes
   sure the allocation is valid before calling the superclass.

  pos - the position to convert >= 0 - `int`
  a - the allocated region to render into - `java.awt.Shape`
  b - a bias value of either Position.Bias.Forward or Position.Bias.Backward - `javax.swing.text.Position.Bias`

  returns: the bounding box of the given position - `java.awt.Shape`

  throws: javax.swing.text.BadLocationException - if the given position does not represent a valid location in the associated document"
  ([this pos a b]
    (-> this (.modelToView pos a b))))

