(ns javax.sql.rowset.RowSetWarning
  "An extension of SQLException that provides information
  about database warnings set on RowSet objects.
  Warnings are silently chained to the object whose method call
  caused it to be reported.
  This class complements the SQLWarning class.

  Rowset warnings may be retrieved from JdbcRowSet,
  CachedRowSet™,
  WebRowSet, FilteredRowSet, or JoinRowSet
  implementations. To retrieve the first warning reported on any
  RowSet
  implementation,  use the method getRowSetWarnings defined
  in the JdbcRowSet interface or the CachedRowSet
  interface. To retrieve a warning chained to the first warning, use the
  RowSetWarning method
  getNextWarning. To retrieve subsequent warnings, call
  getNextWarning on each RowSetWarning object that is
  returned.

  The inherited methods getMessage, getSQLState,
  and getErrorCode retrieve information contained in a
  RowSetWarning object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset RowSetWarning]))

(defn ->row-set-warning
  "Constructor.

  Constructs a fully specified RowSetWarning object initialized
   with the given values for the reason, SQLState and vendorCode.

   If the reason, or the  SQLState
   parameters are null, this constructor behaves like the default
   (zero parameter) RowSetWarning constructor.

  reason - a String giving a description of the warning; - `java.lang.String`
  sql-state - an XOPEN code identifying the warning; if a non standard XOPEN SQLState is supplied, no exception is thrown. - `java.lang.String`
  vendor-code - a database vendor-specific warning code - `int`"
  ([^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code]
    (new RowSetWarning reason sql-state vendor-code))
  ([^java.lang.String reason ^java.lang.String sql-state]
    (new RowSetWarning reason sql-state))
  ([^java.lang.String reason]
    (new RowSetWarning reason))
  ([]
    (new RowSetWarning )))

(defn get-next-warning
  "Retrieves the warning chained to this RowSetWarning
   object.

  returns: the RowSetWarning object chained to this one; if no
           RowSetWarning object is chained to this one,
           null is returned (default value) - `javax.sql.rowset.RowSetWarning`"
  (^javax.sql.rowset.RowSetWarning [^javax.sql.rowset.RowSetWarning this]
    (-> this (.getNextWarning))))

(defn set-next-warning
  "Sets warning as the next warning, that is, the warning chained
   to this RowSetWarning object.

  warning - the RowSetWarning object to be set as the next warning; if the RowSetWarning is null, this represents the finish point in the warning chain - `javax.sql.rowset.RowSetWarning`"
  ([^javax.sql.rowset.RowSetWarning this ^javax.sql.rowset.RowSetWarning warning]
    (-> this (.setNextWarning warning))))

