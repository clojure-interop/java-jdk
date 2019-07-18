(ns javax.sql.rowset.spi.SyncProviderException
  "Indicates an error with the SyncProvider mechanism. This exception
  is created by a SyncProvider abstract class extension if it
  encounters violations in reading from or writing to the originating data source.

  If it is implemented to do so, the SyncProvider object may also create a
  SyncResolver object and either initialize the SyncProviderException
  object with it at construction time or set it with the SyncProvider object at
  a later time.

  The method acceptChanges will throw this exception after the writer
  has finished checking for conflicts and has found one or more conflicts. An
  application may catch a SyncProviderException object and call its
  getSyncResolver method to get its SyncResolver object.
  See the code fragment in the interface comment for
  SyncResolver for an example.
  This SyncResolver object will mirror the RowSet
  object that generated the exception, except that it will contain only the values
  from the data source that are in conflict.  All other values in the SyncResolver
  object will be null.

  The SyncResolver object may be used to examine and resolve
  each conflict in a row and then go to the next row with a conflict to
  repeat the procedure.

  A SyncProviderException object may or may not contain a description of the
  condition causing the exception.  The inherited method getMessage may be
  called to retrieve the description if there is one."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset.spi SyncProviderException]))

(defn ->sync-provider-exception
  "Constructor.

  Constructs a SyncProviderException object with the specified
   detail message.

  msg - the detail message - `java.lang.String`"
  (^SyncProviderException [^java.lang.String msg]
    (new SyncProviderException msg))
  (^SyncProviderException []
    (new SyncProviderException )))

(defn get-sync-resolver
  "Retrieves the SyncResolver object that has been set for
   this SyncProviderException object, or
   if none has been set, an instance of the default SyncResolver
   implementation included in the reference implementation.

   If a SyncProviderException object is thrown, an application
   may use this method to generate a SyncResolver object
   with which to resolve the conflict or conflicts that caused the
   exception to be thrown.

  returns: the SyncResolver object set for this
       SyncProviderException object or, if none has
       been set, an instance of the default SyncResolver
       implementation. In addition, the default SyncResolver
       implementation is also returned if the SyncResolver() or
       SyncResolver(String) constructors are used to instantiate
       the SyncResolver instance. - `javax.sql.rowset.spi.SyncResolver`"
  (^javax.sql.rowset.spi.SyncResolver [^SyncProviderException this]
    (-> this (.getSyncResolver))))

(defn set-sync-resolver
  "Sets the SyncResolver object for this
   SyncProviderException object to the one supplied.
   If the argument supplied is null, a call to the method
   getSyncResolver will return the default reference
   implementation of the SyncResolver interface.

  sync-resolver - the SyncResolver object to be set; cannot be null - `javax.sql.rowset.spi.SyncResolver`

  throws: java.lang.IllegalArgumentException - if the SyncResolver object is null."
  ([^SyncProviderException this ^javax.sql.rowset.spi.SyncResolver sync-resolver]
    (-> this (.setSyncResolver sync-resolver))))

