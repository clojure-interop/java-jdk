(ns jdk.sql.SQLTransientConnectionException
  "The subclass of SQLException for the SQLState class
  value '08', or under vendor-specified conditions.  This indicates
  that the connection operation that failed might be able to succeed if
  the operation is retried without any application-level changes.

  Please consult your driver vendor documentation for the vendor-specified
  conditions for which this Exception may be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql SQLTransientConnectionException]))

(defn ->sql-transient-connection-exception
  "Constructor.

  Constructs a SQLTransientConnectionException object
   with a given
   reason, SQLState, vendorCode
   and  cause.

  reason - a description of the exception - `java.lang.String`
  sql-state - an XOPEN or SQL:2003 code identifying the exception - `java.lang.String`
  vendor-code - a database vendor-specific exception code - `int`
  cause - the underlying reason for this SQLException (which is saved for later retrieval by the getCause() method); may be null indicating the cause is non-existent or unknown. - `java.lang.Throwable`"
  (^SQLTransientConnectionException [^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code ^java.lang.Throwable cause]
    (new SQLTransientConnectionException reason sql-state vendor-code cause))
  (^SQLTransientConnectionException [^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code]
    (new SQLTransientConnectionException reason sql-state vendor-code))
  (^SQLTransientConnectionException [^java.lang.String reason ^java.lang.String sql-state]
    (new SQLTransientConnectionException reason sql-state))
  (^SQLTransientConnectionException [^java.lang.String reason]
    (new SQLTransientConnectionException reason))
  (^SQLTransientConnectionException []
    (new SQLTransientConnectionException )))

