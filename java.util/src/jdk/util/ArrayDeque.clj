(ns jdk.util.ArrayDeque
  "Resizable-array implementation of the Deque interface.  Array
  deques have no capacity restrictions; they grow as necessary to support
  usage.  They are not thread-safe; in the absence of external
  synchronization, they do not support concurrent access by multiple threads.
  Null elements are prohibited.  This class is likely to be faster than
  Stack when used as a stack, and faster than LinkedList
  when used as a queue.

  Most ArrayDeque operations run in amortized constant time.
  Exceptions include remove, removeFirstOccurrence, removeLastOccurrence, contains, iterator.remove(), and the bulk operations, all of which run in linear
  time.

  The iterators returned by this class's iterator method are
  fail-fast: If the deque is modified at any time after the iterator
  is created, in any way except through the iterator's own remove
  method, the iterator will generally throw a ConcurrentModificationException.  Thus, in the face of concurrent
  modification, the iterator fails quickly and cleanly, rather than risking
  arbitrary, non-deterministic behavior at an undetermined time in the
  future.

  Note that the fail-fast behavior of an iterator cannot be guaranteed
  as it is, generally speaking, impossible to make any hard guarantees in the
  presence of unsynchronized concurrent modification.  Fail-fast iterators
  throw ConcurrentModificationException on a best-effort basis.
  Therefore, it would be wrong to write a program that depended on this
  exception for its correctness: the fail-fast behavior of iterators
  should be used only to detect bugs.

  This class and its iterator implement all of the
  optional methods of the Collection and Iterator interfaces.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util ArrayDeque]))

(defn ->array-deque
  "Constructor.

  Constructs an empty array deque with an initial capacity
   sufficient to hold the specified number of elements.

  num-elements - lower bound on initial capacity of the deque - `int`"
  ([^Integer num-elements]
    (new ArrayDeque num-elements))
  ([]
    (new ArrayDeque )))

(defn peek
  "Retrieves, but does not remove, the head of the queue represented by
   this deque, or returns null if this deque is empty.

   This method is equivalent to peekFirst().

  returns: the head of the queue represented by this deque, or
           null if this deque is empty - `ArrayDeque.E`"
  (^ArrayDeque.E [^java.util.ArrayDeque this]
    (-> this (.peek))))

(defn offer-first
  "Inserts the specified element at the front of this deque.

  e - the element to add - `ArrayDeque.E`

  returns: true (as specified by Deque.offerFirst(E)) - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  (^Boolean [^java.util.ArrayDeque this ^ArrayDeque.E e]
    (-> this (.offerFirst e))))

(defn get-first
  "Description copied from interface: Deque

  returns: the head of this deque - `ArrayDeque.E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  (^ArrayDeque.E [^java.util.ArrayDeque this]
    (-> this (.getFirst))))

(defn spliterator
  "Creates a late-binding
   and fail-fast Spliterator over the elements in this
   deque.

   The Spliterator reports Spliterator.SIZED,
   Spliterator.SUBSIZED, Spliterator.ORDERED, and
   Spliterator.NONNULL.  Overriding implementations should document
   the reporting of additional characteristic values.

  returns: a Spliterator over the elements in this deque - `java.util.Spliterator<ArrayDeque.E>`"
  (^java.util.Spliterator [^java.util.ArrayDeque this]
    (-> this (.spliterator))))

(defn peek-first
  "Description copied from interface: Deque

  returns: the head of this deque, or null if this deque is empty - `ArrayDeque.E`"
  (^ArrayDeque.E [^java.util.ArrayDeque this]
    (-> this (.peekFirst))))

(defn remove-first-occurrence
  "Removes the first occurrence of the specified element in this
   deque (when traversing the deque from head to tail).
   If the deque does not contain the element, it is unchanged.
   More formally, removes the first element e such that
   o.equals(e) (if such an element exists).
   Returns true if this deque contained the specified element
   (or equivalently, if this deque changed as a result of the call).

  o - element to be removed from this deque, if present - `java.lang.Object`

  returns: true if the deque contained the specified element - `boolean`"
  (^Boolean [^java.util.ArrayDeque this ^java.lang.Object o]
    (-> this (.removeFirstOccurrence o))))

(defn offer
  "Inserts the specified element at the end of this deque.

   This method is equivalent to offerLast(E).

  e - the element to add - `ArrayDeque.E`

  returns: true (as specified by Queue.offer(E)) - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  (^Boolean [^java.util.ArrayDeque this ^ArrayDeque.E e]
    (-> this (.offer e))))

(defn peek-last
  "Description copied from interface: Deque

  returns: the tail of this deque, or null if this deque is empty - `ArrayDeque.E`"
  (^ArrayDeque.E [^java.util.ArrayDeque this]
    (-> this (.peekLast))))

(defn pop
  "Pops an element from the stack represented by this deque.  In other
   words, removes and returns the first element of this deque.

   This method is equivalent to removeFirst().

  returns: the element at the front of this deque (which is the top
           of the stack represented by this deque) - `ArrayDeque.E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  (^ArrayDeque.E [^java.util.ArrayDeque this]
    (-> this (.pop))))

(defn contains
  "Returns true if this deque contains the specified element.
   More formally, returns true if and only if this deque contains
   at least one element e such that o.equals(e).

  o - object to be checked for containment in this deque - `java.lang.Object`

  returns: true if this deque contains the specified element - `boolean`"
  (^Boolean [^java.util.ArrayDeque this ^java.lang.Object o]
    (-> this (.contains o))))

(defn push
  "Pushes an element onto the stack represented by this deque.  In other
   words, inserts the element at the front of this deque.

   This method is equivalent to addFirst(E).

  e - the element to push - `ArrayDeque.E`

  throws: java.lang.NullPointerException - if the specified element is null"
  ([^java.util.ArrayDeque this ^ArrayDeque.E e]
    (-> this (.push e))))

(defn get-last
  "Description copied from interface: Deque

  returns: the tail of this deque - `ArrayDeque.E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  (^ArrayDeque.E [^java.util.ArrayDeque this]
    (-> this (.getLast))))

(defn iterator
  "Returns an iterator over the elements in this deque.  The elements
   will be ordered from first (head) to last (tail).  This is the same
   order that elements would be dequeued (via successive calls to
   remove() or popped (via successive calls to pop()).

  returns: an iterator over the elements in this deque - `java.util.Iterator<ArrayDeque.E>`"
  (^java.util.Iterator [^java.util.ArrayDeque this]
    (-> this (.iterator))))

(defn element
  "Retrieves, but does not remove, the head of the queue represented by
   this deque.  This method differs from peek only in
   that it throws an exception if this deque is empty.

   This method is equivalent to getFirst().

  returns: the head of the queue represented by this deque - `ArrayDeque.E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  (^ArrayDeque.E [^java.util.ArrayDeque this]
    (-> this (.element))))

(defn remove-first
  "Description copied from interface: Deque

  returns: the head of this deque - `ArrayDeque.E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  (^ArrayDeque.E [^java.util.ArrayDeque this]
    (-> this (.removeFirst))))

(defn remove
  "Removes a single instance of the specified element from this deque.
   If the deque does not contain the element, it is unchanged.
   More formally, removes the first element e such that
   o.equals(e) (if such an element exists).
   Returns true if this deque contained the specified element
   (or equivalently, if this deque changed as a result of the call).

   This method is equivalent to removeFirstOccurrence(Object).

  o - element to be removed from this deque, if present - `java.lang.Object`

  returns: true if this deque contained the specified element - `boolean`"
  (^Boolean [^java.util.ArrayDeque this ^java.lang.Object o]
    (-> this (.remove o)))
  (^ArrayDeque.E [^java.util.ArrayDeque this]
    (-> this (.remove))))

(defn poll-last
  "Description copied from interface: Deque

  returns: the tail of this deque, or null if this deque is empty - `ArrayDeque.E`"
  (^ArrayDeque.E [^java.util.ArrayDeque this]
    (-> this (.pollLast))))

(defn poll
  "Retrieves and removes the head of the queue represented by this deque
   (in other words, the first element of this deque), or returns
   null if this deque is empty.

   This method is equivalent to pollFirst().

  returns: the head of the queue represented by this deque, or
           null if this deque is empty - `ArrayDeque.E`"
  (^ArrayDeque.E [^java.util.ArrayDeque this]
    (-> this (.poll))))

(defn offer-last
  "Inserts the specified element at the end of this deque.

  e - the element to add - `ArrayDeque.E`

  returns: true (as specified by Deque.offerLast(E)) - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  (^Boolean [^java.util.ArrayDeque this ^ArrayDeque.E e]
    (-> this (.offerLast e))))

(defn poll-first
  "Description copied from interface: Deque

  returns: the head of this deque, or null if this deque is empty - `ArrayDeque.E`"
  (^ArrayDeque.E [^java.util.ArrayDeque this]
    (-> this (.pollFirst))))

(defn add-last
  "Inserts the specified element at the end of this deque.

   This method is equivalent to add(E).

  e - the element to add - `ArrayDeque.E`

  throws: java.lang.NullPointerException - if the specified element is null"
  ([^java.util.ArrayDeque this ^ArrayDeque.E e]
    (-> this (.addLast e))))

(defn clone
  "Returns a copy of this deque.

  returns: a copy of this deque - `java.util.ArrayDeque<ArrayDeque.E>`"
  (^java.util.ArrayDeque [^java.util.ArrayDeque this]
    (-> this (.clone))))

(defn remove-last-occurrence
  "Removes the last occurrence of the specified element in this
   deque (when traversing the deque from head to tail).
   If the deque does not contain the element, it is unchanged.
   More formally, removes the last element e such that
   o.equals(e) (if such an element exists).
   Returns true if this deque contained the specified element
   (or equivalently, if this deque changed as a result of the call).

  o - element to be removed from this deque, if present - `java.lang.Object`

  returns: true if the deque contained the specified element - `boolean`"
  (^Boolean [^java.util.ArrayDeque this ^java.lang.Object o]
    (-> this (.removeLastOccurrence o))))

(defn add
  "Inserts the specified element at the end of this deque.

   This method is equivalent to addLast(E).

  e - the element to add - `ArrayDeque.E`

  returns: true (as specified by Collection.add(E)) - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  (^Boolean [^java.util.ArrayDeque this ^ArrayDeque.E e]
    (-> this (.add e))))

(defn descending-iterator
  "Description copied from interface: Deque

  returns: an iterator over the elements in this deque in reverse
   sequence - `java.util.Iterator<ArrayDeque.E>`"
  (^java.util.Iterator [^java.util.ArrayDeque this]
    (-> this (.descendingIterator))))

(defn empty?
  "Returns true if this deque contains no elements.

  returns: true if this deque contains no elements - `boolean`"
  (^Boolean [^java.util.ArrayDeque this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of elements in this deque.

  returns: the number of elements in this deque - `int`"
  (^Integer [^java.util.ArrayDeque this]
    (-> this (.size))))

(defn clear
  "Removes all of the elements from this deque.
   The deque will be empty after this call returns."
  ([^java.util.ArrayDeque this]
    (-> this (.clear))))

(defn remove-last
  "Description copied from interface: Deque

  returns: the tail of this deque - `ArrayDeque.E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  (^ArrayDeque.E [^java.util.ArrayDeque this]
    (-> this (.removeLast))))

(defn add-first
  "Inserts the specified element at the front of this deque.

  e - the element to add - `ArrayDeque.E`

  throws: java.lang.NullPointerException - if the specified element is null"
  ([^java.util.ArrayDeque this ^ArrayDeque.E e]
    (-> this (.addFirst e))))

(defn to-array
  "Returns an array containing all of the elements in this deque in
   proper sequence (from first to last element); the runtime type of the
   returned array is that of the specified array.  If the deque fits in
   the specified array, it is returned therein.  Otherwise, a new array
   is allocated with the runtime type of the specified array and the
   size of this deque.

   If this deque fits in the specified array with room to spare
   (i.e., the array has more elements than this deque), the element in
   the array immediately following the end of the deque is set to
   null.

   Like the toArray() method, this method acts as bridge between
   array-based and collection-based APIs.  Further, this method allows
   precise control over the runtime type of the output array, and may,
   under certain circumstances, be used to save allocation costs.

   Suppose x is a deque known to contain only strings.
   The following code can be used to dump the deque into a newly
   allocated array of String:



    String[] y = x.toArray(new String[0]);

   Note that toArray(new Object[0]) is identical in function to
   toArray().

  a - the array into which the elements of the deque are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose - `T[]`

  returns: an array containing all of the elements in this deque - `<T> T[]`

  throws: java.lang.ArrayStoreException - if the runtime type of the specified array is not a supertype of the runtime type of every element in this deque"
  ([^java.util.ArrayDeque this a]
    (-> this (.toArray a)))
  ([^java.util.ArrayDeque this]
    (-> this (.toArray))))

