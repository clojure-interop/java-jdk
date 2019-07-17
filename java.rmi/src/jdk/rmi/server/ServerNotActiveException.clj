(ns jdk.rmi.server.ServerNotActiveException
  "An ServerNotActiveException is an Exception
  thrown during a call to RemoteServer.getClientHost if
  the getClientHost method is called outside of servicing a remote
  method call."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server ServerNotActiveException]))

(defn ->server-not-active-exception
  "Constructor.

  Constructs an ServerNotActiveException with the specified
   detail message.

  s - the detail message. - `java.lang.String`"
  ([^java.lang.String s]
    (new ServerNotActiveException s))
  ([]
    (new ServerNotActiveException )))

