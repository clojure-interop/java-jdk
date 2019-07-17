(ns jdk.rmi.server.ExportException
  "An ExportException is a RemoteException
  thrown if an attempt to export a remote object fails.  A remote object is
  exported via the constructors and exportObject methods of
  java.rmi.server.UnicastRemoteObject and
  java.rmi.activation.Activatable."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server ExportException]))

(defn ->export-exception
  "Constructor.

  Constructs an ExportException with the specified
   detail message and nested exception.

  s - the detail message - `java.lang.String`
  ex - the nested exception - `java.lang.Exception`"
  ([s ex]
    (new ExportException s ex))
  ([s]
    (new ExportException s)))

