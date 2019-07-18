(ns javax.xml.parsers.ParserConfigurationException
  "Indicates a serious configuration error."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.parsers ParserConfigurationException]))

(defn ->parser-configuration-exception
  "Constructor.

  Create a new ParserConfigurationException with
   the String specified as an error message.

  msg - The error message for the exception. - `java.lang.String`"
  (^ParserConfigurationException [^java.lang.String msg]
    (new ParserConfigurationException msg))
  (^ParserConfigurationException []
    (new ParserConfigurationException )))

