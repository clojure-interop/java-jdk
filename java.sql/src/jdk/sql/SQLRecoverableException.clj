(ns jdk.sql.SQLRecoverableException
  "The subclass of SQLException thrown in situations where a
  previously failed operation might be able to succeed if the application performs
   some recovery steps and retries the entire transaction or in the case of a
  distributed transaction, the transaction branch.  At a minimum,
  the recovery operation must include closing the current connection and getting
  a new connection."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql SQLRecoverableException]))

(defn ->sql-recoverable-exception
  "Constructor.

  Constructs a SQLRecoverableException object
   with a given
   reason, SQLState, vendorCode
   and  cause.

  reason - a description of the exception - `java.lang.String`
  sql-state - an XOPEN or SQL:2003 code identifying the exception - `java.lang.String`
  vendor-code - a database vendor-specific exception code - `int`
  cause - the underlying reason for this SQLException (which is saved for later retrieval by the getCause() method); may be null indicating the cause is non-existent or unknown. - `java.lang.Throwable`"
  (^SQLRecoverableException [^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code ^java.lang.Throwable cause]
    (new SQLRecoverableException reason sql-state vendor-code cause))
  (^SQLRecoverableException [^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code]
    (new SQLRecoverableException reason sql-state vendor-code))
  (^SQLRecoverableException [^java.lang.String reason ^java.lang.String sql-state]
    (new SQLRecoverableException reason sql-state))
  (^SQLRecoverableException [^java.lang.String reason]
    (new SQLRecoverableException reason))
  (^SQLRecoverableException []
    (new SQLRecoverableException )))

