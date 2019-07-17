(ns jdk.util.Iterator
  "An iterator over a collection.  Iterator takes the place of
  Enumeration in the Java Collections Framework.  Iterators
  differ from enumerations in two ways:


        Iterators allow the caller to remove elements from the
            underlying collection during the iteration with well-defined
            semantics.
        Method names have been improved.


  This interface is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Iterator]))

(defn has-next?
  "Returns true if the iteration has more elements.
   (In other words, returns true if next() would
   return an element rather than throwing an exception.)

  returns: true if the iteration has more elements - `boolean`"
  ([^. this]
    (-> this (.hasNext))))

(defn next
  "Returns the next element in the iteration.

  returns: the next element in the iteration - `Iterator.E`

  throws: java.util.NoSuchElementException - if the iteration has no more elements"
  ([^. this]
    (-> this (.next))))

(defn remove
  "Removes from the underlying collection the last element returned
   by this iterator (optional operation).  This method can be called
   only once per call to next().  The behavior of an iterator
   is unspecified if the underlying collection is modified while the
   iteration is in progress in any way other than by calling this
   method.

  returns: `default void`

  throws: java.lang.UnsupportedOperationException - if the remove operation is not supported by this iterator"
  ([^. this]
    (-> this (.remove))))

(defn for-each-remaining
  "Performs the given action for each remaining element until all elements
   have been processed or the action throws an exception.  Actions are
   performed in the order of iteration, if that order is specified.
   Exceptions thrown by the action are relayed to the caller.

  action - The action to be performed for each element - `Iterator.E>`

  returns: `default void`

  throws: java.lang.NullPointerException - if the specified action is null"
  ([^. this ^Iterator.E> action]
    (-> this (.forEachRemaining action))))

