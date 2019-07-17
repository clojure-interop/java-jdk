(ns jdk.lang.Iterable
  "Implementing this interface allows an object to be the target of
  the `for-each loop` statement. See

  For-each Loop"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Iterable]))

(defn iterator
  "Returns an iterator over elements of type T.

  returns: an Iterator. - `java.util.Iterator<Iterable.T>`"
  (^java.util.Iterator [^java.lang.Iterable this]
    (-> this (.iterator))))

(defn for-each
  "Performs the given action for each element of the Iterable
   until all elements have been processed or the action throws an
   exception.  Unless otherwise specified by the implementing class,
   actions are performed in the order of iteration (if an iteration order
   is specified).  Exceptions thrown by the action are relayed to the
   caller.

  action - The action to be performed for each element - `Iterable.T>`

  returns: `default void`

  throws: java.lang.NullPointerException - if the specified action is null"
  ([^java.lang.Iterable this ^Iterable.T> action]
    (-> this (.forEach action))))

(defn spliterator
  "Creates a Spliterator over the elements described by this
   Iterable.

  returns: a Spliterator over the elements described by this
   Iterable. - `default java.util.Spliterator<Iterable.T>`"
  ([^java.lang.Iterable this]
    (-> this (.spliterator))))

