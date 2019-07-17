(ns jdk.util.AbstractCollection
  "This class provides a skeletal implementation of the Collection
  interface, to minimize the effort required to implement this interface.

  To implement an unmodifiable collection, the programmer needs only to
  extend this class and provide implementations for the iterator and
  size methods.  (The iterator returned by the iterator
  method must implement hasNext and next.)

  To implement a modifiable collection, the programmer must additionally
  override this class's add method (which otherwise throws an
  UnsupportedOperationException), and the iterator returned by the
  iterator method must additionally implement its remove
  method.

  The programmer should generally provide a void (no argument) and
  Collection constructor, as per the recommendation in the
  Collection interface specification.

  The documentation for each non-abstract method in this class describes its
  implementation in detail.  Each of these methods may be overridden if
  the collection being implemented admits a more efficient implementation.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util AbstractCollection]))

(defn add-all
  "Adds all of the elements in the specified collection to this collection
   (optional operation).  The behavior of this operation is undefined if
   the specified collection is modified while the operation is in progress.
   (This implies that the behavior of this call is undefined if the
   specified collection is this collection, and this collection is
   nonempty.)

   This implementation iterates over the specified collection, and adds
   each object returned by the iterator to this collection, in turn.

   Note that this implementation will throw an
   UnsupportedOperationException unless add is
   overridden (assuming the specified collection is non-empty).

  c - collection containing elements to be added to this collection - `AbstractCollection.E>`

  returns: true if this collection changed as a result of the call - `boolean`

  throws: java.lang.UnsupportedOperationException - if the addAll operation is not supported by this collection"
  ([^java.util.AbstractCollection this ^AbstractCollection.E> c]
    (-> this (.addAll c))))

(defn contains
  "Returns true if this collection contains the specified element.
   More formally, returns true if and only if this collection
   contains at least one element e such that
   (o==null ? e==null : o.equals(e)).

   This implementation iterates over the elements in the collection,
   checking each element in turn for equality with the specified element.

  o - element whose presence in this collection is to be tested - `java.lang.Object`

  returns: true if this collection contains the specified
           element - `boolean`

  throws: java.lang.ClassCastException - if the type of the specified element is incompatible with this collection (optional)"
  ([^java.util.AbstractCollection this ^java.lang.Object o]
    (-> this (.contains o))))

(defn to-string
  "Returns a string representation of this collection.  The string
   representation consists of a list of the collection's elements in the
   order they are returned by its iterator, enclosed in square brackets
   (`[]`).  Adjacent elements are separated by the characters
   `, ` (comma and space).  Elements are converted to strings as
   by String.valueOf(Object).

  returns: a string representation of this collection - `java.lang.String`"
  ([^java.util.AbstractCollection this]
    (-> this (.toString))))

(defn iterator
  "Returns an iterator over the elements contained in this collection.

  returns: an iterator over the elements contained in this collection - `java.util.Iterator<AbstractCollection.E>`"
  ([^java.util.AbstractCollection this]
    (-> this (.iterator))))

(defn remove
  "Removes a single instance of the specified element from this
   collection, if it is present (optional operation).  More formally,
   removes an element e such that
   (o==null ? e==null : o.equals(e)), if
   this collection contains one or more such elements.  Returns
   true if this collection contained the specified element (or
   equivalently, if this collection changed as a result of the call).

   This implementation iterates over the collection looking for the
   specified element.  If it finds the element, it removes the element
   from the collection using the iterator's remove method.

   Note that this implementation throws an
   UnsupportedOperationException if the iterator returned by this
   collection's iterator method does not implement the remove
   method and this collection contains the specified object.

  o - element to be removed from this collection, if present - `java.lang.Object`

  returns: true if an element was removed as a result of this call - `boolean`

  throws: java.lang.UnsupportedOperationException - if the remove operation is not supported by this collection"
  ([^java.util.AbstractCollection this ^java.lang.Object o]
    (-> this (.remove o))))

(defn add
  "Ensures that this collection contains the specified element (optional
   operation).  Returns true if this collection changed as a
   result of the call.  (Returns false if this collection does
   not permit duplicates and already contains the specified element.)

   Collections that support this operation may place limitations on what
   elements may be added to this collection.  In particular, some
   collections will refuse to add null elements, and others will
   impose restrictions on the type of elements that may be added.
   Collection classes should clearly specify in their documentation any
   restrictions on what elements may be added.

   If a collection refuses to add a particular element for any reason
   other than that it already contains the element, it must throw
   an exception (rather than returning false).  This preserves
   the invariant that a collection always contains the specified element
   after this call returns.

   This implementation always throws an
   UnsupportedOperationException.

  e - element whose presence in this collection is to be ensured - `AbstractCollection.E`

  returns: true if this collection changed as a result of the
           call - `boolean`

  throws: java.lang.UnsupportedOperationException - if the add operation is not supported by this collection"
  ([^java.util.AbstractCollection this ^AbstractCollection.E e]
    (-> this (.add e))))

(defn empty?
  "Returns true if this collection contains no elements.

   This implementation returns size() == 0.

  returns: true if this collection contains no elements - `boolean`"
  ([^java.util.AbstractCollection this]
    (-> this (.isEmpty))))

(defn size
  "Description copied from interface: Collection

  returns: the number of elements in this collection - `int`"
  ([^java.util.AbstractCollection this]
    (-> this (.size))))

(defn retain-all
  "Retains only the elements in this collection that are contained in the
   specified collection (optional operation).  In other words, removes from
   this collection all of its elements that are not contained in the
   specified collection.

   This implementation iterates over this collection, checking each
   element returned by the iterator in turn to see if it's contained
   in the specified collection.  If it's not so contained, it's removed
   from this collection with the iterator's remove method.

   Note that this implementation will throw an
   UnsupportedOperationException if the iterator returned by the
   iterator method does not implement the remove method
   and this collection contains one or more elements not present in the
   specified collection.

  c - collection containing elements to be retained in this collection - `java.util.Collection<?>`

  returns: true if this collection changed as a result of the call - `boolean`

  throws: java.lang.UnsupportedOperationException - if the retainAll operation is not supported by this collection"
  ([^java.util.AbstractCollection this ^java.util.Collection c]
    (-> this (.retainAll c))))

(defn clear
  "Removes all of the elements from this collection (optional operation).
   The collection will be empty after this method returns.

   This implementation iterates over this collection, removing each
   element using the Iterator.remove operation.  Most
   implementations will probably choose to override this method for
   efficiency.

   Note that this implementation will throw an
   UnsupportedOperationException if the iterator returned by this
   collection's iterator method does not implement the
   remove method and this collection is non-empty.

  throws: java.lang.UnsupportedOperationException - if the clear operation is not supported by this collection"
  ([^java.util.AbstractCollection this]
    (-> this (.clear))))

(defn to-array
  "Returns an array containing all of the elements in this collection;
   the runtime type of the returned array is that of the specified array.
   If the collection fits in the specified array, it is returned therein.
   Otherwise, a new array is allocated with the runtime type of the
   specified array and the size of this collection.

   If this collection fits in the specified array with room to spare
   (i.e., the array has more elements than this collection), the element
   in the array immediately following the end of the collection is set to
   null.  (This is useful in determining the length of this
   collection only if the caller knows that this collection does
   not contain any null elements.)

   If this collection makes any guarantees as to what order its elements
   are returned by its iterator, this method must return the elements in
   the same order.

   Like the Collection.toArray() method, this method acts as bridge between
   array-based and collection-based APIs.  Further, this method allows
   precise control over the runtime type of the output array, and may,
   under certain circumstances, be used to save allocation costs.

   Suppose x is a collection known to contain only strings.
   The following code can be used to dump the collection into a newly
   allocated array of String:



       String[] y = x.toArray(new String[0]);

   Note that toArray(new Object[0]) is identical in function to
   toArray().

   This implementation returns an array containing all the elements
   returned by this collection's iterator in the same order, stored in
   consecutive elements of the array, starting with index 0.
   If the number of elements returned by the iterator is too large to
   fit into the specified array, then the elements are returned in a
   newly allocated array with length equal to the number of elements
   returned by the iterator, even if the size of this collection
   changes during iteration, as might happen if the collection permits
   concurrent modification during iteration.  The size method is
   called only as an optimization hint; the correct result is returned
   even if the iterator returns a different number of elements.

   This method is equivalent to:



   List<E> list = new ArrayList<E>(size());
   for (E e : this)
       list.add(e);
   return list.toArray(a);

  a - the array into which the elements of this collection are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose. - `T[]`

  returns: an array containing all of the elements in this collection - `<T> T[]`

  throws: java.lang.ArrayStoreException - if the runtime type of the specified array is not a supertype of the runtime type of every element in this collection"
  ([^java.util.AbstractCollection this a]
    (-> this (.toArray a)))
  ([^java.util.AbstractCollection this]
    (-> this (.toArray))))

(defn remove-all
  "Removes all of this collection's elements that are also contained in the
   specified collection (optional operation).  After this call returns,
   this collection will contain no elements in common with the specified
   collection.

   This implementation iterates over this collection, checking each
   element returned by the iterator in turn to see if it's contained
   in the specified collection.  If it's so contained, it's removed from
   this collection with the iterator's remove method.

   Note that this implementation will throw an
   UnsupportedOperationException if the iterator returned by the
   iterator method does not implement the remove method
   and this collection contains one or more elements in common with the
   specified collection.

  c - collection containing elements to be removed from this collection - `java.util.Collection<?>`

  returns: true if this collection changed as a result of the
           call - `boolean`

  throws: java.lang.UnsupportedOperationException - if the removeAll method is not supported by this collection"
  ([^java.util.AbstractCollection this ^java.util.Collection c]
    (-> this (.removeAll c))))

(defn contains-all
  "Returns true if this collection contains all of the elements
   in the specified collection.

   This implementation iterates over the specified collection,
   checking each element returned by the iterator in turn to see
   if it's contained in this collection.  If all elements are so
   contained true is returned, otherwise false.

  c - collection to be checked for containment in this collection - `java.util.Collection<?>`

  returns: true if this collection contains all of the elements
           in the specified collection - `boolean`

  throws: java.lang.ClassCastException - if the types of one or more elements in the specified collection are incompatible with this collection (optional)"
  ([^java.util.AbstractCollection this ^java.util.Collection c]
    (-> this (.containsAll c))))

