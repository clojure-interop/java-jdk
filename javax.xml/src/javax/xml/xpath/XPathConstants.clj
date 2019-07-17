(ns javax.xml.xpath.XPathConstants
  "XPath constants."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.xpath XPathConstants]))

(def *-number
  "Static Constant.

  The XPath 1.0 number data type.

   Maps to Java Double.

  type: javax.xml.namespace.QName"
  XPathConstants/NUMBER)

(def *-string
  "Static Constant.

  The XPath 1.0 string data type.

   Maps to Java String.

  type: javax.xml.namespace.QName"
  XPathConstants/STRING)

(def *-boolean
  "Static Constant.

  The XPath 1.0 boolean data type.

   Maps to Java Boolean.

  type: javax.xml.namespace.QName"
  XPathConstants/BOOLEAN)

(def *-nodeset
  "Static Constant.

  The XPath 1.0 NodeSet data type.

   Maps to Java NodeList.

  type: javax.xml.namespace.QName"
  XPathConstants/NODESET)

(def *-node
  "Static Constant.

  The XPath 1.0 NodeSet data type.

   Maps to Java Node.

  type: javax.xml.namespace.QName"
  XPathConstants/NODE)

(def *-dom-object-model
  "Static Constant.

  The URI for the DOM object model, `http://java.sun.com/jaxp/xpath/dom`.

  type: java.lang.String"
  XPathConstants/DOM_OBJECT_MODEL)

