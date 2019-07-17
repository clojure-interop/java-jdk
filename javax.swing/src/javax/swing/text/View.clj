(ns javax.swing.text.View
  " A very important part of the text package is the View class.
  As the name suggests it represents a view of the text model,
  or a piece of the text model.
  It is this class that is responsible for the look of the text component.
  The view is not intended to be some completely new thing that one must
  learn, but rather is much like a lightweight component.

 By default, a view is very light.  It contains a reference to the parent
 view from which it can fetch many things without holding state, and it
 contains a reference to a portion of the model (Element).
 A view does not
 have to exactly represent an element in the model, that is simply a typical
 and therefore convenient mapping.  A view can alternatively maintain a couple
 of Position objects to maintain its location in the model (i.e. represent
 a fragment of an element).  This is typically the result of formatting where
 views have been broken down into pieces.  The convenience of a substantial
 relationship to the element makes it easier to build factories to produce the
 views, and makes it easier  to keep track of the view pieces as the model is
 changed and the view must be changed to reflect the model.  Simple views
 therefore represent an Element directly and complex views do not.

 A view has the following responsibilities:


     Participate in layout.

     The view has a setSize method which is like
     doLayout and setSize in Component combined.
     The view has a preferenceChanged method which is
     like invalidate in Component except that one can
     invalidate just one axis
     and the child requesting the change is identified.
     A View expresses the size that it would like to be in terms of three
     values, a minimum, a preferred, and a maximum span.  Layout in a view is
     can be done independently upon each axis.  For a properly functioning View
     implementation, the minimum span will be <= the preferred span which in turn
     will be <= the maximum span.


     The minimum set of methods for layout are:

     getMinimumSpan
     getPreferredSpan
     getMaximumSpan
     getAlignment
     preferenceChanged
     setSize


   The setSize method should be prepared to be called a number of times
     (i.e. It may be called even if the size didn't change).
     The setSize method
     is generally called to make sure the View layout is complete prior to trying
     to perform an operation on it that requires an up-to-date layout.  A view's
     size should always be set to a value within the minimum and maximum
     span specified by that view.  Additionally, the view must always call the
     preferenceChanged method on the parent if it has changed the
     values for the
     layout it would like, and expects the parent to honor.  The parent View is
     not required to recognize a change until the preferenceChanged
     has been sent.
     This allows parent View implementations to cache the child requirements if
     desired.  The calling sequence looks something like the following:



     The exact calling sequence is up to the layout functionality of
     the parent view (if the view has any children).  The view may collect
     the preferences of the children prior to determining what it will give
     each child, or it might iteratively update the children one at a time.


     Render a portion of the model.

     This is done in the paint method, which is pretty much like a component
     paint method.  Views are expected to potentially populate a fairly large
     tree.  A View has the following semantics for rendering:


     The view gets its allocation from the parent at paint time, so it
     must be prepared to redo layout if the allocated area is different from
     what it is prepared to deal with.
     The coordinate system is the same as the hosting Component
     (i.e. the Component returned by the
     getContainer method).
     This means a child view lives in the same coordinate system as the parent
     view unless the parent has explicitly changed the coordinate system.
     To schedule itself to be repainted a view can call repaint on the hosting
     Component.
     The default is to not clip the children.  It is more efficient
     to allow a view to clip only if it really feels it needs clipping.
     The Graphics object given is not initialized in any way.
     A view should set any settings needed.
     A View is inherently transparent.  While a view may render into its
     entire allocation, typically a view does not.  Rendering is performed by
     traversing down the tree of View implementations.
     Each View is responsible
     for rendering its children.  This behavior is depended upon for thread
     safety.  While view implementations do not necessarily have to be implemented
     with thread safety in mind, other view implementations that do make use of
     concurrency can depend upon a tree traversal to guarantee thread safety.
     The order of views relative to the model is up to the implementation.
     Although child views will typically be arranged in the same order that they
     occur in the model, they may be visually arranged in an entirely different
     order.  View implementations may have Z-Order associated with them if the
     children are overlapping.

     The methods for rendering are:

     paint


     Translate between the model and view coordinate systems.

     Because the view objects are produced from a factory and therefore cannot
     necessarily be counted upon to be in a particular pattern, one must be able
     to perform translation to properly locate spatial representation of the model.
     The methods for doing this are:

     modelToView
     viewToModel
     getDocument
     getElement
     getStartOffset
     getEndOffset

     The layout must be valid prior to attempting to make the translation.
     The translation is not valid, and must not be attempted while changes
     are being broadcasted from the model via a DocumentEvent.


     Respond to changes from the model.

     If the overall view is represented by many pieces (which is the best situation
     if one want to be able to change the view and write the least amount of new code),
     it would be impractical to have a huge number of DocumentListeners.
     If each
     view listened to the model, only a few would actually be interested in the
     changes broadcasted at any given time.   Since the model has no knowledge of
     views, it has no way to filter the broadcast of change information.  The view
     hierarchy itself is instead responsible for propagating the change information.
     At any level in the view hierarchy, that view knows enough about its children to
     best distribute the change information further.   Changes are therefore broadcasted
     starting from the root of the view hierarchy.
     The methods for doing this are:

     insertUpdate
     removeUpdate
     changedUpdate"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text View]))

(defn ->view
  "Constructor.

  Creates a new View object.

  elem - the Element to represent - `javax.swing.text.Element`"
  ([^javax.swing.text.Element elem]
    (new View elem)))

(def *-bad-break-weight
  "Static Constant.

  The weight to indicate a view is a bad break
   opportunity for the purpose of formatting.  This
   value indicates that no attempt should be made to
   break the view into fragments as the view has
   not been written to support fragmenting.

  type: int"
  View/BadBreakWeight)

(def *-good-break-weight
  "Static Constant.

  The weight to indicate a view supports breaking,
   but better opportunities probably exist.

  type: int"
  View/GoodBreakWeight)

(def *-excellent-break-weight
  "Static Constant.

  The weight to indicate a view supports breaking,
   and this represents a very attractive place to
   break.

  type: int"
  View/ExcellentBreakWeight)

(def *-forced-break-weight
  "Static Constant.

  The weight to indicate a view supports breaking,
   and must be broken to be represented properly
   when placed in a view that formats its children
   by breaking them.

  type: int"
  View/ForcedBreakWeight)

(def *-x-axis
  "Static Constant.

  Axis for format/break operations.

  type: int"
  View/X_AXIS)

(def *-y-axis
  "Static Constant.

  Axis for format/break operations.

  type: int"
  View/Y_AXIS)

(defn get-view-factory
  "Fetches the ViewFactory implementation that is feeding
   the view hierarchy.  Normally the views are given this
   as an argument to updates from the model when they
   are most likely to need the factory, but this
   method serves to provide it at other times.

  returns: the factory, null if none - `javax.swing.text.ViewFactory`"
  (^javax.swing.text.ViewFactory [^javax.swing.text.View this]
    (-> this (.getViewFactory))))

(defn get-break-weight
  "Determines how attractive a break opportunity in
   this view is.  This can be used for determining which
   view is the most attractive to call breakView
   on in the process of formatting.  A view that represents
   text that has whitespace in it might be more attractive
   than a view that has no whitespace, for example.  The
   higher the weight, the more attractive the break.  A
   value equal to or lower than BadBreakWeight
   should not be considered for a break.  A value greater
   than or equal to ForcedBreakWeight should
   be broken.

   This is implemented to provide the default behavior
   of returning BadBreakWeight unless the length
   is greater than the length of the view in which case the
   entire view represents the fragment.  Unless a view has
   been written to support breaking behavior, it is not
   attractive to try and break the view.  An example of
   a view that does support breaking is LabelView.
   An example of a view that uses break weight is
   ParagraphView.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`
  pos - the potential location of the start of the broken view >= 0. This may be useful for calculating tab positions - `float`
  len - specifies the relative length from pos where a potential break is desired >= 0 - `float`

  returns: the weight, which should be a value between
     ForcedBreakWeight and BadBreakWeight - `int`"
  (^Integer [^javax.swing.text.View this ^Integer axis ^Float pos ^Float len]
    (-> this (.getBreakWeight axis pos len))))

(defn changed-update
  "Gives notification from the document that attributes were changed
   in a location that this view is responsible for.
   To reduce the burden to subclasses, this functionality is
   spread out into the following calls that subclasses can
   reimplement:

   updateChildren is called
   if there were any changes to the element this view is
   responsible for.  If this view has child views that are
   represent the child elements, then this method should do
   whatever is necessary to make sure the child views correctly
   represent the model.
   forwardUpdate is called
   to forward the DocumentEvent to the appropriate child views.
   updateLayout is called to
   give the view a chance to either repair its layout, to reschedule
   layout, or do nothing.

  e - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.View this ^javax.swing.event.DocumentEvent e ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.changedUpdate e a f))))

(defn set-parent
  "Establishes the parent view for this view.  This is
   guaranteed to be called before any other methods if the
   parent view is functioning properly.  This is also
   the last method called, since it is called to indicate
   the view has been removed from the hierarchy as
   well. When this method is called to set the parent to
   null, this method does the same for each of its children,
   propagating the notification that they have been
   disconnected from the view tree. If this is
   reimplemented, super.setParent() should
   be called.

  parent - the new parent, or null if the view is being removed from a parent - `javax.swing.text.View`"
  ([^javax.swing.text.View this ^javax.swing.text.View parent]
    (-> this (.setParent parent))))

(defn get-preferred-span
  "Determines the preferred span for this view along an
   axis.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the span the view would like to be rendered into.
             Typically the view is told to render into the span
             that is returned, although there is no guarantee.
             The parent may choose to resize or break the view - `float`"
  (^Float [^javax.swing.text.View this ^Integer axis]
    (-> this (.getPreferredSpan axis))))

(defn get-view
  "Gets the nth child view.  Since there are no
   children by default, this returns null.

  n - the number of the view to get, >= 0 && < getViewCount() - `int`

  returns: the view - `javax.swing.text.View`"
  (^javax.swing.text.View [^javax.swing.text.View this ^Integer n]
    (-> this (.getView n))))

(defn get-document
  "Fetches the model associated with the view.

  returns: the view model, null if none - `javax.swing.text.Document`"
  (^javax.swing.text.Document [^javax.swing.text.View this]
    (-> this (.getDocument))))

(defn get-child-allocation
  "Fetches the allocation for the given child view.
   This enables finding out where various views
   are located, without assuming how the views store
   their location.  This returns null since the
   default is to not have any child views.

  index - the index of the child, >= 0 && < getViewCount() - `int`
  a - the allocation to this view - `java.awt.Shape`

  returns: the allocation to the child - `java.awt.Shape`"
  (^java.awt.Shape [^javax.swing.text.View this ^Integer index ^java.awt.Shape a]
    (-> this (.getChildAllocation index a))))

(defn remove-update
  "Gives notification that something was removed from the document
   in a location that this view is responsible for.
   To reduce the burden to subclasses, this functionality is
   spread out into the following calls that subclasses can
   reimplement:

   updateChildren is called
   if there were any changes to the element this view is
   responsible for.  If this view has child views that are
   represent the child elements, then this method should do
   whatever is necessary to make sure the child views correctly
   represent the model.
   forwardUpdate is called
   to forward the DocumentEvent to the appropriate child views.
   updateLayout is called to
   give the view a chance to either repair its layout, to reschedule
   layout, or do nothing.

  e - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.View this ^javax.swing.event.DocumentEvent e ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.removeUpdate e a f))))

(defn create-fragment
  "Creates a view that represents a portion of the element.
   This is potentially useful during formatting operations
   for taking measurements of fragments of the view.  If
   the view doesn't support fragmenting (the default), it
   should return itself.

  p-0 - the starting offset >= 0. This should be a value greater or equal to the element starting offset and less than the element ending offset. - `int`
  p-1 - the ending offset > p0. This should be a value less than or equal to the elements end offset and greater than the elements starting offset. - `int`

  returns: the view fragment, or itself if the view doesn't
     support breaking into fragments - `javax.swing.text.View`"
  (^javax.swing.text.View [^javax.swing.text.View this ^Integer p-0 ^Integer p-1]
    (-> this (.createFragment p-0 p-1))))

(defn get-end-offset
  "Fetches the portion of the model for which this view is
   responsible.

  returns: the ending offset into the model >= 0 - `int`"
  (^Integer [^javax.swing.text.View this]
    (-> this (.getEndOffset))))

(defn get-element
  "Fetches the structural portion of the subject that this
   view is mapped to.  The view may not be responsible for the
   entire portion of the element.

  returns: the subject - `javax.swing.text.Element`"
  (^javax.swing.text.Element [^javax.swing.text.View this]
    (-> this (.getElement))))

(defn get-graphics
  "Fetch a Graphics for rendering.
   This can be used to determine
   font characteristics, and will be different for a print view
   than a component view.

  returns: a Graphics object for rendering - `java.awt.Graphics`"
  (^java.awt.Graphics [^javax.swing.text.View this]
    (-> this (.getGraphics))))

(defn replace
  "Replaces child views.  If there are no views to remove
   this acts as an insert.  If there are no views to
   add this acts as a remove.  Views being removed will
   have the parent set to null, and the internal reference
   to them removed so that they can be garbage collected.
   This is implemented to do nothing, because by default
   a view has no children.

  offset - the starting index into the child views to insert the new views. This should be a value >= 0 and <= getViewCount - `int`
  length - the number of existing child views to remove This should be a value >= 0 and <= (getViewCount() - offset). - `int`
  views - the child views to add. This value can be null to indicate no children are being added (useful to remove). - `javax.swing.text.View[]`"
  ([^javax.swing.text.View this ^Integer offset ^Integer length views]
    (-> this (.replace offset length views))))

(defn get-tool-tip-text
  "Returns the tooltip text at the specified location. The default
   implementation returns the value from the child View identified by
   the passed in location.

  x - `float`
  y - `float`
  allocation - `java.awt.Shape`

  returns: `java.lang.String`"
  (^java.lang.String [^javax.swing.text.View this ^Float x ^Float y ^java.awt.Shape allocation]
    (-> this (.getToolTipText x y allocation))))

(defn get-parent
  "Returns the parent of the view.

  returns: the parent, or null if none exists - `javax.swing.text.View`"
  (^javax.swing.text.View [^javax.swing.text.View this]
    (-> this (.getParent))))

(defn get-container
  "Fetches the container hosting the view.  This is useful for
   things like scheduling a repaint, finding out the host
   components font, etc.  The default implementation
   of this is to forward the query to the parent view.

  returns: the container, null if none - `java.awt.Container`"
  (^java.awt.Container [^javax.swing.text.View this]
    (-> this (.getContainer))))

(defn remove
  "Removes one of the children at the given position.
   This is a convenience call to replace.

  i - `int`"
  ([^javax.swing.text.View this ^Integer i]
    (-> this (.remove i))))

(defn get-minimum-span
  "Determines the minimum span for this view along an
   axis.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the minimum span the view can be rendered into - `float`"
  (^Float [^javax.swing.text.View this ^Integer axis]
    (-> this (.getMinimumSpan axis))))

(defn get-maximum-span
  "Determines the maximum span for this view along an
   axis.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the maximum span the view can be rendered into - `float`"
  (^Float [^javax.swing.text.View this ^Integer axis]
    (-> this (.getMaximumSpan axis))))

(defn insert-update
  "Gives notification that something was inserted into
   the document in a location that this view is responsible for.
   To reduce the burden to subclasses, this functionality is
   spread out into the following calls that subclasses can
   reimplement:

   updateChildren is called
   if there were any changes to the element this view is
   responsible for.  If this view has child views that are
   represent the child elements, then this method should do
   whatever is necessary to make sure the child views correctly
   represent the model.
   forwardUpdate is called
   to forward the DocumentEvent to the appropriate child views.
   updateLayout is called to
   give the view a chance to either repair its layout, to reschedule
   layout, or do nothing.

  e - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.View this ^javax.swing.event.DocumentEvent e ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.insertUpdate e a f))))

(defn paint
  "Renders using the given rendering surface and area on that
   surface.  The view may need to do layout and create child
   views to enable itself to render into the given allocation.

  g - the rendering surface to use - `java.awt.Graphics`
  allocation - the allocated region to render into - `java.awt.Shape`"
  ([^javax.swing.text.View this ^java.awt.Graphics g ^java.awt.Shape allocation]
    (-> this (.paint g allocation))))

(defn get-alignment
  "Determines the desired alignment for this view along an
   axis.  The desired alignment is returned.  This should be
   a value >= 0.0 and <= 1.0, where 0 indicates alignment at
   the origin and 1.0 indicates alignment to the full span
   away from the origin.  An alignment of 0.5 would be the
   center of the view.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the value 0.5 - `float`"
  (^Float [^javax.swing.text.View this ^Integer axis]
    (-> this (.getAlignment axis))))

(defn get-resize-weight
  "Determines the resizability of the view along the
   given axis.  A value of 0 or less is not resizable.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the weight - `int`"
  (^Integer [^javax.swing.text.View this ^Integer axis]
    (-> this (.getResizeWeight axis))))

(defn get-start-offset
  "Fetches the portion of the model for which this view is
   responsible.

  returns: the starting offset into the model >= 0 - `int`"
  (^Integer [^javax.swing.text.View this]
    (-> this (.getStartOffset))))

(defn visible?
  "Returns a boolean that indicates whether
    the view is visible or not.  By default
    all views are visible.

  returns: always returns true - `boolean`"
  (^Boolean [^javax.swing.text.View this]
    (-> this (.isVisible))))

(defn set-size
  "Sets the size of the view.  This should cause
   layout of the view along the given axis, if it
   has any layout duties.

  width - the width >= 0 - `float`
  height - the height >= 0 - `float`"
  ([^javax.swing.text.View this ^Float width ^Float height]
    (-> this (.setSize width height))))

(defn append
  "Appends a single child view.  This is a convenience
   call to replace.

  v - the view - `javax.swing.text.View`"
  ([^javax.swing.text.View this ^javax.swing.text.View v]
    (-> this (.append v))))

(defn preference-changed
  "Child views can call this on the parent to indicate that
   the preference has changed and should be reconsidered
   for layout.  By default this just propagates upward to
   the next parent.  The root view will call
   revalidate on the associated text component.

  child - the child view - `javax.swing.text.View`
  width - true if the width preference has changed - `boolean`
  height - true if the height preference has changed - `boolean`"
  ([^javax.swing.text.View this ^javax.swing.text.View child ^Boolean width ^Boolean height]
    (-> this (.preferenceChanged child width height))))

(defn insert
  "Inserts a single child view.  This is a convenience
   call to replace.

  offs - the offset of the view to insert before >= 0 - `int`
  v - the view - `javax.swing.text.View`"
  ([^javax.swing.text.View this ^Integer offs ^javax.swing.text.View v]
    (-> this (.insert offs v))))

(defn view-to-model
  "Provides a mapping from the view coordinate space to the logical
   coordinate space of the model.  The biasReturn
   argument will be filled in to indicate that the point given is
   closer to the next character in the model or the previous
   character in the model.

  x - the X coordinate >= 0 - `float`
  y - the Y coordinate >= 0 - `float`
  a - the allocated region in which to render - `java.awt.Shape`
  bias-return - `javax.swing.text.Position.Bias[]`

  returns: the location within the model that best represents the
    given point in the view >= 0.  The biasReturn
    argument will be
   filled in to indicate that the point given is closer to the next
   character in the model or the previous character in the model. - `int`"
  (^Integer [^javax.swing.text.View this ^Float x ^Float y ^java.awt.Shape a bias-return]
    (-> this (.viewToModel x y a bias-return)))
  ([^javax.swing.text.View this ^Float x ^Float y ^java.awt.Shape a]
    (-> this (.viewToModel x y a))))

(defn break-view
  "Tries to break this view on the given axis.  This is
   called by views that try to do formatting of their
   children.  For example, a view of a paragraph will
   typically try to place its children into row and
   views representing chunks of text can sometimes be
   broken down into smaller pieces.

   This is implemented to return the view itself, which
   represents the default behavior on not being
   breakable.  If the view does support breaking, the
   starting offset of the view returned should be the
   given offset, and the end offset should be less than
   or equal to the end offset of the view being broken.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`
  offset - the location in the document model that a broken fragment would occupy >= 0. This would be the starting offset of the fragment returned - `int`
  pos - the position along the axis that the broken view would occupy >= 0. This may be useful for things like tab calculations - `float`
  len - specifies the distance along the axis where a potential break is desired >= 0 - `float`

  returns: the fragment of the view that represents the
    given span, if the view can be broken.  If the view
    doesn't support breaking behavior, the view itself is
    returned. - `javax.swing.text.View`"
  (^javax.swing.text.View [^javax.swing.text.View this ^Integer axis ^Integer offset ^Float pos ^Float len]
    (-> this (.breakView axis offset pos len))))

(defn get-view-index
  "Returns the child view index representing the given position in
   the view. This iterates over all the children returning the
   first with a bounds that contains x, y.

  x - the x coordinate - `float`
  y - the y coordinate - `float`
  allocation - current allocation of the View. - `java.awt.Shape`

  returns: index of the view representing the given location, or
     -1 if no view represents that position - `int`"
  (^Integer [^javax.swing.text.View this ^Float x ^Float y ^java.awt.Shape allocation]
    (-> this (.getViewIndex x y allocation)))
  (^Integer [^javax.swing.text.View this ^Integer pos ^javax.swing.text.Position.Bias b]
    (-> this (.getViewIndex pos b))))

(defn remove-all
  "Removes all of the children.  This is a convenience
   call to replace."
  ([^javax.swing.text.View this]
    (-> this (.removeAll))))

(defn get-view-count
  "Returns the number of views in this view.  Since
   the default is to not be a composite view this
   returns 0.

  returns: the number of views >= 0 - `int`"
  (^Integer [^javax.swing.text.View this]
    (-> this (.getViewCount))))

(defn get-attributes
  "Fetches the attributes to use when rendering.  By default
   this simply returns the attributes of the associated element.
   This method should be used rather than using the element
   directly to obtain access to the attributes to allow
   view-specific attributes to be mixed in or to allow the
   view to have view-specific conversion of attributes by
   subclasses.
   Each view should document what attributes it recognizes
   for the purpose of rendering or layout, and should always
   access them through the AttributeSet returned
   by this method.

  returns: `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^javax.swing.text.View this]
    (-> this (.getAttributes))))

(defn model-to-view
  "Provides a mapping, for a given region,
   from the document model coordinate space
   to the view coordinate space. The specified region is
   created as a union of the first and last character positions.

  p-0 - the position of the first character (>=0) - `int`
  b-0 - the bias of the first character position, toward the previous character or the next character represented by the offset, in case the position is a boundary of two views; b0 will have one of these values: Position.Bias.Forward Position.Bias.Backward - `javax.swing.text.Position.Bias`
  p-1 - the position of the last character (>=0) - `int`
  b-1 - the bias for the second character position, defined one of the legal values shown above - `javax.swing.text.Position.Bias`
  a - the area of the view, which encompasses the requested region - `java.awt.Shape`

  returns: the bounding box which is a union of the region specified
            by the first and last character positions - `java.awt.Shape`

  throws: javax.swing.text.BadLocationException - if the given position does not represent a valid location in the associated document"
  (^java.awt.Shape [^javax.swing.text.View this ^Integer p-0 ^javax.swing.text.Position.Bias b-0 ^Integer p-1 ^javax.swing.text.Position.Bias b-1 ^java.awt.Shape a]
    (-> this (.modelToView p-0 b-0 p-1 b-1 a)))
  (^java.awt.Shape [^javax.swing.text.View this ^Integer pos ^java.awt.Shape a ^javax.swing.text.Position.Bias b]
    (-> this (.modelToView pos a b)))
  ([^javax.swing.text.View this ^Integer pos ^java.awt.Shape a]
    (-> this (.modelToView pos a))))

(defn get-next-visual-position-from
  "Provides a way to determine the next visually represented model
   location at which one might place a caret.
   Some views may not be visible,
   they might not be in the same order found in the model, or they just
   might not allow access to some of the locations in the model.
   This method enables specifying a position to convert
   within the range of >=0.  If the value is -1, a position
   will be calculated automatically.  If the value < -1,
   the BadLocationException will be thrown.

  pos - the position to convert - `int`
  b - `javax.swing.text.Position.Bias`
  a - the allocated region in which to render - `java.awt.Shape`
  direction - the direction from the current position that can be thought of as the arrow keys typically found on a keyboard. This will be one of the following values: SwingConstants.WEST SwingConstants.EAST SwingConstants.NORTH SwingConstants.SOUTH - `int`
  bias-ret - `javax.swing.text.Position.Bias[]`

  returns: the location within the model that best represents the next
    location visual position - `int`

  throws: javax.swing.text.BadLocationException - the given position is not a valid position within the document"
  (^Integer [^javax.swing.text.View this ^Integer pos ^javax.swing.text.Position.Bias b ^java.awt.Shape a ^Integer direction bias-ret]
    (-> this (.getNextVisualPositionFrom pos b a direction bias-ret))))

