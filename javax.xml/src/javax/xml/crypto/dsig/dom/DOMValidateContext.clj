(ns javax.xml.crypto.dsig.dom.DOMValidateContext
  "A DOM-specific XMLValidateContext. This class contains additional
  methods to specify the location in a DOM tree where an XMLSignature
  is to be unmarshalled and validated from.

  Note that the behavior of an unmarshalled XMLSignature
  is undefined if the contents of the underlying DOM tree are modified by the
  caller after the XMLSignature is created.

  Also, note that DOMValidateContext instances can contain
  information and state specific to the XML signature structure it is
  used with. The results are unpredictable if a
  DOMValidateContext is used with different signature structures
  (for example, you should not use the same DOMValidateContext
  instance to validate two different XMLSignature objects)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig.dom DOMValidateContext]))

(defn ->dom-validate-context
  "Constructor.

  Creates a DOMValidateContext containing the specified key
   selector and node.

  ks - a key selector for finding a validation key - `javax.xml.crypto.KeySelector`
  node - the node - `org.w3c.dom.Node`

  throws: java.lang.NullPointerException - if ks or node is null"
  ([^javax.xml.crypto.KeySelector ks ^org.w3c.dom.Node node]
    (new DOMValidateContext ks node)))

(defn set-node
  "Sets the node.

  node - the node - `org.w3c.dom.Node`

  throws: java.lang.NullPointerException - if node is null"
  ([^javax.xml.crypto.dsig.dom.DOMValidateContext this ^org.w3c.dom.Node node]
    (-> this (.setNode node))))

(defn get-node
  "Returns the node.

  returns: the node (never null) - `org.w3c.dom.Node`"
  ([^javax.xml.crypto.dsig.dom.DOMValidateContext this]
    (-> this (.getNode))))

