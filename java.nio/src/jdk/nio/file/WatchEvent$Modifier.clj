(ns jdk.nio.file.WatchEvent$Modifier
  "An event modifier that qualifies how a Watchable is registered
  with a WatchService.

   This release does not define any standard modifiers."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file WatchEvent$Modifier]))

(defn name
  "Returns the name of the modifier.

  returns: the name of the modifier - `java.lang.String`"
  ([this]
    (-> this (.name))))

