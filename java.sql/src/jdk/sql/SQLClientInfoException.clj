(ns jdk.sql.SQLClientInfoException
  "The subclass of SQLException is thrown when one or more client info properties
  could not be set on a Connection.  In addition to the information provided
  by SQLException, a SQLClientInfoException provides a list of client info
  properties that were not set.

  Some databases do not allow multiple client info properties to be set
  atomically.  For those databases, it is possible that some of the client
  info properties had been set even though the Connection.setClientInfo
  method threw an exception.  An application can use the getFailedProperties
  method to retrieve a list of client info properties that were not set.  The
  properties are identified by passing a
  Map<String,ClientInfoStatus> to
  the appropriate SQLClientInfoException constructor."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql SQLClientInfoException]))

(defn ->sql-client-info-exception
  "Constructor.

  Constructs a SQLClientInfoException object initialized with a
   given  reason, SQLState,
   cause, vendorCode and
   failedProperties.

  reason - a description of the exception - `java.lang.String`
  sql-state - an XOPEN or SQL:2003 code identifying the exception - `java.lang.String`
  vendor-code - a database vendor-specific exception code - `int`
  failed-properties - A Map containing the property values that could not be set. The keys in the Map contain the names of the client info properties that could not be set and the values contain one of the reason codes defined in ClientInfoStatus - `java.util.Map<java.lang.String,java.sql.ClientInfoStatus>`
  cause - the underlying reason for this SQLException (which is saved for later retrieval by the getCause() method); may be null indicating the cause is non-existent or unknown. - `java.lang.Throwable`"
  ([^java.lang.String reason ^java.lang.String sql-state ^Integer vendor-code ^java.util.Map failed-properties ^java.lang.Throwable cause]
    (new SQLClientInfoException reason sql-state vendor-code failed-properties cause))
  ([^java.lang.String reason ^java.lang.String sql-state ^java.util.Map failed-properties ^java.lang.Throwable cause]
    (new SQLClientInfoException reason sql-state failed-properties cause))
  ([^java.lang.String reason ^java.util.Map failed-properties ^java.lang.Throwable cause]
    (new SQLClientInfoException reason failed-properties cause))
  ([^java.util.Map failed-properties ^java.lang.Throwable cause]
    (new SQLClientInfoException failed-properties cause))
  ([^java.util.Map failed-properties]
    (new SQLClientInfoException failed-properties))
  ([]
    (new SQLClientInfoException )))

(defn get-failed-properties
  "Returns the list of client info properties that could not be set.  The
   keys in the Map  contain the names of the client info
   properties that could not be set and the values contain one of the
   reason codes defined in ClientInfoStatus

  returns: Map list containing the client info properties that could
   not be set - `java.util.Map<java.lang.String,java.sql.ClientInfoStatus>`"
  (^java.util.Map [^java.sql.SQLClientInfoException this]
    (-> this (.getFailedProperties))))

