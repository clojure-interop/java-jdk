(ns jdk.lang.Iterable
  "Implementing this interface allows an object to be the target of
  the `for-each loop` statement. See

  For-each Loop"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Iterable]))

(defn iterator
  "Returns an iterator over elements of type T.

  returns: an Iterator. - `java.util.Iterator<T>`"
  (^java.util.Iterator [^Iterable this]
    (-> this (.iterator))))

(defn for-each
  "Performs the given action for each element of the Iterable
   until all elements have been processed or the action throws an
   exception.  Unless otherwise specified by the implementing class,
   actions are performed in the order of iteration (if an iteration order
   is specified).  Exceptions thrown by the action are relayed to the
   caller.

  action - The action to be performed for each element - `java.util.function.Consumer`

  returns: `default void`

  throws: java.lang.NullPointerException - if the specified action is null"
  ([^Iterable this ^java.util.function.Consumer action]
    (-> this (.forEach action))))

(defn spliterator
  "Creates a Spliterator over the elements described by this
   Iterable.

  returns: a Spliterator over the elements described by this
   Iterable. - `default java.util.Spliterator<T>`"
  ([^Iterable this]
    (-> this (.spliterator))))

