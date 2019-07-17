(ns javax.xml.bind.annotation.adapters.CollapsedStringAdapter
  "Built-in XmlAdapter to handle xs:token and its derived types.


  This adapter removes leading and trailing whitespaces, then truncate any
  sequnce of tab, CR, LF, and SP by a single whitespace character ' '."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind.annotation.adapters CollapsedStringAdapter]))

(defn ->collapsed-string-adapter
  "Constructor."
  ([]
    (new CollapsedStringAdapter )))

(defn unmarshal
  "Removes leading and trailing whitespaces of the string
   given as the parameter, then truncate any
   sequnce of tab, CR, LF, and SP by a single whitespace character ' '.

  text - The value to be converted. Can be null. - `java.lang.String`

  returns: `java.lang.String`"
  ([^javax.xml.bind.annotation.adapters.CollapsedStringAdapter this ^java.lang.String text]
    (-> this (.unmarshal text))))

(defn marshal
  "No-op.

   Just return the same string given as the parameter.

  s - The value to be convereted. Can be null. - `java.lang.String`

  returns: `java.lang.String`"
  ([^javax.xml.bind.annotation.adapters.CollapsedStringAdapter this ^java.lang.String s]
    (-> this (.marshal s))))

