(ns jdk.awt.datatransfer.FlavorEvent
  "FlavorEvent is used to notify interested parties
  that available DataFlavors have changed in the
  Clipboard (the event source)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.datatransfer FlavorEvent]))

(defn ->flavor-event
  "Constructor.

  Constructs a FlavorEvent object.

  source - the Clipboard that is the source of the event - `java.awt.datatransfer.Clipboard`

  throws: java.lang.IllegalArgumentException - if the source is null"
  ([source]
    (new FlavorEvent source)))

