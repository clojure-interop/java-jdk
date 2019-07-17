(ns jdk.nio.channels.ScatteringByteChannel
  "A channel that can read bytes into a sequence of buffers.

   A scattering read operation reads, in a single invocation, a
  sequence of bytes into one or more of a given sequence of buffers.
  Scattering reads are often useful when implementing network protocols or
  file formats that, for example, group data into segments consisting of one
  or more fixed-length headers followed by a variable-length body.  Similar
  gathering write operations are defined in the GatheringByteChannel interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels ScatteringByteChannel]))

(defn read
  "Reads a sequence of bytes from this channel into a subsequence of the
   given buffers.

    An invocation of this method attempts to read up to r bytes
   from this channel, where r is the total number of bytes remaining
   the specified subsequence of the given buffer array, that is,



   dsts[offset].remaining()
        dsts[offset+1].remaining()
        ...  dsts[offset+length-1].remaining()

   at the moment that this method is invoked.

    Suppose that a byte sequence of length n is read, where
   0 <= n <= r.
   Up to the first dsts[offset].remaining() bytes of this sequence
   are transferred into buffer dsts[offset], up to the next
   dsts[offset+1].remaining() bytes are transferred into buffer
   dsts[offset+1], and so forth, until the entire byte sequence
   is transferred into the given buffers.  As many bytes as possible are
   transferred into each buffer, hence the final position of each updated
   buffer, except the last updated buffer, is guaranteed to be equal to
   that buffer's limit.

    This method may be invoked at any time.  If another thread has
   already initiated a read operation upon this channel, however, then an
   invocation of this method will block until the first operation is
   complete.

  dsts - The buffers into which bytes are to be transferred - `java.nio.ByteBuffer[]`
  offset - The offset within the buffer array of the first buffer into which bytes are to be transferred; must be non-negative and no larger than dsts.length - `int`
  length - The maximum number of buffers to be accessed; must be non-negative and no larger than dsts.length - offset - `int`

  returns: The number of bytes read, possibly zero,
           or -1 if the channel has reached end-of-stream - `long`

  throws: java.lang.IndexOutOfBoundsException - If the preconditions on the offset and length parameters do not hold"
  ([^. this ^java.nio.ByteBuffer[] dsts ^Integer offset ^Integer length]
    (-> this (.read dsts offset length)))
  ([^. this ^java.nio.ByteBuffer[] dsts]
    (-> this (.read dsts))))

