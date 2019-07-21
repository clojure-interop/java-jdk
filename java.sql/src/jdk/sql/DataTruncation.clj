(ns jdk.sql.DataTruncation
  "An exception  thrown as a DataTruncation exception
  (on writes) or reported as a
  DataTruncation warning (on reads)
   when a data values is unexpectedly truncated for reasons other than its having
   exceeded MaxFieldSize.

  The SQLstate for a DataTruncation during read is 01004.
  The SQLstate for a DataTruncation during write is 22001."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql DataTruncation]))

(defn ->data-truncation
  "Constructor.

  Creates a DataTruncation object
   with the SQLState initialized
   to 01004 when read is set to true and 22001
   when read is set to false,
   the reason set to \"Data truncation\", the
   vendor code set to 0, and
   the other fields set to the given values.

  index - The index of the parameter or column value - `int`
  parameter - true if a parameter value was truncated - `boolean`
  read - true if a read was truncated - `boolean`
  data-size - the original size of the data - `int`
  transfer-size - the size after truncation - `int`
  cause - the underlying reason for this DataTruncation (which is saved for later retrieval by the getCause() method); may be null indicating the cause is non-existent or unknown. - `java.lang.Throwable`"
  (^DataTruncation [^Integer index ^Boolean parameter ^Boolean read ^Integer data-size ^Integer transfer-size ^java.lang.Throwable cause]
    (new DataTruncation index parameter read data-size transfer-size cause))
  (^DataTruncation [^Integer index ^Boolean parameter ^Boolean read ^Integer data-size ^Integer transfer-size]
    (new DataTruncation index parameter read data-size transfer-size)))

(defn get-index
  "Retrieves the index of the column or parameter that was truncated.

   This may be -1 if the column or parameter index is unknown, in
   which case the parameter and read fields should be ignored.

  returns: the index of the truncated parameter or column value - `int`"
  (^Integer [^DataTruncation this]
    (-> this (.getIndex))))

(defn get-parameter?
  "Indicates whether the value truncated was a parameter value or
   a column value.

  returns: true if the value truncated was a parameter;
           false if it was a column value - `boolean`"
  (^Boolean [^DataTruncation this]
    (-> this (.getParameter))))

(defn get-read?
  "Indicates whether or not the value was truncated on a read.

  returns: true if the value was truncated when read from
           the database; false if the data was truncated on a write - `boolean`"
  (^Boolean [^DataTruncation this]
    (-> this (.getRead))))

(defn get-data-size
  "Gets the number of bytes of data that should have been transferred.
   This number may be approximate if data conversions were being
   performed.  The value may be -1 if the size is unknown.

  returns: the number of bytes of data that should have been transferred - `int`"
  (^Integer [^DataTruncation this]
    (-> this (.getDataSize))))

(defn get-transfer-size
  "Gets the number of bytes of data actually transferred.
   The value may be -1 if the size is unknown.

  returns: the number of bytes of data actually transferred - `int`"
  (^Integer [^DataTruncation this]
    (-> this (.getTransferSize))))

