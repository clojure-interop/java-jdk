(ns jdk.io.SyncFailedException
  "Signals that a sync operation has failed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io SyncFailedException]))

(defn ->sync-failed-exception
  "Constructor.

  Constructs an SyncFailedException with a detail message.
   A detail message is a String that describes this particular exception.

  desc - a String describing the exception. - `java.lang.String`"
  (^SyncFailedException [^java.lang.String desc]
    (new SyncFailedException desc)))

