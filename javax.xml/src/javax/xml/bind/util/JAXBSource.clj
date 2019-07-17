(ns javax.xml.bind.util.JAXBSource
  "JAXP Source implementation
  that marshals a JAXB-generated object.


  This utility class is useful to combine JAXB with
  other Java/XML technologies.


  The following example shows how to use JAXB to marshal a document
  for transformation by XSLT.




        MyObject o = // get JAXB content tree

        // jaxbContext is a JAXBContext object from which 'o' is created.
        JAXBSource source = new JAXBSource( jaxbContext, o );

        // set up XSLT transformation
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer(new StreamSource(`test.xsl`));

        // run transformation
        t.transform(source,new StreamResult(System.out));



  The fact that JAXBSource derives from SAXSource is an implementation
  detail. Thus in general applications are strongly discouraged from
  accessing methods defined on SAXSource. In particular,
  the setXMLReader and setInputSource methods shall never be called.
  The XMLReader object obtained by the getXMLReader method shall
  be used only for parsing the InputSource object returned by
  the getInputSource method.


  Similarly the InputSource object obtained by the getInputSource
  method shall be used only for being parsed by the XMLReader object
  returned by the getXMLReader."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind.util JAXBSource]))

(defn ->jaxb-source
  "Constructor.

  Creates a new Source for the given content object.

  context - JAXBContext that was used to create contentObject. This context is used to create a new instance of marshaller and must not be null. - `javax.xml.bind.JAXBContext`
  content-object - An instance of a JAXB-generated class, which will be used as a Source (by marshalling it into XML). It must not be null. - `java.lang.Object`

  throws: javax.xml.bind.JAXBException - if an error is encountered while creating the JAXBSource or if either of the parameters are null."
  ([^javax.xml.bind.JAXBContext context ^java.lang.Object content-object]
    (new JAXBSource context content-object)))

