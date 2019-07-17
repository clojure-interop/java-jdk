(ns javax.swing.SpringLayout$Constraints
  "A Constraints object holds the
  constraints that govern the way a component's size and position
  change in a container controlled by a SpringLayout.
  A Constraints object is
  like a Rectangle, in that it
  has x, y,
  width, and height properties.
  In the Constraints object, however,
  these properties have
  Spring values instead of integers.
  In addition,
  a Constraints object
  can be manipulated as four edges
  -- north, south, east, and west --
  using the constraint property.


  The following formulas are always true
  for a Constraints object (here WEST and x are synonyms, as are and NORTH and y):



                EAST = WEST  WIDTH
               SOUTH = NORTH  HEIGHT
   HORIZONTAL_CENTER = WEST  WIDTH/2
     VERTICAL_CENTER = NORTH  HEIGHT/2
   ABSOLUTE_BASELINE = NORTH  RELATIVE_BASELINE*

  For example, if you have specified the WIDTH and WEST (X) location
  the EAST is calculated as WEST  WIDTH.  If you instead specified
  the WIDTH and EAST locations the WEST (X) location is then calculated
  as EAST - WIDTH.

  [RELATIVE_BASELINE is a private constraint that is set automatically when
  the SpringLayout.Constraints(Component) constructor is called or when
  a constraints object is registered with a SpringLayout object.]

  Note: In this document,
  operators represent methods
  in the Spring class.
  For example, `a  b` is equal to
  Spring.sum(a, b),
  and `a - b` is equal to
  Spring.sum(a, Spring.minus(b)).
  See the
  Spring API documentation
  for further details
  of spring arithmetic.



  Because a Constraints object's properties --
  representing its edges, size, and location -- can all be set
  independently and yet are interrelated,
  a Constraints object can become over-constrained.
  For example, if the WEST, WIDTH and
  EAST edges are all set, steps must be taken to ensure that
  the first of the formulas above holds.  To do this, the
  Constraints
  object throws away the least recently set
  constraint so as to make the formulas hold."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing SpringLayout$Constraints]))

(defn ->constraints
  "Constructor.

  Creates a Constraints object with the
   specified values for its
   x, y, width,
   and height properties.
   Note: If the SpringLayout class
   encounters null values in the
   Constraints object of a given component,
   it replaces them with suitable defaults.

  x - the spring value for the x property - `javax.swing.Spring`
  y - the spring value for the y property - `javax.swing.Spring`
  width - the spring value for the width property - `javax.swing.Spring`
  height - the spring value for the height property - `javax.swing.Spring`"
  ([^javax.swing.Spring x ^javax.swing.Spring y ^javax.swing.Spring width ^javax.swing.Spring height]
    (new SpringLayout$Constraints x y width height))
  ([^javax.swing.Spring x ^javax.swing.Spring y]
    (new SpringLayout$Constraints x y))
  ([^java.awt.Component c]
    (new SpringLayout$Constraints c))
  ([]
    (new SpringLayout$Constraints )))

(defn get-width
  "Returns the value of the width property.

  returns: the spring controlling the width of a component - `javax.swing.Spring`"
  ([^javax.swing.SpringLayout$Constraints this]
    (-> this (.getWidth))))

(defn set-width
  "Sets the width property,
   which controls the width of a component.

  width - the spring controlling the width of this Constraints object - `javax.swing.Spring`"
  ([^javax.swing.SpringLayout$Constraints this ^javax.swing.Spring width]
    (-> this (.setWidth width))))

(defn set-height
  "Sets the height property,
   which controls the height of a component.

  height - the spring controlling the height of this Constraints object - `javax.swing.Spring`"
  ([^javax.swing.SpringLayout$Constraints this ^javax.swing.Spring height]
    (-> this (.setHeight height))))

(defn get-constraint
  "Returns the value of the specified edge, which may be
   a derived value, or even null.
   The edge must have one of the following values:
   SpringLayout.NORTH,
   SpringLayout.SOUTH,
   SpringLayout.EAST,
   SpringLayout.WEST,
   SpringLayout.HORIZONTAL_CENTER,
   SpringLayout.VERTICAL_CENTER,
   SpringLayout.BASELINE,
   SpringLayout.WIDTH or
   SpringLayout.HEIGHT.
   For any other String value passed as the edge,
   null will be returned. Throws
   NullPointerException for a null edge.

  edge-name - the edge whose value is to be returned - `java.lang.String`

  returns: the spring controlling the specified edge, may be null - `javax.swing.Spring`

  throws: java.lang.NullPointerException - if edgeName is null"
  ([^javax.swing.SpringLayout$Constraints this ^java.lang.String edge-name]
    (-> this (.getConstraint edge-name))))

(defn get-y
  "Returns the value of the y property.

  returns: the spring controlling the y value
           of a component's location - `javax.swing.Spring`"
  ([^javax.swing.SpringLayout$Constraints this]
    (-> this (.getY))))

(defn get-x
  "Returns the value of the x property.

  returns: the spring controlling the x value
           of a component's location - `javax.swing.Spring`"
  ([^javax.swing.SpringLayout$Constraints this]
    (-> this (.getX))))

(defn get-height
  "Returns the value of the height property.

  returns: the spring controlling the height of a component - `javax.swing.Spring`"
  ([^javax.swing.SpringLayout$Constraints this]
    (-> this (.getHeight))))

(defn set-y
  "Sets the y property,
   which controls the y value
   of a component's location.

  y - the spring controlling the y value of a component's location - `javax.swing.Spring`"
  ([^javax.swing.SpringLayout$Constraints this ^javax.swing.Spring y]
    (-> this (.setY y))))

(defn set-constraint
  "Sets the spring controlling the specified edge.
   The edge must have one of the following values:
   SpringLayout.NORTH,
   SpringLayout.SOUTH,
   SpringLayout.EAST,
   SpringLayout.WEST,
   SpringLayout.HORIZONTAL_CENTER,
   SpringLayout.VERTICAL_CENTER,
   SpringLayout.BASELINE,
   SpringLayout.WIDTH or
   SpringLayout.HEIGHT.
   For any other String value passed as the edge,
   no action is taken. For a null edge, a
   NullPointerException is thrown.

   Note: This method can affect x and y values
   previously set for this Constraints.

  edge-name - the edge to be set - `java.lang.String`
  s - the spring controlling the specified edge - `javax.swing.Spring`

  throws: java.lang.NullPointerException - if edgeName is null"
  ([^javax.swing.SpringLayout$Constraints this ^java.lang.String edge-name ^javax.swing.Spring s]
    (-> this (.setConstraint edge-name s))))

(defn set-x
  "Sets the x property,
   which controls the x value
   of a component's location.

  x - the spring controlling the x value of a component's location - `javax.swing.Spring`"
  ([^javax.swing.SpringLayout$Constraints this ^javax.swing.Spring x]
    (-> this (.setX x))))

