(ns javax.security.auth.login.AccountException
  "A generic account exception."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.login AccountException]))

(defn ->account-exception
  "Constructor.

  Constructs a AccountException with the specified detail message.
   A detail message is a String that describes this particular
   exception.

  msg - the detail message. - `java.lang.String`"
  ([msg]
    (new AccountException msg))
  ([]
    (new AccountException )))

