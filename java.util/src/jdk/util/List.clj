(ns jdk.util.List
  "An ordered collection (also known as a sequence).  The user of this
  interface has precise control over where in the list each element is
  inserted.  The user can access elements by their integer index (position in
  the list), and search for elements in the list.

  Unlike sets, lists typically allow duplicate elements.  More formally,
  lists typically allow pairs of elements e1 and e2
  such that e1.equals(e2), and they typically allow multiple
  null elements if they allow null elements at all.  It is not inconceivable
  that someone might wish to implement a list that prohibits duplicates, by
  throwing runtime exceptions when the user attempts to insert them, but we
  expect this usage to be rare.

  The List interface places additional stipulations, beyond those
  specified in the Collection interface, on the contracts of the
  iterator, add, remove, equals, and
  hashCode methods.  Declarations for other inherited methods are
  also included here for convenience.

  The List interface provides four methods for positional (indexed)
  access to list elements.  Lists (like Java arrays) are zero based.  Note
  that these operations may execute in time proportional to the index value
  for some implementations (the LinkedList class, for
  example). Thus, iterating over the elements in a list is typically
  preferable to indexing through it if the caller does not know the
  implementation.

  The List interface provides a special iterator, called a
  ListIterator, that allows element insertion and replacement, and
  bidirectional access in addition to the normal operations that the
  Iterator interface provides.  A method is provided to obtain a
  list iterator that starts at a specified position in the list.

  The List interface provides two methods to search for a specified
  object.  From a performance standpoint, these methods should be used with
  caution.  In many implementations they will perform costly linear
  searches.

  The List interface provides two methods to efficiently insert and
  remove multiple elements at an arbitrary point in the list.

  Note: While it is permissible for lists to contain themselves as elements,
  extreme caution is advised: the equals and hashCode
  methods are no longer well defined on such a list.

  Some list implementations have restrictions on the elements that
  they may contain.  For example, some implementations prohibit null elements,
  and some have restrictions on the types of their elements.  Attempting to
  add an ineligible element throws an unchecked exception, typically
  NullPointerException or ClassCastException.  Attempting
  to query the presence of an ineligible element may throw an exception,
  or it may simply return false; some implementations will exhibit the former
  behavior and some will exhibit the latter.  More generally, attempting an
  operation on an ineligible element whose completion would not result in
  the insertion of an ineligible element into the list may throw an
  exception or it may succeed, at the option of the implementation.
  Such exceptions are marked as \"optional\" in the specification for this
  interface.

  This interface is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util List]))

(defn add-all
  "Inserts all of the elements in the specified collection into this
   list at the specified position (optional operation).  Shifts the
   element currently at that position (if any) and any subsequent
   elements to the right (increases their indices).  The new elements
   will appear in this list in the order that they are returned by the
   specified collection's iterator.  The behavior of this operation is
   undefined if the specified collection is modified while the
   operation is in progress.  (Note that this will occur if the specified
   collection is this list, and it's nonempty.)

  index - index at which to insert the first element from the specified collection - `int`
  c - collection containing elements to be added to this list - `java.util.Collection`

  returns: true if this list changed as a result of the call - `boolean`

  throws: java.lang.UnsupportedOperationException - if the addAll operation is not supported by this list"
  (^Boolean [^List this ^Integer index ^java.util.Collection c]
    (-> this (.addAll index c)))
  (^Boolean [^List this ^java.util.Collection c]
    (-> this (.addAll c))))

(defn spliterator
  "Creates a Spliterator over the elements in this list.

   The Spliterator reports Spliterator.SIZED and
   Spliterator.ORDERED.  Implementations should document the
   reporting of additional characteristic values.

  returns: a Spliterator over the elements in this list - `default java.util.Spliterator<E>`"
  ([^List this]
    (-> this (.spliterator))))

(defn replace-all
  "Replaces each element of this list with the result of applying the
   operator to that element.  Errors or runtime exceptions thrown by
   the operator are relayed to the caller.

  operator - the operator to apply to each element - `java.util.function.UnaryOperator`

  returns: `default void`

  throws: java.lang.UnsupportedOperationException - if this list is unmodifiable. Implementations may throw this exception if an element cannot be replaced or if, in general, modification is not supported"
  ([^List this ^java.util.function.UnaryOperator operator]
    (-> this (.replaceAll operator))))

(defn contains
  "Returns true if this list contains the specified element.
   More formally, returns true if and only if this list contains
   at least one element e such that
   (o==null ? e==null : o.equals(e)).

  o - element whose presence in this list is to be tested - `java.lang.Object`

  returns: true if this list contains the specified element - `boolean`

  throws: java.lang.ClassCastException - if the type of the specified element is incompatible with this list (optional)"
  (^Boolean [^List this ^java.lang.Object o]
    (-> this (.contains o))))

(defn list-iterator
  "Returns a list iterator over the elements in this list (in proper
   sequence), starting at the specified position in the list.
   The specified index indicates the first element that would be
   returned by an initial call to next.
   An initial call to previous would
   return the element with the specified index minus one.

  index - index of the first element to be returned from the list iterator (by a call to next) - `int`

  returns: a list iterator over the elements in this list (in proper
           sequence), starting at the specified position in the list - `java.util.ListIterator<E>`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())"
  (^java.util.ListIterator [^List this ^Integer index]
    (-> this (.listIterator index)))
  (^java.util.ListIterator [^List this]
    (-> this (.listIterator))))

(defn sort
  "Sorts this list according to the order induced by the specified
   Comparator.

   All elements in this list must be mutually comparable using the
   specified comparator (that is, c.compare(e1, e2) must not throw
   a ClassCastException for any elements e1 and e2
   in the list).

   If the specified comparator is null then all elements in this
   list must implement the Comparable interface and the elements'
   java.lang.natural ordering should be used.

   This list must be modifiable, but need not be resizable.

  c - the Comparator used to compare list elements. A null value indicates that the elements' java.lang.natural ordering should be used - `java.util.Comparator`

  returns: `default void`

  throws: java.lang.ClassCastException - if the list contains elements that are not mutually comparable using the specified comparator"
  ([^List this ^java.util.Comparator c]
    (-> this (.sort c))))

(defn iterator
  "Returns an iterator over the elements in this list in proper sequence.

  returns: an iterator over the elements in this list in proper sequence - `java.util.Iterator<E>`"
  (^java.util.Iterator [^List this]
    (-> this (.iterator))))

(defn sub-list
  "Returns a view of the portion of this list between the specified
   fromIndex, inclusive, and toIndex, exclusive.  (If
   fromIndex and toIndex are equal, the returned list is
   empty.)  The returned list is backed by this list, so non-structural
   changes in the returned list are reflected in this list, and vice-versa.
   The returned list supports all of the optional list operations supported
   by this list.

   This method eliminates the need for explicit range operations (of
   the sort that commonly exist for arrays).  Any operation that expects
   a list can be used as a range operation by passing a subList view
   instead of a whole list.  For example, the following idiom
   removes a range of elements from a list:


        list.subList(from, to).clear();
   Similar idioms may be constructed for indexOf and
   lastIndexOf, and all of the algorithms in the
   Collections class can be applied to a subList.

   The semantics of the list returned by this method become undefined if
   the backing list (i.e., this list) is structurally modified in
   any way other than via the returned list.  (Structural modifications are
   those that change the size of this list, or otherwise perturb it in such
   a fashion that iterations in progress may yield incorrect results.)

  from-index - low endpoint (inclusive) of the subList - `int`
  to-index - high endpoint (exclusive) of the subList - `int`

  returns: a view of the specified range within this list - `java.util.List<E>`

  throws: java.lang.IndexOutOfBoundsException - for an illegal endpoint index value (fromIndex < 0 || toIndex > size || fromIndex > toIndex)"
  (^java.util.List [^List this ^Integer from-index ^Integer to-index]
    (-> this (.subList from-index to-index))))

(defn last-index-of
  "Returns the index of the last occurrence of the specified element
   in this list, or -1 if this list does not contain the element.
   More formally, returns the highest index i such that
   (o==null ? get(i)==null : o.equals(get(i))),
   or -1 if there is no such index.

  o - element to search for - `java.lang.Object`

  returns: the index of the last occurrence of the specified element in
           this list, or -1 if this list does not contain the element - `int`

  throws: java.lang.ClassCastException - if the type of the specified element is incompatible with this list (optional)"
  (^Integer [^List this ^java.lang.Object o]
    (-> this (.lastIndexOf o))))

(defn remove
  "Removes the first occurrence of the specified element from this list,
   if it is present (optional operation).  If this list does not contain
   the element, it is unchanged.  More formally, removes the element with
   the lowest index i such that
   (o==null ? get(i)==null : o.equals(get(i)))
   (if such an element exists).  Returns true if this list
   contained the specified element (or equivalently, if this list changed
   as a result of the call).

  o - element to be removed from this list, if present - `java.lang.Object`

  returns: true if this list contained the specified element - `boolean`

  throws: java.lang.ClassCastException - if the type of the specified element is incompatible with this list (optional)"
  (^Boolean [^List this ^java.lang.Object o]
    (-> this (.remove o))))

(defn hash-code
  "Returns the hash code value for this list.  The hash code of a list
   is defined to be the result of the following calculation:


       int hashCode = 1;
       for (E e : list)
           hashCode = 31*hashCode  (e==null ? 0 : e.hashCode());
   This ensures that list1.equals(list2) implies that
   list1.hashCode()==list2.hashCode() for any two lists,
   list1 and list2, as required by the general
   contract of Object.hashCode().

  returns: the hash code value for this list - `int`"
  (^Integer [^List this]
    (-> this (.hashCode))))

(defn add
  "Inserts the specified element at the specified position in this list
   (optional operation).  Shifts the element currently at that position
   (if any) and any subsequent elements to the right (adds one to their
   indices).

  index - index at which the specified element is to be inserted - `int`
  element - element to be inserted - `E`

  throws: java.lang.UnsupportedOperationException - if the add operation is not supported by this list"
  ([^List this ^Integer index element]
    (-> this (.add index element)))
  (^Boolean [^List this e]
    (-> this (.add e))))

(defn set
  "Replaces the element at the specified position in this list with the
   specified element (optional operation).

  index - index of the element to replace - `int`
  element - element to be stored at the specified position - `E`

  returns: the element previously at the specified position - `E`

  throws: java.lang.UnsupportedOperationException - if the set operation is not supported by this list"
  ([^List this ^Integer index element]
    (-> this (.set index element))))

(defn empty?
  "Returns true if this list contains no elements.

  returns: true if this list contains no elements - `boolean`"
  (^Boolean [^List this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of elements in this list.  If this list contains
   more than Integer.MAX_VALUE elements, returns
   Integer.MAX_VALUE.

  returns: the number of elements in this list - `int`"
  (^Integer [^List this]
    (-> this (.size))))

(defn retain-all
  "Retains only the elements in this list that are contained in the
   specified collection (optional operation).  In other words, removes
   from this list all of its elements that are not contained in the
   specified collection.

  c - collection containing elements to be retained in this list - `java.util.Collection`

  returns: true if this list changed as a result of the call - `boolean`

  throws: java.lang.UnsupportedOperationException - if the retainAll operation is not supported by this list"
  (^Boolean [^List this ^java.util.Collection c]
    (-> this (.retainAll c))))

(defn clear
  "Removes all of the elements from this list (optional operation).
   The list will be empty after this call returns.

  throws: java.lang.UnsupportedOperationException - if the clear operation is not supported by this list"
  ([^List this]
    (-> this (.clear))))

(defn index-of
  "Returns the index of the first occurrence of the specified element
   in this list, or -1 if this list does not contain the element.
   More formally, returns the lowest index i such that
   (o==null ? get(i)==null : o.equals(get(i))),
   or -1 if there is no such index.

  o - element to search for - `java.lang.Object`

  returns: the index of the first occurrence of the specified element in
           this list, or -1 if this list does not contain the element - `int`

  throws: java.lang.ClassCastException - if the type of the specified element is incompatible with this list (optional)"
  (^Integer [^List this ^java.lang.Object o]
    (-> this (.indexOf o))))

(defn to-array
  "Returns an array containing all of the elements in this list in
   proper sequence (from first to last element); the runtime type of
   the returned array is that of the specified array.  If the list fits
   in the specified array, it is returned therein.  Otherwise, a new
   array is allocated with the runtime type of the specified array and
   the size of this list.

   If the list fits in the specified array with room to spare (i.e.,
   the array has more elements than the list), the element in the array
   immediately following the end of the list is set to null.
   (This is useful in determining the length of the list only if
   the caller knows that the list does not contain any null elements.)

   Like the toArray() method, this method acts as bridge between
   array-based and collection-based APIs.  Further, this method allows
   precise control over the runtime type of the output array, and may,
   under certain circumstances, be used to save allocation costs.

   Suppose x is a list known to contain only strings.
   The following code can be used to dump the list into a newly
   allocated array of String:



       String[] y = x.toArray(new String[0]);

   Note that toArray(new Object[0]) is identical in function to
   toArray().

  a - the array into which the elements of this list are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose. - `T[]`

  returns: an array containing the elements of this list - `<T> T[]`

  throws: java.lang.ArrayStoreException - if the runtime type of the specified array is not a supertype of the runtime type of every element in this list"
  ([^List this a]
    (-> this (.toArray a)))
  ([^List this]
    (-> this (.toArray))))

(defn remove-all
  "Removes from this list all of its elements that are contained in the
   specified collection (optional operation).

  c - collection containing elements to be removed from this list - `java.util.Collection`

  returns: true if this list changed as a result of the call - `boolean`

  throws: java.lang.UnsupportedOperationException - if the removeAll operation is not supported by this list"
  (^Boolean [^List this ^java.util.Collection c]
    (-> this (.removeAll c))))

(defn get
  "Returns the element at the specified position in this list.

  index - index of the element to return - `int`

  returns: the element at the specified position in this list - `E`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())"
  ([^List this ^Integer index]
    (-> this (.get index))))

(defn equals
  "Compares the specified object with this list for equality.  Returns
   true if and only if the specified object is also a list, both
   lists have the same size, and all corresponding pairs of elements in
   the two lists are equal.  (Two elements e1 and
   e2 are equal if (e1==null ? e2==null :
   e1.equals(e2)).)  In other words, two lists are defined to be
   equal if they contain the same elements in the same order.  This
   definition ensures that the equals method works properly across
   different implementations of the List interface.

  o - the object to be compared for equality with this list - `java.lang.Object`

  returns: true if the specified object is equal to this list - `boolean`"
  (^Boolean [^List this ^java.lang.Object o]
    (-> this (.equals o))))

(defn contains-all
  "Returns true if this list contains all of the elements of the
   specified collection.

  c - collection to be checked for containment in this list - `java.util.Collection`

  returns: true if this list contains all of the elements of the
           specified collection - `boolean`

  throws: java.lang.ClassCastException - if the types of one or more elements in the specified collection are incompatible with this list (optional)"
  (^Boolean [^List this ^java.util.Collection c]
    (-> this (.containsAll c))))

