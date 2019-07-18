(ns jdk.sql.SQLFeatureNotSupportedException
  "The subclass of SQLException thrown when the SQLState class value is '0A'
  ( the value is 'zero' A).
  This indicates that the JDBC driver does not support an optional JDBC feature.
  Optional JDBC features can fall into the fallowing categories:


 no support for an optional feature
 no support for an optional overloaded method
 no support for an optional mode for a method.  The mode for a method is
 determined based on constants passed as parameter values to a method"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql SQLFeatureNotSupportedException]))

(defn ->sql-feature-not-supported-exception
  "Constructor.

  Constructs a SQLFeatureNotSupportedException object
   with a given
   reason, SQLState, vendorCode
   and  cause.

  reason - a description of the exception - `java.lang.String`
  sql-state - an XOPEN or SQL:2003 code identifying the exception - `java.lang.String`
  vendor-code - a database vendor-specific exception code - `int`
  cause - the underlying reason for this SQLException (which is saved for later retrieval by the getCause() method); may be null indicating the cause is non-existent or unknown. - `java.lang.Throwable`"
  (^SQLFeatureNotSupportedException [^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code ^java.lang.Throwable cause]
    (new SQLFeatureNotSupportedException reason sql-state vendor-code cause))
  (^SQLFeatureNotSupportedException [^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code]
    (new SQLFeatureNotSupportedException reason sql-state vendor-code))
  (^SQLFeatureNotSupportedException [^java.lang.String reason ^java.lang.String sql-state]
    (new SQLFeatureNotSupportedException reason sql-state))
  (^SQLFeatureNotSupportedException [^java.lang.String reason]
    (new SQLFeatureNotSupportedException reason))
  (^SQLFeatureNotSupportedException []
    (new SQLFeatureNotSupportedException )))

