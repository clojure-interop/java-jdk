(ns javax.xml.crypto.dsig.Reference
  "A representation of the Reference element as defined in the

  W3C Recommendation for XML-Signature Syntax and Processing.
  The XML schema is defined as:


  <element name=`Reference` type=`ds:ReferenceType`/>
  <complexType name=`ReferenceType`>
    <sequence>
      <element ref=`ds:Transforms` minOccurs=`0`/>
      <element ref=`ds:DigestMethod`/>
      <element ref=`ds:DigestValue`/>
    </sequence>
    <attribute name=`Id` type=`ID` use=`optional`/>
    <attribute name=`URI` type=`anyURI` use=`optional`/>
    <attribute name=`Type` type=`anyURI` use=`optional`/>
  </complexType>

  <element name=`DigestValue` type=`ds:DigestValueType`/>
  <simpleType name=`DigestValueType`>
    <restriction base=`base64Binary`/>
  </simpleType>

  A Reference instance may be created by invoking one of the
  newReference methods of the
  XMLSignatureFactory class; for example:



    XMLSignatureFactory factory = XMLSignatureFactory.getInstance(`DOM`);
    Reference ref = factory.newReference
      (`http://www.ietf.org/rfc/rfc3275.txt`,
       factory.newDigestMethod(DigestMethod.SHA1, null));"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig Reference]))

(defn get-transforms
  "Returns an unmodifiable
   list of Transforms that are contained in this
   Reference.

  returns: an unmodifiable list of Transforms
      (may be empty but never null) - `java.util.List`"
  (^java.util.List [^Reference this]
    (-> this (.getTransforms))))

(defn get-digest-method
  "Returns the digest method of this Reference.

  returns: the digest method - `javax.xml.crypto.dsig.DigestMethod`"
  (^javax.xml.crypto.dsig.DigestMethod [^Reference this]
    (-> this (.getDigestMethod))))

(defn get-id
  "Returns the optional Id attribute of this
   Reference, which permits this reference to be
   referenced from elsewhere.

  returns: the Id attribute (may be null if not
      specified) - `java.lang.String`"
  (^java.lang.String [^Reference this]
    (-> this (.getId))))

(defn get-digest-value
  "Returns the digest value of this Reference.

  returns: the raw digest value, or null if this reference has
      not been digested yet. Each invocation of this method returns a new
      clone to protect against subsequent modification. - `byte[]`"
  ([^Reference this]
    (-> this (.getDigestValue))))

(defn get-calculated-digest-value
  "Returns the calculated digest value of this Reference
   after a validation operation. This method is useful for debugging if
   the reference fails to validate.

  returns: the calculated digest value, or null if this
      reference has not been validated yet. Each invocation of this method
      returns a new clone to protect against subsequent modification. - `byte[]`"
  ([^Reference this]
    (-> this (.getCalculatedDigestValue))))

(defn validate
  "Validates this reference. This method verifies the digest of this
   reference.

   This method only validates the reference the first time it is
   invoked. On subsequent invocations, it returns a cached result.

  validate-context - the validating context - `javax.xml.crypto.dsig.XMLValidateContext`

  returns: true if this reference was validated successfully;
      false otherwise - `boolean`

  throws: java.lang.NullPointerException - if validateContext is null"
  (^Boolean [^Reference this ^javax.xml.crypto.dsig.XMLValidateContext validate-context]
    (-> this (.validate validate-context))))

(defn get-dereferenced-data
  "Returns the dereferenced data, if
   reference caching
   is enabled. This is the result of dereferencing the URI of this
   reference during a validation or generation operation.

  returns: the dereferenced data, or null if reference
      caching is not enabled or this reference has not been generated or
      validated - `javax.xml.crypto.Data`"
  (^javax.xml.crypto.Data [^Reference this]
    (-> this (.getDereferencedData))))

(defn get-digest-input-stream
  "Returns the pre-digested input stream, if
   reference caching
   is enabled. This is the input to the digest operation during a
   validation or signing operation.

  returns: an input stream containing the pre-digested input, or
      null if reference caching is not enabled or this
      reference has not been generated or validated - `java.io.InputStream`"
  (^java.io.InputStream [^Reference this]
    (-> this (.getDigestInputStream))))

