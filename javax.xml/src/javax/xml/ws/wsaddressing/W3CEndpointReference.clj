(ns javax.xml.ws.wsaddressing.W3CEndpointReference
  "This class represents a W3C Addressing EndpointReferece which is
  a remote reference to a web service endpoint that supports the
  W3C WS-Addressing 1.0 - Core Recommendation.

  Developers should use this class in their SEIs if they want to
  pass/return endpoint references that represent the W3C WS-Addressing
  recommendation.

  JAXB will use the JAXB annotations and bind this class to XML infoset
  that is consistent with that defined by WS-Addressing.  See

  WS-Addressing
  for more information on WS-Addressing EndpointReferences."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.wsaddressing W3CEndpointReference]))

(defn ->w-3-c-endpoint-reference
  "Constructor.

  Creates an EPR from infoset representation

  source - A source object containing valid XmlInfoset instance consistent with the W3C WS-Addressing Core recommendation. - `javax.xml.transform.Source`

  throws: javax.xml.ws.WebServiceException - If the source does NOT contain a valid W3C WS-Addressing EndpointReference."
  ([source]
    (new W3CEndpointReference source)))

(defn write-to
  "write this EndpointReference to the specified infoset format

  result - for writing infoset - `javax.xml.transform.Result`"
  ([this result]
    (-> this (.writeTo result))))

