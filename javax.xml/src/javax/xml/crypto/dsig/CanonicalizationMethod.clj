(ns javax.xml.crypto.dsig.CanonicalizationMethod
  "A representation of the XML CanonicalizationMethod
  element as defined in the

  W3C Recommendation for XML-Signature Syntax and Processing. The XML
  Schema Definition is defined as:



    <element name=`CanonicalizationMethod` type=`ds:CanonicalizationMethodType`/>
      <complexType name=`CanonicalizationMethodType` mixed=`true`>
        <sequence>
          <any namespace=`##any` minOccurs=`0` maxOccurs=`unbounded`/>
            <!-- (0,unbounded) elements from (1,1) namespace -->
        </sequence>
        <attribute name=`Algorithm` type=`anyURI` use=`required`/>
      </complexType>

  A CanonicalizationMethod instance may be created by invoking
  the newCanonicalizationMethod method of the XMLSignatureFactory class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig CanonicalizationMethod]))

(defn get-parameter-spec
  "Returns the algorithm-specific input parameters associated with this
   CanonicalizationMethod.

   The returned parameters can be typecast to a
   C14NMethodParameterSpec object.

  returns: the algorithm-specific input parameters (may be
      null if not specified) - `java.security.spec.AlgorithmParameterSpec`"
  (^java.security.spec.AlgorithmParameterSpec [^javax.xml.crypto.dsig.CanonicalizationMethod this]
    (-> this (.getParameterSpec))))

