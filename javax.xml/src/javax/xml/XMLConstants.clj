(ns javax.xml.XMLConstants
  "Utility class to contain basic XML values as constants."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml XMLConstants]))

(def *-null-ns-uri
  "Static Constant.

  Namespace URI to use to represent that there is no Namespace.

   Defined by the Namespace specification to be ``.

  type: java.lang.String"
  XMLConstants/NULL_NS_URI)

(def *-default-ns-prefix
  "Static Constant.

  Prefix to use to represent the default XML Namespace.

   Defined by the XML specification to be ``.

  type: java.lang.String"
  XMLConstants/DEFAULT_NS_PREFIX)

(def *-xml-ns-uri
  "Static Constant.

  The official XML Namespace name URI.

   Defined by the XML specification to be
   `http://www.w3.org/XML/1998/namespace`.

  type: java.lang.String"
  XMLConstants/XML_NS_URI)

(def *-xml-ns-prefix
  "Static Constant.

  The official XML Namespace prefix.

   Defined by the XML specification to be `xml`.

  type: java.lang.String"
  XMLConstants/XML_NS_PREFIX)

(def *-xmlns-attribute-ns-uri
  "Static Constant.

  The official XML attribute used for specifying XML Namespace
   declarations, XMLConstants.XMLNS_ATTRIBUTE, Namespace name URI.

   Defined by the XML specification to be
   `http://www.w3.org/2000/xmlns/`.

  type: java.lang.String"
  XMLConstants/XMLNS_ATTRIBUTE_NS_URI)

(def *-xmlns-attribute
  "Static Constant.

  The official XML attribute used for specifying XML Namespace
   declarations.

   It is NOT valid to use as a
   prefix.  Defined by the XML specification to be
   `xmlns`.

  type: java.lang.String"
  XMLConstants/XMLNS_ATTRIBUTE)

(def *-w-3-c-xml-schema-ns-uri
  "Static Constant.

  W3C XML Schema Namespace URI.

   Defined to be `http://www.w3.org/2001/XMLSchema`.

  type: java.lang.String"
  XMLConstants/W3C_XML_SCHEMA_NS_URI)

(def *-w-3-c-xml-schema-instance-ns-uri
  "Static Constant.

  W3C XML Schema Instance Namespace URI.

   Defined to be `http://www.w3.org/2001/XMLSchema-instance`.

  type: java.lang.String"
  XMLConstants/W3C_XML_SCHEMA_INSTANCE_NS_URI)

(def *-w-3-c-xpath-datatype-ns-uri
  "Static Constant.

  W3C XPath Datatype Namespace URI.

   Defined to be `http://www.w3.org/2003/11/xpath-datatypes`.

  type: java.lang.String"
  XMLConstants/W3C_XPATH_DATATYPE_NS_URI)

(def *-xml-dtd-ns-uri
  "Static Constant.

  XML Document Type Declaration Namespace URI as an arbitrary value.

   Since not formally defined by any existing standard, arbitrarily define to be `http://www.w3.org/TR/REC-xml`.

  type: java.lang.String"
  XMLConstants/XML_DTD_NS_URI)

(def *-relaxng-ns-uri
  "Static Constant.

  RELAX NG Namespace URI.

   Defined to be `http://relaxng.org/ns/structure/1.0`.

  type: java.lang.String"
  XMLConstants/RELAXNG_NS_URI)

(def *-feature-secure-processing
  "Static Constant.

  Feature for secure processing.



       true instructs the implementation to process XML securely.
       This may set limits on XML constructs to avoid conditions such as denial of service attacks.


       false instructs the implementation to process XML in accordance with the XML specifications
       ignoring security issues such as limits on XML constructs to avoid conditions such as denial of service attacks.

  type: java.lang.String"
  XMLConstants/FEATURE_SECURE_PROCESSING)

(def *-access-external-dtd
  "Static Constant.

  Property: accessExternalDTD


   Restrict access to external DTDs and external Entity References to the protocols specified.
   If access is denied due to the restriction of this property, a runtime exception that
   is specific to the context is thrown. In the case of SAXParser
   for example, SAXException is thrown.



   Value:  a list of protocols separated by comma. A protocol is the scheme portion of a
   URI, or in the case of the JAR protocol, `jar` plus the scheme portion
   separated by colon.
   A scheme is defined as:


   scheme = alpha *( alpha | digit | `+` | `-` | `.` )
   where alpha = a-z and A-Z.

   And the JAR protocol:

   jar[:scheme]

   Protocols including the keyword `jar` are case-insensitive. Any whitespaces as defined by
   Character.isSpaceChar(char) in the value will be ignored.
   Examples of protocols are file, http, jar:file.





   Default value: The default value is implementation specific and therefore not specified.
   The following options are provided for consideration:


       an empty string to deny all access to external references;
       a specific protocol, such as file, to give permission to only the protocol;
       the keyword `all` to grant  permission to all protocols.

        When FEATURE_SECURE_PROCESSING is enabled,  it is recommended that implementations
        restrict external connections by default, though this may cause problems for applications
        that process XML/XSD/XSL with external references.




   Granting all access:  the keyword `all` grants permission to all protocols.


   System Property: The value of this property can be set or overridden by
   system property javax.xml.accessExternalDTD.



   ${JAVA_HOME}/lib/jaxp.properties: This configuration file is in standard
   Properties format. If the file exists and the system property is specified,
   its value will be used to override the default of the property.

  type: java.lang.String"
  XMLConstants/ACCESS_EXTERNAL_DTD)

(def *-access-external-schema
  "Static Constant.

  Property: accessExternalSchema


   Restrict access to the protocols specified for external reference set by the
   schemaLocation attribute, Import and Include element. If access is denied
   due to the restriction of this property, a runtime exception that is specific
   to the context is thrown. In the case of SchemaFactory
   for example, org.xml.sax.SAXException is thrown.


   Value: a list of protocols separated by comma. A protocol is the scheme portion of a
   URI, or in the case of the JAR protocol, `jar` plus the scheme portion
   separated by colon.
   A scheme is defined as:


   scheme = alpha *( alpha | digit | `+` | `-` | `.` )
   where alpha = a-z and A-Z.

   And the JAR protocol:

   jar[:scheme]

   Protocols including the keyword `jar` are case-insensitive. Any whitespaces as defined by
   Character.isSpaceChar(char) in the value will be ignored.
   Examples of protocols are file, http, jar:file.





   Default value: The default value is implementation specific and therefore not specified.
   The following options are provided for consideration:


       an empty string to deny all access to external references;
       a specific protocol, such as file, to give permission to only the protocol;
       the keyword `all` to grant  permission to all protocols.

        When FEATURE_SECURE_PROCESSING is enabled,  it is recommended that implementations
        restrict external connections by default, though this may cause problems for applications
        that process XML/XSD/XSL with external references.



   Granting all access:  the keyword `all` grants permission to all protocols.



   System Property: The value of this property can be set or overridden by
   system property javax.xml.accessExternalSchema



   ${JAVA_HOME}/lib/jaxp.properties: This configuration file is in standard
   java.util.Properties format. If the file exists and the system property is specified,
   its value will be used to override the default of the property.

  type: java.lang.String"
  XMLConstants/ACCESS_EXTERNAL_SCHEMA)

(def *-access-external-stylesheet
  "Static Constant.

  Property: accessExternalStylesheet


   Restrict access to the protocols specified for external references set by the
   stylesheet processing instruction, Import and Include element, and document function.
   If access is denied due to the restriction of this property, a runtime exception
   that is specific to the context is thrown. In the case of constructing new
   Transformer for example,
   TransformerConfigurationException
   will be thrown by the TransformerFactory.


   Value: a list of protocols separated by comma. A protocol is the scheme portion of a
   URI, or in the case of the JAR protocol, `jar` plus the scheme portion
   separated by colon.
   A scheme is defined as:


   scheme = alpha *( alpha | digit | `+` | `-` | `.` )
   where alpha = a-z and A-Z.

   And the JAR protocol:

   jar[:scheme]

   Protocols including the keyword `jar` are case-insensitive. Any whitespaces as defined by
   Character.isSpaceChar(char) in the value will be ignored.
   Examples of protocols are file, http, jar:file.





   Default value: The default value is implementation specific and therefore not specified.
   The following options are provided for consideration:


       an empty string to deny all access to external references;
       a specific protocol, such as file, to give permission to only the protocol;
       the keyword `all` to grant  permission to all protocols.

        When FEATURE_SECURE_PROCESSING is enabled,  it is recommended that implementations
        restrict external connections by default, though this may cause problems for applications
        that process XML/XSD/XSL with external references.



   Granting all access:  the keyword `all` grants permission to all protocols.



   System Property: The value of this property can be set or overridden by
   system property javax.xml.accessExternalStylesheet



   ${JAVA_HOME}/lib/jaxp.properties:  This configuration file is in standard
   java.util.Properties format. If the file exists and the system property is specified,
   its value will be used to override the default of the property.

  type: java.lang.String"
  XMLConstants/ACCESS_EXTERNAL_STYLESHEET)

