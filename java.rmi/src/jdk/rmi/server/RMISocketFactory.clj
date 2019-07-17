(ns jdk.rmi.server.RMISocketFactory
  "An RMISocketFactory instance is used by the RMI runtime
  in order to obtain client and server sockets for RMI calls.  An
  application may use the setSocketFactory method to
  request that the RMI runtime use its socket factory instance
  instead of the default implementation.

  The default socket factory implementation performs a
  three-tiered approach to creating client sockets. First, a direct
  socket connection to the remote VM is attempted.  If that fails
  (due to a firewall), the runtime uses HTTP with the explicit port
  number of the server.  If the firewall does not allow this type of
  communication, then HTTP to a cgi-bin script on the server is used
  to POST the RMI call. The HTTP tunneling mechanisms are disabled by
  default. This behavior is controlled by the java.rmi.server.disableHttp
  property, whose default value is true. Setting this property's
  value to false will enable the HTTP tunneling mechanisms.

  Deprecated: HTTP Tunneling. The HTTP tunneling mechanisms
  described above, specifically HTTP with an explicit port and HTTP to a
  cgi-bin script, are deprecated. These HTTP tunneling mechanisms are
  subject to removal in a future release of the platform.

  The default socket factory implementation creates server sockets that
  are bound to the wildcard address, which accepts requests from all network
  interfaces."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server RMISocketFactory]))

(defn ->rmi-socket-factory
  "Constructor.

  Constructs an RMISocketFactory."
  ([]
    (new RMISocketFactory )))

(defn *set-socket-factory
  "Set the global socket factory from which RMI gets sockets (if the
   remote object is not associated with a specific client and/or server
   socket factory). The RMI socket factory can only be set once. Note: The
   RMISocketFactory may only be set if the current security manager allows
   setting a socket factory; if disallowed, a SecurityException will be
   thrown.

  fac - the socket factory - `java.rmi.server.RMISocketFactory`

  throws: java.io.IOException - if the RMI socket factory is already set"
  ([fac]
    (RMISocketFactory/setSocketFactory fac)))

(defn *get-socket-factory
  "Returns the socket factory set by the setSocketFactory
   method. Returns null if no socket factory has been
   set.

  returns: the socket factory - `java.rmi.server.RMISocketFactory`"
  ([]
    (RMISocketFactory/getSocketFactory )))

(defn *get-default-socket-factory
  "Returns a reference to the default socket factory used
   by this RMI implementation.  This will be the factory used
   by the RMI runtime when getSocketFactory
   returns null.

  returns: the default RMI socket factory - `java.rmi.server.RMISocketFactory`"
  ([]
    (RMISocketFactory/getDefaultSocketFactory )))

(defn *set-failure-handler
  "Sets the failure handler to be called by the RMI runtime if server
   socket creation fails.  By default, if no failure handler is installed
   and server socket creation fails, the RMI runtime does attempt to
   recreate the server socket.

   If there is a security manager, this method first calls
   the security manager's checkSetFactory method
   to ensure the operation is allowed.
   This could result in a SecurityException.

  fh - the failure handler - `java.rmi.server.RMIFailureHandler`

  throws: java.lang.SecurityException - if a security manager exists and its checkSetFactory method doesn't allow the operation."
  ([fh]
    (RMISocketFactory/setFailureHandler fh)))

(defn *get-failure-handler
  "Returns the handler for socket creation failure set by the
   setFailureHandler method.

  returns: the failure handler - `java.rmi.server.RMIFailureHandler`"
  ([]
    (RMISocketFactory/getFailureHandler )))

(defn create-socket
  "Creates a client socket connected to the specified host and port.

  host - the host name - `java.lang.String`
  port - the port number - `int`

  returns: a socket connected to the specified host and port. - `java.net.Socket`

  throws: java.io.IOException - if an I/O error occurs during socket creation"
  ([this host port]
    (-> this (.createSocket host port))))

(defn create-server-socket
  "Create a server socket on the specified port (port 0 indicates
   an anonymous port).

  port - the port number - `int`

  returns: the server socket on the specified port - `java.net.ServerSocket`

  throws: java.io.IOException - if an I/O error occurs during server socket creation"
  ([this port]
    (-> this (.createServerSocket port))))

