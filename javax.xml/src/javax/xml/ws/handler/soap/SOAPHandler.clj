(ns javax.xml.ws.handler.soap.SOAPHandler
  "The SOAPHandler class extends Handler
   to provide typesafety for the message context parameter and add a method
   to obtain access to the headers that may be processed by the handler."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.handler.soap SOAPHandler]))

(defn get-headers
  "Gets the header blocks that can be processed by this Handler
    instance.

  returns: Set of QNames of header blocks processed by this
             handler instance. QName is the qualified
             name of the outermost element of the Header block. - `java.util.Set<javax.xml.namespace.QName>`"
  (^java.util.Set [^javax.xml.ws.handler.soap.SOAPHandler this]
    (-> this (.getHeaders))))

