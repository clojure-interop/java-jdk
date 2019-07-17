(ns javax.xml.bind.JAXBIntrospector
  "Provide access to JAXB xml binding data for a JAXB object.


  Intially, the intent of this class is to just conceptualize how
  a JAXB application developer can access xml binding information,
  independent if binding model is java to schema or schema to java.
  Since accessing the XML element name related to a JAXB element is
  a highly requested feature, demonstrate access to this
  binding information.

  The factory method to get a JAXBIntrospector instance is
  JAXBContext.createJAXBIntrospector()."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind JAXBIntrospector]))

(defn ->jaxb-introspector
  "Constructor."
  ([]
    (new JAXBIntrospector )))

(defn *get-value
  "Get the element value of a JAXB element.

   Convenience method to abstract whether working with either
      a javax.xml.bind.JAXBElement instance or an instance of
      @XmlRootElement annotated Java class.

  jaxb-element - object that #isElement(Object) returns true. - `java.lang.Object`

  returns: The element value of the jaxbElement. - `java.lang.Object`"
  ([jaxb-element]
    (JAXBIntrospector/getValue jaxb-element)))

(defn element?
  "Return true if object represents a JAXB element.
   Parameter object is a JAXB element for following cases:

     It is an instance of javax.xml.bind.JAXBElement.
     The class of object is annotated with
         @XmlRootElement.

  object - `java.lang.Object`

  returns: `boolean`"
  ([this object]
    (-> this (.isElement object))))

(defn get-element-name
  "Get xml element qname for jaxbElement.

  jaxb-element - is an object that isElement(Object) returned true. - `java.lang.Object`

  returns: xml element qname associated with jaxbElement;
           null if jaxbElement is not a JAXB Element. - `javax.xml.namespace.QName`"
  ([this jaxb-element]
    (-> this (.getElementName jaxb-element))))

