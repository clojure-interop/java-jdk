(ns jdk.io.RandomAccessFile
  "Instances of this class support both reading and writing to a
  random access file. A random access file behaves like a large
  array of bytes stored in the file system. There is a kind of cursor,
  or index into the implied array, called the file pointer;
  input operations read bytes starting at the file pointer and advance
  the file pointer past the bytes read. If the random access file is
  created in read/write mode, then output operations are also available;
  output operations write bytes starting at the file pointer and advance
  the file pointer past the bytes written. Output operations that write
  past the current end of the implied array cause the array to be
  extended. The file pointer can be read by the
  getFilePointer method and set by the seek
  method.

  It is generally true of all the reading routines in this class that
  if end-of-file is reached before the desired number of bytes has been
  read, an EOFException (which is a kind of
  IOException) is thrown. If any byte cannot be read for
  any reason other than end-of-file, an IOException other
  than EOFException is thrown. In particular, an
  IOException may be thrown if the stream has been closed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io RandomAccessFile]))

(defn ->random-access-file
  "Constructor.

  Creates a random access file stream to read from, and optionally
   to write to, a file with the specified name. A new
   FileDescriptor object is created to represent the
   connection to the file.

    The mode argument specifies the access mode with which the
   file is to be opened.  The permitted values and their meanings are as
   specified for the RandomAccessFile(File,String) constructor.


   If there is a security manager, its checkRead method
   is called with the name argument
   as its argument to see if read access to the file is allowed.
   If the mode allows writing, the security manager's
   checkWrite method
   is also called with the name argument
   as its argument to see if write access to the file is allowed.

  name - the system-dependent filename - `java.lang.String`
  mode - the access mode - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the mode argument is not equal to one of \"r\", \"rw\", \"rws\", or \"rwd\""
  (^RandomAccessFile [^java.lang.String name ^java.lang.String mode]
    (new RandomAccessFile name mode)))

(defn read-unsigned-byte
  "Reads an unsigned eight-bit number from this file. This method reads
   a byte from this file, starting at the current file pointer,
   and returns that byte.

   This method blocks until the byte is read, the end of the stream
   is detected, or an exception is thrown.

  returns: the next byte of this file, interpreted as an unsigned
               eight-bit number. - `int`

  throws: java.io.EOFException - if this file has reached the end."
  (^Integer [^RandomAccessFile this]
    (-> this (.readUnsignedByte))))

(defn write-utf
  "Writes a string to the file using
   modified UTF-8
   encoding in a machine-independent manner.

   First, two bytes are written to the file, starting at the
   current file pointer, as if by the
   writeShort method giving the number of bytes to
   follow. This value is the number of bytes actually written out,
   not the length of the string. Following the length, each character
   of the string is output, in sequence, using the modified UTF-8 encoding
   for each character.

  str - a string to be written. - `java.lang.String`

  throws: java.io.IOException - if an I/O error occurs."
  ([^RandomAccessFile this ^java.lang.String str]
    (-> this (.writeUTF str))))

(defn get-fd
  "Returns the opaque file descriptor object associated with this
   stream.

  returns: the file descriptor object associated with this stream. - `java.io.FileDescriptor`

  throws: java.io.IOException - if an I/O error occurs."
  (^java.io.FileDescriptor [^RandomAccessFile this]
    (-> this (.getFD))))

(defn read-byte
  "Reads a signed eight-bit value from this file. This method reads a
   byte from the file, starting from the current file pointer.
   If the byte read is b, where
   0 <= b <= 255,
   then the result is:


       (byte)(b)

   This method blocks until the byte is read, the end of the stream
   is detected, or an exception is thrown.

  returns: the next byte of this file as a signed eight-bit
               byte. - `byte`

  throws: java.io.EOFException - if this file has reached the end."
  (^Byte [^RandomAccessFile this]
    (-> this (.readByte))))

(defn read-fully
  "Reads exactly len bytes from this file into the byte
   array, starting at the current file pointer. This method reads
   repeatedly from the file until the requested number of bytes are
   read. This method blocks until the requested number of bytes are
   read, the end of the stream is detected, or an exception is thrown.

  b - the buffer into which the data is read. - `byte[]`
  off - the start offset of the data. - `int`
  len - the number of bytes to read. - `int`

  throws: java.io.EOFException - if this file reaches the end before reading all the bytes."
  ([^RandomAccessFile this b ^Integer off ^Integer len]
    (-> this (.readFully b off len)))
  ([^RandomAccessFile this b]
    (-> this (.readFully b))))

(defn read-char
  "Reads a character from this file. This method reads two
   bytes from the file, starting at the current file pointer.
   If the bytes read, in order, are
   b1 and b2, where
   0 <= b1, b2 <= 255,
   then the result is equal to:


       (char)((b1 << 8) | b2)

   This method blocks until the two bytes are read, the end of the
   stream is detected, or an exception is thrown.

  returns: the next two bytes of this file, interpreted as a
                    char. - `char`

  throws: java.io.EOFException - if this file reaches the end before reading two bytes."
  (^Character [^RandomAccessFile this]
    (-> this (.readChar))))

(defn write-bytes
  "Writes the string to the file as a sequence of bytes. Each
   character in the string is written out, in sequence, by discarding
   its high eight bits. The write starts at the current position of
   the file pointer.

  s - a string of bytes to be written. - `java.lang.String`

  throws: java.io.IOException - if an I/O error occurs."
  ([^RandomAccessFile this ^java.lang.String s]
    (-> this (.writeBytes s))))

(defn write-double
  "Converts the double argument to a long using the
   doubleToLongBits method in class Double,
   and then writes that long value to the file as an
   eight-byte quantity, high byte first. The write starts at the current
   position of the file pointer.

  v - a double value to be written. - `double`

  throws: java.io.IOException - if an I/O error occurs."
  ([^RandomAccessFile this ^Double v]
    (-> this (.writeDouble v))))

(defn get-file-pointer
  "Returns the current offset in this file.

  returns: the offset from the beginning of the file, in bytes,
               at which the next read or write occurs. - `long`

  throws: java.io.IOException - if an I/O error occurs."
  (^Long [^RandomAccessFile this]
    (-> this (.getFilePointer))))

(defn read-float
  "Reads a float from this file. This method reads an
   int value, starting at the current file pointer,
   as if by the readInt method
   and then converts that int to a float
   using the intBitsToFloat method in class
   Float.

   This method blocks until the four bytes are read, the end of the
   stream is detected, or an exception is thrown.

  returns: the next four bytes of this file, interpreted as a
               float. - `float`

  throws: java.io.EOFException - if this file reaches the end before reading four bytes."
  (^Float [^RandomAccessFile this]
    (-> this (.readFloat))))

(defn write-boolean
  "Writes a boolean to the file as a one-byte value. The
   value true is written out as the value
   (byte)1; the value false is written out
   as the value (byte)0. The write starts at
   the current position of the file pointer.

  v - a boolean value to be written. - `boolean`

  throws: java.io.IOException - if an I/O error occurs."
  ([^RandomAccessFile this ^Boolean v]
    (-> this (.writeBoolean v))))

(defn read
  "Reads up to len bytes of data from this file into an
   array of bytes. This method blocks until at least one byte of input
   is available.

   Although RandomAccessFile is not a subclass of
   InputStream, this method behaves in exactly the
   same way as the InputStream.read(byte[], int, int) method of
   InputStream.

  b - the buffer into which the data is read. - `byte[]`
  off - the start offset in array b at which the data is written. - `int`
  len - the maximum number of bytes read. - `int`

  returns: the total number of bytes read into the buffer, or
               -1 if there is no more data because the end of
               the file has been reached. - `int`

  throws: java.io.IOException - If the first byte cannot be read for any reason other than end of file, or if the random access file has been closed, or if some other I/O error occurs."
  (^Integer [^RandomAccessFile this b ^Integer off ^Integer len]
    (-> this (.read b off len)))
  (^Integer [^RandomAccessFile this b]
    (-> this (.read b)))
  (^Integer [^RandomAccessFile this]
    (-> this (.read))))

(defn write-long
  "Writes a long to the file as eight bytes, high byte first.
   The write starts at the current position of the file pointer.

  v - a long to be written. - `long`

  throws: java.io.IOException - if an I/O error occurs."
  ([^RandomAccessFile this ^Long v]
    (-> this (.writeLong v))))

(defn write-short
  "Writes a short to the file as two bytes, high byte first.
   The write starts at the current position of the file pointer.

  v - a short to be written. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^RandomAccessFile this ^Integer v]
    (-> this (.writeShort v))))

(defn set-length
  "Sets the length of this file.

    If the present length of the file as returned by the
   length method is greater than the newLength
   argument then the file will be truncated.  In this case, if the file
   offset as returned by the getFilePointer method is greater
   than newLength then after this method returns the offset
   will be equal to newLength.

    If the present length of the file as returned by the
   length method is smaller than the newLength
   argument then the file will be extended.  In this case, the contents of
   the extended portion of the file are not defined.

  new-length - The desired length of the file - `long`

  throws: java.io.IOException - If an I/O error occurs"
  ([^RandomAccessFile this ^Long new-length]
    (-> this (.setLength new-length))))

(defn seek
  "Sets the file-pointer offset, measured from the beginning of this
   file, at which the next read or write occurs.  The offset may be
   set beyond the end of the file. Setting the offset beyond the end
   of the file does not change the file length.  The file length will
   change only by writing after the offset has been set beyond the end
   of the file.

  pos - the offset position, measured in bytes from the beginning of the file, at which to set the file pointer. - `long`

  throws: java.io.IOException - if pos is less than 0 or if an I/O error occurs."
  ([^RandomAccessFile this ^Long pos]
    (-> this (.seek pos))))

(defn read-boolean
  "Reads a boolean from this file. This method reads a
   single byte from the file, starting at the current file pointer.
   A value of 0 represents
   false. Any other value represents true.
   This method blocks until the byte is read, the end of the stream
   is detected, or an exception is thrown.

  returns: the boolean value read. - `boolean`

  throws: java.io.EOFException - if this file has reached the end."
  (^Boolean [^RandomAccessFile this]
    (-> this (.readBoolean))))

(defn read-int
  "Reads a signed 32-bit integer from this file. This method reads 4
   bytes from the file, starting at the current file pointer.
   If the bytes read, in order, are b1,
   b2, b3, and b4, where
   0 <= b1, b2, b3, b4 <= 255,
   then the result is equal to:


       (b1 << 24) | (b2 << 16)  (b3 << 8)  b4

   This method blocks until the four bytes are read, the end of the
   stream is detected, or an exception is thrown.

  returns: the next four bytes of this file, interpreted as an
               int. - `int`

  throws: java.io.EOFException - if this file reaches the end before reading four bytes."
  (^Integer [^RandomAccessFile this]
    (-> this (.readInt))))

(defn read-long
  "Reads a signed 64-bit integer from this file. This method reads eight
   bytes from the file, starting at the current file pointer.
   If the bytes read, in order, are
   b1, b2, b3,
   b4, b5, b6,
   b7, and b8, where:


       0 <= b1, b2, b3, b4, b5, b6, b7, b8 <=255,

   then the result is equal to:


       ((long)b1 << 56)  ((long)b2 << 48)
        ((long)b3 << 40)  ((long)b4 << 32)
        ((long)b5 << 24)  ((long)b6 << 16)
        ((long)b7 << 8)  b8

   This method blocks until the eight bytes are read, the end of the
   stream is detected, or an exception is thrown.

  returns: the next eight bytes of this file, interpreted as a
               long. - `long`

  throws: java.io.EOFException - if this file reaches the end before reading eight bytes."
  (^Long [^RandomAccessFile this]
    (-> this (.readLong))))

(defn length
  "Returns the length of this file.

  returns: the length of this file, measured in bytes. - `long`

  throws: java.io.IOException - if an I/O error occurs."
  (^Long [^RandomAccessFile this]
    (-> this (.length))))

(defn close
  "Closes this random access file stream and releases any system
   resources associated with the stream. A closed random access
   file cannot perform input or output operations and cannot be
   reopened.

    If this file has an associated channel then the channel is closed
   as well.

  throws: java.io.IOException - if an I/O error occurs."
  ([^RandomAccessFile this]
    (-> this (.close))))

(defn write-int
  "Writes an int to the file as four bytes, high byte first.
   The write starts at the current position of the file pointer.

  v - an int to be written. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^RandomAccessFile this ^Integer v]
    (-> this (.writeInt v))))

(defn write-float
  "Converts the float argument to an int using the
   floatToIntBits method in class Float,
   and then writes that int value to the file as a
   four-byte quantity, high byte first. The write starts at the
   current position of the file pointer.

  v - a float value to be written. - `float`

  throws: java.io.IOException - if an I/O error occurs."
  ([^RandomAccessFile this ^Float v]
    (-> this (.writeFloat v))))

(defn write-chars
  "Writes a string to the file as a sequence of characters. Each
   character is written to the data output stream as if by the
   writeChar method. The write starts at the current
   position of the file pointer.

  s - a String value to be written. - `java.lang.String`

  throws: java.io.IOException - if an I/O error occurs."
  ([^RandomAccessFile this ^java.lang.String s]
    (-> this (.writeChars s))))

(defn read-short
  "Reads a signed 16-bit number from this file. The method reads two
   bytes from this file, starting at the current file pointer.
   If the two bytes read, in order, are
   b1 and b2, where each of the two values is
   between 0 and 255, inclusive, then the
   result is equal to:


       (short)((b1 << 8) | b2)

   This method blocks until the two bytes are read, the end of the
   stream is detected, or an exception is thrown.

  returns: the next two bytes of this file, interpreted as a signed
               16-bit number. - `short`

  throws: java.io.EOFException - if this file reaches the end before reading two bytes."
  (^Short [^RandomAccessFile this]
    (-> this (.readShort))))

(defn skip-bytes
  "Attempts to skip over n bytes of input discarding the
   skipped bytes.


   This method may skip over some smaller number of bytes, possibly zero.
   This may result from any of a number of conditions; reaching end of
   file before n bytes have been skipped is only one
   possibility. This method never throws an EOFException.
   The actual number of bytes skipped is returned.  If n
   is negative, no bytes are skipped.

  n - the number of bytes to be skipped. - `int`

  returns: the actual number of bytes skipped. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  (^Integer [^RandomAccessFile this ^Integer n]
    (-> this (.skipBytes n))))

(defn write-char
  "Writes a char to the file as a two-byte value, high
   byte first. The write starts at the current position of the
   file pointer.

  v - a char value to be written. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^RandomAccessFile this ^Integer v]
    (-> this (.writeChar v))))

(defn write-byte
  "Writes a byte to the file as a one-byte value. The
   write starts at the current position of the file pointer.

  v - a byte value to be written. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^RandomAccessFile this ^Integer v]
    (-> this (.writeByte v))))

(defn read-utf
  "Reads in a string from this file. The string has been encoded
   using a
   modified UTF-8
   format.

   The first two bytes are read, starting from the current file
   pointer, as if by
   readUnsignedShort. This value gives the number of
   following bytes that are in the encoded string, not
   the length of the resulting string. The following bytes are then
   interpreted as bytes encoding characters in the modified UTF-8 format
   and are converted into characters.

   This method blocks until all the bytes are read, the end of the
   stream is detected, or an exception is thrown.

  returns: a Unicode string. - `java.lang.String`

  throws: java.io.EOFException - if this file reaches the end before reading all the bytes."
  (^java.lang.String [^RandomAccessFile this]
    (-> this (.readUTF))))

(defn read-double
  "Reads a double from this file. This method reads a
   long value, starting at the current file pointer,
   as if by the readLong method
   and then converts that long to a double
   using the longBitsToDouble method in
   class Double.

   This method blocks until the eight bytes are read, the end of the
   stream is detected, or an exception is thrown.

  returns: the next eight bytes of this file, interpreted as a
               double. - `double`

  throws: java.io.EOFException - if this file reaches the end before reading eight bytes."
  (^Double [^RandomAccessFile this]
    (-> this (.readDouble))))

(defn get-channel
  "Returns the unique FileChannel
   object associated with this file.

    The position of the returned channel will always be equal to
   this object's file-pointer offset as returned by the getFilePointer method.  Changing this object's
   file-pointer offset, whether explicitly or by reading or writing bytes,
   will change the position of the channel, and vice versa.  Changing the
   file's length via this object will change the length seen via the file
   channel, and vice versa.

  returns: the file channel associated with this file - `java.nio.channels.FileChannel`"
  (^java.nio.channels.FileChannel [^RandomAccessFile this]
    (-> this (.getChannel))))

(defn write
  "Writes len bytes from the specified byte array
   starting at offset off to this file.

  b - the data. - `byte[]`
  off - the start offset in the data. - `int`
  len - the number of bytes to write. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^RandomAccessFile this b ^Integer off ^Integer len]
    (-> this (.write b off len)))
  ([^RandomAccessFile this ^Integer b]
    (-> this (.write b))))

(defn read-line
  "Reads the next line of text from this file.  This method successively
   reads bytes from the file, starting at the current file pointer,
   until it reaches a line terminator or the end
   of the file.  Each byte is converted into a character by taking the
   byte's value for the lower eight bits of the character and setting the
   high eight bits of the character to zero.  This method does not,
   therefore, support the full Unicode character set.

    A line of text is terminated by a carriage-return character
   ('\\r'), a newline character ('\\n'), a
   carriage-return character immediately followed by a newline character,
   or the end of the file.  Line-terminating characters are discarded and
   are not included as part of the string returned.

    This method blocks until a newline character is read, a carriage
   return and the byte following it are read (to see if it is a newline),
   the end of the file is reached, or an exception is thrown.

  returns: the next line of text from this file, or null if end
               of file is encountered before even one byte is read. - `java.lang.String`

  throws: java.io.IOException - if an I/O error occurs."
  (^java.lang.String [^RandomAccessFile this]
    (-> this (.readLine))))

(defn read-unsigned-short
  "Reads an unsigned 16-bit number from this file. This method reads
   two bytes from the file, starting at the current file pointer.
   If the bytes read, in order, are
   b1 and b2, where
   0 <= b1, b2 <= 255,
   then the result is equal to:


       (b1 << 8) | b2

   This method blocks until the two bytes are read, the end of the
   stream is detected, or an exception is thrown.

  returns: the next two bytes of this file, interpreted as an unsigned
               16-bit integer. - `int`

  throws: java.io.EOFException - if this file reaches the end before reading two bytes."
  (^Integer [^RandomAccessFile this]
    (-> this (.readUnsignedShort))))

