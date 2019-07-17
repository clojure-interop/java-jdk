(ns javax.xml.namespace.QName
  "QName represents a qualified name
  as defined in the XML specifications: XML Schema Part2:
  Datatypes specification, Namespaces
  in XML, Namespaces
  in XML Errata.

  The value of a QName contains a Namespace
  URI, local part and
  prefix.

  The prefix is included in QName to retain lexical
  information when present in an XML input source. The prefix is
  NOT used in QName.equals(Object) or to compute the QName.hashCode().  Equality and the hash code are defined using
  only the Namespace URI and local part.

  If not specified, the Namespace URI is set to XMLConstants.NULL_NS_URI.
  If not specified, the prefix is set to XMLConstants.DEFAULT_NS_PREFIX.

  QName is immutable."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.namespace QName]))

(defn ->q-name
  "Constructor.

  QName constructor specifying the Namespace URI,
   local part and prefix.

   If the Namespace URI is null, it is set to
   XMLConstants.NULL_NS_URI.  This value represents no
   explicitly defined Namespace as defined by the Namespaces
   in XML specification.  This action preserves compatible
   behavior with QName 1.0.  Explicitly providing the XMLConstants.NULL_NS_URI value is the preferred coding
   style.

   If the local part is null an
   IllegalArgumentException is thrown.
   A local part of `` is allowed to preserve
   compatible behavior with QName 1.0.

   If the prefix is null, an
   IllegalArgumentException is thrown.  Use XMLConstants.DEFAULT_NS_PREFIX to explicitly indicate that no
   prefix is present or the prefix is not relevant.

   The Namespace URI is not validated as a
   URI reference.
   The local part and prefix are not validated as a
   NCName
   as specified in Namespaces
   in XML.

  namespace-uri - Namespace URI of the QName - `java.lang.String`
  local-part - local part of the QName - `java.lang.String`
  prefix - prefix of the QName - `java.lang.String`

  throws: java.lang.IllegalArgumentException - When localPart or prefix is null"
  ([namespace-uri local-part prefix]
    (new QName namespace-uri local-part prefix))
  ([namespace-uri local-part]
    (new QName namespace-uri local-part))
  ([local-part]
    (new QName local-part)))

(defn *value-of
  "QName derived from parsing the formatted
   String.

   If the String is null or does not conform to
   QName.toString() formatting, an
   IllegalArgumentException is thrown.

   The String MUST be in the
   form returned by QName.toString().

   The commonly accepted way of representing a QName
   as a String was
   defined
   by James Clark.  Although this is not a standard
   specification, it is in common use, e.g. Transformer.setParameter(String name, Object value).
   This implementation parses a String formatted
   as: `{`  Namespace URI  `}`  local part.  If the Namespace
   URI .equals(XMLConstants.NULL_NS_URI), only the
   local part should be provided.

   The prefix value CANNOT be
   represented in the String and will be set to
   XMLConstants.DEFAULT_NS_PREFIX.

   This method does not do full validation of the resulting
   QName.
   The Namespace URI is not validated as a
   URI reference.
   The local part is not validated as a
   NCName
   as specified in
   Namespaces in XML.

  q-name-as-string - String representation of the QName - `java.lang.String`

  returns: QName corresponding to the given String - `javax.xml.namespace.QName`

  throws: java.lang.IllegalArgumentException - When qNameAsString is null or malformed"
  ([q-name-as-string]
    (QName/valueOf q-name-as-string)))

(defn get-namespace-uri
  "Get the Namespace URI of this QName.

  returns: Namespace URI of this QName - `java.lang.String`"
  ([this]
    (-> this (.getNamespaceURI))))

(defn get-local-part
  "Get the local part of this QName.

  returns: local part of this QName - `java.lang.String`"
  ([this]
    (-> this (.getLocalPart))))

(defn get-prefix
  "Get the prefix of this QName.

   The prefix assigned to a QName might
   NOT be valid in a different
   context. For example, a QName may be assigned a
   prefix in the context of parsing a document but that prefix may
   be invalid in the context of a different document.

  returns: prefix of this QName - `java.lang.String`"
  ([this]
    (-> this (.getPrefix))))

(defn equals
  "Test this QName for equality with another
   Object.

   If the Object to be tested is not a
   QName or is null, then this method
   returns false.

   Two QNames are considered equal if and only if
   both the Namespace URI and local part are equal. This method
   uses String.equals() to check equality of the
   Namespace URI and local part. The prefix is
   NOT used to determine equality.

   This method satisfies the general contract of Object.equals(Object)

  object-to-test - the Object to test for equality with this QName - `java.lang.Object`

  returns: true if the given Object is
   equal to this QName else false - `boolean`"
  ([this object-to-test]
    (-> this (.equals object-to-test))))

(defn hash-code
  "Generate the hash code for this QName.

   The hash code is calculated using both the Namespace URI and
   the local part of the QName.  The prefix is
   NOT used to calculate the hash
   code.

   This method satisfies the general contract of Object.hashCode().

  returns: hash code for this QName Object - `int`"
  ([this]
    (-> this (.hashCode))))

(defn to-string
  "String representation of this
   QName.

   The commonly accepted way of representing a QName
   as a String was
   defined
   by James Clark.  Although this is not a standard
   specification, it is in common use, e.g. Transformer.setParameter(String name, Object value).
   This implementation represents a QName as:
   `{`  Namespace URI  `}`  local part.  If the Namespace URI
   .equals(XMLConstants.NULL_NS_URI), only the
   local part is returned.  An appropriate use of this method is
   for debugging or logging for human consumption.

   Note the prefix value is NOT
   returned as part of the String representation.

   This method satisfies the general contract of Object.toString().

  returns: String representation of this QName - `java.lang.String`"
  ([this]
    (-> this (.toString))))

