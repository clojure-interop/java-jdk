(ns javax.sql.XADataSource
  "A factory for XAConnection objects that is used internally.
  An object that implements the XADataSource interface is
  typically registered with a naming service that uses the
  Java Naming and Directory Interface™
  (JNDI).

  An implementation of XADataSource must include a public no-arg
  constructor."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql XADataSource]))

(defn get-xa-connection
  "Attempts to establish a physical database connection, using the given
   user name and password. The connection that is returned is one that
   can be used in a distributed transaction.

  user - the database user on whose behalf the connection is being made - `java.lang.String`
  password - the user's password - `java.lang.String`

  returns: an XAConnection object, which represents a
            physical connection to a data source, that can be used in
            a distributed transaction - `javax.sql.XAConnection`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^javax.sql.XADataSource this ^java.lang.String user ^java.lang.String password]
    (-> this (.getXAConnection user password)))
  ([^javax.sql.XADataSource this]
    (-> this (.getXAConnection))))

