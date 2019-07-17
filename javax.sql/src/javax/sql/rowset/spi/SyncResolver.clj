(ns javax.sql.rowset.spi.SyncResolver
  "Defines a framework that allows applications to use a manual decision tree
  to decide what should be done when a synchronization conflict occurs.
  Although it is not mandatory for
  applications to resolve synchronization conflicts manually, this
  framework provides the means to delegate to the application when conflicts
  arise.

  Note that a conflict is a situation where the RowSet object's original
  values for a row do not match the values in the data source, which indicates that
  the data source row has been modified since the last synchronization. Note also that
  a RowSet object's original values are the values it had just prior to the
  the last synchronization, which are not necessarily its initial values.


  Description of a SyncResolver Object

  A SyncResolver object is a specialized RowSet object
  that implements the SyncResolver interface.
  It may operate as either a connected RowSet object (an
  implementation of the JdbcRowSet interface) or a connected
  RowSet object (an implementation of the
  CachedRowSet interface or one of its subinterfaces). For information
  on the subinterfaces, see the
  javax.sql.rowset package
  description. The reference implementation for SyncResolver implements
  the CachedRowSet interface, but other implementations
  may choose to implement the JdbcRowSet interface to satisfy
  particular needs.

  After an application has attempted to synchronize a RowSet object with
  the data source (by calling the CachedRowSet
  method acceptChanges), and one or more conflicts have been found,
  a rowset's SyncProvider object creates an instance of
  SyncResolver. This new SyncResolver object has
  the same number of rows and columns as the
  RowSet object that was attempting the synchronization. The
  SyncResolver object contains the values from the data source that caused
  the conflict(s) and null for all other values.
  In addition, it contains information about each conflict.


  Getting and Using a SyncResolver Object

  When the method acceptChanges encounters conflicts, the
  SyncProvider object creates a SyncProviderException
  object and sets it with the new SyncResolver object. The method
  acceptChanges will throw this exception, which
  the application can then catch and use to retrieve the
  SyncResolver object it contains. The following code snippet uses the
  SyncProviderException method getSyncResolver to get
  the SyncResolver object resolver.


       catch (SyncProviderException spe) {
          SyncResolver resolver = spe.getSyncResolver();
      ...
      }

  }

  With resolver in hand, an application can use it to get the information
  it contains about the conflict or conflicts.  A SyncResolver object
  such as resolver keeps
  track of the conflicts for each row in which there is a conflict.  It also places a
  lock on the table or tables affected by the rowset's command so that no more
  conflicts can occur while the current conflicts are being resolved.

  The following kinds of information can be obtained from a SyncResolver
  object:

     What operation was being attempted when a conflict occurred
  The SyncProvider interface defines four constants
  describing states that may occur. Three
  constants describe the type of operation (update, delete, or insert) that a
  RowSet object was attempting to perform when a conflict was discovered,
  and the fourth indicates that there is no conflict.
  These constants are the possible return values when a SyncResolver object
  calls the method getStatus.


       int operation = resolver.getStatus();

     The value in the data source that caused a conflict
  A conflict exists when a value that a RowSet object has changed
  and is attempting to write to the data source
  has also been changed in the data source since the last synchronization.  An
  application can call the SyncResolver method
  getConflictValue to retrieve the
  value in the data source that is the cause of the conflict because the values in a
  SyncResolver object are the conflict values from the data source.


      java.lang.Object conflictValue = resolver.getConflictValue(2);
  Note that the column in resolver can be designated by the column number,
  as is done in the preceding line of code, or by the column name.

  With the information retrieved from the methods getStatus and
  getConflictValue, the application may make a determination as to
  which value should be persisted in the data source. The application then calls the
  SyncResolver method setResolvedValue, which sets the value
  to be persisted in the RowSet object and also in the data source.


      resolver.setResolvedValue(`DEPT`, 8390426);
  In the preceding line of code,
  the column name designates the column in the RowSet object
  that is to be set with the given value. The column number can also be used to
  designate the column.

  An application calls the method setResolvedValue after it has
  resolved all of the conflicts in the current conflict row and repeats this process
  for each conflict row in the SyncResolver object.


  Navigating a SyncResolver Object

  Because a SyncResolver object is a RowSet object, an
  application can use all of the RowSet methods for moving the cursor
  to navigate a SyncResolver object. For example, an application can
  use the RowSet method next to get to each row and then
  call the SyncResolver method getStatus to see if the row
  contains a conflict.  In a row with one or more conflicts, the application can
  iterate through the columns to find any non-null values, which will be the values
  from the data source that are in conflict.

  To make it easier to navigate a SyncResolver object, especially when
  there are large numbers of rows with no conflicts, the SyncResolver
  interface defines the methods nextConflict and
  previousConflict, which move only to rows
  that contain at least one conflict value. Then an application can call the
  SyncResolver method getConflictValue, supplying it
  with the column number, to get the conflict value itself. The code fragment in the
  next section gives an example.

  Code Example

  The following code fragment demonstrates how a disconnected RowSet
  object crs might attempt to synchronize itself with the
  underlying data source and then resolve the conflicts. In the try
  block, crs calls the method acceptChanges, passing it the
  Connection object con.  If there are no conflicts, the
  changes in crs are simply written to the data source.  However, if there
  is a conflict, the method acceptChanges throws a
  SyncProviderException object, and the
  catch block takes effect.  In this example, which
  illustrates one of the many ways a SyncResolver object can be used,
  the SyncResolver method nextConflict is used in a
  while loop. The loop will end when nextConflict returns
  false, which will occur when there are no more conflict rows in the
  SyncResolver object resolver. In This particular code fragment,
  resolver looks for rows that have update conflicts (rows with the status
  SyncResolver.UPDATE_ROW_CONFLICT), and the rest of this code fragment
  executes only for rows where conflicts occurred because crs was attempting an
  update.

  After the cursor for resolver has moved to the next conflict row that
  has an update conflict, the method getRow indicates the number of the
  current row, and
  the cursor for the CachedRowSet object crs is moved to
  the comparable row in crs. By iterating
  through the columns of that row in both resolver and crs, the conflicting
  values can be retrieved and compared to decide which one should be persisted. In this
  code fragment, the value in crs is the one set as the resolved value, which means
  that it will be used to overwrite the conflict value in the data source.



      try {

          crs.acceptChanges(con);

      } catch (SyncProviderException spe) {

          SyncResolver resolver = spe.getSyncResolver();

          Object crsValue;  // value in the RowSet object
          Object resolverValue:  // value in the SyncResolver object
          Object resolvedValue:  // value to be persisted

          while(resolver.nextConflict())  {
              if(resolver.getStatus() == SyncResolver.UPDATE_ROW_CONFLICT)  {
                  int row = resolver.getRow();
                  crs.absolute(row);

                  int colCount = crs.getMetaData().getColumnCount();
                  for(int j = 1; j <= colCount; j++) {
                      if (resolver.getConflictValue(j) != null)  {
                          crsValue = crs.getObject(j);
                          resolverValue = resolver.getConflictValue(j);
                          . . .
                          // compare crsValue and resolverValue to determine
                          // which should be the resolved value (the value to persist)
                          resolvedValue = crsValue;

                          resolver.setResolvedValue(j, resolvedValue);
                       }
                   }
               }
           }
       }"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset.spi SyncResolver]))

(defn get-status
  "Retrieves the conflict status of the current row of this SyncResolver,
   which indicates the operation
   the RowSet object was attempting when the conflict occurred.

  returns: one of the following constants:
           SyncResolver.UPDATE_ROW_CONFLICT,
           SyncResolver.DELETE_ROW_CONFLICT,
           SyncResolver.INSERT_ROW_CONFLICT, or
           SyncResolver.NO_ROW_CONFLICT - `int`"
  (^Integer [^javax.sql.rowset.spi.SyncResolver this]
    (-> this (.getStatus))))

(defn get-conflict-value
  "Retrieves the value in the designated column in the current row of this
   SyncResolver object, which is the value in the data source
   that caused a conflict.

  index - an int designating the column in this row of this SyncResolver object from which to retrieve the value causing a conflict - `int`

  returns: the value of the designated column in the current row of this
           SyncResolver object - `java.lang.Object`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.lang.Object [^javax.sql.rowset.spi.SyncResolver this ^Integer index]
    (-> this (.getConflictValue index))))

(defn set-resolved-value
  "Sets obj as the value in column index in the current row of the
   RowSet object that is being synchronized. obj
   is set as the value in the data source internally.

  index - an int giving the number of the column into which to set the value to be persisted - `int`
  obj - an Object that is the value to be set in the RowSet object and persisted in the data source - `java.lang.Object`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^javax.sql.rowset.spi.SyncResolver this ^Integer index ^java.lang.Object obj]
    (-> this (.setResolvedValue index obj))))

(defn next-conflict
  "Moves the cursor down from its current position to the next row that contains
   a conflict value. A SyncResolver object's
   cursor is initially positioned before the first conflict row; the first call to the
   method nextConflict makes the first conflict row the current row;
   the second call makes the second conflict row the current row, and so on.

   A call to the method nextConflict will implicitly close
   an input stream if one is open and will clear the SyncResolver
   object's warning chain.

  returns: true if the new current row is valid; false
           if there are no more rows - `boolean`

  throws: java.sql.SQLException - if a database access error occurs or the result set type is TYPE_FORWARD_ONLY"
  (^Boolean [^javax.sql.rowset.spi.SyncResolver this]
    (-> this (.nextConflict))))

(defn previous-conflict
  "Moves the cursor up from its current position to the previous conflict
   row in this SyncResolver object.

   A call to the method previousConflict will implicitly close
   an input stream if one is open and will clear the SyncResolver
   object's warning chain.

  returns: true if the cursor is on a valid row; false
       if it is off the result set - `boolean`

  throws: java.sql.SQLException - if a database access error occurs or the result set type is TYPE_FORWARD_ONLY"
  (^Boolean [^javax.sql.rowset.spi.SyncResolver this]
    (-> this (.previousConflict))))

