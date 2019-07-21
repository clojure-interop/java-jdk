(ns jdk.awt.GridBagConstraints
  "The GridBagConstraints class specifies constraints
  for components that are laid out using the
  GridBagLayout class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt GridBagConstraints]))

(defn ->grid-bag-constraints
  "Constructor.

  Creates a GridBagConstraints object with
   all of its fields set to the passed-in arguments.

   Note: Because the use of this constructor hinders readability
   of source code, this constructor should only be used by
   automatic source code generation tools.

  gridx - The initial gridx value. - `int`
  gridy - The initial gridy value. - `int`
  gridwidth - The initial gridwidth value. - `int`
  gridheight - The initial gridheight value. - `int`
  weightx - The initial weightx value. - `double`
  weighty - The initial weighty value. - `double`
  anchor - The initial anchor value. - `int`
  fill - The initial fill value. - `int`
  insets - The initial insets value. - `java.awt.Insets`
  ipadx - The initial ipadx value. - `int`
  ipady - The initial ipady value. - `int`"
  (^GridBagConstraints [^Integer gridx ^Integer gridy ^Integer gridwidth ^Integer gridheight ^Double weightx ^Double weighty ^Integer anchor ^Integer fill ^java.awt.Insets insets ^Integer ipadx ^Integer ipady]
    (new GridBagConstraints gridx gridy gridwidth gridheight weightx weighty anchor fill insets ipadx ipady))
  (^GridBagConstraints []
    (new GridBagConstraints )))

(def *-relative
  "Static Constant.

  Specifies that this component is the next-to-last component in its
   column or row (gridwidth, gridheight),
   or that this component be placed next to the previously added
   component (gridx, gridy).

  type: int"
  GridBagConstraints/RELATIVE)

(def *-remainder
  "Static Constant.

  Specifies that this component is the
   last component in its column or row.

  type: int"
  GridBagConstraints/REMAINDER)

(def *-none
  "Static Constant.

  Do not resize the component.

  type: int"
  GridBagConstraints/NONE)

(def *-both
  "Static Constant.

  Resize the component both horizontally and vertically.

  type: int"
  GridBagConstraints/BOTH)

(def *-horizontal
  "Static Constant.

  Resize the component horizontally but not vertically.

  type: int"
  GridBagConstraints/HORIZONTAL)

(def *-vertical
  "Static Constant.

  Resize the component vertically but not horizontally.

  type: int"
  GridBagConstraints/VERTICAL)

(def *-center
  "Static Constant.

  Put the component in the center of its display area.

  type: int"
  GridBagConstraints/CENTER)

(def *-north
  "Static Constant.

  Put the component at the top of its display area,
   centered horizontally.

  type: int"
  GridBagConstraints/NORTH)

(def *-northeast
  "Static Constant.

  Put the component at the top-right corner of its display area.

  type: int"
  GridBagConstraints/NORTHEAST)

(def *-east
  "Static Constant.

  Put the component on the right side of its display area,
   centered vertically.

  type: int"
  GridBagConstraints/EAST)

(def *-southeast
  "Static Constant.

  Put the component at the bottom-right corner of its display area.

  type: int"
  GridBagConstraints/SOUTHEAST)

(def *-south
  "Static Constant.

  Put the component at the bottom of its display area, centered
   horizontally.

  type: int"
  GridBagConstraints/SOUTH)

(def *-southwest
  "Static Constant.

  Put the component at the bottom-left corner of its display area.

  type: int"
  GridBagConstraints/SOUTHWEST)

(def *-west
  "Static Constant.

  Put the component on the left side of its display area,
   centered vertically.

  type: int"
  GridBagConstraints/WEST)

(def *-northwest
  "Static Constant.

  Put the component at the top-left corner of its display area.

  type: int"
  GridBagConstraints/NORTHWEST)

(def *-page-start
  "Static Constant.

  Place the component centered along the edge of its display area
   associated with the start of a page for the current
   ComponentOrientation.  Equal to NORTH for horizontal
   orientations.

  type: int"
  GridBagConstraints/PAGE_START)

(def *-page-end
  "Static Constant.

  Place the component centered along the edge of its display area
   associated with the end of a page for the current
   ComponentOrientation.  Equal to SOUTH for horizontal
   orientations.

  type: int"
  GridBagConstraints/PAGE_END)

(def *-line-start
  "Static Constant.

  Place the component centered along the edge of its display area where
   lines of text would normally begin for the current
   ComponentOrientation.  Equal to WEST for horizontal,
   left-to-right orientations and EAST for horizontal, right-to-left
   orientations.

  type: int"
  GridBagConstraints/LINE_START)

(def *-line-end
  "Static Constant.

  Place the component centered along the edge of its display area where
   lines of text would normally end for the current
   ComponentOrientation.  Equal to EAST for horizontal,
   left-to-right orientations and WEST for horizontal, right-to-left
   orientations.

  type: int"
  GridBagConstraints/LINE_END)

(def *-first-line-start
  "Static Constant.

  Place the component in the corner of its display area where
   the first line of text on a page would normally begin for the current
   ComponentOrientation.  Equal to NORTHWEST for horizontal,
   left-to-right orientations and NORTHEAST for horizontal, right-to-left
   orientations.

  type: int"
  GridBagConstraints/FIRST_LINE_START)

(def *-first-line-end
  "Static Constant.

  Place the component in the corner of its display area where
   the first line of text on a page would normally end for the current
   ComponentOrientation.  Equal to NORTHEAST for horizontal,
   left-to-right orientations and NORTHWEST for horizontal, right-to-left
   orientations.

  type: int"
  GridBagConstraints/FIRST_LINE_END)

(def *-last-line-start
  "Static Constant.

  Place the component in the corner of its display area where
   the last line of text on a page would normally start for the current
   ComponentOrientation.  Equal to SOUTHWEST for horizontal,
   left-to-right orientations and SOUTHEAST for horizontal, right-to-left
   orientations.

  type: int"
  GridBagConstraints/LAST_LINE_START)

(def *-last-line-end
  "Static Constant.

  Place the component in the corner of its display area where
   the last line of text on a page would normally end for the current
   ComponentOrientation.  Equal to SOUTHEAST for horizontal,
   left-to-right orientations and SOUTHWEST for horizontal, right-to-left
   orientations.

  type: int"
  GridBagConstraints/LAST_LINE_END)

(def *-baseline
  "Static Constant.

  Possible value for the anchor field.  Specifies
   that the component should be horizontally centered and
   vertically aligned along the baseline of the prevailing row.
   If the component does not have a baseline it will be vertically
   centered.

  type: int"
  GridBagConstraints/BASELINE)

(def *-baseline-leading
  "Static Constant.

  Possible value for the anchor field.  Specifies
   that the component should be horizontally placed along the
   leading edge.  For components with a left-to-right orientation,
   the leading edge is the left edge.  Vertically the component is
   aligned along the baseline of the prevailing row.  If the
   component does not have a baseline it will be vertically
   centered.

  type: int"
  GridBagConstraints/BASELINE_LEADING)

(def *-baseline-trailing
  "Static Constant.

  Possible value for the anchor field.  Specifies
   that the component should be horizontally placed along the
   trailing edge.  For components with a left-to-right
   orientation, the trailing edge is the right edge.  Vertically
   the component is aligned along the baseline of the prevailing
   row.  If the component does not have a baseline it will be
   vertically centered.

  type: int"
  GridBagConstraints/BASELINE_TRAILING)

(def *-above-baseline
  "Static Constant.

  Possible value for the anchor field.  Specifies
   that the component should be horizontally centered.  Vertically
   the component is positioned so that its bottom edge touches
   the baseline of the starting row.  If the starting row does not
   have a baseline it will be vertically centered.

  type: int"
  GridBagConstraints/ABOVE_BASELINE)

(def *-above-baseline-leading
  "Static Constant.

  Possible value for the anchor field.  Specifies
   that the component should be horizontally placed along the
   leading edge.  For components with a left-to-right orientation,
   the leading edge is the left edge.  Vertically the component is
   positioned so that its bottom edge touches the baseline of the
   starting row.  If the starting row does not have a baseline it
   will be vertically centered.

  type: int"
  GridBagConstraints/ABOVE_BASELINE_LEADING)

(def *-above-baseline-trailing
  "Static Constant.

  Possible value for the anchor field.  Specifies
   that the component should be horizontally placed along the
   trailing edge.  For components with a left-to-right
   orientation, the trailing edge is the right edge.  Vertically
   the component is positioned so that its bottom edge touches
   the baseline of the starting row.  If the starting row does not
   have a baseline it will be vertically centered.

  type: int"
  GridBagConstraints/ABOVE_BASELINE_TRAILING)

(def *-below-baseline
  "Static Constant.

  Possible value for the anchor field.  Specifies
   that the component should be horizontally centered.  Vertically
   the component is positioned so that its top edge touches the
   baseline of the starting row.  If the starting row does not
   have a baseline it will be vertically centered.

  type: int"
  GridBagConstraints/BELOW_BASELINE)

(def *-below-baseline-leading
  "Static Constant.

  Possible value for the anchor field.  Specifies
   that the component should be horizontally placed along the
   leading edge.  For components with a left-to-right orientation,
   the leading edge is the left edge.  Vertically the component is
   positioned so that its top edge touches the baseline of the
   starting row.  If the starting row does not have a baseline it
   will be vertically centered.

  type: int"
  GridBagConstraints/BELOW_BASELINE_LEADING)

(def *-below-baseline-trailing
  "Static Constant.

  Possible value for the anchor field.  Specifies
   that the component should be horizontally placed along the
   trailing edge.  For components with a left-to-right
   orientation, the trailing edge is the right edge.  Vertically
   the component is positioned so that its top edge touches the
   baseline of the starting row.  If the starting row does not
   have a baseline it will be vertically centered.

  type: int"
  GridBagConstraints/BELOW_BASELINE_TRAILING)

(defn gridx
  "Instance Field.

  Specifies the cell containing the leading edge of the component's
   display area, where the first cell in a row has gridx=0.
   The leading edge of a component's display area is its left edge for
   a horizontal, left-to-right container and its right edge for a
   horizontal, right-to-left container.
   The value
   RELATIVE specifies that the component be placed
   immediately following the component that was added to the container
   just before this component was added.

   The default value is RELATIVE.
   gridx should be a non-negative value.

  type: int"
  (^Integer [^GridBagConstraints this]
    (-> this .-gridx)))

(defn gridy
  "Instance Field.

  Specifies the cell at the top of the component's display area,
   where the topmost cell has gridy=0. The value
   RELATIVE specifies that the component be placed just
   below the component that was added to the container just before
   this component was added.

   The default value is RELATIVE.
   gridy should be a non-negative value.

  type: int"
  (^Integer [^GridBagConstraints this]
    (-> this .-gridy)))

(defn gridwidth
  "Instance Field.

  Specifies the number of cells in a row for the component's
   display area.

   Use REMAINDER to specify that the component's
   display area will be from gridx to the last
   cell in the row.
   Use RELATIVE to specify that the component's
   display area will be from gridx to the next
   to the last one in its row.

   gridwidth should be non-negative and the default
   value is 1.

  type: int"
  (^Integer [^GridBagConstraints this]
    (-> this .-gridwidth)))

(defn gridheight
  "Instance Field.

  Specifies the number of cells in a column for the component's
   display area.

   Use REMAINDER to specify that the component's
   display area will be from gridy to the last
   cell in the column.
   Use RELATIVE to specify that the component's
   display area will be from gridy to the next
   to the last one in its column.

   gridheight should be a non-negative value and the
   default value is 1.

  type: int"
  (^Integer [^GridBagConstraints this]
    (-> this .-gridheight)))

(defn weightx
  "Instance Field.

  Specifies how to distribute extra horizontal space.

   The grid bag layout manager calculates the weight of a column to
   be the maximum weightx of all the components in a
   column. If the resulting layout is smaller horizontally than the area
   it needs to fill, the extra space is distributed to each column in
   proportion to its weight. A column that has a weight of zero receives
   no extra space.

   If all the weights are zero, all the extra space appears between
   the grids of the cell and the left and right edges.

   The default value of this field is 0.
   weightx should be a non-negative value.

  type: double"
  (^Double [^GridBagConstraints this]
    (-> this .-weightx)))

(defn weighty
  "Instance Field.

  Specifies how to distribute extra vertical space.

   The grid bag layout manager calculates the weight of a row to be
   the maximum weighty of all the components in a row.
   If the resulting layout is smaller vertically than the area it
   needs to fill, the extra space is distributed to each row in
   proportion to its weight. A row that has a weight of zero receives no
   extra space.

   If all the weights are zero, all the extra space appears between
   the grids of the cell and the top and bottom edges.

   The default value of this field is 0.
   weighty should be a non-negative value.

  type: double"
  (^Double [^GridBagConstraints this]
    (-> this .-weighty)))

(defn anchor
  "Instance Field.

  This field is used when the component is smaller than its
   display area. It determines where, within the display area, to
   place the component.
    There are three kinds of possible values: orientation
   relative, baseline relative and absolute.  Orientation relative
   values are interpreted relative to the container's component
   orientation property, baseline relative values are interpreted
   relative to the baseline and absolute values are not.  The
   absolute values are:
   CENTER, NORTH, NORTHEAST,
   EAST, SOUTHEAST, SOUTH,
   SOUTHWEST, WEST, and NORTHWEST.
   The orientation relative values are: PAGE_START,
   PAGE_END,
   LINE_START, LINE_END,
   FIRST_LINE_START, FIRST_LINE_END,
   LAST_LINE_START and LAST_LINE_END.  The
   baseline relative values are:
   BASELINE, BASELINE_LEADING,
   BASELINE_TRAILING,
   ABOVE_BASELINE, ABOVE_BASELINE_LEADING,
   ABOVE_BASELINE_TRAILING,
   BELOW_BASELINE, BELOW_BASELINE_LEADING,
   and BELOW_BASELINE_TRAILING.
   The default value is CENTER.

  type: int"
  (^Integer [^GridBagConstraints this]
    (-> this .-anchor)))

(defn fill
  "Instance Field.

  This field is used when the component's display area is larger
   than the component's requested size. It determines whether to
   resize the component, and if so, how.

   The following values are valid for fill:



   NONE: Do not resize the component.

   HORIZONTAL: Make the component wide enough to fill
           its display area horizontally, but do not change its height.

   VERTICAL: Make the component tall enough to fill its
           display area vertically, but do not change its width.

   BOTH: Make the component fill its display area
           entirely.


   The default value is NONE.

  type: int"
  (^Integer [^GridBagConstraints this]
    (-> this .-fill)))

(defn insets
  "Instance Field.

  This field specifies the external padding of the component, the
   minimum amount of space between the component and the edges of its
   display area.

   The default value is new Insets(0, 0, 0, 0).

  type: java.awt.Insets"
  (^java.awt.Insets [^GridBagConstraints this]
    (-> this .-insets)))

(defn ipadx
  "Instance Field.

  This field specifies the internal padding of the component, how much
   space to add to the minimum width of the component. The width of
   the component is at least its minimum width plus
   ipadx pixels.

   The default value is 0.

  type: int"
  (^Integer [^GridBagConstraints this]
    (-> this .-ipadx)))

(defn ipady
  "Instance Field.

  This field specifies the internal padding, that is, how much
   space to add to the minimum height of the component. The height of
   the component is at least its minimum height plus
   ipady pixels.

   The default value is 0.

  type: int"
  (^Integer [^GridBagConstraints this]
    (-> this .-ipady)))

(defn clone
  "Creates a copy of this grid bag constraint.

  returns: a copy of this grid bag constraint - `java.lang.Object`"
  (^java.lang.Object [^GridBagConstraints this]
    (-> this (.clone))))

