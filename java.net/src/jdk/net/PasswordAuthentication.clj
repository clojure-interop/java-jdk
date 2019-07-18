(ns jdk.net.PasswordAuthentication
  "The class PasswordAuthentication is a data holder that is used by
  Authenticator.  It is simply a repository for a user name and a password."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net PasswordAuthentication]))

(defn ->password-authentication
  "Constructor.

  Creates a new PasswordAuthentication object from the given
   user name and password.

    Note that the given user password is cloned before it is stored in
   the new PasswordAuthentication object.

  user-name - the user name - `java.lang.String`
  password - the user's password - `char[]`"
  (^PasswordAuthentication [^java.lang.String user-name password]
    (new PasswordAuthentication user-name password)))

(defn get-user-name
  "Returns the user name.

  returns: the user name - `java.lang.String`"
  (^java.lang.String [^PasswordAuthentication this]
    (-> this (.getUserName))))

(defn get-password
  "Returns the user password.

    Note that this method returns a reference to the password. It is
   the caller's responsibility to zero out the password information after
   it is no longer needed.

  returns: the password - `char[]`"
  ([^PasswordAuthentication this]
    (-> this (.getPassword))))

