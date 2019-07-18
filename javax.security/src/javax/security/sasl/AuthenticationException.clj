(ns javax.security.sasl.AuthenticationException
  "This exception is thrown by a SASL mechanism implementation
  to indicate that the SASL
  exchange has failed due to reasons related to authentication, such as
  an invalid identity, passphrase, or key.

  Note that the lack of an AuthenticationException does not mean that
  the failure was not due to an authentication error.  A SASL mechanism
  implementation might throw the more general SaslException instead of
  AuthenticationException if it is unable to determine the nature
  of the failure, or if does not want to disclose the nature of
  the failure, for example, due to security reasons."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.sasl AuthenticationException]))

(defn ->authentication-exception
  "Constructor.

  Constructs a new instance of AuthenticationException with a detailed message
   and a root exception.

  detail - A possibly null string containing details of the exception. - `java.lang.String`
  ex - A possibly null root exception that caused this exception. - `java.lang.Throwable`"
  (^AuthenticationException [^java.lang.String detail ^java.lang.Throwable ex]
    (new AuthenticationException detail ex))
  (^AuthenticationException [^java.lang.String detail]
    (new AuthenticationException detail))
  (^AuthenticationException []
    (new AuthenticationException )))

