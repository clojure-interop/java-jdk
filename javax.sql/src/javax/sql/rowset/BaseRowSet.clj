(ns javax.sql.rowset.BaseRowSet
  "An abstract class providing a RowSet object with its basic functionality.
  The basic functions include having properties and sending event notifications,
  which all JavaBeans™ components must implement.

  1.0 Overview
  The BaseRowSet class provides the core functionality
  for all RowSet implementations,
  and all standard implementations may use this class in combination with
  one or more RowSet interfaces in order to provide a standard
  vendor-specific implementation.  To clarify, all implementations must implement
  at least one of the RowSet interfaces (JdbcRowSet,
  CachedRowSet, JoinRowSet, FilteredRowSet,
  or WebRowSet). This means that any implementation that extends
  the BaseRowSet class must also implement one of the RowSet
  interfaces.

  The BaseRowSet class provides the following:


  Properties

      Fields for storing current properties
      Methods for getting and setting properties


  Event notification

  A complete set of setter methods for setting the parameters in a
       RowSet object's command

   Streams

   Fields for storing stream instances
   Constants for indicating the type of a stream




  2.0 Setting Properties
  All rowsets maintain a set of properties, which will usually be set using
  a tool.  The number and kinds of properties a rowset has will vary,
  depending on what the RowSet implementation does and how it gets
  its data.  For example,
  rowsets that get their data from a ResultSet object need to
  set the properties that are required for making a database connection.
  If a RowSet object uses the DriverManager facility to make a
  connection, it needs to set a property for the JDBC URL that identifies the
  appropriate driver, and it needs to set the properties that give the
  user name and password.
  If, on the other hand, the rowset uses a DataSource object
  to make the connection, which is the preferred method, it does not need to
  set the property for the JDBC URL.  Instead, it needs to set the property
  for the logical name of the data source along with the properties for
  the user name and password.

  NOTE:  In order to use a DataSource object for making a
  connection, the DataSource object must have been registered
  with a naming service that uses the Java Naming and Directory
  Interface™ (JNDI) API.  This registration
  is usually done by a person acting in the capacity of a system administrator.

  3.0 Setting the Command and Its Parameters
  When a rowset gets its data from a relational database, it executes a command (a query)
  that produces a ResultSet object.  This query is the command that is set
  for the RowSet object's command property.  The rowset populates itself with data by reading the
  data from the ResultSet object into itself. If the query
  contains placeholders for values to be set, the BaseRowSet setter methods
  are used to set these values. All setter methods allow these values to be set
  to null if required.

  The following code fragment illustrates how the
  CachedRowSet™
  object crs might have its command property set.  Note that if a
  tool is used to set properties, this is the code that the tool would use.


     crs.setCommand(`SELECT FIRST_NAME, LAST_NAME, ADDRESS FROM CUSTOMERS`
                    `WHERE CREDIT_LIMIT > ? AND REGION = ?`);

  In this example, the values for CREDIT_LIMIT and
  REGION are placeholder parameters, which are indicated with a
  question mark (?).  The first question mark is placeholder parameter number
  1, the second question mark is placeholder parameter number
  2, and so on.  Any placeholder parameters must be set with
  values before the query can be executed. To set these
  placeholder parameters, the BaseRowSet class provides a set of setter
  methods, similar to those provided by the PreparedStatement
  interface, for setting values of each data type.  A RowSet object stores the
  parameter values internally, and its execute method uses them internally
  to set values for the placeholder parameters
  before it sends the command to the DBMS to be executed.

  The following code fragment demonstrates
  setting the two parameters in the query from the previous example.


     crs.setInt(1, 5000);
     crs.setString(2, `West`);
  If the execute method is called at this point, the query
  sent to the DBMS will be:


     `SELECT FIRST_NAME, LAST_NAME, ADDRESS FROM CUSTOMERS`
                    `WHERE CREDIT_LIMIT > 5000 AND REGION = 'West'`
  NOTE: Setting Array, Clob, Blob and
  Ref objects as a command parameter, stores these values as
  SerialArray, SerialClob, SerialBlob
  and SerialRef objects respectively.

  4.0 Handling of Parameters Behind the Scenes

  NOTE: The BaseRowSet class provides two kinds of setter methods,
  those that set properties and those that set placeholder parameters. The setter
  methods discussed in this section are those that set placeholder parameters.

  The placeholder parameters set with the BaseRowSet setter methods
  are stored as objects in an internal Hashtable object.
  Primitives are stored as their Object type. For example, byte
  is stored as Byte object, and int is stored as
  an Integer object.
  When the method execute is called, the values in the
  Hashtable object are substituted for the appropriate placeholder
  parameters in the command.

  A call to the method getParams returns the values stored in the
  Hashtable object as an array of Object instances.
  An element in this array may be a simple Object instance or an
  array (which is a type of Object). The particular setter method used
  determines whether an element in this array is an Object or an array.

  The majority of methods for setting placeholder parameters take two parameters,
   with the first parameter
  indicating which placeholder parameter is to be set, and the second parameter
  giving the value to be set.  Methods such as setInt,
  setString, setBoolean, and setLong fall into
  this category.  After these methods have been called, a call to the method
  getParams will return an array with the values that have been set. Each
  element in the array is an Object instance representing the
  values that have been set. The order of these values in the array is determined by the
  int (the first parameter) passed to the setter method. The values in the
  array are the values (the second parameter) passed to the setter method.
  In other words, the first element in the array is the value
  to be set for the first placeholder parameter in the RowSet object's
  command. The second element is the value to
  be set for the second placeholder parameter, and so on.

  Several setter methods send the driver and DBMS information beyond the value to be set.
  When the method getParams is called after one of these setter methods has
  been used, the elements in the array will themselves be arrays to accommodate the
  additional information. In this category, the method setNull is a special case
  because one version takes only
  two parameters (setNull(int parameterIndex, int SqlType)). Nevertheless,
  it requires
  an array to contain the information that will be passed to the driver and DBMS.  The first
  element in this array is the value to be set, which is null, and the
  second element is the int supplied for sqlType, which
  indicates the type of SQL value that is being set to null. This information
  is needed by some DBMSs and is therefore required in order to ensure that applications
  are portable.
  The other version is intended to be used when the value to be set to null
  is a user-defined type. It takes three parameters
  (setNull(int parameterIndex, int sqlType, String typeName)) and also
  requires an array to contain the information to be passed to the driver and DBMS.
  The first two elements in this array are the same as for the first version of
  setNull.  The third element, typeName, gives the SQL name of
  the user-defined type. As is true with the other setter methods, the number of the
  placeholder parameter to be set is indicated by an element's position in the array
  returned by getParams.  So, for example, if the parameter
  supplied to setNull is 2, the second element in the array
  returned by getParams will be an array of two or three elements.

  Some methods, such as setObject and setDate have versions
  that take more than two parameters, with the extra parameters giving information
  to the driver or the DBMS. For example, the methods setDate,
  setTime, and setTimestamp can take a Calendar
  object as their third parameter.  If the DBMS does not store time zone information,
  the driver uses the Calendar object to construct the Date,
  Time, or Timestamp object being set. As is true with other
  methods that provide additional information, the element in the array returned
  by getParams is an array instead of a simple Object instance.

  The methods setAsciiStream, setBinaryStream,
  setCharacterStream, and setUnicodeStream (which is
  deprecated, so applications should use getCharacterStream instead)
  take three parameters, so for them, the element in the array returned by
  getParams is also an array.  What is different about these setter
  methods is that in addition to the information provided by parameters, the array contains
  one of the BaseRowSet constants indicating the type of stream being set.

  NOTE: The method getParams is called internally by
  RowSet implementations extending this class; it is not normally called by an
  application programmer directly.

  5.0 Event Notification
  The BaseRowSet class provides the event notification
  mechanism for rowsets.  It contains the field
  listeners, methods for adding and removing listeners, and
  methods for notifying listeners of changes.

  A listener is an object that has implemented the RowSetListener interface.
  If it has been added to a RowSet object's list of listeners, it will be notified
   when an event occurs on that RowSet object.  Each listener's
  implementation of the RowSetListener methods defines what that object
  will do when it is notified that an event has occurred.

  There are three possible events for a RowSet object:

  the cursor moves
  an individual row is changed (updated, deleted, or inserted)
  the contents of the entire RowSet object  are changed


  The BaseRowSet method used for the notification indicates the
  type of event that has occurred.  For example, the method
  notifyRowChanged indicates that a row has been updated,
  deleted, or inserted.  Each of the notification methods creates a
  RowSetEvent object, which is supplied to the listener in order to
  identify the RowSet object on which the event occurred.
  What the listener does with this information, which may be nothing, depends on how it was
  implemented.

  6.0 Default Behavior
  A default BaseRowSet object is initialized with many starting values.

  The following is true of a default RowSet instance that extends
  the BaseRowSet class:

    Has a scrollable cursor and does not show changes
        made by others.
    Is updatable.
    Does not show rows that have been deleted.
    Has no time limit for how long a driver may take to
        execute the RowSet object's command.
    Has no limit for the number of rows it may contain.
    Has no limit for the number of bytes a column may contain. NOTE: This
    limit applies only to columns that hold values of the
    following types:  BINARY, VARBINARY,
    LONGVARBINARY, CHAR, VARCHAR,
    and LONGVARCHAR.
    Will not see uncommitted data (make `dirty` reads).
    Has escape processing turned on.
    Has its connection's type map set to null.
    Has an empty Vector object for storing the values set
        for the placeholder parameters in the RowSet object's command.


  If other values are desired, an application must set the property values
  explicitly. For example, the following line of code sets the maximum number
  of rows for the CachedRowSet object crs to 500.


     crs.setMaxRows(500);
  Methods implemented in extensions of this BaseRowSet class must throw an
  SQLException object for any violation of the defined assertions.  Also, if the
  extending class overrides and reimplements any BaseRowSet method and encounters
  connectivity or underlying data source issues, that method may in addition throw an
  SQLException object for that reason."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset BaseRowSet]))

(defn ->base-row-set
  "Constructor.

  Constructs a new BaseRowSet object initialized with
   a default Vector object for its listeners
   field. The other default values with which it is initialized are listed
   in Section 6.0 of the class comment for this class."
  ([]
    (new BaseRowSet )))

(def *-unicode-stream-param
  "Static Constant.

  A constant indicating to a RowSetReaderImpl object
   that a given parameter is a Unicode stream. This
   RowSetReaderImpl object is provided as an extension of the
   SyncProvider abstract class defined in the
   SyncFactory static factory SPI mechanism.

  type: int"
  BaseRowSet/UNICODE_STREAM_PARAM)

(def *-binary-stream-param
  "Static Constant.

  A constant indicating to a RowSetReaderImpl object
   that a given parameter is a binary stream. A
   RowSetReaderImpl object is provided as an extension of the
   SyncProvider abstract class defined in the
   SyncFactory static factory SPI mechanism.

  type: int"
  BaseRowSet/BINARY_STREAM_PARAM)

(def *-ascii-stream-param
  "Static Constant.

  A constant indicating to a RowSetReaderImpl object
   that a given parameter is an ASCII stream. A
   RowSetReaderImpl object is provided as an extension of the
   SyncProvider abstract class defined in the
   SyncFactory static factory SPI mechanism.

  type: int"
  BaseRowSet/ASCII_STREAM_PARAM)

(defn set-fetch-size
  "Sets the fetch size for this RowSet object to the given number of
   rows.  The fetch size gives a JDBC technology-enabled driver (`JDBC driver`)
   a hint as to the
   number of rows that should be fetched from the database when more rows
   are needed for this RowSet object. If the fetch size specified
   is zero, the driver ignores the value and is free to make its own best guess
   as to what the fetch size should be.

   A RowSet object inherits the default properties of the
   ResultSet object from which it got its data.  That
   ResultSet object's default fetch size is set by
   the Statement object that created it.

   This method applies to a RowSet object only while it is
   connected to a database using a JDBC driver.
   For connected RowSet implementations such as
   JdbcRowSet, this method has a direct and immediate effect
   on the underlying JDBC driver.

   A RowSet object may use this method at any time to change
   its setting for the fetch size.

   For RowSet implementations such as
   CachedRowSet, which operate in a disconnected environment,
   the SyncProvider object being used
   may leverage the fetch size to poll the data source and
   retrieve a number of rows that do not exceed the fetch size and that may
   form a subset of the actual rows returned by the original query. This is
   an implementation variance determined by the specific SyncProvider
   object employed by the disconnected RowSet object.

  rows - the number of rows to fetch; 0 to let the driver decide what the best fetch size is; must not be less than 0 or more than the maximum number of rows allowed for this RowSet object (the number returned by a call to the method getMaxRows()) - `int`

  throws: java.sql.SQLException - if the specified fetch size is less than 0 or more than the limit for the maximum number of rows"
  ([^javax.sql.rowset.BaseRowSet this ^Integer rows]
    (-> this (.setFetchSize rows))))

(defn set-bytes
  "Sets the designated parameter to the given array of bytes.
   The driver converts this to an SQL
   VARBINARY or LONGVARBINARY value
   (depending on the argument's size relative to the driver's limits
   on VARBINARY values) when it sends it to the database.

   The parameter value set by this method is stored internally and
   will be supplied as the appropriate parameter in this RowSet
   object's command when the method execute is called.
   Methods such as execute and populate must be
   provided in any class that extends this class and implements one or
   more of the standard JSR-114 RowSet interfaces.

   NOTE: JdbcRowSet does not require the populate method
   as it is undefined in this class.

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  x - the parameter value - `byte[]`

  throws: java.sql.SQLException - if an error occurs or the parameter index is out of bounds"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index x]
    (-> this (.setBytes parameter-index x))))

(defn set-string
  "Sets the designated parameter to the given String
   value.  The driver converts this to an SQL
   VARCHAR or LONGVARCHAR value
   (depending on the argument's size relative to the driver's limits
   on VARCHAR values) when it sends it to the database.

   The parameter value set by this method is stored internally and
   will be supplied as the appropriate parameter in this RowSet
   object's command when the method execute is called.
   Methods such as execute and populate must be
   provided in any class that extends this class and implements one or
   more of the standard JSR-114 RowSet interfaces.

   NOTE: JdbcRowSet does not require the populate method
   as it is undefined in this class.

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  x - the parameter value - `java.lang.String`

  throws: java.sql.SQLException - if an error occurs or the parameter index is out of bounds"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.lang.String x]
    (-> this (.setString parameter-index x))))

(defn remove-row-set-listener
  "Removes the designated object from this RowSet object's list of listeners.
   If the given argument is not a registered listener, this method
   does nothing.

    Note: if the RowSetListener object is
   null, this method silently discards the null
   value.

  listener - a RowSetListener object that is on the list of listeners for this RowSet object - `javax.sql.RowSetListener`"
  ([^javax.sql.rowset.BaseRowSet this ^javax.sql.RowSetListener listener]
    (-> this (.removeRowSetListener listener))))

(defn set-array
  "Sets the designated parameter to an Array object in the
   Java programming language.  The driver converts this to an SQL
   ARRAY value when it sends it to the database. Internally,
   the Array is represented as a SerialArray
   to ensure serializability.

   The parameter value set by this method is stored internally and
   will be supplied as the appropriate parameter in this RowSet
   object's command when the method execute is called.
   Methods such as execute and populate must be
   provided in any class that extends this class and implements one or
   more of the standard JSR-114 RowSet interfaces.

   Note: JdbcRowSet does not require the populate method
   as it is undefined in this class.

   After this method has been called, a call to the
   method getParams
   will return an object array of the current command parameters, which will
   include the Array object set for placeholder parameter number
   parameterIndex.
   Note that because the numbering of elements in an array starts at zero,
   the array element that corresponds to placeholder parameter number
   parameterIndex is element number parameterIndex -1.

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  array - an Array object representing an SQL ARRAY value; cannot be null. The Array object passed to this method must return a non-null Object for all getArray() method calls. A null value will cause a SQLException to be thrown. - `java.sql.Array`

  throws: java.sql.SQLException - if an error occurs; the parameter index is out of bounds or the ARRAY is null"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.sql.Array array]
    (-> this (.setArray parameter-index array))))

(defn set-type-map
  "Installs the given java.util.Map object as the type map
   associated with the Connection object for this
   RowSet object.  The custom mapping indicated in
   this type map will be used unless a different type map is explicitly
   supplied to a method, in which case the type map supplied will be used.

  map - a java.util.Map object that contains the mapping from SQL type names for user defined types (UDT) to classes in the Java programming language. Each entry in the Map object consists of the fully qualified SQL name of a UDT and the Class object for the SQLData implementation of that UDT. May be null. - `java.util.Map<java.lang.String,java.lang.Class<?>>`"
  ([^javax.sql.rowset.BaseRowSet this ^java.util.Map> map]
    (-> this (.setTypeMap map))))

(defn set-read-only
  "Sets this RowSet object's readOnly  property to the given boolean.

  value - true to indicate that this RowSet object is read-only; false to indicate that it is updatable - `boolean`"
  ([^javax.sql.rowset.BaseRowSet this ^Boolean value]
    (-> this (.setReadOnly value))))

(defn set-time
  "Sets the designated parameter to the given java.sql.Time
   object.  The driver converts this
   to an SQL TIME value when it sends it to the database.

   When the DBMS does not store time zone information, the driver will use
   the given Calendar object to construct the SQL TIME
   value to send to the database. With a
   Calendar object, the driver can calculate the date
   taking into account a custom time zone.  If no Calendar
   object is specified, the driver uses the time zone of the Virtual Machine
   that is running the application.

   The parameter value set by this method is stored internally and
   will be supplied as the appropriate parameter in this RowSet
   object's command when the method execute is called.
   Methods such as execute and populate must be
   provided in any class that extends this class and implements one or
   more of the standard JSR-114 RowSet interfaces.

   NOTE: JdbcRowSet does not require the populate method
   as it is undefined in this class.

   Calls made to the method getParams after this version of
   setTime
   has been called will return an array containing the parameter values that
   have been set.  In that array, the element that represents the values
   set with this method will itself be an array. The first element of that array
   is the given java.sql.Time object.
   The second element is the value set for cal.
   The parameter number is indicated by an element's position in the array
   returned by the method getParams,
   with the first element being the value for the first placeholder parameter, the
   second element being the value for the second placeholder parameter, and so on.
   In other words, if the time being set is the value for the second
   placeholder parameter, the array containing it will be the second element in
   the array returned by getParams.

   Note that because the numbering of elements in an array starts at zero,
   the array element that corresponds to placeholder parameter number
   parameterIndex is parameterIndex -1.

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  x - a java.sql.Time object - `java.sql.Time`
  cal - the java.util.Calendar object the driver can use to construct the time - `java.util.Calendar`

  throws: java.sql.SQLException - if an error occurs or the parameter index is out of bounds"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.sql.Time x ^java.util.Calendar cal]
    (-> this (.setTime parameter-index x cal)))
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.sql.Time x]
    (-> this (.setTime parameter-index x))))

(defn set-timestamp
  "Sets the designated parameter to the given
   java.sql.Timestamp object.  The driver converts this
   to an SQL TIMESTAMP value when it sends it to the database.

   When the DBMS does not store time zone information, the driver will use
   the given Calendar object to construct the SQL TIMESTAMP
   value to send to the database. With a
   Calendar object, the driver can calculate the timestamp
   taking into account a custom time zone.  If no Calendar
   object is specified, the driver uses the time zone of the Virtual Machine
   that is running the application.

   The parameter value set by this method is stored internally and
   will be supplied as the appropriate parameter in this RowSet
   object's command when the method execute is called.
   Methods such as execute and populate must be
   provided in any class that extends this class and implements one or
   more of the standard JSR-114 RowSet interfaces.

   NOTE: JdbcRowSet does not require the populate method
   as it is undefined in this class.

   Calls made to the method getParams after this version of
   setTimestamp
   has been called will return an array containing the parameter values that
   have been set.  In that array, the element that represents the values
   set with this method will itself be an array. The first element of that array
   is the given java.sql.Timestamp object.
   The second element is the value set for cal.
   The parameter number is indicated by an element's position in the array
   returned by the method getParams,
   with the first element being the value for the first placeholder parameter, the
   second element being the value for the second placeholder parameter, and so on.
   In other words, if the timestamp being set is the value for the second
   placeholder parameter, the array containing it will be the second element in
   the array returned by getParams.

   Note that because the numbering of elements in an array starts at zero,
   the array element that corresponds to placeholder parameter number
   parameterIndex is parameterIndex -1.

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  x - a java.sql.Timestamp object - `java.sql.Timestamp`
  cal - the java.util.Calendar object the driver can use to construct the timestamp - `java.util.Calendar`

  throws: java.sql.SQLException - if an error occurs or the parameter index is out of bounds"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.sql.Timestamp x ^java.util.Calendar cal]
    (-> this (.setTimestamp parameter-index x cal)))
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.sql.Timestamp x]
    (-> this (.setTimestamp parameter-index x))))

(defn set-date
  "Sets the designated parameter to the given java.sql.Date
   object.
   When the DBMS does not store time zone information, the driver will use
   the given Calendar object to construct the SQL DATE
   value to send to the database. With a
   Calendar object, the driver can calculate the date
   taking into account a custom time zone.  If no Calendar
   object is specified, the driver uses the time zone of the Virtual Machine
   that is running the application.

   The parameter value set by this method is stored internally and
   will be supplied as the appropriate parameter in this RowSet
   object's command when the method execute is called.
   Methods such as execute and populate must be
   provided in any class that extends this class and implements one or
   more of the standard JSR-114 RowSet interfaces.

   NOTE: JdbcRowSet does not require the populate method
   as it is undefined in this class.

   Calls made to the method getParams after this version of
   setDate
   has been called will return an array containing the parameter values that
   have been set.  In that array, the element that represents the values
   set with this method will itself be an array. The first element of that array
   is the given java.sql.Date object.
   The second element is the value set for cal.
   The parameter number is indicated by an element's position in the array
   returned by the method getParams,
   with the first element being the value for the first placeholder parameter, the
   second element being the value for the second placeholder parameter, and so on.
   In other words, if the date being set is the value for the second
   placeholder parameter, the array containing it will be the second element in
   the array returned by getParams.

   Note that because the numbering of elements in an array starts at zero,
   the array element that corresponds to placeholder parameter number
   parameterIndex is parameterIndex -1.

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  x - a java.sql.Date object representing an SQL DATE value - `java.sql.Date`
  cal - a java.util.Calendar object to use when when constructing the date - `java.util.Calendar`

  throws: java.sql.SQLException - if an error occurs or the parameter index is out of bounds"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.sql.Date x ^java.util.Calendar cal]
    (-> this (.setDate parameter-index x cal)))
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.sql.Date x]
    (-> this (.setDate parameter-index x))))

(defn set-boolean
  "Sets the designated parameter to the given boolean in the
   Java programming language.  The driver converts this to an SQL
   BIT value when it sends it to the database.

   The parameter value set by this method is stored internally and
   will be supplied as the appropriate parameter in this RowSet
   object's command when the method execute is called.
   Methods such as execute, populate must be
   provided in any class that extends this class and implements one or
   more of the standard JSR-114 RowSet interfaces.

   NOTE: JdbcRowSet does not require the populate method
   as it is undefined in this class.

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  x - the parameter value - `boolean`

  throws: java.sql.SQLException - if an error occurs or the parameter index is out of bounds"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^Boolean x]
    (-> this (.setBoolean parameter-index x))))

(defn get-url
  "Retrieves the JDBC URL that this RowSet object's
   javax.sql.Reader object uses to make a connection
   with a relational database using a JDBC technology-enabled driver.

   The Url property will be null if the underlying data
   source is a non-SQL data source, such as a spreadsheet or an XML
   data source.

  returns: a String object that contains the JDBC URL
           used to establish the connection for this RowSet
           object; may be null (default value) if not set - `java.lang.String`

  throws: java.sql.SQLException - if an error occurs retrieving the URL value"
  (^java.lang.String [^javax.sql.rowset.BaseRowSet this]
    (-> this (.getUrl))))

(defn get-type
  "Returns the type of this RowSet object. The type is initially
   determined by the statement that created the RowSet object.
   The RowSet object can call the method
   setType at any time to change its
   type.  The default is TYPE_SCROLL_INSENSITIVE.

  returns: the type of this JDBC RowSet
           object, which must be one of the following:
           ResultSet.TYPE_FORWARD_ONLY,
           ResultSet.TYPE_SCROLL_INSENSITIVE, or
           ResultSet.TYPE_SCROLL_SENSITIVE - `int`

  throws: java.sql.SQLException - if an error occurs getting the type of of this RowSet object"
  (^Integer [^javax.sql.rowset.BaseRowSet this]
    (-> this (.getType))))

(defn set-command
  "Sets this RowSet object's command property to
   the given String object and clears the parameters, if any,
   that were set for the previous command.

   The command property may not be needed if the RowSet
   object gets its data from a source that does not support commands,
   such as a spreadsheet or other tabular file.
   Thus, this property is optional and may be null.

  cmd - a String object containing an SQL query that will be set as this RowSet object's command property; may be null but may not be an empty string - `java.lang.String`

  throws: java.sql.SQLException - if an empty string is provided as the command value"
  ([^javax.sql.rowset.BaseRowSet this ^java.lang.String cmd]
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
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.io.Reader value ^Long length]
    (-> this (.setNCharacterStream parameter-index value length)))
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.io.Reader value]
    (-> this (.setNCharacterStream parameter-index value))))

(defn set-null
  "Sets the designated parameter to SQL NULL.

   Although this version of the  method setNull is intended
   for user-defined
   and REF parameters, this method may be used to set a null
   parameter for any JDBC type. The following are user-defined types:
   STRUCT, DISTINCT, and JAVA_OBJECT,
   and named array types.

   Note: To be portable, applications must give the
   SQL type code and the fully qualified SQL type name when specifying
   a NULL user-defined or REF parameter.
   In the case of a user-defined type, the name is the type name of
   the parameter itself.  For a REF parameter, the name is
   the type name of the referenced type.  If a JDBC technology-enabled
   driver does not need the type code or type name information,
   it may ignore it.

   If the parameter does not have a user-defined or REF type,
   the given typeName parameter is ignored.

   The parameter value set by this method is stored internally and
   will be supplied as the appropriate parameter in this RowSet
   object's command when the method execute is called.
   Methods such as execute and populate must be
   provided in any class that extends this class and implements one or
   more of the standard JSR-114 RowSet interfaces.

   NOTE: JdbcRowSet does not require the populate method
   as it is undefined in this class.

   Calls made to the method getParams after this version of
   setNull
   has been called will return an Object array containing the parameter values that
   have been set.  In that array, the element that represents the values
   set with this method will itself be an array. The first element of that array
   is null.
   The second element is the value set for sqlType, and the third
   element is the value set for typeName.
   The parameter number is indicated by an element's position in the array
   returned by the method getParams,
   with the first element being the value for the first placeholder parameter, the
   second element being the value for the second placeholder parameter, and so on.
   In other words, if the second placeholder parameter is being set to
   null, the array containing it will be the second element in
   the array returned by getParams.

   Note that because the numbering of elements in an array starts at zero,
   the array element that corresponds to placeholder parameter number
   parameterIndex is parameterIndex -1.

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  sql-type - a value from java.sql.Types - `int`
  type-name - the fully qualified name of an SQL user-defined type, which is ignored if the parameter is not a user-defined type or REF value - `java.lang.String`

  throws: java.sql.SQLException - if an error occurs or the given parameter index is out of bounds"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^Integer sql-type ^java.lang.String type-name]
    (-> this (.setNull parameter-index sql-type type-name)))
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^Integer sql-type]
    (-> this (.setNull parameter-index sql-type))))

(defn set-query-timeout
  "Sets to the given number the maximum number of seconds the driver will
   wait for a query to execute. If the limit is exceeded, an
   SQLException is thrown.

  seconds - the new query time-out limit in seconds; zero means that there is no limit; must not be less than zero - `int`

  throws: java.sql.SQLException - if an error occurs setting the query time-out or if the query time-out value is less than 0"
  ([^javax.sql.rowset.BaseRowSet this ^Integer seconds]
    (-> this (.setQueryTimeout seconds))))

(defn get-transaction-isolation
  "Returns the transaction isolation property for this
   RowSet object's connection. This property represents
   the transaction isolation level requested for use in transactions.

   For RowSet implementations such as
   the CachedRowSet that operate in a disconnected environment,
   the SyncProvider object
   offers complementary locking and data integrity options. The
   options described below are pertinent only to connected RowSet
   objects (JdbcRowSet objects).

  returns: one of the following constants:
           Connection.TRANSACTION_NONE,
           Connection.TRANSACTION_READ_UNCOMMITTED,
           Connection.TRANSACTION_READ_COMMITTED,
           Connection.TRANSACTION_REPEATABLE_READ, or
           Connection.TRANSACTION_SERIALIZABLE - `int`"
  (^Integer [^javax.sql.rowset.BaseRowSet this]
    (-> this (.getTransactionIsolation))))

(defn set-password
  "Sets the password used to create a database connection for this
   RowSet object to the given String
   object.  Because the password property is not
   serialized, it is set at run time before calling the method
   execute.

  pass - the String object that represents the password that is supplied to the database to create a connection. It may be null. - `java.lang.String`"
  ([^javax.sql.rowset.BaseRowSet this ^java.lang.String pass]
    (-> this (.setPassword pass))))

(defn set-binary-stream
  "Sets the designated parameter to the given java.io.InputStream
   object, which will have the specified number of bytes.
   The contents of the stream will be read and sent to the database.
   This method throws an SQLException object if the number of bytes
   read and sent to the database is not equal to length.

   When a very large binary value is input to a
   LONGVARBINARY parameter, it may be more practical
   to send it via a java.io.InputStream object.
   A JDBC technology-enabled driver will read the data from the
   stream as needed until it reaches end-of-file.

   Note: This stream object can be either a standard
   Java stream object or your own subclass that implements the
   standard interface.

   The parameter value set by this method is stored internally and
   will be supplied as the appropriate parameter in this RowSet
   object's command when the method execute is called.
   Methods such as execute and populate must be
   provided in any class that extends this class and implements one or
   more of the standard JSR-114 RowSet interfaces.

   NOTE: JdbcRowSet does not require the populate method
   as it is undefined in this class.

   Calls made to the method getParams after setBinaryStream
   has been called will return an array containing the parameter values that
   have been set.  In that array, the element that represents the values
   set with this method will itself be an array. The first element of that array
   is the given java.io.InputStream object.
   The second element is the value set for length.
   The third element is an internal BaseRowSet constant
   specifying that the stream passed to this method is a binary stream.
   The parameter number is indicated by an element's position in the array
   returned by the method getParams,
   with the first element being the value for the first placeholder parameter, the
   second element being the value for the second placeholder parameter, and so on.
   In other words, if the input stream being set is the value for the second
   placeholder parameter, the array containing it will be the second element in
   the array returned by getParams.

   Note that because the numbering of elements in an array starts at zero,
   the array element that corresponds to placeholder parameter number
   parameterIndex is element number parameterIndex -1.

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  x - the input stream that contains the binary value to be set - `java.io.InputStream`
  length - the number of bytes in the stream; lengths of 0 or less are are undefined but will cause an invalid length exception to be thrown in the underlying JDBC driver. - `int`

  throws: java.sql.SQLException - if an error occurs, the parameter index is out of bounds, or when connected to a data source, the number of bytes the driver reads and sends to the database is not equal to the number of bytes specified in length"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.io.InputStream x ^Integer length]
    (-> this (.setBinaryStream parameter-index x length)))
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.io.InputStream x]
    (-> this (.setBinaryStream parameter-index x))))

(defn set-type
  "Sets the type for this RowSet object to the specified type.
   The default type is ResultSet.TYPE_SCROLL_INSENSITIVE.

  type - one of the following constants: ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE - `int`

  throws: java.sql.SQLException - if the parameter supplied is not one of the following constants: ResultSet.TYPE_FORWARD_ONLY or ResultSet.TYPE_SCROLL_INSENSITIVE ResultSet.TYPE_SCROLL_SENSITIVE"
  ([^javax.sql.rowset.BaseRowSet this ^Integer type]
    (-> this (.setType type))))

(defn add-row-set-listener
  "The listener will be notified whenever an event occurs on this RowSet
   object.

   A listener might, for example, be a table or graph that needs to
   be updated in order to accurately reflect the current state of
   the RowSet object.

   Note: if the RowSetListener object is
   null, this method silently discards the null
   value and does not add a null reference to the set of listeners.

   Note: if the listener is already set, and the new RowSetListerner
   instance is added to the set of listeners already registered to receive
   event notifications from this RowSet.

  listener - an object that has implemented the javax.sql.RowSetListener interface and wants to be notified of any events that occur on this RowSet object; May be null. - `javax.sql.RowSetListener`"
  ([^javax.sql.rowset.BaseRowSet this ^javax.sql.RowSetListener listener]
    (-> this (.addRowSetListener listener))))

(defn get-command
  "Retrieves the SQL query that is the command for this
   RowSet object. The command property contains the query that
   will be executed to populate this RowSet object.

   The SQL query returned by this method is used by RowSet methods
   such as execute and populate, which may be implemented
   by any class that extends the BaseRowSet abstract class and
   implements one or more of the standard JSR-114 RowSet
   interfaces.

   The command is used by the RowSet object's
   reader to obtain a ResultSet object.  The reader then
   reads the data from the ResultSet object and uses it to
   to populate this RowSet object.

   The default value for the command property is null.

  returns: the String that is the value for this
           RowSet object's command property;
           may be null - `java.lang.String`"
  (^java.lang.String [^javax.sql.rowset.BaseRowSet this]
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
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.io.InputStream input-stream ^Long length]
    (-> this (.setBlob parameter-index input-stream length)))
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.sql.Blob x]
    (-> this (.setBlob parameter-index x))))

(defn set-url
  "Sets the Url property for this RowSet object
   to the given String object and sets the dataSource name
   property to null. The Url property is a
   JDBC URL that is used when
   the connection is created using a JDBC technology-enabled driver
   (`JDBC driver`) and the DriverManager.
   The correct JDBC URL for the specific driver to be used can be found
   in the driver documentation.  Although there are guidelines for for how
   a JDBC URL is formed,
   a driver vendor can specify any String object except
   one with a length of 0 (an empty string).

   Setting the Url property is optional if connections are established using
   a DataSource object instead of the DriverManager.
   The driver will use either the URL property or the
   dataSourceName property to create a connection, whichever was
   specified most recently. If an application uses a JDBC URL, it
   must load a JDBC driver that accepts the JDBC URL before it uses the
   RowSet object to connect to a database.  The RowSet
   object will use the URL internally to create a database connection in order
   to read or write data.

  url - a String object that contains the JDBC URL that will be used to establish the connection to a database for this RowSet object; may be null but must not be an empty string - `java.lang.String`

  throws: java.sql.SQLException - if an error occurs setting the Url property or the parameter supplied is a string with a length of 0 (an empty string)"
  ([^javax.sql.rowset.BaseRowSet this ^java.lang.String url]
    (-> this (.setUrl url))))

(defn set-object
  "Sets the designated parameter to an Object in the Java
   programming language. The second parameter must be an
   Object type.  For integral values, the
   java.lang equivalent
   objects should be used. For example, use the class Integer
   for an int.

   The driver converts this object to the specified
   target SQL type before sending it to the database.
   If the object has a custom mapping (is of a class implementing
   SQLData), the driver should call the method
   SQLData.writeSQL to write the object to the SQL
   data stream. If, on the other hand, the object is of a class
   implementing Ref, Blob, Clob,
   Struct, or Array,
   the driver should pass it to the database as a value of the
   corresponding SQL type.

   Note that this method may be used to pass database-
   specific abstract data types.

   The parameter value set by this method is stored internally and
   will be supplied as the appropriate parameter in this RowSet
   object's command when the method execute is called.
   Methods such as execute and populate must be
   provided in any class that extends this class and implements one or
   more of the standard JSR-114 RowSet interfaces.

   NOTE: JdbcRowSet does not require the populate method
   as it is undefined in this class.

   Calls made to the method getParams after this version of
   setObject
   has been called will return an array containing the parameter values that
   have been set.  In that array, the element that represents the values
   set with this method will itself be an array. The first element of that array
   is the given Object instance, and the
   second element is the value set for targetSqlType.  The
   third element is the value set for scale, which the driver will
   ignore if the type of the object being set is not
   java.sql.Types.NUMERIC or java.sql.Types.DECIMAL.
   The parameter number is indicated by an element's position in the array
   returned by the method getParams,
   with the first element being the value for the first placeholder parameter, the
   second element being the value for the second placeholder parameter, and so on.
   In other words, if the object being set is the value for the second
   placeholder parameter, the array containing it will be the second element in
   the array returned by getParams.

   Note that because the numbering of elements in an array starts at zero,
   the array element that corresponds to placeholder parameter number
   parameterIndex is element number parameterIndex -1.

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  x - the Object containing the input parameter value; must be an Object type - `java.lang.Object`
  target-sql-type - the SQL type (as defined in java.sql.Types) to be sent to the database. The scale argument may further qualify this type. If a non-standard targetSqlType is supplied, this method will not throw a SQLException. This allows implicit support for non-standard SQL types. - `int`
  scale - for the types java.sql.Types.DECIMAL and java.sql.Types.NUMERIC, this is the number of digits after the decimal point. For all other types, this value will be ignored. - `int`

  throws: java.sql.SQLException - if an error occurs or the parameter index is out of bounds"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.lang.Object x ^Integer target-sql-type ^Integer scale]
    (-> this (.setObject parameter-index x target-sql-type scale)))
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.lang.Object x ^Integer target-sql-type]
    (-> this (.setObject parameter-index x target-sql-type)))
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.lang.Object x]
    (-> this (.setObject parameter-index x))))

(defn set-escape-processing
  "Sets to the given boolean whether or not the driver will
   scan for escape syntax and do escape substitution before sending SQL
   statements to the database. The default is for the driver to do escape
   processing.

   Note: Since PreparedStatement objects have usually been
   parsed prior to making this call, disabling escape processing for
   prepared statements will likely have no effect.

  enable - true to enable escape processing; false to disable it - `boolean`

  throws: java.sql.SQLException - if an error occurs setting the underlying JDBC technology-enabled driver to process the escape syntax"
  ([^javax.sql.rowset.BaseRowSet this ^Boolean enable]
    (-> this (.setEscapeProcessing enable))))

(defn set-max-rows
  "Sets the maximum number of rows that this RowSet object may contain to
   the given number. If this limit is exceeded, the excess rows are
   silently dropped.

  max - an int indicating the current maximum number of rows; zero means that there is no limit - `int`

  throws: java.sql.SQLException - if an error occurs internally setting the maximum limit on the number of rows that a JDBC RowSet object can contain; or if max is less than 0; or if max is less than the fetchSize of the RowSet"
  ([^javax.sql.rowset.BaseRowSet this ^Integer max]
    (-> this (.setMaxRows max))))

(defn get-username
  "Returns the user name used to create a database connection.  Because it
   is not serialized, the username property is set at runtime before
   calling the method execute.

  returns: the String object containing the user name that
           is supplied to the data source to create a connection; may be
           null (default value) if not set - `java.lang.String`"
  (^java.lang.String [^javax.sql.rowset.BaseRowSet this]
    (-> this (.getUsername))))

(defn clear-parameters
  "Clears all of the current parameter values in this RowSet
   object's internal representation of the parameters to be set in
   this RowSet object's command when it is executed.

   In general, parameter values remain in force for repeated use in
   this RowSet object's command. Setting a parameter value with the
   setter methods automatically clears the value of the
   designated parameter and replaces it with the new specified value.

   This method is called internally by the setCommand
   method to clear all of the parameters set for the previous command.

   Furthermore, this method differs from the initParams
   method in that it maintains the schema of the RowSet object.

  throws: java.sql.SQLException - if an error occurs clearing the parameters"
  ([^javax.sql.rowset.BaseRowSet this]
    (-> this (.clearParameters))))

(defn get-fetch-direction
  "Retrieves this RowSet object's current setting for the
   fetch direction. The default type is ResultSet.FETCH_FORWARD

  returns: one of ResultSet.FETCH_FORWARD,
                    ResultSet.FETCH_REVERSE, or
                    ResultSet.FETCH_UNKNOWN - `int`

  throws: java.sql.SQLException - if an error occurs in determining the current fetch direction for fetching rows"
  (^Integer [^javax.sql.rowset.BaseRowSet this]
    (-> this (.getFetchDirection))))

(defn set-n-clob
  "Sets the designated parameter to a Reader object.  The reader must contain
   the number
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
  ([^javax.sql.rowset.BaseRowSet this ^java.lang.String parameter-name ^java.io.Reader reader ^Long length]
    (-> this (.setNClob parameter-name reader length)))
  ([^javax.sql.rowset.BaseRowSet this ^java.lang.String parameter-name ^java.sql.NClob value]
    (-> this (.setNClob parameter-name value))))

(defn get-max-field-size
  "Retrieves the maximum number of bytes that can be used for a column
   value in this RowSet object.
   This limit applies only to columns that hold values of the
   following types:  BINARY, VARBINARY,
   LONGVARBINARY, CHAR, VARCHAR,
   and LONGVARCHAR.  If the limit is exceeded, the excess
   data is silently discarded.

  returns: an int indicating the current maximum column size
       limit; zero means that there is no limit - `int`

  throws: java.sql.SQLException - if an error occurs internally determining the maximum limit of the column size"
  (^Integer [^javax.sql.rowset.BaseRowSet this]
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
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.io.Reader reader ^Long length]
    (-> this (.setClob parameter-index reader length)))
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.sql.Clob x]
    (-> this (.setClob parameter-index x))))

(defn set-transaction-isolation
  "Sets the transaction isolation property for this JDBC RowSet object to the given
   constant. The DBMS will use this transaction isolation level for
   transactions if it can.

   For RowSet implementations such as
   the CachedRowSet that operate in a disconnected environment,
   the SyncProvider object being used
   offers complementary locking and data integrity options. The
   options described below are pertinent only to connected RowSet
   objects (JdbcRowSet objects).

  level - one of the following constants, listed in ascending order: Connection.TRANSACTION_NONE, Connection.TRANSACTION_READ_UNCOMMITTED, Connection.TRANSACTION_READ_COMMITTED, Connection.TRANSACTION_REPEATABLE_READ, or Connection.TRANSACTION_SERIALIZABLE - `int`

  throws: java.sql.SQLException - if the given parameter is not one of the Connection constants"
  ([^javax.sql.rowset.BaseRowSet this ^Integer level]
    (-> this (.setTransactionIsolation level))))

(defn set-double
  "Sets the designated parameter to the given double in the
   Java programming language.  The driver converts this to an SQL
   DOUBLE value when it sends it to the database.

   The parameter value set by this method is stored internally and
   will be supplied as the appropriate parameter in this RowSet
   object's command when the method execute is called.
   Methods such as execute and populate must be
   provided in any class that extends this class and implements one or
   more of the standard JSR-114 RowSet interfaces.

   NOTE: JdbcRowSet does not require the populate method
   as it is undefined in this class.
   S

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  x - the parameter value - `double`

  throws: java.sql.SQLException - if an error occurs or the parameter index is out of bounds"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^Double x]
    (-> this (.setDouble parameter-index x))))

(defn set-ref
  "Sets the designated parameter to the given Ref object in
   the Java programming language.  The driver converts this to an SQL
   REF value when it sends it to the database. Internally, the
   Ref is represented as a SerialRef to ensure
   serializability.

   The parameter value set by this method is stored internally and
   will be supplied as the appropriate parameter in this RowSet
   object's command when the method execute is called.
   Methods such as execute and populate must be
   provided in any class that extends this class and implements one or
   more of the standard JSR-114 RowSet interfaces.

   NOTE: JdbcRowSet does not require the populate method
   as it is undefined in this class.

   After this method has been called, a call to the
   method getParams
   will return an object array of the current command parameters, which will
   include the Ref object set for placeholder parameter number
   parameterIndex.
   Note that because the numbering of elements in an array starts at zero,
   the array element that corresponds to placeholder parameter number
   parameterIndex is element number parameterIndex -1.

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  ref - a Ref object representing an SQL REF value; cannot be null - `java.sql.Ref`

  throws: java.sql.SQLException - if an error occurs; the parameter index is out of bounds or the Ref object is null; or the Ref object returns a null base type name."
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.sql.Ref ref]
    (-> this (.setRef parameter-index ref))))

(defn set-long
  "Sets the designated parameter to the given long in the Java
   programming language.  The driver converts this to an SQL
   BIGINT value when it sends it to the database.

   The parameter value set by this method is stored internally and
   will be supplied as the appropriate parameter in this RowSet
   object's command when the method execute is called.
   Methods such as execute and populate must be
   provided in any class that extends this class and implements one or
   more of the standard JSR-114 RowSet interfaces.

   NOTE: JdbcRowSet does not require the populate method
   as it is undefined in this class.

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  x - the parameter value - `long`

  throws: java.sql.SQLException - if an error occurs or the parameter index is out of bounds"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^Long x]
    (-> this (.setLong parameter-index x))))

(defn set-max-field-size
  "Sets the maximum number of bytes that can be used for a column
   value in this RowSet object to the given number.
   This limit applies only to columns that hold values of the
   following types:  BINARY, VARBINARY,
   LONGVARBINARY, CHAR, VARCHAR,
   and LONGVARCHAR.  If the limit is exceeded, the excess
   data is silently discarded. For maximum portability, it is advisable to
   use values greater than 256.

  max - an int indicating the new maximum column size limit; zero means that there is no limit - `int`

  throws: java.sql.SQLException - if (1) an error occurs internally setting the maximum limit of the column size or (2) a size of less than 0 is set"
  ([^javax.sql.rowset.BaseRowSet this ^Integer max]
    (-> this (.setMaxFieldSize max))))

(defn get-show-deleted?
  "Retrieves a boolean indicating whether rows marked
   for deletion appear in the set of current rows.
   The default value is false.

   Note: Allowing deleted rows to remain visible complicates the behavior
   of some of the methods.  However, most RowSet object users
   can simply ignore this extra detail because only sophisticated
   applications will likely want to take advantage of this feature.

  returns: true if deleted rows are visible;
           false otherwise - `boolean`

  throws: java.sql.SQLException - if an error occurs determining if deleted rows are visible or not"
  (^Boolean [^javax.sql.rowset.BaseRowSet this]
    (-> this (.getShowDeleted))))

(defn set-username
  "Sets the username property for this RowSet object
   to the given user name. Because it
   is not serialized, the username property is set at run time before
   calling the method execute.

  name - the String object containing the user name that is supplied to the data source to create a connection. It may be null. - `java.lang.String`"
  ([^javax.sql.rowset.BaseRowSet this ^java.lang.String name]
    (-> this (.setUsername name))))

(defn set-byte
  "Sets the designated parameter to the given byte in the Java
   programming language.  The driver converts this to an SQL
   TINYINT value when it sends it to the database.

   The parameter value set by this method is stored internally and
   will be supplied as the appropriate parameter in this RowSet
   object's command when the method execute is called.
   Methods such as execute and populate must be
   provided in any class that extends this class and implements one or
   more of the standard JSR-114 RowSet interfaces.

   NOTE: JdbcRowSet does not require the populate method
   as it is undefined in this class.

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  x - the parameter value - `byte`

  throws: java.sql.SQLException - if an error occurs or the parameter index is out of bounds"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^Byte x]
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
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.lang.String value]
    (-> this (.setNString parameter-index value))))

(defn set-short
  "Sets the designated parameter to the given short in the
   Java programming language.  The driver converts this to an SQL
   SMALLINT value when it sends it to the database.

   The parameter value set by this method is stored internally and
   will be supplied as the appropriate parameter in this RowSet
   object's command when the method execute is called.
   Methods such as execute and populate must be
   provided in any class that extends this class and implements one or
   more of the standard JSR-114 RowSet interfaces.

   NOTE: JdbcRowSet does not require the populate method
   as it is undefined in this class.

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  x - the parameter value - `short`

  throws: java.sql.SQLException - if an error occurs or the parameter index is out of bounds"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^Short x]
    (-> this (.setShort parameter-index x))))

(defn set-concurrency
  "Sets the concurrency for this RowSet object to
   the specified concurrency. The default concurrency for any RowSet
   object (connected or disconnected) is ResultSet.CONCUR_UPDATABLE,
   but this method may be called at any time to change the concurrency.

  concurrency - one of the following constants: ResultSet.CONCUR_READ_ONLY or ResultSet.CONCUR_UPDATABLE - `int`

  throws: java.sql.SQLException - if the parameter supplied is not one of the following constants: ResultSet.CONCUR_UPDATABLE or ResultSet.CONCUR_READ_ONLY"
  ([^javax.sql.rowset.BaseRowSet this ^Integer concurrency]
    (-> this (.setConcurrency concurrency))))

(defn set-ascii-stream
  "Sets the designated parameter to the given
   java.io.InputStream object,
   which will have the specified number of bytes.
   The contents of the stream will be read and sent to the database.
   This method throws an SQLException object if the number of bytes
   read and sent to the database is not equal to length.

   When a very large ASCII value is input to a LONGVARCHAR
   parameter, it may be more practical to send it via a
   java.io.InputStream object. A JDBC technology-enabled
   driver will read the data from the stream as needed until it reaches
   end-of-file. The driver will do any necessary conversion from ASCII to
   the database CHAR format.

   Note: This stream object can be either a standard
   Java stream object or your own subclass that implements the
   standard interface.

   The parameter value set by this method is stored internally and
   will be supplied as the appropriate parameter in this RowSet
   object's command when the method execute is called.
   Methods such as execute and populate must be
   provided in any class that extends this class and implements one or
   more of the standard JSR-114 RowSet interfaces.

   Note: JdbcRowSet does not require the populate method
   as it is undefined in this class.

   Calls made to the method getParams after setAsciiStream
   has been called will return an array containing the parameter values that
   have been set.  The element in the array that represents the values
   set with this method will itself be an array. The first element of that array
   is the given java.io.InputStream object.
   The second element is the value set for length.
   The third element is an internal BaseRowSet constant
   specifying that the stream passed to this method is an ASCII stream.
   The parameter number is indicated by an element's position in the array
   returned by the method getParams,
   with the first element being the value for the first placeholder parameter, the
   second element being the value for the second placeholder parameter, and so on.
   In other words, if the input stream being set is the value for the second
   placeholder parameter, the array containing it will be the second element in
   the array returned by getParams.

   Note that because the numbering of elements in an array starts at zero,
   the array element that corresponds to placeholder parameter number
   parameterIndex is element number parameterIndex -1.

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  x - the Java input stream that contains the ASCII parameter value - `java.io.InputStream`
  length - the number of bytes in the stream. This is the number of bytes the driver will send to the DBMS; lengths of 0 or less are are undefined but will cause an invalid length exception to be thrown in the underlying JDBC driver. - `int`

  throws: java.sql.SQLException - if an error occurs, the parameter index is out of bounds, or when connected to a data source, the number of bytes the driver reads and sends to the database is not equal to the number of bytes specified in length"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.io.InputStream x ^Integer length]
    (-> this (.setAsciiStream parameter-index x length)))
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.io.InputStream x]
    (-> this (.setAsciiStream parameter-index x))))

(defn set-big-decimal
  "Sets the designated parameter to the given
   java.lang.BigDecimal value.  The driver converts this to
   an SQL NUMERIC value when it sends it to the database.

   The parameter value set by this method is stored internally and
   will be supplied as the appropriate parameter in this RowSet
   object's command when the method execute is called.
   Methods such as execute and populate must be
   provided in any class that extends this class and implements one or
   more of the standard JSR-114 RowSet interfaces.

   Note: JdbcRowSet does not require the populate method
   as it is undefined in this class.

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  x - the parameter value - `java.math.BigDecimal`

  throws: java.sql.SQLException - if an error occurs or the parameter index is out of bounds"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.math.BigDecimal x]
    (-> this (.setBigDecimal parameter-index x))))

(defn get-max-rows
  "Retrieves the maximum number of rows that this RowSet object may contain. If
   this limit is exceeded, the excess rows are silently dropped.

  returns: an int indicating the current maximum number of
       rows; zero means that there is no limit - `int`

  throws: java.sql.SQLException - if an error occurs internally determining the maximum limit of rows that a Rowset object can contain"
  (^Integer [^javax.sql.rowset.BaseRowSet this]
    (-> this (.getMaxRows))))

(defn set-int
  "Sets the designated parameter to an int in the Java
   programming language.  The driver converts this to an SQL
   INTEGER value when it sends it to the database.

   The parameter value set by this method is stored internally and
   will be supplied as the appropriate parameter in this RowSet
   object's command when the method execute is called.
   Methods such as execute and populate must be
   provided in any class that extends this class and implements one or
   more of the standard JSR-114 RowSet interfaces.

   NOTE: JdbcRowSet does not require the populate method
   as it is undefined in this class.

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  x - the parameter value - `int`

  throws: java.sql.SQLException - if an error occurs or the parameter index is out of bounds"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^Integer x]
    (-> this (.setInt parameter-index x))))

(defn get-query-timeout
  "Retrieves the maximum number of seconds the driver will wait for a
   query to execute. If the limit is exceeded, an SQLException
   is thrown.

  returns: the current query timeout limit in seconds; zero means that
       there is no limit - `int`

  throws: java.sql.SQLException - if an error occurs in determining the query time-out value"
  (^Integer [^javax.sql.rowset.BaseRowSet this]
    (-> this (.getQueryTimeout))))

(defn get-fetch-size
  "Returns the fetch size for this RowSet object. The default
   value is zero.

  returns: the number of rows suggested as the fetch size when this RowSet object
       needs more rows from the database - `int`

  throws: java.sql.SQLException - if an error occurs determining the number of rows in the current fetch size"
  (^Integer [^javax.sql.rowset.BaseRowSet this]
    (-> this (.getFetchSize))))

(defn get-concurrency
  "Returns the concurrency for this RowSet object.
   The default is CONCUR_UPDATABLE for both connected and
   disconnected RowSet objects.

   An application can call the method setConcurrency at any time
   to change a RowSet object's concurrency.

  returns: the concurrency type for this RowSet
       object, which must be one of the following:
       ResultSet.CONCUR_READ_ONLY or
       ResultSet.CONCUR_UPDATABLE - `int`

  throws: java.sql.SQLException - if an error occurs getting the concurrency of this RowSet object"
  (^Integer [^javax.sql.rowset.BaseRowSet this]
    (-> this (.getConcurrency))))

(defn set-character-stream
  "Sets the designated parameter to the given java.io.Reader
   object, which will have the specified number of characters. The
   contents of the reader will be read and sent to the database.
   This method throws an SQLException if the number of bytes
   read and sent to the database is not equal to length.

   When a very large Unicode value is input to a
   LONGVARCHAR parameter, it may be more practical
   to send it via a Reader object.
   A JDBC technology-enabled driver will read the data from the
   stream as needed until it reaches end-of-file.
   The driver will do any necessary conversion from Unicode to the
   database CHAR format.
   The byte format of the Unicode stream must be Java UTF-8, as
   defined in the Java Virtual Machine Specification.

   Note: This stream object can be either a standard
   Java stream object or your own subclass that implements the
   standard interface.

   The parameter value set by this method is stored internally and
   will be supplied as the appropriate parameter in this RowSet
   object's command when the method execute is called.
   Methods such as execute and populate must be
   provided in any class that extends this class and implements one or
   more of the standard JSR-114 RowSet interfaces.

   NOTE: JdbcRowSet does not require the populate method
   as it is undefined in this class.

   Calls made to the method getParams after
   setCharacterStream
   has been called will return an array containing the parameter values that
   have been set.  In that array, the element that represents the values
   set with this method will itself be an array. The first element of that array
   is the given java.io.Reader object.
   The second element is the value set for length.
   The parameter number is indicated by an element's position in the array
   returned by the method getParams,
   with the first element being the value for the first placeholder parameter, the
   second element being the value for the second placeholder parameter, and so on.
   In other words, if the reader being set is the value for the second
   placeholder parameter, the array containing it will be the second element in
   the array returned by getParams.

   Note that because the numbering of elements in an array starts at zero,
   the array element that corresponds to placeholder parameter number
   parameterIndex is element number parameterIndex -1.

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  reader - the Reader object that contains the Unicode data - `java.io.Reader`
  length - the number of characters in the stream; lengths of 0 or less are undefined but will cause an invalid length exception to be thrown in the underlying JDBC driver. - `int`

  throws: java.sql.SQLException - if an error occurs, the parameter index is out of bounds, or when connected to a data source, the number of bytes the driver reads and sends to the database is not equal to the number of bytes specified in length"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.io.Reader reader ^Integer length]
    (-> this (.setCharacterStream parameter-index reader length)))
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.io.Reader reader]
    (-> this (.setCharacterStream parameter-index reader))))

(defn get-type-map
  "Retrieves the type map associated with the Connection
   object for this RowSet object.

   Drivers that support the JDBC 3.0 API will create
   Connection objects with an associated type map.
   This type map, which is initially empty, can contain one or more
   fully-qualified SQL names and Class objects indicating
   the class to which the named SQL value will be mapped. The type mapping
   specified in the connection's type map is used for custom type mapping
   when no other type map supersedes it.

   If a type map is explicitly supplied to a method that can perform
   custom mapping, that type map supersedes the connection's type map.

  returns: the java.util.Map object that is the type map
           for this RowSet object's connection - `java.util.Map<java.lang.String,java.lang.Class<?>>`"
  (^java.util.Map> [^javax.sql.rowset.BaseRowSet this]
    (-> this (.getTypeMap))))

(defn get-data-source-name
  "Returns the logical name that when supplied to a naming service
   that uses the Java Naming and Directory Interface (JNDI) API, will
   retrieve a javax.sql.DataSource object. This
   DataSource object can be used to establish a connection
   to the data source that it represents.

   Users should set either the url or the data source name property.
   The driver will use the property set most recently to establish a
   connection.

  returns: a String object that identifies the
           DataSource object to be used for making a
           connection; if no logical name has been set, null
           is returned. - `java.lang.String`"
  (^java.lang.String [^javax.sql.rowset.BaseRowSet this]
    (-> this (.getDataSourceName))))

(defn set-data-source-name
  "Sets the DataSource name property for this RowSet
   object to the given logical name and sets this RowSet object's
   Url property to null. The name must have been bound to a
   DataSource object in a JNDI naming service so that an
   application can do a lookup using that name to retrieve the
   DataSource object bound to it. The DataSource
   object can then be used to establish a connection to the data source it
   represents.

   Users should set either the Url property or the dataSourceName property.
   If both properties are set, the driver will use the property set most recently.

  name - a String object with the name that can be supplied to a naming service based on JNDI technology to retrieve the DataSource object that can be used to get a connection; may be null but must not be an empty string - `java.lang.String`

  throws: java.sql.SQLException - if an empty string is provided as the DataSource name"
  ([^javax.sql.rowset.BaseRowSet this ^java.lang.String name]
    (-> this (.setDataSourceName name))))

(defn read-only?
  "Returns a boolean indicating whether this
   RowSet object is read-only.
   Any attempts to update a read-only RowSet object will result in an
   SQLException being thrown. By default,
   rowsets are updatable if updates are possible.

  returns: true if this RowSet object
           cannot be updated; false otherwise - `boolean`"
  (^Boolean [^javax.sql.rowset.BaseRowSet this]
    (-> this (.isReadOnly))))

(defn set-url
  "Sets the designated parameter to the given java.net.URL value.
   The driver converts this to an SQL DATALINK value
   when it sends it to the database.

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the java.net.URL object to be set - `java.net.URL`

  throws: java.sql.SQLException - if a database access error occurs or this method is called on a closed PreparedStatement"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.net.URL x]
    (-> this (.setURL parameter-index x))))

(defn get-escape-processing?
  "Ascertains whether escape processing is enabled for this
   RowSet object.

  returns: true if escape processing is turned on;
           false otherwise - `boolean`

  throws: java.sql.SQLException - if an error occurs determining if escape processing is enabled or not or if the internal escape processing trigger has not been enabled"
  (^Boolean [^javax.sql.rowset.BaseRowSet this]
    (-> this (.getEscapeProcessing))))

(defn set-unicode-stream
  "Deprecated. getCharacterStream should be used in its place

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  x - the java.io.InputStream object that contains the UNICODE parameter value - `java.io.InputStream`
  length - the number of bytes in the input stream - `int`

  returns: `java.lang.  void`

  throws: java.sql.SQLException - if an error occurs, the parameter index is out of bounds, or the number of bytes the driver reads and sends to the database is not equal to the number of bytes specified in length"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.io.InputStream x ^Integer length]
    (-> this (.setUnicodeStream parameter-index x length))))

(defn set-show-deleted
  "Sets the property showDeleted to the given
   boolean value, which determines whether
   rows marked for deletion appear in the set of current rows.

  value - true if deleted rows should be shown; false otherwise - `boolean`

  throws: java.sql.SQLException - if an error occurs setting whether deleted rows are visible or not"
  ([^javax.sql.rowset.BaseRowSet this ^Boolean value]
    (-> this (.setShowDeleted value))))

(defn set-sqlxml
  "Sets the designated parameter to the given java.sql.SQLXML object. The driver converts this to an
   SQL XML value when it sends it to the database.

  parameter-index - index of the first parameter is 1, the second is 2, ... - `int`
  xml-object - a SQLXML object that maps an SQL XML value - `java.sql.SQLXML`

  throws: java.sql.SQLException - if a database access error occurs, this method is called on a closed result set, the java.xml.transform.Result, Writer or OutputStream has not been closed for the SQLXML object or if there is an error processing the XML value. The getCause method of the exception may provide a more detailed exception, for example, if the stream does not contain valid XML."
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.sql.SQLXML xml-object]
    (-> this (.setSQLXML parameter-index xml-object))))

(defn set-float
  "Sets the designated parameter to the given float in the
   Java programming language.  The driver converts this to an SQL
   FLOAT value when it sends it to the database.

   The parameter value set by this method is stored internally and
   will be supplied as the appropriate parameter in this RowSet
   object's command when the method execute is called.
   Methods such as execute and populate must be
   provided in any class that extends this class and implements one or
   more of the standard JSR-114 RowSet interfaces.

   NOTE: JdbcRowSet does not require the populate method
   as it is undefined in this class.

  parameter-index - the ordinal number of the placeholder parameter in this RowSet object's command that is to be set. The first parameter is 1, the second is 2, and so on; must be 1 or greater - `int`
  x - the parameter value - `float`

  throws: java.sql.SQLException - if an error occurs or the parameter index is out of bounds"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^Float x]
    (-> this (.setFloat parameter-index x))))

(defn set-fetch-direction
  "Gives the driver a performance hint as to the direction in
   which the rows in this RowSet object will be
   processed.  The driver may ignore this hint.

   A RowSet object inherits the default properties of the
   ResultSet object from which it got its data.  That
   ResultSet object's default fetch direction is set by
   the Statement object that created it.

   This method applies to a RowSet object only while it is
   connected to a database using a JDBC driver.

   A RowSet object may use this method at any time to change
   its setting for the fetch direction.

  direction - one of ResultSet.FETCH_FORWARD, ResultSet.FETCH_REVERSE, or ResultSet.FETCH_UNKNOWN - `int`

  throws: java.sql.SQLException - if (1) the RowSet type is TYPE_FORWARD_ONLY and the given fetch direction is not FETCH_FORWARD or (2) the given fetch direction is not one of the following: ResultSet.FETCH_FORWARD, ResultSet.FETCH_REVERSE, or ResultSet.FETCH_UNKNOWN"
  ([^javax.sql.rowset.BaseRowSet this ^Integer direction]
    (-> this (.setFetchDirection direction))))

(defn set-row-id
  "Sets the designated parameter to the given java.sql.RowId object. The
   driver converts this to a SQL ROWID value when it sends it
   to the database

  parameter-index - the first parameter is 1, the second is 2, ... - `int`
  x - the parameter value - `java.sql.RowId`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^javax.sql.rowset.BaseRowSet this ^Integer parameter-index ^java.sql.RowId x]
    (-> this (.setRowId parameter-index x))))

(defn get-password
  "Returns the password used to create a database connection for this
   RowSet object.  Because the password property is not
   serialized, it is set at run time before calling the method
   execute. The default value is null

  returns: the String object that represents the password
           that must be supplied to the database to create a connection - `java.lang.String`"
  (^java.lang.String [^javax.sql.rowset.BaseRowSet this]
    (-> this (.getPassword))))

(defn get-params
  "Retrieves an array containing the parameter values (both Objects and
   primitives) that have been set for this
   RowSet object's command and throws an SQLException object
   if all parameters have not been set.   Before the command is sent to the
   DBMS to be executed, these parameters will be substituted
   for placeholder parameters in the  PreparedStatement object
   that is the command for a RowSet implementation extending
   the BaseRowSet class.

   Each element in the array that is returned is an Object instance
   that contains the values of the parameters supplied to a setter method.
   The order of the elements is determined by the value supplied for
   parameterIndex.  If the setter method takes only the parameter index
   and the value to be set (possibly null), the array element will contain the value to be set
   (which will be expressed as an Object).  If there are additional
   parameters, the array element will itself be an array containing the value to be set
   plus any additional parameter values supplied to the setter method. If the method
   sets a stream, the array element includes the type of stream being supplied to the
   method. These additional parameters are for the use of the driver or the DBMS and may or
   may not be used.

   NOTE: Stored parameter values of types Array, Blob,
   Clob and Ref are returned as SerialArray,
   SerialBlob, SerialClob and SerialRef
   respectively.

  returns: an array of Object instances that includes the
           parameter values that may be set in this RowSet object's
           command; an empty array if no parameters have been set - `java.lang.Object[]`

  throws: java.sql.SQLException - if an error occurs retrieving the object array of parameters of this RowSet object or if not all parameters have been set"
  ([^javax.sql.rowset.BaseRowSet this]
    (-> this (.getParams))))

