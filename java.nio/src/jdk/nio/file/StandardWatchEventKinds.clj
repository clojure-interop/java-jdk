(ns jdk.nio.file.StandardWatchEventKinds
  "Defines the standard event kinds."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file StandardWatchEventKinds]))

(def *-overflow
  "Static Constant.

  A special event to indicate that events may have been lost or
   discarded.

    The context for this event is
   implementation specific and may be null. The event count may be greater than 1.

  type: java.nio.file.WatchEvent.Kind<java.lang.Object>"
  StandardWatchEventKinds/OVERFLOW)

(def *-entry-create
  "Static Constant.

  Directory entry created.

    When a directory is registered for this event then the WatchKey
   is queued when it is observed that an entry is created in the directory
   or renamed into the directory. The event count
   for this event is always 1.

  type: java.nio.file.WatchEvent.Kind<java.nio.file.Path>"
  StandardWatchEventKinds/ENTRY_CREATE)

(def *-entry-delete
  "Static Constant.

  Directory entry deleted.

    When a directory is registered for this event then the WatchKey
   is queued when it is observed that an entry is deleted or renamed out of
   the directory. The event count for this event
   is always 1.

  type: java.nio.file.WatchEvent.Kind<java.nio.file.Path>"
  StandardWatchEventKinds/ENTRY_DELETE)

(def *-entry-modify
  "Static Constant.

  Directory entry modified.

    When a directory is registered for this event then the WatchKey
   is queued when it is observed that an entry in the directory has been
   modified. The event count for this event is
   1 or greater.

  type: java.nio.file.WatchEvent.Kind<java.nio.file.Path>"
  StandardWatchEventKinds/ENTRY_MODIFY)

