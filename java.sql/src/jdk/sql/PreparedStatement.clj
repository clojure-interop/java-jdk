(ns jdk.sql.PreparedStatement
  "An object that represents a precompiled SQL statement.
  A SQL statement is precompiled and stored in a
  PreparedStatement object. This object can then be used to
  efficiently execute this statement multiple times.

  Note: The setter methods (setShort, setString,
  and so on) for setting IN parameter values
  must specify types that are compatible with the defined SQL type of
  the input parameter. For instance, if the IN parameter has SQL type
  INTEGER, then the method setInt should be used.

  If arbitrary parameter type conversions are required, the method
  setObject should be used with a target SQL type.

  In the following example of setting a parameter, con represents
  an active connection:


    PreparedStatement pstmt = con.prepareStatement(`UPDATE EMPLOYEES
                                      SET SALARY = ? WHERE ID = ?`);
    pstmt.setBigDecimal(1, 153833.00)
    pstmt.setInt(2, 110592)"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql PreparedStatement]))

(defn set-bytes
  "Sets the designated parameter to the given Java array of bytes.  The driver converts
   this to an SQL VARBINARY or LONGVARBINARY
   (depending on the argument's size relative to the driver's limits on
   VARBINARY values) when it sends it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `byte[]`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index x]
    (-> this (.setBytes parameter-index x))))

(defn execute-large-update
  "Executes the SQL statement in this PreparedStatement object,
   which must be an SQL Data Manipulation Language (DML) statement,
   such as INSERT, UPDATE or
   DELETE; or an SQL statement that returns nothing,
   such as a DDL statement.

   This method should be used when the returned row count may exceed
   Integer.MAX_VALUE.

   The default implementation will throw UnsupportedOperationException

  returns: either (1) the row count for SQL Data Manipulation Language
   (DML) statements or (2) 0 for SQL statements that return nothing - `default long`

  throws: java.sql.SQLException - if a database access error occurs; this method is called on a closed PreparedStatement or the SQL statement returns a ResultSet object"
  ([^java.sql.PreparedStatement this]
    (-> this (.executeLargeUpdate))))

(defn set-string
  "Sets the designated parameter to the given Java String value.
   The driver converts this
   to an SQL VARCHAR or LONGVARCHAR value
   (depending on the argument's
   size relative to the driver's limits on VARCHAR values)
   when it sends it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `java.lang.String`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.lang.String x]
    (-> this (.setString parameter-index x))))

(defn set-array
  "Sets the designated parameter to the given java.sql.Array object.
   The driver converts this to an SQL ARRAY value when it
   sends it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - an Array object that maps an SQL ARRAY value - `java.sql.Array`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.sql.Array x]
    (-> this (.setArray parameter-index x))))

(defn set-time
  "Sets the designated parameter to the given java.sql.Time value,
   using the given Calendar object.  The driver uses
   the Calendar object to construct an SQL TIME value,
   which the driver then sends to the database.  With
   a Calendar object, the driver can calculate the time
   taking into account a custom timezone.  If no
   Calendar object is specified, the driver uses the default
   timezone, which is that of the virtual machine running the application.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `java.sql.Time`
  cal - the Calendar object the driver will use to construct the time - `java.util.Calendar`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.sql.Time x ^java.util.Calendar cal]
    (-> this (.setTime parameter-index x cal)))
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.sql.Time x]
    (-> this (.setTime parameter-index x))))

(defn set-timestamp
  "Sets the designated parameter to the given java.sql.Timestamp value,
   using the given Calendar object.  The driver uses
   the Calendar object to construct an SQL TIMESTAMP value,
   which the driver then sends to the database.  With a
    Calendar object, the driver can calculate the timestamp
   taking into account a custom timezone.  If no
   Calendar object is specified, the driver uses the default
   timezone, which is that of the virtual machine running the application.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `java.sql.Timestamp`
  cal - the Calendar object the driver will use to construct the timestamp - `java.util.Calendar`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.sql.Timestamp x ^java.util.Calendar cal]
    (-> this (.setTimestamp parameter-index x cal)))
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.sql.Timestamp x]
    (-> this (.setTimestamp parameter-index x))))

(defn set-date
  "Sets the designated parameter to the given java.sql.Date value,
   using the given Calendar object.  The driver uses
   the Calendar object to construct an SQL DATE value,
   which the driver then sends to the database.  With
   a Calendar object, the driver can calculate the date
   taking into account a custom timezone.  If no
   Calendar object is specified, the driver uses the default
   timezone, which is that of the virtual machine running the application.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `java.sql.Date`
  cal - the Calendar object the driver will use to construct the date - `java.util.Calendar`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.sql.Date x ^java.util.Calendar cal]
    (-> this (.setDate parameter-index x cal)))
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.sql.Date x]
    (-> this (.setDate parameter-index x))))

(defn set-boolean
  "Sets the designated parameter to the given Java boolean value.
   The driver converts this
   to an SQL BIT or BOOLEAN value when it sends it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `boolean`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^Boolean x]
    (-> this (.setBoolean parameter-index x))))

(defn set-n-character-stream
  "Sets the designated parameter to a Reader object. The
   Reader reads the data till end-of-file is reached. The
   driver does the necessary conversion from Java character format to
   the national character set in the database.

  parameter-index - of the first parameter is 1, the second is 2, ... - `int`
  value - the parameter value - `java.io.Reader`
  length - the number of characters in the parameter data. - `long`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if the driver does not support national character sets; if the driver can detect that a data conversion error could occur; if a database access error occurs; or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.io.Reader value ^Long length]
    (-> this (.setNCharacterStream parameter-index value length)))
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.io.Reader value]
    (-> this (.setNCharacterStream parameter-index value))))

(defn set-null
  "Sets the designated parameter to SQL NULL.
   This version of the method setNull should
   be used for user-defined types and REF type parameters.  Examples
   of user-defined types include: STRUCT, DISTINCT, JAVA_OBJECT, and
   named array types.

   Note: To be portable, applications must give the
   SQL type code and the fully-qualified SQL type name when specifying
   a NULL user-defined or REF parameter.  In the case of a user-defined type
   the name is the type name of the parameter itself.  For a REF
   parameter, the name is the type name of the referenced type.  If
   a JDBC driver does not need the type code or type name information,
   it may ignore it.

   Although it is intended for user-defined and Ref parameters,
   this method may be used to set a null parameter of any JDBC type.
   If the parameter does not have a user-defined or REF type, the given
   typeName is ignored.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  sql-type - a value from java.sql.Types - `int`
  type-name - the fully-qualified name of an SQL user-defined type; ignored if the parameter is not a user-defined type or REF - `java.lang.String`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^Integer sql-type ^java.lang.String type-name]
    (-> this (.setNull parameter-index sql-type type-name)))
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^Integer sql-type]
    (-> this (.setNull parameter-index sql-type))))

(defn set-binary-stream
  "Sets the designated parameter to the given input stream, which will have
   the specified number of bytes.
   When a very large binary value is input to a LONGVARBINARY
   parameter, it may be more practical to send it via a
   java.io.InputStream object. The data will be read from the
   stream as needed until end-of-file is reached.

   Note: This stream object can either be a standard
   Java stream object or your own subclass that implements the
   standard interface.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the java input stream which contains the binary parameter value - `java.io.InputStream`
  length - the number of bytes in the stream - `int`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.io.InputStream x ^Integer length]
    (-> this (.setBinaryStream parameter-index x length)))
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.io.InputStream x]
    (-> this (.setBinaryStream parameter-index x))))

(defn add-batch
  "Adds a set of parameters to this PreparedStatement
   object's batch of commands.

  throws: java.sql.SQLException - if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this]
    (-> this (.addBatch))))

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

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs; this method is called on a closed PreparedStatement; if the length specified is less than zero or if the number of bytes in the inputstream does not match the specified length."
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.io.InputStream input-stream ^Long length]
    (-> this (.setBlob parameter-index input-stream length)))
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.sql.Blob x]
    (-> this (.setBlob parameter-index x))))

(defn set-object
  "Sets the value of the designated parameter with the given object.

   If the second argument is an InputStream then the stream must contain
   the number of bytes specified by scaleOrLength.  If the second argument is a
   Reader then the reader must contain the number of characters specified
   by scaleOrLength. If these conditions are not true the driver will generate a
   SQLException when the prepared statement is executed.

   The given Java object will be converted to the given targetSqlType
   before being sent to the database.

   If the object has a custom mapping (is of a class implementing the
   interface SQLData),
   the JDBC driver should call the method SQLData.writeSQL to
   write it to the SQL data stream.
   If, on the other hand, the object is of a class implementing
   Ref, Blob, Clob,  NClob,
    Struct, java.net.URL,
   or Array, the driver should pass it to the database as a
   value of the corresponding SQL type.

   Note that this method may be used to pass database-specific
   abstract data types.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the object containing the input parameter value - `java.lang.Object`
  target-sql-type - the SQL type (as defined in java.sql.Types) to be sent to the database. The scale argument may further qualify this type. - `int`
  scale-or-length - for java.sql.Types.DECIMAL or java.sql.Types.NUMERIC types, this is the number of digits after the decimal point. For Java Object types InputStream and Reader, this is the length of the data in the stream or reader. For all other types, this value will be ignored. - `int`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs; this method is called on a closed PreparedStatement or if the Java Object specified by x is an InputStream or Reader object and the value of the scale parameter is less than zero"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.lang.Object x ^Integer target-sql-type ^Integer scale-or-length]
    (-> this (.setObject parameter-index x target-sql-type scale-or-length)))
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.lang.Object x ^Integer target-sql-type]
    (-> this (.setObject parameter-index x target-sql-type)))
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.lang.Object x]
    (-> this (.setObject parameter-index x))))

(defn clear-parameters
  "Clears the current parameter values immediately.
   In general, parameter values remain in force for repeated use of a
   statement. Setting a parameter value automatically clears its
   previous value.  However, in some cases it is useful to immediately
   release the resources used by the current parameter values; this can
   be done by calling the method clearParameters.

  throws: java.sql.SQLException - if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this]
    (-> this (.clearParameters))))

(defn set-n-clob
  "Sets the designated parameter to a Reader object.  The reader must contain  the number
   of characters specified by length otherwise a SQLException will be
   generated when the PreparedStatement is executed.
   This method differs from the setCharacterStream (int, Reader, int) method
   because it informs the driver that the parameter value should be sent to
   the server as a NCLOB.  When the setCharacterStream method is used, the
   driver may have to do extra work to determine whether the parameter
   data should be sent to the server as a LONGNVARCHAR or a NCLOB

  parameter-index - index of the first parameter is 1, the second is 2, ... - `int`
  reader - An object that contains the data to set the parameter value to. - `java.io.Reader`
  length - the number of characters in the parameter data. - `long`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if the length specified is less than zero; if the driver does not support national character sets; if the driver can detect that a data conversion error could occur; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.io.Reader reader ^Long length]
    (-> this (.setNClob parameter-index reader length)))
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.sql.NClob value]
    (-> this (.setNClob parameter-index value))))

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

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs; this method is called on a closed PreparedStatement or if the length specified is less than zero."
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.io.Reader reader ^Long length]
    (-> this (.setClob parameter-index reader length)))
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.sql.Clob x]
    (-> this (.setClob parameter-index x))))

(defn set-double
  "Sets the designated parameter to the given Java double value.
   The driver converts this
   to an SQL DOUBLE value when it sends it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `double`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^Double x]
    (-> this (.setDouble parameter-index x))))

(defn set-ref
  "Sets the designated parameter to the given
    REF(<structured-type>) value.
   The driver converts this to an SQL REF value when it
   sends it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - an SQL REF value - `java.sql.Ref`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.sql.Ref x]
    (-> this (.setRef parameter-index x))))

(defn set-long
  "Sets the designated parameter to the given Java long value.
   The driver converts this
   to an SQL BIGINT value when it sends it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `long`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^Long x]
    (-> this (.setLong parameter-index x))))

(defn get-meta-data
  "Retrieves a ResultSetMetaData object that contains
   information about the columns of the ResultSet object
   that will be returned when this PreparedStatement object
   is executed.

   Because a PreparedStatement object is precompiled, it is
   possible to know about the ResultSet object that it will
   return without having to execute it.  Consequently, it is possible
   to invoke the method getMetaData on a
   PreparedStatement object rather than waiting to execute
   it and then invoking the ResultSet.getMetaData method
   on the ResultSet object that is returned.

   NOTE: Using this method may be expensive for some drivers due
   to the lack of underlying DBMS support.

  returns: the description of a ResultSet object's columns or
           null if the driver cannot return a
           ResultSetMetaData object - `java.sql.ResultSetMetaData`

  throws: java.sql.SQLException - if a database access error occurs or this method is called on a closed PreparedStatement"
  (^java.sql.ResultSetMetaData [^java.sql.PreparedStatement this]
    (-> this (.getMetaData))))

(defn set-byte
  "Sets the designated parameter to the given Java byte value.
   The driver converts this
   to an SQL TINYINT value when it sends it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `byte`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^Byte x]
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

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if the driver does not support national character sets; if the driver can detect that a data conversion error could occur; if a database access error occurs; or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.lang.String value]
    (-> this (.setNString parameter-index value))))

(defn set-short
  "Sets the designated parameter to the given Java short value.
   The driver converts this
   to an SQL SMALLINT value when it sends it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `short`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^Short x]
    (-> this (.setShort parameter-index x))))

(defn set-ascii-stream
  "Sets the designated parameter to the given input stream, which will have
   the specified number of bytes.
   When a very large ASCII value is input to a LONGVARCHAR
   parameter, it may be more practical to send it via a
   java.io.InputStream. Data will be read from the stream
   as needed until end-of-file is reached.  The JDBC driver will
   do any necessary conversion from ASCII to the database char format.

   Note: This stream object can either be a standard
   Java stream object or your own subclass that implements the
   standard interface.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the Java input stream that contains the ASCII parameter value - `java.io.InputStream`
  length - the number of bytes in the stream - `int`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.io.InputStream x ^Integer length]
    (-> this (.setAsciiStream parameter-index x length)))
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.io.InputStream x]
    (-> this (.setAsciiStream parameter-index x))))

(defn set-big-decimal
  "Sets the designated parameter to the given java.math.BigDecimal value.
   The driver converts this to an SQL NUMERIC value when
   it sends it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `java.math.BigDecimal`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.math.BigDecimal x]
    (-> this (.setBigDecimal parameter-index x))))

(defn set-int
  "Sets the designated parameter to the given Java int value.
   The driver converts this
   to an SQL INTEGER value when it sends it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `int`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^Integer x]
    (-> this (.setInt parameter-index x))))

(defn execute
  "Executes the SQL statement in this PreparedStatement object,
   which may be any kind of SQL statement.
   Some prepared statements return multiple results; the execute
   method handles these complex statements as well as the simpler
   form of statements handled by the methods executeQuery
   and executeUpdate.

   The execute method returns a boolean to
   indicate the form of the first result.  You must call either the method
   getResultSet or getUpdateCount
   to retrieve the result; you must call getMoreResults to
   move to any subsequent result(s).

  returns: true if the first result is a ResultSet
           object; false if the first result is an update
           count or there is no result - `boolean`

  throws: java.sql.SQLException - if a database access error occurs; this method is called on a closed PreparedStatement or an argument is supplied to this method"
  (^Boolean [^java.sql.PreparedStatement this]
    (-> this (.execute))))

(defn set-character-stream
  "Sets the designated parameter to the given Reader
   object, which is the given number of characters long.
   When a very large UNICODE value is input to a LONGVARCHAR
   parameter, it may be more practical to send it via a
   java.io.Reader object. The data will be read from the stream
   as needed until end-of-file is reached.  The JDBC driver will
   do any necessary conversion from UNICODE to the database char format.

   Note: This stream object can either be a standard
   Java stream object or your own subclass that implements the
   standard interface.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  reader - the java.io.Reader object that contains the Unicode data - `java.io.Reader`
  length - the number of characters in the stream - `int`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.io.Reader reader ^Integer length]
    (-> this (.setCharacterStream parameter-index reader length)))
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.io.Reader reader]
    (-> this (.setCharacterStream parameter-index reader))))

(defn set-url
  "Sets the designated parameter to the given java.net.URL value.
   The driver converts this to an SQL DATALINK value
   when it sends it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the java.net.URL object to be set - `java.net.URL`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.net.URL x]
    (-> this (.setURL parameter-index x))))

(defn get-parameter-meta-data
  "Retrieves the number, types and properties of this
   PreparedStatement object's parameters.

  returns: a ParameterMetaData object that contains information
           about the number, types and properties for each
    parameter marker of this PreparedStatement object - `java.sql.ParameterMetaData`

  throws: java.sql.SQLException - if a database access error occurs or this method is called on a closed PreparedStatement"
  (^java.sql.ParameterMetaData [^java.sql.PreparedStatement this]
    (-> this (.getParameterMetaData))))

(defn set-unicode-stream
  "Deprecated. Use setCharacterStream

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - a java.io.InputStream object that contains the Unicode parameter value - `java.io.InputStream`
  length - the number of bytes in the stream - `int`

  returns: `java.lang. void`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.io.InputStream x ^Integer length]
    (-> this (.setUnicodeStream parameter-index x length))))

(defn execute-update
  "Executes the SQL statement in this PreparedStatement object,
   which must be an SQL Data Manipulation Language (DML) statement, such as INSERT, UPDATE or
   DELETE; or an SQL statement that returns nothing,
   such as a DDL statement.

  returns: either (1) the row count for SQL Data Manipulation Language (DML) statements
           or (2) 0 for SQL statements that return nothing - `int`

  throws: java.sql.SQLException - if a database access error occurs; this method is called on a closed PreparedStatement or the SQL statement returns a ResultSet object"
  (^Integer [^java.sql.PreparedStatement this]
    (-> this (.executeUpdate))))

(defn execute-query
  "Executes the SQL query in this PreparedStatement object
   and returns the ResultSet object generated by the query.

  returns: a ResultSet object that contains the data produced by the
           query; never null - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs; this method is called on a closed PreparedStatement or the SQL statement does not return a ResultSet object"
  (^java.sql.ResultSet [^java.sql.PreparedStatement this]
    (-> this (.executeQuery))))

(defn set-sqlxml
  "Sets the designated parameter to the given java.sql.SQLXML object.
   The driver converts this to an
   SQL XML value when it sends it to the database.

  parameter-index - index of the first parameter is 1, the second is 2, ... - `int`
  xml-object - a SQLXML object that maps an SQL XML value - `java.sql.SQLXML`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs; this method is called on a closed PreparedStatement or the java.xml.transform.Result, Writer or OutputStream has not been closed for the SQLXML object"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.sql.SQLXML xml-object]
    (-> this (.setSQLXML parameter-index xml-object))))

(defn set-float
  "Sets the designated parameter to the given Java float value.
   The driver converts this
   to an SQL REAL value when it sends it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `float`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^Float x]
    (-> this (.setFloat parameter-index x))))

(defn set-row-id
  "Sets the designated parameter to the given java.sql.RowId object. The
   driver converts this to a SQL ROWID value when it sends it
   to the database

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `java.sql.RowId`

  throws: java.sql.SQLException - if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^java.sql.PreparedStatement this ^Integer parameter-index ^java.sql.RowId x]
    (-> this (.setRowId parameter-index x))))

