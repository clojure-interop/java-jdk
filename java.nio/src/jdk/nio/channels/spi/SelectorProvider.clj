(ns jdk.nio.channels.spi.SelectorProvider
  "Service-provider class for selectors and selectable channels.

   A selector provider is a concrete subclass of this class that has a
  zero-argument constructor and implements the abstract methods specified
  below.  A given invocation of the Java virtual machine maintains a single
  system-wide default provider instance, which is returned by the provider method.  The first invocation of that method will locate
  the default provider as specified below.

   The system-wide default provider is used by the static open
  methods of the DatagramChannel, Pipe, Selector, ServerSocketChannel, and SocketChannel classes.  It is also
  used by the System.inheritedChannel()
  method. A program may make use of a provider other than the default provider
  by instantiating that provider and then directly invoking the open
  methods defined in this class.

   All of the methods in this class are safe for use by multiple concurrent
  threads."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels.spi SelectorProvider]))

(defn *provider
  "Returns the system-wide default selector provider for this invocation of
   the Java virtual machine.

    The first invocation of this method locates the default provider
   object as follows:



      If the system property
     java.nio.channels.spi.SelectorProvider is defined then it is
     taken to be the fully-qualified name of a concrete provider class.
     The class is loaded and instantiated; if this process fails then an
     unspecified error is thrown.

      If a provider class has been installed in a jar file that is
     visible to the system class loader, and that jar file contains a
     provider-configuration file named
     java.nio.channels.spi.SelectorProvider in the resource
     directory META-INF/services, then the first class name
     specified in that file is taken.  The class is loaded and
     instantiated; if this process fails then an unspecified error is
     thrown.

      Finally, if no provider has been specified by any of the above
     means then the system-default provider class is instantiated and the
     result is returned.



    Subsequent invocations of this method return the provider that was
   returned by the first invocation.

  returns: The system-wide default selector provider - `java.nio.channels.spi.SelectorProvider`"
  (^java.nio.channels.spi.SelectorProvider []
    (SelectorProvider/provider )))

(defn open-datagram-channel
  "Opens a datagram channel.

  family - The protocol family - `java.net.ProtocolFamily`

  returns: A new datagram channel - `java.nio.channels.DatagramChannel`

  throws: java.lang.UnsupportedOperationException - If the specified protocol family is not supported"
  (^java.nio.channels.DatagramChannel [^java.nio.channels.spi.SelectorProvider this ^java.net.ProtocolFamily family]
    (-> this (.openDatagramChannel family)))
  (^java.nio.channels.DatagramChannel [^java.nio.channels.spi.SelectorProvider this]
    (-> this (.openDatagramChannel))))

(defn open-pipe
  "Opens a pipe.

  returns: The new pipe - `java.nio.channels.Pipe`

  throws: java.io.IOException - If an I/O error occurs"
  (^java.nio.channels.Pipe [^java.nio.channels.spi.SelectorProvider this]
    (-> this (.openPipe))))

(defn open-selector
  "Opens a selector.

  returns: The new selector - `java.nio.channels.spi.AbstractSelector`

  throws: java.io.IOException - If an I/O error occurs"
  (^java.nio.channels.spi.AbstractSelector [^java.nio.channels.spi.SelectorProvider this]
    (-> this (.openSelector))))

(defn open-server-socket-channel
  "Opens a server-socket channel.

  returns: The new channel - `java.nio.channels.ServerSocketChannel`

  throws: java.io.IOException - If an I/O error occurs"
  (^java.nio.channels.ServerSocketChannel [^java.nio.channels.spi.SelectorProvider this]
    (-> this (.openServerSocketChannel))))

(defn open-socket-channel
  "Opens a socket channel.

  returns: The new channel - `java.nio.channels.SocketChannel`

  throws: java.io.IOException - If an I/O error occurs"
  (^java.nio.channels.SocketChannel [^java.nio.channels.spi.SelectorProvider this]
    (-> this (.openSocketChannel))))

(defn inherited-channel
  "Returns the channel inherited from the entity that created this
   Java virtual machine.

    On many operating systems a process, such as a Java virtual
   machine, can be started in a manner that allows the process to
   inherit a channel from the entity that created the process. The
   manner in which this is done is system dependent, as are the
   possible entities to which the channel may be connected. For example,
   on UNIX systems, the Internet services daemon (inetd) is used to
   start programs to service requests when a request arrives on an
   associated network port. In this example, the process that is started,
   inherits a channel representing a network socket.

    In cases where the inherited channel represents a network socket
   then the Channel type returned
   by this method is determined as follows:



     If the inherited channel represents a stream-oriented connected
    socket then a SocketChannel is
    returned. The socket channel is, at least initially, in blocking
    mode, bound to a socket address, and connected to a peer.


     If the inherited channel represents a stream-oriented listening
    socket then a ServerSocketChannel is returned. The server-socket channel is, at
    least initially, in blocking mode, and bound to a socket address.


     If the inherited channel is a datagram-oriented socket
    then a DatagramChannel is
    returned. The datagram channel is, at least initially, in blocking
    mode, and bound to a socket address.




    In addition to the network-oriented channels described, this method
   may return other kinds of channels in the future.

    The first invocation of this method creates the channel that is
   returned. Subsequent invocations of this method return the same
   channel.

  returns: The inherited channel, if any, otherwise null. - `java.nio.channels.Channel`

  throws: java.io.IOException - If an I/O error occurs"
  (^java.nio.channels.Channel [^java.nio.channels.spi.SelectorProvider this]
    (-> this (.inheritedChannel))))

