(ns javax.xml.crypto.dsig.keyinfo.KeyInfo
  "A representation of the XML KeyInfo element as defined in
  the
  W3C Recommendation for XML-Signature Syntax and Processing.
  A KeyInfo contains a list of XMLStructures, each of
  which contain information that enables the recipient(s) to obtain the key
  needed to validate an XML signature. The XML Schema Definition is defined as:



  <element name=\"KeyInfo\" type=\"ds:KeyInfoType\"/>
  <complexType name=\"KeyInfoType\" mixed=\"true\">
    <choice maxOccurs=\"unbounded\">
      <element ref=\"ds:KeyName\"/>
      <element ref=\"ds:KeyValue\"/>
      <element ref=\"ds:RetrievalMethod\"/>
      <element ref=\"ds:X509Data\"/>
      <element ref=\"ds:PGPData\"/>
      <element ref=\"ds:SPKIData\"/>
      <element ref=\"ds:MgmtData\"/>
      <any processContents=\"lax\" namespace=\"##other\"/>
      <!-- (1,1) elements from (0,unbounded) namespaces -->
    </choice>
    <attribute name=\"Id\" type=\"ID\" use=\"optional\"/>
  </complexType>

  A KeyInfo instance may be created by invoking one of the
  newKeyInfo methods of the
  KeyInfoFactory class, and passing it a list of one or more
  XMLStructures and an optional id parameter;
  for example:


    KeyInfoFactory factory = KeyInfoFactory.getInstance(\"DOM\");
    KeyInfo keyInfo = factory.newKeyInfo
       (Collections.singletonList(factory.newKeyName(\"Alice\"), \"keyinfo-1\"));

  KeyInfo objects can also be marshalled to XML by invoking
  the marshal method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig.keyinfo KeyInfo]))

(defn get-content
  "Returns an unmodifiable
   list containing the key information. Each entry of the list is
   an XMLStructure.

   If there is a public subclass representing the type of
   XMLStructure, it is returned as an instance of that
   class (ex: an X509Data element would be returned as an
   instance of X509Data).

  returns: an unmodifiable list of one or more XMLStructures
      in this KeyInfo. Never returns null or an
      empty list. - `java.util.List`"
  (^java.util.List [^KeyInfo this]
    (-> this (.getContent))))

(defn get-id
  "Return the optional Id attribute of this KeyInfo, which
   may be useful for referencing this KeyInfo from other
   XML structures.

  returns: the Id attribute of this KeyInfo (may be
      null if not specified) - `java.lang.String`"
  (^java.lang.String [^KeyInfo this]
    (-> this (.getId))))

(defn marshal
  "Marshals the key info to XML.

  parent - a mechanism-specific structure containing the parent node that the marshalled key info will be appended to - `javax.xml.crypto.XMLStructure`
  context - the XMLCryptoContext containing additional context (may be null if not applicable) - `javax.xml.crypto.XMLCryptoContext`

  throws: java.lang.ClassCastException - if the type of parent or context is not compatible with this key info"
  ([^KeyInfo this ^javax.xml.crypto.XMLStructure parent ^javax.xml.crypto.XMLCryptoContext context]
    (-> this (.marshal parent context))))

