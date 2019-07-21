(ns jdk.nio.CharBuffer
  "A char buffer.

   This class defines four categories of operations upon
  char buffers:



     Absolute and relative get and
    put methods that read and write
    single chars;

     Relative bulk get
    methods that transfer contiguous sequences of chars from this buffer
    into an array; and

     Relative bulk put
    methods that transfer contiguous sequences of chars from a
    char array, a string, or some other char
    buffer into this buffer; and














     Methods for compacting, duplicating, and slicing
    a char buffer.



   Char buffers can be created either by allocation, which allocates space for the buffer's








  content, by wrapping an existing
  char array or string into a buffer, or by creating a
  view of an existing byte buffer.









































































































   Like a byte buffer, a char buffer is either direct or non-direct.  A
  char buffer created via the wrap methods of this class will
  be non-direct.  A char buffer created as a view of a byte buffer will
  be direct if, and only if, the byte buffer itself is direct.  Whether or not
  a char buffer is direct may be determined by invoking the isDirect method.





   This class implements the CharSequence interface so that
  character buffers may be used wherever character sequences are accepted, for
  example in the regular-expression package java.util.regex.








   Methods in this class that do not otherwise have a value to return are
  specified to return the buffer upon which they are invoked.  This allows
  method invocations to be chained.


















  The sequence of statements



  cb.put(\"text/\");
  cb.put(subtype);
  cb.put(\"; charset=\");
  cb.put(enc);

  can, for example, be replaced by the single statement



  cb.put(\"text/\").put(subtype).put(\"; charset=\").put(enc);"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio CharBuffer]))

(defn *allocate
  "Allocates a new char buffer.

    The new buffer's position will be zero, its limit will be its
   capacity, its mark will be undefined, and each of its elements will be
   initialized to zero.  It will have a backing array,
   and its array offset will be zero.

  capacity - The new buffer's capacity, in chars - `int`

  returns: The new char buffer - `java.nio.CharBuffer`

  throws: java.lang.IllegalArgumentException - If the capacity is a negative integer"
  (^java.nio.CharBuffer [^Integer capacity]
    (CharBuffer/allocate capacity)))

(defn *wrap
  "Wraps a char array into a buffer.

    The new buffer will be backed by the given char array;
   that is, modifications to the buffer will cause the array to be modified
   and vice versa.  The new buffer's capacity will be
   array.length, its position will be offset, its limit
   will be offset  length, and its mark will be undefined.  Its
   backing array will be the given array, and
   its array offset will be zero.

  array - The array that will back the new buffer - `char[]`
  offset - The offset of the subarray to be used; must be non-negative and no larger than array.length. The new buffer's position will be set to this value. - `int`
  length - The length of the subarray to be used; must be non-negative and no larger than array.length - offset. The new buffer's limit will be set to offset length. - `int`

  returns: The new char buffer - `java.nio.CharBuffer`

  throws: java.lang.IndexOutOfBoundsException - If the preconditions on the offset and length parameters do not hold"
  (^java.nio.CharBuffer [array ^Integer offset ^Integer length]
    (CharBuffer/wrap array offset length))
  (^java.nio.CharBuffer [array]
    (CharBuffer/wrap array)))

(defn array-offset
  "Returns the offset within this buffer's backing array of the first
   element of the buffer  (optional operation).

    If this buffer is backed by an array then buffer position p
   corresponds to array index p  arrayOffset().

    Invoke the hasArray method before invoking this
   method in order to ensure that this buffer has an accessible backing
   array.

  returns: The offset within this buffer's array
            of the first element of the buffer - `int`

  throws: java.nio.ReadOnlyBufferException - If this buffer is backed by an array but is read-only"
  (^Integer [^CharBuffer this]
    (-> this (.arrayOffset))))

(defn compact
  "Compacts this buffer  (optional operation).

    The chars between the buffer's current position and its limit,
   if any, are copied to the beginning of the buffer.  That is, the
   char at index p = position() is copied
   to index zero, the char at index p  1 is copied
   to index one, and so forth until the char at index
   limit() - 1 is copied to index
   n = limit() - 1 - p.
   The buffer's position is then set to n+1 and its limit is set to
   its capacity.  The mark, if defined, is discarded.

    The buffer's position is set to the number of chars copied,
   rather than to zero, so that an invocation of this method can be
   followed immediately by an invocation of another relative put
   method.

  returns: This buffer - `java.nio.CharBuffer`

  throws: java.nio.ReadOnlyBufferException - If this buffer is read-only"
  (^java.nio.CharBuffer [^CharBuffer this]
    (-> this (.compact))))

(defn put
  "Relative bulk put method  (optional operation).

    This method transfers chars into this buffer from the given
   source array.  If there are more chars to be copied from the array
   than remain in this buffer, that is, if
   length > remaining(), then no
   chars are transferred and a BufferOverflowException is
   thrown.

    Otherwise, this method copies length chars from the
   given array into this buffer, starting at the given offset in the array
   and at the current position of this buffer.  The position of this buffer
   is then incremented by length.

    In other words, an invocation of this method of the form
   dst.put(src, off, len) has exactly the same effect as
   the loop



       for (int i = off; i < off  len; i++)
           dst.put(a[i]);

   except that it first checks that there is sufficient space in this
   buffer and it is potentially much more efficient.

  src - The array from which chars are to be read - `char[]`
  offset - The offset within the array of the first char to be read; must be non-negative and no larger than array.length - `int`
  length - The number of chars to be read from the given array; must be non-negative and no larger than array.length - offset - `int`

  returns: This buffer - `java.nio.CharBuffer`

  throws: java.nio.BufferOverflowException - If there is insufficient space in this buffer"
  (^java.nio.CharBuffer [^CharBuffer this src ^Integer offset ^Integer length]
    (-> this (.put src offset length)))
  (^java.nio.CharBuffer [^CharBuffer this ^Integer index ^Character c]
    (-> this (.put index c)))
  (^java.nio.CharBuffer [^CharBuffer this ^Character c]
    (-> this (.put c))))

(defn chars
  "Description copied from interface: CharSequence

  returns: an IntStream of char values from this sequence - `java.util.stream.IntStream`"
  (^java.util.stream.IntStream [^CharBuffer this]
    (-> this (.chars))))

(defn to-string
  "Returns a string containing the characters in this buffer.

    The first character of the resulting string will be the character at
   this buffer's position, while the last character will be the character
   at index limit() - 1.  Invoking this method does not
   change the buffer's position.

  returns: The specified string - `java.lang.String`"
  (^java.lang.String [^CharBuffer this]
    (-> this (.toString))))

(defn read
  "Attempts to read characters into the specified character buffer.
   The buffer is used as a repository of characters as-is: the only
   changes made are the results of a put operation. No flipping or
   rewinding of the buffer is performed.

  target - the buffer to read characters into - `java.nio.CharBuffer`

  returns: The number of characters added to the buffer, or
           -1 if this source of characters is at its end - `int`

  throws: java.io.IOException - if an I/O error occurs"
  (^Integer [^CharBuffer this ^java.nio.CharBuffer target]
    (-> this (.read target))))

(defn sub-sequence
  "Creates a new character buffer that represents the specified subsequence
   of this buffer, relative to the current position.

    The new buffer will share this buffer's content; that is, if the
   content of this buffer is mutable then modifications to one buffer will
   cause the other to be modified.  The new buffer's capacity will be that
   of this buffer, its position will be
   position()  start, and its limit will be
   position()  end.  The new buffer will be
   direct if, and only if, this buffer is direct, and it will be read-only
   if, and only if, this buffer is read-only.

  start - The index, relative to the current position, of the first character in the subsequence; must be non-negative and no larger than remaining() - `int`
  end - The index, relative to the current position, of the character following the last character in the subsequence; must be no smaller than start and no larger than remaining() - `int`

  returns: The new character buffer - `java.nio.CharBuffer`

  throws: java.lang.IndexOutOfBoundsException - If the preconditions on start and end do not hold"
  (^java.nio.CharBuffer [^CharBuffer this ^Integer start ^Integer end]
    (-> this (.subSequence start end))))

(defn duplicate
  "Creates a new char buffer that shares this buffer's content.

    The content of the new buffer will be that of this buffer.  Changes
   to this buffer's content will be visible in the new buffer, and vice
   versa; the two buffers' position, limit, and mark values will be
   independent.

    The new buffer's capacity, limit, position, and mark values will be
   identical to those of this buffer.  The new buffer will be direct if,
   and only if, this buffer is direct, and it will be read-only if, and
   only if, this buffer is read-only.

  returns: The new char buffer - `java.nio.CharBuffer`"
  (^java.nio.CharBuffer [^CharBuffer this]
    (-> this (.duplicate))))

(defn has-array?
  "Tells whether or not this buffer is backed by an accessible char
   array.

    If this method returns true then the array
   and arrayOffset methods may safely be invoked.

  returns: true if, and only if, this buffer
            is backed by an array and is not read-only - `boolean`"
  (^Boolean [^CharBuffer this]
    (-> this (.hasArray))))

(defn char-at
  "Reads the character at the given index relative to the current
   position.

  index - The index of the character to be read, relative to the position; must be non-negative and smaller than remaining() - `int`

  returns: The character at index
            position()  index - `char`

  throws: java.lang.IndexOutOfBoundsException - If the preconditions on index do not hold"
  (^Character [^CharBuffer this ^Integer index]
    (-> this (.charAt index))))

(defn direct?
  "Tells whether or not this char buffer is direct.

  returns: true if, and only if, this buffer is direct - `boolean`"
  (^Boolean [^CharBuffer this]
    (-> this (.isDirect))))

(defn length
  "Returns the length of this character buffer.

    When viewed as a character sequence, the length of a character
   buffer is simply the number of characters between the position
   (inclusive) and the limit (exclusive); that is, it is equivalent to
   remaining().

  returns: The length of this character buffer - `int`"
  (^Integer [^CharBuffer this]
    (-> this (.length))))

(defn order
  "Retrieves this buffer's byte order.

    The byte order of a char buffer created by allocation or by
   wrapping an existing char array is the native order of the underlying
   hardware.  The byte order of a char buffer created as a view of a byte buffer is that of the
   byte buffer at the moment that the view is created.

  returns: This buffer's byte order - `java.nio.ByteOrder`"
  (^java.nio.ByteOrder [^CharBuffer this]
    (-> this (.order))))

(defn append
  "Appends a subsequence of the  specified character sequence  to this
   buffer  (optional operation).

    An invocation of this method of the form dst.append(csq, start,
   end) when csq is not null, behaves in exactly the
   same way as the invocation



       dst.put(csq.subSequence(start, end).toString())

  csq - The character sequence from which a subsequence will be appended. If csq is null, then characters will be appended as if csq contained the four characters \"null\". - `java.lang.CharSequence`
  start - The index of the first character in the subsequence - `int`
  end - The index of the character following the last character in the subsequence - `int`

  returns: This buffer - `java.nio.CharBuffer`

  throws: java.nio.BufferOverflowException - If there is insufficient space in this buffer"
  (^java.nio.CharBuffer [^CharBuffer this ^java.lang.CharSequence csq ^Integer start ^Integer end]
    (-> this (.append csq start end)))
  (^java.nio.CharBuffer [^CharBuffer this ^java.lang.CharSequence csq]
    (-> this (.append csq))))

(defn slice
  "Creates a new char buffer whose content is a shared subsequence of
   this buffer's content.

    The content of the new buffer will start at this buffer's current
   position.  Changes to this buffer's content will be visible in the new
   buffer, and vice versa; the two buffers' position, limit, and mark
   values will be independent.

    The new buffer's position will be zero, its capacity and its limit
   will be the number of chars remaining in this buffer, and its mark
   will be undefined.  The new buffer will be direct if, and only if, this
   buffer is direct, and it will be read-only if, and only if, this buffer
   is read-only.

  returns: The new char buffer - `java.nio.CharBuffer`"
  (^java.nio.CharBuffer [^CharBuffer this]
    (-> this (.slice))))

(defn hash-code
  "Returns the current hash code of this buffer.

    The hash code of a char buffer depends only upon its remaining
   elements; that is, upon the elements from position() up to, and
   including, the element at limit() - 1.

    Because buffer hash codes are content-dependent, it is inadvisable
   to use buffers as keys in hash maps or similar data structures unless it
   is known that their contents will not change.

  returns: The current hash code of this buffer - `int`"
  (^Integer [^CharBuffer this]
    (-> this (.hashCode))))

(defn compare-to
  "Compares this buffer to another.

    Two char buffers are compared by comparing their sequences of
   remaining elements lexicographically, without regard to the starting
   position of each sequence within its corresponding buffer.








   Pairs of char elements are compared as if by invoking
   Character.compare(char,char).


    A char buffer is not comparable to any other type of object.

  that - the object to be compared. - `java.nio.CharBuffer`

  returns: A negative integer, zero, or a positive integer as this buffer
            is less than, equal to, or greater than the given buffer - `int`"
  (^Integer [^CharBuffer this ^java.nio.CharBuffer that]
    (-> this (.compareTo that))))

(defn get
  "Relative bulk get method.

    This method transfers chars from this buffer into the given
   destination array.  If there are fewer chars remaining in the
   buffer than are required to satisfy the request, that is, if
   length > remaining(), then no
   chars are transferred and a BufferUnderflowException is
   thrown.

    Otherwise, this method copies length chars from this
   buffer into the given array, starting at the current position of this
   buffer and at the given offset in the array.  The position of this
   buffer is then incremented by length.

    In other words, an invocation of this method of the form
   src.get(dst, off, len) has exactly the same effect as
   the loop



       for (int i = off; i < off  len; i++)
           dst[i] = src.get():

   except that it first checks that there are sufficient chars in
   this buffer and it is potentially much more efficient.

  dst - The array into which chars are to be written - `char[]`
  offset - The offset within the array of the first char to be written; must be non-negative and no larger than dst.length - `int`
  length - The maximum number of chars to be written to the given array; must be non-negative and no larger than dst.length - offset - `int`

  returns: This buffer - `java.nio.CharBuffer`

  throws: java.nio.BufferUnderflowException - If there are fewer than length chars remaining in this buffer"
  (^java.nio.CharBuffer [^CharBuffer this dst ^Integer offset ^Integer length]
    (-> this (.get dst offset length)))
  (^Character [^CharBuffer this ^Integer index]
    (-> this (.get index)))
  (^Character [^CharBuffer this]
    (-> this (.get))))

(defn equals
  "Tells whether or not this buffer is equal to another object.

    Two char buffers are equal if, and only if,



      They have the same element type,

      They have the same number of remaining elements, and


      The two sequences of remaining elements, considered
     independently of their starting positions, are pointwise equal.











    A char buffer is not equal to any other type of object.

  ob - The object to which this buffer is to be compared - `java.lang.Object`

  returns: true if, and only if, this buffer is equal to the
             given object - `boolean`"
  (^Boolean [^CharBuffer this ^java.lang.Object ob]
    (-> this (.equals ob))))

(defn array
  "Returns the char array that backs this
   buffer  (optional operation).

    Modifications to this buffer's content will cause the returned
   array's content to be modified, and vice versa.

    Invoke the hasArray method before invoking this
   method in order to ensure that this buffer has an accessible backing
   array.

  returns: The array that backs this buffer - `char[]`

  throws: java.nio.ReadOnlyBufferException - If this buffer is backed by an array but is read-only"
  ([^CharBuffer this]
    (-> this (.array))))

(defn as-read-only-buffer
  "Creates a new, read-only char buffer that shares this buffer's
   content.

    The content of the new buffer will be that of this buffer.  Changes
   to this buffer's content will be visible in the new buffer; the new
   buffer itself, however, will be read-only and will not allow the shared
   content to be modified.  The two buffers' position, limit, and mark
   values will be independent.

    The new buffer's capacity, limit, position, and mark values will be
   identical to those of this buffer.

    If this buffer is itself read-only then this method behaves in
   exactly the same way as the duplicate method.

  returns: The new, read-only char buffer - `java.nio.CharBuffer`"
  (^java.nio.CharBuffer [^CharBuffer this]
    (-> this (.asReadOnlyBuffer))))

