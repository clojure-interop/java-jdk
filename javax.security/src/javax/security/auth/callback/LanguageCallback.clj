(ns javax.security.auth.callback.LanguageCallback
  " Underlying security services instantiate and pass a
  LanguageCallback to the handle
  method of a CallbackHandler to retrieve the Locale
  used for localizing text."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.callback LanguageCallback]))

(defn ->language-callback
  "Constructor.

  Construct a LanguageCallback."
  ([]
    (new LanguageCallback )))

(defn set-locale
  "Set the retrieved Locale.

  locale - the retrieved Locale. - `java.util.Locale`"
  ([^javax.security.auth.callback.LanguageCallback this ^java.util.Locale locale]
    (-> this (.setLocale locale))))

(defn get-locale
  "Get the retrieved Locale.

  returns: the retrieved Locale, or null
            if no Locale could be retrieved. - `java.util.Locale`"
  (^java.util.Locale [^javax.security.auth.callback.LanguageCallback this]
    (-> this (.getLocale))))

