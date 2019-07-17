(ns jdk.io.Closeable
  "A Closeable is a source or destination of data that can be closed.
  The close method is invoked to release resources that the object is
  holding (such as open files)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io Closeable]))

(defn close
  "Closes this stream and releases any system resources associated
   with it. If the stream is already closed then invoking this
   method has no effect.

    As noted in AutoCloseable.close(), cases where the
   close may fail require careful attention. It is strongly advised
   to relinquish the underlying resources and to internally
   mark the Closeable as closed, prior to throwing
   the IOException.

  throws: java.io.IOException - if an I/O error occurs"
  ([^. this]
    (-> this (.close))))

