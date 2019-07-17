(ns jdk.lang.ClassValue
  "Lazily associate a computed value with (potentially) every type.
  For example, if a dynamic language needs to construct a message dispatch
  table for each class encountered at a message send call site,
  it can use a ClassValue to cache information needed to
  perform the message send quickly, for each class encountered."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang ClassValue]))

(defn get
  "Returns the value for the given class.
   If no value has yet been computed, it is obtained by
   an invocation of the computeValue method.

   The actual installation of the value on the class
   is performed atomically.
   At that point, if several racing threads have
   computed values, one is chosen, and returned to
   all the racing threads.

   The type parameter is typically a class, but it may be any type,
   such as an interface, a primitive type (like int.class), or void.class.

   In the absence of remove calls, a class value has a simple
   state diagram:  uninitialized and initialized.
   When remove calls are made,
   the rules for value observation are more complex.
   See the documentation for remove for more information.

  type - the type whose class value must be computed or retrieved - `java.lang.Class<?>`

  returns: the current value associated with this ClassValue, for the given class or interface - `ClassValue.T`

  throws: java.lang.NullPointerException - if the argument is null"
  (^ClassValue.T [^java.lang.ClassValue this ^java.lang.Class type]
    (-> this (.get type))))

(defn remove
  "Removes the associated value for the given class.
   If this value is subsequently read for the same class,
   its value will be reinitialized by invoking its computeValue method.
   This may result in an additional invocation of the
   computeValue method for the given class.

   In order to explain the interaction between get and remove calls,
   we must model the state transitions of a class value to take into account
   the alternation between uninitialized and initialized states.
   To do this, number these states sequentially from zero, and note that
   uninitialized (or removed) states are numbered with even numbers,
   while initialized (or re-initialized) states have odd numbers.

   When a thread T removes a class value in state 2N,
   nothing happens, since the class value is already uninitialized.
   Otherwise, the state is advanced atomically to 2N+1.

   When a thread T queries a class value in state 2N,
   the thread first attempts to initialize the class value to state 2N+1
   by invoking computeValue and installing the resulting value.

   When T attempts to install the newly computed value,
   if the state is still at 2N, the class value will be initialized
   with the computed value, advancing it to state 2N+1.

   Otherwise, whether the new state is even or odd,
   T will discard the newly computed value
   and retry the get operation.

   Discarding and retrying is an important proviso,
   since otherwise T could potentially install
   a disastrously stale value.  For example:

   T calls CV.get(C) and sees state 2N
   T quickly computes a time-dependent value V0 and gets ready to install it
   T is hit by an unlucky paging or scheduling event, and goes to sleep for a long time
   ...meanwhile, T2 also calls CV.get(C) and sees state 2N
   T2 quickly computes a similar time-dependent value V1 and installs it on CV.get(C)
   T2 (or a third thread) then calls CV.remove(C), undoing T2's work
    the previous actions of T2 are repeated several times
    also, the relevant computed values change over time: V1, V2, ...
   ...meanwhile, T wakes up and attempts to install V0; this must fail

   We can assume in the above scenario that CV.computeValue uses locks to properly
   observe the time-dependent states as it computes V1, etc.
   This does not remove the threat of a stale value, since there is a window of time
   between the return of computeValue in T and the installation
   of the the new value.  No user synchronization is possible during this time.

  type - the type whose class value must be removed - `java.lang.Class<?>`

  throws: java.lang.NullPointerException - if the argument is null"
  ([^java.lang.ClassValue this ^java.lang.Class type]
    (-> this (.remove type))))

