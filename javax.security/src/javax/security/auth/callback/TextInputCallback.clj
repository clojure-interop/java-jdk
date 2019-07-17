(ns javax.security.auth.callback.TextInputCallback
  " Underlying security services instantiate and pass a
  TextInputCallback to the handle
  method of a CallbackHandler to retrieve generic text
  information."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.callback TextInputCallback]))

(defn ->text-input-callback
  "Constructor.

  Construct a TextInputCallback with a prompt
   and default input value.

  prompt - the prompt used to request the information. - `java.lang.String`
  default-text - the text to be used as the default text displayed with the prompt. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if prompt is null, if prompt has a length of 0, if defaultText is null or if defaultText has a length of 0."
  ([^java.lang.String prompt ^java.lang.String default-text]
    (new TextInputCallback prompt default-text))
  ([^java.lang.String prompt]
    (new TextInputCallback prompt)))

(defn get-prompt
  "Get the prompt.

  returns: the prompt. - `java.lang.String`"
  ([^javax.security.auth.callback.TextInputCallback this]
    (-> this (.getPrompt))))

(defn get-default-text
  "Get the default text.

  returns: the default text, or null if this TextInputCallback
            was not instantiated with defaultText. - `java.lang.String`"
  ([^javax.security.auth.callback.TextInputCallback this]
    (-> this (.getDefaultText))))

(defn set-text
  "Set the retrieved text.

  text - the retrieved text, which may be null. - `java.lang.String`"
  ([^javax.security.auth.callback.TextInputCallback this ^java.lang.String text]
    (-> this (.setText text))))

(defn get-text
  "Get the retrieved text.

  returns: the retrieved text, which may be null. - `java.lang.String`"
  ([^javax.security.auth.callback.TextInputCallback this]
    (-> this (.getText))))

