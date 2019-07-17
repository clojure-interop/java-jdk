(ns jdk.lang.ref.ReferenceQueue
  "Reference queues, to which registered reference objects are appended by the
  garbage collector after the appropriate reachability changes are detected."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.ref ReferenceQueue]))

(defn ->reference-queue
  "Constructor.

  Constructs a new reference-object queue."
  ([]
    (new ReferenceQueue )))

(defn poll
  "Polls this queue to see if a reference object is available.  If one is
   available without further delay then it is removed from the queue and
   returned.  Otherwise this method immediately returns null.

  returns: A reference object, if one was immediately available,
            otherwise null - `java.lang.ref.Reference<? extends ReferenceQueue.T>`"
  ([this]
    (-> this (.poll))))

(defn remove
  "Removes the next reference object in this queue, blocking until either
   one becomes available or the given timeout period expires.

    This method does not offer real-time guarantees: It schedules the
   timeout as if by invoking the Object.wait(long) method.

  timeout - If positive, block for up to timeout milliseconds while waiting for a reference to be added to this queue. If zero, block indefinitely. - `long`

  returns: A reference object, if one was available within the specified
            timeout period, otherwise null - `java.lang.ref.Reference<? extends ReferenceQueue.T>`

  throws: java.lang.IllegalArgumentException - If the value of the timeout argument is negative"
  ([this timeout]
    (-> this (.remove timeout)))
  ([this]
    (-> this (.remove))))

