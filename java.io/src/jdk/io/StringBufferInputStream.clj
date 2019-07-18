(ns jdk.io.StringBufferInputStream
  "Deprecated.
 This class does not properly convert characters into bytes.  As
              of JDK 1.1, the preferred way to create a stream from a
              string is via the StringReader class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io StringBufferInputStream]))

(defn ->string-buffer-input-stream
  "Constructor.

  Deprecated.

  s - the underlying input buffer. - `java.lang.String`"
  (^StringBufferInputStream [^java.lang.String s]
    (new StringBufferInputStream s)))

(defn read
  "Deprecated.

  b - the buffer into which the data is read. - `byte[]`
  off - the start offset of the data. - `int`
  len - the maximum number of bytes read. - `int`

  returns: the total number of bytes read into the buffer, or
               -1 if there is no more data because the end of
               the stream has been reached. - `int`"
  (^Integer [^StringBufferInputStream this b ^Integer off ^Integer len]
    (-> this (.read b off len)))
  (^Integer [^StringBufferInputStream this]
    (-> this (.read))))

(defn skip
  "Deprecated.

  n - the number of bytes to be skipped. - `long`

  returns: the actual number of bytes skipped. - `long`"
  (^Long [^StringBufferInputStream this ^Long n]
    (-> this (.skip n))))

(defn available
  "Deprecated.

  returns: the value of count - pos, which is the
               number of bytes remaining to be read from the input buffer. - `int`"
  (^Integer [^StringBufferInputStream this]
    (-> this (.available))))

(defn reset
  "Deprecated."
  ([^StringBufferInputStream this]
    (-> this (.reset))))

