(ns jdk.awt.datatransfer.FlavorListener
  "Defines an object which listens for FlavorEvents."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.datatransfer FlavorListener]))

(defn flavors-changed
  "Invoked when the target Clipboard of the listener
   has changed its available DataFlavors.

   Some notifications may be redundant  they are not
   caused by a change of the set of DataFlavors available
   on the clipboard.
   For example, if the clipboard subsystem supposes that
   the system clipboard's contents has been changed but it
   can't ascertain whether its DataFlavors have been changed
   because of some exceptional condition when accessing the
   clipboard, the notification is sent to ensure from omitting
   a significant notification. Ordinarily, those redundant
   notifications should be occasional.

  e - a FlavorEvent object - `java.awt.datatransfer.FlavorEvent`"
  ([this e]
    (-> this (.flavorsChanged e))))

