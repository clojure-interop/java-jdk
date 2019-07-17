(ns javax.swing.table.DefaultTableCellRenderer
  "The standard class for rendering (displaying) individual cells
  in a JTable.


  Implementation Note:
  This class inherits from JLabel, a standard component class.
  However JTable employs a unique mechanism for rendering
  its cells and therefore requires some slightly modified behavior
  from its cell renderer.
  The table class defines a single cell renderer and uses it as a
  as a rubber-stamp for rendering all cells in the table;
  it renders the first cell,
  changes the contents of that cell renderer,
  shifts the origin to the new location, re-draws it, and so on.
  The standard JLabel component was not
  designed to be used this way and we want to avoid
  triggering a revalidate each time the
  cell is drawn. This would greatly decrease performance because the
  revalidate message would be
  passed up the hierarchy of the container to determine whether any other
  components would be affected.
  As the renderer is only parented for the lifetime of a painting operation
  we similarly want to avoid the overhead associated with walking the
  hierarchy for painting operations.
  So this class
  overrides the validate, invalidate,
  revalidate, repaint, and
  firePropertyChange methods to be
  no-ops and override the isOpaque method solely to improve
  performance.  If you write your own renderer,
  please keep this performance consideration in mind.


  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.table DefaultTableCellRenderer]))

(defn ->default-table-cell-renderer
  "Constructor.

  Creates a default table cell renderer."
  ([]
    (new DefaultTableCellRenderer )))

(defn opaque?
  "Overridden for performance reasons.
   See the Implementation Note
   for more information.

  returns: true if this component is completely opaque - `boolean`"
  ([this]
    (-> this (.isOpaque))))

(defn set-foreground
  "Overrides JComponent.setForeground to assign
   the unselected-foreground color to the specified color.

  c - set the foreground color to this value - `java.awt.Color`"
  ([this c]
    (-> this (.setForeground c))))

(defn get-table-cell-renderer-component
  "Returns the default table cell renderer.

   During a printing operation, this method will be called with
   isSelected and hasFocus values of
   false to prevent selection and focus from appearing
   in the printed output. To do other customization based on whether
   or not the table is being printed, check the return value from
   JComponent.isPaintingForPrint().

  table - the JTable - `javax.swing.JTable`
  value - the value to assign to the cell at [row, column] - `java.lang.Object`
  is-selected - true if cell is selected - `boolean`
  has-focus - true if cell has focus - `boolean`
  row - the row of the cell to render - `int`
  column - the column of the cell to render - `int`

  returns: the default table cell renderer - `java.awt.Component`"
  ([this table value is-selected has-focus row column]
    (-> this (.getTableCellRendererComponent table value is-selected has-focus row column))))

(defn fire-property-change
  "Overridden for performance reasons.
   See the Implementation Note
   for more information.

  property-name - the property whose value has changed - `java.lang.String`
  old-value - the property's previous value - `boolean`
  new-value - the property's new value - `boolean`"
  ([this property-name old-value new-value]
    (-> this (.firePropertyChange property-name old-value new-value))))

(defn validate
  "Overridden for performance reasons.
   See the Implementation Note
   for more information."
  ([this]
    (-> this (.validate))))

(defn set-background
  "Overrides JComponent.setBackground to assign
   the unselected-background color to the specified color.

  c - set the background color to this value - `java.awt.Color`"
  ([this c]
    (-> this (.setBackground c))))

(defn repaint
  "Overridden for performance reasons.
   See the Implementation Note
   for more information.

  tm - this parameter is not used - `long`
  x - the x value of the dirty region - `int`
  y - the y value of the dirty region - `int`
  width - the width of the dirty region - `int`
  height - the height of the dirty region - `int`"
  ([this tm x y width height]
    (-> this (.repaint tm x y width height)))
  ([this r]
    (-> this (.repaint r)))
  ([this]
    (-> this (.repaint))))

(defn invalidate
  "Overridden for performance reasons.
   See the Implementation Note
   for more information."
  ([this]
    (-> this (.invalidate))))

(defn revalidate
  "Overridden for performance reasons.
   See the Implementation Note
   for more information."
  ([this]
    (-> this (.revalidate))))

(defn update-ui
  "Notification from the UIManager that the look and feel
   [L&F] has changed.
   Replaces the current UI object with the latest version from the
   UIManager."
  ([this]
    (-> this (.updateUI))))

