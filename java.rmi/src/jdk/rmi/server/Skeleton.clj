(ns jdk.rmi.server.Skeleton
  "Deprecated.
 no replacement.  Skeletons are no longer required for remote
  method calls in the Java 2 platform v1.2 and greater."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server Skeleton]))

(defn dispatch
  "Deprecated. no replacement

  obj - remote implementation to dispatch call to - `java.rmi.Remote`
  the-call - object representing remote call - `java.rmi.server.RemoteCall`
  opnum - operation number - `int`
  hash - stub/skeleton interface hash - `long`

  returns: `java.lang. void`

  throws: java.lang.Exception - if a general exception occurs."
  ([^java.rmi.server.Skeleton this ^java.rmi.Remote obj ^java.rmi.server.RemoteCall the-call ^Integer opnum ^Long hash]
    (-> this (.dispatch obj the-call opnum hash))))

(defn get-operations
  "Deprecated. no replacement

  returns: operations supported by skeleton - `java.lang..rmi.server.Operation[]`"
  ([^java.rmi.server.Skeleton this]
    (-> this (.getOperations))))

