(ns javax.xml.soap.SOAPElementFactory
  "Deprecated.
 - Use javax.xml.soap.SOAPFactory for creating SOAPElements."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap SOAPElementFactory]))

(defn *new-instance
  "Deprecated.

  returns: a new instance of a SOAPElementFactory - `javax.xml.soap.SOAPElementFactory`

  throws: javax.xml.soap.SOAPException - if there was an error creating the default SOAPElementFactory"
  (^javax.xml.soap.SOAPElementFactory []
    (SOAPElementFactory/newInstance )))

(defn create
  "Deprecated. Use
   javax.xml.soap.SOAPFactory.createElement(String localName,
                        String prefix,
                        String uri)
   instead

  local-name - a String giving the local name for the new element - `java.lang.String`
  prefix - the prefix for this SOAPElement - `java.lang.String`
  uri - a String giving the URI of the namespace to which the new element belongs - `java.lang.String`

  returns: `javax.xml.soap.SOAPElement`

  throws: javax.xml.soap.SOAPException - if there is an error in creating the SOAPElement object"
  (^javax.xml.soap.SOAPElement [^SOAPElementFactory this ^java.lang.String local-name ^java.lang.String prefix ^java.lang.String uri]
    (-> this (.create local-name prefix uri)))
  (^javax.xml.soap.SOAPElement [^SOAPElementFactory this ^javax.xml.soap.Name name]
    (-> this (.create name))))

