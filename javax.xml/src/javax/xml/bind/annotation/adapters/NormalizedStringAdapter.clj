(ns javax.xml.bind.annotation.adapters.NormalizedStringAdapter
  "XmlAdapter to handle xs:normalizedString.


  Replaces any tab, CR, and LF by a whitespace character ' ',
  as specified in the whitespace facet 'replace'"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind.annotation.adapters NormalizedStringAdapter]))

(defn ->normalized-string-adapter
  "Constructor."
  ([]
    (new NormalizedStringAdapter )))

(defn unmarshal
  "Replace any tab, CR, and LF by a whitespace character ' ',
   as specified in the whitespace facet 'replace'

  text - The value to be converted. Can be null. - `java.lang.String`

  returns: `java.lang.String`"
  (^java.lang.String [^javax.xml.bind.annotation.adapters.NormalizedStringAdapter this ^java.lang.String text]
    (-> this (.unmarshal text))))

(defn marshal
  "No-op.

   Just return the same string given as the parameter.

  s - The value to be convereted. Can be null. - `java.lang.String`

  returns: `java.lang.String`"
  (^java.lang.String [^javax.xml.bind.annotation.adapters.NormalizedStringAdapter this ^java.lang.String s]
    (-> this (.marshal s))))

