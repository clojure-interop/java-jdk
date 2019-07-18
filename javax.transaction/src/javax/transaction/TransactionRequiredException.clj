(ns javax.transaction.TransactionRequiredException
  "This exception indicates that a request carried a null transaction context,
  but the target object requires an activate transaction."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.transaction TransactionRequiredException]))

(defn ->transaction-required-exception
  "Constructor.

  msg - `java.lang.String`"
  (^TransactionRequiredException [^java.lang.String msg]
    (new TransactionRequiredException msg))
  (^TransactionRequiredException []
    (new TransactionRequiredException )))

