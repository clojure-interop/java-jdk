(ns javax.sql.RowSet
  "The interface that adds support to the JDBC API for the
  JavaBeans™ component model.
  A rowset, which can be used as a JavaBeans component in
  a visual Bean development environment, can be created and
  configured at design time and executed at run time.

  The RowSet
  interface provides a set of JavaBeans properties that allow a RowSet
  instance to be configured to connect to a JDBC data source and read
  some data from the data source.  A group of setter methods (setInt,
  setBytes, setString, and so on)
  provide a way to pass input parameters to a rowset's command property.
  This command is the SQL query the rowset uses when it gets its data from
  a relational database, which is generally the case.

  The RowSet
  interface supports JavaBeans events, allowing other components in an
  application to be notified when an event occurs on a rowset,
  such as a change in its value.

  The RowSet interface is unique in that it is intended to be
  implemented using the rest of the JDBC API.  In other words, a
  RowSet implementation is a layer of software that executes `on top`
  of a JDBC driver.  Implementations of the RowSet interface can
  be provided by anyone, including JDBC driver vendors who want to
  provide a RowSet implementation as part of their JDBC products.

  A RowSet object may make a connection with a data source and
  maintain that connection throughout its life cycle, in which case it is
  called a connected rowset.  A rowset may also make a connection with
  a data source, get data from it, and then close the connection. Such a rowset
  is called a disconnected rowset.  A disconnected rowset may make
  changes to its data while it is disconnected and then send the changes back
  to the original source of the data, but it must reestablish a connection to do so.

  A disconnected rowset may have a reader (a RowSetReader object)
  and a writer (a RowSetWriter object) associated with it.
  The reader may be implemented in many different ways to populate a rowset
  with data, including getting data from a non-relational data source. The
  writer can also be implemented in many different ways to propagate changes
  made to the rowset's data back to the underlying data source.

  Rowsets are easy to use.  The RowSet interface extends the standard
  java.sql.ResultSet interface.  The RowSetMetaData
  interface extends the java.sql.ResultSetMetaData interface.
  Thus, developers familiar
  with the JDBC API will have to learn a minimal number of new APIs to
  use rowsets.  In addition, third-party software tools that work with
  JDBC ResultSet objects will also easily be made to work with rowsets."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql RowSet]))

(defn set-bytes
  "Sets the designated parameter in this RowSet object's command
   to the given Java array of byte values. Before sending it to the
   database, the driver converts this to an SQL VARBINARY or
   LONGVARBINARY value, depending on the argument's size relative
   to the driver's limits on VARBINARY values.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `byte[]`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this parameter-index x]
    (-> this (.setBytes parameter-index x))))

(defn set-string
  "Sets the designated parameter in this RowSet object's command
   to the given Java String value. Before sending it to the
   database, the driver converts this to an SQL VARCHAR or
   LONGVARCHAR value, depending on the argument's size relative
   to the driver's limits on VARCHAR values.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this parameter-index x]
    (-> this (.setString parameter-index x))))

(defn remove-row-set-listener
  "Removes the specified listener from the list of components that will be
   notified when an event occurs on this RowSet object.

  listener - a component that has been registered as a listener for this RowSet object - `javax.sql.RowSetListener`"
  ([this listener]
    (-> this (.removeRowSetListener listener))))

(defn set-array
  "Sets the designated parameter in this RowSet object's command
   with the given  Array value.  The driver will convert this
   to the ARRAY value that the Array object
   represents before sending it to the database.

  i - the first parameter is 1, the second is 2, ... - `int`
  x - an object representing an SQL array - `java.sql.Array`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this i x]
    (-> this (.setArray i x))))

(defn set-type-map
  "Installs the given java.util.Map object as the default
   type map for this RowSet object. This type map will be
   used unless another type map is supplied as a method parameter.

  map - a java.util.Map object containing the names of SQL user-defined types and the Java classes to which they are to be mapped - `java.util.Map<java.lang.String,java.lang.Class<?>>`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this map]
    (-> this (.setTypeMap map))))

(defn set-read-only
  "Sets whether this RowSet object is read-only to the
   given boolean.

  value - true if read-only; false if updatable - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this value]
    (-> this (.setReadOnly value))))

(defn set-time
  "Sets the designated parameter in this RowSet object's command
   with the given  java.sql.Time value.  The driver will convert this
   to an SQL TIME value, using the given java.util.Calendar
   object to calculate it, before sending it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `java.sql.Time`
  cal - the java.util.Calendar object to use for calculating the time - `java.util.Calendar`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this parameter-index x cal]
    (-> this (.setTime parameter-index x cal)))
  ([this parameter-index x]
    (-> this (.setTime parameter-index x))))

(defn set-timestamp
  "Sets the designated parameter in this RowSet object's command
   with the given  java.sql.Timestamp value.  The driver will
   convert this to an SQL TIMESTAMP value, using the given
   java.util.Calendar object to calculate it, before sending it to the
   database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `java.sql.Timestamp`
  cal - the java.util.Calendar object to use for calculating the timestamp - `java.util.Calendar`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this parameter-index x cal]
    (-> this (.setTimestamp parameter-index x cal)))
  ([this parameter-index x]
    (-> this (.setTimestamp parameter-index x))))

(defn set-date
  "Sets the designated parameter in this RowSet object's command
   with the given  java.sql.Date value.  The driver will convert this
   to an SQL DATE value, using the given java.util.Calendar
   object to calculate the date.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `java.sql.Date`
  cal - the java.util.Calendar object to use for calculating the date - `java.util.Calendar`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this parameter-index x cal]
    (-> this (.setDate parameter-index x cal)))
  ([this parameter-index x]
    (-> this (.setDate parameter-index x))))

(defn set-boolean
  "Sets the designated parameter in this RowSet object's command
   to the given Java boolean value. The driver converts this to
   an SQL BIT value before sending it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this parameter-index x]
    (-> this (.setBoolean parameter-index x))))

(defn get-url
  "Retrieves the url property this RowSet object will use to
   create a connection if it uses the DriverManager
   instead of a DataSource object to establish the connection.
   The default value is null.

  returns: a string url - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this]
    (-> this (.getUrl))))

(defn set-command
  "Sets this RowSet object's command property to the given
   SQL query.

   This property is optional
   when a rowset gets its data from a data source that does not support
   commands, such as a spreadsheet.

  cmd - the SQL query that will be used to get the data for this RowSet object; may be null - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this cmd]
    (-> this (.setCommand cmd))))

(defn set-n-character-stream
  "Sets the designated parameter to a Reader object. The
   Reader reads the data till end-of-file is reached. The
   driver does the necessary conversion from Java character format to
   the national character set in the database.

  parameter-index - of the first parameter is 1, the second is 2, ... - `int`
  value - the parameter value - `java.io.Reader`
  length - the number of characters in the parameter data. - `long`

  throws: java.sql.SQLException - if the driver does not support national character sets; if the driver can detect that a data conversion error could occur ; or if a database access error occurs"
  ([this parameter-index value length]
    (-> this (.setNCharacterStream parameter-index value length)))
  ([this parameter-index value]
    (-> this (.setNCharacterStream parameter-index value))))

(defn set-null
  "Sets the designated parameter in this RowSet object's SQL
   command to SQL NULL. This version of the method setNull
   should  be used for SQL user-defined types (UDTs) and REF type
   parameters.  Examples of UDTs include: STRUCT, DISTINCT,
   JAVA_OBJECT, and named array types.

   Note: To be portable, applications must give the
   SQL type code and the fully qualified SQL type name when specifying
   a NULL UDT or REF parameter.  In the case of a UDT,
   the name is the type name of the parameter itself.  For a REF
   parameter, the name is the type name of the referenced type.  If
   a JDBC driver does not need the type code or type name information,
   it may ignore it.

   Although it is intended for UDT and REF parameters,
   this method may be used to set a null parameter of any JDBC type.
   If the parameter does not have a user-defined or REF type,
   the typeName parameter is ignored.

  param-index - the first parameter is 1, the second is 2, ... - `int`
  sql-type - a value from java.sql.Types - `int`
  type-name - the fully qualified name of an SQL UDT or the type name of the SQL structured type being referenced by a REF type; ignored if the parameter is not a UDT or REF type - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this param-index sql-type type-name]
    (-> this (.setNull param-index sql-type type-name)))
  ([this parameter-index sql-type]
    (-> this (.setNull parameter-index sql-type))))

(defn set-query-timeout
  "Sets the maximum time the driver will wait for
   a statement to execute to the given number of seconds.
   If this limit is exceeded, an SQLException is thrown.

  seconds - the new query timeout limit in seconds; zero means that there is no limit - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this seconds]
    (-> this (.setQueryTimeout seconds))))

(defn get-transaction-isolation
  "Retrieves the transaction isolation level set for this
   RowSet object.

  returns: the transaction isolation level; one of
        Connection.TRANSACTION_READ_UNCOMMITTED,
        Connection.TRANSACTION_READ_COMMITTED,
        Connection.TRANSACTION_REPEATABLE_READ, or
        Connection.TRANSACTION_SERIALIZABLE - `int`"
  ([this]
    (-> this (.getTransactionIsolation))))

(defn set-password
  "Sets the database password for this RowSet object to
   the given String.

  password - the password string - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this password]
    (-> this (.setPassword password))))

(defn set-binary-stream
  "Sets the designated parameter in this RowSet object's command
   to the given java.io.InputStream value.
   It may be more practical to send a very large binary value via a
   java.io.InputStream rather than as a LONGVARBINARY
   parameter. The driver will read the data from the stream
   as needed until it reaches end-of-file.

   Note: This stream object can either be a standard
   Java stream object or your own subclass that implements the
   standard interface.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the java input stream which contains the binary parameter value - `java.io.InputStream`
  length - the number of bytes in the stream - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this parameter-index x length]
    (-> this (.setBinaryStream parameter-index x length)))
  ([this parameter-index x]
    (-> this (.setBinaryStream parameter-index x))))

(defn set-type
  "Sets the type of this RowSet object to the given type.
   This method is used to change the type of a rowset, which is by
   default read-only and non-scrollable.

  type - one of the ResultSet constants specifying a type: ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this type]
    (-> this (.setType type))))

(defn add-row-set-listener
  "Registers the given listener so that it will be notified of events
   that occur on this RowSet object.

  listener - a component that has implemented the RowSetListener interface and wants to be notified when events occur on this RowSet object - `javax.sql.RowSetListener`"
  ([this listener]
    (-> this (.addRowSetListener listener))))

(defn get-command
  "Retrieves this RowSet object's command property.

   The command property contains a command string, which must be an SQL
   query, that can be executed to fill the rowset with data.
   The default value is null.

  returns: the command string; may be null - `java.lang.String`"
  ([this]
    (-> this (.getCommand))))

(defn set-blob
  "Sets the designated parameter to a InputStream object.  The inputstream must contain  the number
   of characters specified by length otherwise a SQLException will be
   generated when the PreparedStatement is executed.
   This method differs from the setBinaryStream (int, InputStream, int)
   method because it informs the driver that the parameter value should be
   sent to the server as a BLOB.  When the setBinaryStream method is used,
   the driver may have to do extra work to determine whether the parameter
   data should be sent to the server as a LONGVARBINARY or a BLOB

  parameter-index - index of the first parameter is 1, the second is 2, ... - `int`
  input-stream - An object that contains the data to set the parameter value to. - `java.io.InputStream`
  length - the number of bytes in the parameter data. - `long`

  throws: java.sql.SQLException - if a database access error occurs, this method is called on a closed PreparedStatement, if parameterIndex does not correspond to a parameter marker in the SQL statement, if the length specified is less than zero or if the number of bytes in the inputstream does not match the specified length."
  ([this parameter-index input-stream length]
    (-> this (.setBlob parameter-index input-stream length)))
  ([this i x]
    (-> this (.setBlob i x))))

(defn set-url
  "Sets the URL this RowSet object will use when it uses the
   DriverManager to create a connection.

   Setting this property is optional.  If a URL is used, a JDBC driver
   that accepts the URL must be loaded before the
   rowset is used to connect to a database.  The rowset will use the URL
   internally to create a database connection when reading or writing
   data.  Either a URL or a data source name is used to create a
   connection, whichever was set to non null value most recently.

  url - a string value; may be null - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this url]
    (-> this (.setUrl url))))

(defn set-object
  "Sets the designated parameter in this RowSet object's command
   with the given Java Object.  For integral values, the
   java.lang equivalent objects should be used (for example,
   an instance of the class Integer for an int).

   If the second argument is an InputStream then the stream must contain
   the number of bytes specified by scaleOrLength.  If the second argument is a
   Reader then the reader must contain the number of characters specified    * by scaleOrLength. If these conditions are not true the driver will generate a
   SQLException when the prepared statement is executed.

   The given Java object will be converted to the targetSqlType
   before being sent to the database.

   If the object is of a class implementing SQLData,
   the rowset should call the method SQLData.writeSQL
   to write the object to an SQLOutput data stream.
   If, on the other hand, the object is of a class implementing
   Ref, Blob, Clob,  NClob,
    Struct, java.net.URL,
   or Array, the driver should pass it to the database as a
   value of the corresponding SQL type.


   Note that this method may be used to pass datatabase-specific
   abstract data types.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the object containing the input parameter value - `java.lang.Object`
  target-sql-type - the SQL type (as defined in java.sql.Types) to be sent to the database. The scale argument may further qualify this type. - `int`
  scale-or-length - for java.sql.Types.DECIMAL or java.sql.Types.NUMERIC types, this is the number of digits after the decimal point. For Java Object types InputStream and Reader, this is the length of the data in the stream or reader. For all other types, this value will be ignored. - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this parameter-index x target-sql-type scale-or-length]
    (-> this (.setObject parameter-index x target-sql-type scale-or-length)))
  ([this parameter-index x target-sql-type]
    (-> this (.setObject parameter-index x target-sql-type)))
  ([this parameter-name x]
    (-> this (.setObject parameter-name x))))

(defn set-escape-processing
  "Sets escape processing for this RowSet object on or
   off. If escape scanning is on (the default), the driver will do
   escape substitution before sending an SQL statement to the database.

  enable - true to enable escape processing; false to disable it - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this enable]
    (-> this (.setEscapeProcessing enable))))

(defn set-max-rows
  "Sets the maximum number of rows that this RowSet
   object can contain to the specified number.
   If the limit is exceeded, the excess rows are silently dropped.

  max - the new maximum number of rows; zero means unlimited - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this max]
    (-> this (.setMaxRows max))))

(defn get-username
  "Retrieves the username used to create a database connection for this
   RowSet object.
   The username property is set at run time before calling the method
   execute.  It is
   not usually part of the serialized state of a RowSet object.

  returns: the username property - `java.lang.String`"
  ([this]
    (-> this (.getUsername))))

(defn clear-parameters
  "Clears the parameters set for this RowSet object's command.
   In general, parameter values remain in force for repeated use of a
   RowSet object. Setting a parameter value automatically clears its
   previous value.  However, in some cases it is useful to immediately
   release the resources used by the current parameter values, which can
   be done by calling the method clearParameters.

  throws: java.sql.SQLException - if a database access error occurs"
  ([this]
    (-> this (.clearParameters))))

(defn set-n-clob
  "Sets the designated parameter to a Reader object.  The reader must contain  the number
   of characters specified by length otherwise a SQLException will be
   generated when the CallableStatement is executed.
   This method differs from the setCharacterStream (int, Reader, int) method
   because it informs the driver that the parameter value should be sent to
   the server as a NCLOB.  When the setCharacterStream method is used, the
   driver may have to do extra work to determine whether the parameter
   data should be send to the server as a LONGNVARCHAR or a NCLOB

  parameter-name - the name of the parameter to be set - `java.lang.String`
  reader - An object that contains the data to set the parameter value to. - `java.io.Reader`
  length - the number of characters in the parameter data. - `long`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if the length specified is less than zero; if the driver does not support national character sets; if the driver can detect that a data conversion error could occur; if a database access error occurs or this method is called on a closed CallableStatement"
  ([this parameter-name reader length]
    (-> this (.setNClob parameter-name reader length)))
  ([this parameter-name value]
    (-> this (.setNClob parameter-name value))))

(defn get-max-field-size
  "Retrieves the maximum number of bytes that may be returned
   for certain column values.
   This limit applies only to BINARY,
   VARBINARY, LONGVARBINARYBINARY, CHAR,
   VARCHAR, LONGVARCHAR, NCHAR
   and NVARCHAR columns.
   If the limit is exceeded, the excess data is silently discarded.

  returns: the current maximum column size limit; zero means that there
            is no limit - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this]
    (-> this (.getMaxFieldSize))))

(defn set-clob
  "Sets the designated parameter to a Reader object.  The reader must contain  the number
   of characters specified by length otherwise a SQLException will be
   generated when the PreparedStatement is executed.
  This method differs from the setCharacterStream (int, Reader, int) method
   because it informs the driver that the parameter value should be sent to
   the server as a CLOB.  When the setCharacterStream method is used, the
   driver may have to do extra work to determine whether the parameter
   data should be sent to the server as a LONGVARCHAR or a CLOB

  parameter-index - index of the first parameter is 1, the second is 2, ... - `int`
  reader - An object that contains the data to set the parameter value to. - `java.io.Reader`
  length - the number of characters in the parameter data. - `long`

  throws: java.sql.SQLException - if a database access error occurs, this method is called on a closed PreparedStatement, if parameterIndex does not correspond to a parameter marker in the SQL statement, or if the length specified is less than zero."
  ([this parameter-index reader length]
    (-> this (.setClob parameter-index reader length)))
  ([this i x]
    (-> this (.setClob i x))))

(defn set-transaction-isolation
  "Sets the transaction isolation level for this RowSet object.

  level - the transaction isolation level; one of Connection.TRANSACTION_READ_UNCOMMITTED, Connection.TRANSACTION_READ_COMMITTED, Connection.TRANSACTION_REPEATABLE_READ, or Connection.TRANSACTION_SERIALIZABLE - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this level]
    (-> this (.setTransactionIsolation level))))

(defn set-double
  "Sets the designated parameter in this RowSet object's command
   to the given Java double value. The driver converts this to
   an SQL DOUBLE value before sending it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `double`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this parameter-index x]
    (-> this (.setDouble parameter-index x))))

(defn set-ref
  "Sets the designated parameter in this RowSet object's command
   with the given  Ref value.  The driver will convert this
   to the appropriate REF(<structured-type>) value.

  i - the first parameter is 1, the second is 2, ... - `int`
  x - an object representing data of an SQL REF type - `java.sql.Ref`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this i x]
    (-> this (.setRef i x))))

(defn set-long
  "Sets the designated parameter in this RowSet object's command
   to the given Java long value. The driver converts this to
   an SQL BIGINT value before sending it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `long`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this parameter-index x]
    (-> this (.setLong parameter-index x))))

(defn set-max-field-size
  "Sets the maximum number of bytes that can be returned for a column
   value to the given number of bytes.
   This limit applies only to BINARY,
   VARBINARY, LONGVARBINARYBINARY, CHAR,
   VARCHAR, LONGVARCHAR, NCHAR
   and NVARCHAR columns.
   If the limit is exceeded, the excess data is silently discarded.
   For maximum portability, use values greater than 256.

  max - the new max column size limit in bytes; zero means unlimited - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this max]
    (-> this (.setMaxFieldSize max))))

(defn set-username
  "Sets the username property for this RowSet object to the
   given String.

  name - a user name - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this name]
    (-> this (.setUsername name))))

(defn set-byte
  "Sets the designated parameter in this RowSet object's command
   to the given Java byte value. The driver converts this to
   an SQL TINYINT value before sending it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `byte`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this parameter-index x]
    (-> this (.setByte parameter-index x))))

(defn set-n-string
  "Sets the designated parameter to the given String object.
   The driver converts this to a SQL NCHAR or
   NVARCHAR or LONGNVARCHAR value
   (depending on the argument's
   size relative to the driver's limits on NVARCHAR values)
   when it sends it to the database.

  parameter-index - of the first parameter is 1, the second is 2, ... - `int`
  value - the parameter value - `java.lang.String`

  throws: java.sql.SQLException - if the driver does not support national character sets; if the driver can detect that a data conversion error could occur ; or if a database access error occurs"
  ([this parameter-index value]
    (-> this (.setNString parameter-index value))))

(defn set-short
  "Sets the designated parameter in this RowSet object's command
   to the given Java short value. The driver converts this to
   an SQL SMALLINT value before sending it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `short`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this parameter-index x]
    (-> this (.setShort parameter-index x))))

(defn set-concurrency
  "Sets the concurrency of this RowSet object to the given
   concurrency level. This method is used to change the concurrency level
   of a rowset, which is by default ResultSet.CONCUR_READ_ONLY

  concurrency - one of the ResultSet constants specifying a concurrency level: ResultSet.CONCUR_READ_ONLY or ResultSet.CONCUR_UPDATABLE - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this concurrency]
    (-> this (.setConcurrency concurrency))))

(defn set-ascii-stream
  "Sets the designated parameter in this RowSet object's command
   to the given java.io.InputStream value.
   It may be more practical to send a very large ASCII value via a
   java.io.InputStream rather than as a LONGVARCHAR
   parameter. The driver will read the data from the stream
   as needed until it reaches end-of-file.

   Note: This stream object can either be a standard
   Java stream object or your own subclass that implements the
   standard interface.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the Java input stream that contains the ASCII parameter value - `java.io.InputStream`
  length - the number of bytes in the stream - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this parameter-index x length]
    (-> this (.setAsciiStream parameter-index x length)))
  ([this parameter-index x]
    (-> this (.setAsciiStream parameter-index x))))

(defn set-big-decimal
  "Sets the designated parameter in this RowSet object's command
   to the given java.math.BigDeciaml value.
   The driver converts this to
   an SQL NUMERIC value before sending it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `java.math.BigDecimal`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this parameter-index x]
    (-> this (.setBigDecimal parameter-index x))))

(defn get-max-rows
  "Retrieves the maximum number of rows that this RowSet
   object can contain.
   If the limit is exceeded, the excess rows are silently dropped.

  returns: the current maximum number of rows that this RowSet
           object can contain; zero means unlimited - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this]
    (-> this (.getMaxRows))))

(defn set-int
  "Sets the designated parameter in this RowSet object's command
   to the given Java int value. The driver converts this to
   an SQL INTEGER value before sending it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this parameter-index x]
    (-> this (.setInt parameter-index x))))

(defn get-query-timeout
  "Retrieves the maximum number of seconds the driver will wait for
   a statement to execute.
   If this limit is exceeded, an SQLException is thrown.

  returns: the current query timeout limit in seconds; zero means
            unlimited - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this]
    (-> this (.getQueryTimeout))))

(defn execute
  "Fills this RowSet object with data.

   The execute method may use the following properties
   to create a connection for reading data: url, data source name,
   user name, password, transaction isolation, and type map.

   The execute method  may use the following properties
   to create a statement to execute a command:
   command, read only, maximum field size,
   maximum rows, escape processing, and query timeout.

   If the required properties have not been set, an exception is
   thrown.  If this method is successful, the current contents of the rowset are
   discarded and the rowset's metadata is also (re)set.  If there are
   outstanding updates, they are ignored.

   If this RowSet object does not maintain a continuous connection
   with its source of data, it may use a reader (a RowSetReader
   object) to fill itself with data.  In this case, a reader will have been
   registered with this RowSet object, and the method
   execute will call on the reader's readData
   method as part of its implementation.

  throws: java.sql.SQLException - if a database access error occurs or any of the properties necessary for making a connection and creating a statement have not been set"
  ([this]
    (-> this (.execute))))

(defn set-character-stream
  "Sets the designated parameter in this RowSet object's command
   to the given java.io.Reader value.
   It may be more practical to send a very large UNICODE value via a
   java.io.Reader rather than as a LONGVARCHAR
   parameter. The driver will read the data from the stream
   as needed until it reaches end-of-file.

   Note: This stream object can either be a standard
   Java stream object or your own subclass that implements the
   standard interface.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  reader - the Reader object that contains the UNICODE data to be set - `java.io.Reader`
  length - the number of characters in the stream - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this parameter-index reader length]
    (-> this (.setCharacterStream parameter-index reader length)))
  ([this parameter-index reader]
    (-> this (.setCharacterStream parameter-index reader))))

(defn get-type-map
  "Retrieves the Map object associated with this
   RowSet object, which specifies the custom mapping
   of SQL user-defined types, if any.  The default is for the
   type map to be empty.

  returns: a java.util.Map object containing the names of
           SQL user-defined types and the Java classes to which they are
           to be mapped - `java.util.Map<java.lang.String,java.lang.Class<?>>`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this]
    (-> this (.getTypeMap))))

(defn get-data-source-name
  "Retrieves the logical name that identifies the data source for this
   RowSet object.

  returns: a data source name - `java.lang.String`"
  ([this]
    (-> this (.getDataSourceName))))

(defn set-data-source-name
  "Sets the data source name property for this RowSet object to the
   given String.

   The value of the data source name property can be used to do a lookup of
   a DataSource object that has been registered with a naming
   service.  After being retrieved, the DataSource object can be
   used to create a connection to the data source that it represents.

  name - the logical name of the data source for this RowSet object; may be null - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this name]
    (-> this (.setDataSourceName name))))

(defn read-only?
  "Retrieves whether this RowSet object is read-only.
   If updates are possible, the default is for a rowset to be
   updatable.

   Attempts to update a read-only rowset will result in an
   SQLException being thrown.

  returns: true if this RowSet object is
           read-only; false if it is updatable - `boolean`"
  ([this]
    (-> this (.isReadOnly))))

(defn set-url
  "Sets the designated parameter to the given java.net.URL value.
   The driver converts this to an SQL DATALINK value
   when it sends it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the java.net.URL object to be set - `java.net.URL`

  throws: java.sql.SQLException - if a database access error occurs or this method is called on a closed PreparedStatement"
  ([this parameter-index x]
    (-> this (.setURL parameter-index x))))

(defn get-escape-processing?
  "Retrieves whether escape processing is enabled for this
   RowSet object.
   If escape scanning is enabled, which is the default, the driver will do
   escape substitution before sending an SQL statement to the database.

  returns: true if escape processing is enabled;
           false if it is disabled - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this]
    (-> this (.getEscapeProcessing))))

(defn set-sqlxml
  "Sets the designated parameter to the given java.sql.SQLXML object. The driver converts this to an
   SQL XML value when it sends it to the database.

  parameter-index - index of the first parameter is 1, the second is 2, ... - `int`
  xml-object - a SQLXML object that maps an SQL XML value - `java.sql.SQLXML`

  throws: java.sql.SQLException - if a database access error occurs, this method is called on a closed result set, the java.xml.transform.Result, Writer or OutputStream has not been closed for the SQLXML object or if there is an error processing the XML value. The getCause method of the exception may provide a more detailed exception, for example, if the stream does not contain valid XML."
  ([this parameter-index xml-object]
    (-> this (.setSQLXML parameter-index xml-object))))

(defn set-float
  "Sets the designated parameter in this RowSet object's command
   to the given Java float value. The driver converts this to
   an SQL REAL value before sending it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `float`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this parameter-index x]
    (-> this (.setFloat parameter-index x))))

(defn set-row-id
  "Sets the designated parameter to the given java.sql.RowId object. The
   driver converts this to a SQL ROWID value when it sends it
   to the database

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `java.sql.RowId`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this parameter-index x]
    (-> this (.setRowId parameter-index x))))

(defn get-password
  "Retrieves the password used to create a database connection.
   The password property is set at run time before calling the method
   execute.  It is not usually part of the serialized state
   of a RowSet object.

  returns: the password for making a database connection - `java.lang.String`"
  ([this]
    (-> this (.getPassword))))

