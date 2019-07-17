(ns jdk.nio.channels.spi.AsynchronousChannelProvider
  "Service-provider class for asynchronous channels.

   An asynchronous channel provider is a concrete subclass of this class that
  has a zero-argument constructor and implements the abstract methods specified
  below.  A given invocation of the Java virtual machine maintains a single
  system-wide default provider instance, which is returned by the provider method.  The first invocation of that method will locate
  the default provider as specified below.

   All of the methods in this class are safe for use by multiple concurrent
  threads."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels.spi AsynchronousChannelProvider]))

(defn *provider
  "Returns the system-wide default asynchronous channel provider for this
   invocation of the Java virtual machine.

    The first invocation of this method locates the default provider
   object as follows:



      If the system property
     java.nio.channels.spi.AsynchronousChannelProvider is defined
     then it is taken to be the fully-qualified name of a concrete provider class.
     The class is loaded and instantiated; if this process fails then an
     unspecified error is thrown.

      If a provider class has been installed in a jar file that is
     visible to the system class loader, and that jar file contains a
     provider-configuration file named
     java.nio.channels.spi.AsynchronousChannelProvider in the resource
     directory META-INF/services, then the first class name
     specified in that file is taken.  The class is loaded and
     instantiated; if this process fails then an unspecified error is
     thrown.

      Finally, if no provider has been specified by any of the above
     means then the system-default provider class is instantiated and the
     result is returned.



    Subsequent invocations of this method return the provider that was
   returned by the first invocation.

  returns: The system-wide default AsynchronousChannel provider - `java.nio.channels.spi.AsynchronousChannelProvider`"
  ([]
    (AsynchronousChannelProvider/provider )))

(defn open-asynchronous-channel-group
  "Constructs a new asynchronous channel group with a fixed thread pool.

  n-threads - The number of threads in the pool - `int`
  thread-factory - The factory to use when creating new threads - `java.util.concurrent.ThreadFactory`

  returns: A new asynchronous channel group - `java.nio.channels.AsynchronousChannelGroup`

  throws: java.lang.IllegalArgumentException - If nThreads <= 0"
  ([^java.nio.channels.spi.AsynchronousChannelProvider this ^Integer n-threads ^java.util.concurrent.ThreadFactory thread-factory]
    (-> this (.openAsynchronousChannelGroup n-threads thread-factory))))

(defn open-asynchronous-server-socket-channel
  "Opens an asynchronous server-socket channel.

  group - The group to which the channel is bound, or null to bind to the default group - `java.nio.channels.AsynchronousChannelGroup`

  returns: The new channel - `java.nio.channels.AsynchronousServerSocketChannel`

  throws: java.nio.channels.IllegalChannelGroupException - If the provider that created the group differs from this provider"
  ([^java.nio.channels.spi.AsynchronousChannelProvider this ^java.nio.channels.AsynchronousChannelGroup group]
    (-> this (.openAsynchronousServerSocketChannel group))))

(defn open-asynchronous-socket-channel
  "Opens an asynchronous socket channel.

  group - The group to which the channel is bound, or null to bind to the default group - `java.nio.channels.AsynchronousChannelGroup`

  returns: The new channel - `java.nio.channels.AsynchronousSocketChannel`

  throws: java.nio.channels.IllegalChannelGroupException - If the provider that created the group differs from this provider"
  ([^java.nio.channels.spi.AsynchronousChannelProvider this ^java.nio.channels.AsynchronousChannelGroup group]
    (-> this (.openAsynchronousSocketChannel group))))

