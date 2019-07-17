(ns jdk.util.Deque
  "A linear collection that supports element insertion and removal at
  both ends.  The name deque is short for `double ended queue`
  and is usually pronounced `deck`.  Most Deque
  implementations place no fixed limits on the number of elements
  they may contain, but this interface supports capacity-restricted
  deques as well as those with no fixed size limit.

  This interface defines methods to access the elements at both
  ends of the deque.  Methods are provided to insert, remove, and
  examine the element.  Each of these methods exists in two forms:
  one throws an exception if the operation fails, the other returns a
  special value (either null or false, depending on
  the operation).  The latter form of the insert operation is
  designed specifically for use with capacity-restricted
  Deque implementations; in most implementations, insert
  operations cannot fail.

  The twelve methods described above are summarized in the
  following table:


  Summary of Deque methods


      First Element (Head)
      Last Element (Tail)



     Throws exception
     Special value
     Throws exception
     Special value


     Insert
     addFirst(e)
     offerFirst(e)
     addLast(e)
     offerLast(e)


     Remove
     removeFirst()
     pollFirst()
     removeLast()
     pollLast()


     Examine
     getFirst()
     peekFirst()
     getLast()
     peekLast()



  This interface extends the Queue interface.  When a deque is
  used as a queue, FIFO (First-In-First-Out) behavior results.  Elements are
  added at the end of the deque and removed from the beginning.  The methods
  inherited from the Queue interface are precisely equivalent to
  Deque methods as indicated in the following table:


  Comparison of Queue and Deque methods

      Queue Method
      Equivalent Deque Method


     add(e)
     addLast(e)


     offer(e)
     offerLast(e)


     remove()
     removeFirst()


     poll()
     pollFirst()


     element()
     getFirst()


     peek()
     peekFirst()



  Deques can also be used as LIFO (Last-In-First-Out) stacks.  This
  interface should be used in preference to the legacy Stack class.
  When a deque is used as a stack, elements are pushed and popped from the
  beginning of the deque.  Stack methods are precisely equivalent to
  Deque methods as indicated in the table below:


  Comparison of Stack and Deque methods

      Stack Method
      Equivalent Deque Method


     push(e)
     addFirst(e)


     pop()
     removeFirst()


     peek()
     peekFirst()



  Note that the peek method works equally well when
  a deque is used as a queue or a stack; in either case, elements are
  drawn from the beginning of the deque.

  This interface provides two methods to remove interior
  elements, removeFirstOccurrence and
  removeLastOccurrence.

  Unlike the List interface, this interface does not
  provide support for indexed access to elements.

  While Deque implementations are not strictly required
  to prohibit the insertion of null elements, they are strongly
  encouraged to do so.  Users of any Deque implementations
  that do allow null elements are strongly encouraged not to
  take advantage of the ability to insert nulls.  This is so because
  null is used as a special return value by various methods
  to indicated that the deque is empty.

  Deque implementations generally do not define
  element-based versions of the equals and hashCode
  methods, but instead inherit the identity-based versions from class
  Object.

  This interface is a member of the  Java Collections
  Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Deque]))

(defn peek
  "Retrieves, but does not remove, the head of the queue represented by
   this deque (in other words, the first element of this deque), or
   returns null if this deque is empty.

   This method is equivalent to peekFirst().

  returns: the head of the queue represented by this deque, or
           null if this deque is empty - `Deque.E`"
  ([^. this]
    (-> this (.peek))))

(defn offer-first
  "Inserts the specified element at the front of this deque unless it would
   violate capacity restrictions.  When using a capacity-restricted deque,
   this method is generally preferable to the addFirst(E) method,
   which can fail to insert an element only by throwing an exception.

  e - the element to add - `Deque.E`

  returns: true if the element was added to this deque, else
           false - `boolean`

  throws: java.lang.ClassCastException - if the class of the specified element prevents it from being added to this deque"
  ([^. this ^Deque.E e]
    (-> this (.offerFirst e))))

(defn get-first
  "Retrieves, but does not remove, the first element of this deque.

   This method differs from peekFirst only in that it
   throws an exception if this deque is empty.

  returns: the head of this deque - `Deque.E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  ([^. this]
    (-> this (.getFirst))))

(defn peek-first
  "Retrieves, but does not remove, the first element of this deque,
   or returns null if this deque is empty.

  returns: the head of this deque, or null if this deque is empty - `Deque.E`"
  ([^. this]
    (-> this (.peekFirst))))

(defn remove-first-occurrence
  "Removes the first occurrence of the specified element from this deque.
   If the deque does not contain the element, it is unchanged.
   More formally, removes the first element e such that
   (o==null ? e==null : o.equals(e))
   (if such an element exists).
   Returns true if this deque contained the specified element
   (or equivalently, if this deque changed as a result of the call).

  o - element to be removed from this deque, if present - `java.lang.Object`

  returns: true if an element was removed as a result of this call - `boolean`

  throws: java.lang.ClassCastException - if the class of the specified element is incompatible with this deque (optional)"
  ([^. this ^java.lang.Object o]
    (-> this (.removeFirstOccurrence o))))

(defn offer
  "Inserts the specified element into the queue represented by this deque
   (in other words, at the tail of this deque) if it is possible to do so
   immediately without violating capacity restrictions, returning
   true upon success and false if no space is currently
   available.  When using a capacity-restricted deque, this method is
   generally preferable to the add(E) method, which can fail to
   insert an element only by throwing an exception.

   This method is equivalent to offerLast(E).

  e - the element to add - `Deque.E`

  returns: true if the element was added to this deque, else
           false - `boolean`

  throws: java.lang.ClassCastException - if the class of the specified element prevents it from being added to this deque"
  ([^. this ^Deque.E e]
    (-> this (.offer e))))

(defn peek-last
  "Retrieves, but does not remove, the last element of this deque,
   or returns null if this deque is empty.

  returns: the tail of this deque, or null if this deque is empty - `Deque.E`"
  ([^. this]
    (-> this (.peekLast))))

(defn pop
  "Pops an element from the stack represented by this deque.  In other
   words, removes and returns the first element of this deque.

   This method is equivalent to removeFirst().

  returns: the element at the front of this deque (which is the top
           of the stack represented by this deque) - `Deque.E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  ([^. this]
    (-> this (.pop))))

(defn contains
  "Returns true if this deque contains the specified element.
   More formally, returns true if and only if this deque contains
   at least one element e such that
   (o==null ? e==null : o.equals(e)).

  o - element whose presence in this deque is to be tested - `java.lang.Object`

  returns: true if this deque contains the specified element - `boolean`

  throws: java.lang.ClassCastException - if the type of the specified element is incompatible with this deque (optional)"
  ([^. this ^java.lang.Object o]
    (-> this (.contains o))))

(defn push
  "Pushes an element onto the stack represented by this deque (in other
   words, at the head of this deque) if it is possible to do so
   immediately without violating capacity restrictions, throwing an
   IllegalStateException if no space is currently available.

   This method is equivalent to addFirst(E).

  e - the element to push - `Deque.E`

  throws: java.lang.IllegalStateException - if the element cannot be added at this time due to capacity restrictions"
  ([^. this ^Deque.E e]
    (-> this (.push e))))

(defn get-last
  "Retrieves, but does not remove, the last element of this deque.
   This method differs from peekLast only in that it
   throws an exception if this deque is empty.

  returns: the tail of this deque - `Deque.E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  ([^. this]
    (-> this (.getLast))))

(defn iterator
  "Returns an iterator over the elements in this deque in proper sequence.
   The elements will be returned in order from first (head) to last (tail).

  returns: an iterator over the elements in this deque in proper sequence - `java.util.Iterator<Deque.E>`"
  ([^. this]
    (-> this (.iterator))))

(defn element
  "Retrieves, but does not remove, the head of the queue represented by
   this deque (in other words, the first element of this deque).
   This method differs from peek only in that it throws an
   exception if this deque is empty.

   This method is equivalent to getFirst().

  returns: the head of the queue represented by this deque - `Deque.E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  ([^. this]
    (-> this (.element))))

(defn remove-first
  "Retrieves and removes the first element of this deque.  This method
   differs from pollFirst only in that it throws an
   exception if this deque is empty.

  returns: the head of this deque - `Deque.E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  ([^. this]
    (-> this (.removeFirst))))

(defn remove
  "Removes the first occurrence of the specified element from this deque.
   If the deque does not contain the element, it is unchanged.
   More formally, removes the first element e such that
   (o==null ? e==null : o.equals(e))
   (if such an element exists).
   Returns true if this deque contained the specified element
   (or equivalently, if this deque changed as a result of the call).

   This method is equivalent to removeFirstOccurrence(Object).

  o - element to be removed from this deque, if present - `java.lang.Object`

  returns: true if an element was removed as a result of this call - `boolean`

  throws: java.lang.ClassCastException - if the class of the specified element is incompatible with this deque (optional)"
  ([^. this ^java.lang.Object o]
    (-> this (.remove o)))
  ([^. this]
    (-> this (.remove))))

(defn poll-last
  "Retrieves and removes the last element of this deque,
   or returns null if this deque is empty.

  returns: the tail of this deque, or null if this deque is empty - `Deque.E`"
  ([^. this]
    (-> this (.pollLast))))

(defn poll
  "Retrieves and removes the head of the queue represented by this deque
   (in other words, the first element of this deque), or returns
   null if this deque is empty.

   This method is equivalent to pollFirst().

  returns: the first element of this deque, or null if
           this deque is empty - `Deque.E`"
  ([^. this]
    (-> this (.poll))))

(defn offer-last
  "Inserts the specified element at the end of this deque unless it would
   violate capacity restrictions.  When using a capacity-restricted deque,
   this method is generally preferable to the addLast(E) method,
   which can fail to insert an element only by throwing an exception.

  e - the element to add - `Deque.E`

  returns: true if the element was added to this deque, else
           false - `boolean`

  throws: java.lang.ClassCastException - if the class of the specified element prevents it from being added to this deque"
  ([^. this ^Deque.E e]
    (-> this (.offerLast e))))

(defn poll-first
  "Retrieves and removes the first element of this deque,
   or returns null if this deque is empty.

  returns: the head of this deque, or null if this deque is empty - `Deque.E`"
  ([^. this]
    (-> this (.pollFirst))))

(defn add-last
  "Inserts the specified element at the end of this deque if it is
   possible to do so immediately without violating capacity restrictions,
   throwing an IllegalStateException if no space is currently
   available.  When using a capacity-restricted deque, it is generally
   preferable to use method offerLast(E).

   This method is equivalent to add(E).

  e - the element to add - `Deque.E`

  throws: java.lang.IllegalStateException - if the element cannot be added at this time due to capacity restrictions"
  ([^. this ^Deque.E e]
    (-> this (.addLast e))))

(defn remove-last-occurrence
  "Removes the last occurrence of the specified element from this deque.
   If the deque does not contain the element, it is unchanged.
   More formally, removes the last element e such that
   (o==null ? e==null : o.equals(e))
   (if such an element exists).
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

   This method is equivalent to addLast(E).

  e - the element to add - `Deque.E`

  returns: true (as specified by Collection.add(E)) - `boolean`

  throws: java.lang.IllegalStateException - if the element cannot be added at this time due to capacity restrictions"
  ([^. this ^Deque.E e]
    (-> this (.add e))))

(defn descending-iterator
  "Returns an iterator over the elements in this deque in reverse
   sequential order.  The elements will be returned in order from
   last (tail) to first (head).

  returns: an iterator over the elements in this deque in reverse
   sequence - `java.util.Iterator<Deque.E>`"
  ([^. this]
    (-> this (.descendingIterator))))

(defn size
  "Returns the number of elements in this deque.

  returns: the number of elements in this deque - `int`"
  ([^. this]
    (-> this (.size))))

(defn remove-last
  "Retrieves and removes the last element of this deque.  This method
   differs from pollLast only in that it throws an
   exception if this deque is empty.

  returns: the tail of this deque - `Deque.E`

  throws: java.util.NoSuchElementException - if this deque is empty"
  ([^. this]
    (-> this (.removeLast))))

(defn add-first
  "Inserts the specified element at the front of this deque if it is
   possible to do so immediately without violating capacity restrictions,
   throwing an IllegalStateException if no space is currently
   available.  When using a capacity-restricted deque, it is generally
   preferable to use method offerFirst(E).

  e - the element to add - `Deque.E`

  throws: java.lang.IllegalStateException - if the element cannot be added at this time due to capacity restrictions"
  ([^. this ^Deque.E e]
    (-> this (.addFirst e))))

