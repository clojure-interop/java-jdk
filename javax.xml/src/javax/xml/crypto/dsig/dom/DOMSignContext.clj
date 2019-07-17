(ns javax.xml.crypto.dsig.dom.DOMSignContext
  "A DOM-specific XMLSignContext. This class contains additional methods
  to specify the location in a DOM tree where an XMLSignature
  object is to be marshalled when generating the signature.

  Note that DOMSignContext instances can contain
  information and state specific to the XML signature structure it is
  used with. The results are unpredictable if a
  DOMSignContext is used with different signature structures
  (for example, you should not use the same DOMSignContext
  instance to sign two different XMLSignature objects)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig.dom DOMSignContext]))

(defn ->dom-sign-context
  "Constructor.

  Creates a DOMSignContext with the specified signing key,
   parent and next sibling nodes. The signing key is stored in a
   singleton KeySelector that is
   returned by the getKeySelector method.
   The marshalled XMLSignature will be inserted as a child
   element of the specified parent node and immediately before the
   specified next sibling node.

  signing-key - the signing key - `java.security.Key`
  parent - the parent node - `org.w3c.dom.Node`
  next-sibling - the next sibling node - `org.w3c.dom.Node`

  throws: java.lang.NullPointerException - if signingKey, parent or nextSibling is null"
  ([^java.security.Key signing-key ^org.w3c.dom.Node parent ^org.w3c.dom.Node next-sibling]
    (new DOMSignContext signing-key parent next-sibling))
  ([^java.security.Key signing-key ^org.w3c.dom.Node parent]
    (new DOMSignContext signing-key parent)))

(defn set-parent
  "Sets the parent node.

  parent - the parent node. The marshalled XMLSignature will be added as a child element of this node. - `org.w3c.dom.Node`

  throws: java.lang.NullPointerException - if parent is null"
  ([^javax.xml.crypto.dsig.dom.DOMSignContext this ^org.w3c.dom.Node parent]
    (-> this (.setParent parent))))

(defn set-next-sibling
  "Sets the next sibling node.

  next-sibling - the next sibling node. The marshalled XMLSignature will be inserted immediately before this node. Specify null to remove the current setting. - `org.w3c.dom.Node`"
  ([^javax.xml.crypto.dsig.dom.DOMSignContext this ^org.w3c.dom.Node next-sibling]
    (-> this (.setNextSibling next-sibling))))

(defn get-parent
  "Returns the parent node.

  returns: the parent node (never null) - `org.w3c.dom.Node`"
  ([^javax.xml.crypto.dsig.dom.DOMSignContext this]
    (-> this (.getParent))))

(defn get-next-sibling
  "Returns the nextSibling node.

  returns: the nextSibling node, or null if not specified. - `org.w3c.dom.Node`"
  ([^javax.xml.crypto.dsig.dom.DOMSignContext this]
    (-> this (.getNextSibling))))

