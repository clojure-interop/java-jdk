(ns jdk.rmi.server.SkeletonMismatchException
  "Deprecated.
 no replacement.  Skeletons are no longer required for remote
  method calls in the Java 2 platform v1.2 and greater."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server SkeletonMismatchException]))

(defn ->skeleton-mismatch-exception
  "Constructor.

  Deprecated. no replacement

  s - the detail message - `java.lang.String`"
  ([s]
    (new SkeletonMismatchException s)))

