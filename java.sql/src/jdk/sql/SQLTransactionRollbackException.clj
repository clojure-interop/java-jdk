(ns jdk.sql.SQLTransactionRollbackException
  "The subclass of SQLException thrown when the SQLState class value
  is '40', or under vendor-specified conditions. This indicates that the
  current statement was automatically rolled back by the database because
  of deadlock or other transaction serialization failures.

  Please consult your driver vendor documentation for the vendor-specified
  conditions for which this Exception may be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql SQLTransactionRollbackException]))

(defn ->sql-transaction-rollback-exception
  "Constructor.

  Constructs a SQLTransactionRollbackException object
   with a given
   reason, SQLState, vendorCode
   and  cause.

  reason - a description of the exception - `java.lang.String`
  sql-state - an XOPEN or SQL:2003 code identifying the exception - `java.lang.String`
  vendor-code - a database vendor-specific exception code - `int`
  cause - the underlying reason for this SQLException (which is saved for later retrieval by the getCause() method); may be null indicating the cause is non-existent or unknown. - `java.lang.Throwable`"
  (^SQLTransactionRollbackException [^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code ^java.lang.Throwable cause]
    (new SQLTransactionRollbackException reason sql-state vendor-code cause))
  (^SQLTransactionRollbackException [^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code]
    (new SQLTransactionRollbackException reason sql-state vendor-code))
  (^SQLTransactionRollbackException [^java.lang.String reason ^java.lang.String sql-state]
    (new SQLTransactionRollbackException reason sql-state))
  (^SQLTransactionRollbackException [^java.lang.String reason]
    (new SQLTransactionRollbackException reason))
  (^SQLTransactionRollbackException []
    (new SQLTransactionRollbackException )))

