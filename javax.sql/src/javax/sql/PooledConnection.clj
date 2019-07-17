(ns javax.sql.PooledConnection
  "An object that provides hooks for connection pool management.
  A PooledConnection object
  represents a physical connection to a data source.  The connection
  can be recycled rather than being closed when an application is
  finished with it, thus reducing the number of connections that
  need to be made.

  An application programmer does not use the PooledConnection
  interface directly; rather, it is used by a middle tier infrastructure
  that manages the pooling of connections.

  When an application calls the method DataSource.getConnection,
  it gets back a Connection object.  If connection pooling is
  being done, that Connection object is actually a handle to
  a PooledConnection object, which is a physical connection.

  The connection pool manager, typically the application server, maintains
  a pool of PooledConnection objects.  If there is a
  PooledConnection object available in the pool, the
  connection pool manager returns a Connection object that
  is a handle to that physical connection.
  If no PooledConnection object is available, the
  connection pool manager calls the ConnectionPoolDataSource
  method getPoolConnection to create a new physical connection.  The
   JDBC driver implementing ConnectionPoolDataSource creates a
   new PooledConnection object and returns a handle to it.

  When an application closes a connection, it calls the Connection
  method close. When connection pooling is being done,
  the connection pool manager is notified because it has registered itself as
  a ConnectionEventListener object using the
  ConnectionPool method addConnectionEventListener.
  The connection pool manager deactivates the handle to
  the PooledConnection object and  returns the
  PooledConnection object to the pool of connections so that
  it can be used again.  Thus, when an application closes its connection,
  the underlying physical connection is recycled rather than being closed.

  The physical connection is not closed until the connection pool manager
  calls the PooledConnection method close.
  This method is generally called to have an orderly shutdown of the server or
  if a fatal error has made the connection unusable.


  A connection pool manager is often also a statement pool manager, maintaining
   a pool of PreparedStatement objects.
   When an application closes a prepared statement, it calls the
   PreparedStatement
  method close. When Statement pooling is being done,
  the pool manager is notified because it has registered itself as
  a StatementEventListener object using the
  ConnectionPool method addStatementEventListener.
   Thus, when an application closes its  PreparedStatement,
  the underlying prepared statement is recycled rather than being closed."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql PooledConnection]))

(defn get-connection
  "Creates and returns a Connection object that is a handle
   for the physical connection that
   this PooledConnection object represents.
   The connection pool manager calls this method when an application has
   called the method DataSource.getConnection and there are
   no PooledConnection objects available. See the
   interface description for more information.

  returns: a Connection object that is a handle to
            this PooledConnection object - `java.sql.Connection`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^javax.sql.PooledConnection this]
    (-> this (.getConnection))))

(defn close
  "Closes the physical connection that this PooledConnection
   object represents.  An application never calls this method directly;
   it is called by the connection pool module, or manager.

   See the interface description for more
   information.

  throws: java.sql.SQLException - if a database access error occurs"
  ([^javax.sql.PooledConnection this]
    (-> this (.close))))

(defn add-connection-event-listener
  "Registers the given event listener so that it will be notified
   when an event occurs on this PooledConnection object.

  listener - a component, usually the connection pool manager, that has implemented the ConnectionEventListener interface and wants to be notified when the connection is closed or has an error - `javax.sql.ConnectionEventListener`"
  ([^javax.sql.PooledConnection this ^javax.sql.ConnectionEventListener listener]
    (-> this (.addConnectionEventListener listener))))

(defn remove-connection-event-listener
  "Removes the given event listener from the list of components that
   will be notified when an event occurs on this
   PooledConnection object.

  listener - a component, usually the connection pool manager, that has implemented the ConnectionEventListener interface and been registered with this PooledConnection object as a listener - `javax.sql.ConnectionEventListener`"
  ([^javax.sql.PooledConnection this ^javax.sql.ConnectionEventListener listener]
    (-> this (.removeConnectionEventListener listener))))

(defn add-statement-event-listener
  "Registers a StatementEventListener with this PooledConnection object.  Components that
   wish to be notified when  PreparedStatements created by the
   connection are closed or are detected to be invalid may use this method
   to register a StatementEventListener with this PooledConnection object.

  listener - an component which implements the StatementEventListener interface that is to be registered with this PooledConnection object - `javax.sql.StatementEventListener`"
  ([^javax.sql.PooledConnection this ^javax.sql.StatementEventListener listener]
    (-> this (.addStatementEventListener listener))))

(defn remove-statement-event-listener
  "Removes the specified StatementEventListener from the list of
   components that will be notified when the driver detects that a
   PreparedStatement has been closed or is invalid.

  listener - the component which implements the StatementEventListener interface that was previously registered with this PooledConnection object - `javax.sql.StatementEventListener`"
  ([^javax.sql.PooledConnection this ^javax.sql.StatementEventListener listener]
    (-> this (.removeStatementEventListener listener))))

