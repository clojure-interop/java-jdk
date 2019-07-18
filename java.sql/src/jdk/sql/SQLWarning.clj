(ns jdk.sql.SQLWarning
  "An exception that provides information on  database access
  warnings. Warnings are silently chained to the object whose method
  caused it to be reported.

  Warnings may be retrieved from Connection, Statement,
  and ResultSet objects.  Trying to retrieve a warning on a
  connection after it has been closed will cause an exception to be thrown.
  Similarly, trying to retrieve a warning on a statement after it has been
  closed or on a result set after it has been closed will cause
  an exception to be thrown. Note that closing a statement also
  closes a result set that it might have produced."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql SQLWarning]))

(defn ->sql-warning
  "Constructor.

  Constructs aSQLWarning object
   with a given
   reason, SQLState, vendorCode
   and  cause.

  reason - a description of the warning - `java.lang.String`
  sql-state - an XOPEN or SQL:2003 code identifying the warning - `java.lang.String`
  vendor-code - a database vendor-specific warning code - `int`
  cause - the underlying reason for this SQLWarning (which is saved for later retrieval by the getCause() method); may be null indicating the cause is non-existent or unknown. - `java.lang.Throwable`"
  (^SQLWarning [^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code ^java.lang.Throwable cause]
    (new SQLWarning reason sql-state vendor-code cause))
  (^SQLWarning [^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code]
    (new SQLWarning reason sql-state vendor-code))
  (^SQLWarning [^java.lang.String reason ^java.lang.String sql-state]
    (new SQLWarning reason sql-state))
  (^SQLWarning [^java.lang.String reason]
    (new SQLWarning reason))
  (^SQLWarning []
    (new SQLWarning )))

(defn get-next-warning
  "Retrieves the warning chained to this SQLWarning object by
   setNextWarning.

  returns: the next SQLException in the chain; null if none - `java.sql.SQLWarning`"
  (^java.sql.SQLWarning [^SQLWarning this]
    (-> this (.getNextWarning))))

(defn set-next-warning
  "Adds a SQLWarning object to the end of the chain.

  w - the new end of the SQLException chain - `java.sql.SQLWarning`"
  ([^SQLWarning this ^java.sql.SQLWarning w]
    (-> this (.setNextWarning w))))

