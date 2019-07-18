(ns javax.naming.AuthenticationNotSupportedException
  "This exception is thrown when
  the particular flavor of authentication requested is not supported.
  For example, if the program
  is attempting to use strong authentication but the directory/naming
  supports only simple authentication, this exception would be thrown.
  Identification of a particular flavor of authentication is
  provider- and server-specific. It may be specified using
  specific authentication schemes such
  those identified using SASL, or a generic authentication specifier
  (such as `simple` and `strong`).

  If the program wants to handle this exception in particular, it
  should catch AuthenticationNotSupportedException explicitly before
  attempting to catch NamingException. After catching
  AuthenticationNotSupportedException, the program could
  reattempt the authentication using a different authentication flavor
  by updating the resolved context's environment properties accordingly.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming AuthenticationNotSupportedException]))

(defn ->authentication-not-supported-exception
  "Constructor.

  Constructs a new instance of AuthenticationNotSupportedException using
   an explanation. All other fields default to null.

  explanation - A possibly null string containing additional detail about this exception. - `java.lang.String`"
  (^AuthenticationNotSupportedException [^java.lang.String explanation]
    (new AuthenticationNotSupportedException explanation))
  (^AuthenticationNotSupportedException []
    (new AuthenticationNotSupportedException )))

