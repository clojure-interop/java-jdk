(ns jdk.nio.channels.ReadableByteChannel
  "A channel that can read bytes.

   Only one read operation upon a readable channel may be in progress at
  any given time.  If one thread initiates a read operation upon a channel
  then any other thread that attempts to initiate another read operation will
  block until the first operation is complete.  Whether or not other kinds of
  I/O operations may proceed concurrently with a read operation depends upon
  the type of the channel."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels ReadableByteChannel]))

(defn read
  "Reads a sequence of bytes from this channel into the given buffer.

    An attempt is made to read up to r bytes from the channel,
   where r is the number of bytes remaining in the buffer, that is,
   dst.remaining(), at the moment this method is invoked.

    Suppose that a byte sequence of length n is read, where
   0 <= n <= r.
   This byte sequence will be transferred into the buffer so that the first
   byte in the sequence is at index p and the last byte is at index
   p + n - 1,
   where p is the buffer's position at the moment this method is
   invoked.  Upon return the buffer's position will be equal to
   p + n; its limit will not have changed.

    A read operation might not fill the buffer, and in fact it might not
   read any bytes at all.  Whether or not it does so depends upon the
   nature and state of the channel.  A socket channel in non-blocking mode,
   for example, cannot read any more bytes than are immediately available
   from the socket's input buffer; similarly, a file channel cannot read
   any more bytes than remain in the file.  It is guaranteed, however, that
   if a channel is in blocking mode and there is at least one byte
   remaining in the buffer then this method will block until at least one
   byte is read.

    This method may be invoked at any time.  If another thread has
   already initiated a read operation upon this channel, however, then an
   invocation of this method will block until the first operation is
   complete.

  dst - The buffer into which bytes are to be transferred - `java.nio.ByteBuffer`

  returns: The number of bytes read, possibly zero, or -1 if the
            channel has reached end-of-stream - `int`

  throws: java.nio.channels.NonReadableChannelException - If this channel was not opened for reading"
  (^Integer [^java.nio.channels.ReadableByteChannel this ^java.nio.ByteBuffer dst]
    (-> this (.read dst))))

