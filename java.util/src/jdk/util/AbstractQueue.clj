(ns jdk.util.AbstractQueue
  "This class provides skeletal implementations of some Queue
  operations. The implementations in this class are appropriate when
  the base implementation does not allow null
  elements.  Methods add, remove, and
  element are based on offer, poll, and peek, respectively, but throw
  exceptions instead of indicating failure via false or
  null returns.

  A Queue implementation that extends this class must
  minimally define a method Queue.offer(E) which does not permit
  insertion of null elements, along with methods Queue.peek(), Queue.poll(), Collection.size(), and
  Collection.iterator().  Typically, additional methods will be
  overridden as well.  If these requirements cannot be met, consider
  instead subclassing AbstractCollection.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util AbstractQueue]))

(defn add
  "Inserts the specified element into this queue if it is possible to do so
   immediately without violating capacity restrictions, returning
   true upon success and throwing an IllegalStateException
   if no space is currently available.

   This implementation returns true if offer succeeds,
   else throws an IllegalStateException.

  e - the element to add - `E`

  returns: true (as specified by Collection.add(E)) - `boolean`

  throws: java.lang.IllegalStateException - if the element cannot be added at this time due to capacity restrictions"
  (^Boolean [^AbstractQueue this e]
    (-> this (.add e))))

(defn remove
  "Retrieves and removes the head of this queue.  This method differs
   from poll only in that it throws an exception if this
   queue is empty.

   This implementation returns the result of poll
   unless the queue is empty.

  returns: the head of this queue - `E`

  throws: java.util.NoSuchElementException - if this queue is empty"
  ([^AbstractQueue this]
    (-> this (.remove))))

(defn element
  "Retrieves, but does not remove, the head of this queue.  This method
   differs from peek only in that it throws an exception if
   this queue is empty.

   This implementation returns the result of peek
   unless the queue is empty.

  returns: the head of this queue - `E`

  throws: java.util.NoSuchElementException - if this queue is empty"
  ([^AbstractQueue this]
    (-> this (.element))))

(defn clear
  "Removes all of the elements from this queue.
   The queue will be empty after this call returns.

   This implementation repeatedly invokes poll until it
   returns null."
  ([^AbstractQueue this]
    (-> this (.clear))))

(defn add-all
  "Adds all of the elements in the specified collection to this
   queue.  Attempts to addAll of a queue to itself result in
   IllegalArgumentException. Further, the behavior of
   this operation is undefined if the specified collection is
   modified while the operation is in progress.

   This implementation iterates over the specified collection,
   and adds each element returned by the iterator to this
   queue, in turn.  A runtime exception encountered while
   trying to add an element (including, in particular, a
   null element) may result in only some of the elements
   having been successfully added when the associated exception is
   thrown.

  c - collection containing elements to be added to this queue - `java.util.Collection`

  returns: true if this queue changed as a result of the call - `boolean`

  throws: java.lang.ClassCastException - if the class of an element of the specified collection prevents it from being added to this queue"
  (^Boolean [^AbstractQueue this ^java.util.Collection c]
    (-> this (.addAll c))))

