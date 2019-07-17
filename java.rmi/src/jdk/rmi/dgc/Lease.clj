(ns jdk.rmi.dgc.Lease
  "A lease contains a unique VM identifier and a lease duration. A
  Lease object is used to request and grant leases to remote object
  references."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.dgc Lease]))

(defn ->lease
  "Constructor.

  Constructs a lease with a specific VMID and lease duration. The
   vmid may be null.

  id - VMID associated with this lease - `java.rmi.dgc.VMID`
  duration - lease duration - `long`"
  ([^java.rmi.dgc.VMID id ^Long duration]
    (new Lease id duration)))

(defn get-vmid
  "Returns the client VMID associated with the lease.

  returns: client VMID - `java.rmi.dgc.VMID`"
  (^java.rmi.dgc.VMID [^java.rmi.dgc.Lease this]
    (-> this (.getVMID))))

(defn get-value
  "Returns the lease duration.

  returns: lease duration - `long`"
  (^Long [^java.rmi.dgc.Lease this]
    (-> this (.getValue))))

