(ns javax.naming.AuthenticationException
  "This exception is thrown when an authentication error occurs while
  accessing the naming or directory service.
  An authentication error can happen, for example, when the credentials
  supplied by the user program is invalid or otherwise fails to
  authenticate the user to the naming/directory service.

  If the program wants to handle this exception in particular, it
  should catch AuthenticationException explicitly before attempting to
  catch NamingException. After catching AuthenticationException, the
  program could reattempt the authentication by updating
  the resolved context's environment properties with the appropriate
  appropriate credentials.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming AuthenticationException]))

(defn ->authentication-exception
  "Constructor.

  Constructs a new instance of AuthenticationException using the
   explanation supplied. All other fields default to null.

  explanation - A possibly null string containing additional detail about this exception. - `java.lang.String`"
  (^AuthenticationException [^java.lang.String explanation]
    (new AuthenticationException explanation))
  (^AuthenticationException []
    (new AuthenticationException )))

