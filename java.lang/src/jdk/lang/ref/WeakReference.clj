(ns jdk.lang.ref.WeakReference
  "Weak reference objects, which do not prevent their referents from being
  made finalizable, finalized, and then reclaimed.  Weak references are most
  often used to implement canonicalizing mappings.

   Suppose that the garbage collector determines at a certain point in time
  that an object is weakly
  reachable.  At that time it will atomically clear all weak references to
  that object and all weak references to any other weakly-reachable objects
  from which that object is reachable through a chain of strong and soft
  references.  At the same time it will declare all of the formerly
  weakly-reachable objects to be finalizable.  At the same time or at some
  later time it will enqueue those newly-cleared weak references that are
  registered with reference queues."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.ref WeakReference]))

(defn ->weak-reference
  "Constructor.

  Creates a new weak reference that refers to the given object and is
   registered with the given queue.

  referent - object the new weak reference will refer to - `WeakReference.T`
  q - the queue with which the reference is to be registered, or null if registration is not required - `WeakReference.T>`"
  ([^WeakReference.T referent ^WeakReference.T> q]
    (new WeakReference referent q))
  ([^WeakReference.T referent]
    (new WeakReference referent)))

