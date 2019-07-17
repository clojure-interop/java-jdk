(ns javax.naming.directory.InvalidSearchControlsException
  "This exception is thrown when the specification of
  the SearchControls for a search operation is invalid. For example, if the scope is
  set to a value other than OBJECT_SCOPE, ONELEVEL_SCOPE, SUBTREE_SCOPE,
  this exception is thrown.

  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.directory InvalidSearchControlsException]))

(defn ->invalid-search-controls-exception
  "Constructor.

  Constructs a new instance of InvalidSearchControlsException
   with an explanation. All other fields set to null.

  msg - Detail about this exception. Can be null. - `java.lang.String`"
  ([^java.lang.String msg]
    (new InvalidSearchControlsException msg))
  ([]
    (new InvalidSearchControlsException )))

