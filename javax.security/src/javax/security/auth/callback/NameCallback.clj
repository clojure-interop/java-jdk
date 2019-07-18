(ns javax.security.auth.callback.NameCallback
  " Underlying security services instantiate and pass a
  NameCallback to the handle
  method of a CallbackHandler to retrieve name information."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.callback NameCallback]))

(defn ->name-callback
  "Constructor.

  Construct a NameCallback with a prompt
   and default name.

  prompt - the prompt used to request the information. - `java.lang.String`
  default-name - the name to be used as the default name displayed with the prompt. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if prompt is null, if prompt has a length of 0, if defaultName is null, or if defaultName has a length of 0."
  (^NameCallback [^java.lang.String prompt ^java.lang.String default-name]
    (new NameCallback prompt default-name))
  (^NameCallback [^java.lang.String prompt]
    (new NameCallback prompt)))

(defn get-prompt
  "Get the prompt.

  returns: the prompt. - `java.lang.String`"
  (^java.lang.String [^NameCallback this]
    (-> this (.getPrompt))))

(defn get-default-name
  "Get the default name.

  returns: the default name, or null if this NameCallback
            was not instantiated with a defaultName. - `java.lang.String`"
  (^java.lang.String [^NameCallback this]
    (-> this (.getDefaultName))))

(defn set-name
  "Set the retrieved name.

  name - the retrieved name (which may be null). - `java.lang.String`"
  ([^NameCallback this ^java.lang.String name]
    (-> this (.setName name))))

(defn get-name
  "Get the retrieved name.

  returns: the retrieved name (which may be null) - `java.lang.String`"
  (^java.lang.String [^NameCallback this]
    (-> this (.getName))))

