(ns jdk.text.spi.CollatorProvider
  "An abstract class for service providers that
  provide concrete implementations of the
  Collator class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text.spi CollatorProvider]))

(defn get-instance
  "Returns a new Collator instance for the specified locale.

  locale - the desired locale. - `java.util.Locale`

  returns: the Collator for the desired locale. - `java.text.Collator`

  throws: java.lang.NullPointerException - if locale is null"
  (^java.text.Collator [^CollatorProvider this ^java.util.Locale locale]
    (-> this (.getInstance locale))))

