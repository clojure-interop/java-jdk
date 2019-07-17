(ns jdk.nio.channels.spi.AbstractSelectionKey
  "Base implementation class for selection keys.

   This class tracks the validity of the key and implements cancellation."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels.spi AbstractSelectionKey]))

(defn valid?
  "Description copied from class: SelectionKey

  returns: true if, and only if, this key is valid - `boolean`"
  (^Boolean [^java.nio.channels.spi.AbstractSelectionKey this]
    (-> this (.isValid))))

(defn cancel
  "Cancels this key.

    If this key has not yet been cancelled then it is added to its
   selector's cancelled-key set while synchronized on that set."
  ([^java.nio.channels.spi.AbstractSelectionKey this]
    (-> this (.cancel))))

