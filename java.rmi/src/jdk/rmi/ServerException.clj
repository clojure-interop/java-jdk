(ns jdk.rmi.ServerException
  "A ServerException is thrown as a result of a remote method
  invocation when a RemoteException is thrown while processing
  the invocation on the server, either while unmarshalling the arguments or
  executing the remote method itself.

  A ServerException instance contains the original
  RemoteException that occurred as its cause."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi ServerException]))

(defn ->server-exception
  "Constructor.

  Constructs a ServerException with the specified
   detail message and nested exception.

  s - the detail message - `java.lang.String`
  ex - the nested exception - `java.lang.Exception`"
  (^ServerException [^java.lang.String s ^java.lang.Exception ex]
    (new ServerException s ex))
  (^ServerException [^java.lang.String s]
    (new ServerException s)))

