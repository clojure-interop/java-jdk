(ns jdk.nio.file.OpenOption
  "An object that configures how to open or create a file.

   Objects of this type are used by methods such as newOutputStream, newByteChannel, FileChannel.open, and AsynchronousFileChannel.open
  when opening or creating a file.

   The StandardOpenOption enumeration type defines the
  standard options."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file OpenOption]))

