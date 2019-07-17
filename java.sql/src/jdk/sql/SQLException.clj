(ns jdk.sql.SQLException
  "An exception that provides information on a database access
  error or other errors.

  Each SQLException provides several kinds of information:

     a string describing the error.  This is used as the Java Exception
        message, available via the method getMesasge.
     a `SQLstate` string, which follows either the XOPEN SQLstate conventions
         or the SQL:2003 conventions.
        The values of the SQLState string are described in the appropriate spec.
        The DatabaseMetaData method getSQLStateType
        can be used to discover whether the driver returns the XOPEN type or
        the SQL:2003 type.
     an integer error code that is specific to each vendor.  Normally this will
        be the actual error code returned by the underlying database.
     a chain to a next Exception.  This can be used to provide additional
        error information.
     the causal relationship, if any for this SQLException."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql SQLException]))

(defn ->sql-exception
  "Constructor.

  Constructs a SQLException object with a given
   reason, SQLState, vendorCode
   and  cause.

  reason - a description of the exception - `java.lang.String`
  sql-state - an XOPEN or SQL:2003 code identifying the exception - `java.lang.String`
  vendor-code - a database vendor-specific exception code - `int`
  cause - the underlying reason for this SQLException (which is saved for later retrieval by the getCause() method); may be null indicating the cause is non-existent or unknown. - `java.lang.Throwable`"
  ([^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code ^java.lang.Throwable cause]
    (new SQLException reason sql-state vendor-code cause))
  ([^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code]
    (new SQLException reason sql-state vendor-code))
  ([^java.lang.String reason ^java.lang.String sql-state]
    (new SQLException reason sql-state))
  ([^java.lang.String reason]
    (new SQLException reason))
  ([]
    (new SQLException )))

(defn get-sql-state
  "Retrieves the SQLState for this SQLException object.

  returns: the SQLState value - `java.lang.String`"
  (^java.lang.String [^java.sql.SQLException this]
    (-> this (.getSQLState))))

(defn get-error-code
  "Retrieves the vendor-specific exception code
   for this SQLException object.

  returns: the vendor's error code - `int`"
  (^Integer [^java.sql.SQLException this]
    (-> this (.getErrorCode))))

(defn get-next-exception
  "Retrieves the exception chained to this
   SQLException object by setNextException(SQLException ex).

  returns: the next SQLException object in the chain;
           null if there are none - `java.sql.SQLException`"
  (^java.sql.SQLException [^java.sql.SQLException this]
    (-> this (.getNextException))))

(defn set-next-exception
  "Adds an SQLException object to the end of the chain.

  ex - the new exception that will be added to the end of the SQLException chain - `java.sql.SQLException`"
  ([^java.sql.SQLException this ^java.sql.SQLException ex]
    (-> this (.setNextException ex))))

(defn iterator
  "Returns an iterator over the chained SQLExceptions.  The iterator will
   be used to iterate over each SQLException and its underlying cause
   (if any).

  returns: an iterator over the chained SQLExceptions and causes in the proper
   order - `java.util.Iterator<java.lang.Throwable>`"
  (^java.util.Iterator [^java.sql.SQLException this]
    (-> this (.iterator))))

