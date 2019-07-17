(ns javax.xml.bind.Marshaller$Listener
  " Register an instance of an implementation of this class with a Marshaller to externally listen
  for marshal events.


  This class enables pre and post processing of each marshalled object.
  The event callbacks are called when marshalling from an instance that maps to an xml element or
  complex type definition. The event callbacks are not called when marshalling from an instance of a
  Java datatype that represents a simple type definition.


  External listener is one of two different mechanisms for defining marshal event callbacks.
  See Marshal Event Callbacks for an overview."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind Marshaller$Listener]))

(defn ->listener
  "Constructor."
  ([]
    (new Marshaller$Listener )))

(defn before-marshal
  "Callback method invoked before marshalling from source to XML.


   This method is invoked just before marshalling process starts to marshal source.
   Note that if the class of source defines its own beforeMarshal method,
   the class specific callback method is invoked just before this method is invoked.

  source - instance of JAXB mapped class prior to marshalling from it. - `java.lang.Object`"
  ([^javax.xml.bind.Marshaller$Listener this ^java.lang.Object source]
    (-> this (.beforeMarshal source))))

(defn after-marshal
  "Callback method invoked after marshalling source to XML.


   This method is invoked after source and all its descendants have been marshalled.
   Note that if the class of source defines its own afterMarshal method,
   the class specific callback method is invoked just before this method is invoked.

  source - instance of JAXB mapped class after marshalling it. - `java.lang.Object`"
  ([^javax.xml.bind.Marshaller$Listener this ^java.lang.Object source]
    (-> this (.afterMarshal source))))

