(ns jdk.io.FilterWriter
  "Abstract class for writing filtered character streams.
  The abstract class FilterWriter itself
  provides default methods that pass all requests to the
  contained stream. Subclasses of FilterWriter
  should override some of these methods and may also
  provide additional methods and fields."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io FilterWriter]))

(defn write
  "Writes a portion of an array of characters.

  cbuf - Buffer of characters to be written - `char[]`
  off - Offset from which to start reading characters - `int`
  len - Number of characters to be written - `int`

  throws: java.io.IOException - If an I/O error occurs"
  ([this cbuf off len]
    (-> this (.write cbuf off len)))
  ([this c]
    (-> this (.write c))))

(defn flush
  "Flushes the stream.

  throws: java.io.IOException - If an I/O error occurs"
  ([this]
    (-> this (.flush))))

(defn close
  "Description copied from class: Writer

  throws: java.io.IOException - If an I/O error occurs"
  ([this]
    (-> this (.close))))

