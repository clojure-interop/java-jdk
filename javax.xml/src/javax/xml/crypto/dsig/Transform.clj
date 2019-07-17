(ns javax.xml.crypto.dsig.Transform
  "A representation of the XML Transform element as
  defined in the
  W3C Recommendation for XML-Signature Syntax and Processing.
  The XML Schema Definition is defined as:



  <element name=`Transform` type=`ds:TransformType`/>
    <complexType name=`TransformType` mixed=`true`>
      <choice minOccurs=`0` maxOccurs=`unbounded`>
        <any namespace=`##other` processContents=`lax`/>
        <!-- (1,1) elements from (0,unbounded) namespaces -->
        <element name=`XPath` type=`string`/>
      </choice>
      <attribute name=`Algorithm` type=`anyURI` use=`required`/>
    </complexType>

  A Transform instance may be created by invoking the
  newTransform method
  of the XMLSignatureFactory class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig Transform]))

(defn get-parameter-spec
  "Returns the algorithm-specific input parameters associated with this
   Transform.

   The returned parameters can be typecast to a
   TransformParameterSpec object.

  returns: the algorithm-specific input parameters (may be null
      if not specified) - `java.security.spec.AlgorithmParameterSpec`"
  ([^javax.xml.crypto.dsig.Transform this]
    (-> this (.getParameterSpec))))

(defn transform
  "Transforms the specified data using the underlying transform algorithm.
   If the output of this transform is an OctetStreamData, then
   this method returns null and the bytes are written to the
   specified OutputStream. Otherwise, the
   OutputStream is ignored and the method behaves as if
   transform(Data, XMLCryptoContext) were invoked.

  data - the data to be transformed - `javax.xml.crypto.Data`
  context - the XMLCryptoContext containing additional context (may be null if not applicable) - `javax.xml.crypto.XMLCryptoContext`
  os - the OutputStream that should be used to write the transformed data to - `java.io.OutputStream`

  returns: the transformed data (or null if the data was
      written to the OutputStream parameter) - `javax.xml.crypto.Data`

  throws: java.lang.NullPointerException - if data or os is null"
  ([^javax.xml.crypto.dsig.Transform this ^javax.xml.crypto.Data data ^javax.xml.crypto.XMLCryptoContext context ^java.io.OutputStream os]
    (-> this (.transform data context os)))
  ([^javax.xml.crypto.dsig.Transform this ^javax.xml.crypto.Data data ^javax.xml.crypto.XMLCryptoContext context]
    (-> this (.transform data context))))

