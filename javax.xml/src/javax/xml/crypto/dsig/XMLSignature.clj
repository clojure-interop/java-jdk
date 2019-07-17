(ns javax.xml.crypto.dsig.XMLSignature
  "A representation of the XML Signature element as
  defined in the
  W3C Recommendation for XML-Signature Syntax and Processing.
  This class contains methods for signing and validating XML signatures
  with behavior as defined by the W3C specification. The XML Schema Definition
  is defined as:


  <element name=`Signature` type=`ds:SignatureType`/>
  <complexType name=`SignatureType`>
     <sequence>
       <element ref=`ds:SignedInfo`/>
       <element ref=`ds:SignatureValue`/>
       <element ref=`ds:KeyInfo` minOccurs=`0`/>
       <element ref=`ds:Object` minOccurs=`0` maxOccurs=`unbounded`/>
     </sequence>
     <attribute name=`Id` type=`ID` use=`optional`/>
  </complexType>

  An XMLSignature instance may be created by invoking one of the
  newXMLSignature methods of the
  XMLSignatureFactory class.

  If the contents of the underlying document containing the
  XMLSignature are subsequently modified, the behavior is
  undefined.

  Note that this class is named XMLSignature rather than
  Signature to avoid naming clashes with the existing
  java.security.Signature class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig XMLSignature]))

(defn validate
  "Validates the signature according to the

   core validation processing rules. This method validates the
   signature using the existing state, it does not unmarshal and
   reinitialize the contents of the XMLSignature using the
   location information specified in the context.

   This method only validates the signature the first time it is
   invoked. On subsequent invocations, it returns a cached result.

  validate-context - the validating context - `javax.xml.crypto.dsig.XMLValidateContext`

  returns: true if the signature passed core validation,
      otherwise false - `boolean`

  throws: java.lang.ClassCastException - if the type of validateContext is not compatible with this XMLSignature"
  ([^javax.xml.crypto.dsig.XMLSignature this ^javax.xml.crypto.dsig.XMLValidateContext validate-context]
    (-> this (.validate validate-context))))

(defn get-key-info
  "Returns the key info of this XMLSignature.

  returns: the key info (may be null if not specified) - `javax.xml.crypto.dsig.keyinfo.KeyInfo`"
  ([^javax.xml.crypto.dsig.XMLSignature this]
    (-> this (.getKeyInfo))))

(defn get-signed-info
  "Returns the signed info of this XMLSignature.

  returns: the signed info (never null) - `javax.xml.crypto.dsig.SignedInfo`"
  ([^javax.xml.crypto.dsig.XMLSignature this]
    (-> this (.getSignedInfo))))

(defn get-objects
  "Returns an unmodifiable
   list of XMLObjects contained in this XMLSignature.

  returns: an unmodifiable list of XMLObjects (may be empty
      but never null) - `java.util.List`"
  ([^javax.xml.crypto.dsig.XMLSignature this]
    (-> this (.getObjects))))

(defn get-id
  "Returns the optional Id of this XMLSignature.

  returns: the Id (may be null if not specified) - `java.lang.String`"
  ([^javax.xml.crypto.dsig.XMLSignature this]
    (-> this (.getId))))

(defn get-signature-value
  "Returns the signature value of this XMLSignature.

  returns: the signature value - `javax.xml.crypto.dsig.XMLSignature.SignatureValue`"
  ([^javax.xml.crypto.dsig.XMLSignature this]
    (-> this (.getSignatureValue))))

(defn sign
  "Signs this XMLSignature.

   If this method throws an exception, this XMLSignature and
   the signContext parameter will be left in the state that
   it was in prior to the invocation.

  sign-context - the signing context - `javax.xml.crypto.dsig.XMLSignContext`

  throws: java.lang.ClassCastException - if the type of signContext is not compatible with this XMLSignature"
  ([^javax.xml.crypto.dsig.XMLSignature this ^javax.xml.crypto.dsig.XMLSignContext sign-context]
    (-> this (.sign sign-context))))

(defn get-key-selector-result
  "Returns the result of the KeySelector, if specified, after
   this XMLSignature has been signed or validated.

  returns: the key selector result, or null if a key
      selector has not been specified or this XMLSignature
      has not been signed or validated - `javax.xml.crypto.KeySelectorResult`"
  ([^javax.xml.crypto.dsig.XMLSignature this]
    (-> this (.getKeySelectorResult))))

