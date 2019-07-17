(ns javax.accessibility.AccessibleBundle
  "Base class used to maintain a strongly typed enumeration.  This is
  the superclass of AccessibleState and AccessibleRole.
  The toDisplayString method allows you to obtain the localized string
  for a locale independent key from a predefined ResourceBundle for the
  keys defined in this class.  This localized string is intended to be
  readable by humans."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleBundle]))

(defn ->accessible-bundle
  "Constructor.

  Construct an AccessibleBundle."
  ([]
    (new AccessibleBundle )))

(defn to-display-string
  "Obtains the key as a localized string.
   If a localized string cannot be found for the key, the
   locale independent key stored in the role will be returned.

  locale - the locale for which to obtain a localized string - `java.util.Locale`

  returns: a localized String for the key. - `java.lang.String`"
  ([this locale]
    (-> this (.toDisplayString locale)))
  ([this]
    (-> this (.toDisplayString))))

(defn to-string
  "Gets localized string describing the key using the default locale.

  returns: a localized String describing the key using the default locale - `java.lang.String`"
  ([this]
    (-> this (.toString))))

