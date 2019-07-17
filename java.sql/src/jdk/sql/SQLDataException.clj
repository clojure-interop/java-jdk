(ns jdk.sql.SQLDataException
  "The subclass of SQLException thrown when the SQLState class value
  is '22', or under vendor-specified conditions.  This indicates
  various data errors, including but not limited to data conversion errors,
  division by 0, and invalid arguments to functions.

  Please consult your driver vendor documentation for the vendor-specified
  conditions for which this Exception may be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql SQLDataException]))

(defn ->sql-data-exception
  "Constructor.

  Constructs a SQLDataException object with a given
   reason, SQLState, vendorCode
   and  cause.

  reason - a description of the exception - `java.lang.String`
  sql-state - an XOPEN or SQL:2003 code identifying the exception - `java.lang.String`
  vendor-code - a database vendor-specific exception code - `int`
  cause - the underlying reason for this SQLException (which is saved for later retrieval by the getCause() method); may be null indicating the cause is non-existent or unknown. - `java.lang.Throwable`"
  ([^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code ^java.lang.Throwable cause]
    (new SQLDataException reason sql-state vendor-code cause))
  ([^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code]
    (new SQLDataException reason sql-state vendor-code))
  ([^java.lang.String reason ^java.lang.String sql-state]
    (new SQLDataException reason sql-state))
  ([^java.lang.String reason]
    (new SQLDataException reason))
  ([]
    (new SQLDataException )))

