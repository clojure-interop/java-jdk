(ns javax.sql.RowSetReader
  "The facility that a disconnected RowSet object calls on
  to populate itself with rows of data. A reader (an object implementing the
  RowSetReader interface) may be registered with
  a RowSet object that supports the reader/writer paradigm.
  When the RowSet object's execute method is
  called, it in turn calls the reader's readData method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql RowSetReader]))

(defn read-data
  "Reads the new contents of the calling RowSet object.
   In order to call this method, a RowSet
   object must have implemented the RowSetInternal interface
   and registered this RowSetReader object as its reader.
   The readData  method is invoked internally
   by the RowSet.execute method for rowsets that support the
   reader/writer paradigm.

   The readData method adds rows to the caller.
   It can be implemented in a wide variety of ways and can even
   populate the caller with rows from a nonrelational data source.
   In general, a reader may invoke any of the rowset's methods,
   with one exception. Calling the method execute will
   cause an SQLException to be thrown
   because execute may not be called recursively.  Also,
   when a reader invokes RowSet methods, no listeners
   are notified; that is, no RowSetEvent objects are
   generated and no RowSetListener methods are invoked.
   This is true because listeners are already being notified by the method
   execute.

  caller - the RowSet object (1) that has implemented the RowSetInternal interface, (2) with which this reader is registered, and (3) whose execute method called this reader - `javax.sql.RowSetInternal`

  throws: java.sql.SQLException - if a database access error occurs or this method invokes the RowSet.execute method"
  ([^. this ^javax.sql.RowSetInternal caller]
    (-> this (.readData caller))))

