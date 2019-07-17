(ns javax.xml.transform.dom.DOMResult
  "Acts as a holder for a transformation result tree in the form of a Document Object Model (DOM) tree.

  If no output DOM source is set, the transformation will create a Document node as the holder for the result of the transformation,
  which may be retrieved with getNode()."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform.dom DOMResult]))

(defn ->dom-result
  "Constructor.

  Use a DOM node to create a new output target specifying the child node where the result nodes should be inserted before and
   the specified System ID.

   In practice, node and nextSibling should be
   a Document node,
   a DocumentFragment node, or a
   Element node.
   In other words, a node that accepts children.

   Use nextSibling to specify the child node
   where the result nodes should be inserted before.
   If nextSibling is not a sibling of node,
   then an IllegalArgumentException is thrown.
   If node is null and nextSibling is not null,
   then an IllegalArgumentException is thrown.
   If nextSibling is null,
   then the behavior is the same as calling DOMResult(Node node, String systemId),
   i.e. append the result nodes as the last child of the specified node and use the specified System ID.

  node - The DOM node that will contain the result tree. - `org.w3c.dom.Node`
  next-sibling - The child node where the result nodes should be inserted before. - `org.w3c.dom.Node`
  system-id - The system identifier which may be used in association with this node. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - If nextSibling is not a sibling of node or node is null and nextSibling is not null."
  ([^org.w3c.dom.Node node ^org.w3c.dom.Node next-sibling ^java.lang.String system-id]
    (new DOMResult node next-sibling system-id))
  ([^org.w3c.dom.Node node ^java.lang.String system-id]
    (new DOMResult node system-id))
  ([^org.w3c.dom.Node node]
    (new DOMResult node))
  ([]
    (new DOMResult )))

(def *-feature
  "Static Constant.

  If TransformerFactory.getFeature(java.lang.String)
   returns true when passed this value as an argument,
   the Transformer supports Result output of this type.

  type: java.lang.String"
  DOMResult/FEATURE)

(defn set-node
  "Set the node that will contain the result DOM tree.

   In practice, the node should be
   a Document node,
   a DocumentFragment node, or
   a Element node.
   In other words, a node that accepts children.

   An IllegalStateException is thrown if
   nextSibling is not null and
   node is not a parent of nextSibling.
   An IllegalStateException is thrown if node is null and
   nextSibling is not null.

  node - The node to which the transformation will be appended. - `org.w3c.dom.Node`

  throws: java.lang.IllegalStateException - If nextSibling is not null and nextSibling is not a child of node or node is null and nextSibling is not null."
  ([^javax.xml.transform.dom.DOMResult this ^org.w3c.dom.Node node]
    (-> this (.setNode node))))

(defn get-node
  "Get the node that will contain the result DOM tree.

   If no node was set via
   DOMResult(Node node),
   DOMResult(Node node, String systeId),
   DOMResult(Node node, Node nextSibling),
   DOMResult(Node node, Node nextSibling, String systemId) or
   setNode(Node node),
   then the node will be set by the transformation, and may be obtained from this method once the transformation is complete.
   Calling this method before the transformation will return null.

  returns: The node to which the transformation will be appended. - `org.w3c.dom.Node`"
  (^org.w3c.dom.Node [^javax.xml.transform.dom.DOMResult this]
    (-> this (.getNode))))

(defn set-next-sibling
  "Set the child node before which the result nodes will be inserted.

   Use nextSibling to specify the child node
   before which the result nodes should be inserted.
   If nextSibling is not a descendant of node,
   then an IllegalArgumentException is thrown.
   If node is null and nextSibling is not null,
   then an IllegalStateException is thrown.
   If nextSibling is null,
   then the behavior is the same as calling DOMResult(Node node),
   i.e. append the result nodes as the last child of the specified node.

  next-sibling - The child node before which the result nodes will be inserted. - `org.w3c.dom.Node`

  throws: java.lang.IllegalArgumentException - If nextSibling is not a descendant of node."
  ([^javax.xml.transform.dom.DOMResult this ^org.w3c.dom.Node next-sibling]
    (-> this (.setNextSibling next-sibling))))

(defn get-next-sibling
  "Get the child node before which the result nodes will be inserted.

   If no node was set via
   DOMResult(Node node, Node nextSibling),
   DOMResult(Node node, Node nextSibling, String systemId) or
   setNextSibling(Node nextSibling),
   then null will be returned.

  returns: The child node before which the result nodes will be inserted. - `org.w3c.dom.Node`"
  (^org.w3c.dom.Node [^javax.xml.transform.dom.DOMResult this]
    (-> this (.getNextSibling))))

(defn set-system-id
  "Set the systemId that may be used in association with the node.

  system-id - The system identifier as a URI string. - `java.lang.String`"
  ([^javax.xml.transform.dom.DOMResult this ^java.lang.String system-id]
    (-> this (.setSystemId system-id))))

(defn get-system-id
  "Get the System Identifier.

   If no System ID was set via
   DOMResult(Node node, String systemId),
   DOMResult(Node node, Node nextSibling, String systemId) or
   setSystemId(String systemId),
   then null will be returned.

  returns: The system identifier. - `java.lang.String`"
  (^java.lang.String [^javax.xml.transform.dom.DOMResult this]
    (-> this (.getSystemId))))

