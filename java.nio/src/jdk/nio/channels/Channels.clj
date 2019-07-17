(ns jdk.nio.channels.Channels
  "Utility methods for channels and streams.

   This class defines static methods that support the interoperation of the
  stream classes of the java.io package with the channel
  classes of this package."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels Channels]))

(defn *new-input-stream
  "Constructs a stream that reads bytes from the given channel.

    The read methods of the resulting stream will throw an
   IllegalBlockingModeException if invoked while the underlying
   channel is in non-blocking mode.  The stream will not be buffered, and
   it will not support the mark or reset methods.  The stream will be safe for access by
   multiple concurrent threads.  Closing the stream will in turn cause the
   channel to be closed.

  ch - The channel from which bytes will be read - `java.nio.channels.ReadableByteChannel`

  returns: A new input stream - `java.io.InputStream`"
  ([ch]
    (Channels/newInputStream ch)))

(defn *new-output-stream
  "Constructs a stream that writes bytes to the given channel.

    The write methods of the resulting stream will throw an
   IllegalBlockingModeException if invoked while the underlying
   channel is in non-blocking mode.  The stream will not be buffered.  The
   stream will be safe for access by multiple concurrent threads.  Closing
   the stream will in turn cause the channel to be closed.

  ch - The channel to which bytes will be written - `java.nio.channels.WritableByteChannel`

  returns: A new output stream - `java.io.OutputStream`"
  ([ch]
    (Channels/newOutputStream ch)))

(defn *new-channel
  "Constructs a channel that reads bytes from the given stream.

    The resulting channel will not be buffered; it will simply redirect
   its I/O operations to the given stream.  Closing the channel will in
   turn cause the stream to be closed.

  in - The stream from which bytes are to be read - `java.io.InputStream`

  returns: A new readable byte channel - `java.nio.channels.ReadableByteChannel`"
  ([in]
    (Channels/newChannel in)))

(defn *new-reader
  "Constructs a reader that decodes bytes from the given channel using the
   given decoder.

    The resulting stream will contain an internal input buffer of at
   least minBufferCap bytes.  The stream's read methods
   will, as needed, fill the buffer by reading bytes from the underlying
   channel; if the channel is in non-blocking mode when bytes are to be
   read then an IllegalBlockingModeException will be thrown.  The
   resulting stream will not otherwise be buffered, and it will not support
   the mark or reset methods.
   Closing the stream will in turn cause the channel to be closed.

  ch - The channel from which bytes will be read - `java.nio.channels.ReadableByteChannel`
  dec - The charset decoder to be used - `java.nio.charset.CharsetDecoder`
  min-buffer-cap - The minimum capacity of the internal byte buffer, or -1 if an implementation-dependent default capacity is to be used - `int`

  returns: A new reader - `java.io.Reader`"
  ([ch dec min-buffer-cap]
    (Channels/newReader ch dec min-buffer-cap))
  ([ch cs-name]
    (Channels/newReader ch cs-name)))

(defn *new-writer
  "Constructs a writer that encodes characters using the given encoder and
   writes the resulting bytes to the given channel.

    The resulting stream will contain an internal output buffer of at
   least minBufferCap bytes.  The stream's write methods
   will, as needed, flush the buffer by writing bytes to the underlying
   channel; if the channel is in non-blocking mode when bytes are to be
   written then an IllegalBlockingModeException will be thrown.
   The resulting stream will not otherwise be buffered.  Closing the stream
   will in turn cause the channel to be closed.

  ch - The channel to which bytes will be written - `java.nio.channels.WritableByteChannel`
  enc - The charset encoder to be used - `java.nio.charset.CharsetEncoder`
  min-buffer-cap - The minimum capacity of the internal byte buffer, or -1 if an implementation-dependent default capacity is to be used - `int`

  returns: A new writer - `java.io.Writer`"
  ([ch enc min-buffer-cap]
    (Channels/newWriter ch enc min-buffer-cap))
  ([ch cs-name]
    (Channels/newWriter ch cs-name)))

