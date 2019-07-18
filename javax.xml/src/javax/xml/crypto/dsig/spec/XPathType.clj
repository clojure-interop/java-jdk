(ns javax.xml.crypto.dsig.spec.XPathType
  "The XML Schema Definition of the XPath element as defined in the

  W3C Recommendation for XML-Signature XPath Filter 2.0:


  <schema xmlns=`http://www.w3.org/2001/XMLSchema`
          xmlns:xf=`http://www.w3.org/2002/06/xmldsig-filter2`
          targetNamespace=`http://www.w3.org/2002/06/xmldsig-filter2`
          version=`0.1` elementFormDefault=`qualified`>

  <element name=`XPath`
           type=`xf:XPathType`/>

  <complexType name=`XPathType`>
    <simpleContent>
      <extension base=`string`>
        <attribute name=`Filter`>
          <simpleType>
            <restriction base=`string`>
              <enumeration value=`intersect`/>
              <enumeration value=`subtract`/>
              <enumeration value=`union`/>
            </restriction>
          </simpleType>
        </attribute>
      </extension>
    </simpleContent>
  </complexType>"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig.spec XPathType]))

(defn ->x-path-type
  "Constructor.

  Creates an XPathType instance with the specified XPath
   expression, filter, and namespace map. The map is copied to protect
   against subsequent modification.

  expression - the XPath expression to be evaluated - `java.lang.String`
  filter - the filter operation (XPathType.Filter.INTERSECT, XPathType.Filter.SUBTRACT, or XPathType.Filter.UNION) - `javax.xml.crypto.dsig.spec.XPathType$Filter`
  namespace-map - the map of namespace prefixes. Each key is a namespace prefix String that maps to a corresponding namespace URI String. - `java.util.Map`

  throws: java.lang.NullPointerException - if expression, filter or namespaceMap are null"
  (^XPathType [^java.lang.String expression ^javax.xml.crypto.dsig.spec.XPathType$Filter filter ^java.util.Map namespace-map]
    (new XPathType expression filter namespace-map))
  (^XPathType [^java.lang.String expression ^javax.xml.crypto.dsig.spec.XPathType$Filter filter]
    (new XPathType expression filter)))

(defn get-expression
  "Returns the XPath expression to be evaluated.

  returns: the XPath expression to be evaluated - `java.lang.String`"
  (^java.lang.String [^XPathType this]
    (-> this (.getExpression))))

(defn get-filter
  "Returns the filter operation.

  returns: the filter operation - `javax.xml.crypto.dsig.spec.XPathType$Filter`"
  (^javax.xml.crypto.dsig.spec.XPathType$Filter [^XPathType this]
    (-> this (.getFilter))))

(defn get-namespace-map
  "Returns a map of namespace prefixes. Each key is a namespace prefix
   String that maps to a corresponding namespace URI
   String.

   This implementation returns an unmodifiable map.

  returns: a Map of namespace prefixes to namespace URIs
      (may be empty, but never null) - `java.util.Map`"
  (^java.util.Map [^XPathType this]
    (-> this (.getNamespaceMap))))

