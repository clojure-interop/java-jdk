(ns jdk.sql.SQLNonTransientException
  "The subclass of SQLException thrown when an instance where a retry
  of the same operation would fail unless the cause of the SQLException
  is corrected."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql SQLNonTransientException]))

(defn ->sql-non-transient-exception
  "Constructor.

  Constructs a SQLNonTransientException object
   with a given
   reason, SQLState, vendorCode
   and  cause.

  reason - a description of the exception - `java.lang.String`
  sql-state - an XOPEN or SQL:2003 code identifying the exception - `java.lang.String`
  vendor-code - a database vendor-specific exception code - `int`
  cause - the underlying reason for this SQLException (which is saved for later retrieval by the getCause() method); may be null indicating the cause is non-existent or unknown. - `java.lang.Throwable`"
  (^SQLNonTransientException [^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code ^java.lang.Throwable cause]
    (new SQLNonTransientException reason sql-state vendor-code cause))
  (^SQLNonTransientException [^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code]
    (new SQLNonTransientException reason sql-state vendor-code))
  (^SQLNonTransientException [^java.lang.String reason ^java.lang.String sql-state]
    (new SQLNonTransientException reason sql-state))
  (^SQLNonTransientException [^java.lang.String reason]
    (new SQLNonTransientException reason))
  (^SQLNonTransientException []
    (new SQLNonTransientException )))

