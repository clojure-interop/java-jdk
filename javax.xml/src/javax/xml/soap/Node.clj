(ns javax.xml.soap.Node
  "A representation of a node (element) in an XML document.
  This interface extnends the standard DOM Node interface with methods for
  getting and setting the value of a node, for
  getting and setting the parent of a node, and for removing a node."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap Node]))

(defn get-value
  "Returns the value of this node if this is a Text node or the
   value of the immediate child of this node otherwise.
   If there is an immediate child of this Node that it is a
   Text node then it's value will be returned. If there is
   more than one Text node then the value of the first
   Text Node will be returned.
   Otherwise null is returned.

  returns: a String with the text of this node if this is a
            Text node or the text contained by the first
            immediate child of this Node object that is a
            Text object if such a child exists;
            null otherwise. - `java.lang.String`"
  ([this]
    (-> this (.getValue))))

(defn set-value
  "If this is a Text node then this method will set its value,
   otherwise it sets the value of  the immediate (Text) child of this node.
   The value of the immediate child of this node can be set only if, there is
   one child node and that node is a Text node, or if
   there are no children in which case a child Text node will be
   created.

  value - `java.lang.String`

  throws: java.lang.IllegalStateException - if the node is not a Text node and either has more than one child node or has a child node that is not a Text node."
  ([this value]
    (-> this (.setValue value))))

(defn set-parent-element
  "Sets the parent of this Node object to the given
   SOAPElement object.

  parent - the SOAPElement object to be set as the parent of this Node object - `javax.xml.soap.SOAPElement`

  throws: javax.xml.soap.SOAPException - if there is a problem in setting the parent to the given element"
  ([this parent]
    (-> this (.setParentElement parent))))

(defn get-parent-element
  "Returns the parent element of this Node object.
   This method can throw an UnsupportedOperationException
   if the tree is not kept in memory.

  returns: the SOAPElement object that is the parent of
           this Node object or null if this
           Node object is root - `javax.xml.soap.SOAPElement`

  throws: java.lang.UnsupportedOperationException - if the whole tree is not kept in memory"
  ([this]
    (-> this (.getParentElement))))

(defn detach-node
  "Removes this Node object from the tree."
  ([this]
    (-> this (.detachNode))))

(defn recycle-node
  "Notifies the implementation that this Node
   object is no longer being used by the application and that the
   implementation is free to reuse this object for nodes that may
   be created later.

   Calling the method recycleNode implies that the method
   detachNode has been called previously."
  ([this]
    (-> this (.recycleNode))))

