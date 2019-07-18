(ns jdk.nio.channels.Pipe$SourceChannel
  "A channel representing the readable end of a Pipe."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels Pipe$SourceChannel]))

(defn valid-ops
  "Returns an operation set identifying this channel's supported
   operations.

    Pipe-source channels only support reading, so this method
   returns SelectionKey.OP_READ.

  returns: The valid-operation set - `int`"
  (^Integer [^Pipe$SourceChannel this]
    (-> this (.validOps))))

