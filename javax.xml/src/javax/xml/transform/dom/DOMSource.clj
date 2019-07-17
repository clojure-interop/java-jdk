(ns javax.xml.transform.dom.DOMSource
  "Acts as a holder for a transformation Source tree in the
  form of a Document Object Model (DOM) tree.

  Note that XSLT requires namespace support. Attempting to transform a DOM
  that was not contructed with a namespace-aware parser may result in errors.
  Parsers can be made namespace aware by calling
  DocumentBuilderFactory.setNamespaceAware(boolean awareness)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform.dom DOMSource]))

(defn ->dom-source
  "Constructor.

  Create a new input source with a DOM node, and with the
   system ID also passed in as the base URI.

  node - The DOM node that will contain the Source tree. - `org.w3c.dom.Node`
  system-id - Specifies the base URI associated with node. - `java.lang.String`"
  ([^org.w3c.dom.Node node ^java.lang.String system-id]
    (new DOMSource node system-id))
  ([^org.w3c.dom.Node n]
    (new DOMSource n))
  ([]
    (new DOMSource )))

(def *-feature
  "Static Constant.

  If TransformerFactory.getFeature(java.lang.String)
   returns true when passed this value as an argument,
   the Transformer supports Source input of this type.

  type: java.lang.String"
  DOMSource/FEATURE)

(defn set-node
  "Set the node that will represents a Source DOM tree.

  node - The node that is to be transformed. - `org.w3c.dom.Node`"
  ([^javax.xml.transform.dom.DOMSource this ^org.w3c.dom.Node node]
    (-> this (.setNode node))))

(defn get-node
  "Get the node that represents a Source DOM tree.

  returns: The node that is to be transformed. - `org.w3c.dom.Node`"
  (^org.w3c.dom.Node [^javax.xml.transform.dom.DOMSource this]
    (-> this (.getNode))))

(defn set-system-id
  "Set the base ID (URL or system ID) from where URLs
   will be resolved.

  system-id - Base URL for this DOM tree. - `java.lang.String`"
  ([^javax.xml.transform.dom.DOMSource this ^java.lang.String system-id]
    (-> this (.setSystemId system-id))))

(defn get-system-id
  "Get the base ID (URL or system ID) from where URLs
   will be resolved.

  returns: Base URL for this DOM tree. - `java.lang.String`"
  (^java.lang.String [^javax.xml.transform.dom.DOMSource this]
    (-> this (.getSystemId))))

