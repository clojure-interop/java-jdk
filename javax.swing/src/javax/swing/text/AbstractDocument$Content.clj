(ns javax.swing.text.AbstractDocument$Content
  "Interface to describe a sequence of character content that
  can be edited.  Implementations may or may not support a
  history mechanism which will be reflected by whether or not
  mutations return an UndoableEdit implementation."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text AbstractDocument$Content]))

(defn create-position
  "Creates a position within the content that will
   track change as the content is mutated.

  offset - the offset in the content >= 0 - `int`

  returns: a Position - `javax.swing.text.Position`

  throws: javax.swing.text.BadLocationException - for an invalid offset"
  ([^. this ^Integer offset]
    (-> this (.createPosition offset))))

(defn length
  "Current length of the sequence of character content.

  returns: the length >= 0 - `int`"
  ([^. this]
    (-> this (.length))))

(defn insert-string
  "Inserts a string of characters into the sequence.

  where - offset into the sequence to make the insertion >= 0 - `int`
  str - string to insert - `java.lang.String`

  returns: if the implementation supports a history mechanism,
      a reference to an Edit implementation will be returned,
      otherwise returns null - `javax.swing.undo.UndoableEdit`

  throws: javax.swing.text.BadLocationException - thrown if the area covered by the arguments is not contained in the character sequence"
  ([^. this ^Integer where ^java.lang.String str]
    (-> this (.insertString where str))))

(defn remove
  "Removes some portion of the sequence.

  where - The offset into the sequence to make the insertion >= 0. - `int`
  nitems - The number of items in the sequence to remove >= 0. - `int`

  returns: If the implementation supports a history mechanism,
      a reference to an Edit implementation will be returned,
      otherwise null. - `javax.swing.undo.UndoableEdit`

  throws: javax.swing.text.BadLocationException - Thrown if the area covered by the arguments is not contained in the character sequence."
  ([^. this ^Integer where ^Integer nitems]
    (-> this (.remove where nitems))))

(defn get-string
  "Fetches a string of characters contained in the sequence.

  where - Offset into the sequence to fetch >= 0. - `int`
  len - number of characters to copy >= 0. - `int`

  returns: the string - `java.lang.String`

  throws: javax.swing.text.BadLocationException - Thrown if the area covered by the arguments is not contained in the character sequence."
  ([^. this ^Integer where ^Integer len]
    (-> this (.getString where len))))

(defn get-chars
  "Gets a sequence of characters and copies them into a Segment.

  where - the starting offset >= 0 - `int`
  len - the number of characters >= 0 - `int`
  txt - the target location to copy into - `javax.swing.text.Segment`

  throws: javax.swing.text.BadLocationException - Thrown if the area covered by the arguments is not contained in the character sequence."
  ([^. this ^Integer where ^Integer len ^javax.swing.text.Segment txt]
    (-> this (.getChars where len txt))))

