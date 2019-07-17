(ns javax.security.auth.login.CredentialExpiredException
  "Signals that a Credential has expired.

   This exception is thrown by LoginModules when they determine
  that a Credential has expired.
  For example, a LoginModule authenticating a user
  in its login method may determine that the user's
  password, although entered correctly, has expired.  In this case
  the LoginModule throws this exception to notify
  the application.  The application can then take the appropriate
  steps to assist the user in updating the password."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.login CredentialExpiredException]))

(defn ->credential-expired-exception
  "Constructor.

  Constructs a CredentialExpiredException with the specified detail
   message.  A detail message is a String that describes this particular
   exception.

  msg - the detail message. - `java.lang.String`"
  ([^java.lang.String msg]
    (new CredentialExpiredException msg))
  ([]
    (new CredentialExpiredException )))

