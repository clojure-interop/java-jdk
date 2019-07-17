(ns javax.swing.text.CompositeView
  "CompositeView is an abstract View
  implementation which manages one or more child views.
  (Note that CompositeView is intended
  for managing relatively small numbers of child views.)
  CompositeView is intended to be used as
  a starting point for View implementations,
  such as BoxView, that will contain child
  Views. Subclasses that wish to manage the
  collection of child Views should use the
  replace(int, int, javax.swing.text.View[]) method.  As View invokes
  replace during DocumentListener
  notification, you normally won't need to directly
  invoke replace.

  While CompositeView
  does not impose a layout policy on its child Views,
  it does allow for inseting the child Views
  it will contain.  The insets can be set by either
  setInsets(short, short, short, short) or setParagraphInsets(javax.swing.text.AttributeSet).

  In addition to the abstract methods of
  View,
  subclasses of CompositeView will need to
  override:

  isBefore(int, int, java.awt.Rectangle) - Used to test if a given
      View location is before the visual space
      of the CompositeView.
  isAfter(int, int, java.awt.Rectangle) - Used to test if a given
      View location is after the visual space
      of the CompositeView.
  getViewAtPoint(int, int, java.awt.Rectangle) - Returns the view at
      a given visual location.
  childAllocation(int, java.awt.Rectangle) - Returns the bounds of
      a particular child View.
      getChildAllocation will invoke
      childAllocation after offseting
      the bounds by the Insets of the
      CompositeView."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text CompositeView]))

(defn ->composite-view
  "Constructor.

  Constructs a CompositeView for the given element.

  elem - the element this view is responsible for - `javax.swing.text.Element`"
  ([^javax.swing.text.Element elem]
    (new CompositeView elem)))

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
  ([^javax.swing.text.CompositeView this ^javax.swing.text.View parent]
    (-> this (.setParent parent))))

(defn get-view
  "Returns the n-th view in this container.

  n - the number of the desired view, >= 0 && < getViewCount() - `int`

  returns: the view at index n - `javax.swing.text.View`"
  ([^javax.swing.text.CompositeView this ^Integer n]
    (-> this (.getView n))))

(defn get-child-allocation
  "Fetches the allocation for the given child view to
   render into. This enables finding out where various views
   are located.

  index - the index of the child, >= 0 && < getViewCount() - `int`
  a - the allocation to this view - `java.awt.Shape`

  returns: the allocation to the child - `java.awt.Shape`"
  ([^javax.swing.text.CompositeView this ^Integer index ^java.awt.Shape a]
    (-> this (.getChildAllocation index a))))

(defn replace
  "Replaces child views.  If there are no views to remove
   this acts as an insert.  If there are no views to
   add this acts as a remove.  Views being removed will
   have the parent set to null,
   and the internal reference to them removed so that they
   may be garbage collected.

  offset - the starting index into the child views to insert the new views; >= 0 and <= getViewCount - `int`
  length - the number of existing child views to remove; this should be a value >= 0 and <= (getViewCount() - offset) - `int`
  views - the child views to add; this value can be null to indicate no children are being added (useful to remove) - `javax.swing.text.View[]`"
  ([^javax.swing.text.CompositeView this ^Integer offset ^Integer length ^javax.swing.text.View[] views]
    (-> this (.replace offset length views))))

(defn view-to-model
  "Provides a mapping from the view coordinate space to the logical
   coordinate space of the model.

  x - x coordinate of the view location to convert >= 0 - `float`
  y - y coordinate of the view location to convert >= 0 - `float`
  a - the allocated region to render into - `java.awt.Shape`
  bias - either Position.Bias.Forward or Position.Bias.Backward - `javax.swing.text.Position.Bias[]`

  returns: the location within the model that best represents the
    given point in the view >= 0 - `int`"
  ([^javax.swing.text.CompositeView this ^Float x ^Float y ^java.awt.Shape a ^javax.swing.text.Position.Bias[] bias]
    (-> this (.viewToModel x y a bias))))

(defn get-view-index
  "Returns the child view index representing the given
   position in the model.  This is implemented to call the
   getViewIndexByPosition
   method for backward compatibility.

  pos - the position >= 0 - `int`
  b - `javax.swing.text.Position.Bias`

  returns: index of the view representing the given position, or
     -1 if no view represents that position - `int`"
  ([^javax.swing.text.CompositeView this ^Integer pos ^javax.swing.text.Position.Bias b]
    (-> this (.getViewIndex pos b))))

(defn get-view-count
  "Returns the number of child views of this view.

  returns: the number of views >= 0 - `int`"
  ([^javax.swing.text.CompositeView this]
    (-> this (.getViewCount))))

(defn model-to-view
  "Provides a mapping from the document model coordinate space
   to the coordinate space of the view mapped to it.

  p-0 - the position to convert >= 0 - `int`
  b-0 - the bias toward the previous character or the next character represented by p0, in case the position is a boundary of two views; either Position.Bias.Forward or Position.Bias.Backward - `javax.swing.text.Position.Bias`
  p-1 - the position to convert >= 0 - `int`
  b-1 - the bias toward the previous character or the next character represented by p1, in case the position is a boundary of two views - `javax.swing.text.Position.Bias`
  a - the allocated region to render into - `java.awt.Shape`

  returns: the bounding box of the given position is returned - `java.awt.Shape`

  throws: javax.swing.text.BadLocationException - if the given position does not represent a valid location in the associated document"
  ([^javax.swing.text.CompositeView this ^Integer p-0 ^javax.swing.text.Position.Bias b-0 ^Integer p-1 ^javax.swing.text.Position.Bias b-1 ^java.awt.Shape a]
    (-> this (.modelToView p-0 b-0 p-1 b-1 a)))
  ([^javax.swing.text.CompositeView this ^Integer pos ^java.awt.Shape a ^javax.swing.text.Position.Bias b]
    (-> this (.modelToView pos a b))))

(defn get-next-visual-position-from
  "Provides a way to determine the next visually represented model
   location that one might place a caret.  Some views may not be visible,
   they might not be in the same order found in the model, or they just
   might not allow access to some of the locations in the model.
   This is a convenience method for getNextNorthSouthVisualPositionFrom(int, javax.swing.text.Position.Bias, java.awt.Shape, int, javax.swing.text.Position.Bias[])
   and getNextEastWestVisualPositionFrom(int, javax.swing.text.Position.Bias, java.awt.Shape, int, javax.swing.text.Position.Bias[]).
   This method enables specifying a position to convert
   within the range of >=0.  If the value is -1, a position
   will be calculated automatically.  If the value < -1,
   the BadLocationException will be thrown.

  pos - the position to convert - `int`
  b - a bias value of either Position.Bias.Forward or Position.Bias.Backward - `javax.swing.text.Position.Bias`
  a - the allocated region to render into - `java.awt.Shape`
  direction - the direction from the current position that can be thought of as the arrow keys typically found on a keyboard; this may be one of the following: SwingConstants.WEST SwingConstants.EAST SwingConstants.NORTH SwingConstants.SOUTH - `int`
  bias-ret - an array containing the bias that was checked - `javax.swing.text.Position.Bias[]`

  returns: the location within the model that best represents the next
    location visual position - `int`

  throws: javax.swing.text.BadLocationException - the given position is not a valid position within the document"
  ([^javax.swing.text.CompositeView this ^Integer pos ^javax.swing.text.Position.Bias b ^java.awt.Shape a ^Integer direction ^javax.swing.text.Position.Bias[] bias-ret]
    (-> this (.getNextVisualPositionFrom pos b a direction bias-ret))))

