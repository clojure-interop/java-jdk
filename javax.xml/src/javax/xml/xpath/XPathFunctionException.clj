(ns javax.xml.xpath.XPathFunctionException
  "XPathFunctionException represents an error with an XPath function."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.xpath XPathFunctionException]))

(defn ->x-path-function-exception
  "Constructor.

  Constructs a new XPathFunctionException with the specified detail message.

   The cause is not initialized.

   If message is null,
   then a NullPointerException is thrown.

  message - The detail message. - `java.lang.String`

  throws: java.lang.NullPointerException - When message is null."
  (^XPathFunctionException [^java.lang.String message]
    (new XPathFunctionException message)))

