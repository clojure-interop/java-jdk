(ns jdk.nio.channels.ByteChannel
  "A channel that can read and write bytes.  This interface simply unifies
  ReadableByteChannel and WritableByteChannel; it does not
  specify any new operations."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels ByteChannel]))

