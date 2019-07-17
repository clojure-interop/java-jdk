(ns javax.sql.RowSetMetaData
  "An object that contains information about the columns in a
  RowSet object.  This interface is
  an extension of the ResultSetMetaData interface with
  methods for setting the values in a RowSetMetaData object.
  When a RowSetReader object reads data into a RowSet
  object, it creates a RowSetMetaData object and initializes it
  using the methods in the RowSetMetaData interface.  Then the
  reader passes the RowSetMetaData object to the rowset.

  The methods in this interface are invoked internally when an application
  calls the method RowSet.execute; an application
  programmer would not use them directly."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql RowSetMetaData]))

(defn set-precision
  "Sets the designated column's number of decimal digits to the
   given int.

  column-index - the first column is 1, the second is 2, ... - `int`
  precision - the total number of decimal digits - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this column-index precision]
    (-> this (.setPrecision column-index precision))))

(defn set-column-type-name
  "Sets the designated column's type name that is specific to the
   data source, if any, to the given String.

  column-index - the first column is 1, the second is 2, ... - `int`
  type-name - data source specific type name. - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this column-index type-name]
    (-> this (.setColumnTypeName column-index type-name))))

(defn set-case-sensitive
  "Sets whether the designated column is case sensitive.
   The default is false.

  column-index - the first column is 1, the second is 2, ... - `int`
  property - true if the column is case sensitive; false if it is not - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this column-index property]
    (-> this (.setCaseSensitive column-index property))))

(defn set-signed
  "Sets whether the designated column is a signed number.
   The default is false.

  column-index - the first column is 1, the second is 2, ... - `int`
  property - true if the column is a signed number; false if it is not - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this column-index property]
    (-> this (.setSigned column-index property))))

(defn set-auto-increment
  "Sets whether the designated column is automatically numbered,
   The default is for a RowSet object's
   columns not to be automatically numbered.

  column-index - the first column is 1, the second is 2, ... - `int`
  property - true if the column is automatically numbered; false if it is not - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this column-index property]
    (-> this (.setAutoIncrement column-index property))))

(defn set-currency
  "Sets whether the designated column is a cash value.
   The default is false.

  column-index - the first column is 1, the second is 2, ... - `int`
  property - true if the column is a cash value; false if it is not - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this column-index property]
    (-> this (.setCurrency column-index property))))

(defn set-column-label
  "Sets the suggested column title for use in printouts and
   displays, if any, to the given String.

  column-index - the first column is 1, the second is 2, ... - `int`
  label - the column title - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this column-index label]
    (-> this (.setColumnLabel column-index label))))

(defn set-schema-name
  "Sets the name of the designated column's table's schema, if any, to
   the given String.

  column-index - the first column is 1, the second is 2, ... - `int`
  schema-name - the schema name - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this column-index schema-name]
    (-> this (.setSchemaName column-index schema-name))))

(defn set-searchable
  "Sets whether the designated column can be used in a where clause.
   The default is false.

  column-index - the first column is 1, the second is 2, ... - `int`
  property - true if the column can be used in a WHERE clause; false if it cannot - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this column-index property]
    (-> this (.setSearchable column-index property))))

(defn set-nullable
  "Sets whether the designated column's value can be set to
   NULL.
   The default is ResultSetMetaData.columnNullableUnknown

  column-index - the first column is 1, the second is 2, ... - `int`
  property - one of the following constants: ResultSetMetaData.columnNoNulls, ResultSetMetaData.columnNullable, or ResultSetMetaData.columnNullableUnknown - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this column-index property]
    (-> this (.setNullable column-index property))))

(defn set-catalog-name
  "Sets the designated column's table's catalog name, if any, to the given
   String.

  column-index - the first column is 1, the second is 2, ... - `int`
  catalog-name - the column's catalog name - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this column-index catalog-name]
    (-> this (.setCatalogName column-index catalog-name))))

(defn set-table-name
  "Sets the designated column's table name, if any, to the given
   String.

  column-index - the first column is 1, the second is 2, ... - `int`
  table-name - the column's table name - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this column-index table-name]
    (-> this (.setTableName column-index table-name))))

(defn set-column-display-size
  "Sets the designated column's normal maximum width in chars to the
   given int.

  column-index - the first column is 1, the second is 2, ... - `int`
  size - the normal maximum number of characters for the designated column - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this column-index size]
    (-> this (.setColumnDisplaySize column-index size))))

(defn set-column-count
  "Sets the number of columns in the RowSet object to
   the given number.

  column-count - the number of columns in the RowSet object - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this column-count]
    (-> this (.setColumnCount column-count))))

(defn set-column-type
  "Sets the designated column's SQL type to the one given.

  column-index - the first column is 1, the second is 2, ... - `int`
  sql-type - the column's SQL type - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this column-index sql-type]
    (-> this (.setColumnType column-index sql-type))))

(defn set-scale
  "Sets the designated column's number of digits to the
   right of the decimal point to the given int.

  column-index - the first column is 1, the second is 2, ... - `int`
  scale - the number of digits to right of decimal point - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this column-index scale]
    (-> this (.setScale column-index scale))))

(defn set-column-name
  "Sets the name of the designated column to the given String.

  column-index - the first column is 1, the second is 2, ... - `int`
  column-name - the designated column's name - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this column-index column-name]
    (-> this (.setColumnName column-index column-name))))

