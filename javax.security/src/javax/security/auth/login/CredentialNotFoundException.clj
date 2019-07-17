(ns javax.security.auth.login.CredentialNotFoundException
  "Signals that a credential was not found.

   This exception may be thrown by a LoginModule if it is unable
  to locate a credential necessary to perform authentication."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.login CredentialNotFoundException]))

(defn ->credential-not-found-exception
  "Constructor.

  Constructs a CredentialNotFoundException with the specified
   detail message. A detail message is a String that describes
   this particular exception.

  msg - the detail message. - `java.lang.String`"
  ([^java.lang.String msg]
    (new CredentialNotFoundException msg))
  ([]
    (new CredentialNotFoundException )))

