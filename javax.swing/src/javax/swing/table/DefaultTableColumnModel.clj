(ns javax.swing.table.DefaultTableColumnModel
  "The standard column-handler for a JTable.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.table DefaultTableColumnModel]))

(defn ->default-table-column-model
  "Constructor.

  Creates a default table column model."
  (^DefaultTableColumnModel []
    (new DefaultTableColumnModel )))

(defn set-column-selection-allowed
  "Sets whether column selection is allowed.  The default is false.

  flag - true if column selection will be allowed, false otherwise - `boolean`"
  ([^DefaultTableColumnModel this ^Boolean flag]
    (-> this (.setColumnSelectionAllowed flag))))

(defn get-column
  "Returns the TableColumn object for the column
   at columnIndex.

  column-index - the index of the column desired - `int`

  returns: the TableColumn object for the column
                            at columnIndex - `javax.swing.table.TableColumn`"
  (^javax.swing.table.TableColumn [^DefaultTableColumnModel this ^Integer column-index]
    (-> this (.getColumn column-index))))

(defn get-columns
  "Returns an Enumeration of all the columns in the model.

  returns: an Enumeration of the columns in the model - `java.util.Enumeration<javax.swing.table.TableColumn>`"
  (^java.util.Enumeration [^DefaultTableColumnModel this]
    (-> this (.getColumns))))

(defn get-column-count
  "Returns the number of columns in the tableColumns array.

  returns: the number of columns in the tableColumns array - `int`"
  (^Integer [^DefaultTableColumnModel this]
    (-> this (.getColumnCount))))

(defn set-selection-model
  "Sets the selection model for this TableColumnModel
    to newModel
    and registers for listener notifications from the new selection
    model.  If newModel is null,
    an exception is thrown.

  new-model - the new selection model - `javax.swing.ListSelectionModel`

  throws: java.lang.IllegalArgumentException - if newModel is null"
  ([^DefaultTableColumnModel this ^javax.swing.ListSelectionModel new-model]
    (-> this (.setSelectionModel new-model))))

(defn get-column-selection-allowed?
  "Returns true if column selection is allowed, otherwise false.
   The default is false.

  returns: the columnSelectionAllowed property - `boolean`"
  (^Boolean [^DefaultTableColumnModel this]
    (-> this (.getColumnSelectionAllowed))))

(defn remove-column
  "Deletes the column from the
    tableColumns array.  This method will do nothing if
    column is not in the table's columns list.
    tile is called
    to resize both the header and table views.
    This method also posts a columnRemoved
    event to its listeners.

  column - the TableColumn to be removed - `javax.swing.table.TableColumn`"
  ([^DefaultTableColumnModel this ^javax.swing.table.TableColumn column]
    (-> this (.removeColumn column))))

(defn property-change
  "Property Change Listener change method.  Used to track changes
   to the column width or preferred column width.

  evt - PropertyChangeEvent - `java.beans.PropertyChangeEvent`"
  ([^DefaultTableColumnModel this ^java.beans.PropertyChangeEvent evt]
    (-> this (.propertyChange evt))))

(defn remove-column-model-listener
  "Removes a listener for table column model events.

  x - a TableColumnModelListener object - `javax.swing.event.TableColumnModelListener`"
  ([^DefaultTableColumnModel this ^javax.swing.event.TableColumnModelListener x]
    (-> this (.removeColumnModelListener x))))

(defn get-selection-model
  "Returns the ListSelectionModel that is used to
   maintain column selection state.

  returns: the object that provides column selection state.  Or
            null if row selection is not allowed. - `javax.swing.ListSelectionModel`"
  (^javax.swing.ListSelectionModel [^DefaultTableColumnModel this]
    (-> this (.getSelectionModel))))

(defn value-changed
  "A ListSelectionListener that forwards
   ListSelectionEvents when there is a column
   selection change.

  e - the change event - `javax.swing.event.ListSelectionEvent`"
  ([^DefaultTableColumnModel this ^javax.swing.event.ListSelectionEvent e]
    (-> this (.valueChanged e))))

(defn get-selected-column-count
  "Returns the number of columns selected.

  returns: the number of columns selected - `int`"
  (^Integer [^DefaultTableColumnModel this]
    (-> this (.getSelectedColumnCount))))

(defn move-column
  "Moves the column and heading at columnIndex to
   newIndex.  The old column at columnIndex
   will now be found at newIndex.  The column
   that used to be at newIndex is shifted
   left or right to make room.  This will not move any columns if
   columnIndex equals newIndex.  This method
   also posts a columnMoved event to its listeners.

  column-index - the index of column to be moved - `int`
  new-index - new index to move the column - `int`

  throws: java.lang.IllegalArgumentException - if column or newIndex are not in the valid range"
  ([^DefaultTableColumnModel this ^Integer column-index ^Integer new-index]
    (-> this (.moveColumn column-index new-index))))

(defn add-column
  "Appends aColumn to the end of the
    tableColumns array.
    This method also posts the columnAdded
    event to its listeners.

  a-column - the TableColumn to be added - `javax.swing.table.TableColumn`

  throws: java.lang.IllegalArgumentException - if aColumn is null"
  ([^DefaultTableColumnModel this ^javax.swing.table.TableColumn a-column]
    (-> this (.addColumn a-column))))

(defn set-column-margin
  "Sets the column margin to newMargin.  This method
   also posts a columnMarginChanged event to its
   listeners.

  new-margin - the new margin width, in pixels - `int`"
  ([^DefaultTableColumnModel this ^Integer new-margin]
    (-> this (.setColumnMargin new-margin))))

(defn get-column-model-listeners
  "Returns an array of all the column model listeners
   registered on this model.

  returns: all of this default table column model's ColumnModelListeners
           or an empty
           array if no column model listeners are currently registered - `javax.swing.event.TableColumnModelListener[]`"
  ([^DefaultTableColumnModel this]
    (-> this (.getColumnModelListeners))))

(defn get-column-margin
  "Returns the width margin for TableColumn.
   The default columnMargin is 1.

  returns: the maximum width for the TableColumn - `int`"
  (^Integer [^DefaultTableColumnModel this]
    (-> this (.getColumnMargin))))

(defn get-selected-columns
  "Returns an array of selected columns.  If selectionModel
   is null, returns an empty array.

  returns: an array of selected columns or an empty array if nothing
                    is selected or the selectionModel is
                    null - `int[]`"
  ([^DefaultTableColumnModel this]
    (-> this (.getSelectedColumns))))

(defn get-total-column-width
  "Returns the total combined width of all columns.

  returns: the totalColumnWidth property - `int`"
  (^Integer [^DefaultTableColumnModel this]
    (-> this (.getTotalColumnWidth))))

(defn get-column-index-at-x
  "Returns the index of the column that lies at position x,
   or -1 if no column covers this point.

   In keeping with Swing's separable model architecture, a
   TableColumnModel does not know how the table columns actually appear on
   screen.  The visual presentation of the columns is the responsibility
   of the view/controller object using this model (typically JTable).  The
   view/controller need not display the columns sequentially from left to
   right.  For example, columns could be displayed from right to left to
   accommodate a locale preference or some columns might be hidden at the
   request of the user.  Because the model does not know how the columns
   are laid out on screen, the given xPosition should not be
   considered to be a coordinate in 2D graphics space.  Instead, it should
   be considered to be a width from the start of the first column in the
   model.  If the column index for a given X coordinate in 2D space is
   required, JTable.columnAtPoint can be used instead.

  x - the horizontal location of interest - `int`

  returns: the index of the column or -1 if no column is found - `int`"
  (^Integer [^DefaultTableColumnModel this ^Integer x]
    (-> this (.getColumnIndexAtX x))))

(defn get-listeners
  "Returns an array of all the objects currently registered
   as FooListeners
   upon this model.
   FooListeners are registered using the
   addFooListener method.



   You can specify the listenerType argument
   with a class literal,
   such as
   FooListener.class.
   For example, you can query a
   DefaultTableColumnModel m
   for its column model listeners with the following code:



  ColumnModelListener[] cmls = (ColumnModelListener[])(m.getListeners(ColumnModelListener.class));

   If no such listeners exist, this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class`

  returns: an array of all objects registered as
            FooListeners on this model,
            or an empty array if no such
            listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([^DefaultTableColumnModel this ^java.lang.Class listener-type]
    (-> this (.getListeners listener-type))))

(defn add-column-model-listener
  "Adds a listener for table column model events.

  x - a TableColumnModelListener object - `javax.swing.event.TableColumnModelListener`"
  ([^DefaultTableColumnModel this ^javax.swing.event.TableColumnModelListener x]
    (-> this (.addColumnModelListener x))))

(defn get-column-index
  "Returns the index of the first column in the tableColumns
   array whose identifier is equal to identifier,
   when compared using equals.

  identifier - the identifier object - `java.lang.Object`

  returns: the index of the first column in the
                    tableColumns array whose identifier
                    is equal to identifier - `int`

  throws: java.lang.IllegalArgumentException - if identifier is null, or if no TableColumn has this identifier"
  (^Integer [^DefaultTableColumnModel this ^java.lang.Object identifier]
    (-> this (.getColumnIndex identifier))))

