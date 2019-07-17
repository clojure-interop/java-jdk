(ns jdk.io.Writer
  "Abstract class for writing to character streams.  The only methods that a
  subclass must implement are write(char[], int, int), flush(), and close().
  Most subclasses, however, will override some of the methods defined here in
  order to provide higher efficiency, additional functionality, or both."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io Writer]))

(defn write
  "Writes a portion of an array of characters.

  cbuf - Array of characters - `char[]`
  off - Offset from which to start writing characters - `int`
  len - Number of characters to write - `int`

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.Writer this cbuf ^Integer off ^Integer len]
    (-> this (.write cbuf off len)))
  ([^java.io.Writer this ^Integer c]
    (-> this (.write c))))

(defn append
  "Appends a subsequence of the specified character sequence to this writer.
   Appendable.

    An invocation of this method of the form out.append(csq, start,
   end) when csq is not null behaves in exactly the
   same way as the invocation



       out.write(csq.subSequence(start, end).toString())

  csq - The character sequence from which a subsequence will be appended. If csq is null, then characters will be appended as if csq contained the four characters `null`. - `java.lang.CharSequence`
  start - The index of the first character in the subsequence - `int`
  end - The index of the character following the last character in the subsequence - `int`

  returns: This writer - `java.io.Writer`

  throws: java.lang.IndexOutOfBoundsException - If start or end are negative, start is greater than end, or end is greater than csq.length()"
  (^java.io.Writer [^java.io.Writer this ^java.lang.CharSequence csq ^Integer start ^Integer end]
    (-> this (.append csq start end)))
  (^java.io.Writer [^java.io.Writer this ^java.lang.CharSequence csq]
    (-> this (.append csq))))

(defn flush
  "Flushes the stream.  If the stream has saved any characters from the
   various write() methods in a buffer, write them immediately to their
   intended destination.  Then, if that destination is another character or
   byte stream, flush it.  Thus one flush() invocation will flush all the
   buffers in a chain of Writers and OutputStreams.

    If the intended destination of this stream is an abstraction provided
   by the underlying operating system, for example a file, then flushing the
   stream guarantees only that bytes previously written to the stream are
   passed to the operating system for writing; it does not guarantee that
   they are actually written to a physical device such as a disk drive.

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.Writer this]
    (-> this (.flush))))

(defn close
  "Closes the stream, flushing it first. Once the stream has been closed,
   further write() or flush() invocations will cause an IOException to be
   thrown. Closing a previously closed stream has no effect.

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.Writer this]
    (-> this (.close))))

