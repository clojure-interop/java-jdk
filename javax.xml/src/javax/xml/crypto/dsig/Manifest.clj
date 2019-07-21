(ns javax.xml.crypto.dsig.Manifest
  "A representation of the XML Manifest element as defined in
  the
  W3C Recommendation for XML-Signature Syntax and Processing.
  The XML Schema Definition is defined as:


  <element name=\"Manifest\" type=\"ds:ManifestType\"/>
    <complexType name=\"ManifestType\">
      <sequence>
        <element ref=\"ds:Reference\" maxOccurs=\"unbounded\"/>
      </sequence>
      <attribute name=\"Id\" type=\"ID\" use=\"optional\"/>
    </complexType>

  A Manifest instance may be created by invoking
  one of the newManifest
  methods of the XMLSignatureFactory class; for example:



    XMLSignatureFactory factory = XMLSignatureFactory.getInstance(\"DOM\");
    List references = Collections.singletonList(factory.newReference
        (\"#reference-1\", DigestMethod.SHA1));
    Manifest manifest = factory.newManifest(references, \"manifest-1\");"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig Manifest]))

(defn get-id
  "Returns the Id of this Manifest.

  returns: the Id  of this Manifest (or null
      if not specified) - `java.lang.String`"
  (^java.lang.String [^Manifest this]
    (-> this (.getId))))

(defn get-references
  "Returns an unmodifiable
   list of one or more References that are contained in this
   Manifest.

  returns: an unmodifiable list of one or more References - `java.util.List`"
  (^java.util.List [^Manifest this]
    (-> this (.getReferences))))

