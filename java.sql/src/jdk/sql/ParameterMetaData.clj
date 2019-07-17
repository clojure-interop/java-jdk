(ns jdk.sql.ParameterMetaData
  "An object that can be used to get information about the types
  and properties for each parameter marker in a
  PreparedStatement object. For some queries and driver
  implementations, the data that would be returned by a ParameterMetaData
  object may not be available until the PreparedStatement has
  been executed.

 Some driver implementations may not be able to provide information about the
 types and properties for each parameter marker in a CallableStatement
 object."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql ParameterMetaData]))

(defn get-precision
  "Retrieves the designated parameter's specified column size.

   The returned value represents the maximum column size for the given parameter.
   For numeric data, this is the maximum precision.  For character data, this is the length in characters.
   For datetime datatypes, this is the length in characters of the String representation (assuming the
   maximum allowed precision of the fractional seconds component). For binary data, this is the length in bytes.  For the ROWID datatype,
   this is the length in bytes. 0 is returned for data types where the
   column size is not applicable.

  param - the first parameter is 1, the second is 2, ... - `int`

  returns: precision - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ParameterMetaData this ^Integer param]
    (-> this (.getPrecision param))))

(defn get-parameter-count
  "Retrieves the number of parameters in the PreparedStatement
   object for which this ParameterMetaData object contains
   information.

  returns: the number of parameters - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ParameterMetaData this]
    (-> this (.getParameterCount))))

(defn get-scale
  "Retrieves the designated parameter's number of digits to right of the decimal point.
   0 is returned for data types where the scale is not applicable.

  param - the first parameter is 1, the second is 2, ... - `int`

  returns: scale - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ParameterMetaData this ^Integer param]
    (-> this (.getScale param))))

(defn get-parameter-type-name
  "Retrieves the designated parameter's database-specific type name.

  param - the first parameter is 1, the second is 2, ... - `int`

  returns: type the name used by the database. If the parameter type is
   a user-defined type, then a fully-qualified type name is returned. - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ParameterMetaData this ^Integer param]
    (-> this (.getParameterTypeName param))))

(defn get-parameter-class-name
  "Retrieves the fully-qualified name of the Java class whose instances
   should be passed to the method PreparedStatement.setObject.

  param - the first parameter is 1, the second is 2, ... - `int`

  returns: the fully-qualified name of the class in the Java programming
           language that would be used by the method
           PreparedStatement.setObject to set the value
           in the specified parameter. This is the class name used
           for custom mapping. - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ParameterMetaData this ^Integer param]
    (-> this (.getParameterClassName param))))

(defn signed?
  "Retrieves whether values for the designated parameter can be signed numbers.

  param - the first parameter is 1, the second is 2, ... - `int`

  returns: true if so; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ParameterMetaData this ^Integer param]
    (-> this (.isSigned param))))

(defn get-parameter-type
  "Retrieves the designated parameter's SQL type.

  param - the first parameter is 1, the second is 2, ... - `int`

  returns: SQL type from java.sql.Types - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ParameterMetaData this ^Integer param]
    (-> this (.getParameterType param))))

(defn is-nullable
  "Retrieves whether null values are allowed in the designated parameter.

  param - the first parameter is 1, the second is 2, ... - `int`

  returns: the nullability status of the given parameter; one of
          ParameterMetaData.parameterNoNulls,
          ParameterMetaData.parameterNullable, or
          ParameterMetaData.parameterNullableUnknown - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ParameterMetaData this ^Integer param]
    (-> this (.isNullable param))))

(defn get-parameter-mode
  "Retrieves the designated parameter's mode.

  param - the first parameter is 1, the second is 2, ... - `int`

  returns: mode of the parameter; one of
          ParameterMetaData.parameterModeIn,
          ParameterMetaData.parameterModeOut, or
          ParameterMetaData.parameterModeInOut
          ParameterMetaData.parameterModeUnknown. - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.ParameterMetaData this ^Integer param]
    (-> this (.getParameterMode param))))

