(ns jdk.nio.ByteBuffer
  "A byte buffer.

   This class defines six categories of operations upon
  byte buffers:



     Absolute and relative get and
    put methods that read and write
    single bytes;

     Relative bulk get
    methods that transfer contiguous sequences of bytes from this buffer
    into an array;

     Relative bulk put
    methods that transfer contiguous sequences of bytes from a
    byte array or some other byte
    buffer into this buffer;



     Absolute and relative get
    and put methods that read and
    write values of other primitive types, translating them to and from
    sequences of bytes in a particular byte order;

     Methods for creating view buffers,
    which allow a byte buffer to be viewed as a buffer containing values of
    some other primitive type; and



     Methods for compacting, duplicating, and slicing
    a byte buffer.



   Byte buffers can be created either by allocation, which allocates space for the buffer's



  content, or by wrapping an
  existing byte array  into a buffer.












   Direct vs. non-direct buffers

   A byte buffer is either direct or non-direct.  Given a
  direct byte buffer, the Java virtual machine will make a best effort to
  perform native I/O operations directly upon it.  That is, it will attempt to
  avoid copying the buffer's content to (or from) an intermediate buffer
  before (or after) each invocation of one of the underlying operating
  system's native I/O operations.

   A direct byte buffer may be created by invoking the allocateDirect factory method of this class.  The
  buffers returned by this method typically have somewhat higher allocation
  and deallocation costs than non-direct buffers.  The contents of direct
  buffers may reside outside of the normal garbage-collected heap, and so
  their impact upon the memory footprint of an application might not be
  obvious.  It is therefore recommended that direct buffers be allocated
  primarily for large, long-lived buffers that are subject to the underlying
  system's native I/O operations.  In general it is best to allocate direct
  buffers only when they yield a measureable gain in program performance.

   A direct byte buffer may also be created by mapping a region of a file
  directly into memory.  An implementation of the Java platform may optionally
  support the creation of direct byte buffers from native code via JNI.  If an
  instance of one of these kinds of buffers refers to an inaccessible region
  of memory then an attempt to access that region will not change the buffer's
  content and will cause an unspecified exception to be thrown either at the
  time of the access or at some later time.

   Whether a byte buffer is direct or non-direct may be determined by
  invoking its isDirect method.  This method is provided so
  that explicit buffer management can be done in performance-critical code.



   Access to binary data

   This class defines methods for reading and writing values of all other
  primitive types, except boolean.  Primitive values are translated
  to (or from) sequences of bytes according to the buffer's current byte
  order, which may be retrieved and modified via the order
  methods.  Specific byte orders are represented by instances of the ByteOrder class.  The initial order of a byte buffer is always BIG_ENDIAN.

   For access to heterogeneous binary data, that is, sequences of values of
  different types, this class defines a family of absolute and relative
  get and put methods for each type.  For 32-bit floating-point
  values, for example, this class defines:



  float  getFloat()
  float  getFloat(int index)
   void  putFloat(float f)
   void  putFloat(int index, float f)

   Corresponding methods are defined for the types char,
  short, int, long, and double.  The index
  parameters of the absolute get and put methods are in terms of
  bytes rather than of the type being read or written.



   For access to homogeneous binary data, that is, sequences of values of
  the same type, this class defines methods that can create views of a
  given byte buffer.  A view buffer is simply another buffer whose
  content is backed by the byte buffer.  Changes to the byte buffer's content
  will be visible in the view buffer, and vice versa; the two buffers'
  position, limit, and mark values are independent.  The asFloatBuffer method, for example, creates an instance of
  the FloatBuffer class that is backed by the byte buffer upon which
  the method is invoked.  Corresponding view-creation methods are defined for
  the types char, short, int, long, and
  double.

   View buffers have three important advantages over the families of
  type-specific get and put methods described above:



     A view buffer is indexed not in terms of bytes but rather in terms
    of the type-specific size of its values;

     A view buffer provides relative bulk get and put
    methods that can transfer contiguous sequences of values between a buffer
    and an array or some other buffer of the same type; and

     A view buffer is potentially much more efficient because it will
    be direct if, and only if, its backing byte buffer is direct.



   The byte order of a view buffer is fixed to be that of its byte buffer
  at the time that the view is created.

























   Invocation chaining


   Methods in this class that do not otherwise have a value to return are
  specified to return the buffer upon which they are invoked.  This allows
  method invocations to be chained.



  The sequence of statements



  bb.putInt(0xCAFEBABE);
  bb.putShort(3);
  bb.putShort(45);

  can, for example, be replaced by the single statement



  bb.putInt(0xCAFEBABE).putShort(3).putShort(45);"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio ByteBuffer]))

(defn *allocate-direct
  "Allocates a new direct byte buffer.

    The new buffer's position will be zero, its limit will be its
   capacity, its mark will be undefined, and each of its elements will be
   initialized to zero.  Whether or not it has a
   backing array is unspecified.

  capacity - The new buffer's capacity, in bytes - `int`

  returns: The new byte buffer - `java.nio.ByteBuffer`

  throws: java.lang.IllegalArgumentException - If the capacity is a negative integer"
  (^java.nio.ByteBuffer [^Integer capacity]
    (ByteBuffer/allocateDirect capacity)))

(defn *allocate
  "Allocates a new byte buffer.

    The new buffer's position will be zero, its limit will be its
   capacity, its mark will be undefined, and each of its elements will be
   initialized to zero.  It will have a backing array,
   and its array offset will be zero.

  capacity - The new buffer's capacity, in bytes - `int`

  returns: The new byte buffer - `java.nio.ByteBuffer`

  throws: java.lang.IllegalArgumentException - If the capacity is a negative integer"
  (^java.nio.ByteBuffer [^Integer capacity]
    (ByteBuffer/allocate capacity)))

(defn *wrap
  "Wraps a byte array into a buffer.

    The new buffer will be backed by the given byte array;
   that is, modifications to the buffer will cause the array to be modified
   and vice versa.  The new buffer's capacity will be
   array.length, its position will be offset, its limit
   will be offset  length, and its mark will be undefined.  Its
   backing array will be the given array, and
   its array offset will be zero.

  array - The array that will back the new buffer - `byte[]`
  offset - The offset of the subarray to be used; must be non-negative and no larger than array.length. The new buffer's position will be set to this value. - `int`
  length - The length of the subarray to be used; must be non-negative and no larger than array.length - offset. The new buffer's limit will be set to offset length. - `int`

  returns: The new byte buffer - `java.nio.ByteBuffer`

  throws: java.lang.IndexOutOfBoundsException - If the preconditions on the offset and length parameters do not hold"
  (^java.nio.ByteBuffer [array ^Integer offset ^Integer length]
    (ByteBuffer/wrap array offset length))
  (^java.nio.ByteBuffer [array]
    (ByteBuffer/wrap array)))

(defn put-int
  "Absolute put method for writing an int
   value  (optional operation).

    Writes four bytes containing the given int value, in the
   current byte order, into this buffer at the given index.

  index - The index at which the bytes will be written - `int`
  value - The int value to be written - `int`

  returns: This buffer - `java.nio.ByteBuffer`

  throws: java.lang.IndexOutOfBoundsException - If index is negative or not smaller than the buffer's limit, minus three"
  (^java.nio.ByteBuffer [^ByteBuffer this ^Integer index ^Integer value]
    (-> this (.putInt index value)))
  (^java.nio.ByteBuffer [^ByteBuffer this ^Integer value]
    (-> this (.putInt value))))

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
  (^Integer [^ByteBuffer this]
    (-> this (.arrayOffset))))

(defn compact
  "Compacts this buffer  (optional operation).

    The bytes between the buffer's current position and its limit,
   if any, are copied to the beginning of the buffer.  That is, the
   byte at index p = position() is copied
   to index zero, the byte at index p  1 is copied
   to index one, and so forth until the byte at index
   limit() - 1 is copied to index
   n = limit() - 1 - p.
   The buffer's position is then set to n+1 and its limit is set to
   its capacity.  The mark, if defined, is discarded.

    The buffer's position is set to the number of bytes copied,
   rather than to zero, so that an invocation of this method can be
   followed immediately by an invocation of another relative put
   method.



    Invoke this method after writing data from a buffer in case the
   write was incomplete.  The following loop, for example, copies bytes
   from one channel to another via the buffer buf:



     buf.clear();          // Prepare buffer for use
     while (in.read(buf) >= 0 || buf.position != 0) {
         buf.flip();
         out.write(buf);
         buf.compact();    // In case of partial write
     }

  returns: This buffer - `java.nio.ByteBuffer`

  throws: java.nio.ReadOnlyBufferException - If this buffer is read-only"
  (^java.nio.ByteBuffer [^ByteBuffer this]
    (-> this (.compact))))

(defn put-short
  "Absolute put method for writing a short
   value  (optional operation).

    Writes two bytes containing the given short value, in the
   current byte order, into this buffer at the given index.

  index - The index at which the bytes will be written - `int`
  value - The short value to be written - `short`

  returns: This buffer - `java.nio.ByteBuffer`

  throws: java.lang.IndexOutOfBoundsException - If index is negative or not smaller than the buffer's limit, minus one"
  (^java.nio.ByteBuffer [^ByteBuffer this ^Integer index ^Short value]
    (-> this (.putShort index value)))
  (^java.nio.ByteBuffer [^ByteBuffer this ^Short value]
    (-> this (.putShort value))))

(defn put-char
  "Absolute put method for writing a char
   value  (optional operation).

    Writes two bytes containing the given char value, in the
   current byte order, into this buffer at the given index.

  index - The index at which the bytes will be written - `int`
  value - The char value to be written - `char`

  returns: This buffer - `java.nio.ByteBuffer`

  throws: java.lang.IndexOutOfBoundsException - If index is negative or not smaller than the buffer's limit, minus one"
  (^java.nio.ByteBuffer [^ByteBuffer this ^Integer index ^Character value]
    (-> this (.putChar index value)))
  (^java.nio.ByteBuffer [^ByteBuffer this ^Character value]
    (-> this (.putChar value))))

(defn put
  "Relative bulk put method  (optional operation).

    This method transfers bytes into this buffer from the given
   source array.  If there are more bytes to be copied from the array
   than remain in this buffer, that is, if
   length > remaining(), then no
   bytes are transferred and a BufferOverflowException is
   thrown.

    Otherwise, this method copies length bytes from the
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

  src - The array from which bytes are to be read - `byte[]`
  offset - The offset within the array of the first byte to be read; must be non-negative and no larger than array.length - `int`
  length - The number of bytes to be read from the given array; must be non-negative and no larger than array.length - offset - `int`

  returns: This buffer - `java.nio.ByteBuffer`

  throws: java.nio.BufferOverflowException - If there is insufficient space in this buffer"
  (^java.nio.ByteBuffer [^ByteBuffer this src ^Integer offset ^Integer length]
    (-> this (.put src offset length)))
  (^java.nio.ByteBuffer [^ByteBuffer this ^Integer index ^Byte b]
    (-> this (.put index b)))
  (^java.nio.ByteBuffer [^ByteBuffer this ^Byte b]
    (-> this (.put b))))

(defn get-short
  "Absolute get method for reading a short value.

    Reads two bytes at the given index, composing them into a
   short value according to the current byte order.

  index - The index from which the bytes will be read - `int`

  returns: The short value at the given index - `short`

  throws: java.lang.IndexOutOfBoundsException - If index is negative or not smaller than the buffer's limit, minus one"
  (^Short [^ByteBuffer this ^Integer index]
    (-> this (.getShort index)))
  (^Short [^ByteBuffer this]
    (-> this (.getShort))))

(defn as-long-buffer
  "Creates a view of this byte buffer as a long buffer.

    The content of the new buffer will start at this buffer's current
   position.  Changes to this buffer's content will be visible in the new
   buffer, and vice versa; the two buffers' position, limit, and mark
   values will be independent.

    The new buffer's position will be zero, its capacity and its limit
   will be the number of bytes remaining in this buffer divided by
   eight, and its mark will be undefined.  The new buffer will be direct
   if, and only if, this buffer is direct, and it will be read-only if, and
   only if, this buffer is read-only.

  returns: A new long buffer - `java.nio.LongBuffer`"
  (^java.nio.LongBuffer [^ByteBuffer this]
    (-> this (.asLongBuffer))))

(defn to-string
  "Returns a string summarizing the state of this buffer.

  returns: A summary string - `java.lang.String`"
  (^java.lang.String [^ByteBuffer this]
    (-> this (.toString))))

(defn put-float
  "Absolute put method for writing a float
   value  (optional operation).

    Writes four bytes containing the given float value, in the
   current byte order, into this buffer at the given index.

  index - The index at which the bytes will be written - `int`
  value - The float value to be written - `float`

  returns: This buffer - `java.nio.ByteBuffer`

  throws: java.lang.IndexOutOfBoundsException - If index is negative or not smaller than the buffer's limit, minus three"
  (^java.nio.ByteBuffer [^ByteBuffer this ^Integer index ^Float value]
    (-> this (.putFloat index value)))
  (^java.nio.ByteBuffer [^ByteBuffer this ^Float value]
    (-> this (.putFloat value))))

(defn as-short-buffer
  "Creates a view of this byte buffer as a short buffer.

    The content of the new buffer will start at this buffer's current
   position.  Changes to this buffer's content will be visible in the new
   buffer, and vice versa; the two buffers' position, limit, and mark
   values will be independent.

    The new buffer's position will be zero, its capacity and its limit
   will be the number of bytes remaining in this buffer divided by
   two, and its mark will be undefined.  The new buffer will be direct
   if, and only if, this buffer is direct, and it will be read-only if, and
   only if, this buffer is read-only.

  returns: A new short buffer - `java.nio.ShortBuffer`"
  (^java.nio.ShortBuffer [^ByteBuffer this]
    (-> this (.asShortBuffer))))

(defn as-double-buffer
  "Creates a view of this byte buffer as a double buffer.

    The content of the new buffer will start at this buffer's current
   position.  Changes to this buffer's content will be visible in the new
   buffer, and vice versa; the two buffers' position, limit, and mark
   values will be independent.

    The new buffer's position will be zero, its capacity and its limit
   will be the number of bytes remaining in this buffer divided by
   eight, and its mark will be undefined.  The new buffer will be direct
   if, and only if, this buffer is direct, and it will be read-only if, and
   only if, this buffer is read-only.

  returns: A new double buffer - `java.nio.DoubleBuffer`"
  (^java.nio.DoubleBuffer [^ByteBuffer this]
    (-> this (.asDoubleBuffer))))

(defn duplicate
  "Creates a new byte buffer that shares this buffer's content.

    The content of the new buffer will be that of this buffer.  Changes
   to this buffer's content will be visible in the new buffer, and vice
   versa; the two buffers' position, limit, and mark values will be
   independent.

    The new buffer's capacity, limit, position, and mark values will be
   identical to those of this buffer.  The new buffer will be direct if,
   and only if, this buffer is direct, and it will be read-only if, and
   only if, this buffer is read-only.

  returns: The new byte buffer - `java.nio.ByteBuffer`"
  (^java.nio.ByteBuffer [^ByteBuffer this]
    (-> this (.duplicate))))

(defn get-long
  "Absolute get method for reading a long value.

    Reads eight bytes at the given index, composing them into a
   long value according to the current byte order.

  index - The index from which the bytes will be read - `int`

  returns: The long value at the given index - `long`

  throws: java.lang.IndexOutOfBoundsException - If index is negative or not smaller than the buffer's limit, minus seven"
  (^Long [^ByteBuffer this ^Integer index]
    (-> this (.getLong index)))
  (^Long [^ByteBuffer this]
    (-> this (.getLong))))

(defn has-array?
  "Tells whether or not this buffer is backed by an accessible byte
   array.

    If this method returns true then the array
   and arrayOffset methods may safely be invoked.

  returns: true if, and only if, this buffer
            is backed by an array and is not read-only - `boolean`"
  (^Boolean [^ByteBuffer this]
    (-> this (.hasArray))))

(defn get-int
  "Absolute get method for reading an int value.

    Reads four bytes at the given index, composing them into a
   int value according to the current byte order.

  index - The index from which the bytes will be read - `int`

  returns: The int value at the given index - `int`

  throws: java.lang.IndexOutOfBoundsException - If index is negative or not smaller than the buffer's limit, minus three"
  (^Integer [^ByteBuffer this ^Integer index]
    (-> this (.getInt index)))
  (^Integer [^ByteBuffer this]
    (-> this (.getInt))))

(defn put-double
  "Absolute put method for writing a double
   value  (optional operation).

    Writes eight bytes containing the given double value, in the
   current byte order, into this buffer at the given index.

  index - The index at which the bytes will be written - `int`
  value - The double value to be written - `double`

  returns: This buffer - `java.nio.ByteBuffer`

  throws: java.lang.IndexOutOfBoundsException - If index is negative or not smaller than the buffer's limit, minus seven"
  (^java.nio.ByteBuffer [^ByteBuffer this ^Integer index ^Double value]
    (-> this (.putDouble index value)))
  (^java.nio.ByteBuffer [^ByteBuffer this ^Double value]
    (-> this (.putDouble value))))

(defn get-char
  "Absolute get method for reading a char value.

    Reads two bytes at the given index, composing them into a
   char value according to the current byte order.

  index - The index from which the bytes will be read - `int`

  returns: The char value at the given index - `char`

  throws: java.lang.IndexOutOfBoundsException - If index is negative or not smaller than the buffer's limit, minus one"
  (^Character [^ByteBuffer this ^Integer index]
    (-> this (.getChar index)))
  (^Character [^ByteBuffer this]
    (-> this (.getChar))))

(defn direct?
  "Tells whether or not this byte buffer is direct.

  returns: true if, and only if, this buffer is direct - `boolean`"
  (^Boolean [^ByteBuffer this]
    (-> this (.isDirect))))

(defn order
  "Modifies this buffer's byte order.

  bo - The new byte order, either BIG_ENDIAN or LITTLE_ENDIAN - `java.nio.ByteOrder`

  returns: This buffer - `java.nio.ByteBuffer`"
  (^java.nio.ByteBuffer [^ByteBuffer this ^java.nio.ByteOrder bo]
    (-> this (.order bo)))
  (^java.nio.ByteOrder [^ByteBuffer this]
    (-> this (.order))))

(defn as-char-buffer
  "Creates a view of this byte buffer as a char buffer.

    The content of the new buffer will start at this buffer's current
   position.  Changes to this buffer's content will be visible in the new
   buffer, and vice versa; the two buffers' position, limit, and mark
   values will be independent.

    The new buffer's position will be zero, its capacity and its limit
   will be the number of bytes remaining in this buffer divided by
   two, and its mark will be undefined.  The new buffer will be direct
   if, and only if, this buffer is direct, and it will be read-only if, and
   only if, this buffer is read-only.

  returns: A new char buffer - `java.nio.CharBuffer`"
  (^java.nio.CharBuffer [^ByteBuffer this]
    (-> this (.asCharBuffer))))

(defn slice
  "Creates a new byte buffer whose content is a shared subsequence of
   this buffer's content.

    The content of the new buffer will start at this buffer's current
   position.  Changes to this buffer's content will be visible in the new
   buffer, and vice versa; the two buffers' position, limit, and mark
   values will be independent.

    The new buffer's position will be zero, its capacity and its limit
   will be the number of bytes remaining in this buffer, and its mark
   will be undefined.  The new buffer will be direct if, and only if, this
   buffer is direct, and it will be read-only if, and only if, this buffer
   is read-only.

  returns: The new byte buffer - `java.nio.ByteBuffer`"
  (^java.nio.ByteBuffer [^ByteBuffer this]
    (-> this (.slice))))

(defn hash-code
  "Returns the current hash code of this buffer.

    The hash code of a byte buffer depends only upon its remaining
   elements; that is, upon the elements from position() up to, and
   including, the element at limit() - 1.

    Because buffer hash codes are content-dependent, it is inadvisable
   to use buffers as keys in hash maps or similar data structures unless it
   is known that their contents will not change.

  returns: The current hash code of this buffer - `int`"
  (^Integer [^ByteBuffer this]
    (-> this (.hashCode))))

(defn compare-to
  "Compares this buffer to another.

    Two byte buffers are compared by comparing their sequences of
   remaining elements lexicographically, without regard to the starting
   position of each sequence within its corresponding buffer.








   Pairs of byte elements are compared as if by invoking
   Byte.compare(byte,byte).


    A byte buffer is not comparable to any other type of object.

  that - the object to be compared. - `java.nio.ByteBuffer`

  returns: A negative integer, zero, or a positive integer as this buffer
            is less than, equal to, or greater than the given buffer - `int`"
  (^Integer [^ByteBuffer this ^java.nio.ByteBuffer that]
    (-> this (.compareTo that))))

(defn get-float
  "Absolute get method for reading a float value.

    Reads four bytes at the given index, composing them into a
   float value according to the current byte order.

  index - The index from which the bytes will be read - `int`

  returns: The float value at the given index - `float`

  throws: java.lang.IndexOutOfBoundsException - If index is negative or not smaller than the buffer's limit, minus three"
  (^Float [^ByteBuffer this ^Integer index]
    (-> this (.getFloat index)))
  (^Float [^ByteBuffer this]
    (-> this (.getFloat))))

(defn get-double
  "Absolute get method for reading a double value.

    Reads eight bytes at the given index, composing them into a
   double value according to the current byte order.

  index - The index from which the bytes will be read - `int`

  returns: The double value at the given index - `double`

  throws: java.lang.IndexOutOfBoundsException - If index is negative or not smaller than the buffer's limit, minus seven"
  (^Double [^ByteBuffer this ^Integer index]
    (-> this (.getDouble index)))
  (^Double [^ByteBuffer this]
    (-> this (.getDouble))))

(defn put-long
  "Absolute put method for writing a long
   value  (optional operation).

    Writes eight bytes containing the given long value, in the
   current byte order, into this buffer at the given index.

  index - The index at which the bytes will be written - `int`
  value - The long value to be written - `long`

  returns: This buffer - `java.nio.ByteBuffer`

  throws: java.lang.IndexOutOfBoundsException - If index is negative or not smaller than the buffer's limit, minus seven"
  (^java.nio.ByteBuffer [^ByteBuffer this ^Integer index ^Long value]
    (-> this (.putLong index value)))
  (^java.nio.ByteBuffer [^ByteBuffer this ^Long value]
    (-> this (.putLong value))))

(defn get
  "Relative bulk get method.

    This method transfers bytes from this buffer into the given
   destination array.  If there are fewer bytes remaining in the
   buffer than are required to satisfy the request, that is, if
   length > remaining(), then no
   bytes are transferred and a BufferUnderflowException is
   thrown.

    Otherwise, this method copies length bytes from this
   buffer into the given array, starting at the current position of this
   buffer and at the given offset in the array.  The position of this
   buffer is then incremented by length.

    In other words, an invocation of this method of the form
   src.get(dst, off, len) has exactly the same effect as
   the loop



       for (int i = off; i < off  len; i++)
           dst[i] = src.get():

   except that it first checks that there are sufficient bytes in
   this buffer and it is potentially much more efficient.

  dst - The array into which bytes are to be written - `byte[]`
  offset - The offset within the array of the first byte to be written; must be non-negative and no larger than dst.length - `int`
  length - The maximum number of bytes to be written to the given array; must be non-negative and no larger than dst.length - offset - `int`

  returns: This buffer - `java.nio.ByteBuffer`

  throws: java.nio.BufferUnderflowException - If there are fewer than length bytes remaining in this buffer"
  (^java.nio.ByteBuffer [^ByteBuffer this dst ^Integer offset ^Integer length]
    (-> this (.get dst offset length)))
  (^Byte [^ByteBuffer this ^Integer index]
    (-> this (.get index)))
  (^Byte [^ByteBuffer this]
    (-> this (.get))))

(defn equals
  "Tells whether or not this buffer is equal to another object.

    Two byte buffers are equal if, and only if,



      They have the same element type,

      They have the same number of remaining elements, and


      The two sequences of remaining elements, considered
     independently of their starting positions, are pointwise equal.











    A byte buffer is not equal to any other type of object.

  ob - The object to which this buffer is to be compared - `java.lang.Object`

  returns: true if, and only if, this buffer is equal to the
             given object - `boolean`"
  (^Boolean [^ByteBuffer this ^java.lang.Object ob]
    (-> this (.equals ob))))

(defn array
  "Returns the byte array that backs this
   buffer  (optional operation).

    Modifications to this buffer's content will cause the returned
   array's content to be modified, and vice versa.

    Invoke the hasArray method before invoking this
   method in order to ensure that this buffer has an accessible backing
   array.

  returns: The array that backs this buffer - `byte[]`

  throws: java.nio.ReadOnlyBufferException - If this buffer is backed by an array but is read-only"
  ([^ByteBuffer this]
    (-> this (.array))))

(defn as-int-buffer
  "Creates a view of this byte buffer as an int buffer.

    The content of the new buffer will start at this buffer's current
   position.  Changes to this buffer's content will be visible in the new
   buffer, and vice versa; the two buffers' position, limit, and mark
   values will be independent.

    The new buffer's position will be zero, its capacity and its limit
   will be the number of bytes remaining in this buffer divided by
   four, and its mark will be undefined.  The new buffer will be direct
   if, and only if, this buffer is direct, and it will be read-only if, and
   only if, this buffer is read-only.

  returns: A new int buffer - `java.nio.IntBuffer`"
  (^java.nio.IntBuffer [^ByteBuffer this]
    (-> this (.asIntBuffer))))

(defn as-read-only-buffer
  "Creates a new, read-only byte buffer that shares this buffer's
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

  returns: The new, read-only byte buffer - `java.nio.ByteBuffer`"
  (^java.nio.ByteBuffer [^ByteBuffer this]
    (-> this (.asReadOnlyBuffer))))

(defn as-float-buffer
  "Creates a view of this byte buffer as a float buffer.

    The content of the new buffer will start at this buffer's current
   position.  Changes to this buffer's content will be visible in the new
   buffer, and vice versa; the two buffers' position, limit, and mark
   values will be independent.

    The new buffer's position will be zero, its capacity and its limit
   will be the number of bytes remaining in this buffer divided by
   four, and its mark will be undefined.  The new buffer will be direct
   if, and only if, this buffer is direct, and it will be read-only if, and
   only if, this buffer is read-only.

  returns: A new float buffer - `java.nio.FloatBuffer`"
  (^java.nio.FloatBuffer [^ByteBuffer this]
    (-> this (.asFloatBuffer))))

