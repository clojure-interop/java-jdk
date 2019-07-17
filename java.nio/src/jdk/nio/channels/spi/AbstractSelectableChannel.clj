(ns jdk.nio.channels.spi.AbstractSelectableChannel
  "Base implementation class for selectable channels.

   This class defines methods that handle the mechanics of channel
  registration, deregistration, and closing.  It maintains the current
  blocking mode of this channel as well as its current set of selection keys.
  It performs all of the synchronization required to implement the SelectableChannel specification.  Implementations of the
  abstract protected methods defined in this class need not synchronize
  against other threads that might be engaged in the same operations."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels.spi AbstractSelectableChannel]))

(defn provider
  "Returns the provider that created this channel.

  returns: The provider that created this channel - `java.nio.channels.spi.SelectorProvider`"
  ([^java.nio.channels.spi.AbstractSelectableChannel this]
    (-> this (.provider))))

(defn registered?
  "Description copied from class: SelectableChannel

  returns: true if, and only if, this channel is registered - `boolean`"
  ([^java.nio.channels.spi.AbstractSelectableChannel this]
    (-> this (.isRegistered))))

(defn key-for
  "Description copied from class: SelectableChannel

  sel - The selector - `java.nio.channels.Selector`

  returns: The key returned when this channel was last registered with the
            given selector, or null if this channel is not
            currently registered with that selector - `java.nio.channels.SelectionKey`"
  ([^java.nio.channels.spi.AbstractSelectableChannel this ^java.nio.channels.Selector sel]
    (-> this (.keyFor sel))))

(defn register
  "Registers this channel with the given selector, returning a selection key.

     This method first verifies that this channel is open and that the
   given initial interest set is valid.

    If this channel is already registered with the given selector then
   the selection key representing that registration is returned after
   setting its interest set to the given value.

    Otherwise this channel has not yet been registered with the given
   selector, so the register method of
   the selector is invoked while holding the appropriate locks.  The
   resulting key is added to this channel's key set before being returned.

  sel - The selector with which this channel is to be registered - `java.nio.channels.Selector`
  ops - The interest set for the resulting key - `int`
  att - The attachment for the resulting key; may be null - `java.lang.Object`

  returns: A key representing the registration of this channel with
            the given selector - `java.nio.channels.SelectionKey`

  throws: java.nio.channels.ClosedSelectorException - If the selector is closed"
  ([^java.nio.channels.spi.AbstractSelectableChannel this ^java.nio.channels.Selector sel ^Integer ops ^java.lang.Object att]
    (-> this (.register sel ops att))))

(defn blocking?
  "Description copied from class: SelectableChannel

  returns: true if, and only if, this channel is in blocking mode - `boolean`"
  ([^java.nio.channels.spi.AbstractSelectableChannel this]
    (-> this (.isBlocking))))

(defn blocking-lock
  "Description copied from class: SelectableChannel

  returns: The blocking-mode lock object - `java.lang.Object`"
  ([^java.nio.channels.spi.AbstractSelectableChannel this]
    (-> this (.blockingLock))))

(defn configure-blocking
  "Adjusts this channel's blocking mode.

    If the given blocking mode is different from the current blocking
   mode then this method invokes the implConfigureBlocking method, while holding the appropriate locks, in
   order to change the mode.

  block - If true then this channel will be placed in blocking mode; if false then it will be placed non-blocking mode - `boolean`

  returns: This selectable channel - `java.nio.channels.SelectableChannel`

  throws: java.nio.channels.ClosedChannelException - If this channel is closed"
  ([^java.nio.channels.spi.AbstractSelectableChannel this ^Boolean block]
    (-> this (.configureBlocking block))))

