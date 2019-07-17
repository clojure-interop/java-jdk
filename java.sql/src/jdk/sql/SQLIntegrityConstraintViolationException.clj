(ns jdk.sql.SQLIntegrityConstraintViolationException
  "The subclass of SQLException thrown when the SQLState class value
  is '23', or under vendor-specified conditions.
  This indicates that an integrity
  constraint (foreign key, primary key or unique key) has been violated.

  Please consult your driver vendor documentation for the vendor-specified
  conditions for which this Exception may be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql SQLIntegrityConstraintViolationException]))

(defn ->sql-integrity-constraint-violation-exception
  "Constructor.

  Constructs a SQLIntegrityConstraintViolationException object
   with a given
   reason, SQLState, vendorCode
   and  cause.

  reason - a description of the exception - `java.lang.String`
  sql-state - an XOPEN or SQL:2003 code identifying the exception - `java.lang.String`
  vendor-code - a database vendor-specific exception code - `int`
  cause - the (which is saved for later retrieval by the getCause() method); may be null indicating the cause is non-existent or unknown. - `java.lang.Throwable`"
  ([^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code ^java.lang.Throwable cause]
    (new SQLIntegrityConstraintViolationException reason sql-state vendor-code cause))
  ([^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code]
    (new SQLIntegrityConstraintViolationException reason sql-state vendor-code))
  ([^java.lang.String reason ^java.lang.String sql-state]
    (new SQLIntegrityConstraintViolationException reason sql-state))
  ([^java.lang.String reason]
    (new SQLIntegrityConstraintViolationException reason))
  ([]
    (new SQLIntegrityConstraintViolationException )))

