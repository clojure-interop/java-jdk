(ns javax.xml.crypto.dsig.spec.ExcC14NParameterSpec
  "Parameters for the W3C Recommendation:

  Exclusive XML Canonicalization (C14N) algorithm. The
  parameters include an optional inclusive namespace prefix list. The XML
  Schema Definition of the Exclusive XML Canonicalization parameters is
  defined as:


  <schema xmlns=`http://www.w3.org/2001/XMLSchema`
          xmlns:ec=`http://www.w3.org/2001/10/xml-exc-c14n#`
          targetNamespace=`http://www.w3.org/2001/10/xml-exc-c14n#`
          version=`0.1` elementFormDefault=`qualified`>

  <element name=`InclusiveNamespaces` type=`ec:InclusiveNamespaces`/>
  <complexType name=`InclusiveNamespaces`>
    <attribute name=`PrefixList` type=`xsd:string`/>
  </complexType>
  </schema>"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig.spec ExcC14NParameterSpec]))

(defn ->exc-c-14-n-parameter-spec
  "Constructor.

  Creates a ExcC14NParameterSpec with the specified list
   of prefixes. The list is copied to protect against subsequent
   modification.

  prefix-list - the inclusive namespace prefix list. Each entry in the list is a String that represents a namespace prefix. - `java.util.List`

  throws: java.lang.NullPointerException - if prefixList is null"
  ([^java.util.List prefix-list]
    (new ExcC14NParameterSpec prefix-list))
  ([]
    (new ExcC14NParameterSpec )))

(def *-default
  "Static Constant.

  Indicates the default namespace (`#default`).

  type: java.lang.String"
  ExcC14NParameterSpec/DEFAULT)

(defn get-prefix-list
  "Returns the inclusive namespace prefix list. Each entry in the list
   is a String that represents a namespace prefix.

   This implementation returns an unmodifiable list.

  returns: the inclusive namespace prefix list (may be empty but never
      null) - `java.util.List`"
  (^java.util.List [^javax.xml.crypto.dsig.spec.ExcC14NParameterSpec this]
    (-> this (.getPrefixList))))

