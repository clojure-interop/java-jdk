(ns jdk.util.Vector
  "The Vector class implements a growable array of
  objects. Like an array, it contains components that can be
  accessed using an integer index. However, the size of a
  Vector can grow or shrink as needed to accommodate
  adding and removing items after the Vector has been created.

  Each vector tries to optimize storage management by maintaining a
  capacity and a capacityIncrement. The
  capacity is always at least as large as the vector
  size; it is usually larger because as components are added to the
  vector, the vector's storage increases in chunks the size of
  capacityIncrement. An application can increase the
  capacity of a vector before inserting a large number of
  components; this reduces the amount of incremental reallocation.


  The iterators returned by this class's iterator and
  listIterator methods are fail-fast:
  if the vector is structurally modified at any time after the iterator is
  created, in any way except through the iterator's own
  remove or
  add methods, the iterator will throw a
  ConcurrentModificationException.  Thus, in the face of
  concurrent modification, the iterator fails quickly and cleanly, rather
  than risking arbitrary, non-deterministic behavior at an undetermined
  time in the future.  The Enumerations returned by
  the elements method are not fail-fast.

  Note that the fail-fast behavior of an iterator cannot be guaranteed
  as it is, generally speaking, impossible to make any hard guarantees in the
  presence of unsynchronized concurrent modification.  Fail-fast iterators
  throw ConcurrentModificationException on a best-effort basis.
  Therefore, it would be wrong to write a program that depended on this
  exception for its correctness:  the fail-fast behavior of iterators
  should be used only to detect bugs.

  As of the Java 2 platform v1.2, this class was retrofitted to
  implement the List interface, making it a member of the

  Java Collections Framework.  Unlike the new collection
  implementations, Vector is synchronized.  If a thread-safe
  implementation is not needed, it is recommended to use ArrayList in place of Vector."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Vector]))

(defn ->vector
  "Constructor.

  Constructs an empty vector with the specified initial capacity and
   capacity increment.

  initial-capacity - the initial capacity of the vector - `int`
  capacity-increment - the amount by which the capacity is increased when the vector overflows - `int`

  throws: java.lang.IllegalArgumentException - if the specified initial capacity is negative"
  (^Vector [^Integer initial-capacity ^Integer capacity-increment]
    (new Vector initial-capacity capacity-increment))
  (^Vector [^Integer initial-capacity]
    (new Vector initial-capacity))
  (^Vector []
    (new Vector )))

(defn add-all
  "Inserts all of the elements in the specified Collection into this
   Vector at the specified position.  Shifts the element currently at
   that position (if any) and any subsequent elements to the right
   (increases their indices).  The new elements will appear in the Vector
   in the order that they are returned by the specified Collection's
   iterator.

  index - index at which to insert the first element from the specified collection - `int`
  c - elements to be inserted into this Vector - `java.util.Collection`

  returns: true if this Vector changed as a result of the call - `boolean`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())"
  (^Boolean [^Vector this ^Integer index ^java.util.Collection c]
    (-> this (.addAll index c)))
  (^Boolean [^Vector this ^java.util.Collection c]
    (-> this (.addAll c))))

(defn first-element
  "Returns the first component (the item at index 0) of
   this vector.

  returns: the first component of this vector - `E`

  throws: java.util.NoSuchElementException - if this vector has no components"
  ([^Vector this]
    (-> this (.firstElement))))

(defn spliterator
  "Creates a late-binding
   and fail-fast Spliterator over the elements in this
   list.

   The Spliterator reports Spliterator.SIZED,
   Spliterator.SUBSIZED, and Spliterator.ORDERED.
   Overriding implementations should document the reporting of additional
   characteristic values.

  returns: a Spliterator over the elements in this list - `java.util.Spliterator<E>`"
  (^java.util.Spliterator [^Vector this]
    (-> this (.spliterator))))

(defn for-each
  "Description copied from interface: Iterable

  action - The action to be performed for each element - `java.util.function.Consumer`"
  ([^Vector this ^java.util.function.Consumer action]
    (-> this (.forEach action))))

(defn replace-all
  "Description copied from interface: List

  operator - the operator to apply to each element - `java.util.function.UnaryOperator`"
  ([^Vector this ^java.util.function.UnaryOperator operator]
    (-> this (.replaceAll operator))))

(defn remove-if
  "Description copied from interface: Collection

  filter - a predicate which returns true for elements to be removed - `java.util.function.Predicate`

  returns: true if any elements were removed - `boolean`"
  (^Boolean [^Vector this ^java.util.function.Predicate filter]
    (-> this (.removeIf filter))))

(defn add-element
  "Adds the specified component to the end of this vector,
   increasing its size by one. The capacity of this vector is
   increased if its size becomes greater than its capacity.

   This method is identical in functionality to the
   add(E)
   method (which is part of the List interface).

  obj - the component to be added - `E`"
  ([^Vector this obj]
    (-> this (.addElement obj))))

(defn contains
  "Returns true if this vector contains the specified element.
   More formally, returns true if and only if this vector
   contains at least one element e such that
   (o==null ? e==null : o.equals(e)).

  o - element whose presence in this vector is to be tested - `java.lang.Object`

  returns: true if this vector contains the specified element - `boolean`"
  (^Boolean [^Vector this ^java.lang.Object o]
    (-> this (.contains o))))

(defn to-string
  "Returns a string representation of this Vector, containing
   the String representation of each element.

  returns: a string representation of this collection - `java.lang.String`"
  (^java.lang.String [^Vector this]
    (-> this (.toString))))

(defn insert-element-at
  "Inserts the specified object as a component in this vector at the
   specified index. Each component in this vector with
   an index greater or equal to the specified index is
   shifted upward to have an index one greater than the value it had
   previously.

   The index must be a value greater than or equal to 0
   and less than or equal to the current size of the vector. (If the
   index is equal to the current size of the vector, the new element
   is appended to the Vector.)

   This method is identical in functionality to the
   add(int, E)
   method (which is part of the List interface).  Note that the
   add method reverses the order of the parameters, to more closely
   match array usage.

  obj - the component to insert - `E`
  index - where to insert the new component - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())"
  ([^Vector this obj ^Integer index]
    (-> this (.insertElementAt obj index))))

(defn list-iterator
  "Returns a list iterator over the elements in this list (in proper
   sequence), starting at the specified position in the list.
   The specified index indicates the first element that would be
   returned by an initial call to next.
   An initial call to previous would
   return the element with the specified index minus one.

   The returned list iterator is fail-fast.

  index - index of the first element to be returned from the list iterator (by a call to next) - `int`

  returns: a list iterator over the elements in this list (in proper
           sequence), starting at the specified position in the list - `java.util.ListIterator<E>`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())"
  (^java.util.ListIterator [^Vector this ^Integer index]
    (-> this (.listIterator index)))
  (^java.util.ListIterator [^Vector this]
    (-> this (.listIterator))))

(defn sort
  "Description copied from interface: List

  c - the Comparator used to compare list elements. A null value indicates that the elements' java.lang.natural ordering should be used - `java.util.Comparator`"
  ([^Vector this ^java.util.Comparator c]
    (-> this (.sort c))))

(defn iterator
  "Returns an iterator over the elements in this list in proper sequence.

   The returned iterator is fail-fast.

  returns: an iterator over the elements in this list in proper sequence - `java.util.Iterator<E>`"
  (^java.util.Iterator [^Vector this]
    (-> this (.iterator))))

(defn remove-all-elements
  "Removes all components from this vector and sets its size to zero.

   This method is identical in functionality to the clear()
   method (which is part of the List interface)."
  ([^Vector this]
    (-> this (.removeAllElements))))

(defn sub-list
  "Returns a view of the portion of this List between fromIndex,
   inclusive, and toIndex, exclusive.  (If fromIndex and toIndex are
   equal, the returned List is empty.)  The returned List is backed by this
   List, so changes in the returned List are reflected in this List, and
   vice-versa.  The returned List supports all of the optional List
   operations supported by this List.

   This method eliminates the need for explicit range operations (of
   the sort that commonly exist for arrays).  Any operation that expects
   a List can be used as a range operation by operating on a subList view
   instead of a whole List.  For example, the following idiom
   removes a range of elements from a List:


        list.subList(from, to).clear();
   Similar idioms may be constructed for indexOf and lastIndexOf,
   and all of the algorithms in the Collections class can be applied to
   a subList.

   The semantics of the List returned by this method become undefined if
   the backing list (i.e., this List) is structurally modified in
   any way other than via the returned List.  (Structural modifications are
   those that change the size of the List, or otherwise perturb it in such
   a fashion that iterations in progress may yield incorrect results.)

  from-index - low endpoint (inclusive) of the subList - `int`
  to-index - high endpoint (exclusive) of the subList - `int`

  returns: a view of the specified range within this List - `java.util.List<E>`

  throws: java.lang.IndexOutOfBoundsException - if an endpoint index value is out of range (fromIndex < 0 || toIndex > size)"
  (^java.util.List [^Vector this ^Integer from-index ^Integer to-index]
    (-> this (.subList from-index to-index))))

(defn last-index-of
  "Returns the index of the last occurrence of the specified element in
   this vector, searching backwards from index, or returns -1 if
   the element is not found.
   More formally, returns the highest index i such that
   (i <= index && (o==null ? get(i)==null : o.equals(get(i)))),
   or -1 if there is no such index.

  o - element to search for - `java.lang.Object`
  index - index to start searching backwards from - `int`

  returns: the index of the last occurrence of the element at position
           less than or equal to index in this vector;
           -1 if the element is not found. - `int`

  throws: java.lang.IndexOutOfBoundsException - if the specified index is greater than or equal to the current size of this vector"
  (^Integer [^Vector this ^java.lang.Object o ^Integer index]
    (-> this (.lastIndexOf o index)))
  (^Integer [^Vector this ^java.lang.Object o]
    (-> this (.lastIndexOf o))))

(defn remove-element
  "Removes the first (lowest-indexed) occurrence of the argument
   from this vector. If the object is found in this vector, each
   component in the vector with an index greater or equal to the
   object's index is shifted downward to have an index one smaller
   than the value it had previously.

   This method is identical in functionality to the
   remove(Object) method (which is part of the
   List interface).

  obj - the component to be removed - `java.lang.Object`

  returns: true if the argument was a component of this
            vector; false otherwise. - `boolean`"
  (^Boolean [^Vector this ^java.lang.Object obj]
    (-> this (.removeElement obj))))

(defn set-element-at
  "Sets the component at the specified index of this
   vector to be the specified object. The previous component at that
   position is discarded.

   The index must be a value greater than or equal to 0
   and less than the current size of the vector.

   This method is identical in functionality to the
   set(int, E)
   method (which is part of the List interface). Note that the
   set method reverses the order of the parameters, to more closely
   match array usage.  Note also that the set method returns the
   old value that was stored at the specified position.

  obj - what the component is to be set to - `E`
  index - the specified index - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())"
  ([^Vector this obj ^Integer index]
    (-> this (.setElementAt obj index))))

(defn remove
  "Removes the first occurrence of the specified element in this Vector
   If the Vector does not contain the element, it is unchanged.  More
   formally, removes the element with the lowest index i such that
   (o==null ? get(i)==null : o.equals(get(i))) (if such
   an element exists).

  o - element to be removed from this Vector, if present - `java.lang.Object`

  returns: true if the Vector contained the specified element - `boolean`"
  (^Boolean [^Vector this ^java.lang.Object o]
    (-> this (.remove o))))

(defn copy-into
  "Copies the components of this vector into the specified array.
   The item at index k in this vector is copied into
   component k of anArray.

  an-array - the array into which the components get copied - `java.lang.Object[]`

  throws: java.lang.NullPointerException - if the given array is null"
  ([^Vector this an-array]
    (-> this (.copyInto an-array))))

(defn ensure-capacity
  "Increases the capacity of this vector, if necessary, to ensure
   that it can hold at least the number of components specified by
   the minimum capacity argument.

   If the current capacity of this vector is less than
   minCapacity, then its capacity is increased by replacing its
   internal data array, kept in the field elementData, with a
   larger one.  The size of the new data array will be the old size plus
   capacityIncrement, unless the value of
   capacityIncrement is less than or equal to zero, in which case
   the new capacity will be twice the old capacity; but if this new size
   is still smaller than minCapacity, then the new capacity will
   be minCapacity.

  min-capacity - the desired minimum capacity - `int`"
  ([^Vector this ^Integer min-capacity]
    (-> this (.ensureCapacity min-capacity))))

(defn element-at
  "Returns the component at the specified index.

   This method is identical in functionality to the get(int)
   method (which is part of the List interface).

  index - an index into this vector - `int`

  returns: the component at the specified index - `E`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())"
  ([^Vector this ^Integer index]
    (-> this (.elementAt index))))

(defn set-size
  "Sets the size of this vector. If the new size is greater than the
   current size, new null items are added to the end of
   the vector. If the new size is less than the current size, all
   components at index newSize and greater are discarded.

  new-size - the new size of this vector - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the new size is negative"
  ([^Vector this ^Integer new-size]
    (-> this (.setSize new-size))))

(defn clone
  "Returns a clone of this vector. The copy will contain a
   reference to a clone of the internal data array, not a reference
   to the original internal data array of this Vector object.

  returns: a clone of this vector - `java.lang.Object`"
  (^java.lang.Object [^Vector this]
    (-> this (.clone))))

(defn hash-code
  "Returns the hash code value for this Vector.

  returns: the hash code value for this list - `int`"
  (^Integer [^Vector this]
    (-> this (.hashCode))))

(defn add
  "Inserts the specified element at the specified position in this Vector.
   Shifts the element currently at that position (if any) and any
   subsequent elements to the right (adds one to their indices).

  index - index at which the specified element is to be inserted - `int`
  element - element to be inserted - `E`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())"
  ([^Vector this ^Integer index element]
    (-> this (.add index element)))
  (^Boolean [^Vector this e]
    (-> this (.add e))))

(defn set
  "Replaces the element at the specified position in this Vector with the
   specified element.

  index - index of the element to replace - `int`
  element - element to be stored at the specified position - `E`

  returns: the element previously at the specified position - `E`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())"
  ([^Vector this ^Integer index element]
    (-> this (.set index element))))

(defn empty?
  "Tests if this vector has no components.

  returns: true if and only if this vector has
            no components, that is, its size is zero;
            false otherwise. - `boolean`"
  (^Boolean [^Vector this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of components in this vector.

  returns: the number of components in this vector - `int`"
  (^Integer [^Vector this]
    (-> this (.size))))

(defn retain-all
  "Retains only the elements in this Vector that are contained in the
   specified Collection.  In other words, removes from this Vector all
   of its elements that are not contained in the specified Collection.

  c - a collection of elements to be retained in this Vector (all other elements are removed) - `java.util.Collection`

  returns: true if this Vector changed as a result of the call - `boolean`

  throws: java.lang.ClassCastException - if the types of one or more elements in this vector are incompatible with the specified collection (optional)"
  (^Boolean [^Vector this ^java.util.Collection c]
    (-> this (.retainAll c))))

(defn clear
  "Removes all of the elements from this Vector.  The Vector will
   be empty after this call returns (unless it throws an exception)."
  ([^Vector this]
    (-> this (.clear))))

(defn index-of
  "Returns the index of the first occurrence of the specified element in
   this vector, searching forwards from index, or returns -1 if
   the element is not found.
   More formally, returns the lowest index i such that
   (i >= index && (o==null ? get(i)==null : o.equals(get(i)))),
   or -1 if there is no such index.

  o - element to search for - `java.lang.Object`
  index - index to start searching from - `int`

  returns: the index of the first occurrence of the element in
           this vector at position index or later in the vector;
           -1 if the element is not found. - `int`

  throws: java.lang.IndexOutOfBoundsException - if the specified index is negative"
  (^Integer [^Vector this ^java.lang.Object o ^Integer index]
    (-> this (.indexOf o index)))
  (^Integer [^Vector this ^java.lang.Object o]
    (-> this (.indexOf o))))

(defn to-array
  "Returns an array containing all of the elements in this Vector in the
   correct order; the runtime type of the returned array is that of the
   specified array.  If the Vector fits in the specified array, it is
   returned therein.  Otherwise, a new array is allocated with the runtime
   type of the specified array and the size of this Vector.

   If the Vector fits in the specified array with room to spare
   (i.e., the array has more elements than the Vector),
   the element in the array immediately following the end of the
   Vector is set to null.  (This is useful in determining the length
   of the Vector only if the caller knows that the Vector
   does not contain any null elements.)

  a - the array into which the elements of the Vector are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose. - `T[]`

  returns: an array containing the elements of the Vector - `<T> T[]`

  throws: java.lang.ArrayStoreException - if the runtime type of a is not a supertype of the runtime type of every element in this Vector"
  ([^Vector this a]
    (-> this (.toArray a)))
  ([^Vector this]
    (-> this (.toArray))))

(defn last-element
  "Returns the last component of the vector.

  returns: the last component of the vector, i.e., the component at index
            size() - 1. - `E`

  throws: java.util.NoSuchElementException - if this vector is empty"
  ([^Vector this]
    (-> this (.lastElement))))

(defn remove-all
  "Removes from this Vector all of its elements that are contained in the
   specified Collection.

  c - a collection of elements to be removed from the Vector - `java.util.Collection`

  returns: true if this Vector changed as a result of the call - `boolean`

  throws: java.lang.ClassCastException - if the types of one or more elements in this vector are incompatible with the specified collection (optional)"
  (^Boolean [^Vector this ^java.util.Collection c]
    (-> this (.removeAll c))))

(defn get
  "Returns the element at the specified position in this Vector.

  index - index of the element to return - `int`

  returns: object at the specified index - `E`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())"
  ([^Vector this ^Integer index]
    (-> this (.get index))))

(defn capacity
  "Returns the current capacity of this vector.

  returns: the current capacity (the length of its internal
            data array, kept in the field elementData
            of this vector) - `int`"
  (^Integer [^Vector this]
    (-> this (.capacity))))

(defn remove-element-at
  "Deletes the component at the specified index. Each component in
   this vector with an index greater or equal to the specified
   index is shifted downward to have an index one
   smaller than the value it had previously. The size of this vector
   is decreased by 1.

   The index must be a value greater than or equal to 0
   and less than the current size of the vector.

   This method is identical in functionality to the remove(int)
   method (which is part of the List interface).  Note that the
   remove method returns the old value that was stored at the
   specified position.

  index - the index of the object to remove - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())"
  ([^Vector this ^Integer index]
    (-> this (.removeElementAt index))))

(defn equals
  "Compares the specified Object with this Vector for equality.  Returns
   true if and only if the specified Object is also a List, both Lists
   have the same size, and all corresponding pairs of elements in the two
   Lists are equal.  (Two elements e1 and
   e2 are equal if (e1==null ? e2==null :
   e1.equals(e2)).)  In other words, two Lists are defined to be
   equal if they contain the same elements in the same order.

  o - the Object to be compared for equality with this Vector - `java.lang.Object`

  returns: true if the specified Object is equal to this Vector - `boolean`"
  (^Boolean [^Vector this ^java.lang.Object o]
    (-> this (.equals o))))

(defn elements
  "Returns an enumeration of the components of this vector. The
   returned Enumeration object will generate all items in
   this vector. The first item generated is the item at index 0,
   then the item at index 1, and so on.

  returns: an enumeration of the components of this vector - `java.util.Enumeration<E>`"
  (^java.util.Enumeration [^Vector this]
    (-> this (.elements))))

(defn trim-to-size
  "Trims the capacity of this vector to be the vector's current
   size. If the capacity of this vector is larger than its current
   size, then the capacity is changed to equal the size by replacing
   its internal data array, kept in the field elementData,
   with a smaller one. An application can use this operation to
   minimize the storage of a vector."
  ([^Vector this]
    (-> this (.trimToSize))))

(defn contains-all
  "Returns true if this Vector contains all of the elements in the
   specified Collection.

  c - a collection whose elements will be tested for containment in this Vector - `java.util.Collection`

  returns: true if this Vector contains all of the elements in the
           specified collection - `boolean`

  throws: java.lang.NullPointerException - if the specified collection is null"
  (^Boolean [^Vector this ^java.util.Collection c]
    (-> this (.containsAll c))))

