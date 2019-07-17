(ns javax.imageio.stream.ImageOutputStreamImpl
  "An abstract class implementing the ImageOutputStream interface.
  This class is designed to reduce the number of methods that must
  be implemented by subclasses."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.stream ImageOutputStreamImpl]))

(defn ->image-output-stream-impl
  "Constructor.

  Constructs an ImageOutputStreamImpl."
  ([]
    (new ImageOutputStreamImpl )))

(defn write-utf
  "Description copied from interface: ImageOutputStream

  s - a String containing the value to be written. - `java.lang.String`

  throws: java.io.UTFDataFormatException - if the modified UTF-8 representation of s requires more than 65536 bytes."
  ([this s]
    (-> this (.writeUTF s))))

(defn write-bytes
  "Description copied from interface: ImageOutputStream

  s - a String containing the value to be written. - `java.lang.String`

  throws: java.io.IOException - if an I/O error occurs."
  ([this s]
    (-> this (.writeBytes s))))

(defn write-double
  "Description copied from interface: ImageOutputStream

  v - a double containing the value to be written. - `double`

  throws: java.io.IOException - if an I/O error occurs."
  ([this v]
    (-> this (.writeDouble v))))

(defn write-doubles
  "Description copied from interface: ImageOutputStream

  d - an array of doubless to be written. - `double[]`
  off - the start offset in the data. - `int`
  len - the number of doubles to write. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this d off len]
    (-> this (.writeDoubles d off len))))

(defn write-boolean
  "Description copied from interface: ImageOutputStream

  v - the boolean to be written. - `boolean`

  throws: java.io.IOException - if an I/O error occurs."
  ([this v]
    (-> this (.writeBoolean v))))

(defn write-long
  "Description copied from interface: ImageOutputStream

  v - a long containing the value to be written. - `long`

  throws: java.io.IOException - if an I/O error occurs."
  ([this v]
    (-> this (.writeLong v))))

(defn write-short
  "Description copied from interface: ImageOutputStream

  v - an int containing the short value to be written. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this v]
    (-> this (.writeShort v))))

(defn write-floats
  "Description copied from interface: ImageOutputStream

  f - an array of floats to be written. - `float[]`
  off - the start offset in the data. - `int`
  len - the number of floats to write. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this f off len]
    (-> this (.writeFloats f off len))))

(defn write-shorts
  "Description copied from interface: ImageOutputStream

  s - an array of shorts to be written. - `short[]`
  off - the start offset in the data. - `int`
  len - the number of shorts to write. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this s off len]
    (-> this (.writeShorts s off len))))

(defn write-longs
  "Description copied from interface: ImageOutputStream

  l - an array of longs to be written. - `long[]`
  off - the start offset in the data. - `int`
  len - the number of longs to write. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this l off len]
    (-> this (.writeLongs l off len))))

(defn write-bit
  "Description copied from interface: ImageOutputStream

  bit - an int whose least significant bit is to be written to the stream. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this bit]
    (-> this (.writeBit bit))))

(defn write-int
  "Description copied from interface: ImageOutputStream

  v - an int containing the value to be written. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this v]
    (-> this (.writeInt v))))

(defn write-float
  "Description copied from interface: ImageOutputStream

  v - a float containing the value to be written. - `float`

  throws: java.io.IOException - if an I/O error occurs."
  ([this v]
    (-> this (.writeFloat v))))

(defn write-chars
  "Description copied from interface: ImageOutputStream

  c - an array of chars to be written. - `char[]`
  off - the start offset in the data. - `int`
  len - the number of chars to write. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this c off len]
    (-> this (.writeChars c off len)))
  ([this s]
    (-> this (.writeChars s))))

(defn write-char
  "Description copied from interface: ImageOutputStream

  v - an int containing the char (unsigned short) value to be written. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this v]
    (-> this (.writeChar v))))

(defn write-byte
  "Description copied from interface: ImageOutputStream

  v - an int containing the byte value to be written. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this v]
    (-> this (.writeByte v))))

(defn write-bits
  "Description copied from interface: ImageOutputStream

  bits - a long containing the bits to be written, starting with the bit in position numBits - 1 down to the least significant bit. - `long`
  num-bits - an int between 0 and 64, inclusive. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this bits num-bits]
    (-> this (.writeBits bits num-bits))))

(defn write-ints
  "Description copied from interface: ImageOutputStream

  i - an array of ints to be written. - `int[]`
  off - the start offset in the data. - `int`
  len - the number of ints to write. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this i off len]
    (-> this (.writeInts i off len))))

(defn write
  "Description copied from interface: ImageOutputStream

  b - an array of bytes to be written. - `byte[]`
  off - the start offset in the data. - `int`
  len - the number of bytes to write. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this b off len]
    (-> this (.write b off len)))
  ([this b]
    (-> this (.write b))))

