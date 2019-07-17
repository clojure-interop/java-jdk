(ns jdk.nio.charset.CoderMalfunctionError
  "Error thrown when the decodeLoop method of
  a CharsetDecoder, or the encodeLoop method of a CharsetEncoder, throws an unexpected
  exception."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.charset CoderMalfunctionError]))

(defn ->coder-malfunction-error
  "Constructor.

  Initializes an instance of this class.

  cause - The unexpected exception that was thrown - `java.lang.Exception`"
  ([cause]
    (new CoderMalfunctionError cause)))

