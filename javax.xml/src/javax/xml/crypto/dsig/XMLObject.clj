(ns javax.xml.crypto.dsig.XMLObject
  "A representation of the XML Object element as defined in
  the
  W3C Recommendation for XML-Signature Syntax and Processing.
  An XMLObject may contain any data and may include optional
  MIME type, ID, and encoding attributes. The XML Schema Definition is
  defined as:



  <element name=\"Object\" type=\"ds:ObjectType\"/>
  <complexType name=\"ObjectType\" mixed=\"true\">
    <sequence minOccurs=\"0\" maxOccurs=\"unbounded\">
      <any namespace=\"##any\" processContents=\"lax\"/>
    </sequence>
    <attribute name=\"Id\" type=\"ID\" use=\"optional\"/>
    <attribute name=\"MimeType\" type=\"string\" use=\"optional\"/>
    <attribute name=\"Encoding\" type=\"anyURI\" use=\"optional\"/>
  </complexType>

  A XMLObject instance may be created by invoking the
  newXMLObject method of the
  XMLSignatureFactory class; for example:



    XMLSignatureFactory fac = XMLSignatureFactory.getInstance(\"DOM\");
    List content = Collections.singletonList(fac.newManifest(references)));
    XMLObject object = factory.newXMLObject(content, \"object-1\", null, null);

  Note that this class is named XMLObject rather than
  Object to avoid naming clashes with the existing
  java.lang.Object class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig XMLObject]))

(defn get-content
  "Returns an unmodifiable
   list of XMLStructures contained in this XMLObject,
   which represent elements from any namespace.

  If there is a public subclass representing the type of
   XMLStructure, it is returned as an instance of that class
   (ex: a SignatureProperties element would be returned
   as an instance of SignatureProperties).

  returns: an unmodifiable list of XMLStructures (may be empty
      but never null) - `java.util.List`"
  (^java.util.List [^XMLObject this]
    (-> this (.getContent))))

(defn get-id
  "Returns the Id of this XMLObject.

  returns: the Id (or null if not specified) - `java.lang.String`"
  (^java.lang.String [^XMLObject this]
    (-> this (.getId))))

(defn get-mime-type
  "Returns the mime type of this XMLObject. The
   mime type is an optional attribute which describes the data within this
   XMLObject (independent of its encoding).

  returns: the mime type (or null if not specified) - `java.lang.String`"
  (^java.lang.String [^XMLObject this]
    (-> this (.getMimeType))))

(defn get-encoding
  "Returns the encoding URI of this XMLObject. The encoding
   URI identifies the method by which the object is encoded.

  returns: the encoding URI (or null if not specified) - `java.lang.String`"
  (^java.lang.String [^XMLObject this]
    (-> this (.getEncoding))))

