(ns jdk.io.Flushable
  "A Flushable is a destination of data that can be flushed.  The
  flush method is invoked to write any buffered output to the underlying
  stream."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io Flushable]))

(defn flush
  "Flushes this stream by writing any buffered output to the underlying
   stream.

  throws: java.io.IOException - If an I/O error occurs"
  ([this]
    (-> this (.flush))))

