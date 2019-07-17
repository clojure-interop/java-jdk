(ns jdk.util.BitSet
  "This class implements a vector of bits that grows as needed. Each
  component of the bit set has a boolean value. The
  bits of a BitSet are indexed by nonnegative integers.
  Individual indexed bits can be examined, set, or cleared. One
  BitSet may be used to modify the contents of another
  BitSet through logical AND, logical inclusive OR, and
  logical exclusive OR operations.

  By default, all bits in the set initially have the value
  false.

  Every bit set has a current size, which is the number of bits
  of space currently in use by the bit set. Note that the size is
  related to the implementation of a bit set, so it may change with
  implementation. The length of a bit set relates to logical length
  of a bit set and is defined independently of implementation.

  Unless otherwise noted, passing a null parameter to any of the
  methods in a BitSet will result in a
  NullPointerException.

  A BitSet is not safe for multithreaded use without
  external synchronization."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util BitSet]))

(defn ->bit-set
  "Constructor.

  Creates a bit set whose initial size is large enough to explicitly
   represent bits with indices in the range 0 through
   nbits-1. All bits are initially false.

  nbits - the initial size of the bit set - `int`

  throws: java.lang.NegativeArraySizeException - if the specified initial size is negative"
  ([^Integer nbits]
    (new BitSet nbits))
  ([]
    (new BitSet )))

(defn *value-of
  "Returns a new bit set containing all the bits in the given long array.

   More precisely,
   BitSet.valueOf(longs).get(n) == ((longs[n/64] & (1L<<(n%64))) != 0)
   for all n < 64 * longs.length.

   This method is equivalent to
   BitSet.valueOf(LongBuffer.wrap(longs)).

  longs - a long array containing a little-endian representation of a sequence of bits to be used as the initial bits of the new bit set - `long[]`

  returns: a BitSet containing all the bits in the long array - `java.util.BitSet`"
  (^java.util.BitSet [longs]
    (BitSet/valueOf longs)))

(defn to-long-array
  "Returns a new long array containing all the bits in this bit set.

   More precisely, if
   long[] longs = s.toLongArray();
   then longs.length == (s.length()+63)/64 and
   s.get(n) == ((longs[n/64] & (1L<<(n%64))) != 0)
   for all n < 64 * longs.length.

  returns: a long array containing a little-endian representation
           of all the bits in this bit set - `long[]`"
  ([^java.util.BitSet this]
    (-> this (.toLongArray))))

(defn previous-set-bit
  "Returns the index of the nearest bit that is set to true
   that occurs on or before the specified starting index.
   If no such bit exists, or if -1 is given as the
   starting index, then -1 is returned.

   To iterate over the true bits in a BitSet,
   use the following loop:



   for (int i = bs.length(); (i = bs.previousSetBit(i-1)) >= 0; ) {
       // operate on index i here
   }

  from-index - the index to start checking from (inclusive) - `int`

  returns: the index of the previous set bit, or -1 if there
           is no such bit - `int`

  throws: java.lang.IndexOutOfBoundsException - if the specified index is less than -1"
  (^Integer [^java.util.BitSet this ^Integer from-index]
    (-> this (.previousSetBit from-index))))

(defn stream
  "Returns a stream of indices for which this BitSet
   contains a bit in the set state. The indices are returned
   in order, from lowest to highest. The size of the stream
   is the number of bits in the set state, equal to the value
   returned by the cardinality() method.

   The bit set must remain constant during the execution of the
   terminal stream operation.  Otherwise, the result of the terminal
   stream operation is undefined.

  returns: a stream of integers representing set indices - `java.util..IntStream`"
  (^java.util..IntStream [^java.util.BitSet this]
    (-> this (.stream))))

(defn and-not
  "Clears all of the bits in this BitSet whose corresponding
   bit is set in the specified BitSet.

  set - the BitSet with which to mask this BitSet - `java.util.BitSet`"
  ([^java.util.BitSet this ^java.util.BitSet set]
    (-> this (.andNot set))))

(defn to-string
  "Returns a string representation of this bit set. For every index
   for which this BitSet contains a bit in the set
   state, the decimal representation of that index is included in
   the result. Such indices are listed in order from lowest to
   highest, separated by `, ` (a comma and a space) and
   surrounded by braces, resulting in the usual mathematical
   notation for a set of integers.

   Example:


   BitSet drPepper = new BitSet();
   Now drPepper.toString() returns `{}`.


   drPepper.set(2);
   Now drPepper.toString() returns `{2}`.


   drPepper.set(4);
   drPepper.set(10);
   Now drPepper.toString() returns `{2, 4, 10}`.

  returns: a string representation of this bit set - `java.lang.String`"
  (^java.lang.String [^java.util.BitSet this]
    (-> this (.toString))))

(defn flip
  "Sets each bit from the specified fromIndex (inclusive) to the
   specified toIndex (exclusive) to the complement of its current
   value.

  from-index - index of the first bit to flip - `int`
  to-index - index after the last bit to flip - `int`

  throws: java.lang.IndexOutOfBoundsException - if fromIndex is negative, or toIndex is negative, or fromIndex is larger than toIndex"
  ([^java.util.BitSet this ^Integer from-index ^Integer to-index]
    (-> this (.flip from-index to-index)))
  ([^java.util.BitSet this ^Integer bit-index]
    (-> this (.flip bit-index))))

(defn or
  "Performs a logical OR of this bit set with the bit set
   argument. This bit set is modified so that a bit in it has the
   value true if and only if it either already had the
   value true or the corresponding bit in the bit set
   argument has the value true.

  set - a bit set - `java.util.BitSet`"
  ([^java.util.BitSet this ^java.util.BitSet set]
    (-> this (.or set))))

(defn length
  "Returns the `logical size` of this BitSet: the index of
   the highest set bit in the BitSet plus one. Returns zero
   if the BitSet contains no set bits.

  returns: the logical size of this BitSet - `int`"
  (^Integer [^java.util.BitSet this]
    (-> this (.length))))

(defn and
  "Performs a logical AND of this target bit set with the
   argument bit set. This bit set is modified so that each bit in it
   has the value true if and only if it both initially
   had the value true and the corresponding bit in the
   bit set argument also had the value true.

  set - a bit set - `java.util.BitSet`"
  ([^java.util.BitSet this ^java.util.BitSet set]
    (-> this (.and set))))

(defn previous-clear-bit
  "Returns the index of the nearest bit that is set to false
   that occurs on or before the specified starting index.
   If no such bit exists, or if -1 is given as the
   starting index, then -1 is returned.

  from-index - the index to start checking from (inclusive) - `int`

  returns: the index of the previous clear bit, or -1 if there
           is no such bit - `int`

  throws: java.lang.IndexOutOfBoundsException - if the specified index is less than -1"
  (^Integer [^java.util.BitSet this ^Integer from-index]
    (-> this (.previousClearBit from-index))))

(defn next-clear-bit
  "Returns the index of the first bit that is set to false
   that occurs on or after the specified starting index.

  from-index - the index to start checking from (inclusive) - `int`

  returns: the index of the next clear bit - `int`

  throws: java.lang.IndexOutOfBoundsException - if the specified index is negative"
  (^Integer [^java.util.BitSet this ^Integer from-index]
    (-> this (.nextClearBit from-index))))

(defn clone
  "Cloning this BitSet produces a new BitSet
   that is equal to it.
   The clone of the bit set is another bit set that has exactly the
   same bits set to true as this bit set.

  returns: a clone of this bit set - `java.lang.Object`"
  (^java.lang.Object [^java.util.BitSet this]
    (-> this (.clone))))

(defn hash-code
  "Returns the hash code value for this bit set. The hash code depends
   only on which bits are set within this BitSet.

   The hash code is defined to be the result of the following
   calculation:


   public int hashCode() {
       long h = 1234;
       long[] words = toLongArray();
       for (int i = words.length; --i >= 0; )
           h ^= words[i] * (i  1);
       return (int)((h >> 32) ^ h);
   }
   Note that the hash code changes if the set of bits is altered.

  returns: the hash code value for this bit set - `int`"
  (^Integer [^java.util.BitSet this]
    (-> this (.hashCode))))

(defn set
  "Sets the bits from the specified fromIndex (inclusive) to the
   specified toIndex (exclusive) to the specified value.

  from-index - index of the first bit to be set - `int`
  to-index - index after the last bit to be set - `int`
  value - value to set the selected bits to - `boolean`

  throws: java.lang.IndexOutOfBoundsException - if fromIndex is negative, or toIndex is negative, or fromIndex is larger than toIndex"
  ([^java.util.BitSet this ^Integer from-index ^Integer to-index ^Boolean value]
    (-> this (.set from-index to-index value)))
  ([^java.util.BitSet this ^Integer bit-index ^Boolean value]
    (-> this (.set bit-index value)))
  ([^java.util.BitSet this ^Integer bit-index]
    (-> this (.set bit-index))))

(defn empty?
  "Returns true if this BitSet contains no bits that are set
   to true.

  returns: boolean indicating whether this BitSet is empty - `boolean`"
  (^Boolean [^java.util.BitSet this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of bits of space actually in use by this
   BitSet to represent bit values.
   The maximum element in the set is the size - 1st element.

  returns: the number of bits currently in this bit set - `int`"
  (^Integer [^java.util.BitSet this]
    (-> this (.size))))

(defn clear
  "Sets the bits from the specified fromIndex (inclusive) to the
   specified toIndex (exclusive) to false.

  from-index - index of the first bit to be cleared - `int`
  to-index - index after the last bit to be cleared - `int`

  throws: java.lang.IndexOutOfBoundsException - if fromIndex is negative, or toIndex is negative, or fromIndex is larger than toIndex"
  ([^java.util.BitSet this ^Integer from-index ^Integer to-index]
    (-> this (.clear from-index to-index)))
  ([^java.util.BitSet this ^Integer bit-index]
    (-> this (.clear bit-index)))
  ([^java.util.BitSet this]
    (-> this (.clear))))

(defn cardinality
  "Returns the number of bits set to true in this BitSet.

  returns: the number of bits set to true in this BitSet - `int`"
  (^Integer [^java.util.BitSet this]
    (-> this (.cardinality))))

(defn get
  "Returns a new BitSet composed of bits from this BitSet
   from fromIndex (inclusive) to toIndex (exclusive).

  from-index - index of the first bit to include - `int`
  to-index - index after the last bit to include - `int`

  returns: a new BitSet from a range of this BitSet - `java.util.BitSet`

  throws: java.lang.IndexOutOfBoundsException - if fromIndex is negative, or toIndex is negative, or fromIndex is larger than toIndex"
  (^java.util.BitSet [^java.util.BitSet this ^Integer from-index ^Integer to-index]
    (-> this (.get from-index to-index)))
  (^Boolean [^java.util.BitSet this ^Integer bit-index]
    (-> this (.get bit-index))))

(defn to-byte-array
  "Returns a new byte array containing all the bits in this bit set.

   More precisely, if
   byte[] bytes = s.toByteArray();
   then bytes.length == (s.length()+7)/8 and
   s.get(n) == ((bytes[n/8] & (1<<(n%8))) != 0)
   for all n < 8 * bytes.length.

  returns: a byte array containing a little-endian representation
           of all the bits in this bit set - `byte[]`"
  ([^java.util.BitSet this]
    (-> this (.toByteArray))))

(defn equals
  "Compares this object against the specified object.
   The result is true if and only if the argument is
   not null and is a Bitset object that has
   exactly the same set of bits set to true as this bit
   set. That is, for every nonnegative int index k,


  ((BitSet)obj).get(k) == this.get(k)
   must be true. The current sizes of the two bit sets are not compared.

  obj - the object to compare with - `java.lang.Object`

  returns: true if the objects are the same;
           false otherwise - `boolean`"
  (^Boolean [^java.util.BitSet this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn intersects
  "Returns true if the specified BitSet has any bits set to
   true that are also set to true in this BitSet.

  set - BitSet to intersect with - `java.util.BitSet`

  returns: boolean indicating whether this BitSet intersects
           the specified BitSet - `boolean`"
  (^Boolean [^java.util.BitSet this ^java.util.BitSet set]
    (-> this (.intersects set))))

(defn xor
  "Performs a logical XOR of this bit set with the bit set
   argument. This bit set is modified so that a bit in it has the
   value true if and only if one of the following
   statements holds:

   The bit initially has the value true, and the
       corresponding bit in the argument has the value false.
   The bit initially has the value false, and the
       corresponding bit in the argument has the value true.

  set - a bit set - `java.util.BitSet`"
  ([^java.util.BitSet this ^java.util.BitSet set]
    (-> this (.xor set))))

(defn next-set-bit
  "Returns the index of the first bit that is set to true
   that occurs on or after the specified starting index. If no such
   bit exists then -1 is returned.

   To iterate over the true bits in a BitSet,
   use the following loop:



   for (int i = bs.nextSetBit(0); i >= 0; i = bs.nextSetBit(i+1)) {
       // operate on index i here
       if (i == Integer.MAX_VALUE) {
           break; // or (i+1) would overflow
       }
   }

  from-index - the index to start checking from (inclusive) - `int`

  returns: the index of the next set bit, or -1 if there
           is no such bit - `int`

  throws: java.lang.IndexOutOfBoundsException - if the specified index is negative"
  (^Integer [^java.util.BitSet this ^Integer from-index]
    (-> this (.nextSetBit from-index))))

