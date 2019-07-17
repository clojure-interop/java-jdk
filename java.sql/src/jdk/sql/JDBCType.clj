(ns jdk.sql.JDBCType
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql JDBCType]))

(def BIT
  "Enum Constant.

  Identifies the generic SQL type BIT.

  type: java.sql.JDBCType"
  JDBCType/BIT)

(def TINYINT
  "Enum Constant.

  Identifies the generic SQL type TINYINT.

  type: java.sql.JDBCType"
  JDBCType/TINYINT)

(def SMALLINT
  "Enum Constant.

  Identifies the generic SQL type SMALLINT.

  type: java.sql.JDBCType"
  JDBCType/SMALLINT)

(def INTEGER
  "Enum Constant.

  Identifies the generic SQL type INTEGER.

  type: java.sql.JDBCType"
  JDBCType/INTEGER)

(def BIGINT
  "Enum Constant.

  Identifies the generic SQL type BIGINT.

  type: java.sql.JDBCType"
  JDBCType/BIGINT)

(def FLOAT
  "Enum Constant.

  Identifies the generic SQL type FLOAT.

  type: java.sql.JDBCType"
  JDBCType/FLOAT)

(def REAL
  "Enum Constant.

  Identifies the generic SQL type REAL.

  type: java.sql.JDBCType"
  JDBCType/REAL)

(def DOUBLE
  "Enum Constant.

  Identifies the generic SQL type DOUBLE.

  type: java.sql.JDBCType"
  JDBCType/DOUBLE)

(def NUMERIC
  "Enum Constant.

  Identifies the generic SQL type NUMERIC.

  type: java.sql.JDBCType"
  JDBCType/NUMERIC)

(def DECIMAL
  "Enum Constant.

  Identifies the generic SQL type DECIMAL.

  type: java.sql.JDBCType"
  JDBCType/DECIMAL)

(def CHAR
  "Enum Constant.

  Identifies the generic SQL type CHAR.

  type: java.sql.JDBCType"
  JDBCType/CHAR)

(def VARCHAR
  "Enum Constant.

  Identifies the generic SQL type VARCHAR.

  type: java.sql.JDBCType"
  JDBCType/VARCHAR)

(def LONGVARCHAR
  "Enum Constant.

  Identifies the generic SQL type LONGVARCHAR.

  type: java.sql.JDBCType"
  JDBCType/LONGVARCHAR)

(def DATE
  "Enum Constant.

  Identifies the generic SQL type DATE.

  type: java.sql.JDBCType"
  JDBCType/DATE)

(def TIME
  "Enum Constant.

  Identifies the generic SQL type TIME.

  type: java.sql.JDBCType"
  JDBCType/TIME)

(def TIMESTAMP
  "Enum Constant.

  Identifies the generic SQL type TIMESTAMP.

  type: java.sql.JDBCType"
  JDBCType/TIMESTAMP)

(def BINARY
  "Enum Constant.

  Identifies the generic SQL type BINARY.

  type: java.sql.JDBCType"
  JDBCType/BINARY)

(def VARBINARY
  "Enum Constant.

  Identifies the generic SQL type VARBINARY.

  type: java.sql.JDBCType"
  JDBCType/VARBINARY)

(def LONGVARBINARY
  "Enum Constant.

  Identifies the generic SQL type LONGVARBINARY.

  type: java.sql.JDBCType"
  JDBCType/LONGVARBINARY)

(def NULL
  "Enum Constant.

  Identifies the generic SQL value NULL.

  type: java.sql.JDBCType"
  JDBCType/NULL)

(def OTHER
  "Enum Constant.

  Indicates that the SQL type
   is database-specific and gets mapped to a Java object that can be
   accessed via the methods getObject and setObject.

  type: java.sql.JDBCType"
  JDBCType/OTHER)

(def JAVA_OBJECT
  "Enum Constant.

  Indicates that the SQL type
   is database-specific and gets mapped to a Java object that can be
   accessed via the methods getObject and setObject.

  type: java.sql.JDBCType"
  JDBCType/JAVA_OBJECT)

(def DISTINCT
  "Enum Constant.

  Identifies the generic SQL type DISTINCT.

  type: java.sql.JDBCType"
  JDBCType/DISTINCT)

(def STRUCT
  "Enum Constant.

  Identifies the generic SQL type STRUCT.

  type: java.sql.JDBCType"
  JDBCType/STRUCT)

(def ARRAY
  "Enum Constant.

  Identifies the generic SQL type ARRAY.

  type: java.sql.JDBCType"
  JDBCType/ARRAY)

(def BLOB
  "Enum Constant.

  Identifies the generic SQL type BLOB.

  type: java.sql.JDBCType"
  JDBCType/BLOB)

(def CLOB
  "Enum Constant.

  Identifies the generic SQL type CLOB.

  type: java.sql.JDBCType"
  JDBCType/CLOB)

(def REF
  "Enum Constant.

  Identifies the generic SQL type REF.

  type: java.sql.JDBCType"
  JDBCType/REF)

(def DATALINK
  "Enum Constant.

  Identifies the generic SQL type DATALINK.

  type: java.sql.JDBCType"
  JDBCType/DATALINK)

(def BOOLEAN
  "Enum Constant.

  Identifies the generic SQL type BOOLEAN.

  type: java.sql.JDBCType"
  JDBCType/BOOLEAN)

(def ROWID
  "Enum Constant.

  Identifies the SQL type ROWID.

  type: java.sql.JDBCType"
  JDBCType/ROWID)

(def NCHAR
  "Enum Constant.

  Identifies the generic SQL type NCHAR.

  type: java.sql.JDBCType"
  JDBCType/NCHAR)

(def NVARCHAR
  "Enum Constant.

  Identifies the generic SQL type NVARCHAR.

  type: java.sql.JDBCType"
  JDBCType/NVARCHAR)

(def LONGNVARCHAR
  "Enum Constant.

  Identifies the generic SQL type LONGNVARCHAR.

  type: java.sql.JDBCType"
  JDBCType/LONGNVARCHAR)

(def NCLOB
  "Enum Constant.

  Identifies the generic SQL type NCLOB.

  type: java.sql.JDBCType"
  JDBCType/NCLOB)

(def SQLXML
  "Enum Constant.

  Identifies the generic SQL type SQLXML.

  type: java.sql.JDBCType"
  JDBCType/SQLXML)

(def REF_CURSOR
  "Enum Constant.

  Identifies the generic SQL type REF_CURSOR.

  type: java.sql.JDBCType"
  JDBCType/REF_CURSOR)

(def TIME_WITH_TIMEZONE
  "Enum Constant.

  Identifies the generic SQL type TIME_WITH_TIMEZONE.

  type: java.sql.JDBCType"
  JDBCType/TIME_WITH_TIMEZONE)

(def TIMESTAMP_WITH_TIMEZONE
  "Enum Constant.

  Identifies the generic SQL type TIMESTAMP_WITH_TIMEZONE.

  type: java.sql.JDBCType"
  JDBCType/TIMESTAMP_WITH_TIMEZONE)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (JDBCType c : JDBCType.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.sql.JDBCType[]`"
  ([]
    (JDBCType/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.sql.JDBCType`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.sql.JDBCType [^java.lang.String name]
    (JDBCType/valueOf name)))

(defn get-name
  "Returns the SQLType name that represents a SQL data type.

  returns: The name of this SQLType. - `java.lang.String`"
  (^java.lang.String [^java.sql.JDBCType this]
    (-> this (.getName))))

(defn get-vendor
  "Returns the name of the vendor that supports this data type.

  returns: The name of the vendor for this data type which is
   java.sql for JDBCType. - `java.lang.String`"
  (^java.lang.String [^java.sql.JDBCType this]
    (-> this (.getVendor))))

(defn get-vendor-type-number
  "Returns the vendor specific type number for the data type.

  returns: An Integer representing the data type. For JDBCType,
   the value will be the same value as in Types for the data type. - `java.lang.Integer`"
  (^java.lang.Integer [^java.sql.JDBCType this]
    (-> this (.getVendorTypeNumber))))

