(ns jdk.nio.file.WatchEvent
  "An event or a repeated event for an object that is registered with a WatchService.

   An event is classified by its kind and has a count to indicate the number of times that the event has been
  observed. This allows for efficient representation of repeated events. The
  context method returns any context associated with
  the event. In the case of a repeated event then the context is the same for
  all events.

   Watch events are immutable and safe for use by multiple concurrent
  threads."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file WatchEvent]))

(defn kind
  "Returns the event kind.

  returns: the event kind - `java.nio.file.WatchEvent$Kind<T>`"
  (^java.nio.file.WatchEvent$Kind [^WatchEvent this]
    (-> this (.kind))))

(defn count
  "Returns the event count. If the event count is greater than 1
   then this is a repeated event.

  returns: the event count - `int`"
  (^Integer [^WatchEvent this]
    (-> this (.count))))

(defn context
  "Returns the context for the event.

    In the case of ENTRY_CREATE,
   ENTRY_DELETE, and ENTRY_MODIFY events the context is
   a Path that is the relative path between
   the directory registered with the watch service, and the entry that is
   created, deleted, or modified.

  returns: the event context; may be null - `T`"
  ([^WatchEvent this]
    (-> this (.context))))

