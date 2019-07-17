(ns jdk.rmi.server.SkeletonNotFoundException
  "Deprecated.
 no replacement.  Skeletons are no longer required for remote
  method calls in the Java 2 platform v1.2 and greater."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server SkeletonNotFoundException]))

(defn ->skeleton-not-found-exception
  "Constructor.

  Deprecated.

  s - the detail message. - `java.lang.String`
  ex - the nested exception - `java.lang.Exception`"
  ([^java.lang.String s ^java.lang.Exception ex]
    (new SkeletonNotFoundException s ex))
  ([^java.lang.String s]
    (new SkeletonNotFoundException s)))

