(ns jdk.security.acl.NotOwnerException
  "This is an exception that is thrown whenever the modification of an object
  (such as an Access Control List) is only allowed to be done by an owner of
  the object, but the Principal attempting the modification is not an owner."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.acl NotOwnerException]))

(defn ->not-owner-exception
  "Constructor.

  Constructs a NotOwnerException."
  (^NotOwnerException []
    (new NotOwnerException )))

