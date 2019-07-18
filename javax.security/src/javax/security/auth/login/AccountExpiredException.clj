(ns javax.security.auth.login.AccountExpiredException
  "Signals that a user account has expired.

   This exception is thrown by LoginModules when they determine
  that an account has expired.  For example, a LoginModule,
  after successfully authenticating a user, may determine that the
  user's account has expired.  In this case the LoginModule
  throws this exception to notify the application.  The application can
  then take the appropriate steps to notify the user."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.login AccountExpiredException]))

(defn ->account-expired-exception
  "Constructor.

  Constructs a AccountExpiredException with the specified detail
   message.  A detail message is a String that describes this particular
   exception.

  msg - the detail message. - `java.lang.String`"
  (^AccountExpiredException [^java.lang.String msg]
    (new AccountExpiredException msg))
  (^AccountExpiredException []
    (new AccountExpiredException )))

