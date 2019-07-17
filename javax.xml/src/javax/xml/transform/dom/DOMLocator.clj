(ns javax.xml.transform.dom.DOMLocator
  "Indicates the position of a node in a source DOM, intended
  primarily for error reporting.  To use a DOMLocator, the receiver of an
  error must downcast the SourceLocator
  object returned by an exception. A Transformer
  may use this object for purposes other than error reporting, for instance,
  to indicate the source node that originated a result node."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform.dom DOMLocator]))

(defn get-originating-node
  "Return the node where the event occurred.

  returns: The node that is the location for the event. - `org.w3c.dom.Node`"
  ([^javax.xml.transform.dom.DOMLocator this]
    (-> this (.getOriginatingNode))))

