(ns jdk.sql.Struct
  "The standard mapping in the Java programming language for an SQL
  structured type. A Struct object contains a
  value for each attribute of the SQL structured type that
  it represents.
  By default, an instance ofStruct is valid as long as the
  application has a reference to it.

  All methods on the Struct interface must be fully implemented if the
  JDBC driver supports the data type."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql Struct]))

(defn get-sql-type-name
  "Retrieves the SQL type name of the SQL structured type
   that this Struct object represents.

  returns: the fully-qualified type name of the SQL structured
            type for which this Struct object
            is the generic representation - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^. this]
    (-> this (.getSQLTypeName))))

(defn get-attributes
  "Produces the ordered values of the attributes of the SQL
   structured type that this Struct object represents.
    As individual attributes are processed, this method uses the given type map
   for customizations of the type mappings.
   If there is no
   entry in the given type map that matches the structured
   type that an attribute represents,
   the driver uses the standard mapping. This method never
   uses the type map associated with the connection.

   Conceptually, this method calls the method
   getObject on each attribute
   of the structured type and returns a Java array containing
   the result.

  map - a mapping of SQL type names to Java classes - `java.util.Map<java.lang.String,java.lang.Class<?>>`

  returns: an array containing the ordered attribute values - `java.lang.Object[]`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^. this ^java.util.Map> map]
    (-> this (.getAttributes map)))
  ([^. this]
    (-> this (.getAttributes))))

