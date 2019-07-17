(ns javax.naming.NoPermissionException
  "This exception is thrown when attempting to perform an operation
  for which the client has no permission. The access control/permission
  model is dictated by the directory/naming server.


  Synchronization and serialization issues that apply to NamingException
  apply directly here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming NoPermissionException]))

(defn ->no-permission-exception
  "Constructor.

  Constructs a new instance of NoPermissionException using an
   explanation. All other fields default to null.

  explanation - Possibly null additional detail about this exception. - `java.lang.String`"
  ([^java.lang.String explanation]
    (new NoPermissionException explanation))
  ([]
    (new NoPermissionException )))

