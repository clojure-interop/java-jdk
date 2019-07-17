(ns javax.swing.event.DocumentEvent$ElementChange
  "Describes changes made to a specific element."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event DocumentEvent$ElementChange]))

(defn get-element
  "Returns the element represented.  This is the element
   that was changed.

  returns: the element - `javax.swing.text.Element`"
  ([^javax.swing.event.DocumentEvent$ElementChange this]
    (-> this (.getElement))))

(defn get-index
  "Fetches the index within the element represented.
   This is the location that children were added
   and/or removed.

  returns: the index >= 0 - `int`"
  ([^javax.swing.event.DocumentEvent$ElementChange this]
    (-> this (.getIndex))))

(defn get-children-removed
  "Gets the child elements that were removed from the
   given parent element.  The element array returned is
   sorted in the order that the elements used to lie in
   the document, and must be contiguous.

  returns: the child elements - `javax.swing.text.Element[]`"
  ([^javax.swing.event.DocumentEvent$ElementChange this]
    (-> this (.getChildrenRemoved))))

(defn get-children-added
  "Gets the child elements that were added to the given
   parent element.  The element array returned is in the
   order that the elements lie in the document, and must
   be contiguous.

  returns: the child elements - `javax.swing.text.Element[]`"
  ([^javax.swing.event.DocumentEvent$ElementChange this]
    (-> this (.getChildrenAdded))))

