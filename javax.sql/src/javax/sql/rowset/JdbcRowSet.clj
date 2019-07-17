(ns javax.sql.rowset.JdbcRowSet
  "The standard interface that all standard implementations of
  JdbcRowSet must implement.

  1.0 Overview
  A wrapper around a ResultSet object that makes it possible
  to use the result set as a JavaBeans™
  component.  Thus, a JdbcRowSet object can be one of the Beans that
  a tool makes available for composing an application.  Because
  a JdbcRowSet is a connected rowset, that is, it continually
  maintains its connection to a database using a JDBC technology-enabled
  driver, it also effectively makes the driver a JavaBeans component.

  Because it is always connected to its database, an instance of
  JdbcRowSet
  can simply take calls invoked on it and in turn call them on its
  ResultSet object. As a consequence, a result set can, for
  example, be a component in a Swing application.

  Another advantage of a JdbcRowSet object is that it can be
  used to make a ResultSet object scrollable and updatable.  All
  RowSet objects are by default scrollable and updatable. If
  the driver and database being used do not support scrolling and/or updating
  of result sets, an application can populate a JdbcRowSet object
  with the data of a ResultSet object and then operate on the
  JdbcRowSet object as if it were the ResultSet
  object.

  2.0 Creating a JdbcRowSet Object
  The reference implementation of the JdbcRowSet interface,
  JdbcRowSetImpl, provides an implementation of
  the default constructor.  A new instance is initialized with
  default values, which can be set with new values as needed. A
  new instance is not really functional until its execute
  method is called. In general, this method does the following:

     establishes a connection with a database
     creates a PreparedStatement object and sets any of its
         placeholder parameters
     executes the statement to create a ResultSet object

  If the execute method is successful, it will set the
  appropriate private JdbcRowSet fields with the following:

    a Connection object -- the connection between the rowset
        and the database
    a PreparedStatement object -- the query that produces
        the result set
    a ResultSet object -- the result set that the rowset's
        command produced and that is being made, in effect, a JavaBeans
        component

  If these fields have not been set, meaning that the execute
  method has not executed successfully, no methods other than
  execute and close may be called on the
  rowset.  All other public methods will throw an exception.

  Before calling the execute method, however, the command
  and properties needed for establishing a connection must be set.
  The following code fragment creates a JdbcRowSetImpl object,
  sets the command and connection properties, sets the placeholder parameter,
  and then invokes the method execute.


      JdbcRowSetImpl jrs = new JdbcRowSetImpl();
      jrs.setCommand(`SELECT * FROM TITLES WHERE TYPE = ?`);
      jrs.setURL(`jdbc:myDriver:myAttribute`);
      jrs.setUsername(`cervantes`);
      jrs.setPassword(`sancho`);
      jrs.setString(1, `BIOGRAPHY`);
      jrs.execute();
  The variable jrs now represents an instance of
  JdbcRowSetImpl that is a thin wrapper around the
  ResultSet object containing all the rows in the
  table TITLES where the type of book is biography.
  At this point, operations called on jrs will
  affect the rows in the result set, which is effectively a JavaBeans
  component.

  The implementation of the RowSet method execute in the
  JdbcRowSet reference implementation differs from that in the
  CachedRowSet™
  reference implementation to account for the different
  requirements of connected and disconnected RowSet objects."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset JdbcRowSet]))

(defn get-show-deleted?
  "Retrieves a boolean indicating whether rows marked
   for deletion appear in the set of current rows. If true is
   returned, deleted rows are visible with the current rows. If
   false is returned, rows are not visible with the set of
   current rows. The default value is false.

   Standard rowset implementations may choose to restrict this behavior
   for security considerations or for certain deployment
   scenarios. The visibility of deleted rows is implementation-defined
   and does not represent standard behavior.

   Note: Allowing deleted rows to remain visible complicates the behavior
   of some standard JDBC RowSet implementations methods.
   However, most rowset users can simply ignore this extra detail because
   only very specialized applications will likely want to take advantage of
   this feature.

  returns: true if deleted rows are visible;
           false otherwise - `boolean`

  throws: java.sql.SQLException - if a rowset implementation is unable to to determine whether rows marked for deletion remain visible"
  ([this]
    (-> this (.getShowDeleted))))

(defn set-show-deleted
  "Sets the property showDeleted to the given
   boolean value. This property determines whether
   rows marked for deletion continue to appear in the set of current rows.
   If the value is set to true, deleted rows are immediately
   visible with the set of current rows. If the value is set to
   false, the deleted rows are set as invisible with the
   current set of rows.

   Standard rowset implementations may choose to restrict this behavior
   for security considerations or for certain deployment
   scenarios. This is left as implementation-defined and does not
   represent standard behavior.

  b - true if deleted rows should be shown; false otherwise - `boolean`

  throws: java.sql.SQLException - if a rowset implementation is unable to to reset whether deleted rows should be visible"
  ([this b]
    (-> this (.setShowDeleted b))))

(defn get-row-set-warnings
  "Retrieves the first warning reported by calls on this JdbcRowSet
   object.
   If a second warning was reported on this JdbcRowSet object,
   it will be chained to the first warning and can be retrieved by
   calling the method RowSetWarning.getNextWarning on the
   first warning. Subsequent warnings on this JdbcRowSet
   object will be chained to the RowSetWarning objects
   returned by the method RowSetWarning.getNextWarning.

   The warning chain is automatically cleared each time a new row is read.
   This method may not be called on a RowSet object
   that has been closed;
   doing so will cause an SQLException to be thrown.

   Because it is always connected to its data source, a JdbcRowSet
   object can rely on the presence of active
   Statement, Connection, and ResultSet
   instances. This means that  applications can obtain additional
   SQLWarning
   notifications by calling the getNextWarning methods that
   they provide.
   Disconnected Rowset objects, such as a
   CachedRowSet object, do not have access to
   these getNextWarning methods.

  returns: the first RowSetWarning
   object reported on this JdbcRowSet object
   or null if there are none - `javax.sql.rowset.RowSetWarning`

  throws: java.sql.SQLException - if this method is called on a closed JdbcRowSet object"
  ([this]
    (-> this (.getRowSetWarnings))))

(defn commit
  "Each JdbcRowSet contains a Connection object from
   the ResultSet or JDBC properties passed to it's constructors.
   This method wraps the Connection commit method to allow flexible
   auto commit or non auto commit transactional control support.

   Makes all changes made since the previous commit/rollback permanent
   and releases any database locks currently held by this Connection
   object. This method should be used only when auto-commit mode has
   been disabled.

  throws: java.sql.SQLException - if a database access error occurs or this Connection object within this JdbcRowSet is in auto-commit mode"
  ([this]
    (-> this (.commit))))

(defn get-auto-commit?
  "Each JdbcRowSet contains a Connection object from
   the original ResultSet or JDBC properties passed to it. This
   method wraps the Connection's getAutoCommit method
   to allow an application to determine the JdbcRowSet transaction
   behavior.

   Sets this connection's auto-commit mode to the given state. If a
   connection is in auto-commit mode, then all its SQL statements will
   be executed and committed as individual transactions. Otherwise, its
   SQL statements are grouped into transactions that are terminated by a
   call to either the method commit or the method rollback. By default,
   new connections are in auto-commit mode.

  returns: true if auto-commit is enabled; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this]
    (-> this (.getAutoCommit))))

(defn set-auto-commit
  "Each JdbcRowSet contains a Connection object from
   the original ResultSet or JDBC properties passed to it. This
   method wraps the Connection's getAutoCommit method
   to allow an application to set the JdbcRowSet transaction behavior.

   Sets the current auto-commit mode for this Connection object.

  auto-commit - true to enable auto-commit; false to disable auto-commit - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this auto-commit]
    (-> this (.setAutoCommit auto-commit))))

(defn rollback
  "Each JdbcRowSet contains a Connection object from
   the original ResultSet or JDBC properties passed to it.
   Undoes all changes made in the current transaction to the last set savepoint
   and releases any database locks currently held by this Connection
   object. This method should be used only when auto-commit mode has been disabled.

  s - The Savepoint to rollback to - `java.sql.Savepoint`

  throws: java.sql.SQLException - if a database access error occurs or this Connection object within this JdbcRowSet is in auto-commit mode."
  ([this s]
    (-> this (.rollback s)))
  ([this]
    (-> this (.rollback))))

