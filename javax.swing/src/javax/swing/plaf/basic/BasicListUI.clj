(ns javax.swing.plaf.basic.BasicListUI
  "An extensible implementation of ListUI.

  BasicListUI instances cannot be shared between multiple
  lists."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicListUI]))

(defn ->basic-list-ui
  "Constructor."
  ([]
    (new BasicListUI )))

(defn *create-ui
  "Returns a new instance of BasicListUI.  BasicListUI delegates are
   allocated one per JList.

  list - `javax.swing.JComponent`

  returns: A new ListUI implementation for the Windows look and feel. - `javax.swing.plaf.ComponentUI`"
  ([^javax.swing.JComponent list]
    (BasicListUI/createUI list)))

(defn install-ui
  "Initializes this.list by calling installDefaults(),
   installListeners(), and installKeyboardActions()
   in order.

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicListUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn uninstall-ui
  "Uninitializes this.list by calling uninstallListeners(),
   uninstallKeyboardActions(), and uninstallDefaults()
   in order.  Sets this.list to null.

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicListUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn get-baseline-resize-behavior
  "Returns an enum indicating how the baseline of the component
   changes as the size changes.

  c - JComponent to return baseline resize behavior for - `javax.swing.JComponent`

  returns: an enum indicating how the baseline changes as the component
           size changes - `java.awt.Component.BaselineResizeBehavior`

  throws: java.lang.NullPointerException - if c is null"
  ([^javax.swing.plaf.basic.BasicListUI this ^javax.swing.JComponent c]
    (-> this (.getBaselineResizeBehavior c))))

(defn location-to-index
  "Returns the cell index in the specified JList closest to the
   given location in the list's coordinate system. To determine if the
   cell actually contains the specified location, compare the point against
   the cell's bounds, as provided by getCellBounds.
   This method returns -1 if the list's model is empty.

  list - the list - `javax.swing.JList`
  location - the coordinates of the point - `java.awt.Point`

  returns: the cell index closest to the given location, or -1 - `int`

  throws: java.lang.NullPointerException - if location is null"
  ([^javax.swing.plaf.basic.BasicListUI this ^javax.swing.JList list ^java.awt.Point location]
    (-> this (.locationToIndex list location))))

(defn paint
  "Paint the rows that intersect the Graphics objects clipRect.  This
   method calls paintCell as necessary.  Subclasses
   may want to override these methods.

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicListUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

(defn index-to-location
  "Returns the origin in the given JList, of the specified item,
   in the list's coordinate system.
   Returns null if the index isn't valid.

  list - the list - `javax.swing.JList`
  index - the cell index - `int`

  returns: the origin of the cell, or null - `java.awt.Point`"
  ([^javax.swing.plaf.basic.BasicListUI this ^javax.swing.JList list ^Integer index]
    (-> this (.indexToLocation list index))))

(defn get-cell-bounds
  "Returns the bounding rectangle, in the given list's coordinate system,
   for the range of cells specified by the two indices.
   The indices can be supplied in any order.

   If the smaller index is outside the list's range of cells, this method
   returns null. If the smaller index is valid, but the larger
   index is outside the list's range, the bounds of just the first index
   is returned. Otherwise, the bounds of the valid range is returned.

  list - the list - `javax.swing.JList`
  index-1 - the first index in the range - `int`
  index-2 - the second index in the range - `int`

  returns: the bounding rectangle for the range of cells, or null - `java.awt.Rectangle`"
  ([^javax.swing.plaf.basic.BasicListUI this ^javax.swing.JList list ^Integer index-1 ^Integer index-2]
    (-> this (.getCellBounds list index-1 index-2))))

(defn get-baseline
  "Returns the baseline.

  c - JComponent baseline is being requested for - `javax.swing.JComponent`
  width - the width to get the baseline for - `int`
  height - the height to get the baseline for - `int`

  returns: baseline or a value < 0 indicating there is no reasonable
                    baseline - `int`

  throws: java.lang.NullPointerException - if c is null"
  ([^javax.swing.plaf.basic.BasicListUI this ^javax.swing.JComponent c ^Integer width ^Integer height]
    (-> this (.getBaseline c width height))))

(defn get-preferred-size
  "The preferredSize of the list depends upon the layout orientation.

   Layout OrientationPreferred Size

     JList.VERTICAL
     The preferredSize of the list is total height of the rows
         and the maximum width of the cells.  If JList.fixedCellHeight
         is specified then the total height of the rows is just
         (cellVerticalMargins  fixedCellHeight) * model.getSize() where
         rowVerticalMargins is the space we allocate for drawing
         the yellow focus outline.  Similarly if fixedCellWidth is
         specified then we just use that.


     JList.VERTICAL_WRAP
     If the visible row count is greater than zero, the preferredHeight
         is the maximum cell height * visibleRowCount. If the visible row
         count is <= 0, the preferred height is either the current height
         of the list, or the maximum cell height, whichever is
         bigger. The preferred width is than the maximum cell width *
         number of columns needed. Where the number of columns needs is
         list.height / max cell height. Max cell height is either the fixed
         cell height, or is determined by iterating through all the cells
         to find the maximum height from the ListCellRenderer.

     JList.HORIZONTAL_WRAP
     If the visible row count is greater than zero, the preferredHeight
         is the maximum cell height * adjustedRowCount.  Where
         visibleRowCount is used to determine the number of columns.
         Because this lays out horizontally the number of rows is
         then determined from the column count.  For example, lets say
         you have a model with 10 items and the visible row count is 8.
         The number of columns needed to display this is 2, but you no
         longer need 8 rows to display this, you only need 5, thus
         the adjustedRowCount is 5.
         If the visible row
         count is <= 0, the preferred height is dictated by the
         number of columns, which will be as many as can fit in the width
         of the JList (width / max cell width), with at
         least one column.  The preferred height then becomes the
         model size / number of columns * maximum cell height.
         Max cell height is either the fixed
         cell height, or is determined by iterating through all the cells
         to find the maximum height from the ListCellRenderer.

   The above specifies the raw preferred width and height. The resulting
   preferred width is the above width  insets.left  insets.right and
   the resulting preferred height is the above height  insets.top
   insets.bottom. Where the Insets are determined from
   list.getInsets().

  c - The JList component. - `javax.swing.JComponent`

  returns: The total size of the list. - `java.awt.Dimension`"
  ([^javax.swing.plaf.basic.BasicListUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

