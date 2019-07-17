(ns javax.swing.BoxLayout
  "A layout manager that allows multiple components to be laid out either
  vertically or horizontally. The components will not wrap so, for
  example, a vertical arrangement of components will stay vertically
  arranged when the frame is resized.








  Nesting multiple panels with different combinations of horizontal and
  vertical gives an effect similar to GridBagLayout, without the
  complexity. The diagram shows two panels arranged horizontally, each
  of which contains 3 components arranged vertically.

   The BoxLayout manager is constructed with an axis parameter that
  specifies the type of layout that will be done. There are four choices:

  X_AXIS - Components are laid out horizontally
  from left to right.

  Y_AXIS - Components are laid out vertically
  from top to bottom.

  LINE_AXIS - Components are laid out the way
  words are laid out in a line, based on the container's
  ComponentOrientation property. If the container's
  ComponentOrientation is horizontal then components are laid out
  horizontally, otherwise they are laid out vertically.  For horizontal
  orientations, if the container's ComponentOrientation is left to
  right then components are laid out left to right, otherwise they are laid
  out right to left. For vertical orientations components are always laid out
  from top to bottom.

  PAGE_AXIS - Components are laid out the way
  text lines are laid out on a page, based on the container's
  ComponentOrientation property. If the container's
  ComponentOrientation is horizontal then components are laid out
  vertically, otherwise they are laid out horizontally.  For horizontal
  orientations, if the container's ComponentOrientation is left to
  right then components are laid out left to right, otherwise they are laid
  out right to left.  For vertical orientations components are always
  laid out from top to bottom.

  For all directions, components are arranged in the same order as they were
  added to the container.

  BoxLayout attempts to arrange components
  at their preferred widths (for horizontal layout)
  or heights (for vertical layout).
  For a horizontal layout,
  if not all the components are the same height,
  BoxLayout attempts to make all the components
  as high as the highest component.
  If that's not possible for a particular component,
  then BoxLayout aligns that component vertically,
  according to the component's Y alignment.
  By default, a component has a Y alignment of 0.5,
  which means that the vertical center of the component
  should have the same Y coordinate as
  the vertical centers of other components with 0.5 Y alignment.

  Similarly, for a vertical layout,
  BoxLayout attempts to make all components in the column
  as wide as the widest component.
  If that fails, it aligns them horizontally
  according to their X alignments.  For PAGE_AXIS layout,
  horizontal alignment is done based on the leading edge of the component.
  In other words, an X alignment value of 0.0 means the left edge of a
  component if the container's ComponentOrientation is left to
  right and it means the right edge of the component otherwise.

  Instead of using BoxLayout directly, many programs use the Box class.
  The Box class is a lightweight container that uses a BoxLayout.
  It also provides handy methods to help you use BoxLayout well.
  Adding components to multiple nested boxes is a powerful way to get
  the arrangement you want.

  For further information and examples see
  How to Use BoxLayout,
  a section in The Java Tutorial.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing BoxLayout]))

(defn ->box-layout
  "Constructor.

  Creates a layout manager that will lay out components along the
   given axis.

  target - the container that needs to be laid out - `java.awt.Container`
  axis - the axis to lay out components along. Can be one of: BoxLayout.X_AXIS, BoxLayout.Y_AXIS, BoxLayout.LINE_AXIS or BoxLayout.PAGE_AXIS - `int`

  throws: java.awt.AWTError - if the value of axis is invalid"
  ([target axis]
    (new BoxLayout target axis)))

(def *-x-axis
  "Static Constant.

  Specifies that components should be laid out left to right.

  type: int"
  BoxLayout/X_AXIS)

(def *-y-axis
  "Static Constant.

  Specifies that components should be laid out top to bottom.

  type: int"
  BoxLayout/Y_AXIS)

(def *-line-axis
  "Static Constant.

  Specifies that components should be laid out in the direction of
   a line of text as determined by the target container's
   ComponentOrientation property.

  type: int"
  BoxLayout/LINE_AXIS)

(def *-page-axis
  "Static Constant.

  Specifies that components should be laid out in the direction that
   lines flow across a page as determined by the target container's
   ComponentOrientation property.

  type: int"
  BoxLayout/PAGE_AXIS)

(defn invalidate-layout
  "Indicates that a child has changed its layout related information,
   and thus any cached calculations should be flushed.

   This method is called by AWT when the invalidate method is called
   on the Container.  Since the invalidate method may be called
   asynchronously to the event thread, this method may be called
   asynchronously.

  target - the affected container - `java.awt.Container`

  throws: java.awt.AWTError - if the target isn't the container specified to the BoxLayout constructor"
  ([this target]
    (-> this (.invalidateLayout target))))

(defn get-axis
  "Returns the axis that was used to lay out components.
   Returns one of:
   BoxLayout.X_AXIS,
   BoxLayout.Y_AXIS,
   BoxLayout.LINE_AXIS or
   BoxLayout.PAGE_AXIS

  returns: the axis that was used to lay out components - `int`"
  ([this]
    (-> this (.getAxis))))

(defn get-layout-alignment-y
  "Returns the alignment along the Y axis for the container.
   If the box is vertical, the default
   alignment will be returned. Otherwise, the alignment needed
   to place the children along the Y axis will be returned.

  target - the container - `java.awt.Container`

  returns: the alignment >= 0.0f && <= 1.0f - `float`

  throws: java.awt.AWTError - if the target isn't the container specified to the BoxLayout constructor"
  ([this target]
    (-> this (.getLayoutAlignmentY target))))

(defn preferred-layout-size
  "Returns the preferred dimensions for this layout, given the components
   in the specified target container.

  target - the container that needs to be laid out - `java.awt.Container`

  returns: the dimensions >= 0 && <= Integer.MAX_VALUE - `java.awt.Dimension`

  throws: java.awt.AWTError - if the target isn't the container specified to the BoxLayout constructor"
  ([this target]
    (-> this (.preferredLayoutSize target))))

(defn get-layout-alignment-x
  "Returns the alignment along the X axis for the container.
   If the box is horizontal, the default
   alignment will be returned. Otherwise, the alignment needed
   to place the children along the X axis will be returned.

  target - the container - `java.awt.Container`

  returns: the alignment >= 0.0f && <= 1.0f - `float`

  throws: java.awt.AWTError - if the target isn't the container specified to the BoxLayout constructor"
  ([this target]
    (-> this (.getLayoutAlignmentX target))))

(defn minimum-layout-size
  "Returns the minimum dimensions needed to lay out the components
   contained in the specified target container.

  target - the container that needs to be laid out - `java.awt.Container`

  returns: the dimensions >= 0 && <= Integer.MAX_VALUE - `java.awt.Dimension`

  throws: java.awt.AWTError - if the target isn't the container specified to the BoxLayout constructor"
  ([this target]
    (-> this (.minimumLayoutSize target))))

(defn get-target
  "Returns the container that uses this layout manager.

  returns: the container that uses this layout manager - `java.awt.Container`"
  ([this]
    (-> this (.getTarget))))

(defn maximum-layout-size
  "Returns the maximum dimensions the target container can use
   to lay out the components it contains.

  target - the container that needs to be laid out - `java.awt.Container`

  returns: the dimensions >= 0 && <= Integer.MAX_VALUE - `java.awt.Dimension`

  throws: java.awt.AWTError - if the target isn't the container specified to the BoxLayout constructor"
  ([this target]
    (-> this (.maximumLayoutSize target))))

(defn add-layout-component
  "Not used by this class.

  name - the name of the component - `java.lang.String`
  comp - the component - `java.awt.Component`"
  ([this name comp]
    (-> this (.addLayoutComponent name comp))))

(defn remove-layout-component
  "Not used by this class.

  comp - the component - `java.awt.Component`"
  ([this comp]
    (-> this (.removeLayoutComponent comp))))

(defn layout-container
  "Called by the AWT  XXX CHECK!  when the specified container
   needs to be laid out.

  target - the container to lay out - `java.awt.Container`

  throws: java.awt.AWTError - if the target isn't the container specified to the BoxLayout constructor"
  ([this target]
    (-> this (.layoutContainer target))))

