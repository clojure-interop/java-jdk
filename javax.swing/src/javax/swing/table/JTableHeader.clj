(ns javax.swing.table.JTableHeader
  "This is the object which manages the header of the JTable.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.table JTableHeader]))

(defn ->j-table-header
  "Constructor.

  Constructs a JTableHeader which is initialized with
    cm as the column model.  If cm is
    null this method will initialize the table header
    with a default TableColumnModel.

  cm - the column model for the table - `javax.swing.table.TableColumnModel`"
  (^JTableHeader [^javax.swing.table.TableColumnModel cm]
    (new JTableHeader cm))
  (^JTableHeader []
    (new JTableHeader )))

(defn set-column-model
  "Sets the column model for this table to newModel and registers
    for listener notifications from the new column model.

  column-model - the new data source for this table - `javax.swing.table.TableColumnModel`

  throws: java.lang.IllegalArgumentException - if newModel is null"
  ([^JTableHeader this ^javax.swing.table.TableColumnModel column-model]
    (-> this (.setColumnModel column-model))))

(defn set-reordering-allowed
  "Sets whether the user can drag column headers to reorder columns.

  reordering-allowed - true if the table view should allow reordering; otherwise false - `boolean`"
  ([^JTableHeader this ^Boolean reordering-allowed]
    (-> this (.setReorderingAllowed reordering-allowed))))

(defn set-resizing-allowed
  "Sets whether the user can resize columns by dragging between headers.

  resizing-allowed - true if table view should allow resizing - `boolean`"
  ([^JTableHeader this ^Boolean resizing-allowed]
    (-> this (.setResizingAllowed resizing-allowed))))

(defn get-update-table-in-real-time?
  "Obsolete as of Java 2 platform v1.3.  Real time repaints, in response to
   column dragging or resizing, are now unconditional.

  returns: `boolean`"
  (^Boolean [^JTableHeader this]
    (-> this (.getUpdateTableInRealTime))))

(defn get-resizing-allowed?
  "Returns true if the user is allowed to resize columns by dragging
   between their headers, false otherwise. The default is true. You can
   resize columns programmatically regardless of this setting.

  returns: the resizingAllowed property - `boolean`"
  (^Boolean [^JTableHeader this]
    (-> this (.getResizingAllowed))))

(defn set-update-table-in-real-time
  "Obsolete as of Java 2 platform v1.3.  Real time repaints, in response to
   column dragging or resizing, are now unconditional.

  flag - `boolean`"
  ([^JTableHeader this ^Boolean flag]
    (-> this (.setUpdateTableInRealTime flag))))

(defn column-moved
  "Invoked when a column is repositioned.

   Application code will not use these methods explicitly, they
   are used internally by JTable.

  e - the event received - `javax.swing.event.TableColumnModelEvent`"
  ([^JTableHeader this ^javax.swing.event.TableColumnModelEvent e]
    (-> this (.columnMoved e))))

(defn get-dragged-column
  "Returns the the dragged column, if and only if, a drag is in
   process, otherwise returns null.

  returns: the dragged column, if a drag is in
            process, otherwise returns null - `javax.swing.table.TableColumn`"
  (^javax.swing.table.TableColumn [^JTableHeader this]
    (-> this (.getDraggedColumn))))

(defn get-ui-class-id
  "Returns the suffix used to construct the name of the look and feel
   (L&F) class used to render this component.

  returns: the string `TableHeaderUI` - `java.lang.String`"
  (^java.lang.String [^JTableHeader this]
    (-> this (.getUIClassID))))

(defn get-resizing-column
  "Returns the resizing column.  If no column is being
   resized this method returns null.

  returns: the resizing column, if a resize is in process, otherwise
            returns null - `javax.swing.table.TableColumn`"
  (^javax.swing.table.TableColumn [^JTableHeader this]
    (-> this (.getResizingColumn))))

(defn set-dragged-column
  "Sets the header's draggedColumn to aColumn.

    Application code will not use this method explicitly, it is used
    internally by the column dragging mechanism.

  a-column - the column being dragged, or null if no column is being dragged - `javax.swing.table.TableColumn`"
  ([^JTableHeader this ^javax.swing.table.TableColumn a-column]
    (-> this (.setDraggedColumn a-column))))

(defn set-dragged-distance
  "Sets the header's draggedDistance to distance.

  distance - the distance dragged - `int`"
  ([^JTableHeader this ^Integer distance]
    (-> this (.setDraggedDistance distance))))

(defn set-table
  "Sets the table associated with this header.

  table - the new table - `javax.swing.JTable`"
  ([^JTableHeader this ^javax.swing.JTable table]
    (-> this (.setTable table))))

(defn get-header-rect
  "Returns the rectangle containing the header tile at column.
   When the column parameter is out of bounds this method uses the
   same conventions as the JTable method getCellRect.

  column - `int`

  returns: the rectangle containing the header tile at column - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^JTableHeader this ^Integer column]
    (-> this (.getHeaderRect column))))

(defn set-ui
  "Sets the look and feel (L&F) object that renders this component.

  ui - the TableHeaderUI L&F object - `javax.swing.plaf.TableHeaderUI`"
  ([^JTableHeader this ^javax.swing.plaf.TableHeaderUI ui]
    (-> this (.setUI ui))))

(defn get-tool-tip-text
  "Allows the renderer's tips to be used if there is text set.

  event - the location of the event identifies the proper renderer and, therefore, the proper tip - `java.awt.event.MouseEvent`

  returns: the tool tip for this component - `java.lang.String`"
  (^java.lang.String [^JTableHeader this event]
    (-> this (.getToolTipText event))))

(defn get-ui
  "Returns the look and feel (L&F) object that renders this component.

  returns: the TableHeaderUI object that renders this component - `javax.swing.plaf.TableHeaderUI`"
  (^javax.swing.plaf.TableHeaderUI [^JTableHeader this]
    (-> this (.getUI))))

(defn column-margin-changed
  "Invoked when a column is moved due to a margin change.

   Application code will not use these methods explicitly, they
   are used internally by JTable.

  e - the event received - `javax.swing.event.ChangeEvent`"
  ([^JTableHeader this ^javax.swing.event.ChangeEvent e]
    (-> this (.columnMarginChanged e))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JTableHeader.
   For JTableHeaders, the AccessibleContext takes the form of an
   AccessibleJTableHeader.
   A new AccessibleJTableHeader instance is created if necessary.

  returns: an AccessibleJTableHeader that serves as the
           AccessibleContext of this JTableHeader - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^JTableHeader this]
    (-> this (.getAccessibleContext))))

(defn set-resizing-column
  "Sets the header's resizingColumn to aColumn.

    Application code will not use this method explicitly, it
    is used internally by the column sizing mechanism.

  a-column - the column being resized, or null if no column is being resized - `javax.swing.table.TableColumn`"
  ([^JTableHeader this ^javax.swing.table.TableColumn a-column]
    (-> this (.setResizingColumn a-column))))

(defn resize-and-repaint
  "Sizes the header and marks it as needing display.  Equivalent
   to revalidate followed by repaint."
  ([^JTableHeader this]
    (-> this (.resizeAndRepaint))))

(defn column-selection-changed
  "Invoked when the selection model of the TableColumnModel
   is changed.  This method currently has no effect (the header is not
   redrawn).

   Application code will not use these methods explicitly, they
   are used internally by JTable.

  e - the event received - `javax.swing.event.ListSelectionEvent`"
  ([^JTableHeader this ^javax.swing.event.ListSelectionEvent e]
    (-> this (.columnSelectionChanged e))))

(defn column-removed
  "Invoked when a column is removed from the table column model.

   Application code will not use these methods explicitly, they
   are used internally by JTable.

  e - the event received - `javax.swing.event.TableColumnModelEvent`"
  ([^JTableHeader this ^javax.swing.event.TableColumnModelEvent e]
    (-> this (.columnRemoved e))))

(defn get-column-model
  "Returns the TableColumnModel that contains all column information
   of this table header.

  returns: the columnModel property - `javax.swing.table.TableColumnModel`"
  (^javax.swing.table.TableColumnModel [^JTableHeader this]
    (-> this (.getColumnModel))))

(defn get-reordering-allowed?
  "Returns true if the user is allowed to rearrange columns by
   dragging their headers, false otherwise. The default is true. You can
   rearrange columns programmatically regardless of this setting.

  returns: the reorderingAllowed property - `boolean`"
  (^Boolean [^JTableHeader this]
    (-> this (.getReorderingAllowed))))

(defn get-table
  "Returns the table associated with this header.

  returns: the table property - `javax.swing.JTable`"
  (^javax.swing.JTable [^JTableHeader this]
    (-> this (.getTable))))

(defn column-at-point
  "Returns the index of the column that point lies in, or -1 if it
   lies out of bounds.

  point - `java.awt.Point`

  returns: the index of the column that point lies in, or -1 if it
            lies out of bounds - `int`"
  (^Integer [^JTableHeader this ^java.awt.Point point]
    (-> this (.columnAtPoint point))))

(defn get-dragged-distance
  "Returns the column's horizontal distance from its original
   position, if and only if, a drag is in process. Otherwise, the
   the return value is meaningless.

  returns: the column's horizontal distance from its original
            position, if a drag is in process, otherwise the return
            value is meaningless - `int`"
  (^Integer [^JTableHeader this]
    (-> this (.getDraggedDistance))))

(defn column-added
  "Invoked when a column is added to the table column model.

   Application code will not use these methods explicitly, they
   are used internally by JTable.

  e - the event received - `javax.swing.event.TableColumnModelEvent`"
  ([^JTableHeader this ^javax.swing.event.TableColumnModelEvent e]
    (-> this (.columnAdded e))))

(defn get-default-renderer
  "Returns the default renderer used when no headerRenderer
   is defined by a TableColumn.

  returns: the default renderer - `javax.swing.table.TableCellRenderer`"
  (^javax.swing.table.TableCellRenderer [^JTableHeader this]
    (-> this (.getDefaultRenderer))))

(defn update-ui
  "Notification from the UIManager that the look and feel
   (L&F) has changed.
   Replaces the current UI object with the latest version from the
   UIManager."
  ([^JTableHeader this]
    (-> this (.updateUI))))

(defn set-default-renderer
  "Sets the default renderer to be used when no headerRenderer
   is defined by a TableColumn.

  default-renderer - the default renderer - `javax.swing.table.TableCellRenderer`"
  ([^JTableHeader this ^javax.swing.table.TableCellRenderer default-renderer]
    (-> this (.setDefaultRenderer default-renderer))))

