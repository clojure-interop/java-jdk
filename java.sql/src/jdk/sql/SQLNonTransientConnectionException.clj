(ns jdk.sql.SQLNonTransientConnectionException
  "The subclass of SQLException thrown for the SQLState
  class value '08', or under vendor-specified conditions.  This
  indicates that the connection operation that failed will not succeed if
  the operation is retried without the cause of the failure being corrected.

  Please consult your driver vendor documentation for the vendor-specified
  conditions for which this Exception may be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql SQLNonTransientConnectionException]))

(defn ->sql-non-transient-connection-exception
  "Constructor.

  Constructs a SQLNonTransientConnectionException object
   with a given
   reason, SQLState, vendorCode
   and  cause.

  reason - a description of the exception - `java.lang.String`
  sql-state - an XOPEN or SQL:2003 code identifying the exception - `java.lang.String`
  vendor-code - a database vendor-specific exception code - `int`
  cause - the underlying reason for this SQLException (which is saved for later retrieval by the getCause() method); may be null indicating the cause is non-existent or unknown. - `java.lang.Throwable`"
  (^SQLNonTransientConnectionException [^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code ^java.lang.Throwable cause]
    (new SQLNonTransientConnectionException reason sql-state vendor-code cause))
  (^SQLNonTransientConnectionException [^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code]
    (new SQLNonTransientConnectionException reason sql-state vendor-code))
  (^SQLNonTransientConnectionException [^java.lang.String reason ^java.lang.String sql-state]
    (new SQLNonTransientConnectionException reason sql-state))
  (^SQLNonTransientConnectionException [^java.lang.String reason]
    (new SQLNonTransientConnectionException reason))
  (^SQLNonTransientConnectionException []
    (new SQLNonTransientConnectionException )))

