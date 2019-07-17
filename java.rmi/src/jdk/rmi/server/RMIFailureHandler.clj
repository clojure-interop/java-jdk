(ns jdk.rmi.server.RMIFailureHandler
  "An RMIFailureHandler can be registered via the
  RMISocketFactory.setFailureHandler call. The
  failure method of the handler is invoked when the RMI
  runtime is unable to create a ServerSocket to listen
  for incoming calls. The failure method returns a boolean
  indicating whether the runtime should attempt to re-create the
  ServerSocket."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server RMIFailureHandler]))

(defn failure
  "The failure callback is invoked when the RMI
   runtime is unable to create a ServerSocket via the
   RMISocketFactory. An RMIFailureHandler
   is registered via a call to
   RMISocketFacotry.setFailureHandler.  If no failure
   handler is installed, the default behavior is to attempt to
   re-create the ServerSocket.

  ex - the exception that occurred during ServerSocket creation - `java.lang.Exception`

  returns: if true, the RMI runtime attempts to retry
   ServerSocket creation - `boolean`"
  (^Boolean [^java.rmi.server.RMIFailureHandler this ^java.lang.Exception ex]
    (-> this (.failure ex))))

