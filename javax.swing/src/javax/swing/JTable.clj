(ns javax.swing.JTable
  "The JTable is used to display and edit regular two-dimensional tables
  of cells.
  See How to Use Tables
  in The Java Tutorial
  for task-oriented documentation and examples of using JTable.


  The JTable has many
  facilities that make it possible to customize its rendering and editing
  but provides defaults for these features so that simple tables can be
  set up easily.  For example, to set up a table with 10 rows and 10
  columns of numbers:



       TableModel dataModel = new AbstractTableModel() {
           public int getColumnCount() { return 10; }
           public int getRowCount() { return 10;}
           public Object getValueAt(int row, int col) { return new Integer(row*col); }
       };
       JTable table = new JTable(dataModel);
       JScrollPane scrollpane = new JScrollPane(table);

  JTables are typically placed inside of a JScrollPane.  By
  default, a JTable will adjust its width such that
  a horizontal scrollbar is unnecessary.  To allow for a horizontal scrollbar,
  invoke setAutoResizeMode(int) with AUTO_RESIZE_OFF.
  Note that if you wish to use a JTable in a standalone
  view (outside of a JScrollPane) and want the header
  displayed, you can get it using getTableHeader() and
  display it separately.

  To enable sorting and filtering of rows, use a
  RowSorter.
  You can set up a row sorter in either of two ways:

    Directly set the RowSorter. For example:
         table.setRowSorter(new TableRowSorter(model)).
    Set the autoCreateRowSorter
        property to true, so that the JTable
        creates a RowSorter for
        you. For example: setAutoCreateRowSorter(true).


  When designing applications that use the JTable it is worth paying
  close attention to the data structures that will represent the table's data.
  The DefaultTableModel is a model implementation that
  uses a Vector of Vectors of Objects to
  store the cell values. As well as copying the data from an
  application into the DefaultTableModel,
  it is also possible to wrap the data in the methods of the
  TableModel interface so that the data can be passed to the
  JTable directly, as in the example above. This often results
  in more efficient applications because the model is free to choose the
  internal representation that best suits the data.
  A good rule of thumb for deciding whether to use the AbstractTableModel
  or the DefaultTableModel is to use the AbstractTableModel
  as the base class for creating subclasses and the DefaultTableModel
  when subclassing is not required.

  The `TableExample` directory in the demo area of the source distribution
  gives a number of complete examples of JTable usage,
  covering how the JTable can be used to provide an
  editable view of data taken from a database and how to modify
  the columns in the display to use specialized renderers and editors.

  The JTable uses integers exclusively to refer to both the rows and the columns
  of the model that it displays. The JTable simply takes a tabular range of cells
  and uses getValueAt(int, int) to retrieve the
  values from the model during painting.  It is important to remember that
  the column and row indexes returned by various JTable methods
  are in terms of the JTable (the view) and are not
  necessarily the same indexes used by the model.

  By default, columns may be rearranged in the JTable so that the
  view's columns appear in a different order to the columns in the model.
  This does not affect the implementation of the model at all: when the
  columns are reordered, the JTable maintains the new order of the columns
  internally and converts its column indices before querying the model.

  So, when writing a TableModel, it is not necessary to listen for column
  reordering events as the model will be queried in its own coordinate
  system regardless of what is happening in the view.
  In the examples area there is a demonstration of a sorting algorithm making
  use of exactly this technique to interpose yet another coordinate system
  where the order of the rows is changed, rather than the order of the columns.

  Similarly when using the sorting and filtering functionality
  provided by RowSorter the underlying
  TableModel does not need to know how to do sorting,
  rather RowSorter will handle it.  Coordinate
  conversions will be necessary when using the row based methods of
  JTable with the underlying TableModel.
  All of JTables row based methods are in terms of the
  RowSorter, which is not necessarily the same as that
  of the underlying TableModel.  For example, the
  selection is always in terms of JTable so that when
  using RowSorter you will need to convert using
  convertRowIndexToView or
  convertRowIndexToModel.  The following shows how to
  convert coordinates from JTable to that of the
  underlying model:


    int[] selection = table.getSelectedRows();
    for (int i = 0; i < selection.length; i++) {
      selection[i] = table.convertRowIndexToModel(selection[i]);
    }
    // selection is now in terms of the underlying TableModel

  By default if sorting is enabled JTable will persist the
  selection and variable row heights in terms of the model on
  sorting.  For example if row 0, in terms of the underlying model,
  is currently selected, after the sort row 0, in terms of the
  underlying model will be selected.  Visually the selection may
  change, but in terms of the underlying model it will remain the
  same.  The one exception to that is if the model index is no longer
  visible or was removed.  For example, if row 0 in terms of model
  was filtered out the selection will be empty after the sort.

  J2SE 5 adds methods to JTable to provide convenient access to some
  common printing needs. Simple new print() methods allow for quick
  and easy addition of printing support to your application. In addition, a new
  getPrintable(javax.swing.JTable.PrintMode, java.text.MessageFormat, java.text.MessageFormat) method is available for more advanced printing needs.

  As for all JComponent classes, you can use
  InputMap and ActionMap to associate an
  Action object with a KeyStroke and execute the
  action under specified conditions.

  Warning: Swing is not thread safe. For more
  information see Swing's Threading
  Policy.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JTable]))

(defn ->j-table
  "Constructor.

  Constructs a JTable that is initialized with
   dm as the data model, cm as the
   column model, and sm as the selection model.
   If any of the parameters are null this method
   will initialize the table with the corresponding default model.
   The autoCreateColumnsFromModel flag is set to false
   if cm is non-null, otherwise it is set to true
   and the column model is populated with suitable
   TableColumns for the columns in dm.

  dm - the data model for the table - `javax.swing.table.TableModel`
  cm - the column model for the table - `javax.swing.table.TableColumnModel`
  sm - the row selection model for the table - `javax.swing.ListSelectionModel`"
  ([^javax.swing.table.TableModel dm ^javax.swing.table.TableColumnModel cm ^javax.swing.ListSelectionModel sm]
    (new JTable dm cm sm))
  ([^javax.swing.table.TableModel dm ^javax.swing.table.TableColumnModel cm]
    (new JTable dm cm))
  ([^javax.swing.table.TableModel dm]
    (new JTable dm))
  ([]
    (new JTable )))

(def *-auto-resize-off
  "Static Constant.

  Do not adjust column widths automatically; use a horizontal scrollbar instead.

  type: int"
  JTable/AUTO_RESIZE_OFF)

(def *-auto-resize-next-column
  "Static Constant.

  When a column is adjusted in the UI, adjust the next column the opposite way.

  type: int"
  JTable/AUTO_RESIZE_NEXT_COLUMN)

(def *-auto-resize-subsequent-columns
  "Static Constant.

  During UI adjustment, change subsequent columns to preserve the total width;
   this is the default behavior.

  type: int"
  JTable/AUTO_RESIZE_SUBSEQUENT_COLUMNS)

(def *-auto-resize-last-column
  "Static Constant.

  During all resize operations, apply adjustments to the last column only.

  type: int"
  JTable/AUTO_RESIZE_LAST_COLUMN)

(def *-auto-resize-all-columns
  "Static Constant.

  During all resize operations, proportionately resize all columns.

  type: int"
  JTable/AUTO_RESIZE_ALL_COLUMNS)

(defn *create-scroll-pane-for-table
  "Deprecated. As of Swing version 1.0.2,
   replaced by new JScrollPane(aTable).

  a-table - `javax.swing.JTable`

  returns: `java.lang.   javax.swing.JScrollPane`"
  ([^javax.swing.JTable a-table]
    (JTable/createScrollPaneForTable a-table)))

(defn set-editing-row
  "Sets the editingRow variable.

  a-row - the row of the cell to be edited - `int`"
  ([^javax.swing.JTable this ^Integer a-row]
    (-> this (.setEditingRow a-row))))

(defn get-update-selection-on-sort?
  "Returns true if the selection should be updated after sorting.

  returns: whether to update the selection on a sort - `boolean`"
  ([^javax.swing.JTable this]
    (-> this (.getUpdateSelectionOnSort))))

(defn get-selection-background
  "Returns the background color for selected cells.

  returns: the Color used for the background of selected list items - `java.awt.Color`"
  ([^javax.swing.JTable this]
    (-> this (.getSelectionBackground))))

(defn set-selection-background
  "Sets the background color for selected cells.  Cell renderers
   can use this color to the fill selected cells.

   The default value of this property is defined by the look
   and feel implementation.

   This is a JavaBeans bound property.

  selection-background - the Color to use for the background of selected cells - `java.awt.Color`"
  ([^javax.swing.JTable this ^java.awt.Color selection-background]
    (-> this (.setSelectionBackground selection-background))))

(defn get-fills-viewport-height?
  "Returns whether or not this table is always made large enough
   to fill the height of an enclosing viewport.

  returns: whether or not this table is always made large enough
           to fill the height of an enclosing viewport - `boolean`"
  ([^javax.swing.JTable this]
    (-> this (.getFillsViewportHeight))))

(defn size-columns-to-fit
  "Obsolete as of Java 2 platform v1.4.  Please use the
   doLayout() method instead.

  resizing-column - the column whose resizing made this adjustment necessary or -1 if there is no such column - `int`"
  ([^javax.swing.JTable this ^Integer resizing-column]
    (-> this (.sizeColumnsToFit resizing-column))))

(defn get-column-class
  "Returns the type of the column appearing in the view at
   column position column.

  column - the column in the view being queried - `int`

  returns: the type of the column at position column
            in the view where the first column is column 0 - `java.lang.Class<?>`"
  ([^javax.swing.JTable this ^Integer column]
    (-> this (.getColumnClass column))))

(defn get-selected-row-count
  "Returns the number of selected rows.

  returns: the number of selected rows, 0 if no rows are selected - `int`"
  ([^javax.swing.JTable this]
    (-> this (.getSelectedRowCount))))

(defn change-selection
  "Updates the selection models of the table, depending on the state of the
   two flags: toggle and extend. Most changes
   to the selection that are the result of keyboard or mouse events received
   by the UI are channeled through this method so that the behavior may be
   overridden by a subclass. Some UIs may need more functionality than
   this method provides, such as when manipulating the lead for discontiguous
   selection, and may not call into this method for some selection changes.

   This implementation uses the following conventions:

    toggle: false, extend: false.
        Clear the previous selection and ensure the new cell is selected.
    toggle: false, extend: true.
        Extend the previous selection from the anchor to the specified cell,
        clearing all other selections.
    toggle: true, extend: false.
        If the specified cell is selected, deselect it. If it is not selected, select it.
    toggle: true, extend: true.
        Apply the selection state of the anchor to all cells between it and the
        specified cell.

  row-index - affects the selection at row - `int`
  column-index - affects the selection at column - `int`
  toggle - see description above - `boolean`
  extend - if true, extend the current selection - `boolean`"
  ([^javax.swing.JTable this ^Integer row-index ^Integer column-index ^Boolean toggle ^Boolean extend]
    (-> this (.changeSelection row-index column-index toggle extend))))

(defn row-selected?
  "Returns true if the specified index is in the valid range of rows,
   and the row at that index is selected.

  row - `int`

  returns: true if row is a valid index and the row at
                that index is selected (where 0 is the first row) - `boolean`"
  ([^javax.swing.JTable this ^Integer row]
    (-> this (.isRowSelected row))))

(defn set-column-selection-allowed
  "Sets whether the columns in this model can be selected.

  column-selection-allowed - true if this model will allow column selection - `boolean`"
  ([^javax.swing.JTable this ^Boolean column-selection-allowed]
    (-> this (.setColumnSelectionAllowed column-selection-allowed))))

(defn clear-selection
  "Deselects all selected columns and rows."
  ([^javax.swing.JTable this]
    (-> this (.clearSelection))))

(defn set-column-model
  "Sets the column model for this table to newModel and registers
   for listener notifications from the new column model. Also sets
   the column model of the JTableHeader to columnModel.

  column-model - the new data source for this table - `javax.swing.table.TableColumnModel`

  throws: java.lang.IllegalArgumentException - if columnModel is null"
  ([^javax.swing.JTable this ^javax.swing.table.TableColumnModel column-model]
    (-> this (.setColumnModel column-model))))

(defn row-at-point
  "Returns the index of the row that point lies in,
   or -1 if the result is not in the range
   [0, getRowCount()-1].

  point - the location of interest - `java.awt.Point`

  returns: the index of the row that point lies in,
            or -1 if the result is not in the range
            [0, getRowCount()-1] - `int`"
  ([^javax.swing.JTable this ^java.awt.Point point]
    (-> this (.rowAtPoint point))))

(defn convert-column-index-to-model
  "Maps the index of the column in the view at
   viewColumnIndex to the index of the column
   in the table model.  Returns the index of the corresponding
   column in the model.  If viewColumnIndex
   is less than zero, returns viewColumnIndex.

  view-column-index - the index of the column in the view - `int`

  returns: the index of the corresponding column in the model - `int`"
  ([^javax.swing.JTable this ^Integer view-column-index]
    (-> this (.convertColumnIndexToModel view-column-index))))

(defn get-show-vertical-lines?
  "Returns true if the table draws vertical lines between cells, false if it
   doesn't. The default value is look and feel dependent.

  returns: true if the table draws vertical lines between cells, false if it
            doesn't - `boolean`"
  ([^javax.swing.JTable this]
    (-> this (.getShowVerticalLines))))

(defn set-auto-create-columns-from-model
  "Sets this table's autoCreateColumnsFromModel flag.
   This method calls createDefaultColumnsFromModel if
   autoCreateColumnsFromModel changes from false to true.

  auto-create-columns-from-model - true if JTable should automatically create columns - `boolean`"
  ([^javax.swing.JTable this ^Boolean auto-create-columns-from-model]
    (-> this (.setAutoCreateColumnsFromModel auto-create-columns-from-model))))

(defn get-row-selection-allowed?
  "Returns true if rows can be selected.

  returns: true if rows can be selected, otherwise false - `boolean`"
  ([^javax.swing.JTable this]
    (-> this (.getRowSelectionAllowed))))

(defn remove-column-selection-interval
  "Deselects the columns from index0 to index1, inclusive.

  index-0 - one end of the interval - `int`
  index-1 - the other end of the interval - `int`

  throws: java.lang.IllegalArgumentException - if index0 or index1 lie outside [0, getColumnCount()-1]"
  ([^javax.swing.JTable this ^Integer index-0 ^Integer index-1]
    (-> this (.removeColumnSelectionInterval index-0 index-1))))

(defn set-selection-foreground
  "Sets the foreground color for selected cells.  Cell renderers
   can use this color to render text and graphics for selected
   cells.

   The default value of this property is defined by the look
   and feel implementation.

   This is a JavaBeans bound property.

  selection-foreground - the Color to use in the foreground for selected list items - `java.awt.Color`"
  ([^javax.swing.JTable this ^java.awt.Color selection-foreground]
    (-> this (.setSelectionForeground selection-foreground))))

(defn add-row-selection-interval
  "Adds the rows from index0 to index1, inclusive, to
   the current selection.

  index-0 - one end of the interval - `int`
  index-1 - the other end of the interval - `int`

  throws: java.lang.IllegalArgumentException - if index0 or index1 lie outside [0, getRowCount()-1]"
  ([^javax.swing.JTable this ^Integer index-0 ^Integer index-1]
    (-> this (.addRowSelectionInterval index-0 index-1))))

(defn get-column
  "Returns the TableColumn object for the column in the table
   whose identifier is equal to identifier, when compared using
   equals.

  identifier - the identifier object - `java.lang.Object`

  returns: the TableColumn object that matches the identifier - `javax.swing.table.TableColumn`

  throws: java.lang.IllegalArgumentException - if identifier is null or no TableColumn has this identifier"
  ([^javax.swing.JTable this ^java.lang.Object identifier]
    (-> this (.getColumn identifier))))

(defn set-show-horizontal-lines
  "Sets whether the table draws horizontal lines between cells.
    If showHorizontalLines is true it does; if it is false it doesn't.

  show-horizontal-lines - true if table view should draw horizontal lines - `boolean`"
  ([^javax.swing.JTable this ^Boolean show-horizontal-lines]
    (-> this (.setShowHorizontalLines show-horizontal-lines))))

(defn set-row-selection-allowed
  "Sets whether the rows in this model can be selected.

  row-selection-allowed - true if this model will allow row selection - `boolean`"
  ([^javax.swing.JTable this ^Boolean row-selection-allowed]
    (-> this (.setRowSelectionAllowed row-selection-allowed))))

(defn prepare-editor
  "Prepares the editor by querying the data model for the value and
   selection state of the cell at row, column.

   Note:
   Throughout the table package, the internal implementations always
   use this method to prepare editors so that this default behavior
   can be safely overridden by a subclass.

  editor - the TableCellEditor to set up - `javax.swing.table.TableCellEditor`
  row - the row of the cell to edit, where 0 is the first row - `int`
  column - the column of the cell to edit, where 0 is the first column - `int`

  returns: the Component being edited - `java.awt.Component`"
  ([^javax.swing.JTable this ^javax.swing.table.TableCellEditor editor ^Integer row ^Integer column]
    (-> this (.prepareEditor editor row column))))

(defn get-drop-mode
  "Returns the drop mode for this component.

  returns: the drop mode for this component - `javax.swing.DropMode`"
  ([^javax.swing.JTable this]
    (-> this (.getDropMode))))

(defn get-scrollable-block-increment
  "Returns visibleRect.height or
   visibleRect.width,
   depending on this table's orientation.  Note that as of Swing 1.1.1
   (Java 2 v 1.2.2) the value
   returned will ensure that the viewport is cleanly aligned on
   a row boundary.

  visible-rect - The view area visible within the viewport - `java.awt.Rectangle`
  orientation - Either SwingConstants.VERTICAL or SwingConstants.HORIZONTAL. - `int`
  direction - Less than zero to scroll up/left, greater than zero for down/right. - `int`

  returns: visibleRect.height or
                                    visibleRect.width
                                    per the orientation - `int`"
  ([^javax.swing.JTable this ^java.awt.Rectangle visible-rect ^Integer orientation ^Integer direction]
    (-> this (.getScrollableBlockIncrement visible-rect orientation direction))))

(defn set-drop-mode
  "Sets the drop mode for this component. For backward compatibility,
   the default for this property is DropMode.USE_SELECTION.
   Usage of one of the other modes is recommended, however, for an
   improved user experience. DropMode.ON, for instance,
   offers similar behavior of showing items as selected, but does so without
   affecting the actual selection in the table.

   JTable supports the following drop modes:

      DropMode.USE_SELECTION
      DropMode.ON
      DropMode.INSERT
      DropMode.INSERT_ROWS
      DropMode.INSERT_COLS
      DropMode.ON_OR_INSERT
      DropMode.ON_OR_INSERT_ROWS
      DropMode.ON_OR_INSERT_COLS


   The drop mode is only meaningful if this component has a
   TransferHandler that accepts drops.

  drop-mode - the drop mode to use - `javax.swing.DropMode`

  throws: java.lang.IllegalArgumentException - if the drop mode is unsupported or null"
  ([^javax.swing.JTable this ^javax.swing.DropMode drop-mode]
    (-> this (.setDropMode drop-mode))))

(defn column-moved
  "Invoked when a column is repositioned. If a cell is being
   edited, then editing is stopped and the cell is redrawn.

   Application code will not use these methods explicitly, they
   are used internally by JTable.

  e - the event received - `javax.swing.event.TableColumnModelEvent`"
  ([^javax.swing.JTable this ^javax.swing.event.TableColumnModelEvent e]
    (-> this (.columnMoved e))))

(defn get-value-at
  "Returns the cell value at row and column.

   Note: The column is specified in the table view's display
                order, and not in the TableModel's column
                order.  This is an important distinction because as the
                user rearranges the columns in the table,
                the column at a given index in the view will change.
                Meanwhile the user's actions never affect the model's
                column ordering.

  row - the row whose value is to be queried - `int`
  column - the column whose value is to be queried - `int`

  returns: the Object at the specified cell - `java.lang.Object`"
  ([^javax.swing.JTable this ^Integer row ^Integer column]
    (-> this (.getValueAt row column))))

(defn get-surrenders-focus-on-keystroke?
  "Returns true if the editor should get the focus
   when keystrokes cause the editor to be activated

  returns: true if the editor should get the focus
            when keystrokes cause the editor to be
            activated - `boolean`"
  ([^javax.swing.JTable this]
    (-> this (.getSurrendersFocusOnKeystroke))))

(defn get-selection-foreground
  "Returns the foreground color for selected cells.

  returns: the Color object for the foreground property - `java.awt.Color`"
  ([^javax.swing.JTable this]
    (-> this (.getSelectionForeground))))

(defn get-grid-color
  "Returns the color used to draw grid lines.
   The default color is look and feel dependent.

  returns: the color used to draw grid lines - `java.awt.Color`"
  ([^javax.swing.JTable this]
    (-> this (.getGridColor))))

(defn get-column-count
  "Returns the number of columns in the column model. Note that this may
   be different from the number of columns in the table model.

  returns: the number of columns in the table - `int`"
  ([^javax.swing.JTable this]
    (-> this (.getColumnCount))))

(defn set-fills-viewport-height
  "Sets whether or not this table is always made large enough
   to fill the height of an enclosing viewport. If the preferred
   height of the table is smaller than the viewport, then the table
   will be stretched to fill the viewport. In other words, this
   ensures the table is never smaller than the viewport.
   The default for this property is false.

  fills-viewport-height - whether or not this table is always made large enough to fill the height of an enclosing viewport - `boolean`"
  ([^javax.swing.JTable this ^Boolean fills-viewport-height]
    (-> this (.setFillsViewportHeight fills-viewport-height))))

(defn remove-row-selection-interval
  "Deselects the rows from index0 to index1, inclusive.

  index-0 - one end of the interval - `int`
  index-1 - the other end of the interval - `int`

  throws: java.lang.IllegalArgumentException - if index0 or index1 lie outside [0, getRowCount()-1]"
  ([^javax.swing.JTable this ^Integer index-0 ^Integer index-1]
    (-> this (.removeRowSelectionInterval index-0 index-1))))

(defn get-row-count
  "Returns the number of rows that can be shown in the
   JTable, given unlimited space.  If a
   RowSorter with a filter has been specified, the
   number of rows returned may differ from that of the underlying
   TableModel.

  returns: the number of rows shown in the JTable - `int`"
  ([^javax.swing.JTable this]
    (-> this (.getRowCount))))

(defn select-all
  "Selects all rows, columns, and cells in the table."
  ([^javax.swing.JTable this]
    (-> this (.selectAll))))

(defn cell-selected?
  "Returns true if the specified indices are in the valid range of rows
   and columns and the cell at the specified position is selected.

  row - the row being queried - `int`
  column - the column being queried - `int`

  returns: true if row and column are valid indices
                and the cell at index (row, column) is selected,
                where the first row and first column are at index 0 - `boolean`"
  ([^javax.swing.JTable this ^Integer row ^Integer column]
    (-> this (.isCellSelected row column))))

(defn set-row-margin
  "Sets the amount of empty space between cells in adjacent rows.

  row-margin - the number of pixels between cells in a row - `int`"
  ([^javax.swing.JTable this ^Integer row-margin]
    (-> this (.setRowMargin row-margin))))

(defn get-ui-class-id
  "Returns the suffix used to construct the name of the L&F class used to
   render this component.

  returns: the string `TableUI` - `java.lang.String`"
  ([^javax.swing.JTable this]
    (-> this (.getUIClassID))))

(defn convert-row-index-to-model
  "Maps the index of the row in terms of the view to the
   underlying TableModel.  If the contents of the
   model are not sorted the model and view indices are the same.

  view-row-index - the index of the row in the view - `int`

  returns: the index of the corresponding row in the model - `int`

  throws: java.lang.IndexOutOfBoundsException - if sorting is enabled and passed an index outside the range of the JTable as determined by the method getRowCount"
  ([^javax.swing.JTable this ^Integer view-row-index]
    (-> this (.convertRowIndexToModel view-row-index))))

(defn get-auto-resize-mode
  "Returns the auto resize mode of the table.  The default mode
   is AUTO_RESIZE_SUBSEQUENT_COLUMNS.

  returns: the autoResizeMode of the table - `int`"
  ([^javax.swing.JTable this]
    (-> this (.getAutoResizeMode))))

(defn set-editing-column
  "Sets the editingColumn variable.

  a-column - the column of the cell to be edited - `int`"
  ([^javax.swing.JTable this ^Integer a-column]
    (-> this (.setEditingColumn a-column))))

(defn set-selection-model
  "Sets the row selection model for this table to newModel
   and registers for listener notifications from the new selection model.

  new-model - the new selection model - `javax.swing.ListSelectionModel`

  throws: java.lang.IllegalArgumentException - if newModel is null"
  ([^javax.swing.JTable this ^javax.swing.ListSelectionModel new-model]
    (-> this (.setSelectionModel new-model))))

(defn get-column-selection-allowed?
  "Returns true if columns can be selected.

  returns: true if columns can be selected, otherwise false - `boolean`"
  ([^javax.swing.JTable this]
    (-> this (.getColumnSelectionAllowed))))

(defn remove-column
  "Removes aColumn from this JTable's
    array of columns.  Note: this method does not remove the column
    of data from the model; it just removes the TableColumn
    that was responsible for displaying it.

  a-column - the TableColumn to be removed - `javax.swing.table.TableColumn`"
  ([^javax.swing.JTable this ^javax.swing.table.TableColumn a-column]
    (-> this (.removeColumn a-column))))

(defn get-scrollable-unit-increment
  "Returns the scroll increment (in pixels) that completely exposes one new
   row or column (depending on the orientation).

   This method is called each time the user requests a unit scroll.

  visible-rect - the view area visible within the viewport - `java.awt.Rectangle`
  orientation - either SwingConstants.VERTICAL or SwingConstants.HORIZONTAL - `int`
  direction - less than zero to scroll up/left, greater than zero for down/right - `int`

  returns: the `unit` increment for scrolling in the specified direction - `int`"
  ([^javax.swing.JTable this ^java.awt.Rectangle visible-rect ^Integer orientation ^Integer direction]
    (-> this (.getScrollableUnitIncrement visible-rect orientation direction))))

(defn set-intercell-spacing
  "Sets the rowMargin and the columnMargin --
   the height and width of the space between cells -- to
   intercellSpacing.

  intercell-spacing - a Dimension specifying the new width and height between cells - `java.awt.Dimension`"
  ([^javax.swing.JTable this ^java.awt.Dimension intercell-spacing]
    (-> this (.setIntercellSpacing intercell-spacing))))

(defn get-editor-component
  "Returns the component that is handling the editing session.
   If nothing is being edited, returns null.

  returns: Component handling editing session - `java.awt.Component`"
  ([^javax.swing.JTable this]
    (-> this (.getEditorComponent))))

(defn get-cell-editor
  "Returns an appropriate editor for the cell specified by
   row and column. If the
   TableColumn for this column has a non-null editor,
   returns that.  If not, finds the class of the data in this
   column (using getColumnClass)
   and returns the default editor for this type of data.

   Note:
   Throughout the table package, the internal implementations always
   use this method to provide editors so that this default behavior
   can be safely overridden by a subclass.

  row - the row of the cell to edit, where 0 is the first row - `int`
  column - the column of the cell to edit, where 0 is the first column - `int`

  returns: the editor for this cell;
                    if null return the default editor for
                    this type of cell - `javax.swing.table.TableCellEditor`"
  ([^javax.swing.JTable this ^Integer row ^Integer column]
    (-> this (.getCellEditor row column)))
  ([^javax.swing.JTable this]
    (-> this (.getCellEditor))))

(defn cell-editable?
  "Returns true if the cell at row and column
   is editable.  Otherwise, invoking setValueAt on the cell
   will have no effect.

   Note: The column is specified in the table view's display
                order, and not in the TableModel's column
                order.  This is an important distinction because as the
                user rearranges the columns in the table,
                the column at a given index in the view will change.
                Meanwhile the user's actions never affect the model's
                column ordering.

  row - the row whose value is to be queried - `int`
  column - the column whose value is to be queried - `int`

  returns: true if the cell is editable - `boolean`"
  ([^javax.swing.JTable this ^Integer row ^Integer column]
    (-> this (.isCellEditable row column))))

(defn set-show-vertical-lines
  "Sets whether the table draws vertical lines between cells.
    If showVerticalLines is true it does; if it is false it doesn't.

  show-vertical-lines - true if table view should draw vertical lines - `boolean`"
  ([^javax.swing.JTable this ^Boolean show-vertical-lines]
    (-> this (.setShowVerticalLines show-vertical-lines))))

(defn set-auto-resize-mode
  "Sets the table's auto resize mode when the table is resized.  For further
   information on how the different resize modes work, see
   doLayout().

  mode - One of 5 legal values: AUTO_RESIZE_OFF, AUTO_RESIZE_NEXT_COLUMN, AUTO_RESIZE_SUBSEQUENT_COLUMNS, AUTO_RESIZE_LAST_COLUMN, AUTO_RESIZE_ALL_COLUMNS - `int`"
  ([^javax.swing.JTable this ^Integer mode]
    (-> this (.setAutoResizeMode mode))))

(defn remove-editor
  "Discards the editor object and frees the real estate it used for
   cell rendering."
  ([^javax.swing.JTable this]
    (-> this (.removeEditor))))

(defn edit-cell-at
  "Programmatically starts editing the cell at row and
   column, if those indices are in the valid range, and
   the cell at those indices is editable.
   To prevent the JTable from
   editing a particular table, column or cell value, return false from
   the isCellEditable method in the TableModel
   interface.

  row - the row to be edited - `int`
  column - the column to be edited - `int`
  e - event to pass into shouldSelectCell; note that as of Java 2 platform v1.2, the call to shouldSelectCell is no longer made - `java.util.EventObject`

  returns: false if for any reason the cell cannot be edited,
                  or if the indices are invalid - `boolean`"
  ([^javax.swing.JTable this ^Integer row ^Integer column ^java.util.EventObject e]
    (-> this (.editCellAt row column e)))
  ([^javax.swing.JTable this ^Integer row ^Integer column]
    (-> this (.editCellAt row column))))

(defn set-surrenders-focus-on-keystroke
  "Sets whether editors in this JTable get the keyboard focus
   when an editor is activated as a result of the JTable
   forwarding keyboard events for a cell.
   By default, this property is false, and the JTable
   retains the focus unless the cell is clicked.

  surrenders-focus-on-keystroke - true if the editor should get the focus when keystrokes cause the editor to be activated - `boolean`"
  ([^javax.swing.JTable this ^Boolean surrenders-focus-on-keystroke]
    (-> this (.setSurrendersFocusOnKeystroke surrenders-focus-on-keystroke))))

(defn set-table-header
  "Sets the tableHeader working with this JTable to newHeader.
   It is legal to have a null tableHeader.

  table-header - new tableHeader - `javax.swing.table.JTableHeader`"
  ([^javax.swing.JTable this ^javax.swing.table.JTableHeader table-header]
    (-> this (.setTableHeader table-header))))

(defn set-update-selection-on-sort
  "Specifies whether the selection should be updated after sorting.
   If true, on sorting the selection is reset such that
   the same rows, in terms of the model, remain selected.  The default
   is true.

  update - whether or not to update the selection on sorting - `boolean`"
  ([^javax.swing.JTable this ^Boolean update]
    (-> this (.setUpdateSelectionOnSort update))))

(defn add-notify
  "Calls the configureEnclosingScrollPane method."
  ([^javax.swing.JTable this]
    (-> this (.addNotify))))

(defn get-selection-model
  "Returns the ListSelectionModel that is used to maintain row
   selection state.

  returns: the object that provides row selection state, null
            if row selection is not allowed - `javax.swing.ListSelectionModel`"
  ([^javax.swing.JTable this]
    (-> this (.getSelectionModel))))

(defn set-column-selection-interval
  "Selects the columns from index0 to index1,
   inclusive.

  index-0 - one end of the interval - `int`
  index-1 - the other end of the interval - `int`

  throws: java.lang.IllegalArgumentException - if index0 or index1 lie outside [0, getColumnCount()-1]"
  ([^javax.swing.JTable this ^Integer index-0 ^Integer index-1]
    (-> this (.setColumnSelectionInterval index-0 index-1))))

(defn get-drop-location
  "Returns the location that this component should visually indicate
   as the drop location during a DnD operation over the component,
   or null if no location is to currently be shown.

   This method is not meant for querying the drop location
   from a TransferHandler, as the drop location is only
   set after the TransferHandler's canImport
   has returned and has allowed for the location to be shown.

   When this property changes, a property change event with
   name `dropLocation` is fired by the component.

  returns: the drop location - `javax.swing.JTable.DropLocation`"
  ([^javax.swing.JTable this]
    (-> this (.getDropLocation))))

(defn set-grid-color
  "Sets the color used to draw grid lines to gridColor and redisplays.
   The default color is look and feel dependent.

  grid-color - the new color of the grid lines - `java.awt.Color`

  throws: java.lang.IllegalArgumentException - if gridColor is null"
  ([^javax.swing.JTable this ^java.awt.Color grid-color]
    (-> this (.setGridColor grid-color))))

(defn get-preferred-scrollable-viewport-size
  "Returns the preferred size of the viewport for this table.

  returns: a Dimension object containing the preferredSize of the JViewport
           which displays this table - `java.awt.Dimension`"
  ([^javax.swing.JTable this]
    (-> this (.getPreferredScrollableViewportSize))))

(defn get-cell-renderer
  "Returns an appropriate renderer for the cell specified by this row and
   column. If the TableColumn for this column has a non-null
   renderer, returns that.  If not, finds the class of the data in
   this column (using getColumnClass)
   and returns the default renderer for this type of data.

   Note:
   Throughout the table package, the internal implementations always
   use this method to provide renderers so that this default behavior
   can be safely overridden by a subclass.

  row - the row of the cell to render, where 0 is the first row - `int`
  column - the column of the cell to render, where 0 is the first column - `int`

  returns: the assigned renderer; if null
                    returns the default renderer
                    for this type of object - `javax.swing.table.TableCellRenderer`"
  ([^javax.swing.JTable this ^Integer row ^Integer column]
    (-> this (.getCellRenderer row column))))

(defn set-ui
  "Sets the L&F object that renders this component and repaints.

  ui - the TableUI L&F object - `javax.swing.plaf.TableUI`"
  ([^javax.swing.JTable this ^javax.swing.plaf.TableUI ui]
    (-> this (.setUI ui))))

(defn get-tool-tip-text
  "Overrides JComponent's getToolTipText
   method in order to allow the renderer's tips to be used
   if it has text set.

   Note: For JTable to properly display
   tooltips of its renderers
   JTable must be a registered component with the
   ToolTipManager.
   This is done automatically in initializeLocalVars,
   but if at a later point JTable is told
   setToolTipText(null) it will unregister the table
   component, and no tips from renderers will display anymore.

  event - `java.awt.event.MouseEvent`

  returns: `java.lang.String`"
  ([^javax.swing.JTable this ^java.awt.event.MouseEvent event]
    (-> this (.getToolTipText event))))

(defn remove-notify
  "Calls the unconfigureEnclosingScrollPane method."
  ([^javax.swing.JTable this]
    (-> this (.removeNotify))))

(defn get-selected-row
  "Returns the index of the first selected row, -1 if no row is selected.

  returns: the index of the first selected row - `int`"
  ([^javax.swing.JTable this]
    (-> this (.getSelectedRow))))

(defn set-row-selection-interval
  "Selects the rows from index0 to index1,
   inclusive.

  index-0 - one end of the interval - `int`
  index-1 - the other end of the interval - `int`

  throws: java.lang.IllegalArgumentException - if index0 or index1 lie outside [0, getRowCount()-1]"
  ([^javax.swing.JTable this ^Integer index-0 ^Integer index-1]
    (-> this (.setRowSelectionInterval index-0 index-1))))

(defn convert-column-index-to-view
  "Maps the index of the column in the table model at
   modelColumnIndex to the index of the column
   in the view.  Returns the index of the
   corresponding column in the view; returns -1 if this column is not
   being displayed.  If modelColumnIndex is less than zero,
   returns modelColumnIndex.

  model-column-index - the index of the column in the model - `int`

  returns: the index of the corresponding column in the view - `int`"
  ([^javax.swing.JTable this ^Integer model-column-index]
    (-> this (.convertColumnIndexToView model-column-index))))

(defn get-row-margin
  "Gets the amount of empty space, in pixels, between cells. Equivalent to:
   getIntercellSpacing().height.

  returns: the number of pixels between cells in a row - `int`"
  ([^javax.swing.JTable this]
    (-> this (.getRowMargin))))

(defn prepare-renderer
  "Prepares the renderer by querying the data model for the
   value and selection state
   of the cell at row, column.
   Returns the component (may be a Component
   or a JComponent) under the event location.

   During a printing operation, this method will configure the
   renderer without indicating selection or focus, to prevent
   them from appearing in the printed output. To do other
   customizations based on whether or not the table is being
   printed, you can check the value of
   JComponent.isPaintingForPrint(), either here
   or within custom renderers.

   Note:
   Throughout the table package, the internal implementations always
   use this method to prepare renderers so that this default behavior
   can be safely overridden by a subclass.

  renderer - the TableCellRenderer to prepare - `javax.swing.table.TableCellRenderer`
  row - the row of the cell to render, where 0 is the first row - `int`
  column - the column of the cell to render, where 0 is the first column - `int`

  returns: the Component under the event location - `java.awt.Component`"
  ([^javax.swing.JTable this ^javax.swing.table.TableCellRenderer renderer ^Integer row ^Integer column]
    (-> this (.prepareRenderer renderer row column))))

(defn value-changed
  "Invoked when the row selection changes -- repaints to show the new
   selection.

   Application code will not use these methods explicitly, they
   are used internally by JTable.

  e - the event received - `javax.swing.event.ListSelectionEvent`"
  ([^javax.swing.JTable this ^javax.swing.event.ListSelectionEvent e]
    (-> this (.valueChanged e))))

(defn set-auto-create-row-sorter
  "Specifies whether a RowSorter should be created for the
   table whenever its model changes.

   When setAutoCreateRowSorter(true) is invoked, a TableRowSorter is immediately created and installed on the
   table.  While the autoCreateRowSorter property remains
   true, every time the model is changed, a new TableRowSorter is created and set as the table's row sorter.
   The default value for the autoCreateRowSorter
   property is false.

  auto-create-row-sorter - whether or not a RowSorter should be automatically created - `boolean`"
  ([^javax.swing.JTable this ^Boolean auto-create-row-sorter]
    (-> this (.setAutoCreateRowSorter auto-create-row-sorter))))

(defn set-drag-enabled
  "Turns on or off automatic drag handling. In order to enable automatic
   drag handling, this property should be set to true, and the
   table's TransferHandler needs to be non-null.
   The default value of the dragEnabled property is false.

   The job of honoring this property, and recognizing a user drag gesture,
   lies with the look and feel implementation, and in particular, the table's
   TableUI. When automatic drag handling is enabled, most look and
   feels (including those that subclass BasicLookAndFeel) begin a
   drag and drop operation whenever the user presses the mouse button over
   an item (in single selection mode) or a selection (in other selection
   modes) and then moves the mouse a few pixels. Setting this property to
   true can therefore have a subtle effect on how selections behave.

   If a look and feel is used that ignores this property, you can still
   begin a drag and drop operation by calling exportAsDrag on the
   table's TransferHandler.

  b - whether or not to enable automatic drag handling - `boolean`

  throws: java.awt.HeadlessException - if b is true and GraphicsEnvironment.isHeadless() returns true"
  ([^javax.swing.JTable this ^Boolean b]
    (-> this (.setDragEnabled b))))

(defn get-cell-selection-enabled?
  "Returns true if both row and column selection models are enabled.
   Equivalent to getRowSelectionAllowed() &&
   getColumnSelectionAllowed().

  returns: true if both row and column selection models are enabled - `boolean`"
  ([^javax.swing.JTable this]
    (-> this (.getCellSelectionEnabled))))

(defn table-changed
  "Invoked when this table's TableModel generates
   a TableModelEvent.
   The TableModelEvent should be constructed in the
   coordinate system of the model; the appropriate mapping to the
   view coordinate system is performed by this JTable
   when it receives the event.

   Application code will not use these methods explicitly, they
   are used internally by JTable.

   Note that as of 1.3, this method clears the selection, if any.

  e - `javax.swing.event.TableModelEvent`"
  ([^javax.swing.JTable this ^javax.swing.event.TableModelEvent e]
    (-> this (.tableChanged e))))

(defn get-ui
  "Returns the L&F object that renders this component.

  returns: the TableUI object that renders this component - `javax.swing.plaf.TableUI`"
  ([^javax.swing.JTable this]
    (-> this (.getUI))))

(defn get-editing-column
  "Returns the index of the column that contains the cell currently
   being edited.  If nothing is being edited, returns -1.

  returns: the index of the column that contains the cell currently
            being edited; returns -1 if nothing being edited - `int`"
  ([^javax.swing.JTable this]
    (-> this (.getEditingColumn))))

(defn get-column-name
  "Returns the name of the column appearing in the view at
   column position column.

  column - the column in the view being queried - `int`

  returns: the name of the column at position column
                          in the view where the first column is column 0 - `java.lang.String`"
  ([^javax.swing.JTable this ^Integer column]
    (-> this (.getColumnName column))))

(defn get-selected-column-count
  "Returns the number of selected columns.

  returns: the number of selected columns, 0 if no columns are selected - `int`"
  ([^javax.swing.JTable this]
    (-> this (.getSelectedColumnCount))))

(defn move-column
  "Moves the column column to the position currently
   occupied by the column targetColumn in the view.
   The old column at targetColumn is
   shifted left or right to make room.

  column - the index of column to be moved - `int`
  target-column - the new index of the column - `int`"
  ([^javax.swing.JTable this ^Integer column ^Integer target-column]
    (-> this (.moveColumn column target-column))))

(defn add-column
  "Appends aColumn to the end of the array of columns held by
    this JTable's column model.
    If the column name of aColumn is null,
    sets the column name of aColumn to the name
    returned by getModel().getColumnName().

    To add a column to this JTable to display the
    modelColumn'th column of data in the model with a
    given width, cellRenderer,
    and cellEditor you can use:


        addColumn(new TableColumn(modelColumn, width, cellRenderer, cellEditor));
    [Any of the TableColumn constructors can be used
    instead of this one.]
    The model column number is stored inside the TableColumn
    and is used during rendering and editing to locate the appropriates
    data values in the model. The model column number does not change
    when columns are reordered in the view.

  a-column - the TableColumn to be added - `javax.swing.table.TableColumn`"
  ([^javax.swing.JTable this ^javax.swing.table.TableColumn a-column]
    (-> this (.addColumn a-column))))

(defn get-scrollable-tracks-viewport-width?
  "Returns false if autoResizeMode is set to
   AUTO_RESIZE_OFF, which indicates that the
   width of the viewport does not determine the width
   of the table.  Otherwise returns true.

  returns: false if autoResizeMode is set
     to AUTO_RESIZE_OFF, otherwise returns true - `boolean`"
  ([^javax.swing.JTable this]
    (-> this (.getScrollableTracksViewportWidth))))

(defn column-margin-changed
  "Invoked when a column is moved due to a margin change.
   If a cell is being edited, then editing is stopped and the cell
   is redrawn.

   Application code will not use these methods explicitly, they
   are used internally by JTable.

  e - the event received - `javax.swing.event.ChangeEvent`"
  ([^javax.swing.JTable this ^javax.swing.event.ChangeEvent e]
    (-> this (.columnMarginChanged e))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JTable.
   For tables, the AccessibleContext takes the form of an
   AccessibleJTable.
   A new AccessibleJTable instance is created if necessary.

  returns: an AccessibleJTable that serves as the
           AccessibleContext of this JTable - `javax.accessibility.AccessibleContext`"
  ([^javax.swing.JTable this]
    (-> this (.getAccessibleContext))))

(defn set-value-at
  "Sets the value for the cell in the table model at row
   and column.

   Note: The column is specified in the table view's display
                order, and not in the TableModel's column
                order.  This is an important distinction because as the
                user rearranges the columns in the table,
                the column at a given index in the view will change.
                Meanwhile the user's actions never affect the model's
                column ordering.

   aValue is the new value.

  a-value - the new value - `java.lang.Object`
  row - the row of the cell to be changed - `int`
  column - the column of the cell to be changed - `int`"
  ([^javax.swing.JTable this ^java.lang.Object a-value ^Integer row ^Integer column]
    (-> this (.setValueAt a-value row column))))

(defn add-column-selection-interval
  "Adds the columns from index0 to index1,
   inclusive, to the current selection.

  index-0 - one end of the interval - `int`
  index-1 - the other end of the interval - `int`

  throws: java.lang.IllegalArgumentException - if index0 or index1 lie outside [0, getColumnCount()-1]"
  ([^javax.swing.JTable this ^Integer index-0 ^Integer index-1]
    (-> this (.addColumnSelectionInterval index-0 index-1))))

(defn do-layout
  "Causes this table to lay out its rows and columns.  Overridden so
   that columns can be resized to accommodate a change in the size of
   a containing parent.
   Resizes one or more of the columns in the table
   so that the total width of all of this JTable's
   columns is equal to the width of the table.

   Before the layout begins the method gets the
   resizingColumn of the tableHeader.
   When the method is called as a result of the resizing of an enclosing window,
   the resizingColumn is null. This means that resizing
   has taken place `outside` the JTable and the change -
   or `delta` - should be distributed to all of the columns regardless
   of this JTable's automatic resize mode.

   If the resizingColumn is not null, it is one of
   the columns in the table that has changed size rather than
   the table itself. In this case the auto-resize modes govern
   the way the extra (or deficit) space is distributed
   amongst the available columns.

   The modes are:

     AUTO_RESIZE_OFF: Don't automatically adjust the column's
   widths at all. Use a horizontal scrollbar to accommodate the
   columns when their sum exceeds the width of the
   Viewport.  If the JTable is not
   enclosed in a JScrollPane this may
   leave parts of the table invisible.
     AUTO_RESIZE_NEXT_COLUMN: Use just the column after the
   resizing column. This results in the `boundary` or divider
   between adjacent cells being independently adjustable.
     AUTO_RESIZE_SUBSEQUENT_COLUMNS: Use all columns after the
   one being adjusted to absorb the changes.  This is the
   default behavior.
     AUTO_RESIZE_LAST_COLUMN: Automatically adjust the
   size of the last column only. If the bounds of the last column
   prevent the desired size from being allocated, set the
   width of the last column to the appropriate limit and make
   no further adjustments.
     AUTO_RESIZE_ALL_COLUMNS: Spread the delta amongst all the columns
   in the JTable, including the one that is being
   adjusted.


   Note: When a JTable makes adjustments
     to the widths of the columns it respects their minimum and
     maximum values absolutely.  It is therefore possible that,
     even after this method is called, the total width of the columns
     is still not equal to the width of the table. When this happens
     the JTable does not put itself
     in AUTO_RESIZE_OFF mode to bring up a scroll bar, or break other
     commitments of its current auto-resize mode -- instead it
     allows its bounds to be set larger (or smaller) than the total of the
     column minimum or maximum, meaning, either that there
     will not be enough room to display all of the columns, or that the
     columns will not fill the JTable's bounds.
     These respectively, result in the clipping of some columns
     or an area being painted in the JTable's
     background color during painting.

     The mechanism for distributing the delta amongst the available
     columns is provided in a private method in the JTable
     class:


     adjustSizes(long targetSize, final Resizable3 r, boolean inverse)
     an explanation of which is provided in the following section.
     Resizable3 is a private
     interface that allows any data structure containing a collection
     of elements with a size, preferred size, maximum size and minimum size
     to have its elements manipulated by the algorithm.

    Distributing the delta

    Overview

   Call `DELTA` the difference between the target size and the
   sum of the preferred sizes of the elements in r. The individual
   sizes are calculated by taking the original preferred
   sizes and adding a share of the DELTA - that share being based on
   how far each preferred size is from its limiting bound (minimum or
   maximum).

   Definition

   Call the individual constraints min[i], max[i], and pref[i].

   Call their respective sums: MIN, MAX, and PREF.

   Each new size will be calculated using:



            size[i] = pref[i]  delta[i]
   where each individual delta[i] is calculated according to:

   If (DELTA < 0) we are in shrink mode where:



                          DELTA
            delta[i] = ------------ * (pref[i] - min[i])
                       (PREF - MIN)
   If (DELTA > 0) we are in expand mode where:



                          DELTA
            delta[i] = ------------ * (max[i] - pref[i])
                        (MAX - PREF)

   The overall effect is that the total size moves that same percentage,
   k, towards the total minimum or maximum and that percentage guarantees
   accommodation of the required space, DELTA.

   Details

   Naive evaluation of the formulae presented here would be subject to
   the aggregated rounding errors caused by doing this operation in finite
   precision (using ints). To deal with this, the multiplying factor above,
   is constantly recalculated and this takes account of the rounding
   errors in the previous iterations. The result is an algorithm that
   produces a set of integers whose values exactly sum to the supplied
   targetSize, and does so by spreading the rounding
   errors evenly over the given elements.

   When the MAX and MIN bounds are hit

   When targetSize is outside the [MIN, MAX] range,
   the algorithm sets all sizes to their appropriate limiting value
   (maximum or minimum)."
  ([^javax.swing.JTable this]
    (-> this (.doLayout))))

(defn set-cell-selection-enabled
  "Sets whether this table allows both a column selection and a
   row selection to exist simultaneously. When set,
   the table treats the intersection of the row and column selection
   models as the selected cells. Override isCellSelected to
   change this default behavior. This method is equivalent to setting
   both the rowSelectionAllowed property and
   columnSelectionAllowed property of the
   columnModel to the supplied value.

  cell-selection-enabled - true if simultaneous row and column selection is allowed - `boolean`"
  ([^javax.swing.JTable this ^Boolean cell-selection-enabled]
    (-> this (.setCellSelectionEnabled cell-selection-enabled))))

(defn get-default-editor
  "Returns the editor to be used when no editor has been set in
   a TableColumn. During the editing of cells the editor is fetched from
   a Hashtable of entries according to the class of the cells in the column. If
   there is no entry for this columnClass the method returns
   the entry for the most specific superclass. The JTable installs entries
   for Object, Number, and Boolean, all of which can be modified
   or replaced.

  column-class - return the default cell editor for this columnClass - `java.lang.Class<?>`

  returns: the default cell editor to be used for this columnClass - `javax.swing.table.TableCellEditor`"
  ([^javax.swing.JTable this ^java.lang.Class column-class]
    (-> this (.getDefaultEditor column-class))))

(defn get-show-horizontal-lines?
  "Returns true if the table draws horizontal lines between cells, false if it
   doesn't. The default value is look and feel dependent.

  returns: true if the table draws horizontal lines between cells, false if it
            doesn't - `boolean`"
  ([^javax.swing.JTable this]
    (-> this (.getShowHorizontalLines))))

(defn set-row-sorter
  "Sets the RowSorter.  RowSorter is used
   to provide sorting and filtering to a JTable.

   This method clears the selection and resets any variable row heights.

   This method fires a PropertyChangeEvent when appropriate,
   with the property name `rowSorter`.  For
   backward-compatibility, this method fires an additional event with the
   property name `sorter`.

   If the underlying model of the RowSorter differs from
   that of this JTable undefined behavior will result.

  sorter - the RowSorter; null turns sorting off - `javax.swing.table.TableModel>`"
  ([^javax.swing.JTable this ^javax.swing.table.TableModel> sorter]
    (-> this (.setRowSorter sorter))))

(defn set-row-height
  "Sets the height for row to rowHeight,
   revalidates, and repaints. The height of the cells in this row
   will be equal to the row height minus the row margin.

  row - the row whose height is being changed - `int`
  row-height - new row height, in pixels - `int`

  throws: java.lang.IllegalArgumentException - if rowHeight is less than 1"
  ([^javax.swing.JTable this ^Integer row ^Integer row-height]
    (-> this (.setRowHeight row row-height)))
  ([^javax.swing.JTable this ^Integer row-height]
    (-> this (.setRowHeight row-height))))

(defn get-selected-columns
  "Returns the indices of all selected columns.

  returns: an array of integers containing the indices of all selected columns,
           or an empty array if no column is selected - `int[]`"
  ([^javax.swing.JTable this]
    (-> this (.getSelectedColumns))))

(defn get-scrollable-tracks-viewport-height?
  "Returns false to indicate that the height of the viewport does
   not determine the height of the table, unless
   getFillsViewportHeight is true and the preferred height
   of the table is smaller than the viewport's height.

  returns: false unless getFillsViewportHeight is
           true and the table needs to be stretched to fill
           the viewport - `boolean`"
  ([^javax.swing.JTable this]
    (-> this (.getScrollableTracksViewportHeight))))

(defn column-selection-changed
  "Invoked when the selection model of the TableColumnModel
   is changed.

   Application code will not use these methods explicitly, they
   are used internally by JTable.

  e - the event received - `javax.swing.event.ListSelectionEvent`"
  ([^javax.swing.JTable this ^javax.swing.event.ListSelectionEvent e]
    (-> this (.columnSelectionChanged e))))

(defn column-selected?
  "Returns true if the specified index is in the valid range of columns,
   and the column at that index is selected.

  column - the column in the column model - `int`

  returns: true if column is a valid index and the column at
                that index is selected (where 0 is the first column) - `boolean`"
  ([^javax.swing.JTable this ^Integer column]
    (-> this (.isColumnSelected column))))

(defn print
  "Prints this JTable. Takes steps that the majority of
   developers would take in order to print a JTable.
   In short, it prepares the table, calls getPrintable to
   fetch an appropriate Printable, and then sends it to the
   printer.

   A boolean parameter allows you to specify whether or not
   a printing dialog is displayed to the user. When it is, the user may
   use the dialog to change the destination printer or printing attributes,
   or even to cancel the print. Another two parameters allow for a
   PrintService and printing attributes to be specified.
   These parameters can be used either to provide initial values for the
   print dialog, or to specify values when the dialog is not shown.

   A second boolean parameter allows you to specify whether
   or not to perform printing in an interactive mode. If true,
   a modal progress dialog, with an abort option, is displayed for the
   duration of printing . This dialog also prevents any user action which
   may affect the table. However, it can not prevent the table from being
   modified by code (for example, another thread that posts updates using
   SwingUtilities.invokeLater). It is therefore the
   responsibility of the developer to ensure that no other code modifies
   the table in any way during printing (invalid modifications include
   changes in: size, renderers, or underlying data). Printing behavior is
   undefined when the table is changed during printing.

   If false is specified for this parameter, no dialog will
   be displayed and printing will begin immediately on the event-dispatch
   thread. This blocks any other events, including repaints, from being
   processed until printing is complete. Although this effectively prevents
   the table from being changed, it doesn't provide a good user experience.
   For this reason, specifying false is only recommended when
   printing from an application with no visible GUI.

   Note: Attempting to show the printing dialog or run interactively, while
   in headless mode, will result in a HeadlessException.

   Before fetching the printable, this method will gracefully terminate
   editing, if necessary, to prevent an editor from showing in the printed
   result. Additionally, JTable will prepare its renderers
   during printing such that selection and focus are not indicated.
   As far as customizing further how the table looks in the printout,
   developers can provide custom renderers or paint code that conditionalize
   on the value of JComponent.isPaintingForPrint().

   See getPrintable(javax.swing.JTable.PrintMode, java.text.MessageFormat, java.text.MessageFormat) for more description on how the table is
   printed.

  print-mode - the printing mode that the printable should use - `javax.swing.JTable.PrintMode`
  header-format - a MessageFormat specifying the text to be used in printing a header, or null for none - `java.text.MessageFormat`
  footer-format - a MessageFormat specifying the text to be used in printing a footer, or null for none - `java.text.MessageFormat`
  show-print-dialog - whether or not to display a print dialog - `boolean`
  attr - a PrintRequestAttributeSet specifying any printing attributes, or null for none - `javax.print.attribute.PrintRequestAttributeSet`
  interactive - whether or not to print in an interactive mode - `boolean`
  service - the destination PrintService, or null to use the default printer - `javax.print.PrintService`

  returns: true, unless printing is cancelled by the user - `boolean`

  throws: java.awt.HeadlessException - if the method is asked to show a printing dialog or run interactively, and GraphicsEnvironment.isHeadless returns true"
  ([^javax.swing.JTable this ^javax.swing.JTable.PrintMode print-mode ^java.text.MessageFormat header-format ^java.text.MessageFormat footer-format ^Boolean show-print-dialog ^javax.print.attribute.PrintRequestAttributeSet attr ^Boolean interactive ^javax.print.PrintService service]
    (-> this (.print print-mode header-format footer-format show-print-dialog attr interactive service)))
  ([^javax.swing.JTable this ^javax.swing.JTable.PrintMode print-mode ^java.text.MessageFormat header-format ^java.text.MessageFormat footer-format ^Boolean show-print-dialog ^javax.print.attribute.PrintRequestAttributeSet attr ^Boolean interactive]
    (-> this (.print print-mode header-format footer-format show-print-dialog attr interactive)))
  ([^javax.swing.JTable this ^javax.swing.JTable.PrintMode print-mode ^java.text.MessageFormat header-format ^java.text.MessageFormat footer-format]
    (-> this (.print print-mode header-format footer-format)))
  ([^javax.swing.JTable this ^javax.swing.JTable.PrintMode print-mode]
    (-> this (.print print-mode)))
  ([^javax.swing.JTable this]
    (-> this (.print))))

(defn column-removed
  "Invoked when a column is removed from the table column model.

   Application code will not use these methods explicitly, they
   are used internally by JTable.

  e - `javax.swing.event.TableColumnModelEvent`"
  ([^javax.swing.JTable this ^javax.swing.event.TableColumnModelEvent e]
    (-> this (.columnRemoved e))))

(defn get-drag-enabled?
  "Returns whether or not automatic drag handling is enabled.

  returns: the value of the dragEnabled property - `boolean`"
  ([^javax.swing.JTable this]
    (-> this (.getDragEnabled))))

(defn get-intercell-spacing
  "Returns the horizontal and vertical space between cells.
   The default spacing is look and feel dependent.

  returns: the horizontal and vertical spacing between cells - `java.awt.Dimension`"
  ([^javax.swing.JTable this]
    (-> this (.getIntercellSpacing))))

(defn set-default-editor
  "Sets a default cell editor to be used if no editor has been set in
   a TableColumn. If no editing is required in a table, or a
   particular column in a table, uses the isCellEditable
   method in the TableModel interface to ensure that this
   JTable will not start an editor in these columns.
   If editor is null, removes the default editor for this
   column class.

  column-class - set the default cell editor for this columnClass - `java.lang.Class<?>`
  editor - default cell editor to be used for this columnClass - `javax.swing.table.TableCellEditor`"
  ([^javax.swing.JTable this ^java.lang.Class column-class ^javax.swing.table.TableCellEditor editor]
    (-> this (.setDefaultEditor column-class editor))))

(defn get-column-model
  "Returns the TableColumnModel that contains all column information
   of this table.

  returns: the object that provides the column state of the table - `javax.swing.table.TableColumnModel`"
  ([^javax.swing.JTable this]
    (-> this (.getColumnModel))))

(defn get-table-header
  "Returns the tableHeader used by this JTable.

  returns: the tableHeader used by this table - `javax.swing.table.JTableHeader`"
  ([^javax.swing.JTable this]
    (-> this (.getTableHeader))))

(defn sorter-changed
  "RowSorterListener notification that the
   RowSorter has changed in some way.

  e - the RowSorterEvent describing the change - `javax.swing.event.RowSorterEvent`

  throws: java.lang.NullPointerException - if e is null"
  ([^javax.swing.JTable this ^javax.swing.event.RowSorterEvent e]
    (-> this (.sorterChanged e))))

(defn get-editing-row
  "Returns the index of the row that contains the cell currently
   being edited.  If nothing is being edited, returns -1.

  returns: the index of the row that contains the cell currently
            being edited; returns -1 if nothing being edited - `int`"
  ([^javax.swing.JTable this]
    (-> this (.getEditingRow))))

(defn get-printable
  "Return a Printable for use in printing this JTable.

   This method is meant for those wishing to customize the default
   Printable implementation used by JTable's
   print methods. Developers wanting simply to print the table
   should use one of those methods directly.

   The Printable can be requested in one of two printing modes.
   In both modes, it spreads table rows naturally in sequence across
   multiple pages, fitting as many rows as possible per page.
   PrintMode.NORMAL specifies that the table be
   printed at its current size. In this mode, there may be a need to spread
   columns across pages in a similar manner to that of the rows. When the
   need arises, columns are distributed in an order consistent with the
   table's ComponentOrientation.
   PrintMode.FIT_WIDTH specifies that the output be
   scaled smaller, if necessary, to fit the table's entire width
   (and thereby all columns) on each page. Width and height are scaled
   equally, maintaining the aspect ratio of the output.

   The Printable heads the portion of table on each page
   with the appropriate section from the table's JTableHeader,
   if it has one.

   Header and footer text can be added to the output by providing
   MessageFormat arguments. The printing code requests
   Strings from the formats, providing a single item which may be included
   in the formatted string: an Integer representing the current
   page number.

   You are encouraged to read the documentation for
   MessageFormat as some characters, such as single-quote,
   are special and need to be escaped.

   Here's an example of creating a MessageFormat that can be
   used to print `Duke's Table: Page - ` and the current page number:



       // notice the escaping of the single quote
       // notice how the page number is included with `{0}`
       MessageFormat format = new MessageFormat(`Duke''s Table: Page - {0}`);

   The Printable constrains what it draws to the printable
   area of each page that it prints. Under certain circumstances, it may
   find it impossible to fit all of a page's content into that area. In
   these cases the output may be clipped, but the implementation
   makes an effort to do something reasonable. Here are a few situations
   where this is known to occur, and how they may be handled by this
   particular implementation:

     In any mode, when the header or footer text is too wide to fit
         completely in the printable area -- print as much of the text as
         possible starting from the beginning, as determined by the table's
         ComponentOrientation.
     In any mode, when a row is too tall to fit in the
         printable area -- print the upper-most portion of the row
         and paint no lower border on the table.
     In PrintMode.NORMAL when a column
         is too wide to fit in the printable area -- print the center
         portion of the column and leave the left and right borders
         off the table.


   It is entirely valid for this Printable to be wrapped
   inside another in order to create complex reports and documents. You may
   even request that different pages be rendered into different sized
   printable areas. The implementation must be prepared to handle this
   (possibly by doing its layout calculations on the fly). However,
   providing different heights to each page will likely not work well
   with PrintMode.NORMAL when it has to spread columns
   across pages.

   As far as customizing how the table looks in the printed result,
   JTable itself will take care of hiding the selection
   and focus during printing. For additional customizations, your
   renderers or painting code can customize the look based on the value
   of JComponent.isPaintingForPrint()

   Also, before calling this method you may wish to first
   modify the state of the table, such as to cancel cell editing or
   have the user size the table appropriately. However, you must not
   modify the state of the table after this Printable
   has been fetched (invalid modifications include changes in size or
   underlying data). The behavior of the returned Printable
   is undefined once the table has been changed.

  print-mode - the printing mode that the printable should use - `javax.swing.JTable.PrintMode`
  header-format - a MessageFormat specifying the text to be used in printing a header, or null for none - `java.text.MessageFormat`
  footer-format - a MessageFormat specifying the text to be used in printing a footer, or null for none - `java.text.MessageFormat`

  returns: a Printable for printing this JTable - `java.awt.print.Printable`"
  ([^javax.swing.JTable this ^javax.swing.JTable.PrintMode print-mode ^java.text.MessageFormat header-format ^java.text.MessageFormat footer-format]
    (-> this (.getPrintable print-mode header-format footer-format))))

(defn column-at-point
  "Returns the index of the column that point lies in,
   or -1 if the result is not in the range
   [0, getColumnCount()-1].

  point - the location of interest - `java.awt.Point`

  returns: the index of the column that point lies in,
            or -1 if the result is not in the range
            [0, getColumnCount()-1] - `int`"
  ([^javax.swing.JTable this ^java.awt.Point point]
    (-> this (.columnAtPoint point))))

(defn convert-row-index-to-view
  "Maps the index of the row in terms of the
   TableModel to the view.  If the contents of the
   model are not sorted the model and view indices are the same.

  model-row-index - the index of the row in terms of the model - `int`

  returns: the index of the corresponding row in the view, or -1 if
           the row isn't visible - `int`

  throws: java.lang.IndexOutOfBoundsException - if sorting is enabled and passed an index outside the number of rows of the TableModel"
  ([^javax.swing.JTable this ^Integer model-row-index]
    (-> this (.convertRowIndexToView model-row-index))))

(defn get-model
  "Returns the TableModel that provides the data displayed by this
   JTable.

  returns: the TableModel that provides the data displayed by this JTable - `javax.swing.table.TableModel`"
  ([^javax.swing.JTable this]
    (-> this (.getModel))))

(defn editing?
  "Returns true if a cell is being edited.

  returns: true if the table is editing a cell - `boolean`"
  ([^javax.swing.JTable this]
    (-> this (.isEditing))))

(defn get-selected-rows
  "Returns the indices of all selected rows.

  returns: an array of integers containing the indices of all selected rows,
           or an empty array if no row is selected - `int[]`"
  ([^javax.swing.JTable this]
    (-> this (.getSelectedRows))))

(defn get-selected-column
  "Returns the index of the first selected column,
   -1 if no column is selected.

  returns: the index of the first selected column - `int`"
  ([^javax.swing.JTable this]
    (-> this (.getSelectedColumn))))

(defn get-cell-rect
  "Returns a rectangle for the cell that lies at the intersection of
   row and column.
   If includeSpacing is true then the value returned
   has the full height and width of the row and column
   specified. If it is false, the returned rectangle is inset by the
   intercell spacing to return the true bounds of the rendering or
   editing component as it will be set during rendering.

   If the column index is valid but the row index is less
   than zero the method returns a rectangle with the
   y and height values set appropriately
   and the x and width values both set
   to zero. In general, when either the row or column indices indicate a
   cell outside the appropriate range, the method returns a rectangle
   depicting the closest edge of the closest cell that is within
   the table's range. When both row and column indices are out
   of range the returned rectangle covers the closest
   point of the closest cell.

   In all cases, calculations that use this method to calculate
   results along one axis will not fail because of anomalies in
   calculations along the other axis. When the cell is not valid
   the includeSpacing parameter is ignored.

  row - the row index where the desired cell is located - `int`
  column - the column index where the desired cell is located in the display; this is not necessarily the same as the column index in the data model for the table; the convertColumnIndexToView(int) method may be used to convert a data model column index to a display column index - `int`
  include-spacing - if false, return the true cell bounds - computed by subtracting the intercell spacing from the height and widths of the column and row models - `boolean`

  returns: the rectangle containing the cell at location
            row,column - `java.awt.Rectangle`"
  ([^javax.swing.JTable this ^Integer row ^Integer column ^Boolean include-spacing]
    (-> this (.getCellRect row column include-spacing))))

(defn create-default-columns-from-model
  "Creates default columns for the table from
   the data model using the getColumnCount method
   defined in the TableModel interface.

   Clears any existing columns before creating the
   new columns based on information from the model."
  ([^javax.swing.JTable this]
    (-> this (.createDefaultColumnsFromModel))))

(defn column-added
  "Invoked when a column is added to the table column model.

   Application code will not use these methods explicitly, they
   are used internally by JTable.

  e - `javax.swing.event.TableColumnModelEvent`"
  ([^javax.swing.JTable this ^javax.swing.event.TableColumnModelEvent e]
    (-> this (.columnAdded e))))

(defn set-show-grid
  "Sets whether the table draws grid lines around cells.
    If showGrid is true it does; if it is false it doesn't.
    There is no getShowGrid method as this state is held
    in two variables -- showHorizontalLines and showVerticalLines --
    each of which can be queried independently.

  show-grid - true if table view should draw grid lines - `boolean`"
  ([^javax.swing.JTable this ^Boolean show-grid]
    (-> this (.setShowGrid show-grid))))

(defn set-cell-editor
  "Sets the active cell editor.

  an-editor - the active cell editor - `javax.swing.table.TableCellEditor`"
  ([^javax.swing.JTable this ^javax.swing.table.TableCellEditor an-editor]
    (-> this (.setCellEditor an-editor))))

(defn set-model
  "Sets the data model for this table to newModel and registers
   with it for listener notifications from the new data model.

  data-model - the new data source for this table - `javax.swing.table.TableModel`

  throws: java.lang.IllegalArgumentException - if newModel is null"
  ([^javax.swing.JTable this ^javax.swing.table.TableModel data-model]
    (-> this (.setModel data-model))))

(defn editing-canceled
  "Invoked when editing is canceled. The editor object is discarded
   and the cell is rendered once again.

   Application code will not use these methods explicitly, they
   are used internally by JTable.

  e - the event received - `javax.swing.event.ChangeEvent`"
  ([^javax.swing.JTable this ^javax.swing.event.ChangeEvent e]
    (-> this (.editingCanceled e))))

(defn get-default-renderer
  "Returns the cell renderer to be used when no renderer has been set in
   a TableColumn. During the rendering of cells the renderer is fetched from
   a Hashtable of entries according to the class of the cells in the column. If
   there is no entry for this columnClass the method returns
   the entry for the most specific superclass. The JTable installs entries
   for Object, Number, and Boolean, all of which can be modified
   or replaced.

  column-class - return the default cell renderer for this columnClass - `java.lang.Class<?>`

  returns: the renderer for this columnClass - `javax.swing.table.TableCellRenderer`"
  ([^javax.swing.JTable this ^java.lang.Class column-class]
    (-> this (.getDefaultRenderer column-class))))

(defn get-row-sorter
  "Returns the object responsible for sorting.

  returns: the object responsible for sorting - `javax.swing.RowSorter<? extends javax.swing.table.TableModel>`"
  ([^javax.swing.JTable this]
    (-> this (.getRowSorter))))

(defn update-ui
  "Notification from the UIManager that the L&F has changed.
   Replaces the current UI object with the latest version from the
   UIManager."
  ([^javax.swing.JTable this]
    (-> this (.updateUI))))

(defn get-row-height
  "Returns the height, in pixels, of the cells in row.

  row - the row whose height is to be returned - `int`

  returns: the height, in pixels, of the cells in the row - `int`"
  ([^javax.swing.JTable this ^Integer row]
    (-> this (.getRowHeight row)))
  ([^javax.swing.JTable this]
    (-> this (.getRowHeight))))

(defn set-default-renderer
  "Sets a default cell renderer to be used if no renderer has been set in
   a TableColumn. If renderer is null,
   removes the default renderer for this column class.

  column-class - set the default cell renderer for this columnClass - `java.lang.Class<?>`
  renderer - default cell renderer to be used for this columnClass - `javax.swing.table.TableCellRenderer`"
  ([^javax.swing.JTable this ^java.lang.Class column-class ^javax.swing.table.TableCellRenderer renderer]
    (-> this (.setDefaultRenderer column-class renderer))))

(defn get-auto-create-row-sorter?
  "Returns true if whenever the model changes, a new
   RowSorter should be created and installed
   as the table's sorter; otherwise, returns false.

  returns: true if a RowSorter should be created when
           the model changes - `boolean`"
  ([^javax.swing.JTable this]
    (-> this (.getAutoCreateRowSorter))))

(defn get-auto-create-columns-from-model?
  "Determines whether the table will create default columns from the model.
   If true, setModel will clear any existing columns and
   create new columns from the new model.  Also, if the event in
   the tableChanged notification specifies that the
   entire table changed, then the columns will be rebuilt.
   The default is true.

  returns: the autoCreateColumnsFromModel of the table - `boolean`"
  ([^javax.swing.JTable this]
    (-> this (.getAutoCreateColumnsFromModel))))

(defn set-selection-mode
  "Sets the table's selection mode to allow only single selections, a single
   contiguous interval, or multiple intervals.

   Note:
   JTable provides all the methods for handling
   column and row selection.  When setting states,
   such as setSelectionMode, it not only
   updates the mode for the row selection model but also sets similar
   values in the selection model of the columnModel.
   If you want to have the row and column selection models operating
   in different modes, set them both directly.

   Both the row and column selection models for JTable
   default to using a DefaultListSelectionModel
   so that JTable works the same way as the
   JList. See the setSelectionMode method
   in JList for details about the modes.

  selection-mode - `int`"
  ([^javax.swing.JTable this ^Integer selection-mode]
    (-> this (.setSelectionMode selection-mode))))

(defn editing-stopped
  "Invoked when editing is finished. The changes are saved and the
   editor is discarded.

   Application code will not use these methods explicitly, they
   are used internally by JTable.

  e - the event received - `javax.swing.event.ChangeEvent`"
  ([^javax.swing.JTable this ^javax.swing.event.ChangeEvent e]
    (-> this (.editingStopped e))))

(defn set-preferred-scrollable-viewport-size
  "Sets the preferred size of the viewport for this table.

  size - a Dimension object specifying the preferredSize of a JViewport whose view is this table - `java.awt.Dimension`"
  ([^javax.swing.JTable this ^java.awt.Dimension size]
    (-> this (.setPreferredScrollableViewportSize size))))

