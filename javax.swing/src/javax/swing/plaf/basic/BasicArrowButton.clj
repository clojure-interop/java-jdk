(ns javax.swing.plaf.basic.BasicArrowButton
  "JButton object that draws a scaled Arrow in one of the cardinal directions.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicArrowButton]))

(defn ->basic-arrow-button
  "Constructor.

  Creates a BasicArrowButton whose arrow
   is drawn in the specified direction and with the specified
   colors.

  direction - the direction of the arrow; one of SwingConstants.NORTH, SwingConstants.SOUTH, SwingConstants.EAST or SwingConstants.WEST - `int`
  background - the background color of the button - `java.awt.Color`
  shadow - the color of the shadow - `java.awt.Color`
  dark-shadow - the color of the dark shadow - `java.awt.Color`
  highlight - the color of the highlight - `java.awt.Color`"
  ([direction background shadow dark-shadow highlight]
    (new BasicArrowButton direction background shadow dark-shadow highlight))
  ([direction]
    (new BasicArrowButton direction)))

(defn get-direction
  "Returns the direction of the arrow.

  returns: `int`"
  ([this]
    (-> this (.getDirection))))

(defn set-direction
  "Sets the direction of the arrow.

  direction - the direction of the arrow; one of of SwingConstants.NORTH, SwingConstants.SOUTH, SwingConstants.EAST or SwingConstants.WEST - `int`"
  ([this direction]
    (-> this (.setDirection direction))))

(defn paint
  "Description copied from class: JComponent

  g - the Graphics context in which to paint - `java.awt.Graphics`"
  ([this g]
    (-> this (.paint g))))

(defn get-preferred-size
  "Returns the preferred size of the BasicArrowButton.

  returns: the preferred size - `java.awt.Dimension`"
  ([this]
    (-> this (.getPreferredSize))))

(defn get-minimum-size
  "Returns the minimum size of the BasicArrowButton.

  returns: the minimum size - `java.awt.Dimension`"
  ([this]
    (-> this (.getMinimumSize))))

(defn get-maximum-size
  "Returns the maximum size of the BasicArrowButton.

  returns: the maximum size - `java.awt.Dimension`"
  ([this]
    (-> this (.getMaximumSize))))

(defn focus-traversable?
  "Returns whether the arrow button should get the focus.
   BasicArrowButtons are used as a child component of
   composite components such as JScrollBar and
   JComboBox. Since the composite component typically gets the
   focus, this method is overriden to return false.

  returns: false - `boolean`"
  ([this]
    (-> this (.isFocusTraversable))))

(defn paint-triangle
  "Paints a triangle.

  g - the Graphics to draw to - `java.awt.Graphics`
  x - the x coordinate - `int`
  y - the y coordinate - `int`
  size - the size of the triangle to draw - `int`
  direction - the direction in which to draw the arrow; one of SwingConstants.NORTH, SwingConstants.SOUTH, SwingConstants.EAST or SwingConstants.WEST - `int`
  is-enabled - whether or not the arrow is drawn enabled - `boolean`"
  ([this g x y size direction is-enabled]
    (-> this (.paintTriangle g x y size direction is-enabled))))

