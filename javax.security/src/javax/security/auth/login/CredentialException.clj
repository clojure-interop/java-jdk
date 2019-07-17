(ns javax.security.auth.login.CredentialException
  "A generic credential exception."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.login CredentialException]))

(defn ->credential-exception
  "Constructor.

  Constructs a CredentialException with the specified detail message.
   A detail message is a String that describes this particular
   exception.

  msg - the detail message. - `java.lang.String`"
  ([^java.lang.String msg]
    (new CredentialException msg))
  ([]
    (new CredentialException )))

