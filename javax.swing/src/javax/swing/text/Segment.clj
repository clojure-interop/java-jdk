(ns javax.swing.text.Segment
  "A segment of a character array representing a fragment
  of text.  It should be treated as immutable even though
  the array is directly accessible.  This gives fast access
  to fragments of text without the overhead of copying
  around characters.  This is effectively an unprotected
  String.

  The Segment implements the java.text.CharacterIterator
  interface to support use with the i18n support without
  copying text into a string."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text Segment]))

(defn ->segment
  "Constructor.

  Creates a new segment referring to an existing array.

  array - the array to refer to - `char[]`
  offset - the offset into the array - `int`
  count - the number of characters - `int`"
  ([array ^Integer offset ^Integer count]
    (new Segment array offset count))
  ([]
    (new Segment )))

(defn -array
  "Instance Field.

  This is the array containing the text of
   interest.  This array should never be modified;
   it is available only for efficiency.

  type: char[]"
  [this]
  (-> this .-array))

(defn -offset
  "Instance Field.

  This is the offset into the array that
   the desired text begins.

  type: int"
  [this]
  (-> this .-offset))

(defn -count
  "Instance Field.

  This is the number of array elements that
   make up the text of interest.

  type: int"
  [this]
  (-> this .-count))

(defn next
  "Increments the iterator's index by one and returns the character
   at the new index.  If the resulting index is greater or equal
   to getEndIndex(), the current index is reset to getEndIndex() and
   a value of DONE is returned.

  returns: the character at the new position or DONE if the new
   position is off the end of the text range. - `char`"
  (^Character [^javax.swing.text.Segment this]
    (-> this (.next))))

(defn get-index
  "Returns the current index.

  returns: the current index. - `int`"
  (^Integer [^javax.swing.text.Segment this]
    (-> this (.getIndex))))

(defn get-end-index
  "Returns the end index of the text.  This index is the index of the first
   character following the end of the text.

  returns: the index after the last character in the text - `int`"
  (^Integer [^javax.swing.text.Segment this]
    (-> this (.getEndIndex))))

(defn to-string
  "Converts a segment into a String.

  returns: the string - `java.lang.String`"
  (^java.lang.String [^javax.swing.text.Segment this]
    (-> this (.toString))))

(defn set-partial-return
  "Flag to indicate that partial returns are valid.  If the flag is true,
   an implementation of the interface method Document.getText(position,length,Segment)
   should return as much text as possible without making a copy.  The default
   state of the flag is false which will cause Document.getText(position,length,Segment)
   to provide the same return behavior it always had, which may or may not
   make a copy of the text depending upon the request.

  p - whether or not partial returns are valid. - `boolean`"
  ([^javax.swing.text.Segment this ^Boolean p]
    (-> this (.setPartialReturn p))))

(defn sub-sequence
  "Returns a CharSequence that is a subsequence of this sequence.
   The subsequence starts with the char value at the specified index and
   ends with the char value at index end - 1.  The length
   (in chars) of the
   returned sequence is end - start, so if start == end
   then an empty sequence is returned.

  start - the start index, inclusive - `int`
  end - the end index, exclusive - `int`

  returns: the specified subsequence - `java.lang.CharSequence`"
  (^java.lang.CharSequence [^javax.swing.text.Segment this ^Integer start ^Integer end]
    (-> this (.subSequence start end))))

(defn partial-return?
  "Flag to indicate that partial returns are valid.

  returns: whether or not partial returns are valid. - `boolean`"
  (^Boolean [^javax.swing.text.Segment this]
    (-> this (.isPartialReturn))))

(defn get-begin-index
  "Returns the start index of the text.

  returns: the index at which the text begins. - `int`"
  (^Integer [^javax.swing.text.Segment this]
    (-> this (.getBeginIndex))))

(defn char-at
  "Returns the char value at the specified index.  An index ranges from zero
   to length() - 1.  The first char value of the sequence is at
   index zero, the next at index one, and so on, as for array
   indexing.

   If the char value specified by the index is a
   surrogate, the surrogate
   value is returned.

  index - the index of the char value to be returned - `int`

  returns: the specified char value - `char`"
  (^Character [^javax.swing.text.Segment this ^Integer index]
    (-> this (.charAt index))))

(defn previous
  "Decrements the iterator's index by one and returns the character
   at the new index. If the current index is getBeginIndex(), the index
   remains at getBeginIndex() and a value of DONE is returned.

  returns: the character at the new position or DONE if the current
   position is equal to getBeginIndex(). - `char`"
  (^Character [^javax.swing.text.Segment this]
    (-> this (.previous))))

(defn current
  "Gets the character at the current position (as returned by getIndex()).

  returns: the character at the current position or DONE if the current
   position is off the end of the text. - `char`"
  (^Character [^javax.swing.text.Segment this]
    (-> this (.current))))

(defn length
  "Returns the length of this character sequence.  The length is the number
   of 16-bit chars in the sequence.

  returns: the number of chars in this sequence - `int`"
  (^Integer [^javax.swing.text.Segment this]
    (-> this (.length))))

(defn set-index
  "Sets the position to the specified position in the text and returns that
   character.

  position - the position within the text. Valid values range from getBeginIndex() to getEndIndex(). An IllegalArgumentException is thrown if an invalid value is supplied. - `int`

  returns: the character at the specified position or DONE if the specified position is equal to getEndIndex() - `char`"
  (^Character [^javax.swing.text.Segment this ^Integer position]
    (-> this (.setIndex position))))

(defn last
  "Sets the position to getEndIndex()-1 (getEndIndex() if the text is empty)
   and returns the character at that position.

  returns: the last character in the text, or DONE if the text is empty - `char`"
  (^Character [^javax.swing.text.Segment this]
    (-> this (.last))))

(defn clone
  "Creates a shallow copy.

  returns: the copy - `java.lang.Object`"
  (^java.lang.Object [^javax.swing.text.Segment this]
    (-> this (.clone))))

(defn first
  "Sets the position to getBeginIndex() and returns the character at that
   position.

  returns: the first character in the text, or DONE if the text is empty - `char`"
  (^Character [^javax.swing.text.Segment this]
    (-> this (.first))))

