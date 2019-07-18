(ns javax.xml.bind.JAXB
  "Class that defines convenience methods for common, simple use of JAXB.


  Methods defined in this class are convenience methods that combine several basic operations
  in the JAXBContext, Unmarshaller, and Marshaller.

  They are designed
  to be the prefered methods for developers new to JAXB. They have
  the following characterstics:


   Generally speaking, the performance is not necessarily optimal.
       It is expected that people who need to write performance
       critical code will use the rest of the JAXB API directly.
   Errors that happen during the processing is wrapped into
       DataBindingException (which will have JAXBException
       as its cause. It is expected that
       people who prefer the checked exception would use
       the rest of the JAXB API directly.



  In addition, the unmarshal methods have the following characteristic:


   Schema validation is not performed on the input XML.
       The processing will try to continue even if there
       are errors in the XML, as much as possible. Only as
       the last resort, this method fails with DataBindingException.



  Similarly, the marshal methods have the following characteristic:

   The processing will try to continue even if the Java object tree
       does not meet the validity requirement. Only as
       the last resort, this method fails with DataBindingException.




  All the methods on this class require non-null arguments to all parameters.
  The unmarshal methods either fail with an exception or return
  a non-null value."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind JAXB]))

(defn *unmarshal
  "Reads in a Java object tree from the given XML input.

  xml - Reads the entire file as XML. - `java.io.File`
  type - `java.lang.Class`

  returns: `<T> T`"
  ([^java.io.File xml ^java.lang.Class type]
    (JAXB/unmarshal xml type)))

(defn *marshal
  "Writes a Java object tree to XML and store it to the specified location.

  jaxb-object - The Java object to be marshalled into XML. If this object is a JAXBElement, it will provide the root tag name and the body. If this object has XmlRootElement on its class definition, that will be used as the root tag name and the given object will provide the body. Otherwise, the root tag name is infered from the short class name. This parameter must not be null. - `java.lang.Object`
  xml - XML will be written to this file. If it already exists, it will be overwritten. - `java.io.File`

  throws: javax.xml.bind.DataBindingException - If the operation fails, such as due to I/O error, unbindable classes."
  ([^java.lang.Object jaxb-object ^java.io.File xml]
    (JAXB/marshal jaxb-object xml)))

