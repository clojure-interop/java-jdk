(ns jdk.util.prefs.BackingStoreException
  "Thrown to indicate that a preferences operation could not complete because
  of a failure in the backing store, or a failure to contact the backing
  store."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.prefs BackingStoreException]))

(defn ->backing-store-exception
  "Constructor.

  Constructs a BackingStoreException with the specified detail message.

  s - the detail message. - `java.lang.String`"
  (^BackingStoreException [^java.lang.String s]
    (new BackingStoreException s)))

