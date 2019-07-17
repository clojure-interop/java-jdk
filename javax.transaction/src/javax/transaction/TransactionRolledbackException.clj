(ns javax.transaction.TransactionRolledbackException
  "This exception indicates that the transaction associated with processing
  of the request has been rolled back, or marked to roll back. Thus the
  requested operation either could not be performed or was not performed
  because further computation on behalf of the transaction would be
  fruitless"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.transaction TransactionRolledbackException]))

(defn ->transaction-rolledback-exception
  "Constructor.

  msg - `java.lang.String`"
  ([^java.lang.String msg]
    (new TransactionRolledbackException msg))
  ([]
    (new TransactionRolledbackException )))

