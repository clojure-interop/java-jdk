(ns javax.xml.crypto.dsig.SignatureProperties
  "A representation of the XML SignatureProperties element as
  defined in the
  W3C Recommendation for XML-Signature Syntax and Processing.
  The XML Schema Definition is defined as:


 <element name=`SignatureProperties` type=`ds:SignaturePropertiesType`/>
    <complexType name=`SignaturePropertiesType`>
      <sequence>
        <element ref=`ds:SignatureProperty` maxOccurs=`unbounded`/>
      </sequence>
      <attribute name=`Id` type=`ID` use=`optional`/>
    </complexType>

  A SignatureProperties instance may be created by invoking the
  newSignatureProperties
  method of the XMLSignatureFactory class; for example:



    XMLSignatureFactory factory = XMLSignatureFactory.getInstance(`DOM`);
    SignatureProperties properties =
       factory.newSignatureProperties(props, `signature-properties-1`);"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig SignatureProperties]))

(defn get-id
  "Returns the Id of this SignatureProperties.

  returns: the Id of this SignatureProperties (or
      null if not specified) - `java.lang.String`"
  ([^. this]
    (-> this (.getId))))

(defn get-properties
  "Returns an unmodifiable
   list of one or more SignaturePropertys that are contained in
   this SignatureProperties.

  returns: an unmodifiable list of one or more
      SignaturePropertys - `java.util.List`"
  ([^. this]
    (-> this (.getProperties))))

