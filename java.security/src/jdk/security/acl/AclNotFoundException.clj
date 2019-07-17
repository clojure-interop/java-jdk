(ns jdk.security.acl.AclNotFoundException
  "This is an exception that is thrown whenever a reference is made to a
  non-existent ACL (Access Control List)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.acl AclNotFoundException]))

(defn ->acl-not-found-exception
  "Constructor.

  Constructs an AclNotFoundException."
  ([]
    (new AclNotFoundException )))

