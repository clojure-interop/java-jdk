(ns jdk.lang.ref.Reference
  "Abstract base class for reference objects.  This class defines the
  operations common to all reference objects.  Because reference objects are
  implemented in close cooperation with the garbage collector, this class may
  not be subclassed directly."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.ref Reference]))

(defn get
  "Returns this reference object's referent.  If this reference object has
   been cleared, either by the program or by the garbage collector, then
   this method returns null.

  returns: The object to which this reference refers, or
             null if this reference object has been cleared - `Reference.T`"
  (^Reference.T [^java.lang.ref.Reference this]
    (-> this (.get))))

(defn clear
  "Clears this reference object.  Invoking this method will not cause this
   object to be enqueued.

    This method is invoked only by Java code; when the garbage collector
   clears references it does so directly, without invoking this method."
  ([^java.lang.ref.Reference this]
    (-> this (.clear))))

(defn enqueued?
  "Tells whether or not this reference object has been enqueued, either by
   the program or by the garbage collector.  If this reference object was
   not registered with a queue when it was created, then this method will
   always return false.

  returns: true if and only if this reference object has
             been enqueued - `boolean`"
  (^Boolean [^java.lang.ref.Reference this]
    (-> this (.isEnqueued))))

(defn enqueue
  "Adds this reference object to the queue with which it is registered,
   if any.

    This method is invoked only by Java code; when the garbage collector
   enqueues references it does so directly, without invoking this method.

  returns: true if this reference object was successfully
             enqueued; false if it was already enqueued or if
             it was not registered with a queue when it was created - `boolean`"
  (^Boolean [^java.lang.ref.Reference this]
    (-> this (.enqueue))))

