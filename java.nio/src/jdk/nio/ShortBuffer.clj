(ns jdk.nio.ShortBuffer
  "A short buffer.

   This class defines four categories of operations upon
  short buffers:



     Absolute and relative get and
    put methods that read and write
    single shorts;

     Relative bulk get
    methods that transfer contiguous sequences of shorts from this buffer
    into an array; and

     Relative bulk put
    methods that transfer contiguous sequences of shorts from a
    short array or some other short
    buffer into this buffer; and














     Methods for compacting, duplicating, and slicing
    a short buffer.



   Short buffers can be created either by allocation, which allocates space for the buffer's








  content, by wrapping an existing
  short array  into a buffer, or by creating a
  view of an existing byte buffer.









































































































   Like a byte buffer, a short buffer is either direct or non-direct.  A
  short buffer created via the wrap methods of this class will
  be non-direct.  A short buffer created as a view of a byte buffer will
  be direct if, and only if, the byte buffer itself is direct.  Whether or not
  a short buffer is direct may be determined by invoking the isDirect method.
















   Methods in this class that do not otherwise have a value to return are
  specified to return the buffer upon which they are invoked.  This allows
  method invocations to be chained."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio ShortBuffer]))

(defn *allocate
  "Allocates a new short buffer.

    The new buffer's position will be zero, its limit will be its
   capacity, its mark will be undefined, and each of its elements will be
   initialized to zero.  It will have a backing array,
   and its array offset will be zero.

  capacity - The new buffer's capacity, in shorts - `int`

  returns: The new short buffer - `java.nio.ShortBuffer`

  throws: java.lang.IllegalArgumentException - If the capacity is a negative integer"
  ([capacity]
    (ShortBuffer/allocate capacity)))

(defn *wrap
  "Wraps a short array into a buffer.

    The new buffer will be backed by the given short array;
   that is, modifications to the buffer will cause the array to be modified
   and vice versa.  The new buffer's capacity will be
   array.length, its position will be offset, its limit
   will be offset  length, and its mark will be undefined.  Its
   backing array will be the given array, and
   its array offset will be zero.

  array - The array that will back the new buffer - `short[]`
  offset - The offset of the subarray to be used; must be non-negative and no larger than array.length. The new buffer's position will be set to this value. - `int`
  length - The length of the subarray to be used; must be non-negative and no larger than array.length - offset. The new buffer's limit will be set to offset length. - `int`

  returns: The new short buffer - `java.nio.ShortBuffer`

  throws: java.lang.IndexOutOfBoundsException - If the preconditions on the offset and length parameters do not hold"
  ([array offset length]
    (ShortBuffer/wrap array offset length))
  ([array]
    (ShortBuffer/wrap array)))

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
  ([this]
    (-> this (.arrayOffset))))

(defn compact
  "Compacts this buffer  (optional operation).

    The shorts between the buffer's current position and its limit,
   if any, are copied to the beginning of the buffer.  That is, the
   short at index p = position() is copied
   to index zero, the short at index p  1 is copied
   to index one, and so forth until the short at index
   limit() - 1 is copied to index
   n = limit() - 1 - p.
   The buffer's position is then set to n+1 and its limit is set to
   its capacity.  The mark, if defined, is discarded.

    The buffer's position is set to the number of shorts copied,
   rather than to zero, so that an invocation of this method can be
   followed immediately by an invocation of another relative put
   method.

  returns: This buffer - `java.nio.ShortBuffer`

  throws: java.nio.ReadOnlyBufferException - If this buffer is read-only"
  ([this]
    (-> this (.compact))))

(defn put
  "Relative bulk put method  (optional operation).

    This method transfers shorts into this buffer from the given
   source array.  If there are more shorts to be copied from the array
   than remain in this buffer, that is, if
   length > remaining(), then no
   shorts are transferred and a BufferOverflowException is
   thrown.

    Otherwise, this method copies length shorts from the
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

  src - The array from which shorts are to be read - `short[]`
  offset - The offset within the array of the first short to be read; must be non-negative and no larger than array.length - `int`
  length - The number of shorts to be read from the given array; must be non-negative and no larger than array.length - offset - `int`

  returns: This buffer - `java.nio.ShortBuffer`

  throws: java.nio.BufferOverflowException - If there is insufficient space in this buffer"
  ([this src offset length]
    (-> this (.put src offset length)))
  ([this index s]
    (-> this (.put index s)))
  ([this s]
    (-> this (.put s))))

(defn to-string
  "Returns a string summarizing the state of this buffer.

  returns: A summary string - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn duplicate
  "Creates a new short buffer that shares this buffer's content.

    The content of the new buffer will be that of this buffer.  Changes
   to this buffer's content will be visible in the new buffer, and vice
   versa; the two buffers' position, limit, and mark values will be
   independent.

    The new buffer's capacity, limit, position, and mark values will be
   identical to those of this buffer.  The new buffer will be direct if,
   and only if, this buffer is direct, and it will be read-only if, and
   only if, this buffer is read-only.

  returns: The new short buffer - `java.nio.ShortBuffer`"
  ([this]
    (-> this (.duplicate))))

(defn has-array?
  "Tells whether or not this buffer is backed by an accessible short
   array.

    If this method returns true then the array
   and arrayOffset methods may safely be invoked.

  returns: true if, and only if, this buffer
            is backed by an array and is not read-only - `boolean`"
  ([this]
    (-> this (.hasArray))))

(defn direct?
  "Tells whether or not this short buffer is direct.

  returns: true if, and only if, this buffer is direct - `boolean`"
  ([this]
    (-> this (.isDirect))))

(defn order
  "Retrieves this buffer's byte order.

    The byte order of a short buffer created by allocation or by
   wrapping an existing short array is the native order of the underlying
   hardware.  The byte order of a short buffer created as a view of a byte buffer is that of the
   byte buffer at the moment that the view is created.

  returns: This buffer's byte order - `java.nio.ByteOrder`"
  ([this]
    (-> this (.order))))

(defn slice
  "Creates a new short buffer whose content is a shared subsequence of
   this buffer's content.

    The content of the new buffer will start at this buffer's current
   position.  Changes to this buffer's content will be visible in the new
   buffer, and vice versa; the two buffers' position, limit, and mark
   values will be independent.

    The new buffer's position will be zero, its capacity and its limit
   will be the number of shorts remaining in this buffer, and its mark
   will be undefined.  The new buffer will be direct if, and only if, this
   buffer is direct, and it will be read-only if, and only if, this buffer
   is read-only.

  returns: The new short buffer - `java.nio.ShortBuffer`"
  ([this]
    (-> this (.slice))))

(defn hash-code
  "Returns the current hash code of this buffer.

    The hash code of a short buffer depends only upon its remaining
   elements; that is, upon the elements from position() up to, and
   including, the element at limit() - 1.

    Because buffer hash codes are content-dependent, it is inadvisable
   to use buffers as keys in hash maps or similar data structures unless it
   is known that their contents will not change.

  returns: The current hash code of this buffer - `int`"
  ([this]
    (-> this (.hashCode))))

(defn compare-to
  "Compares this buffer to another.

    Two short buffers are compared by comparing their sequences of
   remaining elements lexicographically, without regard to the starting
   position of each sequence within its corresponding buffer.








   Pairs of short elements are compared as if by invoking
   Short.compare(short,short).


    A short buffer is not comparable to any other type of object.

  that - the object to be compared. - `java.nio.ShortBuffer`

  returns: A negative integer, zero, or a positive integer as this buffer
            is less than, equal to, or greater than the given buffer - `int`"
  ([this that]
    (-> this (.compareTo that))))

(defn get
  "Relative bulk get method.

    This method transfers shorts from this buffer into the given
   destination array.  If there are fewer shorts remaining in the
   buffer than are required to satisfy the request, that is, if
   length > remaining(), then no
   shorts are transferred and a BufferUnderflowException is
   thrown.

    Otherwise, this method copies length shorts from this
   buffer into the given array, starting at the current position of this
   buffer and at the given offset in the array.  The position of this
   buffer is then incremented by length.

    In other words, an invocation of this method of the form
   src.get(dst, off, len) has exactly the same effect as
   the loop



       for (int i = off; i < off  len; i++)
           dst[i] = src.get():

   except that it first checks that there are sufficient shorts in
   this buffer and it is potentially much more efficient.

  dst - The array into which shorts are to be written - `short[]`
  offset - The offset within the array of the first short to be written; must be non-negative and no larger than dst.length - `int`
  length - The maximum number of shorts to be written to the given array; must be non-negative and no larger than dst.length - offset - `int`

  returns: This buffer - `java.nio.ShortBuffer`

  throws: java.nio.BufferUnderflowException - If there are fewer than length shorts remaining in this buffer"
  ([this dst offset length]
    (-> this (.get dst offset length)))
  ([this index]
    (-> this (.get index)))
  ([this]
    (-> this (.get))))

(defn equals
  "Tells whether or not this buffer is equal to another object.

    Two short buffers are equal if, and only if,



      They have the same element type,

      They have the same number of remaining elements, and


      The two sequences of remaining elements, considered
     independently of their starting positions, are pointwise equal.











    A short buffer is not equal to any other type of object.

  ob - The object to which this buffer is to be compared - `java.lang.Object`

  returns: true if, and only if, this buffer is equal to the
             given object - `boolean`"
  ([this ob]
    (-> this (.equals ob))))

(defn array
  "Returns the short array that backs this
   buffer  (optional operation).

    Modifications to this buffer's content will cause the returned
   array's content to be modified, and vice versa.

    Invoke the hasArray method before invoking this
   method in order to ensure that this buffer has an accessible backing
   array.

  returns: The array that backs this buffer - `short[]`

  throws: java.nio.ReadOnlyBufferException - If this buffer is backed by an array but is read-only"
  ([this]
    (-> this (.array))))

(defn as-read-only-buffer
  "Creates a new, read-only short buffer that shares this buffer's
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

  returns: The new, read-only short buffer - `java.nio.ShortBuffer`"
  ([this]
    (-> this (.asReadOnlyBuffer))))

