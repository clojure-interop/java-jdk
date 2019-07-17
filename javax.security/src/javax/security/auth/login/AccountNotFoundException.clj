(ns javax.security.auth.login.AccountNotFoundException
  "Signals that an account was not found.

   This exception may be thrown by a LoginModule if it is unable
  to locate an account necessary to perform authentication."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.login AccountNotFoundException]))

(defn ->account-not-found-exception
  "Constructor.

  Constructs a AccountNotFoundException with the specified
   detail message. A detail message is a String that describes
   this particular exception.

  msg - the detail message. - `java.lang.String`"
  ([^java.lang.String msg]
    (new AccountNotFoundException msg))
  ([]
    (new AccountNotFoundException )))

