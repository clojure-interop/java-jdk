(ns javax.sql.rowset.spi.SyncFactoryException
  "Indicates an error with SyncFactory mechanism. A disconnected
  RowSet implementation cannot be used  without a SyncProvider
  being successfully instantiated"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset.spi SyncFactoryException]))

(defn ->sync-factory-exception
  "Constructor.

  Constructs an SyncFactoryException with the specified
   detail message.

  msg - the detail message. - `java.lang.String`"
  (^SyncFactoryException [^java.lang.String msg]
    (new SyncFactoryException msg))
  (^SyncFactoryException []
    (new SyncFactoryException )))

