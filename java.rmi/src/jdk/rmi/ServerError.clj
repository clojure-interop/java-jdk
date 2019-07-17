(ns jdk.rmi.ServerError
  "A ServerError is thrown as a result of a remote method
  invocation when an Error is thrown while processing
  the invocation on the server, either while unmarshalling the arguments,
  executing the remote method itself, or marshalling the return value.

  A ServerError instance contains the original
  Error that occurred as its cause."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi ServerError]))

(defn ->server-error
  "Constructor.

  Constructs a ServerError with the specified
   detail message and nested error.

  s - the detail message - `java.lang.String`
  err - the nested error - `java.lang.Error`"
  ([^java.lang.String s ^java.lang.Error err]
    (new ServerError s err)))

