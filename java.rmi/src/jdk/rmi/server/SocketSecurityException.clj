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
  ([s ex]
    (new SocketSecurityException s ex))
  ([s]
    (new SocketSecurityException s)))

