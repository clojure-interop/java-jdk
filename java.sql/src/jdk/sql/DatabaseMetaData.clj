(ns jdk.sql.DatabaseMetaData
  "Comprehensive information about the database as a whole.

  This interface is implemented by driver vendors to let users know the capabilities
  of a Database Management System (DBMS) in combination with
  the driver based on JDBC™ technology
  (\"JDBC driver\") that is used with it.  Different relational DBMSs often support
  different features, implement features in different ways, and use different
  data types.  In addition, a driver may implement a feature on top of what the
  DBMS offers.  Information returned by methods in this interface applies
  to the capabilities of a particular driver and a particular DBMS working
  together. Note that as used in this documentation, the term \"database\" is
  used generically to refer to both the driver and DBMS.

  A user for this interface is commonly a tool that needs to discover how to
  deal with the underlying DBMS.  This is especially true for applications
  that are intended to be used with more than one DBMS. For example, a tool might use the method
  getTypeInfo to find out what data types can be used in a
  CREATE TABLE statement.  Or a user might call the method
  supportsCorrelatedSubqueries to see if it is possible to use
  a correlated subquery or supportsBatchUpdates to see if it is
  possible to use batch updates.

  Some DatabaseMetaData methods return lists of information
  in the form of ResultSet objects.
  Regular ResultSet methods, such as
  getString and getInt, can be used
  to retrieve the data from these ResultSet objects.  If
  a given form of metadata is not available, an empty ResultSet
  will be returned. Additional columns beyond the columns defined to be
  returned by the ResultSet object for a given method
  can be defined by the JDBC driver vendor and must be accessed
  by their column label.

  Some DatabaseMetaData methods take arguments that are
  String patterns.  These arguments all have names such as fooPattern.
  Within a pattern String, \"%\" means match any substring of 0 or more
  characters, and \"_\" means match any one character. Only metadata
  entries matching the search pattern are returned. If a search pattern
  argument is set to null, that argument's criterion will
  be dropped from the search."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql DatabaseMetaData]))

(defn nulls-are-sorted-high
  "Retrieves whether NULL values are sorted high.
   Sorted high means that NULL values
   sort higher than any other value in a domain.  In an ascending order,
   if this method returns true,  NULL values
   will appear at the end. By contrast, the method
   nullsAreSortedAtEnd indicates whether NULL values
   are sorted at the end regardless of sort order.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.nullsAreSortedHigh))))

(defn auto-commit-failure-closes-all-result-sets
  "Retrieves whether a SQLException while autoCommit is true indicates
   that all open ResultSets are closed, even ones that are holdable.  When a SQLException occurs while
   autocommit is true, it is vendor specific whether the JDBC driver responds with a commit operation, a
   rollback operation, or by doing neither a commit nor a rollback.  A potential result of this difference
   is in whether or not holdable ResultSets are closed.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.autoCommitFailureClosesAllResultSets))))

(defn get-database-product-version
  "Retrieves the version number of this database product.

  returns: database version number - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.lang.String [^DatabaseMetaData this]
    (-> this (.getDatabaseProductVersion))))

(defn supports-stored-procedures
  "Retrieves whether this database supports stored procedure calls
   that use the stored procedure escape syntax.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsStoredProcedures))))

(defn get-max-columns-in-table
  "Retrieves the maximum number of columns this database allows in a table.

  returns: the maximum number of columns allowed;
        a result of zero means that there is no limit or the limit
        is not known - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getMaxColumnsInTable))))

(defn get-functions
  "Retrieves a description of the  system and user functions available
   in the given catalog.

   Only system and user function descriptions matching the schema and
   function name criteria are returned.  They are ordered by
   FUNCTION_CAT, FUNCTION_SCHEM,
   FUNCTION_NAME and
   SPECIFIC_ NAME.

   Each function description has the the following columns:

    FUNCTION_CAT String => function catalog (may be null)
    FUNCTION_SCHEM String => function schema (may be null)
    FUNCTION_NAME String => function name.  This is the name
   used to invoke the function
    REMARKS String => explanatory comment on the function
   FUNCTION_TYPE short => kind of function:

        functionResultUnknown - Cannot determine if a return value
         or table will be returned
         functionNoTable- Does not return a table
         functionReturnsTable - Returns a table

    SPECIFIC_NAME String  => the name which uniquely identifies
    this function within its schema.  This is a user specified, or DBMS
   generated, name that may be different then the FUNCTION_NAME
   for example with overload functions


   A user may not have permission to execute any of the functions that are
   returned by getFunctions

  catalog - a catalog name; must match the catalog name as it is stored in the database; \"\" retrieves those without a catalog; null means that the catalog name should not be used to narrow the search - `java.lang.String`
  schema-pattern - a schema name pattern; must match the schema name as it is stored in the database; \"\" retrieves those without a schema; null means that the schema name should not be used to narrow the search - `java.lang.String`
  function-name-pattern - a function name pattern; must match the function name as it is stored in the database - `java.lang.String`

  returns: ResultSet - each row is a function description - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String catalog ^java.lang.String schema-pattern ^java.lang.String function-name-pattern]
    (-> this (.getFunctions catalog schema-pattern function-name-pattern))))

(defn get-max-statement-length
  "Retrieves the maximum number of characters this database allows in
   an SQL statement.

  returns: the maximum number of characters allowed for an SQL statement;
        a result of zero means that there is no limit or the limit
        is not known - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getMaxStatementLength))))

(defn supports-statement-pooling
  "Retrieves whether this database supports statement pooling.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsStatementPooling))))

(defn others-deletes-are-visible
  "Retrieves whether deletes made by others are visible.

  type - the ResultSet type; one of ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE - `int`

  returns: true if deletes made by others
          are visible for the given result set type;
          false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this ^Integer type]
    (-> this (.othersDeletesAreVisible type))))

(defn get-exported-keys
  "Retrieves a description of the foreign key columns that reference the
   given table's primary key columns (the foreign keys exported by a
   table).  They are ordered by FKTABLE_CAT, FKTABLE_SCHEM,
   FKTABLE_NAME, and KEY_SEQ.

   Each foreign key column description has the following columns:

    PKTABLE_CAT String => primary key table catalog (may be null)
    PKTABLE_SCHEM String => primary key table schema (may be null)
    PKTABLE_NAME String => primary key table name
    PKCOLUMN_NAME String => primary key column name
    FKTABLE_CAT String => foreign key table catalog (may be null)
        being exported (may be null)
    FKTABLE_SCHEM String => foreign key table schema (may be null)
        being exported (may be null)
    FKTABLE_NAME String => foreign key table name
        being exported
    FKCOLUMN_NAME String => foreign key column name
        being exported
    KEY_SEQ short => sequence number within foreign key( a value
    of 1 represents the first column of the foreign key, a value of 2 would
    represent the second column within the foreign key).
    UPDATE_RULE short => What happens to
         foreign key when primary is updated:

         importedNoAction - do not allow update of primary
                 key if it has been imported
         importedKeyCascade - change imported key to agree
                 with primary key update
         importedKeySetNull - change imported key to NULL if
                 its primary key has been updated
         importedKeySetDefault - change imported key to default values
                 if its primary key has been updated
         importedKeyRestrict - same as importedKeyNoAction
                                   (for ODBC 2.x compatibility)

    DELETE_RULE short => What happens to
        the foreign key when primary is deleted.

         importedKeyNoAction - do not allow delete of primary
                 key if it has been imported
         importedKeyCascade - delete rows that import a deleted key
         importedKeySetNull - change imported key to NULL if
                 its primary key has been deleted
         importedKeyRestrict - same as importedKeyNoAction
                                   (for ODBC 2.x compatibility)
         importedKeySetDefault - change imported key to default if
                 its primary key has been deleted

    FK_NAME String => foreign key name (may be null)
    PK_NAME String => primary key name (may be null)
    DEFERRABILITY short => can the evaluation of foreign key
        constraints be deferred until commit

         importedKeyInitiallyDeferred - see SQL92 for definition
         importedKeyInitiallyImmediate - see SQL92 for definition
         importedKeyNotDeferrable - see SQL92 for definition

  catalog - a catalog name; must match the catalog name as it is stored in this database; \"\" retrieves those without a catalog; null means that the catalog name should not be used to narrow the search - `java.lang.String`
  schema - a schema name; must match the schema name as it is stored in the database; \"\" retrieves those without a schema; null means that the schema name should not be used to narrow the search - `java.lang.String`
  table - a table name; must match the table name as it is stored in this database - `java.lang.String`

  returns: a ResultSet object in which each row is a
           foreign key column description - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String catalog ^java.lang.String schema ^java.lang.String table]
    (-> this (.getExportedKeys catalog schema table))))

(defn stores-lower-case-quoted-identifiers
  "Retrieves whether this database treats mixed case quoted SQL identifiers as
   case insensitive and stores them in lower case.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.storesLowerCaseQuotedIdentifiers))))

(defn supports-ansi-92-entry-level-sql
  "Retrieves whether this database supports the ANSI92 entry level SQL
   grammar.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsANSI92EntryLevelSQL))))

(defn stores-upper-case-quoted-identifiers
  "Retrieves whether this database treats mixed case quoted SQL identifiers as
   case insensitive and stores them in upper case.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.storesUpperCaseQuotedIdentifiers))))

(defn others-updates-are-visible
  "Retrieves whether updates made by others are visible.

  type - the ResultSet type; one of ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE - `int`

  returns: true if updates made by others
          are visible for the given result set type;
          false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this ^Integer type]
    (-> this (.othersUpdatesAreVisible type))))

(defn get-max-columns-in-group-by
  "Retrieves the maximum number of columns this database allows in a
   GROUP BY clause.

  returns: the maximum number of columns allowed;
        a result of zero means that there is no limit or the limit
        is not known - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getMaxColumnsInGroupBy))))

(defn updates-are-detected
  "Retrieves whether or not a visible row update can be detected by
   calling the method ResultSet.rowUpdated.

  type - the ResultSet type; one of ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE - `int`

  returns: true if changes are detected by the result set type;
           false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this ^Integer type]
    (-> this (.updatesAreDetected type))))

(defn own-updates-are-visible
  "Retrieves whether for the given type of ResultSet object,
   the result set's own updates are visible.

  type - the ResultSet type; one of ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE - `int`

  returns: true if updates are visible for the given result set type;
          false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this ^Integer type]
    (-> this (.ownUpdatesAreVisible type))))

(defn uses-local-files
  "Retrieves whether this database stores tables in a local file.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.usesLocalFiles))))

(defn supports-batch-updates
  "Retrieves whether this database supports batch updates.

  returns: true if this database supports batch updates;
           false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsBatchUpdates))))

(defn get-extra-name-characters
  "Retrieves all the \"extra\" characters that can be used in unquoted
   identifier names (those beyond a-z, A-Z, 0-9 and _).

  returns: the string containing the extra characters - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.lang.String [^DatabaseMetaData this]
    (-> this (.getExtraNameCharacters))))

(defn get-database-minor-version
  "Retrieves the minor version number of the underlying database.

  returns: underlying database's minor version - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getDatabaseMinorVersion))))

(defn get-max-index-length
  "Retrieves the maximum number of bytes this database allows for an
   index, including all of the parts of the index.

  returns: the maximum number of bytes allowed; this limit includes the
        composite of all the constituent parts of the index;
        a result of zero means that there is no limit or the limit
        is not known - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getMaxIndexLength))))

(defn get-type-info
  "Retrieves a description of all the data types supported by
   this database. They are ordered by DATA_TYPE and then by how
   closely the data type maps to the corresponding JDBC SQL type.

   If the database supports SQL distinct types, then getTypeInfo() will return
   a single row with a TYPE_NAME of DISTINCT and a DATA_TYPE of Types.DISTINCT.
   If the database supports SQL structured types, then getTypeInfo() will return
   a single row with a TYPE_NAME of STRUCT and a DATA_TYPE of Types.STRUCT.

   If SQL distinct or structured types are supported, then information on the
   individual types may be obtained from the getUDTs() method.



   Each type description has the following columns:

    TYPE_NAME String => Type name
    DATA_TYPE int => SQL data type from java.sql.Types
    PRECISION int => maximum precision
    LITERAL_PREFIX String => prefix used to quote a literal
        (may be null)
    LITERAL_SUFFIX String => suffix used to quote a literal
       (may be null)
    CREATE_PARAMS String => parameters used in creating
        the type (may be null)
    NULLABLE short => can you use NULL for this type.

         typeNoNulls - does not allow NULL values
         typeNullable - allows NULL values
         typeNullableUnknown - nullability unknown

    CASE_SENSITIVE boolean=> is it case sensitive.
    SEARCHABLE short => can you use \"WHERE\" based on this type:

         typePredNone - No support
         typePredChar - Only supported with WHERE .. LIKE
         typePredBasic - Supported except for WHERE .. LIKE
         typeSearchable - Supported for all WHERE ..

    UNSIGNED_ATTRIBUTE boolean => is it unsigned.
    FIXED_PREC_SCALE boolean => can it be a money value.
    AUTO_INCREMENT boolean => can it be used for an
        auto-increment value.
    LOCAL_TYPE_NAME String => localized version of type name
        (may be null)
    MINIMUM_SCALE short => minimum scale supported
    MAXIMUM_SCALE short => maximum scale supported
    SQL_DATA_TYPE int => unused
    SQL_DATETIME_SUB int => unused
    NUM_PREC_RADIX int => usually 2 or 10


   The PRECISION column represents the maximum column size that the server supports for the given datatype.
   For numeric data, this is the maximum precision.  For character data, this is the length in characters.
   For datetime datatypes, this is the length in characters of the String representation (assuming the
   maximum allowed precision of the fractional seconds component). For binary data, this is the length in bytes.  For the ROWID datatype,
   this is the length in bytes. Null is returned for data types where the
   column size is not applicable.

  returns: a ResultSet object in which each row is an SQL
           type description - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this]
    (-> this (.getTypeInfo))))

(defn supports-limited-outer-joins
  "Retrieves whether this database provides limited support for outer
   joins.  (This will be true if the method
   supportsFullOuterJoins returns true).

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsLimitedOuterJoins))))

(defn supports-convert
  "Retrieves whether this database supports the JDBC scalar function
   CONVERT for conversions between the JDBC types fromType
   and toType.  The JDBC types are the generic SQL data types defined
   in java.sql.Types.

  from-type - the type to convert from; one of the type codes from the class java.sql.Types - `int`
  to-type - the type to convert to; one of the type codes from the class java.sql.Types - `int`

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this ^Integer from-type ^Integer to-type]
    (-> this (.supportsConvert from-type to-type)))
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsConvert))))

(defn supports-column-aliasing
  "Retrieves whether this database supports column aliasing.

   If so, the SQL AS clause can be used to provide names for
   computed columns or to provide alias names for columns as
   required.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsColumnAliasing))))

(defn supports-schemas-in-table-definitions
  "Retrieves whether a schema name can be used in a table definition statement.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsSchemasInTableDefinitions))))

(defn get-max-connections
  "Retrieves the maximum number of concurrent connections to this
   database that are possible.

  returns: the maximum number of active connections possible at one time;
        a result of zero means that there is no limit or the limit
        is not known - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getMaxConnections))))

(defn stores-mixed-case-identifiers
  "Retrieves whether this database treats mixed case unquoted SQL identifiers as
   case insensitive and stores them in mixed case.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.storesMixedCaseIdentifiers))))

(defn get-procedure-term
  "Retrieves the database vendor's preferred term for \"procedure\".

  returns: the vendor term for \"procedure\" - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.lang.String [^DatabaseMetaData this]
    (-> this (.getProcedureTerm))))

(defn supports-positioned-delete
  "Retrieves whether this database supports positioned DELETE
   statements.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsPositionedDelete))))

(defn get-primary-keys
  "Retrieves a description of the given table's primary key columns.  They
   are ordered by COLUMN_NAME.

   Each primary key column description has the following columns:

    TABLE_CAT String => table catalog (may be null)
    TABLE_SCHEM String => table schema (may be null)
    TABLE_NAME String => table name
    COLUMN_NAME String => column name
    KEY_SEQ short => sequence number within primary key( a value
    of 1 represents the first column of the primary key, a value of 2 would
    represent the second column within the primary key).
    PK_NAME String => primary key name (may be null)

  catalog - a catalog name; must match the catalog name as it is stored in the database; \"\" retrieves those without a catalog; null means that the catalog name should not be used to narrow the search - `java.lang.String`
  schema - a schema name; must match the schema name as it is stored in the database; \"\" retrieves those without a schema; null means that the schema name should not be used to narrow the search - `java.lang.String`
  table - a table name; must match the table name as it is stored in the database - `java.lang.String`

  returns: ResultSet - each row is a primary key column description - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String catalog ^java.lang.String schema ^java.lang.String table]
    (-> this (.getPrimaryKeys catalog schema table))))

(defn stores-mixed-case-quoted-identifiers
  "Retrieves whether this database treats mixed case quoted SQL identifiers as
   case insensitive and stores them in mixed case.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.storesMixedCaseQuotedIdentifiers))))

(defn supports-select-for-update
  "Retrieves whether this database supports SELECT FOR UPDATE
   statements.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsSelectForUpdate))))

(defn get-max-logical-lob-size
  "Retrieves the maximum number of bytes this database allows for
   the logical size for a LOB.

   The default implementation will return 0

  returns: the maximum number of bytes allowed; a result of zero
   means that there is no limit or the limit is not known - `default long`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^DatabaseMetaData this]
    (-> this (.getMaxLogicalLobSize))))

(defn get-identifier-quote-string
  "Retrieves the string used to quote SQL identifiers.
   This method returns a space \" \" if identifier quoting is not supported.

  returns: the quoting string or a space if quoting is not supported - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.lang.String [^DatabaseMetaData this]
    (-> this (.getIdentifierQuoteString))))

(defn supports-schemas-in-index-definitions
  "Retrieves whether a schema name can be used in an index definition statement.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsSchemasInIndexDefinitions))))

(defn get-max-procedure-name-length
  "Retrieves the maximum number of characters that this database allows in a
   procedure name.

  returns: the maximum number of characters allowed in a procedure name;
        a result of zero means that there is no limit or the limit
        is not known - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getMaxProcedureNameLength))))

(defn get-max-columns-in-index
  "Retrieves the maximum number of columns this database allows in an index.

  returns: the maximum number of columns allowed;
        a result of zero means that there is no limit or the limit
        is not known - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getMaxColumnsInIndex))))

(defn get-schemas
  "Retrieves the schema names available in this database.  The results
   are ordered by TABLE_CATALOG and
   TABLE_SCHEM.

   The schema columns are:

    TABLE_SCHEM String => schema name
    TABLE_CATALOG String => catalog name (may be null)

  catalog - a catalog name; must match the catalog name as it is stored in the database;\"\" retrieves those without a catalog; null means catalog name should not be used to narrow down the search. - `java.lang.String`
  schema-pattern - a schema name; must match the schema name as it is stored in the database; null means schema name should not be used to narrow down the search. - `java.lang.String`

  returns: a ResultSet object in which each row is a
           schema description - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String catalog ^java.lang.String schema-pattern]
    (-> this (.getSchemas catalog schema-pattern)))
  (^java.sql.ResultSet [^DatabaseMetaData this]
    (-> this (.getSchemas))))

(defn supports-subqueries-in-comparisons
  "Retrieves whether this database supports subqueries in comparison
   expressions.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsSubqueriesInComparisons))))

(defn data-definition-causes-transaction-commit
  "Retrieves whether a data definition statement within a transaction forces
   the transaction to commit.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.dataDefinitionCausesTransactionCommit))))

(defn supports-savepoints
  "Retrieves whether this database supports savepoints.

  returns: true if savepoints are supported;
           false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsSavepoints))))

(defn supports-integrity-enhancement-facility
  "Retrieves whether this database supports the SQL Integrity
   Enhancement Facility.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsIntegrityEnhancementFacility))))

(defn get-columns
  "Retrieves a description of table columns available in
   the specified catalog.

   Only column descriptions matching the catalog, schema, table
   and column name criteria are returned.  They are ordered by
   TABLE_CAT,TABLE_SCHEM,
   TABLE_NAME, and ORDINAL_POSITION.

   Each column description has the following columns:

    TABLE_CAT String => table catalog (may be null)
    TABLE_SCHEM String => table schema (may be null)
    TABLE_NAME String => table name
    COLUMN_NAME String => column name
    DATA_TYPE int => SQL type from java.sql.Types
    TYPE_NAME String => Data source dependent type name,
    for a UDT the type name is fully qualified
    COLUMN_SIZE int => column size.
    BUFFER_LENGTH is not used.
    DECIMAL_DIGITS int => the number of fractional digits. Null is returned for data types where
   DECIMAL_DIGITS is not applicable.
    NUM_PREC_RADIX int => Radix (typically either 10 or 2)
    NULLABLE int => is NULL allowed.

         columnNoNulls - might not allow NULL values
         columnNullable - definitely allows NULL values
         columnNullableUnknown - nullability unknown

    REMARKS String => comment describing column (may be null)
    COLUMN_DEF String => default value for the column, which should be interpreted as a string when the value is enclosed in single quotes (may be null)
    SQL_DATA_TYPE int => unused
    SQL_DATETIME_SUB int => unused
    CHAR_OCTET_LENGTH int => for char types the
         maximum number of bytes in the column
    ORDINAL_POSITION int => index of column in table
        (starting at 1)
    IS_NULLABLE String  => ISO rules are used to determine the nullability for a column.

          YES           --- if the column can include NULLs
          NO            --- if the column cannot include NULLs
          empty string  --- if the nullability for the
   column is unknown

    SCOPE_CATALOG String => catalog of table that is the scope
        of a reference attribute (null if DATA_TYPE isn't REF)
    SCOPE_SCHEMA String => schema of table that is the scope
        of a reference attribute (null if the DATA_TYPE isn't REF)
    SCOPE_TABLE String => table name that this the scope
        of a reference attribute (null if the DATA_TYPE isn't REF)
    SOURCE_DATA_TYPE short => source type of a distinct type or user-generated
        Ref type, SQL type from java.sql.Types (null if DATA_TYPE
        isn't DISTINCT or user-generated REF)
     IS_AUTOINCREMENT String  => Indicates whether this column is auto incremented

          YES           --- if the column is auto incremented
          NO            --- if the column is not auto incremented
          empty string  --- if it cannot be determined whether the column is auto incremented

     IS_GENERATEDCOLUMN String  => Indicates whether this is a generated column

          YES           --- if this a generated column
          NO            --- if this not a generated column
          empty string  --- if it cannot be determined whether this is a generated column



   The COLUMN_SIZE column specifies the column size for the given column.
   For numeric data, this is the maximum precision.  For character data, this is the length in characters.
   For datetime datatypes, this is the length in characters of the String representation (assuming the
   maximum allowed precision of the fractional seconds component). For binary data, this is the length in bytes.  For the ROWID datatype,
   this is the length in bytes. Null is returned for data types where the
   column size is not applicable.

  catalog - a catalog name; must match the catalog name as it is stored in the database; \"\" retrieves those without a catalog; null means that the catalog name should not be used to narrow the search - `java.lang.String`
  schema-pattern - a schema name pattern; must match the schema name as it is stored in the database; \"\" retrieves those without a schema; null means that the schema name should not be used to narrow the search - `java.lang.String`
  table-name-pattern - a table name pattern; must match the table name as it is stored in the database - `java.lang.String`
  column-name-pattern - a column name pattern; must match the column name as it is stored in the database - `java.lang.String`

  returns: ResultSet - each row is a column description - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String catalog ^java.lang.String schema-pattern ^java.lang.String table-name-pattern ^java.lang.String column-name-pattern]
    (-> this (.getColumns catalog schema-pattern table-name-pattern column-name-pattern))))

(defn supports-schemas-in-procedure-calls
  "Retrieves whether a schema name can be used in a procedure call statement.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsSchemasInProcedureCalls))))

(defn get-jdbc-minor-version
  "Retrieves the minor JDBC version number for this
   driver.

  returns: JDBC version minor number - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getJDBCMinorVersion))))

(defn get-table-types
  "Retrieves the table types available in this database.  The results
   are ordered by table type.

   The table type is:

    TABLE_TYPE String => table type.  Typical types are \"TABLE\",
                    \"VIEW\", \"SYSTEM TABLE\", \"GLOBAL TEMPORARY\",
                    \"LOCAL TEMPORARY\", \"ALIAS\", \"SYNONYM\".

  returns: a ResultSet object in which each row has a
           single String column that is a table type - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this]
    (-> this (.getTableTypes))))

(defn get-tables
  "Retrieves a description of the tables available in the given catalog.
   Only table descriptions matching the catalog, schema, table
   name and type criteria are returned.  They are ordered by
   TABLE_TYPE, TABLE_CAT,
   TABLE_SCHEM and TABLE_NAME.

   Each table description has the following columns:

    TABLE_CAT String => table catalog (may be null)
    TABLE_SCHEM String => table schema (may be null)
    TABLE_NAME String => table name
    TABLE_TYPE String => table type.  Typical types are \"TABLE\",
                    \"VIEW\", \"SYSTEM TABLE\", \"GLOBAL TEMPORARY\",
                    \"LOCAL TEMPORARY\", \"ALIAS\", \"SYNONYM\".
    REMARKS String => explanatory comment on the table
    TYPE_CAT String => the types catalog (may be null)
    TYPE_SCHEM String => the types schema (may be null)
    TYPE_NAME String => type name (may be null)
    SELF_REFERENCING_COL_NAME String => name of the designated
                    \"identifier\" column of a typed table (may be null)
    REF_GENERATION String => specifies how values in
                    SELF_REFERENCING_COL_NAME are created. Values are
                    \"SYSTEM\", \"USER\", \"DERIVED\". (may be null)


   Note: Some databases may not return information for
   all tables.

  catalog - a catalog name; must match the catalog name as it is stored in the database; \"\" retrieves those without a catalog; null means that the catalog name should not be used to narrow the search - `java.lang.String`
  schema-pattern - a schema name pattern; must match the schema name as it is stored in the database; \"\" retrieves those without a schema; null means that the schema name should not be used to narrow the search - `java.lang.String`
  table-name-pattern - a table name pattern; must match the table name as it is stored in the database - `java.lang.String`
  types - a list of table types, which must be from the list of table types returned from getTableTypes(),to include; null returns all types - `java.lang.String[]`

  returns: ResultSet - each row is a table description - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String catalog ^java.lang.String schema-pattern ^java.lang.String table-name-pattern types]
    (-> this (.getTables catalog schema-pattern table-name-pattern types))))

(defn get-row-id-lifetime
  "Indicates whether or not this data source supports the SQL ROWID type,
   and if so  the lifetime for which a RowId object remains valid.

   The returned int values have the following relationship:


       ROWID_UNSUPPORTED < ROWID_VALID_OTHER < ROWID_VALID_TRANSACTION
           < ROWID_VALID_SESSION < ROWID_VALID_FOREVER
   so conditional logic such as


       if (metadata.getRowIdLifetime() > DatabaseMetaData.ROWID_VALID_TRANSACTION)
   can be used. Valid Forever means valid across all Sessions, and valid for
   a Session means valid across all its contained Transactions.

  returns: the status indicating the lifetime of a RowId - `java.sql.RowIdLifetime`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.RowIdLifetime [^DatabaseMetaData this]
    (-> this (.getRowIdLifetime))))

(defn supports-data-definition-and-data-manipulation-transactions
  "Retrieves whether this database supports both data definition and
   data manipulation statements within a transaction.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsDataDefinitionAndDataManipulationTransactions))))

(defn supports-ansi-92-intermediate-sql
  "Retrieves whether this database supports the ANSI92 intermediate SQL grammar supported.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsANSI92IntermediateSQL))))

(defn get-version-columns
  "Retrieves a description of a table's columns that are automatically
   updated when any value in a row is updated.  They are
   unordered.

   Each column description has the following columns:

    SCOPE short => is not used
    COLUMN_NAME String => column name
    DATA_TYPE int => SQL data type from java.sql.Types
    TYPE_NAME String => Data source-dependent type name
    COLUMN_SIZE int => precision
    BUFFER_LENGTH int => length of column value in bytes
    DECIMAL_DIGITS short  => scale - Null is returned for data types where
   DECIMAL_DIGITS is not applicable.
    PSEUDO_COLUMN short => whether this is pseudo column
        like an Oracle ROWID

         versionColumnUnknown - may or may not be pseudo column
         versionColumnNotPseudo - is NOT a pseudo column
         versionColumnPseudo - is a pseudo column



   The COLUMN_SIZE column represents the specified column size for the given column.
   For numeric data, this is the maximum precision.  For character data, this is the length in characters.
   For datetime datatypes, this is the length in characters of the String representation (assuming the
   maximum allowed precision of the fractional seconds component). For binary data, this is the length in bytes.  For the ROWID datatype,
   this is the length in bytes. Null is returned for data types where the
   column size is not applicable.

  catalog - a catalog name; must match the catalog name as it is stored in the database; \"\" retrieves those without a catalog; null means that the catalog name should not be used to narrow the search - `java.lang.String`
  schema - a schema name; must match the schema name as it is stored in the database; \"\" retrieves those without a schema; null means that the schema name should not be used to narrow the search - `java.lang.String`
  table - a table name; must match the table name as it is stored in the database - `java.lang.String`

  returns: a ResultSet object in which each row is a
           column description - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String catalog ^java.lang.String schema ^java.lang.String table]
    (-> this (.getVersionColumns catalog schema table))))

(defn supports-ref-cursors
  "Retrieves whether this database supports REF CURSOR.

   The default implementation will return false

  returns: true if this database supports REF CURSOR;
           false otherwise - `default boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^DatabaseMetaData this]
    (-> this (.supportsRefCursors))))

(defn supports-schemas-in-data-manipulation
  "Retrieves whether a schema name can be used in a data manipulation statement.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsSchemasInDataManipulation))))

(defn get-user-name
  "Retrieves the user name as known to this database.

  returns: the database user name - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.lang.String [^DatabaseMetaData this]
    (-> this (.getUserName))))

(defn supports-like-escape-clause
  "Retrieves whether this database supports specifying a
   LIKE escape clause.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsLikeEscapeClause))))

(defn supports-catalogs-in-privilege-definitions
  "Retrieves whether a catalog name can be used in a privilege definition statement.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsCatalogsInPrivilegeDefinitions))))

(defn get-driver-minor-version
  "Retrieves this JDBC driver's minor version number.

  returns: JDBC driver minor version number - `int`"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getDriverMinorVersion))))

(defn get-time-date-functions
  "Retrieves a comma-separated list of the time and date functions available
   with this database.

  returns: the list of time and date functions supported by this database - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.lang.String [^DatabaseMetaData this]
    (-> this (.getTimeDateFunctions))))

(defn get-column-privileges
  "Retrieves a description of the access rights for a table's columns.

   Only privileges matching the column name criteria are
   returned.  They are ordered by COLUMN_NAME and PRIVILEGE.

   Each privilege description has the following columns:

    TABLE_CAT String => table catalog (may be null)
    TABLE_SCHEM String => table schema (may be null)
    TABLE_NAME String => table name
    COLUMN_NAME String => column name
    GRANTOR String => grantor of access (may be null)
    GRANTEE String => grantee of access
    PRIVILEGE String => name of access (SELECT,
        INSERT, UPDATE, REFRENCES, ...)
    IS_GRANTABLE String => \"YES\" if grantee is permitted
        to grant to others; \"NO\" if not; null if unknown

  catalog - a catalog name; must match the catalog name as it is stored in the database; \"\" retrieves those without a catalog; null means that the catalog name should not be used to narrow the search - `java.lang.String`
  schema - a schema name; must match the schema name as it is stored in the database; \"\" retrieves those without a schema; null means that the schema name should not be used to narrow the search - `java.lang.String`
  table - a table name; must match the table name as it is stored in the database - `java.lang.String`
  column-name-pattern - a column name pattern; must match the column name as it is stored in the database - `java.lang.String`

  returns: ResultSet - each row is a column privilege description - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String catalog ^java.lang.String schema ^java.lang.String table ^java.lang.String column-name-pattern]
    (-> this (.getColumnPrivileges catalog schema table column-name-pattern))))

(defn get-imported-keys
  "Retrieves a description of the primary key columns that are
   referenced by the given table's foreign key columns (the primary keys
   imported by a table).  They are ordered by PKTABLE_CAT,
   PKTABLE_SCHEM, PKTABLE_NAME, and KEY_SEQ.

   Each primary key column description has the following columns:

    PKTABLE_CAT String => primary key table catalog
        being imported (may be null)
    PKTABLE_SCHEM String => primary key table schema
        being imported (may be null)
    PKTABLE_NAME String => primary key table name
        being imported
    PKCOLUMN_NAME String => primary key column name
        being imported
    FKTABLE_CAT String => foreign key table catalog (may be null)
    FKTABLE_SCHEM String => foreign key table schema (may be null)
    FKTABLE_NAME String => foreign key table name
    FKCOLUMN_NAME String => foreign key column name
    KEY_SEQ short => sequence number within a foreign key( a value
    of 1 represents the first column of the foreign key, a value of 2 would
    represent the second column within the foreign key).
    UPDATE_RULE short => What happens to a
         foreign key when the primary key is updated:

         importedNoAction - do not allow update of primary
                 key if it has been imported
         importedKeyCascade - change imported key to agree
                 with primary key update
         importedKeySetNull - change imported key to NULL
                 if its primary key has been updated
         importedKeySetDefault - change imported key to default values
                 if its primary key has been updated
         importedKeyRestrict - same as importedKeyNoAction
                                   (for ODBC 2.x compatibility)

    DELETE_RULE short => What happens to
        the foreign key when primary is deleted.

         importedKeyNoAction - do not allow delete of primary
                 key if it has been imported
         importedKeyCascade - delete rows that import a deleted key
         importedKeySetNull - change imported key to NULL if
                 its primary key has been deleted
         importedKeyRestrict - same as importedKeyNoAction
                                   (for ODBC 2.x compatibility)
         importedKeySetDefault - change imported key to default if
                 its primary key has been deleted

    FK_NAME String => foreign key name (may be null)
    PK_NAME String => primary key name (may be null)
    DEFERRABILITY short => can the evaluation of foreign key
        constraints be deferred until commit

         importedKeyInitiallyDeferred - see SQL92 for definition
         importedKeyInitiallyImmediate - see SQL92 for definition
         importedKeyNotDeferrable - see SQL92 for definition

  catalog - a catalog name; must match the catalog name as it is stored in the database; \"\" retrieves those without a catalog; null means that the catalog name should not be used to narrow the search - `java.lang.String`
  schema - a schema name; must match the schema name as it is stored in the database; \"\" retrieves those without a schema; null means that the schema name should not be used to narrow the search - `java.lang.String`
  table - a table name; must match the table name as it is stored in the database - `java.lang.String`

  returns: ResultSet - each row is a primary key column description - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String catalog ^java.lang.String schema ^java.lang.String table]
    (-> this (.getImportedKeys catalog schema table))))

(defn get-search-string-escape
  "Retrieves the string that can be used to escape wildcard characters.
   This is the string that can be used to escape '_' or '%' in
   the catalog search parameters that are a pattern (and therefore use one
   of the wildcard characters).

   The '_' character represents any single character;
   the '%' character represents any sequence of zero or
   more characters.

  returns: the string used to escape wildcard characters - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.lang.String [^DatabaseMetaData this]
    (-> this (.getSearchStringEscape))))

(defn supports-core-sql-grammar
  "Retrieves whether this database supports the ODBC Core SQL grammar.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsCoreSQLGrammar))))

(defn get-driver-name
  "Retrieves the name of this JDBC driver.

  returns: JDBC driver name - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.lang.String [^DatabaseMetaData this]
    (-> this (.getDriverName))))

(defn supports-subqueries-in-quantifieds
  "Retrieves whether this database supports subqueries in quantified
   expressions.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsSubqueriesInQuantifieds))))

(defn supports-get-generated-keys
  "Retrieves whether auto-generated keys can be retrieved after
   a statement has been executed

  returns: true if auto-generated keys can be retrieved
           after a statement has executed; false otherwise
  If true is returned, the JDBC driver must support the
   returning of auto-generated keys for at least SQL INSERT statements - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsGetGeneratedKeys))))

(defn supports-positioned-update
  "Retrieves whether this database supports positioned UPDATE
   statements.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsPositionedUpdate))))

(defn supports-expressions-in-order-by
  "Retrieves whether this database supports expressions in
   ORDER BY lists.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsExpressionsInOrderBy))))

(defn get-max-binary-literal-length
  "Retrieves the maximum number of hex characters this database allows in an
   inline binary literal.

  returns: max the maximum length (in hex characters) for a binary literal;
        a result of zero means that there is no limit or the limit
        is not known - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getMaxBinaryLiteralLength))))

(defn get-result-set-holdability
  "Retrieves this database's default holdability for ResultSet
   objects.

  returns: the default holdability; either
           ResultSet.HOLD_CURSORS_OVER_COMMIT or
           ResultSet.CLOSE_CURSORS_AT_COMMIT - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getResultSetHoldability))))

(defn get-client-info-properties
  "Retrieves a list of the client info properties
   that the driver supports.  The result set contains the following columns


   NAME String=> The name of the client info property
   MAX_LEN int=> The maximum length of the value for the property
   DEFAULT_VALUE String=> The default value of the property
   DESCRIPTION String=> A description of the property.  This will typically
                                                contain information as to where this property is
                                                stored in the database.


   The ResultSet is sorted by the NAME column

  returns: A ResultSet object; each row is a supported client info
   property - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this]
    (-> this (.getClientInfoProperties))))

(defn get-schema-term
  "Retrieves the database vendor's preferred term for \"schema\".

  returns: the vendor term for \"schema\" - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.lang.String [^DatabaseMetaData this]
    (-> this (.getSchemaTerm))))

(defn supports-subqueries-in-ins
  "Retrieves whether this database supports subqueries in
   IN expressions.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsSubqueriesInIns))))

(defn get-best-row-identifier
  "Retrieves a description of a table's optimal set of columns that
   uniquely identifies a row. They are ordered by SCOPE.

   Each column description has the following columns:

    SCOPE short => actual scope of result

         bestRowTemporary - very temporary, while using row
         bestRowTransaction - valid for remainder of current transaction
         bestRowSession - valid for remainder of current session

    COLUMN_NAME String => column name
    DATA_TYPE int => SQL data type from java.sql.Types
    TYPE_NAME String => Data source dependent type name,
    for a UDT the type name is fully qualified
    COLUMN_SIZE int => precision
    BUFFER_LENGTH int => not used
    DECIMAL_DIGITS short  => scale - Null is returned for data types where
   DECIMAL_DIGITS is not applicable.
    PSEUDO_COLUMN short => is this a pseudo column
        like an Oracle ROWID

         bestRowUnknown - may or may not be pseudo column
         bestRowNotPseudo - is NOT a pseudo column
         bestRowPseudo - is a pseudo column



   The COLUMN_SIZE column represents the specified column size for the given column.
   For numeric data, this is the maximum precision.  For character data, this is the length in characters.
   For datetime datatypes, this is the length in characters of the String representation (assuming the
   maximum allowed precision of the fractional seconds component). For binary data, this is the length in bytes.  For the ROWID datatype,
   this is the length in bytes. Null is returned for data types where the
   column size is not applicable.

  catalog - a catalog name; must match the catalog name as it is stored in the database; \"\" retrieves those without a catalog; null means that the catalog name should not be used to narrow the search - `java.lang.String`
  schema - a schema name; must match the schema name as it is stored in the database; \"\" retrieves those without a schema; null means that the schema name should not be used to narrow the search - `java.lang.String`
  table - a table name; must match the table name as it is stored in the database - `java.lang.String`
  scope - the scope of interest; use same values as SCOPE - `int`
  nullable - include columns that are nullable. - `boolean`

  returns: ResultSet - each row is a column description - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String catalog ^java.lang.String schema ^java.lang.String table ^Integer scope ^Boolean nullable]
    (-> this (.getBestRowIdentifier catalog schema table scope nullable))))

(defn get-catalogs
  "Retrieves the catalog names available in this database.  The results
   are ordered by catalog name.

   The catalog column is:

    TABLE_CAT String => catalog name

  returns: a ResultSet object in which each row has a
           single String column that is a catalog name - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this]
    (-> this (.getCatalogs))))

(defn supports-transactions
  "Retrieves whether this database supports transactions. If not, invoking the
   method commit is a noop, and the isolation level is
   TRANSACTION_NONE.

  returns: true if transactions are supported;
           false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsTransactions))))

(defn supports-subqueries-in-exists
  "Retrieves whether this database supports subqueries in
   EXISTS expressions.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsSubqueriesInExists))))

(defn supports-catalogs-in-procedure-calls
  "Retrieves whether a catalog name can be used in a procedure call statement.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsCatalogsInProcedureCalls))))

(defn null-plus-non-null-is-null
  "Retrieves whether this database supports concatenations between
   NULL and non-NULL values being
   NULL.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.nullPlusNonNullIsNull))))

(defn get-max-column-name-length
  "Retrieves the maximum number of characters this database allows
   for a column name.

  returns: the maximum number of characters allowed for a column name;
        a result of zero means that there is no limit or the limit
        is not known - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getMaxColumnNameLength))))

(defn supports-different-table-correlation-names
  "Retrieves whether, when table correlation names are supported, they
   are restricted to being different from the names of the tables.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsDifferentTableCorrelationNames))))

(defn get-max-tables-in-select
  "Retrieves the maximum number of tables this database allows in a
   SELECT statement.

  returns: the maximum number of tables allowed in a SELECT
           statement; a result of zero means that there is no limit or
           the limit is not known - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getMaxTablesInSelect))))

(defn generated-key-always-returned
  "Retrieves whether a generated key will always be returned if the column
   name(s) or index(es) specified for the auto generated key column(s)
   are valid and the statement succeeds.  The key that is returned may or
   may not be based on the column(s) for the auto generated key.
   Consult your JDBC driver documentation for additional details.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.generatedKeyAlwaysReturned))))

(defn get-max-columns-in-select
  "Retrieves the maximum number of columns this database allows in a
   SELECT list.

  returns: the maximum number of columns allowed;
        a result of zero means that there is no limit or the limit
        is not known - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getMaxColumnsInSelect))))

(defn get-sql-keywords
  "Retrieves a comma-separated list of all of this database's SQL keywords
   that are NOT also SQL:2003 keywords.

  returns: the list of this database's keywords that are not also
           SQL:2003 keywords - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.lang.String [^DatabaseMetaData this]
    (-> this (.getSQLKeywords))))

(defn own-inserts-are-visible
  "Retrieves whether a result set's own inserts are visible.

  type - the ResultSet type; one of ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE - `int`

  returns: true if inserts are visible for the given result set type;
          false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this ^Integer type]
    (-> this (.ownInsertsAreVisible type))))

(defn others-inserts-are-visible
  "Retrieves whether inserts made by others are visible.

  type - the ResultSet type; one of ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE - `int`

  returns: true if inserts made by others
           are visible for the given result set type;
           false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this ^Integer type]
    (-> this (.othersInsertsAreVisible type))))

(defn get-system-functions
  "Retrieves a comma-separated list of system functions available with
   this database.  These are the  Open Group CLI system function names used
   in the JDBC function escape clause.

  returns: a list of system functions supported by this database - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.lang.String [^DatabaseMetaData this]
    (-> this (.getSystemFunctions))))

(defn get-super-tables
  "Retrieves a description of the table hierarchies defined in a particular
   schema in this database.

   Only supertable information for tables matching the catalog, schema
   and table name are returned. The table name parameter may be a fully-
   qualified name, in which case, the catalog and schemaPattern parameters
   are ignored. If a table does not have a super table, it is not listed here.
   Supertables have to be defined in the same catalog and schema as the
   sub tables. Therefore, the type description does not need to include
   this information for the supertable.

   Each type description has the following columns:

    TABLE_CAT String => the type's catalog (may be null)
    TABLE_SCHEM String => type's schema (may be null)
    TABLE_NAME String => type name
    SUPERTABLE_NAME String => the direct super type's name


   Note: If the driver does not support type hierarchies, an
   empty result set is returned.

  catalog - a catalog name; \"\" retrieves those without a catalog; null means drop catalog name from the selection criteria - `java.lang.String`
  schema-pattern - a schema name pattern; \"\" retrieves those without a schema - `java.lang.String`
  table-name-pattern - a table name pattern; may be a fully-qualified name - `java.lang.String`

  returns: a ResultSet object in which each row is a type description - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String catalog ^java.lang.String schema-pattern ^java.lang.String table-name-pattern]
    (-> this (.getSuperTables catalog schema-pattern table-name-pattern))))

(defn supports-table-correlation-names
  "Retrieves whether this database supports table correlation names.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsTableCorrelationNames))))

(defn all-procedures-are-callable
  "Retrieves whether the current user can call all the procedures
   returned by the method getProcedures.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.allProceduresAreCallable))))

(defn get-procedures
  "Retrieves a description of the stored procedures available in the given
   catalog.

   Only procedure descriptions matching the schema and
   procedure name criteria are returned.  They are ordered by
   PROCEDURE_CAT, PROCEDURE_SCHEM,
   PROCEDURE_NAME and SPECIFIC_ NAME.

   Each procedure description has the the following columns:

    PROCEDURE_CAT String => procedure catalog (may be null)
    PROCEDURE_SCHEM String => procedure schema (may be null)
    PROCEDURE_NAME String => procedure name
     reserved for future use
     reserved for future use
     reserved for future use
    REMARKS String => explanatory comment on the procedure
    PROCEDURE_TYPE short => kind of procedure:

         procedureResultUnknown - Cannot determine if  a return value
         will be returned
         procedureNoResult - Does not return a return value
         procedureReturnsResult - Returns a return value

    SPECIFIC_NAME String  => The name which uniquely identifies this
   procedure within its schema.


   A user may not have permissions to execute any of the procedures that are
   returned by getProcedures

  catalog - a catalog name; must match the catalog name as it is stored in the database; \"\" retrieves those without a catalog; null means that the catalog name should not be used to narrow the search - `java.lang.String`
  schema-pattern - a schema name pattern; must match the schema name as it is stored in the database; \"\" retrieves those without a schema; null means that the schema name should not be used to narrow the search - `java.lang.String`
  procedure-name-pattern - a procedure name pattern; must match the procedure name as it is stored in the database - `java.lang.String`

  returns: ResultSet - each row is a procedure description - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String catalog ^java.lang.String schema-pattern ^java.lang.String procedure-name-pattern]
    (-> this (.getProcedures catalog schema-pattern procedure-name-pattern))))

(defn supports-transaction-isolation-level
  "Retrieves whether this database supports the given transaction isolation level.

  level - one of the transaction isolation levels defined in java.sql.Connection - `int`

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this ^Integer level]
    (-> this (.supportsTransactionIsolationLevel level))))

(defn get-max-user-name-length
  "Retrieves the maximum number of characters this database allows in
   a user name.

  returns: the maximum number of characters allowed for a user name;
        a result of zero means that there is no limit or the limit
        is not known - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getMaxUserNameLength))))

(defn supports-named-parameters
  "Retrieves whether this database supports named parameters to callable
   statements.

  returns: true if named parameters are supported;
           false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsNamedParameters))))

(defn get-max-char-literal-length
  "Retrieves the maximum number of characters this database allows
   for a character literal.

  returns: the maximum number of characters allowed for a character literal;
        a result of zero means that there is no limit or the limit is
        not known - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getMaxCharLiteralLength))))

(defn supports-open-cursors-across-rollback
  "Retrieves whether this database supports keeping cursors open
   across rollbacks.

  returns: true if cursors always remain open;
         false if they might not remain open - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsOpenCursorsAcrossRollback))))

(defn get-index-info
  "Retrieves a description of the given table's indices and statistics. They are
   ordered by NON_UNIQUE, TYPE, INDEX_NAME, and ORDINAL_POSITION.

   Each index column description has the following columns:

    TABLE_CAT String => table catalog (may be null)
    TABLE_SCHEM String => table schema (may be null)
    TABLE_NAME String => table name
    NON_UNIQUE boolean => Can index values be non-unique.
        false when TYPE is tableIndexStatistic
    INDEX_QUALIFIER String => index catalog (may be null);
        null when TYPE is tableIndexStatistic
    INDEX_NAME String => index name; null when TYPE is
        tableIndexStatistic
    TYPE short => index type:

         tableIndexStatistic - this identifies table statistics that are
             returned in conjuction with a table's index descriptions
         tableIndexClustered - this is a clustered index
         tableIndexHashed - this is a hashed index
         tableIndexOther - this is some other style of index

    ORDINAL_POSITION short => column sequence number
        within index; zero when TYPE is tableIndexStatistic
    COLUMN_NAME String => column name; null when TYPE is
        tableIndexStatistic
    ASC_OR_DESC String => column sort sequence, \"A\" => ascending,
        \"D\" => descending, may be null if sort sequence is not supported;
        null when TYPE is tableIndexStatistic
    CARDINALITY long => When TYPE is tableIndexStatistic, then
        this is the number of rows in the table; otherwise, it is the
        number of unique values in the index.
    PAGES long => When TYPE is  tableIndexStatisic then
        this is the number of pages used for the table, otherwise it
        is the number of pages used for the current index.
    FILTER_CONDITION String => Filter condition, if any.
        (may be null)

  catalog - a catalog name; must match the catalog name as it is stored in this database; \"\" retrieves those without a catalog; null means that the catalog name should not be used to narrow the search - `java.lang.String`
  schema - a schema name; must match the schema name as it is stored in this database; \"\" retrieves those without a schema; null means that the schema name should not be used to narrow the search - `java.lang.String`
  table - a table name; must match the table name as it is stored in this database - `java.lang.String`
  unique - when true, return only indices for unique values; when false, return indices regardless of whether unique or not - `boolean`
  approximate - when true, result is allowed to reflect approximate or out of data values; when false, results are requested to be accurate - `boolean`

  returns: ResultSet - each row is an index column description - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String catalog ^java.lang.String schema ^java.lang.String table ^Boolean unique ^Boolean approximate]
    (-> this (.getIndexInfo catalog schema table unique approximate))))

(defn inserts-are-detected
  "Retrieves whether or not a visible row insert can be detected
   by calling the method ResultSet.rowInserted.

  type - the ResultSet type; one of ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE - `int`

  returns: true if changes are detected by the specified result
           set type; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this ^Integer type]
    (-> this (.insertsAreDetected type))))

(defn all-tables-are-selectable
  "Retrieves whether the current user can use all the tables returned
   by the method getTables in a SELECT
   statement.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.allTablesAreSelectable))))

(defn supports-result-set-holdability
  "Retrieves whether this database supports the given result set holdability.

  holdability - one of the following constants: ResultSet.HOLD_CURSORS_OVER_COMMIT or ResultSet.CLOSE_CURSORS_AT_COMMIT - `int`

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this ^Integer holdability]
    (-> this (.supportsResultSetHoldability holdability))))

(defn get-max-row-size
  "Retrieves the maximum number of bytes this database allows in
   a single row.

  returns: the maximum number of bytes allowed for a row; a result of
           zero means that there is no limit or the limit is not known - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getMaxRowSize))))

(defn get-string-functions
  "Retrieves a comma-separated list of string functions available with
   this database.  These are the  Open Group CLI string function names used
   in the JDBC function escape clause.

  returns: the list of string functions supported by this database - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.lang.String [^DatabaseMetaData this]
    (-> this (.getStringFunctions))))

(defn get-ud-ts
  "Retrieves a description of the user-defined types (UDTs) defined
   in a particular schema.  Schema-specific UDTs may have type
   JAVA_OBJECT, STRUCT,
   or DISTINCT.

   Only types matching the catalog, schema, type name and type
   criteria are returned.  They are ordered by DATA_TYPE,
   TYPE_CAT, TYPE_SCHEM  and
   TYPE_NAME.  The type name parameter may be a fully-qualified
   name.  In this case, the catalog and schemaPattern parameters are
   ignored.

   Each type description has the following columns:

    TYPE_CAT String => the type's catalog (may be null)
    TYPE_SCHEM String => type's schema (may be null)
    TYPE_NAME String => type name
    CLASS_NAME String => Java class name
    DATA_TYPE int => type value defined in java.sql.Types.
       One of JAVA_OBJECT, STRUCT, or DISTINCT
    REMARKS String => explanatory comment on the type
    BASE_TYPE short => type code of the source type of a
       DISTINCT type or the type that implements the user-generated
       reference type of the SELF_REFERENCING_COLUMN of a structured
       type as defined in java.sql.Types (null if DATA_TYPE is not
       DISTINCT or not STRUCT with REFERENCE_GENERATION = USER_DEFINED)


   Note: If the driver does not support UDTs, an empty
   result set is returned.

  catalog - a catalog name; must match the catalog name as it is stored in the database; \"\" retrieves those without a catalog; null means that the catalog name should not be used to narrow the search - `java.lang.String`
  schema-pattern - a schema pattern name; must match the schema name as it is stored in the database; \"\" retrieves those without a schema; null means that the schema name should not be used to narrow the search - `java.lang.String`
  type-name-pattern - a type name pattern; must match the type name as it is stored in the database; may be a fully qualified name - `java.lang.String`
  types - a list of user-defined types (JAVA_OBJECT, STRUCT, or DISTINCT) to include; null returns all types - `int[]`

  returns: ResultSet object in which each row describes a UDT - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String catalog ^java.lang.String schema-pattern ^java.lang.String type-name-pattern types]
    (-> this (.getUDTs catalog schema-pattern type-name-pattern types))))

(defn get-database-product-name
  "Retrieves the name of this database product.

  returns: database product name - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.lang.String [^DatabaseMetaData this]
    (-> this (.getDatabaseProductName))))

(defn supports-union-all
  "Retrieves whether this database supports SQL UNION ALL.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsUnionAll))))

(defn supports-full-outer-joins
  "Retrieves whether this database supports full nested outer joins.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsFullOuterJoins))))

(defn get-numeric-functions
  "Retrieves a comma-separated list of math functions available with
   this database.  These are the Open /Open CLI math function names used in
   the JDBC function escape clause.

  returns: the list of math functions supported by this database - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.lang.String [^DatabaseMetaData this]
    (-> this (.getNumericFunctions))))

(defn supports-multiple-transactions
  "Retrieves whether this database allows having multiple
   transactions open at once (on different connections).

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsMultipleTransactions))))

(defn supports-catalogs-in-table-definitions
  "Retrieves whether a catalog name can be used in a table definition statement.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsCatalogsInTableDefinitions))))

(defn supports-order-by-unrelated
  "Retrieves whether this database supports using a column that is
   not in the SELECT statement in an
   ORDER BY clause.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsOrderByUnrelated))))

(defn supports-minimum-sql-grammar
  "Retrieves whether this database supports the ODBC Minimum SQL grammar.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsMinimumSQLGrammar))))

(defn get-sql-state-type
  "Indicates whether the SQLSTATE returned by SQLException.getSQLState
   is X/Open (now known as Open Group) SQL CLI or SQL:2003.

  returns: the type of SQLSTATE; one of:
          sqlStateXOpen or
          sqlStateSQL - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getSQLStateType))))

(defn locators-update-copy
  "Indicates whether updates made to a LOB are made on a copy or directly
   to the LOB.

  returns: true if updates are made to a copy of the LOB;
           false if updates are made directly to the LOB - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.locatorsUpdateCopy))))

(defn get-max-schema-name-length
  "Retrieves the maximum number of characters that this database allows in a
   schema name.

  returns: the maximum number of characters allowed in a schema name;
        a result of zero means that there is no limit or the limit
        is not known - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getMaxSchemaNameLength))))

(defn supports-union
  "Retrieves whether this database supports SQL UNION.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsUnion))))

(defn does-max-row-size-include-blobs
  "Retrieves whether the return value for the method
   getMaxRowSize includes the SQL data types
   LONGVARCHAR and LONGVARBINARY.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.doesMaxRowSizeIncludeBlobs))))

(defn get-default-transaction-isolation
  "Retrieves this database's default transaction isolation level.  The
   possible values are defined in java.sql.Connection.

  returns: the default isolation level - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getDefaultTransactionIsolation))))

(defn supports-group-by-unrelated
  "Retrieves whether this database supports using a column that is
   not in the SELECT statement in a
   GROUP BY clause.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsGroupByUnrelated))))

(defn supports-data-manipulation-transactions-only
  "Retrieves whether this database supports only data manipulation
   statements within a transaction.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsDataManipulationTransactionsOnly))))

(defn get-catalog-separator
  "Retrieves the String that this database uses as the
   separator between a catalog and table name.

  returns: the separator string - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.lang.String [^DatabaseMetaData this]
    (-> this (.getCatalogSeparator))))

(defn supports-group-by
  "Retrieves whether this database supports some form of
   GROUP BY clause.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsGroupBy))))

(defn get-max-cursor-name-length
  "Retrieves the maximum number of characters that this database allows in a
   cursor name.

  returns: the maximum number of characters allowed in a cursor name;
        a result of zero means that there is no limit or the limit
        is not known - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getMaxCursorNameLength))))

(defn get-connection
  "Retrieves the connection that produced this metadata object.

  returns: the connection that produced this metadata object - `java.sql.Connection`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.Connection [^DatabaseMetaData this]
    (-> this (.getConnection))))

(defn supports-catalogs-in-data-manipulation
  "Retrieves whether a catalog name can be used in a data manipulation statement.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsCatalogsInDataManipulation))))

(defn get-pseudo-columns
  "Retrieves a description of the pseudo or hidden columns available
   in a given table within the specified catalog and schema.
   Pseudo or hidden columns may not always be stored within
   a table and are not visible in a ResultSet unless they are
   specified in the query's outermost SELECT list. Pseudo or hidden
   columns may not necessarily be able to be modified. If there are
   no pseudo or hidden columns, an empty ResultSet is returned.

   Only column descriptions matching the catalog, schema, table
   and column name criteria are returned.  They are ordered by
   TABLE_CAT,TABLE_SCHEM, TABLE_NAME
   and COLUMN_NAME.

   Each column description has the following columns:

    TABLE_CAT String => table catalog (may be null)
    TABLE_SCHEM String => table schema (may be null)
    TABLE_NAME String => table name
    COLUMN_NAME String => column name
    DATA_TYPE int => SQL type from java.sql.Types
    COLUMN_SIZE int => column size.
    DECIMAL_DIGITS int => the number of fractional digits. Null is returned for data types where
   DECIMAL_DIGITS is not applicable.
    NUM_PREC_RADIX int => Radix (typically either 10 or 2)
    COLUMN_USAGE String => The allowed usage for the column.  The
    value returned will correspond to the enum name returned by PseudoColumnUsage.name()
    REMARKS String => comment describing column (may be null)
    CHAR_OCTET_LENGTH int => for char types the
         maximum number of bytes in the column
    IS_NULLABLE String  => ISO rules are used to determine the nullability for a column.

          YES           --- if the column can include NULLs
          NO            --- if the column cannot include NULLs
          empty string  --- if the nullability for the column is unknown



   The COLUMN_SIZE column specifies the column size for the given column.
   For numeric data, this is the maximum precision.  For character data, this is the length in characters.
   For datetime datatypes, this is the length in characters of the String representation (assuming the
   maximum allowed precision of the fractional seconds component). For binary data, this is the length in bytes.  For the ROWID datatype,
   this is the length in bytes. Null is returned for data types where the
   column size is not applicable.

  catalog - a catalog name; must match the catalog name as it is stored in the database; \"\" retrieves those without a catalog; null means that the catalog name should not be used to narrow the search - `java.lang.String`
  schema-pattern - a schema name pattern; must match the schema name as it is stored in the database; \"\" retrieves those without a schema; null means that the schema name should not be used to narrow the search - `java.lang.String`
  table-name-pattern - a table name pattern; must match the table name as it is stored in the database - `java.lang.String`
  column-name-pattern - a column name pattern; must match the column name as it is stored in the database - `java.lang.String`

  returns: ResultSet - each row is a column description - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String catalog ^java.lang.String schema-pattern ^java.lang.String table-name-pattern ^java.lang.String column-name-pattern]
    (-> this (.getPseudoColumns catalog schema-pattern table-name-pattern column-name-pattern))))

(defn supports-correlated-subqueries
  "Retrieves whether this database supports correlated subqueries.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsCorrelatedSubqueries))))

(defn supports-stored-functions-using-call-syntax
  "Retrieves whether this database supports invoking user-defined or vendor functions
   using the stored procedure escape syntax.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsStoredFunctionsUsingCallSyntax))))

(defn nulls-are-sorted-at-end
  "Retrieves whether NULL values are sorted at the end regardless of
   sort order.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.nullsAreSortedAtEnd))))

(defn get-catalog-term
  "Retrieves the database vendor's preferred term for \"catalog\".

  returns: the vendor term for \"catalog\" - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.lang.String [^DatabaseMetaData this]
    (-> this (.getCatalogTerm))))

(defn supports-alter-table-with-drop-column
  "Retrieves whether this database supports ALTER TABLE
   with drop column.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsAlterTableWithDropColumn))))

(defn get-procedure-columns
  "Retrieves a description of the given catalog's stored procedure parameter
   and result columns.

   Only descriptions matching the schema, procedure and
   parameter name criteria are returned.  They are ordered by
   PROCEDURE_CAT, PROCEDURE_SCHEM, PROCEDURE_NAME and SPECIFIC_NAME. Within this, the return value,
   if any, is first. Next are the parameter descriptions in call
   order. The column descriptions follow in column number order.

   Each row in the ResultSet is a parameter description or
   column description with the following fields:

    PROCEDURE_CAT String => procedure catalog (may be null)
    PROCEDURE_SCHEM String => procedure schema (may be null)
    PROCEDURE_NAME String => procedure name
    COLUMN_NAME String => column/parameter name
    COLUMN_TYPE Short => kind of column/parameter:

         procedureColumnUnknown - nobody knows
         procedureColumnIn - IN parameter
         procedureColumnInOut - INOUT parameter
         procedureColumnOut - OUT parameter
         procedureColumnReturn - procedure return value
         procedureColumnResult - result column in ResultSet

    DATA_TYPE int => SQL type from java.sql.Types
    TYPE_NAME String => SQL type name, for a UDT type the
    type name is fully qualified
    PRECISION int => precision
    LENGTH int => length in bytes of data
    SCALE short => scale -  null is returned for data types where
   SCALE is not applicable.
    RADIX short => radix
    NULLABLE short => can it contain NULL.

         procedureNoNulls - does not allow NULL values
         procedureNullable - allows NULL values
         procedureNullableUnknown - nullability unknown

    REMARKS String => comment describing parameter/column
    COLUMN_DEF String => default value for the column, which should be interpreted as a string when the value is enclosed in single quotes (may be null)

         The string NULL (not enclosed in quotes) - if NULL was specified as the default value
         TRUNCATE (not enclosed in quotes)        - if the specified default value cannot be represented without truncation
         NULL                                     - if a default value was not specified

    SQL_DATA_TYPE int  => reserved for future use
    SQL_DATETIME_SUB int  => reserved for future use
    CHAR_OCTET_LENGTH int  => the maximum length of binary and character based columns.  For any other datatype the returned value is a
   NULL
    ORDINAL_POSITION int  => the ordinal position, starting from 1, for the input and output parameters for a procedure. A value of 0
  is returned if this row describes the procedure's return value.  For result set columns, it is the
  ordinal position of the column in the result set starting from 1.  If there are
  multiple result sets, the column ordinal positions are implementation
   defined.
    IS_NULLABLE String  => ISO rules are used to determine the nullability for a column.

          YES           --- if the column can include NULLs
          NO            --- if the column cannot include NULLs
          empty string  --- if the nullability for the
   column is unknown

    SPECIFIC_NAME String  => the name which uniquely identifies this procedure within its schema.


   Note: Some databases may not return the column
   descriptions for a procedure.

   The PRECISION column represents the specified column size for the given column.
   For numeric data, this is the maximum precision.  For character data, this is the length in characters.
   For datetime datatypes, this is the length in characters of the String representation (assuming the
   maximum allowed precision of the fractional seconds component). For binary data, this is the length in bytes.  For the ROWID datatype,
   this is the length in bytes. Null is returned for data types where the
   column size is not applicable.

  catalog - a catalog name; must match the catalog name as it is stored in the database; \"\" retrieves those without a catalog; null means that the catalog name should not be used to narrow the search - `java.lang.String`
  schema-pattern - a schema name pattern; must match the schema name as it is stored in the database; \"\" retrieves those without a schema; null means that the schema name should not be used to narrow the search - `java.lang.String`
  procedure-name-pattern - a procedure name pattern; must match the procedure name as it is stored in the database - `java.lang.String`
  column-name-pattern - a column name pattern; must match the column name as it is stored in the database - `java.lang.String`

  returns: ResultSet - each row describes a stored procedure parameter or
        column - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String catalog ^java.lang.String schema-pattern ^java.lang.String procedure-name-pattern ^java.lang.String column-name-pattern]
    (-> this (.getProcedureColumns catalog schema-pattern procedure-name-pattern column-name-pattern))))

(defn supports-multiple-result-sets
  "Retrieves whether this database supports getting multiple
   ResultSet objects from a single call to the
   method execute.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsMultipleResultSets))))

(defn stores-upper-case-identifiers
  "Retrieves whether this database treats mixed case unquoted SQL identifiers as
   case insensitive and stores them in upper case.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.storesUpperCaseIdentifiers))))

(defn supports-alter-table-with-add-column
  "Retrieves whether this database supports ALTER TABLE
   with add column.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsAlterTableWithAddColumn))))

(defn get-url
  "Retrieves the URL for this DBMS.

  returns: the URL for this DBMS or null if it cannot be
            generated - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.lang.String [^DatabaseMetaData this]
    (-> this (.getURL))))

(defn own-deletes-are-visible
  "Retrieves whether a result set's own deletes are visible.

  type - the ResultSet type; one of ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE - `int`

  returns: true if deletes are visible for the given result set type;
          false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this ^Integer type]
    (-> this (.ownDeletesAreVisible type))))

(defn get-driver-major-version
  "Retrieves this JDBC driver's major version number.

  returns: JDBC driver major version - `int`"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getDriverMajorVersion))))

(defn data-definition-ignored-in-transactions
  "Retrieves whether this database ignores a data definition statement
   within a transaction.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.dataDefinitionIgnoredInTransactions))))

(defn get-cross-reference
  "Retrieves a description of the foreign key columns in the given foreign key
   table that reference the primary key or the columns representing a unique constraint of the  parent table (could be the same or a different table).
   The number of columns returned from the parent table must match the number of
   columns that make up the foreign key.  They
   are ordered by FKTABLE_CAT, FKTABLE_SCHEM, FKTABLE_NAME, and
   KEY_SEQ.

   Each foreign key column description has the following columns:

    PKTABLE_CAT String => parent key table catalog (may be null)
    PKTABLE_SCHEM String => parent key table schema (may be null)
    PKTABLE_NAME String => parent key table name
    PKCOLUMN_NAME String => parent key column name
    FKTABLE_CAT String => foreign key table catalog (may be null)
        being exported (may be null)
    FKTABLE_SCHEM String => foreign key table schema (may be null)
        being exported (may be null)
    FKTABLE_NAME String => foreign key table name
        being exported
    FKCOLUMN_NAME String => foreign key column name
        being exported
    KEY_SEQ short => sequence number within foreign key( a value
    of 1 represents the first column of the foreign key, a value of 2 would
    represent the second column within the foreign key).
    UPDATE_RULE short => What happens to
         foreign key when parent key is updated:

         importedNoAction - do not allow update of parent
                 key if it has been imported
         importedKeyCascade - change imported key to agree
                 with parent key update
         importedKeySetNull - change imported key to NULL if
                 its parent key has been updated
         importedKeySetDefault - change imported key to default values
                 if its parent key has been updated
         importedKeyRestrict - same as importedKeyNoAction
                                   (for ODBC 2.x compatibility)

    DELETE_RULE short => What happens to
        the foreign key when parent key is deleted.

         importedKeyNoAction - do not allow delete of parent
                 key if it has been imported
         importedKeyCascade - delete rows that import a deleted key
         importedKeySetNull - change imported key to NULL if
                 its primary key has been deleted
         importedKeyRestrict - same as importedKeyNoAction
                                   (for ODBC 2.x compatibility)
         importedKeySetDefault - change imported key to default if
                 its parent key has been deleted

    FK_NAME String => foreign key name (may be null)
    PK_NAME String => parent key name (may be null)
    DEFERRABILITY short => can the evaluation of foreign key
        constraints be deferred until commit

         importedKeyInitiallyDeferred - see SQL92 for definition
         importedKeyInitiallyImmediate - see SQL92 for definition
         importedKeyNotDeferrable - see SQL92 for definition

  parent-catalog - a catalog name; must match the catalog name as it is stored in the database; \"\" retrieves those without a catalog; null means drop catalog name from the selection criteria - `java.lang.String`
  parent-schema - a schema name; must match the schema name as it is stored in the database; \"\" retrieves those without a schema; null means drop schema name from the selection criteria - `java.lang.String`
  parent-table - the name of the table that exports the key; must match the table name as it is stored in the database - `java.lang.String`
  foreign-catalog - a catalog name; must match the catalog name as it is stored in the database; \"\" retrieves those without a catalog; null means drop catalog name from the selection criteria - `java.lang.String`
  foreign-schema - a schema name; must match the schema name as it is stored in the database; \"\" retrieves those without a schema; null means drop schema name from the selection criteria - `java.lang.String`
  foreign-table - the name of the table that imports the key; must match the table name as it is stored in the database - `java.lang.String`

  returns: ResultSet - each row is a foreign key column description - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String parent-catalog ^java.lang.String parent-schema ^java.lang.String parent-table ^java.lang.String foreign-catalog ^java.lang.String foreign-schema ^java.lang.String foreign-table]
    (-> this (.getCrossReference parent-catalog parent-schema parent-table foreign-catalog foreign-schema foreign-table))))

(defn supports-outer-joins
  "Retrieves whether this database supports some form of outer join.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsOuterJoins))))

(defn get-driver-version
  "Retrieves the version number of this JDBC driver as a String.

  returns: JDBC driver version - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.lang.String [^DatabaseMetaData this]
    (-> this (.getDriverVersion))))

(defn supports-group-by-beyond-select
  "Retrieves whether this database supports using columns not included in
   the SELECT statement in a GROUP BY clause
   provided that all of the columns in the SELECT statement
   are included in the GROUP BY clause.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsGroupByBeyondSelect))))

(defn read-only?
  "Retrieves whether this database is in read-only mode.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.isReadOnly))))

(defn supports-open-statements-across-commit
  "Retrieves whether this database supports keeping statements open
   across commits.

  returns: true if statements always remain open;
         false if they might not remain open - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsOpenStatementsAcrossCommit))))

(defn supports-extended-sql-grammar
  "Retrieves whether this database supports the ODBC Extended SQL grammar.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsExtendedSQLGrammar))))

(defn supports-mixed-case-quoted-identifiers
  "Retrieves whether this database treats mixed case quoted SQL identifiers as
   case sensitive and as a result stores them in mixed case.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsMixedCaseQuotedIdentifiers))))

(defn supports-mixed-case-identifiers
  "Retrieves whether this database treats mixed case unquoted SQL identifiers as
   case sensitive and as a result stores them in mixed case.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsMixedCaseIdentifiers))))

(defn get-max-catalog-name-length
  "Retrieves the maximum number of characters that this database allows in a
   catalog name.

  returns: the maximum number of characters allowed in a catalog name;
        a result of zero means that there is no limit or the limit
        is not known - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getMaxCatalogNameLength))))

(defn stores-lower-case-identifiers
  "Retrieves whether this database treats mixed case unquoted SQL identifiers as
   case insensitive and stores them in lower case.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.storesLowerCaseIdentifiers))))

(defn supports-result-set-concurrency
  "Retrieves whether this database supports the given concurrency type
   in combination with the given result set type.

  type - defined in java.sql.ResultSet - `int`
  concurrency - type defined in java.sql.ResultSet - `int`

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this ^Integer type ^Integer concurrency]
    (-> this (.supportsResultSetConcurrency type concurrency))))

(defn nulls-are-sorted-low
  "Retrieves whether NULL values are sorted low.
   Sorted low means that NULL values
   sort lower than any other value in a domain.  In an ascending order,
   if this method returns true,  NULL values
   will appear at the beginning. By contrast, the method
   nullsAreSortedAtStart indicates whether NULL values
   are sorted at the beginning regardless of sort order.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.nullsAreSortedLow))))

(defn supports-catalogs-in-index-definitions
  "Retrieves whether a catalog name can be used in an index definition statement.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsCatalogsInIndexDefinitions))))

(defn supports-non-nullable-columns
  "Retrieves whether columns in this database may be defined as non-nullable.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsNonNullableColumns))))

(defn get-jdbc-major-version
  "Retrieves the major JDBC version number for this
   driver.

  returns: JDBC version major number - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getJDBCMajorVersion))))

(defn get-max-columns-in-order-by
  "Retrieves the maximum number of columns this database allows in an
   ORDER BY clause.

  returns: the maximum number of columns allowed;
        a result of zero means that there is no limit or the limit
        is not known - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getMaxColumnsInOrderBy))))

(defn uses-local-file-per-table
  "Retrieves whether this database uses a file for each table.

  returns: true if this database uses a local file for each table;
           false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.usesLocalFilePerTable))))

(defn supports-open-cursors-across-commit
  "Retrieves whether this database supports keeping cursors open
   across commits.

  returns: true if cursors always remain open;
         false if they might not remain open - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsOpenCursorsAcrossCommit))))

(defn nulls-are-sorted-at-start
  "Retrieves whether NULL values are sorted at the start regardless
   of sort order.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.nullsAreSortedAtStart))))

(defn get-attributes
  "Retrieves a description of the given attribute of the given type
   for a user-defined type (UDT) that is available in the given schema
   and catalog.

   Descriptions are returned only for attributes of UDTs matching the
   catalog, schema, type, and attribute name criteria. They are ordered by
   TYPE_CAT, TYPE_SCHEM,
   TYPE_NAME and ORDINAL_POSITION. This description
   does not contain inherited attributes.

   The ResultSet object that is returned has the following
   columns:

    TYPE_CAT String => type catalog (may be null)
    TYPE_SCHEM String => type schema (may be null)
    TYPE_NAME String => type name
    ATTR_NAME String => attribute name
    DATA_TYPE int => attribute type SQL type from java.sql.Types
    ATTR_TYPE_NAME String => Data source dependent type name.
    For a UDT, the type name is fully qualified. For a REF, the type name is
    fully qualified and represents the target type of the reference type.
    ATTR_SIZE int => column size.  For char or date
        types this is the maximum number of characters; for numeric or
        decimal types this is precision.
    DECIMAL_DIGITS int => the number of fractional digits. Null is returned for data types where
   DECIMAL_DIGITS is not applicable.
    NUM_PREC_RADIX int => Radix (typically either 10 or 2)
    NULLABLE int => whether NULL is allowed

         attributeNoNulls - might not allow NULL values
         attributeNullable - definitely allows NULL values
         attributeNullableUnknown - nullability unknown

    REMARKS String => comment describing column (may be null)
    ATTR_DEF String => default value (may be null)
    SQL_DATA_TYPE int => unused
    SQL_DATETIME_SUB int => unused
    CHAR_OCTET_LENGTH int => for char types the
         maximum number of bytes in the column
    ORDINAL_POSITION int => index of the attribute in the UDT
        (starting at 1)
    IS_NULLABLE String  => ISO rules are used to determine
   the nullability for a attribute.

          YES           --- if the attribute can include NULLs
          NO            --- if the attribute cannot include NULLs
          empty string  --- if the nullability for the
   attribute is unknown

    SCOPE_CATALOG String => catalog of table that is the
        scope of a reference attribute (null if DATA_TYPE isn't REF)
    SCOPE_SCHEMA String => schema of table that is the
        scope of a reference attribute (null if DATA_TYPE isn't REF)
    SCOPE_TABLE String => table name that is the scope of a
        reference attribute (null if the DATA_TYPE isn't REF)
   SOURCE_DATA_TYPE short => source type of a distinct type or user-generated
        Ref type,SQL type from java.sql.Types (null if DATA_TYPE
        isn't DISTINCT or user-generated REF)

  catalog - a catalog name; must match the catalog name as it is stored in the database; \"\" retrieves those without a catalog; null means that the catalog name should not be used to narrow the search - `java.lang.String`
  schema-pattern - a schema name pattern; must match the schema name as it is stored in the database; \"\" retrieves those without a schema; null means that the schema name should not be used to narrow the search - `java.lang.String`
  type-name-pattern - a type name pattern; must match the type name as it is stored in the database - `java.lang.String`
  attribute-name-pattern - an attribute name pattern; must match the attribute name as it is declared in the database - `java.lang.String`

  returns: a ResultSet object in which each row is an
           attribute description - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String catalog ^java.lang.String schema-pattern ^java.lang.String type-name-pattern ^java.lang.String attribute-name-pattern]
    (-> this (.getAttributes catalog schema-pattern type-name-pattern attribute-name-pattern))))

(defn get-table-privileges
  "Retrieves a description of the access rights for each table available
   in a catalog. Note that a table privilege applies to one or
   more columns in the table. It would be wrong to assume that
   this privilege applies to all columns (this may be true for
   some systems but is not true for all.)

   Only privileges matching the schema and table name
   criteria are returned.  They are ordered by
   TABLE_CAT,
   TABLE_SCHEM, TABLE_NAME,
   and PRIVILEGE.

   Each privilege description has the following columns:

    TABLE_CAT String => table catalog (may be null)
    TABLE_SCHEM String => table schema (may be null)
    TABLE_NAME String => table name
    GRANTOR String => grantor of access (may be null)
    GRANTEE String => grantee of access
    PRIVILEGE String => name of access (SELECT,
        INSERT, UPDATE, REFRENCES, ...)
    IS_GRANTABLE String => \"YES\" if grantee is permitted
        to grant to others; \"NO\" if not; null if unknown

  catalog - a catalog name; must match the catalog name as it is stored in the database; \"\" retrieves those without a catalog; null means that the catalog name should not be used to narrow the search - `java.lang.String`
  schema-pattern - a schema name pattern; must match the schema name as it is stored in the database; \"\" retrieves those without a schema; null means that the schema name should not be used to narrow the search - `java.lang.String`
  table-name-pattern - a table name pattern; must match the table name as it is stored in the database - `java.lang.String`

  returns: ResultSet - each row is a table privilege description - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String catalog ^java.lang.String schema-pattern ^java.lang.String table-name-pattern]
    (-> this (.getTablePrivileges catalog schema-pattern table-name-pattern))))

(defn catalog-at-start?
  "Retrieves whether a catalog appears at the start of a fully qualified
   table name.  If not, the catalog appears at the end.

  returns: true if the catalog name appears at the beginning
           of a fully qualified table name; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.isCatalogAtStart))))

(defn supports-open-statements-across-rollback
  "Retrieves whether this database supports keeping statements open
   across rollbacks.

  returns: true if statements always remain open;
         false if they might not remain open - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsOpenStatementsAcrossRollback))))

(defn supports-ansi-92-full-sql
  "Retrieves whether this database supports the ANSI92 full SQL grammar supported.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsANSI92FullSQL))))

(defn supports-multiple-open-results
  "Retrieves whether it is possible to have multiple ResultSet objects
   returned from a CallableStatement object
   simultaneously.

  returns: true if a CallableStatement object
           can return multiple ResultSet objects
           simultaneously; false otherwise - `boolean`

  throws: java.sql.SQLException - if a datanase access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsMultipleOpenResults))))

(defn get-max-statements
  "Retrieves the maximum number of active statements to this database
   that can be open at the same time.

  returns: the maximum number of statements that can be open at one time;
        a result of zero means that there is no limit or the limit
        is not known - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getMaxStatements))))

(defn get-database-major-version
  "Retrieves the major version number of the underlying database.

  returns: the underlying database's major version - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getDatabaseMajorVersion))))

(defn supports-result-set-type
  "Retrieves whether this database supports the given result set type.

  type - defined in java.sql.ResultSet - `int`

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this ^Integer type]
    (-> this (.supportsResultSetType type))))

(defn deletes-are-detected
  "Retrieves whether or not a visible row delete can be detected by
   calling the method ResultSet.rowDeleted.  If the method
   deletesAreDetected returns false, it means that
   deleted rows are removed from the result set.

  type - the ResultSet type; one of ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE - `int`

  returns: true if deletes are detected by the given result set type;
           false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this ^Integer type]
    (-> this (.deletesAreDetected type))))

(defn get-max-table-name-length
  "Retrieves the maximum number of characters this database allows in
   a table name.

  returns: the maximum number of characters allowed for a table name;
        a result of zero means that there is no limit or the limit
        is not known - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Integer [^DatabaseMetaData this]
    (-> this (.getMaxTableNameLength))))

(defn get-function-columns
  "Retrieves a description of the given catalog's system or user
   function parameters and return type.

   Only descriptions matching the schema,  function and
   parameter name criteria are returned. They are ordered by
   FUNCTION_CAT, FUNCTION_SCHEM,
   FUNCTION_NAME and
   SPECIFIC_ NAME. Within this, the return value,
   if any, is first. Next are the parameter descriptions in call
   order. The column descriptions follow in column number order.

   Each row in the ResultSet
   is a parameter description, column description or
   return type description with the following fields:

    FUNCTION_CAT String => function catalog (may be null)
    FUNCTION_SCHEM String => function schema (may be null)
    FUNCTION_NAME String => function name.  This is the name
   used to invoke the function
    COLUMN_NAME String => column/parameter name
    COLUMN_TYPE Short => kind of column/parameter:

         functionColumnUnknown - nobody knows
         functionColumnIn - IN parameter
         functionColumnInOut - INOUT parameter
         functionColumnOut - OUT parameter
         functionColumnReturn - function return value
         functionColumnResult - Indicates that the parameter or column
    is a column in the ResultSet

    DATA_TYPE int => SQL type from java.sql.Types
    TYPE_NAME String => SQL type name, for a UDT type the
    type name is fully qualified
    PRECISION int => precision
    LENGTH int => length in bytes of data
    SCALE short => scale -  null is returned for data types where
   SCALE is not applicable.
    RADIX short => radix
    NULLABLE short => can it contain NULL.

         functionNoNulls - does not allow NULL values
         functionNullable - allows NULL values
         functionNullableUnknown - nullability unknown

    REMARKS String => comment describing column/parameter
    CHAR_OCTET_LENGTH int  => the maximum length of binary
   and character based parameters or columns.  For any other datatype the returned value
   is a NULL
    ORDINAL_POSITION int  => the ordinal position, starting
   from 1, for the input and output parameters. A value of 0
   is returned if this row describes the function's return value.
   For result set columns, it is the
   ordinal position of the column in the result set starting from 1.
    IS_NULLABLE String  => ISO rules are used to determine
   the nullability for a parameter or column.

          YES           --- if the parameter or column can include NULLs
          NO            --- if the parameter or column  cannot include NULLs
          empty string  --- if the nullability for the
   parameter  or column is unknown

    SPECIFIC_NAME String  => the name which uniquely identifies
   this function within its schema.  This is a user specified, or DBMS
   generated, name that may be different then the FUNCTION_NAME
   for example with overload functions


   The PRECISION column represents the specified column size for the given
   parameter or column.
   For numeric data, this is the maximum precision.  For character data, this is the length in characters.
   For datetime datatypes, this is the length in characters of the String representation (assuming the
   maximum allowed precision of the fractional seconds component). For binary data, this is the length in bytes.  For the ROWID datatype,
   this is the length in bytes. Null is returned for data types where the
   column size is not applicable.

  catalog - a catalog name; must match the catalog name as it is stored in the database; \"\" retrieves those without a catalog; null means that the catalog name should not be used to narrow the search - `java.lang.String`
  schema-pattern - a schema name pattern; must match the schema name as it is stored in the database; \"\" retrieves those without a schema; null means that the schema name should not be used to narrow the search - `java.lang.String`
  function-name-pattern - a procedure name pattern; must match the function name as it is stored in the database - `java.lang.String`
  column-name-pattern - a parameter name pattern; must match the parameter or column name as it is stored in the database - `java.lang.String`

  returns: ResultSet - each row describes a
   user function parameter, column  or return type - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String catalog ^java.lang.String schema-pattern ^java.lang.String function-name-pattern ^java.lang.String column-name-pattern]
    (-> this (.getFunctionColumns catalog schema-pattern function-name-pattern column-name-pattern))))

(defn supports-schemas-in-privilege-definitions
  "Retrieves whether a schema name can be used in a privilege definition statement.

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  (^Boolean [^DatabaseMetaData this]
    (-> this (.supportsSchemasInPrivilegeDefinitions))))

(defn get-super-types
  "Retrieves a description of the user-defined type (UDT) hierarchies defined in a
   particular schema in this database. Only the immediate super type/
   sub type relationship is modeled.

   Only supertype information for UDTs matching the catalog,
   schema, and type name is returned. The type name parameter
   may be a fully-qualified name. When the UDT name supplied is a
   fully-qualified name, the catalog and schemaPattern parameters are
   ignored.

   If a UDT does not have a direct super type, it is not listed here.
   A row of the ResultSet object returned by this method
   describes the designated UDT and a direct supertype. A row has the following
   columns:

    TYPE_CAT String => the UDT's catalog (may be null)
    TYPE_SCHEM String => UDT's schema (may be null)
    TYPE_NAME String => type name of the UDT
    SUPERTYPE_CAT String => the direct super type's catalog
                             (may be null)
    SUPERTYPE_SCHEM String => the direct super type's schema
                               (may be null)
    SUPERTYPE_NAME String => the direct super type's name


   Note: If the driver does not support type hierarchies, an
   empty result set is returned.

  catalog - a catalog name; \"\" retrieves those without a catalog; null means drop catalog name from the selection criteria - `java.lang.String`
  schema-pattern - a schema name pattern; \"\" retrieves those without a schema - `java.lang.String`
  type-name-pattern - a UDT name pattern; may be a fully-qualified name - `java.lang.String`

  returns: a ResultSet object in which a row gives information
           about the designated UDT - `java.sql.ResultSet`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.ResultSet [^DatabaseMetaData this ^java.lang.String catalog ^java.lang.String schema-pattern ^java.lang.String type-name-pattern]
    (-> this (.getSuperTypes catalog schema-pattern type-name-pattern))))

