(ns jdk.awt.GridLayout
  "The GridLayout class is a layout manager that
  lays out a container's components in a rectangular grid.
  The container is divided into equal-sized rectangles,
  and one component is placed in each rectangle.
  For example, the following is an applet that lays out six buttons
  into three rows and two columns:




  import java.awt.*;
  import java.applet.Applet;
  public class ButtonGrid extends Applet {
      public void init() {
          setLayout(new GridLayout(3,2));
          add(new Button(\"1\"));
          add(new Button(\"2\"));
          add(new Button(\"3\"));
          add(new Button(\"4\"));
          add(new Button(\"5\"));
          add(new Button(\"6\"));
      }
  }

  If the container's ComponentOrientation property is horizontal
  and left-to-right, the above example produces the output shown in Figure 1.
  If the container's ComponentOrientation property is horizontal
  and right-to-left, the example produces the output shown in Figure 2.











  Figure 1: Horizontal, Left-to-Right

  Figure 2: Horizontal, Right-to-Left



  When both the number of rows and the number of columns have
  been set to non-zero values, either by a constructor or
  by the setRows and setColumns methods, the number of
  columns specified is ignored.  Instead, the number of
  columns is determined from the specified number of rows
  and the total number of components in the layout. So, for
  example, if three rows and two columns have been specified
  and nine components are added to the layout, they will
  be displayed as three rows of three columns.  Specifying
  the number of columns affects the layout only when the
  number of rows is set to zero."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt GridLayout]))

(defn ->grid-layout
  "Constructor.

  Creates a grid layout with the specified number of rows and
   columns. All components in the layout are given equal size.

   In addition, the horizontal and vertical gaps are set to the
   specified values. Horizontal gaps are placed between each
   of the columns. Vertical gaps are placed between each of
   the rows.

   One, but not both, of rows and cols can
   be zero, which means that any number of objects can be placed in a
   row or in a column.

   All GridLayout constructors defer to this one.

  rows - the rows, with the value zero meaning any number of rows - `int`
  cols - the columns, with the value zero meaning any number of columns - `int`
  hgap - the horizontal gap - `int`
  vgap - the vertical gap - `int`

  throws: java.lang.IllegalArgumentException - if the value of both rows and cols is set to zero"
  (^GridLayout [^Integer rows ^Integer cols ^Integer hgap ^Integer vgap]
    (new GridLayout rows cols hgap vgap))
  (^GridLayout [^Integer rows ^Integer cols]
    (new GridLayout rows cols))
  (^GridLayout []
    (new GridLayout )))

(defn get-vgap
  "Gets the vertical gap between components.

  returns: the vertical gap between components - `int`"
  (^Integer [^GridLayout this]
    (-> this (.getVgap))))

(defn set-columns
  "Sets the number of columns in this layout to the specified value.
   Setting the number of columns has no affect on the layout
   if the number of rows specified by a constructor or by
   the setRows method is non-zero. In that case, the number
   of columns displayed in the layout is determined by the total
   number of components and the number of rows specified.

  cols - the number of columns in this layout - `int`

  throws: java.lang.IllegalArgumentException - if the value of both rows and cols is set to zero"
  ([^GridLayout this ^Integer cols]
    (-> this (.setColumns cols))))

(defn set-hgap
  "Sets the horizontal gap between components to the specified value.

  hgap - the horizontal gap between components - `int`"
  ([^GridLayout this ^Integer hgap]
    (-> this (.setHgap hgap))))

(defn get-columns
  "Gets the number of columns in this layout.

  returns: the number of columns in this layout - `int`"
  (^Integer [^GridLayout this]
    (-> this (.getColumns))))

(defn set-vgap
  "Sets the vertical gap between components to the specified value.

  vgap - the vertical gap between components - `int`"
  ([^GridLayout this ^Integer vgap]
    (-> this (.setVgap vgap))))

(defn preferred-layout-size
  "Determines the preferred size of the container argument using
   this grid layout.

   The preferred width of a grid layout is the largest preferred
   width of all of the components in the container times the number of
   columns, plus the horizontal padding times the number of columns
   minus one, plus the left and right insets of the target container.

   The preferred height of a grid layout is the largest preferred
   height of all of the components in the container times the number of
   rows, plus the vertical padding times the number of rows minus one,
   plus the top and bottom insets of the target container.

  parent - the container in which to do the layout - `java.awt.Container`

  returns: the preferred dimensions to lay out the
                        subcomponents of the specified container - `java.awt.Dimension`"
  (^java.awt.Dimension [^GridLayout this ^java.awt.Container parent]
    (-> this (.preferredLayoutSize parent))))

(defn to-string
  "Returns the string representation of this grid layout's values.

  returns: a string representation of this grid layout - `java.lang.String`"
  (^java.lang.String [^GridLayout this]
    (-> this (.toString))))

(defn get-hgap
  "Gets the horizontal gap between components.

  returns: the horizontal gap between components - `int`"
  (^Integer [^GridLayout this]
    (-> this (.getHgap))))

(defn minimum-layout-size
  "Determines the minimum size of the container argument using this
   grid layout.

   The minimum width of a grid layout is the largest minimum width
   of all of the components in the container times the number of columns,
   plus the horizontal padding times the number of columns minus one,
   plus the left and right insets of the target container.

   The minimum height of a grid layout is the largest minimum height
   of all of the components in the container times the number of rows,
   plus the vertical padding times the number of rows minus one, plus
   the top and bottom insets of the target container.

  parent - the container in which to do the layout - `java.awt.Container`

  returns: the minimum dimensions needed to lay out the
                        subcomponents of the specified container - `java.awt.Dimension`"
  (^java.awt.Dimension [^GridLayout this ^java.awt.Container parent]
    (-> this (.minimumLayoutSize parent))))

(defn get-rows
  "Gets the number of rows in this layout.

  returns: the number of rows in this layout - `int`"
  (^Integer [^GridLayout this]
    (-> this (.getRows))))

(defn add-layout-component
  "Adds the specified component with the specified name to the layout.

  name - the name of the component - `java.lang.String`
  comp - the component to be added - `java.awt.Component`"
  ([^GridLayout this ^java.lang.String name ^java.awt.Component comp]
    (-> this (.addLayoutComponent name comp))))

(defn set-rows
  "Sets the number of rows in this layout to the specified value.

  rows - the number of rows in this layout - `int`

  throws: java.lang.IllegalArgumentException - if the value of both rows and cols is set to zero"
  ([^GridLayout this ^Integer rows]
    (-> this (.setRows rows))))

(defn remove-layout-component
  "Removes the specified component from the layout.

  comp - the component to be removed - `java.awt.Component`"
  ([^GridLayout this ^java.awt.Component comp]
    (-> this (.removeLayoutComponent comp))))

(defn layout-container
  "Lays out the specified container using this layout.

   This method reshapes the components in the specified target
   container in order to satisfy the constraints of the
   GridLayout object.

   The grid layout manager determines the size of individual
   components by dividing the free space in the container into
   equal-sized portions according to the number of rows and columns
   in the layout. The container's free space equals the container's
   size minus any insets and any specified horizontal or vertical
   gap. All components in a grid layout are given the same size.

  parent - the container in which to do the layout - `java.awt.Container`"
  ([^GridLayout this ^java.awt.Container parent]
    (-> this (.layoutContainer parent))))

