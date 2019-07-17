(ns javax.xml.crypto.dsig.spec.XPathFilter2ParameterSpec
  "Parameters for the W3C Recommendation

  XPath Filter 2.0 Transform Algorithm.
  The parameters include a list of one or more XPathType objects."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig.spec XPathFilter2ParameterSpec]))

(defn ->x-path-filter-2-parameter-spec
  "Constructor.

  Creates an XPathFilter2ParameterSpec.

  x-path-list - a list of one or more XPathType objects. The list is defensively copied to protect against subsequent modification. - `java.util.List`

  throws: java.lang.ClassCastException - if xPathList contains any entries that are not of type XPathType"
  ([^java.util.List x-path-list]
    (new XPathFilter2ParameterSpec x-path-list)))

(defn get-x-path-list
  "Returns a list of one or more XPathType objects.

   This implementation returns an unmodifiable list.

  returns: a List of XPathType objects
      (never null or empty) - `java.util.List`"
  (^java.util.List [^javax.xml.crypto.dsig.spec.XPathFilter2ParameterSpec this]
    (-> this (.getXPathList))))

