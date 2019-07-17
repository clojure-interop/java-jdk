(ns jdk.util.Spliterator$OfPrimitive>
  "A Spliterator specialized for primitive values."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Spliterator$OfPrimitive>]))

(defn try-split
  "Description copied from interface: Spliterator

  returns: a Spliterator covering some portion of the
   elements, or null if this spliterator cannot be split - `Spliterator.OfPrimitive.T_SPLITR`"
  ([^java.util.Spliterator$OfPrimitive> this]
    (-> this (.trySplit))))

(defn try-advance
  "If a remaining element exists, performs the given action on it,
   returning true; else returns false.  If this
   Spliterator is Spliterator.ORDERED the action is performed on the
   next element in encounter order.  Exceptions thrown by the
   action are relayed to the caller.

  action - The action - `Spliterator.OfPrimitive.T_CONS`

  returns: false if no remaining elements existed
   upon entry to this method, else true. - `boolean`

  throws: java.lang.NullPointerException - if the specified action is null"
  ([^java.util.Spliterator$OfPrimitive> this ^Spliterator.OfPrimitive.T_CONS action]
    (-> this (.tryAdvance action))))

(defn for-each-remaining
  "Performs the given action for each remaining element, sequentially in
   the current thread, until all elements have been processed or the
   action throws an exception.  If this Spliterator is Spliterator.ORDERED,
   actions are performed in encounter order.  Exceptions thrown by the
   action are relayed to the caller.

  action - The action - `Spliterator.OfPrimitive.T_CONS`

  returns: `default void`

  throws: java.lang.NullPointerException - if the specified action is null"
  ([^java.util.Spliterator$OfPrimitive> this ^Spliterator.OfPrimitive.T_CONS action]
    (-> this (.forEachRemaining action))))

