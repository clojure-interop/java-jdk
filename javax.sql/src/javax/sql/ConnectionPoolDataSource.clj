(ns javax.sql.ConnectionPoolDataSource
  "A factory for PooledConnection
  objects.  An object that implements this interface will typically be
  registered with a naming service that is based on the
  Java™ Naming and Directory Interface
  (JNDI)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql ConnectionPoolDataSource]))

(defn get-pooled-connection
  "Attempts to establish a physical database connection that can
   be used as a pooled connection.

  user - the database user on whose behalf the connection is being made - `java.lang.String`
  password - the user's password - `java.lang.String`

  returns: a PooledConnection object that is a physical
           connection to the database that this
           ConnectionPoolDataSource object represents - `javax.sql.PooledConnection`

  throws: java.sql.SQLException - if a database access error occurs"
  (^javax.sql.PooledConnection [^javax.sql.ConnectionPoolDataSource this ^java.lang.String user ^java.lang.String password]
    (-> this (.getPooledConnection user password)))
  (^javax.sql.PooledConnection [^javax.sql.ConnectionPoolDataSource this]
    (-> this (.getPooledConnection))))

