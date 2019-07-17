(ns jdk.sql.NClob
  "The mapping in the Java™ programming language
  for the SQL NCLOB type.
  An SQL NCLOB is a built-in type
  that stores a Character Large Object using the National Character Set
   as a column value in a row of  a database table.
  The NClob interface extends the Clob interface
  which provides provides methods for getting the
  length of an SQL NCLOB value,
  for materializing a NCLOB value on the client, and for
  searching for a substring or NCLOB object within a
  NCLOB value. A NClob object, just like a Clob object, is valid for the duration
  of the transaction in which it was created.
  Methods in the interfaces ResultSet,
  CallableStatement, and PreparedStatement, such as
  getNClob and setNClob allow a programmer to
  access an SQL NCLOB value.  In addition, this interface
  has methods for updating a NCLOB value.

  All methods on the NClob interface must be fully implemented if the
  JDBC driver supports the data type."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql NClob]))

