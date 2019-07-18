(ns javax.xml.crypto.dom.DOMStructure
  "A DOM-specific XMLStructure. The purpose of this class is to
  allow a DOM node to be used to represent extensible content (any elements
  or mixed content) in XML Signature structures.

  If a sequence of nodes is needed, the node contained in the
  DOMStructure is the first node of the sequence and successive
  nodes can be accessed by invoking Node.getNextSibling().

  If the owner document of the DOMStructure is different than
  the target document of an XMLSignature, the
  XMLSignature.sign(XMLSignContext) method imports the node into the
  target document before generating the signature."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dom DOMStructure]))

(defn ->dom-structure
  "Constructor.

  Creates a DOMStructure containing the specified node.

  node - the node - `org.w3c.dom.Node`

  throws: java.lang.NullPointerException - if node is null"
  (^DOMStructure [^org.w3c.dom.Node node]
    (new DOMStructure node)))

(defn get-node
  "Returns the node contained in this DOMStructure.

  returns: the node - `org.w3c.dom.Node`"
  (^org.w3c.dom.Node [^DOMStructure this]
    (-> this (.getNode))))

(defn feature-supported?
  "Description copied from interface: XMLStructure

  feature - the feature name (as an absolute URI) - `java.lang.String`

  returns: true if the specified feature is supported,
      false otherwise - `boolean`

  throws: java.lang.NullPointerException - if feature is null"
  (^Boolean [^DOMStructure this ^java.lang.String feature]
    (-> this (.isFeatureSupported feature))))

