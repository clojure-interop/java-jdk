(ns javax.management.remote.rmi.RMIServerImpl
  "An RMI object representing a connector server.  Remote clients
  can make connections using the newClient(Object) method.  This
  method returns an RMI object representing the connection.

  User code does not usually reference this class directly.
  RMI connection servers are usually created with the class RMIConnectorServer.  Remote clients usually create connections
  either with JMXConnectorFactory
  or by instantiating RMIConnector.

  This is an abstract class.  Concrete subclasses define the
  details of the client connection objects, such as whether they use
  JRMP or IIOP."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote.rmi RMIServerImpl]))

(defn ->rmi-server-impl
  "Constructor.

  Constructs a new RMIServerImpl.

  env - the environment containing attributes for the new RMIServerImpl. Can be null, which is equivalent to an empty Map. - `java.util.Map`"
  (^RMIServerImpl [^java.util.Map env]
    (new RMIServerImpl env)))

(defn to-stub
  "Returns a remotable stub for this server object.

  returns: a remotable stub. - `java.rmi.Remote`

  throws: java.io.IOException - if the stub cannot be obtained - e.g the RMIServerImpl has not been exported yet."
  (^java.rmi.Remote [^RMIServerImpl this]
    (-> this (.toStub))))

(defn set-default-class-loader
  "Sets the default ClassLoader for this connector
   server. New client connections will use this classloader.
   Existing client connections are unaffected.

  cl - the new ClassLoader to be used by this connector server. - `java.lang.ClassLoader`"
  ([^RMIServerImpl this ^java.lang.ClassLoader cl]
    (-> this (.setDefaultClassLoader cl))))

(defn get-default-class-loader
  "Gets the default ClassLoader used by this connector
   server.

  returns: the default ClassLoader used by this
   connector server. - `java.lang.ClassLoader`"
  (^java.lang.ClassLoader [^RMIServerImpl this]
    (-> this (.getDefaultClassLoader))))

(defn set-m-bean-server
  "Sets the MBeanServer to which this connector
   server is attached. New client connections will interact
   with this MBeanServer. Existing client connections are
   unaffected.

  mbs - the new MBeanServer. Can be null, but new client connections will be refused as long as it is. - `javax.management.MBeanServer`"
  ([^RMIServerImpl this ^javax.management.MBeanServer mbs]
    (-> this (.setMBeanServer mbs))))

(defn get-m-bean-server
  "The MBeanServer to which this connector server
   is attached.  This is the last value passed to setMBeanServer(javax.management.MBeanServer) on this object, or null if that method has
   never been called.

  returns: the MBeanServer to which this connector
   is attached. - `javax.management.MBeanServer`"
  (^javax.management.MBeanServer [^RMIServerImpl this]
    (-> this (.getMBeanServer))))

(defn get-version
  "Description copied from interface: RMIServer

  returns: a string with the format described here. - `java.lang.String`"
  (^java.lang.String [^RMIServerImpl this]
    (-> this (.getVersion))))

(defn new-client
  "Creates a new client connection.  This method calls makeClient and adds the returned client connection
   object to an internal list.  When this
   RMIServerImpl is shut down via its close() method, the close()
   method of each object remaining in the list is called.

   The fact that a client connection object is in this internal
   list does not prevent it from being garbage collected.

  credentials - this object specifies the user-defined credentials to be passed in to the server in order to authenticate the caller before creating the RMIConnection. Can be null. - `java.lang.Object`

  returns: the newly-created RMIConnection.  This is
   usually the object created by makeClient, though
   an implementation may choose to wrap that object in another
   object implementing RMIConnection. - `javax.management.remote.rmi.RMIConnection`

  throws: java.io.IOException - if the new client object cannot be created or exported."
  (^javax.management.remote.rmi.RMIConnection [^RMIServerImpl this ^java.lang.Object credentials]
    (-> this (.newClient credentials))))

(defn close
  "Closes this connection server.  This method first calls the
   closeServer() method so that no new client connections
   will be accepted.  Then, for each remaining RMIConnection object returned by makeClient, its close method is
   called.

   The behavior when this method is called more than once is
   unspecified.

   If closeServer() throws an
   IOException, the individual connections are
   nevertheless closed, and then the IOException is
   thrown from this method.

   If closeServer() returns normally but one or more
   of the individual connections throws an
   IOException, then, after closing all the
   connections, one of those IOExceptions is thrown
   from this method.  If more than one connection throws an
   IOException, it is unspecified which one is thrown
   from this method.

  throws: java.io.IOException - if closeServer() or one of the RMIConnection.close() calls threw IOException."
  ([^RMIServerImpl this]
    (-> this (.close))))

