(ns javax.security.auth.login.AccountLockedException
  "Signals that an account was locked.

   This exception may be thrown by a LoginModule if it
  determines that authentication is being attempted on a
  locked account."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.login AccountLockedException]))

(defn ->account-locked-exception
  "Constructor.

  Constructs a AccountLockedException with the specified
   detail message. A detail message is a String that describes
   this particular exception.

  msg - the detail message. - `java.lang.String`"
  (^AccountLockedException [^java.lang.String msg]
    (new AccountLockedException msg))
  (^AccountLockedException []
    (new AccountLockedException )))

