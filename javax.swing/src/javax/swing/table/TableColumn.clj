(ns javax.swing.table.TableColumn
  "A TableColumn represents all the attributes of a column in a
   JTable, such as width, resizability, minimum and maximum width.
   In addition, the TableColumn provides slots for a renderer and
   an editor that can be used to display and edit the values in this column.

   It is also possible to specify renderers and editors on a per type basis
   rather than a per column basis - see the
   setDefaultRenderer method in the JTable class.
   This default mechanism is only used when the renderer (or
   editor) in the TableColumn is null.

   The TableColumn stores the link between the columns in the
   JTable and the columns in the TableModel.
   The modelIndex is the column in the
   TableModel, which will be queried for the data values for the
   cells in this column. As the column moves around in the view this
   modelIndex does not change.

  Note: Some implementations may assume that all
     TableColumnModels are unique, therefore we would
     recommend that the same TableColumn instance
     not be added more than once to a TableColumnModel.
     To show TableColumns with the same column of
     data from the model, create a new instance with the same
     modelIndex.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.table TableColumn]))

(defn ->table-column
  "Constructor.

  Creates and initializes an instance of
    TableColumn with the specified model index,
    width, cell renderer, and cell editor;
    all TableColumn constructors delegate to this one.
    The value of width is used
    for both the initial and preferred width;
    if width is negative,
    they're set to 0.
    The minimum width is set to 15 unless the initial width is less,
    in which case the minimum width is set to
    the initial width.


    When the cellRenderer
    or cellEditor parameter is null,
    a default value provided by the JTable
    getDefaultRenderer
    or getDefaultEditor method, respectively,
    is used to
    provide defaults based on the type of the data in this column.
    This column-centric rendering strategy can be circumvented by overriding
    the getCellRenderer methods in JTable.

  model-index - the index of the column in the model that supplies the data for this column in the table; the model index remains the same even when columns are reordered in the view - `int`
  width - this column's preferred width and initial width - `int`
  cell-renderer - the object used to render values in this column - `javax.swing.table.TableCellRenderer`
  cell-editor - the object used to edit values in this column - `javax.swing.table.TableCellEditor`"
  (^TableColumn [^Integer model-index ^Integer width ^javax.swing.table.TableCellRenderer cell-renderer ^javax.swing.table.TableCellEditor cell-editor]
    (new TableColumn model-index width cell-renderer cell-editor))
  (^TableColumn [^Integer model-index ^Integer width]
    (new TableColumn model-index width))
  (^TableColumn [^Integer model-index]
    (new TableColumn model-index))
  (^TableColumn []
    (new TableColumn )))

(def *-column-width-property
  "Static Constant.

  Obsolete as of Java 2 platform v1.3.  Please use string literals to identify
   properties.

  type: java.lang.String"
  TableColumn/COLUMN_WIDTH_PROPERTY)

(def *-header-value-property
  "Static Constant.

  Obsolete as of Java 2 platform v1.3.  Please use string literals to identify
   properties.

  type: java.lang.String"
  TableColumn/HEADER_VALUE_PROPERTY)

(def *-header-renderer-property
  "Static Constant.

  Obsolete as of Java 2 platform v1.3.  Please use string literals to identify
   properties.

  type: java.lang.String"
  TableColumn/HEADER_RENDERER_PROPERTY)

(def *-cell-renderer-property
  "Static Constant.

  Obsolete as of Java 2 platform v1.3.  Please use string literals to identify
   properties.

  type: java.lang.String"
  TableColumn/CELL_RENDERER_PROPERTY)

(defn get-min-width
  "Returns the minimum width for the TableColumn. The
   TableColumn's width can't be made less than this either
   by the user or programmatically.

  returns: the minWidth property - `int`"
  (^Integer [^TableColumn this]
    (-> this (.getMinWidth))))

(defn set-header-renderer
  "Sets the TableCellRenderer used to draw the
   TableColumn's header to headerRenderer.

   It is the header renderers responsibility to render the sorting
   indicator.  If you are using sorting and specify a renderer your
   renderer must render the sorting indication.

  header-renderer - the new headerRenderer - `javax.swing.table.TableCellRenderer`"
  ([^TableColumn this ^javax.swing.table.TableCellRenderer header-renderer]
    (-> this (.setHeaderRenderer header-renderer))))

(defn get-max-width
  "Returns the maximum width for the TableColumn. The
   TableColumn's width can't be made larger than this
   either by the user or programmatically.  The default maxWidth
   is Integer.MAX_VALUE.

  returns: the maxWidth property - `int`"
  (^Integer [^TableColumn this]
    (-> this (.getMaxWidth))))

(defn get-width
  "Returns the width of the TableColumn. The default width is
   75.

  returns: the width property - `int`"
  (^Integer [^TableColumn this]
    (-> this (.getWidth))))

(defn set-cell-renderer
  "Sets the TableCellRenderer used by JTable
   to draw individual values for this column.

  cell-renderer - the new cellRenderer - `javax.swing.table.TableCellRenderer`"
  ([^TableColumn this ^javax.swing.table.TableCellRenderer cell-renderer]
    (-> this (.setCellRenderer cell-renderer))))

(defn set-width
  "This method should not be used to set the widths of columns in the
   JTable, use setPreferredWidth instead.
   Like a layout manager in the
   AWT, the JTable adjusts a column's width automatically
   whenever the
   table itself changes size, or a column's preferred width is changed.
   Setting widths programmatically therefore has no long term effect.

   This method sets this column's width to width.
   If width exceeds the minimum or maximum width,
   it is adjusted to the appropriate limiting value.

  width - the new width - `int`"
  ([^TableColumn this ^Integer width]
    (-> this (.setWidth width))))

(defn set-model-index
  "Sets the model index for this column. The model index is the
   index of the column in the model that will be displayed by this
   TableColumn. As the TableColumn
   is moved around in the view the model index remains constant.

  model-index - the new modelIndex - `int`"
  ([^TableColumn this ^Integer model-index]
    (-> this (.setModelIndex model-index))))

(defn get-resizable?
  "Returns true if the user is allowed to resize the
   TableColumn's
   width, false otherwise. You can change the width programmatically
   regardless of this setting.  The default is true.

  returns: the isResizable property - `boolean`"
  (^Boolean [^TableColumn this]
    (-> this (.getResizable))))

(defn enable-resized-posting
  "Deprecated. as of Java 2 platform v1.3"
  ([^TableColumn this]
    (-> this (.enableResizedPosting))))

(defn get-cell-editor
  "Returns the TableCellEditor used by the
   JTable to edit values for this column.  When the
   cellEditor is null, the JTable
   uses a default editor based on the
   class of the cells in that column. The default value for a
   cellEditor is null.

  returns: the cellEditor property - `javax.swing.table.TableCellEditor`"
  (^javax.swing.table.TableCellEditor [^TableColumn this]
    (-> this (.getCellEditor))))

(defn remove-property-change-listener
  "Removes a PropertyChangeListener from the listener list.
   The PropertyChangeListener to be removed was registered
   for all properties.

  listener - the listener to be removed - `java.beans.PropertyChangeListener`"
  ([^TableColumn this ^java.beans.PropertyChangeListener listener]
    (-> this (.removePropertyChangeListener listener))))

(defn get-cell-renderer
  "Returns the TableCellRenderer used by the
   JTable to draw
   values for this column.  The cellRenderer of the column
   not only controls the visual look for the column, but is also used to
   interpret the value object supplied by the TableModel.
   When the cellRenderer is null,
   the JTable uses a default renderer based on the
   class of the cells in that column. The default value for a
   cellRenderer is null.

  returns: the cellRenderer property - `javax.swing.table.TableCellRenderer`"
  (^javax.swing.table.TableCellRenderer [^TableColumn this]
    (-> this (.getCellRenderer))))

(defn get-identifier
  "Returns the identifier object for this column.
    Note identifiers are not used by JTable,
    they are purely a convenience for external use.
    If the identifier is null,
    getIdentifier() returns getHeaderValue
    as a default.

  returns: the identifier property - `java.lang.Object`"
  (^java.lang.Object [^TableColumn this]
    (-> this (.getIdentifier))))

(defn get-header-value
  "Returns the Object used as the value for the header
   renderer.

  returns: the headerValue property - `java.lang.Object`"
  (^java.lang.Object [^TableColumn this]
    (-> this (.getHeaderValue))))

(defn set-preferred-width
  "Sets this column's preferred width to preferredWidth.
   If preferredWidth exceeds the minimum or maximum width,
   it is adjusted to the appropriate limiting value.

   For details on how the widths of columns in the JTable
   (and JTableHeader) are calculated from the
   preferredWidth,
   see the doLayout method in JTable.

  preferred-width - the new preferred width - `int`"
  ([^TableColumn this ^Integer preferred-width]
    (-> this (.setPreferredWidth preferred-width))))

(defn set-min-width
  "Sets the TableColumn's minimum width to
   minWidth,
   adjusting the new minimum width if necessary to ensure that
   0 <= minWidth <= maxWidth.
   For example, if the minWidth argument is negative,
   this method sets the minWidth property to 0.


   If the value of the
   width or preferredWidth property
   is less than the new minimum width,
   this method sets that property to the new minimum width.

  min-width - the new minimum width - `int`"
  ([^TableColumn this ^Integer min-width]
    (-> this (.setMinWidth min-width))))

(defn set-max-width
  "Sets the TableColumn's maximum width to
   maxWidth or,
   if maxWidth is less than the minimum width,
   to the minimum width.


   If the value of the
   width or preferredWidth property
   is more than the new maximum width,
   this method sets that property to the new maximum width.

  max-width - the new maximum width - `int`"
  ([^TableColumn this ^Integer max-width]
    (-> this (.setMaxWidth max-width))))

(defn get-header-renderer
  "Returns the TableCellRenderer used to draw the header of the
   TableColumn. When the headerRenderer is
   null, the JTableHeader
   uses its defaultRenderer. The default value for a
   headerRenderer is null.

  returns: the headerRenderer property - `javax.swing.table.TableCellRenderer`"
  (^javax.swing.table.TableCellRenderer [^TableColumn this]
    (-> this (.getHeaderRenderer))))

(defn size-width-to-fit
  "Resizes the TableColumn to fit the width of its header cell.
   This method does nothing if the header renderer is null
   (the default case). Otherwise, it sets the minimum, maximum and preferred
   widths of this column to the widths of the minimum, maximum and preferred
   sizes of the Component delivered by the header renderer.
   The transient \"width\" property of this TableColumn is also set to the
   preferred width. Note this method is not used internally by the table
   package."
  ([^TableColumn this]
    (-> this (.sizeWidthToFit))))

(defn get-property-change-listeners
  "Returns an array of all the PropertyChangeListeners added
   to this TableColumn with addPropertyChangeListener().

  returns: all of the PropertyChangeListeners added or an empty
           array if no listeners have been added - `java.beans.PropertyChangeListener[]`"
  ([^TableColumn this]
    (-> this (.getPropertyChangeListeners))))

(defn set-header-value
  "Sets the Object whose string representation will be
   used as the value for the headerRenderer.  When the
   TableColumn is created, the default headerValue
   is null.

  header-value - the new headerValue - `java.lang.Object`"
  ([^TableColumn this ^java.lang.Object header-value]
    (-> this (.setHeaderValue header-value))))

(defn set-identifier
  "Sets the TableColumn's identifier to
   anIdentifier.
   Note: identifiers are not used by the JTable,
   they are purely a
   convenience for the external tagging and location of columns.

  identifier - an identifier for this column - `java.lang.Object`"
  ([^TableColumn this ^java.lang.Object identifier]
    (-> this (.setIdentifier identifier))))

(defn get-model-index
  "Returns the model index for this column.

  returns: the modelIndex property - `int`"
  (^Integer [^TableColumn this]
    (-> this (.getModelIndex))))

(defn add-property-change-listener
  "Adds a PropertyChangeListener to the listener list.
   The listener is registered for all properties.

   A PropertyChangeEvent will get fired in response to an
   explicit call to setFont, setBackground,
   or setForeground on the
   current component.  Note that if the current component is
   inheriting its foreground, background, or font from its
   container, then no event will be fired in response to a
   change in the inherited property.

  listener - the listener to be added - `java.beans.PropertyChangeListener`"
  ([^TableColumn this ^java.beans.PropertyChangeListener listener]
    (-> this (.addPropertyChangeListener listener))))

(defn set-cell-editor
  "Sets the editor to used by when a cell in this column is edited.

  cell-editor - the new cellEditor - `javax.swing.table.TableCellEditor`"
  ([^TableColumn this ^javax.swing.table.TableCellEditor cell-editor]
    (-> this (.setCellEditor cell-editor))))

(defn set-resizable
  "Sets whether this column can be resized.

  is-resizable - if true, resizing is allowed; otherwise false - `boolean`"
  ([^TableColumn this ^Boolean is-resizable]
    (-> this (.setResizable is-resizable))))

(defn disable-resized-posting
  "Deprecated. as of Java 2 platform v1.3"
  ([^TableColumn this]
    (-> this (.disableResizedPosting))))

(defn get-preferred-width
  "Returns the preferred width of the TableColumn.
   The default preferred width is 75.

  returns: the preferredWidth property - `int`"
  (^Integer [^TableColumn this]
    (-> this (.getPreferredWidth))))

