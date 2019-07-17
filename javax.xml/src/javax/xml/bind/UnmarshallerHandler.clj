(ns javax.xml.bind.UnmarshallerHandler
  "Unmarshaller implemented as SAX ContentHandler.


  Applications can use this interface to use their JAXB provider as a component
  in an XML pipeline.  For example:



        JAXBContext context = JAXBContext.newInstance( `org.acme.foo` );

        Unmarshaller unmarshaller = context.createUnmarshaller();

        UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();

        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware( true );

        XMLReader xmlReader = spf.newSAXParser().getXMLReader();
        xmlReader.setContentHandler( unmarshallerHandler );
        xmlReader.parse(new InputSource( new FileInputStream( XML_FILE ) ) );

        MyObject myObject= (MyObject)unmarshallerHandler.getResult();


  This interface is reusable: even if the user fails to unmarshal
  an object, s/he can still start a new round of unmarshalling."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind UnmarshallerHandler]))

(defn get-result
  "Obtains the unmarshalled result.

   This method can be called only after this handler
   receives the endDocument SAX event.

  returns: always return a non-null valid object which was unmarshalled. - `java.lang.Object`

  throws: java.lang.IllegalStateException - if this method is called before this handler receives the endDocument event."
  ([^. this]
    (-> this (.getResult))))

