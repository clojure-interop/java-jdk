(ns javax.xml.crypto.dsig.SignatureMethod
  "A representation of the XML SignatureMethod element
  as defined in the
  W3C Recommendation for XML-Signature Syntax and Processing.
  The XML Schema Definition is defined as:



    <element name=`SignatureMethod` type=`ds:SignatureMethodType`/>
      <complexType name=`SignatureMethodType` mixed=`true`>
        <sequence>
          <element name=`HMACOutputLength` minOccurs=`0` type=`ds:HMACOutputLengthType`/>
          <any namespace=`##any` minOccurs=`0` maxOccurs=`unbounded`/>
            <!-- (0,unbounded) elements from (1,1) namespace -->
        </sequence>
        <attribute name=`Algorithm` type=`anyURI` use=`required`/>
      </complexType>

  A SignatureMethod instance may be created by invoking the
  newSignatureMethod method
  of the XMLSignatureFactory class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig SignatureMethod]))

(defn get-parameter-spec
  "Returns the algorithm-specific input parameters of this
   SignatureMethod.

   The returned parameters can be typecast to a SignatureMethodParameterSpec object.

  returns: the algorithm-specific input parameters of this
      SignatureMethod (may be null if not
      specified) - `java.security.spec.AlgorithmParameterSpec`"
  ([this]
    (-> this (.getParameterSpec))))

