(ns jdk.nio.channels.SeekableByteChannel
  "A byte channel that maintains a current position and allows the
  position to be changed.

   A seekable byte channel is connected to an entity, typically a file,
  that contains a variable-length sequence of bytes that can be read and
  written. The current position can be queried and
  modified. The channel also provides access to
  the current size of the entity to which the channel is connected. The
  size increases when bytes are written beyond its current size; the size
  decreases when it is truncated.

   The position and truncate methods
  which do not otherwise have a value to return are specified to return the
  channel upon which they are invoked. This allows method invocations to be
  chained. Implementations of this interface should specialize the return type
  so that method invocations on the implementation class can be chained."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels SeekableByteChannel]))

(defn read
  "Reads a sequence of bytes from this channel into the given buffer.

    Bytes are read starting at this channel's current position, and
   then the position is updated with the number of bytes actually read.
   Otherwise this method behaves exactly as specified in the ReadableByteChannel interface.

  dst - The buffer into which bytes are to be transferred - `java.nio.ByteBuffer`

  returns: The number of bytes read, possibly zero, or -1 if the
            channel has reached end-of-stream - `int`

  throws: java.nio.channels.ClosedChannelException - If this channel is closed"
  ([^java.nio.channels.SeekableByteChannel this ^java.nio.ByteBuffer dst]
    (-> this (.read dst))))

(defn write
  "Writes a sequence of bytes to this channel from the given buffer.

    Bytes are written starting at this channel's current position, unless
   the channel is connected to an entity such as a file that is opened with
   the APPEND option, in
   which case the position is first advanced to the end. The entity to which
   the channel is connected is grown, if necessary, to accommodate the
   written bytes, and then the position is updated with the number of bytes
   actually written. Otherwise this method behaves exactly as specified by
   the WritableByteChannel interface.

  src - The buffer from which bytes are to be retrieved - `java.nio.ByteBuffer`

  returns: The number of bytes written, possibly zero - `int`

  throws: java.nio.channels.ClosedChannelException - If this channel is closed"
  ([^java.nio.channels.SeekableByteChannel this ^java.nio.ByteBuffer src]
    (-> this (.write src))))

(defn position
  "Sets this channel's position.

    Setting the position to a value that is greater than the current size
   is legal but does not change the size of the entity.  A later attempt to
   read bytes at such a position will immediately return an end-of-file
   indication.  A later attempt to write bytes at such a position will cause
   the entity to grow to accommodate the new bytes; the values of any bytes
   between the previous end-of-file and the newly-written bytes are
   unspecified.

    Setting the channel's position is not recommended when connected to
   an entity, typically a file, that is opened with the APPEND option. When opened for
   append, the position is first advanced to the end before writing.

  new-position - The new position, a non-negative integer counting the number of bytes from the beginning of the entity - `long`

  returns: This channel - `java.nio.channels.SeekableByteChannel`

  throws: java.nio.channels.ClosedChannelException - If this channel is closed"
  ([^java.nio.channels.SeekableByteChannel this ^Long new-position]
    (-> this (.position new-position)))
  ([^java.nio.channels.SeekableByteChannel this]
    (-> this (.position))))

(defn size
  "Returns the current size of entity to which this channel is connected.

  returns: The current size, measured in bytes - `long`

  throws: java.nio.channels.ClosedChannelException - If this channel is closed"
  ([^java.nio.channels.SeekableByteChannel this]
    (-> this (.size))))

(defn truncate
  "Truncates the entity, to which this channel is connected, to the given
   size.

    If the given size is less than the current size then the entity is
   truncated, discarding any bytes beyond the new end. If the given size is
   greater than or equal to the current size then the entity is not modified.
   In either case, if the current position is greater than the given size
   then it is set to that size.

    An implementation of this interface may prohibit truncation when
   connected to an entity, typically a file, opened with the APPEND option.

  size - The new size, a non-negative byte count - `long`

  returns: This channel - `java.nio.channels.SeekableByteChannel`

  throws: java.nio.channels.NonWritableChannelException - If this channel was not opened for writing"
  ([^java.nio.channels.SeekableByteChannel this ^Long size]
    (-> this (.truncate size))))

