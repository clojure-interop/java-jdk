(ns javax.imageio.stream.ImageOutputStream
  "A seekable output stream interface for use by
  ImageWriters.  Various output destinations, such as
  OutputStreams and Files, as well as
  future fast I/O destinations may be `wrapped` by a suitable
  implementation of this interface for use by the Image I/O API.

   Unlike a standard OutputStream, ImageOutputStream
  extends its counterpart, ImageInputStream.  Thus it is
  possible to read from the stream as it is being written.  The same
  seek and flush positions apply to both reading and writing, although
  the semantics for dealing with a non-zero bit offset before a byte-aligned
  write are necessarily different from the semantics for dealing with
  a non-zero bit offset before a byte-aligned read.  When reading bytes,
  any bit offset is set to 0 before the read; when writing bytes, a
  non-zero bit offset causes the remaining bits in the byte to be written
  as 0s.  The byte-aligned write then starts at the next byte position."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.stream ImageOutputStream]))

(defn write-utf
  "Writes two bytes of length information to the output stream in
   network byte order, followed by the
   modified
   UTF-8
   representation of every character in the string s.
   If s is null, a
   NullPointerException is thrown.  Each character in
   the string s is converted to a group of one, two,
   or three bytes, depending on the value of the character.

    If a character c is in the range
   \u0001 through \u007f, it is
   represented by one byte:



   (byte)c

    If a character c is \u0000 or
   is in the range \u0080 through
   \u07ff, then it is represented by two bytes,
   to be written in the order shown:



   (byte)(0xc0 | (0x1f & (c >> 6)))
   (byte)(0x80 | (0x3f & c))

    If a character c is in the range
   \u0800 through uffff, then it is
   represented by three bytes, to be written in the order shown:



   (byte)(0xe0 | (0x0f & (c >> 12)))
   (byte)(0x80 | (0x3f & (c >> 6)))
   (byte)(0x80 | (0x3f & c))

    First, the total number of bytes needed to represent all
   the characters of s is calculated. If this number
   is larger than 65535, then a
   UTFDataFormatException is thrown. Otherwise, this
   length is written to the output stream in exactly the manner of
   the writeShort method; after this, the one-, two-,
   or three-byte representation of each character in the string
   s is written.

    The current byte order setting is ignored.

    If the bit offset within the stream is non-zero, the
   remainder of the current byte is padded with 0s
   and written out first.  The bit offset will be 0 after the
   write.

   Note: This method should not be used in
   the  implementation of image formats that use standard UTF-8,
   because  the modified UTF-8 used here is incompatible with
   standard UTF-8.

  s - a String containing the value to be written. - `java.lang.String`

  throws: java.lang.NullPointerException - if s is null."
  ([^ImageOutputStream this ^java.lang.String s]
    (-> this (.writeUTF s))))

(defn write-bytes
  "Writes a string to the output stream. For every character in
   the string s, taken in order, one byte is written
   to the output stream. If s is null, a
   NullPointerException is thrown.

    If s.length is zero, then no bytes are
   written. Otherwise, the character s[0] is written
   first, then s[1], and so on; the last character
   written is s[s.length-1]. For each character, one
   byte is written, the low-order byte, in exactly the manner of
   the writeByte method. The high-order eight bits of
   each character in the string are ignored.

    If the bit offset within the stream is non-zero, the
   remainder of the current byte is padded with 0s
   and written out first.  The bit offset will be 0 after the
   write.

  s - a String containing the value to be written. - `java.lang.String`

  throws: java.lang.NullPointerException - if s is null."
  ([^ImageOutputStream this ^java.lang.String s]
    (-> this (.writeBytes s))))

(defn write-double
  "Writes a double value, which is comprised of four
   bytes, to the output stream. It does this as if it first
   converts this double value to an long
   in exactly the manner of the
   Double.doubleToLongBits method and then writes the
   long value in exactly the manner of the writeLong
   method.

    If the bit offset within the stream is non-zero, the
   remainder of the current byte is padded with 0s
   and written out first.  The bit offset will be 0 after the
   write.

  v - a double containing the value to be written. - `double`

  throws: java.io.IOException - if an I/O error occurs."
  ([^ImageOutputStream this ^Double v]
    (-> this (.writeDouble v))))

(defn write-doubles
  "Writes a sequence of doubles to the stream at the current
   position.  If len is 0, nothing is written.
   The double d[off] is written first, then the double
   d[off  1], and so on.  The byte order of the
   stream is used to determine the order in which the individual
   bytes are written.

    If the bit offset within the stream is non-zero, the
   remainder of the current byte is padded with 0s
   and written out first.  The bit offset will be 0 after the
   write.

  d - an array of doubless to be written. - `double[]`
  off - the start offset in the data. - `int`
  len - the number of doubles to write. - `int`

  throws: java.lang.IndexOutOfBoundsException - if off is negative, len is negative, or off len is greater than d.length."
  ([^ImageOutputStream this d ^Integer off ^Integer len]
    (-> this (.writeDoubles d off len))))

(defn write-boolean
  "Writes a boolean value to the stream.  If
   v is true, the value (byte)1 is
   written; if v is false, the value
   (byte)0 is written.

    If the bit offset within the stream is non-zero, the
   remainder of the current byte is padded with 0s
   and written out first.  The bit offset will be 0 after the
   write.

  v - the boolean to be written. - `boolean`

  throws: java.io.IOException - if an I/O error occurs."
  ([^ImageOutputStream this ^Boolean v]
    (-> this (.writeBoolean v))))

(defn flush-before
  "Flushes all data prior to the given position to the underlying
   destination, such as an OutputStream or
   File.  Attempting to seek to the flushed portion
   of the stream will result in an
   IndexOutOfBoundsException.

  pos - a long containing the length of the stream prefix that may be flushed to the destination. - `long`

  throws: java.lang.IndexOutOfBoundsException - if pos lies in the flushed portion of the stream or past the current stream position."
  ([^ImageOutputStream this ^Long pos]
    (-> this (.flushBefore pos))))

(defn write-long
  "Writes the 64 bits of v to the stream.  If the
   stream uses network byte order, the bytes written, in order,
   will be:



   (byte)((v >> 56) & 0xff)
   (byte)((v >> 48) & 0xff)
   (byte)((v >> 40) & 0xff)
   (byte)((v >> 32) & 0xff)
   (byte)((v >> 24) & 0xff)
   (byte)((v >> 16) & 0xff)
   (byte)((v >> 8) & 0xff)
   (byte)(v & 0xff)

   Otherwise, the bytes written will be:



   (byte)(v & 0xff)
   (byte)((v >> 8) & 0xff)
   (byte)((v >> 16) & 0xff)
   (byte)((v >> 24) & 0xff)
   (byte)((v >> 32) & 0xff)
   (byte)((v >> 40) & 0xff)
   (byte)((v >> 48) & 0xff)
   (byte)((v >> 56) & 0xff)

    If the bit offset within the stream is non-zero, the
   remainder of the current byte is padded with 0s
   and written out first.  The bit offset will be 0 after the
   write.

  v - a long containing the value to be written. - `long`

  throws: java.io.IOException - if an I/O error occurs."
  ([^ImageOutputStream this ^Long v]
    (-> this (.writeLong v))))

(defn write-short
  "Writes the 16 low-order bits of v to the
   stream. The 16 high-order bits of v are ignored.
   If the stream uses network byte order, the bytes written, in
   order, will be:



   (byte)((v >> 8) & 0xff)
   (byte)(v & 0xff)

   Otherwise, the bytes written will be:



   (byte)(v & 0xff)
   (byte)((v >> 8) & 0xff)

    If the bit offset within the stream is non-zero, the
   remainder of the current byte is padded with 0s
   and written out first.  The bit offset will be 0 after the
   write.

  v - an int containing the short value to be written. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^ImageOutputStream this ^Integer v]
    (-> this (.writeShort v))))

(defn write-floats
  "Writes a sequence of floats to the stream at the current
   position.  If len is 0, nothing is written.
   The float f[off] is written first, then the float
   f[off  1], and so on.  The byte order of the
   stream is used to determine the order in which the individual
   bytes are written.

    If the bit offset within the stream is non-zero, the
   remainder of the current byte is padded with 0s
   and written out first.  The bit offset will be 0 after the
   write.

  f - an array of floats to be written. - `float[]`
  off - the start offset in the data. - `int`
  len - the number of floats to write. - `int`

  throws: java.lang.IndexOutOfBoundsException - if off is negative, len is negative, or off len is greater than f.length."
  ([^ImageOutputStream this f ^Integer off ^Integer len]
    (-> this (.writeFloats f off len))))

(defn write-shorts
  "Writes a sequence of shorts to the stream at the current
   position.  If len is 0, nothing is written.
   The short s[off] is written first, then the short
   s[off  1], and so on.  The byte order of the
   stream is used to determine the order in which the individual
   bytes are written.

    If the bit offset within the stream is non-zero, the
   remainder of the current byte is padded with 0s
   and written out first.  The bit offset will be 0 after the
   write.

  s - an array of shorts to be written. - `short[]`
  off - the start offset in the data. - `int`
  len - the number of shorts to write. - `int`

  throws: java.lang.IndexOutOfBoundsException - if off is negative, len is negative, or off len is greater than s.length."
  ([^ImageOutputStream this s ^Integer off ^Integer len]
    (-> this (.writeShorts s off len))))

(defn write-longs
  "Writes a sequence of longs to the stream at the current
   position.  If len is 0, nothing is written.
   The long l[off] is written first, then the long
   l[off  1], and so on.  The byte order of the
   stream is used to determine the order in which the individual
   bytes are written.

    If the bit offset within the stream is non-zero, the
   remainder of the current byte is padded with 0s
   and written out first.  The bit offset will be 0 after the
   write.

  l - an array of longs to be written. - `long[]`
  off - the start offset in the data. - `int`
  len - the number of longs to write. - `int`

  throws: java.lang.IndexOutOfBoundsException - if off is negative, len is negative, or off len is greater than l.length."
  ([^ImageOutputStream this l ^Integer off ^Integer len]
    (-> this (.writeLongs l off len))))

(defn write-bit
  "Writes a single bit, given by the least significant bit of the
   argument, to the stream at the current bit offset within the
   current byte position.  The upper 31 bits of the argument are
   ignored.  The given bit replaces the previous bit at that
   position.  The bit offset is advanced by one and reduced modulo
   8.

    If any bits of a particular byte have never been set
   at the time the byte is flushed to the destination, those
   bits will be set to 0 automatically.

  bit - an int whose least significant bit is to be written to the stream. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^ImageOutputStream this ^Integer bit]
    (-> this (.writeBit bit))))

(defn write-int
  "Writes the 32 bits of v to the stream.  If the
   stream uses network byte order, the bytes written, in order,
   will be:



   (byte)((v >> 24) & 0xff)
   (byte)((v >> 16) & 0xff)
   (byte)((v >> 8) & 0xff)
   (byte)(v & 0xff)

   Otheriwse, the bytes written will be:



   (byte)(v & 0xff)
   (byte)((v >> 8) & 0xff)
   (byte)((v >> 16) & 0xff)
   (byte)((v >> 24) & 0xff)

    If the bit offset within the stream is non-zero, the
   remainder of the current byte is padded with 0s
   and written out first.  The bit offset will be 0 after the
   write.

  v - an int containing the value to be written. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^ImageOutputStream this ^Integer v]
    (-> this (.writeInt v))))

(defn write-float
  "Writes a float value, which is comprised of four
   bytes, to the output stream. It does this as if it first
   converts this float value to an int
   in exactly the manner of the Float.floatToIntBits
   method and then writes the int value in exactly the manner of
   the writeInt method.

    If the bit offset within the stream is non-zero, the
   remainder of the current byte is padded with 0s
   and written out first.  The bit offset will be 0 after the
   write.

  v - a float containing the value to be written. - `float`

  throws: java.io.IOException - if an I/O error occurs."
  ([^ImageOutputStream this ^Float v]
    (-> this (.writeFloat v))))

(defn write-chars
  "Writes a sequence of chars to the stream at the current
   position.  If len is 0, nothing is written.
   The char c[off] is written first, then the char
   c[off  1], and so on.  The byte order of the
   stream is used to determine the order in which the individual
   bytes are written.

    If the bit offset within the stream is non-zero, the
   remainder of the current byte is padded with 0s
   and written out first.  The bit offset will be 0 after the
   write.

  c - an array of chars to be written. - `char[]`
  off - the start offset in the data. - `int`
  len - the number of chars to write. - `int`

  throws: java.lang.IndexOutOfBoundsException - if off is negative, len is negative, or off len is greater than c.length."
  ([^ImageOutputStream this c ^Integer off ^Integer len]
    (-> this (.writeChars c off len)))
  ([^ImageOutputStream this ^java.lang.String s]
    (-> this (.writeChars s))))

(defn write-char
  "This method is a synonym for writeShort.

  v - an int containing the char (unsigned short) value to be written. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^ImageOutputStream this ^Integer v]
    (-> this (.writeChar v))))

(defn write-byte
  "Writes the 8 low-order bits of v to the
   stream. The 24 high-order bits of v are ignored.
   (This means that writeByte does exactly the same
   thing as write for an integer argument.)

    If the bit offset within the stream is non-zero, the
   remainder of the current byte is padded with 0s
   and written out first.  The bit offset will be 0 after the
   write.

  v - an int containing the byte value to be written. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^ImageOutputStream this ^Integer v]
    (-> this (.writeByte v))))

(defn write-bits
  "Writes a sequence of bits, given by the numBits
   least significant bits of the bits argument in
   left-to-right order, to the stream at the current bit offset
   within the current byte position.  The upper 64 -
   numBits bits of the argument are ignored.  The bit
   offset is advanced by numBits and reduced modulo
   8.  Note that a bit offset of 0 always indicates the
   most-significant bit of the byte, and bytes of bits are written
   out in sequence as they are encountered.  Thus bit writes are
   always effectively in network byte order.  The actual stream
   byte order setting is ignored.

    Bit data may be accumulated in memory indefinitely, until
   flushBefore is called.  At that time, all bit data
   prior to the flushed position will be written.

    If any bits of a particular byte have never been set
   at the time the byte is flushed to the destination, those
   bits will be set to 0 automatically.

  bits - a long containing the bits to be written, starting with the bit in position numBits - 1 down to the least significant bit. - `long`
  num-bits - an int between 0 and 64, inclusive. - `int`

  throws: java.lang.IllegalArgumentException - if numBits is not between 0 and 64, inclusive."
  ([^ImageOutputStream this ^Long bits ^Integer num-bits]
    (-> this (.writeBits bits num-bits))))

(defn write-ints
  "Writes a sequence of ints to the stream at the current
   position.  If len is 0, nothing is written.
   The int i[off] is written first, then the int
   i[off  1], and so on.  The byte order of the
   stream is used to determine the order in which the individual
   bytes are written.

    If the bit offset within the stream is non-zero, the
   remainder of the current byte is padded with 0s
   and written out first.  The bit offset will be 0 after the
   write.

  i - an array of ints to be written. - `int[]`
  off - the start offset in the data. - `int`
  len - the number of ints to write. - `int`

  throws: java.lang.IndexOutOfBoundsException - if off is negative, len is negative, or off len is greater than i.length."
  ([^ImageOutputStream this i ^Integer off ^Integer len]
    (-> this (.writeInts i off len))))

(defn write
  "Writes a sequence of bytes to the stream at the current
   position.  If len is 0, nothing is written.
   The byte b[off] is written first, then the byte
   b[off  1], and so on.

    If the bit offset within the stream is non-zero, the
   remainder of the current byte is padded with 0s
   and written out first.  The bit offset will be 0 after the
   write.  Implementers can use the
   flushBits
   method of ImageOutputStreamImpl
   to guarantee this.

  b - an array of bytes to be written. - `byte[]`
  off - the start offset in the data. - `int`
  len - the number of bytes to write. - `int`

  throws: java.lang.IndexOutOfBoundsException - if off is negative, len is negative, or off len is greater than b.length."
  ([^ImageOutputStream this b ^Integer off ^Integer len]
    (-> this (.write b off len)))
  ([^ImageOutputStream this ^Integer b]
    (-> this (.write b))))

