(ns javax.xml.soap.SAAJResult
  "Acts as a holder for the results of a JAXP transformation or a JAXB
  marshalling, in the form of a SAAJ tree. These results should be accessed
  by using the getResult() method. The DOMResult.getNode()
  method should be avoided in almost all cases."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap SAAJResult]))

(defn ->saaj-result
  "Constructor.

  Creates a SAAJResult that will present results in the form
   of a SAAJ tree that supports the specified protocol. The
   DYNAMIC_SOAP_PROTOCOL is ambiguous in this context and will
   cause this constructor to throw an UnsupportedOperationException.

   This kind of SAAJResult is meant for use in situations where the
   results will be used as a parameter to a method that takes a parameter
   whose type, such as SOAPElement, is drawn from the SAAJ
   API. When used in a transformation the results are populated into the
   SOAPPart of a SOAPMessage that is created
   internally. The SOAPPart returned by DOMResult.getNode()
   is not guaranteed to be well-formed.

  protocol - - the name of the SOAP protocol that the resulting SAAJ tree should support - `java.lang.String`

  throws: javax.xml.soap.SOAPException - if a SOAPMessage supporting the specified protocol cannot be created"
  (^SAAJResult [^java.lang.String protocol]
    (new SAAJResult protocol))
  (^SAAJResult []
    (new SAAJResult )))

(defn get-result
  "returns: the resulting Tree that was created under the specified root Node. - `javax.xml.soap.Node`"
  (^javax.xml.soap.Node [^SAAJResult this]
    (-> this (.getResult))))

