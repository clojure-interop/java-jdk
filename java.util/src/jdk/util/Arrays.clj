(ns jdk.util.Arrays
  "This class contains various methods for manipulating arrays (such as
  sorting and searching). This class also contains a static factory
  that allows arrays to be viewed as lists.

  The methods in this class all throw a NullPointerException,
  if the specified array reference is null, except where noted.

  The documentation for the methods contained in this class includes
  briefs description of the implementations. Such descriptions should
  be regarded as implementation notes, rather than parts of the
  specification. Implementors should feel free to substitute other
  algorithms, so long as the specification itself is adhered to. (For
  example, the algorithm used by sort(Object[]) does not have to be
  a MergeSort, but it does have to be stable.)

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Arrays]))

(defn *stream
  "Returns a sequential Stream with the specified range of the
   specified array as its source.

  array - the array, assumed to be unmodified during use - `T[]`
  start-inclusive - the first index to cover, inclusive - `int`
  end-exclusive - index immediately past the last index to cover - `int`

  returns: a Stream for the array range - `<T> java.util..Stream<T>`

  throws: java.lang.ArrayIndexOutOfBoundsException - if startInclusive is negative, endExclusive is less than startInclusive, or endExclusive is greater than the array size"
  ([array ^Integer start-inclusive ^Integer end-exclusive]
    (Arrays/stream array start-inclusive end-exclusive))
  ([array]
    (Arrays/stream array)))

(defn *spliterator
  "Returns a Spliterator covering the specified range of the
   specified array.

   The spliterator reports Spliterator.SIZED,
   Spliterator.SUBSIZED, Spliterator.ORDERED, and
   Spliterator.IMMUTABLE.

  array - the array, assumed to be unmodified during use - `T[]`
  start-inclusive - the first index to cover, inclusive - `int`
  end-exclusive - index immediately past the last index to cover - `int`

  returns: a spliterator for the array elements - `<T> java.util.Spliterator<T>`

  throws: java.lang.ArrayIndexOutOfBoundsException - if startInclusive is negative, endExclusive is less than startInclusive, or endExclusive is greater than the array size"
  ([array ^Integer start-inclusive ^Integer end-exclusive]
    (Arrays/spliterator array start-inclusive end-exclusive))
  ([array]
    (Arrays/spliterator array)))

(defn *parallel-set-all
  "Set all elements of the specified array, in parallel, using the
   provided generator function to compute each element.

   If the generator function throws an exception, an unchecked exception
   is thrown from parallelSetAll and the array is left in an
   indeterminate state.

  array - array to be initialized - `T[]`
  generator - a function accepting an index and producing the desired value for that position - `T>`

  returns: `<T> void`

  throws: java.lang.NullPointerException - if the generator is null"
  ([array generator]
    (Arrays/parallelSetAll array generator)))

(defn *as-list
  "Returns a fixed-size list backed by the specified array.  (Changes to
   the returned list `write through` to the array.)  This method acts
   as bridge between array-based and collection-based APIs, in
   combination with Collection.toArray().  The returned list is
   serializable and implements RandomAccess.

   This method also provides a convenient way to create a fixed-size
   list initialized to contain several elements:


       List<String> stooges = Arrays.asList(`Larry`, `Moe`, `Curly`);

  a - the array by which the list will be backed - `T`

  returns: a list view of the specified array - `java.lang.   <T> java.util.List<T>`"
  ([a]
    (Arrays/asList a)))

(defn *set-all
  "Set all elements of the specified array, using the provided
   generator function to compute each element.

   If the generator function throws an exception, it is relayed to
   the caller and the array is left in an indeterminate state.

  array - array to be initialized - `T[]`
  generator - a function accepting an index and producing the desired value for that position - `T>`

  returns: `<T> void`

  throws: java.lang.NullPointerException - if the generator is null"
  ([array generator]
    (Arrays/setAll array generator)))

(defn *deep-equals
  "Returns true if the two specified arrays are deeply
   equal to one another.  Unlike the equals(Object[],Object[])
   method, this method is appropriate for use with nested arrays of
   arbitrary depth.

   Two array references are considered deeply equal if both
   are null, or if they refer to arrays that contain the same
   number of elements and all corresponding pairs of elements in the two
   arrays are deeply equal.

   Two possibly null elements e1 and e2 are
   deeply equal if any of the following conditions hold:

       e1 and e2 are both arrays of object reference
           types, and Arrays.deepEquals(e1, e2) would return true
       e1 and e2 are arrays of the same primitive
           type, and the appropriate overloading of
           Arrays.equals(e1, e2) would return true.
       e1 == e2
       e1.equals(e2) would return true.

   Note that this definition permits null elements at any depth.

   If either of the specified arrays contain themselves as elements
   either directly or indirectly through one or more levels of arrays,
   the behavior of this method is undefined.

  a-1 - one array to be tested for equality - `java.lang.Object[]`
  a-2 - the other array to be tested for equality - `java.lang.Object[]`

  returns: true if the two arrays are equal - `boolean`"
  (^Boolean [a-1 a-2]
    (Arrays/deepEquals a-1 a-2)))

(defn *to-string
  "Returns a string representation of the contents of the specified array.
   The string representation consists of a list of the array's elements,
   enclosed in square brackets (`[]`).  Adjacent elements are
   separated by the characters `, ` (a comma followed by a
   space).  Elements are converted to strings as by
   String.valueOf(long).  Returns `null` if a
   is null.

  a - the array whose string representation to return - `long[]`

  returns: a string representation of a - `java.lang.String`"
  (^java.lang.String [a]
    (Arrays/toString a)))

(defn *deep-hash-code
  "Returns a hash code based on the `deep contents` of the specified
   array.  If the array contains other arrays as elements, the
   hash code is based on their contents and so on, ad infinitum.
   It is therefore unacceptable to invoke this method on an array that
   contains itself as an element, either directly or indirectly through
   one or more levels of arrays.  The behavior of such an invocation is
   undefined.

   For any two arrays a and b such that
   Arrays.deepEquals(a, b), it is also the case that
   Arrays.deepHashCode(a) == Arrays.deepHashCode(b).

   The computation of the value returned by this method is similar to
   that of the value returned by List.hashCode() on a list
   containing the same elements as a in the same order, with one
   difference: If an element e of a is itself an array,
   its hash code is computed not by calling e.hashCode(), but as
   by calling the appropriate overloading of Arrays.hashCode(e)
   if e is an array of a primitive type, or as by calling
   Arrays.deepHashCode(e) recursively if e is an array
   of a reference type.  If a is null, this method
   returns 0.

  a - the array whose deep-content-based hash code to compute - `java.lang.Object[]`

  returns: a deep-content-based hash code for a - `int`"
  (^Integer [a]
    (Arrays/deepHashCode a)))

(defn *sort
  "Sorts the specified range of the specified array of objects according
   to the order induced by the specified comparator.  The range to be
   sorted extends from index fromIndex, inclusive, to index
   toIndex, exclusive.  (If fromIndex==toIndex, the
   range to be sorted is empty.)  All elements in the range must be
   mutually comparable by the specified comparator (that is,
   c.compare(e1, e2) must not throw a ClassCastException
   for any elements e1 and e2 in the range).

   This sort is guaranteed to be stable:  equal elements will
   not be reordered as a result of the sort.

   Implementation note: This implementation is a stable, adaptive,
   iterative mergesort that requires far fewer than n lg(n) comparisons
   when the input array is partially sorted, while offering the
   performance of a traditional mergesort when the input array is
   randomly ordered.  If the input array is nearly sorted, the
   implementation requires approximately n comparisons.  Temporary
   storage requirements vary from a small constant for nearly sorted
   input arrays to n/2 object references for randomly ordered input
   arrays.

   The implementation takes equal advantage of ascending and
   descending order in its input array, and can take advantage of
   ascending and descending order in different parts of the the same
   input array.  It is well-suited to merging two or more sorted arrays:
   simply concatenate the arrays and sort the resulting array.

   The implementation was adapted from Tim Peters's list sort for Python
   (
   TimSort).  It uses techniques from Peter McIlroy's `Optimistic
   Sorting and Information Theoretic Complexity`, in Proceedings of the
   Fourth Annual ACM-SIAM Symposium on Discrete Algorithms, pp 467-474,
   January 1993.

  a - the array to be sorted - `T[]`
  from-index - the index of the first element (inclusive) to be sorted - `int`
  to-index - the index of the last element (exclusive) to be sorted - `int`
  c - the comparator to determine the order of the array. A null value indicates that the elements' java.lang.natural ordering should be used. - `T>`

  returns: `<T> void`

  throws: java.lang.ClassCastException - if the array contains elements that are not mutually comparable using the specified comparator."
  ([a ^Integer from-index ^Integer to-index c]
    (Arrays/sort a from-index to-index c))
  ([a ^Integer from-index ^Integer to-index]
    (Arrays/sort a from-index to-index))
  ([a c]
    (Arrays/sort a c))
  ([a]
    (Arrays/sort a)))

(defn *binary-search
  "Searches a range of
   the specified array for the specified object using the binary
   search algorithm.
   The range must be sorted into ascending order
   according to the specified comparator (as by the
   sort(T[], int, int, Comparator)
   method) prior to making this call.
   If it is not sorted, the results are undefined.
   If the range contains multiple elements equal to the specified object,
   there is no guarantee which one will be found.

  a - the array to be searched - `T[]`
  from-index - the index of the first element (inclusive) to be searched - `int`
  to-index - the index of the last element (exclusive) to be searched - `int`
  key - the value to be searched for - `T`
  c - the comparator by which the array is ordered. A null value indicates that the elements' java.lang.natural ordering should be used. - `T>`

  returns: index of the search key, if it is contained in the array
           within the specified range;
           otherwise, (-(insertion point) - 1).  The
           insertion point is defined as the point at which the
           key would be inserted into the array: the index of the first
           element in the range greater than the key,
           or toIndex if all
           elements in the range are less than the specified key.  Note
           that this guarantees that the return value will be >= 0 if
           and only if the key is found. - `<T> int`

  throws: java.lang.ClassCastException - if the range contains elements that are not mutually comparable using the specified comparator, or the search key is not comparable to the elements in the range using this comparator."
  ([a ^Integer from-index ^Integer to-index key c]
    (Arrays/binarySearch a from-index to-index key c))
  (^Integer [a ^Integer from-index ^Integer to-index ^Long key]
    (Arrays/binarySearch a from-index to-index key))
  ([a key c]
    (Arrays/binarySearch a key c))
  (^Integer [a ^Long key]
    (Arrays/binarySearch a key)))

(defn *parallel-prefix
  "Performs parallelPrefix(Object[], BinaryOperator)
   for the given subrange of the array.

  array - the array - `T[]`
  from-index - the index of the first element, inclusive - `int`
  to-index - the index of the last element, exclusive - `int`
  op - a side-effect-free, associative function to perform the cumulation - `java.util.function.BinaryOperator<T>`

  returns: `<T> void`

  throws: java.lang.IllegalArgumentException - if fromIndex > toIndex"
  ([array ^Integer from-index ^Integer to-index ^java.util.function.BinaryOperator op]
    (Arrays/parallelPrefix array from-index to-index op))
  ([array ^java.util.function.BinaryOperator op]
    (Arrays/parallelPrefix array op)))

(defn *fill
  "Assigns the specified long value to each element of the specified
   range of the specified array of longs.  The range to be filled
   extends from index fromIndex, inclusive, to index
   toIndex, exclusive.  (If fromIndex==toIndex, the
   range to be filled is empty.)

  a - the array to be filled - `long[]`
  from-index - the index of the first element (inclusive) to be filled with the specified value - `int`
  to-index - the index of the last element (exclusive) to be filled with the specified value - `int`
  val - the value to be stored in all elements of the array - `long`

  throws: java.lang.IllegalArgumentException - if fromIndex > toIndex"
  ([a ^Integer from-index ^Integer to-index ^Long val]
    (Arrays/fill a from-index to-index val))
  ([a ^Long val]
    (Arrays/fill a val)))

(defn *hash-code
  "Returns a hash code based on the contents of the specified array.
   For any two long arrays a and b
   such that Arrays.equals(a, b), it is also the case that
   Arrays.hashCode(a) == Arrays.hashCode(b).

   The value returned by this method is the same value that would be
   obtained by invoking the hashCode
   method on a List containing a sequence of Long
   instances representing the elements of a in the same order.
   If a is null, this method returns 0.

  a - the array whose hash value to compute - `long[]`

  returns: a content-based hash code for a - `int`"
  (^Integer [a]
    (Arrays/hashCode a)))

(defn *copy-of
  "Copies the specified array, truncating or padding with nulls (if necessary)
   so the copy has the specified length.  For all indices that are
   valid in both the original array and the copy, the two arrays will
   contain identical values.  For any indices that are valid in the
   copy but not the original, the copy will contain null.
   Such indices will exist if and only if the specified length
   is greater than that of the original array.
   The resulting array is of the class newType.

  original - the array to be copied - `U[]`
  new-length - the length of the copy to be returned - `int`
  new-type - the class of the copy to be returned - `T[]>`

  returns: a copy of the original array, truncated or padded with nulls
       to obtain the specified length - `<T,U> T[]`

  throws: java.lang.NegativeArraySizeException - if newLength is negative"
  ([original ^Integer new-length new-type]
    (Arrays/copyOf original new-length new-type))
  ([original ^Integer new-length]
    (Arrays/copyOf original new-length)))

(defn *deep-to-string
  "Returns a string representation of the `deep contents` of the specified
   array.  If the array contains other arrays as elements, the string
   representation contains their contents and so on.  This method is
   designed for converting multidimensional arrays to strings.

   The string representation consists of a list of the array's
   elements, enclosed in square brackets (`[]`).  Adjacent
   elements are separated by the characters `, ` (a comma
   followed by a space).  Elements are converted to strings as by
   String.valueOf(Object), unless they are themselves
   arrays.

   If an element e is an array of a primitive type, it is
   converted to a string as by invoking the appropriate overloading of
   Arrays.toString(e).  If an element e is an array of a
   reference type, it is converted to a string as by invoking
   this method recursively.

   To avoid infinite recursion, if the specified array contains itself
   as an element, or contains an indirect reference to itself through one
   or more levels of arrays, the self-reference is converted to the string
   `[...]`.  For example, an array containing only a reference
   to itself would be rendered as `[[...]]`.

   This method returns `null` if the specified array
   is null.

  a - the array whose string representation to return - `java.lang.Object[]`

  returns: a string representation of a - `java.lang.String`"
  (^java.lang.String [a]
    (Arrays/deepToString a)))

(defn *parallel-sort
  "Sorts the specified range of the specified array of objects according
   to the order induced by the specified comparator.  The range to be
   sorted extends from index fromIndex, inclusive, to index
   toIndex, exclusive.  (If fromIndex==toIndex, the
   range to be sorted is empty.)  All elements in the range must be
   mutually comparable by the specified comparator (that is,
   c.compare(e1, e2) must not throw a ClassCastException
   for any elements e1 and e2 in the range).

   This sort is guaranteed to be stable:  equal elements will
   not be reordered as a result of the sort.

  a - the array to be sorted - `T[]`
  from-index - the index of the first element (inclusive) to be sorted - `int`
  to-index - the index of the last element (exclusive) to be sorted - `int`
  cmp - the comparator to determine the order of the array. A null value indicates that the elements' java.lang.natural ordering should be used. - `T>`

  returns: `<T> void`

  throws: java.lang.IllegalArgumentException - if fromIndex > toIndex or (optional) if the natural ordering of the array elements is found to violate the Comparable contract"
  ([a ^Integer from-index ^Integer to-index cmp]
    (Arrays/parallelSort a from-index to-index cmp))
  ([a ^Integer from-index ^Integer to-index]
    (Arrays/parallelSort a from-index to-index))
  ([a cmp]
    (Arrays/parallelSort a cmp))
  ([a]
    (Arrays/parallelSort a)))

(defn *copy-of-range
  "Copies the specified range of the specified array into a new array.
   The initial index of the range (from) must lie between zero
   and original.length, inclusive.  The value at
   original[from] is placed into the initial element of the copy
   (unless from == original.length or from == to).
   Values from subsequent elements in the original array are placed into
   subsequent elements in the copy.  The final index of the range
   (to), which must be greater than or equal to from,
   may be greater than original.length, in which case
   null is placed in all elements of the copy whose index is
   greater than or equal to original.length - from.  The length
   of the returned array will be to - from.
   The resulting array is of the class newType.

  original - the array from which a range is to be copied - `U[]`
  from - the initial index of the range to be copied, inclusive - `int`
  to - the final index of the range to be copied, exclusive. (This index may lie outside the array.) - `int`
  new-type - the class of the copy to be returned - `T[]>`

  returns: a new array containing the specified range from the original array,
       truncated or padded with nulls to obtain the required length - `<T,U> T[]`

  throws: java.lang.ArrayIndexOutOfBoundsException - if from < 0 or from > original.length"
  ([original ^Integer from ^Integer to new-type]
    (Arrays/copyOfRange original from to new-type))
  ([original ^Integer from ^Integer to]
    (Arrays/copyOfRange original from to)))

(defn *equals
  "Returns true if the two specified arrays of longs are
   equal to one another.  Two arrays are considered equal if both
   arrays contain the same number of elements, and all corresponding pairs
   of elements in the two arrays are equal.  In other words, two arrays
   are equal if they contain the same elements in the same order.  Also,
   two array references are considered equal if both are null.

  a - one array to be tested for equality - `long[]`
  a-2 - the other array to be tested for equality - `long[]`

  returns: true if the two arrays are equal - `boolean`"
  (^Boolean [a a-2]
    (Arrays/equals a a-2)))

