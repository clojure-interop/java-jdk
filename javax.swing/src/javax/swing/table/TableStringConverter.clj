(ns javax.swing.table.TableStringConverter
  "TableStringConverter is used to convert objects from the model into
  strings.  This is useful in filtering and searching when the model returns
  objects that do not have meaningful toString implementations."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.table TableStringConverter]))

(defn ->table-string-converter
  "Constructor."
  ([]
    (new TableStringConverter )))

(defn to-string
  "Returns the string representation of the value at the specified
   location.

  model - the TableModel to fetch the value from - `javax.swing.table.TableModel`
  row - the row the string is being requested for - `int`
  column - the column the string is being requested for - `int`

  returns: the string representation.  This should never return null. - `java.lang.String`

  throws: java.lang.NullPointerException - if model is null"
  ([^javax.swing.table.TableStringConverter this ^javax.swing.table.TableModel model ^Integer row ^Integer column]
    (-> this (.toString model row column))))

