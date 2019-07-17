(ns jdk.sql.BatchUpdateException
  "The subclass of SQLException thrown when an error
  occurs during a batch update operation.  In addition to the
  information provided by SQLException, a
  BatchUpdateException provides the update
  counts for all commands that were executed successfully during the
  batch update, that is, all commands that were executed before the error
  occurred.  The order of elements in an array of update counts
  corresponds to the order in which commands were added to the batch.

  After a command in a batch update fails to execute properly
  and a BatchUpdateException is thrown, the driver
  may or may not continue to process the remaining commands in
  the batch.  If the driver continues processing after a failure,
  the array returned by the method
  BatchUpdateException.getUpdateCounts will have
  an element for every command in the batch rather than only
  elements for the commands that executed successfully before
  the error.  In the case where the driver continues processing
  commands, the array element for any command
  that failed is Statement.EXECUTE_FAILED.

  A JDBC driver implementation should use
  the constructor BatchUpdateException(String reason, String SQLState,
  int vendorCode, long []updateCounts,Throwable cause)  instead of
  constructors that take int[] for the update counts to avoid the
  possibility of overflow.

  If Statement.executeLargeBatch method is invoked it is recommended that
  getLargeUpdateCounts be called instead of getUpdateCounts
  in order to avoid a possible overflow of the integer update count."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql BatchUpdateException]))

(defn ->batch-update-exception
  "Constructor.

  Constructs a BatchUpdateException object initialized with
   a given reason, SQLState, vendorCode
   cause and updateCounts.

  reason - a description of the error - `java.lang.String`
  sql-state - an XOPEN or SQL:2003 code identifying the exception - `java.lang.String`
  vendor-code - an exception code used by a particular database vendor - `int`
  update-counts - an array of int, with each elementindicating the update count, Statement.SUCCESS_NO_INFO or Statement.EXECUTE_FAILED for each SQL command in the batch for JDBC drivers that continue processing after a command failure; an update count or Statement.SUCCESS_NO_INFO for each SQL command in the batch prior to the failure for JDBC drivers that stop processing after a command failure Note: There is no validation of updateCounts for overflow and because of this it is recommended that you use the constructor BatchUpdateException(String reason, String SQLState, int vendorCode, long []updateCounts,Throwable cause) . - `int[]`
  cause - the underlying reason for this SQLException (which is saved for later retrieval by the getCause() method); may be null indicating the cause is non-existent or unknown. - `java.lang.Throwable`"
  ([reason sql-state vendor-code update-counts cause]
    (new BatchUpdateException reason sql-state vendor-code update-counts cause))
  ([reason sql-state vendor-code update-counts]
    (new BatchUpdateException reason sql-state vendor-code update-counts))
  ([reason sql-state update-counts]
    (new BatchUpdateException reason sql-state update-counts))
  ([reason update-counts]
    (new BatchUpdateException reason update-counts))
  ([update-counts]
    (new BatchUpdateException update-counts))
  ([]
    (new BatchUpdateException )))

(defn get-update-counts
  "Retrieves the update count for each update statement in the batch
   update that executed successfully before this exception occurred.
   A driver that implements batch updates may or may not continue to
   process the remaining commands in a batch when one of the commands
   fails to execute properly. If the driver continues processing commands,
   the array returned by this method will have as many elements as
   there are commands in the batch; otherwise, it will contain an
   update count for each command that executed successfully before
   the BatchUpdateException was thrown.

   The possible return values for this method were modified for
   the Java 2 SDK, Standard Edition, version 1.3.  This was done to
   accommodate the new option of continuing to process commands
   in a batch update after a BatchUpdateException object
   has been thrown.

  returns: an array of int containing the update counts
   for the updates that were executed successfully before this error
   occurred.  Or, if the driver continues to process commands after an
   error, one of the following for every command in the batch:

   an update count
    Statement.SUCCESS_NO_INFO to indicate that the command
       executed successfully but the number of rows affected is unknown
    Statement.EXECUTE_FAILED to indicate that the command
       failed to execute successfully - `int[]`"
  ([this]
    (-> this (.getUpdateCounts))))

(defn get-large-update-counts
  "Retrieves the update count for each update statement in the batch
   update that executed successfully before this exception occurred.
   A driver that implements batch updates may or may not continue to
   process the remaining commands in a batch when one of the commands
   fails to execute properly. If the driver continues processing commands,
   the array returned by this method will have as many elements as
   there are commands in the batch; otherwise, it will contain an
   update count for each command that executed successfully before
   the BatchUpdateException was thrown.

   This method should be used when Statement.executeLargeBatch is
   invoked and the returned update count may exceed Integer.MAX_VALUE.

  returns: an array of long containing the update counts
   for the updates that were executed successfully before this error
   occurred.  Or, if the driver continues to process commands after an
   error, one of the following for every command in the batch:

   an update count
    Statement.SUCCESS_NO_INFO to indicate that the command
       executed successfully but the number of rows affected is unknown
    Statement.EXECUTE_FAILED to indicate that the command
       failed to execute successfully - `long[]`"
  ([this]
    (-> this (.getLargeUpdateCounts))))

