(ns jdk.sql.Ref
  "The mapping in the Java programming language of an SQL REF
  value, which is a reference to an SQL structured type value in the database.

  SQL REF values are stored in a table that contains
  instances of a referenceable SQL structured type, and each REF
  value is a unique identifier for one instance in that table.
  An SQL REF value may be used in place of the
  SQL structured type it references, either as a column value in a
  table or an attribute value in a structured type.

  Because an SQL REF value is a logical pointer to an
  SQL structured type, a Ref object is by default also a logical
  pointer. Thus, retrieving an SQL REF value as
  a Ref object does not materialize
  the attributes of the structured type on the client.

  A Ref object can be stored in the database using the
  PreparedStatement.setRef method.

  All methods on the Ref interface must be fully implemented if the
  JDBC driver supports the data type."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql Ref]))

(defn get-base-type-name
  "Retrieves the fully-qualified SQL name of the SQL structured type that
   this Ref object references.

  returns: the fully-qualified SQL name of the referenced SQL structured type - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this]
    (-> this (.getBaseTypeName))))

(defn get-object
  "Retrieves the referenced object and maps it to a Java type
   using the given type map.

  map - a java.util.Map object that contains the mapping to use (the fully-qualified name of the SQL structured type being referenced and the class object for SQLData implementation to which the SQL structured type will be mapped) - `java.util.Map<java.lang.String,java.lang.Class<?>>`

  returns: a Java Object that is the custom mapping for
            the SQL structured type to which this Ref
            object refers - `java.lang.Object`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this map]
    (-> this (.getObject map)))
  ([this]
    (-> this (.getObject))))

(defn set-object
  "Sets the structured type value that this Ref
   object references to the given instance of Object.
   The driver converts this to an SQL structured type when it
   sends it to the database.

  value - an Object representing the SQL structured type instance that this Ref object will reference - `java.lang.Object`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this value]
    (-> this (.setObject value))))

