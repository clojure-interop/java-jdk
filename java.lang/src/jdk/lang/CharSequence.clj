(ns jdk.lang.CharSequence
  "A CharSequence is a readable sequence of char values. This
  interface provides uniform, read-only access to many different kinds of
  char sequences.
  A char value represents a character in the Basic
  Multilingual Plane (BMP) or a surrogate. Refer to Unicode Character Representation for details.

   This interface does not refine the general contracts of the equals and hashCode methods.  The result of comparing two
  objects that implement CharSequence is therefore, in general,
  undefined.  Each object may be implemented by a different class, and there
  is no guarantee that each class will be capable of testing its instances
  for equality with those of the other.  It is therefore inappropriate to use
  arbitrary CharSequence instances as elements in a set or as keys in
  a map."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang CharSequence]))

(defn length
  "Returns the length of this character sequence.  The length is the number
   of 16-bit chars in the sequence.

  returns: the number of chars in this sequence - `int`"
  ([^java.lang.CharSequence this]
    (-> this (.length))))

(defn char-at
  "Returns the char value at the specified index.  An index ranges from zero
   to length() - 1.  The first char value of the sequence is at
   index zero, the next at index one, and so on, as for array
   indexing.

   If the char value specified by the index is a
   surrogate, the surrogate
   value is returned.

  index - the index of the char value to be returned - `int`

  returns: the specified char value - `char`

  throws: java.lang.IndexOutOfBoundsException - if the index argument is negative or not less than length()"
  ([^java.lang.CharSequence this ^Integer index]
    (-> this (.charAt index))))

(defn sub-sequence
  "Returns a CharSequence that is a subsequence of this sequence.
   The subsequence starts with the char value at the specified index and
   ends with the char value at index end - 1.  The length
   (in chars) of the
   returned sequence is end - start, so if start == end
   then an empty sequence is returned.

  start - the start index, inclusive - `int`
  end - the end index, exclusive - `int`

  returns: the specified subsequence - `java.lang.CharSequence`

  throws: java.lang.IndexOutOfBoundsException - if start or end are negative, if end is greater than length(), or if start is greater than end"
  ([^java.lang.CharSequence this ^Integer start ^Integer end]
    (-> this (.subSequence start end))))

(defn to-string
  "Returns a string containing the characters in this sequence in the same
   order as this sequence.  The length of the string will be the length of
   this sequence.

  returns: a string consisting of exactly this sequence of characters - `java.lang.String`"
  ([^java.lang.CharSequence this]
    (-> this (.toString))))

(defn chars
  "Returns a stream of int zero-extending the char values
   from this sequence.  Any char which maps to a surrogate code
   point is passed through uninterpreted.

   If the sequence is mutated while the stream is being read, the
   result is undefined.

  returns: an IntStream of char values from this sequence - `default java.util.stream.IntStream`"
  ([^java.lang.CharSequence this]
    (-> this (.chars))))

(defn code-points
  "Returns a stream of code point values from this sequence.  Any surrogate
   pairs encountered in the sequence are combined as if by Character.toCodePoint and the result is passed
   to the stream. Any other code units, including ordinary BMP characters,
   unpaired surrogates, and undefined code units, are zero-extended to
   int values which are then passed to the stream.

   If the sequence is mutated while the stream is being read, the result
   is undefined.

  returns: an IntStream of Unicode code points from this sequence - `default java.util.stream.IntStream`"
  ([^java.lang.CharSequence this]
    (-> this (.codePoints))))

