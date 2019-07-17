(ns javax.sql.XAConnection
  "An object that provides support for distributed
  transactions.  An XAConnection object  may be enlisted
  in a distributed transaction by means of an XAResource object.
  A transaction manager, usually part of a middle tier server, manages an
  XAConnection object through the XAResource object.

  An application programmer does not use this interface directly; rather,
  it is used by a transaction manager working in the middle tier server."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql XAConnection]))

(defn get-xa-resource
  "Retrieves an XAResource object that
   the transaction manager will use
   to manage this XAConnection object's participation in a
   distributed transaction.

  returns: the XAResource object - `javax.transaction.xa.XAResource`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^javax.sql.XAConnection this]
    (-> this (.getXAResource))))

