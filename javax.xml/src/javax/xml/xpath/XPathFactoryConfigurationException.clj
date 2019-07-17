(ns javax.xml.xpath.XPathFactoryConfigurationException
  "XPathFactoryConfigurationException represents a configuration error in a XPathFactory environment."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.xpath XPathFactoryConfigurationException]))

(defn ->x-path-factory-configuration-exception
  "Constructor.

  Constructs a new XPathFactoryConfigurationException with the specified detail message.

   The cause is not initialized.

   If message is null,
   then a NullPointerException is thrown.

  message - The detail message. - `java.lang.String`

  throws: java.lang.NullPointerException - When message is null."
  ([^java.lang.String message]
    (new XPathFactoryConfigurationException message)))

