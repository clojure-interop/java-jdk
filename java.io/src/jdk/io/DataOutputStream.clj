(ns jdk.io.DataOutputStream
  "A data output stream lets an application write primitive Java data
  types to an output stream in a portable way. An application can
  then use a data input stream to read the data back in."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io DataOutputStream]))

(defn ->data-output-stream
  "Constructor.

  Creates a new data output stream to write data to the specified
   underlying output stream. The counter written is
   set to zero.

  out - the underlying output stream, to be saved for later use. - `java.io.OutputStream`"
  ([out]
    (new DataOutputStream out)))

(defn write-utf
  "Writes a string to the underlying output stream using
   modified UTF-8
   encoding in a machine-independent manner.

   First, two bytes are written to the output stream as if by the
   writeShort method giving the number of bytes to
   follow. This value is the number of bytes actually written out,
   not the length of the string. Following the length, each character
   of the string is output, in sequence, using the modified UTF-8 encoding
   for the character. If no exception is thrown, the counter
   written is incremented by the total number of
   bytes written to the output stream. This will be at least two
   plus the length of str, and at most two plus
   thrice the length of str.

  str - a string to be written. - `java.lang.String`

  throws: java.io.IOException - if an I/O error occurs."
  ([this str]
    (-> this (.writeUTF str))))

(defn write-bytes
  "Writes out the string to the underlying output stream as a
   sequence of bytes. Each character in the string is written out, in
   sequence, by discarding its high eight bits. If no exception is
   thrown, the counter written is incremented by the
   length of s.

  s - a string of bytes to be written. - `java.lang.String`

  throws: java.io.IOException - if an I/O error occurs."
  ([this s]
    (-> this (.writeBytes s))))

(defn write-double
  "Converts the double argument to a long using the
   doubleToLongBits method in class Double,
   and then writes that long value to the underlying
   output stream as an 8-byte quantity, high byte first. If no
   exception is thrown, the counter written is
   incremented by 8.

  v - a double value to be written. - `double`

  throws: java.io.IOException - if an I/O error occurs."
  ([this v]
    (-> this (.writeDouble v))))

(defn write-boolean
  "Writes a boolean to the underlying output stream as
   a 1-byte value. The value true is written out as the
   value (byte)1; the value false is
   written out as the value (byte)0. If no exception is
   thrown, the counter written is incremented by
   1.

  v - a boolean value to be written. - `boolean`

  throws: java.io.IOException - if an I/O error occurs."
  ([this v]
    (-> this (.writeBoolean v))))

(defn flush
  "Flushes this data output stream. This forces any buffered output
   bytes to be written out to the stream.

   The flush method of DataOutputStream
   calls the flush method of its underlying output stream.

  throws: java.io.IOException - if an I/O error occurs."
  ([this]
    (-> this (.flush))))

(defn write-long
  "Writes a long to the underlying output stream as eight
   bytes, high byte first. In no exception is thrown, the counter
   written is incremented by 8.

  v - a long to be written. - `long`

  throws: java.io.IOException - if an I/O error occurs."
  ([this v]
    (-> this (.writeLong v))))

(defn write-short
  "Writes a short to the underlying output stream as two
   bytes, high byte first. If no exception is thrown, the counter
   written is incremented by 2.

  v - a short to be written. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this v]
    (-> this (.writeShort v))))

(defn write-int
  "Writes an int to the underlying output stream as four
   bytes, high byte first. If no exception is thrown, the counter
   written is incremented by 4.

  v - an int to be written. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this v]
    (-> this (.writeInt v))))

(defn write-float
  "Converts the float argument to an int using the
   floatToIntBits method in class Float,
   and then writes that int value to the underlying
   output stream as a 4-byte quantity, high byte first. If no
   exception is thrown, the counter written is
   incremented by 4.

  v - a float value to be written. - `float`

  throws: java.io.IOException - if an I/O error occurs."
  ([this v]
    (-> this (.writeFloat v))))

(defn write-chars
  "Writes a string to the underlying output stream as a sequence of
   characters. Each character is written to the data output stream as
   if by the writeChar method. If no exception is
   thrown, the counter written is incremented by twice
   the length of s.

  s - a String value to be written. - `java.lang.String`

  throws: java.io.IOException - if an I/O error occurs."
  ([this s]
    (-> this (.writeChars s))))

(defn size
  "Returns the current value of the counter written,
   the number of bytes written to this data output stream so far.
   If the counter overflows, it will be wrapped to Integer.MAX_VALUE.

  returns: the value of the written field. - `int`"
  ([this]
    (-> this (.size))))

(defn write-char
  "Writes a char to the underlying output stream as a
   2-byte value, high byte first. If no exception is thrown, the
   counter written is incremented by 2.

  v - a char value to be written. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this v]
    (-> this (.writeChar v))))

(defn write-byte
  "Writes out a byte to the underlying output stream as
   a 1-byte value. If no exception is thrown, the counter
   written is incremented by 1.

  v - a byte value to be written. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this v]
    (-> this (.writeByte v))))

(defn write
  "Writes len bytes from the specified byte array
   starting at offset off to the underlying output stream.
   If no exception is thrown, the counter written is
   incremented by len.

  b - the data. - `byte[]`
  off - the start offset in the data. - `int`
  len - the number of bytes to write. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this b off len]
    (-> this (.write b off len)))
  ([this b]
    (-> this (.write b))))

