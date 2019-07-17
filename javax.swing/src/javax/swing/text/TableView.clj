(ns javax.swing.text.TableView
  " Implements View interface for a table, that is composed of an
  element structure where the child elements of the element
  this view is responsible for represent rows and the child
  elements of the row elements are cells.  The cell elements can
  have an arbitrary element structure under them, which will
  be built with the ViewFactory returned by the getViewFactory
  method.


     TABLE
       ROW
         CELL
         CELL
       ROW
         CELL
         CELL

  This is implemented as a hierarchy of boxes, the table itself
  is a vertical box, the rows are horizontal boxes, and the cells
  are vertical boxes.  The cells are allowed to span multiple
  columns and rows.  By default, the table can be thought of as
  being formed over a grid (i.e. somewhat like one would find in
  gridbag layout), where table cells can request to span more
  than one grid cell.  The default horizontal span of table cells
  will be based upon this grid, but can be changed by reimplementing
  the requested span of the cell (i.e. table cells can have independant
  spans if desired)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text TableView]))

(defn ->table-view
  "Constructor.

  Constructs a TableView for the given element.

  elem - the element that this view is responsible for - `javax.swing.text.Element`"
  ([^javax.swing.text.Element elem]
    (new TableView elem)))

(defn replace
  "Change the child views.  This is implemented to
   provide the superclass behavior and invalidate the
   grid so that rows and columns will be recalculated.

  offset - the starting index into the child views to insert the new views; this should be a value >= 0 and <= getViewCount - `int`
  length - the number of existing child views to remove; This should be a value >= 0 and <= (getViewCount() - offset) - `int`
  views - the child views to add; this value can be nullto indicate no children are being added (useful to remove) - `javax.swing.text.View[]`"
  ([^javax.swing.text.TableView this ^Integer offset ^Integer length views]
    (-> this (.replace offset length views))))

