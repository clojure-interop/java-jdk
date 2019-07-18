(ns javax.security.auth.login.LoginException
  "This is the basic login exception."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.login LoginException]))

(defn ->login-exception
  "Constructor.

  Constructs a LoginException with the specified detail message.
   A detail message is a String that describes this particular
   exception.

  msg - the detail message. - `java.lang.String`"
  (^LoginException [^java.lang.String msg]
    (new LoginException msg))
  (^LoginException []
    (new LoginException )))

