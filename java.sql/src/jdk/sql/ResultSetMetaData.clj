(ns jdk.sql.ResultSetMetaData
  "An object that can be used to get information about the types
  and properties of the columns in a ResultSet object.
  The following code fragment creates the ResultSet object rs,
  creates the ResultSetMetaData object rsmd, and uses rsmd
  to find out how many columns rs has and whether the first column in rs
  can be used in a WHERE clause.


      ResultSet rs = stmt.executeQuery(`SELECT a, b, c FROM TABLE2`);
      ResultSetMetaData rsmd = rs.getMetaData();
      int numberOfColumns = rsmd.getColumnCount();
      boolean b = rsmd.isSearchable(1);"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql ResultSetMetaData]))

(defn get-table-name
  "Gets the designated column's table name.

  column - the first column is 1, the second is 2, ... - `int`

  returns: table name or `` if not applicable - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this ^Integer column]
    (-> this (.getTableName column))))

(defn get-column-label
  "Gets the designated column's suggested title for use in printouts and
   displays. The suggested title is usually specified by the SQL AS
   clause.  If a SQL AS is not specified, the value returned from
   getColumnLabel will be the same as the value returned by the
   getColumnName method.

  column - the first column is 1, the second is 2, ... - `int`

  returns: the suggested column title - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this ^Integer column]
    (-> this (.getColumnLabel column))))

(defn get-precision
  "Get the designated column's specified column size.
   For numeric data, this is the maximum precision.  For character data, this is the length in characters.
   For datetime datatypes, this is the length in characters of the String representation (assuming the
   maximum allowed precision of the fractional seconds component). For binary data, this is the length in bytes.  For the ROWID datatype,
   this is the length in bytes. 0 is returned for data types where the
   column size is not applicable.

  column - the first column is 1, the second is 2, ... - `int`

  returns: precision - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this ^Integer column]
    (-> this (.getPrecision column))))

(defn get-catalog-name
  "Gets the designated column's table's catalog name.

  column - the first column is 1, the second is 2, ... - `int`

  returns: the name of the catalog for the table in which the given column
            appears or `` if not applicable - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this ^Integer column]
    (-> this (.getCatalogName column))))

(defn definitely-writable?
  "Indicates whether a write on the designated column will definitely succeed.

  column - the first column is 1, the second is 2, ... - `int`

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this ^Integer column]
    (-> this (.isDefinitelyWritable column))))

(defn searchable?
  "Indicates whether the designated column can be used in a where clause.

  column - the first column is 1, the second is 2, ... - `int`

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this ^Integer column]
    (-> this (.isSearchable column))))

(defn get-column-count
  "Returns the number of columns in this ResultSet object.

  returns: the number of columns - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this]
    (-> this (.getColumnCount))))

(defn get-column-display-size
  "Indicates the designated column's normal maximum width in characters.

  column - the first column is 1, the second is 2, ... - `int`

  returns: the normal maximum number of characters allowed as the width
            of the designated column - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this ^Integer column]
    (-> this (.getColumnDisplaySize column))))

(defn auto-increment?
  "Indicates whether the designated column is automatically numbered.

  column - the first column is 1, the second is 2, ... - `int`

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this ^Integer column]
    (-> this (.isAutoIncrement column))))

(defn get-schema-name
  "Get the designated column's table's schema.

  column - the first column is 1, the second is 2, ... - `int`

  returns: schema name or `` if not applicable - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this ^Integer column]
    (-> this (.getSchemaName column))))

(defn get-column-type
  "Retrieves the designated column's SQL type.

  column - the first column is 1, the second is 2, ... - `int`

  returns: SQL type from java.sql.Types - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this ^Integer column]
    (-> this (.getColumnType column))))

(defn get-column-type-name
  "Retrieves the designated column's database-specific type name.

  column - the first column is 1, the second is 2, ... - `int`

  returns: type name used by the database. If the column type is
   a user-defined type, then a fully-qualified type name is returned. - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this ^Integer column]
    (-> this (.getColumnTypeName column))))

(defn currency?
  "Indicates whether the designated column is a cash value.

  column - the first column is 1, the second is 2, ... - `int`

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this ^Integer column]
    (-> this (.isCurrency column))))

(defn get-scale
  "Gets the designated column's number of digits to right of the decimal point.
   0 is returned for data types where the scale is not applicable.

  column - the first column is 1, the second is 2, ... - `int`

  returns: scale - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this ^Integer column]
    (-> this (.getScale column))))

(defn get-column-name
  "Get the designated column's name.

  column - the first column is 1, the second is 2, ... - `int`

  returns: column name - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this ^Integer column]
    (-> this (.getColumnName column))))

(defn get-column-class-name
  "Returns the fully-qualified name of the Java class whose instances
   are manufactured if the method ResultSet.getObject
   is called to retrieve a value
   from the column.  ResultSet.getObject may return a subclass of the
   class returned by this method.

  column - the first column is 1, the second is 2, ... - `int`

  returns: the fully-qualified name of the class in the Java programming
           language that would be used by the method
   ResultSet.getObject to retrieve the value in the specified
   column. This is the class name used for custom mapping. - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this ^Integer column]
    (-> this (.getColumnClassName column))))

(defn signed?
  "Indicates whether values in the designated column are signed numbers.

  column - the first column is 1, the second is 2, ... - `int`

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this ^Integer column]
    (-> this (.isSigned column))))

(defn is-nullable
  "Indicates the nullability of values in the designated column.

  column - the first column is 1, the second is 2, ... - `int`

  returns: the nullability status of the given column; one of columnNoNulls,
            columnNullable or columnNullableUnknown - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this ^Integer column]
    (-> this (.isNullable column))))

(defn writable?
  "Indicates whether it is possible for a write on the designated column to succeed.

  column - the first column is 1, the second is 2, ... - `int`

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this ^Integer column]
    (-> this (.isWritable column))))

(defn read-only?
  "Indicates whether the designated column is definitely not writable.

  column - the first column is 1, the second is 2, ... - `int`

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this ^Integer column]
    (-> this (.isReadOnly column))))

(defn case-sensitive?
  "Indicates whether a column's case matters.

  column - the first column is 1, the second is 2, ... - `int`

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ResultSetMetaData this ^Integer column]
    (-> this (.isCaseSensitive column))))

