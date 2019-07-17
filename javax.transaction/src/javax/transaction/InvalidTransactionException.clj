(ns javax.transaction.InvalidTransactionException
  "This exception indicates that the request carried an invalid transaction
  context. For example, this exception could be raised if an error
  occured when trying to register a resource."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.transaction InvalidTransactionException]))

(defn ->invalid-transaction-exception
  "Constructor.

  msg - `java.lang.String`"
  ([msg]
    (new InvalidTransactionException msg))
  ([]
    (new InvalidTransactionException )))

