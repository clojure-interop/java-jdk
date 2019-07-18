(ns jdk.util.concurrent.LinkedBlockingDeque
  "An optionally-bounded java.util.concurrent.blocking deque based on
  linked nodes.

  The optional capacity bound constructor argument serves as a
  way to prevent excessive expansion. The capacity, if unspecified,
  is equal to Integer.MAX_VALUE.  Linked nodes are
  dynamically created upon each insertion unless this would bring the
  deque above capacity.

  Most operations run in constant time (ignoring time spent
  blocking).  Exceptions include remove,
  removeFirstOccurrence, removeLastOccurrence, contains, iterator.remove(), and the bulk
  operations, all of which run in linear time.

  This class and its iterator implement all of the
  optional methods of the Collection and Iterator interfaces.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent LinkedBlockingDeque]))

(defn ->linked-blocking-deque
  "Constructor.

  Creates a LinkedBlockingDeque with the given (fixed) capacity.

  capacity - the capacity of this deque - `int`

  throws: java.lang.IllegalArgumentException - if capacity is less than 1"
  (^LinkedBlockingDeque [^Integer capacity]
    (new LinkedBlockingDeque capacity))
  (^LinkedBlockingDeque []
    (new LinkedBlockingDeque )))

(defn peek
  "Description copied from interface: BlockingDeque

  returns: the head of this deque, or null if this deque is empty - `E`"
  ([^LinkedBlockingDeque this]
    (-> this (.peek))))

(defn offer-first
  "Description copied from interface: BlockingDeque

  e - the element to add - `E`
  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: true if successful, or false if
           the specified waiting time elapses before space is available - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  (^Boolean [^LinkedBlockingDeque this e ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.offerFirst e timeout unit)))
  (^Boolean [^LinkedBlockingDeque this e]
    (-> this (.offerFirst e))))

(defn get-first
  "Description copied from interface: Deque

  returns: the head of this deque - `E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  ([^LinkedBlockingDeque this]
    (-> this (.getFirst))))

(defn spliterator
  "Returns a Spliterator over the elements in this deque.

   The returned spliterator is
   weakly consistent.

   The Spliterator reports Spliterator.CONCURRENT,
   Spliterator.ORDERED, and Spliterator.NONNULL.

  returns: a Spliterator over the elements in this deque - `java.util.Spliterator<E>`"
  (^java.util.Spliterator [^LinkedBlockingDeque this]
    (-> this (.spliterator))))

(defn peek-first
  "Description copied from interface: Deque

  returns: the head of this deque, or null if this deque is empty - `E`"
  ([^LinkedBlockingDeque this]
    (-> this (.peekFirst))))

(defn remove-first-occurrence
  "Description copied from interface: BlockingDeque

  o - element to be removed from this deque, if present - `java.lang.Object`

  returns: true if an element was removed as a result of this call - `boolean`"
  (^Boolean [^LinkedBlockingDeque this ^java.lang.Object o]
    (-> this (.removeFirstOccurrence o))))

(defn offer
  "Description copied from interface: BlockingDeque

  e - the element to add - `E`
  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: true if the element was added to this deque, else
           false - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  (^Boolean [^LinkedBlockingDeque this e ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.offer e timeout unit)))
  (^Boolean [^LinkedBlockingDeque this e]
    (-> this (.offer e))))

(defn put
  "Description copied from interface: BlockingDeque

  e - the element to add - `E`

  throws: java.lang.NullPointerException - if the specified element is null"
  ([^LinkedBlockingDeque this e]
    (-> this (.put e))))

(defn peek-last
  "Description copied from interface: Deque

  returns: the tail of this deque, or null if this deque is empty - `E`"
  ([^LinkedBlockingDeque this]
    (-> this (.peekLast))))

(defn pop
  "Description copied from interface: Deque

  returns: the element at the front of this deque (which is the top
           of the stack represented by this deque) - `E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  ([^LinkedBlockingDeque this]
    (-> this (.pop))))

(defn contains
  "Returns true if this deque contains the specified element.
   More formally, returns true if and only if this deque contains
   at least one element e such that o.equals(e).

  o - object to be checked for containment in this deque - `java.lang.Object`

  returns: true if this deque contains the specified element - `boolean`"
  (^Boolean [^LinkedBlockingDeque this ^java.lang.Object o]
    (-> this (.contains o))))

(defn take-last
  "Description copied from interface: BlockingDeque

  returns: the tail of this deque - `E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^LinkedBlockingDeque this]
    (-> this (.takeLast))))

(defn take-first
  "Description copied from interface: BlockingDeque

  returns: the head of this deque - `E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^LinkedBlockingDeque this]
    (-> this (.takeFirst))))

(defn to-string
  "Description copied from class: AbstractCollection

  returns: a string representation of this collection - `java.lang.String`"
  (^java.lang.String [^LinkedBlockingDeque this]
    (-> this (.toString))))

(defn push
  "Description copied from interface: BlockingDeque

  e - the element to push - `E`

  throws: java.lang.IllegalStateException - if this deque is full"
  ([^LinkedBlockingDeque this e]
    (-> this (.push e))))

(defn get-last
  "Description copied from interface: Deque

  returns: the tail of this deque - `E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  ([^LinkedBlockingDeque this]
    (-> this (.getLast))))

(defn take
  "Description copied from interface: BlockingDeque

  returns: the head of this deque - `E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^LinkedBlockingDeque this]
    (-> this (.take))))

(defn iterator
  "Returns an iterator over the elements in this deque in proper sequence.
   The elements will be returned in order from first (head) to last (tail).

   The returned iterator is
   weakly consistent.

  returns: an iterator over the elements in this deque in proper sequence - `java.util.Iterator<E>`"
  (^java.util.Iterator [^LinkedBlockingDeque this]
    (-> this (.iterator))))

(defn element
  "Retrieves, but does not remove, the head of the queue represented by
   this deque.  This method differs from peek only in that
   it throws an exception if this deque is empty.

   This method is equivalent to getFirst.

  returns: the head of the queue represented by this deque - `E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  ([^LinkedBlockingDeque this]
    (-> this (.element))))

(defn put-first
  "Description copied from interface: BlockingDeque

  e - the element to add - `E`

  throws: java.lang.NullPointerException - if the specified element is null"
  ([^LinkedBlockingDeque this e]
    (-> this (.putFirst e))))

(defn remove-first
  "Description copied from interface: Deque

  returns: the head of this deque - `E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  ([^LinkedBlockingDeque this]
    (-> this (.removeFirst))))

(defn remove
  "Removes the first occurrence of the specified element from this deque.
   If the deque does not contain the element, it is unchanged.
   More formally, removes the first element e such that
   o.equals(e) (if such an element exists).
   Returns true if this deque contained the specified element
   (or equivalently, if this deque changed as a result of the call).

   This method is equivalent to
   removeFirstOccurrence.

  o - element to be removed from this deque, if present - `java.lang.Object`

  returns: true if this deque changed as a result of the call - `boolean`"
  (^Boolean [^LinkedBlockingDeque this ^java.lang.Object o]
    (-> this (.remove o)))
  ([^LinkedBlockingDeque this]
    (-> this (.remove))))

(defn poll-last
  "Description copied from interface: BlockingDeque

  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: the tail of this deque, or null if the specified
           waiting time elapses before an element is available - `E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^LinkedBlockingDeque this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.pollLast timeout unit)))
  ([^LinkedBlockingDeque this]
    (-> this (.pollLast))))

(defn drain-to
  "Description copied from interface: BlockingQueue

  c - the collection to transfer elements into - `java.util.Collection`
  max-elements - the maximum number of elements to transfer - `int`

  returns: the number of elements transferred - `int`

  throws: java.lang.UnsupportedOperationException - if addition of elements is not supported by the specified collection"
  (^Integer [^LinkedBlockingDeque this ^java.util.Collection c ^Integer max-elements]
    (-> this (.drainTo c max-elements)))
  (^Integer [^LinkedBlockingDeque this ^java.util.Collection c]
    (-> this (.drainTo c))))

(defn poll
  "Description copied from interface: BlockingDeque

  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: the head of this deque, or null if the
           specified waiting time elapses before an element is available - `E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^LinkedBlockingDeque this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.poll timeout unit)))
  ([^LinkedBlockingDeque this]
    (-> this (.poll))))

(defn offer-last
  "Description copied from interface: BlockingDeque

  e - the element to add - `E`
  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: true if successful, or false if
           the specified waiting time elapses before space is available - `boolean`

  throws: java.lang.NullPointerException - if the specified element is null"
  (^Boolean [^LinkedBlockingDeque this e ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.offerLast e timeout unit)))
  (^Boolean [^LinkedBlockingDeque this e]
    (-> this (.offerLast e))))

(defn poll-first
  "Description copied from interface: BlockingDeque

  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: the head of this deque, or null if the specified
           waiting time elapses before an element is available - `E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^LinkedBlockingDeque this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.pollFirst timeout unit)))
  ([^LinkedBlockingDeque this]
    (-> this (.pollFirst))))

(defn add-last
  "Description copied from interface: BlockingDeque

  e - the element to add - `E`

  throws: java.lang.IllegalStateException - if this deque is full"
  ([^LinkedBlockingDeque this e]
    (-> this (.addLast e))))

(defn remove-last-occurrence
  "Description copied from interface: BlockingDeque

  o - element to be removed from this deque, if present - `java.lang.Object`

  returns: true if an element was removed as a result of this call - `boolean`"
  (^Boolean [^LinkedBlockingDeque this ^java.lang.Object o]
    (-> this (.removeLastOccurrence o))))

(defn remaining-capacity
  "Returns the number of additional elements that this deque can ideally
   (in the absence of memory or resource constraints) accept without
   blocking. This is always equal to the initial capacity of this deque
   less the current size of this deque.

   Note that you cannot always tell if an attempt to insert
   an element will succeed by inspecting remainingCapacity
   because it may be the case that another thread is about to
   insert or remove an element.

  returns: the remaining capacity - `int`"
  (^Integer [^LinkedBlockingDeque this]
    (-> this (.remainingCapacity))))

(defn add
  "Inserts the specified element at the end of this deque unless it would
   violate capacity restrictions.  When using a capacity-restricted deque,
   it is generally preferable to use method offer.

   This method is equivalent to addLast(E).

  e - the element to add - `E`

  returns: true (as specified by Collection.add(E)) - `boolean`

  throws: java.lang.IllegalStateException - if this deque is full"
  (^Boolean [^LinkedBlockingDeque this e]
    (-> this (.add e))))

(defn descending-iterator
  "Returns an iterator over the elements in this deque in reverse
   sequential order.  The elements will be returned in order from
   last (tail) to first (head).

   The returned iterator is
   weakly consistent.

  returns: an iterator over the elements in this deque in reverse order - `java.util.Iterator<E>`"
  (^java.util.Iterator [^LinkedBlockingDeque this]
    (-> this (.descendingIterator))))

(defn size
  "Returns the number of elements in this deque.

  returns: the number of elements in this deque - `int`"
  (^Integer [^LinkedBlockingDeque this]
    (-> this (.size))))

(defn clear
  "Atomically removes all of the elements from this deque.
   The deque will be empty after this call returns."
  ([^LinkedBlockingDeque this]
    (-> this (.clear))))

(defn remove-last
  "Description copied from interface: Deque

  returns: the tail of this deque - `E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  ([^LinkedBlockingDeque this]
    (-> this (.removeLast))))

(defn add-first
  "Description copied from interface: BlockingDeque

  e - the element to add - `E`

  throws: java.lang.IllegalStateException - if this deque is full"
  ([^LinkedBlockingDeque this e]
    (-> this (.addFirst e))))

(defn to-array
  "Returns an array containing all of the elements in this deque, in
   proper sequence; the runtime type of the returned array is that of
   the specified array.  If the deque fits in the specified array, it
   is returned therein.  Otherwise, a new array is allocated with the
   runtime type of the specified array and the size of this deque.

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
  ([^LinkedBlockingDeque this a]
    (-> this (.toArray a)))
  ([^LinkedBlockingDeque this]
    (-> this (.toArray))))

(defn put-last
  "Description copied from interface: BlockingDeque

  e - the element to add - `E`

  throws: java.lang.NullPointerException - if the specified element is null"
  ([^LinkedBlockingDeque this e]
    (-> this (.putLast e))))

