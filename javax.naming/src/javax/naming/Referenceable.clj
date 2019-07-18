(ns javax.naming.Referenceable
  "This interface is implemented by an object that can provide a
  Reference to itself.

  A Reference represents a way of recording address information about
  objects which themselves are not directly bound to the naming system.
  Such objects can implement the Referenceable interface as a way
  for programs that use that object to determine what its Reference is.
  For example, when binding a object, if an object implements the
  Referenceable interface, getReference() can be invoked on the object to
  get its Reference to use for binding."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming Referenceable]))

(defn get-reference
  "Retrieves the Reference of this object.

  returns: The non-null Reference of this object. - `javax.naming.Reference`

  throws: javax.naming.NamingException - If a naming exception was encountered while retrieving the reference."
  (^javax.naming.Reference [^Referenceable this]
    (-> this (.getReference))))

