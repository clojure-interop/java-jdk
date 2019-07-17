(ns javax.swing.text.AsyncBoxView
  "A box that does layout asynchronously.  This
  is useful to keep the GUI event thread moving by
  not doing any layout on it.  The layout is done
  on a granularity of operations on the child views.
  After each child view is accessed for some part
  of layout (a potentially time consuming operation)
  the remaining tasks can be abandoned or a new higher
  priority task (i.e. to service a synchronous request
  or a visible area) can be taken on.

  While the child view is being accessed
  a read lock is acquired on the associated document
  so that the model is stable while being accessed."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text AsyncBoxView]))

(defn ->async-box-view
  "Constructor.

  Construct a box view that does asynchronous layout.

  elem - the element of the model to represent - `javax.swing.text.Element`
  axis - the axis to tile along. This can be either X_AXIS or Y_AXIS. - `int`"
  ([^javax.swing.text.Element elem ^Integer axis]
    (new AsyncBoxView elem axis)))

(defn get-bottom-inset
  "Get the bottom part of the margin around the view.

  returns: `float`"
  ([^javax.swing.text.AsyncBoxView this]
    (-> this (.getBottomInset))))

(defn set-parent
  "Sets the parent of the view.
   This is reimplemented to provide the superclass
   behavior as well as calling the loadChildren
   method if this view does not already have children.
   The children should not be loaded in the
   constructor because the act of setting the parent
   may cause them to try to search up the hierarchy
   (to get the hosting Container for example).
   If this view has children (the view is being moved
   from one place in the view hierarchy to another),
   the loadChildren method will not be called.

  parent - the parent of the view, null if none - `javax.swing.text.View`"
  ([^javax.swing.text.AsyncBoxView this ^javax.swing.text.View parent]
    (-> this (.setParent parent))))

(defn get-preferred-span
  "Determines the preferred span for this view along an
   axis.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the span the view would like to be rendered into >= 0.
             Typically the view is told to render into the span
             that is returned, although there is no guarantee.
             The parent may choose to resize or break the view. - `float`

  throws: java.lang.IllegalArgumentException - for an invalid axis type"
  ([^javax.swing.text.AsyncBoxView this ^Integer axis]
    (-> this (.getPreferredSpan axis))))

(defn get-view
  "Gets the nth child view.  Since there are no
   children by default, this returns null.

  n - the number of the view to get, >= 0 && < getViewCount() - `int`

  returns: the view - `javax.swing.text.View`"
  ([^javax.swing.text.AsyncBoxView this ^Integer n]
    (-> this (.getView n))))

(defn get-child-allocation
  "Fetches the allocation for the given child view.
   This enables finding out where various views
   are located, without assuming the views store
   their location.  This returns null since the
   default is to not have any child views.

  index - the index of the child, >= 0 && < getViewCount() - `int`
  a - the allocation to this view. - `java.awt.Shape`

  returns: the allocation to the child - `java.awt.Shape`"
  ([^javax.swing.text.AsyncBoxView this ^Integer index ^java.awt.Shape a]
    (-> this (.getChildAllocation index a))))

(defn set-right-inset
  "Set the right part of the margin around the view.

  i - the value of the inset - `float`"
  ([^javax.swing.text.AsyncBoxView this ^Float i]
    (-> this (.setRightInset i))))

(defn replace
  "Calls the superclass to update the child views, and
   updates the status records for the children.  This
   is expected to be called while a write lock is held
   on the model so that interaction with the layout
   thread will not happen (i.e. the layout thread
   acquires a read lock before doing anything).

  offset - the starting offset into the child views >= 0 - `int`
  length - the number of existing views to replace >= 0 - `int`
  views - the child views to insert - `javax.swing.text.View[]`"
  ([^javax.swing.text.AsyncBoxView this ^Integer offset ^Integer length ^javax.swing.text.View[] views]
    (-> this (.replace offset length views))))

(defn get-major-axis
  "Fetch the major axis (the axis the children
   are tiled along).  This will have a value of
   either X_AXIS or Y_AXIS.

  returns: `int`"
  ([^javax.swing.text.AsyncBoxView this]
    (-> this (.getMajorAxis))))

(defn get-right-inset
  "Get the right part of the margin around the view.

  returns: `float`"
  ([^javax.swing.text.AsyncBoxView this]
    (-> this (.getRightInset))))

(defn get-top-inset
  "Get the top part of the margin around the view.

  returns: `float`"
  ([^javax.swing.text.AsyncBoxView this]
    (-> this (.getTopInset))))

(defn set-top-inset
  "Set the top part of the margin around the view.

  i - the value of the inset - `float`"
  ([^javax.swing.text.AsyncBoxView this ^Float i]
    (-> this (.setTopInset i))))

(defn set-bottom-inset
  "Set the bottom part of the margin around the view.

  i - the value of the inset - `float`"
  ([^javax.swing.text.AsyncBoxView this ^Float i]
    (-> this (.setBottomInset i))))

(defn get-minimum-span
  "Determines the minimum span for this view along an
   axis.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the span the view would like to be rendered into >= 0.
             Typically the view is told to render into the span
             that is returned, although there is no guarantee.
             The parent may choose to resize or break the view. - `float`

  throws: java.lang.IllegalArgumentException - for an invalid axis type"
  ([^javax.swing.text.AsyncBoxView this ^Integer axis]
    (-> this (.getMinimumSpan axis))))

(defn get-maximum-span
  "Determines the maximum span for this view along an
   axis.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the span the view would like to be rendered into >= 0.
             Typically the view is told to render into the span
             that is returned, although there is no guarantee.
             The parent may choose to resize or break the view. - `float`

  throws: java.lang.IllegalArgumentException - for an invalid axis type"
  ([^javax.swing.text.AsyncBoxView this ^Integer axis]
    (-> this (.getMaximumSpan axis))))

(defn paint
  "Render the view using the given allocation and
   rendering surface.

   This is implemented to determine whether or not the
   desired region to be rendered (i.e. the unclipped
   area) is up to date or not.  If up-to-date the children
   are rendered.  If not up-to-date, a task to build
   the desired area is placed on the layout queue as
   a high priority task.  This keeps by event thread
   moving by rendering if ready, and postponing until
   a later time if not ready (since paint requests
   can be rescheduled).

  g - the rendering surface to use - `java.awt.Graphics`
  alloc - the allocated region to render into - `java.awt.Shape`"
  ([^javax.swing.text.AsyncBoxView this ^java.awt.Graphics g ^java.awt.Shape alloc]
    (-> this (.paint g alloc))))

(defn set-size
  "Sets the size of the view.  This should cause
   layout of the view if the view caches any layout
   information.

   Since the major axis is updated asynchronously and should be
   the sum of the tiled children the call is ignored for the major
   axis.  Since the minor axis is flexible, work is queued to resize
   the children if the minor span changes.

  width - the width >= 0 - `float`
  height - the height >= 0 - `float`"
  ([^javax.swing.text.AsyncBoxView this ^Float width ^Float height]
    (-> this (.setSize width height))))

(defn preference-changed
  "Child views can call this on the parent to indicate that
   the preference has changed and should be reconsidered
   for layout.  This is reimplemented to queue new work
   on the layout thread.  This method gets messaged from
   multiple threads via the children.

  child - the child view - `javax.swing.text.View`
  width - true if the width preference has changed - `boolean`
  height - true if the height preference has changed - `boolean`"
  ([^javax.swing.text.AsyncBoxView this ^javax.swing.text.View child ^Boolean width ^Boolean height]
    (-> this (.preferenceChanged child width height))))

(defn view-to-model
  "Provides a mapping from the view coordinate space to the logical
   coordinate space of the model.  The biasReturn argument will be
   filled in to indicate that the point given is closer to the next
   character in the model or the previous character in the model.

   This is expected to be called by the GUI thread, holding a
   read-lock on the associated model.  It is implemented to
   locate the child view and determine it's allocation with a
   lock on the ChildLocator object, and to call viewToModel
   on the child view with a lock on the ChildState object
   to avoid interaction with the layout thread.

  x - the X coordinate >= 0 - `float`
  y - the Y coordinate >= 0 - `float`
  a - the allocated region to render into - `java.awt.Shape`
  bias-return - `javax.swing.text.Position.Bias[]`

  returns: the location within the model that best represents the
    given point in the view >= 0.  The biasReturn argument will be
   filled in to indicate that the point given is closer to the next
   character in the model or the previous character in the model. - `int`"
  ([^javax.swing.text.AsyncBoxView this ^Float x ^Float y ^java.awt.Shape a ^javax.swing.text.Position.Bias[] bias-return]
    (-> this (.viewToModel x y a bias-return))))

(defn get-minor-axis
  "Fetch the minor axis (the axis orthogonal
   to the tiled axis).  This will have a value of
   either X_AXIS or Y_AXIS.

  returns: `int`"
  ([^javax.swing.text.AsyncBoxView this]
    (-> this (.getMinorAxis))))

(defn get-left-inset
  "Get the left part of the margin around the view.

  returns: `float`"
  ([^javax.swing.text.AsyncBoxView this]
    (-> this (.getLeftInset))))

(defn get-view-index
  "Returns the child view index representing the given position in
   the model.  By default a view has no children so this is implemented
   to return -1 to indicate there is no valid child index for any
   position.

  pos - the position >= 0 - `int`
  b - `javax.swing.text.Position.Bias`

  returns: index of the view representing the given position, or
     -1 if no view represents that position - `int`"
  ([^javax.swing.text.AsyncBoxView this ^Integer pos ^javax.swing.text.Position.Bias b]
    (-> this (.getViewIndex pos b))))

(defn get-view-count
  "Returns the number of views in this view.  Since
   the default is to not be a composite view this
   returns 0.

  returns: the number of views >= 0 - `int`"
  ([^javax.swing.text.AsyncBoxView this]
    (-> this (.getViewCount))))

(defn model-to-view
  "Provides a mapping from the document model coordinate space
   to the coordinate space of the view mapped to it.

  pos - the position to convert >= 0 - `int`
  a - the allocated region to render into - `java.awt.Shape`
  b - the bias toward the previous character or the next character represented by the offset, in case the position is a boundary of two views. - `javax.swing.text.Position.Bias`

  returns: the bounding box of the given position is returned - `java.awt.Shape`

  throws: javax.swing.text.BadLocationException - if the given position does not represent a valid location in the associated document"
  ([^javax.swing.text.AsyncBoxView this ^Integer pos ^java.awt.Shape a ^javax.swing.text.Position.Bias b]
    (-> this (.modelToView pos a b))))

(defn set-left-inset
  "Set the left part of the margin around the view.

  i - the value of the inset - `float`"
  ([^javax.swing.text.AsyncBoxView this ^Float i]
    (-> this (.setLeftInset i))))

(defn get-next-visual-position-from
  "Provides a way to determine the next visually represented model
   location that one might place a caret.  Some views may not be visible,
   they might not be in the same order found in the model, or they just
   might not allow access to some of the locations in the model.
   This method enables specifying a position to convert
   within the range of >=0.  If the value is -1, a position
   will be calculated automatically.  If the value < -1,
   the BadLocationException will be thrown.

  pos - the position to convert - `int`
  b - `javax.swing.text.Position.Bias`
  a - the allocated region to render into - `java.awt.Shape`
  direction - the direction from the current position that can be thought of as the arrow keys typically found on a keyboard; this may be one of the following: SwingConstants.WEST SwingConstants.EAST SwingConstants.NORTH SwingConstants.SOUTH - `int`
  bias-ret - an array contain the bias that was checked - `javax.swing.text.Position.Bias[]`

  returns: the location within the model that best represents the next
    location visual position - `int`

  throws: javax.swing.text.BadLocationException - the given position is not a valid position within the document"
  ([^javax.swing.text.AsyncBoxView this ^Integer pos ^javax.swing.text.Position.Bias b ^java.awt.Shape a ^Integer direction ^javax.swing.text.Position.Bias[] bias-ret]
    (-> this (.getNextVisualPositionFrom pos b a direction bias-ret))))

