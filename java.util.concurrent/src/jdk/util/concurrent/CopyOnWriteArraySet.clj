(ns jdk.util.concurrent.CopyOnWriteArraySet
  "A Set that uses an internal CopyOnWriteArrayList
  for all of its operations.  Thus, it shares the same basic properties:

   It is best suited for applications in which set sizes generally
        stay small, read-only operations
        vastly outnumber mutative operations, and you need
        to prevent interference among threads during traversal.
   It is thread-safe.
   Mutative operations (add, set, remove, etc.)
       are expensive since they usually entail copying the entire underlying
       array.
   Iterators do not support the mutative remove operation.
   Traversal via iterators is fast and cannot encounter
       interference from other threads. Iterators rely on
       unchanging snapshots of the array at the time the iterators were
       constructed.


  Sample Usage. The following code sketch uses a
  copy-on-write set to maintain a set of Handler objects that
  perform some action upon state updates.



  class Handler { void handle(); ... }

  class X {
    private final CopyOnWriteArraySet<Handler> handlers
      = new CopyOnWriteArraySet<Handler>();
    public void addHandler(Handler h) { handlers.add(h); }

    private long internalState;
    private synchronized void changeState() { internalState = ...; }

    public void update() {
      changeState();
      for (Handler handler : handlers)
        handler.handle();
    }
  }

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent CopyOnWriteArraySet]))

(defn ->copy-on-write-array-set
  "Constructor.

  Creates a set containing all of the elements of the specified
   collection.

  c - the collection of elements to initially contain - `CopyOnWriteArraySet.E>`

  throws: java.lang.NullPointerException - if the specified collection is null"
  ([^CopyOnWriteArraySet.E> c]
    (new CopyOnWriteArraySet c))
  ([]
    (new CopyOnWriteArraySet )))

(defn add-all
  "Adds all of the elements in the specified collection to this set if
   they're not already present.  If the specified collection is also a
   set, the addAll operation effectively modifies this set so
   that its value is the union of the two sets.  The behavior of
   this operation is undefined if the specified collection is modified
   while the operation is in progress.

  c - collection containing elements to be added to this set - `CopyOnWriteArraySet.E>`

  returns: true if this set changed as a result of the call - `boolean`

  throws: java.lang.NullPointerException - if the specified collection is null"
  (^Boolean [^java.util.concurrent.CopyOnWriteArraySet this ^CopyOnWriteArraySet.E> c]
    (-> this (.addAll c))))

(defn spliterator
  "Returns a Spliterator over the elements in this set in the order
   in which these elements were added.

   The Spliterator reports Spliterator.IMMUTABLE,
   Spliterator.DISTINCT, Spliterator.SIZED, and
   Spliterator.SUBSIZED.

   The spliterator provides a snapshot of the state of the set
   when the spliterator was constructed. No synchronization is needed while
   operating on the spliterator.

  returns: a Spliterator over the elements in this set - `java.util.Spliterator<CopyOnWriteArraySet.E>`"
  (^java.util.Spliterator [^java.util.concurrent.CopyOnWriteArraySet this]
    (-> this (.spliterator))))

(defn for-each
  "Description copied from interface: Iterable

  action - The action to be performed for each element - `CopyOnWriteArraySet.E>`"
  ([^java.util.concurrent.CopyOnWriteArraySet this ^CopyOnWriteArraySet.E> action]
    (-> this (.forEach action))))

(defn remove-if
  "Description copied from interface: Collection

  filter - a predicate which returns true for elements to be removed - `CopyOnWriteArraySet.E>`

  returns: true if any elements were removed - `boolean`"
  (^Boolean [^java.util.concurrent.CopyOnWriteArraySet this ^CopyOnWriteArraySet.E> filter]
    (-> this (.removeIf filter))))

(defn contains
  "Returns true if this set contains the specified element.
   More formally, returns true if and only if this set
   contains an element e such that
   (o==null ? e==null : o.equals(e)).

  o - element whose presence in this set is to be tested - `java.lang.Object`

  returns: true if this set contains the specified element - `boolean`"
  (^Boolean [^java.util.concurrent.CopyOnWriteArraySet this ^java.lang.Object o]
    (-> this (.contains o))))

(defn iterator
  "Returns an iterator over the elements contained in this set
   in the order in which these elements were added.

   The returned iterator provides a snapshot of the state of the set
   when the iterator was constructed. No synchronization is needed while
   traversing the iterator. The iterator does NOT support the
   remove method.

  returns: an iterator over the elements in this set - `java.util.Iterator<CopyOnWriteArraySet.E>`"
  (^java.util.Iterator [^java.util.concurrent.CopyOnWriteArraySet this]
    (-> this (.iterator))))

(defn remove
  "Removes the specified element from this set if it is present.
   More formally, removes an element e such that
   (o==null ? e==null : o.equals(e)),
   if this set contains such an element.  Returns true if
   this set contained the element (or equivalently, if this set
   changed as a result of the call).  (This set will not contain the
   element once the call returns.)

  o - object to be removed from this set, if present - `java.lang.Object`

  returns: true if this set contained the specified element - `boolean`"
  (^Boolean [^java.util.concurrent.CopyOnWriteArraySet this ^java.lang.Object o]
    (-> this (.remove o))))

(defn add
  "Adds the specified element to this set if it is not already present.
   More formally, adds the specified element e to this set if
   the set contains no element e2 such that
   (e==null ? e2==null : e.equals(e2)).
   If this set already contains the element, the call leaves the set
   unchanged and returns false.

  e - element to be added to this set - `CopyOnWriteArraySet.E`

  returns: true if this set did not already contain the specified
           element - `boolean`"
  (^Boolean [^java.util.concurrent.CopyOnWriteArraySet this ^CopyOnWriteArraySet.E e]
    (-> this (.add e))))

(defn empty?
  "Returns true if this set contains no elements.

  returns: true if this set contains no elements - `boolean`"
  (^Boolean [^java.util.concurrent.CopyOnWriteArraySet this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of elements in this set.

  returns: the number of elements in this set - `int`"
  (^Integer [^java.util.concurrent.CopyOnWriteArraySet this]
    (-> this (.size))))

(defn retain-all
  "Retains only the elements in this set that are contained in the
   specified collection.  In other words, removes from this set all of
   its elements that are not contained in the specified collection.  If
   the specified collection is also a set, this operation effectively
   modifies this set so that its value is the intersection of the
   two sets.

  c - collection containing elements to be retained in this set - `java.util.Collection<?>`

  returns: true if this set changed as a result of the call - `boolean`

  throws: java.lang.ClassCastException - if the class of an element of this set is incompatible with the specified collection (optional)"
  (^Boolean [^java.util.concurrent.CopyOnWriteArraySet this ^java.util.Collection c]
    (-> this (.retainAll c))))

(defn clear
  "Removes all of the elements from this set.
   The set will be empty after this call returns."
  ([^java.util.concurrent.CopyOnWriteArraySet this]
    (-> this (.clear))))

(defn to-array
  "Returns an array containing all of the elements in this set; the
   runtime type of the returned array is that of the specified array.
   If the set fits in the specified array, it is returned therein.
   Otherwise, a new array is allocated with the runtime type of the
   specified array and the size of this set.

   If this set fits in the specified array with room to spare
   (i.e., the array has more elements than this set), the element in
   the array immediately following the end of the set is set to
   null.  (This is useful in determining the length of this
   set only if the caller knows that this set does not contain
   any null elements.)

   If this set makes any guarantees as to what order its elements
   are returned by its iterator, this method must return the elements
   in the same order.

   Like the toArray() method, this method acts as bridge between
   array-based and collection-based APIs.  Further, this method allows
   precise control over the runtime type of the output array, and may,
   under certain circumstances, be used to save allocation costs.

   Suppose x is a set known to contain only strings.
   The following code can be used to dump the set into a newly allocated
   array of String:



    String[] y = x.toArray(new String[0]);

   Note that toArray(new Object[0]) is identical in function to
   toArray().

  a - the array into which the elements of this set are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose. - `T[]`

  returns: an array containing all the elements in this set - `<T> T[]`

  throws: java.lang.ArrayStoreException - if the runtime type of the specified array is not a supertype of the runtime type of every element in this set"
  ([^java.util.concurrent.CopyOnWriteArraySet this a]
    (-> this (.toArray a)))
  ([^java.util.concurrent.CopyOnWriteArraySet this]
    (-> this (.toArray))))

(defn remove-all
  "Removes from this set all of its elements that are contained in the
   specified collection.  If the specified collection is also a set,
   this operation effectively modifies this set so that its value is the
   asymmetric set difference of the two sets.

  c - collection containing elements to be removed from this set - `java.util.Collection<?>`

  returns: true if this set changed as a result of the call - `boolean`

  throws: java.lang.ClassCastException - if the class of an element of this set is incompatible with the specified collection (optional)"
  (^Boolean [^java.util.concurrent.CopyOnWriteArraySet this ^java.util.Collection c]
    (-> this (.removeAll c))))

(defn equals
  "Compares the specified object with this set for equality.
   Returns true if the specified object is the same object
   as this object, or if it is also a Set and the elements
   returned by an iterator over the
   specified set are the same as the elements returned by an
   iterator over this set.  More formally, the two iterators are
   considered to return the same elements if they return the same
   number of elements and for every element e1 returned by
   the iterator over the specified set, there is an element
   e2 returned by the iterator over this set such that
   (e1==null ? e2==null : e1.equals(e2)).

  o - object to be compared for equality with this set - `java.lang.Object`

  returns: true if the specified object is equal to this set - `boolean`"
  (^Boolean [^java.util.concurrent.CopyOnWriteArraySet this ^java.lang.Object o]
    (-> this (.equals o))))

(defn contains-all
  "Returns true if this set contains all of the elements of the
   specified collection.  If the specified collection is also a set, this
   method returns true if it is a subset of this set.

  c - collection to be checked for containment in this set - `java.util.Collection<?>`

  returns: true if this set contains all of the elements of the
           specified collection - `boolean`

  throws: java.lang.NullPointerException - if the specified collection is null"
  (^Boolean [^java.util.concurrent.CopyOnWriteArraySet this ^java.util.Collection c]
    (-> this (.containsAll c))))

