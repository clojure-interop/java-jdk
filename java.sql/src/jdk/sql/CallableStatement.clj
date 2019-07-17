(ns jdk.sql.CallableStatement
  "The interface used to execute SQL stored procedures.  The JDBC API
  provides a stored procedure SQL escape syntax that allows stored procedures
  to be called in a standard way for all RDBMSs. This escape syntax has one
  form that includes a result parameter and one that does not. If used, the result
  parameter must be registered as an OUT parameter. The other parameters
  can be used for input, output or both. Parameters are referred to
  sequentially, by number, with the first parameter being 1.


    {?= call <procedure-name>[(<arg1>,<arg2>, ...)]}
    {call <procedure-name>[(<arg1>,<arg2>, ...)]}

  IN parameter values are set using the set methods inherited from
  PreparedStatement.  The type of all OUT parameters must be
  registered prior to executing the stored procedure; their values
  are retrieved after execution via the get methods provided here.

  A CallableStatement can return one ResultSet object or
  multiple ResultSet objects.  Multiple
  ResultSet objects are handled using operations
  inherited from Statement.

  For maximum portability, a call's ResultSet objects and
  update counts should be processed prior to getting the values of output
  parameters."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql CallableStatement]))

(defn set-bytes
  "Sets the designated parameter to the given Java array of bytes.
   The driver converts this to an SQL VARBINARY or
   LONGVARBINARY (depending on the argument's size relative
   to the driver's limits on VARBINARY values) when it sends
   it to the database.

  parameter-name - the name of the parameter - `java.lang.String`
  x - the parameter value - `byte[]`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name x]
    (-> this (.setBytes parameter-name x))))

(defn get-n-character-stream
  "Retrieves the value of the designated parameter as a
   java.io.Reader object in the Java programming language.
   It is intended for use when
   accessing  NCHAR,NVARCHAR
   and LONGNVARCHAR parameters.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`

  returns: a java.io.Reader object that contains the parameter
   value; if the value is SQL NULL, the value returned is
   null in the Java programming language. - `java.io.Reader`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getNCharacterStream parameter-index))))

(defn get-sqlxml
  "Retrieves the value of the designated SQL XML parameter as a
   java.sql.SQLXML object in the Java programming language.

  parameter-index - index of the first parameter is 1, the second is 2, ... - `int`

  returns: a SQLXML object that maps an SQL XML value - `java.sql.SQLXML`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getSQLXML parameter-index))))

(defn get-row-id
  "Retrieves the value of the designated JDBC ROWID parameter as a
   java.sql.RowId object.

  parameter-index - the first parameter is 1, the second is 2,... - `int`

  returns: a RowId object that represents the JDBC ROWID
       value is used as the designated parameter. If the parameter contains
   a SQL NULL, then a null value is returned. - `java.sql.RowId`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getRowId parameter-index))))

(defn set-string
  "Sets the designated parameter to the given Java String value.
   The driver converts this
   to an SQL VARCHAR or LONGVARCHAR value
   (depending on the argument's
   size relative to the driver's limits on VARCHAR values)
   when it sends it to the database.

  parameter-name - the name of the parameter - `java.lang.String`
  x - the parameter value - `java.lang.String`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.lang.String x]
    (-> this (.setString parameter-name x))))

(defn get-byte
  "Retrieves the value of the designated JDBC TINYINT parameter
   as a byte in the Java programming language.

  parameter-index - the first parameter is 1, the second is 2, and so on - `int`

  returns: the parameter value.  If the value is SQL NULL, the result
   is 0. - `byte`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getByte parameter-index))))

(defn set-time
  "Sets the designated parameter to the given java.sql.Time value,
   using the given Calendar object.  The driver uses
   the Calendar object to construct an SQL TIME value,
   which the driver then sends to the database.  With a
   a Calendar object, the driver can calculate the time
   taking into account a custom timezone.  If no
   Calendar object is specified, the driver uses the default
   timezone, which is that of the virtual machine running the application.

  parameter-name - the name of the parameter - `java.lang.String`
  x - the parameter value - `java.sql.Time`
  cal - the Calendar object the driver will use to construct the time - `java.util.Calendar`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.sql.Time x ^java.util.Calendar cal]
    (-> this (.setTime parameter-name x cal)))
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.sql.Time x]
    (-> this (.setTime parameter-name x))))

(defn set-timestamp
  "Sets the designated parameter to the given java.sql.Timestamp value,
   using the given Calendar object.  The driver uses
   the Calendar object to construct an SQL TIMESTAMP value,
   which the driver then sends to the database.  With a
   a Calendar object, the driver can calculate the timestamp
   taking into account a custom timezone.  If no
   Calendar object is specified, the driver uses the default
   timezone, which is that of the virtual machine running the application.

  parameter-name - the name of the parameter - `java.lang.String`
  x - the parameter value - `java.sql.Timestamp`
  cal - the Calendar object the driver will use to construct the timestamp - `java.util.Calendar`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.sql.Timestamp x ^java.util.Calendar cal]
    (-> this (.setTimestamp parameter-name x cal)))
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.sql.Timestamp x]
    (-> this (.setTimestamp parameter-name x))))

(defn set-date
  "Sets the designated parameter to the given java.sql.Date value,
   using the given Calendar object.  The driver uses
   the Calendar object to construct an SQL DATE value,
   which the driver then sends to the database.  With a
   a Calendar object, the driver can calculate the date
   taking into account a custom timezone.  If no
   Calendar object is specified, the driver uses the default
   timezone, which is that of the virtual machine running the application.

  parameter-name - the name of the parameter - `java.lang.String`
  x - the parameter value - `java.sql.Date`
  cal - the Calendar object the driver will use to construct the date - `java.util.Calendar`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.sql.Date x ^java.util.Calendar cal]
    (-> this (.setDate parameter-name x cal)))
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.sql.Date x]
    (-> this (.setDate parameter-name x))))

(defn get-ref
  "Retrieves the value of the designated JDBC REF(<structured-type>)
   parameter as a Ref object in the Java programming language.

  parameter-index - the first parameter is 1, the second is 2, and so on - `int`

  returns: the parameter value as a Ref object in the
   Java programming language.  If the value was SQL NULL, the value
   null is returned. - `java.sql.Ref`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getRef parameter-index))))

(defn set-boolean
  "Sets the designated parameter to the given Java boolean value.
   The driver converts this
   to an SQL BIT or BOOLEAN value when it sends it to the database.

  parameter-name - the name of the parameter - `java.lang.String`
  x - the parameter value - `boolean`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^Boolean x]
    (-> this (.setBoolean parameter-name x))))

(defn set-n-character-stream
  "Sets the designated parameter to a Reader object. The
   Reader reads the data till end-of-file is reached. The
   driver does the necessary conversion from Java character format to
   the national character set in the database.

  parameter-name - the name of the parameter to be set - `java.lang.String`
  value - the parameter value - `java.io.Reader`
  length - the number of characters in the parameter data. - `long`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if the driver does not support national character sets; if the driver can detect that a data conversion error could occur; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.io.Reader value ^Long length]
    (-> this (.setNCharacterStream parameter-name value length)))
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.io.Reader value]
    (-> this (.setNCharacterStream parameter-name value))))

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
   parameter, the name is the type name of the referenced type.

   Although it is intended for user-defined and Ref parameters,
   this method may be used to set a null parameter of any JDBC type.
   If the parameter does not have a user-defined or REF type, the given
   typeName is ignored.

  parameter-name - the name of the parameter - `java.lang.String`
  sql-type - a value from java.sql.Types - `int`
  type-name - the fully-qualified name of an SQL user-defined type; ignored if the parameter is not a user-defined type or SQL REF value - `java.lang.String`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^Integer sql-type ^java.lang.String type-name]
    (-> this (.setNull parameter-name sql-type type-name)))
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^Integer sql-type]
    (-> this (.setNull parameter-name sql-type))))

(defn get-n-string
  "Retrieves the value of the designated NCHAR,
   NVARCHAR
   or LONGNVARCHAR parameter as
   a String in the Java programming language.

   For the fixed-length type JDBC NCHAR,
   the String object
   returned has exactly the same value the SQL
   NCHAR value had in the
   database, including any padding added by the database.

  parameter-index - index of the first parameter is 1, the second is 2, ... - `int`

  returns: a String object that maps an
   NCHAR, NVARCHAR or LONGNVARCHAR value - `java.lang.String`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getNString parameter-index))))

(defn set-binary-stream
  "Sets the designated parameter to the given input stream, which will have
   the specified number of bytes.
   When a very large binary value is input to a LONGVARBINARY
   parameter, it may be more practical to send it via a
   java.io.InputStream object. The data will be read from the stream
   as needed until end-of-file is reached.

   Note: This stream object can either be a standard
   Java stream object or your own subclass that implements the
   standard interface.

  parameter-name - the name of the parameter - `java.lang.String`
  x - the java input stream which contains the binary parameter value - `java.io.InputStream`
  length - the number of bytes in the stream - `int`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.io.InputStream x ^Integer length]
    (-> this (.setBinaryStream parameter-name x length)))
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.io.InputStream x]
    (-> this (.setBinaryStream parameter-name x))))

(defn get-string
  "Retrieves the value of the designated JDBC CHAR,
   VARCHAR, or LONGVARCHAR parameter as a
   String in the Java programming language.

   For the fixed-length type JDBC CHAR,
   the String object
   returned has exactly the same value the SQL
   CHAR value had in the
   database, including any padding added by the database.

  parameter-index - the first parameter is 1, the second is 2, and so on - `int`

  returns: the parameter value. If the value is SQL NULL,
           the result
           is null. - `java.lang.String`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getString parameter-index))))

(defn set-blob
  "Sets the designated parameter to a InputStream object.  The inputstream must contain  the number
   of characters specified by length, otherwise a SQLException will be
   generated when the CallableStatement is executed.
   This method differs from the setBinaryStream (int, InputStream, int)
   method because it informs the driver that the parameter value should be
   sent to the server as a BLOB.  When the setBinaryStream method is used,
   the driver may have to do extra work to determine whether the parameter
   data should be sent to the server as a LONGVARBINARY or a BLOB

  parameter-name - the name of the parameter to be set the second is 2, ... - `java.lang.String`
  input-stream - An object that contains the data to set the parameter value to. - `java.io.InputStream`
  length - the number of bytes in the parameter data. - `long`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if the length specified is less than zero; if the number of bytes in the inputstream does not match the specified length; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.io.InputStream input-stream ^Long length]
    (-> this (.setBlob parameter-name input-stream length)))
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.sql.Blob x]
    (-> this (.setBlob parameter-name x))))

(defn get-short
  "Retrieves the value of the designated JDBC SMALLINT parameter
   as a short in the Java programming language.

  parameter-index - the first parameter is 1, the second is 2, and so on - `int`

  returns: the parameter value.  If the value is SQL NULL, the result
   is 0. - `short`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getShort parameter-index))))

(defn set-object
  "Sets the value of the designated parameter with the given object.

   The given Java object will be converted to the given targetSqlType
   before being sent to the database.

   If the object has a custom mapping (is of a class implementing the
   interface SQLData),
   the JDBC driver should call the method SQLData.writeSQL to write it
   to the SQL data stream.
   If, on the other hand, the object is of a class implementing
   Ref, Blob, Clob,  NClob,
    Struct, java.net.URL,
   or Array, the driver should pass it to the database as a
   value of the corresponding SQL type.

   Note that this method may be used to pass datatabase-
   specific abstract data types.

  parameter-name - the name of the parameter - `java.lang.String`
  x - the object containing the input parameter value - `java.lang.Object`
  target-sql-type - the SQL type (as defined in java.sql.Types) to be sent to the database. The scale argument may further qualify this type. - `int`
  scale - for java.sql.Types.DECIMAL or java.sql.Types.NUMERIC types, this is the number of digits after the decimal point. For all other types, this value will be ignored. - `int`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.lang.Object x ^Integer target-sql-type ^Integer scale]
    (-> this (.setObject parameter-name x target-sql-type scale)))
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.lang.Object x ^Integer target-sql-type]
    (-> this (.setObject parameter-name x target-sql-type)))
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.lang.Object x]
    (-> this (.setObject parameter-name x))))

(defn get-timestamp
  "Retrieves the value of the designated JDBC TIMESTAMP parameter as a
   java.sql.Timestamp object, using
   the given Calendar object to construct
   the Timestamp object.
   With a Calendar object, the driver
   can calculate the timestamp taking into account a custom timezone and locale.
   If no Calendar object is specified, the driver uses the
   default timezone and locale.

  parameter-index - the first parameter is 1, the second is 2, and so on - `int`
  cal - the Calendar object the driver will use to construct the timestamp - `java.util.Calendar`

  returns: the parameter value.  If the value is SQL NULL, the result
           is null. - `java.sql.Timestamp`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index ^java.util.Calendar cal]
    (-> this (.getTimestamp parameter-index cal)))
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getTimestamp parameter-index))))

(defn get-object
  "Returns an object representing the value of OUT parameter
   parameterIndex and uses map for the custom
   mapping of the parameter value.

   This method returns a Java object whose type corresponds to the
   JDBC type that was registered for this parameter using the method
   registerOutParameter.  By registering the target
   JDBC type as java.sql.Types.OTHER, this method can
   be used to read database-specific abstract data types.

  parameter-index - the first parameter is 1, the second is 2, and so on - `int`
  map - the mapping from SQL type names to Java classes - `java.util.Map<java.lang.String,java.lang.Class<?>>`

  returns: a java.lang.Object holding the OUT parameter value - `java.lang.Object`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index ^java.util.Map> map]
    (-> this (.getObject parameter-index map)))
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getObject parameter-index))))

(defn get-bytes
  "Retrieves the value of the designated JDBC BINARY or
   VARBINARY parameter as an array of byte
   values in the Java programming language.

  parameter-index - the first parameter is 1, the second is 2, and so on - `int`

  returns: the parameter value.  If the value is SQL NULL, the result
           is null. - `byte[]`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getBytes parameter-index))))

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

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if the length specified is less than zero; if the driver does not support national character sets; if the driver can detect that a data conversion error could occur; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.io.Reader reader ^Long length]
    (-> this (.setNClob parameter-name reader length)))
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.sql.NClob value]
    (-> this (.setNClob parameter-name value))))

(defn get-clob
  "Retrieves the value of the designated JDBC CLOB parameter as a
   java.sql.Clob object in the Java programming language.

  parameter-index - the first parameter is 1, the second is 2, and so on - `int`

  returns: the parameter value as a Clob object in the
   Java programming language.  If the value was SQL NULL, the
   value null is returned. - `java.sql.Clob`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getClob parameter-index))))

(defn get-blob
  "Retrieves the value of the designated JDBC BLOB parameter as a
   Blob object in the Java programming language.

  parameter-index - the first parameter is 1, the second is 2, and so on - `int`

  returns: the parameter value as a Blob object in the
   Java programming language.  If the value was SQL NULL, the value
   null is returned. - `java.sql.Blob`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getBlob parameter-index))))

(defn get-date
  "Retrieves the value of the designated JDBC DATE parameter as a
   java.sql.Date object, using
   the given Calendar object
   to construct the date.
   With a Calendar object, the driver
   can calculate the date taking into account a custom timezone and locale.
   If no Calendar object is specified, the driver uses the
   default timezone and locale.

  parameter-index - the first parameter is 1, the second is 2, and so on - `int`
  cal - the Calendar object the driver will use to construct the date - `java.util.Calendar`

  returns: the parameter value.  If the value is SQL NULL, the result
           is null. - `java.sql.Date`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index ^java.util.Calendar cal]
    (-> this (.getDate parameter-index cal)))
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getDate parameter-index))))

(defn get-character-stream
  "Retrieves the value of the designated parameter as a
   java.io.Reader object in the Java programming language.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`

  returns: a java.io.Reader object that contains the parameter
   value; if the value is SQL NULL, the value returned is
   null in the Java programming language. - `java.io.Reader`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getCharacterStream parameter-index))))

(defn get-long
  "Retrieves the value of the designated JDBC BIGINT parameter
   as a long in the Java programming language.

  parameter-index - the first parameter is 1, the second is 2, and so on - `int`

  returns: the parameter value.  If the value is SQL NULL, the result
   is 0. - `long`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getLong parameter-index))))

(defn set-clob
  "Sets the designated parameter to a Reader object.  The reader must contain  the number
   of characters specified by length otherwise a SQLException will be
   generated when the CallableStatement is executed.
   This method differs from the setCharacterStream (int, Reader, int) method
   because it informs the driver that the parameter value should be sent to
   the server as a CLOB.  When the setCharacterStream method is used, the
   driver may have to do extra work to determine whether the parameter
   data should be send to the server as a LONGVARCHAR or a CLOB

  parameter-name - the name of the parameter to be set - `java.lang.String`
  reader - An object that contains the data to set the parameter value to. - `java.io.Reader`
  length - the number of characters in the parameter data. - `long`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if the length specified is less than zero; a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.io.Reader reader ^Long length]
    (-> this (.setClob parameter-name reader length)))
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.sql.Clob x]
    (-> this (.setClob parameter-name x))))

(defn set-double
  "Sets the designated parameter to the given Java double value.
   The driver converts this
   to an SQL DOUBLE value when it sends it to the database.

  parameter-name - the name of the parameter - `java.lang.String`
  x - the parameter value - `double`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^Double x]
    (-> this (.setDouble parameter-name x))))

(defn get-int
  "Retrieves the value of the designated JDBC INTEGER parameter
   as an int in the Java programming language.

  parameter-index - the first parameter is 1, the second is 2, and so on - `int`

  returns: the parameter value.  If the value is SQL NULL, the result
   is 0. - `int`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getInt parameter-index))))

(defn register-out-parameter
  "Registers the parameter in ordinal position
   parameterIndex to be of JDBC type
   sqlType. All OUT parameters must be registered
   before a stored procedure is executed.

   The JDBC type specified by sqlType for an OUT
   parameter determines the Java type that must be used
   in the get method to read the value of that parameter.

   This version of registerOutParameter should be
   used when the parameter is of JDBC type NUMERIC
   or DECIMAL.

  parameter-index - the first parameter is 1, the second is 2, and so on - `int`
  sql-type - the SQL type code defined by java.sql.Types. - `int`
  scale - the desired number of digits to the right of the decimal point. It must be greater than or equal to zero. - `int`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index ^Integer sql-type ^Integer scale]
    (-> this (.registerOutParameter parameter-index sql-type scale)))
  ([^java.sql.CallableStatement this ^Integer parameter-index ^Integer sql-type]
    (-> this (.registerOutParameter parameter-index sql-type))))

(defn set-long
  "Sets the designated parameter to the given Java long value.
   The driver converts this
   to an SQL BIGINT value when it sends it to the database.

  parameter-name - the name of the parameter - `java.lang.String`
  x - the parameter value - `long`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^Long x]
    (-> this (.setLong parameter-name x))))

(defn get-array
  "Retrieves the value of the designated JDBC ARRAY parameter as an
   Array object in the Java programming language.

  parameter-index - the first parameter is 1, the second is 2, and so on - `int`

  returns: the parameter value as an Array object in
   the Java programming language.  If the value was SQL NULL, the
   value null is returned. - `java.sql.Array`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getArray parameter-index))))

(defn was-null
  "Retrieves whether the last OUT parameter read had the value of
   SQL NULL.  Note that this method should be called only after
   calling a getter method; otherwise, there is no value to use in
   determining whether it is null or not.

  returns: true if the last parameter read was SQL
   NULL; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this]
    (-> this (.wasNull))))

(defn set-byte
  "Sets the designated parameter to the given Java byte value.
   The driver converts this
   to an SQL TINYINT value when it sends it to the database.

  parameter-name - the name of the parameter - `java.lang.String`
  x - the parameter value - `byte`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^Byte x]
    (-> this (.setByte parameter-name x))))

(defn set-n-string
  "Sets the designated parameter to the given String object.
   The driver converts this to a SQL NCHAR or
   NVARCHAR or LONGNVARCHAR

  parameter-name - the name of the parameter to be set - `java.lang.String`
  value - the parameter value - `java.lang.String`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if the driver does not support national character sets; if the driver can detect that a data conversion error could occur; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.lang.String value]
    (-> this (.setNString parameter-name value))))

(defn set-short
  "Sets the designated parameter to the given Java short value.
   The driver converts this
   to an SQL SMALLINT value when it sends it to the database.

  parameter-name - the name of the parameter - `java.lang.String`
  x - the parameter value - `short`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^Short x]
    (-> this (.setShort parameter-name x))))

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

  parameter-name - the name of the parameter - `java.lang.String`
  x - the Java input stream that contains the ASCII parameter value - `java.io.InputStream`
  length - the number of bytes in the stream - `int`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.io.InputStream x ^Integer length]
    (-> this (.setAsciiStream parameter-name x length)))
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.io.InputStream x]
    (-> this (.setAsciiStream parameter-name x))))

(defn set-big-decimal
  "Sets the designated parameter to the given
   java.math.BigDecimal value.
   The driver converts this to an SQL NUMERIC value when
   it sends it to the database.

  parameter-name - the name of the parameter - `java.lang.String`
  x - the parameter value - `java.math.BigDecimal`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.math.BigDecimal x]
    (-> this (.setBigDecimal parameter-name x))))

(defn set-int
  "Sets the designated parameter to the given Java int value.
   The driver converts this
   to an SQL INTEGER value when it sends it to the database.

  parameter-name - the name of the parameter - `java.lang.String`
  x - the parameter value - `int`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^Integer x]
    (-> this (.setInt parameter-name x))))

(defn get-url
  "Retrieves the value of the designated JDBC DATALINK parameter as a
   java.net.URL object.

  parameter-index - the first parameter is 1, the second is 2,... - `int`

  returns: a java.net.URL object that represents the
           JDBC DATALINK value used as the designated
           parameter - `java.net.URL`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs, this method is called on a closed CallableStatement, or if the URL being returned is not a valid URL on the Java platform"
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getURL parameter-index))))

(defn get-boolean?
  "Retrieves the value of the designated JDBC BIT
   or BOOLEAN parameter as a
   boolean in the Java programming language.

  parameter-index - the first parameter is 1, the second is 2, and so on - `int`

  returns: the parameter value.  If the value is SQL NULL,
           the result is false. - `boolean`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getBoolean parameter-index))))

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

  parameter-name - the name of the parameter - `java.lang.String`
  reader - the java.io.Reader object that contains the UNICODE data used as the designated parameter - `java.io.Reader`
  length - the number of characters in the stream - `int`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.io.Reader reader ^Integer length]
    (-> this (.setCharacterStream parameter-name reader length)))
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.io.Reader reader]
    (-> this (.setCharacterStream parameter-name reader))))

(defn get-n-clob
  "Retrieves the value of the designated JDBC NCLOB parameter as a
   java.sql.NClob object in the Java programming language.

  parameter-index - the first parameter is 1, the second is 2, and so on - `int`

  returns: the parameter value as a NClob object in the
   Java programming language.  If the value was SQL NULL, the
   value null is returned. - `java.sql.NClob`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if the driver does not support national character sets; if the driver can detect that a data conversion error could occur; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getNClob parameter-index))))

(defn set-url
  "Sets the designated parameter to the given java.net.URL object.
   The driver converts this to an SQL DATALINK value when
   it sends it to the database.

  parameter-name - the name of the parameter - `java.lang.String`
  val - the parameter value - `java.net.URL`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs; this method is called on a closed CallableStatement or if a URL is malformed"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.net.URL val]
    (-> this (.setURL parameter-name val))))

(defn get-float
  "Retrieves the value of the designated JDBC FLOAT parameter
   as a float in the Java programming language.

  parameter-index - the first parameter is 1, the second is 2, and so on - `int`

  returns: the parameter value.  If the value is SQL NULL, the result
           is 0. - `float`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getFloat parameter-index))))

(defn get-time
  "Retrieves the value of the designated JDBC TIME parameter as a
   java.sql.Time object, using
   the given Calendar object
   to construct the time.
   With a Calendar object, the driver
   can calculate the time taking into account a custom timezone and locale.
   If no Calendar object is specified, the driver uses the
   default timezone and locale.

  parameter-index - the first parameter is 1, the second is 2, and so on - `int`
  cal - the Calendar object the driver will use to construct the time - `java.util.Calendar`

  returns: the parameter value; if the value is SQL NULL, the result
           is null. - `java.sql.Time`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index ^java.util.Calendar cal]
    (-> this (.getTime parameter-index cal)))
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getTime parameter-index))))

(defn get-double
  "Retrieves the value of the designated JDBC DOUBLE parameter as a double
   in the Java programming language.

  parameter-index - the first parameter is 1, the second is 2, and so on - `int`

  returns: the parameter value.  If the value is SQL NULL, the result
           is 0. - `double`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getDouble parameter-index))))

(defn set-sqlxml
  "Sets the designated parameter to the given java.sql.SQLXML object. The driver converts this to an
   SQL XML value when it sends it to the database.

  parameter-name - the name of the parameter - `java.lang.String`
  xml-object - a SQLXML object that maps an SQL XML value - `java.sql.SQLXML`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs; this method is called on a closed CallableStatement or the java.xml.transform.Result, Writer or OutputStream has not been closed for the SQLXML object"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.sql.SQLXML xml-object]
    (-> this (.setSQLXML parameter-name xml-object))))

(defn get-big-decimal
  "Deprecated. use getBigDecimal(int parameterIndex)
               or getBigDecimal(String parameterName)

  parameter-index - the first parameter is 1, the second is 2, and so on - `int`
  scale - the number of digits to the right of the decimal point - `int`

  returns: the parameter value.  If the value is SQL NULL, the result
           is null. - `java.lang..math.BigDecimal`

  throws: java.sql.SQLException - if the parameterIndex is not valid; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^Integer parameter-index ^Integer scale]
    (-> this (.getBigDecimal parameter-index scale)))
  ([^java.sql.CallableStatement this ^Integer parameter-index]
    (-> this (.getBigDecimal parameter-index))))

(defn set-float
  "Sets the designated parameter to the given Java float value.
   The driver converts this
   to an SQL FLOAT value when it sends it to the database.

  parameter-name - the name of the parameter - `java.lang.String`
  x - the parameter value - `float`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^Float x]
    (-> this (.setFloat parameter-name x))))

(defn set-row-id
  "Sets the designated parameter to the given java.sql.RowId object. The
   driver converts this to a SQL ROWID when it sends it to the
   database.

  parameter-name - the name of the parameter - `java.lang.String`
  x - the parameter value - `java.sql.RowId`

  throws: java.sql.SQLException - if parameterName does not correspond to a named parameter; if a database access error occurs or this method is called on a closed CallableStatement"
  ([^java.sql.CallableStatement this ^java.lang.String parameter-name ^java.sql.RowId x]
    (-> this (.setRowId parameter-name x))))

