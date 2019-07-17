(ns jdk.util.ListIterator
  "An iterator for lists that allows the programmer
  to traverse the list in either direction, modify
  the list during iteration, and obtain the iterator's
  current position in the list. A ListIterator
  has no current element; its cursor position always
  lies between the element that would be returned by a call
  to previous() and the element that would be
  returned by a call to next().
  An iterator for a list of length n has n+1 possible
  cursor positions, as illustrated by the carets (^) below:


                       Element(0)   Element(1)   Element(2)   ... Element(n-1)
  cursor positions:  ^            ^            ^            ^                  ^
  Note that the remove() and set(Object) methods are
  not defined in terms of the cursor position;  they are defined to
  operate on the last element returned by a call to next() or
  previous().

  This interface is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util ListIterator]))

(defn next
  "Returns the next element in the list and advances the cursor position.
   This method may be called repeatedly to iterate through the list,
   or intermixed with calls to previous() to go back and forth.
   (Note that alternating calls to next and previous
   will return the same element repeatedly.)

  returns: the next element in the list - `ListIterator.E`

  throws: java.util.NoSuchElementException - if the iteration has no next element"
  (^ListIterator.E [^java.util.ListIterator this]
    (-> this (.next))))

(defn has-previous?
  "Returns true if this list iterator has more elements when
   traversing the list in the reverse direction.  (In other words,
   returns true if previous() would return an element
   rather than throwing an exception.)

  returns: true if the list iterator has more elements when
           traversing the list in the reverse direction - `boolean`"
  (^Boolean [^java.util.ListIterator this]
    (-> this (.hasPrevious))))

(defn previous-index
  "Returns the index of the element that would be returned by a
   subsequent call to previous(). (Returns -1 if the list
   iterator is at the beginning of the list.)

  returns: the index of the element that would be returned by a
           subsequent call to previous, or -1 if the list
           iterator is at the beginning of the list - `int`"
  (^Integer [^java.util.ListIterator this]
    (-> this (.previousIndex))))

(defn previous
  "Returns the previous element in the list and moves the cursor
   position backwards.  This method may be called repeatedly to
   iterate through the list backwards, or intermixed with calls to
   next() to go back and forth.  (Note that alternating calls
   to next and previous will return the same
   element repeatedly.)

  returns: the previous element in the list - `ListIterator.E`

  throws: java.util.NoSuchElementException - if the iteration has no previous element"
  (^ListIterator.E [^java.util.ListIterator this]
    (-> this (.previous))))

(defn remove
  "Removes from the list the last element that was returned by next() or previous() (optional operation).  This call can
   only be made once per call to next or previous.
   It can be made only if add(E) has not been
   called after the last call to next or previous.

  throws: java.lang.UnsupportedOperationException - if the remove operation is not supported by this list iterator"
  ([^java.util.ListIterator this]
    (-> this (.remove))))

(defn has-next?
  "Returns true if this list iterator has more elements when
   traversing the list in the forward direction. (In other words,
   returns true if next() would return an element rather
   than throwing an exception.)

  returns: true if the list iterator has more elements when
           traversing the list in the forward direction - `boolean`"
  (^Boolean [^java.util.ListIterator this]
    (-> this (.hasNext))))

(defn add
  "Inserts the specified element into the list (optional operation).
   The element is inserted immediately before the element that
   would be returned by next(), if any, and after the element
   that would be returned by previous(), if any.  (If the
   list contains no elements, the new element becomes the sole element
   on the list.)  The new element is inserted before the implicit
   cursor: a subsequent call to next would be unaffected, and a
   subsequent call to previous would return the new element.
   (This call increases by one the value that would be returned by a
   call to nextIndex or previousIndex.)

  e - the element to insert - `ListIterator.E`

  throws: java.lang.UnsupportedOperationException - if the add method is not supported by this list iterator"
  ([^java.util.ListIterator this ^ListIterator.E e]
    (-> this (.add e))))

(defn set
  "Replaces the last element returned by next() or
   previous() with the specified element (optional operation).
   This call can be made only if neither remove() nor add(E) have been called after the last call to next or
   previous.

  e - the element with which to replace the last element returned by next or previous - `ListIterator.E`

  throws: java.lang.UnsupportedOperationException - if the set operation is not supported by this list iterator"
  ([^java.util.ListIterator this ^ListIterator.E e]
    (-> this (.set e))))

(defn next-index
  "Returns the index of the element that would be returned by a
   subsequent call to next(). (Returns list size if the list
   iterator is at the end of the list.)

  returns: the index of the element that would be returned by a
           subsequent call to next, or list size if the list
           iterator is at the end of the list - `int`"
  (^Integer [^java.util.ListIterator this]
    (-> this (.nextIndex))))

