(ns javax.swing.event.TableColumnModelEvent
  "TableColumnModelEvent is used to notify listeners that a table
  column model has changed, such as a column was added, removed, or
  moved.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event TableColumnModelEvent]))

(defn ->table-column-model-event
  "Constructor.

  Constructs a TableColumnModelEvent object.

  source - the TableColumnModel that originated the event - `javax.swing.table.TableColumnModel`
  from - an int specifying the index from where the column was moved or removed - `int`
  to - an int specifying the index to where the column was moved or added - `int`"
  ([^javax.swing.table.TableColumnModel source ^Integer from ^Integer to]
    (new TableColumnModelEvent source from to)))

(defn get-from-index
  "Returns the fromIndex.  Valid for removed or moved events

  returns: `int`"
  (^Integer [^javax.swing.event.TableColumnModelEvent this]
    (-> this (.getFromIndex))))

(defn get-to-index
  "Returns the toIndex.  Valid for add and moved events

  returns: `int`"
  (^Integer [^javax.swing.event.TableColumnModelEvent this]
    (-> this (.getToIndex))))

