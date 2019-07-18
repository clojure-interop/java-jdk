(ns javax.xml.crypto.dsig.keyinfo.RetrievalMethod
  "A representation of the XML RetrievalMethod element as
  defined in the
  W3C Recommendation for XML-Signature Syntax and Processing.
  A RetrievalMethod object is used to convey a reference to
  KeyInfo information that is stored at another location.
  The XML schema definition is defined as:



    <element name=`RetrievalMethod` type=`ds:RetrievalMethodType`/>
    <complexType name=`RetrievalMethodType`>
      <sequence>
        <element name=`Transforms` type=`ds:TransformsType` minOccurs=`0`/>
      </sequence>
      <attribute name=`URI` type=`anyURI`/>
      <attribute name=`Type` type=`anyURI` use=`optional`/>
    </complexType>

  A RetrievalMethod instance may be created by invoking one of the
  newRetrievalMethod methods
  of the KeyInfoFactory class, and passing it the URI
  identifying the location of the KeyInfo, an optional type URI identifying
  the type of KeyInfo, and an optional list of Transforms; for example:


    KeyInfoFactory factory = KeyInfoFactory.getInstance(`DOM`);
    RetrievalMethod rm = factory.newRetrievalMethod
       (`#KeyValue-1`, KeyValue.DSA_TYPE, Collections.singletonList(Transform.BASE64));"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig.keyinfo RetrievalMethod]))

(defn get-transforms
  "Returns an unmodifiable
   list of Transforms of this RetrievalMethod.

  returns: an unmodifiable list of Transform objects (may be
      empty but never null). - `java.util.List`"
  (^java.util.List [^RetrievalMethod this]
    (-> this (.getTransforms))))

(defn get-uri
  "Returns the URI of the referenced KeyInfo information.

  returns: the URI of the referenced KeyInfo information in
      RFC 2396 format (never null) - `java.lang.String`"
  (^java.lang.String [^RetrievalMethod this]
    (-> this (.getURI))))

(defn dereference
  "Dereferences the KeyInfo information referenced by this
   RetrievalMethod and applies the specified
   Transforms.

  context - an XMLCryptoContext that may contain additional useful information for dereferencing the URI. The context's baseURI and dereferencer parameters (if specified) are used to resolve and dereference this RetrievalMethod - `javax.xml.crypto.XMLCryptoContext`

  returns: a Data object representing the raw contents of the
      KeyInfo information referenced by this
      RetrievalMethod. It is the caller's responsibility to
      convert the returned data to an appropriate
      KeyInfo object. - `javax.xml.crypto.Data`

  throws: java.lang.NullPointerException - if context is null"
  (^javax.xml.crypto.Data [^RetrievalMethod this ^javax.xml.crypto.XMLCryptoContext context]
    (-> this (.dereference context))))

