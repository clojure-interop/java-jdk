(ns javax.xml.xpath.XPathExpressionException
  "XPathExpressionException represents an error in an XPath expression."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.xpath XPathExpressionException]))

(defn ->x-path-expression-exception
  "Constructor.

  Constructs a new XPathExpressionException
   with the specified detail message.

   The cause is not initialized.

   If message is null,
   then a NullPointerException is thrown.

  message - The detail message. - `java.lang.String`

  throws: java.lang.NullPointerException - When message is null."
  ([message]
    (new XPathExpressionException message)))

