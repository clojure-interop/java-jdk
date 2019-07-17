(ns jdk.io.ByteArrayOutputStream
  "This class implements an output stream in which the data is
  written into a byte array. The buffer automatically grows as data
  is written to it.
  The data can be retrieved using toByteArray() and
  toString().

  Closing a ByteArrayOutputStream has no effect. The methods in
  this class can be called after the stream has been closed without
  generating an IOException."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io ByteArrayOutputStream]))

(defn ->byte-array-output-stream
  "Constructor.

  Creates a new byte array output stream, with a buffer capacity of
   the specified size, in bytes.

  size - the initial size. - `int`

  throws: java.lang.IllegalArgumentException - if size is negative."
  ([^Integer size]
    (new ByteArrayOutputStream size))
  ([]
    (new ByteArrayOutputStream )))

(defn write
  "Writes len bytes from the specified byte array
   starting at offset off to this byte array output stream.

  b - the data. - `byte[]`
  off - the start offset in the data. - `int`
  len - the number of bytes to write. - `int`"
  ([^java.io.ByteArrayOutputStream this b ^Integer off ^Integer len]
    (-> this (.write b off len)))
  ([^java.io.ByteArrayOutputStream this ^Integer b]
    (-> this (.write b))))

(defn write-to
  "Writes the complete contents of this byte array output stream to
   the specified output stream argument, as if by calling the output
   stream's write method using out.write(buf, 0, count).

  out - the output stream to which to write the data. - `java.io.OutputStream`

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.ByteArrayOutputStream this ^java.io.OutputStream out]
    (-> this (.writeTo out))))

(defn reset
  "Resets the count field of this byte array output
   stream to zero, so that all currently accumulated output in the
   output stream is discarded. The output stream can be used again,
   reusing the already allocated buffer space."
  ([^java.io.ByteArrayOutputStream this]
    (-> this (.reset))))

(defn to-byte-array
  "Creates a newly allocated byte array. Its size is the current
   size of this output stream and the valid contents of the buffer
   have been copied into it.

  returns: the current contents of this output stream, as a byte array. - `byte[]`"
  ([^java.io.ByteArrayOutputStream this]
    (-> this (.toByteArray))))

(defn size
  "Returns the current size of the buffer.

  returns: the value of the count field, which is the number
            of valid bytes in this output stream. - `int`"
  ([^java.io.ByteArrayOutputStream this]
    (-> this (.size))))

(defn to-string
  "Converts the buffer's contents into a string by decoding the bytes using
   the named charset. The length of the new
   String is a function of the charset, and hence may not be equal
   to the length of the byte array.

    This method always replaces malformed-input and unmappable-character
   sequences with this charset's default replacement string. The CharsetDecoder class should be used when more control
   over the decoding process is required.

  charset-name - the name of a supported charset - `java.lang.String`

  returns: String decoded from the buffer's contents. - `java.lang.String`

  throws: java.io.UnsupportedEncodingException - If the named charset is not supported"
  ([^java.io.ByteArrayOutputStream this ^java.lang.String charset-name]
    (-> this (.toString charset-name)))
  ([^java.io.ByteArrayOutputStream this]
    (-> this (.toString))))

(defn close
  "Closing a ByteArrayOutputStream has no effect. The methods in
   this class can be called after the stream has been closed without
   generating an IOException.

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.ByteArrayOutputStream this]
    (-> this (.close))))

