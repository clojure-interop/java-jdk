(ns jdk.nio.channels.GatheringByteChannel
  "A channel that can write bytes from a sequence of buffers.

   A gathering write operation writes, in a single invocation, a
  sequence of bytes from one or more of a given sequence of buffers.
  Gathering writes are often useful when implementing network protocols or
  file formats that, for example, group data into segments consisting of one
  or more fixed-length headers followed by a variable-length body.  Similar
  scattering read operations are defined in the ScatteringByteChannel interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels GatheringByteChannel]))

(defn write
  "Writes a sequence of bytes to this channel from a subsequence of the
   given buffers.

    An attempt is made to write up to r bytes to this channel,
   where r is the total number of bytes remaining in the specified
   subsequence of the given buffer array, that is,



   srcs[offset].remaining()
        srcs[offset+1].remaining()
        ...  srcs[offset+length-1].remaining()

   at the moment that this method is invoked.

    Suppose that a byte sequence of length n is written, where
   0 <= n <= r.
   Up to the first srcs[offset].remaining() bytes of this sequence
   are written from buffer srcs[offset], up to the next
   srcs[offset+1].remaining() bytes are written from buffer
   srcs[offset+1], and so forth, until the entire byte sequence is
   written.  As many bytes as possible are written from each buffer, hence
   the final position of each updated buffer, except the last updated
   buffer, is guaranteed to be equal to that buffer's limit.

    Unless otherwise specified, a write operation will return only after
   writing all of the r requested bytes.  Some types of channels,
   depending upon their state, may write only some of the bytes or possibly
   none at all.  A socket channel in non-blocking mode, for example, cannot
   write any more bytes than are free in the socket's output buffer.

    This method may be invoked at any time.  If another thread has
   already initiated a write operation upon this channel, however, then an
   invocation of this method will block until the first operation is
   complete.

  srcs - The buffers from which bytes are to be retrieved - `java.nio.ByteBuffer[]`
  offset - The offset within the buffer array of the first buffer from which bytes are to be retrieved; must be non-negative and no larger than srcs.length - `int`
  length - The maximum number of buffers to be accessed; must be non-negative and no larger than srcs.length - offset - `int`

  returns: The number of bytes written, possibly zero - `long`

  throws: java.lang.IndexOutOfBoundsException - If the preconditions on the offset and length parameters do not hold"
  (^Long [^GatheringByteChannel this srcs ^Integer offset ^Integer length]
    (-> this (.write srcs offset length)))
  (^Long [^GatheringByteChannel this srcs]
    (-> this (.write srcs))))

