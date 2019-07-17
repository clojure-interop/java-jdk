(ns javax.xml.soap.SAAJMetaFactory
  "The access point for the implementation classes of the factories defined in the
  SAAJ API. All of the newInstance methods defined on factories in
  SAAJ 1.3 defer to instances of this class to do the actual object creation.
  The implementations of newInstance() methods (in SOAPFactory and MessageFactory)
  that existed in SAAJ 1.2 have been updated to also delegate to the SAAJMetaFactory when the SAAJ 1.2
  defined lookup fails to locate the Factory implementation class name.


  SAAJMetaFactory is a service provider interface. There are no public methods on this
  class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap SAAJMetaFactory]))

