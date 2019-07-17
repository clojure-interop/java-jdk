(ns javax.sql.RowSetInternal
  "The interface that a RowSet object implements in order to
  present itself to a RowSetReader or RowSetWriter
  object. The RowSetInternal interface contains
  methods that let the reader or writer access and modify the internal
  state of the rowset."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql RowSetInternal]))

(defn get-params
  "Retrieves the parameters that have been set for this
   RowSet object's command.

  returns: an array of the current parameter values for this RowSet
           object's command - `java.lang.Object[]`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this]
    (-> this (.getParams))))

(defn get-connection
  "Retrieves the Connection object that was passed to this
   RowSet object.

  returns: the Connection object passed to the rowset
        or null if none was passed - `java.sql.Connection`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this]
    (-> this (.getConnection))))

(defn set-meta-data
  "Sets the given RowSetMetaData object as the
   RowSetMetaData object for this RowSet
   object. The RowSetReader object associated with the rowset
   will use RowSetMetaData methods to set the values giving
   information about the rowset's columns.

  md - the RowSetMetaData object that will be set with information about the rowset's columns - `javax.sql.RowSetMetaData`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this md]
    (-> this (.setMetaData md))))

(defn get-original
  "Retrieves a ResultSet object containing the original
   value of this RowSet object.

   The cursor is positioned before the first row in the result set.
   Only rows contained in the result set returned by the method
   getOriginal are said to have an original value.

  returns: the original value of the rowset - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this]
    (-> this (.getOriginal))))

(defn get-original-row
  "Retrieves a ResultSet object containing the original value
   of the current row only.  If the current row has no original value,
   an empty result set is returned. If there is no current row,
   an exception is thrown.

  returns: the original value of the current row as a ResultSet
            object - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs or this method is called while the cursor is on the insert row, before the first row, or after the last row"
  ([this]
    (-> this (.getOriginalRow))))

