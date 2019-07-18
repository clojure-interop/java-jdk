(ns javax.swing.table.TableRowSorter
  "An implementation of RowSorter that provides sorting
  and filtering using a TableModel.
  The following example shows adding sorting to a JTable:


    TableModel myModel = createMyTableModel();
    JTable table = new JTable(myModel);
    table.setRowSorter(new TableRowSorter(myModel));
  This will do all the wiring such that when the user does the appropriate
  gesture, such as clicking on the column header, the table will
  visually sort.

  JTable's row-based methods and JTable's
  selection model refer to the view and not the underlying
  model. Therefore, it is necessary to convert between the two.  For
  example, to get the selection in terms of myModel
  you need to convert the indices:


    int[] selection = table.getSelectedRows();
    for (int i = 0; i < selection.length; i++) {
      selection[i] = table.convertRowIndexToModel(selection[i]);
    }
  Similarly to select a row in JTable based on
  a coordinate from the underlying model do the inverse:


    table.setRowSelectionInterval(table.convertRowIndexToView(row),
                                  table.convertRowIndexToView(row));

  The previous example assumes you have not enabled filtering.  If you
  have enabled filtering convertRowIndexToView will return
  -1 for locations that are not visible in the view.

  TableRowSorter uses Comparators for doing
  comparisons. The following defines how a Comparator is
  chosen for a column:

  If a Comparator has been specified for the column by the
      setComparator method, use it.
  If the column class as returned by getColumnClass is
      String, use the Comparator returned by
      Collator.getInstance().
  If the column class implements Comparable, use a
      Comparator that invokes the compareTo
      method.
  If a TableStringConverter has been specified, use it
      to convert the values to Strings and then use the
      Comparator returned by Collator.getInstance().
  Otherwise use the Comparator returned by
      Collator.getInstance() on the results from
      calling toString on the objects.


  In addition to sorting TableRowSorter provides the ability
  to filter.  A filter is specified using the setFilter
  method. The following example will only show rows containing the string
  `foo`:


    TableModel myModel = createMyTableModel();
    TableRowSorter sorter = new TableRowSorter(myModel);
    sorter.setRowFilter(RowFilter.regexFilter(`.*foo.*`));
    JTable table = new JTable(myModel);
    table.setRowSorter(sorter);

  If the underlying model structure changes (the
  modelStructureChanged method is invoked) the following
  are reset to their default values: Comparators by
  column, current sort order, and whether each column is sortable. The default
  sort order is natural (the same as the model), and columns are
  sortable by default.

  TableRowSorter has one formal type parameter: the type
  of the model.  Passing in a type that corresponds exactly to your
  model allows you to filter based on your model without casting.
  Refer to the documentation of RowFilter for an example
  of this.

  WARNING: DefaultTableModel returns a column
  class of Object.  As such all comparisons will
  be done using toString.  This may be unnecessarily
  expensive.  If the column only contains one type of value, such as
  an Integer, you should override getColumnClass and
  return the appropriate Class.  This will dramatically
  increase the performance of this class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.table TableRowSorter]))

(defn ->table-row-sorter
  "Constructor.

  Creates a TableRowSorter using model
   as the underlying TableModel.

  model - the underlying TableModel to use, null is treated as an empty model - `M`"
  (^TableRowSorter [model]
    (new TableRowSorter model))
  (^TableRowSorter []
    (new TableRowSorter )))

(defn set-model
  "Sets the TableModel to use as the underlying model
   for this TableRowSorter.  A value of null
   can be used to set an empty model.

  model - the underlying model to use, or null - `M`"
  ([^TableRowSorter this model]
    (-> this (.setModel model))))

(defn set-string-converter
  "Sets the object responsible for converting values from the
   model to strings.  If non-null this
   is used to convert any object values, that do not have a
   registered Comparator, to strings.

  string-converter - the object responsible for converting values from the model to strings - `javax.swing.table.TableStringConverter`"
  ([^TableRowSorter this ^javax.swing.table.TableStringConverter string-converter]
    (-> this (.setStringConverter string-converter))))

(defn get-string-converter
  "Returns the object responsible for converting values from the
   model to strings.

  returns: object responsible for converting values to strings. - `javax.swing.table.TableStringConverter`"
  (^javax.swing.table.TableStringConverter [^TableRowSorter this]
    (-> this (.getStringConverter))))

(defn get-comparator
  "Returns the Comparator for the specified
   column.  If a Comparator has not been specified using
   the setComparator method a Comparator
   will be returned based on the column class
   (TableModel.getColumnClass) of the specified column.
   If the column class is String,
   Collator.getInstance is returned.  If the
   column class implements Comparable a private
   Comparator is returned that invokes the
   compareTo method.  Otherwise
   Collator.getInstance is returned.

  column - the column to fetch the Comparator for, in terms of the underlying model - `int`

  returns: the Comparator for the specified column - `java.util.Comparator<?>`

  throws: java.lang.IndexOutOfBoundsException - if column is outside the range of the underlying model"
  (^java.util.Comparator [^TableRowSorter this ^Integer column]
    (-> this (.getComparator column))))

