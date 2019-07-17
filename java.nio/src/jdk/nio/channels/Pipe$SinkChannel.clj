(ns jdk.nio.channels.Pipe$SinkChannel
  "A channel representing the writable end of a Pipe."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels Pipe$SinkChannel]))

(defn valid-ops
  "Returns an operation set identifying this channel's supported
   operations.

    Pipe-sink channels only support writing, so this method returns
   SelectionKey.OP_WRITE.

  returns: The valid-operation set - `int`"
  ([this]
    (-> this (.validOps))))

