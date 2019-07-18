(ns jdk.nio.file.WatchEvent$Kind
  "An event kind, for the purposes of identification."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file WatchEvent$Kind]))

(defn name
  "Returns the name of the event kind.

  returns: the name of the event kind - `java.lang.String`"
  (^java.lang.String [^WatchEvent$Kind this]
    (-> this (.name))))

(defn type
  "Returns the type of the context value.

  returns: the type of the context value - `java.lang.Class<T>`"
  (^java.lang.Class [^WatchEvent$Kind this]
    (-> this (.type))))

