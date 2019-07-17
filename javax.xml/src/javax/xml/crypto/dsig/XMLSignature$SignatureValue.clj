(ns javax.xml.crypto.dsig.XMLSignature$SignatureValue
  "A representation of the XML SignatureValue element as
  defined in the
  W3C Recommendation for XML-Signature Syntax and Processing.
  The XML Schema Definition is defined as:



    <element name=`SignatureValue` type=`ds:SignatureValueType`/>
      <complexType name=`SignatureValueType`>
        <simpleContent>
          <extension base=`base64Binary`>
            <attribute name=`Id` type=`ID` use=`optional`/>
          </extension>
        </simpleContent>
      </complexType>"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig XMLSignature$SignatureValue]))

(defn get-id
  "Returns the optional Id attribute of this
   SignatureValue, which permits this element to be
   referenced from elsewhere.

  returns: the Id attribute (may be null if
      not specified) - `java.lang.String`"
  ([this]
    (-> this (.getId))))

(defn get-value
  "Returns the signature value of this SignatureValue.

  returns: the signature value (may be null if the
      XMLSignature has not been signed yet). Each
      invocation of this method returns a new clone of the array to
      prevent subsequent modification. - `byte[]`"
  ([this]
    (-> this (.getValue))))

(defn validate
  "Validates the signature value. This method performs a
   cryptographic validation of the signature calculated over the
   SignedInfo of the XMLSignature.

   This method only validates the signature the first
   time it is invoked. On subsequent invocations, it returns a cached
   result.

  validate-context - the validating context - `javax.xml.crypto.dsig.XMLValidateContext`

  returns: true if the signature was
      validated successfully; false otherwise - `boolean`

  throws: java.lang.NullPointerException - if validateContext is null"
  ([this validate-context]
    (-> this (.validate validate-context))))

