(ns javax.swing.table.TableCellRenderer
  "This interface defines the method required by any object that
  would like to be a renderer for cells in a JTable."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.table TableCellRenderer]))

(defn get-table-cell-renderer-component
  "Returns the component used for drawing the cell.  This method is
   used to configure the renderer appropriately before drawing.

   The TableCellRenderer is also responsible for rendering the
   the cell representing the table's current DnD drop location if
   it has one. If this renderer cares about rendering
   the DnD drop location, it should query the table directly to
   see if the given row and column represent the drop location:


       JTable.DropLocation dropLocation = table.getDropLocation();
       if (dropLocation != null
               && !dropLocation.isInsertRow()
               && !dropLocation.isInsertColumn()
               && dropLocation.getRow() == row
               && dropLocation.getColumn() == column) {

           // this cell represents the current drop location
           // so render it specially, perhaps with a different color
       }

   During a printing operation, this method will be called with
   isSelected and hasFocus values of
   false to prevent selection and focus from appearing
   in the printed output. To do other customization based on whether
   or not the table is being printed, check the return value from
   JComponent.isPaintingForPrint().

  table - the JTable that is asking the renderer to draw; can be null - `javax.swing.JTable`
  value - the value of the cell to be rendered. It is up to the specific renderer to interpret and draw the value. For example, if value is the string `true`, it could be rendered as a string or it could be rendered as a check box that is checked. null is a valid value - `java.lang.Object`
  is-selected - true if the cell is to be rendered with the selection highlighted; otherwise false - `boolean`
  has-focus - if true, render cell appropriately. For example, put a special border on the cell, if the cell can be edited, render in the color used to indicate editing - `boolean`
  row - the row index of the cell being drawn. When drawing the header, the value of row is -1 - `int`
  column - the column index of the cell being drawn - `int`

  returns: `java.awt.Component`"
  ([this table value is-selected has-focus row column]
    (-> this (.getTableCellRendererComponent table value is-selected has-focus row column))))

