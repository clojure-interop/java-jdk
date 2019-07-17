(ns jdk.io.LineNumberInputStream
  "Deprecated.
 This class incorrectly assumes that bytes adequately represent
              characters.  As of JDK 1.1, the preferred way to operate on
              character streams is via the new character-stream classes, which
              include a class for counting line numbers."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io LineNumberInputStream]))

(defn ->line-number-input-stream
  "Constructor.

  Deprecated.

  in - the underlying input stream. - `java.io.InputStream`"
  ([in]
    (new LineNumberInputStream in)))

(defn read
  "Deprecated.

  b - the buffer into which the data is read. - `byte[]`
  off - the start offset of the data. - `int`
  len - the maximum number of bytes read. - `int`

  returns: the total number of bytes read into the buffer, or
               -1 if there is no more data because the end of
               this stream has been reached. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this b off len]
    (-> this (.read b off len)))
  ([this]
    (-> this (.read))))

(defn skip
  "Deprecated.

  n - the number of bytes to be skipped. - `long`

  returns: the actual number of bytes skipped. - `long`

  throws: java.io.IOException - if an I/O error occurs."
  ([this n]
    (-> this (.skip n))))

(defn set-line-number
  "Deprecated.

  line-number - the new line number. - `int`"
  ([this line-number]
    (-> this (.setLineNumber line-number))))

(defn get-line-number
  "Deprecated.

  returns: the current line number. - `int`"
  ([this]
    (-> this (.getLineNumber))))

(defn available
  "Deprecated.

  returns: the number of bytes that can be read from this input stream
               without blocking. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this]
    (-> this (.available))))

(defn mark
  "Deprecated.

  readlimit - the maximum limit of bytes that can be read before the mark position becomes invalid. - `int`"
  ([this readlimit]
    (-> this (.mark readlimit))))

(defn reset
  "Deprecated.

  throws: java.io.IOException - if an I/O error occurs."
  ([this]
    (-> this (.reset))))

