(ns javax.security.auth.login.FailedLoginException
  "Signals that user authentication failed.

   This exception is thrown by LoginModules if authentication failed.
  For example, a LoginModule throws this exception if
  the user entered an incorrect password."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.login FailedLoginException]))

(defn ->failed-login-exception
  "Constructor.

  Constructs a FailedLoginException with the specified detail
   message.  A detail message is a String that describes this particular
   exception.

  msg - the detail message. - `java.lang.String`"
  ([^java.lang.String msg]
    (new FailedLoginException msg))
  ([]
    (new FailedLoginException )))

