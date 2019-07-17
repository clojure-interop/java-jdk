(ns jdk.util.concurrent.locks.AbstractOwnableSynchronizer
  "A synchronizer that may be exclusively owned by a thread.  This
  class provides a basis for creating locks and related synchronizers
  that may entail a notion of ownership.  The
  AbstractOwnableSynchronizer class itself does not manage or
  use this information. However, subclasses and tools may use
  appropriately maintained values to help control and monitor access
  and provide diagnostics."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.locks AbstractOwnableSynchronizer]))

