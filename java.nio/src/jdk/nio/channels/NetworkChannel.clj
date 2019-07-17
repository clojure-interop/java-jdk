(ns jdk.nio.channels.NetworkChannel
  "A channel to a network socket.

   A channel that implements this interface is a channel to a network
  socket. The bind method is used to bind the
  socket to a local address, the getLocalAddress method returns the address that the socket is bound to, and
  the setOption and getOption methods are used to set and query socket
  options.  An implementation of this interface should specify the socket options
  that it supports.

   The bind and setOption methods that do
  not otherwise have a value to return are specified to return the network
  channel upon which they are invoked. This allows method invocations to be
  chained. Implementations of this interface should specialize the return type
  so that method invocations on the implementation class can be chained."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels NetworkChannel]))

(defn bind
  "Binds the channel's socket to a local address.

    This method is used to establish an association between the socket and
   a local address. Once an association is established then the socket remains
   bound until the channel is closed. If the local parameter has the
   value null then the socket will be bound to an address that is
   assigned automatically.

  local - The address to bind the socket, or null to bind the socket to an automatically assigned socket address - `java.net.SocketAddress`

  returns: This channel - `java.nio.channels.NetworkChannel`

  throws: java.nio.channels.AlreadyBoundException - If the socket is already bound"
  (^java.nio.channels.NetworkChannel [^java.nio.channels.NetworkChannel this ^java.net.SocketAddress local]
    (-> this (.bind local))))

(defn get-local-address
  "Returns the socket address that this channel's socket is bound to.

    Where the channel is bound to an Internet Protocol
   socket address then the return value from this method is of type InetSocketAddress.

  returns: The socket address that the socket is bound to, or null
            if the channel's socket is not bound - `java.net.SocketAddress`

  throws: java.nio.channels.ClosedChannelException - If the channel is closed"
  (^java.net.SocketAddress [^java.nio.channels.NetworkChannel this]
    (-> this (.getLocalAddress))))

(defn set-option
  "Sets the value of a socket option.

  name - The socket option - `java.net.SocketOption<T>`
  value - The value of the socket option. A value of null may be a valid value for some socket options. - `T`

  returns: This channel - `<T> java.nio.channels.NetworkChannel`

  throws: java.lang.UnsupportedOperationException - If the socket option is not supported by this channel"
  ([^java.nio.channels.NetworkChannel this ^java.net.SocketOption name value]
    (-> this (.setOption name value))))

(defn get-option
  "Returns the value of a socket option.

  name - The socket option - `java.net.SocketOption<T>`

  returns: The value of the socket option. A value of null may be
            a valid value for some socket options. - `<T> T`

  throws: java.lang.UnsupportedOperationException - If the socket option is not supported by this channel"
  ([^java.nio.channels.NetworkChannel this ^java.net.SocketOption name]
    (-> this (.getOption name))))

(defn supported-options
  "Returns a set of the socket options supported by this channel.

    This method will continue to return the set of options even after the
   channel has been closed.

  returns: A set of the socket options supported by this channel - `java.util.Set<java.net.SocketOption<?>>`"
  (^java.util.Set> [^java.nio.channels.NetworkChannel this]
    (-> this (.supportedOptions))))

