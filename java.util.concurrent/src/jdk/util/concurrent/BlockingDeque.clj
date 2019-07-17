(ns jdk.util.concurrent.BlockingDeque
  "A Deque that additionally supports blocking operations that wait
  for the deque to become non-empty when retrieving an element, and wait for
  space to become available in the deque when storing an element.

  BlockingDeque methods come in four forms, with different ways
  of handling operations that cannot be satisfied immediately, but may be
  satisfied at some point in the future:
  one throws an exception, the second returns a special value (either
  null or false, depending on the operation), the third
  blocks the current thread indefinitely until the operation can succeed,
  and the fourth blocks for only a given maximum time limit before giving
  up.  These methods are summarized in the following table:


  Summary of BlockingDeque methods

      First Element (Head)



     Throws exception
     Special value
     Blocks
     Times out


     Insert
     addFirst(e)
     offerFirst(e)
     putFirst(e)
     offerFirst(e, time, unit)


     Remove
     removeFirst()
     pollFirst()
     takeFirst()
     pollFirst(time, unit)


     Examine
     getFirst()
     peekFirst()
     not applicable
     not applicable


      Last Element (Tail)



     Throws exception
     Special value
     Blocks
     Times out


     Insert
     addLast(e)
     offerLast(e)
     putLast(e)
     offerLast(e, time, unit)


     Remove
     removeLast()
     pollLast()
     takeLast()
     pollLast(time, unit)


     Examine
     getLast()
     peekLast()
     not applicable
     not applicable



  Like any BlockingQueue, a BlockingDeque is thread safe,
  does not permit null elements, and may (or may not) be
  capacity-constrained.

  A BlockingDeque implementation may be used directly as a FIFO
  BlockingQueue. The methods inherited from the
  BlockingQueue interface are precisely equivalent to
  BlockingDeque methods as indicated in the following table:


  Comparison of BlockingQueue and BlockingDeque methods

      BlockingQueue Method
      Equivalent BlockingDeque Method


      Insert


     add(e)
     addLast(e)


     offer(e)
     offerLast(e)


     put(e)
     putLast(e)


     offer(e, time, unit)
     offerLast(e, time, unit)


      Remove


     remove()
     removeFirst()


     poll()
     pollFirst()


     take()
     takeFirst()


     poll(time, unit)
     pollFirst(time, unit)


      Examine


     element()
     getFirst()


     peek()
     peekFirst()



  Memory consistency effects: As with other concurrent
  collections, actions in a thread prior to placing an object into a
  BlockingDeque
  happen-before
  actions subsequent to the access or removal of that element from
  the BlockingDeque in another thread.

  This interface is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent BlockingDeque]))

(defn peek
  "Retrieves, but does not remove, the head of the queue represented by
   this deque (in other words, the first element of this deque), or
   returns null if this deque is empty.

   This method is equivalent to peekFirst.

  returns: the head of this deque, or null if this deque is empty - `BlockingDeque.E`"
  ([^. this]
    (-> this (.peek))))

(defn offer-first
  "Inserts the specified element at the front of this deque,
   waiting up to the specified wait time if necessary for space to
   become available.

  e - the element to add - `BlockingDeque.E`
  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: true if successful, or false if
           the specified waiting time elapses before space is available - `boolean`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^. this ^BlockingDeque.E e ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.offerFirst e timeout unit)))
  ([^. this ^BlockingDeque.E e]
    (-> this (.offerFirst e))))

(defn remove-first-occurrence
  "Removes the first occurrence of the specified element from this deque.
   If the deque does not contain the element, it is unchanged.
   More formally, removes the first element e such that
   o.equals(e) (if such an element exists).
   Returns true if this deque contained the specified element
   (or equivalently, if this deque changed as a result of the call).

  o - element to be removed from this deque, if present - `java.lang.Object`

  returns: true if an element was removed as a result of this call - `boolean`

  throws: java.lang.ClassCastException - if the class of the specified element is incompatible with this deque (optional)"
  ([^. this ^java.lang.Object o]
    (-> this (.removeFirstOccurrence o))))

(defn offer
  "Inserts the specified element into the queue represented by this deque
   (in other words, at the tail of this deque), waiting up to the
   specified wait time if necessary for space to become available.

   This method is equivalent to
   offerLast.

  e - the element to add - `BlockingDeque.E`
  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: true if the element was added to this deque, else
           false - `boolean`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^. this ^BlockingDeque.E e ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.offer e timeout unit)))
  ([^. this ^BlockingDeque.E e]
    (-> this (.offer e))))

(defn put
  "Inserts the specified element into the queue represented by this deque
   (in other words, at the tail of this deque), waiting if necessary for
   space to become available.

   This method is equivalent to putLast.

  e - the element to add - `BlockingDeque.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^. this ^BlockingDeque.E e]
    (-> this (.put e))))

(defn contains
  "Returns true if this deque contains the specified element.
   More formally, returns true if and only if this deque contains
   at least one element e such that o.equals(e).

  o - object to be checked for containment in this deque - `java.lang.Object`

  returns: true if this deque contains the specified element - `boolean`

  throws: java.lang.ClassCastException - if the class of the specified element is incompatible with this deque (optional)"
  ([^. this ^java.lang.Object o]
    (-> this (.contains o))))

(defn take-last
  "Retrieves and removes the last element of this deque, waiting
   if necessary until an element becomes available.

  returns: the tail of this deque - `BlockingDeque.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^. this]
    (-> this (.takeLast))))

(defn take-first
  "Retrieves and removes the first element of this deque, waiting
   if necessary until an element becomes available.

  returns: the head of this deque - `BlockingDeque.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^. this]
    (-> this (.takeFirst))))

(defn push
  "Pushes an element onto the stack represented by this deque (in other
   words, at the head of this deque) if it is possible to do so
   immediately without violating capacity restrictions, throwing an
   IllegalStateException if no space is currently available.

   This method is equivalent to addFirst.

  e - the element to push - `BlockingDeque.E`

  throws: java.lang.IllegalStateException - if the element cannot be added at this time due to capacity restrictions"
  ([^. this ^BlockingDeque.E e]
    (-> this (.push e))))

(defn take
  "Retrieves and removes the head of the queue represented by this deque
   (in other words, the first element of this deque), waiting if
   necessary until an element becomes available.

   This method is equivalent to takeFirst.

  returns: the head of this deque - `BlockingDeque.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^. this]
    (-> this (.take))))

(defn iterator
  "Returns an iterator over the elements in this deque in proper sequence.
   The elements will be returned in order from first (head) to last (tail).

  returns: an iterator over the elements in this deque in proper sequence - `java.util.Iterator<BlockingDeque.E>`"
  ([^. this]
    (-> this (.iterator))))

(defn element
  "Retrieves, but does not remove, the head of the queue represented by
   this deque (in other words, the first element of this deque).
   This method differs from peek only in that it throws an
   exception if this deque is empty.

   This method is equivalent to getFirst.

  returns: the head of this deque - `BlockingDeque.E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  ([^. this]
    (-> this (.element))))

(defn put-first
  "Inserts the specified element at the front of this deque,
   waiting if necessary for space to become available.

  e - the element to add - `BlockingDeque.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^. this ^BlockingDeque.E e]
    (-> this (.putFirst e))))

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

  returns: true if this deque changed as a result of the call - `boolean`

  throws: java.lang.ClassCastException - if the class of the specified element is incompatible with this deque (optional)"
  ([^. this ^java.lang.Object o]
    (-> this (.remove o)))
  ([^. this]
    (-> this (.remove))))

(defn poll-last
  "Retrieves and removes the last element of this deque, waiting
   up to the specified wait time if necessary for an element to
   become available.

  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: the tail of this deque, or null if the specified
           waiting time elapses before an element is available - `BlockingDeque.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^. this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.pollLast timeout unit))))

(defn poll
  "Retrieves and removes the head of the queue represented by this deque
   (in other words, the first element of this deque), waiting up to the
   specified wait time if necessary for an element to become available.

   This method is equivalent to
   pollFirst.

  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: the head of this deque, or null if the
           specified waiting time elapses before an element is available - `BlockingDeque.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^. this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.poll timeout unit)))
  ([^. this]
    (-> this (.poll))))

(defn offer-last
  "Inserts the specified element at the end of this deque,
   waiting up to the specified wait time if necessary for space to
   become available.

  e - the element to add - `BlockingDeque.E`
  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: true if successful, or false if
           the specified waiting time elapses before space is available - `boolean`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^. this ^BlockingDeque.E e ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.offerLast e timeout unit)))
  ([^. this ^BlockingDeque.E e]
    (-> this (.offerLast e))))

(defn poll-first
  "Retrieves and removes the first element of this deque, waiting
   up to the specified wait time if necessary for an element to
   become available.

  timeout - how long to wait before giving up, in units of unit - `long`
  unit - a TimeUnit determining how to interpret the timeout parameter - `java.util.concurrent.TimeUnit`

  returns: the head of this deque, or null if the specified
           waiting time elapses before an element is available - `BlockingDeque.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^. this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.pollFirst timeout unit))))

(defn add-last
  "Inserts the specified element at the end of this deque if it is
   possible to do so immediately without violating capacity restrictions,
   throwing an IllegalStateException if no space is currently
   available.  When using a capacity-restricted deque, it is generally
   preferable to use offerLast.

  e - the element to add - `BlockingDeque.E`

  throws: java.lang.IllegalStateException - if the element cannot be added at this time due to capacity restrictions"
  ([^. this ^BlockingDeque.E e]
    (-> this (.addLast e))))

(defn remove-last-occurrence
  "Removes the last occurrence of the specified element from this deque.
   If the deque does not contain the element, it is unchanged.
   More formally, removes the last element e such that
   o.equals(e) (if such an element exists).
   Returns true if this deque contained the specified element
   (or equivalently, if this deque changed as a result of the call).

  o - element to be removed from this deque, if present - `java.lang.Object`

  returns: true if an element was removed as a result of this call - `boolean`

  throws: java.lang.ClassCastException - if the class of the specified element is incompatible with this deque (optional)"
  ([^. this ^java.lang.Object o]
    (-> this (.removeLastOccurrence o))))

(defn add
  "Inserts the specified element into the queue represented by this deque
   (in other words, at the tail of this deque) if it is possible to do so
   immediately without violating capacity restrictions, returning
   true upon success and throwing an
   IllegalStateException if no space is currently available.
   When using a capacity-restricted deque, it is generally preferable to
   use offer.

   This method is equivalent to addLast.

  e - the element to add - `BlockingDeque.E`

  returns: true (as specified by Collection.add(E)) - `boolean`

  throws: java.lang.IllegalStateException - if the element cannot be added at this time due to capacity restrictions"
  ([^. this ^BlockingDeque.E e]
    (-> this (.add e))))

(defn size
  "Returns the number of elements in this deque.

  returns: the number of elements in this deque - `int`"
  ([^. this]
    (-> this (.size))))

(defn add-first
  "Inserts the specified element at the front of this deque if it is
   possible to do so immediately without violating capacity restrictions,
   throwing an IllegalStateException if no space is currently
   available.  When using a capacity-restricted deque, it is generally
   preferable to use offerFirst.

  e - the element to add - `BlockingDeque.E`

  throws: java.lang.IllegalStateException - if the element cannot be added at this time due to capacity restrictions"
  ([^. this ^BlockingDeque.E e]
    (-> this (.addFirst e))))

(defn put-last
  "Inserts the specified element at the end of this deque,
   waiting if necessary for space to become available.

  e - the element to add - `BlockingDeque.E`

  throws: java.lang.InterruptedException - if interrupted while waiting"
  ([^. this ^BlockingDeque.E e]
    (-> this (.putLast e))))

