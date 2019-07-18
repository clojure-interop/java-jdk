(ns javax.swing.SpringLayout
  "A SpringLayout lays out the children of its associated container
  according to a set of constraints.
  See How to Use SpringLayout
  in The Java Tutorial for examples of using
  SpringLayout.


  Each constraint,
  represented by a Spring object,
  controls the vertical or horizontal distance
  between two component edges.
  The edges can belong to
  any child of the container,
  or to the container itself.
  For example,
  the allowable width of a component
  can be expressed using a constraint
  that controls the distance between the west (left) and east (right)
  edges of the component.
  The allowable y coordinates for a component
  can be expressed by constraining the distance between
  the north (top) edge of the component
  and the north edge of its container.


  Every child of a SpringLayout-controlled container,
  as well as the container itself,
  has exactly one set of constraints
  associated with it.
  These constraints are represented by
  a SpringLayout.Constraints object.
  By default,
  SpringLayout creates constraints
  that make their associated component
  have the minimum, preferred, and maximum sizes
  returned by the component's
  Component.getMinimumSize(),
  Component.getPreferredSize(), and
  Component.getMaximumSize()
  methods. The x and y positions are initially not
  constrained, so that until you constrain them the Component
  will be positioned at 0,0 relative to the Insets of the
  parent Container.


  You can change
  a component's constraints in several ways.
  You can
  use one of the
  putConstraint
  methods
  to establish a spring
  linking the edges of two components within the same container.
  Or you can get the appropriate SpringLayout.Constraints
  object using
  getConstraints
  and then modify one or more of its springs.
  Or you can get the spring for a particular edge of a component
  using getConstraint,
  and modify it.
  You can also associate
  your own SpringLayout.Constraints object
  with a component by specifying the constraints object
  when you add the component to its container
  (using
  Container.add(Component, Object)).


  The Spring object representing each constraint
  has a minimum, preferred, maximum, and current value.
  The current value of the spring
  is somewhere between the minimum and maximum values,
  according to the formula given in the
  Spring.sum(javax.swing.Spring, javax.swing.Spring) method description.
  When the minimum, preferred, and maximum values are the same,
  the current value is always equal to them;
  this inflexible spring is called a strut.
  You can create struts using the factory method
  Spring.constant(int).
  The Spring class also provides factory methods
  for creating other kinds of springs,
  including springs that depend on other springs.


  In a SpringLayout, the position of each edge is dependent on
  the position of just one other edge. If a constraint is subsequently added
  to create a new binding for an edge, the previous binding is discarded
  and the edge remains dependent on a single edge.
  Springs should only be attached
  between edges of the container and its immediate children; the behavior
  of the SpringLayout when presented with constraints linking
  the edges of components from different containers (either internal or
  external) is undefined.


  SpringLayout vs. Other Layout Managers




  Note:
  Unlike many layout managers,
  SpringLayout doesn't automatically set the location of
  the components it manages.
  If you hand-code a GUI that uses SpringLayout,
  remember to initialize component locations by constraining the west/east
  and north/south locations.

  Depending on the constraints you use,
  you may also need to set the size of the container explicitly.




  Despite the simplicity of SpringLayout,
  it can emulate the behavior of most other layout managers.
  For some features,
  such as the line breaking provided by FlowLayout,
  you'll need to
  create a special-purpose subclass of the Spring class.


  SpringLayout also provides a way to solve
  many of the difficult layout
  problems that cannot be solved by nesting combinations
  of Boxes. That said, SpringLayout honors the
  LayoutManager2 contract correctly and so can be nested with
  other layout managers -- a technique that can be preferable to
  creating the constraints implied by the other layout managers.

  The asymptotic complexity of the layout operation of a SpringLayout
  is linear in the number of constraints (and/or components).

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing SpringLayout]))

(defn ->spring-layout
  "Constructor.

  Constructs a new SpringLayout."
  (^SpringLayout []
    (new SpringLayout )))

(def *-north
  "Static Constant.

  Specifies the top edge of a component's bounding rectangle.

  type: java.lang.String"
  SpringLayout/NORTH)

(def *-south
  "Static Constant.

  Specifies the bottom edge of a component's bounding rectangle.

  type: java.lang.String"
  SpringLayout/SOUTH)

(def *-east
  "Static Constant.

  Specifies the right edge of a component's bounding rectangle.

  type: java.lang.String"
  SpringLayout/EAST)

(def *-west
  "Static Constant.

  Specifies the left edge of a component's bounding rectangle.

  type: java.lang.String"
  SpringLayout/WEST)

(def *-horizontal-center
  "Static Constant.

  Specifies the horizontal center of a component's bounding rectangle.

  type: java.lang.String"
  SpringLayout/HORIZONTAL_CENTER)

(def *-vertical-center
  "Static Constant.

  Specifies the vertical center of a component's bounding rectangle.

  type: java.lang.String"
  SpringLayout/VERTICAL_CENTER)

(def *-baseline
  "Static Constant.

  Specifies the baseline of a component.

  type: java.lang.String"
  SpringLayout/BASELINE)

(def *-width
  "Static Constant.

  Specifies the width of a component's bounding rectangle.

  type: java.lang.String"
  SpringLayout/WIDTH)

(def *-height
  "Static Constant.

  Specifies the height of a component's bounding rectangle.

  type: java.lang.String"
  SpringLayout/HEIGHT)

(defn invalidate-layout
  "Description copied from interface: LayoutManager2

  p - `java.awt.Container`"
  ([^SpringLayout this ^java.awt.Container p]
    (-> this (.invalidateLayout p))))

(defn put-constraint
  "Links edge e1 of component c1 to
   edge e2 of component c2,
   with a fixed distance between the edges. This
   constraint will cause the assignment


       value(e1, c1) = value(e2, c2)  pad
   to take place during all subsequent layout operations.

  e-1 - the edge of the dependent - `java.lang.String`
  c-1 - the component of the dependent - `java.awt.Component`
  pad - the fixed distance between dependent and anchor - `int`
  e-2 - the edge of the anchor - `java.lang.String`
  c-2 - the component of the anchor - `java.awt.Component`"
  ([^SpringLayout this ^java.lang.String e-1 ^java.awt.Component c-1 ^Integer pad ^java.lang.String e-2 ^java.awt.Component c-2]
    (-> this (.putConstraint e-1 c-1 pad e-2 c-2))))

(defn get-layout-alignment-y
  "Returns 0.5f (centered).

  p - `java.awt.Container`

  returns: `float`"
  (^Float [^SpringLayout this ^java.awt.Container p]
    (-> this (.getLayoutAlignmentY p))))

(defn get-constraint
  "Returns the spring controlling the distance between
   the specified edge of
   the component and the top or left edge of its parent. This
   method, instead of returning the current binding for the
   edge, returns a proxy that tracks the characteristics
   of the edge even if the edge is subsequently rebound.
   Proxies are intended to be used in builder environments
   where it is useful to allow the user to define the
   constraints for a layout in any order. Proxies do, however,
   provide the means to create cyclic dependencies amongst
   the constraints of a layout. Such cycles are detected
   internally by SpringLayout so that
   the layout operation always terminates.

  edge-name - must be one of SpringLayout.NORTH, SpringLayout.SOUTH, SpringLayout.EAST, SpringLayout.WEST, SpringLayout.VERTICAL_CENTER, SpringLayout.HORIZONTAL_CENTER or SpringLayout.BASELINE - `java.lang.String`
  c - the component whose edge spring is desired - `java.awt.Component`

  returns: a proxy for the spring controlling the distance between the
           specified edge and the top or left edge of its parent - `javax.swing.Spring`"
  (^javax.swing.Spring [^SpringLayout this ^java.lang.String edge-name ^java.awt.Component c]
    (-> this (.getConstraint edge-name c))))

(defn preferred-layout-size
  "Description copied from interface: LayoutManager

  parent - the container to be laid out - `java.awt.Container`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^SpringLayout this ^java.awt.Container parent]
    (-> this (.preferredLayoutSize parent))))

(defn get-layout-alignment-x
  "Returns 0.5f (centered).

  p - `java.awt.Container`

  returns: `float`"
  (^Float [^SpringLayout this ^java.awt.Container p]
    (-> this (.getLayoutAlignmentX p))))

(defn minimum-layout-size
  "Description copied from interface: LayoutManager

  parent - the component to be laid out - `java.awt.Container`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^SpringLayout this ^java.awt.Container parent]
    (-> this (.minimumLayoutSize parent))))

(defn get-constraints
  "Returns the constraints for the specified component.
   Note that,
   unlike the GridBagLayout
   getConstraints method,
   this method does not clone constraints.
   If no constraints
   have been associated with this component,
   this method
   returns a default constraints object positioned at
   0,0 relative to the parent's Insets and its width/height
   constrained to the minimum, maximum, and preferred sizes of the
   component. The size characteristics
   are not frozen at the time this method is called;
   instead this method returns a constraints object
   whose characteristics track the characteristics
   of the component as they change.

  c - the component whose constraints will be returned - `java.awt.Component`

  returns: the constraints for the specified component - `javax.swing.SpringLayout$Constraints`"
  (^javax.swing.SpringLayout$Constraints [^SpringLayout this ^java.awt.Component c]
    (-> this (.getConstraints c))))

(defn maximum-layout-size
  "Description copied from interface: LayoutManager2

  parent - `java.awt.Container`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^SpringLayout this ^java.awt.Container parent]
    (-> this (.maximumLayoutSize parent))))

(defn add-layout-component
  "Has no effect,
   since this layout manager does not
   use a per-component string.

  name - the string to be associated with the component - `java.lang.String`
  c - the component to be added - `java.awt.Component`"
  ([^SpringLayout this ^java.lang.String name ^java.awt.Component c]
    (-> this (.addLayoutComponent name c))))

(defn remove-layout-component
  "Removes the constraints associated with the specified component.

  c - the component being removed from the container - `java.awt.Component`"
  ([^SpringLayout this ^java.awt.Component c]
    (-> this (.removeLayoutComponent c))))

(defn layout-container
  "Description copied from interface: LayoutManager

  parent - the container to be laid out - `java.awt.Container`"
  ([^SpringLayout this ^java.awt.Container parent]
    (-> this (.layoutContainer parent))))

