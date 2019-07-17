(ns javax.xml.bind.DataBindingException
  "Exception that represents a failure in a JAXB operation.


  This exception differs from JAXBException in that
  this is an unchecked exception, while JAXBException
  is a checked exception."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind DataBindingException]))

(defn ->data-binding-exception
  "Constructor.

  message - `java.lang.String`
  cause - `java.lang.Throwable`"
  ([message cause]
    (new DataBindingException message cause))
  ([cause]
    (new DataBindingException cause)))

