(ns jdk.sql.SQLData
  "The interface used for the custom mapping of an SQL user-defined type (UDT) to
  a class in the Java programming language. The class object for a class
  implementing the SQLData interface will be entered in the
  appropriate Connection object's type map along with the SQL
  name of the UDT for which it is a custom mapping.

  Typically, a SQLData implementation
  will define a field for each attribute of an SQL structured type or a
  single field for an SQL DISTINCT type. When the UDT is
  retrieved from a data source with the ResultSet.getObject
  method, it will be mapped as an instance of this class.  A programmer
  can operate on this class instance just as on any other object in the
  Java programming language and then store any changes made to it by
  calling the PreparedStatement.setObject method,
  which will map it back to the SQL type.

  It is expected that the implementation of the class for a custom
  mapping will be done by a tool.  In a typical implementation, the
  programmer would simply supply the name of the SQL UDT, the name of
  the class to which it is being mapped, and the names of the fields to
  which each of the attributes of the UDT is to be mapped.  The tool will use
  this information to implement the SQLData.readSQL and
  SQLData.writeSQL methods.  The readSQL method
  calls the appropriate SQLInput methods to read
  each attribute from an SQLInput object, and the
  writeSQL method calls SQLOutput methods
  to write each attribute back to the data source via an
  SQLOutput object.

  An application programmer will not normally call SQLData methods
  directly, and the SQLInput and SQLOutput methods
  are called internally by SQLData methods, not by application code."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql SQLData]))

(defn get-sql-type-name
  "Returns the fully-qualified
   name of the SQL user-defined type that this object represents.
   This method is called by the JDBC driver to get the name of the
   UDT instance that is being mapped to this instance of
   SQLData.

  returns: the type name that was passed to the method readSQL
              when this object was constructed and populated - `java.lang.String`

  throws: java.sql.SQLException - if there is a database access error"
  ([this]
    (-> this (.getSQLTypeName))))

(defn read-sql
  "Populates this object with data read from the database.
   The implementation of the method must follow this protocol:

   It must read each of the attributes or elements of the SQL
   type  from the given input stream.  This is done
   by calling a method of the input stream to read each
   item, in the order that they appear in the SQL definition
   of the type.
   The method readSQL then
   assigns the data to appropriate fields or
   elements (of this or other objects).
   Specifically, it must call the appropriate reader method
   (SQLInput.readString, SQLInput.readBigDecimal,
   and so on) method(s) to do the following:
   for a distinct type, read its single data element;
   for a structured type, read a value for each attribute of the SQL type.

   The JDBC driver initializes the input stream with a type map
   before calling this method, which is used by the appropriate
   SQLInput reader method on the stream.

  stream - the SQLInput object from which to read the data for the value that is being custom mapped - `java.sql.SQLInput`
  type-name - the SQL type name of the value on the data stream - `java.lang.String`

  throws: java.sql.SQLException - if there is a database access error"
  ([this stream type-name]
    (-> this (.readSQL stream type-name))))

(defn write-sql
  "Writes this object to the given SQL data stream, converting it back to
   its SQL value in the data source.
   The implementation of the method must follow this protocol:
   It must write each of the attributes of the SQL type
   to the given output stream.  This is done by calling a
   method of the output stream to write each item, in the order that
   they appear in the SQL definition of the type.
   Specifically, it must call the appropriate SQLOutput writer
   method(s) (writeInt, writeString, and so on)
   to do the following: for a Distinct Type, write its single data element;
   for a Structured Type, write a value for each attribute of the SQL type.

  stream - the SQLOutput object to which to write the data for the value that was custom mapped - `java.sql.SQLOutput`

  throws: java.sql.SQLException - if there is a database access error"
  ([this stream]
    (-> this (.writeSQL stream))))

