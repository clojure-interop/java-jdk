(ns javax.swing.Box
  "A lightweight container
  that uses a BoxLayout object as its layout manager.
  Box provides several class methods
  that are useful for containers using BoxLayout --
  even non-Box containers.


  The Box class can create several kinds
  of invisible components
  that affect layout:
  glue, struts, and rigid areas.
  If all the components your Box contains
  have a fixed size,
  you might want to use a glue component
  (returned by createGlue)
  to control the components' positions.
  If you need a fixed amount of space between two components,
  try using a strut
  (createHorizontalStrut or createVerticalStrut).
  If you need an invisible component
  that always takes up the same amount of space,
  get it by invoking createRigidArea.

  If you are implementing a BoxLayout you
  can find further information and examples in
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
  (:import [javax.swing Box]))

(defn ->box
  "Constructor.

  Creates a Box that displays its components
   along the the specified axis.

  axis - can be BoxLayout.X_AXIS, BoxLayout.Y_AXIS, BoxLayout.LINE_AXIS or BoxLayout.PAGE_AXIS. - `int`

  throws: java.awt.AWTError - if the axis is invalid"
  (^Box [^Integer axis]
    (new Box axis)))

(defn *create-horizontal-box
  "Creates a Box that displays its components
   from left to right. If you want a Box that
   respects the component orientation you should create the
   Box using the constructor and pass in
   BoxLayout.LINE_AXIS, eg:


     Box lineBox = new Box(BoxLayout.LINE_AXIS);

  returns: the box - `javax.swing.Box`"
  (^javax.swing.Box []
    (Box/createHorizontalBox )))

(defn *create-vertical-box
  "Creates a Box that displays its components
   from top to bottom. If you want a Box that
   respects the component orientation you should create the
   Box using the constructor and pass in
   BoxLayout.PAGE_AXIS, eg:


     Box lineBox = new Box(BoxLayout.PAGE_AXIS);

  returns: the box - `javax.swing.Box`"
  (^javax.swing.Box []
    (Box/createVerticalBox )))

(defn *create-rigid-area
  "Creates an invisible component that's always the specified size.
    WHEN WOULD YOU USE THIS AS OPPOSED TO A STRUT?

  d - the dimensions of the invisible component - `java.awt.Dimension`

  returns: the component - `java.awt.Component`"
  (^java.awt.Component [^java.awt.Dimension d]
    (Box/createRigidArea d)))

(defn *create-horizontal-strut
  "Creates an invisible, fixed-width component.
   In a horizontal box,
   you typically use this method
   to force a certain amount of space between two components.
   In a vertical box,
   you might use this method
   to force the box to be at least the specified width.
   The invisible component has no height
   unless excess space is available,
   in which case it takes its share of available space,
   just like any other component that has no maximum height.

  width - the width of the invisible component, in pixels >= 0 - `int`

  returns: the component - `java.awt.Component`"
  (^java.awt.Component [^Integer width]
    (Box/createHorizontalStrut width)))

(defn *create-vertical-strut
  "Creates an invisible, fixed-height component.
   In a vertical box,
   you typically use this method
   to force a certain amount of space between two components.
   In a horizontal box,
   you might use this method
   to force the box to be at least the specified height.
   The invisible component has no width
   unless excess space is available,
   in which case it takes its share of available space,
   just like any other component that has no maximum width.

  height - the height of the invisible component, in pixels >= 0 - `int`

  returns: the component - `java.awt.Component`"
  (^java.awt.Component [^Integer height]
    (Box/createVerticalStrut height)))

(defn *create-glue
  "Creates an invisible \"glue\" component
   that can be useful in a Box
   whose visible components have a maximum width
   (for a horizontal box)
   or height (for a vertical box).
   You can think of the glue component
   as being a gooey substance
   that expands as much as necessary
   to fill the space between its neighboring components.



   For example, suppose you have
   a horizontal box that contains two fixed-size components.
   If the box gets extra space,
   the fixed-size components won't become larger,
   so where does the extra space go?
   Without glue,
   the extra space goes to the right of the second component.
   If you put glue between the fixed-size components,
   then the extra space goes there.
   If you put glue before the first fixed-size component,
   the extra space goes there,
   and the fixed-size components are shoved against the right
   edge of the box.
   If you put glue before the first fixed-size component
   and after the second fixed-size component,
   the fixed-size components are centered in the box.



   To use glue,
   call Box.createGlue
   and add the returned component to a container.
   The glue component has no minimum or preferred size,
   so it takes no space unless excess space is available.
   If excess space is available,
   then the glue component takes its share of available
   horizontal or vertical space,
   just like any other component that has no maximum width or height.

  returns: the component - `java.awt.Component`"
  (^java.awt.Component []
    (Box/createGlue )))

(defn *create-horizontal-glue
  "Creates a horizontal glue component.

  returns: the component - `java.awt.Component`"
  (^java.awt.Component []
    (Box/createHorizontalGlue )))

(defn *create-vertical-glue
  "Creates a vertical glue component.

  returns: the component - `java.awt.Component`"
  (^java.awt.Component []
    (Box/createVerticalGlue )))

(defn set-layout
  "Throws an AWTError, since a Box can use only a BoxLayout.

  l - the layout manager to use - `java.awt.LayoutManager`"
  ([^Box this ^java.awt.LayoutManager l]
    (-> this (.setLayout l))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this Box.
   For boxes, the AccessibleContext takes the form of an
   AccessibleBox.
   A new AccessibleAWTBox instance is created if necessary.

  returns: an AccessibleBox that serves as the
           AccessibleContext of this Box - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^Box this]
    (-> this (.getAccessibleContext))))

