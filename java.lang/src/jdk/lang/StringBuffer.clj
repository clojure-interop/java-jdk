(ns jdk.lang.StringBuffer
  "A thread-safe, mutable sequence of characters.
  A string buffer is like a String, but can be modified. At any
  point in time it contains some particular sequence of characters, but
  the length and content of the sequence can be changed through certain
  method calls.

  String buffers are safe for use by multiple threads. The methods
  are synchronized where necessary so that all the operations on any
  particular instance behave as if they occur in some serial order
  that is consistent with the order of the method calls made by each of
  the individual threads involved.

  The principal operations on a StringBuffer are the
  append and insert methods, which are
  overloaded so as to accept data of any type. Each effectively
  converts a given datum to a string and then appends or inserts the
  characters of that string to the string buffer. The
  append method always adds these characters at the end
  of the buffer; the insert method adds the characters at
  a specified point.

  For example, if z refers to a string buffer object
  whose current contents are `start`, then
  the method call z.append(`le`) would cause the string
  buffer to contain `startle`, whereas
  z.insert(4, `le`) would alter the string buffer to
  contain `starlet`.

  In general, if sb refers to an instance of a StringBuffer,
  then sb.append(x) has the same effect as
  sb.insert(sb.length(), x).

  Whenever an operation occurs involving a source sequence (such as
  appending or inserting from a source sequence), this class synchronizes
  only on the string buffer performing the operation, not on the source.
  Note that while StringBuffer is designed to be safe to use
  concurrently from multiple threads, if the constructor or the
  append or insert operation is passed a source sequence
  that is shared across threads, the calling code must ensure
  that the operation has a consistent and unchanging view of the source
  sequence for the duration of the operation.
  This could be satisfied by the caller holding a lock during the
  operation's call, by using an immutable source sequence, or by not
  sharing the source sequence across threads.

  Every string buffer has a capacity. As long as the length of the
  character sequence contained in the string buffer does not exceed
  the capacity, it is not necessary to allocate a new internal
  buffer array. If the internal buffer overflows, it is
  automatically made larger.

  Unless otherwise noted, passing a null argument to a constructor
  or method in this class will cause a NullPointerException to be
  thrown.

  As of  release JDK 5, this class has been supplemented with an equivalent
  class designed for use by a single thread, StringBuilder.  The
  StringBuilder class should generally be used in preference to
  this one, as it supports all of the same operations but it is faster, as
  it performs no synchronization."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang StringBuffer]))

(defn ->string-buffer
  "Constructor.

  Constructs a string buffer with no characters in it and
   the specified initial capacity.

  capacity - the initial capacity. - `int`

  throws: java.lang.NegativeArraySizeException - if the capacity argument is less than 0."
  ([^Integer capacity]
    (new StringBuffer capacity))
  ([]
    (new StringBuffer )))

(defn get-chars
  "Characters are copied from this sequence into the
   destination character array dst. The first character to
   be copied is at index srcBegin; the last character to
   be copied is at index srcEnd-1. The total number of
   characters to be copied is srcEnd-srcBegin. The
   characters are copied into the subarray of dst starting
   at index dstBegin and ending at index:


   dstbegin  (srcEnd-srcBegin) - 1

  src-begin - start copying at this offset. - `int`
  src-end - stop copying at this offset. - `int`
  dst - the array to copy the data into. - `char[]`
  dst-begin - offset into dst. - `int`

  throws: java.lang.IndexOutOfBoundsException - if any of the following is true: srcBegin is negative dstBegin is negative the srcBegin argument is greater than the srcEnd argument. srcEnd is greater than this.length(). dstBegin+srcEnd-srcBegin is greater than dst.length"
  ([^java.lang.StringBuffer this ^Integer src-begin ^Integer src-end dst ^Integer dst-begin]
    (-> this (.getChars src-begin src-end dst dst-begin))))

(defn append-code-point
  "Appends the string representation of the codePoint
   argument to this sequence.

    The argument is appended to the contents of this sequence.
   The length of this sequence increases by
   Character.charCount(codePoint).

    The overall effect is exactly as if the argument were
   converted to a char array by the method
   Character.toChars(int) and the character in that array
   were then appended to this character
   sequence.

  code-point - a Unicode code point - `int`

  returns: a reference to this object. - `java.lang.StringBuffer`"
  ([^java.lang.StringBuffer this ^Integer code-point]
    (-> this (.appendCodePoint code-point))))

(defn delete
  "Removes the characters in a substring of this sequence.
   The substring begins at the specified start and extends to
   the character at index end - 1 or to the end of the
   sequence if no such character exists. If
   start is equal to end, no changes are made.

  start - The beginning index, inclusive. - `int`
  end - The ending index, exclusive. - `int`

  returns: This object. - `java.lang.StringBuffer`

  throws: java.lang.StringIndexOutOfBoundsException - if start is negative, greater than length(), or greater than end."
  ([^java.lang.StringBuffer this ^Integer start ^Integer end]
    (-> this (.delete start end))))

(defn reverse
  "Causes this character sequence to be replaced by the reverse of
   the sequence. If there are any surrogate pairs included in the
   sequence, these are treated as single characters for the
   reverse operation. Thus, the order of the high-low surrogates
   is never reversed.

   Let n be the character length of this character sequence
   (not the length in char values) just prior to
   execution of the reverse method. Then the
   character at index k in the new character sequence is
   equal to the character at index n-k-1 in the old
   character sequence.

   Note that the reverse operation may result in producing
   surrogate pairs that were unpaired low-surrogates and
   high-surrogates before the operation. For example, reversing
   `\uDC00\uD800` produces `\uD800\uDC00` which is
   a valid surrogate pair.

  returns: a reference to this object. - `java.lang.StringBuffer`"
  ([^java.lang.StringBuffer this]
    (-> this (.reverse))))

(defn to-string
  "Returns a string representing the data in this sequence.
   A new String object is allocated and initialized to
   contain the character sequence currently represented by this
   object. This String is then returned. Subsequent
   changes to this sequence do not affect the contents of the
   String.

  returns: a string representation of this sequence of characters. - `java.lang.String`"
  ([^java.lang.StringBuffer this]
    (-> this (.toString))))

(defn set-length
  "Sets the length of the character sequence.
   The sequence is changed to a new character sequence
   whose length is specified by the argument. For every nonnegative
   index k less than newLength, the character at
   index k in the new character sequence is the same as the
   character at index k in the old sequence if k is less
   than the length of the old character sequence; otherwise, it is the
   null character '\u0000'.

   In other words, if the newLength argument is less than
   the current length, the length is changed to the specified length.

   If the newLength argument is greater than or equal
   to the current length, sufficient null characters
   ('\u0000') are appended so that
   length becomes the newLength argument.

   The newLength argument must be greater than or equal
   to 0.

  new-length - the new length - `int`

  throws: java.lang.IndexOutOfBoundsException - if the newLength argument is negative."
  ([^java.lang.StringBuffer this ^Integer new-length]
    (-> this (.setLength new-length))))

(defn sub-sequence
  "Returns a new character sequence that is a subsequence of this sequence.

    An invocation of this method of the form



   sb.subSequence(begin,&nbsp;end)

   behaves in exactly the same way as the invocation



   sb.substring(begin,&nbsp;end)

   This method is provided so that this class can
   implement the CharSequence interface.

  start - the start index, inclusive. - `int`
  end - the end index, exclusive. - `int`

  returns: the specified subsequence. - `java.lang.CharSequence`

  throws: java.lang.IndexOutOfBoundsException - if start or end are negative, if end is greater than length(), or if start is greater than end"
  ([^java.lang.StringBuffer this ^Integer start ^Integer end]
    (-> this (.subSequence start end))))

(defn substring
  "Returns a new String that contains a subsequence of
   characters currently contained in this sequence. The
   substring begins at the specified start and
   extends to the character at index end - 1.

  start - The beginning index, inclusive. - `int`
  end - The ending index, exclusive. - `int`

  returns: The new string. - `java.lang.String`

  throws: java.lang.StringIndexOutOfBoundsException - if start or end are negative or greater than length(), or start is greater than end."
  ([^java.lang.StringBuffer this ^Integer start ^Integer end]
    (-> this (.substring start end)))
  ([^java.lang.StringBuffer this ^Integer start]
    (-> this (.substring start))))

(defn replace
  "Replaces the characters in a substring of this sequence
   with characters in the specified String. The substring
   begins at the specified start and extends to the character
   at index end - 1 or to the end of the
   sequence if no such character exists. First the
   characters in the substring are removed and then the specified
   String is inserted at start. (This
   sequence will be lengthened to accommodate the
   specified String if necessary.)

  start - The beginning index, inclusive. - `int`
  end - The ending index, exclusive. - `int`
  str - String that will replace previous contents. - `java.lang.String`

  returns: This object. - `java.lang.StringBuffer`

  throws: java.lang.StringIndexOutOfBoundsException - if start is negative, greater than length(), or greater than end."
  ([^java.lang.StringBuffer this ^Integer start ^Integer end ^java.lang.String str]
    (-> this (.replace start end str))))

(defn delete-char-at
  "Removes the char at the specified position in this
   sequence. This sequence is shortened by one char.

   Note: If the character at the given index is a supplementary
   character, this method does not remove the entire character. If
   correct handling of supplementary characters is required,
   determine the number of chars to remove by calling
   Character.charCount(thisSequence.codePointAt(index)),
   where thisSequence is this sequence.

  index - Index of char to remove - `int`

  returns: This object. - `java.lang.StringBuffer`

  throws: java.lang.StringIndexOutOfBoundsException - if the index is negative or greater than or equal to length()."
  ([^java.lang.StringBuffer this ^Integer index]
    (-> this (.deleteCharAt index))))

(defn last-index-of
  "Returns the index within this string of the last occurrence of the
   specified substring. The integer returned is the largest value k
   such that:


       k <= Math.min(fromIndex, this.length()) &&
                     this.toString().startsWith(str, k)
   If no such value of k exists, then -1 is returned.

  str - the substring to search for. - `java.lang.String`
  from-index - the index to start the search from. - `int`

  returns: the index within this sequence of the last occurrence of the
            specified substring. - `int`"
  ([^java.lang.StringBuffer this ^java.lang.String str ^Integer from-index]
    (-> this (.lastIndexOf str from-index)))
  ([^java.lang.StringBuffer this ^java.lang.String str]
    (-> this (.lastIndexOf str))))

(defn char-at
  "Returns the char value in this sequence at the specified index.
   The first char value is at index 0, the next at index
   1, and so on, as in array indexing.

   The index argument must be greater than or equal to
   0, and less than the length of this sequence.

   If the char value specified by the index is a
   surrogate, the surrogate
   value is returned.

  index - the index of the desired char value. - `int`

  returns: the char value at the specified index. - `char`

  throws: java.lang.IndexOutOfBoundsException - if index is negative or greater than or equal to length()."
  ([^java.lang.StringBuffer this ^Integer index]
    (-> this (.charAt index))))

(defn offset-by-code-points
  "Returns the index within this sequence that is offset from the
   given index by codePointOffset code
   points. Unpaired surrogates within the text range given by
   index and codePointOffset count as
   one code point each.

  index - the index to be offset - `int`
  code-point-offset - the offset in code points - `int`

  returns: the index within this sequence - `int`"
  ([^java.lang.StringBuffer this ^Integer index ^Integer code-point-offset]
    (-> this (.offsetByCodePoints index code-point-offset))))

(defn length
  "Returns the length (character count).

  returns: the length of the sequence of characters currently
            represented by this object - `int`"
  ([^java.lang.StringBuffer this]
    (-> this (.length))))

(defn ensure-capacity
  "Ensures that the capacity is at least equal to the specified minimum.
   If the current capacity is less than the argument, then a new internal
   array is allocated with greater capacity. The new capacity is the
   larger of:

   The minimumCapacity argument.
   Twice the old capacity, plus 2.

   If the minimumCapacity argument is nonpositive, this
   method takes no action and simply returns.
   Note that subsequent operations on this object can reduce the
   actual capacity below that requested here.

  minimum-capacity - the minimum desired capacity. - `int`"
  ([^java.lang.StringBuffer this ^Integer minimum-capacity]
    (-> this (.ensureCapacity minimum-capacity))))

(defn append
  "Appends a subsequence of the specified CharSequence to this
   sequence.

   Characters of the argument s, starting at
   index start, are appended, in order, to the contents of
   this sequence up to the (exclusive) index end. The length
   of this sequence is increased by the value of end - start.

   Let n be the length of this character sequence just prior to
   execution of the append method. Then the character at
   index k in this character sequence becomes equal to the
   character at index k in this sequence, if k is less than
   n; otherwise, it is equal to the character at index
   k+start-n in the argument s.

   If s is null, then this method appends
   characters as if the s parameter was a sequence containing the four
   characters `null`.

  s - the sequence to append. - `java.lang.CharSequence`
  start - the starting index of the subsequence to be appended. - `int`
  end - the end index of the subsequence to be appended. - `int`

  returns: a reference to this object. - `java.lang.StringBuffer`

  throws: java.lang.IndexOutOfBoundsException - if start is negative, or start is greater than end or end is greater than s.length()"
  ([^java.lang.StringBuffer this ^java.lang.CharSequence s ^Integer start ^Integer end]
    (-> this (.append s start end)))
  ([^java.lang.StringBuffer this ^java.lang.Object obj]
    (-> this (.append obj))))

(defn set-char-at
  "The character at the specified index is set to ch. This
   sequence is altered to represent a new character sequence that is
   identical to the old character sequence, except that it contains the
   character ch at position index.

   The index argument must be greater than or equal to
   0, and less than the length of this sequence.

  index - the index of the character to modify. - `int`
  ch - the new character. - `char`

  throws: java.lang.IndexOutOfBoundsException - if index is negative or greater than or equal to length()."
  ([^java.lang.StringBuffer this ^Integer index ^Character ch]
    (-> this (.setCharAt index ch))))

(defn insert
  "Inserts the string representation of a subarray of the str
   array argument into this sequence. The subarray begins at the
   specified offset and extends len chars.
   The characters of the subarray are inserted into this sequence at
   the position indicated by index. The length of this
   sequence increases by len chars.

  index - position at which to insert subarray. - `int`
  str - A char array. - `char[]`
  offset - the index of the first char in subarray to be inserted. - `int`
  len - the number of chars in the subarray to be inserted. - `int`

  returns: This object - `java.lang.StringBuffer`

  throws: java.lang.StringIndexOutOfBoundsException - if index is negative or greater than length(), or offset or len are negative, or (offset+len) is greater than str.length."
  ([^java.lang.StringBuffer this ^Integer index str ^Integer offset ^Integer len]
    (-> this (.insert index str offset len)))
  ([^java.lang.StringBuffer this ^Integer offset ^java.lang.Object obj]
    (-> this (.insert offset obj))))

(defn code-point-count
  "Returns the number of Unicode code points in the specified text
   range of this sequence. The text range begins at the specified
   beginIndex and extends to the char at
   index endIndex - 1. Thus the length (in
   chars) of the text range is
   endIndex-beginIndex. Unpaired surrogates within
   this sequence count as one code point each.

  begin-index - the index to the first char of the text range. - `int`
  end-index - the index after the last char of the text range. - `int`

  returns: the number of Unicode code points in the specified text
   range - `int`"
  ([^java.lang.StringBuffer this ^Integer begin-index ^Integer end-index]
    (-> this (.codePointCount begin-index end-index))))

(defn code-point-before
  "Returns the character (Unicode code point) before the specified
   index. The index refers to char values
   (Unicode code units) and ranges from 1 to length().

    If the char value at (index - 1)
   is in the low-surrogate range, (index - 2) is not
   negative, and the char value at (index -
   2) is in the high-surrogate range, then the
   supplementary code point value of the surrogate pair is
   returned. If the char value at index -
   1 is an unpaired low-surrogate or a high-surrogate, the
   surrogate value is returned.

  index - the index following the code point that should be returned - `int`

  returns: the Unicode code point value before the given index. - `int`"
  ([^java.lang.StringBuffer this ^Integer index]
    (-> this (.codePointBefore index))))

(defn index-of
  "Returns the index within this string of the first occurrence of the
   specified substring, starting at the specified index.  The integer
   returned is the smallest value k for which:


       k >= Math.min(fromIndex, this.length()) &&
                     this.toString().startsWith(str, k)
   If no such value of k exists, then -1 is returned.

  str - the substring for which to search. - `java.lang.String`
  from-index - the index from which to start the search. - `int`

  returns: the index within this string of the first occurrence of the
            specified substring, starting at the specified index. - `int`"
  ([^java.lang.StringBuffer this ^java.lang.String str ^Integer from-index]
    (-> this (.indexOf str from-index)))
  ([^java.lang.StringBuffer this ^java.lang.String str]
    (-> this (.indexOf str))))

(defn capacity
  "Returns the current capacity. The capacity is the amount of storage
   available for newly inserted characters, beyond which an allocation
   will occur.

  returns: the current capacity - `int`"
  ([^java.lang.StringBuffer this]
    (-> this (.capacity))))

(defn trim-to-size
  "Attempts to reduce storage used for the character sequence.
   If the buffer is larger than necessary to hold its current sequence of
   characters, then it may be resized to become more space efficient.
   Calling this method may, but is not required to, affect the value
   returned by a subsequent call to the capacity() method."
  ([^java.lang.StringBuffer this]
    (-> this (.trimToSize))))

(defn code-point-at
  "Returns the character (Unicode code point) at the specified
   index. The index refers to char values
   (Unicode code units) and ranges from 0 to
   length()- 1.

    If the char value specified at the given index
   is in the high-surrogate range, the following index is less
   than the length of this sequence, and the
   char value at the following index is in the
   low-surrogate range, then the supplementary code point
   corresponding to this surrogate pair is returned. Otherwise,
   the char value at the given index is returned.

  index - the index to the char values - `int`

  returns: the code point value of the character at the
               index - `int`"
  ([^java.lang.StringBuffer this ^Integer index]
    (-> this (.codePointAt index))))

