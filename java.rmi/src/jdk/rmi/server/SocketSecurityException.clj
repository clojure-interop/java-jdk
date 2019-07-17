(ns jdk.rmi.server.SocketSecurityException
  "Deprecated.
 This class is obsolete. Use ExportException instead."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server SocketSecurityException]))

(defn ->socket-security-exception
  "Constructor.

  Deprecated.

  s - the detail message. - `java.lang.String`
  ex - the nested exception - `java.lang.Exception`"
  ([^java.lang.String s ^java.lang.Exception ex]
    (new SocketSecurityException s ex))
  ([^java.lang.String s]
    (new SocketSecurityException s)))

