(ns javax.sql.rowset.spi.TransactionalWriter
  "A specialized interface that facilitates an extension of the standard
  SyncProvider abstract class so that it has finer grained
  transaction control.

  If one or more disconnected RowSet objects are participating
  in a global transaction, they may wish to coordinate their synchronization
  commits to preserve data integrity and reduce the number of
  synchronization exceptions. If this is the case, an application should set
  the CachedRowSet constant COMMIT_ON_ACCEPT_CHANGES
  to false and use the commit and rollback
  methods defined in this interface to manage transaction boundaries."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset.spi TransactionalWriter]))

(defn commit
  "Makes permanent all changes that have been performed by the
   acceptChanges method since the last call to either the
   commit or rollback methods.
   This method should be used only when auto-commit mode has been disabled.

  throws: java.sql.SQLException - if a database access error occurs or the Connection object within this CachedRowSet object is in auto-commit mode"
  ([^javax.sql.rowset.spi.TransactionalWriter this]
    (-> this (.commit))))

(defn rollback
  "Undoes all changes made in the current transaction made prior to the given
   Savepoint object.  This method should be used only when auto-commit
   mode has been disabled.

  s - a Savepoint object marking a savepoint in the current transaction. All changes made before s was set will be undone. All changes made after s was set will be made permanent. - `java.sql.Savepoint`

  throws: java.sql.SQLException - if a database access error occurs or the Connection object within this CachedRowSet object is in auto-commit mode"
  ([^javax.sql.rowset.spi.TransactionalWriter this ^java.sql.Savepoint s]
    (-> this (.rollback s)))
  ([^javax.sql.rowset.spi.TransactionalWriter this]
    (-> this (.rollback))))

