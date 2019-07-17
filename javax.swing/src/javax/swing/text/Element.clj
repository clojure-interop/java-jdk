(ns javax.swing.text.Element
  "Interface to describe a structural piece of a document.  It
  is intended to capture the spirit of an SGML element."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text Element]))

(defn get-element-index
  "Gets the child element index closest to the given offset.
   The offset is specified relative to the beginning of the
   document.  Returns -1 if the
   Element is a leaf, otherwise returns
   the index of the Element that best represents
   the given location.  Returns 0 if the location
   is less than the start offset. Returns
   getElementCount() - 1 if the location is
   greater than or equal to the end offset.

  offset - the specified offset >= 0 - `int`

  returns: the element index >= 0 - `int`"
  ([this offset]
    (-> this (.getElementIndex offset))))

(defn get-document
  "Fetches the document associated with this element.

  returns: the document - `javax.swing.text.Document`"
  ([this]
    (-> this (.getDocument))))

(defn get-end-offset
  "Fetches the offset from the beginning of the document
   that this element ends at.  If this element has
   children, this will be the end offset of the last child.
   As a document position, there is an implied backward bias.

   All the default Document implementations
   descend from AbstractDocument.
   AbstractDocument models an implied break at the end of
   the document. As a result of this, it is possible for this to
   return a value greater than the length of the document.

  returns: the ending offset > getStartOffset() and
       <= getDocument().getLength()  1 - `int`"
  ([this]
    (-> this (.getEndOffset))))

(defn get-element
  "Fetches the child element at the given index.

  index - the specified index >= 0 - `int`

  returns: the child element - `javax.swing.text.Element`"
  ([this index]
    (-> this (.getElement index))))

(defn get-element-count
  "Gets the number of child elements contained by this element.
   If this element is a leaf, a count of zero is returned.

  returns: the number of child elements >= 0 - `int`"
  ([this]
    (-> this (.getElementCount))))

(defn get-name
  "Fetches the name of the element.  If the element is used to
   represent some type of structure, this would be the type
   name.

  returns: the element name - `java.lang.String`"
  ([this]
    (-> this (.getName))))

(defn leaf?
  "Is this element a leaf element? An element that
   may have children, even if it currently
   has no children, would return false.

  returns: true if a leaf element else false - `boolean`"
  ([this]
    (-> this (.isLeaf))))

(defn get-start-offset
  "Fetches the offset from the beginning of the document
   that this element begins at.  If this element has
   children, this will be the offset of the first child.
   As a document position, there is an implied forward bias.

  returns: the starting offset >= 0 and < getEndOffset(); - `int`"
  ([this]
    (-> this (.getStartOffset))))

(defn get-parent-element
  "Fetches the parent element.  If the element is a root level
   element returns null.

  returns: the parent element - `javax.swing.text.Element`"
  ([this]
    (-> this (.getParentElement))))

(defn get-attributes
  "Fetches the collection of attributes this element contains.

  returns: the attributes for the element - `javax.swing.text.AttributeSet`"
  ([this]
    (-> this (.getAttributes))))

