(ns jdk.nio.channels.SelectableChannel
  "A channel that can be multiplexed via a Selector.

   In order to be used with a selector, an instance of this class must
  first be registered via the register method.  This method returns a new SelectionKey object
  that represents the channel's registration with the selector.

   Once registered with a selector, a channel remains registered until it
  is deregistered.  This involves deallocating whatever resources were
  allocated to the channel by the selector.

   A channel cannot be deregistered directly; instead, the key representing
  its registration must be cancelled.  Cancelling a key requests that
  the channel be deregistered during the selector's next selection operation.
  A key may be cancelled explicitly by invoking its cancel method.  All of a channel's keys are cancelled
  implicitly when the channel is closed, whether by invoking its close method or by interrupting a thread blocked in an I/O
  operation upon the channel.

   If the selector itself is closed then the channel will be deregistered,
  and the key representing its registration will be invalidated, without
  further delay.

   A channel may be registered at most once with any particular selector.

   Whether or not a channel is registered with one or more selectors may be
  determined by invoking the isRegistered method.

   Selectable channels are safe for use by multiple concurrent
  threads.



  Blocking mode

  A selectable channel is either in blocking mode or in
  non-blocking mode.  In blocking mode, every I/O operation invoked
  upon the channel will block until it completes.  In non-blocking mode an I/O
  operation will never block and may transfer fewer bytes than were requested
  or possibly no bytes at all.  The blocking mode of a selectable channel may
  be determined by invoking its isBlocking method.

   Newly-created selectable channels are always in blocking mode.
  Non-blocking mode is most useful in conjunction with selector-based
  multiplexing.  A channel must be placed into non-blocking mode before being
  registered with a selector, and may not be returned to blocking mode until
  it has been deregistered."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels SelectableChannel]))

(defn provider
  "Returns the provider that created this channel.

  returns: The provider that created this channel - `java.nio.channels.spi.SelectorProvider`"
  ([this]
    (-> this (.provider))))

(defn valid-ops
  "Returns an operation set
   identifying this channel's supported operations.  The bits that are set
   in this integer value denote exactly the operations that are valid for
   this channel.  This method always returns the same value for a given
   concrete channel class.

  returns: The valid-operation set - `int`"
  ([this]
    (-> this (.validOps))))

(defn registered?
  "Tells whether or not this channel is currently registered with any
   selectors.  A newly-created channel is not registered.

    Due to the inherent delay between key cancellation and channel
   deregistration, a channel may remain registered for some time after all
   of its keys have been cancelled.  A channel may also remain registered
   for some time after it is closed.

  returns: true if, and only if, this channel is registered - `boolean`"
  ([this]
    (-> this (.isRegistered))))

(defn key-for
  "Retrieves the key representing the channel's registration with the given
   selector.

  sel - The selector - `java.nio.channels.Selector`

  returns: The key returned when this channel was last registered with the
            given selector, or null if this channel is not
            currently registered with that selector - `java.nio.channels.SelectionKey`"
  ([this sel]
    (-> this (.keyFor sel))))

(defn register
  "Registers this channel with the given selector, returning a selection
   key.

    If this channel is currently registered with the given selector then
   the selection key representing that registration is returned.  The key's
   interest set will have been changed to ops, as if by invoking
   the interestOps(int) method.  If
   the att argument is not null then the key's attachment
   will have been set to that value.  A CancelledKeyException will
   be thrown if the key has already been cancelled.

    Otherwise this channel has not yet been registered with the given
   selector, so it is registered and the resulting new key is returned.
   The key's initial interest set will be ops and its attachment
   will be att.

    This method may be invoked at any time.  If this method is invoked
   while another invocation of this method or of the configureBlocking method is in progress
   then it will first block until the other operation is complete.  This
   method will then synchronize on the selector's key set and therefore may
   block if invoked concurrently with another registration or selection
   operation involving the same selector.

    If this channel is closed while this operation is in progress then
   the key returned by this method will have been cancelled and will
   therefore be invalid.

  sel - The selector with which this channel is to be registered - `java.nio.channels.Selector`
  ops - The interest set for the resulting key - `int`
  att - The attachment for the resulting key; may be null - `java.lang.Object`

  returns: A key representing the registration of this channel with
            the given selector - `java.nio.channels.SelectionKey`

  throws: java.nio.channels.ClosedChannelException - If this channel is closed"
  ([this sel ops att]
    (-> this (.register sel ops att)))
  ([this sel ops]
    (-> this (.register sel ops))))

(defn configure-blocking
  "Adjusts this channel's blocking mode.

    If this channel is registered with one or more selectors then an
   attempt to place it into blocking mode will cause an IllegalBlockingModeException to be thrown.

    This method may be invoked at any time.  The new blocking mode will
   only affect I/O operations that are initiated after this method returns.
   For some implementations this may require blocking until all pending I/O
   operations are complete.

    If this method is invoked while another invocation of this method or
   of the register method is in progress
   then it will first block until the other operation is complete.

  block - If true then this channel will be placed in blocking mode; if false then it will be placed non-blocking mode - `boolean`

  returns: This selectable channel - `java.nio.channels.SelectableChannel`

  throws: java.nio.channels.ClosedChannelException - If this channel is closed"
  ([this block]
    (-> this (.configureBlocking block))))

(defn blocking?
  "Tells whether or not every I/O operation on this channel will block
   until it completes.  A newly-created channel is always in blocking mode.

    If this channel is closed then the value returned by this method is
   not specified.

  returns: true if, and only if, this channel is in blocking mode - `boolean`"
  ([this]
    (-> this (.isBlocking))))

(defn blocking-lock
  "Retrieves the object upon which the configureBlocking and register methods synchronize.
   This is often useful in the implementation of adaptors that require a
   specific blocking mode to be maintained for a short period of time.

  returns: The blocking-mode lock object - `java.lang.Object`"
  ([this]
    (-> this (.blockingLock))))

