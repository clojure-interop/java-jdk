(ns javax.xml.bind.Unmarshaller$Listener
  " Register an instance of an implementation of this class with Unmarshaller to externally listen
  for unmarshal events.


  This class enables pre and post processing of an instance of a JAXB mapped class
  as XML data is unmarshalled into it. The event callbacks are called when unmarshalling
  XML content into a JAXBElement instance or a JAXB mapped class that represents a complex type definition.
  The event callbacks are not called when unmarshalling to an instance of a
  Java datatype that represents a simple type definition.


  External listener is one of two different mechanisms for defining unmarshal event callbacks.
  See Unmarshal Event Callbacks for an overview.

  (@link #setListener(Listener)}
  (@link #getListener()}"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind Unmarshaller$Listener]))

(defn ->listener
  "Constructor."
  ([]
    (new Unmarshaller$Listener )))

(defn before-unmarshal
  "Callback method invoked before unmarshalling into target.


   This method is invoked immediately after target was created and
   before the unmarshalling of this object begins. Note that
   if the class of target defines its own beforeUnmarshal method,
   the class specific callback method is invoked before this method is invoked.

  target - non-null instance of JAXB mapped class prior to unmarshalling into it. - `java.lang.Object`
  parent - instance of JAXB mapped class that will eventually reference target. null when target is root element. - `java.lang.Object`"
  ([^javax.xml.bind.Unmarshaller$Listener this ^java.lang.Object target ^java.lang.Object parent]
    (-> this (.beforeUnmarshal target parent))))

(defn after-unmarshal
  "Callback method invoked after unmarshalling XML data into target.


   This method is invoked after all the properties (except IDREF) are unmarshalled into target,
   but before target is set into its parent object.
   Note that if the class of target defines its own afterUnmarshal method,
   the class specific callback method is invoked before this method is invoked.

  target - non-null instance of JAXB mapped class prior to unmarshalling into it. - `java.lang.Object`
  parent - instance of JAXB mapped class that will reference target. null when target is root element. - `java.lang.Object`"
  ([^javax.xml.bind.Unmarshaller$Listener this ^java.lang.Object target ^java.lang.Object parent]
    (-> this (.afterUnmarshal target parent))))

