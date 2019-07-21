(ns jdk.io.CharArrayWriter
  "This class implements a character buffer that can be used as an Writer.
  The buffer automatically grows when data is written to the stream.  The data
  can be retrieved using toCharArray() and toString().

  Note: Invoking close() on this class has no effect, and methods
  of this class can be called after the stream has closed
  without generating an IOException."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io CharArrayWriter]))

(defn ->char-array-writer
  "Constructor.

  Creates a new CharArrayWriter with the specified initial size.

  initial-size - an int specifying the initial buffer size. - `int`

  throws: java.lang.IllegalArgumentException - if initialSize is negative"
  (^CharArrayWriter [^Integer initial-size]
    (new CharArrayWriter initial-size))
  (^CharArrayWriter []
    (new CharArrayWriter )))

(defn flush
  "Flush the stream."
  ([^CharArrayWriter this]
    (-> this (.flush))))

(defn to-string
  "Converts input data to a string.

  returns: the string. - `java.lang.String`"
  (^java.lang.String [^CharArrayWriter this]
    (-> this (.toString))))

(defn reset
  "Resets the buffer so that you can use it again without
   throwing away the already allocated buffer."
  ([^CharArrayWriter this]
    (-> this (.reset))))

(defn to-char-array
  "Returns a copy of the input data.

  returns: an array of chars copied from the input data. - `char[]`"
  ([^CharArrayWriter this]
    (-> this (.toCharArray))))

(defn write-to
  "Writes the contents of the buffer to another character stream.

  out - the output stream to write to - `java.io.Writer`

  throws: java.io.IOException - If an I/O error occurs."
  ([^CharArrayWriter this ^java.io.Writer out]
    (-> this (.writeTo out))))

(defn close
  "Close the stream.  This method does not release the buffer, since its
   contents might still be required. Note: Invoking this method in this class
   will have no effect."
  ([^CharArrayWriter this]
    (-> this (.close))))

(defn append
  "Appends a subsequence of the specified character sequence to this writer.

    An invocation of this method of the form out.append(csq, start,
   end) when csq is not null, behaves in
   exactly the same way as the invocation



       out.write(csq.subSequence(start, end).toString())

  csq - The character sequence from which a subsequence will be appended. If csq is null, then characters will be appended as if csq contained the four characters \"null\". - `java.lang.CharSequence`
  start - The index of the first character in the subsequence - `int`
  end - The index of the character following the last character in the subsequence - `int`

  returns: This writer - `java.io.CharArrayWriter`

  throws: java.lang.IndexOutOfBoundsException - If start or end are negative, start is greater than end, or end is greater than csq.length()"
  (^java.io.CharArrayWriter [^CharArrayWriter this ^java.lang.CharSequence csq ^Integer start ^Integer end]
    (-> this (.append csq start end)))
  (^java.io.CharArrayWriter [^CharArrayWriter this ^java.lang.CharSequence csq]
    (-> this (.append csq))))

(defn size
  "Returns the current size of the buffer.

  returns: an int representing the current size of the buffer. - `int`"
  (^Integer [^CharArrayWriter this]
    (-> this (.size))))

(defn write
  "Writes characters to the buffer.

  c - the data to be written - `char[]`
  off - the start offset in the data - `int`
  len - the number of chars that are written - `int`"
  ([^CharArrayWriter this c ^Integer off ^Integer len]
    (-> this (.write c off len)))
  ([^CharArrayWriter this ^Integer c]
    (-> this (.write c))))

