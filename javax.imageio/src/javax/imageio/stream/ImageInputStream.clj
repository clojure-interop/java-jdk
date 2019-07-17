(ns javax.imageio.stream.ImageInputStream
  "A seekable input stream interface for use by
  ImageReaders.  Various input sources, such as
  InputStreams and Files,
  as well as future fast I/O sources may be `wrapped` by a suitable
  implementation of this interface for use by the Image I/O API."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.stream ImageInputStream]))

(defn read-unsigned-byte
  "Reads a byte from the stream, and (conceptually) converts it to
   an int, masks it with 0xff in order to strip off
   any sign-extension bits, and returns it as a byte
   value.

    Thus, byte values between 0x00 and
   0x7f are simply returned as integer values between
   0 and 127.  Values between
   0x80 and 0xff, which normally
   represent negative bytevalues, will be mapped into
   positive integers between 128 and
   255.

    The bit offset within the stream is reset to zero before
   the read occurs.

  returns: an unsigned byte value from the stream. - `int`

  throws: java.io.EOFException - if the end of the stream is reached."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.readUnsignedByte))))

(defn read-bytes
  "Reads up to len bytes from the stream, and
   modifies the supplied IIOByteBuffer to indicate
   the byte array, offset, and length where the data may be found.
   The caller should not attempt to modify the data found in the
   IIOByteBuffer.

    The bit offset within the stream is reset to zero before
   the read occurs.

  buf - an IIOByteBuffer object to be modified. - `javax.imageio.stream.IIOByteBuffer`
  len - the maximum number of bytes to read. - `int`

  throws: java.lang.IndexOutOfBoundsException - if len is negative."
  ([^javax.imageio.stream.ImageInputStream this ^javax.imageio.stream.IIOByteBuffer buf ^Integer len]
    (-> this (.readBytes buf len))))

(defn read-bit
  "Reads a single bit from the stream and returns it as an
   int with the value 0 or
   1.  The bit offset is advanced by one and reduced
   modulo 8.

  returns: an int containing the value 0
   or 1. - `int`

  throws: java.io.EOFException - if the stream reaches the end before reading all the bits."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.readBit))))

(defn set-byte-order
  "Sets the desired byte order for future reads of data values
   from this stream.  For example, the sequence of bytes '0x01
   0x02 0x03 0x04' if read as a 4-byte integer would have the
   value '0x01020304' using network byte order and the value
   '0x04030201' under the reverse byte order.

    The enumeration class java.nio.ByteOrder is
   used to specify the byte order.  A value of
   ByteOrder.BIG_ENDIAN specifies so-called
   big-endian or network byte order, in which the high-order byte
   comes first.  Motorola and Sparc processors store data in this
   format, while Intel processors store data in the reverse
   ByteOrder.LITTLE_ENDIAN order.

    The byte order has no effect on the results returned from
   the readBits method (or the value written by
   ImageOutputStream.writeBits).

  byte-order - one of ByteOrder.BIG_ENDIAN or java.nio.ByteOrder.LITTLE_ENDIAN, indicating whether network byte order or its reverse will be used for future reads. - `java.nio.ByteOrder`"
  ([^javax.imageio.stream.ImageInputStream this ^java.nio.ByteOrder byte-order]
    (-> this (.setByteOrder byte-order))))

(defn read-byte
  "Reads a byte from the stream and returns it as a
   byte value.  Byte values between 0x00
   and 0x7f represent integer values between
   0 and 127.  Values between
   0x80 and 0xff represent negative
   values from -128 to /1.

    The bit offset within the stream is reset to zero before
   the read occurs.

  returns: a signed byte value from the stream. - `byte`

  throws: java.io.EOFException - if the end of the stream is reached."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.readByte))))

(defn read-fully
  "Reads len bytes from the stream, and stores them
   into b starting at index off.
   If the end of the stream is reached, an java.io.EOFException
   will be thrown.

    The bit offset within the stream is reset to zero before
   the read occurs.

  b - an array of bytes to be written to. - `byte[]`
  off - the starting position within b to write to. - `int`
  len - the maximum number of bytes to read. - `int`

  throws: java.lang.IndexOutOfBoundsException - if off is negative, len is negative, or off len is greater than b.length."
  ([^javax.imageio.stream.ImageInputStream this b ^Integer off ^Integer len]
    (-> this (.readFully b off len)))
  ([^javax.imageio.stream.ImageInputStream this b]
    (-> this (.readFully b))))

(defn get-bit-offset
  "Returns the current bit offset, as an integer between 0 and 7,
   inclusive.  The bit offset is updated implicitly by calls to
   the readBits method.  A value of 0 indicates the
   most-significant bit, and a value of 7 indicates the least
   significant bit, of the byte being read.

    The bit offset is set to 0 when a stream is first
   opened, and is reset to 0 by calls to seek,
   skipBytes, or any read or
   readFully method.

  returns: an int containing the bit offset between
   0 and 7, inclusive. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.getBitOffset))))

(defn read-char
  "Equivalent to readUnsignedShort, except that the
   result is returned using the char datatype.

    The bit offset within the stream is reset to zero before
   the read occurs.

  returns: an unsigned char value from the stream. - `char`

  throws: java.io.EOFException - if the stream reaches the end before reading all the bytes."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.readChar))))

(defn set-bit-offset
  "Sets the bit offset to an integer between 0 and 7, inclusive.
   The byte offset within the stream, as returned by
   getStreamPosition, is left unchanged.
   A value of 0 indicates the
   most-significant bit, and a value of 7 indicates the least
   significant bit, of the byte being read.

  bit-offset - the desired offset, as an int between 0 and 7, inclusive. - `int`

  throws: java.lang.IllegalArgumentException - if bitOffset is not between 0 and 7, inclusive."
  ([^javax.imageio.stream.ImageInputStream this ^Integer bit-offset]
    (-> this (.setBitOffset bit-offset))))

(defn get-stream-position
  "Returns the current byte position of the stream.  The next read
   will take place starting at this offset.

  returns: a long containing the position of the stream. - `long`

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.getStreamPosition))))

(defn read-float
  "Reads 4 bytes from the stream, and (conceptually) concatenates
   them according to the current byte order and returns the result
   as a float.

    The bit offset within the stream is reset to zero before
   the read occurs.

  returns: a float value from the stream. - `float`

  throws: java.io.EOFException - if the stream reaches the end before reading all the bytes."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.readFloat))))

(defn flush-before
  "Discards the initial portion of the stream prior to the
   indicated position.  Attempting to seek to an offset within the
   flushed portion of the stream will result in an
   IndexOutOfBoundsException.

    Calling flushBefore may allow classes
   implementing this interface to free up resources such as memory
   or disk space that are being used to store data from the
   stream.

  pos - a long containing the length of the stream prefix that may be flushed. - `long`

  throws: java.lang.IndexOutOfBoundsException - if pos lies in the flushed portion of the stream or past the current stream position."
  ([^javax.imageio.stream.ImageInputStream this ^Long pos]
    (-> this (.flushBefore pos))))

(defn flush
  "Discards the initial position of the stream prior to the current
   stream position.  Equivalent to
   flushBefore(getStreamPosition()).

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.flush))))

(defn read
  "Reads up to len bytes from the stream, and stores
   them into b starting at index off.
   The number of bytes read is returned.  If no bytes can be read
   because the end of the stream has been reached, -1
   is returned.

    The bit offset within the stream is reset to zero before
   the read occurs.

  b - an array of bytes to be written to. - `byte[]`
  off - the starting position within b to write to. - `int`
  len - the maximum number of bytes to read. - `int`

  returns: the number of bytes actually read, or -1
   to indicate EOF. - `int`

  throws: java.lang.NullPointerException - if b is null."
  ([^javax.imageio.stream.ImageInputStream this b ^Integer off ^Integer len]
    (-> this (.read b off len)))
  ([^javax.imageio.stream.ImageInputStream this b]
    (-> this (.read b)))
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.read))))

(defn reset
  "Returns the stream pointer to its previous position, including
   the bit offset, at the time of the most recent unmatched call
   to mark.

    Calls to reset without a corresponding call
   to mark have no effect.

    An IOException will be thrown if the previous
   marked position lies in the discarded portion of the stream.

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.reset))))

(defn seek
  "Sets the current stream position to the desired location.  The
   next read will occur at this location.  The bit offset is set
   to 0.

    An IndexOutOfBoundsException will be thrown if
   pos is smaller than the flushed position (as
   returned by getflushedPosition).

    It is legal to seek past the end of the file; an
   java.io.EOFException will be thrown only if a read is
   performed.

  pos - a long containing the desired file pointer position. - `long`

  throws: java.lang.IndexOutOfBoundsException - if pos is smaller than the flushed position."
  ([^javax.imageio.stream.ImageInputStream this ^Long pos]
    (-> this (.seek pos))))

(defn read-boolean
  "Reads a byte from the stream and returns a boolean
   value of true if it is nonzero, false
   if it is zero.

    The bit offset within the stream is reset to zero before
   the read occurs.

  returns: a boolean value from the stream. - `boolean`

  throws: java.io.EOFException - if the end of the stream is reached."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.readBoolean))))

(defn read-int
  "Reads 4 bytes from the stream, and (conceptually) concatenates
   them according to the current byte order and returns the result
   as an int.

    The bit offset within the stream is ignored and treated as
   though it were zero.

  returns: a signed int value from the stream. - `int`

  throws: java.io.EOFException - if the stream reaches the end before reading all the bytes."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.readInt))))

(defn read-long
  "Reads 8 bytes from the stream, and (conceptually) concatenates
   them according to the current byte order and returns the result
   as a long.

    The bit offset within the stream is reset to zero before
   the read occurs.

  returns: a signed long value from the stream. - `long`

  throws: java.io.EOFException - if the stream reaches the end before reading all the bytes."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.readLong))))

(defn cached-memory?
  "Returns true if this ImageInputStream
   caches data itself in order to allow seeking backwards, and
   the cache is kept in main memory.  Applications may consult
   this in order to decide how frequently, or whether, to flush
   in order to conserve cache resources.

  returns: true if this ImageInputStream
   caches data in main memory. - `boolean`"
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.isCachedMemory))))

(defn length
  "Returns the total length of the stream, if known.  Otherwise,
   -1 is returned.

  returns: a long containing the length of the
   stream, if known, or else -1. - `long`

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.length))))

(defn close
  "Closes the stream.  Attempts to access a stream that has been
   closed may result in IOExceptions or incorrect
   behavior.  Calling this method may allow classes implementing
   this interface to release resources associated with the stream
   such as memory, disk space, or file descriptors.

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.close))))

(defn get-byte-order
  "Returns the byte order with which data values will be read from
   this stream as an instance of the
   java.nio.ByteOrder enumeration.

  returns: one of ByteOrder.BIG_ENDIAN or
   ByteOrder.LITTLE_ENDIAN, indicating which byte
   order is being used. - `java.nio.ByteOrder`"
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.getByteOrder))))

(defn read-short
  "Reads two bytes from the stream, and (conceptually)
   concatenates them according to the current byte order, and
   returns the result as a short value.

    The bit offset within the stream is reset to zero before
   the read occurs.

  returns: a signed short value from the stream. - `short`

  throws: java.io.EOFException - if the stream reaches the end before reading all the bytes."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.readShort))))

(defn skip-bytes
  "Moves the stream position forward by a given number of bytes.  It
   is possible that this method will only be able to skip forward
   by a smaller number of bytes than requested, for example if the
   end of the stream is reached.  In all cases, the actual number
   of bytes skipped is returned.  The bit offset is set to zero
   prior to advancing the position.

  n - an int containing the number of bytes to be skipped. - `int`

  returns: an int representing the number of bytes skipped. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.imageio.stream.ImageInputStream this ^Integer n]
    (-> this (.skipBytes n))))

(defn cached-file?
  "Returns true if this ImageInputStream
   caches data itself in order to allow seeking backwards, and
   the cache is kept in a temporary file.  Applications may consult
   this in order to decide how frequently, or whether, to flush
   in order to conserve cache resources.

  returns: true if this ImageInputStream
   caches data in a temporary file. - `boolean`"
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.isCachedFile))))

(defn read-utf
  "Reads in a string that has been encoded using a
   modified
   UTF-8
   format.  The general contract of readUTF is that
   it reads a representation of a Unicode character string encoded
   in modified UTF-8 format; this string of characters is
   then returned as a String.

    First, two bytes are read and used to construct an unsigned
   16-bit integer in the manner of the
   readUnsignedShort method, using network byte order
   (regardless of the current byte order setting). This integer
   value is called the UTF length and specifies the number
   of additional bytes to be read. These bytes are then converted
   to characters by considering them in groups. The length of each
   group is computed from the value of the first byte of the
   group. The byte following a group, if any, is the first byte of
   the next group.

    If the first byte of a group matches the bit pattern
   0xxxxxxx (where x means `may be
   0 or 1`), then the group consists of
   just that byte. The byte is zero-extended to form a character.

    If the first byte of a group matches the bit pattern
   110xxxxx, then the group consists of that byte
   a and a second byte b. If there is no
   byte b (because byte a was the last
   of the bytes to be read), or if byte b does not
   match the bit pattern 10xxxxxx, then a
   UTFDataFormatException is thrown. Otherwise, the
   group is converted to the character:



   (char)(((a& 0x1F) << 6) | (b & 0x3F))

   If the first byte of a group matches the bit pattern
   1110xxxx, then the group consists of that byte
   a and two more bytes b and
   c.  If there is no byte c (because
   byte a was one of the last two of the bytes to be
   read), or either byte b or byte c
   does not match the bit pattern 10xxxxxx, then a
   UTFDataFormatException is thrown. Otherwise, the
   group is converted to the character:



   (char)(((a & 0x0F) << 12) | ((b & 0x3F) << 6) | (c & 0x3F))

   If the first byte of a group matches the pattern
   1111xxxx or the pattern 10xxxxxx,
   then a UTFDataFormatException is thrown.

    If end of file is encountered at any time during this
   entire process, then an java.io.EOFException is thrown.

    After every group has been converted to a character by this
   process, the characters are gathered, in the same order in
   which their corresponding groups were read from the input
   stream, to form a String, which is returned.

    The current byte order setting is ignored.

    The bit offset within the stream is reset to zero before
   the read occurs.

   Note: This method should not be used in
   the  implementation of image formats that use standard UTF-8,
   because  the modified UTF-8 used here is incompatible with
   standard UTF-8.

  returns: a String read from the stream. - `java.lang.String`

  throws: java.io.EOFException - if this stream reaches the end before reading all the bytes."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.readUTF))))

(defn read-bits
  "Reads a bitstring from the stream and returns it as a
   long, with the first bit read becoming the most
   significant bit of the output.  The read starts within the byte
   indicated by getStreamPosition, at the bit given
   by getBitOffset.  The bit offset is advanced by
   numBits and reduced modulo 8.

    The byte order of the stream has no effect on this
   method.  The return value of this method is constructed as
   though the bits were read one at a time, and shifted into
   the right side of the return value, as shown by the following
   pseudo-code:



   long accum = 0L;
   for (int i = 0; i < numBits; i++) {
     accum <<= 1; // Shift left one bit to make room
     accum |= readBit();
   }

   Note that the result of readBits(32) may thus not
   be equal to that of readInt() if a reverse network
   byte order is being used (i.e., getByteOrder() ==
   false).

    If the end of the stream is encountered before all the bits
   have been read, an java.io.EOFException is thrown.

  num-bits - the number of bits to read, as an int between 0 and 64, inclusive. - `int`

  returns: the bitstring, as a long with the last bit
   read stored in the least significant bit. - `long`

  throws: java.lang.IllegalArgumentException - if numBits is not between 0 and 64, inclusive."
  ([^javax.imageio.stream.ImageInputStream this ^Integer num-bits]
    (-> this (.readBits num-bits))))

(defn mark
  "Marks a position in the stream to be returned to by a
   subsequent call to reset.  Unlike a standard
   InputStream, all ImageInputStreams
   support marking.  Additionally, calls to mark and
   reset may be nested arbitrarily.

    Unlike the mark methods declared by the
   Reader and InputStream interfaces, no
   readLimit parameter is used.  An arbitrary amount
   of data may be read following the call to mark.

    The bit position used by the readBits method
   is saved and restored by each pair of calls to
   mark and reset.

    Note that it is valid for an ImageReader to call
   flushBefore as part of a read operation.
   Therefore, if an application calls mark prior to
   passing that stream to an ImageReader, the application
   should not assume that the marked position will remain valid after
   the read operation has completed."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.mark))))

(defn read-double
  "Reads 8 bytes from the stream, and (conceptually) concatenates
   them according to the current byte order and returns the result
   as a double.

    The bit offset within the stream is reset to zero before
   the read occurs.

  returns: a double value from the stream. - `double`

  throws: java.io.EOFException - if the stream reaches the end before reading all the bytes."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.readDouble))))

(defn get-flushed-position
  "Returns the earliest position in the stream to which seeking
   may be performed.  The returned value will be the maximum of
   all values passed into previous calls to
   flushBefore.

  returns: the earliest legal position for seeking, as a
   long. - `long`"
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.getFlushedPosition))))

(defn read-unsigned-int
  "Reads 4 bytes from the stream, and (conceptually) concatenates
   them according to the current byte order, converts the result
   to a long, masks it with 0xffffffffL in order to
   strip off any sign-extension bits, and returns the result as an
   unsigned long value.

    The bit offset within the stream is reset to zero before
   the read occurs.

  returns: an unsigned int value from the stream, as a long. - `long`

  throws: java.io.EOFException - if the stream reaches the end before reading all the bytes."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.readUnsignedInt))))

(defn cached?
  "Returns true if this ImageInputStream
   caches data itself in order to allow seeking backwards.
   Applications may consult this in order to decide how frequently,
   or whether, to flush in order to conserve cache resources.

  returns: true if this ImageInputStream
   caches data. - `boolean`"
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.isCached))))

(defn read-line
  "Reads the next line of text from the input stream.  It reads
   successive bytes, converting each byte separately into a
   character, until it encounters a line terminator or end of
   file; the characters read are then returned as a
   String. Note that because this method processes
   bytes, it does not support input of the full Unicode character
   set.

    If end of file is encountered before even one byte can be
   read, then null is returned. Otherwise, each byte
   that is read is converted to type char by
   zero-extension. If the character '\n' is
   encountered, it is discarded and reading ceases. If the
   character '\r' is encountered, it is discarded
   and, if the following byte converts  to the character
   '\n', then that is discarded also; reading then
   ceases. If end of file is encountered before either of the
   characters '\n' and '\r' is
   encountered, reading ceases. Once reading has ceased, a
   String is returned that contains all the
   characters read and not discarded, taken in order.  Note that
   every character in this string will have a value less than
   \u0100, that is, (char)256.

    The bit offset within the stream is reset to zero before
   the read occurs.

  returns: a String containing a line of text from the stream. - `java.lang.String`

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.readLine))))

(defn read-unsigned-short
  "Reads two bytes from the stream, and (conceptually)
   concatenates them according to the current byte order, converts
   the resulting value to an int, masks it with
   0xffff in order to strip off any sign-extension
   buts, and returns the result as an unsigned int
   value.

    The bit offset within the stream is reset to zero before
   the read occurs.

  returns: an unsigned short value from the stream, as an int. - `int`

  throws: java.io.EOFException - if the stream reaches the end before reading all the bytes."
  ([^javax.imageio.stream.ImageInputStream this]
    (-> this (.readUnsignedShort))))

