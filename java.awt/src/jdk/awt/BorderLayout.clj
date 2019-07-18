(ns jdk.awt.BorderLayout
  "A border layout lays out a container, arranging and resizing
  its components to fit in five regions:
  north, south, east, west, and center.
  Each region may contain no more than one component, and
  is identified by a corresponding constant:
  NORTH, SOUTH, EAST,
  WEST, and CENTER.  When adding a
  component to a container with a border layout, use one of these
  five constants, for example:


     Panel p = new Panel();
     p.setLayout(new BorderLayout());
     p.add(new Button(`Okay`), BorderLayout.SOUTH);
  As a convenience, BorderLayout interprets the
  absence of a string specification the same as the constant
  CENTER:


     Panel p2 = new Panel();
     p2.setLayout(new BorderLayout());
     p2.add(new TextArea());  // Same as p.add(new TextArea(), BorderLayout.CENTER);

  In addition, BorderLayout supports the relative
  positioning constants, PAGE_START, PAGE_END,
  LINE_START, and LINE_END.
  In a container whose ComponentOrientation is set to
  ComponentOrientation.LEFT_TO_RIGHT, these constants map to
  NORTH, SOUTH, WEST, and
  EAST, respectively.

  For compatibility with previous releases, BorderLayout
  also includes the relative positioning constants BEFORE_FIRST_LINE,
  AFTER_LAST_LINE, BEFORE_LINE_BEGINS and
  AFTER_LINE_ENDS.  These are equivalent to
  PAGE_START, PAGE_END, LINE_START
  and LINE_END respectively.  For
  consistency with the relative positioning constants used by other
  components, the latter constants are preferred.

  Mixing both absolute and relative positioning constants can lead to
  unpredictable results.  If
  you use both types, the relative constants will take precedence.
  For example, if you add components using both the NORTH
  and PAGE_START constants in a container whose
  orientation is LEFT_TO_RIGHT, only the
  PAGE_START will be layed out.

  NOTE: Currently (in the Java 2 platform v1.2),
  BorderLayout does not support vertical
  orientations.  The isVertical setting on the container's
  ComponentOrientation is not respected.

  The components are laid out according to their
  preferred sizes and the constraints of the container's size.
  The NORTH and SOUTH components may
  be stretched horizontally; the EAST and
  WEST components may be stretched vertically;
  the CENTER component may stretch both horizontally
  and vertically to fill any space left over.

  Here is an example of five buttons in an applet laid out using
  the BorderLayout layout manager:



  The code for this applet is as follows:



  import java.awt.*;
  import java.applet.Applet;

  public class buttonDir extends Applet {
    public void init() {
      setLayout(new BorderLayout());
      add(new Button(`North`), BorderLayout.NORTH);
      add(new Button(`South`), BorderLayout.SOUTH);
      add(new Button(`East`), BorderLayout.EAST);
      add(new Button(`West`), BorderLayout.WEST);
      add(new Button(`Center`), BorderLayout.CENTER);
    }
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt BorderLayout]))

(defn ->border-layout
  "Constructor.

  Constructs a border layout with the specified gaps
   between components.
   The horizontal gap is specified by hgap
   and the vertical gap is specified by vgap.

  hgap - the horizontal gap. - `int`
  vgap - the vertical gap. - `int`"
  (^BorderLayout [^Integer hgap ^Integer vgap]
    (new BorderLayout hgap vgap))
  (^BorderLayout []
    (new BorderLayout )))

(def *-north
  "Static Constant.

  The north layout constraint (top of container).

  type: java.lang.String"
  BorderLayout/NORTH)

(def *-south
  "Static Constant.

  The south layout constraint (bottom of container).

  type: java.lang.String"
  BorderLayout/SOUTH)

(def *-east
  "Static Constant.

  The east layout constraint (right side of container).

  type: java.lang.String"
  BorderLayout/EAST)

(def *-west
  "Static Constant.

  The west layout constraint (left side of container).

  type: java.lang.String"
  BorderLayout/WEST)

(def *-center
  "Static Constant.

  The center layout constraint (middle of container).

  type: java.lang.String"
  BorderLayout/CENTER)

(def *-before-first-line
  "Static Constant.

  Synonym for PAGE_START.  Exists for compatibility with previous
   versions.  PAGE_START is preferred.

  type: java.lang.String"
  BorderLayout/BEFORE_FIRST_LINE)

(def *-after-last-line
  "Static Constant.

  Synonym for PAGE_END.  Exists for compatibility with previous
   versions.  PAGE_END is preferred.

  type: java.lang.String"
  BorderLayout/AFTER_LAST_LINE)

(def *-before-line-begins
  "Static Constant.

  Synonym for LINE_START.  Exists for compatibility with previous
   versions.  LINE_START is preferred.

  type: java.lang.String"
  BorderLayout/BEFORE_LINE_BEGINS)

(def *-after-line-ends
  "Static Constant.

  Synonym for LINE_END.  Exists for compatibility with previous
   versions.  LINE_END is preferred.

  type: java.lang.String"
  BorderLayout/AFTER_LINE_ENDS)

(def *-page-start
  "Static Constant.

  The component comes before the first line of the layout's content.
   For Western, left-to-right and top-to-bottom orientations, this is
   equivalent to NORTH.

  type: java.lang.String"
  BorderLayout/PAGE_START)

(def *-page-end
  "Static Constant.

  The component comes after the last line of the layout's content.
   For Western, left-to-right and top-to-bottom orientations, this is
   equivalent to SOUTH.

  type: java.lang.String"
  BorderLayout/PAGE_END)

(def *-line-start
  "Static Constant.

  The component goes at the beginning of the line direction for the
   layout. For Western, left-to-right and top-to-bottom orientations,
   this is equivalent to WEST.

  type: java.lang.String"
  BorderLayout/LINE_START)

(def *-line-end
  "Static Constant.

  The component goes at the end of the line direction for the
   layout. For Western, left-to-right and top-to-bottom orientations,
   this is equivalent to EAST.

  type: java.lang.String"
  BorderLayout/LINE_END)

(defn get-vgap
  "Returns the vertical gap between components.

  returns: `int`"
  (^Integer [^BorderLayout this]
    (-> this (.getVgap))))

(defn invalidate-layout
  "Invalidates the layout, indicating that if the layout manager
   has cached information it should be discarded.

  target - `java.awt.Container`"
  ([^BorderLayout this ^java.awt.Container target]
    (-> this (.invalidateLayout target))))

(defn get-layout-alignment-y
  "Returns the alignment along the y axis.  This specifies how
   the component would like to be aligned relative to other
   components.  The value should be a number between 0 and 1
   where 0 represents alignment along the origin, 1 is aligned
   the furthest away from the origin, 0.5 is centered, etc.

  parent - `java.awt.Container`

  returns: `float`"
  (^Float [^BorderLayout this ^java.awt.Container parent]
    (-> this (.getLayoutAlignmentY parent))))

(defn set-hgap
  "Sets the horizontal gap between components.

  hgap - the horizontal gap between components - `int`"
  ([^BorderLayout this ^Integer hgap]
    (-> this (.setHgap hgap))))

(defn get-layout-component
  "Returns the component that corresponds to the given constraint location
   based on the target Container's component orientation.
   Components added with the relative constraints PAGE_START,
   PAGE_END, LINE_START, and LINE_END
   take precedence over components added with the explicit constraints
   NORTH, SOUTH, WEST, and EAST.
   The Container's component orientation is used to determine the location of components
   added with LINE_START and LINE_END.

  target - the Container used to obtain the constraint location based on the target Container's component orientation. - `java.awt.Container`
  constraints - the desired absolute position, one of CENTER, NORTH, SOUTH, EAST, WEST - `java.lang.Object`

  returns: the component at the given location, or null if
            the location is empty - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if the constraint object is not one of the five specified constants"
  (^java.awt.Component [^BorderLayout this ^java.awt.Container target ^java.lang.Object constraints]
    (-> this (.getLayoutComponent target constraints)))
  (^java.awt.Component [^BorderLayout this ^java.lang.Object constraints]
    (-> this (.getLayoutComponent constraints))))

(defn set-vgap
  "Sets the vertical gap between components.

  vgap - the vertical gap between components - `int`"
  ([^BorderLayout this ^Integer vgap]
    (-> this (.setVgap vgap))))

(defn preferred-layout-size
  "Determines the preferred size of the target
   container using this layout manager, based on the components
   in the container.

   Most applications do not call this method directly. This method
   is called when a container calls its getPreferredSize
   method.

  target - the container in which to do the layout. - `java.awt.Container`

  returns: the preferred dimensions to lay out the subcomponents
            of the specified container. - `java.awt.Dimension`"
  (^java.awt.Dimension [^BorderLayout this ^java.awt.Container target]
    (-> this (.preferredLayoutSize target))))

(defn to-string
  "Returns a string representation of the state of this border layout.

  returns: a string representation of this border layout. - `java.lang.String`"
  (^java.lang.String [^BorderLayout this]
    (-> this (.toString))))

(defn get-hgap
  "Returns the horizontal gap between components.

  returns: `int`"
  (^Integer [^BorderLayout this]
    (-> this (.getHgap))))

(defn get-layout-alignment-x
  "Returns the alignment along the x axis.  This specifies how
   the component would like to be aligned relative to other
   components.  The value should be a number between 0 and 1
   where 0 represents alignment along the origin, 1 is aligned
   the furthest away from the origin, 0.5 is centered, etc.

  parent - `java.awt.Container`

  returns: `float`"
  (^Float [^BorderLayout this ^java.awt.Container parent]
    (-> this (.getLayoutAlignmentX parent))))

(defn minimum-layout-size
  "Determines the minimum size of the target container
   using this layout manager.

   This method is called when a container calls its
   getMinimumSize method. Most applications do not call
   this method directly.

  target - the container in which to do the layout. - `java.awt.Container`

  returns: the minimum dimensions needed to lay out the subcomponents
            of the specified container. - `java.awt.Dimension`"
  (^java.awt.Dimension [^BorderLayout this ^java.awt.Container target]
    (-> this (.minimumLayoutSize target))))

(defn get-constraints
  "Gets the constraints for the specified component

  comp - the component to be queried - `java.awt.Component`

  returns: the constraint for the specified component,
            or null if component is null or is not present
            in this layout - `java.lang.Object`"
  (^java.lang.Object [^BorderLayout this ^java.awt.Component comp]
    (-> this (.getConstraints comp))))

(defn maximum-layout-size
  "Returns the maximum dimensions for this layout given the components
   in the specified target container.

  target - the component which needs to be laid out - `java.awt.Container`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^BorderLayout this ^java.awt.Container target]
    (-> this (.maximumLayoutSize target))))

(defn add-layout-component
  "Adds the specified component to the layout, using the specified
   constraint object.  For border layouts, the constraint must be
   one of the following constants:  NORTH,
   SOUTH, EAST,
   WEST, or CENTER.

   Most applications do not call this method directly. This method
   is called when a component is added to a container using the
   Container.add method with the same argument types.

  comp - the component to be added. - `java.awt.Component`
  constraints - an object that specifies how and where the component is added to the layout. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the constraint object is not a string, or if it not one of the five specified constants."
  ([^BorderLayout this ^java.awt.Component comp ^java.lang.Object constraints]
    (-> this (.addLayoutComponent comp constraints))))

(defn remove-layout-component
  "Removes the specified component from this border layout. This
   method is called when a container calls its remove or
   removeAll methods. Most applications do not call this
   method directly.

  comp - the component to be removed. - `java.awt.Component`"
  ([^BorderLayout this ^java.awt.Component comp]
    (-> this (.removeLayoutComponent comp))))

(defn layout-container
  "Lays out the container argument using this border layout.

   This method actually reshapes the components in the specified
   container in order to satisfy the constraints of this
   BorderLayout object. The NORTH
   and SOUTH components, if any, are placed at
   the top and bottom of the container, respectively. The
   WEST and EAST components are
   then placed on the left and right, respectively. Finally,
   the CENTER object is placed in any remaining
   space in the middle.

   Most applications do not call this method directly. This method
   is called when a container calls its doLayout method.

  target - the container in which to do the layout. - `java.awt.Container`"
  ([^BorderLayout this ^java.awt.Container target]
    (-> this (.layoutContainer target))))

