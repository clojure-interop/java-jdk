(ns javax.swing.text.GapContent
  "An implementation of the AbstractDocument.Content interface
  implemented using a gapped buffer similar to that used by emacs.
  The underlying storage is a array of unicode characters with
  a gap somewhere.  The gap is moved to the location of changes
  to take advantage of common behavior where most changes are
  in the same location.  Changes that occur at a gap boundary are
  generally cheap and moving the gap is generally cheaper than
  moving the array contents directly to accommodate the change.

  The positions tracking change are also generally cheap to
  maintain.  The Position implementations (marks) store the array
  index and can easily calculate the sequential position from
  the current gap location.  Changes only require update to the
  the marks between the old and new gap boundaries when the gap
  is moved, so generally updating the marks is pretty cheap.
  The marks are stored sorted so they can be located quickly
  with a binary search.  This increases the cost of adding a
  mark, and decreases the cost of keeping the mark updated."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text GapContent]))

(defn ->gap-content
  "Constructor.

  Creates a new GapContent object, with the initial
   size specified.  The initial size will not be allowed
   to go below 2, to give room for the implied break and
   the gap.

  initial-length - the initial size - `int`"
  ([initial-length]
    (new GapContent initial-length))
  ([]
    (new GapContent )))

(defn length
  "Returns the length of the content.

  returns: the length >= 1 - `int`"
  ([this]
    (-> this (.length))))

(defn insert-string
  "Inserts a string into the content.

  where - the starting position >= 0, < length() - `int`
  str - the non-null string to insert - `java.lang.String`

  returns: an UndoableEdit object for undoing - `javax.swing.undo.UndoableEdit`

  throws: javax.swing.text.BadLocationException - if the specified position is invalid"
  ([this where str]
    (-> this (.insertString where str))))

(defn remove
  "Removes part of the content.

  where - the starting position >= 0, where nitems < length() - `int`
  nitems - the number of characters to remove >= 0 - `int`

  returns: an UndoableEdit object for undoing - `javax.swing.undo.UndoableEdit`

  throws: javax.swing.text.BadLocationException - if the specified position is invalid"
  ([this where nitems]
    (-> this (.remove where nitems))))

(defn get-string
  "Retrieves a portion of the content.

  where - the starting position >= 0 - `int`
  len - the length to retrieve >= 0 - `int`

  returns: a string representing the content - `java.lang.String`

  throws: javax.swing.text.BadLocationException - if the specified position is invalid"
  ([this where len]
    (-> this (.getString where len))))

(defn get-chars
  "Retrieves a portion of the content.  If the desired content spans
   the gap, we copy the content.  If the desired content does not
   span the gap, the actual store is returned to avoid the copy since
   it is contiguous.

  where - the starting position >= 0, where len <= length() - `int`
  len - the number of characters to retrieve >= 0 - `int`
  chars - the Segment object to return the characters in - `javax.swing.text.Segment`

  throws: javax.swing.text.BadLocationException - if the specified position is invalid"
  ([this where len chars]
    (-> this (.getChars where len chars))))

(defn create-position
  "Creates a position within the content that will
   track change as the content is mutated.

  offset - the offset to track >= 0 - `int`

  returns: the position - `javax.swing.text.Position`

  throws: javax.swing.text.BadLocationException - if the specified position is invalid"
  ([this offset]
    (-> this (.createPosition offset))))

