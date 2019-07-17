(ns javax.xml.soap.SOAPConnectionFactory
  "A factory for creating SOAPConnection objects. Implementation of this class
  is optional. If SOAPConnectionFactory.newInstance() throws an
  UnsupportedOperationException then the implementation does not support the
  SAAJ communication infrastructure. Otherwise SOAPConnection objects
  can be created by calling createConnection() on the newly
  created SOAPConnectionFactory object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap SOAPConnectionFactory]))

(defn ->soap-connection-factory
  "Constructor."
  ([]
    (new SOAPConnectionFactory )))

(defn *new-instance
  "Creates an instance of the default
   SOAPConnectionFactory object.

  returns: a new instance of a default
           SOAPConnectionFactory object - `javax.xml.soap.SOAPConnectionFactory`

  throws: javax.xml.soap.SOAPException - if there was an error creating the SOAPConnectionFactory"
  (^javax.xml.soap.SOAPConnectionFactory []
    (SOAPConnectionFactory/newInstance )))

(defn create-connection
  "Create a new SOAPConnection.

  returns: the new SOAPConnection object. - `javax.xml.soap.SOAPConnection`

  throws: javax.xml.soap.SOAPException - if there was an exception creating the SOAPConnection object."
  (^javax.xml.soap.SOAPConnection [^javax.xml.soap.SOAPConnectionFactory this]
    (-> this (.createConnection))))

