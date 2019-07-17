(ns javax.xml.bind.util.JAXBResult
  "JAXP Result implementation
  that unmarshals a JAXB object.


  This utility class is useful to combine JAXB with
  other Java/XML technologies.


  The following example shows how to use JAXB to unmarshal a document
  resulting from an XSLT transformation.




        JAXBResult result = new JAXBResult(
          JAXBContext.newInstance(`org.acme.foo`) );

        // set up XSLT transformation
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer(new StreamSource(`test.xsl`));

        // run transformation
        t.transform(new StreamSource(`document.xml`),result);

        // obtain the unmarshalled content tree
        Object o = result.getResult();



  The fact that JAXBResult derives from SAXResult is an implementation
  detail. Thus in general applications are strongly discouraged from
  accessing methods defined on SAXResult.


  In particular it shall never attempt to call the setHandler,
  setLexicalHandler, and setSystemId methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind.util JAXBResult]))

(defn ->jaxb-result
  "Constructor.

  Creates a new instance that uses the specified
   JAXBContext to unmarshal.

  context - The JAXBContext that will be used to create the necessary Unmarshaller. This parameter must not be null. - `javax.xml.bind.JAXBContext`

  throws: javax.xml.bind.JAXBException - if an error is encountered while creating the JAXBResult or if the context parameter is null."
  ([^javax.xml.bind.JAXBContext context]
    (new JAXBResult context)))

(defn get-result
  "Gets the unmarshalled object created by the transformation.

  returns: Always return a non-null object. - `java.lang.Object`

  throws: java.lang.IllegalStateException - if this method is called before an object is unmarshalled."
  ([^javax.xml.bind.util.JAXBResult this]
    (-> this (.getResult))))

