(ns jdk.rmi.dgc.VMID
  "A VMID is a identifier that is unique across all Java virtual
  machines.  VMIDs are used by the distributed garbage collector
  to identify client VMs."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.dgc VMID]))

(defn ->vmid
  "Constructor.

  Create a new VMID.  Each new VMID returned from this constructor
   is unique for all Java virtual machines under the following
   conditions: a) the conditions for uniqueness for objects of
   the class java.rmi.server.UID are satisfied, and b) an
   address can be obtained for this host that is unique and constant
   for the lifetime of this object."
  ([]
    (new VMID )))

(defn *is-unique
  "Deprecated.

  returns: true if host address can be determined, false otherwise - `java.lang.   boolean`"
  ([]
    (VMID/isUnique )))

(defn hash-code
  "Compute hash code for this VMID.

  returns: a hash code value for this object. - `int`"
  (^Integer [^java.rmi.dgc.VMID this]
    (-> this (.hashCode))))

(defn equals
  "Compare this VMID to another, and return true if they are the
   same identifier.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  (^Boolean [^java.rmi.dgc.VMID this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn to-string
  "Return string representation of this VMID.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^java.rmi.dgc.VMID this]
    (-> this (.toString))))

