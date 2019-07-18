(ns jdk.sql.Connection
  "A connection (session) with a specific
  database. SQL statements are executed and results are returned
  within the context of a connection.

  A Connection object's database is able to provide information
  describing its tables, its supported SQL grammar, its stored
  procedures, the capabilities of this connection, and so on. This
  information is obtained with the getMetaData method.

  Note: When configuring a Connection, JDBC applications
   should use the appropriate Connection method such as
   setAutoCommit or setTransactionIsolation.
   Applications should not invoke SQL commands directly to change the connection's
    configuration when there is a JDBC method available.  By default a Connection object is in
  auto-commit mode, which means that it automatically commits changes
  after executing each statement. If auto-commit mode has been
  disabled, the method commit must be called explicitly in
  order to commit changes; otherwise, database changes will not be saved.

  A new Connection object created using the JDBC 2.1 core API
  has an initially empty type map associated with it. A user may enter a
  custom mapping for a UDT in this type map.
  When a UDT is retrieved from a data source with the
  method ResultSet.getObject, the getObject method
  will check the connection's type map to see if there is an entry for that
  UDT.  If so, the getObject method will map the UDT to the
  class indicated.  If there is no entry, the UDT will be mapped using the
  standard mapping.

  A user may create a new type map, which is a java.util.Map
  object, make an entry in it, and pass it to the java.sql
  methods that can perform custom mapping.  In this case, the method
  will use the given type map instead of the one associated with
  the connection.

  For example, the following code fragment specifies that the SQL
  type ATHLETES will be mapped to the class
  Athletes in the Java programming language.
  The code fragment retrieves the type map for the Connection
   object con, inserts the entry into it, and then sets
  the type map with the new entry as the connection's type map.


       java.util.Map map = con.getTypeMap();
       map.put(`mySchemaName.ATHLETES`, Class.forName(`Athletes`));
       con.setTypeMap(map);"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql Connection]))

(defn create-clob
  "Constructs an object that implements the Clob interface. The object
   returned initially contains no data.  The setAsciiStream,
   setCharacterStream and setString methods of
   the Clob interface may be used to add data to the Clob.

  returns: An object that implements the Clob interface - `java.sql.Clob`

  throws: java.sql.SQLException - if an object that implements the Clob interface can not be constructed, this method is called on a closed connection or a database access error occurs."
  (^java.sql.Clob [^Connection this]
    (-> this (.createClob))))

(defn get-auto-commit?
  "Retrieves the current auto-commit mode for this Connection
   object.

  returns: the current state of this Connection object's
           auto-commit mode - `boolean`

  throws: java.sql.SQLException - if a database access error occurs or this method is called on a closed connection"
  (^Boolean [^Connection this]
    (-> this (.getAutoCommit))))

(defn set-type-map
  "Installs the given TypeMap object as the type map for
   this Connection object.  The type map will be used for the
   custom mapping of SQL structured types and distinct types.

   You must set the the values for the TypeMap prior to
   callng setMap as a JDBC driver may create an internal copy
   of the TypeMap:



        Map myMap<String,Class<?>> = new HashMap<String,Class<?>>();
        myMap.put(`mySchemaName.ATHLETES`, Athletes.class);
        con.setTypeMap(myMap);

  map - the java.util.Map object to install as the replacement for this Connection object's default type map - `java.util.Map`

  throws: java.sql.SQLException - if a database access error occurs, this method is called on a closed connection or the given parameter is not a java.util.Map object"
  ([^Connection this ^java.util.Map map]
    (-> this (.setTypeMap map))))

(defn set-read-only
  "Puts this connection in read-only mode as a hint to the driver to enable
   database optimizations.

   Note: This method cannot be called during a transaction.

  read-only - true enables read-only mode; false disables it - `boolean`

  throws: java.sql.SQLException - if a database access error occurs, this method is called on a closed connection or this method is called during a transaction"
  ([^Connection this ^Boolean read-only]
    (-> this (.setReadOnly read-only))))

(defn get-transaction-isolation
  "Retrieves this Connection object's current
   transaction isolation level.

  returns: the current transaction isolation level, which will be one
           of the following constants:
          Connection.TRANSACTION_READ_UNCOMMITTED,
          Connection.TRANSACTION_READ_COMMITTED,
          Connection.TRANSACTION_REPEATABLE_READ,
          Connection.TRANSACTION_SERIALIZABLE, or
          Connection.TRANSACTION_NONE. - `int`

  throws: java.sql.SQLException - if a database access error occurs or this method is called on a closed connection"
  (^Integer [^Connection this]
    (-> this (.getTransactionIsolation))))

(defn set-savepoint
  "Creates a savepoint with the given name in the current transaction
   and returns the new Savepoint object that represents it.

    if setSavepoint is invoked outside of an active transaction, a transaction will be started at this newly created
  savepoint.

  name - a String containing the name of the savepoint - `java.lang.String`

  returns: the new Savepoint object - `java.sql.Savepoint`

  throws: java.sql.SQLException - if a database access error occurs, this method is called while participating in a distributed transaction, this method is called on a closed connection or this Connection object is currently in auto-commit mode"
  (^java.sql.Savepoint [^Connection this ^java.lang.String name]
    (-> this (.setSavepoint name)))
  (^java.sql.Savepoint [^Connection this]
    (-> this (.setSavepoint))))

(defn native-sql
  "Converts the given SQL statement into the system's native SQL grammar.
   A driver may convert the JDBC SQL grammar into its system's
   native SQL grammar prior to sending it. This method returns the
   native form of the statement that the driver would have sent.

  sql - an SQL statement that may contain one or more '?' parameter placeholders - `java.lang.String`

  returns: the native form of this statement - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs or this method is called on a closed connection"
  (^java.lang.String [^Connection this ^java.lang.String sql]
    (-> this (.nativeSQL sql))))

(defn clear-warnings
  "Clears all warnings reported for this Connection object.
   After a call to this method, the method getWarnings
   returns null until a new warning is
   reported for this Connection object.

  throws: java.sql.SQLException - SQLException if a database access error occurs or this method is called on a closed connection"
  ([^Connection this]
    (-> this (.clearWarnings))))

(defn prepare-statement
  "Creates a PreparedStatement object that will generate
   ResultSet objects with the given type, concurrency,
   and holdability.

   This method is the same as the prepareStatement method
   above, but it allows the default result set
   type, concurrency, and holdability to be overridden.

  sql - a String object that is the SQL statement to be sent to the database; may contain one or more '?' IN parameters - `java.lang.String`
  result-set-type - one of the following ResultSet constants: ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE - `int`
  result-set-concurrency - one of the following ResultSet constants: ResultSet.CONCUR_READ_ONLY or ResultSet.CONCUR_UPDATABLE - `int`
  result-set-holdability - one of the following ResultSet constants: ResultSet.HOLD_CURSORS_OVER_COMMIT or ResultSet.CLOSE_CURSORS_AT_COMMIT - `int`

  returns: a new PreparedStatement object, containing the
           pre-compiled SQL statement, that will generate
           ResultSet objects with the given type,
           concurrency, and holdability - `java.sql.PreparedStatement`

  throws: java.sql.SQLException - if a database access error occurs, this method is called on a closed connection or the given parameters are not ResultSet constants indicating type, concurrency, and holdability"
  (^java.sql.PreparedStatement [^Connection this ^java.lang.String sql ^Integer result-set-type ^Integer result-set-concurrency ^Integer result-set-holdability]
    (-> this (.prepareStatement sql result-set-type result-set-concurrency result-set-holdability)))
  (^java.sql.PreparedStatement [^Connection this ^java.lang.String sql ^Integer result-set-type ^Integer result-set-concurrency]
    (-> this (.prepareStatement sql result-set-type result-set-concurrency)))
  (^java.sql.PreparedStatement [^Connection this ^java.lang.String sql ^Integer auto-generated-keys]
    (-> this (.prepareStatement sql auto-generated-keys)))
  (^java.sql.PreparedStatement [^Connection this ^java.lang.String sql]
    (-> this (.prepareStatement sql))))

(defn get-warnings
  "Retrieves the first warning reported by calls on this
   Connection object.  If there is more than one
   warning, subsequent warnings will be chained to the first one
   and can be retrieved by calling the method
   SQLWarning.getNextWarning on the warning
   that was retrieved previously.

   This method may not be
   called on a closed connection; doing so will cause an
   SQLException to be thrown.

   Note: Subsequent warnings will be chained to this
   SQLWarning.

  returns: the first SQLWarning object or null
           if there are none - `java.sql.SQLWarning`

  throws: java.sql.SQLException - if a database access error occurs or this method is called on a closed connection"
  (^java.sql.SQLWarning [^Connection this]
    (-> this (.getWarnings))))

(defn set-client-info
  "Sets the value of the client info property specified by name to the
   value specified by value.

   Applications may use the DatabaseMetaData.getClientInfoProperties
   method to determine the client info properties supported by the driver
   and the maximum length that may be specified for each property.

   The driver stores the value specified in a suitable location in the
   database.  For example in a special register, session parameter, or
   system table column.  For efficiency the driver may defer setting the
   value in the database until the next time a statement is executed or
   prepared.  Other than storing the client information in the appropriate
   place in the database, these methods shall not alter the behavior of
   the connection in anyway.  The values supplied to these methods are
   used for accounting, diagnostics and debugging purposes only.

   The driver shall generate a warning if the client info name specified
   is not recognized by the driver.

   If the value specified to this method is greater than the maximum
   length for the property the driver may either truncate the value and
   generate a warning or generate a SQLClientInfoException.  If the driver
   generates a SQLClientInfoException, the value specified was not set on the
   connection.

   The following are standard client info properties.  Drivers are not
   required to support these properties however if the driver supports a
   client info property that can be described by one of the standard
   properties, the standard property name should be used.


   ApplicationName  -       The name of the application currently utilizing
                                                        the connection
   ClientUser               -       The name of the user that the application using
                                                        the connection is performing work for.  This may
                                                        not be the same as the user name that was used
                                                        in establishing the connection.
   ClientHostname   -       The hostname of the computer the application
                                                        using the connection is running on.

  name - The name of the client info property to set - `java.lang.String`
  value - The value to set the client info property to. If the value is null, the current value of the specified property is cleared. - `java.lang.String`

  throws: java.sql.SQLClientInfoException - if the database server returns an error while setting the client info value on the database server or this method is called on a closed connection"
  ([^Connection this ^java.lang.String name ^java.lang.String value]
    (-> this (.setClientInfo name value)))
  ([^Connection this ^java.util.Properties properties]
    (-> this (.setClientInfo properties))))

(defn get-client-info
  "Returns the value of the client info property specified by name.  This
   method may return null if the specified client info property has not
   been set and does not have a default value.  This method will also
   return null if the specified client info property name is not supported
   by the driver.

   Applications may use the DatabaseMetaData.getClientInfoProperties
   method to determine the client info properties supported by the driver.

  name - The name of the client info property to retrieve - `java.lang.String`

  returns: The value of the client info property specified - `java.lang.String`

  throws: java.sql.SQLException - if the database server returns an error when fetching the client info value from the databaseor this method is called on a closed connection"
  (^java.lang.String [^Connection this ^java.lang.String name]
    (-> this (.getClientInfo name)))
  (^java.util.Properties [^Connection this]
    (-> this (.getClientInfo))))

(defn create-n-clob
  "Constructs an object that implements the NClob interface. The object
   returned initially contains no data.  The setAsciiStream,
   setCharacterStream and setString methods of the NClob interface may
   be used to add data to the NClob.

  returns: An object that implements the NClob interface - `java.sql.NClob`

  throws: java.sql.SQLException - if an object that implements the NClob interface can not be constructed, this method is called on a closed connection or a database access error occurs."
  (^java.sql.NClob [^Connection this]
    (-> this (.createNClob))))

(defn release-savepoint
  "Removes the specified Savepoint  and subsequent Savepoint objects from the current
   transaction. Any reference to the savepoint after it have been removed
   will cause an SQLException to be thrown.

  savepoint - the Savepoint object to be removed - `java.sql.Savepoint`

  throws: java.sql.SQLException - if a database access error occurs, this method is called on a closed connection or the given Savepoint object is not a valid savepoint in the current transaction"
  ([^Connection this ^java.sql.Savepoint savepoint]
    (-> this (.releaseSavepoint savepoint))))

(defn create-sqlxml
  "Constructs an object that implements the SQLXML interface. The object
   returned initially contains no data. The createXmlStreamWriter object and
   setString method of the SQLXML interface may be used to add data to the SQLXML
   object.

  returns: An object that implements the SQLXML interface - `java.sql.SQLXML`

  throws: java.sql.SQLException - if an object that implements the SQLXML interface can not be constructed, this method is called on a closed connection or a database access error occurs."
  (^java.sql.SQLXML [^Connection this]
    (-> this (.createSQLXML))))

(defn prepare-call
  "Creates a CallableStatement object that will generate
   ResultSet objects with the given type and concurrency.
   This method is the same as the prepareCall method
   above, but it allows the default result set
   type, result set concurrency type and holdability to be overridden.

  sql - a String object that is the SQL statement to be sent to the database; may contain on or more '?' parameters - `java.lang.String`
  result-set-type - one of the following ResultSet constants: ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE - `int`
  result-set-concurrency - one of the following ResultSet constants: ResultSet.CONCUR_READ_ONLY or ResultSet.CONCUR_UPDATABLE - `int`
  result-set-holdability - one of the following ResultSet constants: ResultSet.HOLD_CURSORS_OVER_COMMIT or ResultSet.CLOSE_CURSORS_AT_COMMIT - `int`

  returns: a new CallableStatement object, containing the
           pre-compiled SQL statement, that will generate
           ResultSet objects with the given type,
           concurrency, and holdability - `java.sql.CallableStatement`

  throws: java.sql.SQLException - if a database access error occurs, this method is called on a closed connection or the given parameters are not ResultSet constants indicating type, concurrency, and holdability"
  (^java.sql.CallableStatement [^Connection this ^java.lang.String sql ^Integer result-set-type ^Integer result-set-concurrency ^Integer result-set-holdability]
    (-> this (.prepareCall sql result-set-type result-set-concurrency result-set-holdability)))
  (^java.sql.CallableStatement [^Connection this ^java.lang.String sql ^Integer result-set-type ^Integer result-set-concurrency]
    (-> this (.prepareCall sql result-set-type result-set-concurrency)))
  (^java.sql.CallableStatement [^Connection this ^java.lang.String sql]
    (-> this (.prepareCall sql))))

(defn set-transaction-isolation
  "Attempts to change the transaction isolation level for this
   Connection object to the one given.
   The constants defined in the interface Connection
   are the possible transaction isolation levels.

   Note: If this method is called during a transaction, the result
   is implementation-defined.

  level - one of the following Connection constants: Connection.TRANSACTION_READ_UNCOMMITTED, Connection.TRANSACTION_READ_COMMITTED, Connection.TRANSACTION_REPEATABLE_READ, or Connection.TRANSACTION_SERIALIZABLE. (Note that Connection.TRANSACTION_NONE cannot be used because it specifies that transactions are not supported.) - `int`

  throws: java.sql.SQLException - if a database access error occurs, this method is called on a closed connection or the given parameter is not one of the Connection constants"
  ([^Connection this ^Integer level]
    (-> this (.setTransactionIsolation level))))

(defn commit
  "Makes all changes made since the previous
   commit/rollback permanent and releases any database locks
   currently held by this Connection object.
   This method should be
   used only when auto-commit mode has been disabled.

  throws: java.sql.SQLException - if a database access error occurs, this method is called while participating in a distributed transaction, if this method is called on a closed connection or this Connection object is in auto-commit mode"
  ([^Connection this]
    (-> this (.commit))))

(defn create-statement
  "Creates a Statement object that will generate
   ResultSet objects with the given type, concurrency,
   and holdability.
   This method is the same as the createStatement method
   above, but it allows the default result set
   type, concurrency, and holdability to be overridden.

  result-set-type - one of the following ResultSet constants: ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE - `int`
  result-set-concurrency - one of the following ResultSet constants: ResultSet.CONCUR_READ_ONLY or ResultSet.CONCUR_UPDATABLE - `int`
  result-set-holdability - one of the following ResultSet constants: ResultSet.HOLD_CURSORS_OVER_COMMIT or ResultSet.CLOSE_CURSORS_AT_COMMIT - `int`

  returns: a new Statement object that will generate
           ResultSet objects with the given type,
           concurrency, and holdability - `java.sql.Statement`

  throws: java.sql.SQLException - if a database access error occurs, this method is called on a closed connection or the given parameters are not ResultSet constants indicating type, concurrency, and holdability"
  (^java.sql.Statement [^Connection this ^Integer result-set-type ^Integer result-set-concurrency ^Integer result-set-holdability]
    (-> this (.createStatement result-set-type result-set-concurrency result-set-holdability)))
  (^java.sql.Statement [^Connection this ^Integer result-set-type ^Integer result-set-concurrency]
    (-> this (.createStatement result-set-type result-set-concurrency)))
  (^java.sql.Statement [^Connection this]
    (-> this (.createStatement))))

(defn closed?
  "Retrieves whether this Connection object has been
   closed.  A connection is closed if the method close
   has been called on it or if certain fatal errors have occurred.
   This method is guaranteed to return true only when
   it is called after the method Connection.close has
   been called.

   This method generally cannot be called to determine whether a
   connection to a database is valid or invalid.  A typical client
   can determine that a connection is invalid by catching any
   exceptions that might be thrown when an operation is attempted.

  returns: true if this Connection object
           is closed; false if it is still open - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^Connection this]
    (-> this (.isClosed))))

(defn create-blob
  "Constructs an object that implements the Blob interface. The object
   returned initially contains no data.  The setBinaryStream and
   setBytes methods of the Blob interface may be used to add data to
   the Blob.

  returns: An object that implements the Blob interface - `java.sql.Blob`

  throws: java.sql.SQLException - if an object that implements the Blob interface can not be constructed, this method is called on a closed connection or a database access error occurs."
  (^java.sql.Blob [^Connection this]
    (-> this (.createBlob))))

(defn get-catalog
  "Retrieves this Connection object's current catalog name.

  returns: the current catalog name or null if there is none - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs or this method is called on a closed connection"
  (^java.lang.String [^Connection this]
    (-> this (.getCatalog))))

(defn set-schema
  "Sets the given schema name to access.

   If the driver does not support schemas, it will
   silently ignore this request.

   Calling setSchema has no effect on previously created or prepared
   Statement objects. It is implementation defined whether a DBMS
   prepare operation takes place immediately when the Connection
   method prepareStatement or prepareCall is invoked.
   For maximum portability, setSchema should be called before a
   Statement is created or prepared.

  schema - the name of a schema in which to work - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs or this method is called on a closed connection"
  ([^Connection this ^java.lang.String schema]
    (-> this (.setSchema schema))))

(defn get-meta-data
  "Retrieves a DatabaseMetaData object that contains
   metadata about the database to which this
   Connection object represents a connection.
   The metadata includes information about the database's
   tables, its supported SQL grammar, its stored
   procedures, the capabilities of this connection, and so on.

  returns: a DatabaseMetaData object for this
           Connection object - `java.sql.DatabaseMetaData`

  throws: java.sql.SQLException - if a database access error occurs or this method is called on a closed connection"
  (^java.sql.DatabaseMetaData [^Connection this]
    (-> this (.getMetaData))))

(defn close
  "Releases this Connection object's database and JDBC resources
   immediately instead of waiting for them to be automatically released.

   Calling the method close on a Connection
   object that is already closed is a no-op.

   It is strongly recommended that an application explicitly
   commits or rolls back an active transaction prior to calling the
   close method.  If the close method is called
   and there is an active transaction, the results are implementation-defined.

  throws: java.sql.SQLException - SQLException if a database access error occurs"
  ([^Connection this]
    (-> this (.close))))

(defn valid?
  "Returns true if the connection has not been closed and is still valid.
   The driver shall submit a query on the connection or use some other
   mechanism that positively verifies the connection is still valid when
   this method is called.

   The query submitted by the driver to validate the connection shall be
   executed in the context of the current transaction.

  timeout - - The time in seconds to wait for the database operation used to validate the connection to complete. If the timeout period expires before the operation completes, this method returns false. A value of 0 indicates a timeout is not applied to the database operation. - `int`

  returns: true if the connection is valid, false otherwise - `boolean`

  throws: java.sql.SQLException - if the value supplied for timeout is less then 0"
  (^Boolean [^Connection this ^Integer timeout]
    (-> this (.isValid timeout))))

(defn get-schema
  "Retrieves this Connection object's current schema name.

  returns: the current schema name or null if there is none - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs or this method is called on a closed connection"
  (^java.lang.String [^Connection this]
    (-> this (.getSchema))))

(defn set-catalog
  "Sets the given catalog name in order to select
   a subspace of this Connection object's database
   in which to work.

   If the driver does not support catalogs, it will
   silently ignore this request.

   Calling setCatalog has no effect on previously created or prepared
   Statement objects. It is implementation defined whether a DBMS
   prepare operation takes place immediately when the Connection
   method prepareStatement or prepareCall is invoked.
   For maximum portability, setCatalog should be called before a
   Statement is created or prepared.

  catalog - the name of a catalog (subspace in this Connection object's database) in which to work - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs or this method is called on a closed connection"
  ([^Connection this ^java.lang.String catalog]
    (-> this (.setCatalog catalog))))

(defn set-holdability
  "Changes the default holdability of ResultSet objects
   created using this Connection object to the given
   holdability.  The default holdability of ResultSet objects
   can be be determined by invoking
   DatabaseMetaData.getResultSetHoldability().

  holdability - a ResultSet holdability constant; one of ResultSet.HOLD_CURSORS_OVER_COMMIT or ResultSet.CLOSE_CURSORS_AT_COMMIT - `int`

  throws: java.sql.SQLException - if a database access occurs, this method is called on a closed connection, or the given parameter is not a ResultSet constant indicating holdability"
  ([^Connection this ^Integer holdability]
    (-> this (.setHoldability holdability))))

(defn rollback
  "Undoes all changes made after the given Savepoint object
   was set.

   This method should be used only when auto-commit has been disabled.

  savepoint - the Savepoint object to roll back to - `java.sql.Savepoint`

  throws: java.sql.SQLException - if a database access error occurs, this method is called while participating in a distributed transaction, this method is called on a closed connection, the Savepoint object is no longer valid, or this Connection object is currently in auto-commit mode"
  ([^Connection this ^java.sql.Savepoint savepoint]
    (-> this (.rollback savepoint)))
  ([^Connection this]
    (-> this (.rollback))))

(defn get-type-map
  "Retrieves the Map object associated with this
   Connection object.
   Unless the application has added an entry, the type map returned
   will be empty.

   You must invoke setTypeMap after making changes to the
   Map object returned from
    getTypeMap as a JDBC driver may create an internal
   copy of the Map object passed to setTypeMap:



        Map<String,Class<?>> myMap = con.getTypeMap();
        myMap.put(`mySchemaName.ATHLETES`, Athletes.class);
        con.setTypeMap(myMap);

  returns: the java.util.Map object associated
           with this Connection object - `java.util.Map<java.lang.String,java.lang.Class<?>>`

  throws: java.sql.SQLException - if a database access error occurs or this method is called on a closed connection"
  (^java.util.Map [^Connection this]
    (-> this (.getTypeMap))))

(defn abort
  "Terminates an open connection.  Calling abort results in:

   The connection marked as closed
   Closes any physical connection to the database
   Releases resources used by the connection
   Insures that any thread that is currently accessing the connection
   will either progress to completion or throw an SQLException.


   Calling abort marks the connection closed and releases any
   resources. Calling abort on a closed connection is a
   no-op.

   It is possible that the aborting and releasing of the resources that are
   held by the connection can take an extended period of time.  When the
   abort method returns, the connection will have been marked as
   closed and the Executor that was passed as a parameter to abort
   may still be executing tasks to release resources.

   This method checks to see that there is an SQLPermission
   object before allowing the method to proceed.  If a
   SecurityManager exists and its
   checkPermission method denies calling abort,
   this method throws a
   java.lang.SecurityException.

  executor - The Executor implementation which will be used by abort. - `java.util.concurrent.Executor`

  throws: java.sql.SQLException - if a database access error occurs or the executor is null,"
  ([^Connection this ^java.util.concurrent.Executor executor]
    (-> this (.abort executor))))

(defn get-holdability
  "Retrieves the current holdability of ResultSet objects
   created using this Connection object.

  returns: the holdability, one of
          ResultSet.HOLD_CURSORS_OVER_COMMIT or
          ResultSet.CLOSE_CURSORS_AT_COMMIT - `int`

  throws: java.sql.SQLException - if a database access error occurs or this method is called on a closed connection"
  (^Integer [^Connection this]
    (-> this (.getHoldability))))

(defn create-struct
  "Factory method for creating Struct objects.

  type-name - the SQL type name of the SQL structured type that this Struct object maps to. The typeName is the name of a user-defined type that has been defined for this database. It is the value returned by Struct.getSQLTypeName. - `java.lang.String`
  attributes - the attributes that populate the returned object - `java.lang.Object[]`

  returns: a Struct object that maps to the given SQL type and is populated with the given attributes - `java.sql.Struct`

  throws: java.sql.SQLException - if a database error occurs, the typeName is null or this method is called on a closed connection"
  (^java.sql.Struct [^Connection this ^java.lang.String type-name attributes]
    (-> this (.createStruct type-name attributes))))

(defn read-only?
  "Retrieves whether this Connection
   object is in read-only mode.

  returns: true if this Connection object
           is read-only; false otherwise - `boolean`

  throws: java.sql.SQLException - SQLException if a database access error occurs or this method is called on a closed connection"
  (^Boolean [^Connection this]
    (-> this (.isReadOnly))))

(defn set-auto-commit
  "Sets this connection's auto-commit mode to the given state.
   If a connection is in auto-commit mode, then all its SQL
   statements will be executed and committed as individual
   transactions.  Otherwise, its SQL statements are grouped into
   transactions that are terminated by a call to either
   the method commit or the method rollback.
   By default, new connections are in auto-commit
   mode.

   The commit occurs when the statement completes. The time when the statement
   completes depends on the type of SQL Statement:

   For DML statements, such as Insert, Update or Delete, and DDL statements,
   the statement is complete as soon as it has finished executing.
   For Select statements, the statement is complete when the associated result
   set is closed.
   For CallableStatement objects or for statements that return
   multiple results, the statement is complete
   when all of the associated result sets have been closed, and all update
   counts and output parameters have been retrieved.


   NOTE:  If this method is called during a transaction and the
   auto-commit mode is changed, the transaction is committed.  If
   setAutoCommit is called and the auto-commit mode is
   not changed, the call is a no-op.

  auto-commit - true to enable auto-commit mode; false to disable it - `boolean`

  throws: java.sql.SQLException - if a database access error occurs, setAutoCommit(true) is called while participating in a distributed transaction, or this method is called on a closed connection"
  ([^Connection this ^Boolean auto-commit]
    (-> this (.setAutoCommit auto-commit))))

(defn get-network-timeout
  "Retrieves the number of milliseconds the driver will
   wait for a database request to complete.
   If the limit is exceeded, a
   SQLException is thrown.

  returns: the current timeout limit in milliseconds; zero means there is
           no limit - `int`

  throws: java.sql.SQLException - if a database access error occurs or this method is called on a closed Connection"
  (^Integer [^Connection this]
    (-> this (.getNetworkTimeout))))

(defn set-network-timeout
  "Sets the maximum period a Connection or
   objects created from the Connection
   will wait for the database to reply to any one request. If any
    request remains unanswered, the waiting method will
   return with a SQLException, and the Connection
   or objects created from the Connection  will be marked as
   closed. Any subsequent use of
   the objects, with the exception of the close,
   isClosed or Connection.isValid
   methods, will result in  a SQLException.

   Note: This method is intended to address a rare but serious
   condition where network partitions can cause threads issuing JDBC calls
   to hang uninterruptedly in socket reads, until the OS TCP-TIMEOUT
   (typically 10 minutes). This method is related to the
   abort()  method which provides an administrator
   thread a means to free any such threads in cases where the
   JDBC connection is accessible to the administrator thread.
   The setNetworkTimeout method will cover cases where
   there is no administrator thread, or it has no access to the
   connection. This method is severe in it's effects, and should be
   given a high enough value so it is never triggered before any more
   normal timeouts, such as transaction timeouts.

   JDBC driver implementations  may also choose to support the
   setNetworkTimeout method to impose a limit on database
   response time, in environments where no network is present.

   Drivers may internally implement some or all of their API calls with
   multiple internal driver-database transmissions, and it is left to the
   driver implementation to determine whether the limit will be
   applied always to the response to the API call, or to any
   single  request made during the API call.


   This method can be invoked more than once, such as to set a limit for an
   area of JDBC code, and to reset to the default on exit from this area.
   Invocation of this method has no impact on already outstanding
   requests.

   The Statement.setQueryTimeout() timeout value is independent of the
   timeout value specified in setNetworkTimeout. If the query timeout
   expires  before the network timeout then the
   statement execution will be canceled. If the network is still
   active the result will be that both the statement and connection
   are still usable. However if the network timeout expires before
   the query timeout or if the statement timeout fails due to network
   problems, the connection will be marked as closed, any resources held by
   the connection will be released and both the connection and
   statement will be unusable.

   When the driver determines that the setNetworkTimeout timeout
   value has expired, the JDBC driver marks the connection
   closed and releases any resources held by the connection.


   This method checks to see that there is an SQLPermission
   object before allowing the method to proceed.  If a
   SecurityManager exists and its
   checkPermission method denies calling
   setNetworkTimeout, this method throws a
   java.lang.SecurityException.

  executor - The Executor implementation which will be used by setNetworkTimeout. - `java.util.concurrent.Executor`
  milliseconds - The time in milliseconds to wait for the database operation to complete. If the JDBC driver does not support milliseconds, the JDBC driver will round the value up to the nearest second. If the timeout period expires before the operation completes, a SQLException will be thrown. A value of 0 indicates that there is not timeout for database operations. - `int`

  throws: java.sql.SQLException - if a database access error occurs, this method is called on a closed connection, the executor is null, or the value specified for seconds is less than 0."
  ([^Connection this ^java.util.concurrent.Executor executor ^Integer milliseconds]
    (-> this (.setNetworkTimeout executor milliseconds))))

(defn create-array-of
  "Factory method for creating Array objects.

   Note: When createArrayOf is used to create an array object
   that maps to a primitive data type, then it is implementation-defined
   whether the Array object is an array of that primitive
   data type or an array of Object.

   Note: The JDBC driver is responsible for mapping the elements
   Object array to the default JDBC SQL type defined in
   java.sql.Types for the given class of Object. The default
   mapping is specified in Appendix B of the JDBC specification.  If the
   resulting JDBC type is not the appropriate type for the given typeName then
   it is implementation defined whether an SQLException is
   thrown or the driver supports the resulting conversion.

  type-name - the SQL name of the type the elements of the array map to. The typeName is a database-specific name which may be the name of a built-in type, a user-defined type or a standard SQL type supported by this database. This is the value returned by Array.getBaseTypeName - `java.lang.String`
  elements - the elements that populate the returned object - `java.lang.Object[]`

  returns: an Array object whose elements map to the specified SQL type - `java.sql.Array`

  throws: java.sql.SQLException - if a database error occurs, the JDBC type is not appropriate for the typeName and the conversion is not supported, the typeName is null or this method is called on a closed connection"
  (^java.sql.Array [^Connection this ^java.lang.String type-name elements]
    (-> this (.createArrayOf type-name elements))))

