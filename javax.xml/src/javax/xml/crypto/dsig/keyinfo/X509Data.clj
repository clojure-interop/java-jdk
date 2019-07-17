(ns javax.xml.crypto.dsig.keyinfo.X509Data
  "A representation of the XML X509Data element as defined in
  the
  W3C Recommendation for XML-Signature Syntax and Processing. An
  X509Data object contains one or more identifers of keys
  or X.509 certificates (or certificates' identifiers or a revocation list).
  The XML Schema Definition is defined as:



     <element name=`X509Data` type=`ds:X509DataType`/>
     <complexType name=`X509DataType`>
         <sequence maxOccurs=`unbounded`>
           <choice>
             <element name=`X509IssuerSerial` type=`ds:X509IssuerSerialType`/>
             <element name=`X509SKI` type=`base64Binary`/>
             <element name=`X509SubjectName` type=`string`/>
             <element name=`X509Certificate` type=`base64Binary`/>
             <element name=`X509CRL` type=`base64Binary`/>
             <any namespace=`##other` processContents=`lax`/>
           </choice>
         </sequence>
     </complexType>

     <complexType name=`X509IssuerSerialType`>
       <sequence>
         <element name=`X509IssuerName` type=`string`/>
         <element name=`X509SerialNumber` type=`integer`/>
       </sequence>
     </complexType>

  An X509Data instance may be created by invoking the
  newX509Data methods of the
  KeyInfoFactory class and passing it a list of one or more
  XMLStructures representing X.509 content; for example:


    KeyInfoFactory factory = KeyInfoFactory.getInstance(`DOM`);
    X509Data x509Data = factory.newX509Data
        (Collections.singletonList(`cn=Alice`));"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig.keyinfo X509Data]))

(defn get-content
  "Returns an unmodifiable
   list of the content in this X509Data. Valid types are
   String (subject names), byte[] (subject key ids),
   X509Certificate, X509CRL,
   or XMLStructure (X509IssuerSerial
   objects or elements from an external namespace).

  returns: an unmodifiable list of the content in this X509Data
      (never null or empty) - `java.util.List`"
  ([^javax.xml.crypto.dsig.keyinfo.X509Data this]
    (-> this (.getContent))))

