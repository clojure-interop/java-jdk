(ns jdk.lang.ref.SoftReference
  "Soft reference objects, which are cleared at the discretion of the garbage
  collector in response to memory demand.  Soft references are most often used
  to implement memory-sensitive caches.

   Suppose that the garbage collector determines at a certain point in time
  that an object is softly
  reachable.  At that time it may choose to clear atomically all soft
  references to that object and all soft references to any other
  softly-reachable objects from which that object is reachable through a chain
  of strong references.  At the same time or at some later time it will
  enqueue those newly-cleared soft references that are registered with
  reference queues.

   All soft references to softly-reachable objects are guaranteed to have
  been cleared before the virtual machine throws an
  OutOfMemoryError.  Otherwise no constraints are placed upon the
  time at which a soft reference will be cleared or the order in which a set
  of such references to different objects will be cleared.  Virtual machine
  implementations are, however, encouraged to bias against clearing
  recently-created or recently-used soft references.

   Direct instances of this class may be used to implement simple caches;
  this class or derived subclasses may also be used in larger data structures
  to implement more sophisticated caches.  As long as the referent of a soft
  reference is strongly reachable, that is, is actually in use, the soft
  reference will not be cleared.  Thus a sophisticated cache can, for example,
  prevent its most recently used entries from being discarded by keeping
  strong referents to those entries, leaving the remaining entries to be
  discarded at the discretion of the garbage collector."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.ref SoftReference]))

(defn ->soft-reference
  "Constructor.

  Creates a new soft reference that refers to the given object and is
   registered with the given queue.

  referent - object the new soft reference will refer to - `SoftReference.T`
  q - the queue with which the reference is to be registered, or null if registration is not required - `SoftReference.T>`"
  ([^SoftReference.T referent ^SoftReference.T> q]
    (new SoftReference referent q))
  ([^SoftReference.T referent]
    (new SoftReference referent)))

(defn get
  "Returns this reference object's referent.  If this reference object has
   been cleared, either by the program or by the garbage collector, then
   this method returns null.

  returns: The object to which this reference refers, or
             null if this reference object has been cleared - `SoftReference.T`"
  ([^java.lang.ref.SoftReference this]
    (-> this (.get))))

