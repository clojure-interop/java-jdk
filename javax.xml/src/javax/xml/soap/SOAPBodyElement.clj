(ns javax.xml.soap.SOAPBodyElement
  "A SOAPBodyElement object represents the contents in
  a SOAPBody object.  The SOAPFault interface
  is a SOAPBodyElement object that has been defined.

  A new SOAPBodyElement object can be created and added
  to a SOAPBody object with the SOAPBody
  method addBodyElement. In the following line of code,
  sb is a SOAPBody object, and
  myName is a Name object.


     SOAPBodyElement sbe = sb.addBodyElement(myName);"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap SOAPBodyElement]))

