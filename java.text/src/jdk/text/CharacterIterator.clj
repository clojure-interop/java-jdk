(ns jdk.text.CharacterIterator
  "This interface defines a protocol for bidirectional iteration over text.
  The iterator iterates over a bounded sequence of characters.  Characters
  are indexed with values beginning with the value returned by getBeginIndex() and
  continuing through the value returned by getEndIndex()-1.

  Iterators maintain a current character index, whose valid range is from
  getBeginIndex() to getEndIndex(); the value getEndIndex() is included to allow
  handling of zero-length text ranges and for historical reasons.
  The current index can be retrieved by calling getIndex() and set directly
  by calling setIndex(), first(), and last().

  The methods previous() and next() are used for iteration. They return DONE if
  they would move outside the range from getBeginIndex() to getEndIndex() -1,
  signaling that the iterator has reached the end of the sequence. DONE is
  also returned by other methods to indicate that the current index is
  outside this range.

  Examples:

  Traverse the text from start to finish


  public void traverseForward(CharacterIterator iter) {
      for(char c = iter.first(); c != CharacterIterator.DONE; c = iter.next()) {
          processChar(c);
      }
  }

  Traverse the text backwards, from end to start


  public void traverseBackward(CharacterIterator iter) {
      for(char c = iter.last(); c != CharacterIterator.DONE; c = iter.previous()) {
          processChar(c);
      }
  }

  Traverse both forward and backward from a given position in the text.
  Calls to notBoundary() in this example represents some
  additional stopping criteria.


  public void traverseOut(CharacterIterator iter, int pos) {
      for (char c = iter.setIndex(pos);
               c != CharacterIterator.DONE && notBoundary(c);
               c = iter.next()) {
      }
      int end = iter.getIndex();
      for (char c = iter.setIndex(pos);
              c != CharacterIterator.DONE && notBoundary(c);
              c = iter.previous()) {
      }
      int start = iter.getIndex();
      processSection(start, end);
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text CharacterIterator]))

(defn next
  "Increments the iterator's index by one and returns the character
   at the new index.  If the resulting index is greater or equal
   to getEndIndex(), the current index is reset to getEndIndex() and
   a value of DONE is returned.

  returns: the character at the new position or DONE if the new
   position is off the end of the text range. - `char`"
  ([this]
    (-> this (.next))))

(defn get-index
  "Returns the current index.

  returns: the current index. - `int`"
  ([this]
    (-> this (.getIndex))))

(defn get-end-index
  "Returns the end index of the text.  This index is the index of the first
   character following the end of the text.

  returns: the index after the last character in the text - `int`"
  ([this]
    (-> this (.getEndIndex))))

(defn get-begin-index
  "Returns the start index of the text.

  returns: the index at which the text begins. - `int`"
  ([this]
    (-> this (.getBeginIndex))))

(defn previous
  "Decrements the iterator's index by one and returns the character
   at the new index. If the current index is getBeginIndex(), the index
   remains at getBeginIndex() and a value of DONE is returned.

  returns: the character at the new position or DONE if the current
   position is equal to getBeginIndex(). - `char`"
  ([this]
    (-> this (.previous))))

(defn current
  "Gets the character at the current position (as returned by getIndex()).

  returns: the character at the current position or DONE if the current
   position is off the end of the text. - `char`"
  ([this]
    (-> this (.current))))

(defn set-index
  "Sets the position to the specified position in the text and returns that
   character.

  position - the position within the text. Valid values range from getBeginIndex() to getEndIndex(). An IllegalArgumentException is thrown if an invalid value is supplied. - `int`

  returns: the character at the specified position or DONE if the specified position is equal to getEndIndex() - `char`"
  ([this position]
    (-> this (.setIndex position))))

(defn last
  "Sets the position to getEndIndex()-1 (getEndIndex() if the text is empty)
   and returns the character at that position.

  returns: the last character in the text, or DONE if the text is empty - `char`"
  ([this]
    (-> this (.last))))

(defn clone
  "Create a copy of this iterator

  returns: A copy of this - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

(defn first
  "Sets the position to getBeginIndex() and returns the character at that
   position.

  returns: the first character in the text, or DONE if the text is empty - `char`"
  ([this]
    (-> this (.first))))

