(ns javax.xml.crypto.dsig.DigestMethod
  "A representation of the XML DigestMethod element as
  defined in the
  W3C Recommendation for XML-Signature Syntax and Processing.
  The XML Schema Definition is defined as:



    <element name=`DigestMethod` type=`ds:DigestMethodType`/>
      <complexType name=`DigestMethodType` mixed=`true`>
        <sequence>
          <any namespace=`##any` minOccurs=`0` maxOccurs=`unbounded`/>
            <!-- (0,unbounded) elements from (1,1) namespace -->
        </sequence>
        <attribute name=`Algorithm` type=`anyURI` use=`required`/>
      </complexType>

  A DigestMethod instance may be created by invoking the
  newDigestMethod method
  of the XMLSignatureFactory class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig DigestMethod]))

(defn get-parameter-spec
  "Returns the algorithm-specific input parameters associated with this
   DigestMethod.

   The returned parameters can be typecast to a DigestMethodParameterSpec object.

  returns: the algorithm-specific parameters (may be null if
      not specified) - `java.security.spec.AlgorithmParameterSpec`"
  ([this]
    (-> this (.getParameterSpec))))

