(ns javax.xml.crypto.dsig.SignatureProperty
  "A representation of the XML SignatureProperty element as
  defined in the
  W3C Recommendation for XML-Signature Syntax and Processing.
  The XML Schema Definition is defined as:


 <element name=`SignatureProperty` type=`ds:SignaturePropertyType`/>
    <complexType name=`SignaturePropertyType` mixed=`true`>
      <choice maxOccurs=`unbounded`>
        <any namespace=`##other` processContents=`lax`/>
        <!-- (1,1) elements from (1, unbounded) namespaces -->
      </choice>
      <attribute name=`Target` type=`anyURI` use=`required`/>
      <attribute name=`Id` type=`ID` use=`optional`/>
    </complexType>

  A SignatureProperty instance may be created by invoking the
  newSignatureProperty
  method of the XMLSignatureFactory class; for example:



    XMLSignatureFactory factory = XMLSignatureFactory.getInstance(`DOM`);
    SignatureProperty property = factory.newSignatureProperty
       (Collections.singletonList(content), `#Signature-1`, `TimeStamp`);"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig SignatureProperty]))

(defn get-target
  "Returns the target URI of this SignatureProperty.

  returns: the target URI of this SignatureProperty (never
      null) - `java.lang.String`"
  ([^javax.xml.crypto.dsig.SignatureProperty this]
    (-> this (.getTarget))))

(defn get-id
  "Returns the Id of this SignatureProperty.

  returns: the Id of this SignatureProperty (or
      null if not specified) - `java.lang.String`"
  ([^javax.xml.crypto.dsig.SignatureProperty this]
    (-> this (.getId))))

(defn get-content
  "Returns an unmodifiable
   list of one or more XMLStructures that are contained in
   this SignatureProperty. These represent additional
   information items concerning the generation of the XMLSignature
   (i.e. date/time stamp or serial numbers of cryptographic hardware used
   in signature generation).

  returns: an unmodifiable list of one or more XMLStructures - `java.util.List`"
  ([^javax.xml.crypto.dsig.SignatureProperty this]
    (-> this (.getContent))))

