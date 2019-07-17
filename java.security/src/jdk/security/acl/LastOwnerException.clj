(ns jdk.security.acl.LastOwnerException
  "This is an exception that is thrown whenever an attempt is made to delete
  the last owner of an Access Control List."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.acl LastOwnerException]))

(defn ->last-owner-exception
  "Constructor.

  Constructs a LastOwnerException."
  ([]
    (new LastOwnerException )))

