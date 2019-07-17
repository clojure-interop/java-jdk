(ns jdk.nio.channels.Pipe
  "A pair of channels that implements a unidirectional pipe.

   A pipe consists of a pair of channels: A writable sink channel and a readable source
  channel.  Once some bytes are written to the sink channel they can be read
  from source channel in exactlyAthe order in which they were written.

   Whether or not a thread writing bytes to a pipe will block until another
  thread reads those bytes, or some previously-written bytes, from the pipe is
  system-dependent and therefore unspecified.  Many pipe implementations will
  buffer up to a certain number of bytes between the sink and source channels,
  but such buffering should not be assumed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels Pipe]))

(defn *open
  "Opens a pipe.

    The new pipe is created by invoking the openPipe method of the
   system-wide default SelectorProvider
   object.

  returns: A new pipe - `java.nio.channels.Pipe`

  throws: java.io.IOException - If an I/O error occurs"
  ([]
    (Pipe/open )))

(defn source
  "Returns this pipe's source channel.

  returns: This pipe's source channel - `java.nio.channels.Pipe.SourceChannel`"
  ([this]
    (-> this (.source))))

(defn sink
  "Returns this pipe's sink channel.

  returns: This pipe's sink channel - `java.nio.channels.Pipe.SinkChannel`"
  ([this]
    (-> this (.sink))))

