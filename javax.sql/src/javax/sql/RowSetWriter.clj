(ns javax.sql.RowSetWriter
  "An object that implements the RowSetWriter interface,
  called a writer. A writer may be registered with a RowSet
  object that supports the reader/writer paradigm.

  If a disconnected RowSet object modifies some of its data,
  and it has a writer associated with it, it may be implemented so that it
  calls on the writer's writeData method internally
  to write the updates back to the data source. In order to do this, the writer
  must first establish a connection with the rowset's data source.

  If the data to be updated has already been changed in the data source, there
  is a conflict, in which case the writer will not write
  the changes to the data source.  The algorithm the writer uses for preventing
  or limiting conflicts depends entirely on its implementation."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql RowSetWriter]))

(defn write-data
  "Writes the changes in this RowSetWriter object's
   rowset back to the data source from which it got its data.

  caller - the RowSet object (1) that has implemented the RowSetInternal interface, (2) with which this writer is registered, and (3) that called this method internally - `javax.sql.RowSetInternal`

  returns: true if the modified data was written; false
            if not, which will be the case if there is a conflict - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^javax.sql.RowSetWriter this ^javax.sql.RowSetInternal caller]
    (-> this (.writeData caller))))

