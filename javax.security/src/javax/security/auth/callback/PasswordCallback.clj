(ns javax.security.auth.callback.PasswordCallback
  " Underlying security services instantiate and pass a
  PasswordCallback to the handle
  method of a CallbackHandler to retrieve password information."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.callback PasswordCallback]))

(defn ->password-callback
  "Constructor.

  Construct a PasswordCallback with a prompt
   and a boolean specifying whether the password should be displayed
   as it is being typed.

  prompt - the prompt used to request the password. - `java.lang.String`
  echo-on - true if the password should be displayed as it is being typed. - `boolean`

  throws: java.lang.IllegalArgumentException - if prompt is null or if prompt has a length of 0."
  ([^java.lang.String prompt ^Boolean echo-on]
    (new PasswordCallback prompt echo-on)))

(defn get-prompt
  "Get the prompt.

  returns: the prompt. - `java.lang.String`"
  ([^javax.security.auth.callback.PasswordCallback this]
    (-> this (.getPrompt))))

(defn echo-on?
  "Return whether the password
   should be displayed as it is being typed.

  returns: the whether the password
            should be displayed as it is being typed. - `boolean`"
  ([^javax.security.auth.callback.PasswordCallback this]
    (-> this (.isEchoOn))))

(defn set-password
  "Set the retrieved password.

    This method makes a copy of the input password
   before storing it.

  password - the retrieved password, which may be null. - `char[]`"
  ([^javax.security.auth.callback.PasswordCallback this password]
    (-> this (.setPassword password))))

(defn get-password
  "Get the retrieved password.

    This method returns a copy of the retrieved password.

  returns: the retrieved password, which may be null. - `char[]`"
  ([^javax.security.auth.callback.PasswordCallback this]
    (-> this (.getPassword))))

(defn clear-password
  "Clear the retrieved password."
  ([^javax.security.auth.callback.PasswordCallback this]
    (-> this (.clearPassword))))

