(ns jdk.util.PrimitiveIterator
  "A base type for primitive specializations of Iterator.  Specialized
  subtypes are provided for int, long, and
  double values.

  The specialized subtype default implementations of Iterator.next()
  and Iterator.forEachRemaining(java.util.function.Consumer) box
  primitive values to instances of their corresponding wrapper class.  Such
  boxing may offset any advantages gained when using the primitive
  specializations.  To avoid boxing, the corresponding primitive-based methods
  should be used.  For example, PrimitiveIterator.OfInt.nextInt() and
  PrimitiveIterator.OfInt.forEachRemaining(java.util.function.IntConsumer)
  should be used in preference to PrimitiveIterator.OfInt.next() and
  PrimitiveIterator.OfInt.forEachRemaining(java.util.function.Consumer).

  Iteration of primitive values using boxing-based methods
  next() and
  forEachRemaining(),
  does not affect the order in which the values, transformed to boxed values,
  are encountered."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util PrimitiveIterator]))

(defn for-each-remaining
  "Performs the given action for each remaining element, in the order
   elements occur when iterating, until all elements have been processed
   or the action throws an exception.  Errors or runtime exceptions
   thrown by the action are relayed to the caller.

  action - The action to be performed for each element - `PrimitiveIterator.T_CONS`

  throws: java.lang.NullPointerException - if the specified action is null"
  ([this action]
    (-> this (.forEachRemaining action))))

