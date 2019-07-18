(ns javax.sql.rowset.RowSetMetaDataImpl
  "Provides implementations for the methods that set and get
  metadata information about a RowSet object's columns.
  A RowSetMetaDataImpl object keeps track of the
  number of columns in the rowset and maintains an internal array
  of column attributes for each column.

  A RowSet object creates a RowSetMetaDataImpl
  object internally in order to set and retrieve information about
  its columns.

  NOTE: All metadata in a RowSetMetaDataImpl object
  should be considered as unavailable until the RowSet object
  that it describes is populated.
  Therefore, any RowSetMetaDataImpl method that retrieves information
  is defined as having unspecified behavior when it is called
  before the RowSet object contains data."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset RowSetMetaDataImpl]))

(defn ->row-set-meta-data-impl
  "Constructor."
  (^RowSetMetaDataImpl []
    (new RowSetMetaDataImpl )))

(defn get-table-name
  "Retrieves the name of the table from which the value
   in the designated column was derived.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`

  returns: the table name or an empty String if no table name
           is available - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  (^java.lang.String [^RowSetMetaDataImpl this ^Integer column-index]
    (-> this (.getTableName column-index))))

(defn get-column-label
  "Retrieves the suggested column title for the designated
   column for use in printouts and displays.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`

  returns: the suggested column name to use in printouts and displays - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  (^java.lang.String [^RowSetMetaDataImpl this ^Integer column-index]
    (-> this (.getColumnLabel column-index))))

(defn get-precision
  "Retrieves the total number of digits for values stored in
   the designated column.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`

  returns: the precision for values stored in the designated column - `int`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  (^Integer [^RowSetMetaDataImpl this ^Integer column-index]
    (-> this (.getPrecision column-index))))

(defn get-catalog-name
  "Retrieves the catalog name of the table from which the value
   in the designated column was derived.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`

  returns: the catalog name of the column's table or an empty
           String if no catalog name is available - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  (^java.lang.String [^RowSetMetaDataImpl this ^Integer column-index]
    (-> this (.getCatalogName column-index))))

(defn set-precision
  "Sets the total number of decimal digits in a value stored in the
   designated column to the given number.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`
  precision - the total number of decimal digits; must be 0 or more - `int`

  throws: java.sql.SQLException - if a database access error occurs, columnIndex is out of bounds, or precision is less than 0"
  ([^RowSetMetaDataImpl this ^Integer column-index ^Integer precision]
    (-> this (.setPrecision column-index precision))))

(defn set-column-type-name
  "Sets the type name used by the data source for values stored in the
   designated column to the given type name.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`
  type-name - the data source-specific type name; if typeName is null, an empty String is set - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  ([^RowSetMetaDataImpl this ^Integer column-index ^java.lang.String type-name]
    (-> this (.setColumnTypeName column-index type-name))))

(defn definitely-writable?
  "Indicates whether a write operation on the designated column
   will definitely succeed.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`

  returns: true if a write operation on the designated column will
           definitely succeed; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  (^Boolean [^RowSetMetaDataImpl this ^Integer column-index]
    (-> this (.isDefinitelyWritable column-index))))

(defn set-case-sensitive
  "Sets whether the name of the designated column is case sensitive to
   the given boolean.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns in the rowset, inclusive - `int`
  property - true to indicate that the column name is case sensitive; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  ([^RowSetMetaDataImpl this ^Integer column-index ^Boolean property]
    (-> this (.setCaseSensitive column-index property))))

(defn set-signed
  "Sets whether a value stored in the designated column is a signed
   number to the given boolean.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`
  property - true to indicate that a column value is a signed number; false to indicate that it is not - `boolean`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  ([^RowSetMetaDataImpl this ^Integer column-index ^Boolean property]
    (-> this (.setSigned column-index property))))

(defn searchable?
  "Indicates whether a value stored in the designated column
   can be used in a WHERE clause.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`

  returns: true if a value in the designated column can be used in a
           WHERE clause; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  (^Boolean [^RowSetMetaDataImpl this ^Integer column-index]
    (-> this (.isSearchable column-index))))

(defn set-auto-increment
  "Sets whether the designated column is automatically
   numbered, thus read-only, to the given boolean
   value.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns in the rowset, inclusive - `int`
  property - true if the given column is automatically incremented; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs or the given index is out of bounds"
  ([^RowSetMetaDataImpl this ^Integer column-index ^Boolean property]
    (-> this (.setAutoIncrement column-index property))))

(defn set-currency
  "Sets whether a value stored in the designated column is a cash
   value to the given boolean.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive between 1 and the number of columns, inclusive - `int`
  property - true if the value is a cash value; false otherwise. - `boolean`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  ([^RowSetMetaDataImpl this ^Integer column-index ^Boolean property]
    (-> this (.setCurrency column-index property))))

(defn set-column-label
  "Sets the suggested column label for use in printouts and
   displays, if any, to label. If label is
   null, the column label is set to an empty string
   (``).

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`
  label - the column label to be used in printouts and displays; if the column label is null, an empty String is set - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs or the given column index is out of bounds"
  ([^RowSetMetaDataImpl this ^Integer column-index ^java.lang.String label]
    (-> this (.setColumnLabel column-index label))))

(defn set-schema-name
  "Sets the designated column's table's schema name, if any, to
   schemaName. If schemaName is null,
   the schema name is set to an empty string (``).

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`
  schema-name - the schema name for the table from which a value in the designated column was derived; may be an empty String or null - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  ([^RowSetMetaDataImpl this ^Integer column-index ^java.lang.String schema-name]
    (-> this (.setSchemaName column-index schema-name))))

(defn get-column-count
  "Retrieves the number of columns in the RowSet object
   for which this RowSetMetaDataImpl object was created.

  returns: the number of columns - `int`

  throws: java.sql.SQLException - if an error occurs determining the column count"
  (^Integer [^RowSetMetaDataImpl this]
    (-> this (.getColumnCount))))

(defn get-column-display-size
  "Retrieves the normal maximum width in chars of the designated column.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`

  returns: the maximum number of chars that can be displayed in the designated
           column - `int`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  (^Integer [^RowSetMetaDataImpl this ^Integer column-index]
    (-> this (.getColumnDisplaySize column-index))))

(defn auto-increment?
  "Retrieves whether a value stored in the designated column is
   automatically numbered, and thus readonly.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`

  returns: true if the column is automatically numbered;
           false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  (^Boolean [^RowSetMetaDataImpl this ^Integer column-index]
    (-> this (.isAutoIncrement column-index))))

(defn set-searchable
  "Sets whether a value stored in the designated column can be used
   in a WHERE clause to the given boolean value.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns in the rowset, inclusive - `int`
  property - true to indicate that a column value can be used in a WHERE clause; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  ([^RowSetMetaDataImpl this ^Integer column-index ^Boolean property]
    (-> this (.setSearchable column-index property))))

(defn get-schema-name
  "Retrieves the schema name of the table from which the value
   in the designated column was derived.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`

  returns: the schema name or an empty String if no schema
           name is available - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  (^java.lang.String [^RowSetMetaDataImpl this ^Integer column-index]
    (-> this (.getSchemaName column-index))))

(defn unwrap
  "Returns an object that implements the given interface to allow access to non-standard methods,
   or standard methods not exposed by the proxy.
   The result may be either the object found to implement the interface or a proxy for that object.
   If the receiver implements the interface then that is the object. If the receiver is a wrapper
   and the wrapped object implements the interface then that is the object. Otherwise the object is
    the result of calling unwrap recursively on the wrapped object. If the receiver is not a
   wrapper and does not implement the interface, then an SQLException is thrown.

  iface - A Class defining an interface that the result must implement. - `java.lang.Class`

  returns: an object that implements the interface. May be a proxy for the actual implementing object. - `<T> T`

  throws: java.sql.SQLException - If no object found that implements the interface"
  ([^RowSetMetaDataImpl this ^java.lang.Class iface]
    (-> this (.unwrap iface))))

(defn set-nullable
  "Sets whether a value stored in the designated column can be set
   to NULL to the given constant from the interface
   ResultSetMetaData.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`
  property - one of the following ResultSetMetaData constants: columnNoNulls, columnNullable, or columnNullableUnknown - `int`

  throws: java.sql.SQLException - if a database access error occurs, the given column number is out of bounds, or the value supplied for the property parameter is not one of the following constants: ResultSetMetaData.columnNoNulls, ResultSetMetaData.columnNullable, or ResultSetMetaData.columnNullableUnknown"
  ([^RowSetMetaDataImpl this ^Integer column-index ^Integer property]
    (-> this (.setNullable column-index property))))

(defn set-catalog-name
  "Sets the catalog name of the table from which the designated
   column was derived to catalogName. If catalogName
   is null, the catalog name is set to an empty string.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`
  catalog-name - the column's table's catalog name; if the catalogName is null, an empty String is set - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  ([^RowSetMetaDataImpl this ^Integer column-index ^java.lang.String catalog-name]
    (-> this (.setCatalogName column-index catalog-name))))

(defn set-table-name
  "Sets the name of the table from which the designated column
   was derived to the given table name.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`
  table-name - the column's table name; may be null or an empty string - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  ([^RowSetMetaDataImpl this ^Integer column-index ^java.lang.String table-name]
    (-> this (.setTableName column-index table-name))))

(defn get-column-type
  "Retrieves the type code (one of the java.sql.Types
   constants) for the SQL type of the value stored in the
   designated column.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`

  returns: an int representing the SQL type of values
   stored in the designated column - `int`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  (^Integer [^RowSetMetaDataImpl this ^Integer column-index]
    (-> this (.getColumnType column-index))))

(defn get-column-type-name
  "Retrieves the DBMS-specific type name for values stored in the
   designated column.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`

  returns: the type name used by the data source - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  (^java.lang.String [^RowSetMetaDataImpl this ^Integer column-index]
    (-> this (.getColumnTypeName column-index))))

(defn currency?
  "Indicates whether a value stored in the designated column
   is a cash value.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`

  returns: true if a value in the designated column is a cash value;
           false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  (^Boolean [^RowSetMetaDataImpl this ^Integer column-index]
    (-> this (.isCurrency column-index))))

(defn get-scale
  "Retrieves the number of digits to the right of the decimal point
   for values stored in the designated column.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`

  returns: the scale for values stored in the designated column - `int`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  (^Integer [^RowSetMetaDataImpl this ^Integer column-index]
    (-> this (.getScale column-index))))

(defn get-column-name
  "Retrieves the name of the designated column.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`

  returns: the column name of the designated column - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  (^java.lang.String [^RowSetMetaDataImpl this ^Integer column-index]
    (-> this (.getColumnName column-index))))

(defn set-column-display-size
  "Sets the normal maximum number of chars in the designated column
   to the given number.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`
  size - the maximum size of the column in chars; must be 0 or more - `int`

  throws: java.sql.SQLException - if a database access error occurs, the given column number is out of bounds, or size is less than 0"
  ([^RowSetMetaDataImpl this ^Integer column-index ^Integer size]
    (-> this (.setColumnDisplaySize column-index size))))

(defn get-column-class-name
  "Retrieves the fully-qualified name of the class in the Java
   programming language to which a value in the designated column
   will be mapped.  For example, if the value is an int,
   the class name returned by this method will be
   java.lang.Integer.

   If the value in the designated column has a custom mapping,
   this method returns the name of the class that implements
   SQLData. When the method ResultSet.getObject
   is called to retrieve a value from the designated column, it will
   create an instance of this class or one of its subclasses.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`

  returns: the fully-qualified name of the class in the Java programming
          language that would be used by the method RowSet.getObject to
          retrieve the value in the specified column. This is the class
          name used for custom mapping when there is a custom mapping. - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  (^java.lang.String [^RowSetMetaDataImpl this ^Integer column-index]
    (-> this (.getColumnClassName column-index))))

(defn set-column-count
  "Sets to the given number the number of columns in the RowSet
   object for which this RowSetMetaDataImpl object was created.

  column-count - an int giving the number of columns in the RowSet object - `int`

  throws: java.sql.SQLException - if the given number is equal to or less than zero"
  ([^RowSetMetaDataImpl this ^Integer column-count]
    (-> this (.setColumnCount column-count))))

(defn signed?
  "Indicates whether a value stored in the designated column is
   a signed number.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`

  returns: true if a value in the designated column is a signed
           number; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  (^Boolean [^RowSetMetaDataImpl this ^Integer column-index]
    (-> this (.isSigned column-index))))

(defn set-column-type
  "Sets the SQL type code for values stored in the designated column
   to the given type code from the class java.sql.Types.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`
  sql-type - the designated column's SQL type, which must be one of the constants in the class java.sql.Types - `int`

  throws: java.sql.SQLException - if a database access error occurs, the given column number is out of bounds, or the column type specified is not one of the constants in java.sql.Types"
  ([^RowSetMetaDataImpl this ^Integer column-index ^Integer sql-type]
    (-> this (.setColumnType column-index sql-type))))

(defn is-nullable
  "Retrieves a constant indicating whether it is possible
   to store a NULL value in the designated column.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`

  returns: a constant from the ResultSetMetaData interface;
           either columnNoNulls,
           columnNullable, or
           columnNullableUnknown - `int`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  (^Integer [^RowSetMetaDataImpl this ^Integer column-index]
    (-> this (.isNullable column-index))))

(defn set-scale
  "Sets the number of digits to the right of the decimal point in a value
   stored in the designated column to the given number.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`
  scale - the number of digits to the right of the decimal point; must be zero or greater - `int`

  throws: java.sql.SQLException - if a database access error occurs, columnIndex is out of bounds, or scale is less than 0"
  ([^RowSetMetaDataImpl this ^Integer column-index ^Integer scale]
    (-> this (.setScale column-index scale))))

(defn writable?
  "Indicates whether it is possible for a write operation on
   the designated column to succeed. A return value of
   true means that a write operation may or may
   not succeed.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`

  returns: true if a write operation on the designated column may
            will succeed; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  (^Boolean [^RowSetMetaDataImpl this ^Integer column-index]
    (-> this (.isWritable column-index))))

(defn set-column-name
  "Sets the column name of the designated column to the given name.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`
  column-name - a String object indicating the column name; if the given name is null, an empty String is set - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs or the given column index is out of bounds"
  ([^RowSetMetaDataImpl this ^Integer column-index ^java.lang.String column-name]
    (-> this (.setColumnName column-index column-name))))

(defn read-only?
  "Indicates whether the designated column is definitely
   not writable, thus readonly.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`

  returns: true if this RowSet object is read-Only
   and thus not updatable; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  (^Boolean [^RowSetMetaDataImpl this ^Integer column-index]
    (-> this (.isReadOnly column-index))))

(defn wrapper-for?
  "Returns true if this either implements the interface argument or is directly or indirectly a wrapper
   for an object that does. Returns false otherwise. If this implements the interface then return true,
   else if this is a wrapper then return the result of recursively calling isWrapperFor on the wrapped
   object. If this does not implement the interface and is not a wrapper, return false.
   This method should be implemented as a low-cost operation compared to unwrap so that
   callers can use this method to avoid expensive unwrap calls that may fail. If this method
   returns true then calling unwrap with the same argument should succeed.

  interfaces - a Class defining an interface. - `java.lang.Class`

  returns: true if this implements the interface or directly or indirectly wraps an object that does. - `boolean`

  throws: java.sql.SQLException - if an error occurs while determining whether this is a wrapper for an object with the given interface."
  (^Boolean [^RowSetMetaDataImpl this ^java.lang.Class interfaces]
    (-> this (.isWrapperFor interfaces))))

(defn case-sensitive?
  "Indicates whether the case of the designated column's name
   matters.

  column-index - the first column is 1, the second is 2, and so on; must be between 1 and the number of columns, inclusive - `int`

  returns: true if the column name is case sensitive;
            false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs or the given column number is out of bounds"
  (^Boolean [^RowSetMetaDataImpl this ^Integer column-index]
    (-> this (.isCaseSensitive column-index))))

