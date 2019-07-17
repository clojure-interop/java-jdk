(ns javax.imageio.metadata.IIOMetadataNode
  "A class representing a node in a meta-data tree, which implements
  the
  org.w3c.dom.Element interface and additionally allows
  for the storage of non-textual objects via the
  getUserObject and setUserObject methods.

   This class is not intended to be used for general XML
  processing. In particular, Element nodes created
  within the Image I/O API are not compatible with those created by
  Sun's standard implementation of the org.w3.dom API.
  In particular, the implementation is tuned for simple uses and may
  not perform well for intensive processing.

   Namespaces are ignored in this implementation.  The terms `tag
  name` and `node name` are always considered to be synonymous.

  Note:
  The DOM Level 3 specification added a number of new methods to the
  Node, Element and Attr interfaces that are not
  of value to the IIOMetadataNode implementation or specification.

  Calling such methods on an IIOMetadataNode, or an Attr
  instance returned from an IIOMetadataNode will result in a
  DOMException being thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.metadata IIOMetadataNode]))

(defn ->iio-metadata-node
  "Constructor.

  Constructs an IIOMetadataNode with a given node
   name.

  node-name - the name of the node, as a String. - `java.lang.String`"
  ([^java.lang.String node-name]
    (new IIOMetadataNode node-name))
  ([]
    (new IIOMetadataNode )))

(defn get-attribute-node-ns
  "Equivalent to getAttributeNode(localName).

  namespace-uri - The namespace URI of the attribute to retrieve. - `java.lang.String`
  local-name - The local name of the attribute to retrieve. - `java.lang.String`

  returns: The Attr node with the specified attribute local
     name and namespace URI or null if there is no such
     attribute. - `org.w3c.dom.Attr`"
  (^org.w3c.dom.Attr [^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String namespace-uri ^java.lang.String local-name]
    (-> this (.getAttributeNodeNS namespace-uri local-name))))

(defn get-node-value
  "Returns the value associated with this node.

  returns: the node value, as a String. - `java.lang.String`"
  (^java.lang.String [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.getNodeValue))))

(defn set-prefix
  "Does nothing, since namespaces are not supported.

  prefix - a String, which is ignored. - `java.lang.String`"
  ([^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String prefix]
    (-> this (.setPrefix prefix))))

(defn get-elements-by-tag-name
  "Description copied from interface: Element

  name - The name of the tag to match on. The special value `*` matches all tags. - `java.lang.String`

  returns: A list of matching Element nodes. - `org.w3c.dom.NodeList`"
  (^org.w3c.dom.NodeList [^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String name]
    (-> this (.getElementsByTagName name))))

(defn get-owner-document
  "Returns null, since IIOMetadataNodes
   do not belong to any Document.

  returns: null. - `org.w3c.dom.Document`"
  (^org.w3c.dom.Document [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.getOwnerDocument))))

(defn set-user-object
  "Sets the value associated with this node.

  user-object - the user Object. - `java.lang.Object`"
  ([^javax.imageio.metadata.IIOMetadataNode this ^java.lang.Object user-object]
    (-> this (.setUserObject user-object))))

(defn get-schema-type-info
  "This DOM Level 3 method is not supported for IIOMetadataNode
   and will throw a DOMException.

  returns: `org.w3c.dom.TypeInfo`

  throws: org.w3c.dom.DOMException - - always."
  (^org.w3c.dom.TypeInfo [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.getSchemaTypeInfo))))

(defn get-attribute-ns
  "Equivalent to getAttribute(localName).

  namespace-uri - The namespace URI of the attribute to retrieve. - `java.lang.String`
  local-name - The local name of the attribute to retrieve. - `java.lang.String`

  returns: The Attr value as a string, or the empty string
     if that attribute does not have a specified or default value. - `java.lang.String`"
  (^java.lang.String [^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String namespace-uri ^java.lang.String local-name]
    (-> this (.getAttributeNS namespace-uri local-name))))

(defn get-feature
  "This DOM Level 3 method is not supported for IIOMetadataNode
   and will throw a DOMException.

  feature - The name of the feature requested. Note that any plus sign `+` prepended to the name of the feature will be ignored since it is not significant in the context of this method. - `java.lang.String`
  version - This is the version number of the feature to test. - `java.lang.String`

  returns: Returns an object which implements the specialized APIs of
     the specified feature and version, if any, or null if
     there is no object which implements interfaces associated with that
     feature. If the DOMObject returned by this method
     implements the Node interface, it must delegate to the
     primary core Node and not return results inconsistent
     with the primary core Node such as attributes,
     childNodes, etc. - `java.lang.Object`

  throws: org.w3c.dom.DOMException - - always."
  (^java.lang.Object [^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String feature ^java.lang.String version]
    (-> this (.getFeature feature version))))

(defn get-namespace-uri
  "Returns null, since namespaces are not supported.

  returns: `java.lang.String`

  throws: org.w3c.dom.DOMException"
  (^java.lang.String [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.getNamespaceURI))))

(defn normalize
  "Does nothing, since IIOMetadataNodes do not
   contain Text children."
  ([^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.normalize))))

(defn set-text-content
  "This DOM Level 3 method is not supported for IIOMetadataNode
   and will throw a DOMException.

  text-content - `java.lang.String`

  throws: org.w3c.dom.DOMException - - always."
  ([^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String text-content]
    (-> this (.setTextContent text-content))))

(defn set-id-attribute-ns
  "This DOM Level 3 method is not supported for IIOMetadataNode
   and will throw a DOMException.

  namespace-uri - The namespace URI of the attribute. - `java.lang.String`
  local-name - The local name of the attribute. - `java.lang.String`
  is-id - Whether the attribute is a of type ID. - `boolean`

  throws: org.w3c.dom.DOMException - - always."
  ([^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String namespace-uri ^java.lang.String local-name ^Boolean is-id]
    (-> this (.setIdAttributeNS namespace-uri local-name is-id))))

(defn get-parent-node
  "Returns the parent of this node.  A null value
   indicates that the node is the root of its own tree.  To add a
   node to an existing tree, use one of the
   insertBefore, replaceChild, or
   appendChild methods.

  returns: the parent, as a Node. - `org.w3c.dom.Node`"
  (^org.w3c.dom.Node [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.getParentNode))))

(defn get-attribute-node
  "Description copied from interface: Element

  name - The name (nodeName) of the attribute to retrieve. - `java.lang.String`

  returns: The Attr node with the specified name (
     nodeName) or null if there is no such
     attribute. - `org.w3c.dom.Attr`"
  (^org.w3c.dom.Attr [^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String name]
    (-> this (.getAttributeNode name))))

(defn set-attribute-ns
  "Equivalent to setAttribute(qualifiedName, value).

  namespace-uri - The namespace URI of the attribute to create or alter. - `java.lang.String`
  qualified-name - The qualified name of the attribute to create or alter. - `java.lang.String`
  value - The value to set in string form. - `java.lang.String`"
  ([^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String namespace-uri ^java.lang.String qualified-name ^java.lang.String value]
    (-> this (.setAttributeNS namespace-uri qualified-name value))))

(defn set-id-attribute
  "This DOM Level 3 method is not supported for IIOMetadataNode
   and will throw a DOMException.

  name - The name of the attribute. - `java.lang.String`
  is-id - Whether the attribute is a of type ID. - `boolean`

  throws: org.w3c.dom.DOMException - - always."
  ([^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String name ^Boolean is-id]
    (-> this (.setIdAttribute name is-id))))

(defn append-child
  "Adds the node newChild to the end of the list of
   children of this node.

  new-child - the Node to insert. - `org.w3c.dom.Node`

  returns: the node added. - `org.w3c.dom.Node`

  throws: java.lang.IllegalArgumentException - if newChild is null."
  (^org.w3c.dom.Node [^javax.imageio.metadata.IIOMetadataNode this ^org.w3c.dom.Node new-child]
    (-> this (.appendChild new-child))))

(defn remove-attribute-ns
  "Equivalent to removeAttribute(localName).

  namespace-uri - The namespace URI of the attribute to remove. - `java.lang.String`
  local-name - The local name of the attribute to remove. - `java.lang.String`"
  ([^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String namespace-uri ^java.lang.String local-name]
    (-> this (.removeAttributeNS namespace-uri local-name))))

(defn get-user-data
  "This DOM Level 3 method is not supported for IIOMetadataNode
   and will throw a DOMException.

  key - The key the object is associated to. - `java.lang.String`

  returns: Returns the DOMUserData associated to the given
     key on this node, or null if there was none. - `java.lang.Object`

  throws: org.w3c.dom.DOMException - - always."
  (^java.lang.Object [^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String key]
    (-> this (.getUserData key))))

(defn get-node-type
  "Returns the node type, which is always
   ELEMENT_NODE.

  returns: the short value ELEMENT_NODE. - `short`"
  (^Short [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.getNodeType))))

(defn get-text-content
  "This DOM Level 3 method is not supported for IIOMetadataNode
   and will throw a DOMException.

  returns: `java.lang.String`

  throws: org.w3c.dom.DOMException - - always."
  (^java.lang.String [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.getTextContent))))

(defn get-next-sibling
  "Returns the next sibling of this node, or null if
   the node has no next sibling.

  returns: the next sibling, as a Node, or
   null. - `org.w3c.dom.Node`"
  (^org.w3c.dom.Node [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.getNextSibling))))

(defn has-attributes?
  "Description copied from interface: Node

  returns: Returns true if this node has any attributes,
     false otherwise. - `boolean`"
  (^Boolean [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.hasAttributes))))

(defn replace-child
  "Replaces the child node oldChild with
   newChild in the list of children, and returns the
   oldChild node.

  new-child - the Node to insert. - `org.w3c.dom.Node`
  old-child - the Node to be replaced. - `org.w3c.dom.Node`

  returns: the node replaced. - `org.w3c.dom.Node`

  throws: java.lang.IllegalArgumentException - if newChild is null."
  (^org.w3c.dom.Node [^javax.imageio.metadata.IIOMetadataNode this ^org.w3c.dom.Node new-child ^org.w3c.dom.Node old-child]
    (-> this (.replaceChild new-child old-child))))

(defn get-last-child
  "Returns the last child of this node, or null if
   the node has no children.

  returns: the last child, as a Node, or
   null. - `org.w3c.dom.Node`"
  (^org.w3c.dom.Node [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.getLastChild))))

(defn get-attribute
  "Retrieves an attribute value by name.

  name - The name of the attribute to retrieve. - `java.lang.String`

  returns: The Attr value as a string, or the empty string
   if that attribute does not have a specified or default value. - `java.lang.String`"
  (^java.lang.String [^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String name]
    (-> this (.getAttribute name))))

(defn insert-before
  "Inserts the node newChild before the existing
   child node refChild. If refChild is
   null, insert newChild at the end of
   the list of children.

  new-child - the Node to insert. - `org.w3c.dom.Node`
  ref-child - the reference Node. - `org.w3c.dom.Node`

  returns: the node being inserted. - `org.w3c.dom.Node`

  throws: java.lang.IllegalArgumentException - if newChild is null."
  (^org.w3c.dom.Node [^javax.imageio.metadata.IIOMetadataNode this ^org.w3c.dom.Node new-child ^org.w3c.dom.Node ref-child]
    (-> this (.insertBefore new-child ref-child))))

(defn set-id-attribute-node
  "This DOM Level 3 method is not supported for IIOMetadataNode
   and will throw a DOMException.

  id-attr - The attribute node. - `org.w3c.dom.Attr`
  is-id - Whether the attribute is a of type ID. - `boolean`

  throws: org.w3c.dom.DOMException - - always."
  ([^javax.imageio.metadata.IIOMetadataNode this ^org.w3c.dom.Attr id-attr ^Boolean is-id]
    (-> this (.setIdAttributeNode id-attr is-id))))

(defn get-elements-by-tag-name-ns
  "Equivalent to getElementsByTagName(localName).

  namespace-uri - The namespace URI of the elements to match on. The special value `*` matches all namespaces. - `java.lang.String`
  local-name - The local name of the elements to match on. The special value `*` matches all local names. - `java.lang.String`

  returns: A new NodeList object containing all the matched
     Elements. - `org.w3c.dom.NodeList`"
  (^org.w3c.dom.NodeList [^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String namespace-uri ^java.lang.String local-name]
    (-> this (.getElementsByTagNameNS namespace-uri local-name))))

(defn has-attribute-ns?
  "Equivalent to hasAttribute(localName).

  namespace-uri - The namespace URI of the attribute to look for. - `java.lang.String`
  local-name - The local name of the attribute to look for. - `java.lang.String`

  returns: true if an attribute with the given local name
     and namespace URI is specified or has a default value on this
     element, false otherwise. - `boolean`"
  (^Boolean [^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String namespace-uri ^java.lang.String local-name]
    (-> this (.hasAttributeNS namespace-uri local-name))))

(defn remove-attribute
  "Description copied from interface: Element

  name - The name of the attribute to remove. - `java.lang.String`"
  ([^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String name]
    (-> this (.removeAttribute name))))

(defn lookup-namespace-uri
  "This DOM Level 3 method is not supported for IIOMetadataNode
   and will throw a DOMException.

  prefix - The prefix to look for. If this parameter is null, the method will return the default namespace URI if any. - `java.lang.String`

  returns: Returns the associated namespace URI or null if
     none is found. - `java.lang.String`

  throws: org.w3c.dom.DOMException - - always."
  (^java.lang.String [^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String prefix]
    (-> this (.lookupNamespaceURI prefix))))

(defn get-node-name
  "Returns the node name associated with this node.

  returns: the node name, as a String. - `java.lang.String`"
  (^java.lang.String [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.getNodeName))))

(defn item
  "Description copied from interface: NodeList

  index - Index into the collection. - `int`

  returns: The node at the indexth position in the
     NodeList, or null if that is not a valid
     index. - `org.w3c.dom.Node`"
  (^org.w3c.dom.Node [^javax.imageio.metadata.IIOMetadataNode this ^Integer index]
    (-> this (.item index))))

(defn get-base-uri
  "This DOM Level 3 method is not supported for IIOMetadataNode
   and will throw a DOMException.

  returns: `java.lang.String`

  throws: org.w3c.dom.DOMException - - always."
  (^java.lang.String [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.getBaseURI))))

(defn set-attribute
  "Description copied from interface: Element

  name - The name of the attribute to create or alter. - `java.lang.String`
  value - Value to set in string form. - `java.lang.String`"
  ([^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String name ^java.lang.String value]
    (-> this (.setAttribute name value))))

(defn compare-document-position
  "This DOM Level 3 method is not supported for IIOMetadataNode
   and will throw a DOMException.

  other - The node to compare against the reference node. - `org.w3c.dom.Node`

  returns: Returns how the node is positioned relatively to the reference
     node. - `short`

  throws: org.w3c.dom.DOMException - - always."
  (^Short [^javax.imageio.metadata.IIOMetadataNode this ^org.w3c.dom.Node other]
    (-> this (.compareDocumentPosition other))))

(defn get-length
  "Description copied from interface: NodeList

  returns: `int`"
  (^Integer [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.getLength))))

(defn default-namespace?
  "This DOM Level 3 method is not supported for IIOMetadataNode
   and will throw a DOMException.

  namespace-uri - The namespace URI to look for. - `java.lang.String`

  returns: Returns true if the specified
     namespaceURI is the default namespace,
     false otherwise. - `boolean`

  throws: org.w3c.dom.DOMException - - always."
  (^Boolean [^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String namespace-uri]
    (-> this (.isDefaultNamespace namespace-uri))))

(defn get-child-nodes
  "Returns a NodeList that contains all children of this node.
   If there are no children, this is a NodeList containing
   no nodes.

  returns: the children as a NodeList - `org.w3c.dom.NodeList`"
  (^org.w3c.dom.NodeList [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.getChildNodes))))

(defn lookup-prefix
  "This DOM Level 3 method is not supported for IIOMetadataNode
   and will throw a DOMException.

  namespace-uri - The namespace URI to look for. - `java.lang.String`

  returns: Returns an associated namespace prefix if found or
     null if none is found. If more than one prefix are
     associated to the namespace prefix, the returned namespace prefix
     is implementation dependent. - `java.lang.String`

  throws: org.w3c.dom.DOMException - - always."
  (^java.lang.String [^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String namespace-uri]
    (-> this (.lookupPrefix namespace-uri))))

(defn get-previous-sibling
  "Returns the previous sibling of this node, or null
   if this node has no previous sibling.

  returns: the previous sibling, as a Node, or
   null. - `org.w3c.dom.Node`"
  (^org.w3c.dom.Node [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.getPreviousSibling))))

(defn supported?
  "Returns false since DOM features are not
   supported.

  feature - a String, which is ignored. - `java.lang.String`
  version - a String, which is ignored. - `java.lang.String`

  returns: false. - `boolean`"
  (^Boolean [^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String feature ^java.lang.String version]
    (-> this (.isSupported feature version))))

(defn remove-attribute-node
  "Description copied from interface: Element

  old-attr - The Attr node to remove from the attribute list. - `org.w3c.dom.Attr`

  returns: The Attr node that was removed. - `org.w3c.dom.Attr`"
  (^org.w3c.dom.Attr [^javax.imageio.metadata.IIOMetadataNode this ^org.w3c.dom.Attr old-attr]
    (-> this (.removeAttributeNode old-attr))))

(defn set-attribute-node-ns
  "Equivalent to setAttributeNode(newAttr).

  new-attr - The Attr node to add to the attribute list. - `org.w3c.dom.Attr`

  returns: If the newAttr attribute replaces an existing
     attribute with the same local name and namespace URI, the replaced
     Attr node is returned, otherwise null is
     returned. - `org.w3c.dom.Attr`"
  (^org.w3c.dom.Attr [^javax.imageio.metadata.IIOMetadataNode this ^org.w3c.dom.Attr new-attr]
    (-> this (.setAttributeNodeNS new-attr))))

(defn get-first-child
  "Returns the first child of this node, or null if
   the node has no children.

  returns: the first child, as a Node, or
   null - `org.w3c.dom.Node`"
  (^org.w3c.dom.Node [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.getFirstChild))))

(defn has-attribute?
  "Description copied from interface: Element

  name - The name of the attribute to look for. - `java.lang.String`

  returns: true if an attribute with the given name is
     specified on this element or has a default value, false
      otherwise. - `boolean`"
  (^Boolean [^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String name]
    (-> this (.hasAttribute name))))

(defn has-child-nodes?
  "Returns true if this node has child nodes.

  returns: true if this node has children. - `boolean`"
  (^Boolean [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.hasChildNodes))))

(defn get-prefix
  "Returns null, since namespaces are not supported.

  returns: null. - `java.lang.String`"
  (^java.lang.String [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.getPrefix))))

(defn set-attribute-node
  "Description copied from interface: Element

  new-attr - The Attr node to add to the attribute list. - `org.w3c.dom.Attr`

  returns: If the newAttr attribute replaces an existing
     attribute, the replaced Attr node is returned,
     otherwise null is returned. - `org.w3c.dom.Attr`

  throws: org.w3c.dom.DOMException - WRONG_DOCUMENT_ERR: Raised if newAttr was created from a different document than the one that created the element. NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly. INUSE_ATTRIBUTE_ERR: Raised if newAttr is already an attribute of another Element object. The DOM user must explicitly clone Attr nodes to re-use them in other elements."
  (^org.w3c.dom.Attr [^javax.imageio.metadata.IIOMetadataNode this ^org.w3c.dom.Attr new-attr]
    (-> this (.setAttributeNode new-attr))))

(defn clone-node
  "Returns a duplicate of this node.  The duplicate node has no
   parent (getParentNode returns null).
   If a shallow clone is being performed (deep is
   false), the new node will not have any children or
   siblings.  If a deep clone is being performed, the new node
   will form the root of a complete cloned subtree.

  deep - if true, recursively clone the subtree under the specified node; if false, clone only the node itself. - `boolean`

  returns: the duplicate node. - `org.w3c.dom.Node`"
  (^org.w3c.dom.Node [^javax.imageio.metadata.IIOMetadataNode this ^Boolean deep]
    (-> this (.cloneNode deep))))

(defn remove-child
  "Removes the child node indicated by oldChild from
   the list of children, and returns it.

  old-child - the Node to be removed. - `org.w3c.dom.Node`

  returns: the node removed. - `org.w3c.dom.Node`

  throws: java.lang.IllegalArgumentException - if oldChild is null."
  (^org.w3c.dom.Node [^javax.imageio.metadata.IIOMetadataNode this ^org.w3c.dom.Node old-child]
    (-> this (.removeChild old-child))))

(defn get-local-name
  "Equivalent to getNodeName.

  returns: the node name, as a String. - `java.lang.String`"
  (^java.lang.String [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.getLocalName))))

(defn equal-node?
  "This DOM Level 3 method is not supported for IIOMetadataNode
   and will throw a DOMException.

  node - The node to compare equality with. - `org.w3c.dom.Node`

  returns: Returns true if the nodes are equal,
     false otherwise. - `boolean`

  throws: org.w3c.dom.DOMException - - always."
  (^Boolean [^javax.imageio.metadata.IIOMetadataNode this ^org.w3c.dom.Node node]
    (-> this (.isEqualNode node))))

(defn same-node?
  "This DOM Level 3 method is not supported for IIOMetadataNode
   and will throw a DOMException.

  node - The node to test against. - `org.w3c.dom.Node`

  returns: Returns true if the nodes are the same,
     false otherwise. - `boolean`

  throws: org.w3c.dom.DOMException - - always."
  (^Boolean [^javax.imageio.metadata.IIOMetadataNode this ^org.w3c.dom.Node node]
    (-> this (.isSameNode node))))

(defn get-attributes
  "Returns a NamedNodeMap containing the attributes of
   this node.

  returns: a NamedNodeMap containing the attributes of
   this node. - `org.w3c.dom.NamedNodeMap`"
  (^org.w3c.dom.NamedNodeMap [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.getAttributes))))

(defn set-user-data
  "This DOM Level 3 method is not supported for IIOMetadataNode
   and will throw a DOMException.

  key - The key to associate the object to. - `java.lang.String`
  data - The object to associate to the given key, or null to remove any existing association to that key. - `java.lang.Object`
  handler - The handler to associate to that key, or null. - `org.w3c.dom.UserDataHandler`

  returns: Returns the DOMUserData previously associated to
     the given key on this node, or null if there was none. - `java.lang.Object`

  throws: org.w3c.dom.DOMException - - always."
  (^java.lang.Object [^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String key ^java.lang.Object data ^org.w3c.dom.UserDataHandler handler]
    (-> this (.setUserData key data handler))))

(defn get-tag-name
  "Equivalent to getNodeName.

  returns: the node name, as a String - `java.lang.String`"
  (^java.lang.String [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.getTagName))))

(defn get-user-object
  "Returns the Object value associated with this node.

  returns: the user Object. - `java.lang.Object`"
  (^java.lang.Object [^javax.imageio.metadata.IIOMetadataNode this]
    (-> this (.getUserObject))))

(defn set-node-value
  "Sets the String value associated with this node.

  node-value - `java.lang.String`"
  ([^javax.imageio.metadata.IIOMetadataNode this ^java.lang.String node-value]
    (-> this (.setNodeValue node-value))))

