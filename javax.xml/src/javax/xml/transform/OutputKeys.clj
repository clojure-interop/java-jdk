(ns javax.xml.transform.OutputKeys
  "Provides string constants that can be used to set
  output properties for a Transformer, or to retrieve
  output properties from a Transformer or Templates object.
  All the fields in this class are read-only."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform OutputKeys]))

(def *-method
  "Static Constant.

  method = \"xml\" | \"html\" | \"text\" | expanded name.

   The value of the method property identifies the overall method that
   should be used for outputting the result tree.  Other non-namespaced
   values may be used, such as \"xhtml\", but, if accepted, the handling
   of such values is implementation defined.  If any of the method values
   are not accepted and are not namespace qualified,
   then Transformer.setOutputProperty(java.lang.String, java.lang.String)
   or Transformer.setOutputProperties(java.util.Properties) will
   throw a IllegalArgumentException.

  type: java.lang.String"
  OutputKeys/METHOD)

(def *-version
  "Static Constant.

  version = nmtoken.

   version specifies the version of the output
   method.
   When the output method is \"xml\", the version value specifies the
   version of XML to be used for outputting the result tree. The default
   value for the xml output method is 1.0. When the output method is
   \"html\", the version value indicates the version of the HTML.
   The default value for the xml output method is 4.0, which specifies
   that the result should be output as HTML conforming to the HTML 4.0
   Recommendation [HTML].  If the output method is \"text\", the version
   property is ignored.

  type: java.lang.String"
  OutputKeys/VERSION)

(def *-encoding
  "Static Constant.

  encoding = string.

   encoding specifies the preferred character
   encoding that the Transformer should use to encode sequences of
   characters as sequences of bytes. The value of the encoding property should be
   treated case-insensitively. The value must only contain characters in
   the range #x21 to #x7E (i.e., printable ASCII characters). The value
   should either be a charset registered with the Internet
   Assigned Numbers Authority [IANA],
   [RFC2278]
   or start with X-.

  type: java.lang.String"
  OutputKeys/ENCODING)

(def *-omit-xml-declaration
  "Static Constant.

  omit-xml-declaration = \"yes\" | \"no\".

   omit-xml-declaration specifies whether the XSLT
   processor should output an XML declaration; the value must be
   yes or no.

  type: java.lang.String"
  OutputKeys/OMIT_XML_DECLARATION)

(def *-standalone
  "Static Constant.

  standalone = \"yes\" | \"no\".

   standalone specifies whether the Transformer
   should output a standalone document declaration; the value must be
   yes or no.

  type: java.lang.String"
  OutputKeys/STANDALONE)

(def *-doctype-public
  "Static Constant.

  doctype-public = string.
   See the documentation for the DOCTYPE_SYSTEM property
   for a description of what the value of the key should be.

  type: java.lang.String"
  OutputKeys/DOCTYPE_PUBLIC)

(def *-doctype-system
  "Static Constant.

  doctype-system = string.
   doctype-system specifies the system identifier
   to be used in the document type declaration.
   If the doctype-system property is specified, the xml output method
   should output a document type declaration immediately before the first
   element. The name following <!DOCTYPE should be the name of the first
   element. If doctype-public property is also specified, then the xml
   output method should output PUBLIC followed by the public identifier
   and then the system identifier; otherwise, it should output SYSTEM
   followed by the system identifier. The internal subset should be empty.
   The value of the doctype-public property should be ignored unless the doctype-system
   property is specified.
   If the doctype-public or doctype-system properties are specified,
   then the html output method should output a document type declaration
   immediately before the first element. The name following <!DOCTYPE
   should be HTML or html. If the doctype-public property is specified,
   then the output method should output PUBLIC followed by the specified
   public identifier; if the doctype-system property is also specified,
   it should also output the specified system identifier following the
   public identifier. If the doctype-system property is specified but
   the doctype-public property is not specified, then the output method
   should output SYSTEM followed by the specified system identifier.

   doctype-system specifies the system identifier
   to be used in the document type declaration.

  type: java.lang.String"
  OutputKeys/DOCTYPE_SYSTEM)

(def *-cdata-section-elements
  "Static Constant.

  cdata-section-elements = expanded names.

   cdata-section-elements specifies a whitespace delimited
   list of the names of elements whose text node children should be output
   using CDATA sections. Note that these names must use the format
   described in the section Qualfied Name Representation in
   javax.xml.transform.

  type: java.lang.String"
  OutputKeys/CDATA_SECTION_ELEMENTS)

(def *-indent
  "Static Constant.

  indent = \"yes\" | \"no\".

   indent specifies whether the Transformer may
   add additional whitespace when outputting the result tree; the value
   must be yes or no.

  type: java.lang.String"
  OutputKeys/INDENT)

(def *-media-type
  "Static Constant.

  media-type = string.

   media-type specifies the media type (MIME
   content type) of the data that results from outputting the result
   tree. The charset parameter should not be specified
   explicitly; instead, when the top-level media type is
   text, a charset parameter should be added
   according to the character encoding actually used by the output
   method.

  type: java.lang.String"
  OutputKeys/MEDIA_TYPE)

