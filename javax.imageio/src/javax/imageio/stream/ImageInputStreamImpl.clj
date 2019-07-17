(ns javax.imageio.stream.ImageInputStreamImpl
  "An abstract class implementing the ImageInputStream interface.
  This class is designed to reduce the number of methods that must
  be implemented by subclasses.

   In particular, this class handles most or all of the details of
  byte order interpretation, buffering, mark/reset, discarding,
  closing, and disposing."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.stream ImageInputStreamImpl]))

(defn ->image-input-stream-impl
  "Constructor.

  Constructs an ImageInputStreamImpl."
  ([]
    (new ImageInputStreamImpl )))

(defn read-unsigned-byte
  "Description copied from interface: ImageInputStream

  returns: an unsigned byte value from the stream. - `int`

  throws: java.io.EOFException - if the end of the stream is reached."
  (^Integer [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.readUnsignedByte))))

(defn read-bytes
  "Description copied from interface: ImageInputStream

  buf - an IIOByteBuffer object to be modified. - `javax.imageio.stream.IIOByteBuffer`
  len - the maximum number of bytes to read. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.imageio.stream.ImageInputStreamImpl this ^javax.imageio.stream.IIOByteBuffer buf ^Integer len]
    (-> this (.readBytes buf len))))

(defn read-bit
  "Description copied from interface: ImageInputStream

  returns: an int containing the value 0
   or 1. - `int`

  throws: java.io.EOFException - if the stream reaches the end before reading all the bits."
  (^Integer [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.readBit))))

(defn set-byte-order
  "Description copied from interface: ImageInputStream

  byte-order - one of ByteOrder.BIG_ENDIAN or java.nio.ByteOrder.LITTLE_ENDIAN, indicating whether network byte order or its reverse will be used for future reads. - `java.nio.ByteOrder`"
  ([^javax.imageio.stream.ImageInputStreamImpl this ^java.nio.ByteOrder byte-order]
    (-> this (.setByteOrder byte-order))))

(defn read-byte
  "Description copied from interface: ImageInputStream

  returns: a signed byte value from the stream. - `byte`

  throws: java.io.EOFException - if the end of the stream is reached."
  (^Byte [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.readByte))))

(defn read-fully
  "Description copied from interface: ImageInputStream

  b - an array of bytes to be written to. - `byte[]`
  off - the starting position within b to write to. - `int`
  len - the maximum number of bytes to read. - `int`

  throws: java.io.EOFException - if the stream reaches the end before reading all the bytes."
  ([^javax.imageio.stream.ImageInputStreamImpl this b ^Integer off ^Integer len]
    (-> this (.readFully b off len)))
  ([^javax.imageio.stream.ImageInputStreamImpl this b]
    (-> this (.readFully b))))

(defn get-bit-offset
  "Description copied from interface: ImageInputStream

  returns: an int containing the bit offset between
   0 and 7, inclusive. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  (^Integer [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.getBitOffset))))

(defn read-char
  "Description copied from interface: ImageInputStream

  returns: an unsigned char value from the stream. - `char`

  throws: java.io.EOFException - if the stream reaches the end before reading all the bytes."
  (^Character [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.readChar))))

(defn set-bit-offset
  "Description copied from interface: ImageInputStream

  bit-offset - the desired offset, as an int between 0 and 7, inclusive. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.imageio.stream.ImageInputStreamImpl this ^Integer bit-offset]
    (-> this (.setBitOffset bit-offset))))

(defn get-stream-position
  "Description copied from interface: ImageInputStream

  returns: a long containing the position of the stream. - `long`

  throws: java.io.IOException - if an I/O error occurs."
  (^Long [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.getStreamPosition))))

(defn read-float
  "Description copied from interface: ImageInputStream

  returns: a float value from the stream. - `float`

  throws: java.io.EOFException - if the stream reaches the end before reading all the bytes."
  (^Float [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.readFloat))))

(defn flush-before
  "Description copied from interface: ImageInputStream

  pos - a long containing the length of the stream prefix that may be flushed. - `long`

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.imageio.stream.ImageInputStreamImpl this ^Long pos]
    (-> this (.flushBefore pos))))

(defn flush
  "Description copied from interface: ImageInputStream

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.flush))))

(defn read
  "Reads up to len bytes from the stream, and stores
   them into b starting at index off.
   If no bytes can be read because the end of the stream has been
   reached, -1 is returned.

    The bit offset within the stream must be reset to zero before
   the read occurs.

    Subclasses must provide an implementation for this method.
   The subclass implementation should update the stream position
   before exiting.

  b - an array of bytes to be written to. - `byte[]`
  off - the starting position within b to write to. - `int`
  len - the maximum number of bytes to read. - `int`

  returns: the number of bytes actually read, or -1
   to indicate EOF. - `int`

  throws: java.lang.IndexOutOfBoundsException - if off is negative, len is negative, or off len is greater than b.length."
  (^Integer [^javax.imageio.stream.ImageInputStreamImpl this b ^Integer off ^Integer len]
    (-> this (.read b off len)))
  (^Integer [^javax.imageio.stream.ImageInputStreamImpl this b]
    (-> this (.read b)))
  (^Integer [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.read))))

(defn reset
  "Resets the current stream byte and bit positions from the stack
   of marked positions.

    An IOException will be thrown if the previous
   marked position lies in the discarded portion of the stream.

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.reset))))

(defn seek
  "Description copied from interface: ImageInputStream

  pos - a long containing the desired file pointer position. - `long`

  throws: java.io.IOException - if any other I/O error occurs."
  ([^javax.imageio.stream.ImageInputStreamImpl this ^Long pos]
    (-> this (.seek pos))))

(defn read-boolean
  "Description copied from interface: ImageInputStream

  returns: a boolean value from the stream. - `boolean`

  throws: java.io.EOFException - if the end of the stream is reached."
  (^Boolean [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.readBoolean))))

(defn read-int
  "Description copied from interface: ImageInputStream

  returns: a signed int value from the stream. - `int`

  throws: java.io.EOFException - if the stream reaches the end before reading all the bytes."
  (^Integer [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.readInt))))

(defn read-long
  "Description copied from interface: ImageInputStream

  returns: a signed long value from the stream. - `long`

  throws: java.io.EOFException - if the stream reaches the end before reading all the bytes."
  (^Long [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.readLong))))

(defn cached-memory?
  "Default implementation returns false.  Subclasses should
   override this if they cache data in main memory.

  returns: true if this ImageInputStream
   caches data in main memory. - `boolean`"
  (^Boolean [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.isCachedMemory))))

(defn length
  "Returns -1L to indicate that the stream has unknown
   length.  Subclasses must override this method to provide actual
   length information.

  returns: -1L to indicate unknown length. - `long`"
  (^Long [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.length))))

(defn close
  "Description copied from interface: ImageInputStream

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.close))))

(defn get-byte-order
  "Description copied from interface: ImageInputStream

  returns: one of ByteOrder.BIG_ENDIAN or
   ByteOrder.LITTLE_ENDIAN, indicating which byte
   order is being used. - `java.nio.ByteOrder`"
  (^java.nio.ByteOrder [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.getByteOrder))))

(defn read-short
  "Description copied from interface: ImageInputStream

  returns: a signed short value from the stream. - `short`

  throws: java.io.EOFException - if the stream reaches the end before reading all the bytes."
  (^Short [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.readShort))))

(defn skip-bytes
  "Advances the current stream position by calling
   seek(getStreamPosition()  n).

    The bit offset is reset to zero.

  n - the number of bytes to seek forward. - `int`

  returns: an int representing the number of bytes
   skipped. - `int`

  throws: java.io.IOException - if getStreamPosition throws an IOException when computing either the starting or ending position."
  (^Integer [^javax.imageio.stream.ImageInputStreamImpl this ^Integer n]
    (-> this (.skipBytes n))))

(defn cached-file?
  "Default implementation returns false.  Subclasses should
   override this if they cache data in a temporary file.

  returns: true if this ImageInputStream
   caches data in a temporary file. - `boolean`"
  (^Boolean [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.isCachedFile))))

(defn read-utf
  "Description copied from interface: ImageInputStream

  returns: a String read from the stream. - `java.lang.String`

  throws: java.io.EOFException - if this stream reaches the end before reading all the bytes."
  (^java.lang.String [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.readUTF))))

(defn read-bits
  "Description copied from interface: ImageInputStream

  num-bits - the number of bits to read, as an int between 0 and 64, inclusive. - `int`

  returns: the bitstring, as a long with the last bit
   read stored in the least significant bit. - `long`

  throws: java.io.EOFException - if the stream reaches the end before reading all the bits."
  (^Long [^javax.imageio.stream.ImageInputStreamImpl this ^Integer num-bits]
    (-> this (.readBits num-bits))))

(defn mark
  "Pushes the current stream position onto a stack of marked
   positions."
  ([^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.mark))))

(defn read-double
  "Description copied from interface: ImageInputStream

  returns: a double value from the stream. - `double`

  throws: java.io.EOFException - if the stream reaches the end before reading all the bytes."
  (^Double [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.readDouble))))

(defn get-flushed-position
  "Description copied from interface: ImageInputStream

  returns: the earliest legal position for seeking, as a
   long. - `long`"
  (^Long [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.getFlushedPosition))))

(defn read-unsigned-int
  "Description copied from interface: ImageInputStream

  returns: an unsigned int value from the stream, as a long. - `long`

  throws: java.io.EOFException - if the stream reaches the end before reading all the bytes."
  (^Long [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.readUnsignedInt))))

(defn cached?
  "Default implementation returns false.  Subclasses should
   override this if they cache data.

  returns: true if this ImageInputStream
   caches data. - `boolean`"
  (^Boolean [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.isCached))))

(defn read-line
  "Description copied from interface: ImageInputStream

  returns: a String containing a line of text from the stream. - `java.lang.String`

  throws: java.io.IOException - if an I/O error occurs."
  (^java.lang.String [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.readLine))))

(defn read-unsigned-short
  "Description copied from interface: ImageInputStream

  returns: an unsigned short value from the stream, as an int. - `int`

  throws: java.io.EOFException - if the stream reaches the end before reading all the bytes."
  (^Integer [^javax.imageio.stream.ImageInputStreamImpl this]
    (-> this (.readUnsignedShort))))

