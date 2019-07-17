(ns javax.xml.transform.TransformerConfigurationException
  "Indicates a serious configuration error."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform TransformerConfigurationException]))

(defn ->transformer-configuration-exception
  "Constructor.

  Wrap an existing exception in a TransformerConfigurationException.

  message - The error or warning message, or null to use the message from the embedded exception. - `java.lang.String`
  locator - The locator object for the error or warning. - `javax.xml.transform.SourceLocator`
  e - Any exception. - `java.lang.Throwable`"
  ([message locator e]
    (new TransformerConfigurationException message locator e))
  ([msg e]
    (new TransformerConfigurationException msg e))
  ([msg]
    (new TransformerConfigurationException msg))
  ([]
    (new TransformerConfigurationException )))

