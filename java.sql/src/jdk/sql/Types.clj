(ns jdk.sql.Types
  "The class that defines the constants that are used to identify generic
  SQL types, called JDBC types.

  This class is never instantiated."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql Types]))

(def *-bit
  "Static Constant.

  The constant in the Java programming language, sometimes referred
   to as a type code, that identifies the generic SQL type
   BIT.

  type: int"
  Types/BIT)

(def *-tinyint
  "Static Constant.

  The constant in the Java programming language, sometimes referred
   to as a type code, that identifies the generic SQL type
   TINYINT.

  type: int"
  Types/TINYINT)

(def *-smallint
  "Static Constant.

  The constant in the Java programming language, sometimes referred
   to as a type code, that identifies the generic SQL type
   SMALLINT.

  type: int"
  Types/SMALLINT)

(def *-integer
  "Static Constant.

  The constant in the Java programming language, sometimes referred
   to as a type code, that identifies the generic SQL type
   INTEGER.

  type: int"
  Types/INTEGER)

(def *-bigint
  "Static Constant.

  The constant in the Java programming language, sometimes referred
   to as a type code, that identifies the generic SQL type
   BIGINT.

  type: int"
  Types/BIGINT)

(def *-float
  "Static Constant.

  The constant in the Java programming language, sometimes referred
   to as a type code, that identifies the generic SQL type
   FLOAT.

  type: int"
  Types/FLOAT)

(def *-real
  "Static Constant.

  The constant in the Java programming language, sometimes referred
   to as a type code, that identifies the generic SQL type
   REAL.

  type: int"
  Types/REAL)

(def *-double
  "Static Constant.

  The constant in the Java programming language, sometimes referred
   to as a type code, that identifies the generic SQL type
   DOUBLE.

  type: int"
  Types/DOUBLE)

(def *-numeric
  "Static Constant.

  The constant in the Java programming language, sometimes referred
   to as a type code, that identifies the generic SQL type
   NUMERIC.

  type: int"
  Types/NUMERIC)

(def *-decimal
  "Static Constant.

  The constant in the Java programming language, sometimes referred
   to as a type code, that identifies the generic SQL type
   DECIMAL.

  type: int"
  Types/DECIMAL)

(def *-char
  "Static Constant.

  The constant in the Java programming language, sometimes referred
   to as a type code, that identifies the generic SQL type
   CHAR.

  type: int"
  Types/CHAR)

(def *-varchar
  "Static Constant.

  The constant in the Java programming language, sometimes referred
   to as a type code, that identifies the generic SQL type
   VARCHAR.

  type: int"
  Types/VARCHAR)

(def *-longvarchar
  "Static Constant.

  The constant in the Java programming language, sometimes referred
   to as a type code, that identifies the generic SQL type
   LONGVARCHAR.

  type: int"
  Types/LONGVARCHAR)

(def *-date
  "Static Constant.

  The constant in the Java programming language, sometimes referred
   to as a type code, that identifies the generic SQL type
   DATE.

  type: int"
  Types/DATE)

(def *-time
  "Static Constant.

  The constant in the Java programming language, sometimes referred
   to as a type code, that identifies the generic SQL type
   TIME.

  type: int"
  Types/TIME)

(def *-timestamp
  "Static Constant.

  The constant in the Java programming language, sometimes referred
   to as a type code, that identifies the generic SQL type
   TIMESTAMP.

  type: int"
  Types/TIMESTAMP)

(def *-binary
  "Static Constant.

  The constant in the Java programming language, sometimes referred
   to as a type code, that identifies the generic SQL type
   BINARY.

  type: int"
  Types/BINARY)

(def *-varbinary
  "Static Constant.

  The constant in the Java programming language, sometimes referred
   to as a type code, that identifies the generic SQL type
   VARBINARY.

  type: int"
  Types/VARBINARY)

(def *-longvarbinary
  "Static Constant.

  The constant in the Java programming language, sometimes referred
   to as a type code, that identifies the generic SQL type
   LONGVARBINARY.

  type: int"
  Types/LONGVARBINARY)

(def *-null
  "Static Constant.

  The constant in the Java programming language
   that identifies the generic SQL value
   NULL.

  type: int"
  Types/NULL)

(def *-other
  "Static Constant.

  The constant in the Java programming language that indicates
   that the SQL type is database-specific and
   gets mapped to a Java object that can be accessed via
   the methods getObject and setObject.

  type: int"
  Types/OTHER)

(def *-java-object
  "Static Constant.

  The constant in the Java programming language, sometimes referred to
   as a type code, that identifies the generic SQL type
   JAVA_OBJECT.

  type: int"
  Types/JAVA_OBJECT)

(def *-distinct
  "Static Constant.

  The constant in the Java programming language, sometimes referred to
   as a type code, that identifies the generic SQL type
   DISTINCT.

  type: int"
  Types/DISTINCT)

(def *-struct
  "Static Constant.

  The constant in the Java programming language, sometimes referred to
   as a type code, that identifies the generic SQL type
   STRUCT.

  type: int"
  Types/STRUCT)

(def *-array
  "Static Constant.

  The constant in the Java programming language, sometimes referred to
   as a type code, that identifies the generic SQL type
   ARRAY.

  type: int"
  Types/ARRAY)

(def *-blob
  "Static Constant.

  The constant in the Java programming language, sometimes referred to
   as a type code, that identifies the generic SQL type
   BLOB.

  type: int"
  Types/BLOB)

(def *-clob
  "Static Constant.

  The constant in the Java programming language, sometimes referred to
   as a type code, that identifies the generic SQL type
   CLOB.

  type: int"
  Types/CLOB)

(def *-ref
  "Static Constant.

  The constant in the Java programming language, sometimes referred to
   as a type code, that identifies the generic SQL type
   REF.

  type: int"
  Types/REF)

(def *-datalink
  "Static Constant.

  The constant in the Java programming language, somtimes referred to
   as a type code, that identifies the generic SQL type DATALINK.

  type: int"
  Types/DATALINK)

(def *-boolean
  "Static Constant.

  The constant in the Java programming language, somtimes referred to
   as a type code, that identifies the generic SQL type BOOLEAN.

  type: int"
  Types/BOOLEAN)

(def *-rowid
  "Static Constant.

  The constant in the Java programming language, sometimes referred to
   as a type code, that identifies the generic SQL type ROWID

  type: int"
  Types/ROWID)

(def *-nchar
  "Static Constant.

  The constant in the Java programming language, sometimes referred to
   as a type code, that identifies the generic SQL type NCHAR

  type: int"
  Types/NCHAR)

(def *-nvarchar
  "Static Constant.

  The constant in the Java programming language, sometimes referred to
   as a type code, that identifies the generic SQL type NVARCHAR.

  type: int"
  Types/NVARCHAR)

(def *-longnvarchar
  "Static Constant.

  The constant in the Java programming language, sometimes referred to
   as a type code, that identifies the generic SQL type LONGNVARCHAR.

  type: int"
  Types/LONGNVARCHAR)

(def *-nclob
  "Static Constant.

  The constant in the Java programming language, sometimes referred to
   as a type code, that identifies the generic SQL type NCLOB.

  type: int"
  Types/NCLOB)

(def *-sqlxml
  "Static Constant.

  The constant in the Java programming language, sometimes referred to
   as a type code, that identifies the generic SQL type XML.

  type: int"
  Types/SQLXML)

(def *-ref-cursor
  "Static Constant.

  The constant in the Java programming language, sometimes referred to
   as a type code, that identifies the generic SQL type REF CURSOR.

  type: int"
  Types/REF_CURSOR)

(def *-time-with-timezone
  "Static Constant.

  The constant in the Java programming language, sometimes referred to
   as a type code, that identifies the generic SQL type
   TIME WITH TIMEZONE.

  type: int"
  Types/TIME_WITH_TIMEZONE)

(def *-timestamp-with-timezone
  "Static Constant.

  The constant in the Java programming language, sometimes referred to
   as a type code, that identifies the generic SQL type
   TIMESTAMP WITH TIMEZONE.

  type: int"
  Types/TIMESTAMP_WITH_TIMEZONE)

