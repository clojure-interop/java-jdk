(ns jdk.awt.GridBagLayout
  "The GridBagLayout class is a flexible layout
  manager that aligns components vertically, horizontally or along their
  baseline without requiring that the components be of the same size.
  Each GridBagLayout object maintains a dynamic,
  rectangular grid of cells, with each component occupying
  one or more cells, called its display area.

  Each component managed by a GridBagLayout is associated with
  an instance of GridBagConstraints.  The constraints object
  specifies where a component's display area should be located on the grid
  and how the component should be positioned within its display area.  In
  addition to its constraints object, the GridBagLayout also
  considers each component's minimum and preferred sizes in order to
  determine a component's size.

  The overall orientation of the grid depends on the container's
  ComponentOrientation property.  For horizontal left-to-right
  orientations, grid coordinate (0,0) is in the upper left corner of the
  container with x increasing to the right and y increasing downward.  For
  horizontal right-to-left orientations, grid coordinate (0,0) is in the upper
  right corner of the container with x increasing to the left and y
  increasing downward.

  To use a grid bag layout effectively, you must customize one or more
  of the GridBagConstraints objects that are associated
  with its components. You customize a GridBagConstraints
  object by setting one or more of its instance variables:


  GridBagConstraints.gridx,
  GridBagConstraints.gridy
  Specifies the cell containing the leading corner of the component's
  display area, where the cell at the origin of the grid has address
  gridx = 0,
  gridy = 0.  For horizontal left-to-right layout,
  a component's leading corner is its upper left.  For horizontal
  right-to-left layout, a component's leading corner is its upper right.
  Use GridBagConstraints.RELATIVE (the default value)
  to specify that the component be placed immediately following
  (along the x axis for gridx or the y axis for
  gridy) the component that was added to the container
  just before this component was added.
  GridBagConstraints.gridwidth,
  GridBagConstraints.gridheight
  Specifies the number of cells in a row (for gridwidth)
  or column (for gridheight)
  in the component's display area.
  The default value is 1.
  Use GridBagConstraints.REMAINDER to specify
  that the component's display area will be from gridx
  to the last cell in the row (for gridwidth)
  or from gridy to the last cell in the column
  (for gridheight).

  Use GridBagConstraints.RELATIVE to specify
  that the component's display area will be from gridx
  to the next to the last cell in its row (for gridwidth
  or from gridy to the next to the last cell in its
  column (for gridheight).

  GridBagConstraints.fill
  Used when the component's display area
  is larger than the component's requested size
  to determine whether (and how) to resize the component.
  Possible values are
  GridBagConstraints.NONE (the default),
  GridBagConstraints.HORIZONTAL
  (make the component wide enough to fill its display area
  horizontally, but don't change its height),
  GridBagConstraints.VERTICAL
  (make the component tall enough to fill its display area
  vertically, but don't change its width), and
  GridBagConstraints.BOTH
  (make the component fill its display area entirely).
  GridBagConstraints.ipadx,
  GridBagConstraints.ipady
  Specifies the component's internal padding within the layout,
  how much to add to the minimum size of the component.
  The width of the component will be at least its minimum width
  plus ipadx pixels. Similarly, the height of
  the component will be at least the minimum height plus
  ipady pixels.
  GridBagConstraints.insets
  Specifies the component's external padding, the minimum
  amount of space between the component and the edges of its display area.
  GridBagConstraints.anchor
  Specifies where the component should be positioned in its display area.
  There are three kinds of possible values: absolute, orientation-relative,
  and baseline-relative
  Orientation relative values are interpreted relative to the container's
  ComponentOrientation property while absolute values
  are not.  Baseline relative values are calculated relative to the
  baseline.  Valid values are:



  Absolute Values
  Orientation Relative Values
  Baseline Relative Values




  GridBagConstraints.NORTH
  GridBagConstraints.SOUTH
  GridBagConstraints.WEST
  GridBagConstraints.EAST
  GridBagConstraints.NORTHWEST
  GridBagConstraints.NORTHEAST
  GridBagConstraints.SOUTHWEST
  GridBagConstraints.SOUTHEAST
  GridBagConstraints.CENTER (the default)




  GridBagConstraints.PAGE_START
  GridBagConstraints.PAGE_END
  GridBagConstraints.LINE_START
  GridBagConstraints.LINE_END
  GridBagConstraints.FIRST_LINE_START
  GridBagConstraints.FIRST_LINE_END
  GridBagConstraints.LAST_LINE_START
  GridBagConstraints.LAST_LINE_END




  GridBagConstraints.BASELINE
  GridBagConstraints.BASELINE_LEADING
  GridBagConstraints.BASELINE_TRAILING
  GridBagConstraints.ABOVE_BASELINE
  GridBagConstraints.ABOVE_BASELINE_LEADING
  GridBagConstraints.ABOVE_BASELINE_TRAILING
  GridBagConstraints.BELOW_BASELINE
  GridBagConstraints.BELOW_BASELINE_LEADING
  GridBagConstraints.BELOW_BASELINE_TRAILING




  GridBagConstraints.weightx,
  GridBagConstraints.weighty
  Used to determine how to distribute space, which is
  important for specifying resizing behavior.
  Unless you specify a weight for at least one component
  in a row (weightx) and column (weighty),
  all the components clump together in the center of their container.
  This is because when the weight is zero (the default),
  the GridBagLayout object puts any extra space
  between its grid of cells and the edges of the container.


  Each row may have a baseline; the baseline is determined by the
  components in that row that have a valid baseline and are aligned
  along the baseline (the component's anchor value is one of BASELINE, BASELINE_LEADING or BASELINE_TRAILING).
  If none of the components in the row has a valid baseline, the row
  does not have a baseline.

  If a component spans rows it is aligned either to the baseline of
  the start row (if the baseline-resize behavior is CONSTANT_ASCENT) or the end row (if the baseline-resize behavior
  is CONSTANT_DESCENT).  The row that the component is
  aligned to is called the prevailing row.

  The following figure shows a baseline layout and includes a
  component that spans rows:






  This layout consists of three components:
  A panel that starts in row 0 and ends in row 1.  The panel
    has a baseline-resize behavior of CONSTANT_DESCENT and has
    an anchor of BASELINE.  As the baseline-resize behavior
    is CONSTANT_DESCENT the prevailing row for the panel is
    row 1.
  Two buttons, each with a baseline-resize behavior of
    CENTER_OFFSET and an anchor of BASELINE.

  Because the second button and the panel share the same prevailing row,
  they are both aligned along their baseline.

  Components positioned using one of the baseline-relative values resize
  differently than when positioned using an absolute or orientation-relative
  value.  How components change is dictated by how the baseline of the
  prevailing row changes.  The baseline is anchored to the
  bottom of the display area if any components with the same prevailing row
  have a baseline-resize behavior of CONSTANT_DESCENT,
  otherwise the baseline is anchored to the top of the display area.
  The following rules dictate the resize behavior:

  Resizable components positioned above the baseline can only
  grow as tall as the baseline.  For example, if the baseline is at 100
  and anchored at the top, a resizable component positioned above the
  baseline can never grow more than 100 units.
  Similarly, resizable components positioned below the baseline can
  only grow as high as the difference between the display height and the
  baseline.
  Resizable components positioned on the baseline with a
  baseline-resize behavior of OTHER are only resized if
  the baseline at the resized size fits within the display area.  If
  the baseline is such that it does not fit within the display area
  the component is not resized.
  Components positioned on the baseline that do not have a
  baseline-resize behavior of OTHER
  can only grow as tall as display height - baseline  baseline of component.

  If you position a component along the baseline, but the
  component does not have a valid baseline, it will be vertically centered
  in its space.  Similarly if you have positioned a component relative
  to the baseline and none of the components in the row have a valid
  baseline the component is vertically centered.

  The following figures show ten components (all buttons)
  managed by a grid bag layout.  Figure 2 shows the layout for a horizontal,
  left-to-right container and Figure 3 shows the layout for a horizontal,
  right-to-left container.










  Figure 2: Horizontal, Left-to-Right
  Figure 3: Horizontal, Right-to-Left



  Each of the ten components has the fill field
  of its associated GridBagConstraints object
  set to GridBagConstraints.BOTH.
  In addition, the components have the following non-default constraints:


  Button1, Button2, Button3: weightx = 1.0
  Button4: weightx = 1.0,
  gridwidth = GridBagConstraints.REMAINDER
  Button5: gridwidth = GridBagConstraints.REMAINDER
  Button6: gridwidth = GridBagConstraints.RELATIVE
  Button7: gridwidth = GridBagConstraints.REMAINDER
  Button8: gridheight = 2,
  weighty = 1.0
  Button9, Button 10:
  gridwidth = GridBagConstraints.REMAINDER


  Here is the code that implements the example shown above:



  import java.awt.*;
  import java.util.*;
  import java.applet.Applet;

  public class GridBagEx1 extends Applet {

      protected void makebutton(String name,
                                GridBagLayout gridbag,
                                GridBagConstraints c) {
          Button button = new Button(name);
          gridbag.setConstraints(button, c);
          add(button);
      }

      public void init() {
          GridBagLayout gridbag = new GridBagLayout();
          GridBagConstraints c = new GridBagConstraints();

          setFont(new Font(`SansSerif`, Font.PLAIN, 14));
          setLayout(gridbag);

          c.fill = GridBagConstraints.BOTH;
          c.weightx = 1.0;
          makebutton(`Button1`, gridbag, c);
          makebutton(`Button2`, gridbag, c);
          makebutton(`Button3`, gridbag, c);

          c.gridwidth = GridBagConstraints.REMAINDER; //end row
          makebutton(`Button4`, gridbag, c);

          c.weightx = 0.0;                //reset to the default
          makebutton(`Button5`, gridbag, c); //another row

          c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last in row
          makebutton(`Button6`, gridbag, c);

          c.gridwidth = GridBagConstraints.REMAINDER; //end row
          makebutton(`Button7`, gridbag, c);

          c.gridwidth = 1;                //reset to the default
          c.gridheight = 2;
          c.weighty = 1.0;
          makebutton(`Button8`, gridbag, c);

          c.weighty = 0.0;                //reset to the default
          c.gridwidth = GridBagConstraints.REMAINDER; //end row
          c.gridheight = 1;               //reset to the default
          makebutton(`Button9`, gridbag, c);
          makebutton(`Button10`, gridbag, c);

          setSize(300, 100);
      }

      public static void main(String args[]) {
          Frame f = new Frame(`GridBag Layout Example`);
          GridBagEx1 ex1 = new GridBagEx1();

          ex1.init();

          f.add(`Center`, ex1);
          f.pack();
          f.setSize(f.getPreferredSize());
          f.show();
      }
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt GridBagLayout]))

(defn ->grid-bag-layout
  "Constructor.

  Creates a grid bag layout manager."
  ([]
    (new GridBagLayout )))

(defn -column-widths
  "Instance Field.

  This field holds the overrides to the column minimum
   width.  If this field is non-null the values are
   applied to the gridbag after all of the minimum columns
   widths have been calculated.
   If columnWidths has more elements than the number of
   columns, columns are added to the gridbag to match
   the number of elements in columnWidth.

  type: int[]"
  [this]
  (-> this .-columnWidths))

(defn -row-heights
  "Instance Field.

  This field holds the overrides to the row minimum
   heights.  If this field is non-null the values are
   applied to the gridbag after all of the minimum row
   heights have been calculated.
   If rowHeights has more elements than the number of
   rows, rows are added to the gridbag to match
   the number of elements in rowHeights.

  type: int[]"
  [this]
  (-> this .-rowHeights))

(defn -column-weights
  "Instance Field.

  This field holds the overrides to the column weights.
   If this field is non-null the values are
   applied to the gridbag after all of the columns
   weights have been calculated.
   If columnWeights[i] > weight for column i, then
   column i is assigned the weight in columnWeights[i].
   If columnWeights has more elements than the number
   of columns, the excess elements are ignored - they do
   not cause more columns to be created.

  type: double[]"
  [this]
  (-> this .-columnWeights))

(defn -row-weights
  "Instance Field.

  This field holds the overrides to the row weights.
   If this field is non-null the values are
   applied to the gridbag after all of the rows
   weights have been calculated.
   If rowWeights[i] > weight for row i, then
   row i is assigned the weight in rowWeights[i].
   If rowWeights has more elements than the number
   of rows, the excess elements are ignored - they do
   not cause more rows to be created.

  type: double[]"
  [this]
  (-> this .-rowWeights))

(defn get-layout-weights
  "Determines the weights of the layout grid's columns and rows.
   Weights are used to calculate how much a given column or row
   stretches beyond its preferred size, if the layout has extra
   room to fill.

   Most applications do not call this method directly.

  returns: an array of two arrays, representing the
                      horizontal weights of the layout columns
                      and the vertical weights of the layout rows - `double[][]`"
  ([this]
    (-> this (.getLayoutWeights))))

(defn invalidate-layout
  "Invalidates the layout, indicating that if the layout manager
   has cached information it should be discarded.

  target - `java.awt.Container`"
  ([this target]
    (-> this (.invalidateLayout target))))

(defn get-layout-alignment-y
  "Returns the alignment along the y axis.  This specifies how
   the component would like to be aligned relative to other
   components.  The value should be a number between 0 and 1
   where 0 represents alignment along the origin, 1 is aligned
   the furthest away from the origin, 0.5 is centered, etc.

  parent - `java.awt.Container`

  returns: the value 0.5f to indicate centered - `float`"
  ([this parent]
    (-> this (.getLayoutAlignmentY parent))))

(defn preferred-layout-size
  "Determines the preferred size of the parent
   container using this grid bag layout.

   Most applications do not call this method directly.

  parent - the container in which to do the layout - `java.awt.Container`

  returns: the preferred size of the parent
    container - `java.awt.Dimension`"
  ([this parent]
    (-> this (.preferredLayoutSize parent))))

(defn to-string
  "Returns a string representation of this grid bag layout's values.

  returns: a string representation of this grid bag layout. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn location
  "Determines which cell in the layout grid contains the point
   specified by (x, y). Each cell is identified
   by its column index (ranging from 0 to the number of columns
   minus 1) and its row index (ranging from 0 to the number of
   rows minus 1).

   If the (x, y) point lies
   outside the grid, the following rules are used.
   The column index is returned as zero if x lies to the
   left of the layout for a left-to-right container or to the right of
   the layout for a right-to-left container.  The column index is returned
   as the number of columns if x lies
   to the right of the layout in a left-to-right container or to the left
   in a right-to-left container.
   The row index is returned as zero if y lies above the
   layout, and as the number of rows if y lies
   below the layout.  The orientation of a container is determined by its
   ComponentOrientation property.

  x - the x coordinate of a point - `int`
  y - the y coordinate of a point - `int`

  returns: an ordered pair of indexes that indicate which cell
               in the layout grid contains the point
               (x, y). - `java.awt.Point`"
  ([this x y]
    (-> this (.location x y))))

(defn get-layout-alignment-x
  "Returns the alignment along the x axis.  This specifies how
   the component would like to be aligned relative to other
   components.  The value should be a number between 0 and 1
   where 0 represents alignment along the origin, 1 is aligned
   the furthest away from the origin, 0.5 is centered, etc.

  parent - `java.awt.Container`

  returns: the value 0.5f to indicate centered - `float`"
  ([this parent]
    (-> this (.getLayoutAlignmentX parent))))

(defn minimum-layout-size
  "Determines the minimum size of the parent container
   using this grid bag layout.

   Most applications do not call this method directly.

  parent - the container in which to do the layout - `java.awt.Container`

  returns: the minimum size of the parent container - `java.awt.Dimension`"
  ([this parent]
    (-> this (.minimumLayoutSize parent))))

(defn get-constraints
  "Gets the constraints for the specified component.  A copy of
   the actual GridBagConstraints object is returned.

  comp - the component to be queried - `java.awt.Component`

  returns: the constraint for the specified component in this
                    grid bag layout; a copy of the actual constraint
                    object is returned - `java.awt.GridBagConstraints`"
  ([this comp]
    (-> this (.getConstraints comp))))

(defn set-constraints
  "Sets the constraints for the specified component in this layout.

  comp - the component to be modified - `java.awt.Component`
  constraints - the constraints to be applied - `java.awt.GridBagConstraints`"
  ([this comp constraints]
    (-> this (.setConstraints comp constraints))))

(defn get-layout-origin
  "Determines the origin of the layout area, in the graphics coordinate
   space of the target container.  This value represents the pixel
   coordinates of the top-left corner of the layout area regardless of
   the ComponentOrientation value of the container.  This
   is distinct from the grid origin given by the cell coordinates (0,0).
   Most applications do not call this method directly.

  returns: the graphics origin of the cell in the top-left
               corner of the layout grid - `java.awt.Point`"
  ([this]
    (-> this (.getLayoutOrigin))))

(defn maximum-layout-size
  "Returns the maximum dimensions for this layout given the components
   in the specified target container.

  target - the container which needs to be laid out - `java.awt.Container`

  returns: the maximum dimensions for this layout - `java.awt.Dimension`"
  ([this target]
    (-> this (.maximumLayoutSize target))))

(defn get-layout-dimensions
  "Determines column widths and row heights for the layout grid.

   Most applications do not call this method directly.

  returns: an array of two arrays, containing the widths
                         of the layout columns and
                         the heights of the layout rows - `int[][]`"
  ([this]
    (-> this (.getLayoutDimensions))))

(defn add-layout-component
  "Has no effect, since this layout manager does not use a per-component string.

  name - the string to be associated with the component - `java.lang.String`
  comp - the component to be added - `java.awt.Component`"
  ([this name comp]
    (-> this (.addLayoutComponent name comp))))

(defn remove-layout-component
  "Removes the specified component from this layout.

   Most applications do not call this method directly.

  comp - the component to be removed. - `java.awt.Component`"
  ([this comp]
    (-> this (.removeLayoutComponent comp))))

(defn layout-container
  "Lays out the specified container using this grid bag layout.
   This method reshapes components in the specified container in
   order to satisfy the constraints of this GridBagLayout
   object.

   Most applications do not call this method directly.

  parent - the container in which to do the layout - `java.awt.Container`"
  ([this parent]
    (-> this (.layoutContainer parent))))

