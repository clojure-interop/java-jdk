(ns javax.xml.crypto.dsig.SignedInfo
  "An representation of the XML SignedInfo element as
  defined in the
  W3C Recommendation for XML-Signature Syntax and Processing.
  The XML Schema Definition is defined as:


  <element name=`SignedInfo` type=`ds:SignedInfoType`/>
  <complexType name=`SignedInfoType`>
    <sequence>
      <element ref=`ds:CanonicalizationMethod`/>
      <element ref=`ds:SignatureMethod`/>
      <element ref=`ds:Reference` maxOccurs=`unbounded`/>
    </sequence>
    <attribute name=`Id` type=`ID` use=`optional`/>
  </complexType>

  A SignedInfo instance may be created by invoking one of the
  newSignedInfo methods of the
  XMLSignatureFactory class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig SignedInfo]))

(defn get-canonicalization-method
  "Returns the canonicalization method of this SignedInfo.

  returns: the canonicalization method - `javax.xml.crypto.dsig.CanonicalizationMethod`"
  ([^javax.xml.crypto.dsig.SignedInfo this]
    (-> this (.getCanonicalizationMethod))))

(defn get-signature-method
  "Returns the signature method of this SignedInfo.

  returns: the signature method - `javax.xml.crypto.dsig.SignatureMethod`"
  ([^javax.xml.crypto.dsig.SignedInfo this]
    (-> this (.getSignatureMethod))))

(defn get-references
  "Returns an unmodifiable list of one or more References.

  returns: an unmodifiable list of one or more References - `java.util.List`"
  ([^javax.xml.crypto.dsig.SignedInfo this]
    (-> this (.getReferences))))

(defn get-id
  "Returns the optional Id attribute of this
   SignedInfo.

  returns: the id (may be null if not specified) - `java.lang.String`"
  ([^javax.xml.crypto.dsig.SignedInfo this]
    (-> this (.getId))))

(defn get-canonicalized-data
  "Returns the canonicalized signed info bytes after a signing or
   validation operation. This method is useful for debugging.

  returns: an InputStream containing the canonicalized bytes,
      or null if this SignedInfo has not been
      signed or validated yet - `java.io.InputStream`"
  ([^javax.xml.crypto.dsig.SignedInfo this]
    (-> this (.getCanonicalizedData))))

