(ns javax.xml.crypto.dom.DOMURIReference
  "A DOM-specific URIReference. The purpose of this class is to
  provide additional context necessary for resolving XPointer URIs or
  same-document references."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dom DOMURIReference]))

(defn get-here
  "Returns the here node.

  returns: the attribute or processing instruction node or the
      parent element of the text node that directly contains the URI - `org.w3c.dom.Node`"
  ([^. this]
    (-> this (.getHere))))

