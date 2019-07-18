(ns jdk.rmi.ServerRuntimeException
  "Deprecated.
 no replacement"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi ServerRuntimeException]))

(defn ->server-runtime-exception
  "Constructor.

  Deprecated. no replacement

  s - the detail message - `java.lang.String`
  ex - the nested exception - `java.lang.Exception`"
  (^ServerRuntimeException [^java.lang.String s ^java.lang.Exception ex]
    (new ServerRuntimeException s ex)))

