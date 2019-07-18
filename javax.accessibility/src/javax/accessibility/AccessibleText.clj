(ns javax.accessibility.AccessibleText
  "The AccessibleText interface should be implemented by all
  classes that present textual information on the display.  This interface
  provides the standard mechanism for an assistive technology to access
  that text via its content, attributes, and spatial location.
  Applications can determine if an object supports the AccessibleText
  interface by first obtaining its AccessibleContext (see Accessible)
  and then calling the AccessibleContext.getAccessibleText() method of
  AccessibleContext.  If the return value is not null, the object supports this
  interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleText]))

(defn get-selected-text
  "Returns the portion of the text that is selected.

  returns: the String portion of the text that is selected - `java.lang.String`"
  (^java.lang.String [^AccessibleText this]
    (-> this (.getSelectedText))))

(defn get-after-index
  "Returns the String after a given index.

  part - the CHARACTER, WORD, or SENTENCE to retrieve - `int`
  index - an index within the text - `int`

  returns: the letter, word, or sentence - `java.lang.String`"
  (^java.lang.String [^AccessibleText this ^Integer part ^Integer index]
    (-> this (.getAfterIndex part index))))

(defn get-character-attribute
  "Returns the AttributeSet for a given character at a given index

  i - the zero-based index into the text - `int`

  returns: the AttributeSet of the character - `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^AccessibleText this ^Integer i]
    (-> this (.getCharacterAttribute i))))

(defn get-before-index
  "Returns the String before a given index.

  part - the CHARACTER, WORD, or SENTENCE to retrieve - `int`
  index - an index within the text - `int`

  returns: the letter, word, or sentence - `java.lang.String`"
  (^java.lang.String [^AccessibleText this ^Integer part ^Integer index]
    (-> this (.getBeforeIndex part index))))

(defn get-character-bounds
  "Determines the bounding box of the character at the given
   index into the string.  The bounds are returned in local
   coordinates.  If the index is invalid an empty rectangle is returned.

  i - the index into the String - `int`

  returns: the screen coordinates of the character's bounding box,
   if index is invalid return an empty rectangle. - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^AccessibleText this ^Integer i]
    (-> this (.getCharacterBounds i))))

(defn get-index-at-point
  "Given a point in local coordinates, return the zero-based index
   of the character under that Point.  If the point is invalid,
   this method returns -1.

  p - the Point in local coordinates - `java.awt.Point`

  returns: the zero-based index of the character under Point p; if
   Point is invalid return -1. - `int`"
  (^Integer [^AccessibleText this ^java.awt.Point p]
    (-> this (.getIndexAtPoint p))))

(defn get-selection-start
  "Returns the start offset within the selected text.
   If there is no selection, but there is
   a caret, the start and end offsets will be the same.

  returns: the index into the text of the start of the selection - `int`"
  (^Integer [^AccessibleText this]
    (-> this (.getSelectionStart))))

(defn get-caret-position
  "Returns the zero-based offset of the caret.

   Note: That to the right of the caret will have the same index
   value as the offset (the caret is between two characters).

  returns: the zero-based offset of the caret. - `int`"
  (^Integer [^AccessibleText this]
    (-> this (.getCaretPosition))))

(defn get-selection-end
  "Returns the end offset within the selected text.
   If there is no selection, but there is
   a caret, the start and end offsets will be the same.

  returns: the index into the text of the end of the selection - `int`"
  (^Integer [^AccessibleText this]
    (-> this (.getSelectionEnd))))

(defn get-at-index
  "Returns the String at a given index.

  part - the CHARACTER, WORD, or SENTENCE to retrieve - `int`
  index - an index within the text - `int`

  returns: the letter, word, or sentence - `java.lang.String`"
  (^java.lang.String [^AccessibleText this ^Integer part ^Integer index]
    (-> this (.getAtIndex part index))))

(defn get-char-count
  "Returns the number of characters (valid indicies)

  returns: the number of characters - `int`"
  (^Integer [^AccessibleText this]
    (-> this (.getCharCount))))

