(ns jdk.nio.channels.MembershipKey
  "A token representing the membership of an Internet Protocol (IP) multicast
  group.

   A membership key may represent a membership to receive all datagrams sent
  to the group, or it may be source-specific, meaning that it
  represents a membership that receives only datagrams from a specific source
  address. Whether or not a membership key is source-specific may be determined
  by invoking its sourceAddress method.

   A membership key is valid upon creation and remains valid until the
  membership is dropped by invoking the drop method, or
  the channel is closed. The validity of the membership key may be tested
  by invoking its isValid method.

   Where a membership key is not source-specific and the underlying operation
  system supports source filtering, then the block and unblock methods can be used to block or unblock multicast datagrams
  from particular source addresses."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels MembershipKey]))

(defn valid?
  "Tells whether or not this membership is valid.

    A multicast group membership is valid upon creation and remains
   valid until the membership is dropped by invoking the drop
   method, or the channel is closed.

  returns: true if this membership key is valid, false
            otherwise - `boolean`"
  (^Boolean [^MembershipKey this]
    (-> this (.isValid))))

(defn drop
  "Drop membership.

    If the membership key represents a membership to receive all datagrams
   then the membership is dropped and the channel will no longer receive any
   datagrams sent to the group. If the membership key is source-specific
   then the channel will no longer receive datagrams sent to the group from
   that source address.

    After membership is dropped it may still be possible to receive
   datagrams sent to the group. This can arise when datagrams are waiting to
   be received in the socket's receive buffer. After membership is dropped
   then the channel may join the group again
   in which case a new membership key is returned.

    Upon return, this membership object will be invalid.
   If the multicast group membership is already invalid then invoking this
   method has no effect. Once a multicast group membership is invalid,
   it remains invalid forever."
  ([^MembershipKey this]
    (-> this (.drop))))

(defn block
  "Block multicast datagrams from the given source address.

    If this membership key is not source-specific, and the underlying
   operating system supports source filtering, then this method blocks
   multicast datagrams from the given source address. If the given source
   address is already blocked then this method has no effect.
   After a source address is blocked it may still be possible to receive
   datagrams from that source. This can arise when datagrams are waiting to
   be received in the socket's receive buffer.

  source - The source address to block - `java.net.InetAddress`

  returns: This membership key - `java.nio.channels.MembershipKey`

  throws: java.lang.IllegalArgumentException - If the source parameter is not a unicast address or is not the same address type as the multicast group"
  (^java.nio.channels.MembershipKey [^MembershipKey this ^java.net.InetAddress source]
    (-> this (.block source))))

(defn unblock
  "Unblock multicast datagrams from the given source address that was
   previously blocked using the block method.

  source - The source address to unblock - `java.net.InetAddress`

  returns: This membership key - `java.nio.channels.MembershipKey`

  throws: java.lang.IllegalStateException - If the given source address is not currently blocked or the membership key is no longer valid"
  (^java.nio.channels.MembershipKey [^MembershipKey this ^java.net.InetAddress source]
    (-> this (.unblock source))))

(defn channel
  "Returns the channel for which this membership key was created. This
   method will continue to return the channel even after the membership
   becomes invalid.

  returns: the channel - `java.nio.channels.MulticastChannel`"
  (^java.nio.channels.MulticastChannel [^MembershipKey this]
    (-> this (.channel))))

(defn group
  "Returns the multicast group for which this membership key was created.
   This method will continue to return the group even after the membership
   becomes invalid.

  returns: the multicast group - `java.net.InetAddress`"
  (^java.net.InetAddress [^MembershipKey this]
    (-> this (.group))))

(defn network-interface
  "Returns the network interface for which this membership key was created.
   This method will continue to return the network interface even after the
   membership becomes invalid.

  returns: the network interface - `java.net.NetworkInterface`"
  (^java.net.NetworkInterface [^MembershipKey this]
    (-> this (.networkInterface))))

(defn source-address
  "Returns the source address if this membership key is source-specific,
   or null if this membership is not source-specific.

  returns: The source address if this membership key is source-specific,
            otherwise null - `java.net.InetAddress`"
  (^java.net.InetAddress [^MembershipKey this]
    (-> this (.sourceAddress))))

