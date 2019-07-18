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
  (^TransformerConfigurationException [^java.lang.String message ^javax.xml.transform.SourceLocator locator ^java.lang.Throwable e]
    (new TransformerConfigurationException message locator e))
  (^TransformerConfigurationException [^java.lang.String msg ^java.lang.Throwable e]
    (new TransformerConfigurationException msg e))
  (^TransformerConfigurationException [^java.lang.String msg]
    (new TransformerConfigurationException msg))
  (^TransformerConfigurationException []
    (new TransformerConfigurationException )))

