(ns javax.xml.crypto.dsig.spec.XPathFilterParameterSpec
  "Parameters for the
  XPath Filtering Transform Algorithm.
  The parameters include the XPath expression and an optional Map
  of additional namespace prefix mappings. The XML Schema Definition of
  the XPath Filtering transform parameters is defined as:


  <element name=\"XPath\" type=\"string\"/>"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig.spec XPathFilterParameterSpec]))

(defn ->x-path-filter-parameter-spec
  "Constructor.

  Creates an XPathFilterParameterSpec with the specified
   XPath expression and namespace map. The map is copied to protect against
   subsequent modification.

  x-path - the XPath expression to be evaluated - `java.lang.String`
  namespace-map - the map of namespace prefixes. Each key is a namespace prefix String that maps to a corresponding namespace URI String. - `java.util.Map`

  throws: java.lang.NullPointerException - if xPath or namespaceMap are null"
  (^XPathFilterParameterSpec [^java.lang.String x-path ^java.util.Map namespace-map]
    (new XPathFilterParameterSpec x-path namespace-map))
  (^XPathFilterParameterSpec [^java.lang.String x-path]
    (new XPathFilterParameterSpec x-path)))

(defn get-x-path
  "Returns the XPath expression to be evaluated.

  returns: the XPath expression to be evaluated - `java.lang.String`"
  (^java.lang.String [^XPathFilterParameterSpec this]
    (-> this (.getXPath))))

(defn get-namespace-map
  "Returns a map of namespace prefixes. Each key is a namespace prefix
   String that maps to a corresponding namespace URI
   String.

   This implementation returns an unmodifiable map.

  returns: a Map of namespace prefixes to namespace URIs (may
      be empty, but never null) - `java.util.Map`"
  (^java.util.Map [^XPathFilterParameterSpec this]
    (-> this (.getNamespaceMap))))

