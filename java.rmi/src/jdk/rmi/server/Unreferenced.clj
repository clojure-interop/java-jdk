(ns jdk.rmi.server.Unreferenced
  "A remote object implementation should implement the
  Unreferenced interface to receive notification when there are
  no more clients that reference that remote object."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server Unreferenced]))

(defn unreferenced
  "Called by the RMI runtime sometime after the runtime determines that
   the reference list, the list of clients referencing the remote object,
   becomes empty."
  ([^Unreferenced this]
    (-> this (.unreferenced))))

