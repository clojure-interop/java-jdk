(ns jdk.io.DataInputStream
  "A data input stream lets an application read primitive Java data
  types from an underlying input stream in a machine-independent
  way. An application uses a data output stream to write data that
  can later be read by a data input stream.

  DataInputStream is not necessarily safe for multithreaded access.
  Thread safety is optional and is the responsibility of users of
  methods in this class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io DataInputStream]))

(defn ->data-input-stream
  "Constructor.

  Creates a DataInputStream that uses the specified
   underlying InputStream.

  in - the specified input stream - `java.io.InputStream`"
  ([^java.io.InputStream in]
    (new DataInputStream in)))

(defn *read-utf
  "Reads from the
   stream in a representation
   of a Unicode  character string encoded in
   modified UTF-8 format;
   this string of characters is then returned as a String.
   The details of the modified UTF-8 representation
   are  exactly the same as for the readUTF
   method of DataInput.

  in - a data input stream. - `java.io.DataInput`

  returns: a Unicode string. - `java.lang.String`

  throws: java.io.EOFException - if the input stream reaches the end before all the bytes."
  ([^java.io.DataInput in]
    (DataInputStream/readUTF in)))

(defn read-unsigned-byte
  "See the general contract of the readUnsignedByte
   method of DataInput.

   Bytes
   for this operation are read from the contained
   input stream.

  returns: the next byte of this input stream, interpreted as an
               unsigned 8-bit number. - `int`

  throws: java.io.EOFException - if this input stream has reached the end."
  ([^java.io.DataInputStream this]
    (-> this (.readUnsignedByte))))

(defn read-byte
  "See the general contract of the readByte
   method of DataInput.

   Bytes
   for this operation are read from the contained
   input stream.

  returns: the next byte of this input stream as a signed 8-bit
               byte. - `byte`

  throws: java.io.EOFException - if this input stream has reached the end."
  ([^java.io.DataInputStream this]
    (-> this (.readByte))))

(defn read-fully
  "See the general contract of the readFully
   method of DataInput.

   Bytes
   for this operation are read from the contained
   input stream.

  b - the buffer into which the data is read. - `byte[]`
  off - the start offset of the data. - `int`
  len - the number of bytes to read. - `int`

  throws: java.io.EOFException - if this input stream reaches the end before reading all the bytes."
  ([^java.io.DataInputStream this b ^Integer off ^Integer len]
    (-> this (.readFully b off len)))
  ([^java.io.DataInputStream this b]
    (-> this (.readFully b))))

(defn read-char
  "See the general contract of the readChar
   method of DataInput.

   Bytes
   for this operation are read from the contained
   input stream.

  returns: the next two bytes of this input stream, interpreted as a
               char. - `char`

  throws: java.io.EOFException - if this input stream reaches the end before reading two bytes."
  ([^java.io.DataInputStream this]
    (-> this (.readChar))))

(defn read-float
  "See the general contract of the readFloat
   method of DataInput.

   Bytes
   for this operation are read from the contained
   input stream.

  returns: the next four bytes of this input stream, interpreted as a
               float. - `float`

  throws: java.io.EOFException - if this input stream reaches the end before reading four bytes."
  ([^java.io.DataInputStream this]
    (-> this (.readFloat))))

(defn read
  "Reads up to len bytes of data from the contained
   input stream into an array of bytes.  An attempt is made to read
   as many as len bytes, but a smaller number may be read,
   possibly zero. The number of bytes actually read is returned as an
   integer.

    This method blocks until input data is available, end of file is
   detected, or an exception is thrown.

    If len is zero, then no bytes are read and
   0 is returned; otherwise, there is an attempt to read at
   least one byte. If no byte is available because the stream is at end of
   file, the value -1 is returned; otherwise, at least one
   byte is read and stored into b.

    The first byte read is stored into element b[off], the
   next one into b[off+1], and so on. The number of bytes read
   is, at most, equal to len. Let k be the number of
   bytes actually read; these bytes will be stored in elements
   b[off] through b[off+k-1],
   leaving elements b[off+k] through
   b[off+len-1] unaffected.

    In every case, elements b[0] through
   b[off] and elements b[off+len] through
   b[b.length-1] are unaffected.

  b - the buffer into which the data is read. - `byte[]`
  off - the start offset in the destination array b - `int`
  len - the maximum number of bytes read. - `int`

  returns: the total number of bytes read into the buffer, or
               -1 if there is no more data because the end
               of the stream has been reached. - `int`

  throws: java.lang.NullPointerException - If b is null."
  ([^java.io.DataInputStream this b ^Integer off ^Integer len]
    (-> this (.read b off len)))
  ([^java.io.DataInputStream this b]
    (-> this (.read b))))

(defn read-boolean
  "See the general contract of the readBoolean
   method of DataInput.

   Bytes for this operation are read from the contained
   input stream.

  returns: the boolean value read. - `boolean`

  throws: java.io.EOFException - if this input stream has reached the end."
  ([^java.io.DataInputStream this]
    (-> this (.readBoolean))))

(defn read-int
  "See the general contract of the readInt
   method of DataInput.

   Bytes
   for this operation are read from the contained
   input stream.

  returns: the next four bytes of this input stream, interpreted as an
               int. - `int`

  throws: java.io.EOFException - if this input stream reaches the end before reading four bytes."
  ([^java.io.DataInputStream this]
    (-> this (.readInt))))

(defn read-long
  "See the general contract of the readLong
   method of DataInput.

   Bytes
   for this operation are read from the contained
   input stream.

  returns: the next eight bytes of this input stream, interpreted as a
               long. - `long`

  throws: java.io.EOFException - if this input stream reaches the end before reading eight bytes."
  ([^java.io.DataInputStream this]
    (-> this (.readLong))))

(defn read-short
  "See the general contract of the readShort
   method of DataInput.

   Bytes
   for this operation are read from the contained
   input stream.

  returns: the next two bytes of this input stream, interpreted as a
               signed 16-bit number. - `short`

  throws: java.io.EOFException - if this input stream reaches the end before reading two bytes."
  ([^java.io.DataInputStream this]
    (-> this (.readShort))))

(defn skip-bytes
  "See the general contract of the skipBytes
   method of DataInput.

   Bytes for this operation are read from the contained
   input stream.

  n - the number of bytes to be skipped. - `int`

  returns: the actual number of bytes skipped. - `int`

  throws: java.io.IOException - if the contained input stream does not support seek, or the stream has been closed and the contained input stream does not support reading after close, or another I/O error occurs."
  ([^java.io.DataInputStream this ^Integer n]
    (-> this (.skipBytes n))))

(defn read-utf
  "See the general contract of the readUTF
   method of DataInput.

   Bytes
   for this operation are read from the contained
   input stream.

  returns: a Unicode string. - `java.lang.String`

  throws: java.io.EOFException - if this input stream reaches the end before reading all the bytes."
  ([^java.io.DataInputStream this]
    (-> this (.readUTF))))

(defn read-double
  "See the general contract of the readDouble
   method of DataInput.

   Bytes
   for this operation are read from the contained
   input stream.

  returns: the next eight bytes of this input stream, interpreted as a
               double. - `double`

  throws: java.io.EOFException - if this input stream reaches the end before reading eight bytes."
  ([^java.io.DataInputStream this]
    (-> this (.readDouble))))

(defn read-line
  "Deprecated. This method does not properly convert bytes to characters.
   As of JDK 1.1, the preferred way to read lines of text is via the
   BufferedReader.readLine() method.  Programs that use the
   DataInputStream class to read lines can be converted to use
   the BufferedReader class by replacing code of the form:


       DataInputStream d = new DataInputStream(in);
   with:


       BufferedReader d
            = new BufferedReader(new InputStreamReader(in));

  returns: the next line of text from this input stream. - `java.lang.   java.lang.String`

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.DataInputStream this]
    (-> this (.readLine))))

(defn read-unsigned-short
  "See the general contract of the readUnsignedShort
   method of DataInput.

   Bytes
   for this operation are read from the contained
   input stream.

  returns: the next two bytes of this input stream, interpreted as an
               unsigned 16-bit integer. - `int`

  throws: java.io.EOFException - if this input stream reaches the end before reading two bytes."
  ([^java.io.DataInputStream this]
    (-> this (.readUnsignedShort))))

